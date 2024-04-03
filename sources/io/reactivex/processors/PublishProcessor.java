package io.reactivex.processors;

import i.b;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.Nullable;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class PublishProcessor<T> extends FlowableProcessor<T> {

    /* renamed from: e  reason: collision with root package name */
    public static final PublishSubscription[] f18706e = new PublishSubscription[0];

    /* renamed from: f  reason: collision with root package name */
    public static final PublishSubscription[] f18707f = new PublishSubscription[0];

    /* renamed from: c  reason: collision with root package name */
    public final AtomicReference<PublishSubscription<T>[]> f18708c = new AtomicReference<>(f18707f);

    /* renamed from: d  reason: collision with root package name */
    public Throwable f18709d;

    public static final class PublishSubscription<T> extends AtomicLong implements Subscription {
        private static final long serialVersionUID = 3562861878281475070L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super T> f18710b;

        /* renamed from: c  reason: collision with root package name */
        public final PublishProcessor<T> f18711c;

        public PublishSubscription(Subscriber<? super T> subscriber, PublishProcessor<T> publishProcessor) {
            this.f18710b = subscriber;
            this.f18711c = publishProcessor;
        }

        public boolean a() {
            return get() == 0;
        }

        public void cancel() {
            if (getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.f18711c.c(this);
            }
        }

        public boolean isCancelled() {
            return get() == Long.MIN_VALUE;
        }

        public void onComplete() {
            if (get() != Long.MIN_VALUE) {
                this.f18710b.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (get() != Long.MIN_VALUE) {
                this.f18710b.onError(th2);
            } else {
                RxJavaPlugins.onError(th2);
            }
        }

        public void onNext(T t11) {
            long j11 = get();
            if (j11 != Long.MIN_VALUE) {
                if (j11 != 0) {
                    this.f18710b.onNext(t11);
                    BackpressureHelper.producedCancel(this, 1);
                    return;
                }
                cancel();
                this.f18710b.onError(new MissingBackpressureException("Could not emit value due to lack of requests"));
            }
        }

        public void request(long j11) {
            if (SubscriptionHelper.validate(j11)) {
                BackpressureHelper.addCancel(this, j11);
            }
        }
    }

    @CheckReturnValue
    @NonNull
    public static <T> PublishProcessor<T> create() {
        return new PublishProcessor<>();
    }

    public boolean b(PublishSubscription<T> publishSubscription) {
        PublishSubscription[] publishSubscriptionArr;
        PublishSubscription[] publishSubscriptionArr2;
        do {
            publishSubscriptionArr = (PublishSubscription[]) this.f18708c.get();
            if (publishSubscriptionArr == f18706e) {
                return false;
            }
            int length = publishSubscriptionArr.length;
            publishSubscriptionArr2 = new PublishSubscription[(length + 1)];
            System.arraycopy(publishSubscriptionArr, 0, publishSubscriptionArr2, 0, length);
            publishSubscriptionArr2[length] = publishSubscription;
        } while (!b.a(this.f18708c, publishSubscriptionArr, publishSubscriptionArr2));
        return true;
    }

    public void c(PublishSubscription<T> publishSubscription) {
        PublishSubscription<T>[] publishSubscriptionArr;
        PublishSubscription[] publishSubscriptionArr2;
        do {
            publishSubscriptionArr = (PublishSubscription[]) this.f18708c.get();
            if (publishSubscriptionArr != f18706e && publishSubscriptionArr != f18707f) {
                int length = publishSubscriptionArr.length;
                int i11 = 0;
                while (true) {
                    if (i11 >= length) {
                        i11 = -1;
                        break;
                    } else if (publishSubscriptionArr[i11] == publishSubscription) {
                        break;
                    } else {
                        i11++;
                    }
                }
                if (i11 >= 0) {
                    if (length == 1) {
                        publishSubscriptionArr2 = f18707f;
                    } else {
                        PublishSubscription[] publishSubscriptionArr3 = new PublishSubscription[(length - 1)];
                        System.arraycopy(publishSubscriptionArr, 0, publishSubscriptionArr3, 0, i11);
                        System.arraycopy(publishSubscriptionArr, i11 + 1, publishSubscriptionArr3, i11, (length - i11) - 1);
                        publishSubscriptionArr2 = publishSubscriptionArr3;
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        } while (!b.a(this.f18708c, publishSubscriptionArr, publishSubscriptionArr2));
    }

    @Nullable
    public Throwable getThrowable() {
        if (this.f18708c.get() == f18706e) {
            return this.f18709d;
        }
        return null;
    }

    public boolean hasComplete() {
        return this.f18708c.get() == f18706e && this.f18709d == null;
    }

    public boolean hasSubscribers() {
        return ((PublishSubscription[]) this.f18708c.get()).length != 0;
    }

    public boolean hasThrowable() {
        return this.f18708c.get() == f18706e && this.f18709d != null;
    }

    public boolean offer(T t11) {
        if (t11 == null) {
            onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            return true;
        }
        PublishSubscription[] publishSubscriptionArr = (PublishSubscription[]) this.f18708c.get();
        for (PublishSubscription a11 : publishSubscriptionArr) {
            if (a11.a()) {
                return false;
            }
        }
        for (PublishSubscription onNext : publishSubscriptionArr) {
            onNext.onNext(t11);
        }
        return true;
    }

    public void onComplete() {
        PublishSubscription<T>[] publishSubscriptionArr = this.f18708c.get();
        PublishSubscription<T>[] publishSubscriptionArr2 = f18706e;
        if (publishSubscriptionArr != publishSubscriptionArr2) {
            for (PublishSubscription onComplete : (PublishSubscription[]) this.f18708c.getAndSet(publishSubscriptionArr2)) {
                onComplete.onComplete();
            }
        }
    }

    public void onError(Throwable th2) {
        ObjectHelper.requireNonNull(th2, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        PublishSubscription<T>[] publishSubscriptionArr = this.f18708c.get();
        PublishSubscription<T>[] publishSubscriptionArr2 = f18706e;
        if (publishSubscriptionArr == publishSubscriptionArr2) {
            RxJavaPlugins.onError(th2);
            return;
        }
        this.f18709d = th2;
        for (PublishSubscription onError : (PublishSubscription[]) this.f18708c.getAndSet(publishSubscriptionArr2)) {
            onError.onError(th2);
        }
    }

    public void onNext(T t11) {
        ObjectHelper.requireNonNull(t11, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        for (PublishSubscription onNext : (PublishSubscription[]) this.f18708c.get()) {
            onNext.onNext(t11);
        }
    }

    public void onSubscribe(Subscription subscription) {
        if (this.f18708c.get() == f18706e) {
            subscription.cancel();
        } else {
            subscription.request(Long.MAX_VALUE);
        }
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        PublishSubscription publishSubscription = new PublishSubscription(subscriber, this);
        subscriber.onSubscribe(publishSubscription);
        if (!b(publishSubscription)) {
            Throwable th2 = this.f18709d;
            if (th2 != null) {
                subscriber.onError(th2);
            } else {
                subscriber.onComplete();
            }
        } else if (publishSubscription.isCancelled()) {
            c(publishSubscription);
        }
    }
}
