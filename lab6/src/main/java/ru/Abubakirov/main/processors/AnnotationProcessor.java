package ru.Abubakirov.main.processors;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

import ru.Abubakirov.annotations.Cache;
import ru.Abubakirov.annotations.Default;
import ru.Abubakirov.annotations.Invoke;
import ru.Abubakirov.annotations.Two;
import ru.Abubakirov.annotations.Validate;

/**
 * Универсальный обработчик для демонстрации работы всех аннотаций.
 */
public class AnnotationProcessor {
    /**
     * Обрабатывает все аннотации на переданном объекте.
     * @param obj Объект для анализа.
     */
    public static void process(Object obj) {
        System.out.println("--- Обработка объекта класса: " + obj.getClass().getSimpleName() + " ---");
        Class<?> clazz = obj.getClass();
        
        // Задание 1.1: @Invoke
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Invoke.class)) {
                try {
                    method.invoke(obj);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
        
        // Задание 1.2: @Default
        if (clazz.isAnnotationPresent(Default.class)) {
            Default defaultAnn = clazz.getAnnotation(Default.class);
            System.out.println("Класс по умолчанию: " + defaultAnn.value().getName());
        }

        // Задание 1.4: @Validate
        if (clazz.isAnnotationPresent(Validate.class)) {
            Validate validateAnn = clazz.getAnnotation(Validate.class);
            System.out.println("Классы для валидации: " + Arrays.toString(validateAnn.value()));
        }

        // Задание 1.5: @Two
        if (clazz.isAnnotationPresent(Two.class)) {
            Two twoAnn = clazz.getAnnotation(Two.class);
            System.out.println("Аннотация @Two: first='" + twoAnn.first() + "', second=" + twoAnn.second());
        }

        // Задание 1.6: @Cache
        if (clazz.isAnnotationPresent(Cache.class)) {
            Cache cacheAnn = clazz.getAnnotation(Cache.class);
            if (cacheAnn.value().length == 0) {
                System.out.println("Список кэшируемых областей пуст.");
            } else {
                System.out.println("Кэшируемые области: " + String.join(", ", cacheAnn.value()));
            }
        }
        System.out.println("--- Обработка завершена ---\n");
    }
}
