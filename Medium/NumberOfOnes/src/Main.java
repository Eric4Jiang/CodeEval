import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by eric on 7/23/16.
 */
public class Main {

    public static int find1s(int num) {

        int base = 2;
        int count = 0;
        String binary = "";
        while(num != 0) {
            if(num % base == 1) {
                count++;
                binary = "1" + binary;
            }
            else
                binary = "0" + binary;
            num = num/2;
        }
        return count;
    }
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new File(args[0]))) {
            while(scanner.hasNextInt()) {
                int num = scanner.nextInt();
                int numOf1s = find1s(num);
                System.out.println(numOf1s);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
