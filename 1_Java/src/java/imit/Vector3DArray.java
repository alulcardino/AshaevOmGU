package imit;

public class Vector3DArray {
    private Vector3D[] vectors;

    public Vector3DArray(int n) {
        vectors = new Vector3D[n];
        for (int i = 0; i < n; i++) {
            vectors[i] = new Vector3D();
        }
    }

    public int count() {
        return vectors.length;
    }

    public void replace(Vector3D v, int indx) {
        if (indx >= vectors.length || indx < 0)
            throw new IllegalArgumentException("Индекс больше длины массива!");
        //copy
        vectors[indx].setX(v.getX());
        vectors[indx].setY(v.getY());
        vectors[indx].setZ(v.getZ());
    }

    public double maxLen() {
        double max = 0;
        for (Vector3D v : vectors) {
            if (v.length() > max)
                max = v.length();
        }
        return max;
    }

    public int search(Vector3D v) {
        for (int i = 0; i < vectors.length; i++) {
            if (vectors[i].equals(v))
                return i;
        }
        return -1;
    }

    public Vector3D sum() {
        Vector3D sum = new Vector3D();
        for (Vector3D v : vectors) {
            sum = Vector3DProcessor.sum(sum, v);
        }
        return sum;
    }

    public Vector3D linComb(double[] coef) {
        if (coef.length != vectors.length) {
            throw new IllegalArgumentException("Размер массива коэффициентолв не совпадает с количеством векторов");
        }
        Vector3D lin = new Vector3D();
        for (int i = 0; i < vectors.length; i++) {
            lin = Vector3DProcessor.sum(lin, Vector3DProcessor.proiz(coef[i], vectors[i]));
        }
        return lin;
    }

    public Point3D[] shift(Point3D p) {
        Point3D[] out = new Point3D[vectors.length];
        for (int i = 0; i < vectors.length; i++) {
            out[i] = new Point3D(
                    p.getX() + vectors[i].getX(),
                    p.getY() + vectors[i].getY(),
                    p.getZ() + vectors[i].getZ()
            );
        }
        return out;
    }
}