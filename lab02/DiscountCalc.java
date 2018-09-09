package lab02;
//worked with daun lee
/**
 * Created by rebeccaxu on 10/18/17.
 */
public class DiscountCalc {
    public static double calculateTheDiscount(int numOfItems, double cost) {

        double discount;
        double newCost = 0.00;
        final double SPECIAL_SAVINGS_RATE = 0.10;
        final double SUPER_SPECIAL_SAVINGS_RATE = 0.09;
        final int ZERO_ITEMS = 0;
        final int FIVE_ITEMS = 5;
        final int TEN_ITEMS = 10;
        final int TWENTY_ITEMS = 20;

        if (numOfItems > ZERO_ITEMS && numOfItems <= FIVE_ITEMS) {
            newCost = cost * FIVE_ITEMS;
            discount = cost - newCost;
        }
        else if (numOfItems <= TEN_ITEMS) {
            newCost = cost * SUPER_SPECIAL_SAVINGS_RATE;
            discount = cost - newCost;
        }
        else if (numOfItems <= TWENTY_ITEMS) {
            discount = newCost;
        }
        else {
            newCost = cost * SPECIAL_SAVINGS_RATE;
            discount = cost - newCost;
        }

        //rounds the result
        discount = ((int) ((100 * discount) + .5)) / 100.0;

        return discount;
    }
}

/*
Create one method that returns the discount on a given purchase.
Make sure that the cost is properly rounded to the nearest penny.
*/