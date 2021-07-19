package pac;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FindSundays_2Test {


    @Test
    public void getAmountOfSundays() {
        FindSundays_2 findSundays = new FindSundays_2();
        findSundays.setFirstDate("01-05-2021");
        findSundays.setSecondDate("30-05-2021");

        Assert.assertEquals(findSundays.getAmountOfSundays(), 5);
    }
}