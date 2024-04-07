import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class NumberProcessor {
    private List<Integer> numbers = new ArrayList<>();

    public void addNumber(int number) {
        numbers.add(number);
    }

    public int sumOfEvenNumbers() {
        return numbers.stream()
                .filter(num -> num % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public List<Integer> multiplyBy2() {
        return numbers.stream()
                .map(num -> num * 2)
                .collect(Collectors.toList());
    }

    public int findMax() {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElseThrow(() -> new IllegalStateException("List is empty"));
    }

    public String oddNumbersAsString() {
        return numbers.stream()
                .filter(num -> num % 2 != 0)
                .map(Object::toString)
                .collect(Collectors.joining(", "));
    }

    public double calculateAverage() {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(Double.NaN);
    }

    public static void main(String[] args) {
        NumberProcessor processor = new NumberProcessor();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter numbers (type 'done' to finish):");
        while (scanner.hasNextInt()) {
            int number = scanner.nextInt();
            processor.addNumber(number);
        }

        System.out.println("Sum of even numbers: " + processor.sumOfEvenNumbers());
        System.out.println("List multiplied by 2: " + processor.multiplyBy2());
        System.out.println("Max number: " + processor.findMax());
        System.out.println("Odd numbers: " + processor.oddNumbersAsString());
        System.out.println("Average: " + processor.calculateAverage());
    }
}
