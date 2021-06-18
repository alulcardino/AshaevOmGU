package imit;

public class Simple_Classes {

    public static void main1(String[] args) {
        Point3D p = new Point3D(1, 2, 3);
        p.print();
        System.out.println();
        p.setY(0.123);
        p.print();
        double x = p.getX();
        System.out.println("\nx: "+x);
        Point3D t = new Point3D();
        if (Point3D.compare(p, t))
            System.out.println("Точки равны!");
        else
            System.out.println("Точки НЕ равны!");
        System.out.println();
    }

    public static void main(String[] args){
        Vector3D v = new Vector3D(1, 1, 1);
        System.out.println(v.length());
    }
}
