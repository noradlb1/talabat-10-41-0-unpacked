package com.talabat.talabatcommon.views.wallet.subscription.model;

import com.talabat.talabatcommon.extentions.StringUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001a\u0010\u0010\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR\u001a\u0010\u0012\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001a\u0010\u0015\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001a\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\b¨\u0006!"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/subscription/model/SubscriptionItemDisplayModel;", "", "()V", "endDate", "", "getEndDate", "()Ljava/lang/String;", "setEndDate", "(Ljava/lang/String;)V", "isActive", "", "()Z", "setActive", "(Z)V", "isAutoRenewable", "setAutoRenewable", "isServiceCompleted", "setServiceCompleted", "membershipId", "getMembershipId", "setMembershipId", "nextBillingDate", "getNextBillingDate", "setNextBillingDate", "subscriptionPlanItem", "Lcom/talabat/talabatcommon/views/wallet/subscription/model/SubscriptionPlanItemDisplayModel;", "getSubscriptionPlanItem", "()Lcom/talabat/talabatcommon/views/wallet/subscription/model/SubscriptionPlanItemDisplayModel;", "setSubscriptionPlanItem", "(Lcom/talabat/talabatcommon/views/wallet/subscription/model/SubscriptionPlanItemDisplayModel;)V", "type", "getType", "setType", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SubscriptionItemDisplayModel {
    @NotNull
    private String endDate;
    private boolean isActive;
    private boolean isAutoRenewable;
    private boolean isServiceCompleted;
    @NotNull
    private String membershipId;
    @NotNull
    private String nextBillingDate;
    @NotNull
    private SubscriptionPlanItemDisplayModel subscriptionPlanItem = new SubscriptionPlanItemDisplayModel();
    @NotNull
    private String type;

    public SubscriptionItemDisplayModel() {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        this.membershipId = StringUtils.empty(stringCompanionObject);
        this.nextBillingDate = StringUtils.empty(stringCompanionObject);
        this.endDate = StringUtils.empty(stringCompanionObject);
        this.type = StringUtils.empty(stringCompanionObject);
    }

    @NotNull
    public final String getEndDate() {
        return this.endDate;
    }

    @NotNull
    public final String getMembershipId() {
        return this.membershipId;
    }

    @NotNull
    public final String getNextBillingDate() {
        return this.nextBillingDate;
    }

    @NotNull
    public final SubscriptionPlanItemDisplayModel getSubscriptionPlanItem() {
        return this.subscriptionPlanItem;
    }

    @NotNull
    public final String getType() {
        return this.type;
    }

    public final boolean isActive() {
        return this.isActive;
    }

    public final boolean isAutoRenewable() {
        return this.isAutoRenewable;
    }

    public final boolean isServiceCompleted() {
        return this.isServiceCompleted;
    }

    public final void setActive(boolean z11) {
        this.isActive = z11;
    }

    public final void setAutoRenewable(boolean z11) {
        this.isAutoRenewable = z11;
    }

    public final void setEndDate(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.endDate = str;
    }

    public final void setMembershipId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.membershipId = str;
    }

    public final void setNextBillingDate(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.nextBillingDate = str;
    }

    public final void setServiceCompleted(boolean z11) {
        this.isServiceCompleted = z11;
    }

    public final void setSubscriptionPlanItem(@NotNull SubscriptionPlanItemDisplayModel subscriptionPlanItemDisplayModel) {
        Intrinsics.checkNotNullParameter(subscriptionPlanItemDisplayModel, "<set-?>");
        this.subscriptionPlanItem = subscriptionPlanItemDisplayModel;
    }

    public final void setType(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.type = str;
    }
}
