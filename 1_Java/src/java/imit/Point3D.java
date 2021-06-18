package imit;

import java.util.Locale;

public class Point3D {
    private double x, y, z;

    Point3D() {
        this.x = 0;
        this.y = 0;
        this.z = 0;
    }

    Point3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public static boolean compare(Point3D p1, Point3D p2) {
        return Double.compare(p1.x, p2.x) == 0 && Double.compare(p1.y, p2.y) == 0 && Double.compare(p1.z, p2.z) == 0;
    }

    void print() {
        System.out.printf(Locale.ENGLISH, "(%.3f, %.3f, %.3f)", this.x, this.y, this.z);
    }
}
