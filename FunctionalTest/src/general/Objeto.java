package general;

public class Objeto {

    private boolean isException;

    public Objeto(boolean isException){
        this.isException = isException;
    }

    public void execute() throws Exception {
        if (isException){
            System.out.println("Voy a arrojar");
            throw new Exception("Error");
        }
    }
}
