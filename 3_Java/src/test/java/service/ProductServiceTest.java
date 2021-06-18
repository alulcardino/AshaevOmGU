package service;

import interfaces.IncludesFilter;
import product.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProductServiceTest {

    @Test
    public void countByFilterTest(){
        Pack pack = new Pack("simple pack ", 1);
        PackCashGoods packProduct1 = new PackCashGoods(new CashGoods("orange pickle","weird pickle"),2, pack);
        PackCashGoods packProduct2 = new PackCashGoods(new CashGoods("gray pickle","weird pickle"),2, pack);
        PackCashGoods packProduct3 = new PackCashGoods(new CashGoods("pink pickle","weird pickle"),2, pack);
        PackCashGoods packProduct4 = new PackCashGoods(new CashGoods("ice cream","yummy ice cream "),2, pack);
        PackCashGoods packProduct5 = new PackCashGoods(new CashGoods("cool pickle","weird pickle"),2, pack);

        PackagedGoods packaged = new PackagedGoods(pack,"pickle box","big box pickle",packProduct1,packProduct2,packProduct3,packProduct5);
        PackagedGoods package2 = new PackagedGoods(pack,"big box pickle box","something yummy",packaged,packProduct2);
        Consignment consignment = new Consignment(package2,packProduct1,packProduct2,packProduct3,packProduct4,packProduct5);
        assertEquals(5,ProductService.countByFilter(consignment,new IncludesFilter("pickle")));
    }

    @Test
    public void countByFilterTestOnEmptyConsigment(){
        Consignment consignment = new Consignment();
        assertEquals(0,ProductService.countByFilter(consignment,new IncludesFilter("pickle")));

    }

    @Test
    public void countByFilterDeepTest(){

        Pack pack = new Pack("simple pack ", 1);
        PackCashGoods packProduct1 = new PackCashGoods(new CashGoods("orange pickle","weird pickle"),2, pack);
        PackCashGoods packProduct2 = new PackCashGoods( new CashGoods("pink pickle","weird pickle"),2, pack);
        PackCashGoods packProduct3 = new PackCashGoods(new CashGoods("ice cream","yummy ice cream "),2, pack);
        PackCashGoods packProduct4=new PackCashGoods(new CashGoods("blee pickle","simple pickle"),2,pack);
        PackCashGoods packProduct5 =new PackCashGoods(new CashGoods("simple pickle","simple pickle"),2,pack);


        PackagedGoods packaged = new PackagedGoods(pack,"pickle box","big box pickle",packProduct3,packProduct1,packProduct2);
        PackagedGoods package2 = new PackagedGoods(pack,"big box pickle box","something yummy",packaged,packProduct4);
        Consignment consignment = new Consignment(package2,packaged,packProduct5);
        assertEquals(3,ProductService.countByFilterDeep(consignment,new IncludesFilter("pickle")));
    }

    @Test
    public  void checkAllWeightTestTrue(){
        Pack pack = new Pack("simple pack ", 1);
        PackCashGoods packProduct1 = new PackCashGoods(new CashGoods("orange pickle","weird pickle"),2, pack);
        PackCashGoods packProduct2 = new PackCashGoods( new CashGoods("pink pickle","weird pickle"),2, pack);
        PackCashGoods packProduct3 = new PackCashGoods(new CashGoods("ice cream","yummy ice cream "),2, pack);
        PackCashGoods packProduct4=new PackCashGoods(new CashGoods("blee pickle","simple pickle"),2,pack);
        PackCashGoods packProduct5 =new PackCashGoods(new CashGoods("simple pickle","simple pickle"),2,pack);


        Consignment consignment = new Consignment(packProduct1,packProduct2,packProduct5);
        assertTrue(ProductService.checkAllWeighted(consignment));

    }

    @Test
    public  void checkAllWeightTestFalse(){
        Pack pack = new Pack("simple pack ", 1);
        PackCashGoods packProduct1 = new PackCashGoods(new CashGoods("orange pickle","weird pickle"),2, pack);
        PackCashGoods packProduct2 = new PackCashGoods( new CashGoods("pink pickle","weird pickle"),2, pack);
        PackCashGoods packProduct5 =new PackCashGoods(new CashGoods("simple pickle","simple pickle"),2,pack);
        PackPieceGoods packProduct4 = new PackPieceGoods(new PieceGoods("keyboard","cool keyboard",12),2,pack);

        Consignment consignment = new Consignment(packProduct1,packProduct2,packProduct5,packProduct4);
        assertFalse(ProductService.checkAllWeighted(consignment));
    }

    @Test
    public  void checkAllWeightTestEmptyConsigment(){
        Consignment consignment = new Consignment();
        assertTrue(ProductService.checkAllWeighted(consignment));
    }
}
