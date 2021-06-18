package collections;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class PhoneBook {
    private Map<String, Human> map;

    public PhoneBook() {
        this.map = new HashMap<>();
    }

    public void add(@NotNull Human per, @NotNull String phone){
        map.put(phone, per);
    }

    public void removePhone(@NotNull Human per, @NotNull String phone){
        map.remove(phone, per);
    }

    public List<String> getListPhoneByPerson(@NotNull Human per){
        List<String> out = new ArrayList<>(map.size());
        for (final Map.Entry<String, Human> entry : map.entrySet())
            if(per.equals(entry.getValue()))
                out.add(entry.getKey());
        return out;
    }

    public Human findPersonByPhone(@NotNull String phone){
        return map.get(phone);
    }

    public Map<String, Human> getListPhoneByPerson(@NotNull String prefix){
        Map<String, Human> out = new HashMap<>(map.size());
        for (final Map.Entry<String, Human> entry : map.entrySet())
            if(entry.getKey().startsWith(prefix))
                out.put(entry.getKey(), entry.getValue());
        return out;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhoneBook phoneBook = (PhoneBook) o;
        return Objects.equals(map, phoneBook.map);
    }

    @Override
    public int hashCode() {
        return Objects.hash(map);
    }

    @Override
    public String toString() {
        return "collections.PhoneBook{" +
                "map=" + map +
                '}';
    }
}