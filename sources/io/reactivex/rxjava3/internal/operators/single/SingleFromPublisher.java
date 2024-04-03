package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.NoSuchElementException;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;

public final class SingleFromPublisher<T> extends Single<T> {

    /* renamed from: b  reason: collision with root package name */
    public final Publisher<? extends T> f22917b;

    public static final class ToSingleObserver<T> implements FlowableSubscriber<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final SingleObserver<? super T> f22918b;

        /* renamed from: c  reason: collision with root package name */
        public Subscription f22919c;

        /* renamed from: d  reason: collision with root package name */
        public T f22920d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f22921e;

        /* renamed from: f  reason: collision with root package name */
        public volatile boolean f22922f;

        public ToSingleObserver(SingleObserver<? super T> singleObserver) {
            this.f22918b = singleObserver;
        }

        public void dispose() {
            this.f22922f = true;
            this.f22919c.cancel();
        }

        public boolean isDisposed() {
            return this.f22922f;
        }

        public void onComplete() {
            if (!this.f22921e) {
                this.f22921e = true;
                T t11 = this.f22920d;
                this.f22920d = null;
                if (t11 == null) {
                    this.f22918b.onError(new NoSuchElementException("The source Publisher is empty"));
                } else {
                    this.f22918b.onSuccess(t11);
                }
            }
        }

        public void onError(Throwable th2) {
            if (this.f22921e) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f22921e = true;
            this.f22920d = null;
            this.f22918b.onError(th2);
        }

        public void onNext(T t11) {
            if (!this.f22921e) {
                if (this.f22920d != null) {
                    this.f22919c.cancel();
                    this.f22921e = true;
                    this.f22920d = null;
                    this.f22918b.onError(new IndexOutOfBoundsException("Too many elements in the Publisher"));
                    return;
                }
                this.f22920d = t11;
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f22919c, subscription)) {
                this.f22919c = subscription;
                this.f22918b.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }
    }

    public SingleFromPublisher(Publisher<? extends T> publisher) {
        this.f22917b = publisher;
    }

    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f22917b.subscribe(new ToSingleObserver(singleObserver));
    }
}
