package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.operators.QueueSubscription;
import io.reactivex.rxjava3.operators.SimpleQueue;
import io.reactivex.rxjava3.operators.SpscArrayQueue;
import io.reactivex.rxjava3.operators.SpscLinkedArrayQueue;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;

public final class CompletableConcat extends Completable {

    /* renamed from: b  reason: collision with root package name */
    public final Publisher<? extends CompletableSource> f19088b;

    /* renamed from: c  reason: collision with root package name */
    public final int f19089c;

    public static final class CompletableConcatSubscriber extends AtomicInteger implements FlowableSubscriber<CompletableSource>, Disposable {
        private static final long serialVersionUID = 9032184911934499404L;

        /* renamed from: b  reason: collision with root package name */
        public final CompletableObserver f19090b;

        /* renamed from: c  reason: collision with root package name */
        public final int f19091c;

        /* renamed from: d  reason: collision with root package name */
        public final int f19092d;

        /* renamed from: e  reason: collision with root package name */
        public final ConcatInnerObserver f19093e = new ConcatInnerObserver(this);

        /* renamed from: f  reason: collision with root package name */
        public final AtomicBoolean f19094f = new AtomicBoolean();

        /* renamed from: g  reason: collision with root package name */
        public int f19095g;

        /* renamed from: h  reason: collision with root package name */
        public int f19096h;

        /* renamed from: i  reason: collision with root package name */
        public SimpleQueue<CompletableSource> f19097i;

        /* renamed from: j  reason: collision with root package name */
        public Subscription f19098j;

        /* renamed from: k  reason: collision with root package name */
        public volatile boolean f19099k;

        /* renamed from: l  reason: collision with root package name */
        public volatile boolean f19100l;

        public static final class ConcatInnerObserver extends AtomicReference<Disposable> implements CompletableObserver {
            private static final long serialVersionUID = -5454794857847146511L;

            /* renamed from: b  reason: collision with root package name */
            public final CompletableConcatSubscriber f19101b;

            public ConcatInnerObserver(CompletableConcatSubscriber completableConcatSubscriber) {
                this.f19101b = completableConcatSubscriber;
            }

            public void onComplete() {
                this.f19101b.b();
            }

            public void onError(Throwable th2) {
                this.f19101b.c(th2);
            }

            public void onSubscribe(Disposable disposable) {
                DisposableHelper.replace(this, disposable);
            }
        }

        public CompletableConcatSubscriber(CompletableObserver completableObserver, int i11) {
            this.f19090b = completableObserver;
            this.f19091c = i11;
            this.f19092d = i11 - (i11 >> 2);
        }

        public void a() {
            boolean z11;
            if (getAndIncrement() == 0) {
                while (!isDisposed()) {
                    if (!this.f19100l) {
                        boolean z12 = this.f19099k;
                        try {
                            CompletableSource poll = this.f19097i.poll();
                            if (poll == null) {
                                z11 = true;
                            } else {
                                z11 = false;
                            }
                            if (z12 && z11) {
                                this.f19090b.onComplete();
                                return;
                            } else if (!z11) {
                                this.f19100l = true;
                                poll.subscribe(this.f19093e);
                                d();
                            }
                        } catch (Throwable th2) {
                            Exceptions.throwIfFatal(th2);
                            c(th2);
                            return;
                        }
                    }
                    if (decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }

        public void b() {
            this.f19100l = false;
            a();
        }

        public void c(Throwable th2) {
            if (this.f19094f.compareAndSet(false, true)) {
                this.f19098j.cancel();
                this.f19090b.onError(th2);
                return;
            }
            RxJavaPlugins.onError(th2);
        }

        public void d() {
            if (this.f19095g != 1) {
                int i11 = this.f19096h + 1;
                if (i11 == this.f19092d) {
                    this.f19096h = 0;
                    this.f19098j.request((long) i11);
                    return;
                }
                this.f19096h = i11;
            }
        }

        public void dispose() {
            this.f19098j.cancel();
            DisposableHelper.dispose(this.f19093e);
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) this.f19093e.get());
        }

        public void onComplete() {
            this.f19099k = true;
            a();
        }

        public void onError(Throwable th2) {
            if (this.f19094f.compareAndSet(false, true)) {
                DisposableHelper.dispose(this.f19093e);
                this.f19090b.onError(th2);
                return;
            }
            RxJavaPlugins.onError(th2);
        }

        public void onSubscribe(Subscription subscription) {
            long j11;
            if (SubscriptionHelper.validate(this.f19098j, subscription)) {
                this.f19098j = subscription;
                int i11 = this.f19091c;
                if (i11 == Integer.MAX_VALUE) {
                    j11 = Long.MAX_VALUE;
                } else {
                    j11 = (long) i11;
                }
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int requestFusion = queueSubscription.requestFusion(3);
                    if (requestFusion == 1) {
                        this.f19095g = requestFusion;
                        this.f19097i = queueSubscription;
                        this.f19099k = true;
                        this.f19090b.onSubscribe(this);
                        a();
                        return;
                    } else if (requestFusion == 2) {
                        this.f19095g = requestFusion;
                        this.f19097i = queueSubscription;
                        this.f19090b.onSubscribe(this);
                        subscription.request(j11);
                        return;
                    }
                }
                if (this.f19091c == Integer.MAX_VALUE) {
                    this.f19097i = new SpscLinkedArrayQueue(Flowable.bufferSize());
                } else {
                    this.f19097i = new SpscArrayQueue(this.f19091c);
                }
                this.f19090b.onSubscribe(this);
                subscription.request(j11);
            }
        }

        public void onNext(CompletableSource completableSource) {
            if (this.f19095g != 0 || this.f19097i.offer(completableSource)) {
                a();
            } else {
                onError(new MissingBackpressureException());
            }
        }
    }

    public CompletableConcat(Publisher<? extends CompletableSource> publisher, int i11) {
        this.f19088b = publisher;
        this.f19089c = i11;
    }

    public void subscribeActual(CompletableObserver completableObserver) {
        this.f19088b.subscribe(new CompletableConcatSubscriber(completableObserver, this.f19089c));
    }
}
