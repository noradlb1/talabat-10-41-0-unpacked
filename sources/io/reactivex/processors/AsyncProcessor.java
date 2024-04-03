package io.reactivex.processors;

import i.b;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.Nullable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class AsyncProcessor<T> extends FlowableProcessor<T> {

    /* renamed from: f  reason: collision with root package name */
    public static final AsyncSubscription[] f18665f = new AsyncSubscription[0];

    /* renamed from: g  reason: collision with root package name */
    public static final AsyncSubscription[] f18666g = new AsyncSubscription[0];

    /* renamed from: c  reason: collision with root package name */
    public final AtomicReference<AsyncSubscription<T>[]> f18667c = new AtomicReference<>(f18665f);

    /* renamed from: d  reason: collision with root package name */
    public Throwable f18668d;

    /* renamed from: e  reason: collision with root package name */
    public T f18669e;

    public static final class AsyncSubscription<T> extends DeferredScalarSubscription<T> {
        private static final long serialVersionUID = 5629876084736248016L;

        /* renamed from: d  reason: collision with root package name */
        public final AsyncProcessor<T> f18670d;

        public AsyncSubscription(Subscriber<? super T> subscriber, AsyncProcessor<T> asyncProcessor) {
            super(subscriber);
            this.f18670d = asyncProcessor;
        }

        public void cancel() {
            if (super.tryCancel()) {
                this.f18670d.c(this);
            }
        }

        public void onComplete() {
            if (!isCancelled()) {
                this.f18609b.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (isCancelled()) {
                RxJavaPlugins.onError(th2);
            } else {
                this.f18609b.onError(th2);
            }
        }
    }

    @CheckReturnValue
    @NonNull
    public static <T> AsyncProcessor<T> create() {
        return new AsyncProcessor<>();
    }

    public boolean b(AsyncSubscription<T> asyncSubscription) {
        AsyncSubscription[] asyncSubscriptionArr;
        AsyncSubscription[] asyncSubscriptionArr2;
        do {
            asyncSubscriptionArr = (AsyncSubscription[]) this.f18667c.get();
            if (asyncSubscriptionArr == f18666g) {
                return false;
            }
            int length = asyncSubscriptionArr.length;
            asyncSubscriptionArr2 = new AsyncSubscription[(length + 1)];
            System.arraycopy(asyncSubscriptionArr, 0, asyncSubscriptionArr2, 0, length);
            asyncSubscriptionArr2[length] = asyncSubscription;
        } while (!b.a(this.f18667c, asyncSubscriptionArr, asyncSubscriptionArr2));
        return true;
    }

    public void c(AsyncSubscription<T> asyncSubscription) {
        AsyncSubscription<T>[] asyncSubscriptionArr;
        AsyncSubscription[] asyncSubscriptionArr2;
        do {
            asyncSubscriptionArr = (AsyncSubscription[]) this.f18667c.get();
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
                        asyncSubscriptionArr2 = f18665f;
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
        } while (!b.a(this.f18667c, asyncSubscriptionArr, asyncSubscriptionArr2));
    }

    @Nullable
    public Throwable getThrowable() {
        if (this.f18667c.get() == f18666g) {
            return this.f18668d;
        }
        return null;
    }

    @Nullable
    public T getValue() {
        if (this.f18667c.get() == f18666g) {
            return this.f18669e;
        }
        return null;
    }

    @Deprecated
    public Object[] getValues() {
        Object value = getValue();
        if (value == null) {
            return new Object[0];
        }
        return new Object[]{value};
    }

    public boolean hasComplete() {
        return this.f18667c.get() == f18666g && this.f18668d == null;
    }

    public boolean hasSubscribers() {
        return ((AsyncSubscription[]) this.f18667c.get()).length != 0;
    }

    public boolean hasThrowable() {
        return this.f18667c.get() == f18666g && this.f18668d != null;
    }

    public boolean hasValue() {
        return this.f18667c.get() == f18666g && this.f18669e != null;
    }

    public void onComplete() {
        AsyncSubscription<T>[] asyncSubscriptionArr = this.f18667c.get();
        AsyncSubscription<T>[] asyncSubscriptionArr2 = f18666g;
        if (asyncSubscriptionArr != asyncSubscriptionArr2) {
            T t11 = this.f18669e;
            AsyncSubscription[] asyncSubscriptionArr3 = (AsyncSubscription[]) this.f18667c.getAndSet(asyncSubscriptionArr2);
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

    public void onError(Throwable th2) {
        ObjectHelper.requireNonNull(th2, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        AsyncSubscription<T>[] asyncSubscriptionArr = this.f18667c.get();
        AsyncSubscription<T>[] asyncSubscriptionArr2 = f18666g;
        if (asyncSubscriptionArr == asyncSubscriptionArr2) {
            RxJavaPlugins.onError(th2);
            return;
        }
        this.f18669e = null;
        this.f18668d = th2;
        for (AsyncSubscription onError : (AsyncSubscription[]) this.f18667c.getAndSet(asyncSubscriptionArr2)) {
            onError.onError(th2);
        }
    }

    public void onNext(T t11) {
        ObjectHelper.requireNonNull(t11, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.f18667c.get() != f18666g) {
            this.f18669e = t11;
        }
    }

    public void onSubscribe(Subscription subscription) {
        if (this.f18667c.get() == f18666g) {
            subscription.cancel();
        } else {
            subscription.request(Long.MAX_VALUE);
        }
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        AsyncSubscription asyncSubscription = new AsyncSubscription(subscriber, this);
        subscriber.onSubscribe(asyncSubscription);
        if (!b(asyncSubscription)) {
            Throwable th2 = this.f18668d;
            if (th2 != null) {
                subscriber.onError(th2);
                return;
            }
            T t11 = this.f18669e;
            if (t11 != null) {
                asyncSubscription.complete(t11);
            } else {
                asyncSubscription.onComplete();
            }
        } else if (asyncSubscription.isCancelled()) {
            c(asyncSubscription);
        }
    }

    @Deprecated
    public T[] getValues(T[] tArr) {
        T value = getValue();
        if (value == null) {
            if (tArr.length != 0) {
                tArr[0] = null;
            }
            return tArr;
        }
        if (tArr.length == 0) {
            tArr = Arrays.copyOf(tArr, 1);
        }
        tArr[0] = value;
        if (tArr.length != 1) {
            tArr[1] = null;
        }
        return tArr;
    }
}
