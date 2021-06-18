package interfaces;

import org.jetbrains.annotations.NotNull;

public class ContainsLettersFilter implements Filter {
    private String pattern;

    public ContainsLettersFilter(@NotNull String pattern) {
        if (pattern.trim().equals(""))
            throw new IllegalArgumentException("Шаблон не может быть пустым!");
        this.pattern = pattern;
    }

    public boolean apply(@NotNull String str) {
        char[] letters = pattern.toCharArray();
        for (char l : letters) {
            if (str.indexOf(l) == -1)
                return false;
        }
        return true;
    }
}