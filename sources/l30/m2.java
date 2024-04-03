package l30;

import j$.util.function.IntPredicate;

public final /* synthetic */ class m2 implements IntPredicate {
    public /* synthetic */ IntPredicate and(IntPredicate intPredicate) {
        return IntPredicate.CC.$default$and(this, intPredicate);
    }

    public /* synthetic */ IntPredicate negate() {
        return IntPredicate.CC.$default$negate(this);
    }

    public /* synthetic */ IntPredicate or(IntPredicate intPredicate) {
        return IntPredicate.CC.$default$or(this, intPredicate);
    }

    public final boolean test(int i11) {
        return Character.isWhitespace(i11);
    }
}
