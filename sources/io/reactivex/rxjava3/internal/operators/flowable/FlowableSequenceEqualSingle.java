package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiPredicate;
import io.reactivex.rxjava3.internal.fuseable.FuseToFlowable;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableSequenceEqual;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.operators.SimpleQueue;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Publisher;

public final class FlowableSequenceEqualSingle<T> extends Single<Boolean> implements FuseToFlowable<Boolean> {

    /* renamed from: b  reason: collision with root package name */
    public final Publisher<? extends T> f20336b;

    /* renamed from: c  reason: collision with root package name */
    public final Publisher<? extends T> f20337c;

    /* renamed from: d  reason: collision with root package name */
    public final BiPredicate<? super T, ? super T> f20338d;

    /* renamed from: e  reason: collision with root package name */
    public final int f20339e;

    public static final class EqualCoordinator<T> extends AtomicInteger implements Disposable, FlowableSequenceEqual.EqualCoordinatorHelper {
        private static final long serialVersionUID = -6178010334400373240L;

        /* renamed from: b  reason: collision with root package name */
        public final SingleObserver<? super Boolean> f20340b;

        /* renamed from: c  reason: collision with root package name */
        public final BiPredicate<? super T, ? super T> f20341c;

        /* renamed from: d  reason: collision with root package name */
        public final FlowableSequenceEqual.EqualSubscriber<T> f20342d;

        /* renamed from: e  reason: collision with root package name */
        public final FlowableSequenceEqual.EqualSubscriber<T> f20343e;

        /* renamed from: f  reason: collision with root package name */
        public final AtomicThrowable f20344f = new AtomicThrowable();

        /* renamed from: g  reason: collision with root package name */
        public T f20345g;

        /* renamed from: h  reason: collision with root package name */
        public T f20346h;

        public EqualCoordinator(SingleObserver<? super Boolean> singleObserver, int i11, BiPredicate<? super T, ? super T> biPredicate) {
            this.f20340b = singleObserver;
            this.f20341c = biPredicate;
            this.f20342d = new FlowableSequenceEqual.EqualSubscriber<>(this, i11);
            this.f20343e = new FlowableSequenceEqual.EqualSubscriber<>(this, i11);
        }

        public void a() {
            this.f20342d.cancel();
            this.f20342d.a();
            this.f20343e.cancel();
            this.f20343e.a();
        }

        public void b(Publisher<? extends T> publisher, Publisher<? extends T> publisher2) {
            publisher.subscribe(this.f20342d);
            publisher2.subscribe(this.f20343e);
        }

        public void dispose() {
            this.f20342d.cancel();
            this.f20343e.cancel();
            this.f20344f.tryTerminateAndReport();
            if (getAndIncrement() == 0) {
                this.f20342d.a();
                this.f20343e.a();
            }
        }

        public void drain() {
            boolean z11;
            if (getAndIncrement() == 0) {
                int i11 = 1;
                do {
                    SimpleQueue<T> simpleQueue = this.f20342d.f20333f;
                    SimpleQueue<T> simpleQueue2 = this.f20343e.f20333f;
                    if (simpleQueue != null && simpleQueue2 != null) {
                        while (!isDisposed()) {
                            if (((Throwable) this.f20344f.get()) != null) {
                                a();
                                this.f20344f.tryTerminateConsumer((SingleObserver<?>) this.f20340b);
                                return;
                            }
                            boolean z12 = this.f20342d.f20334g;
                            T t11 = this.f20345g;
                            if (t11 == null) {
                                try {
                                    t11 = simpleQueue.poll();
                                    this.f20345g = t11;
                                } catch (Throwable th2) {
                                    Exceptions.throwIfFatal(th2);
                                    a();
                                    this.f20344f.tryAddThrowableOrReport(th2);
                                    this.f20344f.tryTerminateConsumer((SingleObserver<?>) this.f20340b);
                                    return;
                                }
                            }
                            boolean z13 = false;
                            if (t11 == null) {
                                z11 = true;
                            } else {
                                z11 = false;
                            }
                            boolean z14 = this.f20343e.f20334g;
                            T t12 = this.f20346h;
                            if (t12 == null) {
                                try {
                                    t12 = simpleQueue2.poll();
                                    this.f20346h = t12;
                                } catch (Throwable th3) {
                                    Exceptions.throwIfFatal(th3);
                                    a();
                                    this.f20344f.tryAddThrowableOrReport(th3);
                                    this.f20344f.tryTerminateConsumer((SingleObserver<?>) this.f20340b);
                                    return;
                                }
                            }
                            if (t12 == null) {
                                z13 = true;
                            }
                            if (z12 && z14 && z11 && z13) {
                                this.f20340b.onSuccess(Boolean.TRUE);
                                return;
                            } else if (z12 && z14 && z11 != z13) {
                                a();
                                this.f20340b.onSuccess(Boolean.FALSE);
                                return;
                            } else if (!z11 && !z13) {
                                try {
                                    if (!this.f20341c.test(t11, t12)) {
                                        a();
                                        this.f20340b.onSuccess(Boolean.FALSE);
                                        return;
                                    }
                                    this.f20345g = null;
                                    this.f20346h = null;
                                    this.f20342d.request();
                                    this.f20343e.request();
                                } catch (Throwable th4) {
                                    Exceptions.throwIfFatal(th4);
                                    a();
                                    this.f20344f.tryAddThrowableOrReport(th4);
                                    this.f20344f.tryTerminateConsumer((SingleObserver<?>) this.f20340b);
                                    return;
                                }
                            }
                        }
                        this.f20342d.a();
                        this.f20343e.a();
                        return;
                    } else if (isDisposed()) {
                        this.f20342d.a();
                        this.f20343e.a();
                        return;
                    } else if (((Throwable) this.f20344f.get()) != null) {
                        a();
                        this.f20344f.tryTerminateConsumer((SingleObserver<?>) this.f20340b);
                        return;
                    }
                    i11 = addAndGet(-i11);
                } while (i11 != 0);
            }
        }

        public void innerError(Throwable th2) {
            if (this.f20344f.tryAddThrowableOrReport(th2)) {
                drain();
            }
        }

        public boolean isDisposed() {
            return this.f20342d.get() == SubscriptionHelper.CANCELLED;
        }
    }

    public FlowableSequenceEqualSingle(Publisher<? extends T> publisher, Publisher<? extends T> publisher2, BiPredicate<? super T, ? super T> biPredicate, int i11) {
        this.f20336b = publisher;
        this.f20337c = publisher2;
        this.f20338d = biPredicate;
        this.f20339e = i11;
    }

    public Flowable<Boolean> fuseToFlowable() {
        return RxJavaPlugins.onAssembly(new FlowableSequenceEqual(this.f20336b, this.f20337c, this.f20338d, this.f20339e));
    }

    public void subscribeActual(SingleObserver<? super Boolean> singleObserver) {
        EqualCoordinator equalCoordinator = new EqualCoordinator(singleObserver, this.f20339e, this.f20338d);
        singleObserver.onSubscribe(equalCoordinator);
        equalCoordinator.b(this.f20336b, this.f20337c);
    }
}
