package lab04;

/**
 * Created by rebeccaxu on 12/14/17.
 */
public class GetE {
    public static void main(String[] args) {
        final int N = Integer.parseInt(args[0]);
        double answer = 1;
        double factorial = 1;

        for (int i = 1; i < N; i++) {
            factorial *= i;
            answer += (1 / factorial);
        }

        System.out.println(answer);
    }
}

/*
This program is meant to be run from a console.
The irrational number e, also called Euler’s number,
is approximately 2.71828.  Euler proved that this number
was irrational by showing that it was equal to the infinitely
expanding series 1 + 1/1 + 1/(2!) + 1/(3!) + 1/(4!)...
*/
