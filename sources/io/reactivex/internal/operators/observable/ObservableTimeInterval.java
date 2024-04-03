package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.schedulers.Timed;
import java.util.concurrent.TimeUnit;

public final class ObservableTimeInterval<T> extends AbstractObservableWithUpstream<T, Timed<T>> {

    /* renamed from: c  reason: collision with root package name */
    public final Scheduler f17816c;

    /* renamed from: d  reason: collision with root package name */
    public final TimeUnit f17817d;

    public static final class TimeIntervalObserver<T> implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super Timed<T>> f17818b;

        /* renamed from: c  reason: collision with root package name */
        public final TimeUnit f17819c;

        /* renamed from: d  reason: collision with root package name */
        public final Scheduler f17820d;

        /* renamed from: e  reason: collision with root package name */
        public long f17821e;

        /* renamed from: f  reason: collision with root package name */
        public Disposable f17822f;

        public TimeIntervalObserver(Observer<? super Timed<T>> observer, TimeUnit timeUnit, Scheduler scheduler) {
            this.f17818b = observer;
            this.f17820d = scheduler;
            this.f17819c = timeUnit;
        }

        public void dispose() {
            this.f17822f.dispose();
        }

        public boolean isDisposed() {
            return this.f17822f.isDisposed();
        }

        public void onComplete() {
            this.f17818b.onComplete();
        }

        public void onError(Throwable th2) {
            this.f17818b.onError(th2);
        }

        public void onNext(T t11) {
            long now = this.f17820d.now(this.f17819c);
            long j11 = this.f17821e;
            this.f17821e = now;
            this.f17818b.onNext(new Timed(t11, now - j11, this.f17819c));
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f17822f, disposable)) {
                this.f17822f = disposable;
                this.f17821e = this.f17820d.now(this.f17819c);
                this.f17818b.onSubscribe(this);
            }
        }
    }

    public ObservableTimeInterval(ObservableSource<T> observableSource, TimeUnit timeUnit, Scheduler scheduler) {
        super(observableSource);
        this.f17816c = scheduler;
        this.f17817d = timeUnit;
    }

    public void subscribeActual(Observer<? super Timed<T>> observer) {
        this.f16799b.subscribe(new TimeIntervalObserver(observer, this.f17817d, this.f17816c));
    }
}
