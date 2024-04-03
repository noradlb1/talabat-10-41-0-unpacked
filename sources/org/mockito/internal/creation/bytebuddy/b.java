package org.mockito.internal.creation.bytebuddy;

import org.mockito.plugins.MemberAccessor;

public final /* synthetic */ class b implements MemberAccessor.OnConstruction {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ InlineDelegateByteBuddyMockMaker f63173a;

    public /* synthetic */ b(InlineDelegateByteBuddyMockMaker inlineDelegateByteBuddyMockMaker) {
        this.f63173a = inlineDelegateByteBuddyMockMaker;
    }

    public final Object invoke(MemberAccessor.ConstructionDispatcher constructionDispatcher) {
        return this.f63173a.lambda$newInstance$4(constructionDispatcher);
    }
}
