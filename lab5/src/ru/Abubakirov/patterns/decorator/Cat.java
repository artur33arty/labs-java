package ru.Abubakirov.patterns.decorator;

public class Cat implements Meowable {
    private final String name;
    public Cat(String name) { this.name = name; }
    @Override
    public void meow() { System.out.println(name + ": мяу!"); }
    @Override
    public String toString() { return "кот: " + name; }
}
