package pl.javastart.task;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        CustomList<String> customListOfStrings = new CustomList<>();
        CustomList<Integer> customListOfIntegers = new CustomList<>();
        for (int i = 0; i < 10; i++) {
            customListOfStrings.add("X");
        }
        customListOfStrings.remove(2);
        customListOfStrings.add(1, "rex");
        System.out.println(customListOfStrings);
        System.out.println("Rozmiar listy: " + customListOfStrings.size());
        for (int i = 1; i < 1000; i *= 2) {
            customListOfIntegers.add(i);
        }
        customListOfIntegers.remove(5);
        customListOfIntegers.add(5, 777);
        System.out.println(customListOfIntegers);
    }
}
