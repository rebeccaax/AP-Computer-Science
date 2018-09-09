package lab01;
import java.util.Scanner;
import java.io.*;

//worked with hannah ahn

public class Challenge {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Where is your file?");
        String file = input.nextLine();
        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader(file));
            //file
            String[] order = {" ", " ", " ", " "};

            System.out.println("Give a letter");
            order[0] = input.next();

            System.out.println("Give a letter");
            order[1] = input.next();

            System.out.println("Give a letter");
            order[2] = input.next();

            System.out.println("Give a letter");
            order[3] = input.next();

            final int LINES_IN_FILE = 5;
            String[] a = new String[LINES_IN_FILE];
            String[] b = new String[LINES_IN_FILE];
            String[] c = new String[LINES_IN_FILE];

            //vertical
            final int TOTAL_LINES_IN_FILE = 15;
            for (int i = 0; i < TOTAL_LINES_IN_FILE; i++) {
                if (i < LINES_IN_FILE) {
                    a[i] = br.readLine();
                }

                else if (i < (LINES_IN_FILE * 2)) {
                    b[i-5] = br.readLine();
                }

                else {
                    c[i-10] = br.readLine();
                }
            }

            //horizontal
            String horizontal;
            final int LETTERS = 4;
            final int LETTERS2 = 3;
            for (int i = 0; i <= LETTERS; i++) {
                horizontal = "";

                for (int j = 0; j <= LETTERS2; j++) {
                    if (order[j].equals("A")) {
                        horizontal = horizontal + a[i];
                    }

                    else if (order[j].equals("B")) {
                        horizontal = horizontal + b[i];
                    }

                    else {
                        horizontal = horizontal + c[i];
                    }
                }

                System.out.println(horizontal);
            }
        }

        catch (IOException e) {
            e.printStackTrace();
        }

        finally {
            try {
                if (br != null) br.close();
            }

            catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}

/*
Using only the letters “A”, “B”, and “C”, ask the user to input four characters in any order.
(The user may repeat a character if they would like.)
Display these characters to the screen as one line of bubble letter “text”.
*/