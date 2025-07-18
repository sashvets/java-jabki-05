import java.util.Objects;

public class Homework {
    public static void main(String[] args) {
        Wallet wallet = new Wallet("Ганс", 0);
        wallet.setMoney(100);
        wallet.spend(10);
        System.out.printf("У гражданина по имени %s в кошельке %s монет %s", wallet.getOwner(), wallet.getMoney(), System.lineSeparator());

        Game game = new Game();
        int secretNumber = 0;
        while (!game.checkGuess(secretNumber).equals("Угадал") && secretNumber != 100) {
            secretNumber++;
        }
        System.out.printf("%s загаданное число %s%s", game.checkGuess(secretNumber), secretNumber, System.lineSeparator());

        TV tv = new TV(1, 0);
        tv.nextChannel();
        System.out.printf("Текущий канал %s, громкость %s%s", tv.getCurrentChannel(), tv.getVolume(), System.lineSeparator());
        tv.setVolume(10);
        System.out.printf("Текущий канал %s, громкость %s%s", tv.getCurrentChannel(), tv.getVolume(), System.lineSeparator());
        tv.setCurrentChannel(50);
        System.out.printf("Текущий канал %s, громкость %s%s", tv.getCurrentChannel(), tv.getVolume(), System.lineSeparator());
        tv.nextChannel();
        System.out.printf("Текущий канал %s, громкость %s%s", tv.getCurrentChannel(), tv.getVolume(), System.lineSeparator());

        Order order = new Order();
        order.addItem("Труба 32 ПВХ", 250.00);
        order.addItem("Труба 32 ПВХ", 250.00);
        order.addItem("Труба 32 ПВХ", 250.00);
        order.addItem("Труба 32 ПВХ", 250.00);
        order.addItem("Клипса 20 трубы", 15.00);
        order.addItem("ГКЛ 1.5x3м", 450.);
        order.addItem("ГКЛ 1.5x3м", 450.);
        order.addItem("ГКЛ 1.5x3м", 450.);
        order.addItem("ГКЛ 1.5x3м", 450.);
        order.addItem("ГКЛ 1.5x3м", 450.);
        order.addItem("ГКЛ 1.5x3м", 450.);
        order.addItem("ГКЛ 1.5x3м", 450.);
        System.out.println(order.getOrderInfo());
    }
}
