package ru.vlabum.training;

import lombok.Getter;

@Getter
class Fruit {

    private float weight;

    Fruit(final float weight) {
        this.weight = weight;
    }

}
