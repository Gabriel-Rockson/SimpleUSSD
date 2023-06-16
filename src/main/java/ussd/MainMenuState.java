package ussd;

public class MainMenuState implements USSDState {
    protected USSD ussd;

    MainMenuState(USSD ussd) {
        this.ussd = ussd;
    }

    @Override
    public void displayOptions() {
        String[] options = new String[] {"airtime / data", "cash", "settings"};
        Prompt.showOptions(options);
    }

    @Override
    public void processInput(String userInput) {
        switch (userInput) {
            case "1" -> ussd.changeState(new AirtimeDataMenuState(ussd));
            case "2" -> ussd.changeState(new CashMenuState(ussd));
            case "3" -> ussd.changeState(new SettingsMenuState(ussd));
            default -> Prompt.invalidInput();
        }
    }
}
