package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableFromObservable<T> extends Flowable<T> {
    private final Observable<T> upstream;

    public static final class SubscriberObserver<T> implements Observer<T>, Subscription {

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super T> f15320b;

        /* renamed from: c  reason: collision with root package name */
        public Disposable f15321c;

        public SubscriberObserver(Subscriber<? super T> subscriber) {
            this.f15320b = subscriber;
        }

        public void cancel() {
            this.f15321c.dispose();
        }

        public void onComplete() {
            this.f15320b.onComplete();
        }

        public void onError(Throwable th2) {
            this.f15320b.onError(th2);
        }

        public void onNext(T t11) {
            this.f15320b.onNext(t11);
        }

        public void onSubscribe(Disposable disposable) {
            this.f15321c = disposable;
            this.f15320b.onSubscribe(this);
        }

        public void request(long j11) {
        }
    }

    public FlowableFromObservable(Observable<T> observable) {
        this.upstream = observable;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.upstream.subscribe(new SubscriberObserver(subscriber));
    }
}
