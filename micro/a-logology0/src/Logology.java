import java.util.*;

public class Logology {
    
    // Same letters backwards & forwards
    public static boolean palindrome(String s) {
        char[] cs = s.toLowerCase().replaceAll("[!?,. ]", "").toCharArray();
        List<Character> l = new ArrayList<Character>();
        for (char c : cs) {
            l.add(c);
        }
        ListIterator<Character> f = l.listIterator();
        ListIterator<Character> b = l.listIterator(l.size()-1);
        while (f.hasNext() || b.hasPrevious()) {
            if (f.next() != b.previous()) {
                return false;
            }
        }
        return true;
    }
    
    // Same letters horizontally & vertically:
    //   CARD
    //   AREA
    //   REAR
    //   DART
    public static boolean wordSquare(String[] s) {
        throw new Error("Unimplemented");
    }
    
    public static void main(String[] args) {
        String s = "Hello";
        System.out.println(s + ": " + palindrome(s)); // false
        
        String t = "Kayak";
        System.out.println(t + ": " + palindrome(t)); // true
        
        String u = "Sator Arepo Tenet Opera Rotas";
        System.out.println(u + ": " + palindrome(u)); // true
        
        String v = "Eva, can I stab bats in a cave?";
        System.out.println(v + ": " + palindrome(v)); // true
    }
}
