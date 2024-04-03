package com.talabat.feature.tpro.presentation.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.C;
import com.talabat.feature.bnplcheckout.presentation.BNPLCheckoutFlutterFragment;
import com.talabat.feature.subscriptions.data.remote.model.UdfItemResponse;
import com.talabat.feature.subscriptions.domain.model.SubscriptionPlanCategory;
import com.talabat.feature.subscriptions.domain.model.SubscriptionRenewType;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.threeten.bp.LocalDateTime;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\bE\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B¥\u0002\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u0016\u001a\u00020\b\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u001e\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0003\u0012\b\b\u0002\u0010 \u001a\u00020\u0003\u0012\b\b\u0002\u0010!\u001a\u00020\u0003\u0012\b\b\u0002\u0010\"\u001a\u00020\u0003\u0012\b\b\u0002\u0010#\u001a\u00020$\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&¢\u0006\u0002\u0010'J\t\u0010L\u001a\u00020\u0003HÆ\u0003J\t\u0010M\u001a\u00020\u0003HÆ\u0003J\t\u0010N\u001a\u00020\u0003HÆ\u0003J\u000f\u0010O\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011HÆ\u0003J\t\u0010P\u001a\u00020\u0014HÆ\u0003J\t\u0010Q\u001a\u00020\u0014HÆ\u0003J\t\u0010R\u001a\u00020\bHÆ\u0003J\t\u0010S\u001a\u00020\u0003HÆ\u0003J\t\u0010T\u001a\u00020\u0003HÆ\u0003J\t\u0010U\u001a\u00020\u0003HÆ\u0003J\t\u0010V\u001a\u00020\u0003HÆ\u0003J\t\u0010W\u001a\u00020\u0003HÆ\u0003J\t\u0010X\u001a\u00020\u0003HÆ\u0003J\t\u0010Y\u001a\u00020\u000bHÆ\u0003J\t\u0010Z\u001a\u00020\u001eHÆ\u0003J\t\u0010[\u001a\u00020\u0003HÆ\u0003J\t\u0010\\\u001a\u00020\u0003HÆ\u0003J\t\u0010]\u001a\u00020\u0003HÆ\u0003J\t\u0010^\u001a\u00020\u0003HÆ\u0003J\t\u0010_\u001a\u00020$HÆ\u0003J\u000b\u0010`\u001a\u0004\u0018\u00010&HÆ\u0003J\t\u0010a\u001a\u00020\u0003HÆ\u0003J\t\u0010b\u001a\u00020\u0003HÆ\u0003J\t\u0010c\u001a\u00020\bHÆ\u0003J\t\u0010d\u001a\u00020\u0003HÆ\u0003J\t\u0010e\u001a\u00020\u000bHÆ\u0003J\t\u0010f\u001a\u00020\u000bHÆ\u0003J\t\u0010g\u001a\u00020\u0003HÆ\u0003J©\u0002\u0010h\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0016\u001a\u00020\b2\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u001b\u001a\u00020\u00032\b\b\u0002\u0010\u001c\u001a\u00020\u000b2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u00032\b\b\u0002\u0010 \u001a\u00020\u00032\b\b\u0002\u0010!\u001a\u00020\u00032\b\b\u0002\u0010\"\u001a\u00020\u00032\b\b\u0002\u0010#\u001a\u00020$2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&HÆ\u0001J\t\u0010i\u001a\u00020\u000bHÖ\u0001J\u0013\u0010j\u001a\u00020\u00142\b\u0010k\u001a\u0004\u0018\u00010lHÖ\u0003J\t\u0010m\u001a\u00020\u000bHÖ\u0001J\t\u0010n\u001a\u00020\u0003HÖ\u0001J\u0019\u0010o\u001a\u00020p2\u0006\u0010q\u001a\u00020r2\u0006\u0010s\u001a\u00020\u000bHÖ\u0001R\u0011\u0010\u0015\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0011\u0010!\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0011\u0010 \u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b,\u0010+R\u0011\u0010\u001f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b-\u0010+R\u0011\u0010\"\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b.\u0010+R\u0011\u0010\u0019\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b/\u0010+R\u0011\u0010\u001d\u001a\u00020\u001e¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b2\u0010+R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b3\u0010+R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b4\u0010+R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u0013\u0010%\u001a\u0004\u0018\u00010&¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u0011\u0010\f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b9\u00106R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b:\u0010)R\u0011\u0010\u001a\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b;\u0010+R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b<\u0010+R\u0011\u0010\u0016\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b=\u0010>R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b?\u0010+R\u0011\u0010\u001c\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b@\u00106R\u0011\u0010\u001b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bA\u0010+R\u0011\u0010\u0017\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bB\u0010+R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bC\u0010+R\u0011\u0010\u0018\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bD\u0010+R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\bE\u0010>R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\b\n\u0000\u001a\u0004\bF\u0010GR\u0011\u0010#\u001a\u00020$¢\u0006\b\n\u0000\u001a\u0004\bH\u0010IR\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010+R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bK\u0010+¨\u0006t"}, d2 = {"Lcom/talabat/feature/tpro/presentation/model/TProPlanDisplayModel;", "Landroid/os/Parcelable;", "planId", "", "title", "description", "displayAmount", "price", "", "country", "durationDays", "", "freeTrialDays", "freeTrialTitle", "termsUrl", "minimumDeliveryFee", "products", "", "Lcom/talabat/feature/tpro/presentation/model/TProProductDisplayModel;", "freeTrialEligible", "", "activeSubscription", "minDeliveryFeeAmount", "periodPrice", "planPeriod", "billingCycle", "freeTrialText", "paymentText", "order", "category", "Lcom/talabat/feature/subscriptions/domain/model/SubscriptionPlanCategory;", "bannerImage", "bannerHeader", "bannerDescription", "benefitsHeader", "renewType", "Lcom/talabat/feature/subscriptions/domain/model/SubscriptionRenewType;", "endDate", "Lorg/threeten/bp/LocalDateTime;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;FLjava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;ZZFLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILcom/talabat/feature/subscriptions/domain/model/SubscriptionPlanCategory;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/talabat/feature/subscriptions/domain/model/SubscriptionRenewType;Lorg/threeten/bp/LocalDateTime;)V", "getActiveSubscription", "()Z", "getBannerDescription", "()Ljava/lang/String;", "getBannerHeader", "getBannerImage", "getBenefitsHeader", "getBillingCycle", "getCategory", "()Lcom/talabat/feature/subscriptions/domain/model/SubscriptionPlanCategory;", "getCountry", "getDescription", "getDisplayAmount", "getDurationDays", "()I", "getEndDate", "()Lorg/threeten/bp/LocalDateTime;", "getFreeTrialDays", "getFreeTrialEligible", "getFreeTrialText", "getFreeTrialTitle", "getMinDeliveryFeeAmount", "()F", "getMinimumDeliveryFee", "getOrder", "getPaymentText", "getPeriodPrice", "getPlanId", "getPlanPeriod", "getPrice", "getProducts", "()Ljava/util/List;", "getRenewType", "()Lcom/talabat/feature/subscriptions/domain/model/SubscriptionRenewType;", "getTermsUrl", "getTitle", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "com_talabat_feature_tpro_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Parcelize
public final class TProPlanDisplayModel implements Parcelable {
    @NotNull
    public static final Parcelable.Creator<TProPlanDisplayModel> CREATOR = new Creator();
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
    private final SubscriptionPlanCategory category;
    @NotNull
    private final String country;
    @NotNull
    private final String description;
    @NotNull
    private final String displayAmount;
    private final int durationDays;
    @Nullable
    private final LocalDateTime endDate;
    private final int freeTrialDays;
    private final boolean freeTrialEligible;
    @NotNull
    private final String freeTrialText;
    @NotNull
    private final String freeTrialTitle;
    private final float minDeliveryFeeAmount;
    @NotNull
    private final String minimumDeliveryFee;
    private final int order;
    @NotNull
    private final String paymentText;
    @NotNull
    private final String periodPrice;
    @NotNull
    private final String planId;
    @NotNull
    private final String planPeriod;
    private final float price;
    @NotNull
    private final List<TProProductDisplayModel> products;
    @NotNull
    private final SubscriptionRenewType renewType;
    @NotNull
    private final String termsUrl;
    @NotNull
    private final String title;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<TProPlanDisplayModel> {
        @NotNull
        public final TProPlanDisplayModel createFromParcel(@NotNull Parcel parcel) {
            Parcel parcel2 = parcel;
            Intrinsics.checkNotNullParameter(parcel2, "parcel");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            float readFloat = parcel.readFloat();
            String readString5 = parcel.readString();
            int readInt = parcel.readInt();
            int readInt2 = parcel.readInt();
            String readString6 = parcel.readString();
            String readString7 = parcel.readString();
            String readString8 = parcel.readString();
            int readInt3 = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt3);
            for (int i11 = 0; i11 != readInt3; i11++) {
                arrayList.add(TProProductDisplayModel.CREATOR.createFromParcel(parcel2));
            }
            return new TProPlanDisplayModel(readString, readString2, readString3, readString4, readFloat, readString5, readInt, readInt2, readString6, readString7, readString8, arrayList, parcel.readInt() != 0, parcel.readInt() != 0, parcel.readFloat(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), SubscriptionPlanCategory.valueOf(parcel.readString()), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), SubscriptionRenewType.valueOf(parcel.readString()), (LocalDateTime) parcel.readSerializable());
        }

        @NotNull
        public final TProPlanDisplayModel[] newArray(int i11) {
            return new TProPlanDisplayModel[i11];
        }
    }

    public TProPlanDisplayModel() {
        this((String) null, (String) null, (String) null, (String) null, 0.0f, (String) null, 0, 0, (String) null, (String) null, (String) null, (List) null, false, false, 0.0f, (String) null, (String) null, (String) null, (String) null, (String) null, 0, (SubscriptionPlanCategory) null, (String) null, (String) null, (String) null, (String) null, (SubscriptionRenewType) null, (LocalDateTime) null, 268435455, (DefaultConstructorMarker) null);
    }

    public TProPlanDisplayModel(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, float f11, @NotNull String str5, int i11, int i12, @NotNull String str6, @NotNull String str7, @NotNull String str8, @NotNull List<TProProductDisplayModel> list, boolean z11, boolean z12, float f12, @NotNull String str9, @NotNull String str10, @NotNull String str11, @NotNull String str12, @NotNull String str13, int i13, @NotNull SubscriptionPlanCategory subscriptionPlanCategory, @NotNull String str14, @NotNull String str15, @NotNull String str16, @NotNull String str17, @NotNull SubscriptionRenewType subscriptionRenewType, @Nullable LocalDateTime localDateTime) {
        String str18 = str;
        String str19 = str2;
        String str20 = str3;
        String str21 = str4;
        String str22 = str5;
        String str23 = str6;
        String str24 = str7;
        String str25 = str8;
        List<TProProductDisplayModel> list2 = list;
        String str26 = str9;
        String str27 = str10;
        String str28 = str11;
        String str29 = str12;
        String str30 = str13;
        String str31 = str14;
        Intrinsics.checkNotNullParameter(str18, BNPLCheckoutFlutterFragment.PLAN_ID_EXTRA);
        Intrinsics.checkNotNullParameter(str19, "title");
        Intrinsics.checkNotNullParameter(str20, "description");
        Intrinsics.checkNotNullParameter(str21, "displayAmount");
        Intrinsics.checkNotNullParameter(str22, "country");
        Intrinsics.checkNotNullParameter(str23, "freeTrialTitle");
        Intrinsics.checkNotNullParameter(str24, "termsUrl");
        Intrinsics.checkNotNullParameter(str25, UdfItemResponse.MDF);
        Intrinsics.checkNotNullParameter(list2, "products");
        Intrinsics.checkNotNullParameter(str26, "periodPrice");
        Intrinsics.checkNotNullParameter(str27, "planPeriod");
        Intrinsics.checkNotNullParameter(str28, "billingCycle");
        Intrinsics.checkNotNullParameter(str29, "freeTrialText");
        Intrinsics.checkNotNullParameter(str30, "paymentText");
        Intrinsics.checkNotNullParameter(subscriptionPlanCategory, "category");
        Intrinsics.checkNotNullParameter(str14, "bannerImage");
        Intrinsics.checkNotNullParameter(str15, "bannerHeader");
        Intrinsics.checkNotNullParameter(str16, "bannerDescription");
        Intrinsics.checkNotNullParameter(str17, "benefitsHeader");
        Intrinsics.checkNotNullParameter(subscriptionRenewType, "renewType");
        this.planId = str18;
        this.title = str19;
        this.description = str20;
        this.displayAmount = str21;
        this.price = f11;
        this.country = str22;
        this.durationDays = i11;
        this.freeTrialDays = i12;
        this.freeTrialTitle = str23;
        this.termsUrl = str24;
        this.minimumDeliveryFee = str25;
        this.products = list2;
        this.freeTrialEligible = z11;
        this.activeSubscription = z12;
        this.minDeliveryFeeAmount = f12;
        this.periodPrice = str26;
        this.planPeriod = str27;
        this.billingCycle = str28;
        this.freeTrialText = str29;
        this.paymentText = str30;
        this.order = i13;
        this.category = subscriptionPlanCategory;
        this.bannerImage = str14;
        this.bannerHeader = str15;
        this.bannerDescription = str16;
        this.benefitsHeader = str17;
        this.renewType = subscriptionRenewType;
        this.endDate = localDateTime;
    }

    public static /* synthetic */ TProPlanDisplayModel copy$default(TProPlanDisplayModel tProPlanDisplayModel, String str, String str2, String str3, String str4, float f11, String str5, int i11, int i12, String str6, String str7, String str8, List list, boolean z11, boolean z12, float f12, String str9, String str10, String str11, String str12, String str13, int i13, SubscriptionPlanCategory subscriptionPlanCategory, String str14, String str15, String str16, String str17, SubscriptionRenewType subscriptionRenewType, LocalDateTime localDateTime, int i14, Object obj) {
        TProPlanDisplayModel tProPlanDisplayModel2 = tProPlanDisplayModel;
        int i15 = i14;
        return tProPlanDisplayModel.copy((i15 & 1) != 0 ? tProPlanDisplayModel2.planId : str, (i15 & 2) != 0 ? tProPlanDisplayModel2.title : str2, (i15 & 4) != 0 ? tProPlanDisplayModel2.description : str3, (i15 & 8) != 0 ? tProPlanDisplayModel2.displayAmount : str4, (i15 & 16) != 0 ? tProPlanDisplayModel2.price : f11, (i15 & 32) != 0 ? tProPlanDisplayModel2.country : str5, (i15 & 64) != 0 ? tProPlanDisplayModel2.durationDays : i11, (i15 & 128) != 0 ? tProPlanDisplayModel2.freeTrialDays : i12, (i15 & 256) != 0 ? tProPlanDisplayModel2.freeTrialTitle : str6, (i15 & 512) != 0 ? tProPlanDisplayModel2.termsUrl : str7, (i15 & 1024) != 0 ? tProPlanDisplayModel2.minimumDeliveryFee : str8, (i15 & 2048) != 0 ? tProPlanDisplayModel2.products : list, (i15 & 4096) != 0 ? tProPlanDisplayModel2.freeTrialEligible : z11, (i15 & 8192) != 0 ? tProPlanDisplayModel2.activeSubscription : z12, (i15 & 16384) != 0 ? tProPlanDisplayModel2.minDeliveryFeeAmount : f12, (i15 & 32768) != 0 ? tProPlanDisplayModel2.periodPrice : str9, (i15 & 65536) != 0 ? tProPlanDisplayModel2.planPeriod : str10, (i15 & 131072) != 0 ? tProPlanDisplayModel2.billingCycle : str11, (i15 & 262144) != 0 ? tProPlanDisplayModel2.freeTrialText : str12, (i15 & 524288) != 0 ? tProPlanDisplayModel2.paymentText : str13, (i15 & 1048576) != 0 ? tProPlanDisplayModel2.order : i13, (i15 & 2097152) != 0 ? tProPlanDisplayModel2.category : subscriptionPlanCategory, (i15 & 4194304) != 0 ? tProPlanDisplayModel2.bannerImage : str14, (i15 & 8388608) != 0 ? tProPlanDisplayModel2.bannerHeader : str15, (i15 & 16777216) != 0 ? tProPlanDisplayModel2.bannerDescription : str16, (i15 & 33554432) != 0 ? tProPlanDisplayModel2.benefitsHeader : str17, (i15 & 67108864) != 0 ? tProPlanDisplayModel2.renewType : subscriptionRenewType, (i15 & C.BUFFER_FLAG_FIRST_SAMPLE) != 0 ? tProPlanDisplayModel2.endDate : localDateTime);
    }

    @NotNull
    public final String component1() {
        return this.planId;
    }

    @NotNull
    public final String component10() {
        return this.termsUrl;
    }

    @NotNull
    public final String component11() {
        return this.minimumDeliveryFee;
    }

    @NotNull
    public final List<TProProductDisplayModel> component12() {
        return this.products;
    }

    public final boolean component13() {
        return this.freeTrialEligible;
    }

    public final boolean component14() {
        return this.activeSubscription;
    }

    public final float component15() {
        return this.minDeliveryFeeAmount;
    }

    @NotNull
    public final String component16() {
        return this.periodPrice;
    }

    @NotNull
    public final String component17() {
        return this.planPeriod;
    }

    @NotNull
    public final String component18() {
        return this.billingCycle;
    }

    @NotNull
    public final String component19() {
        return this.freeTrialText;
    }

    @NotNull
    public final String component2() {
        return this.title;
    }

    @NotNull
    public final String component20() {
        return this.paymentText;
    }

    public final int component21() {
        return this.order;
    }

    @NotNull
    public final SubscriptionPlanCategory component22() {
        return this.category;
    }

    @NotNull
    public final String component23() {
        return this.bannerImage;
    }

    @NotNull
    public final String component24() {
        return this.bannerHeader;
    }

    @NotNull
    public final String component25() {
        return this.bannerDescription;
    }

    @NotNull
    public final String component26() {
        return this.benefitsHeader;
    }

    @NotNull
    public final SubscriptionRenewType component27() {
        return this.renewType;
    }

    @Nullable
    public final LocalDateTime component28() {
        return this.endDate;
    }

    @NotNull
    public final String component3() {
        return this.description;
    }

    @NotNull
    public final String component4() {
        return this.displayAmount;
    }

    public final float component5() {
        return this.price;
    }

    @NotNull
    public final String component6() {
        return this.country;
    }

    public final int component7() {
        return this.durationDays;
    }

    public final int component8() {
        return this.freeTrialDays;
    }

    @NotNull
    public final String component9() {
        return this.freeTrialTitle;
    }

    @NotNull
    public final TProPlanDisplayModel copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, float f11, @NotNull String str5, int i11, int i12, @NotNull String str6, @NotNull String str7, @NotNull String str8, @NotNull List<TProProductDisplayModel> list, boolean z11, boolean z12, float f12, @NotNull String str9, @NotNull String str10, @NotNull String str11, @NotNull String str12, @NotNull String str13, int i13, @NotNull SubscriptionPlanCategory subscriptionPlanCategory, @NotNull String str14, @NotNull String str15, @NotNull String str16, @NotNull String str17, @NotNull SubscriptionRenewType subscriptionRenewType, @Nullable LocalDateTime localDateTime) {
        String str18 = str;
        Intrinsics.checkNotNullParameter(str18, BNPLCheckoutFlutterFragment.PLAN_ID_EXTRA);
        Intrinsics.checkNotNullParameter(str2, "title");
        Intrinsics.checkNotNullParameter(str3, "description");
        Intrinsics.checkNotNullParameter(str4, "displayAmount");
        Intrinsics.checkNotNullParameter(str5, "country");
        Intrinsics.checkNotNullParameter(str6, "freeTrialTitle");
        Intrinsics.checkNotNullParameter(str7, "termsUrl");
        Intrinsics.checkNotNullParameter(str8, UdfItemResponse.MDF);
        Intrinsics.checkNotNullParameter(list, "products");
        Intrinsics.checkNotNullParameter(str9, "periodPrice");
        Intrinsics.checkNotNullParameter(str10, "planPeriod");
        Intrinsics.checkNotNullParameter(str11, "billingCycle");
        Intrinsics.checkNotNullParameter(str12, "freeTrialText");
        Intrinsics.checkNotNullParameter(str13, "paymentText");
        Intrinsics.checkNotNullParameter(subscriptionPlanCategory, "category");
        Intrinsics.checkNotNullParameter(str14, "bannerImage");
        Intrinsics.checkNotNullParameter(str15, "bannerHeader");
        Intrinsics.checkNotNullParameter(str16, "bannerDescription");
        Intrinsics.checkNotNullParameter(str17, "benefitsHeader");
        Intrinsics.checkNotNullParameter(subscriptionRenewType, "renewType");
        return new TProPlanDisplayModel(str18, str2, str3, str4, f11, str5, i11, i12, str6, str7, str8, list, z11, z12, f12, str9, str10, str11, str12, str13, i13, subscriptionPlanCategory, str14, str15, str16, str17, subscriptionRenewType, localDateTime);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TProPlanDisplayModel)) {
            return false;
        }
        TProPlanDisplayModel tProPlanDisplayModel = (TProPlanDisplayModel) obj;
        return Intrinsics.areEqual((Object) this.planId, (Object) tProPlanDisplayModel.planId) && Intrinsics.areEqual((Object) this.title, (Object) tProPlanDisplayModel.title) && Intrinsics.areEqual((Object) this.description, (Object) tProPlanDisplayModel.description) && Intrinsics.areEqual((Object) this.displayAmount, (Object) tProPlanDisplayModel.displayAmount) && Intrinsics.areEqual((Object) Float.valueOf(this.price), (Object) Float.valueOf(tProPlanDisplayModel.price)) && Intrinsics.areEqual((Object) this.country, (Object) tProPlanDisplayModel.country) && this.durationDays == tProPlanDisplayModel.durationDays && this.freeTrialDays == tProPlanDisplayModel.freeTrialDays && Intrinsics.areEqual((Object) this.freeTrialTitle, (Object) tProPlanDisplayModel.freeTrialTitle) && Intrinsics.areEqual((Object) this.termsUrl, (Object) tProPlanDisplayModel.termsUrl) && Intrinsics.areEqual((Object) this.minimumDeliveryFee, (Object) tProPlanDisplayModel.minimumDeliveryFee) && Intrinsics.areEqual((Object) this.products, (Object) tProPlanDisplayModel.products) && this.freeTrialEligible == tProPlanDisplayModel.freeTrialEligible && this.activeSubscription == tProPlanDisplayModel.activeSubscription && Intrinsics.areEqual((Object) Float.valueOf(this.minDeliveryFeeAmount), (Object) Float.valueOf(tProPlanDisplayModel.minDeliveryFeeAmount)) && Intrinsics.areEqual((Object) this.periodPrice, (Object) tProPlanDisplayModel.periodPrice) && Intrinsics.areEqual((Object) this.planPeriod, (Object) tProPlanDisplayModel.planPeriod) && Intrinsics.areEqual((Object) this.billingCycle, (Object) tProPlanDisplayModel.billingCycle) && Intrinsics.areEqual((Object) this.freeTrialText, (Object) tProPlanDisplayModel.freeTrialText) && Intrinsics.areEqual((Object) this.paymentText, (Object) tProPlanDisplayModel.paymentText) && this.order == tProPlanDisplayModel.order && this.category == tProPlanDisplayModel.category && Intrinsics.areEqual((Object) this.bannerImage, (Object) tProPlanDisplayModel.bannerImage) && Intrinsics.areEqual((Object) this.bannerHeader, (Object) tProPlanDisplayModel.bannerHeader) && Intrinsics.areEqual((Object) this.bannerDescription, (Object) tProPlanDisplayModel.bannerDescription) && Intrinsics.areEqual((Object) this.benefitsHeader, (Object) tProPlanDisplayModel.benefitsHeader) && this.renewType == tProPlanDisplayModel.renewType && Intrinsics.areEqual((Object) this.endDate, (Object) tProPlanDisplayModel.endDate);
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
    public final SubscriptionPlanCategory getCategory() {
        return this.category;
    }

    @NotNull
    public final String getCountry() {
        return this.country;
    }

    @NotNull
    public final String getDescription() {
        return this.description;
    }

    @NotNull
    public final String getDisplayAmount() {
        return this.displayAmount;
    }

    public final int getDurationDays() {
        return this.durationDays;
    }

    @Nullable
    public final LocalDateTime getEndDate() {
        return this.endDate;
    }

    public final int getFreeTrialDays() {
        return this.freeTrialDays;
    }

    public final boolean getFreeTrialEligible() {
        return this.freeTrialEligible;
    }

    @NotNull
    public final String getFreeTrialText() {
        return this.freeTrialText;
    }

    @NotNull
    public final String getFreeTrialTitle() {
        return this.freeTrialTitle;
    }

    public final float getMinDeliveryFeeAmount() {
        return this.minDeliveryFeeAmount;
    }

    @NotNull
    public final String getMinimumDeliveryFee() {
        return this.minimumDeliveryFee;
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

    public final float getPrice() {
        return this.price;
    }

    @NotNull
    public final List<TProProductDisplayModel> getProducts() {
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
        int hashCode = ((((((((((((((((((((((this.planId.hashCode() * 31) + this.title.hashCode()) * 31) + this.description.hashCode()) * 31) + this.displayAmount.hashCode()) * 31) + Float.floatToIntBits(this.price)) * 31) + this.country.hashCode()) * 31) + this.durationDays) * 31) + this.freeTrialDays) * 31) + this.freeTrialTitle.hashCode()) * 31) + this.termsUrl.hashCode()) * 31) + this.minimumDeliveryFee.hashCode()) * 31) + this.products.hashCode()) * 31;
        boolean z11 = this.freeTrialEligible;
        boolean z12 = true;
        if (z11) {
            z11 = true;
        }
        int i11 = (hashCode + (z11 ? 1 : 0)) * 31;
        boolean z13 = this.activeSubscription;
        if (!z13) {
            z12 = z13;
        }
        int floatToIntBits = (((((((((((((((((((((((((((i11 + (z12 ? 1 : 0)) * 31) + Float.floatToIntBits(this.minDeliveryFeeAmount)) * 31) + this.periodPrice.hashCode()) * 31) + this.planPeriod.hashCode()) * 31) + this.billingCycle.hashCode()) * 31) + this.freeTrialText.hashCode()) * 31) + this.paymentText.hashCode()) * 31) + this.order) * 31) + this.category.hashCode()) * 31) + this.bannerImage.hashCode()) * 31) + this.bannerHeader.hashCode()) * 31) + this.bannerDescription.hashCode()) * 31) + this.benefitsHeader.hashCode()) * 31) + this.renewType.hashCode()) * 31;
        LocalDateTime localDateTime = this.endDate;
        return floatToIntBits + (localDateTime == null ? 0 : localDateTime.hashCode());
    }

    @NotNull
    public String toString() {
        String str = this.planId;
        String str2 = this.title;
        String str3 = this.description;
        String str4 = this.displayAmount;
        float f11 = this.price;
        String str5 = this.country;
        int i11 = this.durationDays;
        int i12 = this.freeTrialDays;
        String str6 = this.freeTrialTitle;
        String str7 = this.termsUrl;
        String str8 = this.minimumDeliveryFee;
        List<TProProductDisplayModel> list = this.products;
        boolean z11 = this.freeTrialEligible;
        boolean z12 = this.activeSubscription;
        float f12 = this.minDeliveryFeeAmount;
        String str9 = this.periodPrice;
        String str10 = this.planPeriod;
        String str11 = this.billingCycle;
        String str12 = this.freeTrialText;
        String str13 = this.paymentText;
        int i13 = this.order;
        SubscriptionPlanCategory subscriptionPlanCategory = this.category;
        String str14 = this.bannerImage;
        String str15 = this.bannerHeader;
        String str16 = this.bannerDescription;
        String str17 = this.benefitsHeader;
        SubscriptionRenewType subscriptionRenewType = this.renewType;
        LocalDateTime localDateTime = this.endDate;
        return "TProPlanDisplayModel(planId=" + str + ", title=" + str2 + ", description=" + str3 + ", displayAmount=" + str4 + ", price=" + f11 + ", country=" + str5 + ", durationDays=" + i11 + ", freeTrialDays=" + i12 + ", freeTrialTitle=" + str6 + ", termsUrl=" + str7 + ", minimumDeliveryFee=" + str8 + ", products=" + list + ", freeTrialEligible=" + z11 + ", activeSubscription=" + z12 + ", minDeliveryFeeAmount=" + f12 + ", periodPrice=" + str9 + ", planPeriod=" + str10 + ", billingCycle=" + str11 + ", freeTrialText=" + str12 + ", paymentText=" + str13 + ", order=" + i13 + ", category=" + subscriptionPlanCategory + ", bannerImage=" + str14 + ", bannerHeader=" + str15 + ", bannerDescription=" + str16 + ", benefitsHeader=" + str17 + ", renewType=" + subscriptionRenewType + ", endDate=" + localDateTime + ")";
    }

    public void writeToParcel(@NotNull Parcel parcel, int i11) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.planId);
        parcel.writeString(this.title);
        parcel.writeString(this.description);
        parcel.writeString(this.displayAmount);
        parcel.writeFloat(this.price);
        parcel.writeString(this.country);
        parcel.writeInt(this.durationDays);
        parcel.writeInt(this.freeTrialDays);
        parcel.writeString(this.freeTrialTitle);
        parcel.writeString(this.termsUrl);
        parcel.writeString(this.minimumDeliveryFee);
        List<TProProductDisplayModel> list = this.products;
        parcel.writeInt(list.size());
        for (TProProductDisplayModel writeToParcel : list) {
            writeToParcel.writeToParcel(parcel, i11);
        }
        parcel.writeInt(this.freeTrialEligible ? 1 : 0);
        parcel.writeInt(this.activeSubscription ? 1 : 0);
        parcel.writeFloat(this.minDeliveryFeeAmount);
        parcel.writeString(this.periodPrice);
        parcel.writeString(this.planPeriod);
        parcel.writeString(this.billingCycle);
        parcel.writeString(this.freeTrialText);
        parcel.writeString(this.paymentText);
        parcel.writeInt(this.order);
        parcel.writeString(this.category.name());
        parcel.writeString(this.bannerImage);
        parcel.writeString(this.bannerHeader);
        parcel.writeString(this.bannerDescription);
        parcel.writeString(this.benefitsHeader);
        parcel.writeString(this.renewType.name());
        parcel.writeSerializable(this.endDate);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ TProPlanDisplayModel(java.lang.String r30, java.lang.String r31, java.lang.String r32, java.lang.String r33, float r34, java.lang.String r35, int r36, int r37, java.lang.String r38, java.lang.String r39, java.lang.String r40, java.util.List r41, boolean r42, boolean r43, float r44, java.lang.String r45, java.lang.String r46, java.lang.String r47, java.lang.String r48, java.lang.String r49, int r50, com.talabat.feature.subscriptions.domain.model.SubscriptionPlanCategory r51, java.lang.String r52, java.lang.String r53, java.lang.String r54, java.lang.String r55, com.talabat.feature.subscriptions.domain.model.SubscriptionRenewType r56, org.threeten.bp.LocalDateTime r57, int r58, kotlin.jvm.internal.DefaultConstructorMarker r59) {
        /*
            r29 = this;
            r0 = r58
            r1 = r0 & 1
            if (r1 == 0) goto L_0x000d
            kotlin.jvm.internal.StringCompanionObject r1 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.String r1 = com.talabat.talabatcommon.extentions.StringUtils.empty(r1)
            goto L_0x000f
        L_0x000d:
            r1 = r30
        L_0x000f:
            r2 = r0 & 2
            if (r2 == 0) goto L_0x001a
            kotlin.jvm.internal.StringCompanionObject r2 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.String r2 = com.talabat.talabatcommon.extentions.StringUtils.empty(r2)
            goto L_0x001c
        L_0x001a:
            r2 = r31
        L_0x001c:
            r3 = r0 & 4
            if (r3 == 0) goto L_0x0027
            kotlin.jvm.internal.StringCompanionObject r3 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.String r3 = com.talabat.talabatcommon.extentions.StringUtils.empty(r3)
            goto L_0x0029
        L_0x0027:
            r3 = r32
        L_0x0029:
            r4 = r0 & 8
            if (r4 == 0) goto L_0x0034
            kotlin.jvm.internal.StringCompanionObject r4 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.String r4 = com.talabat.talabatcommon.extentions.StringUtils.empty(r4)
            goto L_0x0036
        L_0x0034:
            r4 = r33
        L_0x0036:
            r5 = r0 & 16
            if (r5 == 0) goto L_0x003c
            r5 = 0
            goto L_0x003e
        L_0x003c:
            r5 = r34
        L_0x003e:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x0049
            kotlin.jvm.internal.StringCompanionObject r7 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.String r7 = com.talabat.talabatcommon.extentions.StringUtils.empty(r7)
            goto L_0x004b
        L_0x0049:
            r7 = r35
        L_0x004b:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0051
            r8 = 0
            goto L_0x0053
        L_0x0051:
            r8 = r36
        L_0x0053:
            r10 = r0 & 128(0x80, float:1.794E-43)
            if (r10 == 0) goto L_0x0059
            r10 = 0
            goto L_0x005b
        L_0x0059:
            r10 = r37
        L_0x005b:
            r11 = r0 & 256(0x100, float:3.59E-43)
            if (r11 == 0) goto L_0x0066
            kotlin.jvm.internal.StringCompanionObject r11 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.String r11 = com.talabat.talabatcommon.extentions.StringUtils.empty(r11)
            goto L_0x0068
        L_0x0066:
            r11 = r38
        L_0x0068:
            r12 = r0 & 512(0x200, float:7.175E-43)
            if (r12 == 0) goto L_0x0073
            kotlin.jvm.internal.StringCompanionObject r12 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.String r12 = com.talabat.talabatcommon.extentions.StringUtils.empty(r12)
            goto L_0x0075
        L_0x0073:
            r12 = r39
        L_0x0075:
            r13 = r0 & 1024(0x400, float:1.435E-42)
            if (r13 == 0) goto L_0x0080
            kotlin.jvm.internal.StringCompanionObject r13 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.String r13 = com.talabat.talabatcommon.extentions.StringUtils.empty(r13)
            goto L_0x0082
        L_0x0080:
            r13 = r40
        L_0x0082:
            r14 = r0 & 2048(0x800, float:2.87E-42)
            if (r14 == 0) goto L_0x008b
            java.util.List r14 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
            goto L_0x008d
        L_0x008b:
            r14 = r41
        L_0x008d:
            r15 = r0 & 4096(0x1000, float:5.74E-42)
            if (r15 == 0) goto L_0x0093
            r15 = 0
            goto L_0x0095
        L_0x0093:
            r15 = r42
        L_0x0095:
            r6 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r6 == 0) goto L_0x009b
            r6 = 0
            goto L_0x009d
        L_0x009b:
            r6 = r43
        L_0x009d:
            r9 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r9 == 0) goto L_0x00a3
            r9 = 0
            goto L_0x00a5
        L_0x00a3:
            r9 = r44
        L_0x00a5:
            r16 = 32768(0x8000, float:4.5918E-41)
            r16 = r0 & r16
            if (r16 == 0) goto L_0x00b3
            kotlin.jvm.internal.StringCompanionObject r16 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.String r16 = com.talabat.talabatcommon.extentions.StringUtils.empty(r16)
            goto L_0x00b5
        L_0x00b3:
            r16 = r45
        L_0x00b5:
            r17 = 65536(0x10000, float:9.18355E-41)
            r17 = r0 & r17
            if (r17 == 0) goto L_0x00c2
            kotlin.jvm.internal.StringCompanionObject r17 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.String r17 = com.talabat.talabatcommon.extentions.StringUtils.empty(r17)
            goto L_0x00c4
        L_0x00c2:
            r17 = r46
        L_0x00c4:
            r18 = 131072(0x20000, float:1.83671E-40)
            r18 = r0 & r18
            if (r18 == 0) goto L_0x00d1
            kotlin.jvm.internal.StringCompanionObject r18 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.String r18 = com.talabat.talabatcommon.extentions.StringUtils.empty(r18)
            goto L_0x00d3
        L_0x00d1:
            r18 = r47
        L_0x00d3:
            r19 = 262144(0x40000, float:3.67342E-40)
            r19 = r0 & r19
            if (r19 == 0) goto L_0x00e0
            kotlin.jvm.internal.StringCompanionObject r19 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.String r19 = com.talabat.talabatcommon.extentions.StringUtils.empty(r19)
            goto L_0x00e2
        L_0x00e0:
            r19 = r48
        L_0x00e2:
            r20 = 524288(0x80000, float:7.34684E-40)
            r20 = r0 & r20
            if (r20 == 0) goto L_0x00ef
            kotlin.jvm.internal.StringCompanionObject r20 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.String r20 = com.talabat.talabatcommon.extentions.StringUtils.empty(r20)
            goto L_0x00f1
        L_0x00ef:
            r20 = r49
        L_0x00f1:
            r21 = 1048576(0x100000, float:1.469368E-39)
            r21 = r0 & r21
            if (r21 == 0) goto L_0x00fa
            r21 = 0
            goto L_0x00fc
        L_0x00fa:
            r21 = r50
        L_0x00fc:
            r22 = 2097152(0x200000, float:2.938736E-39)
            r22 = r0 & r22
            if (r22 == 0) goto L_0x0105
            com.talabat.feature.subscriptions.domain.model.SubscriptionPlanCategory r22 = com.talabat.feature.subscriptions.domain.model.SubscriptionPlanCategory.NONE
            goto L_0x0107
        L_0x0105:
            r22 = r51
        L_0x0107:
            r23 = 4194304(0x400000, float:5.877472E-39)
            r23 = r0 & r23
            if (r23 == 0) goto L_0x0114
            kotlin.jvm.internal.StringCompanionObject r23 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.String r23 = com.talabat.talabatcommon.extentions.StringUtils.empty(r23)
            goto L_0x0116
        L_0x0114:
            r23 = r52
        L_0x0116:
            r24 = 8388608(0x800000, float:1.17549435E-38)
            r24 = r0 & r24
            if (r24 == 0) goto L_0x0123
            kotlin.jvm.internal.StringCompanionObject r24 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.String r24 = com.talabat.talabatcommon.extentions.StringUtils.empty(r24)
            goto L_0x0125
        L_0x0123:
            r24 = r53
        L_0x0125:
            r25 = 16777216(0x1000000, float:2.3509887E-38)
            r25 = r0 & r25
            if (r25 == 0) goto L_0x0132
            kotlin.jvm.internal.StringCompanionObject r25 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.String r25 = com.talabat.talabatcommon.extentions.StringUtils.empty(r25)
            goto L_0x0134
        L_0x0132:
            r25 = r54
        L_0x0134:
            r26 = 33554432(0x2000000, float:9.403955E-38)
            r26 = r0 & r26
            if (r26 == 0) goto L_0x0141
            kotlin.jvm.internal.StringCompanionObject r26 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.String r26 = com.talabat.talabatcommon.extentions.StringUtils.empty(r26)
            goto L_0x0143
        L_0x0141:
            r26 = r55
        L_0x0143:
            r27 = 67108864(0x4000000, float:1.5046328E-36)
            r27 = r0 & r27
            if (r27 == 0) goto L_0x014c
            com.talabat.feature.subscriptions.domain.model.SubscriptionRenewType r27 = com.talabat.feature.subscriptions.domain.model.SubscriptionRenewType.NoRenewal
            goto L_0x014e
        L_0x014c:
            r27 = r56
        L_0x014e:
            r28 = 134217728(0x8000000, float:3.85186E-34)
            r0 = r0 & r28
            if (r0 == 0) goto L_0x0156
            r0 = 0
            goto L_0x0158
        L_0x0156:
            r0 = r57
        L_0x0158:
            r30 = r29
            r31 = r1
            r32 = r2
            r33 = r3
            r34 = r4
            r35 = r5
            r36 = r7
            r37 = r8
            r38 = r10
            r39 = r11
            r40 = r12
            r41 = r13
            r42 = r14
            r43 = r15
            r44 = r6
            r45 = r9
            r46 = r16
            r47 = r17
            r48 = r18
            r49 = r19
            r50 = r20
            r51 = r21
            r52 = r22
            r53 = r23
            r54 = r24
            r55 = r25
            r56 = r26
            r57 = r27
            r58 = r0
            r30.<init>(r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55, r56, r57, r58)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.tpro.presentation.model.TProPlanDisplayModel.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, float, java.lang.String, int, int, java.lang.String, java.lang.String, java.lang.String, java.util.List, boolean, boolean, float, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, com.talabat.feature.subscriptions.domain.model.SubscriptionPlanCategory, java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.talabat.feature.subscriptions.domain.model.SubscriptionRenewType, org.threeten.bp.LocalDateTime, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
