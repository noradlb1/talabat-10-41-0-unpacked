package com.talabat.talabatcommon.feature.subscriptionManagement;

import com.talabat.talabatcommon.extentions.SafeLetKt;
import com.talabat.talabatcommon.model.wallet.WalletCardListDisplayModel;
import com.talabat.talabatcommon.views.wallet.subscription.model.SubscriptionDefaultCardDisplayModel;
import com.talabat.talabatcommon.views.wallet.subscription.model.SubscriptionDisplayModel;
import com.talabat.talabatcommon.views.wallet.subscription.model.SubscriptionPlanDisplayModel;
import com.talabat.talabatcommon.views.wallet.subscription.model.SubscriptionViewDisplayModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function5;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002.\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0001B\u0005¢\u0006\u0002\u0010\bJ9\u0010\t\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\u0010\f\u001a\u0004\u0018\u00010\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000e\u001a\u00020\u0006H\u0002¨\u0006\u000f"}, d2 = {"Lcom/talabat/talabatcommon/feature/subscriptionManagement/GetSubscriptionViewsDataUseCase;", "Lkotlin/Function5;", "Lcom/talabat/talabatcommon/views/wallet/subscription/model/SubscriptionDisplayModel;", "Lcom/talabat/talabatcommon/views/wallet/subscription/model/SubscriptionPlanDisplayModel;", "Lcom/talabat/talabatcommon/views/wallet/subscription/model/SubscriptionDefaultCardDisplayModel;", "Lcom/talabat/talabatcommon/model/wallet/WalletCardListDisplayModel;", "", "Lcom/talabat/talabatcommon/views/wallet/subscription/model/SubscriptionViewDisplayModel;", "()V", "invoke", "subscriptionDisplayModel", "subscriptionPlanDisplayModel", "subscriptionDefaultCardDisplayModel", "walletCardListDisplayModel", "isGetDefaultCardFailed", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GetSubscriptionViewsDataUseCase implements Function5<SubscriptionDisplayModel, SubscriptionPlanDisplayModel, SubscriptionDefaultCardDisplayModel, WalletCardListDisplayModel, Boolean, SubscriptionViewDisplayModel> {
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        return invoke((SubscriptionDisplayModel) obj, (SubscriptionPlanDisplayModel) obj2, (SubscriptionDefaultCardDisplayModel) obj3, (WalletCardListDisplayModel) obj4, ((Boolean) obj5).booleanValue());
    }

    @NotNull
    public SubscriptionViewDisplayModel invoke(@Nullable SubscriptionDisplayModel subscriptionDisplayModel, @Nullable SubscriptionPlanDisplayModel subscriptionPlanDisplayModel, @Nullable SubscriptionDefaultCardDisplayModel subscriptionDefaultCardDisplayModel, @Nullable WalletCardListDisplayModel walletCardListDisplayModel, boolean z11) {
        SubscriptionViewDisplayModel subscriptionViewDisplayModel = new SubscriptionViewDisplayModel();
        SafeLetKt.safeLet(subscriptionDisplayModel, subscriptionPlanDisplayModel, subscriptionDefaultCardDisplayModel, walletCardListDisplayModel, new GetSubscriptionViewsDataUseCase$invoke$1(subscriptionViewDisplayModel, z11));
        return subscriptionViewDisplayModel;
    }
}
