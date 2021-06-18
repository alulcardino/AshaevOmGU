package objects;

import com.sun.istack.internal.NotNull;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.LinkedList;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class FinanceReportProcessor {

    @NotNull
    public static FinanceReport getStartWith(@NotNull FinanceReport inRep, char first, String name) {
        FinanceReport outRep = new FinanceReport(name);
        for (int i = 0; i < inRep.amountPay(); i++) {
            if (inRep.getPay(i).getFIO().charAt(0) == first)
                outRep.addPay(new Payment(inRep.getPay(i)));
        }
        return outRep;
    }

    @NotNull
    public static FinanceReport getLessThan(@NotNull FinanceReport inRep, int maxSum, String name) {
        FinanceReport outRep = new FinanceReport(name);
        for (int i = 0; i < inRep.amountPay(); i++) {
            if (inRep.getPay(i).getDeposit() < maxSum)
                outRep.addPay(new Payment(inRep.getPay(i)));
        }
        return outRep;
    }

//    BiPredicate<String, Character> getStartWith = (s, ch) -> s.indexOf(ch) == 0;
//
//    @NotNull
//    public static <S, T> FinanceReport get(BiPredicate<S, T> lambda, S args, T arg, @NotNull FinanceReport inRep,  String name) {
//        FinanceReport outRep = new FinanceReport(name);
//        for (int i = 0; i < inRep.amountPay(); i++) {
//            if (lambda.test(args, arg))
//                outRep.addPay(new Payment(inRep.getPay(i)));
//        }
//        return outRep;
//    }

    public static int getSumDepositAtDate(FinanceReport inRep, @NotNull String dmy, String name) {
        String[] strDate = dmy.split("\\.");
        if (strDate.length != 3)
            throw new IllegalArgumentException("Дата должна содержать 3 числа, разделённых точками!");
        int[] date = new int[3];
        for (int i = 0; i < 3; i++) {
            date[i] = Integer.parseInt(strDate[i].trim());
        }
        int sum = 0;
        for (int i = 0; i < inRep.amountPay(); i++) {
            Payment curPay = inRep.getPay(i);
            if (curPay.getDay() == date[0] && curPay.getMonth() == date[1] && curPay.getYear() == date[2])
                sum += curPay.getDeposit();
        }
        return sum;
    }

    @NotNull
    public static List<String> getMonthNoDepAtYear(@NotNull FinanceReport inRep, int year, String name) {
        boolean[] isDepOnMonth = new boolean[12];
        for (int i = 0; i < inRep.amountPay(); i++) {
            Payment curPay = inRep.getPay(i);
            if (curPay.getYear() == year)
                isDepOnMonth[curPay.getMonth() - 1] = true;
        }
        List<String> outMonth = new LinkedList<>();
        for (int i = 0; i < 12; i++) {
            if (!isDepOnMonth[i])
                outMonth.add(strMonth(i + 1));
        }
        return outMonth;
    }

    @NotNull
    @Contract(pure = true)
    private static String strMonth(int indx) {
        switch (indx) {
            case 1:
                return "Январь";
            case 2:
                return "Февраль";
            case 3:
                return "Март";
            case 4:
                return "Апрель";
            case 5:
                return "Май";
            case 6:
                return "Июнь";
            case 7:
                return "Июль";
            case 8:
                return "Август";
            case 9:
                return "Сентябрь";
            case 10:
                return "Октябрь";
            case 11:
                return "Ноябрь";
            case 12:
                return "Декабрь";
            default:
                throw new IllegalArgumentException("Нет такого месяца!");
        }
    }
}