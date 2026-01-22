package ru.Abubakirov.patterns.decorator;

public class MeowCounterDecorator implements Meowable {
    private final Meowable wrapped;
    private int meowCount = 0;

    public MeowCounterDecorator(Meowable wrapped) {
        this.wrapped = wrapped;
    }
    
    @Override
    public void meow() {
        meowCount++;
        wrapped.meow();
    }
    
    public int getMeowCount() {
        return meowCount;
    }
}
