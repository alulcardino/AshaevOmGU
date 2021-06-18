package house_data;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class House implements Serializable {
    private final String cadastralNum;
    private final String address;
    private final Person housewife;
    private final List<Flat> apartments;

    public House(String cadastralNum, String address, Person housewife, Flat... apartments) {
        this.cadastralNum = cadastralNum;
        this.address = address;
        this.housewife = housewife;
        this.apartments = Arrays.asList(apartments);
    }

    public String getCadastralNum() {
        return cadastralNum;
    }

    public String getAddress() {
        return address;
    }

    public Person getHousewife() {
        return housewife;
    }

    public List<Flat> getApartments() {
        return apartments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        House house = (House) o;
        return Objects.equals(cadastralNum, house.cadastralNum) &&
                Objects.equals(address, house.address) &&
                Objects.equals(housewife, house.housewife) &&
                Objects.equals(apartments, house.apartments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cadastralNum, address, housewife, apartments);
    }

    @Override
    public String toString() {
        return "House{" +
                "cadastralNum='" + cadastralNum + '\'' +
                ", address='" + address + '\'' +
                ", housewife=" + housewife +
                ", apartments=" + apartments +
                '}';
    }
}