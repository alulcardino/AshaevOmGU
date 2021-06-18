package house_data;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Flat implements Serializable {
    private final int number;
    private final int area;
    private final List<Person> owners;

    public Flat(int number, int area, Person... owners) {
        if (number < 0 || area < 0)
            throw new IllegalArgumentException("Некорректные данные квартиры!");
        this.number = number;
        this.area = area;
        this.owners = Arrays.asList(owners);
    }

    public int getNumber() {
        return number;
    }

    public int getArea() {
        return area;
    }

    public List<Person> getOwners() {
        return owners;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flat flat = (Flat) o;
        return number == flat.number &&
                area == flat.area &&
                Objects.equals(owners, flat.owners);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, area, owners);
    }

    @Override
    public String toString() {
        return "Flat{" +
                "number=" + number +
                ", area=" + area +
                ", owners=" + owners +
                '}';
    }
}