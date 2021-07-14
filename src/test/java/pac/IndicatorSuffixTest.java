package pac;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class IndicatorSuffixTest {

    private List<String> expected;
    private List<String> actual;
    private  List<String> list;


    @Before
    public void setUp() throws Exception {
        list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("11");
        list.add("12");
        list.add("15");
        list.add("20");
        list.add("21");
        list.add("22");
        list.add("23");
        list.add("33");
        list.add("101");
        list.add("104");
        list.add("100000000");

        expected = new ArrayList<>();
        expected.add("1st");
        expected.add("2nd");
        expected.add("3rd");
        expected.add("4th");
        expected.add("11th");
        expected.add("12th");
        expected.add("15th");
        expected.add("20th");
        expected.add("21st");
        expected.add("22nd");
        expected.add("23rd");
        expected.add("33rd");
        expected.add("101st");
        expected.add("104th");
        expected.add("100000000th");

    }

    @Test
    public void assertEqualsTest()  {
        actual = new ArrayList<>();
        for (String s: list)
        {
            actual.add(IndicatorSuffix.action(s));
        }
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void wrongInput() {
        Assert.assertEquals(IndicatorSuffix.action("ggg"), "ggg");
    }

    @Test
    public void notEqualsTest()  {
        Assert.assertNotEquals(IndicatorSuffix.action("1"), "1nd");
    }

    @After
    public void tearDown()  {
    }

}