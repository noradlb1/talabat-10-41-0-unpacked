package com.talabat.talabatcommon.views.wallet.subscription.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u0005\"\u0004\b\n\u0010\u0007R \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/subscription/model/SubscriptionDisplayModel;", "", "()V", "isServiceCompleted", "", "()Z", "setServiceCompleted", "(Z)V", "shouldShowChangeCardWidget", "getShouldShowChangeCardWidget", "setShouldShowChangeCardWidget", "subscriptions", "", "Lcom/talabat/talabatcommon/views/wallet/subscription/model/SubscriptionItemDisplayModel;", "getSubscriptions", "()Ljava/util/List;", "setSubscriptions", "(Ljava/util/List;)V", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SubscriptionDisplayModel {
    private boolean isServiceCompleted;
    private boolean shouldShowChangeCardWidget;
    @NotNull
    private List<SubscriptionItemDisplayModel> subscriptions = CollectionsKt__CollectionsKt.emptyList();

    public final boolean getShouldShowChangeCardWidget() {
        return this.shouldShowChangeCardWidget;
    }

    @NotNull
    public final List<SubscriptionItemDisplayModel> getSubscriptions() {
        return this.subscriptions;
    }

    public final boolean isServiceCompleted() {
        return this.isServiceCompleted;
    }

    public final void setServiceCompleted(boolean z11) {
        this.isServiceCompleted = z11;
    }

    public final void setShouldShowChangeCardWidget(boolean z11) {
        this.shouldShowChangeCardWidget = z11;
    }

    public final void setSubscriptions(@NotNull List<SubscriptionItemDisplayModel> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.subscriptions = list;
    }
}
