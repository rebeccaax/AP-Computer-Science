package lab02;
//worked with daun lee
/**
 * Created by rebeccaxu on 10/30/17.
 */
public class TaxCalc {
    final double BRACKET_5_MIN = 217450,
                 BRACKET_5_TAX = 0.33,
                 BRACKET_4_MIN = 142700,
                 BRACKET_4_TAX = 0.28,
                 BRACKET_3_MIN = 70700,
                 BRACKET_3_TAX = 0.25,
                 BRACKET_2_MIN = 17400,
                 BRACKET_2_TAX = 0.15,
                 BRACKET_1_TAX = 0.10;

    public String oldTax(double income) {
        //graduated tax
        double oldTax = 0.00;
        double difference = 0.00;

        if (income > BRACKET_5_MIN) {
            difference = income - BRACKET_5_MIN;
            oldTax += difference * BRACKET_5_TAX;
        }
        if (income > BRACKET_4_MIN) {
            difference = (Math.min(income, BRACKET_5_MIN) - BRACKET_4_MIN);
            oldTax += difference * BRACKET_4_TAX;
        }
        if (income > BRACKET_3_MIN) {
            difference = (Math.min(income, BRACKET_4_MIN) - BRACKET_3_MIN);
            oldTax += difference * BRACKET_3_TAX;
        }
        if (income > BRACKET_2_MIN) {
            difference = Math.min(BRACKET_3_MIN, income) - BRACKET_2_MIN;
            oldTax += difference * BRACKET_2_TAX;
            oldTax += BRACKET_2_MIN * BRACKET_1_TAX;
        }

        //rounds and formats the result
        oldTax = ((int) ((100 * oldTax) + .5)) / 100.0;
        return String.format("$%,.2f", oldTax);
    }

    public String newTax(double income) {
        //ungraduated tax
        double newTax = 0.00;

        if (income >= BRACKET_5_MIN) {
            newTax = income * BRACKET_5_TAX;
            newTax = ((int)((100 * newTax) + .5)) / 100.0;
            return String.format("$%,.2f", newTax);
        }
        else {
            return(oldTax(income));
        }
    }

   public String taxDifference(double income) {
       String oldTaxStringValue = oldTax(income);
       String newTaxStringValue = newTax(income);

       double oldTaxVal = Double.parseDouble(oldTaxStringValue.substring(1).replaceAll(",", ""));
       double newTaxVal = Double.parseDouble(newTaxStringValue.substring(1).replaceAll(",", ""));
       double taxDifference = newTaxVal - oldTaxVal;

       taxDifference = ((int) ((100 * taxDifference) + .5)) / 100.0;
       return (String.format("$%,.2f", taxDifference));
   }
}

/*
Returns graduated, ungraduated, and difference of the taxes
*/