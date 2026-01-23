package ru.Abubakirov.annotations;

import java.lang.annotation.*;

/**
 * Аннотация с двумя обязательными параметрами: строкой и числом.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Two {
    String first();
    int second();
}
