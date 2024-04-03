package com.checkout.frames.component.paybutton;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class PayButtonComponentKt$PayButtonComponent$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ PayButtonViewModel $viewModel;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PayButtonComponentKt$PayButtonComponent$1(PayButtonViewModel payButtonViewModel) {
        super(0);
        this.$viewModel = payButtonViewModel;
    }

    public final void invoke() {
        this.$viewModel.pay();
    }
}
