package com.talabat.feature.subscriptions.data.remote.model;

import com.squareup.moshi.Json;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\"\b\b\u0018\u00002\u00020\u0001B\u0001\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0003\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f\u0012\u0010\b\u0003\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\f\u0012\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0003\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\f¢\u0006\u0002\u0010\u0013J\u0010\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0015J\u0011\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\fHÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010'\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u000b\u0010(\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0015J\u000b\u0010*\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010+\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fHÆ\u0003J\u0011\u0010,\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\fHÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0001\u0010.\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u00052\u0010\b\u0003\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\u0010\b\u0003\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\f2\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u00052\u0010\b\u0003\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\fHÆ\u0001¢\u0006\u0002\u0010/J\u0013\u00100\u001a\u00020\u00032\b\u00101\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00102\u001a\u00020\u0007HÖ\u0001J\t\u00103\u001a\u00020\u0005HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001aR\u0015\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u001c\u0010\u0015R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0018R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0018R\u0019\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0019\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b!\u0010 R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0018R\u0019\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b#\u0010 ¨\u00064"}, d2 = {"Lcom/talabat/feature/subscriptions/data/remote/model/SubscriptionMultiPlanResponseModel;", "", "activeSubscription", "", "category", "", "freeTrialDays", "", "freeTrialTitle", "freeTrialEligible", "onBoardingLink", "products", "", "Lcom/talabat/feature/subscriptions/data/remote/model/SubscriptionProductResponse;", "plans", "Lcom/talabat/feature/subscriptions/data/remote/model/SubscriptionPlanResponseModel;", "termsUrl", "udf", "Lcom/talabat/feature/subscriptions/data/remote/model/UdfItemResponse;", "(Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/util/List;)V", "getActiveSubscription", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getCategory", "()Ljava/lang/String;", "getFreeTrialDays", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getFreeTrialEligible", "getFreeTrialTitle", "getOnBoardingLink", "getPlans", "()Ljava/util/List;", "getProducts", "getTermsUrl", "getUdf", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/util/List;)Lcom/talabat/feature/subscriptions/data/remote/model/SubscriptionMultiPlanResponseModel;", "equals", "other", "hashCode", "toString", "com_talabat_feature_subscriptions_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SubscriptionMultiPlanResponseModel {
    @Nullable
    private final Boolean activeSubscription;
    @Nullable
    private final String category;
    @Nullable
    private final Integer freeTrialDays;
    @Nullable
    private final Boolean freeTrialEligible;
    @Nullable
    private final String freeTrialTitle;
    @Nullable
    private final String onBoardingLink;
    @Nullable
    private final List<SubscriptionPlanResponseModel> plans;
    @Nullable
    private final List<SubscriptionProductResponse> products;
    @Nullable
    private final String termsUrl;
    @Nullable
    private final List<UdfItemResponse> udf;

    public SubscriptionMultiPlanResponseModel() {
        this((Boolean) null, (String) null, (Integer) null, (String) null, (Boolean) null, (String) null, (List) null, (List) null, (String) null, (List) null, 1023, (DefaultConstructorMarker) null);
    }

    public SubscriptionMultiPlanResponseModel(@Nullable @Json(name = "activeSubscription") Boolean bool, @Nullable @Json(name = "category") String str, @Nullable @Json(name = "freeTrialDays") Integer num, @Nullable @Json(name = "freeTrialTitle") String str2, @Nullable @Json(name = "freeTrialEligible") Boolean bool2, @Nullable @Json(name = "onboardingLink") String str3, @Nullable @Json(name = "products") List<SubscriptionProductResponse> list, @Nullable @Json(name = "plans") List<SubscriptionPlanResponseModel> list2, @Nullable @Json(name = "termsUrl") String str4, @Nullable @Json(name = "udf") List<UdfItemResponse> list3) {
        this.activeSubscription = bool;
        this.category = str;
        this.freeTrialDays = num;
        this.freeTrialTitle = str2;
        this.freeTrialEligible = bool2;
        this.onBoardingLink = str3;
        this.products = list;
        this.plans = list2;
        this.termsUrl = str4;
        this.udf = list3;
    }

    public static /* synthetic */ SubscriptionMultiPlanResponseModel copy$default(SubscriptionMultiPlanResponseModel subscriptionMultiPlanResponseModel, Boolean bool, String str, Integer num, String str2, Boolean bool2, String str3, List list, List list2, String str4, List list3, int i11, Object obj) {
        SubscriptionMultiPlanResponseModel subscriptionMultiPlanResponseModel2 = subscriptionMultiPlanResponseModel;
        int i12 = i11;
        return subscriptionMultiPlanResponseModel.copy((i12 & 1) != 0 ? subscriptionMultiPlanResponseModel2.activeSubscription : bool, (i12 & 2) != 0 ? subscriptionMultiPlanResponseModel2.category : str, (i12 & 4) != 0 ? subscriptionMultiPlanResponseModel2.freeTrialDays : num, (i12 & 8) != 0 ? subscriptionMultiPlanResponseModel2.freeTrialTitle : str2, (i12 & 16) != 0 ? subscriptionMultiPlanResponseModel2.freeTrialEligible : bool2, (i12 & 32) != 0 ? subscriptionMultiPlanResponseModel2.onBoardingLink : str3, (i12 & 64) != 0 ? subscriptionMultiPlanResponseModel2.products : list, (i12 & 128) != 0 ? subscriptionMultiPlanResponseModel2.plans : list2, (i12 & 256) != 0 ? subscriptionMultiPlanResponseModel2.termsUrl : str4, (i12 & 512) != 0 ? subscriptionMultiPlanResponseModel2.udf : list3);
    }

    @Nullable
    public final Boolean component1() {
        return this.activeSubscription;
    }

    @Nullable
    public final List<UdfItemResponse> component10() {
        return this.udf;
    }

    @Nullable
    public final String component2() {
        return this.category;
    }

    @Nullable
    public final Integer component3() {
        return this.freeTrialDays;
    }

    @Nullable
    public final String component4() {
        return this.freeTrialTitle;
    }

    @Nullable
    public final Boolean component5() {
        return this.freeTrialEligible;
    }

    @Nullable
    public final String component6() {
        return this.onBoardingLink;
    }

    @Nullable
    public final List<SubscriptionProductResponse> component7() {
        return this.products;
    }

    @Nullable
    public final List<SubscriptionPlanResponseModel> component8() {
        return this.plans;
    }

    @Nullable
    public final String component9() {
        return this.termsUrl;
    }

    @NotNull
    public final SubscriptionMultiPlanResponseModel copy(@Nullable @Json(name = "activeSubscription") Boolean bool, @Nullable @Json(name = "category") String str, @Nullable @Json(name = "freeTrialDays") Integer num, @Nullable @Json(name = "freeTrialTitle") String str2, @Nullable @Json(name = "freeTrialEligible") Boolean bool2, @Nullable @Json(name = "onboardingLink") String str3, @Nullable @Json(name = "products") List<SubscriptionProductResponse> list, @Nullable @Json(name = "plans") List<SubscriptionPlanResponseModel> list2, @Nullable @Json(name = "termsUrl") String str4, @Nullable @Json(name = "udf") List<UdfItemResponse> list3) {
        return new SubscriptionMultiPlanResponseModel(bool, str, num, str2, bool2, str3, list, list2, str4, list3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SubscriptionMultiPlanResponseModel)) {
            return false;
        }
        SubscriptionMultiPlanResponseModel subscriptionMultiPlanResponseModel = (SubscriptionMultiPlanResponseModel) obj;
        return Intrinsics.areEqual((Object) this.activeSubscription, (Object) subscriptionMultiPlanResponseModel.activeSubscription) && Intrinsics.areEqual((Object) this.category, (Object) subscriptionMultiPlanResponseModel.category) && Intrinsics.areEqual((Object) this.freeTrialDays, (Object) subscriptionMultiPlanResponseModel.freeTrialDays) && Intrinsics.areEqual((Object) this.freeTrialTitle, (Object) subscriptionMultiPlanResponseModel.freeTrialTitle) && Intrinsics.areEqual((Object) this.freeTrialEligible, (Object) subscriptionMultiPlanResponseModel.freeTrialEligible) && Intrinsics.areEqual((Object) this.onBoardingLink, (Object) subscriptionMultiPlanResponseModel.onBoardingLink) && Intrinsics.areEqual((Object) this.products, (Object) subscriptionMultiPlanResponseModel.products) && Intrinsics.areEqual((Object) this.plans, (Object) subscriptionMultiPlanResponseModel.plans) && Intrinsics.areEqual((Object) this.termsUrl, (Object) subscriptionMultiPlanResponseModel.termsUrl) && Intrinsics.areEqual((Object) this.udf, (Object) subscriptionMultiPlanResponseModel.udf);
    }

    @Nullable
    public final Boolean getActiveSubscription() {
        return this.activeSubscription;
    }

    @Nullable
    public final String getCategory() {
        return this.category;
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
    public final String getOnBoardingLink() {
        return this.onBoardingLink;
    }

    @Nullable
    public final List<SubscriptionPlanResponseModel> getPlans() {
        return this.plans;
    }

    @Nullable
    public final List<SubscriptionProductResponse> getProducts() {
        return this.products;
    }

    @Nullable
    public final String getTermsUrl() {
        return this.termsUrl;
    }

    @Nullable
    public final List<UdfItemResponse> getUdf() {
        return this.udf;
    }

    public int hashCode() {
        Boolean bool = this.activeSubscription;
        int i11 = 0;
        int hashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        String str = this.category;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        Integer num = this.freeTrialDays;
        int hashCode3 = (hashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        String str2 = this.freeTrialTitle;
        int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Boolean bool2 = this.freeTrialEligible;
        int hashCode5 = (hashCode4 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        String str3 = this.onBoardingLink;
        int hashCode6 = (hashCode5 + (str3 == null ? 0 : str3.hashCode())) * 31;
        List<SubscriptionProductResponse> list = this.products;
        int hashCode7 = (hashCode6 + (list == null ? 0 : list.hashCode())) * 31;
        List<SubscriptionPlanResponseModel> list2 = this.plans;
        int hashCode8 = (hashCode7 + (list2 == null ? 0 : list2.hashCode())) * 31;
        String str4 = this.termsUrl;
        int hashCode9 = (hashCode8 + (str4 == null ? 0 : str4.hashCode())) * 31;
        List<UdfItemResponse> list3 = this.udf;
        if (list3 != null) {
            i11 = list3.hashCode();
        }
        return hashCode9 + i11;
    }

    @NotNull
    public String toString() {
        Boolean bool = this.activeSubscription;
        String str = this.category;
        Integer num = this.freeTrialDays;
        String str2 = this.freeTrialTitle;
        Boolean bool2 = this.freeTrialEligible;
        String str3 = this.onBoardingLink;
        List<SubscriptionProductResponse> list = this.products;
        List<SubscriptionPlanResponseModel> list2 = this.plans;
        String str4 = this.termsUrl;
        List<UdfItemResponse> list3 = this.udf;
        return "SubscriptionMultiPlanResponseModel(activeSubscription=" + bool + ", category=" + str + ", freeTrialDays=" + num + ", freeTrialTitle=" + str2 + ", freeTrialEligible=" + bool2 + ", onBoardingLink=" + str3 + ", products=" + list + ", plans=" + list2 + ", termsUrl=" + str4 + ", udf=" + list3 + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ SubscriptionMultiPlanResponseModel(java.lang.Boolean r12, java.lang.String r13, java.lang.Integer r14, java.lang.String r15, java.lang.Boolean r16, java.lang.String r17, java.util.List r18, java.util.List r19, java.lang.String r20, java.util.List r21, int r22, kotlin.jvm.internal.DefaultConstructorMarker r23) {
        /*
            r11 = this;
            r0 = r22
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = r2
            goto L_0x000a
        L_0x0009:
            r1 = r12
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            r3 = r2
            goto L_0x0011
        L_0x0010:
            r3 = r13
        L_0x0011:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0017
            r4 = r2
            goto L_0x0018
        L_0x0017:
            r4 = r14
        L_0x0018:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x001e
            r5 = r2
            goto L_0x001f
        L_0x001e:
            r5 = r15
        L_0x001f:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0025
            r6 = r2
            goto L_0x0027
        L_0x0025:
            r6 = r16
        L_0x0027:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x002d
            r7 = r2
            goto L_0x002f
        L_0x002d:
            r7 = r17
        L_0x002f:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0035
            r8 = r2
            goto L_0x0037
        L_0x0035:
            r8 = r18
        L_0x0037:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x003d
            r9 = r2
            goto L_0x003f
        L_0x003d:
            r9 = r19
        L_0x003f:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x0045
            r10 = r2
            goto L_0x0047
        L_0x0045:
            r10 = r20
        L_0x0047:
            r0 = r0 & 512(0x200, float:7.175E-43)
            if (r0 == 0) goto L_0x004c
            goto L_0x004e
        L_0x004c:
            r2 = r21
        L_0x004e:
            r12 = r11
            r13 = r1
            r14 = r3
            r15 = r4
            r16 = r5
            r17 = r6
            r18 = r7
            r19 = r8
            r20 = r9
            r21 = r10
            r22 = r2
            r12.<init>(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.subscriptions.data.remote.model.SubscriptionMultiPlanResponseModel.<init>(java.lang.Boolean, java.lang.String, java.lang.Integer, java.lang.String, java.lang.Boolean, java.lang.String, java.util.List, java.util.List, java.lang.String, java.util.List, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
