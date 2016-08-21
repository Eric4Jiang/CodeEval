import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by eric on 8/18/16.
 */
public class Main {

    public static String reverseGroups(String[] nums, int groupSize) {

        for(int i = 0; i < nums.length - groupSize + 1; i += groupSize) {
            int lastElementOfGroup = i + groupSize - 1;
            for(int j = 0; j < groupSize/2; j++) {
                //swap elements

                String temp = nums[i + j];
                nums[i + j] = nums[lastElementOfGroup - j];
                nums[lastElementOfGroup - j] = temp;
            }
        }

        String output = "";
        for(int  i = 0; i < nums.length; i++) {
            if(i == nums.length - 1)
                output += nums[i];
            else
                output += nums[i] + ",";
        }
        return output;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new File(args[0]))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] semiSeparated = line.split(";");

                int groupSize = Integer.parseInt(semiSeparated[1]);
                String[] commaSeparated = semiSeparated[0].split(",");

                String reversedGroups = reverseGroups(commaSeparated, groupSize);
                System.out.println(reversedGroups);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
