package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiPredicate;
import io.reactivex.rxjava3.internal.disposables.ArrayCompositeDisposable;
import io.reactivex.rxjava3.operators.SpscLinkedArrayQueue;
import java.util.concurrent.atomic.AtomicInteger;

public final class ObservableSequenceEqual<T> extends Observable<Boolean> {

    /* renamed from: b  reason: collision with root package name */
    public final ObservableSource<? extends T> f22173b;

    /* renamed from: c  reason: collision with root package name */
    public final ObservableSource<? extends T> f22174c;

    /* renamed from: d  reason: collision with root package name */
    public final BiPredicate<? super T, ? super T> f22175d;

    /* renamed from: e  reason: collision with root package name */
    public final int f22176e;

    public static final class EqualCoordinator<T> extends AtomicInteger implements Disposable {
        private static final long serialVersionUID = -6178010334400373240L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super Boolean> f22177b;

        /* renamed from: c  reason: collision with root package name */
        public final BiPredicate<? super T, ? super T> f22178c;

        /* renamed from: d  reason: collision with root package name */
        public final ArrayCompositeDisposable f22179d = new ArrayCompositeDisposable(2);

        /* renamed from: e  reason: collision with root package name */
        public final ObservableSource<? extends T> f22180e;

        /* renamed from: f  reason: collision with root package name */
        public final ObservableSource<? extends T> f22181f;

        /* renamed from: g  reason: collision with root package name */
        public final EqualObserver<T>[] f22182g;

        /* renamed from: h  reason: collision with root package name */
        public volatile boolean f22183h;

        /* renamed from: i  reason: collision with root package name */
        public T f22184i;

        /* renamed from: j  reason: collision with root package name */
        public T f22185j;

        public EqualCoordinator(Observer<? super Boolean> observer, int i11, ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2, BiPredicate<? super T, ? super T> biPredicate) {
            this.f22177b = observer;
            this.f22180e = observableSource;
            this.f22181f = observableSource2;
            this.f22178c = biPredicate;
            EqualObserver<T>[] equalObserverArr = new EqualObserver[2];
            this.f22182g = equalObserverArr;
            equalObserverArr[0] = new EqualObserver<>(this, 0, i11);
            equalObserverArr[1] = new EqualObserver<>(this, 1, i11);
        }

        public void a(SpscLinkedArrayQueue<T> spscLinkedArrayQueue, SpscLinkedArrayQueue<T> spscLinkedArrayQueue2) {
            this.f22183h = true;
            spscLinkedArrayQueue.clear();
            spscLinkedArrayQueue2.clear();
        }

        public void b() {
            boolean z11;
            boolean z12;
            Throwable th2;
            Throwable th3;
            if (getAndIncrement() == 0) {
                EqualObserver<T>[] equalObserverArr = this.f22182g;
                EqualObserver<T> equalObserver = equalObserverArr[0];
                SpscLinkedArrayQueue<T> spscLinkedArrayQueue = equalObserver.f22187c;
                EqualObserver<T> equalObserver2 = equalObserverArr[1];
                SpscLinkedArrayQueue<T> spscLinkedArrayQueue2 = equalObserver2.f22187c;
                int i11 = 1;
                while (!this.f22183h) {
                    boolean z13 = equalObserver.f22189e;
                    if (!z13 || (th3 = equalObserver.f22190f) == null) {
                        boolean z14 = equalObserver2.f22189e;
                        if (!z14 || (th2 = equalObserver2.f22190f) == null) {
                            if (this.f22184i == null) {
                                this.f22184i = spscLinkedArrayQueue.poll();
                            }
                            if (this.f22184i == null) {
                                z11 = true;
                            } else {
                                z11 = false;
                            }
                            if (this.f22185j == null) {
                                this.f22185j = spscLinkedArrayQueue2.poll();
                            }
                            T t11 = this.f22185j;
                            if (t11 == null) {
                                z12 = true;
                            } else {
                                z12 = false;
                            }
                            if (z13 && z14 && z11 && z12) {
                                this.f22177b.onNext(Boolean.TRUE);
                                this.f22177b.onComplete();
                                return;
                            } else if (!z13 || !z14 || z11 == z12) {
                                if (!z11 && !z12) {
                                    try {
                                        if (!this.f22178c.test(this.f22184i, t11)) {
                                            a(spscLinkedArrayQueue, spscLinkedArrayQueue2);
                                            this.f22177b.onNext(Boolean.FALSE);
                                            this.f22177b.onComplete();
                                            return;
                                        }
                                        this.f22184i = null;
                                        this.f22185j = null;
                                    } catch (Throwable th4) {
                                        Exceptions.throwIfFatal(th4);
                                        a(spscLinkedArrayQueue, spscLinkedArrayQueue2);
                                        this.f22177b.onError(th4);
                                        return;
                                    }
                                }
                                if ((z11 || z12) && (i11 = addAndGet(-i11)) == 0) {
                                    return;
                                }
                            } else {
                                a(spscLinkedArrayQueue, spscLinkedArrayQueue2);
                                this.f22177b.onNext(Boolean.FALSE);
                                this.f22177b.onComplete();
                                return;
                            }
                        } else {
                            a(spscLinkedArrayQueue, spscLinkedArrayQueue2);
                            this.f22177b.onError(th2);
                            return;
                        }
                    } else {
                        a(spscLinkedArrayQueue, spscLinkedArrayQueue2);
                        this.f22177b.onError(th3);
                        return;
                    }
                }
                spscLinkedArrayQueue.clear();
                spscLinkedArrayQueue2.clear();
            }
        }

        public boolean c(Disposable disposable, int i11) {
            return this.f22179d.setResource(i11, disposable);
        }

        public void d() {
            EqualObserver<T>[] equalObserverArr = this.f22182g;
            this.f22180e.subscribe(equalObserverArr[0]);
            this.f22181f.subscribe(equalObserverArr[1]);
        }

        public void dispose() {
            if (!this.f22183h) {
                this.f22183h = true;
                this.f22179d.dispose();
                if (getAndIncrement() == 0) {
                    EqualObserver<T>[] equalObserverArr = this.f22182g;
                    equalObserverArr[0].f22187c.clear();
                    equalObserverArr[1].f22187c.clear();
                }
            }
        }

        public boolean isDisposed() {
            return this.f22183h;
        }
    }

    public static final class EqualObserver<T> implements Observer<T> {

        /* renamed from: b  reason: collision with root package name */
        public final EqualCoordinator<T> f22186b;

        /* renamed from: c  reason: collision with root package name */
        public final SpscLinkedArrayQueue<T> f22187c;

        /* renamed from: d  reason: collision with root package name */
        public final int f22188d;

        /* renamed from: e  reason: collision with root package name */
        public volatile boolean f22189e;

        /* renamed from: f  reason: collision with root package name */
        public Throwable f22190f;

        public EqualObserver(EqualCoordinator<T> equalCoordinator, int i11, int i12) {
            this.f22186b = equalCoordinator;
            this.f22188d = i11;
            this.f22187c = new SpscLinkedArrayQueue<>(i12);
        }

        public void onComplete() {
            this.f22189e = true;
            this.f22186b.b();
        }

        public void onError(Throwable th2) {
            this.f22190f = th2;
            this.f22189e = true;
            this.f22186b.b();
        }

        public void onNext(T t11) {
            this.f22187c.offer(t11);
            this.f22186b.b();
        }

        public void onSubscribe(Disposable disposable) {
            this.f22186b.c(disposable, this.f22188d);
        }
    }

    public ObservableSequenceEqual(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2, BiPredicate<? super T, ? super T> biPredicate, int i11) {
        this.f22173b = observableSource;
        this.f22174c = observableSource2;
        this.f22175d = biPredicate;
        this.f22176e = i11;
    }

    public void subscribeActual(Observer<? super Boolean> observer) {
        EqualCoordinator equalCoordinator = new EqualCoordinator(observer, this.f22176e, this.f22173b, this.f22174c, this.f22175d);
        observer.onSubscribe(equalCoordinator);
        equalCoordinator.d();
    }
}
