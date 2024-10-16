package lotto.view;

public class OutputWriter {
    public static void displayMessage(String message) {
        System.out.println(message);
    } // displayMessage

    public static void displayMessageByFormat(String format, String message) {
        System.out.printf(format, message);
    } // displayMessageByFormat

    public static void displayNewLine() {
        System.out.println("");
    } // displayNewLine
} // class