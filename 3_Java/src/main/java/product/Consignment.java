package product;

import java.util.Arrays;

public class Consignment {
    private Packed[] set;

    public Consignment(Packed... set) {
        this.set = set;
    }

    public int TotalWeight() {
        int sum = 0;
        for (Packed p : set) {
            sum += p.getGrossMass();
        }
        return sum;
    }

    public Product getProduct(int indx){
        return (Product)set[indx];
    }

    public int getCount(){
        return set.length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Consignment that = (Consignment) o;
        return Arrays.equals(set, that.set);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(set);
    }

    @Override
    public String toString() {
        return "Consignment{" +
                "set=" + Arrays.toString(set) +
                '}';
    }
}