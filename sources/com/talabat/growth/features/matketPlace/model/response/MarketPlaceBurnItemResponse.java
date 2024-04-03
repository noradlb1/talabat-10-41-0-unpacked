package com.talabat.growth.features.matketPlace.model.response;

import com.google.gson.annotations.SerializedName;
import com.talabat.growth.ui.loyalty.burn.models.SubscriptionRestriction;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.VoucherOptionType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b)\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B­\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\u0015J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\u0010\u0010/\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0019J\u0010\u00100\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u001eJ\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00102\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0019J\u000b\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00105\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0019J\u0010\u00106\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u001eJ\u000b\u00107\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0003HÆ\u0003J¶\u0001\u00109\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010:J\u0013\u0010;\u001a\u00020<2\b\u0010=\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010>\u001a\u00020\u0006HÖ\u0001J\t\u0010?\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0004¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u001a\u0010\u0013\u001a\u0004\u0018\u00010\u00068\u0006X\u0004¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u001c\u0010\u0019R\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u000b8\u0006X\u0004¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b\u001d\u0010\u001eR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0017R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0017R\u001a\u0010\t\u001a\u0004\u0018\u00010\u00068\u0006X\u0004¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\"\u0010\u0019R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00128\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0017R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0017R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0017R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0004¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b*\u0010\u001e¨\u0006@"}, d2 = {"Lcom/talabat/growth/features/matketPlace/model/response/MarketPlaceBurnItemResponse;", "", "id", "", "title", "country", "", "thumbnailURL", "imageURL", "pointsCost", "walletCredit", "", "burnOptionType", "description", "tag", "voucherOptionType", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/VoucherOptionType;", "subscriptionRestriction", "Lcom/talabat/growth/ui/loyalty/burn/models/SubscriptionRestriction;", "discountType", "discountValue", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/VoucherOptionType;Lcom/talabat/growth/ui/loyalty/burn/models/SubscriptionRestriction;Ljava/lang/Integer;Ljava/lang/Float;)V", "getBurnOptionType", "()Ljava/lang/String;", "getCountry", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getDescription", "getDiscountType", "getDiscountValue", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getId", "getImageURL", "getPointsCost", "getSubscriptionRestriction", "()Lcom/talabat/growth/ui/loyalty/burn/models/SubscriptionRestriction;", "getTag", "getThumbnailURL", "getTitle", "getVoucherOptionType", "()Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/VoucherOptionType;", "getWalletCredit", "component1", "component10", "component11", "component12", "component13", "component14", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/VoucherOptionType;Lcom/talabat/growth/ui/loyalty/burn/models/SubscriptionRestriction;Ljava/lang/Integer;Ljava/lang/Float;)Lcom/talabat/growth/features/matketPlace/model/response/MarketPlaceBurnItemResponse;", "equals", "", "other", "hashCode", "toString", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MarketPlaceBurnItemResponse {
    @SerializedName("burnOptionType")
    @Nullable
    private final String burnOptionType;
    @SerializedName("country")
    @Nullable
    private final Integer country;
    @SerializedName("description")
    @Nullable
    private final String description;
    @SerializedName("discountType")
    @Nullable
    private final Integer discountType;
    @SerializedName("discountValue")
    @Nullable
    private final Float discountValue;
    @SerializedName("id")
    @Nullable

    /* renamed from: id  reason: collision with root package name */
    private final String f60574id;
    @SerializedName("imageURL")
    @Nullable
    private final String imageURL;
    @SerializedName("pointsCost")
    @Nullable
    private final Integer pointsCost;
    @SerializedName("subscriptionRestriction")
    @Nullable
    private final SubscriptionRestriction subscriptionRestriction;
    @SerializedName("tag")
    @Nullable
    private final String tag;
    @SerializedName("thumbnailURL")
    @Nullable
    private final String thumbnailURL;
    @SerializedName("title")
    @Nullable
    private final String title;
    @SerializedName("voucherOptionType")
    @Nullable
    private final VoucherOptionType voucherOptionType;
    @SerializedName("walletCredit")
    @Nullable
    private final Float walletCredit;

    public MarketPlaceBurnItemResponse() {
        this((String) null, (String) null, (Integer) null, (String) null, (String) null, (Integer) null, (Float) null, (String) null, (String) null, (String) null, (VoucherOptionType) null, (SubscriptionRestriction) null, (Integer) null, (Float) null, 16383, (DefaultConstructorMarker) null);
    }

    public MarketPlaceBurnItemResponse(@Nullable String str, @Nullable String str2, @Nullable Integer num, @Nullable String str3, @Nullable String str4, @Nullable Integer num2, @Nullable Float f11, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable VoucherOptionType voucherOptionType2, @Nullable SubscriptionRestriction subscriptionRestriction2, @Nullable Integer num3, @Nullable Float f12) {
        this.f60574id = str;
        this.title = str2;
        this.country = num;
        this.thumbnailURL = str3;
        this.imageURL = str4;
        this.pointsCost = num2;
        this.walletCredit = f11;
        this.burnOptionType = str5;
        this.description = str6;
        this.tag = str7;
        this.voucherOptionType = voucherOptionType2;
        this.subscriptionRestriction = subscriptionRestriction2;
        this.discountType = num3;
        this.discountValue = f12;
    }

    public static /* synthetic */ MarketPlaceBurnItemResponse copy$default(MarketPlaceBurnItemResponse marketPlaceBurnItemResponse, String str, String str2, Integer num, String str3, String str4, Integer num2, Float f11, String str5, String str6, String str7, VoucherOptionType voucherOptionType2, SubscriptionRestriction subscriptionRestriction2, Integer num3, Float f12, int i11, Object obj) {
        MarketPlaceBurnItemResponse marketPlaceBurnItemResponse2 = marketPlaceBurnItemResponse;
        int i12 = i11;
        return marketPlaceBurnItemResponse.copy((i12 & 1) != 0 ? marketPlaceBurnItemResponse2.f60574id : str, (i12 & 2) != 0 ? marketPlaceBurnItemResponse2.title : str2, (i12 & 4) != 0 ? marketPlaceBurnItemResponse2.country : num, (i12 & 8) != 0 ? marketPlaceBurnItemResponse2.thumbnailURL : str3, (i12 & 16) != 0 ? marketPlaceBurnItemResponse2.imageURL : str4, (i12 & 32) != 0 ? marketPlaceBurnItemResponse2.pointsCost : num2, (i12 & 64) != 0 ? marketPlaceBurnItemResponse2.walletCredit : f11, (i12 & 128) != 0 ? marketPlaceBurnItemResponse2.burnOptionType : str5, (i12 & 256) != 0 ? marketPlaceBurnItemResponse2.description : str6, (i12 & 512) != 0 ? marketPlaceBurnItemResponse2.tag : str7, (i12 & 1024) != 0 ? marketPlaceBurnItemResponse2.voucherOptionType : voucherOptionType2, (i12 & 2048) != 0 ? marketPlaceBurnItemResponse2.subscriptionRestriction : subscriptionRestriction2, (i12 & 4096) != 0 ? marketPlaceBurnItemResponse2.discountType : num3, (i12 & 8192) != 0 ? marketPlaceBurnItemResponse2.discountValue : f12);
    }

    @Nullable
    public final String component1() {
        return this.f60574id;
    }

    @Nullable
    public final String component10() {
        return this.tag;
    }

    @Nullable
    public final VoucherOptionType component11() {
        return this.voucherOptionType;
    }

    @Nullable
    public final SubscriptionRestriction component12() {
        return this.subscriptionRestriction;
    }

    @Nullable
    public final Integer component13() {
        return this.discountType;
    }

    @Nullable
    public final Float component14() {
        return this.discountValue;
    }

    @Nullable
    public final String component2() {
        return this.title;
    }

    @Nullable
    public final Integer component3() {
        return this.country;
    }

    @Nullable
    public final String component4() {
        return this.thumbnailURL;
    }

    @Nullable
    public final String component5() {
        return this.imageURL;
    }

    @Nullable
    public final Integer component6() {
        return this.pointsCost;
    }

    @Nullable
    public final Float component7() {
        return this.walletCredit;
    }

    @Nullable
    public final String component8() {
        return this.burnOptionType;
    }

    @Nullable
    public final String component9() {
        return this.description;
    }

    @NotNull
    public final MarketPlaceBurnItemResponse copy(@Nullable String str, @Nullable String str2, @Nullable Integer num, @Nullable String str3, @Nullable String str4, @Nullable Integer num2, @Nullable Float f11, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable VoucherOptionType voucherOptionType2, @Nullable SubscriptionRestriction subscriptionRestriction2, @Nullable Integer num3, @Nullable Float f12) {
        return new MarketPlaceBurnItemResponse(str, str2, num, str3, str4, num2, f11, str5, str6, str7, voucherOptionType2, subscriptionRestriction2, num3, f12);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MarketPlaceBurnItemResponse)) {
            return false;
        }
        MarketPlaceBurnItemResponse marketPlaceBurnItemResponse = (MarketPlaceBurnItemResponse) obj;
        return Intrinsics.areEqual((Object) this.f60574id, (Object) marketPlaceBurnItemResponse.f60574id) && Intrinsics.areEqual((Object) this.title, (Object) marketPlaceBurnItemResponse.title) && Intrinsics.areEqual((Object) this.country, (Object) marketPlaceBurnItemResponse.country) && Intrinsics.areEqual((Object) this.thumbnailURL, (Object) marketPlaceBurnItemResponse.thumbnailURL) && Intrinsics.areEqual((Object) this.imageURL, (Object) marketPlaceBurnItemResponse.imageURL) && Intrinsics.areEqual((Object) this.pointsCost, (Object) marketPlaceBurnItemResponse.pointsCost) && Intrinsics.areEqual((Object) this.walletCredit, (Object) marketPlaceBurnItemResponse.walletCredit) && Intrinsics.areEqual((Object) this.burnOptionType, (Object) marketPlaceBurnItemResponse.burnOptionType) && Intrinsics.areEqual((Object) this.description, (Object) marketPlaceBurnItemResponse.description) && Intrinsics.areEqual((Object) this.tag, (Object) marketPlaceBurnItemResponse.tag) && this.voucherOptionType == marketPlaceBurnItemResponse.voucherOptionType && this.subscriptionRestriction == marketPlaceBurnItemResponse.subscriptionRestriction && Intrinsics.areEqual((Object) this.discountType, (Object) marketPlaceBurnItemResponse.discountType) && Intrinsics.areEqual((Object) this.discountValue, (Object) marketPlaceBurnItemResponse.discountValue);
    }

    @Nullable
    public final String getBurnOptionType() {
        return this.burnOptionType;
    }

    @Nullable
    public final Integer getCountry() {
        return this.country;
    }

    @Nullable
    public final String getDescription() {
        return this.description;
    }

    @Nullable
    public final Integer getDiscountType() {
        return this.discountType;
    }

    @Nullable
    public final Float getDiscountValue() {
        return this.discountValue;
    }

    @Nullable
    public final String getId() {
        return this.f60574id;
    }

    @Nullable
    public final String getImageURL() {
        return this.imageURL;
    }

    @Nullable
    public final Integer getPointsCost() {
        return this.pointsCost;
    }

    @Nullable
    public final SubscriptionRestriction getSubscriptionRestriction() {
        return this.subscriptionRestriction;
    }

    @Nullable
    public final String getTag() {
        return this.tag;
    }

    @Nullable
    public final String getThumbnailURL() {
        return this.thumbnailURL;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    public final VoucherOptionType getVoucherOptionType() {
        return this.voucherOptionType;
    }

    @Nullable
    public final Float getWalletCredit() {
        return this.walletCredit;
    }

    public int hashCode() {
        String str = this.f60574id;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.title;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num = this.country;
        int hashCode3 = (hashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        String str3 = this.thumbnailURL;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.imageURL;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Integer num2 = this.pointsCost;
        int hashCode6 = (hashCode5 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Float f11 = this.walletCredit;
        int hashCode7 = (hashCode6 + (f11 == null ? 0 : f11.hashCode())) * 31;
        String str5 = this.burnOptionType;
        int hashCode8 = (hashCode7 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.description;
        int hashCode9 = (hashCode8 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.tag;
        int hashCode10 = (hashCode9 + (str7 == null ? 0 : str7.hashCode())) * 31;
        VoucherOptionType voucherOptionType2 = this.voucherOptionType;
        int hashCode11 = (hashCode10 + (voucherOptionType2 == null ? 0 : voucherOptionType2.hashCode())) * 31;
        SubscriptionRestriction subscriptionRestriction2 = this.subscriptionRestriction;
        int hashCode12 = (hashCode11 + (subscriptionRestriction2 == null ? 0 : subscriptionRestriction2.hashCode())) * 31;
        Integer num3 = this.discountType;
        int hashCode13 = (hashCode12 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Float f12 = this.discountValue;
        if (f12 != null) {
            i11 = f12.hashCode();
        }
        return hashCode13 + i11;
    }

    @NotNull
    public String toString() {
        String str = this.f60574id;
        String str2 = this.title;
        Integer num = this.country;
        String str3 = this.thumbnailURL;
        String str4 = this.imageURL;
        Integer num2 = this.pointsCost;
        Float f11 = this.walletCredit;
        String str5 = this.burnOptionType;
        String str6 = this.description;
        String str7 = this.tag;
        VoucherOptionType voucherOptionType2 = this.voucherOptionType;
        SubscriptionRestriction subscriptionRestriction2 = this.subscriptionRestriction;
        Integer num3 = this.discountType;
        Float f12 = this.discountValue;
        return "MarketPlaceBurnItemResponse(id=" + str + ", title=" + str2 + ", country=" + num + ", thumbnailURL=" + str3 + ", imageURL=" + str4 + ", pointsCost=" + num2 + ", walletCredit=" + f11 + ", burnOptionType=" + str5 + ", description=" + str6 + ", tag=" + str7 + ", voucherOptionType=" + voucherOptionType2 + ", subscriptionRestriction=" + subscriptionRestriction2 + ", discountType=" + num3 + ", discountValue=" + f12 + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ MarketPlaceBurnItemResponse(java.lang.String r16, java.lang.String r17, java.lang.Integer r18, java.lang.String r19, java.lang.String r20, java.lang.Integer r21, java.lang.Float r22, java.lang.String r23, java.lang.String r24, java.lang.String r25, com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.VoucherOptionType r26, com.talabat.growth.ui.loyalty.burn.models.SubscriptionRestriction r27, java.lang.Integer r28, java.lang.Float r29, int r30, kotlin.jvm.internal.DefaultConstructorMarker r31) {
        /*
            r15 = this;
            r0 = r30
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = r2
            goto L_0x000b
        L_0x0009:
            r1 = r16
        L_0x000b:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0011
            r3 = r2
            goto L_0x0013
        L_0x0011:
            r3 = r17
        L_0x0013:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0019
            r4 = r2
            goto L_0x001b
        L_0x0019:
            r4 = r18
        L_0x001b:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x0021
            r5 = r2
            goto L_0x0023
        L_0x0021:
            r5 = r19
        L_0x0023:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0029
            r6 = r2
            goto L_0x002b
        L_0x0029:
            r6 = r20
        L_0x002b:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x0031
            r7 = r2
            goto L_0x0033
        L_0x0031:
            r7 = r21
        L_0x0033:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x003d
            r8 = 0
            java.lang.Float r8 = java.lang.Float.valueOf(r8)
            goto L_0x003f
        L_0x003d:
            r8 = r22
        L_0x003f:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x0045
            r9 = r2
            goto L_0x0047
        L_0x0045:
            r9 = r23
        L_0x0047:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x004d
            r10 = r2
            goto L_0x004f
        L_0x004d:
            r10 = r24
        L_0x004f:
            r11 = r0 & 512(0x200, float:7.175E-43)
            if (r11 == 0) goto L_0x0055
            r11 = r2
            goto L_0x0057
        L_0x0055:
            r11 = r25
        L_0x0057:
            r12 = r0 & 1024(0x400, float:1.435E-42)
            if (r12 == 0) goto L_0x005d
            r12 = r2
            goto L_0x005f
        L_0x005d:
            r12 = r26
        L_0x005f:
            r13 = r0 & 2048(0x800, float:2.87E-42)
            if (r13 == 0) goto L_0x0065
            r13 = r2
            goto L_0x0067
        L_0x0065:
            r13 = r27
        L_0x0067:
            r14 = r0 & 4096(0x1000, float:5.74E-42)
            if (r14 == 0) goto L_0x006d
            r14 = r2
            goto L_0x006f
        L_0x006d:
            r14 = r28
        L_0x006f:
            r0 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r0 == 0) goto L_0x0074
            goto L_0x0076
        L_0x0074:
            r2 = r29
        L_0x0076:
            r16 = r15
            r17 = r1
            r18 = r3
            r19 = r4
            r20 = r5
            r21 = r6
            r22 = r7
            r23 = r8
            r24 = r9
            r25 = r10
            r26 = r11
            r27 = r12
            r28 = r13
            r29 = r14
            r30 = r2
            r16.<init>(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.growth.features.matketPlace.model.response.MarketPlaceBurnItemResponse.<init>(java.lang.String, java.lang.String, java.lang.Integer, java.lang.String, java.lang.String, java.lang.Integer, java.lang.Float, java.lang.String, java.lang.String, java.lang.String, com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.VoucherOptionType, com.talabat.growth.ui.loyalty.burn.models.SubscriptionRestriction, java.lang.Integer, java.lang.Float, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
