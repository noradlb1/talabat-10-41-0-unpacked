package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;

public final class CompletableConcat extends Completable {

    /* renamed from: b  reason: collision with root package name */
    public final Publisher<? extends CompletableSource> f14603b;

    /* renamed from: c  reason: collision with root package name */
    public final int f14604c;

    public static final class CompletableConcatSubscriber extends AtomicInteger implements FlowableSubscriber<CompletableSource>, Disposable {
        private static final long serialVersionUID = 9032184911934499404L;

        /* renamed from: b  reason: collision with root package name */
        public final CompletableObserver f14605b;

        /* renamed from: c  reason: collision with root package name */
        public final int f14606c;

        /* renamed from: d  reason: collision with root package name */
        public final int f14607d;

        /* renamed from: e  reason: collision with root package name */
        public final ConcatInnerObserver f14608e = new ConcatInnerObserver(this);

        /* renamed from: f  reason: collision with root package name */
        public final AtomicBoolean f14609f = new AtomicBoolean();

        /* renamed from: g  reason: collision with root package name */
        public int f14610g;

        /* renamed from: h  reason: collision with root package name */
        public int f14611h;

        /* renamed from: i  reason: collision with root package name */
        public SimpleQueue<CompletableSource> f14612i;

        /* renamed from: j  reason: collision with root package name */
        public Subscription f14613j;

        /* renamed from: k  reason: collision with root package name */
        public volatile boolean f14614k;

        /* renamed from: l  reason: collision with root package name */
        public volatile boolean f14615l;

        public static final class ConcatInnerObserver extends AtomicReference<Disposable> implements CompletableObserver {
            private static final long serialVersionUID = -5454794857847146511L;

            /* renamed from: b  reason: collision with root package name */
            public final CompletableConcatSubscriber f14616b;

            public ConcatInnerObserver(CompletableConcatSubscriber completableConcatSubscriber) {
                this.f14616b = completableConcatSubscriber;
            }

            public void onComplete() {
                this.f14616b.b();
            }

            public void onError(Throwable th2) {
                this.f14616b.c(th2);
            }

            public void onSubscribe(Disposable disposable) {
                DisposableHelper.replace(this, disposable);
            }
        }

        public CompletableConcatSubscriber(CompletableObserver completableObserver, int i11) {
            this.f14605b = completableObserver;
            this.f14606c = i11;
            this.f14607d = i11 - (i11 >> 2);
        }

        public void a() {
            boolean z11;
            if (getAndIncrement() == 0) {
                while (!isDisposed()) {
                    if (!this.f14615l) {
                        boolean z12 = this.f14614k;
                        try {
                            CompletableSource poll = this.f14612i.poll();
                            if (poll == null) {
                                z11 = true;
                            } else {
                                z11 = false;
                            }
                            if (!z12 || !z11) {
                                if (!z11) {
                                    this.f14615l = true;
                                    poll.subscribe(this.f14608e);
                                    d();
                                }
                            } else if (this.f14609f.compareAndSet(false, true)) {
                                this.f14605b.onComplete();
                                return;
                            } else {
                                return;
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
            this.f14615l = false;
            a();
        }

        public void c(Throwable th2) {
            if (this.f14609f.compareAndSet(false, true)) {
                this.f14613j.cancel();
                this.f14605b.onError(th2);
                return;
            }
            RxJavaPlugins.onError(th2);
        }

        public void d() {
            if (this.f14610g != 1) {
                int i11 = this.f14611h + 1;
                if (i11 == this.f14607d) {
                    this.f14611h = 0;
                    this.f14613j.request((long) i11);
                    return;
                }
                this.f14611h = i11;
            }
        }

        public void dispose() {
            this.f14613j.cancel();
            DisposableHelper.dispose(this.f14608e);
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) this.f14608e.get());
        }

        public void onComplete() {
            this.f14614k = true;
            a();
        }

        public void onError(Throwable th2) {
            if (this.f14609f.compareAndSet(false, true)) {
                DisposableHelper.dispose(this.f14608e);
                this.f14605b.onError(th2);
                return;
            }
            RxJavaPlugins.onError(th2);
        }

        public void onSubscribe(Subscription subscription) {
            long j11;
            if (SubscriptionHelper.validate(this.f14613j, subscription)) {
                this.f14613j = subscription;
                int i11 = this.f14606c;
                if (i11 == Integer.MAX_VALUE) {
                    j11 = Long.MAX_VALUE;
                } else {
                    j11 = (long) i11;
                }
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int requestFusion = queueSubscription.requestFusion(3);
                    if (requestFusion == 1) {
                        this.f14610g = requestFusion;
                        this.f14612i = queueSubscription;
                        this.f14614k = true;
                        this.f14605b.onSubscribe(this);
                        a();
                        return;
                    } else if (requestFusion == 2) {
                        this.f14610g = requestFusion;
                        this.f14612i = queueSubscription;
                        this.f14605b.onSubscribe(this);
                        subscription.request(j11);
                        return;
                    }
                }
                if (this.f14606c == Integer.MAX_VALUE) {
                    this.f14612i = new SpscLinkedArrayQueue(Flowable.bufferSize());
                } else {
                    this.f14612i = new SpscArrayQueue(this.f14606c);
                }
                this.f14605b.onSubscribe(this);
                subscription.request(j11);
            }
        }

        public void onNext(CompletableSource completableSource) {
            if (this.f14610g != 0 || this.f14612i.offer(completableSource)) {
                a();
            } else {
                onError(new MissingBackpressureException());
            }
        }
    }

    public CompletableConcat(Publisher<? extends CompletableSource> publisher, int i11) {
        this.f14603b = publisher;
        this.f14604c = i11;
    }

    public void subscribeActual(CompletableObserver completableObserver) {
        this.f14603b.subscribe(new CompletableConcatSubscriber(completableObserver, this.f14604c));
    }
}
