import java.util.ArrayList;
import java.util.List;

/**
 * Класс-перечисление Animal (животное).
 * В нём есть такие виды животных:
 *      CAT (кошка),
 *      DOG (собака),
 *      HORSE (лошадь),
 *      COW (корова),
 *      NOT_DEFINED (не определён).
 */

public enum Animal {
    CAT("CAT", "кошка"),
    DOG("DOG", "собака"),
    HORSE("HORSE","лошадь"),
    COW("COW","корова"),
    NOT_DEFINED("NOT_DEFINED","не определён");

    private String type;
    private String description;

    Animal(String type, String description) {
        this.type = type;
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }
}