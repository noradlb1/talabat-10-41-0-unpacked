package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.observable.ObservableGroupJoin;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableJoin<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AbstractObservableWithUpstream<TLeft, R> {

    /* renamed from: c  reason: collision with root package name */
    public final ObservableSource<? extends TRight> f17361c;

    /* renamed from: d  reason: collision with root package name */
    public final Function<? super TLeft, ? extends ObservableSource<TLeftEnd>> f17362d;

    /* renamed from: e  reason: collision with root package name */
    public final Function<? super TRight, ? extends ObservableSource<TRightEnd>> f17363e;

    /* renamed from: f  reason: collision with root package name */
    public final BiFunction<? super TLeft, ? super TRight, ? extends R> f17364f;

    public static final class JoinDisposable<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AtomicInteger implements Disposable, ObservableGroupJoin.JoinSupport {

        /* renamed from: o  reason: collision with root package name */
        public static final Integer f17365o = 1;

        /* renamed from: p  reason: collision with root package name */
        public static final Integer f17366p = 2;

        /* renamed from: q  reason: collision with root package name */
        public static final Integer f17367q = 3;

        /* renamed from: r  reason: collision with root package name */
        public static final Integer f17368r = 4;
        private static final long serialVersionUID = -6071216598687999801L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super R> f17369b;

        /* renamed from: c  reason: collision with root package name */
        public final SpscLinkedArrayQueue<Object> f17370c = new SpscLinkedArrayQueue<>(Observable.bufferSize());

        /* renamed from: d  reason: collision with root package name */
        public final CompositeDisposable f17371d = new CompositeDisposable();

        /* renamed from: e  reason: collision with root package name */
        public final Map<Integer, TLeft> f17372e = new LinkedHashMap();

        /* renamed from: f  reason: collision with root package name */
        public final Map<Integer, TRight> f17373f = new LinkedHashMap();

        /* renamed from: g  reason: collision with root package name */
        public final AtomicReference<Throwable> f17374g = new AtomicReference<>();

        /* renamed from: h  reason: collision with root package name */
        public final Function<? super TLeft, ? extends ObservableSource<TLeftEnd>> f17375h;

        /* renamed from: i  reason: collision with root package name */
        public final Function<? super TRight, ? extends ObservableSource<TRightEnd>> f17376i;

        /* renamed from: j  reason: collision with root package name */
        public final BiFunction<? super TLeft, ? super TRight, ? extends R> f17377j;

        /* renamed from: k  reason: collision with root package name */
        public final AtomicInteger f17378k;

        /* renamed from: l  reason: collision with root package name */
        public int f17379l;

        /* renamed from: m  reason: collision with root package name */
        public int f17380m;

        /* renamed from: n  reason: collision with root package name */
        public volatile boolean f17381n;

        public JoinDisposable(Observer<? super R> observer, Function<? super TLeft, ? extends ObservableSource<TLeftEnd>> function, Function<? super TRight, ? extends ObservableSource<TRightEnd>> function2, BiFunction<? super TLeft, ? super TRight, ? extends R> biFunction) {
            this.f17369b = observer;
            this.f17375h = function;
            this.f17376i = function2;
            this.f17377j = biFunction;
            this.f17378k = new AtomicInteger(2);
        }

        public void a() {
            this.f17371d.dispose();
        }

        public void b() {
            boolean z11;
            boolean z12;
            if (getAndIncrement() == 0) {
                SpscLinkedArrayQueue<Object> spscLinkedArrayQueue = this.f17370c;
                Observer<? super R> observer = this.f17369b;
                int i11 = 1;
                while (!this.f17381n) {
                    if (this.f17374g.get() != null) {
                        spscLinkedArrayQueue.clear();
                        a();
                        c(observer);
                        return;
                    }
                    if (this.f17378k.get() == 0) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    Integer num = (Integer) spscLinkedArrayQueue.poll();
                    if (num == null) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    if (z11 && z12) {
                        this.f17372e.clear();
                        this.f17373f.clear();
                        this.f17371d.dispose();
                        observer.onComplete();
                        return;
                    } else if (z12) {
                        i11 = addAndGet(-i11);
                        if (i11 == 0) {
                            return;
                        }
                    } else {
                        Object poll = spscLinkedArrayQueue.poll();
                        if (num == f17365o) {
                            int i12 = this.f17379l;
                            this.f17379l = i12 + 1;
                            this.f17372e.put(Integer.valueOf(i12), poll);
                            try {
                                ObservableSource observableSource = (ObservableSource) ObjectHelper.requireNonNull(this.f17375h.apply(poll), "The leftEnd returned a null ObservableSource");
                                ObservableGroupJoin.LeftRightEndObserver leftRightEndObserver = new ObservableGroupJoin.LeftRightEndObserver(this, true, i12);
                                this.f17371d.add(leftRightEndObserver);
                                observableSource.subscribe(leftRightEndObserver);
                                if (this.f17374g.get() != null) {
                                    spscLinkedArrayQueue.clear();
                                    a();
                                    c(observer);
                                    return;
                                }
                                for (TRight apply : this.f17373f.values()) {
                                    try {
                                        observer.onNext(ObjectHelper.requireNonNull(this.f17377j.apply(poll, apply), "The resultSelector returned a null value"));
                                    } catch (Throwable th2) {
                                        d(th2, observer, spscLinkedArrayQueue);
                                        return;
                                    }
                                }
                            } catch (Throwable th3) {
                                d(th3, observer, spscLinkedArrayQueue);
                                return;
                            }
                        } else if (num == f17366p) {
                            int i13 = this.f17380m;
                            this.f17380m = i13 + 1;
                            this.f17373f.put(Integer.valueOf(i13), poll);
                            try {
                                ObservableSource observableSource2 = (ObservableSource) ObjectHelper.requireNonNull(this.f17376i.apply(poll), "The rightEnd returned a null ObservableSource");
                                ObservableGroupJoin.LeftRightEndObserver leftRightEndObserver2 = new ObservableGroupJoin.LeftRightEndObserver(this, false, i13);
                                this.f17371d.add(leftRightEndObserver2);
                                observableSource2.subscribe(leftRightEndObserver2);
                                if (this.f17374g.get() != null) {
                                    spscLinkedArrayQueue.clear();
                                    a();
                                    c(observer);
                                    return;
                                }
                                for (TLeft apply2 : this.f17372e.values()) {
                                    try {
                                        observer.onNext(ObjectHelper.requireNonNull(this.f17377j.apply(apply2, poll), "The resultSelector returned a null value"));
                                    } catch (Throwable th4) {
                                        d(th4, observer, spscLinkedArrayQueue);
                                        return;
                                    }
                                }
                            } catch (Throwable th5) {
                                d(th5, observer, spscLinkedArrayQueue);
                                return;
                            }
                        } else if (num == f17367q) {
                            ObservableGroupJoin.LeftRightEndObserver leftRightEndObserver3 = (ObservableGroupJoin.LeftRightEndObserver) poll;
                            this.f17372e.remove(Integer.valueOf(leftRightEndObserver3.f17329d));
                            this.f17371d.remove(leftRightEndObserver3);
                        } else {
                            ObservableGroupJoin.LeftRightEndObserver leftRightEndObserver4 = (ObservableGroupJoin.LeftRightEndObserver) poll;
                            this.f17373f.remove(Integer.valueOf(leftRightEndObserver4.f17329d));
                            this.f17371d.remove(leftRightEndObserver4);
                        }
                    }
                }
                spscLinkedArrayQueue.clear();
            }
        }

        public void c(Observer<?> observer) {
            Throwable terminate = ExceptionHelper.terminate(this.f17374g);
            this.f17372e.clear();
            this.f17373f.clear();
            observer.onError(terminate);
        }

        public void d(Throwable th2, Observer<?> observer, SpscLinkedArrayQueue<?> spscLinkedArrayQueue) {
            Exceptions.throwIfFatal(th2);
            ExceptionHelper.addThrowable(this.f17374g, th2);
            spscLinkedArrayQueue.clear();
            a();
            c(observer);
        }

        public void dispose() {
            if (!this.f17381n) {
                this.f17381n = true;
                a();
                if (getAndIncrement() == 0) {
                    this.f17370c.clear();
                }
            }
        }

        public void innerClose(boolean z11, ObservableGroupJoin.LeftRightEndObserver leftRightEndObserver) {
            Integer num;
            synchronized (this) {
                SpscLinkedArrayQueue<Object> spscLinkedArrayQueue = this.f17370c;
                if (z11) {
                    num = f17367q;
                } else {
                    num = f17368r;
                }
                spscLinkedArrayQueue.offer(num, leftRightEndObserver);
            }
            b();
        }

        public void innerCloseError(Throwable th2) {
            if (ExceptionHelper.addThrowable(this.f17374g, th2)) {
                b();
            } else {
                RxJavaPlugins.onError(th2);
            }
        }

        public void innerComplete(ObservableGroupJoin.LeftRightObserver leftRightObserver) {
            this.f17371d.delete(leftRightObserver);
            this.f17378k.decrementAndGet();
            b();
        }

        public void innerError(Throwable th2) {
            if (ExceptionHelper.addThrowable(this.f17374g, th2)) {
                this.f17378k.decrementAndGet();
                b();
                return;
            }
            RxJavaPlugins.onError(th2);
        }

        public void innerValue(boolean z11, Object obj) {
            Integer num;
            synchronized (this) {
                SpscLinkedArrayQueue<Object> spscLinkedArrayQueue = this.f17370c;
                if (z11) {
                    num = f17365o;
                } else {
                    num = f17366p;
                }
                spscLinkedArrayQueue.offer(num, obj);
            }
            b();
        }

        public boolean isDisposed() {
            return this.f17381n;
        }
    }

    public ObservableJoin(ObservableSource<TLeft> observableSource, ObservableSource<? extends TRight> observableSource2, Function<? super TLeft, ? extends ObservableSource<TLeftEnd>> function, Function<? super TRight, ? extends ObservableSource<TRightEnd>> function2, BiFunction<? super TLeft, ? super TRight, ? extends R> biFunction) {
        super(observableSource);
        this.f17361c = observableSource2;
        this.f17362d = function;
        this.f17363e = function2;
        this.f17364f = biFunction;
    }

    public void subscribeActual(Observer<? super R> observer) {
        JoinDisposable joinDisposable = new JoinDisposable(observer, this.f17362d, this.f17363e, this.f17364f);
        observer.onSubscribe(joinDisposable);
        ObservableGroupJoin.LeftRightObserver leftRightObserver = new ObservableGroupJoin.LeftRightObserver(joinDisposable, true);
        joinDisposable.f17371d.add(leftRightObserver);
        ObservableGroupJoin.LeftRightObserver leftRightObserver2 = new ObservableGroupJoin.LeftRightObserver(joinDisposable, false);
        joinDisposable.f17371d.add(leftRightObserver2);
        this.f16799b.subscribe(leftRightObserver);
        this.f17361c.subscribe(leftRightObserver2);
    }
}
