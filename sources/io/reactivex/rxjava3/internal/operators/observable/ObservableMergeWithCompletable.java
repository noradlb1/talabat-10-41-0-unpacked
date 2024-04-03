package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.HalfSerializer;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableMergeWithCompletable<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    public final CompletableSource f21952c;

    public static final class MergeWithObserver<T> extends AtomicInteger implements Observer<T>, Disposable {
        private static final long serialVersionUID = -4592979584110982903L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super T> f21953b;

        /* renamed from: c  reason: collision with root package name */
        public final AtomicReference<Disposable> f21954c = new AtomicReference<>();

        /* renamed from: d  reason: collision with root package name */
        public final OtherObserver f21955d = new OtherObserver(this);

        /* renamed from: e  reason: collision with root package name */
        public final AtomicThrowable f21956e = new AtomicThrowable();

        /* renamed from: f  reason: collision with root package name */
        public volatile boolean f21957f;

        /* renamed from: g  reason: collision with root package name */
        public volatile boolean f21958g;

        public static final class OtherObserver extends AtomicReference<Disposable> implements CompletableObserver {
            private static final long serialVersionUID = -2935427570954647017L;

            /* renamed from: b  reason: collision with root package name */
            public final MergeWithObserver<?> f21959b;

            public OtherObserver(MergeWithObserver<?> mergeWithObserver) {
                this.f21959b = mergeWithObserver;
            }

            public void onComplete() {
                this.f21959b.a();
            }

            public void onError(Throwable th2) {
                this.f21959b.b(th2);
            }

            public void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this, disposable);
            }
        }

        public MergeWithObserver(Observer<? super T> observer) {
            this.f21953b = observer;
        }

        public void a() {
            this.f21958g = true;
            if (this.f21957f) {
                HalfSerializer.onComplete((Observer<?>) this.f21953b, (AtomicInteger) this, this.f21956e);
            }
        }

        public void b(Throwable th2) {
            DisposableHelper.dispose(this.f21954c);
            HalfSerializer.onError((Observer<?>) this.f21953b, th2, (AtomicInteger) this, this.f21956e);
        }

        public void dispose() {
            DisposableHelper.dispose(this.f21954c);
            DisposableHelper.dispose(this.f21955d);
            this.f21956e.tryTerminateAndReport();
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed(this.f21954c.get());
        }

        public void onComplete() {
            this.f21957f = true;
            if (this.f21958g) {
                HalfSerializer.onComplete((Observer<?>) this.f21953b, (AtomicInteger) this, this.f21956e);
            }
        }

        public void onError(Throwable th2) {
            DisposableHelper.dispose(this.f21955d);
            HalfSerializer.onError((Observer<?>) this.f21953b, th2, (AtomicInteger) this, this.f21956e);
        }

        public void onNext(T t11) {
            HalfSerializer.onNext(this.f21953b, t11, (AtomicInteger) this, this.f21956e);
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this.f21954c, disposable);
        }
    }

    public ObservableMergeWithCompletable(Observable<T> observable, CompletableSource completableSource) {
        super(observable);
        this.f21952c = completableSource;
    }

    public void subscribeActual(Observer<? super T> observer) {
        MergeWithObserver mergeWithObserver = new MergeWithObserver(observer);
        observer.onSubscribe(mergeWithObserver);
        this.f21304b.subscribe(mergeWithObserver);
        this.f21952c.subscribe(mergeWithObserver.f21955d);
    }
}
