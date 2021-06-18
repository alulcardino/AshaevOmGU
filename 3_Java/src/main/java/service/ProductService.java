package service;

import interfaces.Filter;
import product.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import java.util.function.Predicate;

public class ProductService {

    public static int countByFilter(@NotNull Consignment party, Filter filter) {
        int sum = 0;
        for (int i = 0; i < party.getCount(); i++) {
            if (filter.apply(party.getProduct(i).getName()))
                sum++;
        }
        return sum;
    }

    public static int countByFilterDeep(@NotNull Consignment party, Filter filter) {
        int sum = 0;
        Predicate<Product> lambda = x -> filter.apply(x.getName());
        for (int i = 0; i < party.getCount(); i++) {
            Product curProd = party.getProduct(i);
            if (lambda.test(curProd))
                sum++;
            else if (curProd.getClass().getSimpleName().equals("PackagedGoods")) {
                if (depthWalk((PackagedGoods) curProd, lambda) != null)
                    sum++;
            }
        }
        return sum;
    }

    public static boolean checkAllWeighted(@NotNull Consignment party) {
        Predicate<Product> lambda = x -> x.getClass().getSimpleName().equals("PackCashGoods");
        for (int i = 0; i < party.getCount(); i++) {
            Product curProd = party.getProduct(i);
            if (!lambda.test(curProd))
                return false;
            if (curProd.getClass().getSimpleName().equals("PackagedGoods")) {
                if (depthWalk((PackagedGoods) curProd, lambda) == null)
                    return false;
            }
        }
        return true;
    }

    @Nullable
    private static Product depthWalk(@NotNull PackagedGoods packProd, Predicate<Product> lambda) {
        for (int i = 0; i < packProd.getCount(); i++) {
            Product curProd = packProd.getProduct(i);
            if (lambda.test(curProd))
                return curProd;
            if (curProd.getClass() == packProd.getClass())
                depthWalk((PackagedGoods) curProd, lambda);
        }
        return null;
    }
}