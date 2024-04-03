package com.talabat.talabatcommon.views.wallet.subscription.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R \u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/subscription/model/SubscriptionPlanDisplayModel;", "", "()V", "isServiceCompleted", "", "()Z", "setServiceCompleted", "(Z)V", "subscriptionPlans", "", "Lcom/talabat/talabatcommon/views/wallet/subscription/model/SubscriptionItemDisplayModel;", "getSubscriptionPlans", "()Ljava/util/List;", "setSubscriptionPlans", "(Ljava/util/List;)V", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SubscriptionPlanDisplayModel {
    private boolean isServiceCompleted;
    @NotNull
    private List<SubscriptionItemDisplayModel> subscriptionPlans = CollectionsKt__CollectionsKt.emptyList();

    @NotNull
    public final List<SubscriptionItemDisplayModel> getSubscriptionPlans() {
        return this.subscriptionPlans;
    }

    public final boolean isServiceCompleted() {
        return this.isServiceCompleted;
    }

    public final void setServiceCompleted(boolean z11) {
        this.isServiceCompleted = z11;
    }

    public final void setSubscriptionPlans(@NotNull List<SubscriptionItemDisplayModel> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.subscriptionPlans = list;
    }
}
