import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedList;


/*
### Задача 1:
Создайте абстрактный класс "Animal" с полями "name" и "age".
Реализуйте два класса-наследника от "Animal" (например, "Dog" и "Cat") с уникальными полями и методами.
Создайте массив объектов типа "Animal" и с использованием Reflection API выполните следующие действия:
Выведите на экран информацию о каждом объекте.
Вызовите метод "makeSound()" у каждого объекта, если такой метод присутствует.
 */
public class Main {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        // Создадим массив объектов Animal
        LinkedList<Animal> animals = new LinkedList<>();
        Animal cat = new Cat("Кузьма", 13, false, true);
        Animal dog = new Dog("Рэкс", 5, true, true);
        animals.add(cat);
        animals.add(dog);

        // Используем Reflection API для получения сведений об объектах и вызове метода "makeSound()"
        // при его наличии.

        for (Animal animal : animals) {
            // Получим класс объекта animal и сохраним его в переменную childClass.
            // Тип переменной childClass является универсальным.
            Class<?> childClass = animal.getClass();

            // С помощью метода getSuperclass() получим родительский класс для childClass
            // и сохраним его в переменную parentClass.
            Class<?> parentClass = childClass.getSuperclass();

            System.out.println("\nКласс " + childClass.getSimpleName() + " имеет поля:\n");

            // Получим переменные родительского класса для каждого объекта Animal
            Field[] parentFields = parentClass.getDeclaredFields();
            for (Field field : parentFields) {
                System.out.println("Поле родительского класса: " + field.getName() + " - " + field.get(animal));
            }

            // Получим переменные наследного класса для каждого объекта Animal
            Field[] fields = childClass.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                if (field.getType() == int.class) {
                    field.set(animal, 10);
                } else if (field.getType() == boolean.class) {
                    field.setAccessible(true);
                    System.out.println("Поле наследного класса:    " + field.getName() + " - " + field.get(animal));
                }
            }

            // Вызовем метод "makeSound" при его наличии
            Method[] methods = childClass.getDeclaredMethods();
            for (Method method : methods) {
                if (method.getName().equals("makeSound")) {
                    method.invoke(animal);
                    break;
                }
            }
        }
    }
}