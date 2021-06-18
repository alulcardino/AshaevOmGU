public interface IMatrix {
    int size();

    double getElem(int row, int col);

    void setElem(int row, int col, double value);

    double determinant();
}