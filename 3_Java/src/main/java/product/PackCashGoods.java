package product;

import java.util.Objects;

public class PackCashGoods extends CashGoods implements Packed {
    private Integer weight;
    private Pack pack;

    public PackCashGoods(CashGoods goods, Integer weight, Pack pack) {
        super(goods);
        if (weight < 0)
            throw new IllegalArgumentException("Вес весового товара не может быть меньше 0");
        this.weight = weight;
        this.pack = pack;
    }

    @Override
    public int getNetMass() {
        return this.weight;
    }

    @Override
    public int getGrossMass() {
        return pack.GetWeight() + this.getNetMass();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PackCashGoods that = (PackCashGoods) o;
        return Objects.equals(weight, that.weight) &&
                Objects.equals(pack, that.pack);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), weight, pack);
    }

    @Override
    public String toString() {
        return "PackCashGoods{" +
                "weight=" + weight +
                ", pack=" + pack +
                '}';
    }
}