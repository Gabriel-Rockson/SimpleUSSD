package ussd;

public class ConfirmAirtimePurchaseState implements USSDState {
    USSD ussd;
    float amount;
    String recipientNumber = null;

    public ConfirmAirtimePurchaseState(USSD ussd, float amount) {
        this.ussd = ussd;
        this.amount = amount;
    }

    public ConfirmAirtimePurchaseState(USSD ussd, float amount, String recipientNumber) {
        this.ussd = ussd;
        this.amount = amount;
        this.recipientNumber = recipientNumber;
    }

    @Override
    public void displayOptions() {
        String[] options = {"Yes", "Cancel (quit)"};
        Prompt.showOptions("Are you sure you want to buy?", options, true);
    }

    @Override
    public void processInput(String userInput) {
        switch (userInput) {
            case "00" -> ussd.changeState(new EnterAmountState(ussd));
            case "1" -> {
                if (recipientNumber != null) {
                    System.out.printf("Congrats! You just purchased %.2f worth of airtime for %s", amount, recipientNumber);
                } else {
                    System.out.printf("Congrats! You just purchased %.2f worth of airtime", amount);
                }

                System.exit(1);
            }
            case "2" -> {
                System.out.println("Sad you decided not to purchase anymore !!!");
                System.exit(0);
            }
            default -> Prompt.invalidInput();
        }
    }
}
