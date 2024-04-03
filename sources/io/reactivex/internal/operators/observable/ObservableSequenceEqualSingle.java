package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiPredicate;
import io.reactivex.internal.disposables.ArrayCompositeDisposable;
import io.reactivex.internal.fuseable.FuseToObservable;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;

public final class ObservableSequenceEqualSingle<T> extends Single<Boolean> implements FuseToObservable<Boolean> {

    /* renamed from: b  reason: collision with root package name */
    public final ObservableSource<? extends T> f17648b;

    /* renamed from: c  reason: collision with root package name */
    public final ObservableSource<? extends T> f17649c;

    /* renamed from: d  reason: collision with root package name */
    public final BiPredicate<? super T, ? super T> f17650d;

    /* renamed from: e  reason: collision with root package name */
    public final int f17651e;

    public static final class EqualCoordinator<T> extends AtomicInteger implements Disposable {
        private static final long serialVersionUID = -6178010334400373240L;

        /* renamed from: b  reason: collision with root package name */
        public final SingleObserver<? super Boolean> f17652b;

        /* renamed from: c  reason: collision with root package name */
        public final BiPredicate<? super T, ? super T> f17653c;

        /* renamed from: d  reason: collision with root package name */
        public final ArrayCompositeDisposable f17654d = new ArrayCompositeDisposable(2);

        /* renamed from: e  reason: collision with root package name */
        public final ObservableSource<? extends T> f17655e;

        /* renamed from: f  reason: collision with root package name */
        public final ObservableSource<? extends T> f17656f;

        /* renamed from: g  reason: collision with root package name */
        public final EqualObserver<T>[] f17657g;

        /* renamed from: h  reason: collision with root package name */
        public volatile boolean f17658h;

        /* renamed from: i  reason: collision with root package name */
        public T f17659i;

        /* renamed from: j  reason: collision with root package name */
        public T f17660j;

        public EqualCoordinator(SingleObserver<? super Boolean> singleObserver, int i11, ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2, BiPredicate<? super T, ? super T> biPredicate) {
            this.f17652b = singleObserver;
            this.f17655e = observableSource;
            this.f17656f = observableSource2;
            this.f17653c = biPredicate;
            EqualObserver<T>[] equalObserverArr = new EqualObserver[2];
            this.f17657g = equalObserverArr;
            equalObserverArr[0] = new EqualObserver<>(this, 0, i11);
            equalObserverArr[1] = new EqualObserver<>(this, 1, i11);
        }

        public void a(SpscLinkedArrayQueue<T> spscLinkedArrayQueue, SpscLinkedArrayQueue<T> spscLinkedArrayQueue2) {
            this.f17658h = true;
            spscLinkedArrayQueue.clear();
            spscLinkedArrayQueue2.clear();
        }

        public void b() {
            boolean z11;
            boolean z12;
            Throwable th2;
            Throwable th3;
            if (getAndIncrement() == 0) {
                EqualObserver<T>[] equalObserverArr = this.f17657g;
                EqualObserver<T> equalObserver = equalObserverArr[0];
                SpscLinkedArrayQueue<T> spscLinkedArrayQueue = equalObserver.f17662c;
                EqualObserver<T> equalObserver2 = equalObserverArr[1];
                SpscLinkedArrayQueue<T> spscLinkedArrayQueue2 = equalObserver2.f17662c;
                int i11 = 1;
                while (!this.f17658h) {
                    boolean z13 = equalObserver.f17664e;
                    if (!z13 || (th3 = equalObserver.f17665f) == null) {
                        boolean z14 = equalObserver2.f17664e;
                        if (!z14 || (th2 = equalObserver2.f17665f) == null) {
                            if (this.f17659i == null) {
                                this.f17659i = spscLinkedArrayQueue.poll();
                            }
                            if (this.f17659i == null) {
                                z11 = true;
                            } else {
                                z11 = false;
                            }
                            if (this.f17660j == null) {
                                this.f17660j = spscLinkedArrayQueue2.poll();
                            }
                            T t11 = this.f17660j;
                            if (t11 == null) {
                                z12 = true;
                            } else {
                                z12 = false;
                            }
                            if (z13 && z14 && z11 && z12) {
                                this.f17652b.onSuccess(Boolean.TRUE);
                                return;
                            } else if (!z13 || !z14 || z11 == z12) {
                                if (!z11 && !z12) {
                                    try {
                                        if (!this.f17653c.test(this.f17659i, t11)) {
                                            a(spscLinkedArrayQueue, spscLinkedArrayQueue2);
                                            this.f17652b.onSuccess(Boolean.FALSE);
                                            return;
                                        }
                                        this.f17659i = null;
                                        this.f17660j = null;
                                    } catch (Throwable th4) {
                                        Exceptions.throwIfFatal(th4);
                                        a(spscLinkedArrayQueue, spscLinkedArrayQueue2);
                                        this.f17652b.onError(th4);
                                        return;
                                    }
                                }
                                if ((z11 || z12) && (i11 = addAndGet(-i11)) == 0) {
                                    return;
                                }
                            } else {
                                a(spscLinkedArrayQueue, spscLinkedArrayQueue2);
                                this.f17652b.onSuccess(Boolean.FALSE);
                                return;
                            }
                        } else {
                            a(spscLinkedArrayQueue, spscLinkedArrayQueue2);
                            this.f17652b.onError(th2);
                            return;
                        }
                    } else {
                        a(spscLinkedArrayQueue, spscLinkedArrayQueue2);
                        this.f17652b.onError(th3);
                        return;
                    }
                }
                spscLinkedArrayQueue.clear();
                spscLinkedArrayQueue2.clear();
            }
        }

        public boolean c(Disposable disposable, int i11) {
            return this.f17654d.setResource(i11, disposable);
        }

        public void d() {
            EqualObserver<T>[] equalObserverArr = this.f17657g;
            this.f17655e.subscribe(equalObserverArr[0]);
            this.f17656f.subscribe(equalObserverArr[1]);
        }

        public void dispose() {
            if (!this.f17658h) {
                this.f17658h = true;
                this.f17654d.dispose();
                if (getAndIncrement() == 0) {
                    EqualObserver<T>[] equalObserverArr = this.f17657g;
                    equalObserverArr[0].f17662c.clear();
                    equalObserverArr[1].f17662c.clear();
                }
            }
        }

        public boolean isDisposed() {
            return this.f17658h;
        }
    }

    public static final class EqualObserver<T> implements Observer<T> {

        /* renamed from: b  reason: collision with root package name */
        public final EqualCoordinator<T> f17661b;

        /* renamed from: c  reason: collision with root package name */
        public final SpscLinkedArrayQueue<T> f17662c;

        /* renamed from: d  reason: collision with root package name */
        public final int f17663d;

        /* renamed from: e  reason: collision with root package name */
        public volatile boolean f17664e;

        /* renamed from: f  reason: collision with root package name */
        public Throwable f17665f;

        public EqualObserver(EqualCoordinator<T> equalCoordinator, int i11, int i12) {
            this.f17661b = equalCoordinator;
            this.f17663d = i11;
            this.f17662c = new SpscLinkedArrayQueue<>(i12);
        }

        public void onComplete() {
            this.f17664e = true;
            this.f17661b.b();
        }

        public void onError(Throwable th2) {
            this.f17665f = th2;
            this.f17664e = true;
            this.f17661b.b();
        }

        public void onNext(T t11) {
            this.f17662c.offer(t11);
            this.f17661b.b();
        }

        public void onSubscribe(Disposable disposable) {
            this.f17661b.c(disposable, this.f17663d);
        }
    }

    public ObservableSequenceEqualSingle(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2, BiPredicate<? super T, ? super T> biPredicate, int i11) {
        this.f17648b = observableSource;
        this.f17649c = observableSource2;
        this.f17650d = biPredicate;
        this.f17651e = i11;
    }

    public Observable<Boolean> fuseToObservable() {
        return RxJavaPlugins.onAssembly(new ObservableSequenceEqual(this.f17648b, this.f17649c, this.f17650d, this.f17651e));
    }

    public void subscribeActual(SingleObserver<? super Boolean> singleObserver) {
        EqualCoordinator equalCoordinator = new EqualCoordinator(singleObserver, this.f17651e, this.f17648b, this.f17649c, this.f17650d);
        singleObserver.onSubscribe(equalCoordinator);
        equalCoordinator.d();
    }
}
