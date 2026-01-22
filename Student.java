// Student.java
import java.util.Arrays;

public class Student {
    // Свойства
    private final String name;
    private int[] grades;

    // Конструктор
    public Student(String name, int[] grades) {
        this.name = name;
        this.grades = grades;
    }

    // Геттеры и Сеттеры
    public String getName() {
        return name;
    }
    
    public int[] getGrades() {
        return grades;
    }

    public void setGrades(int[] grades) {
        this.grades = grades;
    }
    
    public void setFirstGrade(int grade) {
        if (this.grades != null && this.grades.length > 0) {
            this.grades[0] = grade;
        }
    }
    
    // Метод toString()
    @Override
    public String toString() {
        return name + ": " + Arrays.toString(grades);
    }
}