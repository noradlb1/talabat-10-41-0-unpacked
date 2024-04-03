package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.operators.SpscLinkedArrayQueue;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import io.reactivex.rxjava3.subjects.UnicastSubject;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableGroupJoin<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AbstractObservableWithUpstream<TLeft, R> {

    /* renamed from: c  reason: collision with root package name */
    public final ObservableSource<? extends TRight> f21839c;

    /* renamed from: d  reason: collision with root package name */
    public final Function<? super TLeft, ? extends ObservableSource<TLeftEnd>> f21840d;

    /* renamed from: e  reason: collision with root package name */
    public final Function<? super TRight, ? extends ObservableSource<TRightEnd>> f21841e;

    /* renamed from: f  reason: collision with root package name */
    public final BiFunction<? super TLeft, ? super Observable<TRight>, ? extends R> f21842f;

    public static final class GroupJoinDisposable<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AtomicInteger implements Disposable, JoinSupport {

        /* renamed from: o  reason: collision with root package name */
        public static final Integer f21843o = 1;

        /* renamed from: p  reason: collision with root package name */
        public static final Integer f21844p = 2;

        /* renamed from: q  reason: collision with root package name */
        public static final Integer f21845q = 3;

        /* renamed from: r  reason: collision with root package name */
        public static final Integer f21846r = 4;
        private static final long serialVersionUID = -6071216598687999801L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super R> f21847b;

        /* renamed from: c  reason: collision with root package name */
        public final SpscLinkedArrayQueue<Object> f21848c = new SpscLinkedArrayQueue<>(Observable.bufferSize());

        /* renamed from: d  reason: collision with root package name */
        public final CompositeDisposable f21849d = new CompositeDisposable();

        /* renamed from: e  reason: collision with root package name */
        public final Map<Integer, UnicastSubject<TRight>> f21850e = new LinkedHashMap();

        /* renamed from: f  reason: collision with root package name */
        public final Map<Integer, TRight> f21851f = new LinkedHashMap();

        /* renamed from: g  reason: collision with root package name */
        public final AtomicReference<Throwable> f21852g = new AtomicReference<>();

        /* renamed from: h  reason: collision with root package name */
        public final Function<? super TLeft, ? extends ObservableSource<TLeftEnd>> f21853h;

        /* renamed from: i  reason: collision with root package name */
        public final Function<? super TRight, ? extends ObservableSource<TRightEnd>> f21854i;

        /* renamed from: j  reason: collision with root package name */
        public final BiFunction<? super TLeft, ? super Observable<TRight>, ? extends R> f21855j;

        /* renamed from: k  reason: collision with root package name */
        public final AtomicInteger f21856k;

        /* renamed from: l  reason: collision with root package name */
        public int f21857l;

        /* renamed from: m  reason: collision with root package name */
        public int f21858m;

        /* renamed from: n  reason: collision with root package name */
        public volatile boolean f21859n;

        public GroupJoinDisposable(Observer<? super R> observer, Function<? super TLeft, ? extends ObservableSource<TLeftEnd>> function, Function<? super TRight, ? extends ObservableSource<TRightEnd>> function2, BiFunction<? super TLeft, ? super Observable<TRight>, ? extends R> biFunction) {
            this.f21847b = observer;
            this.f21853h = function;
            this.f21854i = function2;
            this.f21855j = biFunction;
            this.f21856k = new AtomicInteger(2);
        }

        public void a() {
            this.f21849d.dispose();
        }

        public void b() {
            boolean z11;
            boolean z12;
            if (getAndIncrement() == 0) {
                SpscLinkedArrayQueue<Object> spscLinkedArrayQueue = this.f21848c;
                Observer<? super R> observer = this.f21847b;
                int i11 = 1;
                while (!this.f21859n) {
                    if (this.f21852g.get() != null) {
                        spscLinkedArrayQueue.clear();
                        a();
                        c(observer);
                        return;
                    }
                    if (this.f21856k.get() == 0) {
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
                        for (UnicastSubject<TRight> onComplete : this.f21850e.values()) {
                            onComplete.onComplete();
                        }
                        this.f21850e.clear();
                        this.f21851f.clear();
                        this.f21849d.dispose();
                        observer.onComplete();
                        return;
                    } else if (z12) {
                        i11 = addAndGet(-i11);
                        if (i11 == 0) {
                            return;
                        }
                    } else {
                        Object poll = spscLinkedArrayQueue.poll();
                        if (num == f21843o) {
                            UnicastSubject create = UnicastSubject.create();
                            int i12 = this.f21857l;
                            this.f21857l = i12 + 1;
                            this.f21850e.put(Integer.valueOf(i12), create);
                            try {
                                Object apply = this.f21853h.apply(poll);
                                Objects.requireNonNull(apply, "The leftEnd returned a null ObservableSource");
                                ObservableSource observableSource = (ObservableSource) apply;
                                LeftRightEndObserver leftRightEndObserver = new LeftRightEndObserver(this, true, i12);
                                this.f21849d.add(leftRightEndObserver);
                                observableSource.subscribe(leftRightEndObserver);
                                if (this.f21852g.get() != null) {
                                    spscLinkedArrayQueue.clear();
                                    a();
                                    c(observer);
                                    return;
                                }
                                try {
                                    Object apply2 = this.f21855j.apply(poll, create);
                                    Objects.requireNonNull(apply2, "The resultSelector returned a null value");
                                    observer.onNext(apply2);
                                    for (TRight onNext : this.f21851f.values()) {
                                        create.onNext(onNext);
                                    }
                                } catch (Throwable th2) {
                                    d(th2, observer, spscLinkedArrayQueue);
                                    return;
                                }
                            } catch (Throwable th3) {
                                d(th3, observer, spscLinkedArrayQueue);
                                return;
                            }
                        } else if (num == f21844p) {
                            int i13 = this.f21858m;
                            this.f21858m = i13 + 1;
                            this.f21851f.put(Integer.valueOf(i13), poll);
                            try {
                                Object apply3 = this.f21854i.apply(poll);
                                Objects.requireNonNull(apply3, "The rightEnd returned a null ObservableSource");
                                ObservableSource observableSource2 = (ObservableSource) apply3;
                                LeftRightEndObserver leftRightEndObserver2 = new LeftRightEndObserver(this, false, i13);
                                this.f21849d.add(leftRightEndObserver2);
                                observableSource2.subscribe(leftRightEndObserver2);
                                if (this.f21852g.get() != null) {
                                    spscLinkedArrayQueue.clear();
                                    a();
                                    c(observer);
                                    return;
                                }
                                for (UnicastSubject<TRight> onNext2 : this.f21850e.values()) {
                                    onNext2.onNext(poll);
                                }
                            } catch (Throwable th4) {
                                d(th4, observer, spscLinkedArrayQueue);
                                return;
                            }
                        } else if (num == f21845q) {
                            LeftRightEndObserver leftRightEndObserver3 = (LeftRightEndObserver) poll;
                            UnicastSubject remove = this.f21850e.remove(Integer.valueOf(leftRightEndObserver3.f21862d));
                            this.f21849d.remove(leftRightEndObserver3);
                            if (remove != null) {
                                remove.onComplete();
                            }
                        } else {
                            LeftRightEndObserver leftRightEndObserver4 = (LeftRightEndObserver) poll;
                            this.f21851f.remove(Integer.valueOf(leftRightEndObserver4.f21862d));
                            this.f21849d.remove(leftRightEndObserver4);
                        }
                    }
                }
                spscLinkedArrayQueue.clear();
            }
        }

        public void c(Observer<?> observer) {
            Throwable terminate = ExceptionHelper.terminate(this.f21852g);
            for (UnicastSubject<TRight> onError : this.f21850e.values()) {
                onError.onError(terminate);
            }
            this.f21850e.clear();
            this.f21851f.clear();
            observer.onError(terminate);
        }

        public void d(Throwable th2, Observer<?> observer, SpscLinkedArrayQueue<?> spscLinkedArrayQueue) {
            Exceptions.throwIfFatal(th2);
            ExceptionHelper.addThrowable(this.f21852g, th2);
            spscLinkedArrayQueue.clear();
            a();
            c(observer);
        }

        public void dispose() {
            if (!this.f21859n) {
                this.f21859n = true;
                a();
                if (getAndIncrement() == 0) {
                    this.f21848c.clear();
                }
            }
        }

        public void innerClose(boolean z11, LeftRightEndObserver leftRightEndObserver) {
            Integer num;
            synchronized (this) {
                SpscLinkedArrayQueue<Object> spscLinkedArrayQueue = this.f21848c;
                if (z11) {
                    num = f21845q;
                } else {
                    num = f21846r;
                }
                spscLinkedArrayQueue.offer(num, leftRightEndObserver);
            }
            b();
        }

        public void innerCloseError(Throwable th2) {
            if (ExceptionHelper.addThrowable(this.f21852g, th2)) {
                b();
            } else {
                RxJavaPlugins.onError(th2);
            }
        }

        public void innerComplete(LeftRightObserver leftRightObserver) {
            this.f21849d.delete(leftRightObserver);
            this.f21856k.decrementAndGet();
            b();
        }

        public void innerError(Throwable th2) {
            if (ExceptionHelper.addThrowable(this.f21852g, th2)) {
                this.f21856k.decrementAndGet();
                b();
                return;
            }
            RxJavaPlugins.onError(th2);
        }

        public void innerValue(boolean z11, Object obj) {
            Integer num;
            synchronized (this) {
                SpscLinkedArrayQueue<Object> spscLinkedArrayQueue = this.f21848c;
                if (z11) {
                    num = f21843o;
                } else {
                    num = f21844p;
                }
                spscLinkedArrayQueue.offer(num, obj);
            }
            b();
        }

        public boolean isDisposed() {
            return this.f21859n;
        }
    }

    public interface JoinSupport {
        void innerClose(boolean z11, LeftRightEndObserver leftRightEndObserver);

        void innerCloseError(Throwable th2);

        void innerComplete(LeftRightObserver leftRightObserver);

        void innerError(Throwable th2);

        void innerValue(boolean z11, Object obj);
    }

    public static final class LeftRightEndObserver extends AtomicReference<Disposable> implements Observer<Object>, Disposable {
        private static final long serialVersionUID = 1883890389173668373L;

        /* renamed from: b  reason: collision with root package name */
        public final JoinSupport f21860b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f21861c;

        /* renamed from: d  reason: collision with root package name */
        public final int f21862d;

        public LeftRightEndObserver(JoinSupport joinSupport, boolean z11, int i11) {
            this.f21860b = joinSupport;
            this.f21861c = z11;
            this.f21862d = i11;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        public void onComplete() {
            this.f21860b.innerClose(this.f21861c, this);
        }

        public void onError(Throwable th2) {
            this.f21860b.innerCloseError(th2);
        }

        public void onNext(Object obj) {
            if (DisposableHelper.dispose(this)) {
                this.f21860b.innerClose(this.f21861c, this);
            }
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this, disposable);
        }
    }

    public static final class LeftRightObserver extends AtomicReference<Disposable> implements Observer<Object>, Disposable {
        private static final long serialVersionUID = 1883890389173668373L;

        /* renamed from: b  reason: collision with root package name */
        public final JoinSupport f21863b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f21864c;

        public LeftRightObserver(JoinSupport joinSupport, boolean z11) {
            this.f21863b = joinSupport;
            this.f21864c = z11;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        public void onComplete() {
            this.f21863b.innerComplete(this);
        }

        public void onError(Throwable th2) {
            this.f21863b.innerError(th2);
        }

        public void onNext(Object obj) {
            this.f21863b.innerValue(this.f21864c, obj);
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this, disposable);
        }
    }

    public ObservableGroupJoin(ObservableSource<TLeft> observableSource, ObservableSource<? extends TRight> observableSource2, Function<? super TLeft, ? extends ObservableSource<TLeftEnd>> function, Function<? super TRight, ? extends ObservableSource<TRightEnd>> function2, BiFunction<? super TLeft, ? super Observable<TRight>, ? extends R> biFunction) {
        super(observableSource);
        this.f21839c = observableSource2;
        this.f21840d = function;
        this.f21841e = function2;
        this.f21842f = biFunction;
    }

    public void subscribeActual(Observer<? super R> observer) {
        GroupJoinDisposable groupJoinDisposable = new GroupJoinDisposable(observer, this.f21840d, this.f21841e, this.f21842f);
        observer.onSubscribe(groupJoinDisposable);
        LeftRightObserver leftRightObserver = new LeftRightObserver(groupJoinDisposable, true);
        groupJoinDisposable.f21849d.add(leftRightObserver);
        LeftRightObserver leftRightObserver2 = new LeftRightObserver(groupJoinDisposable, false);
        groupJoinDisposable.f21849d.add(leftRightObserver2);
        this.f21304b.subscribe(leftRightObserver);
        this.f21839c.subscribe(leftRightObserver2);
    }
}
