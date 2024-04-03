package com.checkout.frames.view;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class InternalButtonKt$ButtonPreview$1$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ InternalButtonState $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InternalButtonKt$ButtonPreview$1$1(InternalButtonState internalButtonState) {
        super(0);
        this.$state = internalButtonState;
    }

    public final void invoke() {
        this.$state.isEnabled().setValue(Boolean.valueOf(!this.$state.isEnabled().getValue().booleanValue()));
    }
}
