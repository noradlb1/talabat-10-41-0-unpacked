package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;

public final class CompletableMerge extends Completable {

    /* renamed from: b  reason: collision with root package name */
    public final Publisher<? extends CompletableSource> f19162b;

    /* renamed from: c  reason: collision with root package name */
    public final int f19163c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f19164d;

    public static final class CompletableMergeSubscriber extends AtomicInteger implements FlowableSubscriber<CompletableSource>, Disposable {
        private static final long serialVersionUID = -2108443387387077490L;

        /* renamed from: b  reason: collision with root package name */
        public final CompletableObserver f19165b;

        /* renamed from: c  reason: collision with root package name */
        public final int f19166c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f19167d;

        /* renamed from: e  reason: collision with root package name */
        public final AtomicThrowable f19168e = new AtomicThrowable();

        /* renamed from: f  reason: collision with root package name */
        public final CompositeDisposable f19169f = new CompositeDisposable();

        /* renamed from: g  reason: collision with root package name */
        public Subscription f19170g;

        public final class MergeInnerObserver extends AtomicReference<Disposable> implements CompletableObserver, Disposable {
            private static final long serialVersionUID = 251330541679988317L;

            public MergeInnerObserver() {
            }

            public void dispose() {
                DisposableHelper.dispose(this);
            }

            public boolean isDisposed() {
                return DisposableHelper.isDisposed((Disposable) get());
            }

            public void onComplete() {
                CompletableMergeSubscriber.this.a(this);
            }

            public void onError(Throwable th2) {
                CompletableMergeSubscriber.this.b(this, th2);
            }

            public void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this, disposable);
            }
        }

        public CompletableMergeSubscriber(CompletableObserver completableObserver, int i11, boolean z11) {
            this.f19165b = completableObserver;
            this.f19166c = i11;
            this.f19167d = z11;
            lazySet(1);
        }

        public void a(MergeInnerObserver mergeInnerObserver) {
            this.f19169f.delete(mergeInnerObserver);
            if (decrementAndGet() == 0) {
                this.f19168e.tryTerminateConsumer(this.f19165b);
            } else if (this.f19166c != Integer.MAX_VALUE) {
                this.f19170g.request(1);
            }
        }

        public void b(MergeInnerObserver mergeInnerObserver, Throwable th2) {
            this.f19169f.delete(mergeInnerObserver);
            if (!this.f19167d) {
                this.f19170g.cancel();
                this.f19169f.dispose();
                if (this.f19168e.tryAddThrowableOrReport(th2) && getAndSet(0) > 0) {
                    this.f19168e.tryTerminateConsumer(this.f19165b);
                }
            } else if (!this.f19168e.tryAddThrowableOrReport(th2)) {
            } else {
                if (decrementAndGet() == 0) {
                    this.f19168e.tryTerminateConsumer(this.f19165b);
                } else if (this.f19166c != Integer.MAX_VALUE) {
                    this.f19170g.request(1);
                }
            }
        }

        public void dispose() {
            this.f19170g.cancel();
            this.f19169f.dispose();
            this.f19168e.tryTerminateAndReport();
        }

        public boolean isDisposed() {
            return this.f19169f.isDisposed();
        }

        public void onComplete() {
            if (decrementAndGet() == 0) {
                this.f19168e.tryTerminateConsumer(this.f19165b);
            }
        }

        public void onError(Throwable th2) {
            if (!this.f19167d) {
                this.f19169f.dispose();
                if (this.f19168e.tryAddThrowableOrReport(th2) && getAndSet(0) > 0) {
                    this.f19168e.tryTerminateConsumer(this.f19165b);
                }
            } else if (this.f19168e.tryAddThrowableOrReport(th2) && decrementAndGet() == 0) {
                this.f19168e.tryTerminateConsumer(this.f19165b);
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f19170g, subscription)) {
                this.f19170g = subscription;
                this.f19165b.onSubscribe(this);
                int i11 = this.f19166c;
                if (i11 == Integer.MAX_VALUE) {
                    subscription.request(Long.MAX_VALUE);
                } else {
                    subscription.request((long) i11);
                }
            }
        }

        public void onNext(CompletableSource completableSource) {
            getAndIncrement();
            MergeInnerObserver mergeInnerObserver = new MergeInnerObserver();
            this.f19169f.add(mergeInnerObserver);
            completableSource.subscribe(mergeInnerObserver);
        }
    }

    public CompletableMerge(Publisher<? extends CompletableSource> publisher, int i11, boolean z11) {
        this.f19162b = publisher;
        this.f19163c = i11;
        this.f19164d = z11;
    }

    public void subscribeActual(CompletableObserver completableObserver) {
        this.f19162b.subscribe(new CompletableMergeSubscriber(completableObserver, this.f19163c, this.f19164d));
    }
}
