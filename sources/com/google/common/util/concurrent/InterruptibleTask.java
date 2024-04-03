package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.j2objc.annotations.ReflectionSupport;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.AbstractOwnableSynchronizer;
import java.util.concurrent.locks.LockSupport;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

@GwtCompatible(emulated = true)
@ReflectionSupport(ReflectionSupport.Level.FULL)
@ElementTypesAreNonnullByDefault
abstract class InterruptibleTask<T> extends AtomicReference<Runnable> implements Runnable {
    private static final Runnable DONE = new DoNothingRunnable();
    private static final int MAX_BUSY_WAIT_SPINS = 1000;
    private static final Runnable PARKED = new DoNothingRunnable();

    @VisibleForTesting
    public static final class Blocker extends AbstractOwnableSynchronizer implements Runnable {
        private final InterruptibleTask<?> task;

        /* access modifiers changed from: private */
        public void setOwner(Thread thread) {
            super.setExclusiveOwnerThread(thread);
        }

        @VisibleForTesting
        public Thread getOwner() {
            return super.getExclusiveOwnerThread();
        }

        public void run() {
        }

        public String toString() {
            return this.task.toString();
        }

        private Blocker(InterruptibleTask<?> interruptibleTask) {
            this.task = interruptibleTask;
        }
    }

    public static final class DoNothingRunnable implements Runnable {
        private DoNothingRunnable() {
        }

        public void run() {
        }
    }

    private void waitForInterrupt(Thread thread) {
        Runnable runnable = (Runnable) get();
        Blocker blocker = null;
        boolean z11 = false;
        int i11 = 0;
        while (true) {
            boolean z12 = runnable instanceof Blocker;
            if (!z12 && runnable != PARKED) {
                break;
            }
            if (z12) {
                blocker = (Blocker) runnable;
            }
            i11++;
            if (i11 > 1000) {
                Runnable runnable2 = PARKED;
                if (runnable == runnable2 || compareAndSet(runnable, runnable2)) {
                    if (Thread.interrupted() || z11) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    LockSupport.park(blocker);
                }
            } else {
                Thread.yield();
            }
            runnable = (Runnable) get();
        }
        if (z11) {
            thread.interrupt();
        }
    }

    public abstract void afterRanInterruptiblyFailure(Throwable th2);

    public abstract void afterRanInterruptiblySuccess(@ParametricNullness T t11);

    public final void interruptTask() {
        Runnable runnable = (Runnable) get();
        if (runnable instanceof Thread) {
            Blocker blocker = new Blocker();
            blocker.setOwner(Thread.currentThread());
            if (compareAndSet(runnable, blocker)) {
                try {
                    ((Thread) runnable).interrupt();
                } finally {
                    if (((Runnable) getAndSet(DONE)) == PARKED) {
                        LockSupport.unpark((Thread) runnable);
                    }
                }
            }
        }
    }

    public abstract boolean isDone();

    public final void run() {
        Thread currentThread = Thread.currentThread();
        Object obj = null;
        if (compareAndSet((Object) null, currentThread)) {
            boolean z11 = !isDone();
            if (z11) {
                try {
                    obj = runInterruptibly();
                } catch (Throwable th2) {
                    if (!compareAndSet(currentThread, DONE)) {
                        waitForInterrupt(currentThread);
                    }
                    if (z11) {
                        afterRanInterruptiblySuccess(NullnessCasts.uncheckedCastNullableTToT(null));
                    }
                    throw th2;
                }
            }
            if (!compareAndSet(currentThread, DONE)) {
                waitForInterrupt(currentThread);
            }
            if (z11) {
                afterRanInterruptiblySuccess(NullnessCasts.uncheckedCastNullableTToT(obj));
            }
        }
    }

    @ParametricNullness
    public abstract T runInterruptibly() throws Exception;

    public abstract String toPendingString();

    public final String toString() {
        String str;
        Runnable runnable = (Runnable) get();
        if (runnable == DONE) {
            str = "running=[DONE]";
        } else if (runnable instanceof Blocker) {
            str = "running=[INTERRUPTED]";
        } else if (runnable instanceof Thread) {
            str = "running=[RUNNING ON " + ((Thread) runnable).getName() + "]";
        } else {
            str = "running=[NOT STARTED YET]";
        }
        return str + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + toPendingString();
    }
}
