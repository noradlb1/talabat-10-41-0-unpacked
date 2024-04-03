package com.checkout.frames.usecase;

import com.checkout.frames.model.request.InternalCardTokenRequest;
import com.checkout.tokenization.model.TokenDetails;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/checkout/tokenization/model/TokenDetails;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class CardTokenizationUseCase$execute$1 extends Lambda implements Function1<TokenDetails, Unit> {
    final /* synthetic */ InternalCardTokenRequest $data;
    final /* synthetic */ CardTokenizationUseCase this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CardTokenizationUseCase$execute$1(CardTokenizationUseCase cardTokenizationUseCase, InternalCardTokenRequest internalCardTokenRequest) {
        super(1);
        this.this$0 = cardTokenizationUseCase;
        this.$data = internalCardTokenRequest;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((TokenDetails) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull TokenDetails tokenDetails) {
        Intrinsics.checkNotNullParameter(tokenDetails, "it");
        this.this$0.handleSuccess(tokenDetails, this.$data.getOnSuccess());
    }
}
