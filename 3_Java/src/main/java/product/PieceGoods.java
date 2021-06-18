package product;

import java.util.Objects;

public class PieceGoods extends Product {
    private Integer weight;

    public PieceGoods(String name, String descrip, Integer weight) {
        super(name, descrip);
        this.weight = weight;
    }

    public PieceGoods(PieceGoods that) {
        super(that);
        this.weight = that.weight;
    }

    @Override
    public int getNetMass() {
        return this.weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PieceGoods that = (PieceGoods) o;
        return Objects.equals(weight, that.weight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), weight);
    }

    @Override
    public String toString() {
        return "PieceGoods{" +
                super.toString() +
                ", weight=" + weight +
                '}';
    }
}