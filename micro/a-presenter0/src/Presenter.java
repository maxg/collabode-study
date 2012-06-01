public class Presenter {
    /** Return strings of the form "Super", "Awesome Sauce" */
    public static String titleize(String lower) {
        return lower.substring(0, 1).toUpperCase() + lower.substring(1);
    }

    /** Return strings of the form "cows", "people", "sheep" */
    public static String pluralize(String singular) {
        if (singular.endsWith("o")) {
            return singular + "es";
        }
        if (singular.endsWith("is")) {
            return singular.replaceFirst("is$", "es");
        }
        if (singular.endsWith("s")) {
            return singular + "es";
        }
        if (singular.endsWith("y")) {
            return singular.replaceFirst("y$", "ies");
        }
        if (singular.endsWith("ex")) {
            return singular.replaceFirst("ex$", "ices");
        }
        if (singular.endsWith("ix")) {
            return singular.replaceFirst("ix$", "ices");
        }
        return singular + "s";
    }

    /** Return strings of the form "7 Cows" or "1 Duck" */
    public String format(int count, String thing) {
        return count + " " + titleize(pluralize(thing));
    }
}
