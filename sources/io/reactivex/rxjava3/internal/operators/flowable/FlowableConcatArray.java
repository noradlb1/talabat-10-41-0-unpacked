package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionArbiter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableConcatArray<T> extends Flowable<T> {

    /* renamed from: c  reason: collision with root package name */
    public final Publisher<? extends T>[] f19462c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f19463d;

    public static final class ConcatArraySubscriber<T> extends SubscriptionArbiter implements FlowableSubscriber<T> {
        private static final long serialVersionUID = -8158322871608889516L;

        /* renamed from: j  reason: collision with root package name */
        public final Subscriber<? super T> f19464j;

        /* renamed from: k  reason: collision with root package name */
        public final Publisher<? extends T>[] f19465k;

        /* renamed from: l  reason: collision with root package name */
        public final boolean f19466l;

        /* renamed from: m  reason: collision with root package name */
        public final AtomicInteger f19467m = new AtomicInteger();

        /* renamed from: n  reason: collision with root package name */
        public int f19468n;

        /* renamed from: o  reason: collision with root package name */
        public List<Throwable> f19469o;

        /* renamed from: p  reason: collision with root package name */
        public long f19470p;

        public ConcatArraySubscriber(Publisher<? extends T>[] publisherArr, boolean z11, Subscriber<? super T> subscriber) {
            super(false);
            this.f19464j = subscriber;
            this.f19465k = publisherArr;
            this.f19466l = z11;
        }

        public void onComplete() {
            if (this.f19467m.getAndIncrement() == 0) {
                Publisher<? extends T>[] publisherArr = this.f19465k;
                int length = publisherArr.length;
                int i11 = this.f19468n;
                while (i11 != length) {
                    Publisher<? extends T> publisher = publisherArr[i11];
                    if (publisher == null) {
                        NullPointerException nullPointerException = new NullPointerException("A Publisher entry is null");
                        if (this.f19466l) {
                            List list = this.f19469o;
                            if (list == null) {
                                list = new ArrayList((length - i11) + 1);
                                this.f19469o = list;
                            }
                            list.add(nullPointerException);
                            i11++;
                        } else {
                            this.f19464j.onError(nullPointerException);
                            return;
                        }
                    } else {
                        long j11 = this.f19470p;
                        if (j11 != 0) {
                            this.f19470p = 0;
                            produced(j11);
                        }
                        publisher.subscribe(this);
                        i11++;
                        this.f19468n = i11;
                        if (this.f19467m.decrementAndGet() == 0) {
                            return;
                        }
                    }
                }
                List<Throwable> list2 = this.f19469o;
                if (list2 == null) {
                    this.f19464j.onComplete();
                } else if (list2.size() == 1) {
                    this.f19464j.onError(list2.get(0));
                } else {
                    this.f19464j.onError(new CompositeException((Iterable<? extends Throwable>) list2));
                }
            }
        }

        public void onError(Throwable th2) {
            if (this.f19466l) {
                List list = this.f19469o;
                if (list == null) {
                    list = new ArrayList((this.f19465k.length - this.f19468n) + 1);
                    this.f19469o = list;
                }
                list.add(th2);
                onComplete();
                return;
            }
            this.f19464j.onError(th2);
        }

        public void onNext(T t11) {
            this.f19470p++;
            this.f19464j.onNext(t11);
        }

        public void onSubscribe(Subscription subscription) {
            setSubscription(subscription);
        }
    }

    public FlowableConcatArray(Publisher<? extends T>[] publisherArr, boolean z11) {
        this.f19462c = publisherArr;
        this.f19463d = z11;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        ConcatArraySubscriber concatArraySubscriber = new ConcatArraySubscriber(this.f19462c, this.f19463d, subscriber);
        subscriber.onSubscribe(concatArraySubscriber);
        concatArraySubscriber.onComplete();
    }
}
