package ru.Abubakirov.models;

import java.util.HashMap;
import java.util.Map;
import ru.Abubakirov.annotations.Cache;
import ru.Abubakirov.annotations.Default;
import ru.Abubakirov.annotations.Invoke;
import ru.Abubakirov.annotations.Two;
import ru.Abubakirov.annotations.Validate;

/**
 * Демонстрационный класс, использующий все созданные аннотации.
 */
@Default(String.class)
@Validate({Integer.class, Double.class})
@Two(first = "example", second = 42)
@Cache({"users", "orders"})
public class MyService {
    public boolean invoked = false;
    private Map<String, Object> internalCache = new HashMap<>();

    /**
     * Метод, который будет вызван автоматически благодаря аннотации @Invoke.
     */
    @Invoke
    public void performAction() {
        System.out.println("Метод performAction() был вызван!");
        this.invoked = true;
        // Имитация кэширования
        Cache cacheAnnotation = this.getClass().getAnnotation(Cache.class);
        if (cacheAnnotation != null && cacheAnnotation.value().length > 0) {
            System.out.println("Активировано кэширование для областей: " + String.join(", ", cacheAnnotation.value()));
            for (String area : cacheAnnotation.value()) {
                internalCache.put(area, "Cached data for " + area);
            }
        }
    }

    /**
     * Метод без аннотации, не должен вызываться автоматически.
     */
    public void anotherMethod() {
        System.out.println("anotherMethod() не вызывался автоматически.");
    }
    
    public Map<String, Object> getInternalCache() {
        return internalCache;
    }
}
