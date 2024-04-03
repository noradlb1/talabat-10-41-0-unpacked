package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.observers.SerializedObserver;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableSampleWithObservable<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    public final ObservableSource<?> f17604c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f17605d;

    public static final class SampleMainEmitLast<T> extends SampleMainObserver<T> {
        private static final long serialVersionUID = -3029755663834015785L;

        /* renamed from: f  reason: collision with root package name */
        public final AtomicInteger f17606f = new AtomicInteger();

        /* renamed from: g  reason: collision with root package name */
        public volatile boolean f17607g;

        public SampleMainEmitLast(Observer<? super T> observer, ObservableSource<?> observableSource) {
            super(observer, observableSource);
        }

        public void a() {
            this.f17607g = true;
            if (this.f17606f.getAndIncrement() == 0) {
                b();
                this.f17608b.onComplete();
            }
        }

        public void c() {
            if (this.f17606f.getAndIncrement() == 0) {
                do {
                    boolean z11 = this.f17607g;
                    b();
                    if (z11) {
                        this.f17608b.onComplete();
                        return;
                    }
                } while (this.f17606f.decrementAndGet() != 0);
            }
        }
    }

    public static final class SampleMainNoLast<T> extends SampleMainObserver<T> {
        private static final long serialVersionUID = -3029755663834015785L;

        public SampleMainNoLast(Observer<? super T> observer, ObservableSource<?> observableSource) {
            super(observer, observableSource);
        }

        public void a() {
            this.f17608b.onComplete();
        }

        public void c() {
            b();
        }
    }

    public static abstract class SampleMainObserver<T> extends AtomicReference<T> implements Observer<T>, Disposable {
        private static final long serialVersionUID = -3517602651313910099L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super T> f17608b;

        /* renamed from: c  reason: collision with root package name */
        public final ObservableSource<?> f17609c;

        /* renamed from: d  reason: collision with root package name */
        public final AtomicReference<Disposable> f17610d = new AtomicReference<>();

        /* renamed from: e  reason: collision with root package name */
        public Disposable f17611e;

        public SampleMainObserver(Observer<? super T> observer, ObservableSource<?> observableSource) {
            this.f17608b = observer;
            this.f17609c = observableSource;
        }

        public abstract void a();

        public void b() {
            Object andSet = getAndSet((Object) null);
            if (andSet != null) {
                this.f17608b.onNext(andSet);
            }
        }

        public abstract void c();

        public void complete() {
            this.f17611e.dispose();
            a();
        }

        public boolean d(Disposable disposable) {
            return DisposableHelper.setOnce(this.f17610d, disposable);
        }

        public void dispose() {
            DisposableHelper.dispose(this.f17610d);
            this.f17611e.dispose();
        }

        public void error(Throwable th2) {
            this.f17611e.dispose();
            this.f17608b.onError(th2);
        }

        public boolean isDisposed() {
            return this.f17610d.get() == DisposableHelper.DISPOSED;
        }

        public void onComplete() {
            DisposableHelper.dispose(this.f17610d);
            a();
        }

        public void onError(Throwable th2) {
            DisposableHelper.dispose(this.f17610d);
            this.f17608b.onError(th2);
        }

        public void onNext(T t11) {
            lazySet(t11);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f17611e, disposable)) {
                this.f17611e = disposable;
                this.f17608b.onSubscribe(this);
                if (this.f17610d.get() == null) {
                    this.f17609c.subscribe(new SamplerObserver(this));
                }
            }
        }
    }

    public static final class SamplerObserver<T> implements Observer<Object> {

        /* renamed from: b  reason: collision with root package name */
        public final SampleMainObserver<T> f17612b;

        public SamplerObserver(SampleMainObserver<T> sampleMainObserver) {
            this.f17612b = sampleMainObserver;
        }

        public void onComplete() {
            this.f17612b.complete();
        }

        public void onError(Throwable th2) {
            this.f17612b.error(th2);
        }

        public void onNext(Object obj) {
            this.f17612b.c();
        }

        public void onSubscribe(Disposable disposable) {
            this.f17612b.d(disposable);
        }
    }

    public ObservableSampleWithObservable(ObservableSource<T> observableSource, ObservableSource<?> observableSource2, boolean z11) {
        super(observableSource);
        this.f17604c = observableSource2;
        this.f17605d = z11;
    }

    public void subscribeActual(Observer<? super T> observer) {
        SerializedObserver serializedObserver = new SerializedObserver(observer);
        if (this.f17605d) {
            this.f16799b.subscribe(new SampleMainEmitLast(serializedObserver, this.f17604c));
        } else {
            this.f16799b.subscribe(new SampleMainNoLast(serializedObserver, this.f17604c));
        }
    }
}
