import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> correctAnimals = new ArrayList<>();

        // валидные записи
        correctAnimals.add("CAT Барсик");
        correctAnimals.add("CAT Мурзик");
        correctAnimals.add("CAT Пушок");

        correctAnimals.add("DOG Виски");
        correctAnimals.add("DOG Виски");
        correctAnimals.add("DOG Виски");
        correctAnimals.add("DOG Виски");

        correctAnimals.add("COW Гаврюша");
        correctAnimals.add("COW Буренка");

        correctAnimals.add("HORSE Молния");
        correctAnimals.add("HORSE Слевин");
        correctAnimals.add("HORSE Мустанг");

        correctAnimals.add("NOT_DEFINED Anon");

        AnimalFarm correctFarm = new AnimalFarm(correctAnimals);
        System.out.println(correctFarm.countedAnimals() + "\n");
        System.out.println(correctFarm.uniqueNames() + "\n");

        List<String> incorrectAnimals = Arrays.asList("CAT ", "CAT", "CAT Пушок",
                "DOG Виски", "DOG Виски", "DOG Виски", "DOG Виски",
                "Гаврюша", " Буренка", " ",
                "HORSEE Молния", "HORSEE", " Мустанг");

        AnimalFarm incorrectFarm = new AnimalFarm(incorrectAnimals);
        System.out.println(incorrectFarm.countedAnimals() + "\n");
        System.out.println(incorrectFarm.uniqueNames() + "\n");
    }
}
