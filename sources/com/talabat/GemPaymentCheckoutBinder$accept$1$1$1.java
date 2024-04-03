package com.talabat;

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
public final class GemPaymentCheckoutBinder$accept$1$1$1 extends Lambda implements Function1<GemOfferProcessingConfigurations, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Integer f54078g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ CheckOutScreen f54079h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GemPaymentCheckoutBinder$accept$1$1$1(Integer num, CheckOutScreen checkOutScreen) {
        super(1);
        this.f54078g = num;
        this.f54079h = checkOutScreen;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((GemOfferProcessingConfigurations) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull GemOfferProcessingConfigurations gemOfferProcessingConfigurations) {
        Intrinsics.checkNotNullParameter(gemOfferProcessingConfigurations, "$this$withGemOfferProcessing");
        gemOfferProcessingConfigurations.getWith().restaurantId(this.f54078g);
        GemApprovalCallbacks on2 = gemOfferProcessingConfigurations.getOn();
        final CheckOutScreen checkOutScreen = this.f54079h;
        on2.processed(new Function1<GemOfferAcceptance, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((GemOfferAcceptance) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull GemOfferAcceptance gemOfferAcceptance) {
                Intrinsics.checkNotNullParameter(gemOfferAcceptance, "it");
                checkOutScreen.proceedWithPlaceOrder();
            }
        });
        GemApprovalCallbacks on3 = gemOfferProcessingConfigurations.getOn();
        final CheckOutScreen checkOutScreen2 = this.f54079h;
        on3.error(new Function1<Throwable, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Throwable) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull Throwable th2) {
                Intrinsics.checkNotNullParameter(th2, "it");
                checkOutScreen2.onServerError();
            }
        });
    }
}
