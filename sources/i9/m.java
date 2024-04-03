package i9;

import com.google.common.base.Supplier;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public final /* synthetic */ class m implements Supplier {
    public final Object get() {
        return new ReentrantReadWriteLock();
    }
}
