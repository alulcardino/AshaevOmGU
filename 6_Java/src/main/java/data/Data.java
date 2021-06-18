package data;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

public class Data implements Iterable<Integer> {
    private String name;
    private Group[] groups;

    public Data(String name, Group... groups) {
        this.name = name;
        this.groups = groups;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Group[] getGroups() {
        return groups;
    }

    public void setGroups(Group... groups) {
        this.groups = groups;
    }

    public int length() {
        return groups.length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Data data = (Data) o;
        return Objects.equals(name, data.name) &&
                Arrays.equals(groups, data.groups);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name);
        result = 31 * result + Arrays.hashCode(groups);
        return result;
    }

    @Override
    public String toString() {
        return "Data{" +
                "name='" + name + '\'' +
                ", groups=" + Arrays.toString(groups) +
                '}';
    }

    @NotNull
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            private int i = 0, j = 0;

            @Override
            public boolean hasNext() {
                return i < groups.length && j < groups[i].length();
            }

            @Override
            public Integer next() {
                Integer out = groups[i].getData()[j];
                if (++j == groups[i].getData().length) {
                    j = 0;
                    i++;
                }
                return out;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
}