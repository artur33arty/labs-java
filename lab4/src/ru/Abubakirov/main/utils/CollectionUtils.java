package ru.Abubakirov.main.utils;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class CollectionUtils {

    // --- Задание 3.1: Функция (map) ---
    /**
     * Применяет функцию к каждому элементу списка и возвращает новый список с результатами.
     * @param <T> Тип элементов в исходном списке.
     * @param <R> Тип элементов в результирующем списке.
     */
    public static <T, R> List<R> map(List<T> list, Function<T, R> function) {
        List<R> result = new ArrayList<>();
        for (T item : list) {
            result.add(function.apply(item));
        }
        return result;
    }

    // --- Задание 3.2: Фильтр (filter) ---
    /**
     * Возвращает новый список, содержащий только те элементы, которые удовлетворяют предикату.
     * @param <T> Тип элементов в списке.
     */
    public static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        List<T> result = new ArrayList<>();
        for (T item : list) {
            if (predicate.test(item)) {
                result.add(item);
            }
        }
        return result;
    }

    // --- Задание 3.3: Сокращение (reduce) ---
    // Вспомогательный интерфейс для операции свертки
    public interface Reducer<T> {
        T reduce(T accumulator, T item);
    }

    /**
     * "Сворачивает" список в одно значение с помощью заданной функции.
     * Гарантирует, что не вернет null для пустого списка, если initialValue не null.
     */
    public static <T> T reduce(List<T> list, Reducer<T> reducer, T initialValue) {
        T result = initialValue;
        if (list == null || list.isEmpty()) {
            return initialValue;
        }
        for (T item : list) {
            result = reducer.reduce(result, item);
        }
        return result;
    }

    // --- Задание 3.4: Коллекционирование (collect) ---
    /**
     * Собирает элементы из списка в новую коллекцию.
     * @param supplier Поставщик, создающий пустую коллекцию (e.g., ArrayList::new).
     * @param accumulator Потребитель, добавляющий элемент в коллекцию (e.g., List::add).
     */
    public static <T, R> R collect(List<T> list, Supplier<R> supplier, BiConsumer<R, T> accumulator) {
        R result = supplier.get();
        for (T item : list) {
            accumulator.accept(result, item);
        }
        return result;
    }
}