package io.reactivex.internal.subscriptions;

import io.reactivex.annotations.Nullable;
import org.reactivestreams.Subscriber;

public class DeferredScalarSubscription<T> extends BasicIntQueueSubscription<T> {
    private static final long serialVersionUID = -2151279923272604993L;

    /* renamed from: b  reason: collision with root package name */
    public final Subscriber<? super T> f18609b;

    /* renamed from: c  reason: collision with root package name */
    public T f18610c;

    public DeferredScalarSubscription(Subscriber<? super T> subscriber) {
        this.f18609b = subscriber;
    }

    public void cancel() {
        set(4);
        this.f18610c = null;
    }

    public final void clear() {
        lazySet(32);
        this.f18610c = null;
    }

    public final void complete(T t11) {
        int i11 = get();
        while (i11 != 8) {
            if ((i11 & -3) == 0) {
                if (i11 == 2) {
                    lazySet(3);
                    Subscriber<? super T> subscriber = this.f18609b;
                    subscriber.onNext(t11);
                    if (get() != 4) {
                        subscriber.onComplete();
                        return;
                    }
                    return;
                }
                this.f18610c = t11;
                if (!compareAndSet(0, 1)) {
                    i11 = get();
                    if (i11 == 4) {
                        this.f18610c = null;
                        return;
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        }
        this.f18610c = t11;
        lazySet(16);
        Subscriber<? super T> subscriber2 = this.f18609b;
        subscriber2.onNext(t11);
        if (get() != 4) {
            subscriber2.onComplete();
        }
    }

    public final boolean isCancelled() {
        return get() == 4;
    }

    public final boolean isEmpty() {
        return get() != 16;
    }

    @Nullable
    public final T poll() {
        if (get() != 16) {
            return null;
        }
        lazySet(32);
        T t11 = this.f18610c;
        this.f18610c = null;
        return t11;
    }

    public final void request(long j11) {
        T t11;
        if (SubscriptionHelper.validate(j11)) {
            do {
                int i11 = get();
                if ((i11 & -2) == 0) {
                    if (i11 == 1) {
                        if (compareAndSet(1, 3) && (t11 = this.f18610c) != null) {
                            this.f18610c = null;
                            Subscriber<? super T> subscriber = this.f18609b;
                            subscriber.onNext(t11);
                            if (get() != 4) {
                                subscriber.onComplete();
                                return;
                            }
                            return;
                        }
                        return;
                    }
                } else {
                    return;
                }
            } while (!compareAndSet(0, 2));
        }
    }

    public final int requestFusion(int i11) {
        if ((i11 & 2) == 0) {
            return 0;
        }
        lazySet(8);
        return 2;
    }

    public final boolean tryCancel() {
        return getAndSet(4) != 4;
    }
}
