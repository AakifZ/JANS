package helper;

public class passwordHelper {
    public static void main(String[] args) {
        String str = "Hello";
        System.out.println(validPassword(str));

    }

    public static boolean validPassword(String password) {
        if(password.length() < 8 || !hasLowerCase(password) || !hasUpperCase(password) || !hasNumber(password)) {
            return false;
        }
        return true;
    }

    private static boolean hasNumber(String str) {
        for (int i = 0; i < str.length(); i++) {
            if(Character.isDigit(str.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    private static boolean hasLowerCase(String str) {
        for (int i = 0; i < str.length(); i++) {
            if(Character.isLowerCase(str.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    private static boolean hasUpperCase(String str) {
        for (int i = 0; i < str.length(); i++) {
            if(Character.isUpperCase(str.charAt(i))) {
                return true;
            }
        }
        return false;
    }
}
