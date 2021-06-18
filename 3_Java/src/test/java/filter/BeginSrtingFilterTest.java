package filter;

import interfaces.BeginStringFilter;
import interfaces.Filter;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BeginSrtingFilterTest {
    @Test
    public  void filterTest(){
        Filter str1 = new BeginStringFilter("мама");


        assertTrue(str1.apply("мама мыла раму"));

        assertFalse(str1.apply("мыла раму"));

    }
    @Test(expected = IllegalArgumentException.class)
    public  void filterExceptionTest(){
        Filter str1 = new BeginStringFilter("");

        assertTrue(str1.apply("мама мыла раму"));

    }
}
