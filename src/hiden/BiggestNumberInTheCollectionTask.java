package hiden;

import java.util.Collection;
import java.util.concurrent.Callable;

public class BiggestNumberInTheCollectionTask implements Callable<Integer> {
    public Collection<Integer> integerCollection;

    public BiggestNumberInTheCollectionTask(Collection<Integer> integerCollection) {
        this.integerCollection = integerCollection;
    }

    @Override
    public Integer call() throws Exception {
        int min = 0;

        for (Integer integer : integerCollection) {
            if (integer < min) {
                min = integer;
            }
        }
        return min;
    }
}
