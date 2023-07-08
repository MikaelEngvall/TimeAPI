package se.lexicon;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

/* Exercises from Lexicon. 1-14
 * Using the JavaTime API
 */
public class TimeApiExercises {

    public static void main(String[] args) {
        // Exercise 1: Create a LocalDate of the current day and print it out in the pattern
        // "Torsdag 29 mars" using DateTimeFormatter
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE d MMMM",
                Locale.forLanguageTag("sv")); // In swedish it uses lower cases
        String formattedDate = today.format(formatter);
        System.out.println("Exercise 1: " + formattedDate);

        // Exercise 2: Create a LocalDate of a specific date and print it out in the pattern
        // "Torsdag 29 mars" using DateTimeFormatter
        LocalDate specificDate = LocalDate.of(2023, 3, 29);
        String formattedSpecificDate = specificDate.format(formatter);
        System.out.println("Exercise 2: " + formattedSpecificDate);

        // Exercise 3: Create a LocalDate of the last Monday and print out the entire week
        // in the standard ISO format
        LocalDate lastMonday = today.with(DayOfWeek.MONDAY).minusWeeks(1);
        DateTimeFormatter isoFormatter = DateTimeFormatter.ISO_LOCAL_DATE;
        System.out.print("Exercise 3: ");
        for (int i = 0; i < 7; i++) {
            System.out.print(lastMonday.format(isoFormatter) + " ");
            lastMonday = lastMonday.plusDays(1);
        }

        // Exercise 4: Create a LocalDate object from a String by using the .parse() method.
        String dateString = "2023-07-08";
        // Parse the string into a LocalDate object
        LocalDate date = LocalDate.parse(dateString);
        // Print the LocalDate object
        System.out.println("\nExercise 4: Parsed LocalDate is " + date);

        //Exercise 5: Create a LocalDate of 1945-05-08and extract the day of week for that date.
        //I made it in swedish
        LocalDate date45 = LocalDate.of(1945, 5, 8);
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        String dayOfWeekSwedish = dayOfWeek.getDisplayName(TextStyle.FULL, Locale.forLanguageTag("sv"));
        System.out.println("Exercise 5: Day of week for 1945-05-08: " + dayOfWeekSwedish);

        //Exercise 6: Create a LocalDate of current date plus 10 years and minus 10 months.
        //From that date extract the month and print it out.
        LocalDate futureDate = today.plusYears(10).minusMonths(10);
        // Extract the month from the LocalDate object
        Month month = futureDate.getMonth();
        String monthSwedish = month.getDisplayName(TextStyle.FULL, Locale.forLanguageTag("sv"));
        System.out.println("Exercise 6: Month: " + monthSwedish); // Again in swedish, hence in lower cases

        //Exercise 7: Using the LocalDate from exercise 6and your birthdate, create a Period between
        //your birthdate and the date from exercise 5.Print out the elapsed years, months and days.
        LocalDate birthdate = LocalDate.of(1968, Month.JULY, 21);
        Period period = Period.between(date45, birthdate);

        int years = period.getYears();
        int months = period.getMonths();
        int days = period.getDays();

        // Get the display names of months in [language]
        String birthdateMonth = birthdate.getMonth().getDisplayName(TextStyle.FULL, Locale.forLanguageTag("en"));
        String date45Month = date45.getMonth().getDisplayName(TextStyle.FULL, Locale.forLanguageTag("en"));

        System.out.print("Exercise 7: The period between my birthdate: " + birthdate.getDayOfMonth() + " "
                + birthdateMonth + " " + birthdate.getYear() + " and 8 " + date45Month + " 1945 is ");
        System.out.println(years + " years, " + months + " months and " + days + " days.");

        //Exercise 8: Create a period of 4 years, 7 months and 29 days. Then create a LocalDate of current date
        // and add the period you createdto the current date.
        Period periodEx8 = Period.of(4, 7, 29);

        // Add the period to the current date
        LocalDate futureDateEx8 = today.plus(periodEx8);

        System.out.println("Exercise 8: Current Date: " + today + " Future Date: " + futureDateEx8);

        //Exercise 9: Create a LocalTime object of the current time.
        LocalTime now = LocalTime.now();

        System.out.println("Exercise 9: Current Time: " + now);

        //Exercise 10:

        //Exercise 11:

        //Exercise 12:

        //Exercise 13:

        //Exercise 14:

    }
}
