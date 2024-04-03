package com.talabat.talabatcommon.feature.darkstores.lookingGlass.model.response;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.bytebuddy.asm.Advice;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\bD\b\b\u0018\u00002\u00020\u0001BË\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\n\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\n\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0017J\u000b\u0010B\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010C\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010!J\u0011\u0010D\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\nHÆ\u0003J\u0010\u0010E\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0002\u0010-J\u0011\u0010F\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\nHÆ\u0003J\u0010\u0010G\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010!J\u000b\u0010H\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010L\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010M\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010N\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nHÆ\u0003J\u0010\u0010O\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u00104J\u0010\u0010P\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u00104JÔ\u0001\u0010Q\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\n2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\n2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010RJ\u0013\u0010S\u001a\u00020\u00132\b\u0010T\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010U\u001a\u00020\u0010HÖ\u0001J\t\u0010V\u001a\u00020\u0003HÖ\u0001R&\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\n8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR \u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010\u0015\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010$\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R \u0010\u0016\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u001d\"\u0004\b&\u0010\u001fR \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u001d\"\u0004\b(\u0010\u001fR \u0010\b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u001d\"\u0004\b*\u0010\u001fR&\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0019\"\u0004\b,\u0010\u001bR\"\u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u00100\u001a\u0004\b\u0012\u0010-\"\u0004\b.\u0010/R \u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u001d\"\u0004\b2\u0010\u001fR\"\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u00107\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\"\u0010\f\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u00107\u001a\u0004\b8\u00104\"\u0004\b9\u00106R\"\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010$\u001a\u0004\b:\u0010!\"\u0004\b;\u0010#R&\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\n8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\u0019\"\u0004\b=\u0010\u001bR \u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\u001d\"\u0004\b?\u0010\u001fR \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u001d\"\u0004\bA\u0010\u001f¨\u0006W"}, d2 = {"Lcom/talabat/talabatcommon/feature/darkstores/lookingGlass/model/response/GlassItem;", "", "id", "", "vendorId", "trackingCode", "name", "description", "imageUrl", "imageUrls", "", "Lcom/talabat/talabatcommon/feature/darkstores/lookingGlass/model/response/GImageUrl;", "price", "", "originalPrice", "stockAmount", "", "tags", "isAvailable", "", "attributes", "discount", "discountText", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/Boolean;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/String;)V", "getAttributes", "()Ljava/util/List;", "setAttributes", "(Ljava/util/List;)V", "getDescription", "()Ljava/lang/String;", "setDescription", "(Ljava/lang/String;)V", "getDiscount", "()Ljava/lang/Integer;", "setDiscount", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getDiscountText", "setDiscountText", "getId", "setId", "getImageUrl", "setImageUrl", "getImageUrls", "setImageUrls", "()Ljava/lang/Boolean;", "setAvailable", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getName", "setName", "getOriginalPrice", "()Ljava/lang/Double;", "setOriginalPrice", "(Ljava/lang/Double;)V", "Ljava/lang/Double;", "getPrice", "setPrice", "getStockAmount", "setStockAmount", "getTags", "setTags", "getTrackingCode", "setTrackingCode", "getVendorId", "setVendorId", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/Boolean;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/String;)Lcom/talabat/talabatcommon/feature/darkstores/lookingGlass/model/response/GlassItem;", "equals", "other", "hashCode", "toString", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GlassItem {
    @SerializedName("attributes")
    @Nullable
    private List<? extends Object> attributes;
    @SerializedName("description")
    @Nullable
    private String description;
    @SerializedName("discount")
    @Nullable
    private Integer discount;
    @SerializedName("discount_text")
    @Nullable
    private String discountText;
    @SerializedName("id")
    @Nullable

    /* renamed from: id  reason: collision with root package name */
    private String f61550id;
    @SerializedName("image_url")
    @Nullable
    private String imageUrl;
    @SerializedName("image_urls")
    @Nullable
    private List<GImageUrl> imageUrls;
    @SerializedName("is_available")
    @Nullable
    private Boolean isAvailable;
    @SerializedName("name")
    @Nullable

    /* renamed from: name  reason: collision with root package name */
    private String f61551name;
    @SerializedName("original_price")
    @Nullable
    private Double originalPrice;
    @SerializedName("price")
    @Nullable
    private Double price;
    @SerializedName("stock_amount")
    @Nullable
    private Integer stockAmount;
    @SerializedName("tags")
    @Nullable
    private List<String> tags;
    @SerializedName("tracking_code")
    @Nullable
    private String trackingCode;
    @SerializedName("vendor_id")
    @Nullable
    private String vendorId;

    public GlassItem() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (List) null, (Double) null, (Double) null, (Integer) null, (List) null, (Boolean) null, (List) null, (Integer) null, (String) null, Advice.MethodSizeHandler.UNDEFINED_SIZE, (DefaultConstructorMarker) null);
    }

    public GlassItem(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable List<GImageUrl> list, @Nullable Double d11, @Nullable Double d12, @Nullable Integer num, @Nullable List<String> list2, @Nullable Boolean bool, @Nullable List<? extends Object> list3, @Nullable Integer num2, @Nullable String str7) {
        this.f61550id = str;
        this.vendorId = str2;
        this.trackingCode = str3;
        this.f61551name = str4;
        this.description = str5;
        this.imageUrl = str6;
        this.imageUrls = list;
        this.price = d11;
        this.originalPrice = d12;
        this.stockAmount = num;
        this.tags = list2;
        this.isAvailable = bool;
        this.attributes = list3;
        this.discount = num2;
        this.discountText = str7;
    }

    public static /* synthetic */ GlassItem copy$default(GlassItem glassItem, String str, String str2, String str3, String str4, String str5, String str6, List list, Double d11, Double d12, Integer num, List list2, Boolean bool, List list3, Integer num2, String str7, int i11, Object obj) {
        GlassItem glassItem2 = glassItem;
        int i12 = i11;
        return glassItem.copy((i12 & 1) != 0 ? glassItem2.f61550id : str, (i12 & 2) != 0 ? glassItem2.vendorId : str2, (i12 & 4) != 0 ? glassItem2.trackingCode : str3, (i12 & 8) != 0 ? glassItem2.f61551name : str4, (i12 & 16) != 0 ? glassItem2.description : str5, (i12 & 32) != 0 ? glassItem2.imageUrl : str6, (i12 & 64) != 0 ? glassItem2.imageUrls : list, (i12 & 128) != 0 ? glassItem2.price : d11, (i12 & 256) != 0 ? glassItem2.originalPrice : d12, (i12 & 512) != 0 ? glassItem2.stockAmount : num, (i12 & 1024) != 0 ? glassItem2.tags : list2, (i12 & 2048) != 0 ? glassItem2.isAvailable : bool, (i12 & 4096) != 0 ? glassItem2.attributes : list3, (i12 & 8192) != 0 ? glassItem2.discount : num2, (i12 & 16384) != 0 ? glassItem2.discountText : str7);
    }

    @Nullable
    public final String component1() {
        return this.f61550id;
    }

    @Nullable
    public final Integer component10() {
        return this.stockAmount;
    }

    @Nullable
    public final List<String> component11() {
        return this.tags;
    }

    @Nullable
    public final Boolean component12() {
        return this.isAvailable;
    }

    @Nullable
    public final List<Object> component13() {
        return this.attributes;
    }

    @Nullable
    public final Integer component14() {
        return this.discount;
    }

    @Nullable
    public final String component15() {
        return this.discountText;
    }

    @Nullable
    public final String component2() {
        return this.vendorId;
    }

    @Nullable
    public final String component3() {
        return this.trackingCode;
    }

    @Nullable
    public final String component4() {
        return this.f61551name;
    }

    @Nullable
    public final String component5() {
        return this.description;
    }

    @Nullable
    public final String component6() {
        return this.imageUrl;
    }

    @Nullable
    public final List<GImageUrl> component7() {
        return this.imageUrls;
    }

    @Nullable
    public final Double component8() {
        return this.price;
    }

    @Nullable
    public final Double component9() {
        return this.originalPrice;
    }

    @NotNull
    public final GlassItem copy(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable List<GImageUrl> list, @Nullable Double d11, @Nullable Double d12, @Nullable Integer num, @Nullable List<String> list2, @Nullable Boolean bool, @Nullable List<? extends Object> list3, @Nullable Integer num2, @Nullable String str7) {
        return new GlassItem(str, str2, str3, str4, str5, str6, list, d11, d12, num, list2, bool, list3, num2, str7);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GlassItem)) {
            return false;
        }
        GlassItem glassItem = (GlassItem) obj;
        return Intrinsics.areEqual((Object) this.f61550id, (Object) glassItem.f61550id) && Intrinsics.areEqual((Object) this.vendorId, (Object) glassItem.vendorId) && Intrinsics.areEqual((Object) this.trackingCode, (Object) glassItem.trackingCode) && Intrinsics.areEqual((Object) this.f61551name, (Object) glassItem.f61551name) && Intrinsics.areEqual((Object) this.description, (Object) glassItem.description) && Intrinsics.areEqual((Object) this.imageUrl, (Object) glassItem.imageUrl) && Intrinsics.areEqual((Object) this.imageUrls, (Object) glassItem.imageUrls) && Intrinsics.areEqual((Object) this.price, (Object) glassItem.price) && Intrinsics.areEqual((Object) this.originalPrice, (Object) glassItem.originalPrice) && Intrinsics.areEqual((Object) this.stockAmount, (Object) glassItem.stockAmount) && Intrinsics.areEqual((Object) this.tags, (Object) glassItem.tags) && Intrinsics.areEqual((Object) this.isAvailable, (Object) glassItem.isAvailable) && Intrinsics.areEqual((Object) this.attributes, (Object) glassItem.attributes) && Intrinsics.areEqual((Object) this.discount, (Object) glassItem.discount) && Intrinsics.areEqual((Object) this.discountText, (Object) glassItem.discountText);
    }

    @Nullable
    public final List<Object> getAttributes() {
        return this.attributes;
    }

    @Nullable
    public final String getDescription() {
        return this.description;
    }

    @Nullable
    public final Integer getDiscount() {
        return this.discount;
    }

    @Nullable
    public final String getDiscountText() {
        return this.discountText;
    }

    @Nullable
    public final String getId() {
        return this.f61550id;
    }

    @Nullable
    public final String getImageUrl() {
        return this.imageUrl;
    }

    @Nullable
    public final List<GImageUrl> getImageUrls() {
        return this.imageUrls;
    }

    @Nullable
    public final String getName() {
        return this.f61551name;
    }

    @Nullable
    public final Double getOriginalPrice() {
        return this.originalPrice;
    }

    @Nullable
    public final Double getPrice() {
        return this.price;
    }

    @Nullable
    public final Integer getStockAmount() {
        return this.stockAmount;
    }

    @Nullable
    public final List<String> getTags() {
        return this.tags;
    }

    @Nullable
    public final String getTrackingCode() {
        return this.trackingCode;
    }

    @Nullable
    public final String getVendorId() {
        return this.vendorId;
    }

    public int hashCode() {
        String str = this.f61550id;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.vendorId;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.trackingCode;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.f61551name;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.description;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.imageUrl;
        int hashCode6 = (hashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        List<GImageUrl> list = this.imageUrls;
        int hashCode7 = (hashCode6 + (list == null ? 0 : list.hashCode())) * 31;
        Double d11 = this.price;
        int hashCode8 = (hashCode7 + (d11 == null ? 0 : d11.hashCode())) * 31;
        Double d12 = this.originalPrice;
        int hashCode9 = (hashCode8 + (d12 == null ? 0 : d12.hashCode())) * 31;
        Integer num = this.stockAmount;
        int hashCode10 = (hashCode9 + (num == null ? 0 : num.hashCode())) * 31;
        List<String> list2 = this.tags;
        int hashCode11 = (hashCode10 + (list2 == null ? 0 : list2.hashCode())) * 31;
        Boolean bool = this.isAvailable;
        int hashCode12 = (hashCode11 + (bool == null ? 0 : bool.hashCode())) * 31;
        List<? extends Object> list3 = this.attributes;
        int hashCode13 = (hashCode12 + (list3 == null ? 0 : list3.hashCode())) * 31;
        Integer num2 = this.discount;
        int hashCode14 = (hashCode13 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str7 = this.discountText;
        if (str7 != null) {
            i11 = str7.hashCode();
        }
        return hashCode14 + i11;
    }

    @Nullable
    public final Boolean isAvailable() {
        return this.isAvailable;
    }

    public final void setAttributes(@Nullable List<? extends Object> list) {
        this.attributes = list;
    }

    public final void setAvailable(@Nullable Boolean bool) {
        this.isAvailable = bool;
    }

    public final void setDescription(@Nullable String str) {
        this.description = str;
    }

    public final void setDiscount(@Nullable Integer num) {
        this.discount = num;
    }

    public final void setDiscountText(@Nullable String str) {
        this.discountText = str;
    }

    public final void setId(@Nullable String str) {
        this.f61550id = str;
    }

    public final void setImageUrl(@Nullable String str) {
        this.imageUrl = str;
    }

    public final void setImageUrls(@Nullable List<GImageUrl> list) {
        this.imageUrls = list;
    }

    public final void setName(@Nullable String str) {
        this.f61551name = str;
    }

    public final void setOriginalPrice(@Nullable Double d11) {
        this.originalPrice = d11;
    }

    public final void setPrice(@Nullable Double d11) {
        this.price = d11;
    }

    public final void setStockAmount(@Nullable Integer num) {
        this.stockAmount = num;
    }

    public final void setTags(@Nullable List<String> list) {
        this.tags = list;
    }

    public final void setTrackingCode(@Nullable String str) {
        this.trackingCode = str;
    }

    public final void setVendorId(@Nullable String str) {
        this.vendorId = str;
    }

    @NotNull
    public String toString() {
        String str = this.f61550id;
        String str2 = this.vendorId;
        String str3 = this.trackingCode;
        String str4 = this.f61551name;
        String str5 = this.description;
        String str6 = this.imageUrl;
        List<GImageUrl> list = this.imageUrls;
        Double d11 = this.price;
        Double d12 = this.originalPrice;
        Integer num = this.stockAmount;
        List<String> list2 = this.tags;
        Boolean bool = this.isAvailable;
        List<? extends Object> list3 = this.attributes;
        Integer num2 = this.discount;
        String str7 = this.discountText;
        return "GlassItem(id=" + str + ", vendorId=" + str2 + ", trackingCode=" + str3 + ", name=" + str4 + ", description=" + str5 + ", imageUrl=" + str6 + ", imageUrls=" + list + ", price=" + d11 + ", originalPrice=" + d12 + ", stockAmount=" + num + ", tags=" + list2 + ", isAvailable=" + bool + ", attributes=" + list3 + ", discount=" + num2 + ", discountText=" + str7 + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ GlassItem(java.lang.String r16, java.lang.String r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, java.lang.String r21, java.util.List r22, java.lang.Double r23, java.lang.Double r24, java.lang.Integer r25, java.util.List r26, java.lang.Boolean r27, java.util.List r28, java.lang.Integer r29, java.lang.String r30, int r31, kotlin.jvm.internal.DefaultConstructorMarker r32) {
        /*
            r15 = this;
            r0 = r31
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
            if (r8 == 0) goto L_0x0039
            r8 = r2
            goto L_0x003b
        L_0x0039:
            r8 = r22
        L_0x003b:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x0041
            r9 = r2
            goto L_0x0043
        L_0x0041:
            r9 = r23
        L_0x0043:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x0049
            r10 = r2
            goto L_0x004b
        L_0x0049:
            r10 = r24
        L_0x004b:
            r11 = r0 & 512(0x200, float:7.175E-43)
            if (r11 == 0) goto L_0x0051
            r11 = r2
            goto L_0x0053
        L_0x0051:
            r11 = r25
        L_0x0053:
            r12 = r0 & 1024(0x400, float:1.435E-42)
            if (r12 == 0) goto L_0x0059
            r12 = r2
            goto L_0x005b
        L_0x0059:
            r12 = r26
        L_0x005b:
            r13 = r0 & 2048(0x800, float:2.87E-42)
            if (r13 == 0) goto L_0x0061
            r13 = r2
            goto L_0x0063
        L_0x0061:
            r13 = r27
        L_0x0063:
            r14 = r0 & 4096(0x1000, float:5.74E-42)
            if (r14 == 0) goto L_0x0068
            goto L_0x006a
        L_0x0068:
            r2 = r28
        L_0x006a:
            r14 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r14 == 0) goto L_0x0074
            r14 = 0
            java.lang.Integer r14 = java.lang.Integer.valueOf(r14)
            goto L_0x0076
        L_0x0074:
            r14 = r29
        L_0x0076:
            r0 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r0 == 0) goto L_0x007d
            java.lang.String r0 = ""
            goto L_0x007f
        L_0x007d:
            r0 = r30
        L_0x007f:
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
            r29 = r2
            r30 = r14
            r31 = r0
            r16.<init>(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.talabatcommon.feature.darkstores.lookingGlass.model.response.GlassItem.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.List, java.lang.Double, java.lang.Double, java.lang.Integer, java.util.List, java.lang.Boolean, java.util.List, java.lang.Integer, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
