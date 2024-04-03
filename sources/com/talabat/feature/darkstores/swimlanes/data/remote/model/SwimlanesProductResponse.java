package com.talabat.feature.darkstores.swimlanes.data.remote.model;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b;\b\b\u0018\u00002\u00020\u0001B\u0002\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0003\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\f\u0012\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\f\u0012\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\f\u0012\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0003\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0003\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t\u0012\n\b\u0003\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\u0010\b\u0003\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\t\u0012\n\b\u0003\u0010\u001c\u001a\u0004\u0018\u00010\u001d\u0012\n\b\u0003\u0010\u001e\u001a\u0004\u0018\u00010\u0015¢\u0006\u0002\u0010\u001fJ\u000b\u0010=\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010>\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010+J\u000b\u0010?\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010C\u001a\u0004\u0018\u00010\u0015HÆ\u0003¢\u0006\u0002\u0010!J\u000b\u0010D\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010E\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tHÆ\u0003J\u0010\u0010F\u001a\u0004\u0018\u00010\u0019HÆ\u0003¢\u0006\u0002\u00104J\u0011\u0010G\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\tHÆ\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\u001dHÆ\u0003J\u0010\u0010J\u001a\u0004\u0018\u00010\u0015HÆ\u0003¢\u0006\u0002\u0010!J\u000b\u0010K\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010L\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010M\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010N\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0003J\u0010\u0010O\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010+J\u0010\u0010P\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010+J\u0010\u0010Q\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010+J\u0002\u0010R\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u00032\u0010\b\u0003\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\f2\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\f2\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\f2\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0003\u0010\u0016\u001a\u0004\u0018\u00010\u00032\u0010\b\u0003\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t2\n\b\u0003\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0010\b\u0003\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\t2\n\b\u0003\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0003\u0010\u001e\u001a\u0004\u0018\u00010\u0015HÆ\u0001¢\u0006\u0002\u0010SJ\u0013\u0010T\u001a\u00020\u00192\b\u0010U\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010V\u001a\u00020\u0015HÖ\u0001J\t\u0010W\u001a\u00020\u0003HÖ\u0001R\u0015\u0010\u001e\u001a\u0004\u0018\u00010\u0015¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b \u0010!R\u0019\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u001d¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010&R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u0010,\u001a\u0004\b*\u0010+R\u0015\u0010\u000f\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u0010,\u001a\u0004\b-\u0010+R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b.\u0010&R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b/\u0010&R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b0\u0010&R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b1\u0010&R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b2\u0010&R\u0019\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b3\u0010$R\u0015\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\n\n\u0002\u00105\u001a\u0004\b\u0018\u00104R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b6\u0010&R\u0015\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u0010,\u001a\u0004\b7\u0010+R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u0010,\u001a\u0004\b8\u0010+R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b9\u0010&R\u0015\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b:\u0010!R\u0019\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b;\u0010$R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b<\u0010&¨\u0006X"}, d2 = {"Lcom/talabat/feature/darkstores/swimlanes/data/remote/model/SwimlanesProductResponse;", "", "id", "", "vendorId", "name", "description", "imageUrl", "imageUrls", "", "Lcom/talabat/feature/darkstores/swimlanes/data/remote/model/ProductUrlResponse;", "price", "", "originalPrice", "discount", "discountPercentage", "discountText", "globalCatalogId", "globalCatalogVendorId", "categoryId", "stockAmount", "", "sku", "tags", "isAvailable", "", "attributes", "Lcom/talabat/feature/darkstores/swimlanes/data/remote/model/ProductAttributesResponse;", "characteristics", "Lcom/talabat/feature/darkstores/swimlanes/data/remote/model/ProductCharacteristicsResponse;", "ageLimit", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;Ljava/lang/Boolean;Ljava/util/List;Lcom/talabat/feature/darkstores/swimlanes/data/remote/model/ProductCharacteristicsResponse;Ljava/lang/Integer;)V", "getAgeLimit", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getAttributes", "()Ljava/util/List;", "getCategoryId", "()Ljava/lang/String;", "getCharacteristics", "()Lcom/talabat/feature/darkstores/swimlanes/data/remote/model/ProductCharacteristicsResponse;", "getDescription", "getDiscount", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getDiscountPercentage", "getDiscountText", "getGlobalCatalogId", "getGlobalCatalogVendorId", "getId", "getImageUrl", "getImageUrls", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getName", "getOriginalPrice", "getPrice", "getSku", "getStockAmount", "getTags", "getVendorId", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;Ljava/lang/Boolean;Ljava/util/List;Lcom/talabat/feature/darkstores/swimlanes/data/remote/model/ProductCharacteristicsResponse;Ljava/lang/Integer;)Lcom/talabat/feature/darkstores/swimlanes/data/remote/model/SwimlanesProductResponse;", "equals", "other", "hashCode", "toString", "com_talabat_feature_darkstores-swimlanes_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SwimlanesProductResponse {
    @Nullable
    private final Integer ageLimit;
    @Nullable
    private final List<ProductAttributesResponse> attributes;
    @Nullable
    private final String categoryId;
    @Nullable
    private final ProductCharacteristicsResponse characteristics;
    @Nullable
    private final String description;
    @Nullable
    private final Float discount;
    @Nullable
    private final Float discountPercentage;
    @Nullable
    private final String discountText;
    @Nullable
    private final String globalCatalogId;
    @Nullable
    private final String globalCatalogVendorId;
    @Nullable

    /* renamed from: id  reason: collision with root package name */
    private final String f58404id;
    @Nullable
    private final String imageUrl;
    @Nullable
    private final List<ProductUrlResponse> imageUrls;
    @Nullable
    private final Boolean isAvailable;
    @Nullable

    /* renamed from: name  reason: collision with root package name */
    private final String f58405name;
    @Nullable
    private final Float originalPrice;
    @Nullable
    private final Float price;
    @Nullable
    private final String sku;
    @Nullable
    private final Integer stockAmount;
    @Nullable
    private final List<String> tags;
    @Nullable
    private final String vendorId;

    public SwimlanesProductResponse() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (List) null, (Float) null, (Float) null, (Float) null, (Float) null, (String) null, (String) null, (String) null, (String) null, (Integer) null, (String) null, (List) null, (Boolean) null, (List) null, (ProductCharacteristicsResponse) null, (Integer) null, 2097151, (DefaultConstructorMarker) null);
    }

    public SwimlanesProductResponse(@Nullable @Json(name = "id") String str, @Nullable @Json(name = "vendor_id") String str2, @Nullable @Json(name = "name") String str3, @Nullable @Json(name = "description") String str4, @Nullable @Json(name = "image_url") String str5, @Nullable @Json(name = "image_urls") List<ProductUrlResponse> list, @Nullable @Json(name = "price") Float f11, @Nullable @Json(name = "original_price") Float f12, @Nullable @Json(name = "discount") Float f13, @Nullable @Json(name = "discount_percentage") Float f14, @Nullable @Json(name = "discount_text") String str6, @Nullable @Json(name = "global_catalog_id") String str7, @Nullable @Json(name = "global_catalog_vendor_id") String str8, @Nullable @Json(name = "category_id") String str9, @Nullable @Json(name = "stock_amount") Integer num, @Nullable @Json(name = "sku") String str10, @Nullable @Json(name = "tags") List<String> list2, @Nullable @Json(name = "is_available") Boolean bool, @Nullable @Json(name = "attributes") List<ProductAttributesResponse> list3, @Nullable @Json(name = "characteristics") ProductCharacteristicsResponse productCharacteristicsResponse, @Nullable @Json(name = "age_limit") Integer num2) {
        this.f58404id = str;
        this.vendorId = str2;
        this.f58405name = str3;
        this.description = str4;
        this.imageUrl = str5;
        this.imageUrls = list;
        this.price = f11;
        this.originalPrice = f12;
        this.discount = f13;
        this.discountPercentage = f14;
        this.discountText = str6;
        this.globalCatalogId = str7;
        this.globalCatalogVendorId = str8;
        this.categoryId = str9;
        this.stockAmount = num;
        this.sku = str10;
        this.tags = list2;
        this.isAvailable = bool;
        this.attributes = list3;
        this.characteristics = productCharacteristicsResponse;
        this.ageLimit = num2;
    }

    public static /* synthetic */ SwimlanesProductResponse copy$default(SwimlanesProductResponse swimlanesProductResponse, String str, String str2, String str3, String str4, String str5, List list, Float f11, Float f12, Float f13, Float f14, String str6, String str7, String str8, String str9, Integer num, String str10, List list2, Boolean bool, List list3, ProductCharacteristicsResponse productCharacteristicsResponse, Integer num2, int i11, Object obj) {
        SwimlanesProductResponse swimlanesProductResponse2 = swimlanesProductResponse;
        int i12 = i11;
        return swimlanesProductResponse.copy((i12 & 1) != 0 ? swimlanesProductResponse2.f58404id : str, (i12 & 2) != 0 ? swimlanesProductResponse2.vendorId : str2, (i12 & 4) != 0 ? swimlanesProductResponse2.f58405name : str3, (i12 & 8) != 0 ? swimlanesProductResponse2.description : str4, (i12 & 16) != 0 ? swimlanesProductResponse2.imageUrl : str5, (i12 & 32) != 0 ? swimlanesProductResponse2.imageUrls : list, (i12 & 64) != 0 ? swimlanesProductResponse2.price : f11, (i12 & 128) != 0 ? swimlanesProductResponse2.originalPrice : f12, (i12 & 256) != 0 ? swimlanesProductResponse2.discount : f13, (i12 & 512) != 0 ? swimlanesProductResponse2.discountPercentage : f14, (i12 & 1024) != 0 ? swimlanesProductResponse2.discountText : str6, (i12 & 2048) != 0 ? swimlanesProductResponse2.globalCatalogId : str7, (i12 & 4096) != 0 ? swimlanesProductResponse2.globalCatalogVendorId : str8, (i12 & 8192) != 0 ? swimlanesProductResponse2.categoryId : str9, (i12 & 16384) != 0 ? swimlanesProductResponse2.stockAmount : num, (i12 & 32768) != 0 ? swimlanesProductResponse2.sku : str10, (i12 & 65536) != 0 ? swimlanesProductResponse2.tags : list2, (i12 & 131072) != 0 ? swimlanesProductResponse2.isAvailable : bool, (i12 & 262144) != 0 ? swimlanesProductResponse2.attributes : list3, (i12 & 524288) != 0 ? swimlanesProductResponse2.characteristics : productCharacteristicsResponse, (i12 & 1048576) != 0 ? swimlanesProductResponse2.ageLimit : num2);
    }

    @Nullable
    public final String component1() {
        return this.f58404id;
    }

    @Nullable
    public final Float component10() {
        return this.discountPercentage;
    }

    @Nullable
    public final String component11() {
        return this.discountText;
    }

    @Nullable
    public final String component12() {
        return this.globalCatalogId;
    }

    @Nullable
    public final String component13() {
        return this.globalCatalogVendorId;
    }

    @Nullable
    public final String component14() {
        return this.categoryId;
    }

    @Nullable
    public final Integer component15() {
        return this.stockAmount;
    }

    @Nullable
    public final String component16() {
        return this.sku;
    }

    @Nullable
    public final List<String> component17() {
        return this.tags;
    }

    @Nullable
    public final Boolean component18() {
        return this.isAvailable;
    }

    @Nullable
    public final List<ProductAttributesResponse> component19() {
        return this.attributes;
    }

    @Nullable
    public final String component2() {
        return this.vendorId;
    }

    @Nullable
    public final ProductCharacteristicsResponse component20() {
        return this.characteristics;
    }

    @Nullable
    public final Integer component21() {
        return this.ageLimit;
    }

    @Nullable
    public final String component3() {
        return this.f58405name;
    }

    @Nullable
    public final String component4() {
        return this.description;
    }

    @Nullable
    public final String component5() {
        return this.imageUrl;
    }

    @Nullable
    public final List<ProductUrlResponse> component6() {
        return this.imageUrls;
    }

    @Nullable
    public final Float component7() {
        return this.price;
    }

    @Nullable
    public final Float component8() {
        return this.originalPrice;
    }

    @Nullable
    public final Float component9() {
        return this.discount;
    }

    @NotNull
    public final SwimlanesProductResponse copy(@Nullable @Json(name = "id") String str, @Nullable @Json(name = "vendor_id") String str2, @Nullable @Json(name = "name") String str3, @Nullable @Json(name = "description") String str4, @Nullable @Json(name = "image_url") String str5, @Nullable @Json(name = "image_urls") List<ProductUrlResponse> list, @Nullable @Json(name = "price") Float f11, @Nullable @Json(name = "original_price") Float f12, @Nullable @Json(name = "discount") Float f13, @Nullable @Json(name = "discount_percentage") Float f14, @Nullable @Json(name = "discount_text") String str6, @Nullable @Json(name = "global_catalog_id") String str7, @Nullable @Json(name = "global_catalog_vendor_id") String str8, @Nullable @Json(name = "category_id") String str9, @Nullable @Json(name = "stock_amount") Integer num, @Nullable @Json(name = "sku") String str10, @Nullable @Json(name = "tags") List<String> list2, @Nullable @Json(name = "is_available") Boolean bool, @Nullable @Json(name = "attributes") List<ProductAttributesResponse> list3, @Nullable @Json(name = "characteristics") ProductCharacteristicsResponse productCharacteristicsResponse, @Nullable @Json(name = "age_limit") Integer num2) {
        return new SwimlanesProductResponse(str, str2, str3, str4, str5, list, f11, f12, f13, f14, str6, str7, str8, str9, num, str10, list2, bool, list3, productCharacteristicsResponse, num2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SwimlanesProductResponse)) {
            return false;
        }
        SwimlanesProductResponse swimlanesProductResponse = (SwimlanesProductResponse) obj;
        return Intrinsics.areEqual((Object) this.f58404id, (Object) swimlanesProductResponse.f58404id) && Intrinsics.areEqual((Object) this.vendorId, (Object) swimlanesProductResponse.vendorId) && Intrinsics.areEqual((Object) this.f58405name, (Object) swimlanesProductResponse.f58405name) && Intrinsics.areEqual((Object) this.description, (Object) swimlanesProductResponse.description) && Intrinsics.areEqual((Object) this.imageUrl, (Object) swimlanesProductResponse.imageUrl) && Intrinsics.areEqual((Object) this.imageUrls, (Object) swimlanesProductResponse.imageUrls) && Intrinsics.areEqual((Object) this.price, (Object) swimlanesProductResponse.price) && Intrinsics.areEqual((Object) this.originalPrice, (Object) swimlanesProductResponse.originalPrice) && Intrinsics.areEqual((Object) this.discount, (Object) swimlanesProductResponse.discount) && Intrinsics.areEqual((Object) this.discountPercentage, (Object) swimlanesProductResponse.discountPercentage) && Intrinsics.areEqual((Object) this.discountText, (Object) swimlanesProductResponse.discountText) && Intrinsics.areEqual((Object) this.globalCatalogId, (Object) swimlanesProductResponse.globalCatalogId) && Intrinsics.areEqual((Object) this.globalCatalogVendorId, (Object) swimlanesProductResponse.globalCatalogVendorId) && Intrinsics.areEqual((Object) this.categoryId, (Object) swimlanesProductResponse.categoryId) && Intrinsics.areEqual((Object) this.stockAmount, (Object) swimlanesProductResponse.stockAmount) && Intrinsics.areEqual((Object) this.sku, (Object) swimlanesProductResponse.sku) && Intrinsics.areEqual((Object) this.tags, (Object) swimlanesProductResponse.tags) && Intrinsics.areEqual((Object) this.isAvailable, (Object) swimlanesProductResponse.isAvailable) && Intrinsics.areEqual((Object) this.attributes, (Object) swimlanesProductResponse.attributes) && Intrinsics.areEqual((Object) this.characteristics, (Object) swimlanesProductResponse.characteristics) && Intrinsics.areEqual((Object) this.ageLimit, (Object) swimlanesProductResponse.ageLimit);
    }

    @Nullable
    public final Integer getAgeLimit() {
        return this.ageLimit;
    }

    @Nullable
    public final List<ProductAttributesResponse> getAttributes() {
        return this.attributes;
    }

    @Nullable
    public final String getCategoryId() {
        return this.categoryId;
    }

    @Nullable
    public final ProductCharacteristicsResponse getCharacteristics() {
        return this.characteristics;
    }

    @Nullable
    public final String getDescription() {
        return this.description;
    }

    @Nullable
    public final Float getDiscount() {
        return this.discount;
    }

    @Nullable
    public final Float getDiscountPercentage() {
        return this.discountPercentage;
    }

    @Nullable
    public final String getDiscountText() {
        return this.discountText;
    }

    @Nullable
    public final String getGlobalCatalogId() {
        return this.globalCatalogId;
    }

    @Nullable
    public final String getGlobalCatalogVendorId() {
        return this.globalCatalogVendorId;
    }

    @Nullable
    public final String getId() {
        return this.f58404id;
    }

    @Nullable
    public final String getImageUrl() {
        return this.imageUrl;
    }

    @Nullable
    public final List<ProductUrlResponse> getImageUrls() {
        return this.imageUrls;
    }

    @Nullable
    public final String getName() {
        return this.f58405name;
    }

    @Nullable
    public final Float getOriginalPrice() {
        return this.originalPrice;
    }

    @Nullable
    public final Float getPrice() {
        return this.price;
    }

    @Nullable
    public final String getSku() {
        return this.sku;
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
    public final String getVendorId() {
        return this.vendorId;
    }

    public int hashCode() {
        String str = this.f58404id;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.vendorId;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f58405name;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.description;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.imageUrl;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        List<ProductUrlResponse> list = this.imageUrls;
        int hashCode6 = (hashCode5 + (list == null ? 0 : list.hashCode())) * 31;
        Float f11 = this.price;
        int hashCode7 = (hashCode6 + (f11 == null ? 0 : f11.hashCode())) * 31;
        Float f12 = this.originalPrice;
        int hashCode8 = (hashCode7 + (f12 == null ? 0 : f12.hashCode())) * 31;
        Float f13 = this.discount;
        int hashCode9 = (hashCode8 + (f13 == null ? 0 : f13.hashCode())) * 31;
        Float f14 = this.discountPercentage;
        int hashCode10 = (hashCode9 + (f14 == null ? 0 : f14.hashCode())) * 31;
        String str6 = this.discountText;
        int hashCode11 = (hashCode10 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.globalCatalogId;
        int hashCode12 = (hashCode11 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.globalCatalogVendorId;
        int hashCode13 = (hashCode12 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.categoryId;
        int hashCode14 = (hashCode13 + (str9 == null ? 0 : str9.hashCode())) * 31;
        Integer num = this.stockAmount;
        int hashCode15 = (hashCode14 + (num == null ? 0 : num.hashCode())) * 31;
        String str10 = this.sku;
        int hashCode16 = (hashCode15 + (str10 == null ? 0 : str10.hashCode())) * 31;
        List<String> list2 = this.tags;
        int hashCode17 = (hashCode16 + (list2 == null ? 0 : list2.hashCode())) * 31;
        Boolean bool = this.isAvailable;
        int hashCode18 = (hashCode17 + (bool == null ? 0 : bool.hashCode())) * 31;
        List<ProductAttributesResponse> list3 = this.attributes;
        int hashCode19 = (hashCode18 + (list3 == null ? 0 : list3.hashCode())) * 31;
        ProductCharacteristicsResponse productCharacteristicsResponse = this.characteristics;
        int hashCode20 = (hashCode19 + (productCharacteristicsResponse == null ? 0 : productCharacteristicsResponse.hashCode())) * 31;
        Integer num2 = this.ageLimit;
        if (num2 != null) {
            i11 = num2.hashCode();
        }
        return hashCode20 + i11;
    }

    @Nullable
    public final Boolean isAvailable() {
        return this.isAvailable;
    }

    @NotNull
    public String toString() {
        String str = this.f58404id;
        String str2 = this.vendorId;
        String str3 = this.f58405name;
        String str4 = this.description;
        String str5 = this.imageUrl;
        List<ProductUrlResponse> list = this.imageUrls;
        Float f11 = this.price;
        Float f12 = this.originalPrice;
        Float f13 = this.discount;
        Float f14 = this.discountPercentage;
        String str6 = this.discountText;
        String str7 = this.globalCatalogId;
        String str8 = this.globalCatalogVendorId;
        String str9 = this.categoryId;
        Integer num = this.stockAmount;
        String str10 = this.sku;
        List<String> list2 = this.tags;
        Boolean bool = this.isAvailable;
        List<ProductAttributesResponse> list3 = this.attributes;
        ProductCharacteristicsResponse productCharacteristicsResponse = this.characteristics;
        Integer num2 = this.ageLimit;
        return "SwimlanesProductResponse(id=" + str + ", vendorId=" + str2 + ", name=" + str3 + ", description=" + str4 + ", imageUrl=" + str5 + ", imageUrls=" + list + ", price=" + f11 + ", originalPrice=" + f12 + ", discount=" + f13 + ", discountPercentage=" + f14 + ", discountText=" + str6 + ", globalCatalogId=" + str7 + ", globalCatalogVendorId=" + str8 + ", categoryId=" + str9 + ", stockAmount=" + num + ", sku=" + str10 + ", tags=" + list2 + ", isAvailable=" + bool + ", attributes=" + list3 + ", characteristics=" + productCharacteristicsResponse + ", ageLimit=" + num2 + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ SwimlanesProductResponse(java.lang.String r23, java.lang.String r24, java.lang.String r25, java.lang.String r26, java.lang.String r27, java.util.List r28, java.lang.Float r29, java.lang.Float r30, java.lang.Float r31, java.lang.Float r32, java.lang.String r33, java.lang.String r34, java.lang.String r35, java.lang.String r36, java.lang.Integer r37, java.lang.String r38, java.util.List r39, java.lang.Boolean r40, java.util.List r41, com.talabat.feature.darkstores.swimlanes.data.remote.model.ProductCharacteristicsResponse r42, java.lang.Integer r43, int r44, kotlin.jvm.internal.DefaultConstructorMarker r45) {
        /*
            r22 = this;
            r0 = r44
            r1 = r0 & 1
            if (r1 == 0) goto L_0x0008
            r1 = 0
            goto L_0x000a
        L_0x0008:
            r1 = r23
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            r3 = 0
            goto L_0x0012
        L_0x0010:
            r3 = r24
        L_0x0012:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0018
            r4 = 0
            goto L_0x001a
        L_0x0018:
            r4 = r25
        L_0x001a:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x0020
            r5 = 0
            goto L_0x0022
        L_0x0020:
            r5 = r26
        L_0x0022:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0028
            r6 = 0
            goto L_0x002a
        L_0x0028:
            r6 = r27
        L_0x002a:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x0030
            r7 = 0
            goto L_0x0032
        L_0x0030:
            r7 = r28
        L_0x0032:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0038
            r8 = 0
            goto L_0x003a
        L_0x0038:
            r8 = r29
        L_0x003a:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x0040
            r9 = 0
            goto L_0x0042
        L_0x0040:
            r9 = r30
        L_0x0042:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x0048
            r10 = 0
            goto L_0x004a
        L_0x0048:
            r10 = r31
        L_0x004a:
            r11 = r0 & 512(0x200, float:7.175E-43)
            if (r11 == 0) goto L_0x0050
            r11 = 0
            goto L_0x0052
        L_0x0050:
            r11 = r32
        L_0x0052:
            r12 = r0 & 1024(0x400, float:1.435E-42)
            if (r12 == 0) goto L_0x0058
            r12 = 0
            goto L_0x005a
        L_0x0058:
            r12 = r33
        L_0x005a:
            r13 = r0 & 2048(0x800, float:2.87E-42)
            if (r13 == 0) goto L_0x0060
            r13 = 0
            goto L_0x0062
        L_0x0060:
            r13 = r34
        L_0x0062:
            r14 = r0 & 4096(0x1000, float:5.74E-42)
            if (r14 == 0) goto L_0x0068
            r14 = 0
            goto L_0x006a
        L_0x0068:
            r14 = r35
        L_0x006a:
            r15 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r15 == 0) goto L_0x0070
            r15 = 0
            goto L_0x0072
        L_0x0070:
            r15 = r36
        L_0x0072:
            r2 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r2 == 0) goto L_0x0078
            r2 = 0
            goto L_0x007a
        L_0x0078:
            r2 = r37
        L_0x007a:
            r16 = 32768(0x8000, float:4.5918E-41)
            r16 = r0 & r16
            if (r16 == 0) goto L_0x0084
            r16 = 0
            goto L_0x0086
        L_0x0084:
            r16 = r38
        L_0x0086:
            r17 = 65536(0x10000, float:9.18355E-41)
            r17 = r0 & r17
            if (r17 == 0) goto L_0x008f
            r17 = 0
            goto L_0x0091
        L_0x008f:
            r17 = r39
        L_0x0091:
            r18 = 131072(0x20000, float:1.83671E-40)
            r18 = r0 & r18
            if (r18 == 0) goto L_0x009a
            r18 = 0
            goto L_0x009c
        L_0x009a:
            r18 = r40
        L_0x009c:
            r19 = 262144(0x40000, float:3.67342E-40)
            r19 = r0 & r19
            if (r19 == 0) goto L_0x00a5
            r19 = 0
            goto L_0x00a7
        L_0x00a5:
            r19 = r41
        L_0x00a7:
            r20 = 524288(0x80000, float:7.34684E-40)
            r20 = r0 & r20
            if (r20 == 0) goto L_0x00b0
            r20 = 0
            goto L_0x00b2
        L_0x00b0:
            r20 = r42
        L_0x00b2:
            r21 = 1048576(0x100000, float:1.469368E-39)
            r0 = r0 & r21
            if (r0 == 0) goto L_0x00ba
            r0 = 0
            goto L_0x00bc
        L_0x00ba:
            r0 = r43
        L_0x00bc:
            r23 = r22
            r24 = r1
            r25 = r3
            r26 = r4
            r27 = r5
            r28 = r6
            r29 = r7
            r30 = r8
            r31 = r9
            r32 = r10
            r33 = r11
            r34 = r12
            r35 = r13
            r36 = r14
            r37 = r15
            r38 = r2
            r39 = r16
            r40 = r17
            r41 = r18
            r42 = r19
            r43 = r20
            r44 = r0
            r23.<init>(r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.darkstores.swimlanes.data.remote.model.SwimlanesProductResponse.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.List, java.lang.Float, java.lang.Float, java.lang.Float, java.lang.Float, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, java.lang.String, java.util.List, java.lang.Boolean, java.util.List, com.talabat.feature.darkstores.swimlanes.data.remote.model.ProductCharacteristicsResponse, java.lang.Integer, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
