package org.junit.jupiter.api;

import j$.util.function.IntPredicate;
import org.junit.jupiter.api.AssertLinesMatch;

public final /* synthetic */ class e implements IntPredicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AssertLinesMatch.LinesMatcher f57146a;

    public /* synthetic */ e(AssertLinesMatch.LinesMatcher linesMatcher) {
        this.f57146a = linesMatcher;
    }

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
        return this.f57146a.lambda$assertLinesMatch$0(i11);
    }
}
