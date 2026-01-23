package lab6.test.ru.Abubakirov.tests;

import org.junit.jupiter.api.Test;
import ru.Abubakirov.main.processors.ToStringProcessor;
import ru.Abubakirov.models.User;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Тесты для проверки корректности работы обработчика аннотации @ToString.
 */
class UserTest {

    /**
     * Проверяет, что метод toString(), основанный на аннотации,
     * корректно формирует строку, включая поля с @ToString(YES) (по умолчанию)
     * и исключая поля с @ToString(NO).
     */
    @Test
    void testToStringAnnotation() throws IllegalAccessException {
        // Arrange
        User user = new User("Alice", 25, "qwerty123");
        
        // Act
        String result = ToStringProcessor.process(user);
        
        // Assert
        assertTrue(result.contains("name=Alice"), "Строка должна содержать имя");
        assertTrue(result.contains("age=25"), "Строка должна содержать возраст");
        assertFalse(result.contains("password"), "Строка не должна содержать пароль");
        assertEquals("User[name=Alice, age=25]", result, "Финальная строка не соответствует ожиданиям");
    }
}