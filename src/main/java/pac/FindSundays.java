package pac;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class FindSundays {

    public static void main(String[] args) throws Exception {
        if (args.length > 2)
        {
            System.out.println("More than two arguments\ngetting the first ones...");
        }

        if (args.length == 0)
        {
            System.out.println("No arguments - return...");
            return;
        }

        String s1 = args[0];
        String s2 = args[1];

        int s = action(s1, s2);

        if (s == -1)
        {
            //made in such a way as not to make the tests smooth
            throw new Exception("Not valid input");
        }

        System.out.println("('" + s1 + "'), ('" + s2 + "') => " + s);
    }

    /**
     * @param s1 - string value of date. First point in time. Date formatter = "dd-MM-yyyy"
     * @param s2 - second point in time.
     * @return - int value of sundays between two dates or -1 in case of exception.
     */
    public static int action(String s1, String s2) {
        DateTimeFormatter dtfInput = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        try {
            LocalDate startDate = LocalDate.parse(s1, dtfInput);
            LocalDate endDate = LocalDate.parse(s2, dtfInput);

            LocalDate currentDay = startDate;
            int count = 0;
            while (currentDay.isBefore(endDate) || currentDay.isEqual(endDate)) {
                if (currentDay.getDayOfWeek().equals(DayOfWeek.SUNDAY)) {
                    count++;
                }
                currentDay = currentDay.plusDays(1L);
            }
            return count;
        }
        catch (DateTimeParseException e)
        {
            System.out.println("DateTimeParseException e = " + e.getMessage());
            return -1;
        }
        catch (NullPointerException e)
        {
            e.printStackTrace();
            System.out.println("NullPointerException e = " + e.getMessage());
            return -1;
        }
        catch (Exception e)
        {
            e.getStackTrace();
            System.out.println("Exception e = " + e.getMessage());
            return -1;
        }

    }
}
