package ru.Abubakirov.collections;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Set;
import java.util.TreeSet;

public class SetTasks {
    public static int countUniqueLetters(String filename) throws IOException {
        String content = new String(Files.readAllBytes(Paths.get(filename))).toLowerCase();
        Set<Character> uniqueLetters = new TreeSet<>();
        for (char c : content.toCharArray()) {
            if (Character.isLetter(c)) {
                uniqueLetters.add(c);
            }
        }
        System.out.println("Найденные уникальные буквы: " + uniqueLetters);
        return uniqueLetters.size();
    }
}
