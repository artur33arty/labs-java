package ru.Abubakirov.main;

// Статический импорт для Задания 7.3
import ru.Abubakirov.collections.ImmutableList;
import ru.Abubakirov.geography.City;
import ru.Abubakirov.geography.Route;
import ru.Abubakirov.geometry.Line;
import ru.Abubakirov.geometry.Point;
import ru.Abubakirov.geometry.Point3D;
import ru.Abubakirov.geometry.Square;
import ru.Abubakirov.math.Fraction;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- Лабораторная работа №3. Вариант 1 ---");

        // --- Задание 1.6: Отдельные линии ---
        System.out.println("\n--- Задание 1.6: Отдельные линии ---");
        Point p1 = new Point(10, 20);
        Point p2 = new Point(30, 40);
        Line lineA = new Line(p1, p2);
        Line lineB = new Line(p1, p2);
        System.out.println("Создали две линии lineA и lineB на основе одних и тех же точек.");
        System.out.println("Line A: " + lineA);
        // Изменяем исходную точку p1. Это НЕ должно повлиять на линию.
        p1.setX(999);
        System.out.println("Изменили исходную точку. Line A не изменилась: " + lineA);
        System.out.println("Это доказывает, что конструктор Line создает копии точек.");

        // --- Задание 1.12: Квадрат ---
        System.out.println("\n--- Задание 1.12: Квадрат ---");
        try {
            Square square = new Square(5, 3, 23);
            System.out.println("Создан квадрат: " + square);
            square.setSide(10);
            System.out.println("Размер изменен: " + square);
            // new Square(1, 1, -5); // Эта строка вызовет исключение
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка при создании квадрата: " + e.getMessage());
        }

        // --- Задание 2.1: Неизменяемый массив ---
        System.out.println("\n--- Задание 2.1: Неизменяемый массив ---");
        ImmutableList list1 = new ImmutableList(1, 2, 3);
        System.out.println("Исходный список: " + list1);
        ImmutableList list2 = list1.set(1, 99);
        System.out.println("Исходный список не изменился: " + list1);
        System.out.println("Новый список после set(1, 99): " + list2);
        System.out.println("Элемент по индексу 2 в list2: " + list2.get(2));

        // --- Задание 3.5: Маршрут ---
        System.out.println("\n--- Задание 3.5: Маршрут ---");
        City cityF = new City("F");
        City cityD = new City("D");
        Route route = new Route(cityF, cityD);
        System.out.println(route);

        // --- Задание 4.5: Трехмерная точка ---
        System.out.println("\n--- Задание 4.5: Трехмерная точка ---");
        Point p2d = new Point(10, 20);
        Point p3d = new Point3D(10, 20, 30);
        System.out.println("2D Точка: " + p2d);
        System.out.println("3D Точка: " + p3d);

        // --- Задание 5.1: Сложение ---
        System.out.println("\n--- Задание 5.1: Сложение ---");
        double sum = MathUtils.sum(2, 2.3, new Fraction(1, 2), new Fraction(3, 4));
        System.out.println("Сумма 2 + 2.3 + 1/2 + 3/4 = " + sum);

        // --- Задание 6.3: Сравнение линий ---
        System.out.println("\n--- Задание 6.3: Сравнение линий ---");
        Line l1 = new Line(1, 1, 10, 10);
        Line l2 = new Line(1, 1, 10, 10);
        Line l3 = new Line(10, 10, 1, 1); // Обратный порядок точек
        Line l4 = new Line(0, 0, 1, 1);
        System.out.println("l1.equals(l2) (одинаковые): " + l1.equals(l2));
        System.out.println("l1.equals(l3) (точки в обратном порядке): " + l1.equals(l3));
        System.out.println("l1.equals(l4) (разные): " + l1.equals(l4));

        System.out.println("\n--- Задание 7: Пакеты и статические импорты ---");
        
        // --- Демонстрация Задания 7.1 и 7.2 ---
        System.out.println("Задания 7.1 и 7.2 (пакеты) выполнены путем организации структуры проекта.");
        System.out.println("Этот код выполняется из класса Main, который находится в пакете 'ru.ivanov.main'.");

        // --- Наглядная демонстрация Задания 7.3 ---
        System.out.println("\n--- Задание 7.3: Возведение в степень ---");

        // Способ 1: Прямой вызов с тестовыми данными для наглядности
        System.out.println("Прямой вызов метода с тестовыми данными.");
        double result1 = MathUtils.powerFromString("5", "3");
        System.out.println("Результат '5' в степени '3' = " + result1);
        
        double result2 = MathUtils.powerFromString("2", "10");
        System.out.println("Результат '2' в степени '10' = " + result2);

        // Демонстрация обработки ошибки
        double resultError = MathUtils.powerFromString("abc", "2");
        System.out.println("Результат 'abc' в степени '2' = " + resultError);
        System.out.println();
        

        // --- Задание 8.5: Клонирование линии ---
        System.out.println("\n--- Задание 8.5: Клонирование линии ---");
        Line originalLine = new Line(0, 0, 5, 5);
        Line clonedLine = originalLine.clone();
        System.out.println("Оригинал: " + originalLine);
        System.out.println("Клон:     " + clonedLine);
        // Изменим точку у ОРИГИНАЛА. Клон не должен измениться.
        originalLine.setStartPoint(new Point(111, 111));
        System.out.println("После изменения оригинала:");
        System.out.println("Оригинал: " + originalLine);
        System.out.println("Клон:     " + clonedLine);
        System.out.println("Клон не изменился, значит, клонирование глубокое.");
    }
}