package Sweets;

class Chocolate extends Sweetness {
    private final String type; // Дополнительный параметр уникальности (вид шоколада)

    public Chocolate(String name, double weight, double price, String type) {
        super(name, weight, price);
        this.type = type;
    }

    @Override
    public String toString() {
        return "Chocolate{" +
                "name='" + name + '\\' +
        ", weight=" + weight +
                ", price=" + price +
                ", type='" + type + '\\' +
        '}';
    }
}
