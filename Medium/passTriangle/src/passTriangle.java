import java.io.*;
import java.util.*;

public class passTriangle {

    public static int[][] triNum = new int[2000][2000];
    public static int[][] sums = new int[2000][2000];

    public static int i = 0;

    public static int tri(int[][] nums, int row, int col) {
        //if only one number
        if (nums.length == 1)
            return nums[0][0];

        //if next row doesn't exist
        if (row + 1 > i)
            return nums[row][col];

        //if already calculated
        if(sums[row][col] != 0)
            return sums[row][col];

        //recursively transverse
        //current total + max sum of left int
        int maxLeftSum = nums[row][col] + tri(nums, row + 1, col); //left num on same col as num

        int maxRightSum = nums[row][col] + tri(nums,  row + 1, col + 1); //right num is one down one to the right

        //find the larger sum and store it
        sums[row][col] = (maxLeftSum >= maxRightSum) ? maxLeftSum : maxRightSum;

        return sums[row][col];
    }

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(new File(args[0]))) {
            //read in all numbers in input
            while(scanner.hasNextInt()) {
                for(int j = 0; j <= i; j++) {
                    int num = scanner.nextInt();
                    triNum[i][j] = num;
                }
                i++;
            }

            int maxSum = tri(triNum, 0, 0);

            System.out.println(maxSum);
            //System.out.println(Arrays.deepToString(triNum));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
