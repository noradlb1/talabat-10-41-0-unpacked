package com.talabat.checkoutdotcom;

import com.talabat.gem.integration.Gem;
import com.talabat.wallet.debitcarddeflection.presentation.viewmodel.BenefitManagerViewModel;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0002H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/talabat/checkoutdotcom/GemPaymentBinder;", "Lio/reactivex/functions/Consumer;", "Lcom/talabat/checkoutdotcom/CheckoutTokenScreen;", "benefitManagerViewModel", "Lcom/talabat/wallet/debitcarddeflection/presentation/viewmodel/BenefitManagerViewModel;", "(Lcom/talabat/wallet/debitcarddeflection/presentation/viewmodel/BenefitManagerViewModel;)V", "accept", "", "activity", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GemPaymentBinder implements Consumer<CheckoutTokenScreen> {
    /* access modifiers changed from: private */
    @NotNull
    public final BenefitManagerViewModel benefitManagerViewModel;

    public GemPaymentBinder(@NotNull BenefitManagerViewModel benefitManagerViewModel2) {
        Intrinsics.checkNotNullParameter(benefitManagerViewModel2, "benefitManagerViewModel");
        this.benefitManagerViewModel = benefitManagerViewModel2;
    }

    public void accept(@NotNull CheckoutTokenScreen checkoutTokenScreen) {
        Intrinsics.checkNotNullParameter(checkoutTokenScreen, "activity");
        Gem.withGemComponent(new GemPaymentBinder$accept$1(checkoutTokenScreen, this));
    }
}
