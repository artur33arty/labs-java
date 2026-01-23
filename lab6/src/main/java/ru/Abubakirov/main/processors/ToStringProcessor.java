package ru.Abubakirov.main.processors;

import java.lang.reflect.Field;
import ru.Abubakirov.annotations.ToString;

/**
 * Обработчик для генерации строкового представления объекта на основе аннотации @ToString.
 */
public class ToStringProcessor {
    /**
     * Генерирует строку для объекта, учитывая аннотации @ToString на полях.
     * @param obj Объект для преобразования в строку.
     * @return Строковое представление.
     * @throws IllegalAccessException если доступ к полям запрещен.
     */
    public static String process(Object obj) throws IllegalAccessException {
        Class<?> clazz = obj.getClass();
        if (!clazz.isAnnotationPresent(ToString.class)) {
            return obj.toString(); // Возвращаем стандартное поведение
        }

        StringBuilder sb = new StringBuilder(clazz.getSimpleName()).append("[");
        Field[] fields = clazz.getDeclaredFields();
        boolean first = true;

        for (Field field : fields) {
            field.setAccessible(true); // Разрешаем доступ к приватным полям
            ToString toStringAnn = field.getAnnotation(ToString.class);
            // Поле включается, если на нем нет аннотации или аннотация не NO
            if (toStringAnn == null || toStringAnn.value() == ToString.Mode.YES) {
                if (!first) {
                    sb.append(", ");
                }
                sb.append(field.getName()).append("=").append(field.get(obj));
                first = false;
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
