import java.util.ArrayList;
import java.util.List;

public class Calculate implements Runnable {
    private static List<Integer> oddNumbers;
    private static List<Integer> evenNumbers;
    private List<Integer> numbers;
    String name;
    int i = 0;


    public Calculate(List<Integer> numbers, String name) {
        this.numbers = numbers;
        this.name = name;
        oddNumbers = new ArrayList<>();
        evenNumbers = new ArrayList<>();
    }


    @Override
    public void run() {
        System.out.println(this.name + " Calisiyor.");
        for (int number : numbers) {
            addNumber(number);
        }
        System.out.println(this.name+" Toplam tek: "+oddNumbers.size()+" Toplam çift: "+evenNumbers.size());
    }

    public void addNumber(int number) {
        if (number % 2 == 0){
            synchronized (evenNumbers){
                evenNumbers.add(number);
            }
        }else {
            synchronized (oddNumbers){
                oddNumbers.add(number);
            }
        }
    }

    public static List<Integer> getOddNumbers() {
        return oddNumbers;
    }

    public static List<Integer> getEvenNumbers() {
        return evenNumbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}