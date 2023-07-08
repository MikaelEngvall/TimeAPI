package se.lexicon;

import java.time.DayOfWeek;
import java.time.LocalDate;
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
    }
}
