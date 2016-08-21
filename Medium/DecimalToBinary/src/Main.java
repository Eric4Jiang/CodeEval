import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by eric on 7/23/16.
 */
public class Main {

    public static String toBinary(int n) {
        if (n == 0) {
            return "0";
        }
        String binary = "";
        while (n > 0) {
            int rem = n % 2;
            binary = rem + binary;
            n = n / 2;
        }
        return binary;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new File(args[0]))) {
                while(scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(toBinary(Integer.parseInt(line)));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}