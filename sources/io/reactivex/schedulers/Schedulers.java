package io.reactivex.schedulers;

import io.reactivex.Scheduler;
import io.reactivex.annotations.Experimental;
import io.reactivex.annotations.NonNull;
import io.reactivex.internal.schedulers.ComputationScheduler;
import io.reactivex.internal.schedulers.ExecutorScheduler;
import io.reactivex.internal.schedulers.IoScheduler;
import io.reactivex.internal.schedulers.NewThreadScheduler;
import io.reactivex.internal.schedulers.SchedulerPoolFactory;
import io.reactivex.internal.schedulers.SingleScheduler;
import io.reactivex.internal.schedulers.TrampolineScheduler;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

public final class Schedulers {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public static final Scheduler f23554a = RxJavaPlugins.initSingleScheduler(new SingleTask());
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public static final Scheduler f23555b = RxJavaPlugins.initComputationScheduler(new ComputationTask());
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public static final Scheduler f23556c = RxJavaPlugins.initIoScheduler(new IOTask());
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public static final Scheduler f23557d = TrampolineScheduler.instance();
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public static final Scheduler f23558e = RxJavaPlugins.initNewThreadScheduler(new NewThreadTask());

    public static final class ComputationHolder {

        /* renamed from: a  reason: collision with root package name */
        public static final Scheduler f23559a = new ComputationScheduler();
    }

    public static final class ComputationTask implements Callable<Scheduler> {
        public Scheduler call() throws Exception {
            return ComputationHolder.f23559a;
        }
    }

    public static final class IOTask implements Callable<Scheduler> {
        public Scheduler call() throws Exception {
            return IoHolder.f23560a;
        }
    }

    public static final class IoHolder {

        /* renamed from: a  reason: collision with root package name */
        public static final Scheduler f23560a = new IoScheduler();
    }

    public static final class NewThreadHolder {

        /* renamed from: a  reason: collision with root package name */
        public static final Scheduler f23561a = new NewThreadScheduler();
    }

    public static final class NewThreadTask implements Callable<Scheduler> {
        public Scheduler call() throws Exception {
            return NewThreadHolder.f23561a;
        }
    }

    public static final class SingleHolder {

        /* renamed from: a  reason: collision with root package name */
        public static final Scheduler f23562a = new SingleScheduler();
    }

    public static final class SingleTask implements Callable<Scheduler> {
        public Scheduler call() throws Exception {
            return SingleHolder.f23562a;
        }
    }

    private Schedulers() {
        throw new IllegalStateException("No instances!");
    }

    @NonNull
    public static Scheduler computation() {
        return RxJavaPlugins.onComputationScheduler(f23555b);
    }

    @NonNull
    public static Scheduler from(@NonNull Executor executor) {
        return new ExecutorScheduler(executor, false);
    }

    @NonNull
    public static Scheduler io() {
        return RxJavaPlugins.onIoScheduler(f23556c);
    }

    @NonNull
    public static Scheduler newThread() {
        return RxJavaPlugins.onNewThreadScheduler(f23558e);
    }

    public static void shutdown() {
        computation().shutdown();
        io().shutdown();
        newThread().shutdown();
        single().shutdown();
        trampoline().shutdown();
        SchedulerPoolFactory.shutdown();
    }

    @NonNull
    public static Scheduler single() {
        return RxJavaPlugins.onSingleScheduler(f23554a);
    }

    public static void start() {
        computation().start();
        io().start();
        newThread().start();
        single().start();
        trampoline().start();
        SchedulerPoolFactory.start();
    }

    @NonNull
    public static Scheduler trampoline() {
        return f23557d;
    }

    @NonNull
    @Experimental
    public static Scheduler from(@NonNull Executor executor, boolean z11) {
        return new ExecutorScheduler(executor, z11);
    }
}
