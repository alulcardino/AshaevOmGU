package imit;

public class Vector3DProcessor {

    public static Vector3D sum(Vector3D a, Vector3D b) {
        return new Vector3D(
                a.getX() + b.getX(),
                a.getY() + b.getY(),
                a.getZ() + b.getZ()
        );
    }

    public static Vector3D proiz(double coef, Vector3D v) {
        return new Vector3D(
                v.getX() * coef,
                v.getY() * coef,
                v.getZ() * coef
        );
    }

    public static double scal(Vector3D a, Vector3D b) {
        return a.getX() * b.getX() + a.getY() * b.getY() + a.getZ() * b.getZ();
    }

    public static Vector3D vproiz(Vector3D a, Vector3D b) {
        return new Vector3D(
                a.getY() * b.getZ() - a.getZ() * b.getY(),
                a.getZ() * b.getX() - a.getX() * b.getZ(),
                a.getX() * b.getY() - b.getY() * a.getX()
        );
    }

    public static boolean colin(Vector3D a, Vector3D b) {
        return  vproiz(a, b).equals(new Vector3D());
    }
}
