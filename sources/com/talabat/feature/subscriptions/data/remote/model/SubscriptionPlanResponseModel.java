package com.talabat.feature.subscriptions.data.remote.model;

import com.google.android.exoplayer2.C;
import com.squareup.moshi.Json;
import com.talabat.feature.subscriptions.domain.model.SubscriptionCancellationType;
import com.talabat.feature.subscriptions.domain.model.SubscriptionRenewType;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.threeten.bp.LocalDateTime;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\bO\b\b\u0018\u00002\u00020\u0001Bõ\u0002\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0003\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0003\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0003\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016\u0012\u0010\b\u0003\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0016\u0012\n\b\u0003\u0010\u001a\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u001b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u001c\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u001d\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0003\u0010\u001e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u001f\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0003\u0010 \u001a\u00020!\u0012\n\b\u0003\u0010\"\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010#\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010$\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010%\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0003\u0010&\u001a\u00020'\u0012\n\b\u0003\u0010(\u001a\u0004\u0018\u00010)¢\u0006\u0002\u0010*J\u000b\u0010T\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010U\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010V\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010W\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010X\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0002\u0010,J\u0010\u0010Y\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0002\u0010,J\u000b\u0010Z\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010[\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016HÆ\u0003J\u0011\u0010\\\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0016HÆ\u0003J\u000b\u0010]\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010^\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010_\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010`\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010a\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010>J\u000b\u0010b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010d\u001a\u00020!HÆ\u0003J\u000b\u0010e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010g\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010h\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010i\u001a\u00020'HÆ\u0003J\u000b\u0010j\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010k\u001a\u0004\u0018\u00010)HÆ\u0003J\u0010\u0010l\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010/J\u000b\u0010m\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010o\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010>J\u0010\u0010p\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010>J\u000b\u0010q\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jþ\u0002\u0010r\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0003\u0010\u0013\u001a\u0004\u0018\u00010\u00122\n\b\u0003\u0010\u0014\u001a\u0004\u0018\u00010\u00032\u0010\b\u0003\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00162\u0010\b\u0003\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00162\n\b\u0003\u0010\u001a\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u001b\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u001c\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u001d\u001a\u0004\u0018\u00010\u000b2\n\b\u0003\u0010\u001e\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u001f\u001a\u0004\u0018\u00010\u00032\b\b\u0003\u0010 \u001a\u00020!2\n\b\u0003\u0010\"\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010#\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010$\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010%\u001a\u0004\u0018\u00010\u00032\b\b\u0003\u0010&\u001a\u00020'2\n\b\u0003\u0010(\u001a\u0004\u0018\u00010)HÆ\u0001¢\u0006\u0002\u0010sJ\u0013\u0010t\u001a\u00020\u00122\b\u0010u\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010v\u001a\u00020\u000bHÖ\u0001J\t\u0010w\u001a\u00020\u0003HÖ\u0001R\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u0012¢\u0006\n\n\u0002\u0010-\u001a\u0004\b+\u0010,R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u00100\u001a\u0004\b.\u0010/R\u0013\u0010$\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0013\u0010#\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b3\u00102R\u0013\u0010\"\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b4\u00102R\u0013\u0010%\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b5\u00102R\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b6\u00102R\u0011\u0010 \u001a\u00020!¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b9\u00102R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b:\u00102R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b;\u00102R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b<\u00102R\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010?\u001a\u0004\b=\u0010>R\u0013\u0010(\u001a\u0004\u0018\u00010)¢\u0006\b\n\u0000\u001a\u0004\b@\u0010AR\u0015\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010?\u001a\u0004\bB\u0010>R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\n\n\u0002\u0010-\u001a\u0004\bC\u0010,R\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bD\u00102R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bE\u00102R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bF\u00102R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bG\u00102R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bH\u00102R\u0015\u0010\u001d\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010?\u001a\u0004\bI\u0010>R\u0013\u0010\u001f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bJ\u00102R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bK\u00102R\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bL\u00102R\u0019\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016¢\u0006\b\n\u0000\u001a\u0004\bM\u0010NR\u0011\u0010&\u001a\u00020'¢\u0006\b\n\u0000\u001a\u0004\bO\u0010PR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bQ\u00102R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bR\u00102R\u0019\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0016¢\u0006\b\n\u0000\u001a\u0004\bS\u0010N¨\u0006x"}, d2 = {"Lcom/talabat/feature/subscriptions/data/remote/model/SubscriptionPlanResponseModel;", "", "id", "", "title", "description", "amount", "", "currency", "country", "durationDays", "", "freeTrialDays", "freeTrialTitle", "category", "imageUrl", "termsUrl", "freeTrialEligible", "", "activeSubscription", "onBoardingLink", "products", "", "Lcom/talabat/feature/subscriptions/data/remote/model/SubscriptionProductResponse;", "udf", "Lcom/talabat/feature/subscriptions/data/remote/model/UdfItemResponse;", "periodPrice", "planPeriod", "billingCycle", "order", "freeTrialText", "paymentText", "cancellationType", "Lcom/talabat/feature/subscriptions/domain/model/SubscriptionCancellationType;", "bannerImage", "bannerHeader", "bannerDescription", "benefitsHeader", "renewType", "Lcom/talabat/feature/subscriptions/domain/model/SubscriptionRenewType;", "endDate", "Lorg/threeten/bp/LocalDateTime;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Lcom/talabat/feature/subscriptions/domain/model/SubscriptionCancellationType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/talabat/feature/subscriptions/domain/model/SubscriptionRenewType;Lorg/threeten/bp/LocalDateTime;)V", "getActiveSubscription", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getAmount", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getBannerDescription", "()Ljava/lang/String;", "getBannerHeader", "getBannerImage", "getBenefitsHeader", "getBillingCycle", "getCancellationType", "()Lcom/talabat/feature/subscriptions/domain/model/SubscriptionCancellationType;", "getCategory", "getCountry", "getCurrency", "getDescription", "getDurationDays", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getEndDate", "()Lorg/threeten/bp/LocalDateTime;", "getFreeTrialDays", "getFreeTrialEligible", "getFreeTrialText", "getFreeTrialTitle", "getId", "getImageUrl", "getOnBoardingLink", "getOrder", "getPaymentText", "getPeriodPrice", "getPlanPeriod", "getProducts", "()Ljava/util/List;", "getRenewType", "()Lcom/talabat/feature/subscriptions/domain/model/SubscriptionRenewType;", "getTermsUrl", "getTitle", "getUdf", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Lcom/talabat/feature/subscriptions/domain/model/SubscriptionCancellationType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/talabat/feature/subscriptions/domain/model/SubscriptionRenewType;Lorg/threeten/bp/LocalDateTime;)Lcom/talabat/feature/subscriptions/data/remote/model/SubscriptionPlanResponseModel;", "equals", "other", "hashCode", "toString", "com_talabat_feature_subscriptions_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SubscriptionPlanResponseModel {
    @Nullable
    private final Boolean activeSubscription;
    @Nullable
    private final Float amount;
    @Nullable
    private final String bannerDescription;
    @Nullable
    private final String bannerHeader;
    @Nullable
    private final String bannerImage;
    @Nullable
    private final String benefitsHeader;
    @Nullable
    private final String billingCycle;
    @NotNull
    private final SubscriptionCancellationType cancellationType;
    @Nullable
    private final String category;
    @Nullable
    private final String country;
    @Nullable
    private final String currency;
    @Nullable
    private final String description;
    @Nullable
    private final Integer durationDays;
    @Nullable
    private final LocalDateTime endDate;
    @Nullable
    private final Integer freeTrialDays;
    @Nullable
    private final Boolean freeTrialEligible;
    @Nullable
    private final String freeTrialText;
    @Nullable
    private final String freeTrialTitle;
    @Nullable

    /* renamed from: id  reason: collision with root package name */
    private final String f58953id;
    @Nullable
    private final String imageUrl;
    @Nullable
    private final String onBoardingLink;
    @Nullable
    private final Integer order;
    @Nullable
    private final String paymentText;
    @Nullable
    private final String periodPrice;
    @Nullable
    private final String planPeriod;
    @Nullable
    private final List<SubscriptionProductResponse> products;
    @NotNull
    private final SubscriptionRenewType renewType;
    @Nullable
    private final String termsUrl;
    @Nullable
    private final String title;
    @Nullable
    private final List<UdfItemResponse> udf;

    public SubscriptionPlanResponseModel() {
        this((String) null, (String) null, (String) null, (Float) null, (String) null, (String) null, (Integer) null, (Integer) null, (String) null, (String) null, (String) null, (String) null, (Boolean) null, (Boolean) null, (String) null, (List) null, (List) null, (String) null, (String) null, (String) null, (Integer) null, (String) null, (String) null, (SubscriptionCancellationType) null, (String) null, (String) null, (String) null, (String) null, (SubscriptionRenewType) null, (LocalDateTime) null, 1073741823, (DefaultConstructorMarker) null);
    }

    public SubscriptionPlanResponseModel(@Nullable @Json(name = "id") String str, @Nullable @Json(name = "title") String str2, @Nullable @Json(name = "description") String str3, @Nullable @Json(name = "amount") Float f11, @Nullable @Json(name = "currency") String str4, @Nullable @Json(name = "country") String str5, @Nullable @Json(name = "durationDays") Integer num, @Nullable @Json(name = "freeTrialDays") Integer num2, @Nullable @Json(name = "freeTrialTitle") String str6, @Nullable @Json(name = "category") String str7, @Nullable @Json(name = "imageUrl") String str8, @Nullable @Json(name = "termsUrl") String str9, @Nullable @Json(name = "freeTrialEligible") Boolean bool, @Nullable @Json(name = "activeSubscription") Boolean bool2, @Nullable @Json(name = "onboardingLink") String str10, @Nullable @Json(name = "products") List<SubscriptionProductResponse> list, @Nullable @Json(name = "udf") List<UdfItemResponse> list2, @Nullable @Json(name = "periodPrice") String str11, @Nullable @Json(name = "planPeriod") String str12, @Nullable @Json(name = "billingCycle") String str13, @Nullable @Json(name = "order") Integer num3, @Nullable @Json(name = "freeTrialText") String str14, @Nullable @Json(name = "paymentText") String str15, @NotNull @Json(name = "cancellationType") SubscriptionCancellationType subscriptionCancellationType, @Nullable @Json(name = "bannerImage") String str16, @Nullable @Json(name = "bannerHeader") String str17, @Nullable @Json(name = "bannerDescription") String str18, @Nullable @Json(name = "benefitsHeader") String str19, @NotNull @Json(name = "renewType") SubscriptionRenewType subscriptionRenewType, @Nullable @Json(name = "endDate") LocalDateTime localDateTime) {
        SubscriptionCancellationType subscriptionCancellationType2 = subscriptionCancellationType;
        SubscriptionRenewType subscriptionRenewType2 = subscriptionRenewType;
        Intrinsics.checkNotNullParameter(subscriptionCancellationType2, "cancellationType");
        Intrinsics.checkNotNullParameter(subscriptionRenewType2, "renewType");
        this.f58953id = str;
        this.title = str2;
        this.description = str3;
        this.amount = f11;
        this.currency = str4;
        this.country = str5;
        this.durationDays = num;
        this.freeTrialDays = num2;
        this.freeTrialTitle = str6;
        this.category = str7;
        this.imageUrl = str8;
        this.termsUrl = str9;
        this.freeTrialEligible = bool;
        this.activeSubscription = bool2;
        this.onBoardingLink = str10;
        this.products = list;
        this.udf = list2;
        this.periodPrice = str11;
        this.planPeriod = str12;
        this.billingCycle = str13;
        this.order = num3;
        this.freeTrialText = str14;
        this.paymentText = str15;
        this.cancellationType = subscriptionCancellationType2;
        this.bannerImage = str16;
        this.bannerHeader = str17;
        this.bannerDescription = str18;
        this.benefitsHeader = str19;
        this.renewType = subscriptionRenewType2;
        this.endDate = localDateTime;
    }

    public static /* synthetic */ SubscriptionPlanResponseModel copy$default(SubscriptionPlanResponseModel subscriptionPlanResponseModel, String str, String str2, String str3, Float f11, String str4, String str5, Integer num, Integer num2, String str6, String str7, String str8, String str9, Boolean bool, Boolean bool2, String str10, List list, List list2, String str11, String str12, String str13, Integer num3, String str14, String str15, SubscriptionCancellationType subscriptionCancellationType, String str16, String str17, String str18, String str19, SubscriptionRenewType subscriptionRenewType, LocalDateTime localDateTime, int i11, Object obj) {
        SubscriptionPlanResponseModel subscriptionPlanResponseModel2 = subscriptionPlanResponseModel;
        int i12 = i11;
        return subscriptionPlanResponseModel.copy((i12 & 1) != 0 ? subscriptionPlanResponseModel2.f58953id : str, (i12 & 2) != 0 ? subscriptionPlanResponseModel2.title : str2, (i12 & 4) != 0 ? subscriptionPlanResponseModel2.description : str3, (i12 & 8) != 0 ? subscriptionPlanResponseModel2.amount : f11, (i12 & 16) != 0 ? subscriptionPlanResponseModel2.currency : str4, (i12 & 32) != 0 ? subscriptionPlanResponseModel2.country : str5, (i12 & 64) != 0 ? subscriptionPlanResponseModel2.durationDays : num, (i12 & 128) != 0 ? subscriptionPlanResponseModel2.freeTrialDays : num2, (i12 & 256) != 0 ? subscriptionPlanResponseModel2.freeTrialTitle : str6, (i12 & 512) != 0 ? subscriptionPlanResponseModel2.category : str7, (i12 & 1024) != 0 ? subscriptionPlanResponseModel2.imageUrl : str8, (i12 & 2048) != 0 ? subscriptionPlanResponseModel2.termsUrl : str9, (i12 & 4096) != 0 ? subscriptionPlanResponseModel2.freeTrialEligible : bool, (i12 & 8192) != 0 ? subscriptionPlanResponseModel2.activeSubscription : bool2, (i12 & 16384) != 0 ? subscriptionPlanResponseModel2.onBoardingLink : str10, (i12 & 32768) != 0 ? subscriptionPlanResponseModel2.products : list, (i12 & 65536) != 0 ? subscriptionPlanResponseModel2.udf : list2, (i12 & 131072) != 0 ? subscriptionPlanResponseModel2.periodPrice : str11, (i12 & 262144) != 0 ? subscriptionPlanResponseModel2.planPeriod : str12, (i12 & 524288) != 0 ? subscriptionPlanResponseModel2.billingCycle : str13, (i12 & 1048576) != 0 ? subscriptionPlanResponseModel2.order : num3, (i12 & 2097152) != 0 ? subscriptionPlanResponseModel2.freeTrialText : str14, (i12 & 4194304) != 0 ? subscriptionPlanResponseModel2.paymentText : str15, (i12 & 8388608) != 0 ? subscriptionPlanResponseModel2.cancellationType : subscriptionCancellationType, (i12 & 16777216) != 0 ? subscriptionPlanResponseModel2.bannerImage : str16, (i12 & 33554432) != 0 ? subscriptionPlanResponseModel2.bannerHeader : str17, (i12 & 67108864) != 0 ? subscriptionPlanResponseModel2.bannerDescription : str18, (i12 & C.BUFFER_FLAG_FIRST_SAMPLE) != 0 ? subscriptionPlanResponseModel2.benefitsHeader : str19, (i12 & 268435456) != 0 ? subscriptionPlanResponseModel2.renewType : subscriptionRenewType, (i12 & 536870912) != 0 ? subscriptionPlanResponseModel2.endDate : localDateTime);
    }

    @Nullable
    public final String component1() {
        return this.f58953id;
    }

    @Nullable
    public final String component10() {
        return this.category;
    }

    @Nullable
    public final String component11() {
        return this.imageUrl;
    }

    @Nullable
    public final String component12() {
        return this.termsUrl;
    }

    @Nullable
    public final Boolean component13() {
        return this.freeTrialEligible;
    }

    @Nullable
    public final Boolean component14() {
        return this.activeSubscription;
    }

    @Nullable
    public final String component15() {
        return this.onBoardingLink;
    }

    @Nullable
    public final List<SubscriptionProductResponse> component16() {
        return this.products;
    }

    @Nullable
    public final List<UdfItemResponse> component17() {
        return this.udf;
    }

    @Nullable
    public final String component18() {
        return this.periodPrice;
    }

    @Nullable
    public final String component19() {
        return this.planPeriod;
    }

    @Nullable
    public final String component2() {
        return this.title;
    }

    @Nullable
    public final String component20() {
        return this.billingCycle;
    }

    @Nullable
    public final Integer component21() {
        return this.order;
    }

    @Nullable
    public final String component22() {
        return this.freeTrialText;
    }

    @Nullable
    public final String component23() {
        return this.paymentText;
    }

    @NotNull
    public final SubscriptionCancellationType component24() {
        return this.cancellationType;
    }

    @Nullable
    public final String component25() {
        return this.bannerImage;
    }

    @Nullable
    public final String component26() {
        return this.bannerHeader;
    }

    @Nullable
    public final String component27() {
        return this.bannerDescription;
    }

    @Nullable
    public final String component28() {
        return this.benefitsHeader;
    }

    @NotNull
    public final SubscriptionRenewType component29() {
        return this.renewType;
    }

    @Nullable
    public final String component3() {
        return this.description;
    }

    @Nullable
    public final LocalDateTime component30() {
        return this.endDate;
    }

    @Nullable
    public final Float component4() {
        return this.amount;
    }

    @Nullable
    public final String component5() {
        return this.currency;
    }

    @Nullable
    public final String component6() {
        return this.country;
    }

    @Nullable
    public final Integer component7() {
        return this.durationDays;
    }

    @Nullable
    public final Integer component8() {
        return this.freeTrialDays;
    }

    @Nullable
    public final String component9() {
        return this.freeTrialTitle;
    }

    @NotNull
    public final SubscriptionPlanResponseModel copy(@Nullable @Json(name = "id") String str, @Nullable @Json(name = "title") String str2, @Nullable @Json(name = "description") String str3, @Nullable @Json(name = "amount") Float f11, @Nullable @Json(name = "currency") String str4, @Nullable @Json(name = "country") String str5, @Nullable @Json(name = "durationDays") Integer num, @Nullable @Json(name = "freeTrialDays") Integer num2, @Nullable @Json(name = "freeTrialTitle") String str6, @Nullable @Json(name = "category") String str7, @Nullable @Json(name = "imageUrl") String str8, @Nullable @Json(name = "termsUrl") String str9, @Nullable @Json(name = "freeTrialEligible") Boolean bool, @Nullable @Json(name = "activeSubscription") Boolean bool2, @Nullable @Json(name = "onboardingLink") String str10, @Nullable @Json(name = "products") List<SubscriptionProductResponse> list, @Nullable @Json(name = "udf") List<UdfItemResponse> list2, @Nullable @Json(name = "periodPrice") String str11, @Nullable @Json(name = "planPeriod") String str12, @Nullable @Json(name = "billingCycle") String str13, @Nullable @Json(name = "order") Integer num3, @Nullable @Json(name = "freeTrialText") String str14, @Nullable @Json(name = "paymentText") String str15, @NotNull @Json(name = "cancellationType") SubscriptionCancellationType subscriptionCancellationType, @Nullable @Json(name = "bannerImage") String str16, @Nullable @Json(name = "bannerHeader") String str17, @Nullable @Json(name = "bannerDescription") String str18, @Nullable @Json(name = "benefitsHeader") String str19, @NotNull @Json(name = "renewType") SubscriptionRenewType subscriptionRenewType, @Nullable @Json(name = "endDate") LocalDateTime localDateTime) {
        String str20 = str;
        Intrinsics.checkNotNullParameter(subscriptionCancellationType, "cancellationType");
        Intrinsics.checkNotNullParameter(subscriptionRenewType, "renewType");
        return new SubscriptionPlanResponseModel(str, str2, str3, f11, str4, str5, num, num2, str6, str7, str8, str9, bool, bool2, str10, list, list2, str11, str12, str13, num3, str14, str15, subscriptionCancellationType, str16, str17, str18, str19, subscriptionRenewType, localDateTime);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SubscriptionPlanResponseModel)) {
            return false;
        }
        SubscriptionPlanResponseModel subscriptionPlanResponseModel = (SubscriptionPlanResponseModel) obj;
        return Intrinsics.areEqual((Object) this.f58953id, (Object) subscriptionPlanResponseModel.f58953id) && Intrinsics.areEqual((Object) this.title, (Object) subscriptionPlanResponseModel.title) && Intrinsics.areEqual((Object) this.description, (Object) subscriptionPlanResponseModel.description) && Intrinsics.areEqual((Object) this.amount, (Object) subscriptionPlanResponseModel.amount) && Intrinsics.areEqual((Object) this.currency, (Object) subscriptionPlanResponseModel.currency) && Intrinsics.areEqual((Object) this.country, (Object) subscriptionPlanResponseModel.country) && Intrinsics.areEqual((Object) this.durationDays, (Object) subscriptionPlanResponseModel.durationDays) && Intrinsics.areEqual((Object) this.freeTrialDays, (Object) subscriptionPlanResponseModel.freeTrialDays) && Intrinsics.areEqual((Object) this.freeTrialTitle, (Object) subscriptionPlanResponseModel.freeTrialTitle) && Intrinsics.areEqual((Object) this.category, (Object) subscriptionPlanResponseModel.category) && Intrinsics.areEqual((Object) this.imageUrl, (Object) subscriptionPlanResponseModel.imageUrl) && Intrinsics.areEqual((Object) this.termsUrl, (Object) subscriptionPlanResponseModel.termsUrl) && Intrinsics.areEqual((Object) this.freeTrialEligible, (Object) subscriptionPlanResponseModel.freeTrialEligible) && Intrinsics.areEqual((Object) this.activeSubscription, (Object) subscriptionPlanResponseModel.activeSubscription) && Intrinsics.areEqual((Object) this.onBoardingLink, (Object) subscriptionPlanResponseModel.onBoardingLink) && Intrinsics.areEqual((Object) this.products, (Object) subscriptionPlanResponseModel.products) && Intrinsics.areEqual((Object) this.udf, (Object) subscriptionPlanResponseModel.udf) && Intrinsics.areEqual((Object) this.periodPrice, (Object) subscriptionPlanResponseModel.periodPrice) && Intrinsics.areEqual((Object) this.planPeriod, (Object) subscriptionPlanResponseModel.planPeriod) && Intrinsics.areEqual((Object) this.billingCycle, (Object) subscriptionPlanResponseModel.billingCycle) && Intrinsics.areEqual((Object) this.order, (Object) subscriptionPlanResponseModel.order) && Intrinsics.areEqual((Object) this.freeTrialText, (Object) subscriptionPlanResponseModel.freeTrialText) && Intrinsics.areEqual((Object) this.paymentText, (Object) subscriptionPlanResponseModel.paymentText) && this.cancellationType == subscriptionPlanResponseModel.cancellationType && Intrinsics.areEqual((Object) this.bannerImage, (Object) subscriptionPlanResponseModel.bannerImage) && Intrinsics.areEqual((Object) this.bannerHeader, (Object) subscriptionPlanResponseModel.bannerHeader) && Intrinsics.areEqual((Object) this.bannerDescription, (Object) subscriptionPlanResponseModel.bannerDescription) && Intrinsics.areEqual((Object) this.benefitsHeader, (Object) subscriptionPlanResponseModel.benefitsHeader) && this.renewType == subscriptionPlanResponseModel.renewType && Intrinsics.areEqual((Object) this.endDate, (Object) subscriptionPlanResponseModel.endDate);
    }

    @Nullable
    public final Boolean getActiveSubscription() {
        return this.activeSubscription;
    }

    @Nullable
    public final Float getAmount() {
        return this.amount;
    }

    @Nullable
    public final String getBannerDescription() {
        return this.bannerDescription;
    }

    @Nullable
    public final String getBannerHeader() {
        return this.bannerHeader;
    }

    @Nullable
    public final String getBannerImage() {
        return this.bannerImage;
    }

    @Nullable
    public final String getBenefitsHeader() {
        return this.benefitsHeader;
    }

    @Nullable
    public final String getBillingCycle() {
        return this.billingCycle;
    }

    @NotNull
    public final SubscriptionCancellationType getCancellationType() {
        return this.cancellationType;
    }

    @Nullable
    public final String getCategory() {
        return this.category;
    }

    @Nullable
    public final String getCountry() {
        return this.country;
    }

    @Nullable
    public final String getCurrency() {
        return this.currency;
    }

    @Nullable
    public final String getDescription() {
        return this.description;
    }

    @Nullable
    public final Integer getDurationDays() {
        return this.durationDays;
    }

    @Nullable
    public final LocalDateTime getEndDate() {
        return this.endDate;
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
    public final String getFreeTrialText() {
        return this.freeTrialText;
    }

    @Nullable
    public final String getFreeTrialTitle() {
        return this.freeTrialTitle;
    }

    @Nullable
    public final String getId() {
        return this.f58953id;
    }

    @Nullable
    public final String getImageUrl() {
        return this.imageUrl;
    }

    @Nullable
    public final String getOnBoardingLink() {
        return this.onBoardingLink;
    }

    @Nullable
    public final Integer getOrder() {
        return this.order;
    }

    @Nullable
    public final String getPaymentText() {
        return this.paymentText;
    }

    @Nullable
    public final String getPeriodPrice() {
        return this.periodPrice;
    }

    @Nullable
    public final String getPlanPeriod() {
        return this.planPeriod;
    }

    @Nullable
    public final List<SubscriptionProductResponse> getProducts() {
        return this.products;
    }

    @NotNull
    public final SubscriptionRenewType getRenewType() {
        return this.renewType;
    }

    @Nullable
    public final String getTermsUrl() {
        return this.termsUrl;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    public final List<UdfItemResponse> getUdf() {
        return this.udf;
    }

    public int hashCode() {
        String str = this.f58953id;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.title;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.description;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Float f11 = this.amount;
        int hashCode4 = (hashCode3 + (f11 == null ? 0 : f11.hashCode())) * 31;
        String str4 = this.currency;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.country;
        int hashCode6 = (hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        Integer num = this.durationDays;
        int hashCode7 = (hashCode6 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.freeTrialDays;
        int hashCode8 = (hashCode7 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str6 = this.freeTrialTitle;
        int hashCode9 = (hashCode8 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.category;
        int hashCode10 = (hashCode9 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.imageUrl;
        int hashCode11 = (hashCode10 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.termsUrl;
        int hashCode12 = (hashCode11 + (str9 == null ? 0 : str9.hashCode())) * 31;
        Boolean bool = this.freeTrialEligible;
        int hashCode13 = (hashCode12 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.activeSubscription;
        int hashCode14 = (hashCode13 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        String str10 = this.onBoardingLink;
        int hashCode15 = (hashCode14 + (str10 == null ? 0 : str10.hashCode())) * 31;
        List<SubscriptionProductResponse> list = this.products;
        int hashCode16 = (hashCode15 + (list == null ? 0 : list.hashCode())) * 31;
        List<UdfItemResponse> list2 = this.udf;
        int hashCode17 = (hashCode16 + (list2 == null ? 0 : list2.hashCode())) * 31;
        String str11 = this.periodPrice;
        int hashCode18 = (hashCode17 + (str11 == null ? 0 : str11.hashCode())) * 31;
        String str12 = this.planPeriod;
        int hashCode19 = (hashCode18 + (str12 == null ? 0 : str12.hashCode())) * 31;
        String str13 = this.billingCycle;
        int hashCode20 = (hashCode19 + (str13 == null ? 0 : str13.hashCode())) * 31;
        Integer num3 = this.order;
        int hashCode21 = (hashCode20 + (num3 == null ? 0 : num3.hashCode())) * 31;
        String str14 = this.freeTrialText;
        int hashCode22 = (hashCode21 + (str14 == null ? 0 : str14.hashCode())) * 31;
        String str15 = this.paymentText;
        int hashCode23 = (((hashCode22 + (str15 == null ? 0 : str15.hashCode())) * 31) + this.cancellationType.hashCode()) * 31;
        String str16 = this.bannerImage;
        int hashCode24 = (hashCode23 + (str16 == null ? 0 : str16.hashCode())) * 31;
        String str17 = this.bannerHeader;
        int hashCode25 = (hashCode24 + (str17 == null ? 0 : str17.hashCode())) * 31;
        String str18 = this.bannerDescription;
        int hashCode26 = (hashCode25 + (str18 == null ? 0 : str18.hashCode())) * 31;
        String str19 = this.benefitsHeader;
        int hashCode27 = (((hashCode26 + (str19 == null ? 0 : str19.hashCode())) * 31) + this.renewType.hashCode()) * 31;
        LocalDateTime localDateTime = this.endDate;
        if (localDateTime != null) {
            i11 = localDateTime.hashCode();
        }
        return hashCode27 + i11;
    }

    @NotNull
    public String toString() {
        String str = this.f58953id;
        String str2 = this.title;
        String str3 = this.description;
        Float f11 = this.amount;
        String str4 = this.currency;
        String str5 = this.country;
        Integer num = this.durationDays;
        Integer num2 = this.freeTrialDays;
        String str6 = this.freeTrialTitle;
        String str7 = this.category;
        String str8 = this.imageUrl;
        String str9 = this.termsUrl;
        Boolean bool = this.freeTrialEligible;
        Boolean bool2 = this.activeSubscription;
        String str10 = this.onBoardingLink;
        List<SubscriptionProductResponse> list = this.products;
        List<UdfItemResponse> list2 = this.udf;
        String str11 = this.periodPrice;
        String str12 = this.planPeriod;
        String str13 = this.billingCycle;
        Integer num3 = this.order;
        String str14 = this.freeTrialText;
        String str15 = this.paymentText;
        SubscriptionCancellationType subscriptionCancellationType = this.cancellationType;
        String str16 = this.bannerImage;
        String str17 = this.bannerHeader;
        String str18 = this.bannerDescription;
        String str19 = this.benefitsHeader;
        SubscriptionRenewType subscriptionRenewType = this.renewType;
        LocalDateTime localDateTime = this.endDate;
        return "SubscriptionPlanResponseModel(id=" + str + ", title=" + str2 + ", description=" + str3 + ", amount=" + f11 + ", currency=" + str4 + ", country=" + str5 + ", durationDays=" + num + ", freeTrialDays=" + num2 + ", freeTrialTitle=" + str6 + ", category=" + str7 + ", imageUrl=" + str8 + ", termsUrl=" + str9 + ", freeTrialEligible=" + bool + ", activeSubscription=" + bool2 + ", onBoardingLink=" + str10 + ", products=" + list + ", udf=" + list2 + ", periodPrice=" + str11 + ", planPeriod=" + str12 + ", billingCycle=" + str13 + ", order=" + num3 + ", freeTrialText=" + str14 + ", paymentText=" + str15 + ", cancellationType=" + subscriptionCancellationType + ", bannerImage=" + str16 + ", bannerHeader=" + str17 + ", bannerDescription=" + str18 + ", benefitsHeader=" + str19 + ", renewType=" + subscriptionRenewType + ", endDate=" + localDateTime + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ SubscriptionPlanResponseModel(java.lang.String r32, java.lang.String r33, java.lang.String r34, java.lang.Float r35, java.lang.String r36, java.lang.String r37, java.lang.Integer r38, java.lang.Integer r39, java.lang.String r40, java.lang.String r41, java.lang.String r42, java.lang.String r43, java.lang.Boolean r44, java.lang.Boolean r45, java.lang.String r46, java.util.List r47, java.util.List r48, java.lang.String r49, java.lang.String r50, java.lang.String r51, java.lang.Integer r52, java.lang.String r53, java.lang.String r54, com.talabat.feature.subscriptions.domain.model.SubscriptionCancellationType r55, java.lang.String r56, java.lang.String r57, java.lang.String r58, java.lang.String r59, com.talabat.feature.subscriptions.domain.model.SubscriptionRenewType r60, org.threeten.bp.LocalDateTime r61, int r62, kotlin.jvm.internal.DefaultConstructorMarker r63) {
        /*
            r31 = this;
            r0 = r62
            r1 = r0 & 1
            if (r1 == 0) goto L_0x0008
            r1 = 0
            goto L_0x000a
        L_0x0008:
            r1 = r32
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            r3 = 0
            goto L_0x0012
        L_0x0010:
            r3 = r33
        L_0x0012:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0018
            r4 = 0
            goto L_0x001a
        L_0x0018:
            r4 = r34
        L_0x001a:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x0020
            r5 = 0
            goto L_0x0022
        L_0x0020:
            r5 = r35
        L_0x0022:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0028
            r6 = 0
            goto L_0x002a
        L_0x0028:
            r6 = r36
        L_0x002a:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x0030
            r7 = 0
            goto L_0x0032
        L_0x0030:
            r7 = r37
        L_0x0032:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0038
            r8 = 0
            goto L_0x003a
        L_0x0038:
            r8 = r38
        L_0x003a:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x0040
            r9 = 0
            goto L_0x0042
        L_0x0040:
            r9 = r39
        L_0x0042:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x0048
            r10 = 0
            goto L_0x004a
        L_0x0048:
            r10 = r40
        L_0x004a:
            r11 = r0 & 512(0x200, float:7.175E-43)
            if (r11 == 0) goto L_0x0050
            r11 = 0
            goto L_0x0052
        L_0x0050:
            r11 = r41
        L_0x0052:
            r12 = r0 & 1024(0x400, float:1.435E-42)
            if (r12 == 0) goto L_0x0058
            r12 = 0
            goto L_0x005a
        L_0x0058:
            r12 = r42
        L_0x005a:
            r13 = r0 & 2048(0x800, float:2.87E-42)
            if (r13 == 0) goto L_0x0060
            r13 = 0
            goto L_0x0062
        L_0x0060:
            r13 = r43
        L_0x0062:
            r14 = r0 & 4096(0x1000, float:5.74E-42)
            if (r14 == 0) goto L_0x0068
            r14 = 0
            goto L_0x006a
        L_0x0068:
            r14 = r44
        L_0x006a:
            r15 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r15 == 0) goto L_0x0070
            r15 = 0
            goto L_0x0072
        L_0x0070:
            r15 = r45
        L_0x0072:
            r2 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r2 == 0) goto L_0x0078
            r2 = 0
            goto L_0x007a
        L_0x0078:
            r2 = r46
        L_0x007a:
            r16 = 32768(0x8000, float:4.5918E-41)
            r16 = r0 & r16
            if (r16 == 0) goto L_0x0084
            r16 = 0
            goto L_0x0086
        L_0x0084:
            r16 = r47
        L_0x0086:
            r17 = 65536(0x10000, float:9.18355E-41)
            r17 = r0 & r17
            if (r17 == 0) goto L_0x008f
            r17 = 0
            goto L_0x0091
        L_0x008f:
            r17 = r48
        L_0x0091:
            r18 = 131072(0x20000, float:1.83671E-40)
            r18 = r0 & r18
            if (r18 == 0) goto L_0x009a
            r18 = 0
            goto L_0x009c
        L_0x009a:
            r18 = r49
        L_0x009c:
            r19 = 262144(0x40000, float:3.67342E-40)
            r19 = r0 & r19
            if (r19 == 0) goto L_0x00a5
            r19 = 0
            goto L_0x00a7
        L_0x00a5:
            r19 = r50
        L_0x00a7:
            r20 = 524288(0x80000, float:7.34684E-40)
            r20 = r0 & r20
            if (r20 == 0) goto L_0x00b0
            r20 = 0
            goto L_0x00b2
        L_0x00b0:
            r20 = r51
        L_0x00b2:
            r21 = 1048576(0x100000, float:1.469368E-39)
            r21 = r0 & r21
            if (r21 == 0) goto L_0x00bb
            r21 = 0
            goto L_0x00bd
        L_0x00bb:
            r21 = r52
        L_0x00bd:
            r22 = 2097152(0x200000, float:2.938736E-39)
            r22 = r0 & r22
            if (r22 == 0) goto L_0x00c6
            r22 = 0
            goto L_0x00c8
        L_0x00c6:
            r22 = r53
        L_0x00c8:
            r23 = 4194304(0x400000, float:5.877472E-39)
            r23 = r0 & r23
            if (r23 == 0) goto L_0x00d1
            r23 = 0
            goto L_0x00d3
        L_0x00d1:
            r23 = r54
        L_0x00d3:
            r24 = 8388608(0x800000, float:1.17549435E-38)
            r24 = r0 & r24
            if (r24 == 0) goto L_0x00dc
            com.talabat.feature.subscriptions.domain.model.SubscriptionCancellationType r24 = com.talabat.feature.subscriptions.domain.model.SubscriptionCancellationType.None
            goto L_0x00de
        L_0x00dc:
            r24 = r55
        L_0x00de:
            r25 = 16777216(0x1000000, float:2.3509887E-38)
            r25 = r0 & r25
            if (r25 == 0) goto L_0x00e7
            r25 = 0
            goto L_0x00e9
        L_0x00e7:
            r25 = r56
        L_0x00e9:
            r26 = 33554432(0x2000000, float:9.403955E-38)
            r26 = r0 & r26
            if (r26 == 0) goto L_0x00f2
            r26 = 0
            goto L_0x00f4
        L_0x00f2:
            r26 = r57
        L_0x00f4:
            r27 = 67108864(0x4000000, float:1.5046328E-36)
            r27 = r0 & r27
            if (r27 == 0) goto L_0x00fd
            r27 = 0
            goto L_0x00ff
        L_0x00fd:
            r27 = r58
        L_0x00ff:
            r28 = 134217728(0x8000000, float:3.85186E-34)
            r28 = r0 & r28
            if (r28 == 0) goto L_0x0108
            r28 = 0
            goto L_0x010a
        L_0x0108:
            r28 = r59
        L_0x010a:
            r29 = 268435456(0x10000000, float:2.5243549E-29)
            r29 = r0 & r29
            if (r29 == 0) goto L_0x0113
            com.talabat.feature.subscriptions.domain.model.SubscriptionRenewType r29 = com.talabat.feature.subscriptions.domain.model.SubscriptionRenewType.NoRenewal
            goto L_0x0115
        L_0x0113:
            r29 = r60
        L_0x0115:
            r30 = 536870912(0x20000000, float:1.0842022E-19)
            r0 = r0 & r30
            if (r0 == 0) goto L_0x011d
            r0 = 0
            goto L_0x011f
        L_0x011d:
            r0 = r61
        L_0x011f:
            r32 = r31
            r33 = r1
            r34 = r3
            r35 = r4
            r36 = r5
            r37 = r6
            r38 = r7
            r39 = r8
            r40 = r9
            r41 = r10
            r42 = r11
            r43 = r12
            r44 = r13
            r45 = r14
            r46 = r15
            r47 = r2
            r48 = r16
            r49 = r17
            r50 = r18
            r51 = r19
            r52 = r20
            r53 = r21
            r54 = r22
            r55 = r23
            r56 = r24
            r57 = r25
            r58 = r26
            r59 = r27
            r60 = r28
            r61 = r29
            r62 = r0
            r32.<init>(r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55, r56, r57, r58, r59, r60, r61, r62)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.subscriptions.data.remote.model.SubscriptionPlanResponseModel.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.Float, java.lang.String, java.lang.String, java.lang.Integer, java.lang.Integer, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Boolean, java.lang.Boolean, java.lang.String, java.util.List, java.util.List, java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, java.lang.String, java.lang.String, com.talabat.feature.subscriptions.domain.model.SubscriptionCancellationType, java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.talabat.feature.subscriptions.domain.model.SubscriptionRenewType, org.threeten.bp.LocalDateTime, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
