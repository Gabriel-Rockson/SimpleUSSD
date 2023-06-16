package ussd;

public class BuyAirtimeMenuState implements USSDState {
    USSD ussd;
    public BuyAirtimeMenuState(USSD ussd) {
        this.ussd = ussd;
    }

    @Override
    public void displayOptions() {
        String[] options = new String[] {"buy airtime for yourself", "buy airtime for someone"};
        Prompt.showOptions(options, true);
    }

    @Override
    public void processInput(String userInput) {
        switch (userInput) {
            case "00" -> ussd.changeState(new AirtimeDataMenuState(ussd));
            case "1" -> ussd.changeState(new EnterAmountState(ussd));
            case "2" -> ussd.changeState(new EnterRecipientNumberState(ussd));
            default -> Prompt.invalidInput();
        }
    }
}
