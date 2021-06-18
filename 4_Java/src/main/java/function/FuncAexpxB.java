package function;

import org.jetbrains.annotations.Contract;

public class FuncAexpxB implements IFuncOneArg {
    private double a, b, sup, inf;

    @Contract(pure = true)
    FuncAexpxB(double a, double b, double sup, double inf) {
        this.a = a;
        this.b = b;
        if (sup < inf)
            throw new IllegalArgumentException("Нижняя граница больше верхней!");
        this.sup = sup;
        this.inf = inf;
    }

    @Override
    public double solve(double arg) {
        if (arg < inf || arg > sup)
            throw new IllegalArgumentException("Аргумент не входит в область определения функции!");
        return a * Math.exp(arg) + b;
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
