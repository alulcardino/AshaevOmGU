package function;

import org.jetbrains.annotations.Contract;

public class FuncAxBCxD implements IFuncOneArg {
    private double a, b, c, d, sup, inf;

    @Contract(pure = true)
    FuncAxBCxD(double a, double b, double c, double d, double sup, double inf) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        if (sup < inf)
            throw new IllegalArgumentException("Нижняя граница больше верхней!");
        this.sup = sup;
        this.inf = inf;
    }

    @Override
    public double solve(double arg) {
        if (arg < inf || arg > sup)
            throw new IllegalArgumentException("Аргумент не входит в область определения функции!");
        double den = c * arg + d;
        if (Double.compare(den, 0.0) == 0)
            throw new IllegalArgumentException("Деление на 0!");
        return (a * arg + b) / den;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public double getD() {
        return d;
    }

    @Override
    public double getSup() {
        return sup;
    }

    @Override
    public double getInf() {
        return inf;
    }
}
