package ussd;

public class AirtimeDataMenuState implements USSDState{
    protected USSD ussd;

    AirtimeDataMenuState(USSD ussd) {
        this.ussd = ussd;
    }

    @Override
    public void displayOptions() {
        String[] options = new String[] {"airtime", "data"};
        Prompt.showOptions(options, true);
    }

    @Override
    public void processInput(String userInput) {
        switch (userInput) {
            case "00" -> ussd.changeState(new MainMenuState(ussd));
            case "1" -> ussd.changeState(new BuyAirtimeMenuState(ussd));
            case "2" -> ussd.changeState(new BuyDataMenuState(ussd));
            default -> Prompt.invalidInput();
        }
    }

}
