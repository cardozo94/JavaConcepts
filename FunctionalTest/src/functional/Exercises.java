package functional;

import java.util.List;

public class Exercises {

	static List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices","AWS","PCF","Azure","Docker","Kubernetes");
	
	public static void main(String[] args) {
		printOddNumbresFromList();
		System.out.println();
		printAllCoursesIndividually();
		System.out.println();
		printCoursesContainingWordSpring();
		System.out.println();
		printCoursesWhoseNameHasAtLeast4Letters();
	}
	
	private static void printCoursesWhoseNameHasAtLeast4Letters() {
		courses.stream().filter(w -> w.length() >= 4).forEach(System.out::println);		
	}

	private static void printCoursesContainingWordSpring() {
		courses.stream().filter(w -> w.contains("Spring")).forEach(System.out::println);
		
	}

	private static void printAllCoursesIndividually() {
		courses.stream().forEach(System.out::println);
		
	}

	public static void printOddNumbresFromList() {
		List<Integer> numbers = List.of(1, 8, 3, 4, 6, 12, 19, 15, 56, 48);
		numbers.stream().filter(n -> (n%2) != 0).forEach(System.out::println);
	}

}
