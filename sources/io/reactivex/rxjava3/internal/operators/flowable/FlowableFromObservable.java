package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableFromObservable<T> extends Flowable<T> {
    private final ObservableSource<T> upstream;

    public static final class SubscriberObserver<T> implements Observer<T>, Subscription {

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super T> f19835b;

        /* renamed from: c  reason: collision with root package name */
        public Disposable f19836c;

        public SubscriberObserver(Subscriber<? super T> subscriber) {
            this.f19835b = subscriber;
        }

        public void cancel() {
            this.f19836c.dispose();
        }

        public void onComplete() {
            this.f19835b.onComplete();
        }

        public void onError(Throwable th2) {
            this.f19835b.onError(th2);
        }

        public void onNext(T t11) {
            this.f19835b.onNext(t11);
        }

        public void onSubscribe(Disposable disposable) {
            this.f19836c = disposable;
            this.f19835b.onSubscribe(this);
        }

        public void request(long j11) {
        }
    }

    public FlowableFromObservable(ObservableSource<T> observableSource) {
        this.upstream = observableSource;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.upstream.subscribe(new SubscriberObserver(subscriber));
    }
}
