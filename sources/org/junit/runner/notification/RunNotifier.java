package org.junit.runner.notification;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.RunListener;

public class RunNotifier {
    /* access modifiers changed from: private */
    public final List<RunListener> listeners = new CopyOnWriteArrayList();
    private volatile boolean pleaseStop = false;

    public abstract class SafeNotifier {
        private final List<RunListener> currentListeners;

        public SafeNotifier(RunNotifier runNotifier) {
            this(runNotifier.listeners);
        }

        public abstract void a(RunListener runListener) throws Exception;

        public void b() {
            int size = this.currentListeners.size();
            ArrayList arrayList = new ArrayList(size);
            ArrayList arrayList2 = new ArrayList(size);
            for (RunListener next : this.currentListeners) {
                try {
                    a(next);
                    arrayList.add(next);
                } catch (Exception e11) {
                    arrayList2.add(new Failure(Description.TEST_MECHANISM, e11));
                }
            }
            RunNotifier.this.fireTestFailures(arrayList, arrayList2);
        }

        public SafeNotifier(List<RunListener> list) {
            this.currentListeners = list;
        }
    }

    /* access modifiers changed from: private */
    public void fireTestFailures(List<RunListener> list, final List<Failure> list2) {
        if (!list2.isEmpty()) {
            new SafeNotifier(list) {
                public void a(RunListener runListener) throws Exception {
                    for (Failure testFailure : list2) {
                        runListener.testFailure(testFailure);
                    }
                }
            }.b();
        }
    }

    public void addFirstListener(RunListener runListener) {
        if (runListener != null) {
            this.listeners.add(0, c(runListener));
            return;
        }
        throw new NullPointerException("Cannot add a null listener");
    }

    public void addListener(RunListener runListener) {
        if (runListener != null) {
            this.listeners.add(c(runListener));
            return;
        }
        throw new NullPointerException("Cannot add a null listener");
    }

    public RunListener c(RunListener runListener) {
        return runListener.getClass().isAnnotationPresent(RunListener.ThreadSafe.class) ? runListener : new SynchronizedRunListener(runListener, this);
    }

    public void fireTestAssumptionFailed(final Failure failure) {
        new SafeNotifier() {
            public void a(RunListener runListener) throws Exception {
                runListener.testAssumptionFailure(failure);
            }
        }.b();
    }

    public void fireTestFailure(Failure failure) {
        fireTestFailures(this.listeners, Arrays.asList(new Failure[]{failure}));
    }

    public void fireTestFinished(final Description description) {
        new SafeNotifier() {
            public void a(RunListener runListener) throws Exception {
                runListener.testFinished(description);
            }
        }.b();
    }

    public void fireTestIgnored(final Description description) {
        new SafeNotifier() {
            public void a(RunListener runListener) throws Exception {
                runListener.testIgnored(description);
            }
        }.b();
    }

    public void fireTestRunFinished(final Result result) {
        new SafeNotifier() {
            public void a(RunListener runListener) throws Exception {
                runListener.testRunFinished(result);
            }
        }.b();
    }

    public void fireTestRunStarted(final Description description) {
        new SafeNotifier() {
            public void a(RunListener runListener) throws Exception {
                runListener.testRunStarted(description);
            }
        }.b();
    }

    public void fireTestStarted(final Description description) throws StoppedByUserException {
        if (!this.pleaseStop) {
            new SafeNotifier() {
                public void a(RunListener runListener) throws Exception {
                    runListener.testStarted(description);
                }
            }.b();
            return;
        }
        throw new StoppedByUserException();
    }

    public void pleaseStop() {
        this.pleaseStop = true;
    }

    public void removeListener(RunListener runListener) {
        if (runListener != null) {
            this.listeners.remove(c(runListener));
            return;
        }
        throw new NullPointerException("Cannot remove a null listener");
    }
}
