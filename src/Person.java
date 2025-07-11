public class Person {

    private String name;
    private int age;

    Person() {
        this.name = "Неизвестно";
        this.age = 18;
    }

    Person(String name) {
        this.name = name;
        this.age = 18;
    }

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void displayInfo() {
        System.out.printf(
                "Имя: %s, Возраст: %s%s",
                this.name,
                this.age,
                System.lineSeparator());
    }
}
