package com.talabat.talabatcommon.views.wallet.subscription.viewModel;

import com.talabat.talabatcommon.views.wallet.subscription.model.SubscriptionDisplayModel;
import com.talabat.talabatcommon.views.wallet.subscription.model.SubscriptionPlanDisplayModel;
import com.talabat.talabatcommon.views.wallet.subscription.model.WalletSubscriptionMapper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "subscriptionDisplayModel", "Lcom/talabat/talabatcommon/views/wallet/subscription/model/SubscriptionDisplayModel;", "subscriptionPlanDisplayModel", "Lcom/talabat/talabatcommon/views/wallet/subscription/model/SubscriptionPlanDisplayModel;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class SubscriptionManagementViewModelImpl$onUnSubscribedPlansLoaded$1 extends Lambda implements Function2<SubscriptionDisplayModel, SubscriptionPlanDisplayModel, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ SubscriptionManagementViewModelImpl f11942g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SubscriptionManagementViewModelImpl$onUnSubscribedPlansLoaded$1(SubscriptionManagementViewModelImpl subscriptionManagementViewModelImpl) {
        super(2);
        this.f11942g = subscriptionManagementViewModelImpl;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((SubscriptionDisplayModel) obj, (SubscriptionPlanDisplayModel) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull SubscriptionDisplayModel subscriptionDisplayModel, @NotNull SubscriptionPlanDisplayModel subscriptionPlanDisplayModel) {
        Intrinsics.checkNotNullParameter(subscriptionDisplayModel, "subscriptionDisplayModel");
        Intrinsics.checkNotNullParameter(subscriptionPlanDisplayModel, "subscriptionPlanDisplayModel");
        this.f11942g.getUnSubscribedPlansData().setValue(WalletSubscriptionMapper.Companion.getUpSubscribedPlans(subscriptionDisplayModel, subscriptionPlanDisplayModel));
    }
}
