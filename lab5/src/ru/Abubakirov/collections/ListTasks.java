package ru.Abubakirov.collections;

import java.util.Collections;
import java.util.List;

public class ListTasks {
    public static <T extends Comparable<T>> void mergeSorted(List<T> l1, List<T> l2) {
        l1.addAll(l2);
        Collections.sort(l1);
    }
}
