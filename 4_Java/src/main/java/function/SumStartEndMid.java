package function;

import org.jetbrains.annotations.NotNull;

public class SumStartEndMid implements IFunctional<IFuncOneArg> {
    private double a, b;
    public SumStartEndMid(double a, double b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public double solve(@NotNull IFuncOneArg f) {
        if (f.getInf() > a || f.getSup() < b)
            throw new IllegalArgumentException("Границы отрезка функции не входят в область функционала!");

        return f.solve(f.getInf()) +
                f.solve(f.getSup()) +
                f.solve((f.getInf() + f.getSup()) / 2);
    }
}