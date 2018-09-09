package lab01;
import java.util.Scanner;

public class RepeatRepeatParrot {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Hello, I'm Squawky the Parrot. What should I say?");
        String text = input.nextLine();
        System.out.println("How many times should I say it?");
        int num = input.nextInt();
        input.close();

        final int MINREPEATS = 1;
        final int MAXREPEATS = 8;
        if (num >= MINREPEATS && num <= MAXREPEATS) {
            for (int i = 0; i < num; i++) {
                System.out.println(text);
        }

        }
    }
}

/*
Write a program for Squawky that will ask the user for a piece of text and an int.
Repeat the text back the number of times specified by the user, once per line!
You may assume that the number will be between (inclusive) 1 and 8.
Any other numbers should cause the program to end without printing anything.
*/