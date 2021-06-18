import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Objects;

public class DiagMatrix implements IMatrix {
    private double[] diag;
    private double det;
    private boolean detFlag;

    public DiagMatrix() {
        this.diag = new double[1];
        this.detFlag = true;
    }

    public DiagMatrix(int size) {
        if (size < 0)
            throw new IllegalArgumentException("Размер матрицы не может быть отрицательным!");
        this.diag = new double[size];
        this.detFlag = true;
    }

    public DiagMatrix(@NotNull double... src) {
        this.diag = src;
        this.detFlag = false;
    }

    public DiagMatrix(@NotNull DiagMatrix src) {
        this(src.diag);
        this.det = src.det;
        this.detFlag = src.detFlag;
    }

    public int size() {
        return diag.length;
    }

    public double getElem(int row, int col) {
        if (row < 0 || col < 0 || row >= size() || col >= size())
            throw new IllegalArgumentException("Выход индекса за границы матрицы!");
        return row == col ? diag[row] : 0;
    }

    public void setElem(int row, int col, double value) {
        if (row < 0 || col < 0 || row >= size() || col >= size())
            throw new IllegalArgumentException("Выход индекса за границы матрицы!");
        if (row == col) {
            if (Double.compare(diag[row], value) != 0) {
                diag[row] = value;
                detFlag = false;
            }
        } else
            throw new IllegalArgumentException("Попытка установить элемент вне диагонали!");
    }

    public double determinant() {
        if (detFlag)
            return det;
        return Matrix.determinant(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DiagMatrix that = (DiagMatrix) o;
        return Double.compare(that.det, det) == 0 &&
                detFlag == that.detFlag &&
                Arrays.equals(diag, that.diag);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(det, detFlag);
        result = 31 * result + Arrays.hashCode(diag);
        return result;
    }
}