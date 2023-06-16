package ussd;

import java.util.Scanner;

public class USSD {
    private USSDState state;

    USSD() {
        this.state = new MainMenuState(this);
    }

    public void changeState(USSDState state) {
        this.state = state;
    }

    public void displayOptions() {
        this.state.displayOptions();
    }

    public void processInput(String userInput) {
        this.state.processInput(userInput);
    }

    public String takeInput(String promptMessage) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(promptMessage + ": ");

        return scanner.next();
    }

    public USSDState getState() {
        return state;
    }
}
