package com.checkout.frames.screen.billingaddress.billingaddressdetails;

import com.checkout.base.model.Country;
import com.checkout.frames.component.billingaddressfields.BillingAddressInputComponentState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class BillingAddressDetailsScreenKt$BillingAddressDetailsScreen$2$2$1$1 extends Lambda implements Function1<Country, Unit> {
    final /* synthetic */ BillingAddressInputComponentState $state;
    final /* synthetic */ BillingAddressDetailsViewModel $viewModel;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BillingAddressDetailsScreenKt$BillingAddressDetailsScreen$2$2$1$1(BillingAddressDetailsViewModel billingAddressDetailsViewModel, BillingAddressInputComponentState billingAddressInputComponentState) {
        super(1);
        this.$viewModel = billingAddressDetailsViewModel;
        this.$state = billingAddressInputComponentState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Country) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Country country) {
        Intrinsics.checkNotNullParameter(country, "country");
        this.$viewModel.updateCountryComponentState$frames_release(this.$state, country);
    }
}
