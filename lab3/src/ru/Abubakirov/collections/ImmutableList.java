package ru.Abubakirov.collections; // Замените на ваш пакет

import java.util.Arrays;

public final class ImmutableList {
    private final int[] values;

    // Оставляем ТОЛЬКО этот конструктор. Он универсален.
    public ImmutableList(int... values) {
        // varargs может прийти как null, если вызвали new ImmutableList((int[])null)
        this.values = values == null ? new int[0] : Arrays.copyOf(values, values.length);
    }
    
    public ImmutableList(ImmutableList otherList) {
        // Копируем из другого списка
        this.values = Arrays.copyOf(otherList.values, otherList.values.length);
    }

    public int get(int index) {
        if (index < 0 || index >= values.length) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + values.length);
        }
        return values[index];
    }

    public ImmutableList set(int index, int value) {
        if (index < 0 || index >= values.length) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + values.length);
        }
        int[] newValues = Arrays.copyOf(values, values.length);
        newValues[index] = value;
        return new ImmutableList(newValues);
    }

    public int size() {
        return values.length;
    }

    public boolean isEmpty() {
        return values.length == 0;
    }

    public int[] toArray() {
        return Arrays.copyOf(values, values.length);
    }

    @Override
    public String toString() {
        return Arrays.toString(values);
    }
}