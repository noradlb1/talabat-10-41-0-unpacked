package io.reactivex;

import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.Nullable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.NotificationLite;

public final class Notification<T> {

    /* renamed from: b  reason: collision with root package name */
    public static final Notification<Object> f14476b = new Notification<>((Object) null);

    /* renamed from: a  reason: collision with root package name */
    public final Object f14477a;

    private Notification(Object obj) {
        this.f14477a = obj;
    }

    @NonNull
    public static <T> Notification<T> createOnComplete() {
        return f14476b;
    }

    @NonNull
    public static <T> Notification<T> createOnError(@NonNull Throwable th2) {
        ObjectHelper.requireNonNull(th2, "error is null");
        return new Notification<>(NotificationLite.error(th2));
    }

    @NonNull
    public static <T> Notification<T> createOnNext(@NonNull T t11) {
        ObjectHelper.requireNonNull(t11, "value is null");
        return new Notification<>(t11);
    }

    public boolean equals(Object obj) {
        if (obj instanceof Notification) {
            return ObjectHelper.equals(this.f14477a, ((Notification) obj).f14477a);
        }
        return false;
    }

    @Nullable
    public Throwable getError() {
        Object obj = this.f14477a;
        if (NotificationLite.isError(obj)) {
            return NotificationLite.getError(obj);
        }
        return null;
    }

    @Nullable
    public T getValue() {
        Object obj = this.f14477a;
        if (obj == null || NotificationLite.isError(obj)) {
            return null;
        }
        return this.f14477a;
    }

    public int hashCode() {
        Object obj = this.f14477a;
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    public boolean isOnComplete() {
        return this.f14477a == null;
    }

    public boolean isOnError() {
        return NotificationLite.isError(this.f14477a);
    }

    public boolean isOnNext() {
        Object obj = this.f14477a;
        if (obj == null || NotificationLite.isError(obj)) {
            return false;
        }
        return true;
    }

    public String toString() {
        Object obj = this.f14477a;
        if (obj == null) {
            return "OnCompleteNotification";
        }
        if (NotificationLite.isError(obj)) {
            return "OnErrorNotification[" + NotificationLite.getError(obj) + "]";
        }
        return "OnNextNotification[" + this.f14477a + "]";
    }
}
