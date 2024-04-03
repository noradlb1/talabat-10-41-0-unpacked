package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiPredicate;
import io.reactivex.internal.fuseable.FuseToFlowable;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.operators.flowable.FlowableSequenceEqual;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Publisher;

public final class FlowableSequenceEqualSingle<T> extends Single<Boolean> implements FuseToFlowable<Boolean> {

    /* renamed from: b  reason: collision with root package name */
    public final Publisher<? extends T> f15826b;

    /* renamed from: c  reason: collision with root package name */
    public final Publisher<? extends T> f15827c;

    /* renamed from: d  reason: collision with root package name */
    public final BiPredicate<? super T, ? super T> f15828d;

    /* renamed from: e  reason: collision with root package name */
    public final int f15829e;

    public static final class EqualCoordinator<T> extends AtomicInteger implements Disposable, FlowableSequenceEqual.EqualCoordinatorHelper {
        private static final long serialVersionUID = -6178010334400373240L;

        /* renamed from: b  reason: collision with root package name */
        public final SingleObserver<? super Boolean> f15830b;

        /* renamed from: c  reason: collision with root package name */
        public final BiPredicate<? super T, ? super T> f15831c;

        /* renamed from: d  reason: collision with root package name */
        public final FlowableSequenceEqual.EqualSubscriber<T> f15832d;

        /* renamed from: e  reason: collision with root package name */
        public final FlowableSequenceEqual.EqualSubscriber<T> f15833e;

        /* renamed from: f  reason: collision with root package name */
        public final AtomicThrowable f15834f = new AtomicThrowable();

        /* renamed from: g  reason: collision with root package name */
        public T f15835g;

        /* renamed from: h  reason: collision with root package name */
        public T f15836h;

        public EqualCoordinator(SingleObserver<? super Boolean> singleObserver, int i11, BiPredicate<? super T, ? super T> biPredicate) {
            this.f15830b = singleObserver;
            this.f15831c = biPredicate;
            this.f15832d = new FlowableSequenceEqual.EqualSubscriber<>(this, i11);
            this.f15833e = new FlowableSequenceEqual.EqualSubscriber<>(this, i11);
        }

        public void a() {
            this.f15832d.cancel();
            this.f15832d.a();
            this.f15833e.cancel();
            this.f15833e.a();
        }

        public void b(Publisher<? extends T> publisher, Publisher<? extends T> publisher2) {
            publisher.subscribe(this.f15832d);
            publisher2.subscribe(this.f15833e);
        }

        public void dispose() {
            this.f15832d.cancel();
            this.f15833e.cancel();
            if (getAndIncrement() == 0) {
                this.f15832d.a();
                this.f15833e.a();
            }
        }

        public void drain() {
            boolean z11;
            if (getAndIncrement() == 0) {
                int i11 = 1;
                do {
                    SimpleQueue<T> simpleQueue = this.f15832d.f15823f;
                    SimpleQueue<T> simpleQueue2 = this.f15833e.f15823f;
                    if (simpleQueue != null && simpleQueue2 != null) {
                        while (!isDisposed()) {
                            if (((Throwable) this.f15834f.get()) != null) {
                                a();
                                this.f15830b.onError(this.f15834f.terminate());
                                return;
                            }
                            boolean z12 = this.f15832d.f15824g;
                            T t11 = this.f15835g;
                            if (t11 == null) {
                                try {
                                    t11 = simpleQueue.poll();
                                    this.f15835g = t11;
                                } catch (Throwable th2) {
                                    Exceptions.throwIfFatal(th2);
                                    a();
                                    this.f15834f.addThrowable(th2);
                                    this.f15830b.onError(this.f15834f.terminate());
                                    return;
                                }
                            }
                            boolean z13 = false;
                            if (t11 == null) {
                                z11 = true;
                            } else {
                                z11 = false;
                            }
                            boolean z14 = this.f15833e.f15824g;
                            T t12 = this.f15836h;
                            if (t12 == null) {
                                try {
                                    t12 = simpleQueue2.poll();
                                    this.f15836h = t12;
                                } catch (Throwable th3) {
                                    Exceptions.throwIfFatal(th3);
                                    a();
                                    this.f15834f.addThrowable(th3);
                                    this.f15830b.onError(this.f15834f.terminate());
                                    return;
                                }
                            }
                            if (t12 == null) {
                                z13 = true;
                            }
                            if (z12 && z14 && z11 && z13) {
                                this.f15830b.onSuccess(Boolean.TRUE);
                                return;
                            } else if (z12 && z14 && z11 != z13) {
                                a();
                                this.f15830b.onSuccess(Boolean.FALSE);
                                return;
                            } else if (!z11 && !z13) {
                                try {
                                    if (!this.f15831c.test(t11, t12)) {
                                        a();
                                        this.f15830b.onSuccess(Boolean.FALSE);
                                        return;
                                    }
                                    this.f15835g = null;
                                    this.f15836h = null;
                                    this.f15832d.request();
                                    this.f15833e.request();
                                } catch (Throwable th4) {
                                    Exceptions.throwIfFatal(th4);
                                    a();
                                    this.f15834f.addThrowable(th4);
                                    this.f15830b.onError(this.f15834f.terminate());
                                    return;
                                }
                            }
                        }
                        this.f15832d.a();
                        this.f15833e.a();
                        return;
                    } else if (isDisposed()) {
                        this.f15832d.a();
                        this.f15833e.a();
                        return;
                    } else if (((Throwable) this.f15834f.get()) != null) {
                        a();
                        this.f15830b.onError(this.f15834f.terminate());
                        return;
                    }
                    i11 = addAndGet(-i11);
                } while (i11 != 0);
            }
        }

        public void innerError(Throwable th2) {
            if (this.f15834f.addThrowable(th2)) {
                drain();
            } else {
                RxJavaPlugins.onError(th2);
            }
        }

        public boolean isDisposed() {
            return this.f15832d.get() == SubscriptionHelper.CANCELLED;
        }
    }

    public FlowableSequenceEqualSingle(Publisher<? extends T> publisher, Publisher<? extends T> publisher2, BiPredicate<? super T, ? super T> biPredicate, int i11) {
        this.f15826b = publisher;
        this.f15827c = publisher2;
        this.f15828d = biPredicate;
        this.f15829e = i11;
    }

    public Flowable<Boolean> fuseToFlowable() {
        return RxJavaPlugins.onAssembly(new FlowableSequenceEqual(this.f15826b, this.f15827c, this.f15828d, this.f15829e));
    }

    public void subscribeActual(SingleObserver<? super Boolean> singleObserver) {
        EqualCoordinator equalCoordinator = new EqualCoordinator(singleObserver, this.f15829e, this.f15828d);
        singleObserver.onSubscribe(equalCoordinator);
        equalCoordinator.b(this.f15826b, this.f15827c);
    }
}
