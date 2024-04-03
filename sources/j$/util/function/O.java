package j$.util.function;

import java.util.function.IntPredicate;

public final /* synthetic */ class O implements IntPredicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ IntPredicate f28815a;

    private /* synthetic */ O(IntPredicate intPredicate) {
        this.f28815a = intPredicate;
    }

    public static /* synthetic */ IntPredicate a(IntPredicate intPredicate) {
        if (intPredicate == null) {
            return null;
        }
        return intPredicate instanceof N ? ((N) intPredicate).f28814a : new O(intPredicate);
    }

    public final /* synthetic */ IntPredicate and(IntPredicate intPredicate) {
        return a(this.f28815a.and(N.a(intPredicate)));
    }

    public final /* synthetic */ boolean equals(Object obj) {
        IntPredicate intPredicate = this.f28815a;
        if (obj instanceof O) {
            obj = ((O) obj).f28815a;
        }
        return intPredicate.equals(obj);
    }

    public final /* synthetic */ int hashCode() {
        return this.f28815a.hashCode();
    }

    public final /* synthetic */ IntPredicate negate() {
        return a(this.f28815a.negate());
    }

    public final /* synthetic */ IntPredicate or(IntPredicate intPredicate) {
        return a(this.f28815a.or(N.a(intPredicate)));
    }

    public final /* synthetic */ boolean test(int i11) {
        return this.f28815a.test(i11);
    }
}
