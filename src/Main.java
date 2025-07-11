public class Main {
    public static void main(String[] args) {
        Book book = new Book();
        book.displayInfo();

        book.title = "Философия Java";
        book.author = "Борис Эккель";
        book.pagesCount = 1168;

        book.displayInfo();

        Person person = new Person();
        person.displayInfo();

        person = new Person("Павел");
        person.displayInfo();

        person = new Person("Иоанн", 100);
        person.displayInfo();

        Account account = new Account();
        System.out.println(account.getBalance());

        account.deposit(100); // 100
        account.deposit(80); // 180
        account.deposit(-100); // 180
        account.withdraw(100); // 0
        account.withdraw(80); // 0
        account.withdraw(1); // 0
        System.out.println(account.getBalance());

    }
}