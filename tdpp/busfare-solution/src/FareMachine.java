import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FareMachine {
    
    private final static String MONEY = "(\\d*(\\.\\d\\d)?)";
    private final static Pattern CASH = Pattern.compile("cash " + MONEY);
    private final static Pattern BALANCE = Pattern.compile("balance (\\w+) " + MONEY);
    private final static Pattern CARD = Pattern.compile("card (\\w+)");
    
    private final static String BALANCE_FMT = "balance %s %.2f\n";
    private final static String PAID = "paid";
    private final static String INSUFFICIENT = "insufficient";
    private final static String ERROR = "error";
    
    private final BufferedReader in;
    private final PrintWriter out;
    
    private boolean adding = false;
    private String addTo = null;
    private final Map<String, Integer> balances = new HashMap<String, Integer>();
    
    public FareMachine(Reader in, Writer out) {
        this.in = new BufferedReader(in);
        this.out = new PrintWriter(out, true);
    }
    
    public void process() throws IOException {
        String line;
        while ((line = in.readLine()) != null) {
            if (line.isEmpty() || line.startsWith("#")) {
                continue;
            }
            
            Matcher m;
            m = CASH.matcher(line);
            if (m.matches()) {
                cash(Double.parseDouble(m.group(1)));
                continue;
            }
            
            m = BALANCE.matcher(line);
            if (m.matches()) {
                balance(m.group(1), Double.parseDouble(m.group(2)));
                continue;
            }
            
            m = CARD.matcher(line);
            if (m.matches()) {
                card(m.group(1));
                continue;
            }
            
            if (line.equals("add")) {
                add();
                continue;
            }
            
            out.println(ERROR + " on " + line);
        }
    }
    
    private void add() {
        adding = true;
        addTo = null;
    }
    
    private void cash(double amt) {
        int cents = (int)(amt*100);
        if (adding) {
            if (addTo == null) {
                out.println(ERROR);
            } else {
                balances.put(addTo, balances.get(addTo) + cents);
            }
        } else {
            if (cents >= 100) {
                out.println(PAID);
            } else {
                out.println(INSUFFICIENT);
            }
        }
    }
    
    private void balance(String id, double amt) {
        balances.put(id, (int)(amt*100));
    }
    
    private void card(String id) {
        if (adding) {
            if (addTo == null) {
                addTo = id;
                out.format(BALANCE_FMT, id, balances.get(id)/100.);
            } else {
                adding = false;
                addTo = null;
                out.format(BALANCE_FMT, id, balances.get(id)/100.);
            }
        } else {
            if (balances.containsKey(id) && balances.get(id) >= 75) {
                balances.put(id, balances.get(id) - 75);
                out.format(BALANCE_FMT, id, balances.get(id)/100.);
                out.println(PAID);
            } else {
                out.format(BALANCE_FMT, id, balances.get(id)/100.);
                out.println(INSUFFICIENT);
            }
        }
    }
}
