import java.util.Scanner;

public class Main {

    private static String getBestString(String str1, String str2) {

        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) > str2.charAt(i)) {
                return str2;
            } else {
                if (str1.charAt(i) < str2.charAt(i)) {
                    return str1;
                }
            }
        }

        return str1;
    }

    private static String getPalindrome(String input) {

        boolean equal;
        String output;
        String rec1 = "";
        String rec2 = "";
        String rec3 = "";
        if (input.length() <= 1) {

            output = input;

        } else {

            if (input.charAt(0) == input.charAt(input.length() - 1)) {
                equal = true;
                rec1 = input.substring(0, 1)
                        + getPalindrome(input.substring(1, input.length() - 1))
                        + input.substring(input.length() - 1, input.length());

            } else {

                equal = false;
                rec2 = input.substring(0, 1)
                        + getPalindrome(input.substring(1, input.length()))
                        + input.substring(0, 1);

                rec3 = input.substring(input.length() - 1, input.length())
                        + getPalindrome(input.substring(0, input.length() - 1))
                        + input.substring(input.length() - 1, input.length());

            }

            if (equal) {
                output = rec1;
            } else {
                if (rec2.length() < rec3.length()) {
                    output = rec2;
                } else {
                    if (rec2.length() > rec3.length()) {
                        output = rec3;
                    } else {
                        output = getBestString(rec2, rec3);
                    }

                }
            }
        }

        return output;
    }

    public static void main(String[] args) {

        String input;
        String output;
        Scanner scanner = new Scanner(System.in);
        input = scanner.nextLine();

        output = getPalindrome(input);

        System.out.println(output);

    }
}
