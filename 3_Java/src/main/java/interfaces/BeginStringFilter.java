package interfaces;

import org.jetbrains.annotations.NotNull;

public class BeginStringFilter implements Filter {
    private String pattern;

    public BeginStringFilter(@NotNull String pattern){
        if(pattern.trim().equals(""))
            throw new IllegalArgumentException("Шаблон не может быть пустым!");
        this.pattern = pattern;
    }

    public boolean apply(@NotNull String str){
        return str.startsWith(pattern);
    }
}