package ru.Abubakirov.main;

import ru.Abubakirov.main.processors.AnnotationProcessor;
import ru.Abubakirov.main.processors.ToStringProcessor;
import ru.Abubakirov.models.MyService;
import ru.Abubakirov.models.User;

public class Main {
    public static void main(String[] args) throws IllegalAccessException {
        System.out.println("--- Лабораторная работа №6. Вариант 1 ---");

        // Демонстрация работы всех аннотаций на классе MyService
        MyService service = new MyService();
        AnnotationProcessor.process(service);

        // Демонстрация работы @ToString на классе User
        User user = new User("John Doe", 30, "secret_password");
        String userString = ToStringProcessor.process(user);
        System.out.println("Результат @ToString для User: " + userString);
    }
}
