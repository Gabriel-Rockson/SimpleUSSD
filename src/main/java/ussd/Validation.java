package ussd;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Validation {

    private Validation() {
        throw new UnsupportedOperationException("Instances of Validation class cannot be created");
    }

    public static boolean validateAirtimeAmount(float amount) {
        String regex = "^[+-]?\\d*\\.?\\d+$";
        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(String.valueOf(amount));

        return amount > 0 && matcher.matches();
    }

    public static boolean validateRecipientPhoneNumber(String phoneNumber) {
        String regex = "^0\\d{9}$";
        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(phoneNumber);

        return matcher.matches();
    }

}
