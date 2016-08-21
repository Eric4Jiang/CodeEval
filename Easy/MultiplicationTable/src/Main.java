/**
 * Created by eric on 7/22/16.
 */
public class Main {

    public static void main(String[] args) {

        int[][] multiplicationTable = new int[12][12];

        for(int i = 1; i <= 12; i++) {
            for(int j = 1; j <= 12; j++) {
                int num = i * j;
                int placeValue = (int)Math.floor(Math.log10(num)) + 1;

                //not first column
                if(j != 1) {
                    for (int k = placeValue; k < 4; k++)
                        System.out.print(" ");
                }
                else if(placeValue == 1)
                    System.out.print(" ");
                multiplicationTable[i - 1][j - 1] = num;
                System.out.print(i*j);

            }
            System.out.print("\n");
        }

    }
}
