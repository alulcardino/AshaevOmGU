package product;

import org.junit.Test;

public class PackPieceGoodsTest {
    @Test(expected = IllegalArgumentException.class)
    public  void constructorTest(){
        Pack pack = new Pack("cool",15);
        PieceGoods goods = new PieceGoods("box","cool",15);
        PackPieceGoods object = new PackPieceGoods(goods,-12,pack);


    }
}
