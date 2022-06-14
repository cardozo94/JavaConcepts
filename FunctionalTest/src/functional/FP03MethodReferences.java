package functional;

import java.util.List;
import java.util.Locale;
import java.util.function.Supplier;

public class FP03MethodReferences {
    public static void main(String[] args) {
        List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices","AWS","PCF","Azure","Docker","Kubernetes");
        //static reference
        courses.stream()
                .map(str -> str.toUpperCase())
                .forEach(FP03MethodReferences::print);
        //no static reference
        courses.stream()
                .map(String::toUpperCase)
                .forEach(FP03MethodReferences::print);
        //constructor reference

        Supplier<String> supplier = () -> new String();
        Supplier<String> supplier2 = String::new;
    }

    private static void  print(String str){
        System.out.println(str);
    }
}
