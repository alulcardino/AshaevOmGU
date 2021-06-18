package data;

import org.jetbrains.annotations.NotNull;
import java.util.ArrayList;
import java.util.List;

public class DataDemo {

    @NotNull
    public static List<Integer> getAll(@NotNull Data data) {
        List<Integer> out = new ArrayList<>(data.length() * 31);
        for (Integer id : data) {
            out.add(id);
        }
        return out;
    }
}