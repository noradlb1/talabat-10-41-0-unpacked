package com.checkout.frames.api;

import com.checkout.logging.EventLoggerProvider;
import com.checkout.logging.Logger;
import com.checkout.logging.model.LoggingEvent;
import com.checkout.threedsecure.ThreeDSExecutor;
import com.checkout.threedsecure.logging.ThreeDSEventLogger;
import com.checkout.threedsecure.usecase.ProcessThreeDSUseCase;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/checkout/threedsecure/ThreeDSExecutor;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class PaymentFormMediator$threeDSExecutor$2 extends Lambda implements Function0<ThreeDSExecutor> {
    final /* synthetic */ PaymentFormMediator this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PaymentFormMediator$threeDSExecutor$2(PaymentFormMediator paymentFormMediator) {
        super(0);
        this.this$0 = paymentFormMediator;
    }

    @NotNull
    public final ThreeDSExecutor invoke() {
        Logger<LoggingEvent> provide = EventLoggerProvider.INSTANCE.provide();
        PaymentFormMediator paymentFormMediator = this.this$0;
        Logger.DefaultImpls.setup$default(provide, paymentFormMediator.config.getContext(), paymentFormMediator.config.getEnvironment(), (String) null, (String) null, 12, (Object) null);
        return new ThreeDSExecutor(new ProcessThreeDSUseCase(), new ThreeDSEventLogger(provide));
    }
}
