import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by eric on 8/30/16.
 */
public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new File(args[0]))) {
            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] sep = line.split(" ");

                String num = sep[0];
                String letters = sep[1];
                int expression = 0;

                for(int i = 0; i < num.length(); i++) {
                    if(letters.charAt(i) == '+') {
                        expression =  Integer.parseInt(num.substring(0, i)) + Integer.parseInt(num.substring(i));
                        break;
                    } else if(letters.charAt(i) == '-') {
                        expression =  Integer.parseInt(num.substring(0, i)) - Integer.parseInt(num.substring(i));
                        break;
                    }
                }

                System.out.println(expression);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
