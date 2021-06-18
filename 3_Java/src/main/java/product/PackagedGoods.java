package product;

import java.util.Arrays;
import java.util.Objects;

public class PackagedGoods extends Product implements Packed {
    private Pack pack;
    private Packed[] set;

    public PackagedGoods(Pack pack, String name, String descrip, Packed... set) {
        super(name, descrip);
        this.pack = pack;
        this.set = set;
    }

    public Product getProduct(int indx){
        return (Product)set[indx];
    }

    public int getCount(){
        return set.length;
    }

    @Override
    public int getNetMass() {
        int sum = 0;
        for (Packed p : set) {
            sum += p.getGrossMass();
        }
        return sum;
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
        PackagedGoods that = (PackagedGoods) o;
        return Objects.equals(pack, that.pack) &&
                Arrays.equals(set, that.set);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(super.hashCode(), pack);
        result = 31 * result + Arrays.hashCode(set);
        return result;
    }

    @Override
    public String toString() {
        return "PackagedGoods{" +
                "pack=" + pack +
                ", set=" + Arrays.toString(set) +
                '}';
    }
}