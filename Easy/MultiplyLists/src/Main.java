import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by eric on 9/3/16.
 */
public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new File(args[0]))){
            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] sep = line.split(" \\| ");
                String[] num1 = sep[0].split(" ");
                String[] num2 = sep[1].split(" ");

                for(int i = 0; i < num1.length; i++) {
                    System.out.print(Integer.parseInt(num1[i]) * Integer.parseInt(num2[i]) + " ");
                }
                System.out.println();
            }

        }  catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
