package functional;

import java.util.ArrayList;
import java.util.List;

public class Pruebas {
	
	public static void main(String[] args) {
		ArrayList<String> lista = new ArrayList<>();
		lista.add("Perro");
		lista.add("carro");
		lista.add("conejo");
		lista.add("gato");
		lista.add("casa");
		lista.add("construuccion");
		
		lista.stream().filter(obj -> obj.startsWith("c")).forEach(System.out::println);
		
//	listac.stream().forEach(System.out::println);
		List<Integer> numbers = List.of(3,5,4,92,16,85,85,128,18,52,86,212,72,13,64,941,5);
		numbers.stream().filter(n -> (n%2)!=0).forEach(System.out::println);
	}

}
