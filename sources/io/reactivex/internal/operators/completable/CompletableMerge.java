package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;

public final class CompletableMerge extends Completable {

    /* renamed from: b  reason: collision with root package name */
    public final Publisher<? extends CompletableSource> f14676b;

    /* renamed from: c  reason: collision with root package name */
    public final int f14677c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f14678d;

    public static final class CompletableMergeSubscriber extends AtomicInteger implements FlowableSubscriber<CompletableSource>, Disposable {
        private static final long serialVersionUID = -2108443387387077490L;

        /* renamed from: b  reason: collision with root package name */
        public final CompletableObserver f14679b;

        /* renamed from: c  reason: collision with root package name */
        public final int f14680c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f14681d;

        /* renamed from: e  reason: collision with root package name */
        public final AtomicThrowable f14682e = new AtomicThrowable();

        /* renamed from: f  reason: collision with root package name */
        public final CompositeDisposable f14683f = new CompositeDisposable();

        /* renamed from: g  reason: collision with root package name */
        public Subscription f14684g;

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
            this.f14679b = completableObserver;
            this.f14680c = i11;
            this.f14681d = z11;
            lazySet(1);
        }

        public void a(MergeInnerObserver mergeInnerObserver) {
            this.f14683f.delete(mergeInnerObserver);
            if (decrementAndGet() == 0) {
                Throwable th2 = (Throwable) this.f14682e.get();
                if (th2 != null) {
                    this.f14679b.onError(th2);
                } else {
                    this.f14679b.onComplete();
                }
            } else if (this.f14680c != Integer.MAX_VALUE) {
                this.f14684g.request(1);
            }
        }

        public void b(MergeInnerObserver mergeInnerObserver, Throwable th2) {
            this.f14683f.delete(mergeInnerObserver);
            if (!this.f14681d) {
                this.f14684g.cancel();
                this.f14683f.dispose();
                if (!this.f14682e.addThrowable(th2)) {
                    RxJavaPlugins.onError(th2);
                } else if (getAndSet(0) > 0) {
                    this.f14679b.onError(this.f14682e.terminate());
                }
            } else if (!this.f14682e.addThrowable(th2)) {
                RxJavaPlugins.onError(th2);
            } else if (decrementAndGet() == 0) {
                this.f14679b.onError(this.f14682e.terminate());
            } else if (this.f14680c != Integer.MAX_VALUE) {
                this.f14684g.request(1);
            }
        }

        public void dispose() {
            this.f14684g.cancel();
            this.f14683f.dispose();
        }

        public boolean isDisposed() {
            return this.f14683f.isDisposed();
        }

        public void onComplete() {
            if (decrementAndGet() != 0) {
                return;
            }
            if (((Throwable) this.f14682e.get()) != null) {
                this.f14679b.onError(this.f14682e.terminate());
            } else {
                this.f14679b.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (!this.f14681d) {
                this.f14683f.dispose();
                if (!this.f14682e.addThrowable(th2)) {
                    RxJavaPlugins.onError(th2);
                } else if (getAndSet(0) > 0) {
                    this.f14679b.onError(this.f14682e.terminate());
                }
            } else if (!this.f14682e.addThrowable(th2)) {
                RxJavaPlugins.onError(th2);
            } else if (decrementAndGet() == 0) {
                this.f14679b.onError(this.f14682e.terminate());
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f14684g, subscription)) {
                this.f14684g = subscription;
                this.f14679b.onSubscribe(this);
                int i11 = this.f14680c;
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
            this.f14683f.add(mergeInnerObserver);
            completableSource.subscribe(mergeInnerObserver);
        }
    }

    public CompletableMerge(Publisher<? extends CompletableSource> publisher, int i11, boolean z11) {
        this.f14676b = publisher;
        this.f14677c = i11;
        this.f14678d = z11;
    }

    public void subscribeActual(CompletableObserver completableObserver) {
        this.f14676b.subscribe(new CompletableMergeSubscriber(completableObserver, this.f14677c, this.f14678d));
    }
}
