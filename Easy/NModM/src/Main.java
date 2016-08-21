import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by eric on 7/30/16.
 */
public class Main {

    public static int mod(int n, int m) {
        int quotient = n / m;

        int mod = n - (quotient * m);
        return mod;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new File(args[0]))) {
            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] nums = line.split(",");
                int n = Integer.parseInt(nums[0]);
                int m = Integer.parseInt(nums[1]);

                System.out.println(mod(n, m));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
