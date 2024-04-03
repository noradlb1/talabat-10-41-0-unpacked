package com.checkout.frames.di.injector;

import com.checkout.frames.api.PaymentFlowHandler;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public /* synthetic */ class FramesInjector$Companion$create$cardTokenizationUseCase$1 extends FunctionReferenceImpl implements Function0<Unit> {
    public FramesInjector$Companion$create$cardTokenizationUseCase$1(Object obj) {
        super(0, obj, PaymentFlowHandler.class, "onSubmit", "onSubmit()V", 0);
    }

    public final void invoke() {
        ((PaymentFlowHandler) this.receiver).onSubmit();
    }
}
