package org.junit.experimental;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import org.junit.runner.Computer;
import org.junit.runner.Runner;
import org.junit.runners.ParentRunner;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.RunnerBuilder;
import org.junit.runners.model.RunnerScheduler;

public class ParallelComputer extends Computer {
    private final boolean classes;
    private final boolean methods;

    public ParallelComputer(boolean z11, boolean z12) {
        this.classes = z11;
        this.methods = z12;
    }

    public static Computer classes() {
        return new ParallelComputer(true, false);
    }

    public static Computer methods() {
        return new ParallelComputer(false, true);
    }

    private static Runner parallelize(Runner runner) {
        if (runner instanceof ParentRunner) {
            ((ParentRunner) runner).setScheduler(new RunnerScheduler() {
                private final ExecutorService fService = Executors.newCachedThreadPool();

                public void finished() {
                    try {
                        this.fService.shutdown();
                        this.fService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
                    } catch (InterruptedException e11) {
                        e11.printStackTrace(System.err);
                    }
                }

                public void schedule(Runnable runnable) {
                    this.fService.submit(runnable);
                }
            });
        }
        return runner;
    }

    public Runner a(RunnerBuilder runnerBuilder, Class<?> cls) throws Throwable {
        Runner a11 = super.a(runnerBuilder, cls);
        if (this.methods) {
            return parallelize(a11);
        }
        return a11;
    }

    public Runner getSuite(RunnerBuilder runnerBuilder, Class<?>[] clsArr) throws InitializationError {
        Runner suite = super.getSuite(runnerBuilder, clsArr);
        if (this.classes) {
            return parallelize(suite);
        }
        return suite;
    }
}
