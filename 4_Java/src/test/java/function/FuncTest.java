package function;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class FuncTest {

    @Test
    public void FuncNorm() {
        FuncAsinBx sin = new FuncAsinBx(1, 1, 5, -5);
        assertEquals(1, sin.solve(1.5708), 1E-5); // 90 градусов
    }

    @Test(expected = IllegalArgumentException.class)
    public void FuncFail_Arg() {
        FuncAsinBx sin = new FuncAsinBx(1, 1, 10, 2);
        sin.solve(1.5708);
    }

    @Test(expected = IllegalArgumentException.class)
    public void FuncFail_OOF() {
        FuncAsinBx sin = new FuncAsinBx(1, 1, -10, 5);
    }

    @Test
    public void Integral_1() {
        Integral i = new Integral(0, 1);
        assertEquals(1.7182818284, i.solve(new FuncAexpxB(1, 0, 1, 0)), 1E-5);
    }

    @Test
    public void Integral_2() {
        Integral i = new Integral(-10, 10);
        assertEquals(0.0, i.solve(new FuncAsinBx(5, 3, 100, -100)), 1E-5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void Integral_fail() {
        Integral i = new Integral(-10, 10);
        i.solve(new FuncAxB(5, 3, 5, -5));
    }

    @Test
    public void SumStartEndMid_1() {
        SumStartEndMid i = new SumStartEndMid(-10, 10);
        assertEquals(6.0, i.solve(new FuncAxBCxD(4, 10, 2, 5, 20, -20)), 1E-5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void integralRatio() {
        Integral i = new Integral(-2, 0);
        i.solve(new FuncAxBCxD(4, 10, 2, 2, 20, -20));
    }

    @Test
    public void SumStartEndMid_2() {
        SumStartEndMid i = new SumStartEndMid(-10, 10);
        assertEquals(0.0, i.solve(new FuncAsinBx(-5, 10, 20, -20)), 1E-5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void SumStartEndMid_fail() {
        SumStartEndMid i = new SumStartEndMid(-10, 100);
        assertNotNull(i);
        i.solve(new FuncAxBCxD(4, 10, 2, 5, 20, -20));
    }
}