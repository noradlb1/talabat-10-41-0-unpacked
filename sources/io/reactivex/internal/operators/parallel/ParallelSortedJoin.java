package io.reactivex.internal.operators.parallel;

import i.b;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.parallel.ParallelFlowable;
import io.reactivex.plugins.RxJavaPlugins;
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
    public final ParallelFlowable<List<T>> f18203c;

    /* renamed from: d  reason: collision with root package name */
    public final Comparator<? super T> f18204d;

    public static final class SortedJoinInnerSubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<List<T>> {
        private static final long serialVersionUID = 6751017204873808094L;

        /* renamed from: b  reason: collision with root package name */
        public final SortedJoinSubscription<T> f18205b;

        /* renamed from: c  reason: collision with root package name */
        public final int f18206c;

        public SortedJoinInnerSubscriber(SortedJoinSubscription<T> sortedJoinSubscription, int i11) {
            this.f18205b = sortedJoinSubscription;
            this.f18206c = i11;
        }

        public void a() {
            SubscriptionHelper.cancel(this);
        }

        public void onComplete() {
        }

        public void onError(Throwable th2) {
            this.f18205b.c(th2);
        }

        public void onSubscribe(Subscription subscription) {
            SubscriptionHelper.setOnce(this, subscription, Long.MAX_VALUE);
        }

        public void onNext(List<T> list) {
            this.f18205b.d(list, this.f18206c);
        }
    }

    public static final class SortedJoinSubscription<T> extends AtomicInteger implements Subscription {
        private static final long serialVersionUID = 3481980673745556697L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super T> f18207b;

        /* renamed from: c  reason: collision with root package name */
        public final SortedJoinInnerSubscriber<T>[] f18208c;

        /* renamed from: d  reason: collision with root package name */
        public final List<T>[] f18209d;

        /* renamed from: e  reason: collision with root package name */
        public final int[] f18210e;

        /* renamed from: f  reason: collision with root package name */
        public final Comparator<? super T> f18211f;

        /* renamed from: g  reason: collision with root package name */
        public final AtomicLong f18212g = new AtomicLong();

        /* renamed from: h  reason: collision with root package name */
        public volatile boolean f18213h;

        /* renamed from: i  reason: collision with root package name */
        public final AtomicInteger f18214i = new AtomicInteger();

        /* renamed from: j  reason: collision with root package name */
        public final AtomicReference<Throwable> f18215j = new AtomicReference<>();

        public SortedJoinSubscription(Subscriber<? super T> subscriber, int i11, Comparator<? super T> comparator) {
            this.f18207b = subscriber;
            this.f18211f = comparator;
            SortedJoinInnerSubscriber<T>[] sortedJoinInnerSubscriberArr = new SortedJoinInnerSubscriber[i11];
            for (int i12 = 0; i12 < i11; i12++) {
                sortedJoinInnerSubscriberArr[i12] = new SortedJoinInnerSubscriber<>(this, i12);
            }
            this.f18208c = sortedJoinInnerSubscriberArr;
            this.f18209d = new List[i11];
            this.f18210e = new int[i11];
            this.f18214i.lazySet(i11);
        }

        public void a() {
            for (SortedJoinInnerSubscriber<T> a11 : this.f18208c) {
                a11.a();
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:42:0x00a3, code lost:
            if (r13 != 0) goto L_0x00e0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:0x00a7, code lost:
            if (r1.f18213h == false) goto L_0x00ae;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:45:0x00a9, code lost:
            java.util.Arrays.fill(r3, (java.lang.Object) null);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:0x00ad, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:47:0x00ae, code lost:
            r10 = r1.f18215j.get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:48:0x00b7, code lost:
            if (r10 == null) goto L_0x00c3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:0x00b9, code lost:
            a();
            java.util.Arrays.fill(r3, (java.lang.Object) null);
            r2.onError(r10);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:50:0x00c2, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:51:0x00c3, code lost:
            r5 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:52:0x00c4, code lost:
            if (r5 >= r4) goto L_0x00d5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:54:0x00ce, code lost:
            if (r0[r5] == r3[r5].size()) goto L_0x00d2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:55:0x00d0, code lost:
            r14 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:56:0x00d2, code lost:
            r5 = r5 + 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:57:0x00d5, code lost:
            r14 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:58:0x00d6, code lost:
            if (r14 == false) goto L_0x00e0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:59:0x00d8, code lost:
            java.util.Arrays.fill(r3, (java.lang.Object) null);
            r2.onComplete();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:60:0x00df, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:62:0x00e4, code lost:
            if (r11 == 0) goto L_0x00f5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:64:0x00ed, code lost:
            if (r7 == Long.MAX_VALUE) goto L_0x00f5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:65:0x00ef, code lost:
            r1.f18212g.addAndGet(-r11);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:66:0x00f5, code lost:
            r5 = get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:67:0x00f9, code lost:
            if (r5 != r6) goto L_0x0103;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:68:0x00fb, code lost:
            r5 = addAndGet(-r6);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:69:0x0100, code lost:
            if (r5 != 0) goto L_0x0103;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:70:0x0102, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void b() {
            /*
                r16 = this;
                r1 = r16
                int r0 = r16.getAndIncrement()
                if (r0 == 0) goto L_0x0009
                return
            L_0x0009:
                org.reactivestreams.Subscriber<? super T> r2 = r1.f18207b
                java.util.List<T>[] r3 = r1.f18209d
                int[] r0 = r1.f18210e
                int r4 = r0.length
                r6 = 1
            L_0x0011:
                java.util.concurrent.atomic.AtomicLong r7 = r1.f18212g
                long r7 = r7.get()
                r11 = 0
            L_0x0019:
                int r13 = (r11 > r7 ? 1 : (r11 == r7 ? 0 : -1))
                r15 = 0
                if (r13 == 0) goto L_0x00a2
                boolean r13 = r1.f18213h
                if (r13 == 0) goto L_0x0026
                java.util.Arrays.fill(r3, r15)
                return
            L_0x0026:
                java.util.concurrent.atomic.AtomicReference<java.lang.Throwable> r13 = r1.f18215j
                java.lang.Object r13 = r13.get()
                java.lang.Throwable r13 = (java.lang.Throwable) r13
                if (r13 == 0) goto L_0x003a
                r16.a()
                java.util.Arrays.fill(r3, r15)
                r2.onError(r13)
                return
            L_0x003a:
                r13 = -1
                r9 = r15
                r14 = 0
            L_0x003d:
                if (r14 >= r4) goto L_0x008a
                r10 = r3[r14]
                r5 = r0[r14]
                int r15 = r10.size()
                if (r15 == r5) goto L_0x0086
                if (r9 != 0) goto L_0x0051
                java.lang.Object r9 = r10.get(r5)
            L_0x004f:
                r13 = r14
                goto L_0x0086
            L_0x0051:
                java.lang.Object r5 = r10.get(r5)
                java.util.Comparator<? super T> r10 = r1.f18211f     // Catch:{ all -> 0x0064 }
                int r10 = r10.compare(r9, r5)     // Catch:{ all -> 0x0064 }
                if (r10 <= 0) goto L_0x005f
                r10 = 1
                goto L_0x0060
            L_0x005f:
                r10 = 0
            L_0x0060:
                if (r10 == 0) goto L_0x0086
                r9 = r5
                goto L_0x004f
            L_0x0064:
                r0 = move-exception
                io.reactivex.exceptions.Exceptions.throwIfFatal(r0)
                r16.a()
                r4 = 0
                java.util.Arrays.fill(r3, r4)
                java.util.concurrent.atomic.AtomicReference<java.lang.Throwable> r3 = r1.f18215j
                boolean r3 = i.b.a(r3, r4, r0)
                if (r3 != 0) goto L_0x007a
                io.reactivex.plugins.RxJavaPlugins.onError(r0)
            L_0x007a:
                java.util.concurrent.atomic.AtomicReference<java.lang.Throwable> r0 = r1.f18215j
                java.lang.Object r0 = r0.get()
                java.lang.Throwable r0 = (java.lang.Throwable) r0
                r2.onError(r0)
                return
            L_0x0086:
                int r14 = r14 + 1
                r15 = 0
                goto L_0x003d
            L_0x008a:
                if (r9 != 0) goto L_0x0094
                r5 = 0
                java.util.Arrays.fill(r3, r5)
                r2.onComplete()
                return
            L_0x0094:
                r2.onNext(r9)
                r5 = r0[r13]
                r9 = 1
                int r5 = r5 + r9
                r0[r13] = r5
                r13 = 1
                long r11 = r11 + r13
                goto L_0x0019
            L_0x00a2:
                r9 = 1
                if (r13 != 0) goto L_0x00e0
                boolean r5 = r1.f18213h
                if (r5 == 0) goto L_0x00ae
                r5 = 0
                java.util.Arrays.fill(r3, r5)
                return
            L_0x00ae:
                r5 = 0
                java.util.concurrent.atomic.AtomicReference<java.lang.Throwable> r10 = r1.f18215j
                java.lang.Object r10 = r10.get()
                java.lang.Throwable r10 = (java.lang.Throwable) r10
                if (r10 == 0) goto L_0x00c3
                r16.a()
                java.util.Arrays.fill(r3, r5)
                r2.onError(r10)
                return
            L_0x00c3:
                r5 = 0
            L_0x00c4:
                if (r5 >= r4) goto L_0x00d5
                r10 = r0[r5]
                r13 = r3[r5]
                int r13 = r13.size()
                if (r10 == r13) goto L_0x00d2
                r14 = 0
                goto L_0x00d6
            L_0x00d2:
                int r5 = r5 + 1
                goto L_0x00c4
            L_0x00d5:
                r14 = r9
            L_0x00d6:
                if (r14 == 0) goto L_0x00e0
                r5 = 0
                java.util.Arrays.fill(r3, r5)
                r2.onComplete()
                return
            L_0x00e0:
                r13 = 0
                int r5 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
                if (r5 == 0) goto L_0x00f5
                r13 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                int r5 = (r7 > r13 ? 1 : (r7 == r13 ? 0 : -1))
                if (r5 == 0) goto L_0x00f5
                java.util.concurrent.atomic.AtomicLong r5 = r1.f18212g
                long r7 = -r11
                r5.addAndGet(r7)
            L_0x00f5:
                int r5 = r16.get()
                if (r5 != r6) goto L_0x0103
                int r5 = -r6
                int r5 = r1.addAndGet(r5)
                if (r5 != 0) goto L_0x0103
                return
            L_0x0103:
                r6 = r5
                goto L_0x0011
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.parallel.ParallelSortedJoin.SortedJoinSubscription.b():void");
        }

        public void c(Throwable th2) {
            if (b.a(this.f18215j, (Object) null, th2)) {
                b();
            } else if (th2 != this.f18215j.get()) {
                RxJavaPlugins.onError(th2);
            }
        }

        public void cancel() {
            if (!this.f18213h) {
                this.f18213h = true;
                a();
                if (getAndIncrement() == 0) {
                    Arrays.fill(this.f18209d, (Object) null);
                }
            }
        }

        public void d(List<T> list, int i11) {
            this.f18209d[i11] = list;
            if (this.f18214i.decrementAndGet() == 0) {
                b();
            }
        }

        public void request(long j11) {
            if (SubscriptionHelper.validate(j11)) {
                BackpressureHelper.add(this.f18212g, j11);
                if (this.f18214i.get() == 0) {
                    b();
                }
            }
        }
    }

    public ParallelSortedJoin(ParallelFlowable<List<T>> parallelFlowable, Comparator<? super T> comparator) {
        this.f18203c = parallelFlowable;
        this.f18204d = comparator;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        SortedJoinSubscription sortedJoinSubscription = new SortedJoinSubscription(subscriber, this.f18203c.parallelism(), this.f18204d);
        subscriber.onSubscribe(sortedJoinSubscription);
        this.f18203c.subscribe(sortedJoinSubscription.f18208c);
    }
}
