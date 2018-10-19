package ru.vlabum.training;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@NoArgsConstructor
@Getter
final class Box<T extends Fruit> {

    private ArrayList<T> fruits = new ArrayList<>();

    void addAllFruits(ArrayList<T> fruits) {
        this.fruits = fruits;
    }

    /**
     * "Пересыпает" все фрукты из одной коробки в другую
     * @param boxFrom   - источник фруктов
     * @param boxTo     - приемник фруктов
     * @param <T>       - Fruit или его производный тип
     */
    static <T extends Fruit> void pour(Box<T> boxFrom, Box<T> boxTo) {
        boxTo.addAllFruits(boxFrom.getFruits());
        boxFrom.clear();
    }

    /**
     * Вес фруктов в коробке, подразумевается, что все фрукты весят одинаково
     * @return  - общий вес фруктов в коробке
     */
    float getWeight() {
        if (fruits.isEmpty())
            return 0.0f;
        return fruits.size() * fruits.get(0).getWeight();
    }

    /**
     * Сравнивает коробки по весу
     * @param anotherBox    - коробка, с которой идет сравнение
     * @return              - true, если вес коробок одинаков
     */
    boolean compare(Box<?> anotherBox) {
        return this.getWeight() == anotherBox.getWeight();
    }

    /**
     * Опусташает коробку
     */
    void clear() {
        fruits = new ArrayList<>();
    }

}
