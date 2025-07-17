package Sweets;

interface GiftBoxInterface {
    void addSweet(Sweetness sweetness); // Добавление сладости
    void removeLastSweet(); // Удаление последней сладости
    void removeSweet(int index); // Удаление сладости по индексу
    double totalWeight(); // Общий вес
    double totalCost(); // Общая стоимость
    void displayAllSweets(); // Показать список всех сладостей
    void optimizeByWeight(double maxWeight); // Оптимизация по весу
    void optimizeByCost(double maxCost); // Оптимизация по цене
}
