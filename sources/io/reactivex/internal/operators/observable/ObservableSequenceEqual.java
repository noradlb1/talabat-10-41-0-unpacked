package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiPredicate;
import io.reactivex.internal.disposables.ArrayCompositeDisposable;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import java.util.concurrent.atomic.AtomicInteger;

public final class ObservableSequenceEqual<T> extends Observable<Boolean> {

    /* renamed from: b  reason: collision with root package name */
    public final ObservableSource<? extends T> f17630b;

    /* renamed from: c  reason: collision with root package name */
    public final ObservableSource<? extends T> f17631c;

    /* renamed from: d  reason: collision with root package name */
    public final BiPredicate<? super T, ? super T> f17632d;

    /* renamed from: e  reason: collision with root package name */
    public final int f17633e;

    public static final class EqualCoordinator<T> extends AtomicInteger implements Disposable {
        private static final long serialVersionUID = -6178010334400373240L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super Boolean> f17634b;

        /* renamed from: c  reason: collision with root package name */
        public final BiPredicate<? super T, ? super T> f17635c;

        /* renamed from: d  reason: collision with root package name */
        public final ArrayCompositeDisposable f17636d = new ArrayCompositeDisposable(2);

        /* renamed from: e  reason: collision with root package name */
        public final ObservableSource<? extends T> f17637e;

        /* renamed from: f  reason: collision with root package name */
        public final ObservableSource<? extends T> f17638f;

        /* renamed from: g  reason: collision with root package name */
        public final EqualObserver<T>[] f17639g;

        /* renamed from: h  reason: collision with root package name */
        public volatile boolean f17640h;

        /* renamed from: i  reason: collision with root package name */
        public T f17641i;

        /* renamed from: j  reason: collision with root package name */
        public T f17642j;

        public EqualCoordinator(Observer<? super Boolean> observer, int i11, ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2, BiPredicate<? super T, ? super T> biPredicate) {
            this.f17634b = observer;
            this.f17637e = observableSource;
            this.f17638f = observableSource2;
            this.f17635c = biPredicate;
            EqualObserver<T>[] equalObserverArr = new EqualObserver[2];
            this.f17639g = equalObserverArr;
            equalObserverArr[0] = new EqualObserver<>(this, 0, i11);
            equalObserverArr[1] = new EqualObserver<>(this, 1, i11);
        }

        public void a(SpscLinkedArrayQueue<T> spscLinkedArrayQueue, SpscLinkedArrayQueue<T> spscLinkedArrayQueue2) {
            this.f17640h = true;
            spscLinkedArrayQueue.clear();
            spscLinkedArrayQueue2.clear();
        }

        public void b() {
            boolean z11;
            boolean z12;
            Throwable th2;
            Throwable th3;
            if (getAndIncrement() == 0) {
                EqualObserver<T>[] equalObserverArr = this.f17639g;
                EqualObserver<T> equalObserver = equalObserverArr[0];
                SpscLinkedArrayQueue<T> spscLinkedArrayQueue = equalObserver.f17644c;
                EqualObserver<T> equalObserver2 = equalObserverArr[1];
                SpscLinkedArrayQueue<T> spscLinkedArrayQueue2 = equalObserver2.f17644c;
                int i11 = 1;
                while (!this.f17640h) {
                    boolean z13 = equalObserver.f17646e;
                    if (!z13 || (th3 = equalObserver.f17647f) == null) {
                        boolean z14 = equalObserver2.f17646e;
                        if (!z14 || (th2 = equalObserver2.f17647f) == null) {
                            if (this.f17641i == null) {
                                this.f17641i = spscLinkedArrayQueue.poll();
                            }
                            if (this.f17641i == null) {
                                z11 = true;
                            } else {
                                z11 = false;
                            }
                            if (this.f17642j == null) {
                                this.f17642j = spscLinkedArrayQueue2.poll();
                            }
                            T t11 = this.f17642j;
                            if (t11 == null) {
                                z12 = true;
                            } else {
                                z12 = false;
                            }
                            if (z13 && z14 && z11 && z12) {
                                this.f17634b.onNext(Boolean.TRUE);
                                this.f17634b.onComplete();
                                return;
                            } else if (!z13 || !z14 || z11 == z12) {
                                if (!z11 && !z12) {
                                    try {
                                        if (!this.f17635c.test(this.f17641i, t11)) {
                                            a(spscLinkedArrayQueue, spscLinkedArrayQueue2);
                                            this.f17634b.onNext(Boolean.FALSE);
                                            this.f17634b.onComplete();
                                            return;
                                        }
                                        this.f17641i = null;
                                        this.f17642j = null;
                                    } catch (Throwable th4) {
                                        Exceptions.throwIfFatal(th4);
                                        a(spscLinkedArrayQueue, spscLinkedArrayQueue2);
                                        this.f17634b.onError(th4);
                                        return;
                                    }
                                }
                                if ((z11 || z12) && (i11 = addAndGet(-i11)) == 0) {
                                    return;
                                }
                            } else {
                                a(spscLinkedArrayQueue, spscLinkedArrayQueue2);
                                this.f17634b.onNext(Boolean.FALSE);
                                this.f17634b.onComplete();
                                return;
                            }
                        } else {
                            a(spscLinkedArrayQueue, spscLinkedArrayQueue2);
                            this.f17634b.onError(th2);
                            return;
                        }
                    } else {
                        a(spscLinkedArrayQueue, spscLinkedArrayQueue2);
                        this.f17634b.onError(th3);
                        return;
                    }
                }
                spscLinkedArrayQueue.clear();
                spscLinkedArrayQueue2.clear();
            }
        }

        public boolean c(Disposable disposable, int i11) {
            return this.f17636d.setResource(i11, disposable);
        }

        public void d() {
            EqualObserver<T>[] equalObserverArr = this.f17639g;
            this.f17637e.subscribe(equalObserverArr[0]);
            this.f17638f.subscribe(equalObserverArr[1]);
        }

        public void dispose() {
            if (!this.f17640h) {
                this.f17640h = true;
                this.f17636d.dispose();
                if (getAndIncrement() == 0) {
                    EqualObserver<T>[] equalObserverArr = this.f17639g;
                    equalObserverArr[0].f17644c.clear();
                    equalObserverArr[1].f17644c.clear();
                }
            }
        }

        public boolean isDisposed() {
            return this.f17640h;
        }
    }

    public static final class EqualObserver<T> implements Observer<T> {

        /* renamed from: b  reason: collision with root package name */
        public final EqualCoordinator<T> f17643b;

        /* renamed from: c  reason: collision with root package name */
        public final SpscLinkedArrayQueue<T> f17644c;

        /* renamed from: d  reason: collision with root package name */
        public final int f17645d;

        /* renamed from: e  reason: collision with root package name */
        public volatile boolean f17646e;

        /* renamed from: f  reason: collision with root package name */
        public Throwable f17647f;

        public EqualObserver(EqualCoordinator<T> equalCoordinator, int i11, int i12) {
            this.f17643b = equalCoordinator;
            this.f17645d = i11;
            this.f17644c = new SpscLinkedArrayQueue<>(i12);
        }

        public void onComplete() {
            this.f17646e = true;
            this.f17643b.b();
        }

        public void onError(Throwable th2) {
            this.f17647f = th2;
            this.f17646e = true;
            this.f17643b.b();
        }

        public void onNext(T t11) {
            this.f17644c.offer(t11);
            this.f17643b.b();
        }

        public void onSubscribe(Disposable disposable) {
            this.f17643b.c(disposable, this.f17645d);
        }
    }

    public ObservableSequenceEqual(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2, BiPredicate<? super T, ? super T> biPredicate, int i11) {
        this.f17630b = observableSource;
        this.f17631c = observableSource2;
        this.f17632d = biPredicate;
        this.f17633e = i11;
    }

    public void subscribeActual(Observer<? super Boolean> observer) {
        EqualCoordinator equalCoordinator = new EqualCoordinator(observer, this.f17633e, this.f17630b, this.f17631c, this.f17632d);
        observer.onSubscribe(equalCoordinator);
        equalCoordinator.d();
    }
}
