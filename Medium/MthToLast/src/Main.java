import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by eric on 7/23/16.
 */
public class Main {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new File(args[0]))) {
            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] split = line.split(" ");
                int index = Integer.parseInt(split[split.length - 1]);

                if(index > split.length - 1)
                    System.out.print("\n");
                else {
                    System.out.println(split[split.length - index - 1]);
                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


}
