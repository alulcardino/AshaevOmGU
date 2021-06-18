package function;

import org.jetbrains.annotations.NotNull;

public class Integral implements IFunctional<IFuncOneArg> {
    private double a, b;
    private final double EPS = 1E-9;
    private final int INIT_NUM_PART = 16;
    private final int MULTIPLIER = 2;

    public Integral(double a, double b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public double solve(@NotNull IFuncOneArg f) {
        if (f.getInf() > a || f.getSup() < b)
            throw new IllegalArgumentException("Границы отрезка функции не входят в область интеграла!");

        if (f instanceof FuncAxBCxD) {
            double x = -((FuncAxBCxD) f).getD() / ((FuncAxBCxD) f).getC();
            if (x > a && x < b)
                throw new IllegalArgumentException("Плохо!");
        }

        double I, I2;
        double accur = EPS + 1;
        int split = INIT_NUM_PART;

        I = loopIntegral(f, split);
        while (accur > EPS) {
            split *= MULTIPLIER;
            I2 = loopIntegral(f, split);

            //accur = Math.abs(I2 - I);
            //I = I2;
            I = I2 + (I2 - I) / (Math.pow(MULTIPLIER, 2) - 1);      // Поправка Ромберга
            accur = Math.abs(I2 - I) * 3;                           // Критерий Рунге
        }
        return I;
    }

    private double loopIntegral(IFuncOneArg f, int split) {
        double Integ = 0;
        double h = Math.abs(b - a) / (double) split;
        for (int i = 0; i < split; i++) {
            Integ += f.solve(a + i * h + h / 2);
        }
        return Integ * h;
    }
}