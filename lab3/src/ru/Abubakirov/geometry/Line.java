package ru.Abubakirov.geometry;

public class Line implements Cloneable {
    private Point startPoint;
    private Point endPoint;

    // Конструкторы создают КОПИИ точек (Задание 1.6)
    public Line(Point startPoint, Point endPoint) {
        if (startPoint == null || endPoint == null) {
            throw new IllegalArgumentException("Points cannot be null");
        }
        // Создаем новые объекты, чтобы избежать ссылок на одни и те же точки
        this.startPoint = new Point(startPoint.getX(), startPoint.getY());
        this.endPoint = new Point(endPoint.getX(), endPoint.getY());
    }

    public Line(int x1, int y1, int x2, int y2) {
        this.startPoint = new Point(x1, y1);
        this.endPoint = new Point(x2, y2);
    }
    
    // Геттеры возвращают КОПИИ (Задание 1.6)
    public Point getStartPoint() {
        return new Point(startPoint.getX(), startPoint.getY());
    }

    public Point getEndPoint() {
        return new Point(endPoint.getX(), endPoint.getY());
    }
    
    // Сеттеры также используют копии
    public void setStartPoint(Point startPoint) {
        this.startPoint = new Point(startPoint.getX(), startPoint.getY());
    }

    public void setEndPoint(Point endPoint) {
        this.endPoint = new Point(endPoint.getX(), endPoint.getY());
    }

    @Override
    public String toString() {
        return "Линия от " + startPoint + " до " + endPoint;
    }

    // Задание 6.3: Сравнение линий
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        // Линии равны, если их точки совпадают (независимо от порядка)
        return (startPoint.equals(line.startPoint) && endPoint.equals(line.endPoint)) ||
               (startPoint.equals(line.endPoint) && endPoint.equals(line.startPoint));
    }

    @Override
    public int hashCode() {
        // Хэш-код не должен зависеть от порядка точек
        return startPoint.hashCode() + endPoint.hashCode();
    }
    
    // Задание 8.5: Глубокое клонирование
    @Override
    public Line clone() {
        try {
            Line clonedLine = (Line) super.clone();
            // Клонируем внутренние объекты для глубокой копии
            clonedLine.startPoint = this.startPoint.clone();
            clonedLine.endPoint = this.endPoint.clone();
            return clonedLine;
        } catch (CloneNotSupportedException e) {
            throw new InternalError(e);
        }
    }
}
