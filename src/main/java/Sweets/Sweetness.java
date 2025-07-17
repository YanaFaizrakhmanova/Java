package Sweets;

abstract class Sweetness {
    protected final String name;
    protected final double weight;
    protected final double price;

    public Sweetness(String name, double weight, double price) {
        this.name = name;
        this.weight = weight;
        this.price = price;
    }

    @Override
    public abstract String toString();

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public double getPrice() {
        return price;
    }
}
