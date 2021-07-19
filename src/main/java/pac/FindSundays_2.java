package pac;

import java.time.format.DateTimeParseException;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class FindSundays_2 {
    private GregorianCalendar firstDate;
    private GregorianCalendar secondDate;



    public void setFirstDate(String date) {
        try {
            int day = Integer.parseInt(date.substring(0, 2));
            int month = Integer.parseInt(date.substring(3, 5)) - 1;
            int year = Integer.parseInt(date.substring(6));
            firstDate = new GregorianCalendar(year, month, day);
        }
        catch (DateTimeParseException e)
        {
            System.out.println("DateTimeParseException e = " + e.getMessage());
            return;
        }
        catch (NullPointerException e)
        {
            e.printStackTrace();
            System.out.println("NullPointerException e = " + e.getMessage());
            return;
        }
        catch (Exception e)
        {
            e.getStackTrace();
            System.out.println("Exception e = " + e.getMessage());
            return;
        }
    }

    public void setSecondDate(String date) {
        try {
            int day = Integer.parseInt(date.substring(0, 2));
            int month = Integer.parseInt(date.substring(3, 5)) - 1;
            int year = Integer.parseInt(date.substring(6));
            secondDate = new GregorianCalendar(year, month, day);
            }
        catch (DateTimeParseException e)
        {
            System.out.println("DateTimeParseException e = " + e.getMessage());
            return;
        }
        catch (NullPointerException e)
        {
            e.printStackTrace();
            System.out.println("NullPointerException e = " + e.getMessage());
            return;
        }
        catch (Exception e)
        {
            e.getStackTrace();
            System.out.println("Exception e = " + e.getMessage());
            return;
        }
    }


    public int getAmountOfSundays() {
        int aos = 0;


        int days = getNumbsOfDays(secondDate,firstDate);
        if (days < 7) {
            if ((firstDate.get(Calendar.DAY_OF_WEEK) + days) > 8) return aos = 1;
            else return aos = 0;
        }
        aos += (int)Math.ceil((double) days/7);

        return aos;
    }

    private int getNumbsOfDays(GregorianCalendar obj2, GregorianCalendar obj1) {
        int days = (int) ((obj2.getTimeInMillis() - obj1.getTimeInMillis()) / (24 * 60 * 60 * 1000)) +1;
        return days;
    }
}

