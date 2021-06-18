package filter;

import interfaces.Filter;
import interfaces.IncludesFilter;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class IncludesFilterTest {
    @Test
    public  void filterTest(){
        Filter str1 = new IncludesFilter("раму");

        assertTrue(str1.apply("мама мыла раму"));

    }
    @Test(expected = IllegalArgumentException.class)
    public  void filterExceptionTest(){
        Filter str1 = new IncludesFilter("");

        assertTrue(str1.apply("мама мыла раму"));

    }
}
