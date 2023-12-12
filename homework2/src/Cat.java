public class Cat extends Animal{

    private boolean participationInExhibitions;  // Участие в выставках.
    private boolean pedigree;                    // Наличие родословной.

    public Cat(String name, int age, boolean participationInExhibitions, boolean pedigree) {
        super(name, age);
        this.participationInExhibitions = participationInExhibitions;
        this.pedigree = pedigree;
    }

    @Override
    public String toString() {
        return "\nКот: "                  + name +
                "\nВозраст: "             + age + " лет" +
                "\nУчастие в выставках: " + participationInExhibitions +
                "\nНаличие родословной: " + pedigree;
    }


    public void makeSound() {                                                                       // Издает звуки.
        System.out.println("Голос: котик мяукает!");
    }

    public void showAffection() {                                                                   // Проявляет ласку.
        System.out.println("Котик мурлыкает и обтирается о Вашу ногу.");
    }

    public boolean isParticipationInExhibitions() {
        return participationInExhibitions;
    }

    public boolean isPedigree() {
        return pedigree;
    }
}