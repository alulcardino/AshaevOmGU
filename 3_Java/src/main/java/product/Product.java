package product;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import java.util.Objects;

public class Product {
    private String name;
    private String descrip;

    public Product(@NotNull String name, String descrip) {
        if (name.trim().equals(""))
            throw new IllegalArgumentException("Имя упаковки не может быть пустым!");
        if (descrip.trim().equals(""))
            throw new IllegalArgumentException("Описание упаковки не может быть пустым!");
        this.name = name;
        this.descrip = descrip;
    }

    @Contract(pure = true)
    public Product(@NotNull Product that) {
        this.name = that.name;
        this.descrip = that.descrip;
    }

    public String getName() {
        return name;
    }

    public String getDescrip() {
        return descrip;
    }

    public int getNetMass(){
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name) &&
                Objects.equals(descrip, product.descrip);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, descrip);
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", descrip='" + descrip + '\'' +
                '}';
    }
}