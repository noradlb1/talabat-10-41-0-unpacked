package io.reactivex.internal.operators.single;

import io.reactivex.FlowableSubscriber;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.NoSuchElementException;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;

public final class SingleFromPublisher<T> extends Single<T> {

    /* renamed from: b  reason: collision with root package name */
    public final Publisher<? extends T> f18360b;

    public static final class ToSingleObserver<T> implements FlowableSubscriber<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final SingleObserver<? super T> f18361b;

        /* renamed from: c  reason: collision with root package name */
        public Subscription f18362c;

        /* renamed from: d  reason: collision with root package name */
        public T f18363d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f18364e;

        /* renamed from: f  reason: collision with root package name */
        public volatile boolean f18365f;

        public ToSingleObserver(SingleObserver<? super T> singleObserver) {
            this.f18361b = singleObserver;
        }

        public void dispose() {
            this.f18365f = true;
            this.f18362c.cancel();
        }

        public boolean isDisposed() {
            return this.f18365f;
        }

        public void onComplete() {
            if (!this.f18364e) {
                this.f18364e = true;
                T t11 = this.f18363d;
                this.f18363d = null;
                if (t11 == null) {
                    this.f18361b.onError(new NoSuchElementException("The source Publisher is empty"));
                } else {
                    this.f18361b.onSuccess(t11);
                }
            }
        }

        public void onError(Throwable th2) {
            if (this.f18364e) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f18364e = true;
            this.f18363d = null;
            this.f18361b.onError(th2);
        }

        public void onNext(T t11) {
            if (!this.f18364e) {
                if (this.f18363d != null) {
                    this.f18362c.cancel();
                    this.f18364e = true;
                    this.f18363d = null;
                    this.f18361b.onError(new IndexOutOfBoundsException("Too many elements in the Publisher"));
                    return;
                }
                this.f18363d = t11;
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f18362c, subscription)) {
                this.f18362c = subscription;
                this.f18361b.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }
    }

    public SingleFromPublisher(Publisher<? extends T> publisher) {
        this.f18360b = publisher;
    }

    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f18360b.subscribe(new ToSingleObserver(singleObserver));
    }
}
