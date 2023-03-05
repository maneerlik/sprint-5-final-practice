import java.util.HashMap;
import java.util.List;

/**
 * Класс AnimalFarm (ферма).
 * У него одно поле — список строк farmAnimals. Создай конструктор с этим параметром.
 * В этом списке лежат данные по всем животным на ферме в виде двух слов, разделенных пробелом:
 * Вид_животного Имя_животного. Например, DOG Жучка.
 */

public class AnimalFarm {
    private List<String> farmAnimals;

    public AnimalFarm(List<String> farmAnimals) {
        this.farmAnimals = farmAnimals;
    }

    /**
     * В классе AnimalFarm реализуй метод countedAnimals. Он должен по полю farmAnimals формировать хеш-таблицу,
     * в которой ключ — это вид животного (Animal), а значение — количество животных этого вида на ферме.
     * Если какая-то строка в списке не содержит первым словом валидный вид животного, метод должен вывести
     * в консоль фразу: Please correct string [Здесь вывести полностью ошибочную строку]. Incorrect input data.
     * Метод возвращает сформированную хеш-таблицу.
     */

    public HashMap<Animal, Long> countedAnimals() {
        HashMap<Animal, Long> animals = new HashMap<>();

        // проверяет является ли первое слово валидным типом перечисления
        for(String animal : farmAnimals) {
            try {
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
}