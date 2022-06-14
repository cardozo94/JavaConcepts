package functional;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FP03BehaviorParametrization {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 4, 12, 15);
        Predicate<Integer> evenPredicate = x -> x % 2 == 0;
        Predicate<Integer> oddPredicate = x -> x % 2 != 0;
        //filterAndPrint(numbers, evenPredicate);
        //filterAndPrint(numbers, oddPredicate);
        filterAndPrint(numbers, x -> x%3==0);
        Function<Integer, Integer> squaredFunction = number -> number * number;
        List<Integer> squaredNumbers = mapAndCreateNewList(numbers, squaredFunction);
        System.out.println(squaredNumbers);
        List<Integer> cubeNumbers = mapAndCreateNewList(numbers, number -> number*number*number);
        System.out.println(cubeNumbers);
    }

    private static List<Integer> mapAndCreateNewList(List<Integer> numbers, Function<Integer, Integer> function) {
        return numbers.stream()
                .map(function)
                .collect(Collectors.toList());
    }

    private static void filterAndPrint(List<Integer> numbers, Predicate<Integer> predicate) {
        numbers.stream().filter(predicate).forEach(System.out::println);
    }
}
