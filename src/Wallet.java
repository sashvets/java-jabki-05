/**
 * 1) Класс «Кошелек»:
 * Поля: owner (private), money (private).
 * Конструктор с параметрами owner, money.
 * Геттеры и сеттеры с валидацией: money не может быть отрицательным.
 * Метод spend(int amount), уменьшающий money.
 */
public class Wallet {
    private String owner;
    private int money;


    public Wallet(String owner, int money) {
        checkOwner(owner);
        this.owner = owner;
        checkMoney(money);
        this.money = money;
    }

    private void checkOwner(String owner) {
        if (owner.trim().equals("")) {
            throw new IllegalArgumentException("Владелец кошелька должен быть указан");
        }
    }

    private void checkMoney(int money) {
        if (money < 0) {
            throw new IllegalArgumentException("Средства в кошельке не могут быть меньше нуля");
        }
    }

    public void setOwner(String owner) {
        checkOwner(owner);
        this.owner = owner;
    }

    public String getOwner() {
        return this.owner;
    }

    public void setMoney(int money) {
        checkMoney(money);
        this.money = money;
    }

    public int getMoney() {
        return this.money;
    }

    public void spend(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Сумма расходов должна быть положительной. Указано: " + amount);
        }
        if (amount > money) {
            throw new IllegalArgumentException("Недостаточно средств. Сумма " + amount + " больше чем есть в кошельке " + this.money);
        }
        this.money -= amount;
    }
}
