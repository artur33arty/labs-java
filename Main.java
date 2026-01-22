// Main.java

public class Main {
    public static void main(String[] args) {
        // --- Задание 1.1: Точка координат ---
        System.out.println("--- Задание 1.1: Точка координат ---");
        Point p1 = new Point(1, 2);
        Point p2 = new Point(10, 20);
        Point p3 = new Point(-5, 8);
        System.out.println("Точка 1: " + p1);
        System.out.println("Точка 2: " + p2);
        System.out.println("Точка 3: " + p3);
        System.out.println();

        // --- Задание 2.1: Прямая ---
        System.out.println("--- Задание 2.1: Прямая ---");
        // 1. Создаем линию 1
        Line line1 = new Line(new Point(1, 3), new Point(23, 8));
        // 2. Создаем линию 2
        Line line2 = new Line(new Point(5, 10), new Point(25, 10));
        // 3. Создаем линию 3, которая ССЫЛАЕТСЯ на точки линий 1 и 2
        Line line3 = new Line(line1.getStartPoint(), line2.getEndPoint());

        System.out.println("Начальное состояние:");
        System.out.println("Линия 1: " + line1);
        System.out.println("Линия 2: " + line2);
        System.out.println("Линия 3: " + line3);
        System.out.println();
        
        // 4. Изменяем координаты точек у линий 1 и 2
        line1.getStartPoint().setX(100);
        line2.getEndPoint().setY(200);

        System.out.println("После изменения координат у Линии 1 и 2:");
        System.out.println("Линия 1: " + line1);
        System.out.println("Линия 2: " + line2);
        System.out.println("Линия 3 (изменилась, так как ссылалась на те же объекты): " + line3);
        System.out.println();
        
        // 5. Изменяем первую линию, создав для нее НОВУЮ точку
        line1.setStartPoint(new Point(0, 0));
        
        System.out.println("После замены объекта точки у Линии 1:");
        System.out.println("Линия 1: " + line1);
        System.out.println("Линия 3 (не изменилась, так как ссылка осталась на старый объект): " + line3);
        System.out.println();
        
        // --- Задание 3.1: Студент ---
        System.out.println("--- Задание 3.1: Студент ---");
        // 1. Создаем Васю
        Student vasya = new Student("Вася", new int[]{3, 4, 5});

        // 2. Создаем Петю и КОПИРУЕМ ССЫЛКУ на массив оценок Васи
        Student petya = new Student("Петя", vasya.getGrades());
        System.out.println("Начальные оценки:");
        System.out.println(vasya);
        System.out.println(petya);
        
        // 3. Заменяем первую оценку Пети
        petya.setFirstGrade(5);
        System.out.println("\nПосле изменения первой оценки Пети на 5:");
        System.out.println(vasya);
        System.out.println(petya);
        System.out.println("Результат: Оценки Васи изменились, потому что Петя получил не копию массива, а ссылку на тот же самый массив в памяти. Оба объекта указывали на один и тот же массив.");
        System.out.println();
        
        // 4. Создаем Андрея и копируем оценки Васи ПРАВИЛЬНО
        // Используем .clone() для создания поверхностной копии массива
        Student andrey = new Student("Андрей", vasya.getGrades().clone());
        System.out.println("Создали Андрея с копией оценок Васи:");
        System.out.println(vasya);
        System.out.println(andrey);

        vasya.setFirstGrade(2);
        System.out.println("\nПосле изменения первой оценки Васи на 2:");
        System.out.println(vasya);
        System.out.println(andrey);
        System.out.println("Результат: Оценки Андрея не изменились, так как был создан новый, независимый массив.");
        System.out.println();
        
        // --- Задание 4.1: Создаем Точку (проверка конструктора) ---
        System.out.println("--- Задание 4.1: Создаем Точку ---");
        Point p41_1 = new Point(3, 5);
        Point p41_2 = new Point(25, 6);
        Point p41_3 = new Point(7, 8);
        System.out.println("Точка 1: " + p41_1);
        System.out.println("Точка 2: " + p41_2);
        System.out.println("Точка 3: " + p41_3);
        // Код new Point() без аргументов вызовет ошибку компиляции, что и требуется.
        System.out.println();

        // --- Задание 4.2: Создаем Линию (проверка конструкторов) ---
        System.out.println("--- Задание 4.2: Создаем Линию ---");
        // Используем конструктор с 4-мя числами
        Line line42_1 = new Line(1, 3, 23, 8);
        Line line42_2 = new Line(5, 10, 25, 10);
        // Используем конструктор с объектами Point
        Line line42_3 = new Line(line42_1.getStartPoint(), line42_2.getEndPoint());
        System.out.println("Линия 1 (создана по координатам): " + line42_1);
        System.out.println("Линия 2 (создана по координатам): " + line42_2);
        System.out.println("Линия 3 (создана по объектам): " + line42_3);
        System.out.println();
        
        // --- Задание 5.3: Длина Линии ---
        System.out.println("--- Задание 5.3: Длина Линии ---");
        Line line53 = new Line(new Point(1, 1), new Point(10, 15));
        System.out.println("Линия для измерения: " + line53);
        System.out.println("Её длина (целочисленная): " + line53.getLength());
        System.out.println();
    }
}