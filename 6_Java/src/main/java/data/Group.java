package data;

import java.util.Arrays;
import java.util.Objects;

public class Group {
    private Integer id;
    private Integer[] data;

    public Group(Integer id, Integer... data) {
        this.id = id;
        this.data = data;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer[] getData() {
        return data;
    }

    public void setData(Integer... data) {
        this.data = data;
    }

    public int length() {
        return data.length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return Objects.equals(id, group.id) &&
                Arrays.equals(data, group.data);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id);
        result = 31 * result + Arrays.hashCode(data);
        return result;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", data=" + Arrays.toString(data) +
                '}';
    }
}