package hiden;

import java.util.Collection;
import java.util.concurrent.Callable;

public class SizeOfTheCollectionTask implements Callable<Integer> {
    public Collection<Integer> integerCollection;

    public SizeOfTheCollectionTask(Collection<Integer> integerCollection) {
        this.integerCollection = integerCollection;
    }

    @Override
    public Integer call() throws Exception {
        return integerCollection.size();
    }
}
