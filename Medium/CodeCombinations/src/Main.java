import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by eric on 8/19/16.
 */
public class Main {

    public static int checkMatrixForCode(char[][] matrix) {
        int count = 0;
        int[] code = new int[4];

        //check every element in matrix
        for(int i = 0; i < matrix.length - 1; i++) {
            for(int j = 0; j < matrix[0].length - 1; j++) {

                char c = matrix[i][j];
                //if element contains a letter of code
                if(c == 'c' || c == 'o' || c == 'd' || c == 'e') {
                    //perform 2x2 search for code
                    for(int k = 0; k < 2; k++) {
                        for(int l = 0; l < 2; l++) {
                            //record letter occurence
                            switch(matrix[i + k][j + l]) {
                                case 'c':
                                    code[0]++;
                                    break;
                                case 'o':
                                    code[1]++;
                                    break;
                                case 'd':
                                    code[2]++;
                                    break;
                                case 'e':
                                    code[3]++;
                                    break;
                            }
                        }
                    }
                    //check if code was found
                    if(code[0] == 1 && code[1] == 1 && code[2] == 1 && code[3] == 1)
                        count++;
                    code[0] = 0; code[1] = 0; code[2] = 0; code[3] = 0; //reset code for next search
                }

            }
        }

        return count;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new File(args[0]))) {
            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] rows = line.split("\\|");
                char[][] matrix = new char[rows.length][rows[0].trim().length()];

                for(int i = 0; i < rows.length; i++) {
                    String row = rows[i].trim();
                    for(int j = 0; j < row.length(); j++)
                        matrix[i][j] = row.charAt(j);
                }

                System.out.println(checkMatrixForCode(matrix));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
