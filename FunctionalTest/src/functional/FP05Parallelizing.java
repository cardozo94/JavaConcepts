package functional;

import java.util.stream.LongStream;

public class FP05Parallelizing {

    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        //System.out.println(LongStream.range(0,1000000000).sum());
        //1339+1325+1326+1321+1357+1343+1378+1320+1342+1318
        System.out.println(LongStream.range(0,1000000000).parallel().sum());
        //99+102+98+107+91+110+93+106+103+102
        System.out.println(System.currentTimeMillis()-time);
    }
}
