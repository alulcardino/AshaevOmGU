package data;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class DataTest {

    @Test
    public void setNameTest() {
        Data d = new Data("JoJo");
        assertEquals("JoJo", d.getName());
        d.setName("GoGo");
        assertEquals("GoGo", d.getName());
    }

    @Test
    public void setGroupsTest() {
        Data d = new Data("JoJo",
                new Group(1, 1, 2, 3),
                new Group(2, 4, 5),
                new Group(3, 6));

        assertArrayEquals(new Group[]{
                new Group(1, 1, 2, 3),
                new Group(2, 4, 5),
                new Group(3, 6)}, d.getGroups());

        d.setGroups(new Group(4, 0));
        assertArrayEquals(new Group[]{new Group(4, 0)}, d.getGroups());
    }

    @Test
    public void lengthTest() {
        Data d = new Data("JoJo",
                new Group(1, 1, 2, 3),
                new Group(2, 4, 5),
                new Group(3, 6));
        assertEquals(3, d.length());
    }

    @Test
    public void getAllTest() {
        List<Integer> otv = new ArrayList<>(10);
        for (Integer i = 1; i < 10; i++) {
            otv.add(i);
        }
        otv.add(0);

        assertEquals(otv,
                DataDemo.getAll(new Data("Name",
                        new Group(66, 1, 2, 3),
                        new Group(77, 4, 5),
                        new Group(88, 6, 7, 8, 9),
                        new Group(99, 0))));
    }
}