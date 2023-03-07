import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Класс AnimalFarm (ферма).
 * У него одно поле — список строк farmAnimals. Создай конструктор с этим параметром.
 * В этом списке лежат данные по всем животным на ферме в виде двух слов, разделенных пробелом:
 * Вид_животного Имя_животного. Например, DOG Жучка.
 */
public class AnimalFarm {
    private List<String> farmAnimals;

    public AnimalFarm(List<String> animals) {
        this.farmAnimals = animals;
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

        // обработка некорректных строк
        for(String animal : farmAnimals) {
            // строка не полная и не является валидным типом ИЛИ полная и тип не валиден ИЛИ пустая
            if(!isFullString(animal) && !isValidType(animal) ||
                    isFullString(animal) && !isValidType(animal.split(" ")[0]) || animal.isBlank()) {
                System.out.printf("Please correct string [%s]. Incorrect input type.\n", animal);
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

        // обработка некорректных строк
        for(String animal : farmAnimals) {
            // строка не полная и тип валиден или пустая, пропускаем
            if(!isFullString(animal) && isValidType(animal) || animal.isBlank()) {
                System.out.printf("Please correct string [%s]. Incorrect input name.\n", animal);
                continue;
            }

            // если строка не пустая добавляем имя
            if(!animal.isBlank()) names.add(animal.substring(animal.indexOf(" ")+1));
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

    public boolean isFullString(String elem) {
        Pattern p = Pattern.compile("[A-Z]+\\s[А-Яа-яA-Za-z]+");
        Matcher matcher = p.matcher(elem);
        return matcher.find();
    }

    public boolean isValidType(String elem) {
        Pattern pType = Pattern.compile("[A-Z]+");
        Matcher mType = pType.matcher(elem);

        // если все символы заглавные, латинские
        if(mType.find()) {
            try {
                Animal.valueOf(elem.trim()); // валидный ли тип
                return true;
            } catch(IllegalArgumentException e) {
                return false;
            }
        }

        return false; // слово не является валидным типом
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