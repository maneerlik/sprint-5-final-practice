import static java.util.Arrays.asList;

public class Main {
    public static void main(String[] args) {
        AnimalFarm farm = new AnimalFarm(asList("DOG Коко", "CAT Пушок", "CAT Мурзик", "COW Гаврюша", "CAT Барсик", "DOG Туман"));

        System.out.println(farm.countedAnimals());
    }
}
