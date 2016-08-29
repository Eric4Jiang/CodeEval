import java.io.File;
import java.io.FileNotFoundException;
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

                if(line.length() <= 55)
                    System.out.println(line);
                else if(line.length() > 55){
                    output = line.substring(0, 40);
                    int pos = 0;
                    //trim to last space
                    for(int i = output.length() - 1; i >=0; i--) {
                        if(output.charAt(i) == ' ') {
                            pos = i;
                            break;
                        }
                    }
                    if(!(pos == 0))
                        output = output.substring(0, pos);
                    output += "... <Read More>";
                    System.out.println(output);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
