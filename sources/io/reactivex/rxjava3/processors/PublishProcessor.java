package io.reactivex.rxjava3.processors;

import i.b;
import io.reactivex.rxjava3.annotations.CheckReturnValue;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class PublishProcessor<T> extends FlowableProcessor<T> {

    /* renamed from: e  reason: collision with root package name */
    public static final PublishSubscription[] f23304e = new PublishSubscription[0];

    /* renamed from: f  reason: collision with root package name */
    public static final PublishSubscription[] f23305f = new PublishSubscription[0];

    /* renamed from: c  reason: collision with root package name */
    public final AtomicReference<PublishSubscription<T>[]> f23306c = new AtomicReference<>(f23305f);

    /* renamed from: d  reason: collision with root package name */
    public Throwable f23307d;

    public static final class PublishSubscription<T> extends AtomicLong implements Subscription {
        private static final long serialVersionUID = 3562861878281475070L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super T> f23308b;

        /* renamed from: c  reason: collision with root package name */
        public final PublishProcessor<T> f23309c;

        public PublishSubscription(Subscriber<? super T> subscriber, PublishProcessor<T> publishProcessor) {
            this.f23308b = subscriber;
            this.f23309c = publishProcessor;
        }

        public boolean a() {
            return get() == 0;
        }

        public void cancel() {
            if (getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.f23309c.c(this);
            }
        }

        public boolean isCancelled() {
            return get() == Long.MIN_VALUE;
        }

        public void onComplete() {
            if (get() != Long.MIN_VALUE) {
                this.f23308b.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (get() != Long.MIN_VALUE) {
                this.f23308b.onError(th2);
            } else {
                RxJavaPlugins.onError(th2);
            }
        }

        public void onNext(T t11) {
            long j11 = get();
            if (j11 != Long.MIN_VALUE) {
                if (j11 != 0) {
                    this.f23308b.onNext(t11);
                    BackpressureHelper.producedCancel(this, 1);
                    return;
                }
                cancel();
                this.f23308b.onError(new MissingBackpressureException("Could not emit value due to lack of requests"));
            }
        }

        public void request(long j11) {
            if (SubscriptionHelper.validate(j11)) {
                BackpressureHelper.addCancel(this, j11);
            }
        }
    }

    @NonNull
    @CheckReturnValue
    public static <T> PublishProcessor<T> create() {
        return new PublishProcessor<>();
    }

    public boolean b(PublishSubscription<T> publishSubscription) {
        PublishSubscription[] publishSubscriptionArr;
        PublishSubscription[] publishSubscriptionArr2;
        do {
            publishSubscriptionArr = (PublishSubscription[]) this.f23306c.get();
            if (publishSubscriptionArr == f23304e) {
                return false;
            }
            int length = publishSubscriptionArr.length;
            publishSubscriptionArr2 = new PublishSubscription[(length + 1)];
            System.arraycopy(publishSubscriptionArr, 0, publishSubscriptionArr2, 0, length);
            publishSubscriptionArr2[length] = publishSubscription;
        } while (!b.a(this.f23306c, publishSubscriptionArr, publishSubscriptionArr2));
        return true;
    }

    public void c(PublishSubscription<T> publishSubscription) {
        PublishSubscription<T>[] publishSubscriptionArr;
        PublishSubscription[] publishSubscriptionArr2;
        do {
            publishSubscriptionArr = (PublishSubscription[]) this.f23306c.get();
            if (publishSubscriptionArr != f23304e && publishSubscriptionArr != f23305f) {
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
                        publishSubscriptionArr2 = f23305f;
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
        } while (!b.a(this.f23306c, publishSubscriptionArr, publishSubscriptionArr2));
    }

    @CheckReturnValue
    @Nullable
    public Throwable getThrowable() {
        if (this.f23306c.get() == f23304e) {
            return this.f23307d;
        }
        return null;
    }

    @CheckReturnValue
    public boolean hasComplete() {
        return this.f23306c.get() == f23304e && this.f23307d == null;
    }

    @CheckReturnValue
    public boolean hasSubscribers() {
        return ((PublishSubscription[]) this.f23306c.get()).length != 0;
    }

    @CheckReturnValue
    public boolean hasThrowable() {
        return this.f23306c.get() == f23304e && this.f23307d != null;
    }

    @CheckReturnValue
    public boolean offer(@NonNull T t11) {
        ExceptionHelper.nullCheck(t11, "offer called with a null value.");
        PublishSubscription[] publishSubscriptionArr = (PublishSubscription[]) this.f23306c.get();
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
        PublishSubscription<T>[] publishSubscriptionArr = this.f23306c.get();
        PublishSubscription<T>[] publishSubscriptionArr2 = f23304e;
        if (publishSubscriptionArr != publishSubscriptionArr2) {
            for (PublishSubscription onComplete : (PublishSubscription[]) this.f23306c.getAndSet(publishSubscriptionArr2)) {
                onComplete.onComplete();
            }
        }
    }

    public void onError(@NonNull Throwable th2) {
        ExceptionHelper.nullCheck(th2, "onError called with a null Throwable.");
        PublishSubscription<T>[] publishSubscriptionArr = this.f23306c.get();
        PublishSubscription<T>[] publishSubscriptionArr2 = f23304e;
        if (publishSubscriptionArr == publishSubscriptionArr2) {
            RxJavaPlugins.onError(th2);
            return;
        }
        this.f23307d = th2;
        for (PublishSubscription onError : (PublishSubscription[]) this.f23306c.getAndSet(publishSubscriptionArr2)) {
            onError.onError(th2);
        }
    }

    public void onNext(@NonNull T t11) {
        ExceptionHelper.nullCheck(t11, "onNext called with a null value.");
        for (PublishSubscription onNext : (PublishSubscription[]) this.f23306c.get()) {
            onNext.onNext(t11);
        }
    }

    public void onSubscribe(@NonNull Subscription subscription) {
        if (this.f23306c.get() == f23304e) {
            subscription.cancel();
        } else {
            subscription.request(Long.MAX_VALUE);
        }
    }

    public void subscribeActual(@NonNull Subscriber<? super T> subscriber) {
        PublishSubscription publishSubscription = new PublishSubscription(subscriber, this);
        subscriber.onSubscribe(publishSubscription);
        if (!b(publishSubscription)) {
            Throwable th2 = this.f23307d;
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
