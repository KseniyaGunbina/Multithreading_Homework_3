import java.util.concurrent.RecursiveTask;

public class RecursiveTaskForSum extends RecursiveTask<Integer> {
    final private int START;
    final private int FINISH;
    final private int[] ARR;

    public RecursiveTaskForSum(int start, int finish, int[] arr) {
        super();
        START = start;
        FINISH = finish;
        ARR = arr;
    }

    @Override
    protected Integer compute() {
        final int diff = ARR.length - 0;
        switch (diff) {
            case 0: return 0;
            case 1: return ARR[START];
            case 2: return ARR[START] + ARR[START + 1];
            default: return forkTasksAndGetResult();
        }
    }

    private int forkTasksAndGetResult() {
        final int middle = (FINISH - START) / 2 + START;
        ArrSum task1 = new ArrSum(START, middle, ARR);
        ArrSum task2 = new ArrSum(middle, FINISH, ARR);
        invokeAll(task1, task2);
        return task1.join() + task2.join();
    }
}
