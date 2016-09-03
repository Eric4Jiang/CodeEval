import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new File(args[0]))) {
            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] sep = line.split(" ");

                int n = Integer.parseInt(sep[0]); // number of doors
                int m = Integer.parseInt(sep[1]); // number of iterations
                int opened = 0;

                boolean[] locked = new boolean[n];

                for(int i = 1; i < m; i++) { // for every iteration
                    // open/close doors
                    for(int j = 1; j <= n; j++) {
                        if(j % 2 == 0) {
                            locked[j - 1] = true;
                        }
                        if(j % 3 == 0) {
                            locked[j - 1] = !locked[j - 1];
                        }
                    }
                }

                //last iteration
                locked[n - 1] = !locked[n - 1];

                for(int i = 0; i < n; i++) {
                    if(!locked[i])
                        opened++;
                }
                System.out.println(opened);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
