package ru.Abubakirov.annotations;

import java.lang.annotation.*;

/**
 * Указывает, какие области должны быть кэшированы.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Cache {
    /**
     * @return Массив имен кэшируемых областей.
     */
    String[] value() default {};
}
