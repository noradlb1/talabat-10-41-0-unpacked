package j$.util.function;

import java.util.function.IntPredicate;

public final /* synthetic */ class N implements IntPredicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ IntPredicate f28814a;

    private /* synthetic */ N(IntPredicate intPredicate) {
        this.f28814a = intPredicate;
    }

    public static /* synthetic */ IntPredicate a(IntPredicate intPredicate) {
        if (intPredicate == null) {
            return null;
        }
        return intPredicate instanceof O ? ((O) intPredicate).f28815a : new N(intPredicate);
    }

    public final /* synthetic */ IntPredicate and(IntPredicate intPredicate) {
        return a(this.f28814a.and(O.a(intPredicate)));
    }

    public final /* synthetic */ boolean equals(Object obj) {
        if (obj instanceof N) {
            obj = ((N) obj).f28814a;
        }
        return this.f28814a.equals(obj);
    }

    public final /* synthetic */ int hashCode() {
        return this.f28814a.hashCode();
    }

    public final /* synthetic */ IntPredicate negate() {
        return a(this.f28814a.negate());
    }

    public final /* synthetic */ IntPredicate or(IntPredicate intPredicate) {
        return a(this.f28814a.or(O.a(intPredicate)));
    }

    public final /* synthetic */ boolean test(int i11) {
        return this.f28814a.test(i11);
    }
}
