import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

public class ArraySum extends RecursiveTask<Integer> {
    final private int MIN;
    final private int MAX;
    final private int[] ARR;

    public ArraySum(int min, int max, int[] arr) {
        MIN = min;
        MAX = max;
        ARR = arr;
    }

    @Override
    public Integer compute() {
        return Arrays.stream(Arrays.copyOfRange(ARR, MIN, MAX)).sum();
    }
}
