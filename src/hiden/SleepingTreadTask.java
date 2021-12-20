package hiden;

public class SleepingTreadTask implements Runnable{
    long amountOfMilliSeconds;

    public SleepingTreadTask(long amountOfMilliSeconds) {
        this.amountOfMilliSeconds = amountOfMilliSeconds;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(amountOfMilliSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
