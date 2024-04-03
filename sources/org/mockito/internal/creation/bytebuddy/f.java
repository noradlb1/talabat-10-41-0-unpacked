package org.mockito.internal.creation.bytebuddy;

public final /* synthetic */ class f implements ConstructionCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ InlineDelegateByteBuddyMockMaker f63177a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ThreadLocal f63178b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ThreadLocal f63179c;

    public /* synthetic */ f(InlineDelegateByteBuddyMockMaker inlineDelegateByteBuddyMockMaker, ThreadLocal threadLocal, ThreadLocal threadLocal2) {
        this.f63177a = inlineDelegateByteBuddyMockMaker;
        this.f63178b = threadLocal;
        this.f63179c = threadLocal2;
    }

    public final Object apply(Class cls, Object obj, Object[] objArr, String[] strArr) {
        return this.f63177a.lambda$new$3(this.f63178b, this.f63179c, cls, obj, objArr, strArr);
    }
}
