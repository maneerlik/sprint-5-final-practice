import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * Класс AnimalFarm (ферма).
 * У него одно поле — список строк farmAnimals. Создай конструктор с этим параметром.
 * В этом списке лежат данные по всем животным на ферме в виде двух слов, разделенных пробелом:
 * Вид_животного Имя_животного. Например, DOG Жучка.
 */
public class AnimalFarm {
    private List<String> farmAnimals;

    public AnimalFarm() {
        this.farmAnimals = new ArrayList<>();
    }

    /**
     * В классе AnimalFarm реализуй метод countedAnimals.
     * Он должен по полю farmAnimals формировать хеш-таблицу, в которой ключ — это вид животного (Animal),
     * а значение — количество животных этого вида на ферме. Если какая-то строка в списке не содержит первым словом
     * валидный вид животного, метод должен вывести в консоль фразу:
     * Please correct string [Здесь вывести полностью ошибочную строку]. Incorrect input data.
     * Метод возвращает сформированную хеш-таблицу.
     */
    public HashMap<Animal, Long> countedAnimals() {
        HashMap<Animal, Long> animals = new HashMap<>();

        for(String animal : farmAnimals) {
            try {
                // проверяет является ли первое слово валидным типом перечисления
                Animal.valueOf(animal.substring(0, animal.indexOf(" ")));
            } catch(IllegalArgumentException e) {
                System.out.printf("Please correct string [%s]. Incorrect input data.\n", animal);
                System.exit(1);
            }
        }

        // считает количество животных по типам
        for(Animal a : Animal.values()) {
            animals.put(a, farmAnimals.stream()
                .filter(s -> s.contains(a.getType()))
                .count());
        }

        return animals;
    }

    /**
     * В классе AnimalFarm реализуй метод uniqueNames.
     * Он должен возвращать коллекцию всех уникальных имён животных на ферме. Подходящий тип коллекции подбери
     * самостоятельно. Если в какой-то строке списка нет второго слова, метод должен вывести в консоль фразу:
     * Please correct string [Здесь вывести полностью ошибочную строку]. Incorrect input data.
     */
    public HashSet<String> uniqueNames() {
        HashSet<String> names = new HashSet<>();

        for(String animal : farmAnimals) {
            if(animal.substring(animal.indexOf(" ")+1).equals("N")) {
                System.out.printf("Please correct string [%s]. Incorrect input data.\n", animal);
                System.exit(1);
            }

            names.add(animal.substring(animal.indexOf(" ")+1));
        }

        return names;
    }

    /**
     * В классе AnimalFarm реализуй три метода для разных вариантов добавления нового животного на ферму:
     * по переданному виду животного и имени;
     * по переданному виду животного. В этом случае имя животного равно N;
     * по переданному имени животного. В этом случае вид животного равен NOT_DEFINED.
     */
    public void addAnimal(Animal type, String name) {
        farmAnimals.add(String.join(" ", type.getType(), name));
    }

    public void addAnimal(Animal type) {
        farmAnimals.add(String.join(" ", type.getType(), "N"));
    }

    public void addAnimal(String name) {
        farmAnimals.add(String.join(" ", Animal.NOT_DEFINED.getType(), name));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for(String s : farmAnimals) {
            sb.append(s + "\n");
        }

        return sb.toString();
    }
}