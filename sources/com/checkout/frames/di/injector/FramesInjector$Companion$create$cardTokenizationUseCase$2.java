package com.checkout.frames.di.injector;

import com.checkout.frames.api.PaymentFlowHandler;
import com.checkout.tokenization.model.TokenDetails;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public /* synthetic */ class FramesInjector$Companion$create$cardTokenizationUseCase$2 extends FunctionReferenceImpl implements Function1<TokenDetails, Unit> {
    public FramesInjector$Companion$create$cardTokenizationUseCase$2(Object obj) {
        super(1, obj, PaymentFlowHandler.class, "onSuccess", "onSuccess(Lcom/checkout/tokenization/model/TokenDetails;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((TokenDetails) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull TokenDetails tokenDetails) {
        Intrinsics.checkNotNullParameter(tokenDetails, "p0");
        ((PaymentFlowHandler) this.receiver).onSuccess(tokenDetails);
    }
}
