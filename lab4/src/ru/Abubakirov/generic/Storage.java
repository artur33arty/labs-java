package ru.Abubakirov.generic;

public class Storage<T> {
    private final T item; // Хранилище неизменяемо

    public Storage(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }

    /**
     * Возвращает хранимый объект, или defaultValue, если объект равен null.
     */
    public T getOrDefault(T defaultValue) {
        if (item == null) {
            return defaultValue;
        }
        return item;
    }

    @Override
    public String toString() {
        return "Хранилище содержит: " + (item == null ? "null" : item.toString());
    }
}
