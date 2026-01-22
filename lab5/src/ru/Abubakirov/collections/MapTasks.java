package ru.Abubakirov.collections;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Athlete {
    String name, surname;
    int totalScore;
    public Athlete(String surname, String name, int totalScore) {
        this.surname = surname; this.name = name; this.totalScore = totalScore;
    }
    public int getTotalScore() { return totalScore; }
    public String getFullName() { return surname + " " + name; }
}

public class MapTasks {
    public static void findTopThreeAthletes(String filename) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(filename));
        int n = Integer.parseInt(lines.get(0));
        List<Athlete> athletes = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            String[] parts = lines.get(i).split(" ");
            String surname = parts[0];
            String name = parts[1];
            int score = IntStream.range(2, parts.length).map(j -> Integer.parseInt(parts[j])).sum();
            athletes.add(new Athlete(surname, name, score));
        }

        athletes.sort(Comparator.comparingInt(Athlete::getTotalScore).reversed());
        
        System.out.println("Трое лучших участников многоборья:");
        if (athletes.isEmpty()) {
            System.out.println("Список участников пуст.");
            return;
        }

        // Находим 3 уникальных лучших результата
        List<Integer> topScores = athletes.stream()
            .map(Athlete::getTotalScore)
            .distinct()
            .limit(3)
            .collect(Collectors.toList());

        if (topScores.isEmpty()) return;

        int thirdBestScore = topScores.get(topScores.size() - 1);

        // Выводим всех, кто набрал не меньше 3-го лучшего результата
        athletes.stream()
            .filter(a -> a.getTotalScore() >= thirdBestScore)
            .forEach(a -> System.out.println(a.getFullName() + " - " + a.getTotalScore()));
    }
}
