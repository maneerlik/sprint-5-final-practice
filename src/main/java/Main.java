public class Main {
    public static void main(String[] args) {
        AnimalFarm farm = new AnimalFarm();

        farm.addAnimal(Animal.CAT, "Барсик");
        farm.addAnimal(Animal.CAT, "Мурзик");
        farm.addAnimal(Animal.CAT, "Мурзик");
        farm.addAnimal(Animal.CAT, "Мурзик");
        farm.addAnimal(Animal.CAT, "Nomad");
        farm.addAnimal("Rik");
        farm.addAnimal("Morty");
        farm.addAnimal(Animal.HORSE, "Гектор");
        farm.addAnimal(Animal.HORSE, "Soul");
        farm.addAnimal("Ahel");

        System.out.println(farm.countedAnimals());
        System.out.println(farm.uniqueNames());
    }
}
