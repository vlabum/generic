package ru.vlabum.training;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Работа с массивом Integer[]
     */
    @Test
    public void shouldChangeInteger()
    {
        Integer[] array = new Integer[5];
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
        App.change(array, 0, 4);
        Assert.assertArrayEquals(new Integer[]{4,1,2,3,0}, array);
    }

    /**
     * Работа с массивом String[]
     */
    @Test
    public void shouldChangeString()
    {
        String[] array = new String[5];
        for (int i = 0; i < array.length; i++) {
            array[i] = String.valueOf(i);
        }
        App.change(array, 0, 4);
        Assert.assertArrayEquals(new String[]{"4","1","2","3","0"}, array);
    }

    /**
     * Создание ArrayList<String> из String-массива
     */
    @Test
    public void shouldMakeStringArrayList()
    {
        String[] array = new String[5];
        ArrayList<String> expectedArrayList = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            array[i] = String.valueOf(i);
            expectedArrayList.add(String.valueOf(i));
        }
        ArrayList<String> arrayList = App.makeArrayList(array);
        Assert.assertNotNull(arrayList);
        Assert.assertTrue(expectedArrayList.equals(arrayList));
    }

    /**
     * Создание ArrayList<Integer> из Integer-массива
     */
    @Test
    public void shouldMakeIntegerArrayList()
    {
        Integer[] array = new Integer[5];
        ArrayList<Integer> expectedArrayList = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
            expectedArrayList.add(i);
        }
        ArrayList<Integer> arrayList = App.makeArrayList(array);
        Assert.assertNotNull(arrayList);
        Assert.assertTrue(expectedArrayList.equals(arrayList));
    }

    /**
     * Проверяем как сравнивается вес коробок, случай с одинаковым весом
     * Мы знаем, что вес каждого яблока = 1.0f, а вес каждого апельсина = 1.5f
     */
    @Test
    public void shouldSomeWeight()
    {
        Box<Apple> boxApple = new Box<>();
        Apple[] apples = new Apple[3];
        for (int i = 0; i < apples.length; i++) {
            apples[i] = new Apple();
        }
        boxApple.addAllFruits(App.makeArrayList(apples));

        Box<Orange> boxOrange = new Box<>();
        Orange[] oranges = new Orange[2];
        for (int i = 0; i < oranges.length; i++) {
            oranges[i] = new Orange();
        }
        boxOrange.addAllFruits(App.makeArrayList(oranges));

        Assert.assertTrue(boxApple.compare(boxOrange));
    }

    /**
     * Проверяем как сравнивается вес коробок, случай с разным весом коробок
     * Мы знаем, что вес каждого яблока = 1.0f, а вес каждого апельсина = 1.5f
     */
    @Test
    public void shouldDifferenceWeight()
    {
        Box<Apple> boxApple = new Box<>();
        Apple[] apples = new Apple[3];
        for (int i = 0; i < apples.length; i++) {
            apples[i] = new Apple();
        }
        boxApple.addAllFruits(App.makeArrayList(apples));

        Box<Orange> boxOrange = new Box<>();
        Orange[] oranges = new Orange[3];
        for (int i = 0; i < oranges.length; i++) {
            oranges[i] = new Orange();
        }
        boxOrange.addAllFruits(App.makeArrayList(oranges));

        Assert.assertFalse(boxApple.compare(boxOrange));
    }

    /**
     * Пересыпать из коробки в коробку все яблоки
     * Мы знаем, что вес каждого яблока = 1.0f, а вес каждого апельсина = 1.5f
     */
    @Test
    public void shouldPourBoxApples()
    {
        Box<Apple> boxAppleFrom = new Box<>();
        Apple[] apples = new Apple[3];
        for (int i = 0; i < apples.length; i++) {
            apples[i] = new Apple();
        }
        boxAppleFrom.addAllFruits(App.makeArrayList(apples));

        Box<Apple> boxAppleTo = new Box<>();

        Box.pour(boxAppleFrom, boxAppleTo);

        Assert.assertTrue(boxAppleFrom.getWeight() == 0.0f);
        Assert.assertTrue(boxAppleTo.getWeight() == 3.0f);
    }

    /**
     * Пересыпать из коробки в коробку все апельсины
     * Мы знаем, что вес каждого яблока = 1.0f, а вес каждого апельсина = 1.5f
     */
    @Test
    public void shouldPourBoxOranges()
    {
        Box<Orange> boxOrangeFrom = new Box<>();
        Orange[] oranges = new Orange[2];
        for (int i = 0; i < oranges.length; i++) {
            oranges[i] = new Orange();
        }
        boxOrangeFrom.addAllFruits(App.makeArrayList(oranges));

        Box<Orange> boxOrangeTo = new Box<>();

        Box.pour(boxOrangeFrom, boxOrangeTo);

        Assert.assertTrue(boxOrangeFrom.getWeight() == 0.0f);
        Assert.assertTrue(boxOrangeTo.getWeight() == 3.0f);
    }
}
