import org.jetbrains.annotations.Contract;

import java.util.Objects;

public class SquareTrinomial {
    private double a, b, c;

    public SquareTrinomial(double a, double b, double c) {
        this.setA(a);
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        if (a == 0)
            throw new IllegalArgumentException("Это не квадратный многочлен!");
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    public double[] solve() {
        double d = b * b - 4 * a * c;
        if (d < 0)
            return null;
        double[] otv = new double[2];
        otv[0] = (-b + Math.sqrt(d)) / (2 * a);
        otv[1] = (-b - Math.sqrt(d)) / (2 * a);
        return otv;
    }

    @Override
    public String toString() {
        return a + "x^2 + " + b + "x + " + c;
    }

    @Contract(value = "null -> false", pure = true)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SquareTrinomial that = (SquareTrinomial) o;
        return a == that.a &&
                b == that.b &&
                c == that.c;
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b, c);
    }
}