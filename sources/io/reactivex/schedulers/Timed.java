package io.reactivex.schedulers;

import io.reactivex.annotations.NonNull;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.TimeUnit;

public final class Timed<T> {

    /* renamed from: a  reason: collision with root package name */
    public final T f23574a;

    /* renamed from: b  reason: collision with root package name */
    public final long f23575b;

    /* renamed from: c  reason: collision with root package name */
    public final TimeUnit f23576c;

    public Timed(@NonNull T t11, long j11, @NonNull TimeUnit timeUnit) {
        this.f23574a = t11;
        this.f23575b = j11;
        this.f23576c = (TimeUnit) ObjectHelper.requireNonNull(timeUnit, "unit is null");
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Timed)) {
            return false;
        }
        Timed timed = (Timed) obj;
        if (!ObjectHelper.equals(this.f23574a, timed.f23574a) || this.f23575b != timed.f23575b || !ObjectHelper.equals(this.f23576c, timed.f23576c)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i11;
        T t11 = this.f23574a;
        if (t11 != null) {
            i11 = t11.hashCode();
        } else {
            i11 = 0;
        }
        long j11 = this.f23575b;
        return (((i11 * 31) + ((int) (j11 ^ (j11 >>> 31)))) * 31) + this.f23576c.hashCode();
    }

    public long time() {
        return this.f23575b;
    }

    public String toString() {
        return "Timed[time=" + this.f23575b + ", unit=" + this.f23576c + ", value=" + this.f23574a + "]";
    }

    @NonNull
    public TimeUnit unit() {
        return this.f23576c;
    }

    @NonNull
    public T value() {
        return this.f23574a;
    }

    public long time(@NonNull TimeUnit timeUnit) {
        return timeUnit.convert(this.f23575b, this.f23576c);
    }
}
