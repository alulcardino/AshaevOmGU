package product;

import org.junit.Test;

public class PackCashGoodsTest {
    @Test(expected = IllegalArgumentException.class)
    public void constructorTest(){
        Pack pack = new Pack("cool",15);
        CashGoods cash = new CashGoods("something","cool");
        PackCashGoods object = new PackCashGoods(cash,-12,pack);


    }
}
