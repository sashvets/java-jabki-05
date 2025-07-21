import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * 4) Система заказа:
 * Создайте класс Order с полями:
 * orderId (read-only, генерируется автоматически).
 * items (список товаров, private).
 * totalPrice (private, вычисляется при добавлении товара).
 * Добавьте методы для добавления товара и получения информации о заказе.
 */
public class Order {
    private final UUID orderId = UUID.randomUUID();
    private List<Item> items = new ArrayList<>();
    private double totalPrice;

    public UUID getOrderId() {
        return this.orderId;
    }

    public Order() {
        this.totalPrice = 0.0;
    }

    public double getTotalPrice() {
        return this.totalPrice;
    }

    private void addItem(Item item) {
        items.add(item);
        this.totalPrice += item.getItemPrice();
    }

    public void addItem(String itemName, double itemPrice) {
        addItem(new Item(itemName, itemPrice));
    }

    public String getOrderInfo() {
        StringBuilder orderInfo = new StringBuilder();
        orderInfo.append("Номер заказа: ").append(orderId).append("\n");
        orderInfo.append("Итого: ").append(totalPrice).append("\n");
        orderInfo.append("Список товаров в количестве: ").append(items.size()).append("\n");
        for (int i = 0; i < items.size(); i++) {
            orderInfo.append(i).append(". ").append(items.get(i).getItemInfo()).append("\n");
        }
        return orderInfo.toString();
    }

    private static class Item {
        private final String itemName;
        private final double itemPrice;

        Item(String itemName, double itemPrice) {
            if (itemName == null || itemName.isEmpty()) {
                throw new IllegalArgumentException("Некорректное наименование товара");
            }
            this.itemName = itemName;
            if (itemPrice < 0) {
                throw new IllegalArgumentException("Цена товара не может быть меньше нуля");
            }
            this.itemPrice = itemPrice;
        }

        private double getItemPrice() {
            return this.itemPrice;
        }

        private String getItemInfo() {
            return this.itemName + ": " + this.itemPrice;
        }

    }
}
