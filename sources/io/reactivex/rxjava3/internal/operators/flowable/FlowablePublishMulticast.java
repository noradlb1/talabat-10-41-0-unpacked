package io.reactivex.rxjava3.internal.operators.flowable;

import i.b;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.internal.util.QueueDrainHelper;
import io.reactivex.rxjava3.operators.QueueSubscription;
import io.reactivex.rxjava3.operators.SimpleQueue;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowablePublishMulticast<T, R> extends AbstractFlowableWithUpstream<T, R> {

    /* renamed from: d  reason: collision with root package name */
    public final Function<? super Flowable<T>, ? extends Publisher<? extends R>> f20130d;

    /* renamed from: e  reason: collision with root package name */
    public final int f20131e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f20132f;

    public static final class MulticastProcessor<T> extends Flowable<T> implements FlowableSubscriber<T> {

        /* renamed from: n  reason: collision with root package name */
        public static final MulticastSubscription[] f20133n = new MulticastSubscription[0];

        /* renamed from: o  reason: collision with root package name */
        public static final MulticastSubscription[] f20134o = new MulticastSubscription[0];

        /* renamed from: c  reason: collision with root package name */
        public final AtomicInteger f20135c = new AtomicInteger();

        /* renamed from: d  reason: collision with root package name */
        public final AtomicReference<MulticastSubscription<T>[]> f20136d = new AtomicReference<>(f20133n);

        /* renamed from: e  reason: collision with root package name */
        public final int f20137e;

        /* renamed from: f  reason: collision with root package name */
        public final int f20138f;

        /* renamed from: g  reason: collision with root package name */
        public final boolean f20139g;

        /* renamed from: h  reason: collision with root package name */
        public final AtomicReference<Subscription> f20140h = new AtomicReference<>();

        /* renamed from: i  reason: collision with root package name */
        public volatile SimpleQueue<T> f20141i;

        /* renamed from: j  reason: collision with root package name */
        public int f20142j;

        /* renamed from: k  reason: collision with root package name */
        public volatile boolean f20143k;

        /* renamed from: l  reason: collision with root package name */
        public Throwable f20144l;

        /* renamed from: m  reason: collision with root package name */
        public int f20145m;

        public MulticastProcessor(int i11, boolean z11) {
            this.f20137e = i11;
            this.f20138f = i11 - (i11 >> 2);
            this.f20139g = z11;
        }

        public boolean b(MulticastSubscription<T> multicastSubscription) {
            MulticastSubscription[] multicastSubscriptionArr;
            MulticastSubscription[] multicastSubscriptionArr2;
            do {
                multicastSubscriptionArr = (MulticastSubscription[]) this.f20136d.get();
                if (multicastSubscriptionArr == f20134o) {
                    return false;
                }
                int length = multicastSubscriptionArr.length;
                multicastSubscriptionArr2 = new MulticastSubscription[(length + 1)];
                System.arraycopy(multicastSubscriptionArr, 0, multicastSubscriptionArr2, 0, length);
                multicastSubscriptionArr2[length] = multicastSubscription;
            } while (!b.a(this.f20136d, multicastSubscriptionArr, multicastSubscriptionArr2));
            return true;
        }

        public void c() {
            for (MulticastSubscription multicastSubscription : (MulticastSubscription[]) this.f20136d.getAndSet(f20134o)) {
                if (multicastSubscription.get() != Long.MIN_VALUE) {
                    multicastSubscription.f20146b.onComplete();
                }
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:125:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:126:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:74:0x00f8, code lost:
            if (r7 != 0) goto L_0x012a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:76:0x00fe, code lost:
            if (isDisposed() == false) goto L_0x0104;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:77:0x0100, code lost:
            r0.clear();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:78:0x0103, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:79:0x0104, code lost:
            r5 = r1.f20143k;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:80:0x0106, code lost:
            if (r5 == false) goto L_0x0114;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:82:0x010a, code lost:
            if (r1.f20139g != false) goto L_0x0114;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:83:0x010c, code lost:
            r6 = r1.f20144l;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:84:0x010e, code lost:
            if (r6 == null) goto L_0x0114;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:85:0x0110, code lost:
            e(r6);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:86:0x0113, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:87:0x0114, code lost:
            if (r5 == false) goto L_0x012a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:89:0x011a, code lost:
            if (r0.isEmpty() == false) goto L_0x012a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:90:0x011c, code lost:
            r0 = r1.f20144l;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:91:0x011e, code lost:
            if (r0 == null) goto L_0x0124;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:92:0x0120, code lost:
            e(r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:93:0x0124, code lost:
            c();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void d() {
            /*
                r24 = this;
                r1 = r24
                java.util.concurrent.atomic.AtomicInteger r0 = r1.f20135c
                int r0 = r0.getAndIncrement()
                if (r0 == 0) goto L_0x000b
                return
            L_0x000b:
                io.reactivex.rxjava3.operators.SimpleQueue<T> r0 = r1.f20141i
                int r2 = r1.f20145m
                int r3 = r1.f20138f
                int r4 = r1.f20142j
                r6 = 1
                if (r4 == r6) goto L_0x0018
                r4 = r6
                goto L_0x0019
            L_0x0018:
                r4 = 0
            L_0x0019:
                java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.internal.operators.flowable.FlowablePublishMulticast$MulticastSubscription<T>[]> r7 = r1.f20136d
                java.lang.Object r8 = r7.get()
                io.reactivex.rxjava3.internal.operators.flowable.FlowablePublishMulticast$MulticastSubscription[] r8 = (io.reactivex.rxjava3.internal.operators.flowable.FlowablePublishMulticast.MulticastSubscription[]) r8
                r9 = r6
            L_0x0022:
                int r10 = r8.length
                if (r0 == 0) goto L_0x0128
                if (r10 == 0) goto L_0x0128
                int r11 = r8.length
                r12 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                r15 = r12
                r14 = 0
            L_0x002f:
                r17 = -9223372036854775808
                if (r14 >= r11) goto L_0x0052
                r5 = r8[r14]
                long r19 = r5.get()
                r21 = r7
                long r6 = r5.f20148d
                long r19 = r19 - r6
                int r5 = (r19 > r17 ? 1 : (r19 == r17 ? 0 : -1))
                if (r5 == 0) goto L_0x004a
                int r5 = (r15 > r19 ? 1 : (r15 == r19 ? 0 : -1))
                if (r5 <= 0) goto L_0x004c
                r15 = r19
                goto L_0x004c
            L_0x004a:
                int r10 = r10 + -1
            L_0x004c:
                int r14 = r14 + 1
                r7 = r21
                r6 = 1
                goto L_0x002f
            L_0x0052:
                r21 = r7
                r5 = 0
                if (r10 != 0) goto L_0x0059
                r15 = r5
            L_0x0059:
                int r7 = (r15 > r5 ? 1 : (r15 == r5 ? 0 : -1))
                if (r7 == 0) goto L_0x00f8
                boolean r10 = r24.isDisposed()
                if (r10 == 0) goto L_0x0067
                r0.clear()
                return
            L_0x0067:
                boolean r10 = r1.f20143k
                if (r10 == 0) goto L_0x0077
                boolean r11 = r1.f20139g
                if (r11 != 0) goto L_0x0077
                java.lang.Throwable r11 = r1.f20144l
                if (r11 == 0) goto L_0x0077
                r1.e(r11)
                return
            L_0x0077:
                java.lang.Object r11 = r0.poll()     // Catch:{ all -> 0x00ea }
                if (r11 != 0) goto L_0x007f
                r14 = 1
                goto L_0x0080
            L_0x007f:
                r14 = 0
            L_0x0080:
                if (r10 == 0) goto L_0x0090
                if (r14 == 0) goto L_0x0090
                java.lang.Throwable r0 = r1.f20144l
                if (r0 == 0) goto L_0x008c
                r1.e(r0)
                goto L_0x008f
            L_0x008c:
                r24.c()
            L_0x008f:
                return
            L_0x0090:
                if (r14 == 0) goto L_0x0093
                goto L_0x00f8
            L_0x0093:
                int r7 = r8.length
                r10 = 0
                r14 = 0
            L_0x0096:
                r19 = 1
                if (r10 >= r7) goto L_0x00bf
                r5 = r8[r10]
                long r22 = r5.get()
                int r6 = (r22 > r17 ? 1 : (r22 == r17 ? 0 : -1))
                if (r6 == 0) goto L_0x00b4
                int r6 = (r22 > r12 ? 1 : (r22 == r12 ? 0 : -1))
                if (r6 == 0) goto L_0x00ae
                long r12 = r5.f20148d
                long r12 = r12 + r19
                r5.f20148d = r12
            L_0x00ae:
                org.reactivestreams.Subscriber<? super T> r5 = r5.f20146b
                r5.onNext(r11)
                goto L_0x00b5
            L_0x00b4:
                r14 = 1
            L_0x00b5:
                int r10 = r10 + 1
                r5 = 0
                r12 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                goto L_0x0096
            L_0x00bf:
                long r15 = r15 - r19
                if (r4 == 0) goto L_0x00d4
                int r2 = r2 + 1
                if (r2 != r3) goto L_0x00d4
                java.util.concurrent.atomic.AtomicReference<org.reactivestreams.Subscription> r2 = r1.f20140h
                java.lang.Object r2 = r2.get()
                org.reactivestreams.Subscription r2 = (org.reactivestreams.Subscription) r2
                long r5 = (long) r3
                r2.request(r5)
                r2 = 0
            L_0x00d4:
                java.lang.Object r5 = r21.get()
                io.reactivex.rxjava3.internal.operators.flowable.FlowablePublishMulticast$MulticastSubscription[] r5 = (io.reactivex.rxjava3.internal.operators.flowable.FlowablePublishMulticast.MulticastSubscription[]) r5
                if (r14 != 0) goto L_0x00e8
                if (r5 == r8) goto L_0x00df
                goto L_0x00e8
            L_0x00df:
                r5 = 0
                r12 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                goto L_0x0059
            L_0x00e8:
                r8 = r5
                goto L_0x0141
            L_0x00ea:
                r0 = move-exception
                r2 = r0
                io.reactivex.rxjava3.exceptions.Exceptions.throwIfFatal(r2)
                java.util.concurrent.atomic.AtomicReference<org.reactivestreams.Subscription> r0 = r1.f20140h
                io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper.cancel(r0)
                r1.e(r2)
                return
            L_0x00f8:
                if (r7 != 0) goto L_0x012a
                boolean r5 = r24.isDisposed()
                if (r5 == 0) goto L_0x0104
                r0.clear()
                return
            L_0x0104:
                boolean r5 = r1.f20143k
                if (r5 == 0) goto L_0x0114
                boolean r6 = r1.f20139g
                if (r6 != 0) goto L_0x0114
                java.lang.Throwable r6 = r1.f20144l
                if (r6 == 0) goto L_0x0114
                r1.e(r6)
                return
            L_0x0114:
                if (r5 == 0) goto L_0x012a
                boolean r5 = r0.isEmpty()
                if (r5 == 0) goto L_0x012a
                java.lang.Throwable r0 = r1.f20144l
                if (r0 == 0) goto L_0x0124
                r1.e(r0)
                goto L_0x0127
            L_0x0124:
                r24.c()
            L_0x0127:
                return
            L_0x0128:
                r21 = r7
            L_0x012a:
                r1.f20145m = r2
                java.util.concurrent.atomic.AtomicInteger r5 = r1.f20135c
                int r6 = -r9
                int r9 = r5.addAndGet(r6)
                if (r9 != 0) goto L_0x0136
                return
            L_0x0136:
                if (r0 != 0) goto L_0x013a
                io.reactivex.rxjava3.operators.SimpleQueue<T> r0 = r1.f20141i
            L_0x013a:
                java.lang.Object r5 = r21.get()
                r8 = r5
                io.reactivex.rxjava3.internal.operators.flowable.FlowablePublishMulticast$MulticastSubscription[] r8 = (io.reactivex.rxjava3.internal.operators.flowable.FlowablePublishMulticast.MulticastSubscription[]) r8
            L_0x0141:
                r7 = r21
                r6 = 1
                goto L_0x0022
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.flowable.FlowablePublishMulticast.MulticastProcessor.d():void");
        }

        public void dispose() {
            SimpleQueue<T> simpleQueue;
            if (!this.f20143k) {
                SubscriptionHelper.cancel(this.f20140h);
                if (this.f20135c.getAndIncrement() == 0 && (simpleQueue = this.f20141i) != null) {
                    simpleQueue.clear();
                }
            }
        }

        public void e(Throwable th2) {
            for (MulticastSubscription multicastSubscription : (MulticastSubscription[]) this.f20136d.getAndSet(f20134o)) {
                if (multicastSubscription.get() != Long.MIN_VALUE) {
                    multicastSubscription.f20146b.onError(th2);
                }
            }
        }

        public void f(MulticastSubscription<T> multicastSubscription) {
            MulticastSubscription<T>[] multicastSubscriptionArr;
            MulticastSubscription[] multicastSubscriptionArr2;
            do {
                multicastSubscriptionArr = (MulticastSubscription[]) this.f20136d.get();
                int length = multicastSubscriptionArr.length;
                if (length != 0) {
                    int i11 = 0;
                    while (true) {
                        if (i11 >= length) {
                            i11 = -1;
                            break;
                        } else if (multicastSubscriptionArr[i11] == multicastSubscription) {
                            break;
                        } else {
                            i11++;
                        }
                    }
                    if (i11 >= 0) {
                        if (length == 1) {
                            multicastSubscriptionArr2 = f20133n;
                        } else {
                            MulticastSubscription[] multicastSubscriptionArr3 = new MulticastSubscription[(length - 1)];
                            System.arraycopy(multicastSubscriptionArr, 0, multicastSubscriptionArr3, 0, i11);
                            System.arraycopy(multicastSubscriptionArr, i11 + 1, multicastSubscriptionArr3, i11, (length - i11) - 1);
                            multicastSubscriptionArr2 = multicastSubscriptionArr3;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            } while (!b.a(this.f20136d, multicastSubscriptionArr, multicastSubscriptionArr2));
        }

        public boolean isDisposed() {
            return this.f20140h.get() == SubscriptionHelper.CANCELLED;
        }

        public void onComplete() {
            if (!this.f20143k) {
                this.f20143k = true;
                d();
            }
        }

        public void onError(Throwable th2) {
            if (this.f20143k) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f20144l = th2;
            this.f20143k = true;
            d();
        }

        public void onNext(T t11) {
            if (!this.f20143k) {
                if (this.f20142j != 0 || this.f20141i.offer(t11)) {
                    d();
                    return;
                }
                this.f20140h.get().cancel();
                onError(new MissingBackpressureException());
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.setOnce(this.f20140h, subscription)) {
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int requestFusion = queueSubscription.requestFusion(3);
                    if (requestFusion == 1) {
                        this.f20142j = requestFusion;
                        this.f20141i = queueSubscription;
                        this.f20143k = true;
                        d();
                        return;
                    } else if (requestFusion == 2) {
                        this.f20142j = requestFusion;
                        this.f20141i = queueSubscription;
                        QueueDrainHelper.request(subscription, this.f20137e);
                        return;
                    }
                }
                this.f20141i = QueueDrainHelper.createQueue(this.f20137e);
                QueueDrainHelper.request(subscription, this.f20137e);
            }
        }

        public void subscribeActual(Subscriber<? super T> subscriber) {
            MulticastSubscription multicastSubscription = new MulticastSubscription(subscriber, this);
            subscriber.onSubscribe(multicastSubscription);
            if (!b(multicastSubscription)) {
                Throwable th2 = this.f20144l;
                if (th2 != null) {
                    subscriber.onError(th2);
                } else {
                    subscriber.onComplete();
                }
            } else if (multicastSubscription.isCancelled()) {
                f(multicastSubscription);
            } else {
                d();
            }
        }
    }

    public static final class MulticastSubscription<T> extends AtomicLong implements Subscription {
        private static final long serialVersionUID = 8664815189257569791L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super T> f20146b;

        /* renamed from: c  reason: collision with root package name */
        public final MulticastProcessor<T> f20147c;

        /* renamed from: d  reason: collision with root package name */
        public long f20148d;

        public MulticastSubscription(Subscriber<? super T> subscriber, MulticastProcessor<T> multicastProcessor) {
            this.f20146b = subscriber;
            this.f20147c = multicastProcessor;
        }

        public void cancel() {
            if (getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.f20147c.f(this);
                this.f20147c.d();
            }
        }

        public boolean isCancelled() {
            return get() == Long.MIN_VALUE;
        }

        public void request(long j11) {
            if (SubscriptionHelper.validate(j11)) {
                BackpressureHelper.addCancel(this, j11);
                this.f20147c.d();
            }
        }
    }

    public static final class OutputCanceller<R> implements FlowableSubscriber<R>, Subscription {

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super R> f20149b;

        /* renamed from: c  reason: collision with root package name */
        public final MulticastProcessor<?> f20150c;

        /* renamed from: d  reason: collision with root package name */
        public Subscription f20151d;

        public OutputCanceller(Subscriber<? super R> subscriber, MulticastProcessor<?> multicastProcessor) {
            this.f20149b = subscriber;
            this.f20150c = multicastProcessor;
        }

        public void cancel() {
            this.f20151d.cancel();
            this.f20150c.dispose();
        }

        public void onComplete() {
            this.f20149b.onComplete();
            this.f20150c.dispose();
        }

        public void onError(Throwable th2) {
            this.f20149b.onError(th2);
            this.f20150c.dispose();
        }

        public void onNext(R r11) {
            this.f20149b.onNext(r11);
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f20151d, subscription)) {
                this.f20151d = subscription;
                this.f20149b.onSubscribe(this);
            }
        }

        public void request(long j11) {
            this.f20151d.request(j11);
        }
    }

    public FlowablePublishMulticast(Flowable<T> flowable, Function<? super Flowable<T>, ? extends Publisher<? extends R>> function, int i11, boolean z11) {
        super(flowable);
        this.f20130d = function;
        this.f20131e = i11;
        this.f20132f = z11;
    }

    public void subscribeActual(Subscriber<? super R> subscriber) {
        MulticastProcessor multicastProcessor = new MulticastProcessor(this.f20131e, this.f20132f);
        try {
            Object apply = this.f20130d.apply(multicastProcessor);
            Objects.requireNonNull(apply, "selector returned a null Publisher");
            ((Publisher) apply).subscribe(new OutputCanceller(subscriber, multicastProcessor));
            this.f19260c.subscribe(multicastProcessor);
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            EmptySubscription.error(th2, subscriber);
        }
    }
}
