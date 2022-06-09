package functional;

import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class FP03FunctionalInterfaces {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 4, 12, 15);

        Predicate<Integer> isEvenPredicate = x -> x % 2 == 0;
        Predicate<Integer> isEvenPredicate2 = new Predicate<Integer>() {
            @Override
            public boolean test(Integer x) {
                return x % 2 == 0;
            }
        };
        Function<Integer, Integer> squareFunction = x -> x * x;
        Function<Integer, Integer> squareFunction2 = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer x) {
                return x * x;
            }
        };
        Consumer<Integer> sysoutConsumer = System.out::println;
        Consumer<Integer> sysoutConsumer2 = new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        };
        numbers.stream()
                .filter(isEvenPredicate2)
                .map(squareFunction2)
                .forEach(sysoutConsumer2);

        BinaryOperator<Integer> sum1 = Integer::sum;
        BinaryOperator<Integer> sum2 = new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer integer, Integer integer2) {
                return Integer.sum(integer, integer2);
            }
        };
        int sum = numbers.stream().reduce(0, sum2);
        System.out.println("sum "+sum);
    }
}
