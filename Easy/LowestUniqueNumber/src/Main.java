import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by eric on 8/14/16.
 */
public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new File(args[0]))) {
            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] num = line.split(" ");
                int[] hashtable = new int[10];
                int lowest = 10;
                int lowestPos = 0;

                //store occurences in hashtable
                for(int i = 0; i < num.length; i++)
                    hashtable[Integer.parseInt(num[i])]++;

                //find smallest number with 1 occurence
                for(int i = 0; i < num.length; i++) {

                    int num_at_i = Integer.parseInt(num[i]);
                    int occurences = hashtable[num_at_i];

                    if(occurences == 1 && num_at_i < lowest) {
                        lowestPos = i + 1; //make it into scale that starts at 1 instead of 0
                        lowest =  num_at_i;
                    }

                }
                System.out.println(lowestPos);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
