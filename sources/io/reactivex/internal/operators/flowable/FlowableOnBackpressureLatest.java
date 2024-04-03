package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableOnBackpressureLatest<T> extends AbstractFlowableWithUpstream<T, T> {

    public static final class BackpressureLatestSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = 163080509307634843L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super T> f15571b;

        /* renamed from: c  reason: collision with root package name */
        public Subscription f15572c;

        /* renamed from: d  reason: collision with root package name */
        public volatile boolean f15573d;

        /* renamed from: e  reason: collision with root package name */
        public Throwable f15574e;

        /* renamed from: f  reason: collision with root package name */
        public volatile boolean f15575f;

        /* renamed from: g  reason: collision with root package name */
        public final AtomicLong f15576g = new AtomicLong();

        /* renamed from: h  reason: collision with root package name */
        public final AtomicReference<T> f15577h = new AtomicReference<>();

        public BackpressureLatestSubscriber(Subscriber<? super T> subscriber) {
            this.f15571b = subscriber;
        }

        public boolean a(boolean z11, boolean z12, Subscriber<?> subscriber, AtomicReference<T> atomicReference) {
            if (this.f15575f) {
                atomicReference.lazySet((Object) null);
                return true;
            } else if (!z11) {
                return false;
            } else {
                Throwable th2 = this.f15574e;
                if (th2 != null) {
                    atomicReference.lazySet((Object) null);
                    subscriber.onError(th2);
                    return true;
                } else if (!z12) {
                    return false;
                } else {
                    subscriber.onComplete();
                    return true;
                }
            }
        }

        public void b() {
            boolean z11;
            boolean z12;
            if (getAndIncrement() == 0) {
                Subscriber<? super T> subscriber = this.f15571b;
                AtomicLong atomicLong = this.f15576g;
                AtomicReference<T> atomicReference = this.f15577h;
                int i11 = 1;
                do {
                    long j11 = 0;
                    while (true) {
                        z11 = false;
                        if (j11 == atomicLong.get()) {
                            break;
                        }
                        boolean z13 = this.f15573d;
                        T andSet = atomicReference.getAndSet((Object) null);
                        if (andSet == null) {
                            z12 = true;
                        } else {
                            z12 = false;
                        }
                        if (!a(z13, z12, subscriber, atomicReference)) {
                            if (z12) {
                                break;
                            }
                            subscriber.onNext(andSet);
                            j11++;
                        } else {
                            return;
                        }
                    }
                    if (j11 == atomicLong.get()) {
                        boolean z14 = this.f15573d;
                        if (atomicReference.get() == null) {
                            z11 = true;
                        }
                        if (a(z14, z11, subscriber, atomicReference)) {
                            return;
                        }
                    }
                    if (j11 != 0) {
                        BackpressureHelper.produced(atomicLong, j11);
                    }
                    i11 = addAndGet(-i11);
                } while (i11 != 0);
            }
        }

        public void cancel() {
            if (!this.f15575f) {
                this.f15575f = true;
                this.f15572c.cancel();
                if (getAndIncrement() == 0) {
                    this.f15577h.lazySet((Object) null);
                }
            }
        }

        public void onComplete() {
            this.f15573d = true;
            b();
        }

        public void onError(Throwable th2) {
            this.f15574e = th2;
            this.f15573d = true;
            b();
        }

        public void onNext(T t11) {
            this.f15577h.lazySet(t11);
            b();
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f15572c, subscription)) {
                this.f15572c = subscription;
                this.f15571b.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        public void request(long j11) {
            if (SubscriptionHelper.validate(j11)) {
                BackpressureHelper.add(this.f15576g, j11);
                b();
            }
        }
    }

    public FlowableOnBackpressureLatest(Flowable<T> flowable) {
        super(flowable);
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.f14763c.subscribe(new BackpressureLatestSubscriber(subscriber));
    }
}
