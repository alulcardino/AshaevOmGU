package collections;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class CollectionsDemo {

    @Contract(pure = true)
    public static int qtStrFirstChar(@NotNull List<String> list, char ch) {
        int sum = 0;
        for (String str : list) {
            if (str.charAt(0) == ch)
                sum++;
        }
        return sum;
    }

    @NotNull
    public static List<Human> getNamesakes(@NotNull List<Human> list, @NotNull Human man) {
        List<Human> out = new ArrayList<>(list.size());
        for (Human per : list) {
            if (man.getSurname().equals(per.getSurname())) {
                out.add(new Human(per));
            }
        }
        return out;
    }

    @Contract(pure = true)
    private static <T> boolean isIntersect(@NotNull Set<T> s1, @NotNull Set<T> s2) {
        for (T elem : s1)
            if (s2.contains(elem))
                return true;
        return false;
    }

    @NotNull
    public static List<Set<Integer>> notIntersect(@NotNull List<Set<Integer>> list, @NotNull Set<Integer> inSet) {
        List<Set<Integer>> out = new ArrayList<>(list.size());
        for (Set<Integer> set : list) {
            if (!isIntersect(inSet, set)) {
                out.add(new HashSet<>(set));
            }
        }
        return out;
    }

    @NotNull
    public static Set<Human> maxAge(@NotNull List<? extends Human> list) {
        long maxAge = 0;
        Set<Human> out = new HashSet<>(list.size());
        for (Human per : list) {
            long curAge = per.getDateOfBirth().getTimeInMillis();
            if (curAge == maxAge) {
                out.add(new Human(per));
            } else if (curAge > maxAge) {
                maxAge = curAge;
                out.clear();
                out.add(new Human(per));
            }
        }
        return out;
    }

    @NotNull
    public static <T extends Human> List<Human> getSortList(@NotNull Set<T> set) {
        Set<T> sortedSet = new TreeSet<>(Comparator.comparing(Human::getSurname)
                .thenComparing(Human::getName)
                .thenComparing(Human::getMiddleName));
        sortedSet.addAll(set);
        return new ArrayList<>(sortedSet);
    }

    @NotNull
    public static Set<Human> perIndContains(@NotNull Map<Integer, Human> map, @NotNull Set<Integer> set) {
        Set<Human> out = new HashSet<>(set.size());
        for (Integer index : set) {
            if (map.containsKey(index))
                out.add(map.get(index));
        }
        return out;
    }

    @NotNull
    public static List<Integer> notLess18Years(@NotNull Map<Integer, Human> map) {
        List<Integer> out = new ArrayList<>(map.size());
        //for (collections.Human per : map.values())
        for (final Map.Entry<Integer, Human> entry : map.entrySet())
            if (entry.getValue().getDateOfBirth().get(Calendar.YEAR) >= 18)
                out.add(entry.getKey());
        return out;
    }

    @NotNull
    public static Map<Integer, Integer> idOnAgePerson(@NotNull Map<Integer, Human> map) {
        Map<Integer, Integer> out = new HashMap<>(map.size());
        for (final Map.Entry<Integer, Human> entry : map.entrySet())
            out.put(entry.getKey(), entry.getValue().getDateOfBirth().get(Calendar.YEAR));
        return out;
    }

    @NotNull
    public static Map<Integer, List<Human>> ageOnListPerson(@NotNull Set<Human> set) {
        Map<Integer, List<Human>> out = new HashMap<>(set.size());
        for (Human per : set) {
            Integer curAge = per.dateOfBirth.get(Calendar.YEAR);
            if (out.containsKey(curAge))
                out.get(curAge).add(new Human(per));
            else
                out.put(curAge, new ArrayList<>());
        }
        return out;
    }

    // нет 11 номера
}