import jdk.nashorn.internal.objects.NativeUint8Array;

import java.util.*;
import java.io.*;

public class Main {
    public static boolean isInteger(String s) {
        return isInteger(s,10);
    }

    public static boolean isInteger(String s, int radix) {
        if(s.isEmpty()) return false;
        for(int i = 0; i < s.length(); i++) {
            if(i == 0 && s.charAt(i) == '-') {
                if(s.length() == 1) return false;
                else continue;
            }
            if(Character.digit(s.charAt(i),radix) < 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new File(args[0]))) {
            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();
//                System.out.println("input =" +  line);
                String[] sep = line.split(",");

                ArrayList<String> nums = new ArrayList<>();
                ArrayList<String> words = new ArrayList<>();

                for(int i = 0; i < sep.length; i++) {
                    if(isInteger(sep[i]))
                        nums.add(sep[i]);
                    else
                        words.add(sep[i]);
                }

                //print out words and nums
                for(String x : words) {
                    if(x != words.get(words.size() - 1))
                        System.out.print(x + ",");
                    else
                        System.out.print(x);
                }

                if(words.size() != 0 && nums.size() != 0)
                    System.out.print("|");

                for(String x : nums) {
                    if (x != nums.get(nums.size() - 1))
                        System.out.print(x + ",");
                    else
                        System.out.print(x);
                }
                System.out.println();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
