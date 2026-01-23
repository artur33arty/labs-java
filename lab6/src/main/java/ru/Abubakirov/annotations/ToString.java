package ru.Abubakirov.annotations;

import java.lang.annotation.*;

/**
 * Аннотация для кастомизации вывода метода toString().
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})
public @interface ToString {
    enum Mode { YES, NO }

    /**
     * @return Режим включения поля в toString(). По умолчанию YES.
     */
    Mode value() default Mode.YES;
}
