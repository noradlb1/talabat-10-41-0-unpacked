package io.reactivex.rxjava3.internal.schedulers;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.disposables.a;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.processors.FlowableProcessor;
import io.reactivex.rxjava3.processors.UnicastProcessor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class SchedulerWhen extends Scheduler implements Disposable {

    /* renamed from: d  reason: collision with root package name */
    public static final Disposable f23080d = new SubscribedDisposable();

    /* renamed from: e  reason: collision with root package name */
    public static final Disposable f23081e = a.a();
    private final Scheduler actualScheduler;
    private Disposable disposable;
    private final FlowableProcessor<Flowable<Completable>> workerProcessor;

    public static final class CreateWorkerFunction implements Function<ScheduledAction, Completable> {

        /* renamed from: b  reason: collision with root package name */
        public final Scheduler.Worker f23082b;

        public final class WorkerCompletable extends Completable {

            /* renamed from: b  reason: collision with root package name */
            public final ScheduledAction f23083b;

            public WorkerCompletable(ScheduledAction scheduledAction) {
                this.f23083b = scheduledAction;
            }

            public void subscribeActual(CompletableObserver completableObserver) {
                completableObserver.onSubscribe(this.f23083b);
                this.f23083b.a(CreateWorkerFunction.this.f23082b, completableObserver);
            }
        }

        public CreateWorkerFunction(Scheduler.Worker worker) {
            this.f23082b = worker;
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
        public final CompletableObserver f23085b;

        /* renamed from: c  reason: collision with root package name */
        public final Runnable f23086c;

        public OnCompletedAction(Runnable runnable, CompletableObserver completableObserver) {
            this.f23086c = runnable;
            this.f23085b = completableObserver;
        }

        public void run() {
            try {
                this.f23086c.run();
            } finally {
                this.f23085b.onComplete();
            }
        }
    }

    public static abstract class ScheduledAction extends AtomicReference<Disposable> implements Disposable {
        public ScheduledAction() {
            super(SchedulerWhen.f23080d);
        }

        public void a(Scheduler.Worker worker, CompletableObserver completableObserver) {
            Disposable disposable;
            Disposable disposable2 = (Disposable) get();
            if (disposable2 != SchedulerWhen.f23081e && disposable2 == (disposable = SchedulerWhen.f23080d)) {
                Disposable b11 = b(worker, completableObserver);
                if (!compareAndSet(disposable, b11)) {
                    b11.dispose();
                }
            }
        }

        public abstract Disposable b(Scheduler.Worker worker, CompletableObserver completableObserver);

        public void dispose() {
            ((Disposable) getAndSet(SchedulerWhen.f23081e)).dispose();
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
