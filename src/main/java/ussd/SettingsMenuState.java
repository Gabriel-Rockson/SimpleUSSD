package ussd;

public class SettingsMenuState implements USSDState {
    USSD ussd;

    SettingsMenuState(USSD ussd) {
        this.ussd = ussd;
    }

    @Override
    public void displayOptions() {
        String[] options = {"change name", "change password"};
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
