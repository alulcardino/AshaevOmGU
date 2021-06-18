package product;

import org.junit.Test;

public class PackageGoodsTest {
    @Test(expected = IllegalArgumentException.class)
    public void constructorTest(){
        PieceGoods object = new PieceGoods("","",-15);

    }
}
