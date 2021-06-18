package function;

public interface IFunctional<T extends IFuncOneArg> {
    double solve(T arg);
}