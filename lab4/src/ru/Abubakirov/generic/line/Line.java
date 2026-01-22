package ru.Abubakirov.generic.line;

// T extends Point - это ограничение (маска типа). T может быть только Point или его наследником.
public class Line<T extends Point> {
    private T startPoint;
    private T endPoint;

    public Line(T startPoint, T endPoint) {
        // Конструктор не создает копии, чтобы можно было изменять точки извне для Задания 2.1
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    public T getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(T startPoint) {
        this.startPoint = startPoint;
    }

    public T getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(T endPoint) {
        this.endPoint = endPoint;
    }

    @Override
    public String toString() {
        return "Линия от " + startPoint.toString() + " до " + endPoint.toString();
    }
}
