package hiden;

import java.util.Collection;
import java.util.concurrent.Callable;

public class SmallestNumberInTheCollectionTask implements Callable<Integer> {
    public Collection<Integer> integerCollection;

    public SmallestNumberInTheCollectionTask(Collection<Integer> integerCollection) {
        this.integerCollection = integerCollection;
    }

    @Override
    public Integer call() throws Exception {
       int max = 0;

        for (Integer integer : integerCollection) {
            if (integer > max) {
                max = integer;
            }
        }
        return max;
    }
}

