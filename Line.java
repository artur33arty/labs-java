// Line.java
public class Line {
    // Свойства
    private Point startPoint;
    private Point endPoint;

    // Конструктор 1: принимает объекты Point (Задание 2.1 и 4.2)
    public Line(Point startPoint, Point endPoint) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    // Конструктор 2: принимает координаты (Задание 4.2)
    public Line(int x1, int y1, int x2, int y2) {
        this.startPoint = new Point(x1, y1);
        this.endPoint = new Point(x2, y2);
    }
    
    // Геттеры и сеттеры
    public Point getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(Point startPoint) {
        this.startPoint = startPoint;
    }

    public Point getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(Point endPoint) {
        this.endPoint = endPoint;
    }

    // Метод для вычисления длины (Задание 5.3)
    public int getLength() {
        // Формула расстояния между двумя точками
        double dx = endPoint.getX() - startPoint.getX();
        double dy = endPoint.getY() - startPoint.getY();
        return (int) Math.sqrt(dx * dx + dy * dy);
    }

    // Метод toString() для текстового представления (Задание 2.1)
    @Override
    public String toString() {
        return "Линия от " + startPoint + " до " + endPoint;
    }
}