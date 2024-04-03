package j$.util.function;

import j$.util.function.Predicate;
import java.util.function.Predicate;

public final /* synthetic */ class G0 implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Predicate f28800a;

    private /* synthetic */ G0(Predicate predicate) {
        this.f28800a = predicate;
    }

    public static /* synthetic */ Predicate a(Predicate predicate) {
        if (predicate == null) {
            return null;
        }
        return predicate instanceof Predicate.VivifiedWrapper ? ((Predicate.VivifiedWrapper) predicate).f28819a : new G0(predicate);
    }

    public final /* synthetic */ java.util.function.Predicate and(java.util.function.Predicate predicate) {
        return a(this.f28800a.and(Predicate.VivifiedWrapper.convert(predicate)));
    }

    public final /* synthetic */ boolean equals(Object obj) {
        Predicate predicate = this.f28800a;
        if (obj instanceof G0) {
            obj = ((G0) obj).f28800a;
        }
        return predicate.equals(obj);
    }

    public final /* synthetic */ int hashCode() {
        return this.f28800a.hashCode();
    }

    public final /* synthetic */ java.util.function.Predicate negate() {
        return a(this.f28800a.negate());
    }

    public final /* synthetic */ java.util.function.Predicate or(java.util.function.Predicate predicate) {
        return a(this.f28800a.or(Predicate.VivifiedWrapper.convert(predicate)));
    }

    public final /* synthetic */ boolean test(Object obj) {
        return this.f28800a.test(obj);
    }
}
