package product;

import org.junit.Test;

import java.util.Comparator;

import static org.junit.Assert.assertArrayEquals;

public class ComparatorDemoTest {

    @Test
    public void sortGoods() {

        Pack pack = new Pack("simple pack ", 1);
        PackCashGoods packProduct1 = new PackCashGoods(new CashGoods("orange pickle", "weird pickle"), 2, pack);
        PackPieceGoods packProduct2 = new PackPieceGoods(new PieceGoods("gray pickle", "weird pickle", 1), 2, pack);
        CashGoods product3 = new CashGoods("pickle box", "weird pickle");
        PieceGoods product4 = new PieceGoods("ice cream", "yummy ice cream ", 1);
        PackagedGoods packaged5 = new PackagedGoods(pack, "pickle box", "big box pickle", packProduct1, packProduct2);

        Product[] array = new Product[]{packProduct1, packProduct2, product3, product4, packaged5};
        ComparatorDemo.sortGoods(array, new ProductComparator());
        // Легче написать так:
        // ComparatorDemo.sortGoods(array, Comparator.comparing(Product::getName).thenComparing(Product::getDescrip));

        assertArrayEquals(new Product[]{packProduct2, product4, packProduct1, packaged5, product3}, array);
    }
}