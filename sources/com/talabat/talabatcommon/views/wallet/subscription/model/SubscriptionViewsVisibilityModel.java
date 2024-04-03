package com.talabat.talabatcommon.views.wallet.subscription.model;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\u0005\"\u0004\b\t\u0010\u0007R\u001a\u0010\n\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0005\"\u0004\b\u000b\u0010\u0007R\u001a\u0010\f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u0005\"\u0004\b\r\u0010\u0007R\u001a\u0010\u000e\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0005\"\u0004\b\u000f\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/subscription/model/SubscriptionViewsVisibilityModel;", "", "()V", "isAddCardViewVisible", "", "()Z", "setAddCardViewVisible", "(Z)V", "isAllSubscriptionViewVisible", "setAllSubscriptionViewVisible", "isChangeCardWidgetVisible", "setChangeCardWidgetVisible", "isNoSubscriptionViewVisible", "setNoSubscriptionViewVisible", "isPartSubscriptionViewVisible", "setPartSubscriptionViewVisible", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SubscriptionViewsVisibilityModel {
    private boolean isAddCardViewVisible;
    private boolean isAllSubscriptionViewVisible;
    private boolean isChangeCardWidgetVisible;
    private boolean isNoSubscriptionViewVisible;
    private boolean isPartSubscriptionViewVisible;

    public final boolean isAddCardViewVisible() {
        return this.isAddCardViewVisible;
    }

    public final boolean isAllSubscriptionViewVisible() {
        return this.isAllSubscriptionViewVisible;
    }

    public final boolean isChangeCardWidgetVisible() {
        return this.isChangeCardWidgetVisible;
    }

    public final boolean isNoSubscriptionViewVisible() {
        return this.isNoSubscriptionViewVisible;
    }

    public final boolean isPartSubscriptionViewVisible() {
        return this.isPartSubscriptionViewVisible;
    }

    public final void setAddCardViewVisible(boolean z11) {
        this.isAddCardViewVisible = z11;
    }

    public final void setAllSubscriptionViewVisible(boolean z11) {
        this.isAllSubscriptionViewVisible = z11;
    }

    public final void setChangeCardWidgetVisible(boolean z11) {
        this.isChangeCardWidgetVisible = z11;
    }

    public final void setNoSubscriptionViewVisible(boolean z11) {
        this.isNoSubscriptionViewVisible = z11;
    }

    public final void setPartSubscriptionViewVisible(boolean z11) {
        this.isPartSubscriptionViewVisible = z11;
    }
}
