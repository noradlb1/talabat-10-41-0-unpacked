package org.mockito.internal.creation.bytebuddy;

import j$.util.function.Predicate;

public final /* synthetic */ class e implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ InlineDelegateByteBuddyMockMaker f63174a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ThreadLocal f63175b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ThreadLocal f63176c;

    public /* synthetic */ e(InlineDelegateByteBuddyMockMaker inlineDelegateByteBuddyMockMaker, ThreadLocal threadLocal, ThreadLocal threadLocal2) {
        this.f63174a = inlineDelegateByteBuddyMockMaker;
        this.f63175b = threadLocal;
        this.f63176c = threadLocal2;
    }

    public /* synthetic */ Predicate and(Predicate predicate) {
        return Predicate.CC.$default$and(this, predicate);
    }

    public /* synthetic */ Predicate negate() {
        return Predicate.CC.$default$negate(this);
    }

    public /* synthetic */ Predicate or(Predicate predicate) {
        return Predicate.CC.$default$or(this, predicate);
    }

    public final boolean test(Object obj) {
        return this.f63174a.lambda$new$2(this.f63175b, this.f63176c, (Class) obj);
    }
}
