package com.talabat.talabatcommon.feature.subscriptionManagement.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BU\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\rJ\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\"\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010#\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0013J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u0010\u0010(\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0013Jn\u0010)\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010*J\u0013\u0010+\u001a\u00020\u00052\b\u0010,\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010-\u001a\u00020.HÖ\u0001J\t\u0010/\u001a\u00020\u0003HÖ\u0001R \u0010\b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0004\u0010\u0013\"\u0004\b\u0017\u0010\u0015R\"\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0006\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u000fR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u000fR \u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR \u0010\t\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u000f\"\u0004\b \u0010\u0011¨\u00060"}, d2 = {"Lcom/talabat/talabatcommon/feature/subscriptionManagement/model/SubscriptionResponseModel;", "", "membershipId", "", "isActive", "", "isAutoRenewable", "nextBillingDate", "endDate", "type", "subscriptionPlan", "Lcom/talabat/talabatcommon/feature/subscriptionManagement/model/SubscriptionPlanResponseModel;", "freeTrialEligible", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/talabat/talabatcommon/feature/subscriptionManagement/model/SubscriptionPlanResponseModel;Ljava/lang/Boolean;)V", "getEndDate", "()Ljava/lang/String;", "setEndDate", "(Ljava/lang/String;)V", "getFreeTrialEligible", "()Ljava/lang/Boolean;", "setFreeTrialEligible", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "setActive", "setAutoRenewable", "getMembershipId", "getNextBillingDate", "getSubscriptionPlan", "()Lcom/talabat/talabatcommon/feature/subscriptionManagement/model/SubscriptionPlanResponseModel;", "setSubscriptionPlan", "(Lcom/talabat/talabatcommon/feature/subscriptionManagement/model/SubscriptionPlanResponseModel;)V", "getType", "setType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/talabat/talabatcommon/feature/subscriptionManagement/model/SubscriptionPlanResponseModel;Ljava/lang/Boolean;)Lcom/talabat/talabatcommon/feature/subscriptionManagement/model/SubscriptionResponseModel;", "equals", "other", "hashCode", "", "toString", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SubscriptionResponseModel {
    @SerializedName("endDate")
    @Nullable
    private String endDate;
    @SerializedName("freeTrialEligible")
    @Nullable
    private Boolean freeTrialEligible;
    @SerializedName("isActive")
    @Nullable
    private Boolean isActive;
    @SerializedName("isAutorenewable")
    @Nullable
    private Boolean isAutoRenewable;
    @SerializedName("membershipId")
    @Nullable
    private final String membershipId;
    @SerializedName("nextBillingDate")
    @Nullable
    private final String nextBillingDate;
    @SerializedName("plan")
    @Nullable
    private SubscriptionPlanResponseModel subscriptionPlan;
    @SerializedName("type")
    @Nullable
    private String type;

    public SubscriptionResponseModel(@Nullable String str, @Nullable Boolean bool, @Nullable Boolean bool2, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable SubscriptionPlanResponseModel subscriptionPlanResponseModel, @Nullable Boolean bool3) {
        this.membershipId = str;
        this.isActive = bool;
        this.isAutoRenewable = bool2;
        this.nextBillingDate = str2;
        this.endDate = str3;
        this.type = str4;
        this.subscriptionPlan = subscriptionPlanResponseModel;
        this.freeTrialEligible = bool3;
    }

    public static /* synthetic */ SubscriptionResponseModel copy$default(SubscriptionResponseModel subscriptionResponseModel, String str, Boolean bool, Boolean bool2, String str2, String str3, String str4, SubscriptionPlanResponseModel subscriptionPlanResponseModel, Boolean bool3, int i11, Object obj) {
        SubscriptionResponseModel subscriptionResponseModel2 = subscriptionResponseModel;
        int i12 = i11;
        return subscriptionResponseModel.copy((i12 & 1) != 0 ? subscriptionResponseModel2.membershipId : str, (i12 & 2) != 0 ? subscriptionResponseModel2.isActive : bool, (i12 & 4) != 0 ? subscriptionResponseModel2.isAutoRenewable : bool2, (i12 & 8) != 0 ? subscriptionResponseModel2.nextBillingDate : str2, (i12 & 16) != 0 ? subscriptionResponseModel2.endDate : str3, (i12 & 32) != 0 ? subscriptionResponseModel2.type : str4, (i12 & 64) != 0 ? subscriptionResponseModel2.subscriptionPlan : subscriptionPlanResponseModel, (i12 & 128) != 0 ? subscriptionResponseModel2.freeTrialEligible : bool3);
    }

    @Nullable
    public final String component1() {
        return this.membershipId;
    }

    @Nullable
    public final Boolean component2() {
        return this.isActive;
    }

    @Nullable
    public final Boolean component3() {
        return this.isAutoRenewable;
    }

    @Nullable
    public final String component4() {
        return this.nextBillingDate;
    }

    @Nullable
    public final String component5() {
        return this.endDate;
    }

    @Nullable
    public final String component6() {
        return this.type;
    }

    @Nullable
    public final SubscriptionPlanResponseModel component7() {
        return this.subscriptionPlan;
    }

    @Nullable
    public final Boolean component8() {
        return this.freeTrialEligible;
    }

    @NotNull
    public final SubscriptionResponseModel copy(@Nullable String str, @Nullable Boolean bool, @Nullable Boolean bool2, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable SubscriptionPlanResponseModel subscriptionPlanResponseModel, @Nullable Boolean bool3) {
        return new SubscriptionResponseModel(str, bool, bool2, str2, str3, str4, subscriptionPlanResponseModel, bool3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SubscriptionResponseModel)) {
            return false;
        }
        SubscriptionResponseModel subscriptionResponseModel = (SubscriptionResponseModel) obj;
        return Intrinsics.areEqual((Object) this.membershipId, (Object) subscriptionResponseModel.membershipId) && Intrinsics.areEqual((Object) this.isActive, (Object) subscriptionResponseModel.isActive) && Intrinsics.areEqual((Object) this.isAutoRenewable, (Object) subscriptionResponseModel.isAutoRenewable) && Intrinsics.areEqual((Object) this.nextBillingDate, (Object) subscriptionResponseModel.nextBillingDate) && Intrinsics.areEqual((Object) this.endDate, (Object) subscriptionResponseModel.endDate) && Intrinsics.areEqual((Object) this.type, (Object) subscriptionResponseModel.type) && Intrinsics.areEqual((Object) this.subscriptionPlan, (Object) subscriptionResponseModel.subscriptionPlan) && Intrinsics.areEqual((Object) this.freeTrialEligible, (Object) subscriptionResponseModel.freeTrialEligible);
    }

    @Nullable
    public final String getEndDate() {
        return this.endDate;
    }

    @Nullable
    public final Boolean getFreeTrialEligible() {
        return this.freeTrialEligible;
    }

    @Nullable
    public final String getMembershipId() {
        return this.membershipId;
    }

    @Nullable
    public final String getNextBillingDate() {
        return this.nextBillingDate;
    }

    @Nullable
    public final SubscriptionPlanResponseModel getSubscriptionPlan() {
        return this.subscriptionPlan;
    }

    @Nullable
    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        String str = this.membershipId;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Boolean bool = this.isActive;
        int hashCode2 = (hashCode + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.isAutoRenewable;
        int hashCode3 = (hashCode2 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        String str2 = this.nextBillingDate;
        int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.endDate;
        int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.type;
        int hashCode6 = (hashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
        SubscriptionPlanResponseModel subscriptionPlanResponseModel = this.subscriptionPlan;
        int hashCode7 = (hashCode6 + (subscriptionPlanResponseModel == null ? 0 : subscriptionPlanResponseModel.hashCode())) * 31;
        Boolean bool3 = this.freeTrialEligible;
        if (bool3 != null) {
            i11 = bool3.hashCode();
        }
        return hashCode7 + i11;
    }

    @Nullable
    public final Boolean isActive() {
        return this.isActive;
    }

    @Nullable
    public final Boolean isAutoRenewable() {
        return this.isAutoRenewable;
    }

    public final void setActive(@Nullable Boolean bool) {
        this.isActive = bool;
    }

    public final void setAutoRenewable(@Nullable Boolean bool) {
        this.isAutoRenewable = bool;
    }

    public final void setEndDate(@Nullable String str) {
        this.endDate = str;
    }

    public final void setFreeTrialEligible(@Nullable Boolean bool) {
        this.freeTrialEligible = bool;
    }

    public final void setSubscriptionPlan(@Nullable SubscriptionPlanResponseModel subscriptionPlanResponseModel) {
        this.subscriptionPlan = subscriptionPlanResponseModel;
    }

    public final void setType(@Nullable String str) {
        this.type = str;
    }

    @NotNull
    public String toString() {
        String str = this.membershipId;
        Boolean bool = this.isActive;
        Boolean bool2 = this.isAutoRenewable;
        String str2 = this.nextBillingDate;
        String str3 = this.endDate;
        String str4 = this.type;
        SubscriptionPlanResponseModel subscriptionPlanResponseModel = this.subscriptionPlan;
        Boolean bool3 = this.freeTrialEligible;
        return "SubscriptionResponseModel(membershipId=" + str + ", isActive=" + bool + ", isAutoRenewable=" + bool2 + ", nextBillingDate=" + str2 + ", endDate=" + str3 + ", type=" + str4 + ", subscriptionPlan=" + subscriptionPlanResponseModel + ", freeTrialEligible=" + bool3 + ")";
    }
}
