import java.io.*;

public class Main {

    /**
     Разработайте класс Student с полями String name, int age, transient double GPA (средний балл).
     Обеспечьте поддержку сериализации для этого класса. Создайте объект класса Student и инициализируйте его данными.
     Сериализуйте этот объект в файл. Десериализуйте объект обратно в программу из файла.
     Выведите все поля объекта, включая GPA, и обсудите, почему значение GPA не было сохранено/восстановлено.
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Student user1 = new Student("Алексей", 15, 5.0);
        Student user2 = new Student("Николай", 17, 4.9);

        try(FileOutputStream fileOutputStream = new FileOutputStream("S_3_HMW_task_1.bin");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)){
            objectOutputStream.writeObject(user1);
            System.out.println("\nОбъект User1 сериализован.");
            objectOutputStream.writeObject(user2);
            System.out.println("Объект User2 сериализован.");
        }

        try(FileInputStream fileInputStream = new FileInputStream("S_3_HMW_task_1.bin");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)){
            user1 = (Student)objectInputStream.readObject();
            System.out.println("\nОбъект User1 десериализован.");
            user2 = (Student)objectInputStream.readObject();
            System.out.println("Объект User2 десериализован.");
        }

        System.out.println("\nОбъект User1:");
        System.out.println("Имя:          " + user1.getName());
        System.out.println("Возраст:      " + user1.getAge());
        System.out.println("Средний балл: " + user1.getGPA());

        System.out.println("\nОбъект User2:");
        System.out.println("Имя:          " + user2.getName());
        System.out.println("Возраст:      " + user2.getAge());
        System.out.println("Средний балл: " + user2.getGPA());

        System.out.println("""

                Примечание:
                     Данные о среднем балле не были сохранены в файл и не были восстановлены потому,
                     что значение transient double GPA (средний балл) не было сериализовано, т.к. она
                     является transient-свойством и не входит в состав обычного определения класса.
                     Transient-свойства не сохраняются в БД Hibernate, потому что они временные
                     и не являются частью состояния объекта. Они используются для оптимизации производительности
                     и улучшения работы приложения.""");
    }
}