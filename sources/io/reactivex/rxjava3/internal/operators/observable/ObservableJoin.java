package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.operators.observable.ObservableGroupJoin;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.operators.SpscLinkedArrayQueue;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableJoin<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AbstractObservableWithUpstream<TLeft, R> {

    /* renamed from: c  reason: collision with root package name */
    public final ObservableSource<? extends TRight> f21908c;

    /* renamed from: d  reason: collision with root package name */
    public final Function<? super TLeft, ? extends ObservableSource<TLeftEnd>> f21909d;

    /* renamed from: e  reason: collision with root package name */
    public final Function<? super TRight, ? extends ObservableSource<TRightEnd>> f21910e;

    /* renamed from: f  reason: collision with root package name */
    public final BiFunction<? super TLeft, ? super TRight, ? extends R> f21911f;

    public static final class JoinDisposable<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AtomicInteger implements Disposable, ObservableGroupJoin.JoinSupport {

        /* renamed from: o  reason: collision with root package name */
        public static final Integer f21912o = 1;

        /* renamed from: p  reason: collision with root package name */
        public static final Integer f21913p = 2;

        /* renamed from: q  reason: collision with root package name */
        public static final Integer f21914q = 3;

        /* renamed from: r  reason: collision with root package name */
        public static final Integer f21915r = 4;
        private static final long serialVersionUID = -6071216598687999801L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super R> f21916b;

        /* renamed from: c  reason: collision with root package name */
        public final SpscLinkedArrayQueue<Object> f21917c = new SpscLinkedArrayQueue<>(Observable.bufferSize());

        /* renamed from: d  reason: collision with root package name */
        public final CompositeDisposable f21918d = new CompositeDisposable();

        /* renamed from: e  reason: collision with root package name */
        public final Map<Integer, TLeft> f21919e = new LinkedHashMap();

        /* renamed from: f  reason: collision with root package name */
        public final Map<Integer, TRight> f21920f = new LinkedHashMap();

        /* renamed from: g  reason: collision with root package name */
        public final AtomicReference<Throwable> f21921g = new AtomicReference<>();

        /* renamed from: h  reason: collision with root package name */
        public final Function<? super TLeft, ? extends ObservableSource<TLeftEnd>> f21922h;

        /* renamed from: i  reason: collision with root package name */
        public final Function<? super TRight, ? extends ObservableSource<TRightEnd>> f21923i;

        /* renamed from: j  reason: collision with root package name */
        public final BiFunction<? super TLeft, ? super TRight, ? extends R> f21924j;

        /* renamed from: k  reason: collision with root package name */
        public final AtomicInteger f21925k;

        /* renamed from: l  reason: collision with root package name */
        public int f21926l;

        /* renamed from: m  reason: collision with root package name */
        public int f21927m;

        /* renamed from: n  reason: collision with root package name */
        public volatile boolean f21928n;

        public JoinDisposable(Observer<? super R> observer, Function<? super TLeft, ? extends ObservableSource<TLeftEnd>> function, Function<? super TRight, ? extends ObservableSource<TRightEnd>> function2, BiFunction<? super TLeft, ? super TRight, ? extends R> biFunction) {
            this.f21916b = observer;
            this.f21922h = function;
            this.f21923i = function2;
            this.f21924j = biFunction;
            this.f21925k = new AtomicInteger(2);
        }

        public void a() {
            this.f21918d.dispose();
        }

        public void b() {
            boolean z11;
            boolean z12;
            if (getAndIncrement() == 0) {
                SpscLinkedArrayQueue<Object> spscLinkedArrayQueue = this.f21917c;
                Observer<? super R> observer = this.f21916b;
                int i11 = 1;
                while (!this.f21928n) {
                    if (this.f21921g.get() != null) {
                        spscLinkedArrayQueue.clear();
                        a();
                        c(observer);
                        return;
                    }
                    if (this.f21925k.get() == 0) {
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
                        this.f21919e.clear();
                        this.f21920f.clear();
                        this.f21918d.dispose();
                        observer.onComplete();
                        return;
                    } else if (z12) {
                        i11 = addAndGet(-i11);
                        if (i11 == 0) {
                            return;
                        }
                    } else {
                        Object poll = spscLinkedArrayQueue.poll();
                        if (num == f21912o) {
                            int i12 = this.f21926l;
                            this.f21926l = i12 + 1;
                            this.f21919e.put(Integer.valueOf(i12), poll);
                            try {
                                Object apply = this.f21922h.apply(poll);
                                Objects.requireNonNull(apply, "The leftEnd returned a null ObservableSource");
                                ObservableSource observableSource = (ObservableSource) apply;
                                ObservableGroupJoin.LeftRightEndObserver leftRightEndObserver = new ObservableGroupJoin.LeftRightEndObserver(this, true, i12);
                                this.f21918d.add(leftRightEndObserver);
                                observableSource.subscribe(leftRightEndObserver);
                                if (this.f21921g.get() != null) {
                                    spscLinkedArrayQueue.clear();
                                    a();
                                    c(observer);
                                    return;
                                }
                                for (TRight apply2 : this.f21920f.values()) {
                                    try {
                                        Object apply3 = this.f21924j.apply(poll, apply2);
                                        Objects.requireNonNull(apply3, "The resultSelector returned a null value");
                                        observer.onNext(apply3);
                                    } catch (Throwable th2) {
                                        d(th2, observer, spscLinkedArrayQueue);
                                        return;
                                    }
                                }
                            } catch (Throwable th3) {
                                d(th3, observer, spscLinkedArrayQueue);
                                return;
                            }
                        } else if (num == f21913p) {
                            int i13 = this.f21927m;
                            this.f21927m = i13 + 1;
                            this.f21920f.put(Integer.valueOf(i13), poll);
                            try {
                                Object apply4 = this.f21923i.apply(poll);
                                Objects.requireNonNull(apply4, "The rightEnd returned a null ObservableSource");
                                ObservableSource observableSource2 = (ObservableSource) apply4;
                                ObservableGroupJoin.LeftRightEndObserver leftRightEndObserver2 = new ObservableGroupJoin.LeftRightEndObserver(this, false, i13);
                                this.f21918d.add(leftRightEndObserver2);
                                observableSource2.subscribe(leftRightEndObserver2);
                                if (this.f21921g.get() != null) {
                                    spscLinkedArrayQueue.clear();
                                    a();
                                    c(observer);
                                    return;
                                }
                                for (TLeft apply5 : this.f21919e.values()) {
                                    try {
                                        Object apply6 = this.f21924j.apply(apply5, poll);
                                        Objects.requireNonNull(apply6, "The resultSelector returned a null value");
                                        observer.onNext(apply6);
                                    } catch (Throwable th4) {
                                        d(th4, observer, spscLinkedArrayQueue);
                                        return;
                                    }
                                }
                            } catch (Throwable th5) {
                                d(th5, observer, spscLinkedArrayQueue);
                                return;
                            }
                        } else if (num == f21914q) {
                            ObservableGroupJoin.LeftRightEndObserver leftRightEndObserver3 = (ObservableGroupJoin.LeftRightEndObserver) poll;
                            this.f21919e.remove(Integer.valueOf(leftRightEndObserver3.f21862d));
                            this.f21918d.remove(leftRightEndObserver3);
                        } else {
                            ObservableGroupJoin.LeftRightEndObserver leftRightEndObserver4 = (ObservableGroupJoin.LeftRightEndObserver) poll;
                            this.f21920f.remove(Integer.valueOf(leftRightEndObserver4.f21862d));
                            this.f21918d.remove(leftRightEndObserver4);
                        }
                    }
                }
                spscLinkedArrayQueue.clear();
            }
        }

        public void c(Observer<?> observer) {
            Throwable terminate = ExceptionHelper.terminate(this.f21921g);
            this.f21919e.clear();
            this.f21920f.clear();
            observer.onError(terminate);
        }

        public void d(Throwable th2, Observer<?> observer, SpscLinkedArrayQueue<?> spscLinkedArrayQueue) {
            Exceptions.throwIfFatal(th2);
            ExceptionHelper.addThrowable(this.f21921g, th2);
            spscLinkedArrayQueue.clear();
            a();
            c(observer);
        }

        public void dispose() {
            if (!this.f21928n) {
                this.f21928n = true;
                a();
                if (getAndIncrement() == 0) {
                    this.f21917c.clear();
                }
            }
        }

        public void innerClose(boolean z11, ObservableGroupJoin.LeftRightEndObserver leftRightEndObserver) {
            Integer num;
            synchronized (this) {
                SpscLinkedArrayQueue<Object> spscLinkedArrayQueue = this.f21917c;
                if (z11) {
                    num = f21914q;
                } else {
                    num = f21915r;
                }
                spscLinkedArrayQueue.offer(num, leftRightEndObserver);
            }
            b();
        }

        public void innerCloseError(Throwable th2) {
            if (ExceptionHelper.addThrowable(this.f21921g, th2)) {
                b();
            } else {
                RxJavaPlugins.onError(th2);
            }
        }

        public void innerComplete(ObservableGroupJoin.LeftRightObserver leftRightObserver) {
            this.f21918d.delete(leftRightObserver);
            this.f21925k.decrementAndGet();
            b();
        }

        public void innerError(Throwable th2) {
            if (ExceptionHelper.addThrowable(this.f21921g, th2)) {
                this.f21925k.decrementAndGet();
                b();
                return;
            }
            RxJavaPlugins.onError(th2);
        }

        public void innerValue(boolean z11, Object obj) {
            Integer num;
            synchronized (this) {
                SpscLinkedArrayQueue<Object> spscLinkedArrayQueue = this.f21917c;
                if (z11) {
                    num = f21912o;
                } else {
                    num = f21913p;
                }
                spscLinkedArrayQueue.offer(num, obj);
            }
            b();
        }

        public boolean isDisposed() {
            return this.f21928n;
        }
    }

    public ObservableJoin(ObservableSource<TLeft> observableSource, ObservableSource<? extends TRight> observableSource2, Function<? super TLeft, ? extends ObservableSource<TLeftEnd>> function, Function<? super TRight, ? extends ObservableSource<TRightEnd>> function2, BiFunction<? super TLeft, ? super TRight, ? extends R> biFunction) {
        super(observableSource);
        this.f21908c = observableSource2;
        this.f21909d = function;
        this.f21910e = function2;
        this.f21911f = biFunction;
    }

    public void subscribeActual(Observer<? super R> observer) {
        JoinDisposable joinDisposable = new JoinDisposable(observer, this.f21909d, this.f21910e, this.f21911f);
        observer.onSubscribe(joinDisposable);
        ObservableGroupJoin.LeftRightObserver leftRightObserver = new ObservableGroupJoin.LeftRightObserver(joinDisposable, true);
        joinDisposable.f21918d.add(leftRightObserver);
        ObservableGroupJoin.LeftRightObserver leftRightObserver2 = new ObservableGroupJoin.LeftRightObserver(joinDisposable, false);
        joinDisposable.f21918d.add(leftRightObserver2);
        this.f21304b.subscribe(leftRightObserver);
        this.f21908c.subscribe(leftRightObserver2);
    }
}
