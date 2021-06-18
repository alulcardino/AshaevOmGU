import org.junit.Test;

import static org.junit.Assert.*;

public class MaxRootTest {

    private static final double DELTA = 1e-9;

    @Test
    public void NormMaxRoot() {
        MaxRoot mr = new MaxRoot(new SquareTrinomial(1, 5, 6));
        assertEquals(-2, mr.get(), DELTA);
    }

    @Test(expected = IllegalArgumentException.class)
    public void FailMaxRoot() {
        MaxRoot mr = new MaxRoot(new SquareTrinomial(1.0, 2.0, 3.0));
        mr.get();
    }
}