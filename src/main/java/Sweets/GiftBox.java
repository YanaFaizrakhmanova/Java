package Sweets;
import java.util.ArrayList;
import java.util.List;

public class GiftBox implements GiftBoxInterface {
    private List<Sweetness> sweets = new ArrayList<>();

    @Override
    public void addSweet(Sweetness sweetness) {
        sweets.add(sweetness);
    }

    @Override
    public void removeLastSweet() {
        if (!sweets.isEmpty()) {
            sweets.remove(sweets.size() - 1);
        }
    }

    @Override
    public void removeSweet(int index) {
        if (index >= 0 && index < sweets.size()) {
            sweets.remove(index);
        }
    }

    @Override
    public double totalWeight() {
        return sweets.stream().mapToDouble(Sweetness::getWeight).sum();
    }

    @Override
    public double totalCost() {
        return sweets.stream().mapToDouble(Sweetness::getPrice).sum();
    }

    @Override
    public void displayAllSweets() {
        for (Sweetness s : sweets) {
            System.out.println(s);
        }
    }

    @Override
    public void optimizeByWeight(double maxWeight) {
        while (totalWeight() > maxWeight) {
            sweets.sort((a, b) -> Double.compare(a.getWeight(), b.getWeight()));
            sweets.remove(0); // удаляем самую легкую сладость
        }
    }

    @Override
    public void optimizeByCost(double maxCost) {
        while (totalCost() > maxCost) {
            sweets.sort((a, b) -> Double.compare(a.getPrice(), b.getPrice()));
            sweets.remove(0); // удаляем наименее дорогую сладость
        }
    }
}

