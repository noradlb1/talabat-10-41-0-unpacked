package com.talabat.feature.subscriptions.domain.model;

import com.talabat.feature.bnplcheckout.presentation.BNPLCheckoutFlutterFragment;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.threeten.bp.LocalDateTime;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\bE\b\b\u0018\u00002\u00020\u0001B\u0002\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000b\u0012\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001b\u001a\u00020\b\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u001d\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u001f\u0012\b\b\u0002\u0010 \u001a\u00020\u0003\u0012\b\b\u0002\u0010!\u001a\u00020\u0003\u0012\b\b\u0002\u0010\"\u001a\u00020\u0003\u0012\b\b\u0002\u0010#\u001a\u00020\u0003\u0012\b\b\u0002\u0010$\u001a\u00020%\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'¢\u0006\u0002\u0010(J\t\u0010M\u001a\u00020\u0003HÆ\u0003J\u000f\u0010N\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010HÆ\u0003J\t\u0010O\u001a\u00020\u0013HÆ\u0003J\t\u0010P\u001a\u00020\u0015HÆ\u0003J\t\u0010Q\u001a\u00020\u0003HÆ\u0003J\t\u0010R\u001a\u00020\u0003HÆ\u0003J\t\u0010S\u001a\u00020\u0003HÆ\u0003J\t\u0010T\u001a\u00020\u0003HÆ\u0003J\t\u0010U\u001a\u00020\u0003HÆ\u0003J\t\u0010V\u001a\u00020\bHÆ\u0003J\t\u0010W\u001a\u00020\u001dHÆ\u0003J\t\u0010X\u001a\u00020\u0003HÆ\u0003J\t\u0010Y\u001a\u00020\u001fHÆ\u0003J\t\u0010Z\u001a\u00020\u0003HÆ\u0003J\t\u0010[\u001a\u00020\u0003HÆ\u0003J\t\u0010\\\u001a\u00020\u0003HÆ\u0003J\t\u0010]\u001a\u00020\u0003HÆ\u0003J\t\u0010^\u001a\u00020%HÆ\u0003J\u000b\u0010_\u001a\u0004\u0018\u00010'HÆ\u0003J\t\u0010`\u001a\u00020\u0003HÆ\u0003J\t\u0010a\u001a\u00020\u0003HÆ\u0003J\t\u0010b\u001a\u00020\bHÆ\u0003J\t\u0010c\u001a\u00020\u0003HÆ\u0003J\t\u0010d\u001a\u00020\u000bHÆ\u0003J\t\u0010e\u001a\u00020\rHÆ\u0003J\t\u0010f\u001a\u00020\u000bHÆ\u0003J\u0002\u0010g\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000b2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u001b\u001a\u00020\b2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020\u00032\b\b\u0002\u0010!\u001a\u00020\u00032\b\b\u0002\u0010\"\u001a\u00020\u00032\b\b\u0002\u0010#\u001a\u00020\u00032\b\b\u0002\u0010$\u001a\u00020%2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'HÆ\u0001J\u0013\u0010h\u001a\u00020\u000b2\b\u0010i\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010j\u001a\u00020\bHÖ\u0001J\t\u0010k\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0011\u0010\"\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0011\u0010!\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b-\u0010,R\u0011\u0010 \u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b.\u0010,R\u0011\u0010#\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b/\u0010,R\u0011\u0010\u0018\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b0\u0010,R\u0011\u0010\u001e\u001a\u00020\u001f¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0011\u0010\u001c\u001a\u00020\u001d¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b5\u0010,R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b8\u0010,R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:R\u0013\u0010&\u001a\u0004\u0018\u00010'¢\u0006\b\n\u0000\u001a\u0004\b;\u0010<R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b=\u0010>R\u0011\u0010\u0019\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b?\u0010,R\u0011\u0010\u000e\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010*R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b@\u0010AR\u0011\u0010\u001b\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\bB\u0010:R\u0011\u0010\u001a\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bC\u0010,R\u0011\u0010\u0016\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bD\u0010,R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bE\u0010,R\u0011\u0010\u0017\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bF\u0010,R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\b\n\u0000\u001a\u0004\bG\u0010HR\u0011\u0010$\u001a\u00020%¢\u0006\b\n\u0000\u001a\u0004\bI\u0010JR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bK\u0010,R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bL\u0010,¨\u0006l"}, d2 = {"Lcom/talabat/feature/subscriptions/domain/model/SubscriptionPlan;", "", "planId", "", "title", "description", "country", "durationDays", "", "termsUrl", "activeSubscription", "", "minDeliveryFee", "", "isFreeCoffeeEnabled", "products", "", "Lcom/talabat/feature/subscriptions/domain/model/SubscriptionProduct;", "currencyAmount", "Lcom/talabat/feature/subscriptions/domain/model/CurrencyAmount;", "freeTrialInfo", "Lcom/talabat/feature/subscriptions/domain/model/FreeTrialInfo;", "periodPrice", "planPeriod", "billingCycle", "freeTrialText", "paymentText", "order", "category", "Lcom/talabat/feature/subscriptions/domain/model/SubscriptionPlanCategory;", "cancellationType", "Lcom/talabat/feature/subscriptions/domain/model/SubscriptionCancellationType;", "bannerImage", "bannerHeader", "bannerDescription", "benefitsHeader", "renewType", "Lcom/talabat/feature/subscriptions/domain/model/SubscriptionRenewType;", "endDate", "Lorg/threeten/bp/LocalDateTime;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ZFZLjava/util/List;Lcom/talabat/feature/subscriptions/domain/model/CurrencyAmount;Lcom/talabat/feature/subscriptions/domain/model/FreeTrialInfo;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILcom/talabat/feature/subscriptions/domain/model/SubscriptionPlanCategory;Lcom/talabat/feature/subscriptions/domain/model/SubscriptionCancellationType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/talabat/feature/subscriptions/domain/model/SubscriptionRenewType;Lorg/threeten/bp/LocalDateTime;)V", "getActiveSubscription", "()Z", "getBannerDescription", "()Ljava/lang/String;", "getBannerHeader", "getBannerImage", "getBenefitsHeader", "getBillingCycle", "getCancellationType", "()Lcom/talabat/feature/subscriptions/domain/model/SubscriptionCancellationType;", "getCategory", "()Lcom/talabat/feature/subscriptions/domain/model/SubscriptionPlanCategory;", "getCountry", "getCurrencyAmount", "()Lcom/talabat/feature/subscriptions/domain/model/CurrencyAmount;", "getDescription", "getDurationDays", "()I", "getEndDate", "()Lorg/threeten/bp/LocalDateTime;", "getFreeTrialInfo", "()Lcom/talabat/feature/subscriptions/domain/model/FreeTrialInfo;", "getFreeTrialText", "getMinDeliveryFee", "()F", "getOrder", "getPaymentText", "getPeriodPrice", "getPlanId", "getPlanPeriod", "getProducts", "()Ljava/util/List;", "getRenewType", "()Lcom/talabat/feature/subscriptions/domain/model/SubscriptionRenewType;", "getTermsUrl", "getTitle", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "com_talabat_feature_subscriptions_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SubscriptionPlan {
    private final boolean activeSubscription;
    @NotNull
    private final String bannerDescription;
    @NotNull
    private final String bannerHeader;
    @NotNull
    private final String bannerImage;
    @NotNull
    private final String benefitsHeader;
    @NotNull
    private final String billingCycle;
    @NotNull
    private final SubscriptionCancellationType cancellationType;
    @NotNull
    private final SubscriptionPlanCategory category;
    @NotNull
    private final String country;
    @NotNull
    private final CurrencyAmount currencyAmount;
    @NotNull
    private final String description;
    private final int durationDays;
    @Nullable
    private final LocalDateTime endDate;
    @NotNull
    private final FreeTrialInfo freeTrialInfo;
    @NotNull
    private final String freeTrialText;
    private final boolean isFreeCoffeeEnabled;
    private final float minDeliveryFee;
    private final int order;
    @NotNull
    private final String paymentText;
    @NotNull
    private final String periodPrice;
    @NotNull
    private final String planId;
    @NotNull
    private final String planPeriod;
    @NotNull
    private final List<SubscriptionProduct> products;
    @NotNull
    private final SubscriptionRenewType renewType;
    @NotNull
    private final String termsUrl;
    @NotNull
    private final String title;

    public SubscriptionPlan() {
        this((String) null, (String) null, (String) null, (String) null, 0, (String) null, false, 0.0f, false, (List) null, (CurrencyAmount) null, (FreeTrialInfo) null, (String) null, (String) null, (String) null, (String) null, (String) null, 0, (SubscriptionPlanCategory) null, (SubscriptionCancellationType) null, (String) null, (String) null, (String) null, (String) null, (SubscriptionRenewType) null, (LocalDateTime) null, 67108863, (DefaultConstructorMarker) null);
    }

    public SubscriptionPlan(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, int i11, @NotNull String str5, boolean z11, float f11, boolean z12, @NotNull List<SubscriptionProduct> list, @NotNull CurrencyAmount currencyAmount2, @NotNull FreeTrialInfo freeTrialInfo2, @NotNull String str6, @NotNull String str7, @NotNull String str8, @NotNull String str9, @NotNull String str10, int i12, @NotNull SubscriptionPlanCategory subscriptionPlanCategory, @NotNull SubscriptionCancellationType subscriptionCancellationType, @NotNull String str11, @NotNull String str12, @NotNull String str13, @NotNull String str14, @NotNull SubscriptionRenewType subscriptionRenewType, @Nullable LocalDateTime localDateTime) {
        String str15 = str;
        String str16 = str2;
        String str17 = str3;
        String str18 = str4;
        String str19 = str5;
        List<SubscriptionProduct> list2 = list;
        CurrencyAmount currencyAmount3 = currencyAmount2;
        FreeTrialInfo freeTrialInfo3 = freeTrialInfo2;
        String str20 = str6;
        String str21 = str7;
        String str22 = str8;
        String str23 = str9;
        String str24 = str10;
        SubscriptionPlanCategory subscriptionPlanCategory2 = subscriptionPlanCategory;
        String str25 = str11;
        Intrinsics.checkNotNullParameter(str15, BNPLCheckoutFlutterFragment.PLAN_ID_EXTRA);
        Intrinsics.checkNotNullParameter(str16, "title");
        Intrinsics.checkNotNullParameter(str17, "description");
        Intrinsics.checkNotNullParameter(str18, "country");
        Intrinsics.checkNotNullParameter(str19, "termsUrl");
        Intrinsics.checkNotNullParameter(list2, "products");
        Intrinsics.checkNotNullParameter(currencyAmount3, "currencyAmount");
        Intrinsics.checkNotNullParameter(freeTrialInfo3, "freeTrialInfo");
        Intrinsics.checkNotNullParameter(str20, "periodPrice");
        Intrinsics.checkNotNullParameter(str21, "planPeriod");
        Intrinsics.checkNotNullParameter(str22, "billingCycle");
        Intrinsics.checkNotNullParameter(str23, "freeTrialText");
        Intrinsics.checkNotNullParameter(str24, "paymentText");
        Intrinsics.checkNotNullParameter(subscriptionPlanCategory2, "category");
        Intrinsics.checkNotNullParameter(subscriptionCancellationType, "cancellationType");
        Intrinsics.checkNotNullParameter(str11, "bannerImage");
        Intrinsics.checkNotNullParameter(str12, "bannerHeader");
        Intrinsics.checkNotNullParameter(str13, "bannerDescription");
        Intrinsics.checkNotNullParameter(str14, "benefitsHeader");
        Intrinsics.checkNotNullParameter(subscriptionRenewType, "renewType");
        this.planId = str15;
        this.title = str16;
        this.description = str17;
        this.country = str18;
        this.durationDays = i11;
        this.termsUrl = str19;
        this.activeSubscription = z11;
        this.minDeliveryFee = f11;
        this.isFreeCoffeeEnabled = z12;
        this.products = list2;
        this.currencyAmount = currencyAmount3;
        this.freeTrialInfo = freeTrialInfo3;
        this.periodPrice = str20;
        this.planPeriod = str21;
        this.billingCycle = str22;
        this.freeTrialText = str23;
        this.paymentText = str24;
        this.order = i12;
        this.category = subscriptionPlanCategory2;
        this.cancellationType = subscriptionCancellationType;
        this.bannerImage = str11;
        this.bannerHeader = str12;
        this.bannerDescription = str13;
        this.benefitsHeader = str14;
        this.renewType = subscriptionRenewType;
        this.endDate = localDateTime;
    }

    public static /* synthetic */ SubscriptionPlan copy$default(SubscriptionPlan subscriptionPlan, String str, String str2, String str3, String str4, int i11, String str5, boolean z11, float f11, boolean z12, List list, CurrencyAmount currencyAmount2, FreeTrialInfo freeTrialInfo2, String str6, String str7, String str8, String str9, String str10, int i12, SubscriptionPlanCategory subscriptionPlanCategory, SubscriptionCancellationType subscriptionCancellationType, String str11, String str12, String str13, String str14, SubscriptionRenewType subscriptionRenewType, LocalDateTime localDateTime, int i13, Object obj) {
        SubscriptionPlan subscriptionPlan2 = subscriptionPlan;
        int i14 = i13;
        return subscriptionPlan.copy((i14 & 1) != 0 ? subscriptionPlan2.planId : str, (i14 & 2) != 0 ? subscriptionPlan2.title : str2, (i14 & 4) != 0 ? subscriptionPlan2.description : str3, (i14 & 8) != 0 ? subscriptionPlan2.country : str4, (i14 & 16) != 0 ? subscriptionPlan2.durationDays : i11, (i14 & 32) != 0 ? subscriptionPlan2.termsUrl : str5, (i14 & 64) != 0 ? subscriptionPlan2.activeSubscription : z11, (i14 & 128) != 0 ? subscriptionPlan2.minDeliveryFee : f11, (i14 & 256) != 0 ? subscriptionPlan2.isFreeCoffeeEnabled : z12, (i14 & 512) != 0 ? subscriptionPlan2.products : list, (i14 & 1024) != 0 ? subscriptionPlan2.currencyAmount : currencyAmount2, (i14 & 2048) != 0 ? subscriptionPlan2.freeTrialInfo : freeTrialInfo2, (i14 & 4096) != 0 ? subscriptionPlan2.periodPrice : str6, (i14 & 8192) != 0 ? subscriptionPlan2.planPeriod : str7, (i14 & 16384) != 0 ? subscriptionPlan2.billingCycle : str8, (i14 & 32768) != 0 ? subscriptionPlan2.freeTrialText : str9, (i14 & 65536) != 0 ? subscriptionPlan2.paymentText : str10, (i14 & 131072) != 0 ? subscriptionPlan2.order : i12, (i14 & 262144) != 0 ? subscriptionPlan2.category : subscriptionPlanCategory, (i14 & 524288) != 0 ? subscriptionPlan2.cancellationType : subscriptionCancellationType, (i14 & 1048576) != 0 ? subscriptionPlan2.bannerImage : str11, (i14 & 2097152) != 0 ? subscriptionPlan2.bannerHeader : str12, (i14 & 4194304) != 0 ? subscriptionPlan2.bannerDescription : str13, (i14 & 8388608) != 0 ? subscriptionPlan2.benefitsHeader : str14, (i14 & 16777216) != 0 ? subscriptionPlan2.renewType : subscriptionRenewType, (i14 & 33554432) != 0 ? subscriptionPlan2.endDate : localDateTime);
    }

    @NotNull
    public final String component1() {
        return this.planId;
    }

    @NotNull
    public final List<SubscriptionProduct> component10() {
        return this.products;
    }

    @NotNull
    public final CurrencyAmount component11() {
        return this.currencyAmount;
    }

    @NotNull
    public final FreeTrialInfo component12() {
        return this.freeTrialInfo;
    }

    @NotNull
    public final String component13() {
        return this.periodPrice;
    }

    @NotNull
    public final String component14() {
        return this.planPeriod;
    }

    @NotNull
    public final String component15() {
        return this.billingCycle;
    }

    @NotNull
    public final String component16() {
        return this.freeTrialText;
    }

    @NotNull
    public final String component17() {
        return this.paymentText;
    }

    public final int component18() {
        return this.order;
    }

    @NotNull
    public final SubscriptionPlanCategory component19() {
        return this.category;
    }

    @NotNull
    public final String component2() {
        return this.title;
    }

    @NotNull
    public final SubscriptionCancellationType component20() {
        return this.cancellationType;
    }

    @NotNull
    public final String component21() {
        return this.bannerImage;
    }

    @NotNull
    public final String component22() {
        return this.bannerHeader;
    }

    @NotNull
    public final String component23() {
        return this.bannerDescription;
    }

    @NotNull
    public final String component24() {
        return this.benefitsHeader;
    }

    @NotNull
    public final SubscriptionRenewType component25() {
        return this.renewType;
    }

    @Nullable
    public final LocalDateTime component26() {
        return this.endDate;
    }

    @NotNull
    public final String component3() {
        return this.description;
    }

    @NotNull
    public final String component4() {
        return this.country;
    }

    public final int component5() {
        return this.durationDays;
    }

    @NotNull
    public final String component6() {
        return this.termsUrl;
    }

    public final boolean component7() {
        return this.activeSubscription;
    }

    public final float component8() {
        return this.minDeliveryFee;
    }

    public final boolean component9() {
        return this.isFreeCoffeeEnabled;
    }

    @NotNull
    public final SubscriptionPlan copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, int i11, @NotNull String str5, boolean z11, float f11, boolean z12, @NotNull List<SubscriptionProduct> list, @NotNull CurrencyAmount currencyAmount2, @NotNull FreeTrialInfo freeTrialInfo2, @NotNull String str6, @NotNull String str7, @NotNull String str8, @NotNull String str9, @NotNull String str10, int i12, @NotNull SubscriptionPlanCategory subscriptionPlanCategory, @NotNull SubscriptionCancellationType subscriptionCancellationType, @NotNull String str11, @NotNull String str12, @NotNull String str13, @NotNull String str14, @NotNull SubscriptionRenewType subscriptionRenewType, @Nullable LocalDateTime localDateTime) {
        String str15 = str;
        Intrinsics.checkNotNullParameter(str15, BNPLCheckoutFlutterFragment.PLAN_ID_EXTRA);
        Intrinsics.checkNotNullParameter(str2, "title");
        Intrinsics.checkNotNullParameter(str3, "description");
        Intrinsics.checkNotNullParameter(str4, "country");
        Intrinsics.checkNotNullParameter(str5, "termsUrl");
        Intrinsics.checkNotNullParameter(list, "products");
        Intrinsics.checkNotNullParameter(currencyAmount2, "currencyAmount");
        Intrinsics.checkNotNullParameter(freeTrialInfo2, "freeTrialInfo");
        Intrinsics.checkNotNullParameter(str6, "periodPrice");
        Intrinsics.checkNotNullParameter(str7, "planPeriod");
        Intrinsics.checkNotNullParameter(str8, "billingCycle");
        Intrinsics.checkNotNullParameter(str9, "freeTrialText");
        Intrinsics.checkNotNullParameter(str10, "paymentText");
        Intrinsics.checkNotNullParameter(subscriptionPlanCategory, "category");
        Intrinsics.checkNotNullParameter(subscriptionCancellationType, "cancellationType");
        Intrinsics.checkNotNullParameter(str11, "bannerImage");
        Intrinsics.checkNotNullParameter(str12, "bannerHeader");
        Intrinsics.checkNotNullParameter(str13, "bannerDescription");
        Intrinsics.checkNotNullParameter(str14, "benefitsHeader");
        Intrinsics.checkNotNullParameter(subscriptionRenewType, "renewType");
        return new SubscriptionPlan(str15, str2, str3, str4, i11, str5, z11, f11, z12, list, currencyAmount2, freeTrialInfo2, str6, str7, str8, str9, str10, i12, subscriptionPlanCategory, subscriptionCancellationType, str11, str12, str13, str14, subscriptionRenewType, localDateTime);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SubscriptionPlan)) {
            return false;
        }
        SubscriptionPlan subscriptionPlan = (SubscriptionPlan) obj;
        return Intrinsics.areEqual((Object) this.planId, (Object) subscriptionPlan.planId) && Intrinsics.areEqual((Object) this.title, (Object) subscriptionPlan.title) && Intrinsics.areEqual((Object) this.description, (Object) subscriptionPlan.description) && Intrinsics.areEqual((Object) this.country, (Object) subscriptionPlan.country) && this.durationDays == subscriptionPlan.durationDays && Intrinsics.areEqual((Object) this.termsUrl, (Object) subscriptionPlan.termsUrl) && this.activeSubscription == subscriptionPlan.activeSubscription && Intrinsics.areEqual((Object) Float.valueOf(this.minDeliveryFee), (Object) Float.valueOf(subscriptionPlan.minDeliveryFee)) && this.isFreeCoffeeEnabled == subscriptionPlan.isFreeCoffeeEnabled && Intrinsics.areEqual((Object) this.products, (Object) subscriptionPlan.products) && Intrinsics.areEqual((Object) this.currencyAmount, (Object) subscriptionPlan.currencyAmount) && Intrinsics.areEqual((Object) this.freeTrialInfo, (Object) subscriptionPlan.freeTrialInfo) && Intrinsics.areEqual((Object) this.periodPrice, (Object) subscriptionPlan.periodPrice) && Intrinsics.areEqual((Object) this.planPeriod, (Object) subscriptionPlan.planPeriod) && Intrinsics.areEqual((Object) this.billingCycle, (Object) subscriptionPlan.billingCycle) && Intrinsics.areEqual((Object) this.freeTrialText, (Object) subscriptionPlan.freeTrialText) && Intrinsics.areEqual((Object) this.paymentText, (Object) subscriptionPlan.paymentText) && this.order == subscriptionPlan.order && this.category == subscriptionPlan.category && this.cancellationType == subscriptionPlan.cancellationType && Intrinsics.areEqual((Object) this.bannerImage, (Object) subscriptionPlan.bannerImage) && Intrinsics.areEqual((Object) this.bannerHeader, (Object) subscriptionPlan.bannerHeader) && Intrinsics.areEqual((Object) this.bannerDescription, (Object) subscriptionPlan.bannerDescription) && Intrinsics.areEqual((Object) this.benefitsHeader, (Object) subscriptionPlan.benefitsHeader) && this.renewType == subscriptionPlan.renewType && Intrinsics.areEqual((Object) this.endDate, (Object) subscriptionPlan.endDate);
    }

    public final boolean getActiveSubscription() {
        return this.activeSubscription;
    }

    @NotNull
    public final String getBannerDescription() {
        return this.bannerDescription;
    }

    @NotNull
    public final String getBannerHeader() {
        return this.bannerHeader;
    }

    @NotNull
    public final String getBannerImage() {
        return this.bannerImage;
    }

    @NotNull
    public final String getBenefitsHeader() {
        return this.benefitsHeader;
    }

    @NotNull
    public final String getBillingCycle() {
        return this.billingCycle;
    }

    @NotNull
    public final SubscriptionCancellationType getCancellationType() {
        return this.cancellationType;
    }

    @NotNull
    public final SubscriptionPlanCategory getCategory() {
        return this.category;
    }

    @NotNull
    public final String getCountry() {
        return this.country;
    }

    @NotNull
    public final CurrencyAmount getCurrencyAmount() {
        return this.currencyAmount;
    }

    @NotNull
    public final String getDescription() {
        return this.description;
    }

    public final int getDurationDays() {
        return this.durationDays;
    }

    @Nullable
    public final LocalDateTime getEndDate() {
        return this.endDate;
    }

    @NotNull
    public final FreeTrialInfo getFreeTrialInfo() {
        return this.freeTrialInfo;
    }

    @NotNull
    public final String getFreeTrialText() {
        return this.freeTrialText;
    }

    public final float getMinDeliveryFee() {
        return this.minDeliveryFee;
    }

    public final int getOrder() {
        return this.order;
    }

    @NotNull
    public final String getPaymentText() {
        return this.paymentText;
    }

    @NotNull
    public final String getPeriodPrice() {
        return this.periodPrice;
    }

    @NotNull
    public final String getPlanId() {
        return this.planId;
    }

    @NotNull
    public final String getPlanPeriod() {
        return this.planPeriod;
    }

    @NotNull
    public final List<SubscriptionProduct> getProducts() {
        return this.products;
    }

    @NotNull
    public final SubscriptionRenewType getRenewType() {
        return this.renewType;
    }

    @NotNull
    public final String getTermsUrl() {
        return this.termsUrl;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        int hashCode = ((((((((((this.planId.hashCode() * 31) + this.title.hashCode()) * 31) + this.description.hashCode()) * 31) + this.country.hashCode()) * 31) + this.durationDays) * 31) + this.termsUrl.hashCode()) * 31;
        boolean z11 = this.activeSubscription;
        boolean z12 = true;
        if (z11) {
            z11 = true;
        }
        int floatToIntBits = (((hashCode + (z11 ? 1 : 0)) * 31) + Float.floatToIntBits(this.minDeliveryFee)) * 31;
        boolean z13 = this.isFreeCoffeeEnabled;
        if (!z13) {
            z12 = z13;
        }
        int hashCode2 = (((((((((((((((((((((((((((((((((floatToIntBits + (z12 ? 1 : 0)) * 31) + this.products.hashCode()) * 31) + this.currencyAmount.hashCode()) * 31) + this.freeTrialInfo.hashCode()) * 31) + this.periodPrice.hashCode()) * 31) + this.planPeriod.hashCode()) * 31) + this.billingCycle.hashCode()) * 31) + this.freeTrialText.hashCode()) * 31) + this.paymentText.hashCode()) * 31) + this.order) * 31) + this.category.hashCode()) * 31) + this.cancellationType.hashCode()) * 31) + this.bannerImage.hashCode()) * 31) + this.bannerHeader.hashCode()) * 31) + this.bannerDescription.hashCode()) * 31) + this.benefitsHeader.hashCode()) * 31) + this.renewType.hashCode()) * 31;
        LocalDateTime localDateTime = this.endDate;
        return hashCode2 + (localDateTime == null ? 0 : localDateTime.hashCode());
    }

    public final boolean isFreeCoffeeEnabled() {
        return this.isFreeCoffeeEnabled;
    }

    @NotNull
    public String toString() {
        String str = this.planId;
        String str2 = this.title;
        String str3 = this.description;
        String str4 = this.country;
        int i11 = this.durationDays;
        String str5 = this.termsUrl;
        boolean z11 = this.activeSubscription;
        float f11 = this.minDeliveryFee;
        boolean z12 = this.isFreeCoffeeEnabled;
        List<SubscriptionProduct> list = this.products;
        CurrencyAmount currencyAmount2 = this.currencyAmount;
        FreeTrialInfo freeTrialInfo2 = this.freeTrialInfo;
        String str6 = this.periodPrice;
        String str7 = this.planPeriod;
        String str8 = this.billingCycle;
        String str9 = this.freeTrialText;
        String str10 = this.paymentText;
        int i12 = this.order;
        SubscriptionPlanCategory subscriptionPlanCategory = this.category;
        SubscriptionCancellationType subscriptionCancellationType = this.cancellationType;
        String str11 = this.bannerImage;
        String str12 = this.bannerHeader;
        String str13 = this.bannerDescription;
        String str14 = this.benefitsHeader;
        SubscriptionRenewType subscriptionRenewType = this.renewType;
        LocalDateTime localDateTime = this.endDate;
        return "SubscriptionPlan(planId=" + str + ", title=" + str2 + ", description=" + str3 + ", country=" + str4 + ", durationDays=" + i11 + ", termsUrl=" + str5 + ", activeSubscription=" + z11 + ", minDeliveryFee=" + f11 + ", isFreeCoffeeEnabled=" + z12 + ", products=" + list + ", currencyAmount=" + currencyAmount2 + ", freeTrialInfo=" + freeTrialInfo2 + ", periodPrice=" + str6 + ", planPeriod=" + str7 + ", billingCycle=" + str8 + ", freeTrialText=" + str9 + ", paymentText=" + str10 + ", order=" + i12 + ", category=" + subscriptionPlanCategory + ", cancellationType=" + subscriptionCancellationType + ", bannerImage=" + str11 + ", bannerHeader=" + str12 + ", bannerDescription=" + str13 + ", benefitsHeader=" + str14 + ", renewType=" + subscriptionRenewType + ", endDate=" + localDateTime + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ SubscriptionPlan(java.lang.String r28, java.lang.String r29, java.lang.String r30, java.lang.String r31, int r32, java.lang.String r33, boolean r34, float r35, boolean r36, java.util.List r37, com.talabat.feature.subscriptions.domain.model.CurrencyAmount r38, com.talabat.feature.subscriptions.domain.model.FreeTrialInfo r39, java.lang.String r40, java.lang.String r41, java.lang.String r42, java.lang.String r43, java.lang.String r44, int r45, com.talabat.feature.subscriptions.domain.model.SubscriptionPlanCategory r46, com.talabat.feature.subscriptions.domain.model.SubscriptionCancellationType r47, java.lang.String r48, java.lang.String r49, java.lang.String r50, java.lang.String r51, com.talabat.feature.subscriptions.domain.model.SubscriptionRenewType r52, org.threeten.bp.LocalDateTime r53, int r54, kotlin.jvm.internal.DefaultConstructorMarker r55) {
        /*
            r27 = this;
            r0 = r54
            r1 = r0 & 1
            java.lang.String r2 = ""
            if (r1 == 0) goto L_0x000a
            r1 = r2
            goto L_0x000c
        L_0x000a:
            r1 = r28
        L_0x000c:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0012
            r3 = r2
            goto L_0x0014
        L_0x0012:
            r3 = r29
        L_0x0014:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x001a
            r4 = r2
            goto L_0x001c
        L_0x001a:
            r4 = r30
        L_0x001c:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x0022
            r5 = r2
            goto L_0x0024
        L_0x0022:
            r5 = r31
        L_0x0024:
            r6 = r0 & 16
            r7 = 0
            if (r6 == 0) goto L_0x002b
            r6 = r7
            goto L_0x002d
        L_0x002b:
            r6 = r32
        L_0x002d:
            r8 = r0 & 32
            if (r8 == 0) goto L_0x0033
            r8 = r2
            goto L_0x0035
        L_0x0033:
            r8 = r33
        L_0x0035:
            r9 = r0 & 64
            if (r9 == 0) goto L_0x003b
            r9 = r7
            goto L_0x003d
        L_0x003b:
            r9 = r34
        L_0x003d:
            r10 = r0 & 128(0x80, float:1.794E-43)
            r11 = 0
            if (r10 == 0) goto L_0x0044
            r10 = r11
            goto L_0x0046
        L_0x0044:
            r10 = r35
        L_0x0046:
            r12 = r0 & 256(0x100, float:3.59E-43)
            if (r12 == 0) goto L_0x004c
            r12 = r7
            goto L_0x004e
        L_0x004c:
            r12 = r36
        L_0x004e:
            r13 = r0 & 512(0x200, float:7.175E-43)
            if (r13 == 0) goto L_0x0057
            java.util.List r13 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
            goto L_0x0059
        L_0x0057:
            r13 = r37
        L_0x0059:
            r14 = r0 & 1024(0x400, float:1.435E-42)
            if (r14 == 0) goto L_0x0063
            com.talabat.feature.subscriptions.domain.model.CurrencyAmount r14 = new com.talabat.feature.subscriptions.domain.model.CurrencyAmount
            r14.<init>(r11, r2)
            goto L_0x0065
        L_0x0063:
            r14 = r38
        L_0x0065:
            r11 = r0 & 2048(0x800, float:2.87E-42)
            if (r11 == 0) goto L_0x006f
            com.talabat.feature.subscriptions.domain.model.FreeTrialInfo r11 = new com.talabat.feature.subscriptions.domain.model.FreeTrialInfo
            r11.<init>(r7, r2, r7)
            goto L_0x0071
        L_0x006f:
            r11 = r39
        L_0x0071:
            r15 = r0 & 4096(0x1000, float:5.74E-42)
            if (r15 == 0) goto L_0x0077
            r15 = r2
            goto L_0x0079
        L_0x0077:
            r15 = r40
        L_0x0079:
            r7 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r7 == 0) goto L_0x007f
            r7 = r2
            goto L_0x0081
        L_0x007f:
            r7 = r41
        L_0x0081:
            r55 = r2
            r2 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r2 == 0) goto L_0x008a
            r2 = r55
            goto L_0x008c
        L_0x008a:
            r2 = r42
        L_0x008c:
            r16 = 32768(0x8000, float:4.5918E-41)
            r16 = r0 & r16
            if (r16 == 0) goto L_0x0096
            r16 = r55
            goto L_0x0098
        L_0x0096:
            r16 = r43
        L_0x0098:
            r17 = 65536(0x10000, float:9.18355E-41)
            r17 = r0 & r17
            if (r17 == 0) goto L_0x00a1
            r17 = r55
            goto L_0x00a3
        L_0x00a1:
            r17 = r44
        L_0x00a3:
            r18 = 131072(0x20000, float:1.83671E-40)
            r18 = r0 & r18
            if (r18 == 0) goto L_0x00ac
            r18 = 0
            goto L_0x00ae
        L_0x00ac:
            r18 = r45
        L_0x00ae:
            r19 = 262144(0x40000, float:3.67342E-40)
            r19 = r0 & r19
            if (r19 == 0) goto L_0x00b7
            com.talabat.feature.subscriptions.domain.model.SubscriptionPlanCategory r19 = com.talabat.feature.subscriptions.domain.model.SubscriptionPlanCategory.NONE
            goto L_0x00b9
        L_0x00b7:
            r19 = r46
        L_0x00b9:
            r20 = 524288(0x80000, float:7.34684E-40)
            r20 = r0 & r20
            if (r20 == 0) goto L_0x00c2
            com.talabat.feature.subscriptions.domain.model.SubscriptionCancellationType r20 = com.talabat.feature.subscriptions.domain.model.SubscriptionCancellationType.None
            goto L_0x00c4
        L_0x00c2:
            r20 = r47
        L_0x00c4:
            r21 = 1048576(0x100000, float:1.469368E-39)
            r21 = r0 & r21
            if (r21 == 0) goto L_0x00cd
            r21 = r55
            goto L_0x00cf
        L_0x00cd:
            r21 = r48
        L_0x00cf:
            r22 = 2097152(0x200000, float:2.938736E-39)
            r22 = r0 & r22
            if (r22 == 0) goto L_0x00d8
            r22 = r55
            goto L_0x00da
        L_0x00d8:
            r22 = r49
        L_0x00da:
            r23 = 4194304(0x400000, float:5.877472E-39)
            r23 = r0 & r23
            if (r23 == 0) goto L_0x00e3
            r23 = r55
            goto L_0x00e5
        L_0x00e3:
            r23 = r50
        L_0x00e5:
            r24 = 8388608(0x800000, float:1.17549435E-38)
            r24 = r0 & r24
            if (r24 == 0) goto L_0x00ee
            r24 = r55
            goto L_0x00f0
        L_0x00ee:
            r24 = r51
        L_0x00f0:
            r25 = 16777216(0x1000000, float:2.3509887E-38)
            r25 = r0 & r25
            if (r25 == 0) goto L_0x00f9
            com.talabat.feature.subscriptions.domain.model.SubscriptionRenewType r25 = com.talabat.feature.subscriptions.domain.model.SubscriptionRenewType.NoRenewal
            goto L_0x00fb
        L_0x00f9:
            r25 = r52
        L_0x00fb:
            r26 = 33554432(0x2000000, float:9.403955E-38)
            r0 = r0 & r26
            if (r0 == 0) goto L_0x0103
            r0 = 0
            goto L_0x0105
        L_0x0103:
            r0 = r53
        L_0x0105:
            r28 = r27
            r29 = r1
            r30 = r3
            r31 = r4
            r32 = r5
            r33 = r6
            r34 = r8
            r35 = r9
            r36 = r10
            r37 = r12
            r38 = r13
            r39 = r14
            r40 = r11
            r41 = r15
            r42 = r7
            r43 = r2
            r44 = r16
            r45 = r17
            r46 = r18
            r47 = r19
            r48 = r20
            r49 = r21
            r50 = r22
            r51 = r23
            r52 = r24
            r53 = r25
            r54 = r0
            r28.<init>(r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.subscriptions.domain.model.SubscriptionPlan.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, java.lang.String, boolean, float, boolean, java.util.List, com.talabat.feature.subscriptions.domain.model.CurrencyAmount, com.talabat.feature.subscriptions.domain.model.FreeTrialInfo, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, com.talabat.feature.subscriptions.domain.model.SubscriptionPlanCategory, com.talabat.feature.subscriptions.domain.model.SubscriptionCancellationType, java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.talabat.feature.subscriptions.domain.model.SubscriptionRenewType, org.threeten.bp.LocalDateTime, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
