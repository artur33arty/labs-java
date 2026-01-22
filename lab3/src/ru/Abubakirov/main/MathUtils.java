package ru.Abubakirov.main;

// Статический импорт для Задания 7.3
import static java.lang.Integer.parseInt;
import static java.lang.Math.pow;

import ru.Abubakirov.math.Fraction; // Если используете Fraction

public class MathUtils {

    /**
     * Задание 5.1: Сложение (полиморфизм)
     * Принимает любое количество объектов-потомков Number.
     */
    public static double sum(Number... numbers) {
        double total = 0.0;
        for (Number number : numbers) {
            total += number.doubleValue();
        }
        return total;
    }

    /**
     * Задание 7.3: Возведение в степень
     * Принимает две строки, преобразует их в числа и возводит в степень.
     * Использует статические импорты для parseInt и pow.
     */
    public static double powerFromString(String baseStr, String expStr) {
        try {
            // Используем статический импорт
            int base = parseInt(baseStr);
            int exponent = parseInt(expStr);
            return pow(base, exponent);
        } catch (NumberFormatException e) {
            System.err.println("Ошибка преобразования строки в число: " + e.getMessage());
            // Возвращаем специальное значение, чтобы показать ошибку
            return Double.NaN; // NaN = Not a Number
        }
    }
}
