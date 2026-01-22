package ru.Abubakirov.streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamTasks {
    // Задание 7.1
    public static Polyline processPoints(List<Point> points) {
        return points.stream()
            .distinct()
            .sorted(Comparator.comparingInt(Point::getX))
            .map(p -> p.getY() < 0 ? new Point(p.getX(), -p.getY()) : p)
            .collect(Collectors.collectingAndThen(Collectors.toList(), Polyline::new));
    }
    
    // Задание 7.2
    public static Map<Integer, List<String>> processNamesAndNumbers(String filename) throws IOException {
        return Files.lines(Paths.get(filename))
            .map(String::trim)
            .filter(line -> line.contains(":"))
            .map(line -> line.split(":"))
            .collect(Collectors.groupingBy(
                parts -> Integer.parseInt(parts[1]),
                Collectors.mapping(
                    parts -> capitalize(parts[0]),
                    Collectors.toList()
                )
            ));
    }
    
    private static String capitalize(String name) {
        if (name == null || name.isEmpty()) return name;
        String lower = name.toLowerCase();
        return Character.toUpperCase(lower.charAt(0)) + lower.substring(1);
    }
}
