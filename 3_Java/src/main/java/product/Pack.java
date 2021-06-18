package product;

import org.jetbrains.annotations.NotNull;
import java.util.Objects;

public class Pack {
    private String descrip;
    private Integer weight;

    public Pack(@NotNull String descrip, Integer weight) {
        if (descrip.trim().equals(""))
            throw new IllegalArgumentException("Описание упаковки не может быть пустым!");
        if (weight < 0)
            throw new IllegalArgumentException("Масса упаковки не может быть меньше 0!");
        this.descrip = descrip;
        this.weight = weight;
    }

    public String GetDescrip() {
        return descrip;
    }

    public Integer GetWeight() {
        return weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pack pack = (Pack) o;
        return Objects.equals(descrip, pack.descrip) &&
                Objects.equals(weight, pack.weight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(descrip, weight);
    }

    @Override
    public String toString() {
        return "Pack{" +
                "descrip='" + descrip + '\'' +
                ", weight=" + weight +
                '}';
    }
}