package pac;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FindSundaysTest {

    @Before
    public void setUp() {
    }

    @Test
    public void assertEqualsTest() {
        Assert.assertEquals(FindSundays.action("01-02-1999" , "01-02-2021"), 1148);
        Assert.assertEquals(FindSundays.action("01-02-0001" , "01-02-9999"), 521671);//no 0000 year!!!
        Assert.assertEquals(FindSundays.action("01-05-2021" , "30-05-2021"), 5);
      //  Assert.assertEquals(FindSundays.action("01-01-2020" , "01-01-2022"), 105);
      //  Assert.assertEquals(FindSundays.action("01-01-2020" , "01-01-2021"), 105);
        Assert.assertEquals(FindSundays.action("01-01-2021" , "01-01-2022"), 105);
    }

    @Test
    public void wrongInput() {
        Assert.assertEquals(FindSundays.action("01-05-221" , "30-05-2021"), -1);
    }

    @Test
    public void notEqualsTest() {
        Assert.assertNotEquals(FindSundays.action("01-05-2021" , "30-05-2021"), 6);
    }

    @Test
    public void wrongOrder()
    {
        Assert.assertEquals(FindSundays.action("30-05-2021" , "01-05-2021"), 0);
    }

    @After
    public void tearDown()  {
    }
}