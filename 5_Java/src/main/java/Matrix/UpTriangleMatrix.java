import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Objects;

public class UpTriangleMatrix implements IMatrix {
    private double[] upMtx; // Хранятся элементы по столбцам
    private int size;
    private double det;
    private boolean detFlag;

    public UpTriangleMatrix() {
        this.upMtx = new double[1];
        this.detFlag = true;
    }

    public UpTriangleMatrix(int size) {
        if (size < 0)
            throw new IllegalArgumentException("Размер матрицы не может быть отрицательным!");
        this.size = size;
        this.upMtx = new double[(size * size) / 2];
        this.detFlag = true;
    }

    public UpTriangleMatrix(@NotNull double[][] src) {
        if (src.length != src[0].length)
            throw new IllegalArgumentException("Матрица должна быть квадратной!");
        this.size = src.length;
        this.upMtx = new double[(1 + src.length) * src.length / 2];
        int counter = 1, index = 0;
        for (int j = 0; j < src.length; j++) {
            for (int i = 0; i < counter; i++) {
                this.upMtx[index] = src[i][j];
                index++;
            }
            counter++;
        }
        this.detFlag = false;
    }

    public UpTriangleMatrix(@NotNull UpTriangleMatrix src) {
        this.size = src.size;
        this.upMtx = new double[src.upMtx.length];
        System.arraycopy(src.upMtx, 0, this.upMtx, 0, src.upMtx.length);
        this.det = src.det;
        this.detFlag = src.detFlag;
    }

    public int size() {
        return this.size;
    }

    public double getElem(int row, int col) {
        if (row < 0 || col < 0 || row >= size || col >= size)
            throw new IllegalArgumentException("Выход индекса за границы матрицы!");
        return row <= col ? upMtx[generateIndex(row, col)] : 0;
    }

    public void setElem(int row, int col, double value) {
        if (row < 0 || col < 0 || row >= size || col >= size)
            throw new IllegalArgumentException("Выход индекса за границы матрицы!");
        if (row <= col) {
            int indx = generateIndex(row, col);
            if (Double.compare(upMtx[indx], value) != 0) {
                upMtx[indx] = value;
                detFlag = false;
            }
        } else
            throw new IllegalArgumentException("Попытка установить элемент вне треугольной матрицы!");

    }

    private int generateIndex(int row, int col) {
        return col * (col + 1) / 2 + row;
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
        UpTriangleMatrix that = (UpTriangleMatrix) o;
        return size == that.size &&
                Double.compare(that.det, det) == 0 &&
                detFlag == that.detFlag &&
                Arrays.equals(upMtx, that.upMtx);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(size, det, detFlag);
        result = 31 * result + Arrays.hashCode(upMtx);
        return result;
    }
}