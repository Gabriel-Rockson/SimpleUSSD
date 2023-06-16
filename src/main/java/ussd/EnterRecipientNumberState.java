package ussd;

public class EnterRecipientNumberState implements USSDState, InputValidation {
    USSD ussd;

    public EnterRecipientNumberState(USSD ussd) {
        this.ussd = ussd;
    }

    @Override
    public void displayOptions() {
        String[] options = new String[] {"Enter the recipient number"};
        Prompt.showOptions(options, true);
    }

    @Override
    public void processInput(String userInput) {
        switch (userInput) {
            case "00" -> ussd.changeState(new BuyAirtimeMenuState(ussd));
            case "1" -> {
                // TODO: display 'Invalid phone number' to the user if the
                // amount is not valid before you proceed
                String recipientNumber;

                do {
                    recipientNumber = ussd.takeInput("Enter recipient's number");
                } while (!validateInput(recipientNumber));

                ussd.changeState(new EnterAmountState(ussd, recipientNumber));
            }
            default -> Prompt.invalidInput();
        }
    }

    @Override
    public boolean validateInput(String input) {
        return input.length() == 10;
    }
}
