package io.reactivex.rxjava3.schedulers;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.schedulers.ComputationScheduler;
import io.reactivex.rxjava3.internal.schedulers.IoScheduler;
import io.reactivex.rxjava3.internal.schedulers.NewThreadScheduler;
import io.reactivex.rxjava3.internal.schedulers.SingleScheduler;
import io.reactivex.rxjava3.internal.schedulers.TrampolineScheduler;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.Executor;

public final class Schedulers {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public static final Scheduler f23359a = RxJavaPlugins.initSingleScheduler(new SingleTask());
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public static final Scheduler f23360b = RxJavaPlugins.initComputationScheduler(new ComputationTask());
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public static final Scheduler f23361c = RxJavaPlugins.initIoScheduler(new IOTask());
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public static final Scheduler f23362d = TrampolineScheduler.instance();
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public static final Scheduler f23363e = RxJavaPlugins.initNewThreadScheduler(new NewThreadTask());

    public static final class ComputationHolder {

        /* renamed from: a  reason: collision with root package name */
        public static final Scheduler f23364a = new ComputationScheduler();
    }

    public static final class ComputationTask implements Supplier<Scheduler> {
        public Scheduler get() {
            return ComputationHolder.f23364a;
        }
    }

    public static final class IOTask implements Supplier<Scheduler> {
        public Scheduler get() {
            return IoHolder.f23365a;
        }
    }

    public static final class IoHolder {

        /* renamed from: a  reason: collision with root package name */
        public static final Scheduler f23365a = new IoScheduler();
    }

    public static final class NewThreadHolder {

        /* renamed from: a  reason: collision with root package name */
        public static final Scheduler f23366a = new NewThreadScheduler();
    }

    public static final class NewThreadTask implements Supplier<Scheduler> {
        public Scheduler get() {
            return NewThreadHolder.f23366a;
        }
    }

    public static final class SingleHolder {

        /* renamed from: a  reason: collision with root package name */
        public static final Scheduler f23367a = new SingleScheduler();
    }

    public static final class SingleTask implements Supplier<Scheduler> {
        public Scheduler get() {
            return SingleHolder.f23367a;
        }
    }

    private Schedulers() {
        throw new IllegalStateException("No instances!");
    }

    @NonNull
    public static Scheduler computation() {
        return RxJavaPlugins.onComputationScheduler(f23360b);
    }

    @NonNull
    public static Scheduler from(@NonNull Executor executor) {
        return from(executor, false, false);
    }

    @NonNull
    public static Scheduler io() {
        return RxJavaPlugins.onIoScheduler(f23361c);
    }

    @NonNull
    public static Scheduler newThread() {
        return RxJavaPlugins.onNewThreadScheduler(f23363e);
    }

    public static void shutdown() {
        computation().shutdown();
        io().shutdown();
        newThread().shutdown();
        single().shutdown();
        trampoline().shutdown();
    }

    @NonNull
    public static Scheduler single() {
        return RxJavaPlugins.onSingleScheduler(f23359a);
    }

    public static void start() {
        computation().start();
        io().start();
        newThread().start();
        single().start();
        trampoline().start();
    }

    @NonNull
    public static Scheduler trampoline() {
        return f23362d;
    }

    @NonNull
    public static Scheduler from(@NonNull Executor executor, boolean z11) {
        return from(executor, z11, false);
    }

    @NonNull
    public static Scheduler from(@NonNull Executor executor, boolean z11, boolean z12) {
        return RxJavaPlugins.createExecutorScheduler(executor, z11, z12);
    }
}
