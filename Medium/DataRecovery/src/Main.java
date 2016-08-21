import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by eric on 8/4/16.
 */
public class Main {

    public static String getOriginal(String[] words, String nums[]) {

        String[] original = new String[words.length];
        String output = "";
        for(int i = 0; i < nums.length; i++)
            original[Integer.parseInt(nums[i]) - 1] = words[i];

        //puts last word into sentence
        for(int i = 0; i < original.length; i++) {
            if(original[i] == null) {
                original[i] = words[words.length - 1];
                break;
            }
        }

        for(String x:original) {
            output += x + " ";
        }
        output.trim();

        return output;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new File(args[0]))) {
            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();
                line.trim();
                String[] SemiColon = line.split(";");
                String sentence = SemiColon[0];
                //will be missing the last number
                String numbers = SemiColon[1];

                String[] words = sentence.split(" ");
                String[] nums = numbers.split(" ");

                String original = getOriginal(words, nums);
                System.out.println(original);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
