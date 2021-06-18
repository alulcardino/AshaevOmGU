package product;

import org.jetbrains.annotations.NotNull;

import java.util.Comparator;

public class ProductComparator implements Comparator<Product> {
    @Override
    public int compare(@NotNull Product t1, @NotNull Product t2) {
        int firstComp = t1.getName().compareTo(t2.getName());
        return firstComp == 0 ? t1.getDescrip().compareTo(t2.getDescrip()) : firstComp;
    }
}