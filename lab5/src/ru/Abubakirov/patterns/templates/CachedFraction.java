package ru.Abubakirov.patterns.templates;

public class CachedFraction implements Fractionable {
    private final Fraction fraction;
    private Double cache = null;

    public CachedFraction(int numerator, int denominator) {
        this.fraction = new Fraction(numerator, denominator);
    }
    
    @Override
    public double doubleValue() {
        if (cache == null) {
            System.out.println(" (Вычисляю значение...)");
            cache = fraction.toDouble();
        } else {
            System.out.println(" (Беру из кэша...)");
        }
        return cache;
    }

    @Override
    public void setNum(int num) {
        fraction.setNumerator(num);
        cache = null; // Инвалидация кэша
    }

    @Override
    public void setDen(int den) {
        fraction.setDenominator(den);
        cache = null; // Инвалидация кэша
    }
    
    @Override
    public String toString() {
        return fraction.toString();
    }
}
