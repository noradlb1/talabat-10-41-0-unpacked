package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.queue.MpscLinkedQueue;
import io.reactivex.rxjava3.internal.subscribers.QueueDrainSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.subscribers.DisposableSubscriber;
import io.reactivex.rxjava3.subscribers.SerializedSubscriber;
import java.util.Collection;
import java.util.Objects;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableBufferExactBoundary<T, U extends Collection<? super T>, B> extends AbstractFlowableWithUpstream<T, U> {

    /* renamed from: d  reason: collision with root package name */
    public final Publisher<B> f19364d;

    /* renamed from: e  reason: collision with root package name */
    public final Supplier<U> f19365e;

    public static final class BufferBoundarySubscriber<T, U extends Collection<? super T>, B> extends DisposableSubscriber<B> {

        /* renamed from: c  reason: collision with root package name */
        public final BufferExactBoundarySubscriber<T, U, B> f19366c;

        public BufferBoundarySubscriber(BufferExactBoundarySubscriber<T, U, B> bufferExactBoundarySubscriber) {
            this.f19366c = bufferExactBoundarySubscriber;
        }

        public void onComplete() {
            this.f19366c.onComplete();
        }

        public void onError(Throwable th2) {
            this.f19366c.onError(th2);
        }

        public void onNext(B b11) {
            this.f19366c.c();
        }
    }

    public static final class BufferExactBoundarySubscriber<T, U extends Collection<? super T>, B> extends QueueDrainSubscriber<T, U, U> implements Subscription, Disposable {

        /* renamed from: i  reason: collision with root package name */
        public final Supplier<U> f19367i;

        /* renamed from: j  reason: collision with root package name */
        public final Publisher<B> f19368j;

        /* renamed from: k  reason: collision with root package name */
        public Subscription f19369k;

        /* renamed from: l  reason: collision with root package name */
        public Disposable f19370l;

        /* renamed from: m  reason: collision with root package name */
        public U f19371m;

        public BufferExactBoundarySubscriber(Subscriber<? super U> subscriber, Supplier<U> supplier, Publisher<B> publisher) {
            super(subscriber, new MpscLinkedQueue());
            this.f19367i = supplier;
            this.f19368j = publisher;
        }

        public void c() {
            try {
                U u11 = this.f19367i.get();
                Objects.requireNonNull(u11, "The buffer supplied is null");
                U u12 = (Collection) u11;
                synchronized (this) {
                    U u13 = this.f19371m;
                    if (u13 != null) {
                        this.f19371m = u12;
                        a(u13, false, this);
                    }
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                cancel();
                this.f23149d.onError(th2);
            }
        }

        public void cancel() {
            if (!this.f23151f) {
                this.f23151f = true;
                this.f19370l.dispose();
                this.f19369k.cancel();
                if (enter()) {
                    this.f23150e.clear();
                }
            }
        }

        public void dispose() {
            cancel();
        }

        public boolean isDisposed() {
            return this.f23151f;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0019, code lost:
            io.reactivex.rxjava3.internal.util.QueueDrainHelper.drainMaxLoop(r3.f23150e, r3.f23149d, false, r3, r3);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x000b, code lost:
            r3.f23150e.offer(r0);
            r3.f23152g = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0017, code lost:
            if (enter() == false) goto L_?;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onComplete() {
            /*
                r3 = this;
                monitor-enter(r3)
                U r0 = r3.f19371m     // Catch:{ all -> 0x0022 }
                if (r0 != 0) goto L_0x0007
                monitor-exit(r3)     // Catch:{ all -> 0x0022 }
                return
            L_0x0007:
                r1 = 0
                r3.f19371m = r1     // Catch:{ all -> 0x0022 }
                monitor-exit(r3)     // Catch:{ all -> 0x0022 }
                io.reactivex.rxjava3.operators.SimplePlainQueue<U> r1 = r3.f23150e
                r1.offer(r0)
                r0 = 1
                r3.f23152g = r0
                boolean r0 = r3.enter()
                if (r0 == 0) goto L_0x0021
                io.reactivex.rxjava3.operators.SimplePlainQueue<U> r0 = r3.f23150e
                org.reactivestreams.Subscriber<? super V> r1 = r3.f23149d
                r2 = 0
                io.reactivex.rxjava3.internal.util.QueueDrainHelper.drainMaxLoop(r0, r1, r2, r3, r3)
            L_0x0021:
                return
            L_0x0022:
                r0 = move-exception
                monitor-exit(r3)     // Catch:{ all -> 0x0022 }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.flowable.FlowableBufferExactBoundary.BufferExactBoundarySubscriber.onComplete():void");
        }

        public void onError(Throwable th2) {
            cancel();
            this.f23149d.onError(th2);
        }

        public void onNext(T t11) {
            synchronized (this) {
                U u11 = this.f19371m;
                if (u11 != null) {
                    u11.add(t11);
                }
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f19369k, subscription)) {
                this.f19369k = subscription;
                try {
                    U u11 = this.f19367i.get();
                    Objects.requireNonNull(u11, "The buffer supplied is null");
                    this.f19371m = (Collection) u11;
                    BufferBoundarySubscriber bufferBoundarySubscriber = new BufferBoundarySubscriber(this);
                    this.f19370l = bufferBoundarySubscriber;
                    this.f23149d.onSubscribe(this);
                    if (!this.f23151f) {
                        subscription.request(Long.MAX_VALUE);
                        this.f19368j.subscribe(bufferBoundarySubscriber);
                    }
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    this.f23151f = true;
                    subscription.cancel();
                    EmptySubscription.error(th2, this.f23149d);
                }
            }
        }

        public void request(long j11) {
            requested(j11);
        }

        public boolean accept(Subscriber<? super U> subscriber, U u11) {
            this.f23149d.onNext(u11);
            return true;
        }
    }

    public FlowableBufferExactBoundary(Flowable<T> flowable, Publisher<B> publisher, Supplier<U> supplier) {
        super(flowable);
        this.f19364d = publisher;
        this.f19365e = supplier;
    }

    public void subscribeActual(Subscriber<? super U> subscriber) {
        this.f19260c.subscribe(new BufferExactBoundarySubscriber(new SerializedSubscriber(subscriber), this.f19365e, this.f19364d));
    }
}
