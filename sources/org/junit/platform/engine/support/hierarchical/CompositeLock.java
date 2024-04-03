package org.junit.platform.engine.support.hierarchical;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.locks.Lock;
import r30.o;

class CompositeLock implements ResourceLock {
    private final List<Lock> locks;

    public class CompositeLockManagedBlocker implements ForkJoinPool.ManagedBlocker {
        private boolean acquired;

        private CompositeLockManagedBlocker() {
        }

        public boolean block() throws InterruptedException {
            CompositeLock.this.acquireAllLocks();
            this.acquired = true;
            return true;
        }

        public boolean isReleasable() {
            return this.acquired;
        }
    }

    public CompositeLock(List<Lock> list) {
        this.locks = list;
    }

    /* access modifiers changed from: private */
    public void acquireAllLocks() throws InterruptedException {
        ArrayList arrayList = new ArrayList(this.locks.size());
        try {
            for (Lock next : this.locks) {
                next.lockInterruptibly();
                arrayList.add(next);
            }
        } catch (InterruptedException e11) {
            release(arrayList);
            throw e11;
        }
    }

    public ResourceLock acquire() throws InterruptedException {
        ForkJoinPool.managedBlock(new CompositeLockManagedBlocker());
        return this;
    }

    public /* synthetic */ void close() {
        o.a(this);
    }

    public void release() {
        release(this.locks);
    }

    private void release(List<Lock> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            list.get(size).unlock();
        }
    }
}
