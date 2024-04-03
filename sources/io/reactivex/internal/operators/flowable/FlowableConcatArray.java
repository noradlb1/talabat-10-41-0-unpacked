package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableConcatArray<T> extends Flowable<T> {

    /* renamed from: c  reason: collision with root package name */
    public final Publisher<? extends T>[] f14974c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f14975d;

    public static final class ConcatArraySubscriber<T> extends SubscriptionArbiter implements FlowableSubscriber<T> {
        private static final long serialVersionUID = -8158322871608889516L;

        /* renamed from: j  reason: collision with root package name */
        public final Subscriber<? super T> f14976j;

        /* renamed from: k  reason: collision with root package name */
        public final Publisher<? extends T>[] f14977k;

        /* renamed from: l  reason: collision with root package name */
        public final boolean f14978l;

        /* renamed from: m  reason: collision with root package name */
        public final AtomicInteger f14979m = new AtomicInteger();

        /* renamed from: n  reason: collision with root package name */
        public int f14980n;

        /* renamed from: o  reason: collision with root package name */
        public List<Throwable> f14981o;

        /* renamed from: p  reason: collision with root package name */
        public long f14982p;

        public ConcatArraySubscriber(Publisher<? extends T>[] publisherArr, boolean z11, Subscriber<? super T> subscriber) {
            super(false);
            this.f14976j = subscriber;
            this.f14977k = publisherArr;
            this.f14978l = z11;
        }

        public void onComplete() {
            if (this.f14979m.getAndIncrement() == 0) {
                Publisher<? extends T>[] publisherArr = this.f14977k;
                int length = publisherArr.length;
                int i11 = this.f14980n;
                while (i11 != length) {
                    Publisher<? extends T> publisher = publisherArr[i11];
                    if (publisher == null) {
                        NullPointerException nullPointerException = new NullPointerException("A Publisher entry is null");
                        if (this.f14978l) {
                            List list = this.f14981o;
                            if (list == null) {
                                list = new ArrayList((length - i11) + 1);
                                this.f14981o = list;
                            }
                            list.add(nullPointerException);
                            i11++;
                        } else {
                            this.f14976j.onError(nullPointerException);
                            return;
                        }
                    } else {
                        long j11 = this.f14982p;
                        if (j11 != 0) {
                            this.f14982p = 0;
                            produced(j11);
                        }
                        publisher.subscribe(this);
                        i11++;
                        this.f14980n = i11;
                        if (this.f14979m.decrementAndGet() == 0) {
                            return;
                        }
                    }
                }
                List<Throwable> list2 = this.f14981o;
                if (list2 == null) {
                    this.f14976j.onComplete();
                } else if (list2.size() == 1) {
                    this.f14976j.onError(list2.get(0));
                } else {
                    this.f14976j.onError(new CompositeException((Iterable<? extends Throwable>) list2));
                }
            }
        }

        public void onError(Throwable th2) {
            if (this.f14978l) {
                List list = this.f14981o;
                if (list == null) {
                    list = new ArrayList((this.f14977k.length - this.f14980n) + 1);
                    this.f14981o = list;
                }
                list.add(th2);
                onComplete();
                return;
            }
            this.f14976j.onError(th2);
        }

        public void onNext(T t11) {
            this.f14982p++;
            this.f14976j.onNext(t11);
        }

        public void onSubscribe(Subscription subscription) {
            setSubscription(subscription);
        }
    }

    public FlowableConcatArray(Publisher<? extends T>[] publisherArr, boolean z11) {
        this.f14974c = publisherArr;
        this.f14975d = z11;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        ConcatArraySubscriber concatArraySubscriber = new ConcatArraySubscriber(this.f14974c, this.f14975d, subscriber);
        subscriber.onSubscribe(concatArraySubscriber);
        concatArraySubscriber.onComplete();
    }
}
