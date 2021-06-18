package product;

import org.junit.Test;

public class CashGoodsTest {
    @Test(expected = IllegalArgumentException.class)
    public  void constructorTest(){
       CashGoods object = new CashGoods("","");

    }
}
