package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.schedulers.Timed;
import java.util.concurrent.TimeUnit;

public final class ObservableTimeInterval<T> extends AbstractObservableWithUpstream<T, Timed<T>> {

    /* renamed from: c  reason: collision with root package name */
    public final Scheduler f22358c;

    /* renamed from: d  reason: collision with root package name */
    public final TimeUnit f22359d;

    public static final class TimeIntervalObserver<T> implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super Timed<T>> f22360b;

        /* renamed from: c  reason: collision with root package name */
        public final TimeUnit f22361c;

        /* renamed from: d  reason: collision with root package name */
        public final Scheduler f22362d;

        /* renamed from: e  reason: collision with root package name */
        public long f22363e;

        /* renamed from: f  reason: collision with root package name */
        public Disposable f22364f;

        public TimeIntervalObserver(Observer<? super Timed<T>> observer, TimeUnit timeUnit, Scheduler scheduler) {
            this.f22360b = observer;
            this.f22362d = scheduler;
            this.f22361c = timeUnit;
        }

        public void dispose() {
            this.f22364f.dispose();
        }

        public boolean isDisposed() {
            return this.f22364f.isDisposed();
        }

        public void onComplete() {
            this.f22360b.onComplete();
        }

        public void onError(Throwable th2) {
            this.f22360b.onError(th2);
        }

        public void onNext(T t11) {
            long now = this.f22362d.now(this.f22361c);
            long j11 = this.f22363e;
            this.f22363e = now;
            this.f22360b.onNext(new Timed(t11, now - j11, this.f22361c));
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f22364f, disposable)) {
                this.f22364f = disposable;
                this.f22363e = this.f22362d.now(this.f22361c);
                this.f22360b.onSubscribe(this);
            }
        }
    }

    public ObservableTimeInterval(ObservableSource<T> observableSource, TimeUnit timeUnit, Scheduler scheduler) {
        super(observableSource);
        this.f22358c = scheduler;
        this.f22359d = timeUnit;
    }

    public void subscribeActual(Observer<? super Timed<T>> observer) {
        this.f21304b.subscribe(new TimeIntervalObserver(observer, this.f22359d, this.f22358c));
    }
}
