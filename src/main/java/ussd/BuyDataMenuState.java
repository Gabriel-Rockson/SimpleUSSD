package ussd;

public class BuyDataMenuState implements USSDState {
    USSD ussd;

    public BuyDataMenuState(USSD ussd) {
        this.ussd = ussd;
    }


    @Override
    public void displayOptions() {
        String[] options = new String[] {"buy data for yourself", "buy data for someone"};
        Prompt.showOptions(options, true);
    }

    @Override
    public void processInput(String userInput) {
        switch (userInput) {
            case "00" -> ussd.changeState(new MainMenuState(ussd));
            case "1", "2" -> Prompt.endOfApplication();
            default -> Prompt.invalidInput();

        }
    }
}
