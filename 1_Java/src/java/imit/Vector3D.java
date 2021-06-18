package imit;

import java.util.Locale;
import java.util.Objects;

public class Vector3D {
    private double x, y, z;

    Vector3D() {
        this.x = 0;
        this.y = 0;
        this.z = 0;
    }

    Vector3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    Vector3D(Point3D start, Point3D end) {
        this.x = end.getX() - start.getX();
        this.y = end.getY() - start.getY();
        this.z = end.getZ() - start.getZ();
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    double length() {
        return Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vector3D vector3D = (Vector3D) o;
        return Double.compare(vector3D.x, x) == 0 &&
                Double.compare(vector3D.y, y) == 0 &&
                Double.compare(vector3D.z, z) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z);
    }

    void print() {
        System.out.printf(Locale.ENGLISH, "(%.3f, %.3f, %.3f)", this.x, this.y, this.z);
    }
}