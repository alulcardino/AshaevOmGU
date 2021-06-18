package product;

public class CashGoods extends Product {

    public CashGoods(String name, String descrip) {
        super(name, descrip);
    }

    public CashGoods(CashGoods that) {
        super(that);
    }

    @Override
    public int getNetMass() {
        return 0;
    }

    @Override
    public String toString() {
        return "CashGoods{" +
                super.toString() +
                "}";
    }
}