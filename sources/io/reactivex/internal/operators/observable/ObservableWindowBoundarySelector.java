package io.reactivex.internal.operators.observable;

import i.b;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.QueueDrainObserver;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.observers.SerializedObserver;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.subjects.UnicastSubject;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableWindowBoundarySelector<T, B, V> extends AbstractObservableWithUpstream<T, Observable<T>> {

    /* renamed from: c  reason: collision with root package name */
    public final ObservableSource<B> f17922c;

    /* renamed from: d  reason: collision with root package name */
    public final Function<? super B, ? extends ObservableSource<V>> f17923d;

    /* renamed from: e  reason: collision with root package name */
    public final int f17924e;

    public static final class OperatorWindowBoundaryCloseObserver<T, V> extends DisposableObserver<V> {

        /* renamed from: b  reason: collision with root package name */
        public final WindowBoundaryMainObserver<T, ?, V> f17925b;

        /* renamed from: c  reason: collision with root package name */
        public final UnicastSubject<T> f17926c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f17927d;

        public OperatorWindowBoundaryCloseObserver(WindowBoundaryMainObserver<T, ?, V> windowBoundaryMainObserver, UnicastSubject<T> unicastSubject) {
            this.f17925b = windowBoundaryMainObserver;
            this.f17926c = unicastSubject;
        }

        public void onComplete() {
            if (!this.f17927d) {
                this.f17927d = true;
                this.f17925b.c(this);
            }
        }

        public void onError(Throwable th2) {
            if (this.f17927d) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f17927d = true;
            this.f17925b.f(th2);
        }

        public void onNext(V v11) {
            dispose();
            onComplete();
        }
    }

    public static final class OperatorWindowBoundaryOpenObserver<T, B> extends DisposableObserver<B> {

        /* renamed from: b  reason: collision with root package name */
        public final WindowBoundaryMainObserver<T, B, ?> f17928b;

        public OperatorWindowBoundaryOpenObserver(WindowBoundaryMainObserver<T, B, ?> windowBoundaryMainObserver) {
            this.f17928b = windowBoundaryMainObserver;
        }

        public void onComplete() {
            this.f17928b.onComplete();
        }

        public void onError(Throwable th2) {
            this.f17928b.f(th2);
        }

        public void onNext(B b11) {
            this.f17928b.g(b11);
        }
    }

    public static final class WindowBoundaryMainObserver<T, B, V> extends QueueDrainObserver<T, Object, Observable<T>> implements Disposable {

        /* renamed from: h  reason: collision with root package name */
        public final ObservableSource<B> f17929h;

        /* renamed from: i  reason: collision with root package name */
        public final Function<? super B, ? extends ObservableSource<V>> f17930i;

        /* renamed from: j  reason: collision with root package name */
        public final int f17931j;

        /* renamed from: k  reason: collision with root package name */
        public final CompositeDisposable f17932k;

        /* renamed from: l  reason: collision with root package name */
        public Disposable f17933l;

        /* renamed from: m  reason: collision with root package name */
        public final AtomicReference<Disposable> f17934m = new AtomicReference<>();

        /* renamed from: n  reason: collision with root package name */
        public final List<UnicastSubject<T>> f17935n;

        /* renamed from: o  reason: collision with root package name */
        public final AtomicLong f17936o;

        /* renamed from: p  reason: collision with root package name */
        public final AtomicBoolean f17937p;

        public WindowBoundaryMainObserver(Observer<? super Observable<T>> observer, ObservableSource<B> observableSource, Function<? super B, ? extends ObservableSource<V>> function, int i11) {
            super(observer, new MpscLinkedQueue());
            AtomicLong atomicLong = new AtomicLong();
            this.f17936o = atomicLong;
            this.f17937p = new AtomicBoolean();
            this.f17929h = observableSource;
            this.f17930i = function;
            this.f17931j = i11;
            this.f17932k = new CompositeDisposable();
            this.f17935n = new ArrayList();
            atomicLong.lazySet(1);
        }

        public void accept(Observer<? super Observable<T>> observer, Object obj) {
        }

        public void c(OperatorWindowBoundaryCloseObserver<T, V> operatorWindowBoundaryCloseObserver) {
            this.f17932k.delete(operatorWindowBoundaryCloseObserver);
            this.f14576d.offer(new WindowOperation(operatorWindowBoundaryCloseObserver.f17926c, null));
            if (enter()) {
                e();
            }
        }

        public void d() {
            this.f17932k.dispose();
            DisposableHelper.dispose(this.f17934m);
        }

        public void dispose() {
            if (this.f17937p.compareAndSet(false, true)) {
                DisposableHelper.dispose(this.f17934m);
                if (this.f17936o.decrementAndGet() == 0) {
                    this.f17933l.dispose();
                }
            }
        }

        public void e() {
            boolean z11;
            MpscLinkedQueue mpscLinkedQueue = (MpscLinkedQueue) this.f14576d;
            Observer<? super V> observer = this.f14575c;
            List<UnicastSubject<T>> list = this.f17935n;
            int i11 = 1;
            while (true) {
                boolean z12 = this.f14578f;
                Object poll = mpscLinkedQueue.poll();
                if (poll == null) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (z12 && z11) {
                    d();
                    Throwable th2 = this.f14579g;
                    if (th2 != null) {
                        for (UnicastSubject<T> onError : list) {
                            onError.onError(th2);
                        }
                    } else {
                        for (UnicastSubject<T> onComplete : list) {
                            onComplete.onComplete();
                        }
                    }
                    list.clear();
                    return;
                } else if (z11) {
                    i11 = leave(-i11);
                    if (i11 == 0) {
                        return;
                    }
                } else if (poll instanceof WindowOperation) {
                    WindowOperation windowOperation = (WindowOperation) poll;
                    UnicastSubject<T> unicastSubject = windowOperation.f17938a;
                    if (unicastSubject != null) {
                        if (list.remove(unicastSubject)) {
                            windowOperation.f17938a.onComplete();
                            if (this.f17936o.decrementAndGet() == 0) {
                                d();
                                return;
                            }
                        } else {
                            continue;
                        }
                    } else if (!this.f17937p.get()) {
                        UnicastSubject create = UnicastSubject.create(this.f17931j);
                        list.add(create);
                        observer.onNext(create);
                        try {
                            ObservableSource observableSource = (ObservableSource) ObjectHelper.requireNonNull(this.f17930i.apply(windowOperation.f17939b), "The ObservableSource supplied is null");
                            OperatorWindowBoundaryCloseObserver operatorWindowBoundaryCloseObserver = new OperatorWindowBoundaryCloseObserver(this, create);
                            if (this.f17932k.add(operatorWindowBoundaryCloseObserver)) {
                                this.f17936o.getAndIncrement();
                                observableSource.subscribe(operatorWindowBoundaryCloseObserver);
                            }
                        } catch (Throwable th3) {
                            Exceptions.throwIfFatal(th3);
                            this.f17937p.set(true);
                            observer.onError(th3);
                        }
                    }
                } else {
                    for (UnicastSubject<T> onNext : list) {
                        onNext.onNext(NotificationLite.getValue(poll));
                    }
                }
            }
        }

        public void f(Throwable th2) {
            this.f17933l.dispose();
            this.f17932k.dispose();
            onError(th2);
        }

        public void g(B b11) {
            this.f14576d.offer(new WindowOperation((UnicastSubject) null, b11));
            if (enter()) {
                e();
            }
        }

        public boolean isDisposed() {
            return this.f17937p.get();
        }

        public void onComplete() {
            if (!this.f14578f) {
                this.f14578f = true;
                if (enter()) {
                    e();
                }
                if (this.f17936o.decrementAndGet() == 0) {
                    this.f17932k.dispose();
                }
                this.f14575c.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (this.f14578f) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f14579g = th2;
            this.f14578f = true;
            if (enter()) {
                e();
            }
            if (this.f17936o.decrementAndGet() == 0) {
                this.f17932k.dispose();
            }
            this.f14575c.onError(th2);
        }

        public void onNext(T t11) {
            if (fastEnter()) {
                for (UnicastSubject<T> onNext : this.f17935n) {
                    onNext.onNext(t11);
                }
                if (leave(-1) == 0) {
                    return;
                }
            } else {
                this.f14576d.offer(NotificationLite.next(t11));
                if (!enter()) {
                    return;
                }
            }
            e();
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f17933l, disposable)) {
                this.f17933l = disposable;
                this.f14575c.onSubscribe(this);
                if (!this.f17937p.get()) {
                    OperatorWindowBoundaryOpenObserver operatorWindowBoundaryOpenObserver = new OperatorWindowBoundaryOpenObserver(this);
                    if (b.a(this.f17934m, (Object) null, operatorWindowBoundaryOpenObserver)) {
                        this.f17929h.subscribe(operatorWindowBoundaryOpenObserver);
                    }
                }
            }
        }
    }

    public static final class WindowOperation<T, B> {

        /* renamed from: a  reason: collision with root package name */
        public final UnicastSubject<T> f17938a;

        /* renamed from: b  reason: collision with root package name */
        public final B f17939b;

        public WindowOperation(UnicastSubject<T> unicastSubject, B b11) {
            this.f17938a = unicastSubject;
            this.f17939b = b11;
        }
    }

    public ObservableWindowBoundarySelector(ObservableSource<T> observableSource, ObservableSource<B> observableSource2, Function<? super B, ? extends ObservableSource<V>> function, int i11) {
        super(observableSource);
        this.f17922c = observableSource2;
        this.f17923d = function;
        this.f17924e = i11;
    }

    public void subscribeActual(Observer<? super Observable<T>> observer) {
        this.f16799b.subscribe(new WindowBoundaryMainObserver(new SerializedObserver(observer), this.f17922c, this.f17923d, this.f17924e));
    }
}
