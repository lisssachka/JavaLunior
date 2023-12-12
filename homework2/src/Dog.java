public class Dog extends Animal{

    private boolean trainingAvailability;           // Наличие дрессировки.
    private boolean medalsAvailability;             // Наличие медалей.

    public Dog(String name, int age, boolean trainingAvailability, boolean medalsAvailability) {
        super(name, age);
        this.trainingAvailability = trainingAvailability;
        this.medalsAvailability = medalsAvailability;
    }

    @Override
    public String toString() {
        return "\nСобака: " + name +
                "\nВозраст: " + age + " лет" +
                "\nДрессировка: " + trainingAvailability +
                "\nНаграды: " + medalsAvailability;
    }

    public void makeSound() {
        System.out.println("Голос: собака лает!");                                  // Издает звуки.
    }


    public void showAffection() {                                                   // Проявляет ласку.
        System.out.println("Собака машет хвостом.");
    }

    public void training() {                                                        // Собака готова к дрессировке
        System.out.println("Собака выполнила команду сидеть и ждет дальнейших указаний.");
    }
}