package strings;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;
import static strings.StringProcessor.*;

public class StrProcessorTestJA {
    @DataProvider
    public static Object[][] data() {
        return new Object[][]{
                {"N", 3, "NNN"},
                {"qwe", 3, "qweqweqwe"},
                {"", 3, ""},
                {"", 0, ""}
        };
    }

    @DataProvider
    public static Object[][] countData() {
        return new Object[][]{
                {"a", "a", 1},
                {"aa", "a", 2},
                {"aaa", "aa", 2},
                {"", "aaa", 0},
                {"", "", 0},
                {"asdf", "", 0},
                {"aaaa", "vvv", 0},
                {"aeqra facwda", "a", 4}
        };
    }

    @DataProvider
    public static Object[][] onetwothreeData() {
        return new Object[][]{
                {"", ""},
                {"567890", "567890"},
                {"  1 ", "  один "},
                {" 2", " два"},
                {"1 2 3", "один два три"}
        };
    }

    @DataProvider
    public static Object[][] changeWords() {
        return new Object[][]{
                {"", ""},
                {" qq ", " qq "},
                {"   123 erty 11 ", "   123 erty 11 "},
                {"   abc er22ty efgh ", "   efgh er22ty abc "}
        };
    }
    @DataProvider
    public static Object[][] changeAge() {
        return new Object[][]{
                {"Васе 0x00000010 лет", "Васе 16 лет"},
                {"Васе 0x00000010 лет, Андрею 0x00000011 лет", "Васе 16 лет, Андрею 17 лет"},
                {"Васе 16 лет", "Васе 16 лет"}
        };
    }

    @Test(dataProvider = "data")
    public void testCopy(String str, int N, String expected) {
        assertEquals(repeat(str, N), expected);
    }

    @Test(expectedExceptions = {IllegalArgumentException.class})
    public void testCopyExc() throws IllegalArgumentException {
        repeat("qwe", -6);
        fail();
    }

    @Test(dataProvider = "countData")
    public void testFind(String big, String small, int expected) {
        assertEquals(numSub(big, small), expected);
    }

//    @Test(expectedExceptions = { BadSizeLes2.class})
//    public void testFindExc() throws BadSizeLes2 {
//        numSub("", "gdywu");
//        fail();
//    }

    @Test(dataProvider = "onetwothreeData")
    public void testChange(String source, String expected) {

        assertEquals(replaceNum(source), expected);
    }

    @Test
    public void testChange2() {
        StringBuilder  builder = new StringBuilder("1234567");
        removeChet(builder);
        assertEquals(builder.toString(), "1357");
        removeChet(builder);
        assertEquals(builder.toString(), "15");
        removeChet(builder);
        assertEquals(builder.toString(), "1");
        removeChet(builder);
        assertEquals(builder.toString(), "1");
    }

    @Test(dataProvider = "changeWords")
    public void testChange3(String source, String expected)
    {
        StringBuilder builder =  new StringBuilder(source);
        replaceWord(builder);

        assertEquals(builder.toString(), expected);
    }

    @Test(dataProvider = "changeAge", enabled = false)
    public void testChange4(String source, String expected) {
        assertEquals((source), expected);
    }

}