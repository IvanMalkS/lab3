package ru.malkov.point;

public class Point3D extends Point {
    private double z;

    public Point3D(double x, double y, double z) {
        super(x, y);
        this.z = z;
    }

    public double getZ() {
        return z;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Point3D point3D = (Point3D) o;
        return Double.compare(point3D.z, z) == 0;
    }

    @Override
    public String toString() {
        return String.format("{%.2f;%.2f;%.2f}", getX(), getY(), z);
    }
}
