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
                String output = "";
                boolean upper = true;

                for(int i = 0; i < line.length(); i++) {
                    char c = line.charAt(i);
                    if(Character.isLetter(c)) {
                        if(upper)
                            output += Character.toUpperCase(c);
                        else
                            output += c;
                        upper = !upper;
                    }
                    else
                        output += c;
                }
                System.out.println(output);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
