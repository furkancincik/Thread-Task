import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> allNumbers = new ArrayList<>();

        for (int i = 0; i <= 10000; i++) {
            allNumbers.add(i);
        }

        Calculate c1 = new Calculate(allNumbers.subList(0,2501),"Thread-1");
        Calculate c2 = new Calculate(allNumbers.subList(2501,5001),"Thread-2");
        Calculate c3 = new Calculate(allNumbers.subList(5001,7501),"Thread-3");
        Calculate c4 = new Calculate(allNumbers.subList(7501,10000),"Thread-4");
        Thread t1 = new Thread(c1);
        Thread t2 = new Thread(c2);
        Thread t3 = new Thread(c3);
        Thread t4 = new Thread(c4);

        t1.start();
        t2.start();
        t3.start();
        t4.start();


    }
}