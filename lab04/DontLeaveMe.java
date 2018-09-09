package lab04;
import java.util.Scanner;

/**
 * Created by rebeccaxu on 12/14/17.
 */
public class DontLeaveMe {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String repeat;
        do {
            System.out.println("What should I say?");
            repeat = input.nextLine();

            if ((repeat.equalsIgnoreCase("Exit"))) {
                System.out.println("Exiting...");
            }

            else {
                System.out.println(repeat);
            }

        } while (!repeat.equalsIgnoreCase("Exit"));

    }
}

/*
Collect a String from the user, and repeat back whatever it says.
The program should continue to do this until the user enters the String ͞Exit͟.
Ignore capitalization in ͞Exit͟. You may not use a break or System.exit statement.
The loop should naturally end when the user types ͞Exit͟
*/