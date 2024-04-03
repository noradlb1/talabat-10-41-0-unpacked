package com.talabat.Adyen;

import android.widget.Button;
import com.talabat.R;
import com.talabat.gem.adapters.presentation.payment.GemOfferProcessingKt;
import com.talabat.helpers.GlobalDataModel;
import datamodels.Restaurant;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class GemPaymentAdyenBinder$accept$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ AdyenCheckoutScreen f53651g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GemPaymentAdyenBinder$accept$1(AdyenCheckoutScreen adyenCheckoutScreen) {
        super(0);
        this.f53651g = adyenCheckoutScreen;
    }

    public final void invoke() {
        Restaurant restaurant = GlobalDataModel.SELECTED.getRestaurant();
        Integer valueOf = restaurant != null ? Integer.valueOf(restaurant.f13872id) : null;
        AdyenCheckoutScreen adyenCheckoutScreen = this.f53651g;
        Button button = (Button) adyenCheckoutScreen.findViewById(R.id.generate_token);
        Intrinsics.checkNotNullExpressionValue(button, "btnPay");
        GemOfferProcessingKt.withGemOfferProcessing(button, new GemPaymentAdyenBinder$accept$1$1$1(valueOf, adyenCheckoutScreen));
    }
}
