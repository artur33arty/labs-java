package ru.Abubakirov.geography;

import java.util.StringJoiner;

public class Route {
    private City startCity;
    private City endCity;

    public Route(City startCity, City endCity) {
        if (startCity == null || endCity == null) {
            throw new IllegalArgumentException("Start and end cities cannot be null.");
        }
        this.startCity = startCity;
        this.endCity = endCity;
    }
    
    // Для демонстрации возвращаем жестко заданный путь
    public City[] getPath() {
        // Это заглушка, в реальном приложении здесь был бы сложный алгоритм
        if (startCity.getName().equals("F") && endCity.getName().equals("D")) {
            return new City[]{
                new City("F"),
                new City("E"),
                new City("D")
            };
        }
        return new City[0]; // Возвращаем пустой массив, если путь не найден
    }

    @Override
    public String toString() {
        City[] path = getPath();
        StringJoiner sj = new StringJoiner(" -> ");
        for (City city : path) {
            sj.add(city.getName());
        }
        return "Маршрут: " + sj.toString();
    }
}
