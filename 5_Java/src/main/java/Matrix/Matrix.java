import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Objects;

public class Matrix implements IMatrix {
    private double[] mtx;
    private int size;
    private double det;
    private boolean detFlag;

    public Matrix() {
        this.mtx = new double[1];
        this.detFlag = true;
    }

    public Matrix(int size) {
        if (size < 0)
            throw new IllegalArgumentException("Размер матрицы не может быть отрицательным!");
        this.mtx = new double[size * size];
        this.detFlag = true;
    }

    public Matrix(int n, @NotNull double... arr) {
        if (arr.length < n * n) {
            throw new IllegalArgumentException("В матрице не хватает элементов!");
        }
        this.mtx = new double[n * n];
        System.arraycopy(arr, 0, this.mtx, 0, n * n);
        this.size = n;
        this.detFlag = false;
    }

    public Matrix(@NotNull double[][] src) {
        if (src.length != src[0].length)
            throw new IllegalArgumentException("Матрица должна быть квадратной!");
        this.mtx = new double[src.length * src.length];
        for (int i = 0; i < src.length; i++) {
            System.arraycopy(src[i], 0, this.mtx, i * src.length, src.length);
        }
        this.size = src.length;
        this.detFlag = false;
    }

    public Matrix(@NotNull Matrix src) {
        this.mtx = new double[src.mtx.length];
        System.arraycopy(src.mtx, 0, this.mtx, 0, src.mtx.length);
        this.size = src.size;
        this.det = src.det;
        this.detFlag = src.detFlag;
    }

    public Matrix(@NotNull IMatrix src) {
        this.size = src.size();
        this.mtx = new double[size * size];
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                try {
                    this.mtx[i * size + j] = src.getElem(i, j);
                } catch (IllegalArgumentException e) {
                    this.mtx[i * size + j] = 0;
                }
        this.detFlag = false;
    }

    public int size() {
        return size;
    }

    public double getElem(int row, int col) {
        if (row < 0 || col < 0 || row >= size() || col >= size())
            throw new IllegalArgumentException("Выход индекса за границы матрицы!");
        return this.mtx[row * size + col];
    }

    public void setElem(int row, int col, double value) {
        if (row < 0 || col < 0 || row >= size() || col >= size())
            throw new IllegalArgumentException("Выход индекса за границы матрицы!");
        int indx = row * size + col;
        if (Double.compare(mtx[indx], value) != 0) {
            mtx[indx] = value;
            detFlag = false;
        }
    }

    public static boolean isTriangle(@NotNull IMatrix mtx) {
        for (int i = 1; i < mtx.size(); i++)
            for (int j = 0; j < i; j++)
                if (Double.compare(mtx.getElem(i, j), 0.0) != 0)
                    return false;
        return true;
    }

    private void swapLine(int l1, int l2) {
        double[] buf = new double[size];
        System.arraycopy(mtx, l1 * size, buf, 0, size);
        System.arraycopy(mtx, l2 * size, mtx, l1 * size, size);
        System.arraycopy(buf, 0, mtx, l2 * size, size);
    }

    public double determinant() {
        if (detFlag)
            return det;
        return determinant(this);
    }

    protected static double determinant(IMatrix mtxThis) {
        double result = 1;
        int count;
        Matrix mt1 = new Matrix(new Matrix(mtxThis));  // Рабочая матрица
        Matrix mt2;                                 // Матрица хранения

        if (!isTriangle(mtxThis))
            // строим треугольную матрицу
            for (int i = 0; i < mtxThis.size(); i++) {
                // проверка на НЕнулевой i-тый элемент строки
                if (i < mtxThis.size() - 1 && Double.compare(mt1.getElem(i, i), 0.0) == 0) {
                    count = i + 1;
                    do {
                        mt1.getElem(count, 0);
                        count++;
                    } while (Double.compare(mt1.getElem(count, 0), 0.0) == 0);

                    mt1.swapLine(i, count);
                    result = -result; // Если была совершена перестановка — меняем знак определителя
                }
                /*копирование "рабочей" матрицы в "статическую", необходимо
                для корректного расчета коофициентов умножения строк перед вычитанием*/
                mt2 = new Matrix(mt1);
                //зануление i-того столбца
                for (int j = i + 1; j < mtxThis.size(); j++)
                    for (int k = i; k < mtxThis.size(); k++)
                        mt1.setElem(j, k, mt1.getElem(j, k) - ((mt1.getElem(i, k) * mt2.getElem(j, i)) / mt1.getElem(i, i)));
            }
        //Вычисление определителя
        for (int x = 0; x < mtxThis.size(); x++) {
            result = result * mt1.getElem(x, x);
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Matrix)) return false;
        Matrix matrix = (Matrix) o;
        return size == matrix.size &&
                Double.compare(matrix.det, det) == 0 &&
                detFlag == matrix.detFlag &&
                Arrays.equals(mtx, matrix.mtx);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(size, det, detFlag);
        result = 31 * result + Arrays.hashCode(mtx);
        return result;
    }
}
