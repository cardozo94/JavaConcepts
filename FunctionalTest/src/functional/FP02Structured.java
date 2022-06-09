package functional;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FP02Structured {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(12,9,13,4,6,2,4,12,15);
        List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices","AWS","PCF","Azure","Docker","Kubernetes");
        int sum =  addListFunctional(numbers);
       // System.out.println(sum);
        //System.out.println("");
        //sumOfSquares(numbers);
        //System.out.println("");
        //sumOfCubes(numbers);
        //System.out.println("");
        //sumOfOddNumbers(numbers);
        //disctictAndSortedNumbers(numbers);
        //sortedWithComparator(courses);
        List<Integer> squareNumbers = squareNumbersList(numbers);
        System.out.println(squareNumbers);
        //List<Integer> evenNumbers = evenNumbersList(numbers);
        //System.out.println(evenNumbers);
        List<Integer> lengths = lengthList(courses);
        System.out.println(lengths);
    }

    private static List<Integer> lengthList(List<String> courses) {
        return courses.stream().map(course -> course.length()).collect(Collectors.toList());
    }

    private static List<Integer> evenNumbersList(List<Integer> numbers) {
        return numbers.stream().filter(x -> x%2 != 0).collect(Collectors.toList());
    }

    private static List<Integer> squareNumbersList(List<Integer> numbers) {
        return numbers.stream()
                .map(number -> number*number)
                .collect(Collectors.toList());
    }

    private static void sortedWithComparator(List<String> courses) {
        System.out.println("-- Natural order");
        courses.stream().sorted(Comparator.naturalOrder()).forEach(System.out::println);
        System.out.println("-- Reverse order");
        courses.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
        System.out.println("-- Comparing order");
        courses.stream().sorted(Comparator.comparing(str -> str.length())).forEach(System.out::println);
    }

    private static void disctictAndSortedNumbers(List<Integer> numbers){
        numbers.stream().distinct().forEach(System.out::println);
        numbers.stream().sorted().forEach(System.out::println);
    }

    private static void sumOfOddNumbers(List<Integer> numbers) {
        System.out.println(numbers.stream().reduce(0, (x,y) -> (y%2) != 0 ? y+x:x));
        System.out.println(numbers.stream()
                .filter(y -> (y%2) != 0)
                .reduce(0, (x,y) -> y+x));
    }

    private static void sumOfCubes(List<Integer> numbers) {
        System.out.println(numbers.stream().reduce(0, (x,y) -> (y*y*y)+x));
        System.out.println(numbers.stream()
                .map(y-> (y*y*y))
                .reduce(0, (x,y) -> y+x));
    }

    private static void sumOfSquares(List<Integer> numbers) {
        System.out.println(numbers.stream().reduce(0, (x,y) -> (y*y)+x));
        System.out.println(numbers.stream().map(y -> (y*y)).reduce(0, (x,y) -> y+x));
    }

    private static int addListFunctional(List<Integer> numbers) {
        return numbers.stream()
               // .reduce(0, FP02Structured::sum);
                //.reduce(0, (x,y)-> x+y);
                .reduce(0, Integer::sum);
    }

    private static int sum(int a, int b) {
        System.out.println(a+" "+b);
        return a+b;
    }
}
