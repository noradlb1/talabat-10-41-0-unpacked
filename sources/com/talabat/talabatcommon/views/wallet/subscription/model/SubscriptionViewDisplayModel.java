package com.talabat.talabatcommon.views.wallet.subscription.model;

import com.talabat.talabatcommon.model.wallet.WalletCardListDisplayModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R \u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/subscription/model/SubscriptionViewDisplayModel;", "", "()V", "defaultCard", "Lcom/talabat/talabatcommon/views/wallet/subscription/model/SubscriptionDefaultCardDisplayModel;", "getDefaultCard", "()Lcom/talabat/talabatcommon/views/wallet/subscription/model/SubscriptionDefaultCardDisplayModel;", "setDefaultCard", "(Lcom/talabat/talabatcommon/views/wallet/subscription/model/SubscriptionDefaultCardDisplayModel;)V", "isAllServiceLoaded", "", "()Z", "setAllServiceLoaded", "(Z)V", "subscriptionViewsVisibilityModel", "Lcom/talabat/talabatcommon/views/wallet/subscription/model/SubscriptionViewsVisibilityModel;", "getSubscriptionViewsVisibilityModel", "()Lcom/talabat/talabatcommon/views/wallet/subscription/model/SubscriptionViewsVisibilityModel;", "setSubscriptionViewsVisibilityModel", "(Lcom/talabat/talabatcommon/views/wallet/subscription/model/SubscriptionViewsVisibilityModel;)V", "subscriptions", "", "Lcom/talabat/talabatcommon/views/wallet/subscription/model/SubscriptionItemDisplayModel;", "getSubscriptions", "()Ljava/util/List;", "setSubscriptions", "(Ljava/util/List;)V", "walletCardList", "Lcom/talabat/talabatcommon/model/wallet/WalletCardListDisplayModel;", "getWalletCardList", "()Lcom/talabat/talabatcommon/model/wallet/WalletCardListDisplayModel;", "setWalletCardList", "(Lcom/talabat/talabatcommon/model/wallet/WalletCardListDisplayModel;)V", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SubscriptionViewDisplayModel {
    @NotNull
    private SubscriptionDefaultCardDisplayModel defaultCard = new SubscriptionDefaultCardDisplayModel((String) null, (String) null, (String) null, (String) null, 15, (DefaultConstructorMarker) null);
    private boolean isAllServiceLoaded;
    @NotNull
    private SubscriptionViewsVisibilityModel subscriptionViewsVisibilityModel = new SubscriptionViewsVisibilityModel();
    @NotNull
    private List<SubscriptionItemDisplayModel> subscriptions = CollectionsKt__CollectionsKt.emptyList();
    @NotNull
    private WalletCardListDisplayModel walletCardList = new WalletCardListDisplayModel((List) null, false, 0, 7, (DefaultConstructorMarker) null);

    @NotNull
    public final SubscriptionDefaultCardDisplayModel getDefaultCard() {
        return this.defaultCard;
    }

    @NotNull
    public final SubscriptionViewsVisibilityModel getSubscriptionViewsVisibilityModel() {
        return this.subscriptionViewsVisibilityModel;
    }

    @NotNull
    public final List<SubscriptionItemDisplayModel> getSubscriptions() {
        return this.subscriptions;
    }

    @NotNull
    public final WalletCardListDisplayModel getWalletCardList() {
        return this.walletCardList;
    }

    public final boolean isAllServiceLoaded() {
        return this.isAllServiceLoaded;
    }

    public final void setAllServiceLoaded(boolean z11) {
        this.isAllServiceLoaded = z11;
    }

    public final void setDefaultCard(@NotNull SubscriptionDefaultCardDisplayModel subscriptionDefaultCardDisplayModel) {
        Intrinsics.checkNotNullParameter(subscriptionDefaultCardDisplayModel, "<set-?>");
        this.defaultCard = subscriptionDefaultCardDisplayModel;
    }

    public final void setSubscriptionViewsVisibilityModel(@NotNull SubscriptionViewsVisibilityModel subscriptionViewsVisibilityModel2) {
        Intrinsics.checkNotNullParameter(subscriptionViewsVisibilityModel2, "<set-?>");
        this.subscriptionViewsVisibilityModel = subscriptionViewsVisibilityModel2;
    }

    public final void setSubscriptions(@NotNull List<SubscriptionItemDisplayModel> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.subscriptions = list;
    }

    public final void setWalletCardList(@NotNull WalletCardListDisplayModel walletCardListDisplayModel) {
        Intrinsics.checkNotNullParameter(walletCardListDisplayModel, "<set-?>");
        this.walletCardList = walletCardListDisplayModel;
    }
}
