public class Book {
    String title;
    String author;
    int pagesCount;
    String advisor = "Ростислав";

    public void displayInfo() {
        System.out.printf(
                "Книга: %s, Автор: %s, Страниц: %s Посоветовал: %s%s",
                title,
                author,
                pagesCount,
                advisor,
                System.lineSeparator());
    }
}
