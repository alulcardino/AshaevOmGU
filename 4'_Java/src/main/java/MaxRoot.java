import org.jetbrains.annotations.Contract;

public class MaxRoot {
    private SquareTrinomial poly;

    @Contract(pure = true)
    public MaxRoot(SquareTrinomial poly) {
        this.poly = new SquareTrinomial(poly.getA(), poly.getB(), poly.getC() );
    }

    double get() {
        double[] otv = poly.solve();
        if (otv == null)
            throw new IllegalArgumentException("Решений нет!");
        return Math.max(otv[0], otv[1]);
    }
}