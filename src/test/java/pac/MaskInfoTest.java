package pac;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class MaskInfoTest {

    private  List<String> list;
    private  List<String> expected;
    private  List<String> actual;
    @Before
    public void setUp()  {
        list = new ArrayList();
        list.add("user@domain.com");
        list.add("u@domain.com.com.1com.com");
        list.add("USER@domain.com");
        list.add("user@domain.co.in");
        list.add("user1@domain.com");
        list.add("user.name@domain.com");
        list.add("user_name@domain.co.in");
        list.add("user-name@domain.co.in");
        list.add("a.a@dddd.com.");
        list.add(".a.a@dddd.com");
        list.add("a.a@dddd.com...");
        list.add("a.@domain.com");
        list.add("1@domain.com");
        list.add("+7 914 428 97 54");
        list.add(" +111 111 1 11 ");
        list.add("111 11 1-1111");
        list.add("1-1-1-1-1-1-1-1-1");
        list.add(" 111111111 ");
        list.add("+1112223334445");
        list.add("+1 1 1 1 1 1 1 1 1 1");
        list.add("test/test@test.com");
        list.add("+1-1- 015556465");

        expected = new ArrayList<>();
        expected.add("u*****r@domain.com");
        expected.add("u*****u@domain.com.com.1com.com");
        expected.add("u*****r@domain.com");
        expected.add("u*****r@domain.co.in");
        expected.add("u*****1@domain.com");
        expected.add("u*****e@domain.com");
        expected.add("u*****e@domain.co.in");
        expected.add("u*****e@domain.co.in");
        expected.add("a.a@dddd.com.");
        expected.add(".a.a@dddd.com");
        expected.add("a.a@dddd.com...");
        expected.add("a.@domain.com");
        expected.add("1*****1@domain.com");
        expected.add("+*-***-***-*7-54");
        expected.add("+***-***-1-11");
        expected.add("***-**-*-1111");
        expected.add("*-*-*-*-*-*-*-1-1");
        expected.add("*****1111");
        expected.add("+*********4445");
        expected.add("+*-*-*-*-*-*-*-*-1-1");
        expected.add("t*****t@test.com");
        expected.add("+1-1- 015556465");

    }

    @Test
    public void assertEqualsTest()  {
        actual = new ArrayList<>();
        for (String s: list)
        {
            actual.add(MaskInfo.action(s));
        }

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void wrongInput() {
        Assert.assertNotEquals(MaskInfo.action(null), "t*****t@test.com.c");
    }

    @After
    public void tearDown()  {
    }
}