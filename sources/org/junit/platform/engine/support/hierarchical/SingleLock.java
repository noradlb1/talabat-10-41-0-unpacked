package org.junit.platform.engine.support.hierarchical;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.locks.Lock;
import r30.o;

class SingleLock implements ResourceLock {
    /* access modifiers changed from: private */
    public final Lock lock;

    public class SingleLockManagedBlocker implements ForkJoinPool.ManagedBlocker {
        private boolean acquired;

        private SingleLockManagedBlocker() {
        }

        public boolean block() throws InterruptedException {
            SingleLock.this.lock.lockInterruptibly();
            this.acquired = true;
            return true;
        }

        public boolean isReleasable() {
            return this.acquired || SingleLock.this.lock.tryLock();
        }
    }

    public SingleLock(Lock lock2) {
        this.lock = lock2;
    }

    public ResourceLock acquire() throws InterruptedException {
        ForkJoinPool.managedBlock(new SingleLockManagedBlocker());
        return this;
    }

    public /* synthetic */ void close() {
        o.a(this);
    }

    public void release() {
        this.lock.unlock();
    }
}
