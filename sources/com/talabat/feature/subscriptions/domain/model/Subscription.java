package com.talabat.feature.subscriptions.domain.model;

import com.talabat.talabatlife.features.UrlConstantsKt;
import com.talabat.talabatnavigation.tLife.TLifeNavigationActions;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.threeten.bp.LocalDateTime;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0016\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001Bi\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\u0002\u0010\u0012J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0005HÆ\u0003J\t\u0010&\u001a\u00020\u0005HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u0010)\u001a\u00020\u000bHÆ\u0003J\t\u0010*\u001a\u00020\rHÆ\u0003J\t\u0010+\u001a\u00020\u0005HÆ\u0003J\u000f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010HÆ\u0003Jm\u0010-\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u00052\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010HÆ\u0001J\u0013\u0010.\u001a\u00020\u00052\b\u0010/\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00100\u001a\u000201HÖ\u0001J\t\u00102\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0015R\u0011\u0010\u000e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0019\u001a\u00020\u001a8F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0014R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#¨\u00063"}, d2 = {"Lcom/talabat/feature/subscriptions/domain/model/Subscription;", "", "membershipId", "", "isActive", "", "isAutorenewable", "nextBillingDate", "Lorg/threeten/bp/LocalDateTime;", "endDate", "type", "Lcom/talabat/feature/subscriptions/domain/model/SubscriptionType;", "plan", "Lcom/talabat/feature/subscriptions/domain/model/SubscriptionPlan;", "isUpgradeable", "upgradeablePlanInfos", "", "Lcom/talabat/feature/subscriptions/domain/model/SubscriptionUpgradePlan;", "(Ljava/lang/String;ZZLorg/threeten/bp/LocalDateTime;Lorg/threeten/bp/LocalDateTime;Lcom/talabat/feature/subscriptions/domain/model/SubscriptionType;Lcom/talabat/feature/subscriptions/domain/model/SubscriptionPlan;ZLjava/util/List;)V", "getEndDate", "()Lorg/threeten/bp/LocalDateTime;", "()Z", "isFreeCoffeeEnabled", "getMembershipId", "()Ljava/lang/String;", "minDeliveryFee", "", "getMinDeliveryFee", "()F", "getNextBillingDate", "getPlan", "()Lcom/talabat/feature/subscriptions/domain/model/SubscriptionPlan;", "getType", "()Lcom/talabat/feature/subscriptions/domain/model/SubscriptionType;", "getUpgradeablePlanInfos", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "com_talabat_feature_subscriptions_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Subscription {
    @Nullable
    private final LocalDateTime endDate;
    private final boolean isActive;
    private final boolean isAutorenewable;
    private final boolean isUpgradeable;
    @NotNull
    private final String membershipId;
    @Nullable
    private final LocalDateTime nextBillingDate;
    @NotNull
    private final SubscriptionPlan plan;
    @NotNull
    private final SubscriptionType type;
    @NotNull
    private final List<SubscriptionUpgradePlan> upgradeablePlanInfos;

    public Subscription() {
        this((String) null, false, false, (LocalDateTime) null, (LocalDateTime) null, (SubscriptionType) null, (SubscriptionPlan) null, false, (List) null, 511, (DefaultConstructorMarker) null);
    }

    public Subscription(@NotNull String str, boolean z11, boolean z12, @Nullable LocalDateTime localDateTime, @Nullable LocalDateTime localDateTime2, @NotNull SubscriptionType subscriptionType, @NotNull SubscriptionPlan subscriptionPlan, boolean z13, @NotNull List<SubscriptionUpgradePlan> list) {
        Intrinsics.checkNotNullParameter(str, UrlConstantsKt.PATH_MEMBERSHIP_ID);
        Intrinsics.checkNotNullParameter(subscriptionType, "type");
        Intrinsics.checkNotNullParameter(subscriptionPlan, TLifeNavigationActions.EXTRA_PLAN);
        Intrinsics.checkNotNullParameter(list, "upgradeablePlanInfos");
        this.membershipId = str;
        this.isActive = z11;
        this.isAutorenewable = z12;
        this.nextBillingDate = localDateTime;
        this.endDate = localDateTime2;
        this.type = subscriptionType;
        this.plan = subscriptionPlan;
        this.isUpgradeable = z13;
        this.upgradeablePlanInfos = list;
    }

    public static /* synthetic */ Subscription copy$default(Subscription subscription, String str, boolean z11, boolean z12, LocalDateTime localDateTime, LocalDateTime localDateTime2, SubscriptionType subscriptionType, SubscriptionPlan subscriptionPlan, boolean z13, List list, int i11, Object obj) {
        Subscription subscription2 = subscription;
        int i12 = i11;
        return subscription.copy((i12 & 1) != 0 ? subscription2.membershipId : str, (i12 & 2) != 0 ? subscription2.isActive : z11, (i12 & 4) != 0 ? subscription2.isAutorenewable : z12, (i12 & 8) != 0 ? subscription2.nextBillingDate : localDateTime, (i12 & 16) != 0 ? subscription2.endDate : localDateTime2, (i12 & 32) != 0 ? subscription2.type : subscriptionType, (i12 & 64) != 0 ? subscription2.plan : subscriptionPlan, (i12 & 128) != 0 ? subscription2.isUpgradeable : z13, (i12 & 256) != 0 ? subscription2.upgradeablePlanInfos : list);
    }

    @NotNull
    public final String component1() {
        return this.membershipId;
    }

    public final boolean component2() {
        return this.isActive;
    }

    public final boolean component3() {
        return this.isAutorenewable;
    }

    @Nullable
    public final LocalDateTime component4() {
        return this.nextBillingDate;
    }

    @Nullable
    public final LocalDateTime component5() {
        return this.endDate;
    }

    @NotNull
    public final SubscriptionType component6() {
        return this.type;
    }

    @NotNull
    public final SubscriptionPlan component7() {
        return this.plan;
    }

    public final boolean component8() {
        return this.isUpgradeable;
    }

    @NotNull
    public final List<SubscriptionUpgradePlan> component9() {
        return this.upgradeablePlanInfos;
    }

    @NotNull
    public final Subscription copy(@NotNull String str, boolean z11, boolean z12, @Nullable LocalDateTime localDateTime, @Nullable LocalDateTime localDateTime2, @NotNull SubscriptionType subscriptionType, @NotNull SubscriptionPlan subscriptionPlan, boolean z13, @NotNull List<SubscriptionUpgradePlan> list) {
        Intrinsics.checkNotNullParameter(str, UrlConstantsKt.PATH_MEMBERSHIP_ID);
        SubscriptionType subscriptionType2 = subscriptionType;
        Intrinsics.checkNotNullParameter(subscriptionType2, "type");
        SubscriptionPlan subscriptionPlan2 = subscriptionPlan;
        Intrinsics.checkNotNullParameter(subscriptionPlan2, TLifeNavigationActions.EXTRA_PLAN);
        List<SubscriptionUpgradePlan> list2 = list;
        Intrinsics.checkNotNullParameter(list2, "upgradeablePlanInfos");
        return new Subscription(str, z11, z12, localDateTime, localDateTime2, subscriptionType2, subscriptionPlan2, z13, list2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Subscription)) {
            return false;
        }
        Subscription subscription = (Subscription) obj;
        return Intrinsics.areEqual((Object) this.membershipId, (Object) subscription.membershipId) && this.isActive == subscription.isActive && this.isAutorenewable == subscription.isAutorenewable && Intrinsics.areEqual((Object) this.nextBillingDate, (Object) subscription.nextBillingDate) && Intrinsics.areEqual((Object) this.endDate, (Object) subscription.endDate) && this.type == subscription.type && Intrinsics.areEqual((Object) this.plan, (Object) subscription.plan) && this.isUpgradeable == subscription.isUpgradeable && Intrinsics.areEqual((Object) this.upgradeablePlanInfos, (Object) subscription.upgradeablePlanInfos);
    }

    @Nullable
    public final LocalDateTime getEndDate() {
        return this.endDate;
    }

    @NotNull
    public final String getMembershipId() {
        return this.membershipId;
    }

    public final float getMinDeliveryFee() {
        return this.plan.getMinDeliveryFee();
    }

    @Nullable
    public final LocalDateTime getNextBillingDate() {
        return this.nextBillingDate;
    }

    @NotNull
    public final SubscriptionPlan getPlan() {
        return this.plan;
    }

    @NotNull
    public final SubscriptionType getType() {
        return this.type;
    }

    @NotNull
    public final List<SubscriptionUpgradePlan> getUpgradeablePlanInfos() {
        return this.upgradeablePlanInfos;
    }

    public int hashCode() {
        int hashCode = this.membershipId.hashCode() * 31;
        boolean z11 = this.isActive;
        boolean z12 = true;
        if (z11) {
            z11 = true;
        }
        int i11 = (hashCode + (z11 ? 1 : 0)) * 31;
        boolean z13 = this.isAutorenewable;
        if (z13) {
            z13 = true;
        }
        int i12 = (i11 + (z13 ? 1 : 0)) * 31;
        LocalDateTime localDateTime = this.nextBillingDate;
        int i13 = 0;
        int hashCode2 = (i12 + (localDateTime == null ? 0 : localDateTime.hashCode())) * 31;
        LocalDateTime localDateTime2 = this.endDate;
        if (localDateTime2 != null) {
            i13 = localDateTime2.hashCode();
        }
        int hashCode3 = (((((hashCode2 + i13) * 31) + this.type.hashCode()) * 31) + this.plan.hashCode()) * 31;
        boolean z14 = this.isUpgradeable;
        if (!z14) {
            z12 = z14;
        }
        return ((hashCode3 + (z12 ? 1 : 0)) * 31) + this.upgradeablePlanInfos.hashCode();
    }

    public final boolean isActive() {
        return this.isActive;
    }

    public final boolean isAutorenewable() {
        return this.isAutorenewable;
    }

    public final boolean isFreeCoffeeEnabled() {
        return this.plan.isFreeCoffeeEnabled();
    }

    public final boolean isUpgradeable() {
        return this.isUpgradeable;
    }

    @NotNull
    public String toString() {
        String str = this.membershipId;
        boolean z11 = this.isActive;
        boolean z12 = this.isAutorenewable;
        LocalDateTime localDateTime = this.nextBillingDate;
        LocalDateTime localDateTime2 = this.endDate;
        SubscriptionType subscriptionType = this.type;
        SubscriptionPlan subscriptionPlan = this.plan;
        boolean z13 = this.isUpgradeable;
        List<SubscriptionUpgradePlan> list = this.upgradeablePlanInfos;
        return "Subscription(membershipId=" + str + ", isActive=" + z11 + ", isAutorenewable=" + z12 + ", nextBillingDate=" + localDateTime + ", endDate=" + localDateTime2 + ", type=" + subscriptionType + ", plan=" + subscriptionPlan + ", isUpgradeable=" + z13 + ", upgradeablePlanInfos=" + list + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ Subscription(java.lang.String r39, boolean r40, boolean r41, org.threeten.bp.LocalDateTime r42, org.threeten.bp.LocalDateTime r43, com.talabat.feature.subscriptions.domain.model.SubscriptionType r44, com.talabat.feature.subscriptions.domain.model.SubscriptionPlan r45, boolean r46, java.util.List r47, int r48, kotlin.jvm.internal.DefaultConstructorMarker r49) {
        /*
            r38 = this;
            r0 = r48
            r1 = r0 & 1
            if (r1 == 0) goto L_0x0009
            java.lang.String r1 = ""
            goto L_0x000b
        L_0x0009:
            r1 = r39
        L_0x000b:
            r2 = r0 & 2
            r3 = 0
            if (r2 == 0) goto L_0x0012
            r2 = r3
            goto L_0x0014
        L_0x0012:
            r2 = r40
        L_0x0014:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x001a
            r4 = r3
            goto L_0x001c
        L_0x001a:
            r4 = r41
        L_0x001c:
            r5 = r0 & 8
            r6 = 0
            if (r5 == 0) goto L_0x0023
            r5 = r6
            goto L_0x0025
        L_0x0023:
            r5 = r42
        L_0x0025:
            r7 = r0 & 16
            if (r7 == 0) goto L_0x002a
            goto L_0x002c
        L_0x002a:
            r6 = r43
        L_0x002c:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x0033
            com.talabat.feature.subscriptions.domain.model.SubscriptionType r7 = com.talabat.feature.subscriptions.domain.model.SubscriptionType.Unknown
            goto L_0x0035
        L_0x0033:
            r7 = r44
        L_0x0035:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0073
            com.talabat.feature.subscriptions.domain.model.SubscriptionPlan r8 = new com.talabat.feature.subscriptions.domain.model.SubscriptionPlan
            r9 = r8
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r28 = 0
            r29 = 0
            r30 = 0
            r31 = 0
            r32 = 0
            r33 = 0
            r34 = 0
            r35 = 0
            r36 = 67108863(0x3ffffff, float:1.5046327E-36)
            r37 = 0
            r9.<init>(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37)
            goto L_0x0075
        L_0x0073:
            r8 = r45
        L_0x0075:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x007a
            goto L_0x007c
        L_0x007a:
            r3 = r46
        L_0x007c:
            r0 = r0 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x0085
            java.util.List r0 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
            goto L_0x0087
        L_0x0085:
            r0 = r47
        L_0x0087:
            r39 = r38
            r40 = r1
            r41 = r2
            r42 = r4
            r43 = r5
            r44 = r6
            r45 = r7
            r46 = r8
            r47 = r3
            r48 = r0
            r39.<init>(r40, r41, r42, r43, r44, r45, r46, r47, r48)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.subscriptions.domain.model.Subscription.<init>(java.lang.String, boolean, boolean, org.threeten.bp.LocalDateTime, org.threeten.bp.LocalDateTime, com.talabat.feature.subscriptions.domain.model.SubscriptionType, com.talabat.feature.subscriptions.domain.model.SubscriptionPlan, boolean, java.util.List, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
