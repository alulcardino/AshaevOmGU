package strings;

import org.junit.Test;
import static org.junit.Assert.*;

public class StringProcessorTest {

    @Test
    public void repeat() {
        String actual = StringProcessor.repeat("q", 3);
        assertEquals("qqq", actual);

        actual = StringProcessor.repeat("", 10);
        assertEquals("", actual);
    }

    @Test
    public void numSub() {
        int actual = StringProcessor.numSub("привет, какак у вас дела? как?", "как");
        assertEquals(3, actual);

        actual = StringProcessor.numSub("", "123");
        assertEquals(0, actual);

        actual = StringProcessor.numSub("qwerty", "");
        assertEquals(7, actual);

        actual = StringProcessor.numSub("qazwsx edc rf 123", "0");
        assertEquals(0, actual);
    }

    @Test
    public void replaceNum() {
        String actual = StringProcessor.replaceNum("23 1");
        assertEquals("дватри один", actual);

        actual = " oijiojwearfj  ael";
        StringProcessor.replaceNum(actual);
        assertEquals(" oijiojwearfj  ael", actual);
    }

    @Test
    public void removeChet() {
        StringBuilder actual = new StringBuilder("1234567890");
        StringProcessor.removeChet(actual);
        assertEquals("24680", actual.toString());
    }

    @Test
    public void replaceWord(){
        StringBuilder actual = new StringBuilder("раму мыла Маму");
        StringProcessor.replaceWord(actual);
        assertEquals("Маму мыла раму", actual.toString());
        actual = new StringBuilder("   покушать принёс тебе Я   ");
        StringProcessor.replaceWord(actual);
        assertEquals("   Я принёс тебе покушать   ", actual.toString());
    }
}