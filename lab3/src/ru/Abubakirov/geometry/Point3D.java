package ru.Abubakirov.geometry;

public class Point3D extends Point {
    private int z;

    public Point3D(int x, int y, int z) {
        super(x, y); // Вызываем конструктор родительского класса
        this.z = z;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    @Override
    public String toString() {
        // Используем геттеры родителя для доступа к private полям
        return "{" + getX() + ";" + getY() + ";" + z + "}";
    }
}
