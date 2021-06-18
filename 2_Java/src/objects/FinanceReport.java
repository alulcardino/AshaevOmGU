package objects;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

public class FinanceReport {
    private Payment[] arrPay;
    private String repWriterFIO;
    private Date repDate;

    FinanceReport(String name) {
        Payment.checkFIO(name);
        this.repWriterFIO = name.trim();
        this.repDate = new Date();
        this.arrPay = new Payment[0];
    }

    FinanceReport(String name, @NotNull Payment... pays) {
        Payment.checkFIO(name);
        this.repWriterFIO = name.trim();
        this.repDate = new Date();
        this.arrPay = new Payment[pays.length];
        this.arrPay = pays;
    }

    FinanceReport(@NotNull FinanceReport src) {
        this.repWriterFIO = src.repWriterFIO;
        this.repDate = src.repDate;
        this.arrPay = new Payment[src.arrPay.length];
        for (int i = 0; i < arrPay.length; i++) {
            this.arrPay[i] = new Payment(src.arrPay[i]);
        }
    }

    public int amountPay() {
        return arrPay.length;
    }

    public Payment getPay(int indx) {
        if (indx < 0 || indx >= arrPay.length)
            throw new IllegalArgumentException("Некорректный индекс платежа!");
        return arrPay[indx];
    }

    public void addPay(Payment newPay) {
        Payment[] newArrPay = new Payment[this.arrPay.length + 1];
        for (int i = 0; i < arrPay.length; i++) {
            newArrPay[i] = this.arrPay[i];
        }
        newArrPay[this.arrPay.length] = new Payment(newPay);
        this.arrPay = newArrPay;
    }

    @Override
    public String toString() {
        StringBuilder strFormItem = new StringBuilder();
        for (Payment pay : arrPay) {
            strFormItem.append(String.format("\nПлательщик: %s, дата: %d.%d.%d сумма: %d руб. %d коп.",
                    pay.getFIO(), pay.getDay(), pay.getMonth(), pay.getYear(), pay.getDeposit() / 100, pay.getDeposit() % 100));
        }
        return String.format("[Автор: %s, дата: %s, Платежи: [", repWriterFIO, repDate) + strFormItem.toString() + "]]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FinanceReport)) return false;
        FinanceReport that = (FinanceReport) o;
        return Arrays.equals(arrPay, that.arrPay) &&
                repWriterFIO.equals(that.repWriterFIO) &&
                repDate.equals(that.repDate);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(repWriterFIO, repDate);
        result = 31 * result + Arrays.hashCode(arrPay);
        return result;
    }
}