import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class HomeworkTest {

    @Nested
    class testWalletClass {

        @Test
        void testWalletConstructor() {
            Exception exception = assertThrows(IllegalArgumentException.class, () -> new Wallet("", 100));
            assertEquals("Владелец кошелька должен быть указан", exception.getMessage());
            exception = assertThrows(IllegalArgumentException.class, () -> new Wallet("Гомер", -100));
            assertEquals("Средства в кошельке не могут быть меньше нуля", exception.getMessage());
        }

        @Test
        void testSetOwner() {
            Wallet wallet = new Wallet("Глеб", 100);
            Exception exception;
            exception = assertThrows(IllegalArgumentException.class, () -> wallet.setOwner(""));
            assertEquals("Владелец кошелька должен быть указан", exception.getMessage());
        }

        @Test
        void testSetMoney() {
            Wallet wallet = new Wallet("Глеб", 100);
            Exception exception;
            exception = assertThrows(IllegalArgumentException.class, () -> wallet.setMoney(-100));
            assertEquals("Средства в кошельке не могут быть меньше нуля", exception.getMessage());
        }

        @Test
        void testSpend() {
            Wallet wallet = new Wallet("Глеб", 100);
            Exception exception;
            exception = assertThrows(IllegalArgumentException.class, () -> wallet.spend(-100));
            assertEquals("Сумма расходов должна быть положительной. Указано: -100", exception.getMessage());
            exception = assertThrows(IllegalArgumentException.class, () -> wallet.spend(200));
            assertEquals("Недостаточно средств. Сумма 200 больше чем есть в кошельке 100", exception.getMessage());
        }

        @Test
        void testGetOwner() {
            Wallet wallet = new Wallet("Глеб", 100);
            assertEquals("Глеб", wallet.getOwner());
        }

        @Test
        void testGetMoney() {
            Wallet wallet = new Wallet("Глеб", 100);
            assertEquals(100, wallet.getMoney());
        }
    }

    @Nested
    class testGameClass {

        @Test
        void testCheckGuess() {
            Game game = new Game();
            int secretNumber = 0;
            while (!game.checkGuess(secretNumber).equals("Угадал") && secretNumber != 100) {
                secretNumber++;
            }
            assertEquals("Больше", game.checkGuess(secretNumber + 1));
            assertEquals("Меньше", game.checkGuess(secretNumber - 1));
            assertEquals("Угадал", game.checkGuess(secretNumber));
        }
    }

    @Nested
    class testTVClass {

        @Test
        void testTVConstructor() {
            Exception exception = assertThrows(IllegalArgumentException.class, () -> new TV(-100, 10));
            assertEquals("Неверный номер канала -100", exception.getMessage());
            exception = assertThrows(IllegalArgumentException.class, () -> new TV(100, 10));
            assertEquals("Неверный номер канала 100", exception.getMessage());
            exception = assertThrows(IllegalArgumentException.class, () -> new TV(1, -10));
            assertEquals("Некорректное значение громкости -10", exception.getMessage());
            exception = assertThrows(IllegalArgumentException.class, () -> new TV(1, 101));
            assertEquals("Некорректное значение громкости 101", exception.getMessage());
        }

        @Test
        void testSetCurrentChannel() {
            Exception exception;
            TV tv = new TV(1, 10);
            exception = assertThrows(IllegalArgumentException.class, () -> tv.setCurrentChannel(-2));
            assertEquals("Неверный номер канала -2", exception.getMessage());
            exception = assertThrows(IllegalArgumentException.class, () -> tv.setCurrentChannel(51));
            assertEquals("Неверный номер канала 51", exception.getMessage());
            tv.setCurrentChannel(50);
            assertEquals(50, tv.getCurrentChannel());
        }

        @Test
        void testSetVolume() {
            TV tv = new TV(1, 10);
            Exception exception;
            exception = assertThrows(IllegalArgumentException.class, () -> tv.setVolume(-10));
            assertEquals("Некорректное значение громкости -10", exception.getMessage());
            exception = assertThrows(IllegalArgumentException.class, () -> tv.setVolume(101));
            assertEquals("Некорректное значение громкости 101", exception.getMessage());
            tv.setVolume(99);
            assertEquals(99, tv.getVolume());
        }

        @Test
        void testNextChannel() {
            TV tv = new TV(1, 10);
            assertEquals(1, tv.getCurrentChannel());
            tv.nextChannel();
            assertEquals(2, tv.getCurrentChannel());
            tv.setCurrentChannel(50);
            assertEquals(50, tv.getCurrentChannel());
            tv.nextChannel();
            assertEquals(1, tv.getCurrentChannel());
        }
    }

    @Nested
    class testOrderClass {

        @Test
        void testAddItem() {
            Order order = new Order();
            Exception exception;
            exception = assertThrows(IllegalArgumentException.class, () -> order.addItem("", 240.00));
            assertEquals("Некорректное наименование товара", exception.getMessage());
            exception = assertThrows(IllegalArgumentException.class, () -> order.addItem("Лист ДВП", -240.00));
            assertEquals("Цена товара не может быть меньше нуля", exception.getMessage());
        }

        @Test
        void testGetTotalPrice() {
            Order order = new Order();
            assertEquals(0, order.getTotalPrice());
            order.addItem("Лист ДВП", 240.00);
            order.addItem("Лист ДВП", 240.00);
            assertEquals(480, order.getTotalPrice());
        }

        @Test
        void testGetOrderInfo() {
            Order order = new Order();
            UUID uuid = order.getOrderId();
            assertEquals("Номер заказа: " + uuid + "\n" +
                    "Итого: 0.0\n" +
                    "Список товаров в количестве: 0\n", order.getOrderInfo());
            order.addItem("Лист ДВП", 240.0);
            order.addItem("Лист ДВП", 240.0);
            assertEquals("Номер заказа: " + uuid + "\n" +
                    "Итого: 480.0\n" +
                    "Список товаров в количестве: 2\n" +
                    "0. Лист ДВП: 240.0\n" +
                    "1. Лист ДВП: 240.0\n", order.getOrderInfo());
        }
    }
}

