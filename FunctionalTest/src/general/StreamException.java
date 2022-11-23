package general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StreamException {

    public static void main(String[] args) {
        Objeto objeto1 = new Objeto(false);
        Objeto objeto2 = new Objeto(false);
        Objeto objeto3 = new Objeto(false);
        Objeto objeto4 = new Objeto(false);
        Objeto objeto5 = new Objeto(true);
        Objeto objeto6 = new Objeto(false);
        Objeto objeto7 = new Objeto(false);
        Objeto objeto8 = new Objeto(false);
        Objeto objeto9 = new Objeto(false);
        Objeto objeto10 = new Objeto(false);

        List<Objeto> list = Arrays.asList(objeto1, objeto2, objeto3, objeto4, objeto5, objeto6, objeto7, objeto8, objeto9, objeto10);
        System.out.println("Inicios");
        list.stream().forEach( obj -> {
            try {
                System.out.println("peek");
                obj.execute();
            } catch (Exception e) {
                System.out.println("exception");
                throw new RuntimeException(e);
            }
        });
    }
}
