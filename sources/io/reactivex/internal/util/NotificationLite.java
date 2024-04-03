package io.reactivex.internal.util;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.ObjectHelper;
import java.io.Serializable;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public enum NotificationLite {
    COMPLETE;

    public static final class DisposableNotification implements Serializable {
        private static final long serialVersionUID = -7482590109178395495L;

        /* renamed from: b  reason: collision with root package name */
        public final Disposable f18631b;

        public DisposableNotification(Disposable disposable) {
            this.f18631b = disposable;
        }

        public String toString() {
            return "NotificationLite.Disposable[" + this.f18631b + "]";
        }
    }

    public static final class ErrorNotification implements Serializable {
        private static final long serialVersionUID = -8759979445933046293L;

        /* renamed from: b  reason: collision with root package name */
        public final Throwable f18632b;

        public ErrorNotification(Throwable th2) {
            this.f18632b = th2;
        }

        public boolean equals(Object obj) {
            if (obj instanceof ErrorNotification) {
                return ObjectHelper.equals(this.f18632b, ((ErrorNotification) obj).f18632b);
            }
            return false;
        }

        public int hashCode() {
            return this.f18632b.hashCode();
        }

        public String toString() {
            return "NotificationLite.Error[" + this.f18632b + "]";
        }
    }

    public static final class SubscriptionNotification implements Serializable {
        private static final long serialVersionUID = -1322257508628817540L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscription f18633b;

        public SubscriptionNotification(Subscription subscription) {
            this.f18633b = subscription;
        }

        public String toString() {
            return "NotificationLite.Subscription[" + this.f18633b + "]";
        }
    }

    public static <T> boolean accept(Object obj, Subscriber<? super T> subscriber) {
        if (obj == COMPLETE) {
            subscriber.onComplete();
            return true;
        } else if (obj instanceof ErrorNotification) {
            subscriber.onError(((ErrorNotification) obj).f18632b);
            return true;
        } else {
            subscriber.onNext(obj);
            return false;
        }
    }

    public static <T> boolean acceptFull(Object obj, Subscriber<? super T> subscriber) {
        if (obj == COMPLETE) {
            subscriber.onComplete();
            return true;
        } else if (obj instanceof ErrorNotification) {
            subscriber.onError(((ErrorNotification) obj).f18632b);
            return true;
        } else if (obj instanceof SubscriptionNotification) {
            subscriber.onSubscribe(((SubscriptionNotification) obj).f18633b);
            return false;
        } else {
            subscriber.onNext(obj);
            return false;
        }
    }

    public static Object complete() {
        return COMPLETE;
    }

    public static Object disposable(Disposable disposable) {
        return new DisposableNotification(disposable);
    }

    public static Object error(Throwable th2) {
        return new ErrorNotification(th2);
    }

    public static Disposable getDisposable(Object obj) {
        return ((DisposableNotification) obj).f18631b;
    }

    public static Throwable getError(Object obj) {
        return ((ErrorNotification) obj).f18632b;
    }

    public static Subscription getSubscription(Object obj) {
        return ((SubscriptionNotification) obj).f18633b;
    }

    public static <T> T getValue(Object obj) {
        return obj;
    }

    public static boolean isComplete(Object obj) {
        return obj == COMPLETE;
    }

    public static boolean isDisposable(Object obj) {
        return obj instanceof DisposableNotification;
    }

    public static boolean isError(Object obj) {
        return obj instanceof ErrorNotification;
    }

    public static boolean isSubscription(Object obj) {
        return obj instanceof SubscriptionNotification;
    }

    public static <T> Object next(T t11) {
        return t11;
    }

    public static Object subscription(Subscription subscription) {
        return new SubscriptionNotification(subscription);
    }

    public String toString() {
        return "NotificationLite.Complete";
    }

    public static <T> boolean accept(Object obj, Observer<? super T> observer) {
        if (obj == COMPLETE) {
            observer.onComplete();
            return true;
        } else if (obj instanceof ErrorNotification) {
            observer.onError(((ErrorNotification) obj).f18632b);
            return true;
        } else {
            observer.onNext(obj);
            return false;
        }
    }

    public static <T> boolean acceptFull(Object obj, Observer<? super T> observer) {
        if (obj == COMPLETE) {
            observer.onComplete();
            return true;
        } else if (obj instanceof ErrorNotification) {
            observer.onError(((ErrorNotification) obj).f18632b);
            return true;
        } else if (obj instanceof DisposableNotification) {
            observer.onSubscribe(((DisposableNotification) obj).f18631b);
            return false;
        } else {
            observer.onNext(obj);
            return false;
        }
    }
}
