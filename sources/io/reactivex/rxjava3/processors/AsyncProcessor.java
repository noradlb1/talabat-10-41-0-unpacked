package io.reactivex.rxjava3.processors;

import i.b;
import io.reactivex.rxjava3.annotations.CheckReturnValue;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class AsyncProcessor<T> extends FlowableProcessor<T> {

    /* renamed from: f  reason: collision with root package name */
    public static final AsyncSubscription[] f23264f = new AsyncSubscription[0];

    /* renamed from: g  reason: collision with root package name */
    public static final AsyncSubscription[] f23265g = new AsyncSubscription[0];

    /* renamed from: c  reason: collision with root package name */
    public final AtomicReference<AsyncSubscription<T>[]> f23266c = new AtomicReference<>(f23264f);

    /* renamed from: d  reason: collision with root package name */
    public Throwable f23267d;

    /* renamed from: e  reason: collision with root package name */
    public T f23268e;

    public static final class AsyncSubscription<T> extends DeferredScalarSubscription<T> {
        private static final long serialVersionUID = 5629876084736248016L;

        /* renamed from: d  reason: collision with root package name */
        public final AsyncProcessor<T> f23269d;

        public AsyncSubscription(Subscriber<? super T> subscriber, AsyncProcessor<T> asyncProcessor) {
            super(subscriber);
            this.f23269d = asyncProcessor;
        }

        public void cancel() {
            if (super.tryCancel()) {
                this.f23269d.c(this);
            }
        }

        public void onComplete() {
            if (!isCancelled()) {
                this.f23170b.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (isCancelled()) {
                RxJavaPlugins.onError(th2);
            } else {
                this.f23170b.onError(th2);
            }
        }
    }

    @NonNull
    @CheckReturnValue
    public static <T> AsyncProcessor<T> create() {
        return new AsyncProcessor<>();
    }

    public boolean b(AsyncSubscription<T> asyncSubscription) {
        AsyncSubscription[] asyncSubscriptionArr;
        AsyncSubscription[] asyncSubscriptionArr2;
        do {
            asyncSubscriptionArr = (AsyncSubscription[]) this.f23266c.get();
            if (asyncSubscriptionArr == f23265g) {
                return false;
            }
            int length = asyncSubscriptionArr.length;
            asyncSubscriptionArr2 = new AsyncSubscription[(length + 1)];
            System.arraycopy(asyncSubscriptionArr, 0, asyncSubscriptionArr2, 0, length);
            asyncSubscriptionArr2[length] = asyncSubscription;
        } while (!b.a(this.f23266c, asyncSubscriptionArr, asyncSubscriptionArr2));
        return true;
    }

    public void c(AsyncSubscription<T> asyncSubscription) {
        AsyncSubscription<T>[] asyncSubscriptionArr;
        AsyncSubscription[] asyncSubscriptionArr2;
        do {
            asyncSubscriptionArr = (AsyncSubscription[]) this.f23266c.get();
            int length = asyncSubscriptionArr.length;
            if (length != 0) {
                int i11 = 0;
                while (true) {
                    if (i11 >= length) {
                        i11 = -1;
                        break;
                    } else if (asyncSubscriptionArr[i11] == asyncSubscription) {
                        break;
                    } else {
                        i11++;
                    }
                }
                if (i11 >= 0) {
                    if (length == 1) {
                        asyncSubscriptionArr2 = f23264f;
                    } else {
                        AsyncSubscription[] asyncSubscriptionArr3 = new AsyncSubscription[(length - 1)];
                        System.arraycopy(asyncSubscriptionArr, 0, asyncSubscriptionArr3, 0, i11);
                        System.arraycopy(asyncSubscriptionArr, i11 + 1, asyncSubscriptionArr3, i11, (length - i11) - 1);
                        asyncSubscriptionArr2 = asyncSubscriptionArr3;
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        } while (!b.a(this.f23266c, asyncSubscriptionArr, asyncSubscriptionArr2));
    }

    @CheckReturnValue
    @Nullable
    public Throwable getThrowable() {
        if (this.f23266c.get() == f23265g) {
            return this.f23267d;
        }
        return null;
    }

    @CheckReturnValue
    @Nullable
    public T getValue() {
        if (this.f23266c.get() == f23265g) {
            return this.f23268e;
        }
        return null;
    }

    @CheckReturnValue
    public boolean hasComplete() {
        return this.f23266c.get() == f23265g && this.f23267d == null;
    }

    @CheckReturnValue
    public boolean hasSubscribers() {
        return ((AsyncSubscription[]) this.f23266c.get()).length != 0;
    }

    @CheckReturnValue
    public boolean hasThrowable() {
        return this.f23266c.get() == f23265g && this.f23267d != null;
    }

    @CheckReturnValue
    public boolean hasValue() {
        return this.f23266c.get() == f23265g && this.f23268e != null;
    }

    public void onComplete() {
        AsyncSubscription<T>[] asyncSubscriptionArr = this.f23266c.get();
        AsyncSubscription<T>[] asyncSubscriptionArr2 = f23265g;
        if (asyncSubscriptionArr != asyncSubscriptionArr2) {
            T t11 = this.f23268e;
            AsyncSubscription[] asyncSubscriptionArr3 = (AsyncSubscription[]) this.f23266c.getAndSet(asyncSubscriptionArr2);
            int i11 = 0;
            if (t11 == null) {
                int length = asyncSubscriptionArr3.length;
                while (i11 < length) {
                    asyncSubscriptionArr3[i11].onComplete();
                    i11++;
                }
                return;
            }
            int length2 = asyncSubscriptionArr3.length;
            while (i11 < length2) {
                asyncSubscriptionArr3[i11].complete(t11);
                i11++;
            }
        }
    }

    public void onError(@NonNull Throwable th2) {
        ExceptionHelper.nullCheck(th2, "onError called with a null Throwable.");
        AsyncSubscription<T>[] asyncSubscriptionArr = this.f23266c.get();
        AsyncSubscription<T>[] asyncSubscriptionArr2 = f23265g;
        if (asyncSubscriptionArr == asyncSubscriptionArr2) {
            RxJavaPlugins.onError(th2);
            return;
        }
        this.f23268e = null;
        this.f23267d = th2;
        for (AsyncSubscription onError : (AsyncSubscription[]) this.f23266c.getAndSet(asyncSubscriptionArr2)) {
            onError.onError(th2);
        }
    }

    public void onNext(@NonNull T t11) {
        ExceptionHelper.nullCheck(t11, "onNext called with a null value.");
        if (this.f23266c.get() != f23265g) {
            this.f23268e = t11;
        }
    }

    public void onSubscribe(@NonNull Subscription subscription) {
        if (this.f23266c.get() == f23265g) {
            subscription.cancel();
        } else {
            subscription.request(Long.MAX_VALUE);
        }
    }

    public void subscribeActual(@NonNull Subscriber<? super T> subscriber) {
        AsyncSubscription asyncSubscription = new AsyncSubscription(subscriber, this);
        subscriber.onSubscribe(asyncSubscription);
        if (!b(asyncSubscription)) {
            Throwable th2 = this.f23267d;
            if (th2 != null) {
                subscriber.onError(th2);
                return;
            }
            T t11 = this.f23268e;
            if (t11 != null) {
                asyncSubscription.complete(t11);
            } else {
                asyncSubscription.onComplete();
            }
        } else if (asyncSubscription.isCancelled()) {
            c(asyncSubscription);
        }
    }
}
