// Point.java
public class Point {
    // Свойства (поля)
    private int x;
    private int y;

    // Конструктор (требование из Задания 4.1)
    // Создать объект можно только указав обе координаты.
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Геттеры для доступа к координатам
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    // Сеттеры для изменения координат
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    // Метод toString() для текстового представления (требование из Задания 1.1)
    @Override
    public String toString() {
        return "{" + x + ";" + y + "}";
    }
}