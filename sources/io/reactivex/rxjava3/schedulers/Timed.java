package io.reactivex.rxjava3.schedulers;

import io.reactivex.rxjava3.annotations.NonNull;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public final class Timed<T> {

    /* renamed from: a  reason: collision with root package name */
    public final T f23379a;

    /* renamed from: b  reason: collision with root package name */
    public final long f23380b;

    /* renamed from: c  reason: collision with root package name */
    public final TimeUnit f23381c;

    public Timed(@NonNull T t11, long j11, @NonNull TimeUnit timeUnit) {
        Objects.requireNonNull(t11, "value is null");
        this.f23379a = t11;
        this.f23380b = j11;
        Objects.requireNonNull(timeUnit, "unit is null");
        this.f23381c = timeUnit;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Timed)) {
            return false;
        }
        Timed timed = (Timed) obj;
        if (!Objects.equals(this.f23379a, timed.f23379a) || this.f23380b != timed.f23380b || !Objects.equals(this.f23381c, timed.f23381c)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        long j11 = this.f23380b;
        return (((this.f23379a.hashCode() * 31) + ((int) (j11 ^ (j11 >>> 31)))) * 31) + this.f23381c.hashCode();
    }

    public long time() {
        return this.f23380b;
    }

    public String toString() {
        return "Timed[time=" + this.f23380b + ", unit=" + this.f23381c + ", value=" + this.f23379a + "]";
    }

    @NonNull
    public TimeUnit unit() {
        return this.f23381c;
    }

    @NonNull
    public T value() {
        return this.f23379a;
    }

    public long time(@NonNull TimeUnit timeUnit) {
        return timeUnit.convert(this.f23380b, this.f23381c);
    }
}
