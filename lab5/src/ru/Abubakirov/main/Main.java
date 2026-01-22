package ru.Abubakirov.main;

import java.io.IOException;
import java.util.*;
import ru.Abubakirov.collections.*;
import ru.Abubakirov.patterns.decorator.*;
import ru.Abubakirov.patterns.templates.*;
import ru.Abubakirov.streams.*;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("--- Лабораторная работа №5. Вариант 1 ---");

        // Задание 1.1: Дробь с кэшированием
        System.out.println("\n--- Задание 1.1: Дробь с кэшированием ---");
        Fractionable f = new CachedFraction(2, 5);
        System.out.print(f + " -> " + f.doubleValue());
        System.out.print(f + " -> " + f.doubleValue());
        f.setNum(3);
        System.out.print(f + " -> " + f.doubleValue());
        System.out.print(f + " -> " + f.doubleValue());

        // Задание 2.1: Декоратор для подсчета "мяуканий"
        System.out.println("\n\n--- Задание 2.1: Декоратор для подсчета \"мяуканий\" ---");
        MeowCounterDecorator m = new MeowCounterDecorator(new Cat("Барсик"));
        meowsCare(m);
        System.out.println("Кот мяукал " + m.getMeowCount() + " раз");

        // Задание 3.3: Вставка упорядоченного списка
        System.out.println("\n--- Задание 3.3: Вставка упорядоченного списка ---");
        List<Integer> l1 = new ArrayList<>(Arrays.asList(1, 5, 10));
        List<Integer> l2 = new ArrayList<>(Arrays.asList(2, 3, 8));
        System.out.println("L1 = " + l1 + ", L2 = " + l2);
        ListTasks.mergeSorted(l1, l2);
        System.out.println("Результат слияния: " + l1);
        
        // Задание 4.3: Трое лучших участников
        System.out.println("\n--- Задание 4.3: Трое лучших участников из файла 'data/athletes.txt' ---");
        MapTasks.findTopThreeAthletes("lab5/data/athletes.txt");

        // Задание 5.7: Количество разных букв
        System.out.println("\n--- Задание 5.7: Количество разных букв из файла 'data/text_ru.txt' ---");
        int uniqueCount = SetTasks.countUniqueLetters("lab5/data/text_ru.txt");
        System.out.println("Количество уникальных букв в тексте: " + uniqueCount);
        
        // Задание 6.2: Очередь-палиндром
        System.out.println("\n--- Задание 6.2: Очередь-палиндром ---");
        List<Integer> sourceList = Arrays.asList(1, 2, 3);
        Queue<Integer> palindromeQueue = QueueTasks.buildPalindromeQueue(sourceList);
        System.out.println("Исходный список: " + sourceList);
        System.out.println("Результат-очередь: " + palindromeQueue);

        // Задание 7.1: Обработка Point'ов
        System.out.println("\n--- Задание 7.1: Stream API для обработки точек ---");
        List<Point> points = Arrays.asList(
            new Point(1, 10), new Point(5, -2), new Point(3, 8),
            new Point(1, 10), new Point(2, -5)
        );
        System.out.println("Исходный набор точек: " + points);
        Polyline resultPolyline = StreamTasks.processPoints(points);
        System.out.println("Результат: " + resultPolyline);

        // Задание 7.2: Обработка файла с именами и номерами
        System.out.println("\n--- Задание 7.2: Stream API для группировки из файла 'data/names_and_numbers.txt' ---");
        Map<Integer, List<String>> groupedNames = StreamTasks.processNamesAndNumbers("lab5/data/names_and_numbers.txt");
        System.out.println("Результат группировки: " + groupedNames);
    }
    
    // Вспомогательный метод для Задания 2.1
    public static void meowsCare(Meowable m) {
        System.out.println("Запускаем заботу о мяукающем...");
        m.meow(); m.meow(); m.meow();
    }
}
