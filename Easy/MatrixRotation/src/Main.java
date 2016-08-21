import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by eric on 8/18/16.
 */
public class Main {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new File(args[0]))) {
            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] letters = line.split(" ");
                int d = (int)Math.sqrt(letters.length);

                String[][] matrix = new String[d][d];
                String[][] rotated = new String[d][d];

                int k = 0;

                for(int i = 0; i < d; i++) {
                    for(int j = 0; j < d; j++) {
                        matrix[i][j] = letters[k];
                        k++;
                    }
                }

                int xPos = 0, yPos = 0;

                //rotate it
                for(int j = 0; j < d; j++) {
                    xPos = 0;
                    for(int i = d - 1; i >= 0; i--) {
                        rotated[yPos][xPos] = matrix[i][j];
                        System.out.print(matrix[i][j] + " ");
                        xPos++;
                    }
                    yPos++;
                }

                System.out.print("\n");

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
