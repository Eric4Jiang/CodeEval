import java.io.*;
import java.util.*;
import javax.script.ScriptException;


public class Main {

    static int uglyNumbers;

    //function found on stackoverflow not mine
    public static double eval(final String str) {
        return new Object() {
            int pos = -1, ch;

            void nextChar() {
                ch = (++pos < str.length()) ? str.charAt(pos) : -1;
            }

            boolean eat(int charToEat) {
                while (ch == ' ') nextChar();
                if (ch == charToEat) {
                    nextChar();
                    return true;
                }
                return false;
            }

            double parse() {
                nextChar();
                double x = parseExpression();
                if (pos < str.length()) throw new RuntimeException("Unexpected: " + (char)ch);
                return x;
            }

            // Grammar:
            // expression = term | expression `+` term | expression `-` term
            // term = factor | term `*` factor | term `/` factor
            // factor = `+` factor | `-` factor | `(` expression `)`
            //        | number | functionName factor | factor `^` factor

            double parseExpression() {
                double x = parseTerm();
                for (;;) {
                    if      (eat('+')) x += parseTerm(); // addition
                    else if (eat('-')) x -= parseTerm(); // subtraction
                    else return x;
                }
            }

            double parseTerm() {
                double x = parseFactor();
                for (;;) {
                    if      (eat('*')) x *= parseFactor(); // multiplication
                    else if (eat('/')) x /= parseFactor(); // division
                    else return x;
                }
            }

            double parseFactor() {
                if (eat('+')) return parseFactor(); // unary plus
                if (eat('-')) return -parseFactor(); // unary minus

                double x;
                int startPos = this.pos;
                if (eat('(')) { // parentheses
                    x = parseExpression();
                    eat(')');
                } else if ((ch >= '0' && ch <= '9') || ch == '.') { // numbers
                    while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
                    x = Double.parseDouble(str.substring(startPos, this.pos));
                } else if (ch >= 'a' && ch <= 'z') { // functions
                    while (ch >= 'a' && ch <= 'z') nextChar();
                    String func = str.substring(startPos, this.pos);
                    x = parseFactor();
                    if (func.equals("sqrt")) x = Math.sqrt(x);
                    else if (func.equals("sin")) x = Math.sin(Math.toRadians(x));
                    else if (func.equals("cos")) x = Math.cos(Math.toRadians(x));
                    else if (func.equals("tan")) x = Math.tan(Math.toRadians(x));
                    else throw new RuntimeException("Unknown function: " + func);
                } else {
                    throw new RuntimeException("Unexpected: " + (char)ch);
                }

                if (eat('^')) x = Math.pow(x, parseFactor()); // exponentiation

                return x;
            }
        }.parse();
    }

    public static boolean isUgly(long num) {
        return (num % 2 == 0 || num % 3 == 0 || num % 5 == 0 || num % 7 == 0);
    }

    public static long parseStringToExpression(String stringExpression) {
        return (long) eval(stringExpression);
    }

    //use string to deal with 0s
    public static void findUglyExpressions(String num, int startingPos, int  numOfDigitsLeft) {

        //reached end of number
        if(numOfDigitsLeft == 1)
            return;

        String beforeOp = num.substring(0, startingPos);
        String afterOp = num.substring(startingPos);

        //append + in between num[i] and num[i+1]
        String add = beforeOp + "+" + afterOp;
        if(isUgly(parseStringToExpression(add)))
            uglyNumbers++;
        findUglyExpressions(add, startingPos + 2, numOfDigitsLeft - 1); // +2 to deal with "+" added in

        //append - in between
        String subtract = beforeOp + "-" + afterOp;
        if(isUgly(parseStringToExpression(subtract)))
            uglyNumbers++;
        findUglyExpressions(subtract, startingPos + 2, numOfDigitsLeft - 1);

        //don't do any operations in between
        findUglyExpressions(num, startingPos + 1, numOfDigitsLeft - 1);

        numOfDigitsLeft--;
    }

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(new File(args[0]))) {
            while(scanner.hasNextLine()) {
                String num = scanner.nextLine();
                uglyNumbers = 0;

                if(isUgly(Long.parseLong(num)))
                    uglyNumbers++;

                findUglyExpressions(num, 1, num.trim().length());
                System.out.println(uglyNumbers);
            }
        } catch (FileNotFoundException e) { // if file not found
            e.printStackTrace();
        }
    }
}
