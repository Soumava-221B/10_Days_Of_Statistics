import java.util.Arrays;
import java.util.Scanner;

public class Day_0 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int sum = 0;
        for(int i = 0; i < n; i++)
        {
            int num = sc.nextInt();
            arr[i] = num;
            sum += num;
        }
        double mean = (double) sum / n;
        Arrays.sort(arr);
        double median;
        if(n % 2 == 0)
        {
            median = (arr[n / 2] + arr[n / 2 - 1]) / 2.0;
        }
        else
        {
            median = arr[n / 2];
        }
        int maxCount = 1;
        int count = 1;
        int current = arr[0];
        int mode = arr[0];
        for(int i = 1; i < arr.length; i++)
        {
            if(arr[i] == current)
            {
                count++;
            }
            else
            {
                count = 1;
                current = arr[i];
            }

            if(count > maxCount)
            {
                maxCount = count;
                mode = current;
            }
        }
        System.out.printf("%.1f\n%.1f\n%d", mean, median, mode);
    }
}
