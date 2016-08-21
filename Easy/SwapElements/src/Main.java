import java.io.File;
        import java.io.FileNotFoundException;
        import java.util.Scanner;

/**
 * Created by eric on 8/4/16.
 */
public class Main {

    public static String swapElements(String[] array, int[] pos) {
        for(int i = 0; i < pos.length; i+=2) {
            int a = pos[i];
            int b = pos[i + 1];

            String temp = array[a];
            array[a] = array[b];
            array[b] = temp;
        }

        String output = "";
        for(String x: array) {
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
                line = line.replace("-", " ");

                String[] colon = line.split(":");

                String left = colon[0];
                String[] numbers = left.split(" ");

                String right = colon[1];
                right = right.replace(",", "");
                right = right.trim();
                String[] numbers2 = right.split(" ");
                int[] pos = new int[numbers2.length];

                for(int i = 0; i < numbers2.length; i++) {
                    pos[i] = Integer.parseInt(numbers2[i]);
                }

                String swapped = swapElements(numbers, pos);

                System.out.println(swapped);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
