package hiden;

import java.util.Collection;

public class MyPrintIntegerCollectionTask implements Runnable {
    public Collection<Integer> integerCollection;

    public MyPrintIntegerCollectionTask(Collection<Integer> integerCollection) {
        this.integerCollection = integerCollection;
    }

    @Override
    public void run() {
        for (Integer integer : integerCollection) {
            System.out.println(integer);
        }
    }
}
