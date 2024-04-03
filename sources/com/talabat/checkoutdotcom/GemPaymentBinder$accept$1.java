package com.talabat.checkoutdotcom;

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
public final class GemPaymentBinder$accept$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ CheckoutTokenScreen f55634g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ GemPaymentBinder f55635h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GemPaymentBinder$accept$1(CheckoutTokenScreen checkoutTokenScreen, GemPaymentBinder gemPaymentBinder) {
        super(0);
        this.f55634g = checkoutTokenScreen;
        this.f55635h = gemPaymentBinder;
    }

    public final void invoke() {
        Restaurant restaurant = GlobalDataModel.SELECTED.getRestaurant();
        Integer valueOf = restaurant != null ? Integer.valueOf(restaurant.f13872id) : null;
        CheckoutTokenScreen checkoutTokenScreen = this.f55634g;
        GemPaymentBinder gemPaymentBinder = this.f55635h;
        Button button = (Button) checkoutTokenScreen.findViewById(R.id.generate_token);
        Intrinsics.checkNotNullExpressionValue(button, "btnPay");
        GemOfferProcessingKt.withGemOfferProcessing(button, new GemPaymentBinder$accept$1$1$1(valueOf, gemPaymentBinder, checkoutTokenScreen));
    }
}
