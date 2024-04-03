package com.talabat.feature.subscriptions.domain.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BC\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\u000f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\n0\u0007HÆ\u0003J\t\u0010\u001b\u001a\u00020\fHÆ\u0003JG\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00072\b\b\u0002\u0010\u000b\u001a\u00020\fHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u00032\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006\""}, d2 = {"Lcom/talabat/feature/subscriptions/domain/model/SubscriptionMultiPlan;", "", "activeSubscription", "", "freeTrialInfo", "Lcom/talabat/feature/subscriptions/domain/model/FreeTrialInfo;", "plans", "", "Lcom/talabat/feature/subscriptions/domain/model/SubscriptionPlan;", "products", "Lcom/talabat/feature/subscriptions/domain/model/SubscriptionProduct;", "termsUrl", "", "(ZLcom/talabat/feature/subscriptions/domain/model/FreeTrialInfo;Ljava/util/List;Ljava/util/List;Ljava/lang/String;)V", "getActiveSubscription", "()Z", "getFreeTrialInfo", "()Lcom/talabat/feature/subscriptions/domain/model/FreeTrialInfo;", "getPlans", "()Ljava/util/List;", "getProducts", "getTermsUrl", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "com_talabat_feature_subscriptions_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SubscriptionMultiPlan {
    private final boolean activeSubscription;
    @NotNull
    private final FreeTrialInfo freeTrialInfo;
    @NotNull
    private final List<SubscriptionPlan> plans;
    @NotNull
    private final List<SubscriptionProduct> products;
    @NotNull
    private final String termsUrl;

    public SubscriptionMultiPlan() {
        this(false, (FreeTrialInfo) null, (List) null, (List) null, (String) null, 31, (DefaultConstructorMarker) null);
    }

    public SubscriptionMultiPlan(boolean z11, @NotNull FreeTrialInfo freeTrialInfo2, @NotNull List<SubscriptionPlan> list, @NotNull List<SubscriptionProduct> list2, @NotNull String str) {
        Intrinsics.checkNotNullParameter(freeTrialInfo2, "freeTrialInfo");
        Intrinsics.checkNotNullParameter(list, "plans");
        Intrinsics.checkNotNullParameter(list2, "products");
        Intrinsics.checkNotNullParameter(str, "termsUrl");
        this.activeSubscription = z11;
        this.freeTrialInfo = freeTrialInfo2;
        this.plans = list;
        this.products = list2;
        this.termsUrl = str;
    }

    public static /* synthetic */ SubscriptionMultiPlan copy$default(SubscriptionMultiPlan subscriptionMultiPlan, boolean z11, FreeTrialInfo freeTrialInfo2, List<SubscriptionPlan> list, List<SubscriptionProduct> list2, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = subscriptionMultiPlan.activeSubscription;
        }
        if ((i11 & 2) != 0) {
            freeTrialInfo2 = subscriptionMultiPlan.freeTrialInfo;
        }
        FreeTrialInfo freeTrialInfo3 = freeTrialInfo2;
        if ((i11 & 4) != 0) {
            list = subscriptionMultiPlan.plans;
        }
        List<SubscriptionPlan> list3 = list;
        if ((i11 & 8) != 0) {
            list2 = subscriptionMultiPlan.products;
        }
        List<SubscriptionProduct> list4 = list2;
        if ((i11 & 16) != 0) {
            str = subscriptionMultiPlan.termsUrl;
        }
        return subscriptionMultiPlan.copy(z11, freeTrialInfo3, list3, list4, str);
    }

    public final boolean component1() {
        return this.activeSubscription;
    }

    @NotNull
    public final FreeTrialInfo component2() {
        return this.freeTrialInfo;
    }

    @NotNull
    public final List<SubscriptionPlan> component3() {
        return this.plans;
    }

    @NotNull
    public final List<SubscriptionProduct> component4() {
        return this.products;
    }

    @NotNull
    public final String component5() {
        return this.termsUrl;
    }

    @NotNull
    public final SubscriptionMultiPlan copy(boolean z11, @NotNull FreeTrialInfo freeTrialInfo2, @NotNull List<SubscriptionPlan> list, @NotNull List<SubscriptionProduct> list2, @NotNull String str) {
        Intrinsics.checkNotNullParameter(freeTrialInfo2, "freeTrialInfo");
        Intrinsics.checkNotNullParameter(list, "plans");
        Intrinsics.checkNotNullParameter(list2, "products");
        Intrinsics.checkNotNullParameter(str, "termsUrl");
        return new SubscriptionMultiPlan(z11, freeTrialInfo2, list, list2, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SubscriptionMultiPlan)) {
            return false;
        }
        SubscriptionMultiPlan subscriptionMultiPlan = (SubscriptionMultiPlan) obj;
        return this.activeSubscription == subscriptionMultiPlan.activeSubscription && Intrinsics.areEqual((Object) this.freeTrialInfo, (Object) subscriptionMultiPlan.freeTrialInfo) && Intrinsics.areEqual((Object) this.plans, (Object) subscriptionMultiPlan.plans) && Intrinsics.areEqual((Object) this.products, (Object) subscriptionMultiPlan.products) && Intrinsics.areEqual((Object) this.termsUrl, (Object) subscriptionMultiPlan.termsUrl);
    }

    public final boolean getActiveSubscription() {
        return this.activeSubscription;
    }

    @NotNull
    public final FreeTrialInfo getFreeTrialInfo() {
        return this.freeTrialInfo;
    }

    @NotNull
    public final List<SubscriptionPlan> getPlans() {
        return this.plans;
    }

    @NotNull
    public final List<SubscriptionProduct> getProducts() {
        return this.products;
    }

    @NotNull
    public final String getTermsUrl() {
        return this.termsUrl;
    }

    public int hashCode() {
        boolean z11 = this.activeSubscription;
        if (z11) {
            z11 = true;
        }
        return ((((((((z11 ? 1 : 0) * true) + this.freeTrialInfo.hashCode()) * 31) + this.plans.hashCode()) * 31) + this.products.hashCode()) * 31) + this.termsUrl.hashCode();
    }

    @NotNull
    public String toString() {
        boolean z11 = this.activeSubscription;
        FreeTrialInfo freeTrialInfo2 = this.freeTrialInfo;
        List<SubscriptionPlan> list = this.plans;
        List<SubscriptionProduct> list2 = this.products;
        String str = this.termsUrl;
        return "SubscriptionMultiPlan(activeSubscription=" + z11 + ", freeTrialInfo=" + freeTrialInfo2 + ", plans=" + list + ", products=" + list2 + ", termsUrl=" + str + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ SubscriptionMultiPlan(boolean r5, com.talabat.feature.subscriptions.domain.model.FreeTrialInfo r6, java.util.List r7, java.util.List r8, java.lang.String r9, int r10, kotlin.jvm.internal.DefaultConstructorMarker r11) {
        /*
            r4 = this;
            r11 = r10 & 1
            r0 = 0
            if (r11 == 0) goto L_0x0007
            r11 = r0
            goto L_0x0008
        L_0x0007:
            r11 = r5
        L_0x0008:
            r5 = r10 & 2
            java.lang.String r1 = ""
            if (r5 == 0) goto L_0x0013
            com.talabat.feature.subscriptions.domain.model.FreeTrialInfo r6 = new com.talabat.feature.subscriptions.domain.model.FreeTrialInfo
            r6.<init>(r0, r1, r0)
        L_0x0013:
            r0 = r6
            r5 = r10 & 4
            if (r5 == 0) goto L_0x001c
            java.util.List r7 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
        L_0x001c:
            r2 = r7
            r5 = r10 & 8
            if (r5 == 0) goto L_0x0025
            java.util.List r8 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
        L_0x0025:
            r3 = r8
            r5 = r10 & 16
            if (r5 == 0) goto L_0x002c
            r10 = r1
            goto L_0x002d
        L_0x002c:
            r10 = r9
        L_0x002d:
            r5 = r4
            r6 = r11
            r7 = r0
            r8 = r2
            r9 = r3
            r5.<init>(r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.subscriptions.domain.model.SubscriptionMultiPlan.<init>(boolean, com.talabat.feature.subscriptions.domain.model.FreeTrialInfo, java.util.List, java.util.List, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
