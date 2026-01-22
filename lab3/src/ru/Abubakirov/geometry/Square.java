package ru.Abubakirov.geometry;

public class Square {
    private Point topLeft;
    private int side;

    public Square(Point topLeft, int side) {
        if (side <= 0) {
            throw new IllegalArgumentException("Side must be positive");
        }
        this.topLeft = new Point(topLeft.getX(), topLeft.getY());
        this.side = side;
    }

    public Square(int x, int y, int side) {
        if (side <= 0) {
            throw new IllegalArgumentException("Side must be positive");
        }
        this.topLeft = new Point(x, y);
        this.side = side;
    }

    public int getSide() {
        return side;
    }
    
    public void setSide(int side) {
        if (side <= 0) {
            throw new IllegalArgumentException("Side must be positive");
        }
        this.side = side;
    }

    @Override
    public String toString() {
        return "Квадрат в точке " + topLeft + " со стороной " + side;
    }
}
