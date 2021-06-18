package imit;

import org.junit.Ignore;
import org.junit.Test;

import static imit.Work_with_Arrays.sum;
import static org.junit.Assert.*;

public class Work_with_ArraysTest {

//    @Test
//    public void testShow() {
//
//    }

//    @Test
//    public void input() {
//
//    }

    @Test
    public void testSum() {
        int[] array = {1,2,3,4,0};
        long actual = sum(array);
        assertEquals(10, actual);
    }


    @Ignore
    @Test
    public void chetCount() {
    }

    @Ignore
    @Test
    public void ab() {
    }

    @Test(expected = IllegalArgumentException.class)
    public void plus() {
        Vector3DArray array = new Vector3DArray(2);
        array.replace(new Vector3D(1,2,3), 0);
        array.replace(new Vector3D(1,0,3), 1);
//        Vector3D expected = new Vector3D(2,2,6);
        Vector3D actual = array.linComb(new double[]{0.0, 1.0, 2.0});
    }

    @Test
    public void rev() {
    }
}