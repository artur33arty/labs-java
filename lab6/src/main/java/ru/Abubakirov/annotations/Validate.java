package ru.Abubakirov.annotations;

import java.lang.annotation.*;

/**
 * Указывает список классов для валидации.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Validate {
    /**
     * @return Массив классов для проверки.
     */
    Class<?>[] value();
}
