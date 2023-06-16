package ussd;

public class EnterAmountState implements USSDState {
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

                    try {
                        amount = Float.parseFloat(ussd.takeInput("Enter " + "amount"));
                    }
                    catch (Exception ignored) {}

                } while (!Validation.validateAirtimeAmount(amount));


                ussd.changeState(new ConfirmAirtimePurchaseState(ussd, amount, recipientNumber));
            }
            default -> Prompt.invalidInput();
        }
    }
}
