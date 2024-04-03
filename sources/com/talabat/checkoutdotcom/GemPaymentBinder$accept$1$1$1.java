package com.talabat.checkoutdotcom;

import com.talabat.gem.adapters.presentation.GemApprovalCallbacks;
import com.talabat.gem.adapters.presentation.GemOfferProcessingConfigurations;
import com.talabat.gem.domain.entities.GemOfferAcceptance;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/talabat/gem/adapters/presentation/GemOfferProcessingConfigurations;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class GemPaymentBinder$accept$1$1$1 extends Lambda implements Function1<GemOfferProcessingConfigurations, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Integer f55636g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ GemPaymentBinder f55637h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ CheckoutTokenScreen f55638i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GemPaymentBinder$accept$1$1$1(Integer num, GemPaymentBinder gemPaymentBinder, CheckoutTokenScreen checkoutTokenScreen) {
        super(1);
        this.f55636g = num;
        this.f55637h = gemPaymentBinder;
        this.f55638i = checkoutTokenScreen;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((GemOfferProcessingConfigurations) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull GemOfferProcessingConfigurations gemOfferProcessingConfigurations) {
        Intrinsics.checkNotNullParameter(gemOfferProcessingConfigurations, "$this$withGemOfferProcessing");
        gemOfferProcessingConfigurations.getWith().restaurantId(this.f55636g);
        GemApprovalCallbacks on2 = gemOfferProcessingConfigurations.getOn();
        final GemPaymentBinder gemPaymentBinder = this.f55637h;
        on2.processed(new Function1<GemOfferAcceptance, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((GemOfferAcceptance) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull GemOfferAcceptance gemOfferAcceptance) {
                Intrinsics.checkNotNullParameter(gemOfferAcceptance, "it");
                gemPaymentBinder.benefitManagerViewModel.onPayButtonClicked();
            }
        });
        GemApprovalCallbacks on3 = gemOfferProcessingConfigurations.getOn();
        final CheckoutTokenScreen checkoutTokenScreen = this.f55638i;
        on3.error(new Function1<Throwable, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Throwable) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull Throwable th2) {
                Intrinsics.checkNotNullParameter(th2, "it");
                checkoutTokenScreen.onServerError();
            }
        });
    }
}
