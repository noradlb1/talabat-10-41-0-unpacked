package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.subjects.UnicastSubject;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableGroupJoin<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AbstractObservableWithUpstream<TLeft, R> {

    /* renamed from: c  reason: collision with root package name */
    public final ObservableSource<? extends TRight> f17306c;

    /* renamed from: d  reason: collision with root package name */
    public final Function<? super TLeft, ? extends ObservableSource<TLeftEnd>> f17307d;

    /* renamed from: e  reason: collision with root package name */
    public final Function<? super TRight, ? extends ObservableSource<TRightEnd>> f17308e;

    /* renamed from: f  reason: collision with root package name */
    public final BiFunction<? super TLeft, ? super Observable<TRight>, ? extends R> f17309f;

    public static final class GroupJoinDisposable<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AtomicInteger implements Disposable, JoinSupport {

        /* renamed from: o  reason: collision with root package name */
        public static final Integer f17310o = 1;

        /* renamed from: p  reason: collision with root package name */
        public static final Integer f17311p = 2;

        /* renamed from: q  reason: collision with root package name */
        public static final Integer f17312q = 3;

        /* renamed from: r  reason: collision with root package name */
        public static final Integer f17313r = 4;
        private static final long serialVersionUID = -6071216598687999801L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super R> f17314b;

        /* renamed from: c  reason: collision with root package name */
        public final SpscLinkedArrayQueue<Object> f17315c = new SpscLinkedArrayQueue<>(Observable.bufferSize());

        /* renamed from: d  reason: collision with root package name */
        public final CompositeDisposable f17316d = new CompositeDisposable();

        /* renamed from: e  reason: collision with root package name */
        public final Map<Integer, UnicastSubject<TRight>> f17317e = new LinkedHashMap();

        /* renamed from: f  reason: collision with root package name */
        public final Map<Integer, TRight> f17318f = new LinkedHashMap();

        /* renamed from: g  reason: collision with root package name */
        public final AtomicReference<Throwable> f17319g = new AtomicReference<>();

        /* renamed from: h  reason: collision with root package name */
        public final Function<? super TLeft, ? extends ObservableSource<TLeftEnd>> f17320h;

        /* renamed from: i  reason: collision with root package name */
        public final Function<? super TRight, ? extends ObservableSource<TRightEnd>> f17321i;

        /* renamed from: j  reason: collision with root package name */
        public final BiFunction<? super TLeft, ? super Observable<TRight>, ? extends R> f17322j;

        /* renamed from: k  reason: collision with root package name */
        public final AtomicInteger f17323k;

        /* renamed from: l  reason: collision with root package name */
        public int f17324l;

        /* renamed from: m  reason: collision with root package name */
        public int f17325m;

        /* renamed from: n  reason: collision with root package name */
        public volatile boolean f17326n;

        public GroupJoinDisposable(Observer<? super R> observer, Function<? super TLeft, ? extends ObservableSource<TLeftEnd>> function, Function<? super TRight, ? extends ObservableSource<TRightEnd>> function2, BiFunction<? super TLeft, ? super Observable<TRight>, ? extends R> biFunction) {
            this.f17314b = observer;
            this.f17320h = function;
            this.f17321i = function2;
            this.f17322j = biFunction;
            this.f17323k = new AtomicInteger(2);
        }

        public void a() {
            this.f17316d.dispose();
        }

        public void b() {
            boolean z11;
            boolean z12;
            if (getAndIncrement() == 0) {
                SpscLinkedArrayQueue<Object> spscLinkedArrayQueue = this.f17315c;
                Observer<? super R> observer = this.f17314b;
                int i11 = 1;
                while (!this.f17326n) {
                    if (this.f17319g.get() != null) {
                        spscLinkedArrayQueue.clear();
                        a();
                        c(observer);
                        return;
                    }
                    if (this.f17323k.get() == 0) {
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
                        for (UnicastSubject<TRight> onComplete : this.f17317e.values()) {
                            onComplete.onComplete();
                        }
                        this.f17317e.clear();
                        this.f17318f.clear();
                        this.f17316d.dispose();
                        observer.onComplete();
                        return;
                    } else if (z12) {
                        i11 = addAndGet(-i11);
                        if (i11 == 0) {
                            return;
                        }
                    } else {
                        Object poll = spscLinkedArrayQueue.poll();
                        if (num == f17310o) {
                            UnicastSubject create = UnicastSubject.create();
                            int i12 = this.f17324l;
                            this.f17324l = i12 + 1;
                            this.f17317e.put(Integer.valueOf(i12), create);
                            try {
                                ObservableSource observableSource = (ObservableSource) ObjectHelper.requireNonNull(this.f17320h.apply(poll), "The leftEnd returned a null ObservableSource");
                                LeftRightEndObserver leftRightEndObserver = new LeftRightEndObserver(this, true, i12);
                                this.f17316d.add(leftRightEndObserver);
                                observableSource.subscribe(leftRightEndObserver);
                                if (this.f17319g.get() != null) {
                                    spscLinkedArrayQueue.clear();
                                    a();
                                    c(observer);
                                    return;
                                }
                                try {
                                    observer.onNext(ObjectHelper.requireNonNull(this.f17322j.apply(poll, create), "The resultSelector returned a null value"));
                                    for (TRight onNext : this.f17318f.values()) {
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
                        } else if (num == f17311p) {
                            int i13 = this.f17325m;
                            this.f17325m = i13 + 1;
                            this.f17318f.put(Integer.valueOf(i13), poll);
                            try {
                                ObservableSource observableSource2 = (ObservableSource) ObjectHelper.requireNonNull(this.f17321i.apply(poll), "The rightEnd returned a null ObservableSource");
                                LeftRightEndObserver leftRightEndObserver2 = new LeftRightEndObserver(this, false, i13);
                                this.f17316d.add(leftRightEndObserver2);
                                observableSource2.subscribe(leftRightEndObserver2);
                                if (this.f17319g.get() != null) {
                                    spscLinkedArrayQueue.clear();
                                    a();
                                    c(observer);
                                    return;
                                }
                                for (UnicastSubject<TRight> onNext2 : this.f17317e.values()) {
                                    onNext2.onNext(poll);
                                }
                            } catch (Throwable th4) {
                                d(th4, observer, spscLinkedArrayQueue);
                                return;
                            }
                        } else if (num == f17312q) {
                            LeftRightEndObserver leftRightEndObserver3 = (LeftRightEndObserver) poll;
                            UnicastSubject remove = this.f17317e.remove(Integer.valueOf(leftRightEndObserver3.f17329d));
                            this.f17316d.remove(leftRightEndObserver3);
                            if (remove != null) {
                                remove.onComplete();
                            }
                        } else if (num == f17313r) {
                            LeftRightEndObserver leftRightEndObserver4 = (LeftRightEndObserver) poll;
                            this.f17318f.remove(Integer.valueOf(leftRightEndObserver4.f17329d));
                            this.f17316d.remove(leftRightEndObserver4);
                        }
                    }
                }
                spscLinkedArrayQueue.clear();
            }
        }

        public void c(Observer<?> observer) {
            Throwable terminate = ExceptionHelper.terminate(this.f17319g);
            for (UnicastSubject<TRight> onError : this.f17317e.values()) {
                onError.onError(terminate);
            }
            this.f17317e.clear();
            this.f17318f.clear();
            observer.onError(terminate);
        }

        public void d(Throwable th2, Observer<?> observer, SpscLinkedArrayQueue<?> spscLinkedArrayQueue) {
            Exceptions.throwIfFatal(th2);
            ExceptionHelper.addThrowable(this.f17319g, th2);
            spscLinkedArrayQueue.clear();
            a();
            c(observer);
        }

        public void dispose() {
            if (!this.f17326n) {
                this.f17326n = true;
                a();
                if (getAndIncrement() == 0) {
                    this.f17315c.clear();
                }
            }
        }

        public void innerClose(boolean z11, LeftRightEndObserver leftRightEndObserver) {
            Integer num;
            synchronized (this) {
                SpscLinkedArrayQueue<Object> spscLinkedArrayQueue = this.f17315c;
                if (z11) {
                    num = f17312q;
                } else {
                    num = f17313r;
                }
                spscLinkedArrayQueue.offer(num, leftRightEndObserver);
            }
            b();
        }

        public void innerCloseError(Throwable th2) {
            if (ExceptionHelper.addThrowable(this.f17319g, th2)) {
                b();
            } else {
                RxJavaPlugins.onError(th2);
            }
        }

        public void innerComplete(LeftRightObserver leftRightObserver) {
            this.f17316d.delete(leftRightObserver);
            this.f17323k.decrementAndGet();
            b();
        }

        public void innerError(Throwable th2) {
            if (ExceptionHelper.addThrowable(this.f17319g, th2)) {
                this.f17323k.decrementAndGet();
                b();
                return;
            }
            RxJavaPlugins.onError(th2);
        }

        public void innerValue(boolean z11, Object obj) {
            Integer num;
            synchronized (this) {
                SpscLinkedArrayQueue<Object> spscLinkedArrayQueue = this.f17315c;
                if (z11) {
                    num = f17310o;
                } else {
                    num = f17311p;
                }
                spscLinkedArrayQueue.offer(num, obj);
            }
            b();
        }

        public boolean isDisposed() {
            return this.f17326n;
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
        public final JoinSupport f17327b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f17328c;

        /* renamed from: d  reason: collision with root package name */
        public final int f17329d;

        public LeftRightEndObserver(JoinSupport joinSupport, boolean z11, int i11) {
            this.f17327b = joinSupport;
            this.f17328c = z11;
            this.f17329d = i11;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        public void onComplete() {
            this.f17327b.innerClose(this.f17328c, this);
        }

        public void onError(Throwable th2) {
            this.f17327b.innerCloseError(th2);
        }

        public void onNext(Object obj) {
            if (DisposableHelper.dispose(this)) {
                this.f17327b.innerClose(this.f17328c, this);
            }
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this, disposable);
        }
    }

    public static final class LeftRightObserver extends AtomicReference<Disposable> implements Observer<Object>, Disposable {
        private static final long serialVersionUID = 1883890389173668373L;

        /* renamed from: b  reason: collision with root package name */
        public final JoinSupport f17330b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f17331c;

        public LeftRightObserver(JoinSupport joinSupport, boolean z11) {
            this.f17330b = joinSupport;
            this.f17331c = z11;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        public void onComplete() {
            this.f17330b.innerComplete(this);
        }

        public void onError(Throwable th2) {
            this.f17330b.innerError(th2);
        }

        public void onNext(Object obj) {
            this.f17330b.innerValue(this.f17331c, obj);
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this, disposable);
        }
    }

    public ObservableGroupJoin(ObservableSource<TLeft> observableSource, ObservableSource<? extends TRight> observableSource2, Function<? super TLeft, ? extends ObservableSource<TLeftEnd>> function, Function<? super TRight, ? extends ObservableSource<TRightEnd>> function2, BiFunction<? super TLeft, ? super Observable<TRight>, ? extends R> biFunction) {
        super(observableSource);
        this.f17306c = observableSource2;
        this.f17307d = function;
        this.f17308e = function2;
        this.f17309f = biFunction;
    }

    public void subscribeActual(Observer<? super R> observer) {
        GroupJoinDisposable groupJoinDisposable = new GroupJoinDisposable(observer, this.f17307d, this.f17308e, this.f17309f);
        observer.onSubscribe(groupJoinDisposable);
        LeftRightObserver leftRightObserver = new LeftRightObserver(groupJoinDisposable, true);
        groupJoinDisposable.f17316d.add(leftRightObserver);
        LeftRightObserver leftRightObserver2 = new LeftRightObserver(groupJoinDisposable, false);
        groupJoinDisposable.f17316d.add(leftRightObserver2);
        this.f16799b.subscribe(leftRightObserver);
        this.f17306c.subscribe(leftRightObserver2);
    }
}
