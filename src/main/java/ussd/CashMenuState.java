package ussd;

public class CashMenuState implements USSDState {
    protected  USSD ussd;

    CashMenuState(USSD ussd) {
        this.ussd = ussd;
    }

     @Override
    public void displayOptions() {
         String[] options = new String[] {"make payment", "receive funds", "view transfers"};
         Prompt.showOptions(options, true);
    }

    @Override
    public void processInput(String userInput) {
        switch (userInput) {
            case "00" -> ussd.changeState(new MainMenuState(ussd));
            default -> Prompt.endOfApplication();
        }
    }
}
