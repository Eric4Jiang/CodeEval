import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by yao on 8/15/2016.
 */
public class Main {

    static int iterations = 0;

    public static boolean isPalidrome(long num) {
        long reverse = findReverse(num);

        return (num == reverse) ? true : false;
    }

    public static long findReverse(long num) {
        long palidrome = num;
        long reverse = 0;

        while(palidrome != 0) {
            long remainder = palidrome % 10;
            reverse = reverse * 10 + remainder;
            palidrome = palidrome / 10;
        }

        return reverse;
    }

    public static long addReverseUntilYouReachPalidrome(int num) {
        long total = num;
        iterations = 0;

        while(!isPalidrome(total)) {
            long reverse = findReverse(total);
            total += reverse;
            iterations++;
        }
        return total;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new File(args[0]))) {
            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();
                int num = Integer.parseInt(line);

                long palidrome = addReverseUntilYouReachPalidrome(num);
                System.out.println(iterations + " " + palidrome);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
