package com.talabat.feature.swimlanevoucherslist.data.model;

import com.squareup.moshi.Json;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.bytebuddy.asm.Advice;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\bD\b\b\u0018\u00002\u00020\u0001BÅ\u0001\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0003\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\r\u0012\u0010\b\u0003\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\r\u0012\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0003\u0010\u0014\u001a\u0004\u0018\u00010\t\u0012\n\b\u0003\u0010\u0015\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0016J\u000b\u0010B\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010C\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\rHÆ\u0003J\u0010\u0010D\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010 J\u000b\u0010E\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010F\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0002\u0010.J\u0010\u0010G\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010)J\u000b\u0010H\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010L\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010M\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010)J\u000b\u0010N\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010O\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010P\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\rHÆ\u0003JÎ\u0001\u0010Q\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u00032\u0010\b\u0003\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\r2\u0010\b\u0003\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\r2\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0003\u0010\u0014\u001a\u0004\u0018\u00010\t2\n\b\u0003\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010RJ\u0013\u0010S\u001a\u00020\u00102\b\u0010T\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010U\u001a\u00020\u0013HÖ\u0001J\t\u0010V\u001a\u00020\u0003HÖ\u0001R\"\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0010\n\u0002\u0010#\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u001c\"\u0004\b%\u0010\u001eR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u001c\"\u0004\b'\u0010\u001eR\u001e\u0010\u0014\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0010\n\u0002\u0010,\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0010\n\u0002\u00101\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001e\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0010\n\u0002\u0010,\u001a\u0004\b2\u0010)\"\u0004\b3\u0010+R\"\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u0018\"\u0004\b5\u0010\u001aR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u001c\"\u0004\b7\u0010\u001eR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u001c\"\u0004\b9\u0010\u001eR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u001c\"\u0004\b;\u0010\u001eR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\u001c\"\u0004\b=\u0010\u001eR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\u001c\"\u0004\b?\u0010\u001eR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u001c\"\u0004\bA\u0010\u001e¨\u0006W"}, d2 = {"Lcom/talabat/feature/swimlanevoucherslist/data/model/QCSwimLaneVouchers;", "", "voucherName", "", "title", "subtitle", "image", "id", "minimumOrderValue", "", "voucherType", "validTill", "skuIds", "", "categoryIds", "excludeCategories", "", "termsAndConditions", "maxUsage", "", "maxSaving", "discountType", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/String;)V", "getCategoryIds", "()Ljava/util/List;", "setCategoryIds", "(Ljava/util/List;)V", "getDiscountType", "()Ljava/lang/String;", "setDiscountType", "(Ljava/lang/String;)V", "getExcludeCategories", "()Ljava/lang/Boolean;", "setExcludeCategories", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getId", "setId", "getImage", "setImage", "getMaxSaving", "()Ljava/lang/Double;", "setMaxSaving", "(Ljava/lang/Double;)V", "Ljava/lang/Double;", "getMaxUsage", "()Ljava/lang/Integer;", "setMaxUsage", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getMinimumOrderValue", "setMinimumOrderValue", "getSkuIds", "setSkuIds", "getSubtitle", "setSubtitle", "getTermsAndConditions", "setTermsAndConditions", "getTitle", "setTitle", "getValidTill", "setValidTill", "getVoucherName", "setVoucherName", "getVoucherType", "setVoucherType", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/String;)Lcom/talabat/feature/swimlanevoucherslist/data/model/QCSwimLaneVouchers;", "equals", "other", "hashCode", "toString", "com_talabat_feature_customer-vouchers-swimlane_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class QCSwimLaneVouchers {
    @Nullable
    private List<String> categoryIds;
    @Nullable
    private String discountType;
    @Nullable
    private Boolean excludeCategories;
    @Nullable

    /* renamed from: id  reason: collision with root package name */
    private String f59018id;
    @Nullable
    private String image;
    @Nullable
    private Double maxSaving;
    @Nullable
    private Integer maxUsage;
    @Nullable
    private Double minimumOrderValue;
    @Nullable
    private List<String> skuIds;
    @Nullable
    private String subtitle;
    @Nullable
    private String termsAndConditions;
    @Nullable
    private String title;
    @Nullable
    private String validTill;
    @Nullable
    private String voucherName;
    @Nullable
    private String voucherType;

    public QCSwimLaneVouchers() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (Double) null, (String) null, (String) null, (List) null, (List) null, (Boolean) null, (String) null, (Integer) null, (Double) null, (String) null, Advice.MethodSizeHandler.UNDEFINED_SIZE, (DefaultConstructorMarker) null);
    }

    public QCSwimLaneVouchers(@Nullable @Json(name = "campaignTitle") String str, @Nullable @Json(name = "swimlaneTitle") String str2, @Nullable @Json(name = "swimlaneSubtitle") String str3, @Nullable @Json(name = "imageUrl") String str4, @Nullable @Json(name = "id") String str5, @Nullable @Json(name = "minimumOrderValue") Double d11, @Nullable @Json(name = "displayType") String str6, @Nullable @Json(name = "validTill") String str7, @Nullable @Json(name = "skuIds") List<String> list, @Nullable @Json(name = "categoryIds") List<String> list2, @Nullable @Json(name = "excludeCategories") Boolean bool, @Nullable @Json(name = "termsAndConditions") String str8, @Nullable @Json(name = "maxUsage") Integer num, @Nullable @Json(name = "maxSaving") Double d12, @Nullable @Json(name = "discountType") String str9) {
        this.voucherName = str;
        this.title = str2;
        this.subtitle = str3;
        this.image = str4;
        this.f59018id = str5;
        this.minimumOrderValue = d11;
        this.voucherType = str6;
        this.validTill = str7;
        this.skuIds = list;
        this.categoryIds = list2;
        this.excludeCategories = bool;
        this.termsAndConditions = str8;
        this.maxUsage = num;
        this.maxSaving = d12;
        this.discountType = str9;
    }

    public static /* synthetic */ QCSwimLaneVouchers copy$default(QCSwimLaneVouchers qCSwimLaneVouchers, String str, String str2, String str3, String str4, String str5, Double d11, String str6, String str7, List list, List list2, Boolean bool, String str8, Integer num, Double d12, String str9, int i11, Object obj) {
        QCSwimLaneVouchers qCSwimLaneVouchers2 = qCSwimLaneVouchers;
        int i12 = i11;
        return qCSwimLaneVouchers.copy((i12 & 1) != 0 ? qCSwimLaneVouchers2.voucherName : str, (i12 & 2) != 0 ? qCSwimLaneVouchers2.title : str2, (i12 & 4) != 0 ? qCSwimLaneVouchers2.subtitle : str3, (i12 & 8) != 0 ? qCSwimLaneVouchers2.image : str4, (i12 & 16) != 0 ? qCSwimLaneVouchers2.f59018id : str5, (i12 & 32) != 0 ? qCSwimLaneVouchers2.minimumOrderValue : d11, (i12 & 64) != 0 ? qCSwimLaneVouchers2.voucherType : str6, (i12 & 128) != 0 ? qCSwimLaneVouchers2.validTill : str7, (i12 & 256) != 0 ? qCSwimLaneVouchers2.skuIds : list, (i12 & 512) != 0 ? qCSwimLaneVouchers2.categoryIds : list2, (i12 & 1024) != 0 ? qCSwimLaneVouchers2.excludeCategories : bool, (i12 & 2048) != 0 ? qCSwimLaneVouchers2.termsAndConditions : str8, (i12 & 4096) != 0 ? qCSwimLaneVouchers2.maxUsage : num, (i12 & 8192) != 0 ? qCSwimLaneVouchers2.maxSaving : d12, (i12 & 16384) != 0 ? qCSwimLaneVouchers2.discountType : str9);
    }

    @Nullable
    public final String component1() {
        return this.voucherName;
    }

    @Nullable
    public final List<String> component10() {
        return this.categoryIds;
    }

    @Nullable
    public final Boolean component11() {
        return this.excludeCategories;
    }

    @Nullable
    public final String component12() {
        return this.termsAndConditions;
    }

    @Nullable
    public final Integer component13() {
        return this.maxUsage;
    }

    @Nullable
    public final Double component14() {
        return this.maxSaving;
    }

    @Nullable
    public final String component15() {
        return this.discountType;
    }

    @Nullable
    public final String component2() {
        return this.title;
    }

    @Nullable
    public final String component3() {
        return this.subtitle;
    }

    @Nullable
    public final String component4() {
        return this.image;
    }

    @Nullable
    public final String component5() {
        return this.f59018id;
    }

    @Nullable
    public final Double component6() {
        return this.minimumOrderValue;
    }

    @Nullable
    public final String component7() {
        return this.voucherType;
    }

    @Nullable
    public final String component8() {
        return this.validTill;
    }

    @Nullable
    public final List<String> component9() {
        return this.skuIds;
    }

    @NotNull
    public final QCSwimLaneVouchers copy(@Nullable @Json(name = "campaignTitle") String str, @Nullable @Json(name = "swimlaneTitle") String str2, @Nullable @Json(name = "swimlaneSubtitle") String str3, @Nullable @Json(name = "imageUrl") String str4, @Nullable @Json(name = "id") String str5, @Nullable @Json(name = "minimumOrderValue") Double d11, @Nullable @Json(name = "displayType") String str6, @Nullable @Json(name = "validTill") String str7, @Nullable @Json(name = "skuIds") List<String> list, @Nullable @Json(name = "categoryIds") List<String> list2, @Nullable @Json(name = "excludeCategories") Boolean bool, @Nullable @Json(name = "termsAndConditions") String str8, @Nullable @Json(name = "maxUsage") Integer num, @Nullable @Json(name = "maxSaving") Double d12, @Nullable @Json(name = "discountType") String str9) {
        return new QCSwimLaneVouchers(str, str2, str3, str4, str5, d11, str6, str7, list, list2, bool, str8, num, d12, str9);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof QCSwimLaneVouchers)) {
            return false;
        }
        QCSwimLaneVouchers qCSwimLaneVouchers = (QCSwimLaneVouchers) obj;
        return Intrinsics.areEqual((Object) this.voucherName, (Object) qCSwimLaneVouchers.voucherName) && Intrinsics.areEqual((Object) this.title, (Object) qCSwimLaneVouchers.title) && Intrinsics.areEqual((Object) this.subtitle, (Object) qCSwimLaneVouchers.subtitle) && Intrinsics.areEqual((Object) this.image, (Object) qCSwimLaneVouchers.image) && Intrinsics.areEqual((Object) this.f59018id, (Object) qCSwimLaneVouchers.f59018id) && Intrinsics.areEqual((Object) this.minimumOrderValue, (Object) qCSwimLaneVouchers.minimumOrderValue) && Intrinsics.areEqual((Object) this.voucherType, (Object) qCSwimLaneVouchers.voucherType) && Intrinsics.areEqual((Object) this.validTill, (Object) qCSwimLaneVouchers.validTill) && Intrinsics.areEqual((Object) this.skuIds, (Object) qCSwimLaneVouchers.skuIds) && Intrinsics.areEqual((Object) this.categoryIds, (Object) qCSwimLaneVouchers.categoryIds) && Intrinsics.areEqual((Object) this.excludeCategories, (Object) qCSwimLaneVouchers.excludeCategories) && Intrinsics.areEqual((Object) this.termsAndConditions, (Object) qCSwimLaneVouchers.termsAndConditions) && Intrinsics.areEqual((Object) this.maxUsage, (Object) qCSwimLaneVouchers.maxUsage) && Intrinsics.areEqual((Object) this.maxSaving, (Object) qCSwimLaneVouchers.maxSaving) && Intrinsics.areEqual((Object) this.discountType, (Object) qCSwimLaneVouchers.discountType);
    }

    @Nullable
    public final List<String> getCategoryIds() {
        return this.categoryIds;
    }

    @Nullable
    public final String getDiscountType() {
        return this.discountType;
    }

    @Nullable
    public final Boolean getExcludeCategories() {
        return this.excludeCategories;
    }

    @Nullable
    public final String getId() {
        return this.f59018id;
    }

    @Nullable
    public final String getImage() {
        return this.image;
    }

    @Nullable
    public final Double getMaxSaving() {
        return this.maxSaving;
    }

    @Nullable
    public final Integer getMaxUsage() {
        return this.maxUsage;
    }

    @Nullable
    public final Double getMinimumOrderValue() {
        return this.minimumOrderValue;
    }

    @Nullable
    public final List<String> getSkuIds() {
        return this.skuIds;
    }

    @Nullable
    public final String getSubtitle() {
        return this.subtitle;
    }

    @Nullable
    public final String getTermsAndConditions() {
        return this.termsAndConditions;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    public final String getValidTill() {
        return this.validTill;
    }

    @Nullable
    public final String getVoucherName() {
        return this.voucherName;
    }

    @Nullable
    public final String getVoucherType() {
        return this.voucherType;
    }

    public int hashCode() {
        String str = this.voucherName;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.title;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.subtitle;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.image;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.f59018id;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        Double d11 = this.minimumOrderValue;
        int hashCode6 = (hashCode5 + (d11 == null ? 0 : d11.hashCode())) * 31;
        String str6 = this.voucherType;
        int hashCode7 = (hashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.validTill;
        int hashCode8 = (hashCode7 + (str7 == null ? 0 : str7.hashCode())) * 31;
        List<String> list = this.skuIds;
        int hashCode9 = (hashCode8 + (list == null ? 0 : list.hashCode())) * 31;
        List<String> list2 = this.categoryIds;
        int hashCode10 = (hashCode9 + (list2 == null ? 0 : list2.hashCode())) * 31;
        Boolean bool = this.excludeCategories;
        int hashCode11 = (hashCode10 + (bool == null ? 0 : bool.hashCode())) * 31;
        String str8 = this.termsAndConditions;
        int hashCode12 = (hashCode11 + (str8 == null ? 0 : str8.hashCode())) * 31;
        Integer num = this.maxUsage;
        int hashCode13 = (hashCode12 + (num == null ? 0 : num.hashCode())) * 31;
        Double d12 = this.maxSaving;
        int hashCode14 = (hashCode13 + (d12 == null ? 0 : d12.hashCode())) * 31;
        String str9 = this.discountType;
        if (str9 != null) {
            i11 = str9.hashCode();
        }
        return hashCode14 + i11;
    }

    public final void setCategoryIds(@Nullable List<String> list) {
        this.categoryIds = list;
    }

    public final void setDiscountType(@Nullable String str) {
        this.discountType = str;
    }

    public final void setExcludeCategories(@Nullable Boolean bool) {
        this.excludeCategories = bool;
    }

    public final void setId(@Nullable String str) {
        this.f59018id = str;
    }

    public final void setImage(@Nullable String str) {
        this.image = str;
    }

    public final void setMaxSaving(@Nullable Double d11) {
        this.maxSaving = d11;
    }

    public final void setMaxUsage(@Nullable Integer num) {
        this.maxUsage = num;
    }

    public final void setMinimumOrderValue(@Nullable Double d11) {
        this.minimumOrderValue = d11;
    }

    public final void setSkuIds(@Nullable List<String> list) {
        this.skuIds = list;
    }

    public final void setSubtitle(@Nullable String str) {
        this.subtitle = str;
    }

    public final void setTermsAndConditions(@Nullable String str) {
        this.termsAndConditions = str;
    }

    public final void setTitle(@Nullable String str) {
        this.title = str;
    }

    public final void setValidTill(@Nullable String str) {
        this.validTill = str;
    }

    public final void setVoucherName(@Nullable String str) {
        this.voucherName = str;
    }

    public final void setVoucherType(@Nullable String str) {
        this.voucherType = str;
    }

    @NotNull
    public String toString() {
        String str = this.voucherName;
        String str2 = this.title;
        String str3 = this.subtitle;
        String str4 = this.image;
        String str5 = this.f59018id;
        Double d11 = this.minimumOrderValue;
        String str6 = this.voucherType;
        String str7 = this.validTill;
        List<String> list = this.skuIds;
        List<String> list2 = this.categoryIds;
        Boolean bool = this.excludeCategories;
        String str8 = this.termsAndConditions;
        Integer num = this.maxUsage;
        Double d12 = this.maxSaving;
        String str9 = this.discountType;
        return "QCSwimLaneVouchers(voucherName=" + str + ", title=" + str2 + ", subtitle=" + str3 + ", image=" + str4 + ", id=" + str5 + ", minimumOrderValue=" + d11 + ", voucherType=" + str6 + ", validTill=" + str7 + ", skuIds=" + list + ", categoryIds=" + list2 + ", excludeCategories=" + bool + ", termsAndConditions=" + str8 + ", maxUsage=" + num + ", maxSaving=" + d12 + ", discountType=" + str9 + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ QCSwimLaneVouchers(java.lang.String r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, java.lang.String r21, java.lang.Double r22, java.lang.String r23, java.lang.String r24, java.util.List r25, java.util.List r26, java.lang.Boolean r27, java.lang.String r28, java.lang.Integer r29, java.lang.Double r30, java.lang.String r31, int r32, kotlin.jvm.internal.DefaultConstructorMarker r33) {
        /*
            r16 = this;
            r0 = r32
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = r2
            goto L_0x000b
        L_0x0009:
            r1 = r17
        L_0x000b:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0011
            r3 = r2
            goto L_0x0013
        L_0x0011:
            r3 = r18
        L_0x0013:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0019
            r4 = r2
            goto L_0x001b
        L_0x0019:
            r4 = r19
        L_0x001b:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x0021
            r5 = r2
            goto L_0x0023
        L_0x0021:
            r5 = r20
        L_0x0023:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0029
            r6 = r2
            goto L_0x002b
        L_0x0029:
            r6 = r21
        L_0x002b:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x0031
            r7 = r2
            goto L_0x0033
        L_0x0031:
            r7 = r22
        L_0x0033:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0039
            r8 = r2
            goto L_0x003b
        L_0x0039:
            r8 = r23
        L_0x003b:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x0041
            r9 = r2
            goto L_0x0043
        L_0x0041:
            r9 = r24
        L_0x0043:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x004d
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            goto L_0x004f
        L_0x004d:
            r10 = r25
        L_0x004f:
            r11 = r0 & 512(0x200, float:7.175E-43)
            if (r11 == 0) goto L_0x0059
            java.util.ArrayList r11 = new java.util.ArrayList
            r11.<init>()
            goto L_0x005b
        L_0x0059:
            r11 = r26
        L_0x005b:
            r12 = r0 & 1024(0x400, float:1.435E-42)
            if (r12 == 0) goto L_0x0061
            r12 = r2
            goto L_0x0063
        L_0x0061:
            r12 = r27
        L_0x0063:
            r13 = r0 & 2048(0x800, float:2.87E-42)
            if (r13 == 0) goto L_0x0069
            r13 = r2
            goto L_0x006b
        L_0x0069:
            r13 = r28
        L_0x006b:
            r14 = r0 & 4096(0x1000, float:5.74E-42)
            if (r14 == 0) goto L_0x0071
            r14 = r2
            goto L_0x0073
        L_0x0071:
            r14 = r29
        L_0x0073:
            r15 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r15 == 0) goto L_0x0079
            r15 = r2
            goto L_0x007b
        L_0x0079:
            r15 = r30
        L_0x007b:
            r0 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r0 == 0) goto L_0x0080
            goto L_0x0082
        L_0x0080:
            r2 = r31
        L_0x0082:
            r17 = r16
            r18 = r1
            r19 = r3
            r20 = r4
            r21 = r5
            r22 = r6
            r23 = r7
            r24 = r8
            r25 = r9
            r26 = r10
            r27 = r11
            r28 = r12
            r29 = r13
            r30 = r14
            r31 = r15
            r32 = r2
            r17.<init>(r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.swimlanevoucherslist.data.model.QCSwimLaneVouchers.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Double, java.lang.String, java.lang.String, java.util.List, java.util.List, java.lang.Boolean, java.lang.String, java.lang.Integer, java.lang.Double, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
