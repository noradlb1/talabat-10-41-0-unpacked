package r1;

import android.annotation.SuppressLint;
import androidx.core.util.Predicate;
import java.util.Objects;

public final /* synthetic */ class j<T> {
    @SuppressLint({"MissingNullability"})
    public static Predicate a(Predicate predicate, @SuppressLint({"MissingNullability"}) Predicate predicate2) {
        Objects.requireNonNull(predicate2);
        return new h(predicate, predicate2);
    }

    @SuppressLint({"MissingNullability"})
    public static Predicate b(Predicate predicate) {
        return new i(predicate);
    }

    @SuppressLint({"MissingNullability"})
    public static Predicate c(Predicate predicate, @SuppressLint({"MissingNullability"}) Predicate predicate2) {
        Objects.requireNonNull(predicate2);
        return new e(predicate, predicate2);
    }

    public static /* synthetic */ boolean d(Predicate predicate, Predicate predicate2, Object obj) {
        return predicate.test(obj) && predicate2.test(obj);
    }

    public static /* synthetic */ boolean e(Predicate predicate, Object obj) {
        return !predicate.test(obj);
    }

    public static /* synthetic */ boolean f(Predicate predicate, Predicate predicate2, Object obj) {
        return predicate.test(obj) || predicate2.test(obj);
    }

    @SuppressLint({"MissingNullability"})
    public static <T> Predicate<T> g(@SuppressLint({"MissingNullability"}) Object obj) {
        if (obj == null) {
            return new f();
        }
        return new g(obj);
    }

    @SuppressLint({"MissingNullability"})
    public static <T> Predicate<T> j(@SuppressLint({"MissingNullability"}) Predicate<? super T> predicate) {
        Objects.requireNonNull(predicate);
        return predicate.negate();
    }
}
