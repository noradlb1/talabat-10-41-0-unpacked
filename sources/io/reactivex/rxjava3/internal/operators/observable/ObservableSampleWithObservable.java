package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.observers.SerializedObserver;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableSampleWithObservable<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    public final ObservableSource<?> f22147c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f22148d;

    public static final class SampleMainEmitLast<T> extends SampleMainObserver<T> {
        private static final long serialVersionUID = -3029755663834015785L;

        /* renamed from: f  reason: collision with root package name */
        public final AtomicInteger f22149f = new AtomicInteger();

        /* renamed from: g  reason: collision with root package name */
        public volatile boolean f22150g;

        public SampleMainEmitLast(Observer<? super T> observer, ObservableSource<?> observableSource) {
            super(observer, observableSource);
        }

        public void a() {
            this.f22150g = true;
            if (this.f22149f.getAndIncrement() == 0) {
                b();
                this.f22151b.onComplete();
            }
        }

        public void c() {
            if (this.f22149f.getAndIncrement() == 0) {
                do {
                    boolean z11 = this.f22150g;
                    b();
                    if (z11) {
                        this.f22151b.onComplete();
                        return;
                    }
                } while (this.f22149f.decrementAndGet() != 0);
            }
        }
    }

    public static final class SampleMainNoLast<T> extends SampleMainObserver<T> {
        private static final long serialVersionUID = -3029755663834015785L;

        public SampleMainNoLast(Observer<? super T> observer, ObservableSource<?> observableSource) {
            super(observer, observableSource);
        }

        public void a() {
            this.f22151b.onComplete();
        }

        public void c() {
            b();
        }
    }

    public static abstract class SampleMainObserver<T> extends AtomicReference<T> implements Observer<T>, Disposable {
        private static final long serialVersionUID = -3517602651313910099L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super T> f22151b;

        /* renamed from: c  reason: collision with root package name */
        public final ObservableSource<?> f22152c;

        /* renamed from: d  reason: collision with root package name */
        public final AtomicReference<Disposable> f22153d = new AtomicReference<>();

        /* renamed from: e  reason: collision with root package name */
        public Disposable f22154e;

        public SampleMainObserver(Observer<? super T> observer, ObservableSource<?> observableSource) {
            this.f22151b = observer;
            this.f22152c = observableSource;
        }

        public abstract void a();

        public void b() {
            Object andSet = getAndSet((Object) null);
            if (andSet != null) {
                this.f22151b.onNext(andSet);
            }
        }

        public abstract void c();

        public void complete() {
            this.f22154e.dispose();
            a();
        }

        public boolean d(Disposable disposable) {
            return DisposableHelper.setOnce(this.f22153d, disposable);
        }

        public void dispose() {
            DisposableHelper.dispose(this.f22153d);
            this.f22154e.dispose();
        }

        public void error(Throwable th2) {
            this.f22154e.dispose();
            this.f22151b.onError(th2);
        }

        public boolean isDisposed() {
            return this.f22153d.get() == DisposableHelper.DISPOSED;
        }

        public void onComplete() {
            DisposableHelper.dispose(this.f22153d);
            a();
        }

        public void onError(Throwable th2) {
            DisposableHelper.dispose(this.f22153d);
            this.f22151b.onError(th2);
        }

        public void onNext(T t11) {
            lazySet(t11);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f22154e, disposable)) {
                this.f22154e = disposable;
                this.f22151b.onSubscribe(this);
                if (this.f22153d.get() == null) {
                    this.f22152c.subscribe(new SamplerObserver(this));
                }
            }
        }
    }

    public static final class SamplerObserver<T> implements Observer<Object> {

        /* renamed from: b  reason: collision with root package name */
        public final SampleMainObserver<T> f22155b;

        public SamplerObserver(SampleMainObserver<T> sampleMainObserver) {
            this.f22155b = sampleMainObserver;
        }

        public void onComplete() {
            this.f22155b.complete();
        }

        public void onError(Throwable th2) {
            this.f22155b.error(th2);
        }

        public void onNext(Object obj) {
            this.f22155b.c();
        }

        public void onSubscribe(Disposable disposable) {
            this.f22155b.d(disposable);
        }
    }

    public ObservableSampleWithObservable(ObservableSource<T> observableSource, ObservableSource<?> observableSource2, boolean z11) {
        super(observableSource);
        this.f22147c = observableSource2;
        this.f22148d = z11;
    }

    public void subscribeActual(Observer<? super T> observer) {
        SerializedObserver serializedObserver = new SerializedObserver(observer);
        if (this.f22148d) {
            this.f21304b.subscribe(new SampleMainEmitLast(serializedObserver, this.f22147c));
        } else {
            this.f21304b.subscribe(new SampleMainNoLast(serializedObserver, this.f22147c));
        }
    }
}
