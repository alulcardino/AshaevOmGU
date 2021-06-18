package interfaces;

import org.jetbrains.annotations.NotNull;

public class IncludesFilter implements Filter{
    private String pattern;

    public IncludesFilter(@NotNull String pattern){
        if(pattern.trim().equals(""))
            throw new IllegalArgumentException("Шаблон не может быть пустым!");
        this.pattern = pattern;
    }

    public boolean apply(@NotNull String str){
        return str.contains(pattern);
    }
}