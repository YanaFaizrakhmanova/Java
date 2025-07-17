package Sweets;

class Cookie extends Sweetness {
    private final String shape; // Форма печенья

    public Cookie(String name, double weight, double price, String shape) {
        super(name, weight, price);
        this.shape = shape;
    }

    @Override
    public String toString() {
        return "Cookie{" +
                "name='" + name + '\\' +
        ", weight=" + weight +
                ", price=" + price +
                ", shape='" + shape + '\\' +
        '}';
    }
}
