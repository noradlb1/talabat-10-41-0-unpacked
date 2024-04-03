package io.reactivex.internal.operators.observable;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.HalfSerializer;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableMergeWithCompletable<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    public final CompletableSource f17405c;

    public static final class MergeWithObserver<T> extends AtomicInteger implements Observer<T>, Disposable {
        private static final long serialVersionUID = -4592979584110982903L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super T> f17406b;

        /* renamed from: c  reason: collision with root package name */
        public final AtomicReference<Disposable> f17407c = new AtomicReference<>();

        /* renamed from: d  reason: collision with root package name */
        public final OtherObserver f17408d = new OtherObserver(this);

        /* renamed from: e  reason: collision with root package name */
        public final AtomicThrowable f17409e = new AtomicThrowable();

        /* renamed from: f  reason: collision with root package name */
        public volatile boolean f17410f;

        /* renamed from: g  reason: collision with root package name */
        public volatile boolean f17411g;

        public static final class OtherObserver extends AtomicReference<Disposable> implements CompletableObserver {
            private static final long serialVersionUID = -2935427570954647017L;

            /* renamed from: b  reason: collision with root package name */
            public final MergeWithObserver<?> f17412b;

            public OtherObserver(MergeWithObserver<?> mergeWithObserver) {
                this.f17412b = mergeWithObserver;
            }

            public void onComplete() {
                this.f17412b.a();
            }

            public void onError(Throwable th2) {
                this.f17412b.b(th2);
            }

            public void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this, disposable);
            }
        }

        public MergeWithObserver(Observer<? super T> observer) {
            this.f17406b = observer;
        }

        public void a() {
            this.f17411g = true;
            if (this.f17410f) {
                HalfSerializer.onComplete((Observer<?>) this.f17406b, (AtomicInteger) this, this.f17409e);
            }
        }

        public void b(Throwable th2) {
            DisposableHelper.dispose(this.f17407c);
            HalfSerializer.onError((Observer<?>) this.f17406b, th2, (AtomicInteger) this, this.f17409e);
        }

        public void dispose() {
            DisposableHelper.dispose(this.f17407c);
            DisposableHelper.dispose(this.f17408d);
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed(this.f17407c.get());
        }

        public void onComplete() {
            this.f17410f = true;
            if (this.f17411g) {
                HalfSerializer.onComplete((Observer<?>) this.f17406b, (AtomicInteger) this, this.f17409e);
            }
        }

        public void onError(Throwable th2) {
            DisposableHelper.dispose(this.f17408d);
            HalfSerializer.onError((Observer<?>) this.f17406b, th2, (AtomicInteger) this, this.f17409e);
        }

        public void onNext(T t11) {
            HalfSerializer.onNext(this.f17406b, t11, (AtomicInteger) this, this.f17409e);
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this.f17407c, disposable);
        }
    }

    public ObservableMergeWithCompletable(Observable<T> observable, CompletableSource completableSource) {
        super(observable);
        this.f17405c = completableSource;
    }

    public void subscribeActual(Observer<? super T> observer) {
        MergeWithObserver mergeWithObserver = new MergeWithObserver(observer);
        observer.onSubscribe(mergeWithObserver);
        this.f16799b.subscribe(mergeWithObserver);
        this.f17405c.subscribe(mergeWithObserver.f17408d);
    }
}
