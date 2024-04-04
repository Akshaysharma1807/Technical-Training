package TechnicalTrain;
import java.util.Scanner;

public class Exp_7 {
    public static long repeatedString(String s, long n) {
        long count_a = 0;

        for (char ch : s.toCharArray()) {
            if (ch == 'a')
                count_a++;
        }

        long repeat_count = n / s.length();
        long remaining_chars = n % s.length();

        count_a *= repeat_count;

        for (int i = 0; i < remaining_chars; i++) {
            if (s.charAt(i) == 'a')
                count_a++;
        }

        return count_a;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the string to repeat: ");
        String s = scanner.next();

        System.out.print("Enter the number of characters to consider: ");
        long n = scanner.nextLong();

        long result = repeatedString(s, n);
        System.out.println("Frequency of 'a' in the substring: " + result);

        scanner.close();
    }
}