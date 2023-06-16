package ussd;

public final class Prompt {

    private Prompt() {
        throw new UnsupportedOperationException("Instances of Prompt class cannot be created.");
    }

    public static void showOptions(String[] options) {
        for (int i = 0; i < options.length; i++) {
            System.out.println(i + 1 + " - " + options[i]);
        }
    }

    public static void showOptions(String[] options, boolean withGoBack) {
        showOptions(options);
        if (withGoBack) {
            System.out.println("00 - go back");
        }
    }

    public static void showOptions(String promptMessage, String[] options) {
        System.out.println(promptMessage);
        showOptions(options);
    }

    public static void showOptions(String promptMessage, String[] options, boolean withGoBack) {
        System.out.println(promptMessage);
        showOptions(options, withGoBack);
    }

    public static void invalidInput() {
        System.err.println("Invalid entry, quitting application ...\n");
        System.exit(0);
    }

    public static void endOfApplication() {
        System.out.println("Feature coming soon");
        System.out.println("End of application process...\n");
        System.exit(1);
    }

}
