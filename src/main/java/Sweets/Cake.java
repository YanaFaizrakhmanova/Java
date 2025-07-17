package Sweets;

class Cake extends Sweetness {
    private final String flavor; // Уникальность (начинка тортика)

    public Cake(String name, double weight, double price, String flavor) {
        super(name, weight, price);
        this.flavor = flavor;
    }

    @Override
    public String toString() {
        return "Cake{" +
                "name='" + name + '\\' +
        ", weight=" + weight +
                ", price=" + price +
                ", flavor='" + flavor + '\\' +
        '}';
    }
}
