package io.reactivex.rxjava3.core;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.internal.util.NotificationLite;
import java.util.Objects;

public final class Notification<T> {

    /* renamed from: b  reason: collision with root package name */
    public static final Notification<Object> f18764b = new Notification<>((Object) null);

    /* renamed from: a  reason: collision with root package name */
    public final Object f18765a;

    private Notification(@Nullable Object obj) {
        this.f18765a = obj;
    }

    @NonNull
    public static <T> Notification<T> createOnComplete() {
        return f18764b;
    }

    @NonNull
    public static <T> Notification<T> createOnError(@NonNull Throwable th2) {
        Objects.requireNonNull(th2, "error is null");
        return new Notification<>(NotificationLite.error(th2));
    }

    @NonNull
    public static <T> Notification<T> createOnNext(T t11) {
        Objects.requireNonNull(t11, "value is null");
        return new Notification<>(t11);
    }

    public boolean equals(Object obj) {
        if (obj instanceof Notification) {
            return Objects.equals(this.f18765a, ((Notification) obj).f18765a);
        }
        return false;
    }

    @Nullable
    public Throwable getError() {
        Object obj = this.f18765a;
        if (NotificationLite.isError(obj)) {
            return NotificationLite.getError(obj);
        }
        return null;
    }

    @Nullable
    public T getValue() {
        Object obj = this.f18765a;
        if (obj == null || NotificationLite.isError(obj)) {
            return null;
        }
        return this.f18765a;
    }

    public int hashCode() {
        Object obj = this.f18765a;
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    public boolean isOnComplete() {
        return this.f18765a == null;
    }

    public boolean isOnError() {
        return NotificationLite.isError(this.f18765a);
    }

    public boolean isOnNext() {
        Object obj = this.f18765a;
        if (obj == null || NotificationLite.isError(obj)) {
            return false;
        }
        return true;
    }

    public String toString() {
        Object obj = this.f18765a;
        if (obj == null) {
            return "OnCompleteNotification";
        }
        if (NotificationLite.isError(obj)) {
            return "OnErrorNotification[" + NotificationLite.getError(obj) + "]";
        }
        return "OnNextNotification[" + this.f18765a + "]";
    }
}
