package org.mockito.internal.creation.bytebuddy;

import j$.util.function.BiConsumer;
import org.mockito.MockedConstruction;
import org.mockito.internal.creation.bytebuddy.InlineDelegateByteBuddyMockMaker;

public final /* synthetic */ class g implements BiConsumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ InlineDelegateByteBuddyMockMaker.InlineConstructionMockControl f63180b;

    public /* synthetic */ g(InlineDelegateByteBuddyMockMaker.InlineConstructionMockControl inlineConstructionMockControl) {
        this.f63180b = inlineConstructionMockControl;
    }

    public final void accept(Object obj, Object obj2) {
        this.f63180b.lambda$enable$0(obj, (MockedConstruction.Context) obj2);
    }

    public /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
        return BiConsumer.CC.$default$andThen(this, biConsumer);
    }
}
