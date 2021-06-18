package filter;

import interfaces.ContainsLettersFilter;
import interfaces.Filter;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ContainsLettersFilterTest {
    @Test
    public  void filterTest(){
        Filter str1 = new ContainsLettersFilter("раму");

        assertTrue(str1.apply("мама мыла раму"));

    }

    @Test(expected = IllegalArgumentException.class)
    public  void filterExceptionTest(){
        Filter str1 = new ContainsLettersFilter("");

        assertTrue(str1.apply("мама мыла раму"));

    }
}
