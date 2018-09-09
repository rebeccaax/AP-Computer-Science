package lab02;
//worked with daun lee
/**
 * Created by rebeccaxu on 10/18/17.
 */
public class TwelveDays {
    public static String singthatSong() {

        String singthatSong = "";
        final int FIRST_DAY = 1;
        final int TWELFTH_DAY = 12;

        for (int day = FIRST_DAY; day <= TWELFTH_DAY; day++) {
            if (day == 12) {
                singthatSong += "On the twelfth day of high school, my teacher gave to me \n";
            }

            else if (day == 11) {
                singthatSong += "On the eleventh day of high school, my teacher gave to me \n";
            }

            else if (day == 10) {
                singthatSong += "On the tenth day of high school, my teacher gave to me \n";
            }

            else if (day == 9) {
                singthatSong += "On the ninth day of high school, my teacher gave to me \n";
            }

            else if (day == 8) {
                singthatSong += "On the eighth day of high school, my teacher gave to me \n";
            }

            else if (day == 7) {
                singthatSong += "On the seventh day of high school, my teacher gave to me \n";
            }

            else if (day == 6) {
                singthatSong += "On the sixth day of high school, my teacher gave to me \n";
            }

            else if (day == 5) {
                singthatSong += "On the fifth day of high school, my teacher gave to me \n";
            }

            else if (day == 4) {
                singthatSong += "On the fourth day of high school, my teacher gave to me \n";
            }

            else if (day == 3) {
                singthatSong += "On the third day of high school, my teacher gave to me \n";
            }

            else if (day == 2) {
                singthatSong += "On the second day of high school, my teacher gave to me \n";
            }

            else {
                singthatSong += "On the first day of high school, my teacher gave to me \n";
            }

            switch (day) {
                case 12:
                    singthatSong += "Twelve lunch detentions\n";

                case 11:
                    singthatSong += "Eleven vocab lists \n";

                case 10:
                    singthatSong += "Ten Practice Problems \n";

                case 9:
                    singthatSong += "Nine performance skits \n";

                case 8:
                    singthatSong += "Eight examinations \n";

                case 7:
                    singthatSong += "Seven lab reports \n";

                case 6:
                    singthatSong += "Six chapters' reading \n";

                case 5:
                    singthatSong += "Five Shakespeare plays! \n";

                case 4:
                    singthatSong += "Four hundred emails \n";

                case 3:
                    singthatSong += "Three rough drafts \n";

                case 2:
                    singthatSong += "Two problem sets \n";
                    singthatSong += "And a lecture about my workload \n\n";
                    break;

                case 1:
                    singthatSong += "A lecture about my workload\n\n";
                    break;

                default:
                    System.err.println("Something went really wrong.");
            }
        }

        return singthatSong;
    }

    public static void main(String[] args) {
        System.out.println(singthatSong());
    }
}

/*
Prints the twelve days of high school.
*/