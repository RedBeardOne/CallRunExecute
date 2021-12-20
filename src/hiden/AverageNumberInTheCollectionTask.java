package hiden;

import java.util.Collection;
import java.util.concurrent.Callable;

public class AverageNumberInTheCollectionTask implements Callable<Integer> {
    public Collection<Integer> integerCollection;

    public AverageNumberInTheCollectionTask(Collection<Integer> integerCollection) {
        this.integerCollection = integerCollection;
    }

    @Override
    public Integer call() throws Exception {
        int result = 0;
        for (Integer integer : integerCollection) {
            result += integer;
        }
        return (result / integerCollection.size());
    }
}
