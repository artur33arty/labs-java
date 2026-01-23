package lab6.test.ru.Abubakirov.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.Abubakirov.annotations.Cache;
import ru.Abubakirov.annotations.Invoke;
import ru.Abubakirov.models.MyService;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Тест для проверки совместной работы аннотаций @Cache и @Invoke.
 */
class MyServiceTest {
    
    private MyService myService;

    @BeforeEach
    void setUp() {
        myService = new MyService();
    }

    /**
     * Проверяет, что аннотация @Cache корректно считывается и что метод,
     * помеченный @Invoke, выполняется автоматически, активируя логику кэширования.
     */
    @Test
    void testCacheAndInvokeTogether() {
        // Arrange: получаем аннотацию @Cache
        Cache cacheAnnotation = myService.getClass().getAnnotation(Cache.class);
        assertNotNull(cacheAnnotation, "@Cache аннотация должна присутствовать");
        
        // Проверяем содержимое аннотации
        String[] expectedCacheAreas = {"users", "orders"};
        assertArrayEquals(expectedCacheAreas, cacheAnnotation.value(), "Значения в @Cache не совпадают");

        // Act: ищем и вызываем метод с @Invoke
        boolean invoked = false;
        for (Method method : myService.getClass().getDeclaredMethods()) {
            if (method.isAnnotationPresent(Invoke.class)) {
                try {
                    method.invoke(myService);
                    invoked = true;
                } catch (IllegalAccessException | InvocationTargetException e) {
                    fail("Вызов метода с @Invoke не должен приводить к исключению", e);
                }
            }
        }
        
        // Assert: проверяем, что метод был вызван и логика выполнилась
        assertTrue(invoked, "Метод с аннотацией @Invoke должен был быть найден и вызван");
        assertTrue(myService.invoked, "Флаг 'invoked' в сервисе должен быть true после вызова");
        
        // Проверяем, что кэш был заполнен, как ожидалось от логики внутри @Invoke метода
        assertFalse(myService.getInternalCache().isEmpty(), "Внутренний кэш не должен быть пустым");
        assertTrue(myService.getInternalCache().containsKey("users"), "Кэш должен содержать 'users'");
        assertTrue(myService.getInternalCache().containsKey("orders"), "Кэш должен содержать 'orders'");
    }
}
