package se.lexicon;

import java.text.DateFormatSymbols;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Locale;

import static java.time.format.TextStyle.FULL;

/* Exercises from Lexicon. 1-14
 * Using the JavaTime API
 * After today's lecture I would have done lots of the exercises differently
 */
public class TimeApiExercises {

    public static void main(String[] args) {
        // Exercise 1: Create a LocalDate of the current day and print it out in the pattern
        // "Torsdag 29 mars" using DateTimeFormatter
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE d MMMM",
                Locale.forLanguageTag("sv")); // In swedish it uses lower cases.
        // How can I capitalize the first letter? See the capitalizeFirstLetter methode included at the end.
        String formattedDate = capitalizeFirstLetter(today.format(formatter));
        System.out.println("Exercise 01: " + formattedDate);

        // Exercise 2: Create a LocalDate of a specific date and print it out in the pattern
        // "Torsdag 29 mars" using DateTimeFormatter
        LocalDate specificDate = LocalDate.of(2023, 3, 29);
        String formattedSpecificDate = capitalizeFirstLetter(specificDate.format(formatter));
        System.out.println("Exercise 02: " + formattedSpecificDate);

        // Exercise 3: Create a LocalDate of the last Monday and print out the entire week
        // in the standard ISO format
        LocalDate lastMonday = today.with(DayOfWeek.MONDAY).minusWeeks(1);
        DateTimeFormatter isoFormatter = DateTimeFormatter.ISO_LOCAL_DATE;
        System.out.print("Exercise 03: ");
        for (int i = 0; i < 7; i++) {
            System.out.print(lastMonday.format(isoFormatter) + " ");
            lastMonday = lastMonday.plusDays(1);
        }

        // Exercise 4: Create a LocalDate object from a String by using the .parse() method.
        String dateString = "2023-07-08";
        // Parse the string into a LocalDate object
        LocalDate date = LocalDate.parse(dateString);
        // Print the LocalDate object
        System.out.println("\nExercise 04: Parsed LocalDate is " + date);

        //Exercise 5: Create a LocalDate of 1945-05-08and extract the day of week for that date.
        //I made it in swedish
        LocalDate date45 = LocalDate.of(1945, 5, 8);
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        String dayOfWeekSwedish = capitalizeFirstLetter(dayOfWeek.getDisplayName(FULL, Locale.forLanguageTag("sv")));
        System.out.println("Exercise 05: Day of week for 1945-05-08: " + dayOfWeekSwedish);

        //Exercise 6: Create a LocalDate of current date plus 10 years and minus 10 months.
        //From that date extract the month and print it out.
        LocalDate futureDate = today.plusYears(10).minusMonths(10);
        // Extract the month from the LocalDate object
        Month month = futureDate.getMonth();
        String monthSwedish = capitalizeFirstLetter(month.getDisplayName(FULL, Locale.forLanguageTag("sv")));
        System.out.println("Exercise 06: Month: " + monthSwedish); // Again in swedish, hence in lower cases

        //Exercise 7: Using the LocalDate from exercise 6and your birthdate, create a Period between
        //your birthdate and the date from exercise 5.Print out the elapsed years, months and days.
        LocalDate birthdate = LocalDate.of(1968, Month.JULY, 21);
        Period period = Period.between(date45, birthdate);

        int years = period.getYears();
        int months = period.getMonths();
        int days = period.getDays();

        // Get the display names of months in [language]
        String birthdateMonth = birthdate.getMonth().getDisplayName(FULL, Locale.forLanguageTag("en"));
        String date45Month = date45.getMonth().getDisplayName(FULL, Locale.forLanguageTag("en"));

        System.out.print("Exercise 07: The period between my birthdate: " + birthdate.getDayOfMonth() + " "
                + birthdateMonth + " " + birthdate.getYear() + " and 8 " + date45Month + " 1945 is ");
        System.out.println(years + " years, " + months + " months and " + days + " days.");

        //Exercise 8: Create a period of 4 years, 7 months and 29 days. Then create a LocalDate of current date
        // and add the period you created to the current date.
        Period periodEx8 = Period.of(4, 7, 29);

        // Add the period to the current date
        LocalDate futureDateEx8 = today.plus(periodEx8);

        System.out.println("Exercise 08: Current Date: " + today + " Future Date: " + futureDateEx8);

        //Exercise 9: Create a LocalTime object of the current time.
        LocalTime now = LocalTime.now();

        System.out.println("Exercise 09: Current Time: " + now);

        //Exercise 10: Extract the nanoseconds of a LocalTime object of current time. Print out the nanoseconds.
        int nanoseconds = now.getNano();

        System.out.println("Exercise 10: Nanoseconds: " + nanoseconds);

        //Exercise 11: Create a LocalTime object from a String using the .parse() method.
        String timeString = "12:34:56.789012345"; //I added the nanos ;)

        // Parse the string into a LocalTime object, same as Exercise 4 but with LocalTime instead.
        LocalTime time = LocalTime.parse(timeString);

        // Print the LocalTime object
        System.out.println("Exercise 11: Parsed LocalTime: " + time);

        //Exercise 12: Using DateTimeFormatter format LocalTime from current time and print it out
        // as following pattern:10:32:53

        DateTimeFormatter formatterTime = DateTimeFormatter.ofPattern("HH:mm:ss"); // Define the desired pattern
        String formattedTime = now.format(formatterTime); // Format the LocalTime using the formatter

        System.out.println("Exercise 12: Formatted LocalTime: " + formattedTime);

        //Exercise 13: Create a LocalDateTime with the date and time components
        //as: date: 2018-04-05, time: 10.00.
        LocalDate dateEx13 = LocalDate.of(2018, 4, 5);
        LocalTime timeEx13 = LocalTime.of(10, 0);

        LocalDateTime dateTime = LocalDateTime.of(dateEx13, timeEx13);
        //LocalDateTime dateTime = LocalDateTime.of(today, now); //Just tested today and now

        System.out.println("Exercise 13: LocalDateTime: " + dateTime);

        //Exercise 14:Using DateTimeFormatter format the LocalDateTime object from exercise
        // 11 (I think you meant 13 here) to a String that should look tile this: torsdag 5 april 10:00
        DateTimeFormatter formatterEx14 = DateTimeFormatter.ofPattern("EEEE d MMMM HH:mm",
                Locale.forLanguageTag("sv")); // In Swedish, lowercase for month and weekday
        String formattedDateTime = capitalizeFirstLetter(dateTime.format(formatterEx14));

        System.out.println("Exercise 14: Formatted LocalDateTime: " + formattedDateTime);

        //Exercise 15:
        // Create a LocalDate object
        LocalDate dateEx15 = LocalDate.of(2023, 7, 8);
        // Create a LocalTime object
        LocalTime timeEx15 = LocalTime.of(12, 34, 56);
        // Combine the LocalDate and LocalTime to create a LocalDateTime object
        LocalDateTime dateTimeEx15 = dateEx15.atTime(timeEx15);

        System.out.println("Exercise 15: Combined LocalDateTime: " + dateTime);

        //Exercise 16:
        // Create a LocalDateTime object
        LocalDateTime dateTimeEx16 = LocalDateTime.of(2023, 7, 8, 12, 34, 56);
        // Extract the LocalDate component from the LocalDateTime
        LocalDate dateEx16 = dateTime.toLocalDate();
        // Extract the LocalTime component from the LocalDateTime
        LocalTime timeEx16 = dateTime.toLocalTime();

        System.out.println("Exercise 16: Date component: " + date + " Time component: " + time);

        //Exercise 17: Print out the calendar for year 2018.
        //Something wrong with April and July. I'll have to check it out eventually
        int year = 2018;
        // Create a Calendar object
        Calendar calendar = Calendar.getInstance();
        // Set the year
        calendar.set(Calendar.YEAR, year);
        // Print the calendar for the year 2018
        printCalendar(calendar);

    }

    private static String capitalizeFirstLetter(String text) {
        if (text == null || text.isEmpty()) {
            return text;
        }
        return text.substring(0, 1).toUpperCase() + text.substring(1);
    }

    public static void printCalendar(Calendar calendar) {
        int year = calendar.get(Calendar.YEAR);

        System.out.println("Calendar for the year " + year);

        DateFormatSymbols symbols = new DateFormatSymbols(Locale.getDefault());
        String[] dayNames = symbols.getShortWeekdays();
        String[] monthNames = symbols.getMonths();

        //System.out.println("  M  T  W  T  F  S  S");

        for (int month = Calendar.JANUARY; month <= Calendar.DECEMBER; month++) {
            // Create a new Calendar object for each month
            Calendar monthCalendar = Calendar.getInstance();
            monthCalendar.set(Calendar.YEAR, year);
            monthCalendar.set(Calendar.MONTH, month);
            monthCalendar.set(Calendar.DAY_OF_MONTH, 1);

            int maxDayOfMonth = monthCalendar.getActualMaximum(Calendar.DAY_OF_MONTH);

            String monthName = monthNames[month];

            System.out.println("\n " + capitalizeFirstLetter(monthName) + " " + year);
            System.out.println(" Må Ti On To Fr Lö Sö");


            int firstDayOfWeek = monthCalendar.get(Calendar.DAY_OF_WEEK);


            // Calculate the number of leading spaces for the first week
            int leadingSpaces = (firstDayOfWeek - Calendar.MONDAY + 7) % 7;

            for (int i = 0; i < leadingSpaces; i++) {
                System.out.print("   ");
            }

            for (int day = 1; day <= maxDayOfMonth; day++) {
                int weekDay = monthCalendar.get(Calendar.DAY_OF_WEEK);
                System.out.printf("%3d", day);
                if (weekDay == Calendar.SUNDAY || day == maxDayOfMonth) {
                    System.out.println();
                }
                monthCalendar.add(Calendar.DAY_OF_MONTH, 1);
            }
        }
    }

}
