package pe.inykang.concurrent;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class Java8CallableDemo {
    public static void main(String[] args) {
        final List<Integer> integers =  Arrays.asList(1,2,3,4,5);
        Callable<Integer> callableObj = () -> {
            int result = integers.stream().mapToInt(i -> i.intValue()).sum();
            return result;
        };
        ExecutorService service =  Executors.newSingleThreadExecutor();
        Future<Integer> future = service.submit(callableObj);
        Integer result=0;
        try {
            result = future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("Sum = "+result);
    }
}
