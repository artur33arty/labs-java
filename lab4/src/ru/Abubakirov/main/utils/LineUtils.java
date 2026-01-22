package ru.Abubakirov.main.utils;

import ru.Abubakirov.generic.line.Line;
import ru.Abubakirov.generic.line.Point;

public class LineUtils {

    /**
     * Сдвигает начальную точку любой линии (2D, 3D и т.д.) на 10 по оси X.
     * Line<? extends Point> - wildcard, означает "Линия с любым типом, который является наследником Point".
     */
    public static void shiftLineStart(Line<? extends Point> line) {
        Point start = line.getStartPoint(); // Получаем ссылку на точку
        start.setX(start.getX() + 10);      // Изменяем ее состояние
    }
}