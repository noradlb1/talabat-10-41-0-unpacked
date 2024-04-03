package io.reactivex.internal.operators.flowable;

import i.b;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.flowables.ConnectableFlowable;
import io.reactivex.internal.fuseable.HasUpstreamPublisher;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowablePublish<T> extends ConnectableFlowable<T> implements HasUpstreamPublisher<T>, FlowablePublishClassic<T> {

    /* renamed from: c  reason: collision with root package name */
    public final Flowable<T> f15588c;

    /* renamed from: d  reason: collision with root package name */
    public final AtomicReference<PublishSubscriber<T>> f15589d;

    /* renamed from: e  reason: collision with root package name */
    public final int f15590e;

    /* renamed from: f  reason: collision with root package name */
    public final Publisher<T> f15591f;

    public static final class FlowablePublisher<T> implements Publisher<T> {
        private final int bufferSize;
        private final AtomicReference<PublishSubscriber<T>> curr;

        public FlowablePublisher(AtomicReference<PublishSubscriber<T>> atomicReference, int i11) {
            this.curr = atomicReference;
            this.bufferSize = i11;
        }

        public void subscribe(Subscriber<? super T> subscriber) {
            PublishSubscriber<T> publishSubscriber;
            InnerSubscriber innerSubscriber = new InnerSubscriber(subscriber);
            subscriber.onSubscribe(innerSubscriber);
            while (true) {
                publishSubscriber = this.curr.get();
                if (publishSubscriber == null || publishSubscriber.isDisposed()) {
                    PublishSubscriber<T> publishSubscriber2 = new PublishSubscriber<>(this.curr, this.bufferSize);
                    if (!b.a(this.curr, publishSubscriber, publishSubscriber2)) {
                        continue;
                    } else {
                        publishSubscriber = publishSubscriber2;
                    }
                }
                if (publishSubscriber.a(innerSubscriber)) {
                    break;
                }
            }
            if (innerSubscriber.get() == Long.MIN_VALUE) {
                publishSubscriber.d(innerSubscriber);
            } else {
                innerSubscriber.f15593c = publishSubscriber;
            }
            publishSubscriber.c();
        }
    }

    public static final class InnerSubscriber<T> extends AtomicLong implements Subscription {
        private static final long serialVersionUID = -4453897557930727610L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super T> f15592b;

        /* renamed from: c  reason: collision with root package name */
        public volatile PublishSubscriber<T> f15593c;

        /* renamed from: d  reason: collision with root package name */
        public long f15594d;

        public InnerSubscriber(Subscriber<? super T> subscriber) {
            this.f15592b = subscriber;
        }

        public void cancel() {
            PublishSubscriber<T> publishSubscriber;
            if (get() != Long.MIN_VALUE && getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE && (publishSubscriber = this.f15593c) != null) {
                publishSubscriber.d(this);
                publishSubscriber.c();
            }
        }

        public void request(long j11) {
            if (SubscriptionHelper.validate(j11)) {
                BackpressureHelper.addCancel(this, j11);
                PublishSubscriber<T> publishSubscriber = this.f15593c;
                if (publishSubscriber != null) {
                    publishSubscriber.c();
                }
            }
        }
    }

    public static final class PublishSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Disposable {

        /* renamed from: j  reason: collision with root package name */
        public static final InnerSubscriber[] f15595j = new InnerSubscriber[0];

        /* renamed from: k  reason: collision with root package name */
        public static final InnerSubscriber[] f15596k = new InnerSubscriber[0];
        private static final long serialVersionUID = -202316842419149694L;

        /* renamed from: b  reason: collision with root package name */
        public final AtomicReference<PublishSubscriber<T>> f15597b;

        /* renamed from: c  reason: collision with root package name */
        public final int f15598c;

        /* renamed from: d  reason: collision with root package name */
        public final AtomicReference<InnerSubscriber<T>[]> f15599d = new AtomicReference<>(f15595j);

        /* renamed from: e  reason: collision with root package name */
        public final AtomicBoolean f15600e;

        /* renamed from: f  reason: collision with root package name */
        public final AtomicReference<Subscription> f15601f = new AtomicReference<>();

        /* renamed from: g  reason: collision with root package name */
        public volatile Object f15602g;

        /* renamed from: h  reason: collision with root package name */
        public int f15603h;

        /* renamed from: i  reason: collision with root package name */
        public volatile SimpleQueue<T> f15604i;

        public PublishSubscriber(AtomicReference<PublishSubscriber<T>> atomicReference, int i11) {
            this.f15597b = atomicReference;
            this.f15600e = new AtomicBoolean();
            this.f15598c = i11;
        }

        public boolean a(InnerSubscriber<T> innerSubscriber) {
            InnerSubscriber[] innerSubscriberArr;
            InnerSubscriber[] innerSubscriberArr2;
            do {
                innerSubscriberArr = (InnerSubscriber[]) this.f15599d.get();
                if (innerSubscriberArr == f15596k) {
                    return false;
                }
                int length = innerSubscriberArr.length;
                innerSubscriberArr2 = new InnerSubscriber[(length + 1)];
                System.arraycopy(innerSubscriberArr, 0, innerSubscriberArr2, 0, length);
                innerSubscriberArr2[length] = innerSubscriber;
            } while (!b.a(this.f15599d, innerSubscriberArr, innerSubscriberArr2));
            return true;
        }

        public boolean b(Object obj, boolean z11) {
            int i11 = 0;
            if (obj != null) {
                if (!NotificationLite.isComplete(obj)) {
                    Throwable error = NotificationLite.getError(obj);
                    b.a(this.f15597b, this, (Object) null);
                    InnerSubscriber[] innerSubscriberArr = (InnerSubscriber[]) this.f15599d.getAndSet(f15596k);
                    if (innerSubscriberArr.length != 0) {
                        int length = innerSubscriberArr.length;
                        while (i11 < length) {
                            innerSubscriberArr[i11].f15592b.onError(error);
                            i11++;
                        }
                    } else {
                        RxJavaPlugins.onError(error);
                    }
                    return true;
                } else if (z11) {
                    b.a(this.f15597b, this, (Object) null);
                    InnerSubscriber[] innerSubscriberArr2 = (InnerSubscriber[]) this.f15599d.getAndSet(f15596k);
                    int length2 = innerSubscriberArr2.length;
                    while (i11 < length2) {
                        innerSubscriberArr2[i11].f15592b.onComplete();
                        i11++;
                    }
                    return true;
                }
            }
            return false;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:74:0x013b, code lost:
            if (r11 == 0) goto L_0x014e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:75:0x013d, code lost:
            r3 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:76:0x0140, code lost:
            if (r1.f15603h == 1) goto L_0x014f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:77:0x0142, code lost:
            r1.f15601f.get().request(r12);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:78:0x014e, code lost:
            r3 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:80:0x0153, code lost:
            if (r14 == 0) goto L_0x0159;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:81:0x0155, code lost:
            if (r8 != false) goto L_0x0159;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:94:0x0014, code lost:
            continue;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void c() {
            /*
                r25 = this;
                r1 = r25
                int r0 = r25.getAndIncrement()
                if (r0 == 0) goto L_0x0009
                return
            L_0x0009:
                java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.flowable.FlowablePublish$InnerSubscriber<T>[]> r2 = r1.f15599d
                java.lang.Object r0 = r2.get()
                io.reactivex.internal.operators.flowable.FlowablePublish$InnerSubscriber[] r0 = (io.reactivex.internal.operators.flowable.FlowablePublish.InnerSubscriber[]) r0
                r3 = 1
                r4 = r0
                r5 = r3
            L_0x0014:
                java.lang.Object r0 = r1.f15602g
                io.reactivex.internal.fuseable.SimpleQueue<T> r6 = r1.f15604i
                if (r6 == 0) goto L_0x0023
                boolean r8 = r6.isEmpty()
                if (r8 == 0) goto L_0x0021
                goto L_0x0023
            L_0x0021:
                r8 = 0
                goto L_0x0024
            L_0x0023:
                r8 = r3
            L_0x0024:
                boolean r0 = r1.b(r0, r8)
                if (r0 == 0) goto L_0x002b
                return
            L_0x002b:
                if (r8 != 0) goto L_0x0159
                int r0 = r4.length
                int r9 = r4.length
                r12 = 0
                r13 = 0
                r14 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            L_0x0036:
                r16 = -9223372036854775808
                if (r12 >= r9) goto L_0x0052
                r7 = r4[r12]
                long r18 = r7.get()
                int r16 = (r18 > r16 ? 1 : (r18 == r16 ? 0 : -1))
                if (r16 == 0) goto L_0x004d
                long r10 = r7.f15594d
                long r10 = r18 - r10
                long r14 = java.lang.Math.min(r14, r10)
                goto L_0x004f
            L_0x004d:
                int r13 = r13 + 1
            L_0x004f:
                int r12 = r12 + 1
                goto L_0x0036
            L_0x0052:
                r9 = 1
                if (r0 != r13) goto L_0x0090
                java.lang.Object r0 = r1.f15602g
                java.lang.Object r7 = r6.poll()     // Catch:{ all -> 0x005d }
                goto L_0x0074
            L_0x005d:
                r0 = move-exception
                r6 = r0
                io.reactivex.exceptions.Exceptions.throwIfFatal(r6)
                java.util.concurrent.atomic.AtomicReference<org.reactivestreams.Subscription> r0 = r1.f15601f
                java.lang.Object r0 = r0.get()
                org.reactivestreams.Subscription r0 = (org.reactivestreams.Subscription) r0
                r0.cancel()
                java.lang.Object r0 = io.reactivex.internal.util.NotificationLite.error(r6)
                r1.f15602g = r0
                r7 = 0
            L_0x0074:
                if (r7 != 0) goto L_0x0078
                r7 = r3
                goto L_0x0079
            L_0x0078:
                r7 = 0
            L_0x0079:
                boolean r0 = r1.b(r0, r7)
                if (r0 == 0) goto L_0x0080
                return
            L_0x0080:
                int r0 = r1.f15603h
                if (r0 == r3) goto L_0x0014
                java.util.concurrent.atomic.AtomicReference<org.reactivestreams.Subscription> r0 = r1.f15601f
                java.lang.Object r0 = r0.get()
                org.reactivestreams.Subscription r0 = (org.reactivestreams.Subscription) r0
                r0.request(r9)
                goto L_0x0014
            L_0x0090:
                r11 = 0
            L_0x0091:
                long r12 = (long) r11
                int r0 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
                if (r0 >= 0) goto L_0x013b
                java.lang.Object r0 = r1.f15602g
                java.lang.Object r8 = r6.poll()     // Catch:{ all -> 0x009d }
                goto L_0x00b4
            L_0x009d:
                r0 = move-exception
                r8 = r0
                io.reactivex.exceptions.Exceptions.throwIfFatal(r8)
                java.util.concurrent.atomic.AtomicReference<org.reactivestreams.Subscription> r0 = r1.f15601f
                java.lang.Object r0 = r0.get()
                org.reactivestreams.Subscription r0 = (org.reactivestreams.Subscription) r0
                r0.cancel()
                java.lang.Object r0 = io.reactivex.internal.util.NotificationLite.error(r8)
                r1.f15602g = r0
                r8 = 0
            L_0x00b4:
                if (r8 != 0) goto L_0x00b8
                r7 = r3
                goto L_0x00b9
            L_0x00b8:
                r7 = 0
            L_0x00b9:
                boolean r0 = r1.b(r0, r7)
                if (r0 == 0) goto L_0x00c0
                return
            L_0x00c0:
                if (r7 == 0) goto L_0x00c5
                r8 = r7
                goto L_0x013b
            L_0x00c5:
                java.lang.Object r0 = io.reactivex.internal.util.NotificationLite.getValue(r8)
                int r8 = r4.length
                r12 = 0
                r13 = 0
            L_0x00cc:
                if (r12 >= r8) goto L_0x0107
                r3 = r4[r12]
                long r22 = r3.get()
                int r24 = (r22 > r16 ? 1 : (r22 == r16 ? 0 : -1))
                if (r24 == 0) goto L_0x00f5
                r20 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                int r22 = (r22 > r20 ? 1 : (r22 == r20 ? 0 : -1))
                if (r22 == 0) goto L_0x00eb
                r22 = r6
                r23 = r7
                long r6 = r3.f15594d
                long r6 = r6 + r9
                r3.f15594d = r6
                goto L_0x00ef
            L_0x00eb:
                r22 = r6
                r23 = r7
            L_0x00ef:
                org.reactivestreams.Subscriber<? super T> r3 = r3.f15592b
                r3.onNext(r0)
                goto L_0x00ff
            L_0x00f5:
                r22 = r6
                r23 = r7
                r20 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                r13 = 1
            L_0x00ff:
                int r12 = r12 + 1
                r6 = r22
                r7 = r23
                r3 = 1
                goto L_0x00cc
            L_0x0107:
                r22 = r6
                r23 = r7
                r20 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                int r11 = r11 + 1
                java.lang.Object r0 = r2.get()
                io.reactivex.internal.operators.flowable.FlowablePublish$InnerSubscriber[] r0 = (io.reactivex.internal.operators.flowable.FlowablePublish.InnerSubscriber[]) r0
                if (r13 != 0) goto L_0x0124
                if (r0 == r4) goto L_0x011d
                goto L_0x0124
            L_0x011d:
                r6 = r22
                r8 = r23
                r3 = 1
                goto L_0x0091
            L_0x0124:
                if (r11 == 0) goto L_0x0137
                int r3 = r1.f15603h
                r4 = 1
                if (r3 == r4) goto L_0x0137
                java.util.concurrent.atomic.AtomicReference<org.reactivestreams.Subscription> r3 = r1.f15601f
                java.lang.Object r3 = r3.get()
                org.reactivestreams.Subscription r3 = (org.reactivestreams.Subscription) r3
                long r6 = (long) r11
                r3.request(r6)
            L_0x0137:
                r4 = r0
                r3 = 1
                goto L_0x0014
            L_0x013b:
                if (r11 == 0) goto L_0x014e
                int r0 = r1.f15603h
                r3 = 1
                if (r0 == r3) goto L_0x014f
                java.util.concurrent.atomic.AtomicReference<org.reactivestreams.Subscription> r0 = r1.f15601f
                java.lang.Object r0 = r0.get()
                org.reactivestreams.Subscription r0 = (org.reactivestreams.Subscription) r0
                r0.request(r12)
                goto L_0x014f
            L_0x014e:
                r3 = 1
            L_0x014f:
                r6 = 0
                int r0 = (r14 > r6 ? 1 : (r14 == r6 ? 0 : -1))
                if (r0 == 0) goto L_0x0159
                if (r8 != 0) goto L_0x0159
                goto L_0x0014
            L_0x0159:
                int r0 = -r5
                int r5 = r1.addAndGet(r0)
                if (r5 != 0) goto L_0x0161
                return
            L_0x0161:
                java.lang.Object r0 = r2.get()
                r4 = r0
                io.reactivex.internal.operators.flowable.FlowablePublish$InnerSubscriber[] r4 = (io.reactivex.internal.operators.flowable.FlowablePublish.InnerSubscriber[]) r4
                goto L_0x0014
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowablePublish.PublishSubscriber.c():void");
        }

        public void d(InnerSubscriber<T> innerSubscriber) {
            InnerSubscriber[] innerSubscriberArr;
            InnerSubscriber[] innerSubscriberArr2;
            do {
                innerSubscriberArr = (InnerSubscriber[]) this.f15599d.get();
                int length = innerSubscriberArr.length;
                if (length != 0) {
                    int i11 = 0;
                    while (true) {
                        if (i11 >= length) {
                            i11 = -1;
                            break;
                        } else if (innerSubscriberArr[i11].equals(innerSubscriber)) {
                            break;
                        } else {
                            i11++;
                        }
                    }
                    if (i11 >= 0) {
                        if (length == 1) {
                            innerSubscriberArr2 = f15595j;
                        } else {
                            InnerSubscriber[] innerSubscriberArr3 = new InnerSubscriber[(length - 1)];
                            System.arraycopy(innerSubscriberArr, 0, innerSubscriberArr3, 0, i11);
                            System.arraycopy(innerSubscriberArr, i11 + 1, innerSubscriberArr3, i11, (length - i11) - 1);
                            innerSubscriberArr2 = innerSubscriberArr3;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            } while (!b.a(this.f15599d, innerSubscriberArr, innerSubscriberArr2));
        }

        public void dispose() {
            InnerSubscriber<T>[] innerSubscriberArr = this.f15599d.get();
            InnerSubscriber<T>[] innerSubscriberArr2 = f15596k;
            if (innerSubscriberArr != innerSubscriberArr2 && ((InnerSubscriber[]) this.f15599d.getAndSet(innerSubscriberArr2)) != innerSubscriberArr2) {
                b.a(this.f15597b, this, (Object) null);
                SubscriptionHelper.cancel(this.f15601f);
            }
        }

        public boolean isDisposed() {
            return this.f15599d.get() == f15596k;
        }

        public void onComplete() {
            if (this.f15602g == null) {
                this.f15602g = NotificationLite.complete();
                c();
            }
        }

        public void onError(Throwable th2) {
            if (this.f15602g == null) {
                this.f15602g = NotificationLite.error(th2);
                c();
                return;
            }
            RxJavaPlugins.onError(th2);
        }

        public void onNext(T t11) {
            if (this.f15603h != 0 || this.f15604i.offer(t11)) {
                c();
            } else {
                onError(new MissingBackpressureException("Prefetch queue is full?!"));
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.setOnce(this.f15601f, subscription)) {
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int requestFusion = queueSubscription.requestFusion(7);
                    if (requestFusion == 1) {
                        this.f15603h = requestFusion;
                        this.f15604i = queueSubscription;
                        this.f15602g = NotificationLite.complete();
                        c();
                        return;
                    } else if (requestFusion == 2) {
                        this.f15603h = requestFusion;
                        this.f15604i = queueSubscription;
                        subscription.request((long) this.f15598c);
                        return;
                    }
                }
                this.f15604i = new SpscArrayQueue(this.f15598c);
                subscription.request((long) this.f15598c);
            }
        }
    }

    private FlowablePublish(Publisher<T> publisher, Flowable<T> flowable, AtomicReference<PublishSubscriber<T>> atomicReference, int i11) {
        this.f15591f = publisher;
        this.f15588c = flowable;
        this.f15589d = atomicReference;
        this.f15590e = i11;
    }

    public static <T> ConnectableFlowable<T> create(Flowable<T> flowable, int i11) {
        AtomicReference atomicReference = new AtomicReference();
        return RxJavaPlugins.onAssembly(new FlowablePublish(new FlowablePublisher(atomicReference, i11), flowable, atomicReference, i11));
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void connect(io.reactivex.functions.Consumer<? super io.reactivex.disposables.Disposable> r5) {
        /*
            r4 = this;
        L_0x0000:
            java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.flowable.FlowablePublish$PublishSubscriber<T>> r0 = r4.f15589d
            java.lang.Object r0 = r0.get()
            io.reactivex.internal.operators.flowable.FlowablePublish$PublishSubscriber r0 = (io.reactivex.internal.operators.flowable.FlowablePublish.PublishSubscriber) r0
            if (r0 == 0) goto L_0x0010
            boolean r1 = r0.isDisposed()
            if (r1 == 0) goto L_0x0023
        L_0x0010:
            io.reactivex.internal.operators.flowable.FlowablePublish$PublishSubscriber r1 = new io.reactivex.internal.operators.flowable.FlowablePublish$PublishSubscriber
            java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.flowable.FlowablePublish$PublishSubscriber<T>> r2 = r4.f15589d
            int r3 = r4.f15590e
            r1.<init>(r2, r3)
            java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.flowable.FlowablePublish$PublishSubscriber<T>> r2 = r4.f15589d
            boolean r0 = i.b.a(r2, r0, r1)
            if (r0 != 0) goto L_0x0022
            goto L_0x0000
        L_0x0022:
            r0 = r1
        L_0x0023:
            java.util.concurrent.atomic.AtomicBoolean r1 = r0.f15600e
            boolean r1 = r1.get()
            r2 = 0
            if (r1 != 0) goto L_0x0036
            java.util.concurrent.atomic.AtomicBoolean r1 = r0.f15600e
            r3 = 1
            boolean r1 = r1.compareAndSet(r2, r3)
            if (r1 == 0) goto L_0x0036
            r2 = r3
        L_0x0036:
            r5.accept(r0)     // Catch:{ all -> 0x0041 }
            if (r2 == 0) goto L_0x0040
            io.reactivex.Flowable<T> r5 = r4.f15588c
            r5.subscribe(r0)
        L_0x0040:
            return
        L_0x0041:
            r5 = move-exception
            io.reactivex.exceptions.Exceptions.throwIfFatal(r5)
            java.lang.RuntimeException r5 = io.reactivex.internal.util.ExceptionHelper.wrapOrThrow(r5)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowablePublish.connect(io.reactivex.functions.Consumer):void");
    }

    public int publishBufferSize() {
        return this.f15590e;
    }

    public Publisher<T> publishSource() {
        return this.f15588c;
    }

    public Publisher<T> source() {
        return this.f15588c;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.f15591f.subscribe(subscriber);
    }
}
