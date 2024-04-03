package com.talabat.wallet.ui.subscriptionManagement.view.bottomsheet;

import com.talabat.talabatcommon.views.wallet.subscription.viewModel.SubscriptionManagementViewModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class SubscriptionCancellationFragment$factory$1 extends FunctionReferenceImpl implements Function0<SubscriptionManagementViewModel> {
    public SubscriptionCancellationFragment$factory$1(Object obj) {
        super(0, obj, SubscriptionCancellationFragment.class, "viewModelBuilder", "viewModelBuilder()Lcom/talabat/talabatcommon/views/wallet/subscription/viewModel/SubscriptionManagementViewModel;", 0);
    }

    @NotNull
    public final SubscriptionManagementViewModel invoke() {
        return ((SubscriptionCancellationFragment) this.receiver).viewModelBuilder();
    }
}
