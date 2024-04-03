package io.reactivex.internal.schedulers;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.Flowable;
import io.reactivex.Scheduler;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Function;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.processors.FlowableProcessor;
import io.reactivex.processors.UnicastProcessor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class SchedulerWhen extends Scheduler implements Disposable {

    /* renamed from: d  reason: collision with root package name */
    public static final Disposable f18523d = new SubscribedDisposable();

    /* renamed from: e  reason: collision with root package name */
    public static final Disposable f18524e = Disposables.disposed();
    private final Scheduler actualScheduler;
    private Disposable disposable;
    private final FlowableProcessor<Flowable<Completable>> workerProcessor;

    public static final class CreateWorkerFunction implements Function<ScheduledAction, Completable> {

        /* renamed from: b  reason: collision with root package name */
        public final Scheduler.Worker f18525b;

        public final class WorkerCompletable extends Completable {

            /* renamed from: b  reason: collision with root package name */
            public final ScheduledAction f18526b;

            public WorkerCompletable(ScheduledAction scheduledAction) {
                this.f18526b = scheduledAction;
            }

            public void subscribeActual(CompletableObserver completableObserver) {
                completableObserver.onSubscribe(this.f18526b);
                this.f18526b.a(CreateWorkerFunction.this.f18525b, completableObserver);
            }
        }

        public CreateWorkerFunction(Scheduler.Worker worker) {
            this.f18525b = worker;
        }

        public Completable apply(ScheduledAction scheduledAction) {
            return new WorkerCompletable(scheduledAction);
        }
    }

    public static class DelayedAction extends ScheduledAction {
        private final Runnable action;
        private final long delayTime;
        private final TimeUnit unit;

        public DelayedAction(Runnable runnable, long j11, TimeUnit timeUnit) {
            this.action = runnable;
            this.delayTime = j11;
            this.unit = timeUnit;
        }

        public Disposable b(Scheduler.Worker worker, CompletableObserver completableObserver) {
            return worker.schedule(new OnCompletedAction(this.action, completableObserver), this.delayTime, this.unit);
        }
    }

    public static class ImmediateAction extends ScheduledAction {
        private final Runnable action;

        public ImmediateAction(Runnable runnable) {
            this.action = runnable;
        }

        public Disposable b(Scheduler.Worker worker, CompletableObserver completableObserver) {
            return worker.schedule(new OnCompletedAction(this.action, completableObserver));
        }
    }

    public static class OnCompletedAction implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final CompletableObserver f18528b;

        /* renamed from: c  reason: collision with root package name */
        public final Runnable f18529c;

        public OnCompletedAction(Runnable runnable, CompletableObserver completableObserver) {
            this.f18529c = runnable;
            this.f18528b = completableObserver;
        }

        public void run() {
            try {
                this.f18529c.run();
            } finally {
                this.f18528b.onComplete();
            }
        }
    }

    public static abstract class ScheduledAction extends AtomicReference<Disposable> implements Disposable {
        public ScheduledAction() {
            super(SchedulerWhen.f18523d);
        }

        public void a(Scheduler.Worker worker, CompletableObserver completableObserver) {
            Disposable disposable;
            Disposable disposable2 = (Disposable) get();
            if (disposable2 != SchedulerWhen.f18524e && disposable2 == (disposable = SchedulerWhen.f18523d)) {
                Disposable b11 = b(worker, completableObserver);
                if (!compareAndSet(disposable, b11)) {
                    b11.dispose();
                }
            }
        }

        public abstract Disposable b(Scheduler.Worker worker, CompletableObserver completableObserver);

        public void dispose() {
            Disposable disposable;
            Disposable disposable2 = SchedulerWhen.f18524e;
            do {
                disposable = (Disposable) get();
                if (disposable == SchedulerWhen.f18524e) {
                    return;
                }
            } while (!compareAndSet(disposable, disposable2));
            if (disposable != SchedulerWhen.f18523d) {
                disposable.dispose();
            }
        }

        public boolean isDisposed() {
            return ((Disposable) get()).isDisposed();
        }
    }

    public static final class SubscribedDisposable implements Disposable {
        public void dispose() {
        }

        public boolean isDisposed() {
            return false;
        }
    }

    public SchedulerWhen(Function<Flowable<Flowable<Completable>>, Completable> function, Scheduler scheduler) {
        this.actualScheduler = scheduler;
        FlowableProcessor<Flowable<Completable>> serialized = UnicastProcessor.create().toSerialized();
        this.workerProcessor = serialized;
        try {
            this.disposable = function.apply(serialized).subscribe();
        } catch (Throwable th2) {
            throw ExceptionHelper.wrapOrThrow(th2);
        }
    }

    @NonNull
    public Scheduler.Worker createWorker() {
        Scheduler.Worker createWorker = this.actualScheduler.createWorker();
        FlowableProcessor serialized = UnicastProcessor.create().toSerialized();
        Flowable map = serialized.map(new CreateWorkerFunction(createWorker));
        QueueWorker queueWorker = new QueueWorker(serialized, createWorker);
        this.workerProcessor.onNext(map);
        return queueWorker;
    }

    public void dispose() {
        this.disposable.dispose();
    }

    public boolean isDisposed() {
        return this.disposable.isDisposed();
    }

    public static final class QueueWorker extends Scheduler.Worker {
        private final FlowableProcessor<ScheduledAction> actionProcessor;
        private final Scheduler.Worker actualWorker;
        private final AtomicBoolean unsubscribed = new AtomicBoolean();

        public QueueWorker(FlowableProcessor<ScheduledAction> flowableProcessor, Scheduler.Worker worker) {
            this.actionProcessor = flowableProcessor;
            this.actualWorker = worker;
        }

        public void dispose() {
            if (this.unsubscribed.compareAndSet(false, true)) {
                this.actionProcessor.onComplete();
                this.actualWorker.dispose();
            }
        }

        public boolean isDisposed() {
            return this.unsubscribed.get();
        }

        @NonNull
        public Disposable schedule(@NonNull Runnable runnable, long j11, @NonNull TimeUnit timeUnit) {
            DelayedAction delayedAction = new DelayedAction(runnable, j11, timeUnit);
            this.actionProcessor.onNext(delayedAction);
            return delayedAction;
        }

        @NonNull
        public Disposable schedule(@NonNull Runnable runnable) {
            ImmediateAction immediateAction = new ImmediateAction(runnable);
            this.actionProcessor.onNext(immediateAction);
            return immediateAction;
        }
    }
}
