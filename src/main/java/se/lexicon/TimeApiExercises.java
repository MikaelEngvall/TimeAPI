package se.lexicon;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/* Exercises from Lexicon. 1-14
 * Using the JavaTime API
 */
public class TimeApiExercises {

    public static void main(String[] args) {
        // Exercise 1: Create a LocalDate of the current day and print it out in the pattern
        // "Torsdag 29 mars" using DateTimeFormatter
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE d MMMM",
                Locale.forLanguageTag("sv")); // In swedish it uses lower cases
        String formattedDate = currentDate.format(formatter);
        System.out.println("Exercise 1: " + formattedDate);

        // Exercise 2: Create a LocalDate of a specific date and print it out in the pattern
        // "Torsdag 29 mars" using DateTimeFormatter
        LocalDate specificDate = LocalDate.of(2023, 3, 29);
        String formattedSpecificDate = specificDate.format(formatter);
        System.out.println("\nExercise 2: " + formattedSpecificDate);

        // Exercise 3: Create a LocalDate of the last Monday and print out the entire week
        // in the standard ISO format
        LocalDate today = LocalDate.now();
        LocalDate lastMonday = today.with(DayOfWeek.MONDAY).minusWeeks(1);
        DateTimeFormatter isoFormatter = DateTimeFormatter.ISO_LOCAL_DATE;
        System.out.println("Exercise 3:");
        for (int i = 0; i < 7; i++) {
            System.out.print(lastMonday.format(isoFormatter) + " ");
            lastMonday = lastMonday.plusDays(1);
        }
    }
}
