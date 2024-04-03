package io.reactivex.internal.observers;

import io.reactivex.CompletableObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class SubscriberCompletableObserver<T> implements CompletableObserver, Subscription {

    /* renamed from: b  reason: collision with root package name */
    public final Subscriber<? super T> f14583b;

    /* renamed from: c  reason: collision with root package name */
    public Disposable f14584c;

    public SubscriberCompletableObserver(Subscriber<? super T> subscriber) {
        this.f14583b = subscriber;
    }

    public void cancel() {
        this.f14584c.dispose();
    }

    public void onComplete() {
        this.f14583b.onComplete();
    }

    public void onError(Throwable th2) {
        this.f14583b.onError(th2);
    }

    public void onSubscribe(Disposable disposable) {
        if (DisposableHelper.validate(this.f14584c, disposable)) {
            this.f14584c = disposable;
            this.f14583b.onSubscribe(this);
        }
    }

    public void request(long j11) {
    }
}
