package lab05; //Camellia and Rebecca

public class CalendarPrinter {
	
	public final static String[] monthList = {"January", "February", "March", "April", "May", "June", "July", "August",
			"September", "October", "November", "December"};
	public final static String[] day = {"Su", "Mo", "Tu", "We", "Th", "Fr", "Sa"};
	public final static int[] numDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

	public static void main(String[] args) {
		printMonth(2017, 1, 0, true);
		printYear(2013, 2, false);
	}

	public static void printMonth(int year, int month, int janFirst, boolean leapYear) {
		String[][] printMonthArr = new String[7][7];
		int count = 0, sumOfDays = 0, dayNum = 1;

		for (int i = 0; i < printMonthArr.length; i++) {
			for (int j = 0; j < printMonthArr[i].length; j++) {
				printMonthArr[i][j] = " ";
			}
		}

		if (leapYear) { // February from 28 -> 29 days
			numDays[1] = 29;
		}
		
		for (int i = 1; i < month; i++) { // Adds up total amount of days from Jan to month
			sumOfDays += numDays[i - 1];
		}

		printMonthArr[0][1] = monthList[month - 1] + " " + year;
		int firstDay = (sumOfDays + janFirst) % 7;

		while (count < printMonthArr.length) {
			for (int i = 0; i < 7; i++) {
				if (dayNum > numDays[month - 1]) { 
// once the day number gets larger than the number of days in the month, this makes the numbers end at the right place
					break;
				}

				if (count == 1) {
					printMonthArr[count][i] = day[i]; //sets a spot in the array to a day
					
				} else if (count >= 2) {
					if (dayNum > 1) { // Displays all other days besides 1st
						printMonthArr[count][i] = dayNum + "";
						dayNum++;
					}
					
					if ((i == firstDay) && (count == 2)) { //Displays the 1st day
						printMonthArr[count][i] = dayNum + "  ";
						dayNum++;
					}
				}
			}
			
			count++;
		}
		
		for (int i = 0; i < printMonthArr.length; i++)
			for (int j = 0; j < printMonthArr[i].length; j++) {
				System.out.printf("%-3s", printMonthArr[i][j]);
				
				if (j == printMonthArr[i].length - 1) {
					System.out.println();
				}
			}
	}

	public static void printYear(int year, int janFirst, boolean leapYear) {
		int sumDay = 0, dayNum = 1, firstDayJan, firstMonday = 0, firstThursday = 0;
		
		String stringYear = "", stringMonthLine = "";
		String[][][] month = new String[12][7][7];
		
		if (leapYear) {
			numDays[1] = 29;
		} else {
			numDays[1] = 28;
		}
		
		stringYear += String.format("%36s\n\n", year + "");

		for (int i = 0; i < month.length; i++) {
			for (int j = 0; j < month[i].length; j++) {
				for (int k = 0; k < month[i][j].length; k++) {
					month[i][j][k] = "";
				}
			}
		}

		for (int i = 0; i < 12; i++) { //represents months
			dayNum = 1;
			firstDayJan = (sumDay + janFirst) % 7; //find the first day of the month
			firstMonday = 0;
			firstThursday = 0;
			
			for (int j = 0; j <= 6; j++) //represents number of rows
				for (int k = 0; k < 7; k++) {//represents day
					if (dayNum > numDays[i]) {
						break; // to stop numbers from getting too high
					}
					
					if (j == 0) {
						month[i][j][k] = day[k];
					}
					
					if (j >= 1) { //
						if (dayNum > 1) {
							if (k == 1)
								firstMonday++;
							if (k == 4)
								firstThursday++;

							month[i][j][k] = dayNum + "";

//replacement with special characters, couldn't find a way to make them red
							if ((i == 10) && (dayNum == 11))
								month[i][j][k] = "*v";

							if ((i == 6) && (dayNum == 4))
								month[i][j][k] = "*4";

							if ((i == 11) && (dayNum == 25))
								month[i][j][k] = "*c";

							if ((i == 4) && (k == 1) && (j == 5))
								month[i][j][k] = "*m";

							if ((i == 10) && (firstThursday == 4) && (k == 4))
								month[i][j][k] = "*t";

							if ((i == 3) && (dayNum == 15)) {
								if (k == 0)
									month[i][j][k + 1] = "*x";
								else if (k == 6)
									month[i][j][k + 2] = "*x";
								else
									month[i][j][k] = "*x";
							}
							dayNum++;
						}
						
						if ((k == firstDayJan) && (j == 1)) {
							if (k == 1)
								firstMonday++;
							month[i][j][k] = dayNum + "";
							dayNum++;

							if (i == 0)
								month[i][j][k] = "*y";
						}
						if ((firstMonday == 3) && (i == 1) && (k == 1))
							month[i][j][k] = "*p";
						if ((firstMonday == 1) && (i == 8) && (k == 1))
							month[i][j][k] = "*L";
					}
				}
			sumDay += numDays[i];
		}		
		
		for (int i = 0; i < 12; i += 3) { //center string and display months
			String var = "        ";

			for (int j = i; j < i + 3; j++) {
				var += String.format("%-22s", monthList[j]) + "  "; //dunno how to format the months better
			}
			
			var += "\n";
						
			stringMonthLine += var;
			
			for (int k = 0; k <= 6; k++) {// line
				for (int j = i; j < i + 3; j++) {
					for (int l = 0; l < 7; l++) {
						stringMonthLine += String.format("%3s", month[j][k][l]);
					}
					stringYear += String.format("%s\t", stringMonthLine);
					stringMonthLine = "";
				}
				stringYear += "\n";
			}
		}
		System.out.println(stringYear);
	}

}