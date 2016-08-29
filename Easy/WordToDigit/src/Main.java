import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by yao on 8/24/2016.
 */
public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new File(args[0]))) {
            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] words = line.split(";");
                for(String word : words) {
                    switch(word) {
                        case "zero":
                            System.out.print(0);
                            break;
                        case "one":
                            System.out.print(1);
                            break;
                        case "two":
                            System.out.print(2);
                            break;
                        case "three":
                            System.out.print(3);
                            break;
                        case "four":
                            System.out.print(4);
                            break;
                        case "five":
                            System.out.print(5);
                            break;
                        case "six":
                            System.out.print(6);
                            break;
                        case "seven":
                            System.out.print(7);
                            break;
                        case "eight":
                            System.out.print(8);
                            break;
                        case "nine":
                            System.out.print(9);
                            break;
                    }
                }
                System.out.println();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
