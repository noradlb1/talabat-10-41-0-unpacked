package com.talabat.talabatcommon.feature.subscriptionManagement.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\bD\b\b\u0018\u00002\u00020\u0001BÝ\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016\u0012\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0016¢\u0006\u0002\u0010\u001aJ\u000b\u0010F\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010J\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u0010K\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u000b\u0010L\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010M\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016HÆ\u0003J\u0011\u0010N\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0016HÆ\u0003J\u000b\u0010O\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010P\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010Q\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010!J\u000b\u0010R\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010S\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010T\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010.J\u0010\u0010U\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010.J\u000b\u0010V\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jæ\u0001\u0010W\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00162\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0016HÆ\u0001¢\u0006\u0002\u0010XJ\u0013\u0010Y\u001a\u00020\u00122\b\u0010Z\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010[\u001a\u00020\u000bHÖ\u0001J\t\u0010\\\u001a\u00020\u0003HÖ\u0001R\"\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0004¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b \u0010!R \u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R \u0010\t\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010$\"\u0004\b(\u0010&R \u0010\b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010$\"\u0004\b*\u0010&R \u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010$\"\u0004\b,\u0010&R\"\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u00101\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\"\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u00101\u001a\u0004\b2\u0010.\"\u0004\b3\u00100R\"\u0010\u0011\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b4\u0010\u001c\"\u0004\b5\u0010\u001eR \u0010\r\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010$\"\u0004\b7\u0010&R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u0010$R \u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010$\"\u0004\b:\u0010&R\u001e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00168\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b;\u0010<R \u0010\u0014\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010$\"\u0004\b>\u0010&R&\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00168\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010<\"\u0004\b@\u0010AR \u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010$\"\u0004\bC\u0010&R \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010$\"\u0004\bE\u0010&¨\u0006]"}, d2 = {"Lcom/talabat/talabatcommon/feature/subscriptionManagement/model/SubscriptionPlanResponseModel;", "", "id", "", "title", "description", "amount", "", "currency", "country", "durationDays", "", "freeTrialDays", "freeTrialTitle", "category", "imageUrl", "termsUrl", "freeTrialEligible", "", "activeSubscription", "onBoardingLink", "products", "", "Lcom/talabat/talabatcommon/feature/subscriptionManagement/model/SubscriptionProduct;", "minimumOrderValue", "Lcom/talabat/talabatcommon/feature/subscriptionManagement/model/SubscriptionPlanUdfEntityModel;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "getActiveSubscription", "()Ljava/lang/Boolean;", "setActiveSubscription", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getAmount", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getCategory", "()Ljava/lang/String;", "setCategory", "(Ljava/lang/String;)V", "getCountry", "setCountry", "getCurrency", "setCurrency", "getDescription", "setDescription", "getDurationDays", "()Ljava/lang/Integer;", "setDurationDays", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getFreeTrialDays", "setFreeTrialDays", "getFreeTrialEligible", "setFreeTrialEligible", "getFreeTrialTitle", "setFreeTrialTitle", "getId", "getImageUrl", "setImageUrl", "getMinimumOrderValue", "()Ljava/util/List;", "getOnBoardingLink", "setOnBoardingLink", "getProducts", "setProducts", "(Ljava/util/List;)V", "getTermsUrl", "setTermsUrl", "getTitle", "setTitle", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/util/List;Ljava/util/List;)Lcom/talabat/talabatcommon/feature/subscriptionManagement/model/SubscriptionPlanResponseModel;", "equals", "other", "hashCode", "toString", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SubscriptionPlanResponseModel {
    @SerializedName("activeSubscription")
    @Nullable
    private Boolean activeSubscription;
    @SerializedName("amount")
    @Nullable
    private final Float amount;
    @SerializedName("category")
    @Nullable
    private String category;
    @SerializedName("country")
    @Nullable
    private String country;
    @SerializedName("currency")
    @Nullable
    private String currency;
    @SerializedName("description")
    @Nullable
    private String description;
    @SerializedName("durationDays")
    @Nullable
    private Integer durationDays;
    @SerializedName("freeTrialDays")
    @Nullable
    private Integer freeTrialDays;
    @SerializedName("freeTrialEligible")
    @Nullable
    private Boolean freeTrialEligible;
    @SerializedName("freeTrialTitle")
    @Nullable
    private String freeTrialTitle;
    @SerializedName("id")
    @Nullable

    /* renamed from: id  reason: collision with root package name */
    private final String f61580id;
    @SerializedName("imageUrl")
    @Nullable
    private String imageUrl;
    @SerializedName("udf")
    @Nullable
    private final List<SubscriptionPlanUdfEntityModel> minimumOrderValue;
    @SerializedName("onboardingLink")
    @Nullable
    private String onBoardingLink;
    @SerializedName("products")
    @Nullable
    private List<SubscriptionProduct> products;
    @SerializedName("termsUrl")
    @Nullable
    private String termsUrl;
    @SerializedName("title")
    @Nullable
    private String title;

    public SubscriptionPlanResponseModel() {
        this((String) null, (String) null, (String) null, (Float) null, (String) null, (String) null, (Integer) null, (Integer) null, (String) null, (String) null, (String) null, (String) null, (Boolean) null, (Boolean) null, (String) null, (List) null, (List) null, 131071, (DefaultConstructorMarker) null);
    }

    public SubscriptionPlanResponseModel(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable Float f11, @Nullable String str4, @Nullable String str5, @Nullable Integer num, @Nullable Integer num2, @Nullable String str6, @Nullable String str7, @Nullable String str8, @Nullable String str9, @Nullable Boolean bool, @Nullable Boolean bool2, @Nullable String str10, @Nullable List<SubscriptionProduct> list, @Nullable List<SubscriptionPlanUdfEntityModel> list2) {
        this.f61580id = str;
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
        this.minimumOrderValue = list2;
    }

    public static /* synthetic */ SubscriptionPlanResponseModel copy$default(SubscriptionPlanResponseModel subscriptionPlanResponseModel, String str, String str2, String str3, Float f11, String str4, String str5, Integer num, Integer num2, String str6, String str7, String str8, String str9, Boolean bool, Boolean bool2, String str10, List list, List list2, int i11, Object obj) {
        SubscriptionPlanResponseModel subscriptionPlanResponseModel2 = subscriptionPlanResponseModel;
        int i12 = i11;
        return subscriptionPlanResponseModel.copy((i12 & 1) != 0 ? subscriptionPlanResponseModel2.f61580id : str, (i12 & 2) != 0 ? subscriptionPlanResponseModel2.title : str2, (i12 & 4) != 0 ? subscriptionPlanResponseModel2.description : str3, (i12 & 8) != 0 ? subscriptionPlanResponseModel2.amount : f11, (i12 & 16) != 0 ? subscriptionPlanResponseModel2.currency : str4, (i12 & 32) != 0 ? subscriptionPlanResponseModel2.country : str5, (i12 & 64) != 0 ? subscriptionPlanResponseModel2.durationDays : num, (i12 & 128) != 0 ? subscriptionPlanResponseModel2.freeTrialDays : num2, (i12 & 256) != 0 ? subscriptionPlanResponseModel2.freeTrialTitle : str6, (i12 & 512) != 0 ? subscriptionPlanResponseModel2.category : str7, (i12 & 1024) != 0 ? subscriptionPlanResponseModel2.imageUrl : str8, (i12 & 2048) != 0 ? subscriptionPlanResponseModel2.termsUrl : str9, (i12 & 4096) != 0 ? subscriptionPlanResponseModel2.freeTrialEligible : bool, (i12 & 8192) != 0 ? subscriptionPlanResponseModel2.activeSubscription : bool2, (i12 & 16384) != 0 ? subscriptionPlanResponseModel2.onBoardingLink : str10, (i12 & 32768) != 0 ? subscriptionPlanResponseModel2.products : list, (i12 & 65536) != 0 ? subscriptionPlanResponseModel2.minimumOrderValue : list2);
    }

    @Nullable
    public final String component1() {
        return this.f61580id;
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
    public final List<SubscriptionProduct> component16() {
        return this.products;
    }

    @Nullable
    public final List<SubscriptionPlanUdfEntityModel> component17() {
        return this.minimumOrderValue;
    }

    @Nullable
    public final String component2() {
        return this.title;
    }

    @Nullable
    public final String component3() {
        return this.description;
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
    public final SubscriptionPlanResponseModel copy(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable Float f11, @Nullable String str4, @Nullable String str5, @Nullable Integer num, @Nullable Integer num2, @Nullable String str6, @Nullable String str7, @Nullable String str8, @Nullable String str9, @Nullable Boolean bool, @Nullable Boolean bool2, @Nullable String str10, @Nullable List<SubscriptionProduct> list, @Nullable List<SubscriptionPlanUdfEntityModel> list2) {
        return new SubscriptionPlanResponseModel(str, str2, str3, f11, str4, str5, num, num2, str6, str7, str8, str9, bool, bool2, str10, list, list2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SubscriptionPlanResponseModel)) {
            return false;
        }
        SubscriptionPlanResponseModel subscriptionPlanResponseModel = (SubscriptionPlanResponseModel) obj;
        return Intrinsics.areEqual((Object) this.f61580id, (Object) subscriptionPlanResponseModel.f61580id) && Intrinsics.areEqual((Object) this.title, (Object) subscriptionPlanResponseModel.title) && Intrinsics.areEqual((Object) this.description, (Object) subscriptionPlanResponseModel.description) && Intrinsics.areEqual((Object) this.amount, (Object) subscriptionPlanResponseModel.amount) && Intrinsics.areEqual((Object) this.currency, (Object) subscriptionPlanResponseModel.currency) && Intrinsics.areEqual((Object) this.country, (Object) subscriptionPlanResponseModel.country) && Intrinsics.areEqual((Object) this.durationDays, (Object) subscriptionPlanResponseModel.durationDays) && Intrinsics.areEqual((Object) this.freeTrialDays, (Object) subscriptionPlanResponseModel.freeTrialDays) && Intrinsics.areEqual((Object) this.freeTrialTitle, (Object) subscriptionPlanResponseModel.freeTrialTitle) && Intrinsics.areEqual((Object) this.category, (Object) subscriptionPlanResponseModel.category) && Intrinsics.areEqual((Object) this.imageUrl, (Object) subscriptionPlanResponseModel.imageUrl) && Intrinsics.areEqual((Object) this.termsUrl, (Object) subscriptionPlanResponseModel.termsUrl) && Intrinsics.areEqual((Object) this.freeTrialEligible, (Object) subscriptionPlanResponseModel.freeTrialEligible) && Intrinsics.areEqual((Object) this.activeSubscription, (Object) subscriptionPlanResponseModel.activeSubscription) && Intrinsics.areEqual((Object) this.onBoardingLink, (Object) subscriptionPlanResponseModel.onBoardingLink) && Intrinsics.areEqual((Object) this.products, (Object) subscriptionPlanResponseModel.products) && Intrinsics.areEqual((Object) this.minimumOrderValue, (Object) subscriptionPlanResponseModel.minimumOrderValue);
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
    public final String getId() {
        return this.f61580id;
    }

    @Nullable
    public final String getImageUrl() {
        return this.imageUrl;
    }

    @Nullable
    public final List<SubscriptionPlanUdfEntityModel> getMinimumOrderValue() {
        return this.minimumOrderValue;
    }

    @Nullable
    public final String getOnBoardingLink() {
        return this.onBoardingLink;
    }

    @Nullable
    public final List<SubscriptionProduct> getProducts() {
        return this.products;
    }

    @Nullable
    public final String getTermsUrl() {
        return this.termsUrl;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        String str = this.f61580id;
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
        List<SubscriptionProduct> list = this.products;
        int hashCode16 = (hashCode15 + (list == null ? 0 : list.hashCode())) * 31;
        List<SubscriptionPlanUdfEntityModel> list2 = this.minimumOrderValue;
        if (list2 != null) {
            i11 = list2.hashCode();
        }
        return hashCode16 + i11;
    }

    public final void setActiveSubscription(@Nullable Boolean bool) {
        this.activeSubscription = bool;
    }

    public final void setCategory(@Nullable String str) {
        this.category = str;
    }

    public final void setCountry(@Nullable String str) {
        this.country = str;
    }

    public final void setCurrency(@Nullable String str) {
        this.currency = str;
    }

    public final void setDescription(@Nullable String str) {
        this.description = str;
    }

    public final void setDurationDays(@Nullable Integer num) {
        this.durationDays = num;
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

    public final void setImageUrl(@Nullable String str) {
        this.imageUrl = str;
    }

    public final void setOnBoardingLink(@Nullable String str) {
        this.onBoardingLink = str;
    }

    public final void setProducts(@Nullable List<SubscriptionProduct> list) {
        this.products = list;
    }

    public final void setTermsUrl(@Nullable String str) {
        this.termsUrl = str;
    }

    public final void setTitle(@Nullable String str) {
        this.title = str;
    }

    @NotNull
    public String toString() {
        String str = this.f61580id;
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
        List<SubscriptionProduct> list = this.products;
        List<SubscriptionPlanUdfEntityModel> list2 = this.minimumOrderValue;
        return "SubscriptionPlanResponseModel(id=" + str + ", title=" + str2 + ", description=" + str3 + ", amount=" + f11 + ", currency=" + str4 + ", country=" + str5 + ", durationDays=" + num + ", freeTrialDays=" + num2 + ", freeTrialTitle=" + str6 + ", category=" + str7 + ", imageUrl=" + str8 + ", termsUrl=" + str9 + ", freeTrialEligible=" + bool + ", activeSubscription=" + bool2 + ", onBoardingLink=" + str10 + ", products=" + list + ", minimumOrderValue=" + list2 + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ SubscriptionPlanResponseModel(java.lang.String r19, java.lang.String r20, java.lang.String r21, java.lang.Float r22, java.lang.String r23, java.lang.String r24, java.lang.Integer r25, java.lang.Integer r26, java.lang.String r27, java.lang.String r28, java.lang.String r29, java.lang.String r30, java.lang.Boolean r31, java.lang.Boolean r32, java.lang.String r33, java.util.List r34, java.util.List r35, int r36, kotlin.jvm.internal.DefaultConstructorMarker r37) {
        /*
            r18 = this;
            r0 = r36
            r1 = r0 & 1
            if (r1 == 0) goto L_0x0008
            r1 = 0
            goto L_0x000a
        L_0x0008:
            r1 = r19
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            r3 = 0
            goto L_0x0012
        L_0x0010:
            r3 = r20
        L_0x0012:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0018
            r4 = 0
            goto L_0x001a
        L_0x0018:
            r4 = r21
        L_0x001a:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x0020
            r5 = 0
            goto L_0x0022
        L_0x0020:
            r5 = r22
        L_0x0022:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0028
            r6 = 0
            goto L_0x002a
        L_0x0028:
            r6 = r23
        L_0x002a:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x0030
            r7 = 0
            goto L_0x0032
        L_0x0030:
            r7 = r24
        L_0x0032:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0038
            r8 = 0
            goto L_0x003a
        L_0x0038:
            r8 = r25
        L_0x003a:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x0040
            r9 = 0
            goto L_0x0042
        L_0x0040:
            r9 = r26
        L_0x0042:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x0048
            r10 = 0
            goto L_0x004a
        L_0x0048:
            r10 = r27
        L_0x004a:
            r11 = r0 & 512(0x200, float:7.175E-43)
            if (r11 == 0) goto L_0x0050
            r11 = 0
            goto L_0x0052
        L_0x0050:
            r11 = r28
        L_0x0052:
            r12 = r0 & 1024(0x400, float:1.435E-42)
            if (r12 == 0) goto L_0x0058
            r12 = 0
            goto L_0x005a
        L_0x0058:
            r12 = r29
        L_0x005a:
            r13 = r0 & 2048(0x800, float:2.87E-42)
            if (r13 == 0) goto L_0x0060
            r13 = 0
            goto L_0x0062
        L_0x0060:
            r13 = r30
        L_0x0062:
            r14 = r0 & 4096(0x1000, float:5.74E-42)
            if (r14 == 0) goto L_0x0068
            r14 = 0
            goto L_0x006a
        L_0x0068:
            r14 = r31
        L_0x006a:
            r15 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r15 == 0) goto L_0x0070
            r15 = 0
            goto L_0x0072
        L_0x0070:
            r15 = r32
        L_0x0072:
            r2 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r2 == 0) goto L_0x0078
            r2 = 0
            goto L_0x007a
        L_0x0078:
            r2 = r33
        L_0x007a:
            r16 = 32768(0x8000, float:4.5918E-41)
            r16 = r0 & r16
            if (r16 == 0) goto L_0x0084
            r16 = 0
            goto L_0x0086
        L_0x0084:
            r16 = r34
        L_0x0086:
            r17 = 65536(0x10000, float:9.18355E-41)
            r0 = r0 & r17
            if (r0 == 0) goto L_0x008e
            r0 = 0
            goto L_0x0090
        L_0x008e:
            r0 = r35
        L_0x0090:
            r19 = r18
            r20 = r1
            r21 = r3
            r22 = r4
            r23 = r5
            r24 = r6
            r25 = r7
            r26 = r8
            r27 = r9
            r28 = r10
            r29 = r11
            r30 = r12
            r31 = r13
            r32 = r14
            r33 = r15
            r34 = r2
            r35 = r16
            r36 = r0
            r19.<init>(r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.talabatcommon.feature.subscriptionManagement.model.SubscriptionPlanResponseModel.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.Float, java.lang.String, java.lang.String, java.lang.Integer, java.lang.Integer, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Boolean, java.lang.Boolean, java.lang.String, java.util.List, java.util.List, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
