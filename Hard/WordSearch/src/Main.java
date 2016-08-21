import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class node {
    private String value;
    private boolean transversed = false;

    node(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setTransversed(boolean transversed) {
        this.transversed = transversed;
    }

    public boolean wasTransversed() {
        return transversed;
    }
}

class crossword {

    crossword() {}

    public node[][] makeCrossword() {
        node[][] Board = {{new node("A"), new node("B"), new node("C"), new node("E")},
                {new node("S"), new node("F"), new node("C"), new node("S")},
                {new node("A"), new node("D"), new node("E"), new node("E")}};
        return Board;
    }
}


public class Main {

    static node[][] Board;
    static String line = "";

    //Checks all possible routes for a string in the crossword starting from a point
    public static boolean wordExists(int lineIndex, int width, int height) {
        //successfully found line in wordSearch
        if(lineIndex > line.length() - 1)
            return true;
        //outside of crossword
        if(width > Board[0].length - 1 || width < 0 || height > Board.length - 1 || height < 0)
            return false;
        //no repeats
        if(Board[height][width].wasTransversed())
            return false;

        String s = Character.toString(line.charAt(lineIndex));
        //if letter at (x,y) in crossword == current char of line
        if(Board[height][width].getValue().equals(s)) {

            Board[height][width].setTransversed(true);

            //recursively go into adjacent letters

            boolean up = false, down = false, right = false, left = false;

            up = wordExists(lineIndex + 1, width, height + 1);
            down = wordExists(lineIndex + 1, width, height - 1);
            left = wordExists(lineIndex + 1, width + 1, height);
            right = wordExists(lineIndex + 1, width - 1, height);

            boolean foundNextLetter = up || down || right || left;

            //if route fails reset transversed
            if(!foundNextLetter)
                Board[height][width].setTransversed(false);

            return foundNextLetter;
        }
        else
            return false;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new File(args[0]))) {
            while(scanner.hasNextLine()) {
                crossword CrossWord = new crossword();
                Board = CrossWord.makeCrossword();

                line = scanner.nextLine();
                boolean wordExists = false;

                //check all routes for all points
                for(int i = 0; i < Board.length; i++) {
                    for(int j = 0; j < Board[i].length; j++) {
                        if(wordExists(0, j, i)) {
                            wordExists = true;
                            break;
                        }
                    }
                }
                if(wordExists)
                    System.out.println("True");
                else
                    System.out.println("False");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
