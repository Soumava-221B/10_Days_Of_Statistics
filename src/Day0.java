import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Day0 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        scanner.nextLine();

        int[] arrayOne = Stream.of(scanner.nextLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        int[] secondArray = Stream.of(scanner.nextLine().split(" ")).mapToInt(Integer::valueOf).toArray();


        calculateNominator(arrayOne, secondArray);

        double result = calculateNominator(arrayOne, secondArray) / (double) IntStream.of(secondArray).sum();

        System.out.println(String.format("%.1f", result));
    }

    private static int calculateNominator(int[] arrayOne, int[] secondArray) {
        int accumulator = 0;
        for (int i = 0; i < arrayOne.length; i++) {
            accumulator += arrayOne[i] * secondArray[i];
        }

        return accumulator;
    }
}