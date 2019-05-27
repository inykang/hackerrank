package pe.inykang.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class FutureTaskDemo {
    public static final int MAX_NUMBER = 2000000000;

    public static void main(String... args) throws ExecutionException, InterruptedException {
        int resultFuture = FutureTaskDemo.amountOfDivisibleByFuture(0, MAX_NUMBER, 3);
    }

    public static int amountOfDivisibleByFuture(final int first, final int last, final int divisor)
            throws InterruptedException, ExecutionException {

        int amount = 0;

        // Prepare to execute and store the Futures
        int threadNum = 2;
        ExecutorService executor = Executors.newFixedThreadPool(threadNum);
        List<FutureTask<Integer>> taskList = new ArrayList<FutureTask<Integer>>();

        // Start thread for the first half of the numbers
        FutureTask<Integer> futureTask_1 = new FutureTask<Integer>(new Callable<Integer>() {
            @Override
            public Integer call() {
                return FutureTaskDemo.amountOfDivisibleBy(first, last / 2, divisor);
            }
        });
        taskList.add(futureTask_1);
        executor.execute(futureTask_1);

        // Start thread for the second half of the numbers
        FutureTask<Integer> futureTask_2 = new FutureTask<Integer>(new Callable<Integer>() {
            @Override
            public Integer call() {
                return FutureTaskDemo.amountOfDivisibleBy(last / 2 + 1, last, divisor);
            }
        });
        taskList.add(futureTask_2);
        executor.execute(futureTask_2);

        // Wait until all results are available and combine them at the same time
        for (int j = 0; j < threadNum; j++) {
            FutureTask<Integer> futureTask = taskList.get(j);
            amount += futureTask.get();
        }
        executor.shutdown();

        return amount;
    }

    public static int amountOfDivisibleBy(int first, int last, int divisor) {

        int amount = 0;
        for (int i = first; i <= last; i++) {
            if (i % divisor == 0) {
                amount++;
            }
        }
        return amount;
    }
}
