package ru.Abubakirov.collections;

import java.util.*;

public class QueueTasks {
    public static <T> Queue<T> buildPalindromeQueue(List<T> list) {
        Queue<T> queue = new LinkedList<>();
        Stack<T> stack = new Stack<>();
        for (T item : list) {
            queue.add(item);
            stack.push(item);
        }
        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }
        return queue;
    }
}