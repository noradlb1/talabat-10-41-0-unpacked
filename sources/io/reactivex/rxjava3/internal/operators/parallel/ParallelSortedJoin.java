package io.reactivex.rxjava3.internal.operators.parallel;

import i.b;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.parallel.ParallelFlowable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class ParallelSortedJoin<T> extends Flowable<T> {

    /* renamed from: c  reason: collision with root package name */
    public final ParallelFlowable<List<T>> f22737c;

    /* renamed from: d  reason: collision with root package name */
    public final Comparator<? super T> f22738d;

    public static final class SortedJoinInnerSubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<List<T>> {
        private static final long serialVersionUID = 6751017204873808094L;

        /* renamed from: b  reason: collision with root package name */
        public final SortedJoinSubscription<T> f22739b;

        /* renamed from: c  reason: collision with root package name */
        public final int f22740c;

        public SortedJoinInnerSubscriber(SortedJoinSubscription<T> sortedJoinSubscription, int i11) {
            this.f22739b = sortedJoinSubscription;
            this.f22740c = i11;
        }

        public void a() {
            SubscriptionHelper.cancel(this);
        }

        public void onComplete() {
        }

        public void onError(Throwable th2) {
            this.f22739b.c(th2);
        }

        public void onSubscribe(Subscription subscription) {
            SubscriptionHelper.setOnce(this, subscription, Long.MAX_VALUE);
        }

        public void onNext(List<T> list) {
            this.f22739b.d(list, this.f22740c);
        }
    }

    public static final class SortedJoinSubscription<T> extends AtomicInteger implements Subscription {
        private static final long serialVersionUID = 3481980673745556697L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super T> f22741b;

        /* renamed from: c  reason: collision with root package name */
        public final SortedJoinInnerSubscriber<T>[] f22742c;

        /* renamed from: d  reason: collision with root package name */
        public final List<T>[] f22743d;

        /* renamed from: e  reason: collision with root package name */
        public final int[] f22744e;

        /* renamed from: f  reason: collision with root package name */
        public final Comparator<? super T> f22745f;

        /* renamed from: g  reason: collision with root package name */
        public final AtomicLong f22746g = new AtomicLong();

        /* renamed from: h  reason: collision with root package name */
        public volatile boolean f22747h;

        /* renamed from: i  reason: collision with root package name */
        public final AtomicInteger f22748i = new AtomicInteger();

        /* renamed from: j  reason: collision with root package name */
        public final AtomicReference<Throwable> f22749j = new AtomicReference<>();

        public SortedJoinSubscription(Subscriber<? super T> subscriber, int i11, Comparator<? super T> comparator) {
            this.f22741b = subscriber;
            this.f22745f = comparator;
            SortedJoinInnerSubscriber<T>[] sortedJoinInnerSubscriberArr = new SortedJoinInnerSubscriber[i11];
            for (int i12 = 0; i12 < i11; i12++) {
                sortedJoinInnerSubscriberArr[i12] = new SortedJoinInnerSubscriber<>(this, i12);
            }
            this.f22742c = sortedJoinInnerSubscriberArr;
            this.f22743d = new List[i11];
            this.f22744e = new int[i11];
            this.f22748i.lazySet(i11);
        }

        public void a() {
            for (SortedJoinInnerSubscriber<T> a11 : this.f22742c) {
                a11.a();
            }
        }

        public void b() {
            boolean z11;
            boolean z12;
            if (getAndIncrement() == 0) {
                Subscriber<? super T> subscriber = this.f22741b;
                List<T>[] listArr = this.f22743d;
                int[] iArr = this.f22744e;
                int length = iArr.length;
                int i11 = 1;
                do {
                    long j11 = this.f22746g.get();
                    long j12 = 0;
                    while (j12 != j11) {
                        if (this.f22747h) {
                            Arrays.fill(listArr, (Object) null);
                            return;
                        }
                        Throwable th2 = this.f22749j.get();
                        if (th2 != null) {
                            a();
                            Arrays.fill(listArr, (Object) null);
                            subscriber.onError(th2);
                            return;
                        }
                        int i12 = -1;
                        T t11 = null;
                        for (int i13 = 0; i13 < length; i13++) {
                            List<T> list = listArr[i13];
                            int i14 = iArr[i13];
                            if (list.size() != i14) {
                                if (t11 == null) {
                                    t11 = list.get(i14);
                                } else {
                                    T t12 = list.get(i14);
                                    try {
                                        if (this.f22745f.compare(t11, t12) > 0) {
                                            z12 = true;
                                        } else {
                                            z12 = false;
                                        }
                                        if (z12) {
                                            t11 = t12;
                                        }
                                    } catch (Throwable th3) {
                                        Exceptions.throwIfFatal(th3);
                                        a();
                                        Arrays.fill(listArr, (Object) null);
                                        if (!b.a(this.f22749j, (Object) null, th3)) {
                                            RxJavaPlugins.onError(th3);
                                        }
                                        subscriber.onError(this.f22749j.get());
                                        return;
                                    }
                                }
                                i12 = i13;
                            }
                        }
                        if (t11 == null) {
                            Arrays.fill(listArr, (Object) null);
                            subscriber.onComplete();
                            return;
                        }
                        subscriber.onNext(t11);
                        iArr[i12] = iArr[i12] + 1;
                        j12++;
                    }
                    if (this.f22747h) {
                        Arrays.fill(listArr, (Object) null);
                        return;
                    }
                    Throwable th4 = this.f22749j.get();
                    if (th4 != null) {
                        a();
                        Arrays.fill(listArr, (Object) null);
                        subscriber.onError(th4);
                        return;
                    }
                    int i15 = 0;
                    while (true) {
                        if (i15 >= length) {
                            z11 = true;
                            break;
                        } else if (iArr[i15] != listArr[i15].size()) {
                            z11 = false;
                            break;
                        } else {
                            i15++;
                        }
                    }
                    if (z11) {
                        Arrays.fill(listArr, (Object) null);
                        subscriber.onComplete();
                        return;
                    }
                    if (j12 != 0) {
                        BackpressureHelper.produced(this.f22746g, j12);
                    }
                    i11 = addAndGet(-i11);
                } while (i11 != 0);
            }
        }

        public void c(Throwable th2) {
            if (b.a(this.f22749j, (Object) null, th2)) {
                b();
            } else if (th2 != this.f22749j.get()) {
                RxJavaPlugins.onError(th2);
            }
        }

        public void cancel() {
            if (!this.f22747h) {
                this.f22747h = true;
                a();
                if (getAndIncrement() == 0) {
                    Arrays.fill(this.f22743d, (Object) null);
                }
            }
        }

        public void d(List<T> list, int i11) {
            this.f22743d[i11] = list;
            if (this.f22748i.decrementAndGet() == 0) {
                b();
            }
        }

        public void request(long j11) {
            if (SubscriptionHelper.validate(j11)) {
                BackpressureHelper.add(this.f22746g, j11);
                if (this.f22748i.get() == 0) {
                    b();
                }
            }
        }
    }

    public ParallelSortedJoin(ParallelFlowable<List<T>> parallelFlowable, Comparator<? super T> comparator) {
        this.f22737c = parallelFlowable;
        this.f22738d = comparator;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        SortedJoinSubscription sortedJoinSubscription = new SortedJoinSubscription(subscriber, this.f22737c.parallelism(), this.f22738d);
        subscriber.onSubscribe(sortedJoinSubscription);
        this.f22737c.subscribe(sortedJoinSubscription.f22742c);
    }
}
