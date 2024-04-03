package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.operators.SimplePlainQueue;
import io.reactivex.rxjava3.operators.SpscArrayQueue;
import io.reactivex.rxjava3.operators.SpscLinkedArrayQueue;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableOnBackpressureBuffer<T> extends AbstractFlowableWithUpstream<T, T> {

    /* renamed from: d  reason: collision with root package name */
    public final int f20058d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f20059e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f20060f;

    /* renamed from: g  reason: collision with root package name */
    public final Action f20061g;

    public static final class BackpressureBufferSubscriber<T> extends BasicIntQueueSubscription<T> implements FlowableSubscriber<T> {
        private static final long serialVersionUID = -2514538129242366402L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super T> f20062b;

        /* renamed from: c  reason: collision with root package name */
        public final SimplePlainQueue<T> f20063c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f20064d;

        /* renamed from: e  reason: collision with root package name */
        public final Action f20065e;

        /* renamed from: f  reason: collision with root package name */
        public Subscription f20066f;

        /* renamed from: g  reason: collision with root package name */
        public volatile boolean f20067g;

        /* renamed from: h  reason: collision with root package name */
        public volatile boolean f20068h;

        /* renamed from: i  reason: collision with root package name */
        public Throwable f20069i;

        /* renamed from: j  reason: collision with root package name */
        public final AtomicLong f20070j = new AtomicLong();

        /* renamed from: k  reason: collision with root package name */
        public boolean f20071k;

        public BackpressureBufferSubscriber(Subscriber<? super T> subscriber, int i11, boolean z11, boolean z12, Action action) {
            SimplePlainQueue<T> simplePlainQueue;
            this.f20062b = subscriber;
            this.f20065e = action;
            this.f20064d = z12;
            if (z11) {
                simplePlainQueue = new SpscLinkedArrayQueue<>(i11);
            } else {
                simplePlainQueue = new SpscArrayQueue<>(i11);
            }
            this.f20063c = simplePlainQueue;
        }

        public boolean a(boolean z11, boolean z12, Subscriber<? super T> subscriber) {
            if (this.f20067g) {
                this.f20063c.clear();
                return true;
            } else if (!z11) {
                return false;
            } else {
                if (!this.f20064d) {
                    Throwable th2 = this.f20069i;
                    if (th2 != null) {
                        this.f20063c.clear();
                        subscriber.onError(th2);
                        return true;
                    } else if (!z12) {
                        return false;
                    } else {
                        subscriber.onComplete();
                        return true;
                    }
                } else if (!z12) {
                    return false;
                } else {
                    Throwable th3 = this.f20069i;
                    if (th3 != null) {
                        subscriber.onError(th3);
                    } else {
                        subscriber.onComplete();
                    }
                    return true;
                }
            }
        }

        public void cancel() {
            if (!this.f20067g) {
                this.f20067g = true;
                this.f20066f.cancel();
                if (!this.f20071k && getAndIncrement() == 0) {
                    this.f20063c.clear();
                }
            }
        }

        public void clear() {
            this.f20063c.clear();
        }

        public void drain() {
            int i11;
            boolean z11;
            if (getAndIncrement() == 0) {
                SimplePlainQueue<T> simplePlainQueue = this.f20063c;
                Subscriber<? super T> subscriber = this.f20062b;
                int i12 = 1;
                while (!a(this.f20068h, simplePlainQueue.isEmpty(), subscriber)) {
                    long j11 = this.f20070j.get();
                    long j12 = 0;
                    while (true) {
                        i11 = (j12 > j11 ? 1 : (j12 == j11 ? 0 : -1));
                        if (i11 == 0) {
                            break;
                        }
                        boolean z12 = this.f20068h;
                        T poll = simplePlainQueue.poll();
                        if (poll == null) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        if (!a(z12, z11, subscriber)) {
                            if (z11) {
                                break;
                            }
                            subscriber.onNext(poll);
                            j12++;
                        } else {
                            return;
                        }
                    }
                    if (i11 != 0 || !a(this.f20068h, simplePlainQueue.isEmpty(), subscriber)) {
                        if (!(j12 == 0 || j11 == Long.MAX_VALUE)) {
                            this.f20070j.addAndGet(-j12);
                        }
                        i12 = addAndGet(-i12);
                        if (i12 == 0) {
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
        }

        public boolean isEmpty() {
            return this.f20063c.isEmpty();
        }

        public void onComplete() {
            this.f20068h = true;
            if (this.f20071k) {
                this.f20062b.onComplete();
            } else {
                drain();
            }
        }

        public void onError(Throwable th2) {
            this.f20069i = th2;
            this.f20068h = true;
            if (this.f20071k) {
                this.f20062b.onError(th2);
            } else {
                drain();
            }
        }

        public void onNext(T t11) {
            if (!this.f20063c.offer(t11)) {
                this.f20066f.cancel();
                MissingBackpressureException missingBackpressureException = new MissingBackpressureException("Buffer is full");
                try {
                    this.f20065e.run();
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    missingBackpressureException.initCause(th2);
                }
                onError(missingBackpressureException);
            } else if (this.f20071k) {
                this.f20062b.onNext(null);
            } else {
                drain();
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f20066f, subscription)) {
                this.f20066f = subscription;
                this.f20062b.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        @Nullable
        public T poll() {
            return this.f20063c.poll();
        }

        public void request(long j11) {
            if (!this.f20071k && SubscriptionHelper.validate(j11)) {
                BackpressureHelper.add(this.f20070j, j11);
                drain();
            }
        }

        public int requestFusion(int i11) {
            if ((i11 & 2) == 0) {
                return 0;
            }
            this.f20071k = true;
            return 2;
        }
    }

    public FlowableOnBackpressureBuffer(Flowable<T> flowable, int i11, boolean z11, boolean z12, Action action) {
        super(flowable);
        this.f20058d = i11;
        this.f20059e = z11;
        this.f20060f = z12;
        this.f20061g = action;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.f19260c.subscribe(new BackpressureBufferSubscriber(subscriber, this.f20058d, this.f20059e, this.f20060f, this.f20061g));
    }
}
