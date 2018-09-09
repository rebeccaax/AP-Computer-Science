package lab01;
import java.util.Scanner;

public class Initials {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("What is the first letter you want?");
        String a = input.nextLine();

        System.out.println("What is the second letter you want?");
        String b = input.nextLine();

        System.out.println("What is the third letter you want?");
        String c = input.nextLine();

        /*
        OUTPUT SAMPLE

        aaaaaa	 bbb bbb  cc   cc
        a aa  a	 b b b b   cc cc
        a aa  a	 b bbb b    ccc
        a    a	 b bbb b    ccc
        a aa  a  b b b b   cc cc
        aaa aaaa bbb bbb  cc   cc
        */

        //prints the initials with the letters (by using strings)
        System.out.println(a + a + a + a + a + a + "\t " + b + b + b + " " + b + b + b + "  " + c + c + "   " + c + c );
        System.out.println(a + " " + a + a + "  " + a + "\t " + b + " " + b + " " + b + " " + b + " " + "  " + c + c + " " + c + c + " ");
        System.out.println(a + " " + a + a + "  " + a + "\t " + b + " " + b + b + b + " " + b + "  " + "  " + c + c + c + "   ");
        System.out.println(a + "    " + a + "\t " + b + " " + b + b + b + " " + b + "  " + "  " + c + c + c + "   ");
        System.out.println(a + " " + a + a + "  " + a + "  " + b + " " + b + " " + b + " " + b + " " + "  " + c + c + " " + c + c + " ");
        System.out.println(a + a + a + " " + a + a + a + a + " " + b + b + b + " " + b + b + b + "  " + c + c + "   " + c + c );

    }
}

/*
Collect three characters from the user, and write your initials using these characters
*/