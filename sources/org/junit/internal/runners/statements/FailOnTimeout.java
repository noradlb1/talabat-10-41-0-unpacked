package org.junit.internal.runners.statements;

import java.lang.Thread;
import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.junit.runners.model.MultipleFailureException;
import org.junit.runners.model.Statement;
import org.junit.runners.model.TestTimedOutException;

public class FailOnTimeout extends Statement {
    private final boolean lookForStuckThread;
    /* access modifiers changed from: private */
    public final Statement originalStatement;
    private volatile ThreadGroup threadGroup;
    private final TimeUnit timeUnit;
    private final long timeout;

    public static class Builder {
        /* access modifiers changed from: private */
        public boolean lookForStuckThread;
        /* access modifiers changed from: private */
        public long timeout;
        /* access modifiers changed from: private */
        public TimeUnit unit;

        public FailOnTimeout build(Statement statement) {
            if (statement != null) {
                return new FailOnTimeout(this, statement);
            }
            throw new NullPointerException("statement cannot be null");
        }

        public Builder withLookingForStuckThread(boolean z11) {
            this.lookForStuckThread = z11;
            return this;
        }

        public Builder withTimeout(long j11, TimeUnit timeUnit) {
            if (j11 < 0) {
                throw new IllegalArgumentException("timeout must be non-negative");
            } else if (timeUnit != null) {
                this.timeout = j11;
                this.unit = timeUnit;
                return this;
            } else {
                throw new NullPointerException("TimeUnit cannot be null");
            }
        }

        private Builder() {
            this.lookForStuckThread = false;
            this.timeout = 0;
            this.unit = TimeUnit.SECONDS;
        }
    }

    public class CallableStatement implements Callable<Throwable> {
        private final CountDownLatch startLatch;

        private CallableStatement() {
            this.startLatch = new CountDownLatch(1);
        }

        public void awaitStarted() throws InterruptedException {
            this.startLatch.await();
        }

        public Throwable call() throws Exception {
            try {
                this.startLatch.countDown();
                FailOnTimeout.this.originalStatement.evaluate();
                return null;
            } catch (Exception e11) {
                throw e11;
            } catch (Throwable th2) {
                return th2;
            }
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    private Thread[] copyThreads(Thread[] threadArr, int i11) {
        int min = Math.min(i11, threadArr.length);
        Thread[] threadArr2 = new Thread[min];
        for (int i12 = 0; i12 < min; i12++) {
            threadArr2[i12] = threadArr[i12];
        }
        return threadArr2;
    }

    private long cpuTime(Thread thread) {
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        if (!threadMXBean.isThreadCpuTimeSupported()) {
            return 0;
        }
        try {
            return threadMXBean.getThreadCpuTime(thread.getId());
        } catch (UnsupportedOperationException unused) {
            return 0;
        }
    }

    private Exception createTimeoutException(Thread thread) {
        Thread thread2;
        StackTraceElement[] stackTrace = thread.getStackTrace();
        if (this.lookForStuckThread) {
            thread2 = getStuckThread(thread);
        } else {
            thread2 = null;
        }
        TestTimedOutException testTimedOutException = new TestTimedOutException(this.timeout, this.timeUnit);
        if (stackTrace != null) {
            testTimedOutException.setStackTrace(stackTrace);
            thread.interrupt();
        }
        if (thread2 == null) {
            return testTimedOutException;
        }
        Exception exc = new Exception("Appears to be stuck in thread " + thread2.getName());
        exc.setStackTrace(getStackTrace(thread2));
        return new MultipleFailureException(Arrays.asList(new Throwable[]{testTimedOutException, exc}));
    }

    private Throwable getResult(FutureTask<Throwable> futureTask, Thread thread) {
        try {
            long j11 = this.timeout;
            if (j11 > 0) {
                return futureTask.get(j11, this.timeUnit);
            }
            return futureTask.get();
        } catch (InterruptedException e11) {
            return e11;
        } catch (ExecutionException e12) {
            return e12.getCause();
        } catch (TimeoutException unused) {
            return createTimeoutException(thread);
        }
    }

    private StackTraceElement[] getStackTrace(Thread thread) {
        try {
            return thread.getStackTrace();
        } catch (SecurityException unused) {
            return new StackTraceElement[0];
        }
    }

    private Thread getStuckThread(Thread thread) {
        Thread[] threadArray;
        if (this.threadGroup == null || (threadArray = getThreadArray(this.threadGroup)) == null) {
            return null;
        }
        long j11 = 0;
        Thread thread2 = null;
        for (Thread thread3 : threadArray) {
            if (thread3.getState() == Thread.State.RUNNABLE) {
                long cpuTime = cpuTime(thread3);
                if (thread2 == null || cpuTime > j11) {
                    thread2 = thread3;
                    j11 = cpuTime;
                }
            }
        }
        if (thread2 == thread) {
            return null;
        }
        return thread2;
    }

    private Thread[] getThreadArray(ThreadGroup threadGroup2) {
        int max = Math.max(threadGroup2.activeCount() * 2, 100);
        int i11 = 0;
        do {
            Thread[] threadArr = new Thread[max];
            int enumerate = threadGroup2.enumerate(threadArr);
            if (enumerate < max) {
                return copyThreads(threadArr, enumerate);
            }
            max += 100;
            i11++;
        } while (i11 < 5);
        return null;
    }

    public void evaluate() throws Throwable {
        CallableStatement callableStatement = new CallableStatement();
        FutureTask futureTask = new FutureTask(callableStatement);
        this.threadGroup = new ThreadGroup("FailOnTimeoutGroup");
        Thread thread = new Thread(this.threadGroup, futureTask, "Time-limited test");
        thread.setDaemon(true);
        thread.start();
        callableStatement.awaitStarted();
        Throwable result = getResult(futureTask, thread);
        if (result != null) {
            throw result;
        }
    }

    @Deprecated
    public FailOnTimeout(Statement statement, long j11) {
        this(builder().withTimeout(j11, TimeUnit.MILLISECONDS), statement);
    }

    private FailOnTimeout(Builder builder, Statement statement) {
        this.threadGroup = null;
        this.originalStatement = statement;
        this.timeout = builder.timeout;
        this.timeUnit = builder.unit;
        this.lookForStuckThread = builder.lookForStuckThread;
    }
}
