package functional;

import java.util.List;
import java.util.Random;
import java.util.function.*;

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

        Supplier<Integer> randomIntegerSupplier = () -> 2;
        System.out.println(randomIntegerSupplier.get());
        Supplier<Integer> randomIntegerSupplier2 = () -> {
            Random random = new Random();
            return random.nextInt(1000)+2;
        };
        System.out.println(randomIntegerSupplier2.get());

        UnaryOperator<Integer> unaryOperator = x -> 3*x;
        System.out.println(unaryOperator.apply(10));

        BiPredicate<Integer, String> biPredicate = (number, str) -> true;
        BiPredicate<Integer, String> biPredicate2 = (number, str) -> {
            return  number<10 && str.length()>5;
        };
        System.out.println(biPredicate.test(10,"in28minutes"));
        System.out.println(biPredicate2.test(10,"in28minutes"));

        BiFunction<Integer, String, String> biFunction = (number, str) -> {
            return  number+ " "+ str;
        };
        System.out.println(biFunction.apply(15, "in28minutes"));

        BiConsumer<Integer, String> biConsumer = (s1, s2) -> {
            System.out.println(s1);
            System.out.println(s2);
        };
        biConsumer.accept(15, "in28Minutes");

        IntBinaryOperator intBinaryOperator = (x,y) -> x+y;
        System.out.println(intBinaryOperator.applyAsInt(5, 7));
    }
}
