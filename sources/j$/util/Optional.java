package j$.util;

import j$.util.function.Consumer;
import j$.util.function.Function;
import j$.util.function.Predicate;
import j$.util.function.Supplier;
import java.util.NoSuchElementException;
import java.util.Objects;

public final class Optional<T> {

    /* renamed from: b  reason: collision with root package name */
    private static final Optional f28564b = new Optional();

    /* renamed from: a  reason: collision with root package name */
    private final Object f28565a;

    private Optional() {
        this.f28565a = null;
    }

    private Optional(Object obj) {
        Objects.requireNonNull(obj);
        this.f28565a = obj;
    }

    public static <T> Optional<T> empty() {
        return f28564b;
    }

    public static <T> Optional<T> of(T t11) {
        return new Optional<>(t11);
    }

    public static <T> Optional<T> ofNullable(T t11) {
        return t11 == null ? empty() : of(t11);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Optional)) {
            return false;
        }
        return Objects.equals(this.f28565a, ((Optional) obj).f28565a);
    }

    public Optional<T> filter(Predicate<? super T> predicate) {
        Objects.requireNonNull(predicate);
        return !isPresent() ? this : predicate.test(this.f28565a) ? this : empty();
    }

    public <U> Optional<U> flatMap(Function<? super T, ? extends Optional<? extends U>> function) {
        Objects.requireNonNull(function);
        if (!isPresent()) {
            return empty();
        }
        Optional<U> optional = (Optional) function.apply(this.f28565a);
        Objects.requireNonNull(optional);
        return optional;
    }

    public T get() {
        T t11 = this.f28565a;
        if (t11 != null) {
            return t11;
        }
        throw new NoSuchElementException("No value present");
    }

    public final int hashCode() {
        return Objects.hashCode(this.f28565a);
    }

    public void ifPresent(Consumer<? super T> consumer) {
        Object obj = this.f28565a;
        if (obj != null) {
            consumer.accept(obj);
        }
    }

    public boolean isPresent() {
        return this.f28565a != null;
    }

    public <U> Optional<U> map(Function<? super T, ? extends U> function) {
        Objects.requireNonNull(function);
        return !isPresent() ? empty() : ofNullable(function.apply(this.f28565a));
    }

    public T orElse(T t11) {
        T t12 = this.f28565a;
        return t12 != null ? t12 : t11;
    }

    public T orElseGet(Supplier<? extends T> supplier) {
        T t11 = this.f28565a;
        return t11 != null ? t11 : supplier.get();
    }

    public <X extends Throwable> T orElseThrow(Supplier<? extends X> supplier) {
        T t11 = this.f28565a;
        if (t11 != null) {
            return t11;
        }
        throw ((Throwable) supplier.get());
    }

    public final String toString() {
        Object obj = this.f28565a;
        if (obj == null) {
            return "Optional.empty";
        }
        return String.format("Optional[%s]", new Object[]{obj});
    }
}
