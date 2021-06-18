import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNull;

public class SquareTrinomialTest {

    private static final double DELTA = 1e-9;

    @Test
    public void getA() {
        SquareTrinomial sq = new SquareTrinomial(3, 4, 5);
        assertEquals(3, sq.getA(), DELTA);
    }

    @Test
    public void setA() {
        SquareTrinomial sq = new SquareTrinomial(3, 4, 5);
        assertEquals(3, sq.getA(), DELTA);
        sq.setA(-10);
        assertEquals(-10, sq.getA(), DELTA);
    }

    @Test(expected = IllegalArgumentException.class)
    public void solveException() {
        SquareTrinomial obj = new SquareTrinomial(0, 2, 3);
    }

    @Test
    public void solveNull() {
        SquareTrinomial obj = new SquareTrinomial(1, 2, 3);
        assertNull(obj.solve());
    }

    @Test
    public void solveOneRoot() {
        SquareTrinomial obj3 = new SquareTrinomial(1, 4, 4);
        double[] actual = obj3.solve();
        double[] expected = {-2, -2};
        assertArrayEquals(expected, actual, DELTA);
    }

    @Test
    public void solveTwoRoot() {
        SquareTrinomial obj4 = new SquareTrinomial(2, 10, 12);
        double[] actual = obj4.solve();
        double[] expected = {-2, -3};
        assertArrayEquals(expected, actual, DELTA);
    }
}