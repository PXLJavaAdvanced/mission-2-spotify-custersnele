package be.pxl.ja;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.Stream;

public class Demo {
    public static void main(String[] args) {
        List<String> animals = Arrays.asList("Bear", "Zebra", "Cat", "Camel", "Caterpilar", "Zebra");
        System.out.println(animals.stream().distinct().count());
        animals.stream()
                .distinct()
                .filter(s -> s.startsWith("Ca"))
                .sorted()
                .forEach(System.out::println);
        ToIntFunction<String> lengthOfString = String::length;
        OptionalInt max = animals.stream()
                .filter(a -> a.startsWith("X"))
                .mapToInt(lengthOfString)
                .max();
        if (max.isPresent()) {
            System.out.println(max.getAsInt());
        } else {
            System.out.println("No answer");
        }


    }

    // METHOD REFERENCE: Klassenaam::methode
}
