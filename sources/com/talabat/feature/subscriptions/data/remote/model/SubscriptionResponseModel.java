package com.talabat.feature.subscriptions.data.remote.model;

import com.squareup.moshi.Json;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001Bw\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0003\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e¢\u0006\u0002\u0010\u0010J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0013J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u0010\u0010#\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0013J\u0011\u0010$\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eHÆ\u0003J\u0001\u0010%\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u00052\u0010\b\u0003\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eHÆ\u0001¢\u0006\u0002\u0010&J\u0013\u0010'\u001a\u00020\u00052\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020*HÖ\u0001J\t\u0010+\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0004\u0010\u0013R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0006\u0010\u0013R\u0015\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\f\u0010\u0013R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012R\u0019\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006,"}, d2 = {"Lcom/talabat/feature/subscriptions/data/remote/model/SubscriptionResponseModel;", "", "membershipId", "", "isActive", "", "isAutorenewable", "nextBillingDate", "endDate", "type", "plan", "Lcom/talabat/feature/subscriptions/data/remote/model/SubscriptionPlanResponseModel;", "isUpgradeable", "upgradeablePlanInfos", "", "Lcom/talabat/feature/subscriptions/data/remote/model/SubscriptionUpgradePlanResponseModel;", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/talabat/feature/subscriptions/data/remote/model/SubscriptionPlanResponseModel;Ljava/lang/Boolean;Ljava/util/List;)V", "getEndDate", "()Ljava/lang/String;", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getMembershipId", "getNextBillingDate", "getPlan", "()Lcom/talabat/feature/subscriptions/data/remote/model/SubscriptionPlanResponseModel;", "getType", "getUpgradeablePlanInfos", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/talabat/feature/subscriptions/data/remote/model/SubscriptionPlanResponseModel;Ljava/lang/Boolean;Ljava/util/List;)Lcom/talabat/feature/subscriptions/data/remote/model/SubscriptionResponseModel;", "equals", "other", "hashCode", "", "toString", "com_talabat_feature_subscriptions_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SubscriptionResponseModel {
    @Nullable
    private final String endDate;
    @Nullable
    private final Boolean isActive;
    @Nullable
    private final Boolean isAutorenewable;
    @Nullable
    private final Boolean isUpgradeable;
    @Nullable
    private final String membershipId;
    @Nullable
    private final String nextBillingDate;
    @Nullable
    private final SubscriptionPlanResponseModel plan;
    @Nullable
    private final String type;
    @Nullable
    private final List<SubscriptionUpgradePlanResponseModel> upgradeablePlanInfos;

    public SubscriptionResponseModel() {
        this((String) null, (Boolean) null, (Boolean) null, (String) null, (String) null, (String) null, (SubscriptionPlanResponseModel) null, (Boolean) null, (List) null, 511, (DefaultConstructorMarker) null);
    }

    public SubscriptionResponseModel(@Nullable @Json(name = "membershipId") String str, @Nullable @Json(name = "isActive") Boolean bool, @Nullable @Json(name = "isAutorenewable") Boolean bool2, @Nullable @Json(name = "nextBillingDate") String str2, @Nullable @Json(name = "endDate") String str3, @Nullable @Json(name = "type") String str4, @Nullable @Json(name = "plan") SubscriptionPlanResponseModel subscriptionPlanResponseModel, @Nullable @Json(name = "isUpgradeable") Boolean bool3, @Nullable @Json(name = "upgradeablePlanInfos") List<SubscriptionUpgradePlanResponseModel> list) {
        this.membershipId = str;
        this.isActive = bool;
        this.isAutorenewable = bool2;
        this.nextBillingDate = str2;
        this.endDate = str3;
        this.type = str4;
        this.plan = subscriptionPlanResponseModel;
        this.isUpgradeable = bool3;
        this.upgradeablePlanInfos = list;
    }

    public static /* synthetic */ SubscriptionResponseModel copy$default(SubscriptionResponseModel subscriptionResponseModel, String str, Boolean bool, Boolean bool2, String str2, String str3, String str4, SubscriptionPlanResponseModel subscriptionPlanResponseModel, Boolean bool3, List list, int i11, Object obj) {
        SubscriptionResponseModel subscriptionResponseModel2 = subscriptionResponseModel;
        int i12 = i11;
        return subscriptionResponseModel.copy((i12 & 1) != 0 ? subscriptionResponseModel2.membershipId : str, (i12 & 2) != 0 ? subscriptionResponseModel2.isActive : bool, (i12 & 4) != 0 ? subscriptionResponseModel2.isAutorenewable : bool2, (i12 & 8) != 0 ? subscriptionResponseModel2.nextBillingDate : str2, (i12 & 16) != 0 ? subscriptionResponseModel2.endDate : str3, (i12 & 32) != 0 ? subscriptionResponseModel2.type : str4, (i12 & 64) != 0 ? subscriptionResponseModel2.plan : subscriptionPlanResponseModel, (i12 & 128) != 0 ? subscriptionResponseModel2.isUpgradeable : bool3, (i12 & 256) != 0 ? subscriptionResponseModel2.upgradeablePlanInfos : list);
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
        return this.isAutorenewable;
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
        return this.plan;
    }

    @Nullable
    public final Boolean component8() {
        return this.isUpgradeable;
    }

    @Nullable
    public final List<SubscriptionUpgradePlanResponseModel> component9() {
        return this.upgradeablePlanInfos;
    }

    @NotNull
    public final SubscriptionResponseModel copy(@Nullable @Json(name = "membershipId") String str, @Nullable @Json(name = "isActive") Boolean bool, @Nullable @Json(name = "isAutorenewable") Boolean bool2, @Nullable @Json(name = "nextBillingDate") String str2, @Nullable @Json(name = "endDate") String str3, @Nullable @Json(name = "type") String str4, @Nullable @Json(name = "plan") SubscriptionPlanResponseModel subscriptionPlanResponseModel, @Nullable @Json(name = "isUpgradeable") Boolean bool3, @Nullable @Json(name = "upgradeablePlanInfos") List<SubscriptionUpgradePlanResponseModel> list) {
        return new SubscriptionResponseModel(str, bool, bool2, str2, str3, str4, subscriptionPlanResponseModel, bool3, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SubscriptionResponseModel)) {
            return false;
        }
        SubscriptionResponseModel subscriptionResponseModel = (SubscriptionResponseModel) obj;
        return Intrinsics.areEqual((Object) this.membershipId, (Object) subscriptionResponseModel.membershipId) && Intrinsics.areEqual((Object) this.isActive, (Object) subscriptionResponseModel.isActive) && Intrinsics.areEqual((Object) this.isAutorenewable, (Object) subscriptionResponseModel.isAutorenewable) && Intrinsics.areEqual((Object) this.nextBillingDate, (Object) subscriptionResponseModel.nextBillingDate) && Intrinsics.areEqual((Object) this.endDate, (Object) subscriptionResponseModel.endDate) && Intrinsics.areEqual((Object) this.type, (Object) subscriptionResponseModel.type) && Intrinsics.areEqual((Object) this.plan, (Object) subscriptionResponseModel.plan) && Intrinsics.areEqual((Object) this.isUpgradeable, (Object) subscriptionResponseModel.isUpgradeable) && Intrinsics.areEqual((Object) this.upgradeablePlanInfos, (Object) subscriptionResponseModel.upgradeablePlanInfos);
    }

    @Nullable
    public final String getEndDate() {
        return this.endDate;
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
    public final SubscriptionPlanResponseModel getPlan() {
        return this.plan;
    }

    @Nullable
    public final String getType() {
        return this.type;
    }

    @Nullable
    public final List<SubscriptionUpgradePlanResponseModel> getUpgradeablePlanInfos() {
        return this.upgradeablePlanInfos;
    }

    public int hashCode() {
        String str = this.membershipId;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Boolean bool = this.isActive;
        int hashCode2 = (hashCode + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.isAutorenewable;
        int hashCode3 = (hashCode2 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        String str2 = this.nextBillingDate;
        int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.endDate;
        int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.type;
        int hashCode6 = (hashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
        SubscriptionPlanResponseModel subscriptionPlanResponseModel = this.plan;
        int hashCode7 = (hashCode6 + (subscriptionPlanResponseModel == null ? 0 : subscriptionPlanResponseModel.hashCode())) * 31;
        Boolean bool3 = this.isUpgradeable;
        int hashCode8 = (hashCode7 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
        List<SubscriptionUpgradePlanResponseModel> list = this.upgradeablePlanInfos;
        if (list != null) {
            i11 = list.hashCode();
        }
        return hashCode8 + i11;
    }

    @Nullable
    public final Boolean isActive() {
        return this.isActive;
    }

    @Nullable
    public final Boolean isAutorenewable() {
        return this.isAutorenewable;
    }

    @Nullable
    public final Boolean isUpgradeable() {
        return this.isUpgradeable;
    }

    @NotNull
    public String toString() {
        String str = this.membershipId;
        Boolean bool = this.isActive;
        Boolean bool2 = this.isAutorenewable;
        String str2 = this.nextBillingDate;
        String str3 = this.endDate;
        String str4 = this.type;
        SubscriptionPlanResponseModel subscriptionPlanResponseModel = this.plan;
        Boolean bool3 = this.isUpgradeable;
        List<SubscriptionUpgradePlanResponseModel> list = this.upgradeablePlanInfos;
        return "SubscriptionResponseModel(membershipId=" + str + ", isActive=" + bool + ", isAutorenewable=" + bool2 + ", nextBillingDate=" + str2 + ", endDate=" + str3 + ", type=" + str4 + ", plan=" + subscriptionPlanResponseModel + ", isUpgradeable=" + bool3 + ", upgradeablePlanInfos=" + list + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ SubscriptionResponseModel(java.lang.String r11, java.lang.Boolean r12, java.lang.Boolean r13, java.lang.String r14, java.lang.String r15, java.lang.String r16, com.talabat.feature.subscriptions.data.remote.model.SubscriptionPlanResponseModel r17, java.lang.Boolean r18, java.util.List r19, int r20, kotlin.jvm.internal.DefaultConstructorMarker r21) {
        /*
            r10 = this;
            r0 = r20
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = r2
            goto L_0x000a
        L_0x0009:
            r1 = r11
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            r3 = r2
            goto L_0x0011
        L_0x0010:
            r3 = r12
        L_0x0011:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0017
            r4 = r2
            goto L_0x0018
        L_0x0017:
            r4 = r13
        L_0x0018:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x001e
            r5 = r2
            goto L_0x001f
        L_0x001e:
            r5 = r14
        L_0x001f:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0025
            r6 = r2
            goto L_0x0026
        L_0x0025:
            r6 = r15
        L_0x0026:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x002c
            r7 = r2
            goto L_0x002e
        L_0x002c:
            r7 = r16
        L_0x002e:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0034
            r8 = r2
            goto L_0x0036
        L_0x0034:
            r8 = r17
        L_0x0036:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x003c
            r9 = r2
            goto L_0x003e
        L_0x003c:
            r9 = r18
        L_0x003e:
            r0 = r0 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x0043
            goto L_0x0045
        L_0x0043:
            r2 = r19
        L_0x0045:
            r11 = r10
            r12 = r1
            r13 = r3
            r14 = r4
            r15 = r5
            r16 = r6
            r17 = r7
            r18 = r8
            r19 = r9
            r20 = r2
            r11.<init>(r12, r13, r14, r15, r16, r17, r18, r19, r20)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.subscriptions.data.remote.model.SubscriptionResponseModel.<init>(java.lang.String, java.lang.Boolean, java.lang.Boolean, java.lang.String, java.lang.String, java.lang.String, com.talabat.feature.subscriptions.data.remote.model.SubscriptionPlanResponseModel, java.lang.Boolean, java.util.List, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
