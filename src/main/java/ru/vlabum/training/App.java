package ru.vlabum.training;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Hello Generic!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        System.out.println( "Hello Generic!" );
        System.out.println( "See tests." );
    }

    /**
     * Меняет местами два элемента массива
     * @param array     - массив элементов
     * @param index1    - индекс первого меняемого элемента
     * @param index2    - индекс второго меняемого элемента
     * @param <T>       - параметризованный тип элементов массива
     */
    static <T> void change(final T[] array, final int index1, final int index2) {
        if (index1 >= array.length || index2 >= array.length || index1 == index2 || index1 < 0 || index2 < 0)
            return;
        final T tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
    }

    /**
     * Создает ArrayList на основе массива
     * @param array - массив элементов
     * @param <T>   - параметризованный тип элементов
     * @return      - ArrayList<T>
     */
    static <T> ArrayList<T> makeArrayList(final T[] array) {
        return new ArrayList<>(Arrays.asList(array));
    }

}