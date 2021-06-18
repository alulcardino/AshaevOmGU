package product;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorDemo {
    public static void sortGoods(Product[] goods, Comparator<Product> cmp) {
        Arrays.sort(goods, cmp);
    }
}