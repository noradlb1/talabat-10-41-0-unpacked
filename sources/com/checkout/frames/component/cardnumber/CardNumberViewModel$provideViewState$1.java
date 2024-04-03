package com.checkout.frames.component.cardnumber;

import com.checkout.base.model.CardScheme;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/checkout/base/model/CardScheme;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class CardNumberViewModel$provideViewState$1 extends Lambda implements Function0<CardScheme> {
    final /* synthetic */ CardNumberComponentState $viewState;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CardNumberViewModel$provideViewState$1(CardNumberComponentState cardNumberComponentState) {
        super(0);
        this.$viewState = cardNumberComponentState;
    }

    @NotNull
    public final CardScheme invoke() {
        return this.$viewState.getCardScheme().getValue();
    }
}
