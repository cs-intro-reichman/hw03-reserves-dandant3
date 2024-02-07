public class Calendar2 {
    private static int endyear;
    public static void main(String args[]) {
        endyear = Integer.parseInt(args[0]);
        // Starting the calendar on 1/1/1900
        int dayOfMonth = 1;
        int month = 1;
        int year = 1900;
        int dayOfWeek = 2;     // 1.1.1900 was a Monday
        int nDaysInMonth = 31; // Number of days in January
        int SundayCounter = 0;

        // Advances the date and the day-of-the-week from 1/1/1900 till 31/12/1999, inclusive.
        // Prints each date dd/mm/yyyy in a separate line. If the day is a Sunday, prints "Sunday".
        // The following variable, used for debugging purposes, counts how many days were advanced so far.
        int debugDaysCounter = 0;
 
        while (true) {
            if (dayOfMonth == 1 && dayOfWeek == 1) {
                System.out.println(dayOfMonth + "/" + month + "/" + year + " Sunday");
                SundayCounter++;
            } else {
                System.out.println(dayOfMonth + "/" + month + "/" + year);
            }
            advance(dayOfWeek, dayOfMonth, month, year, nDaysInMonth);
            debugDaysCounter++;
            if (year > endyear) {
                break;
            }
        }
        System.out.println("During the 20th century, " + SundayCounter + " Sundays fell on the first day of the month");
    }

    // Advances the date (day, month, year) and the day-of-the-week.
    // If the month changes, sets the number of days in this month.
    // Side effects: changes the static variables dayOfMonth, month, year, dayOfWeek, nDaysInMonth.
    private static void advance(int dayOfWeek, int dayOfMonth, int month, int year, int nDaysInMonth) {
        dayOfWeek = dayOfWeek % 7 + 1;
        if (dayOfMonth < nDaysInMonth) {
            dayOfMonth++;
        } else {
            dayOfMonth = 1;
            if (month < 12) {
                month++;
                nDaysInMonth = nDaysInMonth(month, year);
            } else {
                month = 1;
                year++;
            }
        }
    }

    // Returns true if the given year is a leap year, false otherwise.
    private static boolean isLeapYear(int year) {
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            return true;
        }
        return false;
    }

    // Returns the number of days in the given month and year.
    // April, June, September, and November have 30 days each.
    // February has 28 days in a common year, and 29 days in a leap year.
    // All the other months have 31 days.
    private static int nDaysInMonth(int month, int year) {
        if (month == 4 || month == 6 || month == 9 || month == 11) {
            return 30;
        } else if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            return 31;
        } else {
            if (isLeapYear(year)) {
                return 29;
            } else {
                return 28;
            }
        }
    }
}