package com.talabat.wallet.ui.subscriptionManagement.view;

import android.content.Intent;
import com.talabat.talabatcommon.views.wallet.subscription.model.SubscriptionItemDisplayModel;
import com.talabat.talabatnavigation.walletSquad.WalletNavigatorActions;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroid/content/Intent;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class SubscriptionManagementFragment$navigateToSubscriptionDetail$1$1 extends Lambda implements Function1<Intent, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ SubscriptionItemDisplayModel f12719g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ SubscriptionManagementFragment f12720h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SubscriptionManagementFragment$navigateToSubscriptionDetail$1$1(SubscriptionItemDisplayModel subscriptionItemDisplayModel, SubscriptionManagementFragment subscriptionManagementFragment) {
        super(1);
        this.f12719g = subscriptionItemDisplayModel;
        this.f12720h = subscriptionManagementFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Intent) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "$this$$receiver");
        intent.putExtra("subscriptionMemberId", this.f12719g.getMembershipId());
        intent.putExtra(WalletNavigatorActions.EXTRA_WALLET_CARD_LIST, SubscriptionManagementFragment.access$getViewModel(this.f12720h).getWalletCardList());
        intent.putExtra(WalletNavigatorActions.EXTRA_IS_SUBSCRIPTION_DEFAULT_CARD_AVAILABLE, SubscriptionManagementFragment.access$getViewModel(this.f12720h).isSubscriptionDefaultCardAvailable());
    }
}
