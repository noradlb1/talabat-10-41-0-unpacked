package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiPredicate;
import io.reactivex.rxjava3.internal.disposables.ArrayCompositeDisposable;
import io.reactivex.rxjava3.internal.fuseable.FuseToObservable;
import io.reactivex.rxjava3.operators.SpscLinkedArrayQueue;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;

public final class ObservableSequenceEqualSingle<T> extends Single<Boolean> implements FuseToObservable<Boolean> {

    /* renamed from: b  reason: collision with root package name */
    public final ObservableSource<? extends T> f22191b;

    /* renamed from: c  reason: collision with root package name */
    public final ObservableSource<? extends T> f22192c;

    /* renamed from: d  reason: collision with root package name */
    public final BiPredicate<? super T, ? super T> f22193d;

    /* renamed from: e  reason: collision with root package name */
    public final int f22194e;

    public static final class EqualCoordinator<T> extends AtomicInteger implements Disposable {
        private static final long serialVersionUID = -6178010334400373240L;

        /* renamed from: b  reason: collision with root package name */
        public final SingleObserver<? super Boolean> f22195b;

        /* renamed from: c  reason: collision with root package name */
        public final BiPredicate<? super T, ? super T> f22196c;

        /* renamed from: d  reason: collision with root package name */
        public final ArrayCompositeDisposable f22197d = new ArrayCompositeDisposable(2);

        /* renamed from: e  reason: collision with root package name */
        public final ObservableSource<? extends T> f22198e;

        /* renamed from: f  reason: collision with root package name */
        public final ObservableSource<? extends T> f22199f;

        /* renamed from: g  reason: collision with root package name */
        public final EqualObserver<T>[] f22200g;

        /* renamed from: h  reason: collision with root package name */
        public volatile boolean f22201h;

        /* renamed from: i  reason: collision with root package name */
        public T f22202i;

        /* renamed from: j  reason: collision with root package name */
        public T f22203j;

        public EqualCoordinator(SingleObserver<? super Boolean> singleObserver, int i11, ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2, BiPredicate<? super T, ? super T> biPredicate) {
            this.f22195b = singleObserver;
            this.f22198e = observableSource;
            this.f22199f = observableSource2;
            this.f22196c = biPredicate;
            EqualObserver<T>[] equalObserverArr = new EqualObserver[2];
            this.f22200g = equalObserverArr;
            equalObserverArr[0] = new EqualObserver<>(this, 0, i11);
            equalObserverArr[1] = new EqualObserver<>(this, 1, i11);
        }

        public void a(SpscLinkedArrayQueue<T> spscLinkedArrayQueue, SpscLinkedArrayQueue<T> spscLinkedArrayQueue2) {
            this.f22201h = true;
            spscLinkedArrayQueue.clear();
            spscLinkedArrayQueue2.clear();
        }

        public void b() {
            boolean z11;
            boolean z12;
            Throwable th2;
            Throwable th3;
            if (getAndIncrement() == 0) {
                EqualObserver<T>[] equalObserverArr = this.f22200g;
                EqualObserver<T> equalObserver = equalObserverArr[0];
                SpscLinkedArrayQueue<T> spscLinkedArrayQueue = equalObserver.f22205c;
                EqualObserver<T> equalObserver2 = equalObserverArr[1];
                SpscLinkedArrayQueue<T> spscLinkedArrayQueue2 = equalObserver2.f22205c;
                int i11 = 1;
                while (!this.f22201h) {
                    boolean z13 = equalObserver.f22207e;
                    if (!z13 || (th3 = equalObserver.f22208f) == null) {
                        boolean z14 = equalObserver2.f22207e;
                        if (!z14 || (th2 = equalObserver2.f22208f) == null) {
                            if (this.f22202i == null) {
                                this.f22202i = spscLinkedArrayQueue.poll();
                            }
                            if (this.f22202i == null) {
                                z11 = true;
                            } else {
                                z11 = false;
                            }
                            if (this.f22203j == null) {
                                this.f22203j = spscLinkedArrayQueue2.poll();
                            }
                            T t11 = this.f22203j;
                            if (t11 == null) {
                                z12 = true;
                            } else {
                                z12 = false;
                            }
                            if (z13 && z14 && z11 && z12) {
                                this.f22195b.onSuccess(Boolean.TRUE);
                                return;
                            } else if (!z13 || !z14 || z11 == z12) {
                                if (!z11 && !z12) {
                                    try {
                                        if (!this.f22196c.test(this.f22202i, t11)) {
                                            a(spscLinkedArrayQueue, spscLinkedArrayQueue2);
                                            this.f22195b.onSuccess(Boolean.FALSE);
                                            return;
                                        }
                                        this.f22202i = null;
                                        this.f22203j = null;
                                    } catch (Throwable th4) {
                                        Exceptions.throwIfFatal(th4);
                                        a(spscLinkedArrayQueue, spscLinkedArrayQueue2);
                                        this.f22195b.onError(th4);
                                        return;
                                    }
                                }
                                if ((z11 || z12) && (i11 = addAndGet(-i11)) == 0) {
                                    return;
                                }
                            } else {
                                a(spscLinkedArrayQueue, spscLinkedArrayQueue2);
                                this.f22195b.onSuccess(Boolean.FALSE);
                                return;
                            }
                        } else {
                            a(spscLinkedArrayQueue, spscLinkedArrayQueue2);
                            this.f22195b.onError(th2);
                            return;
                        }
                    } else {
                        a(spscLinkedArrayQueue, spscLinkedArrayQueue2);
                        this.f22195b.onError(th3);
                        return;
                    }
                }
                spscLinkedArrayQueue.clear();
                spscLinkedArrayQueue2.clear();
            }
        }

        public boolean c(Disposable disposable, int i11) {
            return this.f22197d.setResource(i11, disposable);
        }

        public void d() {
            EqualObserver<T>[] equalObserverArr = this.f22200g;
            this.f22198e.subscribe(equalObserverArr[0]);
            this.f22199f.subscribe(equalObserverArr[1]);
        }

        public void dispose() {
            if (!this.f22201h) {
                this.f22201h = true;
                this.f22197d.dispose();
                if (getAndIncrement() == 0) {
                    EqualObserver<T>[] equalObserverArr = this.f22200g;
                    equalObserverArr[0].f22205c.clear();
                    equalObserverArr[1].f22205c.clear();
                }
            }
        }

        public boolean isDisposed() {
            return this.f22201h;
        }
    }

    public static final class EqualObserver<T> implements Observer<T> {

        /* renamed from: b  reason: collision with root package name */
        public final EqualCoordinator<T> f22204b;

        /* renamed from: c  reason: collision with root package name */
        public final SpscLinkedArrayQueue<T> f22205c;

        /* renamed from: d  reason: collision with root package name */
        public final int f22206d;

        /* renamed from: e  reason: collision with root package name */
        public volatile boolean f22207e;

        /* renamed from: f  reason: collision with root package name */
        public Throwable f22208f;

        public EqualObserver(EqualCoordinator<T> equalCoordinator, int i11, int i12) {
            this.f22204b = equalCoordinator;
            this.f22206d = i11;
            this.f22205c = new SpscLinkedArrayQueue<>(i12);
        }

        public void onComplete() {
            this.f22207e = true;
            this.f22204b.b();
        }

        public void onError(Throwable th2) {
            this.f22208f = th2;
            this.f22207e = true;
            this.f22204b.b();
        }

        public void onNext(T t11) {
            this.f22205c.offer(t11);
            this.f22204b.b();
        }

        public void onSubscribe(Disposable disposable) {
            this.f22204b.c(disposable, this.f22206d);
        }
    }

    public ObservableSequenceEqualSingle(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2, BiPredicate<? super T, ? super T> biPredicate, int i11) {
        this.f22191b = observableSource;
        this.f22192c = observableSource2;
        this.f22193d = biPredicate;
        this.f22194e = i11;
    }

    public Observable<Boolean> fuseToObservable() {
        return RxJavaPlugins.onAssembly(new ObservableSequenceEqual(this.f22191b, this.f22192c, this.f22193d, this.f22194e));
    }

    public void subscribeActual(SingleObserver<? super Boolean> singleObserver) {
        EqualCoordinator equalCoordinator = new EqualCoordinator(singleObserver, this.f22194e, this.f22191b, this.f22192c, this.f22193d);
        singleObserver.onSubscribe(equalCoordinator);
        equalCoordinator.d();
    }
}
