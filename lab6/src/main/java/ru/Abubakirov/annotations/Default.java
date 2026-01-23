package ru.Abubakirov.annotations;

import java.lang.annotation.*;

/**
 * Указывает тип по умолчанию для класса или поля.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})
public @interface Default {
    /**
     * @return Класс, используемый по умолчанию.
     */
    Class<?> value();
}
