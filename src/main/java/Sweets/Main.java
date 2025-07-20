package Sweets;

public class Main {
    public static void main(String[] args) {
        GiftBox giftBox = new GiftBox();

        // Создание нескольких сладостей разных типов
        Chocolate chocolate = new Chocolate("Молочный шоколад", 0.2, 50, "молочный");
        Cake cake = new Cake("Шоколадный торт", 0.5, 150, "шоколадный");
        Cookie cookie = new Cookie("Карамельное печенье", 0.1, 30, "звездочка");

        // Добавление сладостей в коробку
        giftBox.addSweet(chocolate);
        giftBox.addSweet(cake);
        giftBox.addSweet(cookie);

        // Информация о коробке
        System.out.println("Вес коробки: " + giftBox.totalWeight());
        System.out.println("Стоимость коробки: " + giftBox.totalCost());
        System.out.println("Все сладости:");

        // Оптимизация коробки по весу
        giftBox.optimizeByWeight(0.6); // Ограничиваем максимальный вес до 0.6 кг
        System.out.println("\nИнформация после оптимизации по весу:");
        System.out.println("Новый вес коробки: " + giftBox.totalWeight());
        System.out.println("Новая стоимость коробки: " + giftBox.totalCost());
        System.out.println("Остались сладости:");
        giftBox.displayAllSweets();
        // Оптимизация коробки по стоимости
        giftBox.optimizeByCost(100); // Ограничиваем максимальную цену до 100 рублей
        System.out.println("\nИнформация после оптимизации по стоимости:");
        System.out.println("Новый вес коробки: " + giftBox.totalWeight());
        System.out.println("Новая стоимость коробки: " + giftBox.totalCost());
        System.out.println("Остались сладости:");
        giftBox.displayAllSweets();

    }
}

