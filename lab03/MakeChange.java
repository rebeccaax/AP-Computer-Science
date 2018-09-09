package lab03;

/**
 * Created by rebeccaxu on 11/16/17.
 */
public class MakeChange {
    public static String makeChange(double money) {
        final double AMOUNT_OF_MONEY[] = {100, 50, 20, 10, 5, 1, 0.25, 0.10, 0.05, 0.01};
        String change = "";

        for (int i = 0; i < 10; i++){
            change += (int)(money/AMOUNT_OF_MONEY[i]);
            change += " ";

            money %= AMOUNT_OF_MONEY[i];
            money = (int)(Math.round(money*100))/ 100.0;
        }

        return change;
    }
}

/*
Using modular arithmetic, please create a method to determine the
proper way to break an amount of money into change.
SpreadLines will take a series of arguments
Should return a String with the optimal number of the following,
separated by spaces:
Hundreds, fifties, twenties, tens, fives, singles, quarters, dimes, nickels, and pennies.
*/