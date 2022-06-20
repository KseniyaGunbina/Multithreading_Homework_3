import java.util.Arrays;
import java.util.concurrent.RecursiveTask;

public class ArrSum extends RecursiveTask<Integer>  {
    final private int START;
    final private int FINISH;
    final private int[] ARR;

    public ArrSum(int start, int finish, int[] arr) {
        START = start;
        FINISH = finish;
        ARR = arr;
    }

    @Override
    protected Integer compute() {
        return Arrays.stream(Arrays.copyOfRange(ARR, START, FINISH)).sum();
    }
}
