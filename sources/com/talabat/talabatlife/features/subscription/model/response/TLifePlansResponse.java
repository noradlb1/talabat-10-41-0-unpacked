package com.talabat.talabatlife.features.subscription.model.response;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\u0007\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0013\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R \u0010\u001a\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0006\"\u0004\b\u001c\u0010\bR \u0010\u001d\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0006\"\u0004\b\u001f\u0010\bR \u0010 \u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0006\"\u0004\b\"\u0010\bR \u0010#\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0006\"\u0004\b%\u0010\bR \u0010&\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0006\"\u0004\b(\u0010\bR\"\u0010)\u001a\u0004\u0018\u00010*8\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010/\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R \u00100\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0006\"\u0004\b2\u0010\bR \u00103\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u0006\"\u0004\b5\u0010\bR \u00106\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u0006\"\u0004\b8\u0010\b¨\u00069"}, d2 = {"Lcom/talabat/talabatlife/features/subscription/model/response/TLifePlansResponse;", "", "()V", "actionText", "", "getActionText", "()Ljava/lang/String;", "setActionText", "(Ljava/lang/String;)V", "descriptionText", "getDescriptionText", "setDescriptionText", "freeTrialDays", "", "getFreeTrialDays", "()Ljava/lang/Integer;", "setFreeTrialDays", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "freeTrialEligible", "", "getFreeTrialEligible", "()Ljava/lang/Boolean;", "setFreeTrialEligible", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "freeTrialTitle", "getFreeTrialTitle", "setFreeTrialTitle", "nextBillingSubText", "getNextBillingSubText", "setNextBillingSubText", "nextBillingText", "getNextBillingText", "setNextBillingText", "onBoardingSubTitle", "getOnBoardingSubTitle", "setOnBoardingSubTitle", "onBoardingTitle", "getOnBoardingTitle", "setOnBoardingTitle", "planAmount", "", "getPlanAmount", "()Ljava/lang/Float;", "setPlanAmount", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "planId", "getPlanId", "setPlanId", "planTitle", "getPlanTitle", "setPlanTitle", "subscriptionPaymentDate", "getSubscriptionPaymentDate", "setSubscriptionPaymentDate", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TLifePlansResponse {
    @SerializedName("actionText")
    @Nullable
    private String actionText;
    @SerializedName("descriptionText")
    @Nullable
    private String descriptionText;
    @SerializedName("freeTrialDays")
    @Nullable
    private Integer freeTrialDays;
    @SerializedName("freeTrialEligible")
    @Nullable
    private Boolean freeTrialEligible = Boolean.FALSE;
    @SerializedName("freeTrialTitle")
    @Nullable
    private String freeTrialTitle;
    @SerializedName("nextBillingSubText")
    @Nullable
    private String nextBillingSubText;
    @SerializedName("nextBillingText")
    @Nullable
    private String nextBillingText;
    @SerializedName("onBoardingSubTitle")
    @Nullable
    private String onBoardingSubTitle;
    @SerializedName("onBoardingTitle")
    @Nullable
    private String onBoardingTitle;
    @SerializedName("planAmount")
    @Nullable
    private Float planAmount;
    @SerializedName("planId")
    @Nullable
    private String planId;
    @SerializedName("planTitle")
    @Nullable
    private String planTitle;
    @SerializedName("subscriptionPaymentDate")
    @Nullable
    private String subscriptionPaymentDate;

    @Nullable
    public final String getActionText() {
        return this.actionText;
    }

    @Nullable
    public final String getDescriptionText() {
        return this.descriptionText;
    }

    @Nullable
    public final Integer getFreeTrialDays() {
        return this.freeTrialDays;
    }

    @Nullable
    public final Boolean getFreeTrialEligible() {
        return this.freeTrialEligible;
    }

    @Nullable
    public final String getFreeTrialTitle() {
        return this.freeTrialTitle;
    }

    @Nullable
    public final String getNextBillingSubText() {
        return this.nextBillingSubText;
    }

    @Nullable
    public final String getNextBillingText() {
        return this.nextBillingText;
    }

    @Nullable
    public final String getOnBoardingSubTitle() {
        return this.onBoardingSubTitle;
    }

    @Nullable
    public final String getOnBoardingTitle() {
        return this.onBoardingTitle;
    }

    @Nullable
    public final Float getPlanAmount() {
        return this.planAmount;
    }

    @Nullable
    public final String getPlanId() {
        return this.planId;
    }

    @Nullable
    public final String getPlanTitle() {
        return this.planTitle;
    }

    @Nullable
    public final String getSubscriptionPaymentDate() {
        return this.subscriptionPaymentDate;
    }

    public final void setActionText(@Nullable String str) {
        this.actionText = str;
    }

    public final void setDescriptionText(@Nullable String str) {
        this.descriptionText = str;
    }

    public final void setFreeTrialDays(@Nullable Integer num) {
        this.freeTrialDays = num;
    }

    public final void setFreeTrialEligible(@Nullable Boolean bool) {
        this.freeTrialEligible = bool;
    }

    public final void setFreeTrialTitle(@Nullable String str) {
        this.freeTrialTitle = str;
    }

    public final void setNextBillingSubText(@Nullable String str) {
        this.nextBillingSubText = str;
    }

    public final void setNextBillingText(@Nullable String str) {
        this.nextBillingText = str;
    }

    public final void setOnBoardingSubTitle(@Nullable String str) {
        this.onBoardingSubTitle = str;
    }

    public final void setOnBoardingTitle(@Nullable String str) {
        this.onBoardingTitle = str;
    }

    public final void setPlanAmount(@Nullable Float f11) {
        this.planAmount = f11;
    }

    public final void setPlanId(@Nullable String str) {
        this.planId = str;
    }

    public final void setPlanTitle(@Nullable String str) {
        this.planTitle = str;
    }

    public final void setSubscriptionPaymentDate(@Nullable String str) {
        this.subscriptionPaymentDate = str;
    }
}
