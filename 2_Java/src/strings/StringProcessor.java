package strings;

public class StringProcessor {

    public static String repeat(String str, int N) {
        if(N<0)
            throw new IllegalArgumentException("плохо!");
        if (N == 0) {
            return "";
        } else {
            StringBuilder out = new StringBuilder(str.length() * N);
            for (int i = 0; i < N; i++) {
                out.append(str);
            }
            return out.toString();
        }
    }

    public static int numSub(String str, String sub) {
        if (str.length() < sub.length() || sub.equals(""))
            return 0;
        int num = 0;
        int c = 0;
        boolean flag = true;
        for (int i = 0; i <= str.length() - sub.length(); i++) {
            for (int j = 0; j < sub.length(); j++) {
                if (str.charAt(j + c) != sub.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                num++;
            flag = true;
            c++;
        }
        return num;
    }

    public static String replaceNum(String str) {
        StringBuilder out = new StringBuilder(str);
        for (int i = 0; i < out.length(); i++) {
            switch (out.charAt(i)) {
                case '1':
                    out.replace(i, i + 1, "один");
                    break;
                case '2':
                    out.replace(i, i + 1, "два");
                    break;
                case '3':
                    out.replace(i, i + 1, "три");
                    break;
            }
        }
        return out.toString();
    }

    public static void removeChet(StringBuilder strb) {
        for (int i = 1; i < strb.length(); i++) {
            strb.deleteCharAt(i);
        }
    }

    public static void replaceWord(StringBuilder strb) {
        String[] words = strb.toString().split("");
        int countWords = 0;
        for(String word : words)
        {
            if(!word.equals(""))
                countWords++;
        }
        if(countWords<2)
            return;
        int indxStart = 0, indxEnd = 0;     // Индексы начала первого и последнего слов
        StringBuilder wordStart = new StringBuilder();
        StringBuilder wordEnd = new StringBuilder();
        boolean flag = false;
        for (int i = 0; i < strb.length(); i++) {
            if (Character.isLetter(strb.charAt(i))) {
                indxStart = i;
                wordStart.append(strb.charAt(i));
                flag = true;
            } else if (flag)
                break;
        }
        indxStart -= (wordStart.length() - 1);

        flag = false;
        for (int i = strb.length() - 1; i >= 0; i--) {
            if (Character.isLetter(strb.charAt(i))) {
                indxEnd = i;
                wordEnd.append(strb.charAt(i));
                flag = true;
            } else if (flag)
                break;
        }
        wordEnd.reverse();
        // Заменяем с конца, чтоб не сбить индексы
        strb.replace(indxEnd, indxEnd + wordEnd.length(), wordStart.toString());
        strb.replace(indxStart, indxStart + wordStart.length(), wordEnd.toString());
    }


}