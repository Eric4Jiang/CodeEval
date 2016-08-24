import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by eric on 8/23/16.
 */
public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new File(args[0]))) {
            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] sep = line.split(" ");

                String word = sep[0];
                String binaryCode = sep[1];

                String output = "";

                for(int i = 0; i < binaryCode.length(); i++) {
                    char c = binaryCode.charAt(i);
                    if(c == '1')
                        output += Character.toUpperCase(word.charAt(i));
                    else
                        output += word.charAt(i);
                }
                System.out.println(output);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
