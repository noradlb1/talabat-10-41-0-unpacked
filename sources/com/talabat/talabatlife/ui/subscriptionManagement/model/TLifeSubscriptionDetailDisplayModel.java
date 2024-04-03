package com.talabat.talabatlife.ui.subscriptionManagement.model;

import com.talabat.talabatcommon.extentions.StringUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001a\u0010\u0012\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001a\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0017\"\u0004\b\u001b\u0010\u0019R\u001a\u0010\u001c\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0017\"\u0004\b\u001e\u0010\u0019R\u001a\u0010\u001f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0006\"\u0004\b!\u0010\bR\u001a\u0010\"\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0006\"\u0004\b$\u0010\bR\u001a\u0010%\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0006\"\u0004\b'\u0010\b¨\u0006("}, d2 = {"Lcom/talabat/talabatlife/ui/subscriptionManagement/model/TLifeSubscriptionDetailDisplayModel;", "", "()V", "actionText", "", "getActionText", "()Ljava/lang/String;", "setActionText", "(Ljava/lang/String;)V", "buttonAction", "Lcom/talabat/talabatlife/ui/subscriptionManagement/model/SubscriptionButtonAction;", "getButtonAction", "()Lcom/talabat/talabatlife/ui/subscriptionManagement/model/SubscriptionButtonAction;", "setButtonAction", "(Lcom/talabat/talabatlife/ui/subscriptionManagement/model/SubscriptionButtonAction;)V", "endDate", "getEndDate", "setEndDate", "error", "getError", "setError", "isActive", "", "()Z", "setActive", "(Z)V", "isAutoRenewable", "setAutoRenewable", "latestAutoRenewPaymentStatus", "getLatestAutoRenewPaymentStatus", "setLatestAutoRenewPaymentStatus", "membershipId", "getMembershipId", "setMembershipId", "nextBillingDate", "getNextBillingDate", "setNextBillingDate", "planTitle", "getPlanTitle", "setPlanTitle", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TLifeSubscriptionDetailDisplayModel {
    @NotNull
    private String actionText;
    @NotNull
    private SubscriptionButtonAction buttonAction = SubscriptionButtonAction.DEFAULT;
    @NotNull
    private String endDate;
    @NotNull
    private String error;
    private boolean isActive;
    private boolean isAutoRenewable;
    private boolean latestAutoRenewPaymentStatus;
    @NotNull
    private String membershipId;
    @NotNull
    private String nextBillingDate;
    @NotNull
    private String planTitle;

    public TLifeSubscriptionDetailDisplayModel() {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        this.error = StringUtils.empty(stringCompanionObject);
        this.membershipId = StringUtils.empty(stringCompanionObject);
        this.nextBillingDate = StringUtils.empty(stringCompanionObject);
        this.endDate = StringUtils.empty(stringCompanionObject);
        this.planTitle = StringUtils.empty(stringCompanionObject);
        this.actionText = StringUtils.empty(stringCompanionObject);
    }

    @NotNull
    public final String getActionText() {
        return this.actionText;
    }

    @NotNull
    public final SubscriptionButtonAction getButtonAction() {
        return this.buttonAction;
    }

    @NotNull
    public final String getEndDate() {
        return this.endDate;
    }

    @NotNull
    public final String getError() {
        return this.error;
    }

    public final boolean getLatestAutoRenewPaymentStatus() {
        return this.latestAutoRenewPaymentStatus;
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
    public final String getPlanTitle() {
        return this.planTitle;
    }

    public final boolean isActive() {
        return this.isActive;
    }

    public final boolean isAutoRenewable() {
        return this.isAutoRenewable;
    }

    public final void setActionText(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.actionText = str;
    }

    public final void setActive(boolean z11) {
        this.isActive = z11;
    }

    public final void setAutoRenewable(boolean z11) {
        this.isAutoRenewable = z11;
    }

    public final void setButtonAction(@NotNull SubscriptionButtonAction subscriptionButtonAction) {
        Intrinsics.checkNotNullParameter(subscriptionButtonAction, "<set-?>");
        this.buttonAction = subscriptionButtonAction;
    }

    public final void setEndDate(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.endDate = str;
    }

    public final void setError(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.error = str;
    }

    public final void setLatestAutoRenewPaymentStatus(boolean z11) {
        this.latestAutoRenewPaymentStatus = z11;
    }

    public final void setMembershipId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.membershipId = str;
    }

    public final void setNextBillingDate(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.nextBillingDate = str;
    }

    public final void setPlanTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.planTitle = str;
    }
}
