package ussd;

public class EnterAmountState implements USSDState, InputValidation {
    USSD ussd;
    String recipientNumber = null;

    public EnterAmountState(USSD ussd) {
        this.ussd = ussd;
    }

    public EnterAmountState(USSD ussd, String recipientNumber) {
        this.ussd = ussd;
        this.recipientNumber = recipientNumber;
    }

    @Override
    public void displayOptions() {
        String[] options = new String[] {"Enter the amount to buy"};
        Prompt.showOptions(options, true);
    }

    @Override
    public void processInput(String userInput) {
        switch (userInput) {
            case "00" -> ussd.changeState(new BuyAirtimeMenuState(ussd));
            case "1" -> {
                float amount = 0;

                do {
                    // TODO: display 'Invalid Input' to the user if the amount
                    // is not valid before you proceed

                    amount = Float.parseFloat(ussd.takeInput("Enter amount"));

                } while (!validateInput(String.valueOf(amount)));


                ussd.changeState(new ConfirmAirtimePurchaseState(ussd, amount, recipientNumber));
            }
            default -> Prompt.invalidInput();
        }
    }

    @Override
    public boolean validateInput(String input) {
        return Float.parseFloat(input) > 0;
    }
}
