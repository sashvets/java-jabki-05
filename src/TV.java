/**
 * 3) Класс «Телевизор»:
 * Поля: currentChannel (private), volume (private).
 * Геттеры и сеттеры:
 * volume может быть от 0 до 100.
 * currentChannel от 1 до 50.
 * Метод nextChannel() увеличивает канал на 1.
 */
public class TV {
    private int currentChannel;
    private int volume;
    private static final int MIN_CHANNEL = 1;
    private static final int MAX_CHANNEL = 50;
    private static final int MIN_VOLUME = 0;
    private static final int MAX_VOLUME = 100;

    public TV(int currentChannel, int volume) {
        checkCurrentChannel(currentChannel);
        this.currentChannel = currentChannel;
        checkVolume(volume);
        this.volume = volume;
    }

    private void checkCurrentChannel(int currentChannel) {
        if (currentChannel < MIN_CHANNEL || currentChannel > MAX_CHANNEL) {
            throw new IllegalArgumentException("Неверный номер канала " + currentChannel);
        }
    }

    private void checkVolume(int volume) {
        if (volume < MIN_VOLUME || volume > MAX_VOLUME) {
            throw new IllegalArgumentException("Некорректное значение громкости " + volume);
        }
    }

    public int getCurrentChannel() {
        return this.currentChannel;
    }

    public int getVolume() {
        return this.volume;
    }

    public void setCurrentChannel(int currentChannel) {
        checkCurrentChannel(currentChannel);
        this.currentChannel = currentChannel;
    }

    public void setVolume(int volume) {
        checkVolume(volume);
        this.volume = volume;
    }

    public void nextChannel() {
        if (this.currentChannel == MAX_CHANNEL) {
            this.currentChannel = MIN_CHANNEL;
        } else {
            this.currentChannel++;
        }
    }
}
