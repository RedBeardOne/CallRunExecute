import hiden.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6);

    public static void main(String[] args) {
        new Main().getSomeResult();
        new Main().createSomeIntegerResults();
        new Main().measureProcessorWorkTime();
    }

    public void getSomeResult() {
        MyPrintIntegerCollectionTask task = new MyPrintIntegerCollectionTask(integers);
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<?> submit = executor.submit(task);

        try {
            System.out.println("Wait integer collection result");
            submit.get();
            System.out.println("Result ");
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    public void createSomeIntegerResults() {
        AverageNumberInTheCollectionTask averageInCollectionTask = new AverageNumberInTheCollectionTask(integers);
        SizeOfTheCollectionTask sizeOfCollectionTask = new SizeOfTheCollectionTask(integers);
        SmallestNumberInTheCollectionTask smallestInCollectionTask = new SmallestNumberInTheCollectionTask(integers);
        BiggestNumberInTheCollectionTask biggestInCollectionTask = new BiggestNumberInTheCollectionTask(integers);

        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        ExecutorService cachedThreadPoolExecutor = Executors.newCachedThreadPool();
        ExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);
        ExecutorService workStealingPoolExecutor = Executors.newWorkStealingPool();

        List<Callable<Integer>> tasks = new ArrayList<>();
        tasks.add(averageInCollectionTask);
        tasks.add(sizeOfCollectionTask);
        tasks.add(smallestInCollectionTask);
        tasks.add(biggestInCollectionTask);

        List<ExecutorService> executorServiceList = new ArrayList<>();
        executorServiceList.add(singleThreadExecutor);
        executorServiceList.add(cachedThreadPoolExecutor);
        executorServiceList.add(scheduledExecutorService);
        executorServiceList.add(workStealingPoolExecutor);

        Future<Integer> integerFuture = null;
       int counter = 0;
        int counterTwo = tasks.size();

        while (counterTwo > 0) {
            integerFuture = executorServiceList.get(counter).submit(tasks.get(counter));
            try {
                System.out.println(integerFuture.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            counter++;
            --counterTwo;
        }
    }

    public void measureProcessorWorkTime() {
        SleepingTreadTask sleepingTreadTask = new SleepingTreadTask(1_000);
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        Future<?> future = singleThreadExecutor.submit(sleepingTreadTask);

        long result = 0;
        long startTime = System.currentTimeMillis();

        try {
            future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        long endTime = System.currentTimeMillis();
        result = endTime - startTime;
        System.out.println(result);


        SleepingTreadTask sleepingTreadTask2 = new SleepingTreadTask(1_000);
        ExecutorService singleThreadExecutor2 = Executors.newSingleThreadExecutor();
        Future<?> future2 = singleThreadExecutor2.submit(sleepingTreadTask2);

        long resultTwo = 0;
        long startTimeTwo = System.currentTimeMillis();
        while (!future2.isDone()) {

        }
        long endTimeTwo = System.currentTimeMillis();
        resultTwo = endTimeTwo - startTimeTwo;
        System.out.println(resultTwo);
    }
}
