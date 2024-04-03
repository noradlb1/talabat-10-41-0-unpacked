package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.subscribers.QueueDrainSubscriber;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.subscribers.DisposableSubscriber;
import io.reactivex.subscribers.SerializedSubscriber;
import java.util.Collection;
import java.util.concurrent.Callable;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableBufferExactBoundary<T, U extends Collection<? super T>, B> extends AbstractFlowableWithUpstream<T, U> {

    /* renamed from: d  reason: collision with root package name */
    public final Publisher<B> f14876d;

    /* renamed from: e  reason: collision with root package name */
    public final Callable<U> f14877e;

    public static final class BufferBoundarySubscriber<T, U extends Collection<? super T>, B> extends DisposableSubscriber<B> {

        /* renamed from: c  reason: collision with root package name */
        public final BufferExactBoundarySubscriber<T, U, B> f14878c;

        public BufferBoundarySubscriber(BufferExactBoundarySubscriber<T, U, B> bufferExactBoundarySubscriber) {
            this.f14878c = bufferExactBoundarySubscriber;
        }

        public void onComplete() {
            this.f14878c.onComplete();
        }

        public void onError(Throwable th2) {
            this.f14878c.onError(th2);
        }

        public void onNext(B b11) {
            this.f14878c.c();
        }
    }

    public static final class BufferExactBoundarySubscriber<T, U extends Collection<? super T>, B> extends QueueDrainSubscriber<T, U, U> implements Subscription, Disposable {

        /* renamed from: i  reason: collision with root package name */
        public final Callable<U> f14879i;

        /* renamed from: j  reason: collision with root package name */
        public final Publisher<B> f14880j;

        /* renamed from: k  reason: collision with root package name */
        public Subscription f14881k;

        /* renamed from: l  reason: collision with root package name */
        public Disposable f14882l;

        /* renamed from: m  reason: collision with root package name */
        public U f14883m;

        public BufferExactBoundarySubscriber(Subscriber<? super U> subscriber, Callable<U> callable, Publisher<B> publisher) {
            super(subscriber, new MpscLinkedQueue());
            this.f14879i = callable;
            this.f14880j = publisher;
        }

        public void c() {
            try {
                U u11 = (Collection) ObjectHelper.requireNonNull(this.f14879i.call(), "The buffer supplied is null");
                synchronized (this) {
                    U u12 = this.f14883m;
                    if (u12 != null) {
                        this.f14883m = u11;
                        a(u12, false, this);
                    }
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                cancel();
                this.f18588d.onError(th2);
            }
        }

        public void cancel() {
            if (!this.f18590f) {
                this.f18590f = true;
                this.f14882l.dispose();
                this.f14881k.cancel();
                if (enter()) {
                    this.f18589e.clear();
                }
            }
        }

        public void dispose() {
            cancel();
        }

        public boolean isDisposed() {
            return this.f18590f;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0019, code lost:
            io.reactivex.internal.util.QueueDrainHelper.drainMaxLoop(r3.f18589e, r3.f18588d, false, r3, r3);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x000b, code lost:
            r3.f18589e.offer(r0);
            r3.f18591g = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0017, code lost:
            if (enter() == false) goto L_?;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onComplete() {
            /*
                r3 = this;
                monitor-enter(r3)
                U r0 = r3.f14883m     // Catch:{ all -> 0x0022 }
                if (r0 != 0) goto L_0x0007
                monitor-exit(r3)     // Catch:{ all -> 0x0022 }
                return
            L_0x0007:
                r1 = 0
                r3.f14883m = r1     // Catch:{ all -> 0x0022 }
                monitor-exit(r3)     // Catch:{ all -> 0x0022 }
                io.reactivex.internal.fuseable.SimplePlainQueue<U> r1 = r3.f18589e
                r1.offer(r0)
                r0 = 1
                r3.f18591g = r0
                boolean r0 = r3.enter()
                if (r0 == 0) goto L_0x0021
                io.reactivex.internal.fuseable.SimplePlainQueue<U> r0 = r3.f18589e
                org.reactivestreams.Subscriber<? super V> r1 = r3.f18588d
                r2 = 0
                io.reactivex.internal.util.QueueDrainHelper.drainMaxLoop(r0, r1, r2, r3, r3)
            L_0x0021:
                return
            L_0x0022:
                r0 = move-exception
                monitor-exit(r3)     // Catch:{ all -> 0x0022 }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableBufferExactBoundary.BufferExactBoundarySubscriber.onComplete():void");
        }

        public void onError(Throwable th2) {
            cancel();
            this.f18588d.onError(th2);
        }

        public void onNext(T t11) {
            synchronized (this) {
                U u11 = this.f14883m;
                if (u11 != null) {
                    u11.add(t11);
                }
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f14881k, subscription)) {
                this.f14881k = subscription;
                try {
                    this.f14883m = (Collection) ObjectHelper.requireNonNull(this.f14879i.call(), "The buffer supplied is null");
                    BufferBoundarySubscriber bufferBoundarySubscriber = new BufferBoundarySubscriber(this);
                    this.f14882l = bufferBoundarySubscriber;
                    this.f18588d.onSubscribe(this);
                    if (!this.f18590f) {
                        subscription.request(Long.MAX_VALUE);
                        this.f14880j.subscribe(bufferBoundarySubscriber);
                    }
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    this.f18590f = true;
                    subscription.cancel();
                    EmptySubscription.error(th2, this.f18588d);
                }
            }
        }

        public void request(long j11) {
            requested(j11);
        }

        public boolean accept(Subscriber<? super U> subscriber, U u11) {
            this.f18588d.onNext(u11);
            return true;
        }
    }

    public FlowableBufferExactBoundary(Flowable<T> flowable, Publisher<B> publisher, Callable<U> callable) {
        super(flowable);
        this.f14876d = publisher;
        this.f14877e = callable;
    }

    public void subscribeActual(Subscriber<? super U> subscriber) {
        this.f14763c.subscribe(new BufferExactBoundarySubscriber(new SerializedSubscriber(subscriber), this.f14877e, this.f14876d));
    }
}
