package product;

import java.util.Objects;

public class PackPieceGoods extends PieceGoods implements Packed {
    private Pack pack;
    private Integer amount;

    public PackPieceGoods(PieceGoods goods, Integer amount, Pack pack) {
        super(goods);
        if (amount < 0)
            throw new IllegalArgumentException("Количество штучного товара не может быть меньше 0");
        this.amount = amount;
        this.pack = pack;
    }

    @Override
    public int getNetMass() {
        return this.amount * super.getNetMass();
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
        PackPieceGoods that = (PackPieceGoods) o;
        return Objects.equals(pack, that.pack) &&
                Objects.equals(amount, that.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), pack, amount);
    }

    @Override
    public String toString() {
        return "PackPieceGoods{" +
                "pack=" + pack +
                ", amount=" + amount +
                ", weight=" + super.getNetMass() +
                '}';
    }
}