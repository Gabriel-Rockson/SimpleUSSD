package ussd;

public class USSDApplication {

    public static void main(String[] args) {
        USSD ussd = new USSD();

        String ussdCode = ussd.takeInput("Enter USSD code");

        if (ussdCode.strip().equals("*455#")) {
            do {
                ussd.displayOptions();

                String optionNumber = ussd.takeInput("Enter option number");

                ussd.processInput(optionNumber.strip());

            } while (ussd.getState() != null);
        } else System.err.println("You entered the wrong USSD code, try again.");
    }
}
