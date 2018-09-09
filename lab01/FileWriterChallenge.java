package lab01;
import java.util.Scanner;
import java.io.*;

//worked with hannah ahn

public class FileWriterChallenge {
    public static void main(String[] args) {

        //font file
        Scanner input = new Scanner(System.in);
        System.out.println("Where is your font file?");
        String file = input.nextLine();
        BufferedReader br = null;

        try {

            br = new BufferedReader(new FileReader(file));

            final int LINES_IN_FILE = 5;
            String[] a = new String[(LINES_IN_FILE)];
            String[] b = new String[(LINES_IN_FILE * 2)];
            String[] c = new String[(LINES_IN_FILE * 2)];

            //output file
            Scanner output = new Scanner(System.in);
            System.out.println("Where is your output file?");
            String outputfile = output.nextLine();


            String[] order = {" ", " ", " ", " "};

            System.out.println("Give a letter");
            order[0] = input.next();

            System.out.println("Give a letter");
            order[1] = input.next();

            System.out.println("Give a letter");
            order[2] = input.next();

            System.out.println("Give a letter");
            order[3]= input.next();

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

            //file
            File ofile = new File(outputfile);

            if (!ofile.exists()) {
                ofile.createNewFile();
            }

            FileWriter fw = new FileWriter(ofile.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);

            //horizontal
            String horizontal;
            final int AMOUNTOFLETTERS = 4;
            final int HORIZONTAL2 = 3;
            for (int i = 0; i <= AMOUNTOFLETTERS; i++) {
                horizontal = "";

                for (int j = 0; j <= HORIZONTAL2; j++) {

                    if (order[j].equals("A")) {
                        horizontal = horizontal + a[i];
                    }

                    if (order[j].equals("B")) {
                        horizontal = horizontal + b[i];
                    }

                    if (order[j].equals("C")) {
                        horizontal = horizontal + c[i];
                    }
                }
                bw.write(horizontal + "\n");
            }
            bw.close();
        }

        catch (IOException e) {
            e.printStackTrace();
        }
    }
}

/*
Using only the letters “A”, “B”, and “C”, ask the user to input four characters in any order.
(The user may repeat a character if they would like.)
Display these characters to a textfile as one line of bubble letter “text”.
*/