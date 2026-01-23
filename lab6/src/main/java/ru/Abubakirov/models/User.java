package ru.Abubakirov.models;
import ru.Abubakirov.annotations.ToString;
/**
 * Класс-модель пользователя для демонстрации аннотации @ToString.
 */
@ToString
public class User {
    private final String  name;
    private int age;
    @ToString(value = ToString.Mode.NO)
    private final String password;

    public User(String name, int age, String password) {
        this.name = name;
        this.age = age;
        this.password = password;
    }
}
