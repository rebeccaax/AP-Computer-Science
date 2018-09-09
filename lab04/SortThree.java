package lab04;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by rebeccaxu on 12/19/17.
 */
public class SortThree {
    public static void main(String[] args) {
        int ones = 0;
        int twos = 0;
        int threes = 0;
        int pos = 0;

        Scanner input = new Scanner(System.in);
        System.out.print("What is the size of the array? ");
        int size = input.nextInt();
        int[] array = new int[size];

        for (int j = 0; j < size; j++) {
            array[j] = (int) (Math.random() * 3 + 1);

            if (array[j] == 1) {
                ones++;
            }

            if (array[j] == 2) {
                twos++;
            }

            if (array[j] == 3) {
                threes++;
            }
        }

        System.out.println(Arrays.toString(array));

        for (int i = 0; i < ones; i++) {
            array[pos] = 1;
            pos++;
        }

        for (int k = 0; k < twos; k++) {
            array[pos] = 2;
            pos++;
        }

        for (int x = 0; x < threes; x++) {
            array[pos] = 3;
            pos++;
        }

        System.out.println(Arrays.toString(array));

    }
}

/*
        while (k < size) {
            if (i == array.length - 1) {
                i = 0;
                k++;
            }

            if (array[i+1] < array[i]) {
                temp = array[i + 1];
                array[i + 1] = array[i];
                array[i] = temp;
            }
            i++;
        }



        for (int k = 0; k < size; k++) {
            for (int i = 0; i < array.length - 1; i++) {
                int temp;
                if (array[i + 1] < array[i]) {
                    temp = array[i + 1];
                    array[i + 1] = array[i];
                    array[i] = temp;
                }
            }
        }


there is an array full of the numbers 1, 2, and 3.
ask the user for an array size,
fill the bucket with appropriate random numbers (using Math.random(),
arithmetic, and int casting).
You will then print that randomized array to the screen.
*/
