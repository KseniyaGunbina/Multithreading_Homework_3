import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.IntStream;

public class Main {
    public static final int MIN = 0;
    public static final int MAX = 300000;

    public static void main(String[] args) {
        int[] arr = IntStream.range(MIN, MAX).toArray();

        // однопоточное решение
        long now = System.currentTimeMillis();
        int sum = Arrays.stream(arr)
                .sum();
        long finish = System.currentTimeMillis();
        System.out.printf("Сумма всех значений: %s. Время однопоточного решения %s мс\n", sum, finish - now);

        // многопоточное решение
        now = System.currentTimeMillis();
        int start = 0;
        int end = arr.length;

        final Integer middle = (end - start) / 2; // делим массив пополам
        RecursiveTask<Integer> task1 = new ArraySum(start, middle, arr); // поток для подсчета суммы первой половины
        RecursiveTask<Integer> task2 = new ArraySum(middle, end, arr); // поток для подсчета суммы второй половины
        RecursiveTask.invokeAll(task1, task2); // пул двух потоков
        finish = System.currentTimeMillis();
        System.out.printf("Сумма всех значений: %s. Время многопоточного решения %s мс\n", task1.join() + task2.join(), finish - now);
    }
}


