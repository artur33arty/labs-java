package ru.Abubakirov.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import ru.Abubakirov.generic.Storage;
import ru.Abubakirov.generic.line.Line;
import ru.Abubakirov.generic.line.Point3D;
import ru.Abubakirov.main.utils.CollectionUtils;
import ru.Abubakirov.main.utils.LineUtils;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- Лабораторная работа №4. Вариант 1 ---");

        // --- Задание 1.2: Без null ---
        System.out.println("\n--- Задание 1.2: Хранилище с заменой null ---");
        Storage<Integer> nullIntStorage = new Storage<>(null);
        System.out.println("Хранилище с null, получаем с default=0: " + nullIntStorage.getOrDefault(0));

        Storage<Integer> intStorage = new Storage<>(99);
        System.out.println("Хранилище с 99, получаем с default=-1: " + intStorage.getOrDefault(-1));

        Storage<String> nullStringStorage = new Storage<>(null);
        System.out.println("Хранилище с null, получаем с default='default': " + nullStringStorage.getOrDefault("default"));
        
        Storage<String> stringStorage = new Storage<>("hello");
        System.out.println("Хранилище с 'hello', получаем с default='hello world': " + stringStorage.getOrDefault("hello world"));

        // --- Задание 1.5: Обобщенная линия ---
        System.out.println("\n--- Задание 1.5: Обобщенная линия ---");
        Point3D p3d_1 = new Point3D(1, 2, 3);
        Point3D p3d_2 = new Point3D(10, 20, 30);
        Line<Point3D> line3D = new Line<>(p3d_1, p3d_2);
        System.out.println("Создана линия в 3D пространстве: " + line3D);

        // --- Задание 2.1: Сдвинуть линию ---
        System.out.println("\n--- Задание 2.1: Сдвинуть линию ---");
        System.out.println("Начальное положение линии: " + line3D);
        LineUtils.shiftLineStart(line3D);
        System.out.println("Положение после сдвига начальной точки на 10 по X: " + line3D);

        // --- Задание 3.1: Функция (map) ---
        System.out.println("\n--- Задание 3.1: Обобщенный метод 'map' ---");
        List<String> strings = Arrays.asList("qwerty", "asdfg", "zx");
        List<Integer> lengths = CollectionUtils.map(strings, String::length);
        System.out.println("Строки " + strings + " -> Длины строк: " + lengths);

        List<Integer> numbers = Arrays.asList(1, -3, 7);
        List<Integer> absoluteNumbers = CollectionUtils.map(numbers, Math::abs);
        System.out.println("Числа " + numbers + " -> Абсолютные значения: " + absoluteNumbers);

        // --- Задание 3.2: Фильтр (filter) ---
        System.out.println("\n--- Задание 3.2: Обобщенный метод 'filter' ---");
        List<String> shortStrings = CollectionUtils.filter(strings, s -> s.length() < 5);
        System.out.println("Фильтр строк (длина < 5) из " + strings + " -> " + shortStrings);
        
        List<Integer> positiveNumbers = CollectionUtils.filter(numbers, n -> n > 0);
        System.out.println("Фильтр чисел (> 0) из " + numbers + " -> " + positiveNumbers);

        // --- Задание 3.3: Сокращение (reduce) ---
        System.out.println("\n--- Задание 3.3: Обобщенный метод 'reduce' ---");
        String concatenated = CollectionUtils.reduce(strings, (acc, s) -> acc + s, "");
        System.out.println("Свертка списка строк " + strings + " в одну: " + concatenated);

        Integer sum = CollectionUtils.reduce(numbers, (acc, n) -> acc + n, 0);
        System.out.println("Свертка списка чисел " + numbers + " в сумму: " + sum);

        // --- Задание 3.4: Коллекционирование (collect) ---
        System.out.println("\n--- Задание 3.4: Обобщенный метод 'collect' ---");
        List<Integer> numsToSplit = Arrays.asList(1, -3, 7, -5, 0);
        // Пример 1: Разбиение на два списка (положительные и отрицательные/ноль)
        List<List<Integer>> splitBySign = CollectionUtils.collect(numsToSplit,
                () -> {
                    List<List<Integer>> lists = new ArrayList<>();
                    lists.add(new ArrayList<>()); // for positive
                    lists.add(new ArrayList<>()); // for negative and zero
                    return lists;
                },
                (lists, num) -> {
                    if (num > 0) {
                        lists.get(0).add(num);
                    } else {
                        lists.get(1).add(num);
                    }
                }
        );
        System.out.println("Разбиение " + numsToSplit + " на положительные и остальные: " + splitBySign);

        // Пример 3: Сбор в набор уникальных элементов
        List<String> duplicateStrings = Arrays.asList("qwerty", "asdfg", "qwerty", "qw");
        Set<String> uniqueSet = CollectionUtils.collect(duplicateStrings, HashSet::new, HashSet::add);
        System.out.println("Сбор списка " + duplicateStrings + " в набор уникальных: " + uniqueSet);
    }
}