package io.reactivex.internal.operators.flowable;

import i.b;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.QueueDrainHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowablePublishMulticast<T, R> extends AbstractFlowableWithUpstream<T, R> {

    /* renamed from: d  reason: collision with root package name */
    public final Function<? super Flowable<T>, ? extends Publisher<? extends R>> f15623d;

    /* renamed from: e  reason: collision with root package name */
    public final int f15624e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f15625f;

    public static final class MulticastProcessor<T> extends Flowable<T> implements FlowableSubscriber<T>, Disposable {

        /* renamed from: n  reason: collision with root package name */
        public static final MulticastSubscription[] f15626n = new MulticastSubscription[0];

        /* renamed from: o  reason: collision with root package name */
        public static final MulticastSubscription[] f15627o = new MulticastSubscription[0];

        /* renamed from: c  reason: collision with root package name */
        public final AtomicInteger f15628c = new AtomicInteger();

        /* renamed from: d  reason: collision with root package name */
        public final AtomicReference<MulticastSubscription<T>[]> f15629d = new AtomicReference<>(f15626n);

        /* renamed from: e  reason: collision with root package name */
        public final int f15630e;

        /* renamed from: f  reason: collision with root package name */
        public final int f15631f;

        /* renamed from: g  reason: collision with root package name */
        public final boolean f15632g;

        /* renamed from: h  reason: collision with root package name */
        public final AtomicReference<Subscription> f15633h = new AtomicReference<>();

        /* renamed from: i  reason: collision with root package name */
        public volatile SimpleQueue<T> f15634i;

        /* renamed from: j  reason: collision with root package name */
        public int f15635j;

        /* renamed from: k  reason: collision with root package name */
        public volatile boolean f15636k;

        /* renamed from: l  reason: collision with root package name */
        public Throwable f15637l;

        /* renamed from: m  reason: collision with root package name */
        public int f15638m;

        public MulticastProcessor(int i11, boolean z11) {
            this.f15630e = i11;
            this.f15631f = i11 - (i11 >> 2);
            this.f15632g = z11;
        }

        public boolean b(MulticastSubscription<T> multicastSubscription) {
            MulticastSubscription[] multicastSubscriptionArr;
            MulticastSubscription[] multicastSubscriptionArr2;
            do {
                multicastSubscriptionArr = (MulticastSubscription[]) this.f15629d.get();
                if (multicastSubscriptionArr == f15627o) {
                    return false;
                }
                int length = multicastSubscriptionArr.length;
                multicastSubscriptionArr2 = new MulticastSubscription[(length + 1)];
                System.arraycopy(multicastSubscriptionArr, 0, multicastSubscriptionArr2, 0, length);
                multicastSubscriptionArr2[length] = multicastSubscription;
            } while (!b.a(this.f15629d, multicastSubscriptionArr, multicastSubscriptionArr2));
            return true;
        }

        public void c() {
            for (MulticastSubscription multicastSubscription : (MulticastSubscription[]) this.f15629d.getAndSet(f15627o)) {
                if (multicastSubscription.get() != Long.MIN_VALUE) {
                    multicastSubscription.f15639b.onComplete();
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
            r5 = r1.f15636k;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:80:0x0106, code lost:
            if (r5 == false) goto L_0x0114;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:82:0x010a, code lost:
            if (r1.f15632g != false) goto L_0x0114;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:83:0x010c, code lost:
            r6 = r1.f15637l;
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
            r0 = r1.f15637l;
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
                java.util.concurrent.atomic.AtomicInteger r0 = r1.f15628c
                int r0 = r0.getAndIncrement()
                if (r0 == 0) goto L_0x000b
                return
            L_0x000b:
                io.reactivex.internal.fuseable.SimpleQueue<T> r0 = r1.f15634i
                int r2 = r1.f15638m
                int r3 = r1.f15631f
                int r4 = r1.f15635j
                r6 = 1
                if (r4 == r6) goto L_0x0018
                r4 = r6
                goto L_0x0019
            L_0x0018:
                r4 = 0
            L_0x0019:
                java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.flowable.FlowablePublishMulticast$MulticastSubscription<T>[]> r7 = r1.f15629d
                java.lang.Object r8 = r7.get()
                io.reactivex.internal.operators.flowable.FlowablePublishMulticast$MulticastSubscription[] r8 = (io.reactivex.internal.operators.flowable.FlowablePublishMulticast.MulticastSubscription[]) r8
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
                long r6 = r5.f15641d
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
                boolean r10 = r1.f15636k
                if (r10 == 0) goto L_0x0077
                boolean r11 = r1.f15632g
                if (r11 != 0) goto L_0x0077
                java.lang.Throwable r11 = r1.f15637l
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
                java.lang.Throwable r0 = r1.f15637l
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
                long r12 = r5.f15641d
                long r12 = r12 + r19
                r5.f15641d = r12
            L_0x00ae:
                org.reactivestreams.Subscriber<? super T> r5 = r5.f15639b
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
                java.util.concurrent.atomic.AtomicReference<org.reactivestreams.Subscription> r2 = r1.f15633h
                java.lang.Object r2 = r2.get()
                org.reactivestreams.Subscription r2 = (org.reactivestreams.Subscription) r2
                long r5 = (long) r3
                r2.request(r5)
                r2 = 0
            L_0x00d4:
                java.lang.Object r5 = r21.get()
                io.reactivex.internal.operators.flowable.FlowablePublishMulticast$MulticastSubscription[] r5 = (io.reactivex.internal.operators.flowable.FlowablePublishMulticast.MulticastSubscription[]) r5
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
                io.reactivex.exceptions.Exceptions.throwIfFatal(r2)
                java.util.concurrent.atomic.AtomicReference<org.reactivestreams.Subscription> r0 = r1.f15633h
                io.reactivex.internal.subscriptions.SubscriptionHelper.cancel(r0)
                r1.e(r2)
                return
            L_0x00f8:
                if (r7 != 0) goto L_0x012a
                boolean r5 = r24.isDisposed()
                if (r5 == 0) goto L_0x0104
                r0.clear()
                return
            L_0x0104:
                boolean r5 = r1.f15636k
                if (r5 == 0) goto L_0x0114
                boolean r6 = r1.f15632g
                if (r6 != 0) goto L_0x0114
                java.lang.Throwable r6 = r1.f15637l
                if (r6 == 0) goto L_0x0114
                r1.e(r6)
                return
            L_0x0114:
                if (r5 == 0) goto L_0x012a
                boolean r5 = r0.isEmpty()
                if (r5 == 0) goto L_0x012a
                java.lang.Throwable r0 = r1.f15637l
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
                r1.f15638m = r2
                java.util.concurrent.atomic.AtomicInteger r5 = r1.f15628c
                int r6 = -r9
                int r9 = r5.addAndGet(r6)
                if (r9 != 0) goto L_0x0136
                return
            L_0x0136:
                if (r0 != 0) goto L_0x013a
                io.reactivex.internal.fuseable.SimpleQueue<T> r0 = r1.f15634i
            L_0x013a:
                java.lang.Object r5 = r21.get()
                r8 = r5
                io.reactivex.internal.operators.flowable.FlowablePublishMulticast$MulticastSubscription[] r8 = (io.reactivex.internal.operators.flowable.FlowablePublishMulticast.MulticastSubscription[]) r8
            L_0x0141:
                r7 = r21
                r6 = 1
                goto L_0x0022
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowablePublishMulticast.MulticastProcessor.d():void");
        }

        public void dispose() {
            SimpleQueue<T> simpleQueue;
            SubscriptionHelper.cancel(this.f15633h);
            if (this.f15628c.getAndIncrement() == 0 && (simpleQueue = this.f15634i) != null) {
                simpleQueue.clear();
            }
        }

        public void e(Throwable th2) {
            for (MulticastSubscription multicastSubscription : (MulticastSubscription[]) this.f15629d.getAndSet(f15627o)) {
                if (multicastSubscription.get() != Long.MIN_VALUE) {
                    multicastSubscription.f15639b.onError(th2);
                }
            }
        }

        public void f(MulticastSubscription<T> multicastSubscription) {
            MulticastSubscription<T>[] multicastSubscriptionArr;
            MulticastSubscription[] multicastSubscriptionArr2;
            do {
                multicastSubscriptionArr = (MulticastSubscription[]) this.f15629d.get();
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
                            multicastSubscriptionArr2 = f15626n;
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
            } while (!b.a(this.f15629d, multicastSubscriptionArr, multicastSubscriptionArr2));
        }

        public boolean isDisposed() {
            return this.f15633h.get() == SubscriptionHelper.CANCELLED;
        }

        public void onComplete() {
            if (!this.f15636k) {
                this.f15636k = true;
                d();
            }
        }

        public void onError(Throwable th2) {
            if (this.f15636k) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f15637l = th2;
            this.f15636k = true;
            d();
        }

        public void onNext(T t11) {
            if (!this.f15636k) {
                if (this.f15635j != 0 || this.f15634i.offer(t11)) {
                    d();
                    return;
                }
                this.f15633h.get().cancel();
                onError(new MissingBackpressureException());
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.setOnce(this.f15633h, subscription)) {
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int requestFusion = queueSubscription.requestFusion(3);
                    if (requestFusion == 1) {
                        this.f15635j = requestFusion;
                        this.f15634i = queueSubscription;
                        this.f15636k = true;
                        d();
                        return;
                    } else if (requestFusion == 2) {
                        this.f15635j = requestFusion;
                        this.f15634i = queueSubscription;
                        QueueDrainHelper.request(subscription, this.f15630e);
                        return;
                    }
                }
                this.f15634i = QueueDrainHelper.createQueue(this.f15630e);
                QueueDrainHelper.request(subscription, this.f15630e);
            }
        }

        public void subscribeActual(Subscriber<? super T> subscriber) {
            MulticastSubscription multicastSubscription = new MulticastSubscription(subscriber, this);
            subscriber.onSubscribe(multicastSubscription);
            if (!b(multicastSubscription)) {
                Throwable th2 = this.f15637l;
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
        public final Subscriber<? super T> f15639b;

        /* renamed from: c  reason: collision with root package name */
        public final MulticastProcessor<T> f15640c;

        /* renamed from: d  reason: collision with root package name */
        public long f15641d;

        public MulticastSubscription(Subscriber<? super T> subscriber, MulticastProcessor<T> multicastProcessor) {
            this.f15639b = subscriber;
            this.f15640c = multicastProcessor;
        }

        public void cancel() {
            if (getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.f15640c.f(this);
                this.f15640c.d();
            }
        }

        public boolean isCancelled() {
            return get() == Long.MIN_VALUE;
        }

        public void request(long j11) {
            if (SubscriptionHelper.validate(j11)) {
                BackpressureHelper.addCancel(this, j11);
                this.f15640c.d();
            }
        }
    }

    public static final class OutputCanceller<R> implements FlowableSubscriber<R>, Subscription {

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super R> f15642b;

        /* renamed from: c  reason: collision with root package name */
        public final MulticastProcessor<?> f15643c;

        /* renamed from: d  reason: collision with root package name */
        public Subscription f15644d;

        public OutputCanceller(Subscriber<? super R> subscriber, MulticastProcessor<?> multicastProcessor) {
            this.f15642b = subscriber;
            this.f15643c = multicastProcessor;
        }

        public void cancel() {
            this.f15644d.cancel();
            this.f15643c.dispose();
        }

        public void onComplete() {
            this.f15642b.onComplete();
            this.f15643c.dispose();
        }

        public void onError(Throwable th2) {
            this.f15642b.onError(th2);
            this.f15643c.dispose();
        }

        public void onNext(R r11) {
            this.f15642b.onNext(r11);
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f15644d, subscription)) {
                this.f15644d = subscription;
                this.f15642b.onSubscribe(this);
            }
        }

        public void request(long j11) {
            this.f15644d.request(j11);
        }
    }

    public FlowablePublishMulticast(Flowable<T> flowable, Function<? super Flowable<T>, ? extends Publisher<? extends R>> function, int i11, boolean z11) {
        super(flowable);
        this.f15623d = function;
        this.f15624e = i11;
        this.f15625f = z11;
    }

    public void subscribeActual(Subscriber<? super R> subscriber) {
        MulticastProcessor multicastProcessor = new MulticastProcessor(this.f15624e, this.f15625f);
        try {
            ((Publisher) ObjectHelper.requireNonNull(this.f15623d.apply(multicastProcessor), "selector returned a null Publisher")).subscribe(new OutputCanceller(subscriber, multicastProcessor));
            this.f14763c.subscribe(multicastProcessor);
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            EmptySubscription.error(th2, subscriber);
        }
    }
}
