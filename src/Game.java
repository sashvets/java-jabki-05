/**
 * 2) Игра «Угадай число»:
 * Создайте класс Game с полем secretNumber (private, случайное число от 1 до 100).
 * Добавьте метод checkGuess(int guess), возвращающий "Больше", "Меньше" или "Угадал".
 */
public class Game {
    private final int secretNumber = (int) (Math.random() * 100);

    public String checkGuess(int guess) {
        if (guess > secretNumber) {
            return "Больше";
        } else if (guess < secretNumber)
            return "Меньше";
        return "Угадал";
    }
}
