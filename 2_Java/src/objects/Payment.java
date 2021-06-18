package objects;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import java.util.Objects;

public class Payment {
    private String FIO;
    private int year;
    private int month;
    private int day;
    private long deposit;
    private static int[] dayOfMonth = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    static void checkDeposit(long pay){
        if (pay < 0)
            throw new IllegalArgumentException("Платёж не должен быть отрицательным!");
    }

    static void checkDate(int year, int month, int day){
        if (year < 1970)
            throw new IllegalArgumentException("Год должен быть не меньше 1970");
        if (month < 1 || month > 12)
            throw new IllegalArgumentException("Некорректный месяц");
        if (day < 1 || day > dayOfMonth[month - 1])
            throw new IllegalArgumentException("Некорректный день при заданном месяце");
        if (month == 2 && day == 29 && (year % 4 != 0 || year % 100 == 0 && year % 400 != 0))
            throw new IllegalArgumentException("Год не високосный! Наибольший день февраля - 28");
    }

    static void checkFIO(@NotNull String FIO){
        if(FIO.trim().equals(""))
            throw new IllegalArgumentException("Поле имени не может быть пустым!");
    }

//    @NotNull
//    static String checkNormFIO(@NotNull String FIO){
//        String[] FIOwords = FIO.split(" ");
//        int numWord = 0;
//        StringBuilder FIOfinal = new StringBuilder();
//        for (String word : FIOwords) {
//            if (!word.equals("")) {
//                FIOfinal.append(word).append(" ");
//                numWord++;
//                if (numWord > 3)
//                    break;
//            }
//        }
//        if (numWord != 3)
//            throw new IllegalArgumentException("ФИО должно состоять из 3-х слов!");
//        return FIOfinal.delete(FIOfinal.length() - 1, FIOfinal.length()).toString();
//    }

    @Contract(pure = true)
    public Payment(){
        this.FIO = "F I O";
        this.year = 1970;
        this.month = 1;
        this.day = 1;
        this.deposit = 0;
    }

    public Payment(String FIO, long pay, int year, int month, int day) {
        checkDeposit(pay);
        this.deposit = pay;
        checkDate(year, month, day);
        this.year = year;
        this.month = month;
        this.day = day;
        checkFIO(FIO);
        this.FIO = FIO.trim();
    }

    public Payment(Payment src) {
        this.deposit = src.deposit;
        this.year = src.year;
        this.month = src.month;
        this.day = src.day;
        this.FIO = src.FIO;
    }

    public String getFIO() {
        return FIO;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public long getDeposit() {
        return deposit;
    }

    public void setFIO(String FIO) {
        checkFIO(FIO);
        this.FIO = FIO.trim();
    }

    public void setYear(int year) {
        checkDate(year, month, day);
        this.year = year;
    }

    public void setMonth(int month) {
        checkDate(year, month, day);
        this.month = month;
    }

    public void setDay(int day) {
        checkDate(year, month, day);
        this.day = day;
    }

    public void setDeposit(long deposit) {
        checkDeposit(deposit);
        this.deposit = deposit;
    }

    @Override
    @Contract(value = "null -> false", pure = true)
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Payment)) return false;
        Payment payment = (Payment) o;
        return getYear() == payment.getYear() &&
                getMonth() == payment.getMonth() &&
                getDay() == payment.getDay() &&
                getDeposit() == payment.getDeposit() &&
                Objects.equals(getFIO(), payment.getFIO());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFIO(), getYear(), getMonth(), getDay(), getDeposit());
    }

    @Override
    public String toString() {
        return "Payment{" + "FIO='" + FIO + '\'' +
                ", year=" + year +
                ", month=" + month +
                ", day=" + day +
                ", pay=" + deposit +
                '}';
    }
}