package com.talabat.talabatcommon.feature.subscriptionManagement;

import com.talabat.talabatcommon.model.wallet.WalletCardListDisplayModel;
import com.talabat.talabatcommon.views.wallet.subscription.model.SubscriptionDefaultCardDisplayModel;
import com.talabat.talabatcommon.views.wallet.subscription.model.SubscriptionDisplayModel;
import com.talabat.talabatcommon.views.wallet.subscription.model.SubscriptionPlanDisplayModel;
import com.talabat.talabatcommon.views.wallet.subscription.model.SubscriptionViewDisplayModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\n¢\u0006\u0002\b\n"}, d2 = {"<anonymous>", "Lcom/talabat/talabatcommon/views/wallet/subscription/model/SubscriptionViewDisplayModel;", "subscriptionDisplayModel", "Lcom/talabat/talabatcommon/views/wallet/subscription/model/SubscriptionDisplayModel;", "subscriptionPlanDisplayModel", "Lcom/talabat/talabatcommon/views/wallet/subscription/model/SubscriptionPlanDisplayModel;", "subscriptionDefaultCardDisplayModel", "Lcom/talabat/talabatcommon/views/wallet/subscription/model/SubscriptionDefaultCardDisplayModel;", "walletCardListDisplayModel", "Lcom/talabat/talabatcommon/model/wallet/WalletCardListDisplayModel;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class GetSubscriptionViewsDataUseCase$invoke$1 extends Lambda implements Function4<SubscriptionDisplayModel, SubscriptionPlanDisplayModel, SubscriptionDefaultCardDisplayModel, WalletCardListDisplayModel, SubscriptionViewDisplayModel> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ SubscriptionViewDisplayModel f61578g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ boolean f61579h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GetSubscriptionViewsDataUseCase$invoke$1(SubscriptionViewDisplayModel subscriptionViewDisplayModel, boolean z11) {
        super(4);
        this.f61578g = subscriptionViewDisplayModel;
        this.f61579h = z11;
    }

    @Nullable
    public final SubscriptionViewDisplayModel invoke(@NotNull SubscriptionDisplayModel subscriptionDisplayModel, @NotNull SubscriptionPlanDisplayModel subscriptionPlanDisplayModel, @NotNull SubscriptionDefaultCardDisplayModel subscriptionDefaultCardDisplayModel, @NotNull WalletCardListDisplayModel walletCardListDisplayModel) {
        Intrinsics.checkNotNullParameter(subscriptionDisplayModel, "subscriptionDisplayModel");
        Intrinsics.checkNotNullParameter(subscriptionPlanDisplayModel, "subscriptionPlanDisplayModel");
        Intrinsics.checkNotNullParameter(subscriptionDefaultCardDisplayModel, "subscriptionDefaultCardDisplayModel");
        Intrinsics.checkNotNullParameter(walletCardListDisplayModel, "walletCardListDisplayModel");
        SubscriptionViewDisplayModel subscriptionViewDisplayModel = this.f61578g;
        subscriptionViewDisplayModel.setDefaultCard(subscriptionDefaultCardDisplayModel);
        subscriptionViewDisplayModel.setWalletCardList(walletCardListDisplayModel);
        subscriptionViewDisplayModel.setAllServiceLoaded(true);
        subscriptionViewDisplayModel.getSubscriptionViewsVisibilityModel().setChangeCardWidgetVisible(subscriptionDisplayModel.getShouldShowChangeCardWidget());
        if ((subscriptionDefaultCardDisplayModel.getCardTokenId().length() == 0) && !this.f61579h) {
            this.f61578g.getSubscriptionViewsVisibilityModel().setAddCardViewVisible(true);
        }
        if ((!subscriptionPlanDisplayModel.getSubscriptionPlans().isEmpty()) && subscriptionPlanDisplayModel.getSubscriptionPlans().size() == subscriptionDisplayModel.getSubscriptions().size()) {
            SubscriptionViewDisplayModel subscriptionViewDisplayModel2 = this.f61578g;
            subscriptionViewDisplayModel2.getSubscriptionViewsVisibilityModel().setAllSubscriptionViewVisible(true);
            subscriptionViewDisplayModel2.setSubscriptions(subscriptionDisplayModel.getSubscriptions());
            return subscriptionViewDisplayModel2;
        } else if ((!subscriptionPlanDisplayModel.getSubscriptionPlans().isEmpty()) && (!subscriptionDisplayModel.getSubscriptions().isEmpty())) {
            SubscriptionViewDisplayModel subscriptionViewDisplayModel3 = this.f61578g;
            subscriptionViewDisplayModel3.getSubscriptionViewsVisibilityModel().setPartSubscriptionViewVisible(true);
            subscriptionViewDisplayModel3.setSubscriptions(subscriptionDisplayModel.getSubscriptions());
            return subscriptionViewDisplayModel3;
        } else if (!(!subscriptionPlanDisplayModel.getSubscriptionPlans().isEmpty()) || !subscriptionDisplayModel.getSubscriptions().isEmpty()) {
            return this.f61578g;
        } else {
            SubscriptionViewDisplayModel subscriptionViewDisplayModel4 = this.f61578g;
            subscriptionViewDisplayModel4.getSubscriptionViewsVisibilityModel().setNoSubscriptionViewVisible(true);
            subscriptionViewDisplayModel4.setSubscriptions(subscriptionPlanDisplayModel.getSubscriptionPlans());
            return subscriptionViewDisplayModel4;
        }
    }
}
