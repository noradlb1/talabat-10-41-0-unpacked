package com.talabat.feature.darkstores.vendorslanding.data.model;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\bH\b\b\u0018\u00002\u00020\u0001BÏ\u0002\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0003\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\b\u0012\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\b\u0012\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\b\u0012\n\b\u0001\u0010\u0011\u001a\u0004\u0018\u00010\b\u0012\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\b\u0012\u0010\b\u0003\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0001\u0010\u0017\u001a\u0004\u0018\u00010\b\u0012\n\b\u0003\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0003\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0001\u0010\u001b\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0003\u0010\u001c\u001a\u0004\u0018\u00010\b\u0012\n\b\u0003\u0010\u001d\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0003\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u001f\u001a\u0004\u0018\u00010 \u0012\n\b\u0003\u0010!\u001a\u0004\u0018\u00010\b\u0012\n\b\u0001\u0010\"\u001a\u0004\u0018\u00010\b\u0012\n\b\u0003\u0010#\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0003\u0010$\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010%J\u0010\u0010H\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010'J\u000b\u0010I\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0011\u0010L\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0005HÆ\u0003J\u0010\u0010M\u001a\u0004\u0018\u00010\u0016HÆ\u0003¢\u0006\u0002\u00108J\u000b\u0010N\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0010\u0010O\u001a\u0004\u0018\u00010\u0019HÆ\u0003¢\u0006\u0002\u0010=J\u0010\u0010P\u001a\u0004\u0018\u00010\u0019HÆ\u0003¢\u0006\u0002\u0010=J\u0010\u0010Q\u001a\u0004\u0018\u00010\u0019HÆ\u0003¢\u0006\u0002\u0010=J\u000b\u0010R\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0011\u0010S\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u0010\u0010T\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010'J\u0011\u0010U\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005HÆ\u0003J\u000b\u0010V\u001a\u0004\u0018\u00010 HÆ\u0003J\u000b\u0010W\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010X\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0010\u0010Y\u001a\u0004\u0018\u00010\u0016HÆ\u0003¢\u0006\u0002\u00108J\u000b\u0010Z\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010[\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\\\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010]\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0010\u0010^\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010'J\u0010\u0010_\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010'J\u000b\u0010`\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010a\u001a\u0004\u0018\u00010\bHÆ\u0003JØ\u0002\u0010b\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0003\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\b2\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\b2\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\b2\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\b2\n\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\b2\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\b2\u0010\b\u0003\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00052\n\b\u0003\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0003\u0010\u0017\u001a\u0004\u0018\u00010\b2\n\b\u0003\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\b\u0003\u0010\u001a\u001a\u0004\u0018\u00010\u00192\n\b\u0003\u0010\u001b\u001a\u0004\u0018\u00010\u00192\n\b\u0003\u0010\u001c\u001a\u0004\u0018\u00010\b2\n\b\u0003\u0010\u001d\u001a\u0004\u0018\u00010\u00032\u0010\b\u0003\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00052\n\b\u0003\u0010\u001f\u001a\u0004\u0018\u00010 2\n\b\u0003\u0010!\u001a\u0004\u0018\u00010\b2\n\b\u0003\u0010\"\u001a\u0004\u0018\u00010\b2\n\b\u0003\u0010#\u001a\u0004\u0018\u00010\u00162\n\b\u0003\u0010$\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010cJ\u0013\u0010d\u001a\u00020\u00162\b\u0010e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010f\u001a\u00020\u0003HÖ\u0001J\t\u0010g\u001a\u00020\bHÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010(\u001a\u0004\b&\u0010'R\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b/\u0010,R\u0015\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010(\u001a\u0004\b0\u0010'R\u0015\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010(\u001a\u0004\b1\u0010'R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b2\u0010,R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b3\u0010,R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b4\u0010,R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b5\u0010,R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b6\u0010,R\u0019\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b7\u0010*R\u0015\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\n\n\u0002\u00109\u001a\u0004\b\u0015\u00108R\u0015\u0010#\u001a\u0004\u0018\u00010\u0016¢\u0006\n\n\u0002\u00109\u001a\u0004\b#\u00108R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b:\u0010,R\u0013\u0010$\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b;\u0010,R\u0015\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\n\n\u0002\u0010>\u001a\u0004\b<\u0010=R\u0015\u0010\u001a\u001a\u0004\u0018\u00010\u0019¢\u0006\n\n\u0002\u0010>\u001a\u0004\b?\u0010=R\u0015\u0010\u001b\u001a\u0004\u0018\u00010\u0019¢\u0006\n\n\u0002\u0010>\u001a\u0004\b@\u0010=R\u0013\u0010\u001c\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\bA\u0010,R\u0015\u0010\u001d\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010(\u001a\u0004\bB\u0010'R\u0019\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\bC\u0010*R\u0013\u0010\u001f\u001a\u0004\u0018\u00010 ¢\u0006\b\n\u0000\u001a\u0004\bD\u0010ER\u0013\u0010!\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\bF\u0010,R\u0013\u0010\"\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\bG\u0010,¨\u0006h"}, d2 = {"Lcom/talabat/feature/darkstores/vendorslanding/data/model/SwimlaneProductResponse;", "", "ageLimit", "", "attributes", "", "Lcom/talabat/feature/darkstores/vendorslanding/data/model/ProductAttributesResponse;", "categoryId", "", "characteristics", "Lcom/talabat/feature/darkstores/vendorslanding/data/model/CharacteristicsResponse;", "description", "discount", "discountPercentage", "discountText", "globalCatalogId", "globalCatalogVendorId", "id", "imageUrl", "imageUrls", "Lcom/talabat/feature/darkstores/vendorslanding/data/model/ImageUrlResponse;", "isAvailable", "", "name", "originalPrice", "", "packagingCharge", "price", "sku", "stockAmount", "tags", "tracking", "Lcom/talabat/feature/darkstores/vendorslanding/data/model/SwimlaneProductTrackingResponse;", "trackingCode", "vendorId", "isSponsored", "offerText", "(Ljava/lang/Integer;Ljava/util/List;Ljava/lang/String;Lcom/talabat/feature/darkstores/vendorslanding/data/model/CharacteristicsResponse;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;Lcom/talabat/feature/darkstores/vendorslanding/data/model/SwimlaneProductTrackingResponse;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;)V", "getAgeLimit", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getAttributes", "()Ljava/util/List;", "getCategoryId", "()Ljava/lang/String;", "getCharacteristics", "()Lcom/talabat/feature/darkstores/vendorslanding/data/model/CharacteristicsResponse;", "getDescription", "getDiscount", "getDiscountPercentage", "getDiscountText", "getGlobalCatalogId", "getGlobalCatalogVendorId", "getId", "getImageUrl", "getImageUrls", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getName", "getOfferText", "getOriginalPrice", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getPackagingCharge", "getPrice", "getSku", "getStockAmount", "getTags", "getTracking", "()Lcom/talabat/feature/darkstores/vendorslanding/data/model/SwimlaneProductTrackingResponse;", "getTrackingCode", "getVendorId", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Integer;Ljava/util/List;Ljava/lang/String;Lcom/talabat/feature/darkstores/vendorslanding/data/model/CharacteristicsResponse;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;Lcom/talabat/feature/darkstores/vendorslanding/data/model/SwimlaneProductTrackingResponse;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;)Lcom/talabat/feature/darkstores/vendorslanding/data/model/SwimlaneProductResponse;", "equals", "other", "hashCode", "toString", "com_talabat_feature_darkstores-vendor-landing_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SwimlaneProductResponse {
    @Nullable
    private final Integer ageLimit;
    @Nullable
    private final List<ProductAttributesResponse> attributes;
    @Nullable
    private final String categoryId;
    @Nullable
    private final CharacteristicsResponse characteristics;
    @Nullable
    private final String description;
    @Nullable
    private final Integer discount;
    @Nullable
    private final Integer discountPercentage;
    @Nullable
    private final String discountText;
    @Nullable
    private final String globalCatalogId;
    @Nullable
    private final String globalCatalogVendorId;
    @Nullable

    /* renamed from: id  reason: collision with root package name */
    private final String f58446id;
    @Nullable
    private final String imageUrl;
    @Nullable
    private final List<ImageUrlResponse> imageUrls;
    @Nullable
    private final Boolean isAvailable;
    @Nullable
    private final Boolean isSponsored;
    @Nullable

    /* renamed from: name  reason: collision with root package name */
    private final String f58447name;
    @Nullable
    private final String offerText;
    @Nullable
    private final Float originalPrice;
    @Nullable
    private final Float packagingCharge;
    @Nullable
    private final Float price;
    @Nullable
    private final String sku;
    @Nullable
    private final Integer stockAmount;
    @Nullable
    private final List<String> tags;
    @Nullable

    /* renamed from: tracking  reason: collision with root package name */
    private final SwimlaneProductTrackingResponse f58448tracking;
    @Nullable
    private final String trackingCode;
    @Nullable
    private final String vendorId;

    public SwimlaneProductResponse(@Nullable @Json(name = "age_limit") Integer num, @Nullable @Json(name = "attributes") List<ProductAttributesResponse> list, @Nullable @Json(name = "category_id") String str, @Nullable @Json(name = "characteristics") CharacteristicsResponse characteristicsResponse, @Nullable @Json(name = "description") String str2, @Nullable @Json(name = "discount") Integer num2, @Nullable @Json(name = "discount_percentage") Integer num3, @Nullable @Json(name = "discount_text") String str3, @Nullable @Json(name = "global_catalog_id") String str4, @Nullable @Json(name = "global_catalog_vendor_id") String str5, @Nullable @Json(name = "id") String str6, @Nullable @Json(name = "image_url") String str7, @Nullable @Json(name = "image_urls") List<ImageUrlResponse> list2, @Nullable @Json(name = "is_available") Boolean bool, @Nullable @Json(name = "name") String str8, @Nullable @Json(name = "original_price") Float f11, @Nullable @Json(name = "packaging_charge") Float f12, @Nullable @Json(name = "price") Float f13, @Nullable @Json(name = "sku") String str9, @Nullable @Json(name = "stock_amount") Integer num4, @Nullable @Json(name = "tags") List<String> list3, @Nullable @Json(name = "tracking") SwimlaneProductTrackingResponse swimlaneProductTrackingResponse, @Nullable @Json(name = "tracking_code") String str10, @Nullable @Json(name = "vendor_id") String str11, @Nullable @Json(name = "is_sponsored") Boolean bool2, @Nullable @Json(name = "offer_text") String str12) {
        this.ageLimit = num;
        this.attributes = list;
        this.categoryId = str;
        this.characteristics = characteristicsResponse;
        this.description = str2;
        this.discount = num2;
        this.discountPercentage = num3;
        this.discountText = str3;
        this.globalCatalogId = str4;
        this.globalCatalogVendorId = str5;
        this.f58446id = str6;
        this.imageUrl = str7;
        this.imageUrls = list2;
        this.isAvailable = bool;
        this.f58447name = str8;
        this.originalPrice = f11;
        this.packagingCharge = f12;
        this.price = f13;
        this.sku = str9;
        this.stockAmount = num4;
        this.tags = list3;
        this.f58448tracking = swimlaneProductTrackingResponse;
        this.trackingCode = str10;
        this.vendorId = str11;
        this.isSponsored = bool2;
        this.offerText = str12;
    }

    public static /* synthetic */ SwimlaneProductResponse copy$default(SwimlaneProductResponse swimlaneProductResponse, Integer num, List list, String str, CharacteristicsResponse characteristicsResponse, String str2, Integer num2, Integer num3, String str3, String str4, String str5, String str6, String str7, List list2, Boolean bool, String str8, Float f11, Float f12, Float f13, String str9, Integer num4, List list3, SwimlaneProductTrackingResponse swimlaneProductTrackingResponse, String str10, String str11, Boolean bool2, String str12, int i11, Object obj) {
        SwimlaneProductResponse swimlaneProductResponse2 = swimlaneProductResponse;
        int i12 = i11;
        return swimlaneProductResponse.copy((i12 & 1) != 0 ? swimlaneProductResponse2.ageLimit : num, (i12 & 2) != 0 ? swimlaneProductResponse2.attributes : list, (i12 & 4) != 0 ? swimlaneProductResponse2.categoryId : str, (i12 & 8) != 0 ? swimlaneProductResponse2.characteristics : characteristicsResponse, (i12 & 16) != 0 ? swimlaneProductResponse2.description : str2, (i12 & 32) != 0 ? swimlaneProductResponse2.discount : num2, (i12 & 64) != 0 ? swimlaneProductResponse2.discountPercentage : num3, (i12 & 128) != 0 ? swimlaneProductResponse2.discountText : str3, (i12 & 256) != 0 ? swimlaneProductResponse2.globalCatalogId : str4, (i12 & 512) != 0 ? swimlaneProductResponse2.globalCatalogVendorId : str5, (i12 & 1024) != 0 ? swimlaneProductResponse2.f58446id : str6, (i12 & 2048) != 0 ? swimlaneProductResponse2.imageUrl : str7, (i12 & 4096) != 0 ? swimlaneProductResponse2.imageUrls : list2, (i12 & 8192) != 0 ? swimlaneProductResponse2.isAvailable : bool, (i12 & 16384) != 0 ? swimlaneProductResponse2.f58447name : str8, (i12 & 32768) != 0 ? swimlaneProductResponse2.originalPrice : f11, (i12 & 65536) != 0 ? swimlaneProductResponse2.packagingCharge : f12, (i12 & 131072) != 0 ? swimlaneProductResponse2.price : f13, (i12 & 262144) != 0 ? swimlaneProductResponse2.sku : str9, (i12 & 524288) != 0 ? swimlaneProductResponse2.stockAmount : num4, (i12 & 1048576) != 0 ? swimlaneProductResponse2.tags : list3, (i12 & 2097152) != 0 ? swimlaneProductResponse2.f58448tracking : swimlaneProductTrackingResponse, (i12 & 4194304) != 0 ? swimlaneProductResponse2.trackingCode : str10, (i12 & 8388608) != 0 ? swimlaneProductResponse2.vendorId : str11, (i12 & 16777216) != 0 ? swimlaneProductResponse2.isSponsored : bool2, (i12 & 33554432) != 0 ? swimlaneProductResponse2.offerText : str12);
    }

    @Nullable
    public final Integer component1() {
        return this.ageLimit;
    }

    @Nullable
    public final String component10() {
        return this.globalCatalogVendorId;
    }

    @Nullable
    public final String component11() {
        return this.f58446id;
    }

    @Nullable
    public final String component12() {
        return this.imageUrl;
    }

    @Nullable
    public final List<ImageUrlResponse> component13() {
        return this.imageUrls;
    }

    @Nullable
    public final Boolean component14() {
        return this.isAvailable;
    }

    @Nullable
    public final String component15() {
        return this.f58447name;
    }

    @Nullable
    public final Float component16() {
        return this.originalPrice;
    }

    @Nullable
    public final Float component17() {
        return this.packagingCharge;
    }

    @Nullable
    public final Float component18() {
        return this.price;
    }

    @Nullable
    public final String component19() {
        return this.sku;
    }

    @Nullable
    public final List<ProductAttributesResponse> component2() {
        return this.attributes;
    }

    @Nullable
    public final Integer component20() {
        return this.stockAmount;
    }

    @Nullable
    public final List<String> component21() {
        return this.tags;
    }

    @Nullable
    public final SwimlaneProductTrackingResponse component22() {
        return this.f58448tracking;
    }

    @Nullable
    public final String component23() {
        return this.trackingCode;
    }

    @Nullable
    public final String component24() {
        return this.vendorId;
    }

    @Nullable
    public final Boolean component25() {
        return this.isSponsored;
    }

    @Nullable
    public final String component26() {
        return this.offerText;
    }

    @Nullable
    public final String component3() {
        return this.categoryId;
    }

    @Nullable
    public final CharacteristicsResponse component4() {
        return this.characteristics;
    }

    @Nullable
    public final String component5() {
        return this.description;
    }

    @Nullable
    public final Integer component6() {
        return this.discount;
    }

    @Nullable
    public final Integer component7() {
        return this.discountPercentage;
    }

    @Nullable
    public final String component8() {
        return this.discountText;
    }

    @Nullable
    public final String component9() {
        return this.globalCatalogId;
    }

    @NotNull
    public final SwimlaneProductResponse copy(@Nullable @Json(name = "age_limit") Integer num, @Nullable @Json(name = "attributes") List<ProductAttributesResponse> list, @Nullable @Json(name = "category_id") String str, @Nullable @Json(name = "characteristics") CharacteristicsResponse characteristicsResponse, @Nullable @Json(name = "description") String str2, @Nullable @Json(name = "discount") Integer num2, @Nullable @Json(name = "discount_percentage") Integer num3, @Nullable @Json(name = "discount_text") String str3, @Nullable @Json(name = "global_catalog_id") String str4, @Nullable @Json(name = "global_catalog_vendor_id") String str5, @Nullable @Json(name = "id") String str6, @Nullable @Json(name = "image_url") String str7, @Nullable @Json(name = "image_urls") List<ImageUrlResponse> list2, @Nullable @Json(name = "is_available") Boolean bool, @Nullable @Json(name = "name") String str8, @Nullable @Json(name = "original_price") Float f11, @Nullable @Json(name = "packaging_charge") Float f12, @Nullable @Json(name = "price") Float f13, @Nullable @Json(name = "sku") String str9, @Nullable @Json(name = "stock_amount") Integer num4, @Nullable @Json(name = "tags") List<String> list3, @Nullable @Json(name = "tracking") SwimlaneProductTrackingResponse swimlaneProductTrackingResponse, @Nullable @Json(name = "tracking_code") String str10, @Nullable @Json(name = "vendor_id") String str11, @Nullable @Json(name = "is_sponsored") Boolean bool2, @Nullable @Json(name = "offer_text") String str12) {
        return new SwimlaneProductResponse(num, list, str, characteristicsResponse, str2, num2, num3, str3, str4, str5, str6, str7, list2, bool, str8, f11, f12, f13, str9, num4, list3, swimlaneProductTrackingResponse, str10, str11, bool2, str12);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SwimlaneProductResponse)) {
            return false;
        }
        SwimlaneProductResponse swimlaneProductResponse = (SwimlaneProductResponse) obj;
        return Intrinsics.areEqual((Object) this.ageLimit, (Object) swimlaneProductResponse.ageLimit) && Intrinsics.areEqual((Object) this.attributes, (Object) swimlaneProductResponse.attributes) && Intrinsics.areEqual((Object) this.categoryId, (Object) swimlaneProductResponse.categoryId) && Intrinsics.areEqual((Object) this.characteristics, (Object) swimlaneProductResponse.characteristics) && Intrinsics.areEqual((Object) this.description, (Object) swimlaneProductResponse.description) && Intrinsics.areEqual((Object) this.discount, (Object) swimlaneProductResponse.discount) && Intrinsics.areEqual((Object) this.discountPercentage, (Object) swimlaneProductResponse.discountPercentage) && Intrinsics.areEqual((Object) this.discountText, (Object) swimlaneProductResponse.discountText) && Intrinsics.areEqual((Object) this.globalCatalogId, (Object) swimlaneProductResponse.globalCatalogId) && Intrinsics.areEqual((Object) this.globalCatalogVendorId, (Object) swimlaneProductResponse.globalCatalogVendorId) && Intrinsics.areEqual((Object) this.f58446id, (Object) swimlaneProductResponse.f58446id) && Intrinsics.areEqual((Object) this.imageUrl, (Object) swimlaneProductResponse.imageUrl) && Intrinsics.areEqual((Object) this.imageUrls, (Object) swimlaneProductResponse.imageUrls) && Intrinsics.areEqual((Object) this.isAvailable, (Object) swimlaneProductResponse.isAvailable) && Intrinsics.areEqual((Object) this.f58447name, (Object) swimlaneProductResponse.f58447name) && Intrinsics.areEqual((Object) this.originalPrice, (Object) swimlaneProductResponse.originalPrice) && Intrinsics.areEqual((Object) this.packagingCharge, (Object) swimlaneProductResponse.packagingCharge) && Intrinsics.areEqual((Object) this.price, (Object) swimlaneProductResponse.price) && Intrinsics.areEqual((Object) this.sku, (Object) swimlaneProductResponse.sku) && Intrinsics.areEqual((Object) this.stockAmount, (Object) swimlaneProductResponse.stockAmount) && Intrinsics.areEqual((Object) this.tags, (Object) swimlaneProductResponse.tags) && Intrinsics.areEqual((Object) this.f58448tracking, (Object) swimlaneProductResponse.f58448tracking) && Intrinsics.areEqual((Object) this.trackingCode, (Object) swimlaneProductResponse.trackingCode) && Intrinsics.areEqual((Object) this.vendorId, (Object) swimlaneProductResponse.vendorId) && Intrinsics.areEqual((Object) this.isSponsored, (Object) swimlaneProductResponse.isSponsored) && Intrinsics.areEqual((Object) this.offerText, (Object) swimlaneProductResponse.offerText);
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
    public final CharacteristicsResponse getCharacteristics() {
        return this.characteristics;
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
    public final Integer getDiscountPercentage() {
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
        return this.f58446id;
    }

    @Nullable
    public final String getImageUrl() {
        return this.imageUrl;
    }

    @Nullable
    public final List<ImageUrlResponse> getImageUrls() {
        return this.imageUrls;
    }

    @Nullable
    public final String getName() {
        return this.f58447name;
    }

    @Nullable
    public final String getOfferText() {
        return this.offerText;
    }

    @Nullable
    public final Float getOriginalPrice() {
        return this.originalPrice;
    }

    @Nullable
    public final Float getPackagingCharge() {
        return this.packagingCharge;
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
    public final SwimlaneProductTrackingResponse getTracking() {
        return this.f58448tracking;
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
        Integer num = this.ageLimit;
        int i11 = 0;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        List<ProductAttributesResponse> list = this.attributes;
        int hashCode2 = (hashCode + (list == null ? 0 : list.hashCode())) * 31;
        String str = this.categoryId;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        CharacteristicsResponse characteristicsResponse = this.characteristics;
        int hashCode4 = (hashCode3 + (characteristicsResponse == null ? 0 : characteristicsResponse.hashCode())) * 31;
        String str2 = this.description;
        int hashCode5 = (hashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num2 = this.discount;
        int hashCode6 = (hashCode5 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.discountPercentage;
        int hashCode7 = (hashCode6 + (num3 == null ? 0 : num3.hashCode())) * 31;
        String str3 = this.discountText;
        int hashCode8 = (hashCode7 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.globalCatalogId;
        int hashCode9 = (hashCode8 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.globalCatalogVendorId;
        int hashCode10 = (hashCode9 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.f58446id;
        int hashCode11 = (hashCode10 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.imageUrl;
        int hashCode12 = (hashCode11 + (str7 == null ? 0 : str7.hashCode())) * 31;
        List<ImageUrlResponse> list2 = this.imageUrls;
        int hashCode13 = (hashCode12 + (list2 == null ? 0 : list2.hashCode())) * 31;
        Boolean bool = this.isAvailable;
        int hashCode14 = (hashCode13 + (bool == null ? 0 : bool.hashCode())) * 31;
        String str8 = this.f58447name;
        int hashCode15 = (hashCode14 + (str8 == null ? 0 : str8.hashCode())) * 31;
        Float f11 = this.originalPrice;
        int hashCode16 = (hashCode15 + (f11 == null ? 0 : f11.hashCode())) * 31;
        Float f12 = this.packagingCharge;
        int hashCode17 = (hashCode16 + (f12 == null ? 0 : f12.hashCode())) * 31;
        Float f13 = this.price;
        int hashCode18 = (hashCode17 + (f13 == null ? 0 : f13.hashCode())) * 31;
        String str9 = this.sku;
        int hashCode19 = (hashCode18 + (str9 == null ? 0 : str9.hashCode())) * 31;
        Integer num4 = this.stockAmount;
        int hashCode20 = (hashCode19 + (num4 == null ? 0 : num4.hashCode())) * 31;
        List<String> list3 = this.tags;
        int hashCode21 = (hashCode20 + (list3 == null ? 0 : list3.hashCode())) * 31;
        SwimlaneProductTrackingResponse swimlaneProductTrackingResponse = this.f58448tracking;
        int hashCode22 = (hashCode21 + (swimlaneProductTrackingResponse == null ? 0 : swimlaneProductTrackingResponse.hashCode())) * 31;
        String str10 = this.trackingCode;
        int hashCode23 = (hashCode22 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.vendorId;
        int hashCode24 = (hashCode23 + (str11 == null ? 0 : str11.hashCode())) * 31;
        Boolean bool2 = this.isSponsored;
        int hashCode25 = (hashCode24 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        String str12 = this.offerText;
        if (str12 != null) {
            i11 = str12.hashCode();
        }
        return hashCode25 + i11;
    }

    @Nullable
    public final Boolean isAvailable() {
        return this.isAvailable;
    }

    @Nullable
    public final Boolean isSponsored() {
        return this.isSponsored;
    }

    @NotNull
    public String toString() {
        Integer num = this.ageLimit;
        List<ProductAttributesResponse> list = this.attributes;
        String str = this.categoryId;
        CharacteristicsResponse characteristicsResponse = this.characteristics;
        String str2 = this.description;
        Integer num2 = this.discount;
        Integer num3 = this.discountPercentage;
        String str3 = this.discountText;
        String str4 = this.globalCatalogId;
        String str5 = this.globalCatalogVendorId;
        String str6 = this.f58446id;
        String str7 = this.imageUrl;
        List<ImageUrlResponse> list2 = this.imageUrls;
        Boolean bool = this.isAvailable;
        String str8 = this.f58447name;
        Float f11 = this.originalPrice;
        Float f12 = this.packagingCharge;
        Float f13 = this.price;
        String str9 = this.sku;
        Integer num4 = this.stockAmount;
        List<String> list3 = this.tags;
        SwimlaneProductTrackingResponse swimlaneProductTrackingResponse = this.f58448tracking;
        String str10 = this.trackingCode;
        String str11 = this.vendorId;
        Boolean bool2 = this.isSponsored;
        String str12 = this.offerText;
        return "SwimlaneProductResponse(ageLimit=" + num + ", attributes=" + list + ", categoryId=" + str + ", characteristics=" + characteristicsResponse + ", description=" + str2 + ", discount=" + num2 + ", discountPercentage=" + num3 + ", discountText=" + str3 + ", globalCatalogId=" + str4 + ", globalCatalogVendorId=" + str5 + ", id=" + str6 + ", imageUrl=" + str7 + ", imageUrls=" + list2 + ", isAvailable=" + bool + ", name=" + str8 + ", originalPrice=" + f11 + ", packagingCharge=" + f12 + ", price=" + f13 + ", sku=" + str9 + ", stockAmount=" + num4 + ", tags=" + list3 + ", tracking=" + swimlaneProductTrackingResponse + ", trackingCode=" + str10 + ", vendorId=" + str11 + ", isSponsored=" + bool2 + ", offerText=" + str12 + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ SwimlaneProductResponse(java.lang.Integer r31, java.util.List r32, java.lang.String r33, com.talabat.feature.darkstores.vendorslanding.data.model.CharacteristicsResponse r34, java.lang.String r35, java.lang.Integer r36, java.lang.Integer r37, java.lang.String r38, java.lang.String r39, java.lang.String r40, java.lang.String r41, java.lang.String r42, java.util.List r43, java.lang.Boolean r44, java.lang.String r45, java.lang.Float r46, java.lang.Float r47, java.lang.Float r48, java.lang.String r49, java.lang.Integer r50, java.util.List r51, com.talabat.feature.darkstores.vendorslanding.data.model.SwimlaneProductTrackingResponse r52, java.lang.String r53, java.lang.String r54, java.lang.Boolean r55, java.lang.String r56, int r57, kotlin.jvm.internal.DefaultConstructorMarker r58) {
        /*
            r30 = this;
            r0 = r57
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r4 = r2
            goto L_0x000b
        L_0x0009:
            r4 = r31
        L_0x000b:
            r1 = r0 & 2
            if (r1 == 0) goto L_0x0011
            r5 = r2
            goto L_0x0013
        L_0x0011:
            r5 = r32
        L_0x0013:
            r1 = r0 & 8
            if (r1 == 0) goto L_0x0019
            r7 = r2
            goto L_0x001b
        L_0x0019:
            r7 = r34
        L_0x001b:
            r1 = r0 & 16
            if (r1 == 0) goto L_0x0021
            r8 = r2
            goto L_0x0023
        L_0x0021:
            r8 = r35
        L_0x0023:
            r1 = r0 & 32
            if (r1 == 0) goto L_0x0029
            r9 = r2
            goto L_0x002b
        L_0x0029:
            r9 = r36
        L_0x002b:
            r1 = r0 & 64
            if (r1 == 0) goto L_0x0031
            r10 = r2
            goto L_0x0033
        L_0x0031:
            r10 = r37
        L_0x0033:
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x0039
            r11 = r2
            goto L_0x003b
        L_0x0039:
            r11 = r38
        L_0x003b:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x0041
            r12 = r2
            goto L_0x0043
        L_0x0041:
            r12 = r39
        L_0x0043:
            r1 = r0 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x0049
            r13 = r2
            goto L_0x004b
        L_0x0049:
            r13 = r40
        L_0x004b:
            r1 = r0 & 2048(0x800, float:2.87E-42)
            if (r1 == 0) goto L_0x0051
            r15 = r2
            goto L_0x0053
        L_0x0051:
            r15 = r42
        L_0x0053:
            r1 = r0 & 4096(0x1000, float:5.74E-42)
            if (r1 == 0) goto L_0x005a
            r16 = r2
            goto L_0x005c
        L_0x005a:
            r16 = r43
        L_0x005c:
            r1 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r1 == 0) goto L_0x0065
            java.lang.Boolean r1 = java.lang.Boolean.FALSE
            r17 = r1
            goto L_0x0067
        L_0x0065:
            r17 = r44
        L_0x0067:
            r1 = 32768(0x8000, float:4.5918E-41)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x0070
            r19 = r2
            goto L_0x0072
        L_0x0070:
            r19 = r46
        L_0x0072:
            r1 = 65536(0x10000, float:9.18355E-41)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x007a
            r20 = r2
            goto L_0x007c
        L_0x007a:
            r20 = r47
        L_0x007c:
            r1 = 262144(0x40000, float:3.67342E-40)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x0084
            r22 = r2
            goto L_0x0086
        L_0x0084:
            r22 = r49
        L_0x0086:
            r1 = 524288(0x80000, float:7.34684E-40)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x008e
            r23 = r2
            goto L_0x0090
        L_0x008e:
            r23 = r50
        L_0x0090:
            r1 = 1048576(0x100000, float:1.469368E-39)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x0098
            r24 = r2
            goto L_0x009a
        L_0x0098:
            r24 = r51
        L_0x009a:
            r1 = 2097152(0x200000, float:2.938736E-39)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x00a2
            r25 = r2
            goto L_0x00a4
        L_0x00a2:
            r25 = r52
        L_0x00a4:
            r1 = 4194304(0x400000, float:5.877472E-39)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x00ac
            r26 = r2
            goto L_0x00ae
        L_0x00ac:
            r26 = r53
        L_0x00ae:
            r1 = 16777216(0x1000000, float:2.3509887E-38)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x00b8
            java.lang.Boolean r1 = java.lang.Boolean.FALSE
            r28 = r1
            goto L_0x00ba
        L_0x00b8:
            r28 = r55
        L_0x00ba:
            r1 = 33554432(0x2000000, float:9.403955E-38)
            r0 = r0 & r1
            if (r0 == 0) goto L_0x00c2
            r29 = r2
            goto L_0x00c4
        L_0x00c2:
            r29 = r56
        L_0x00c4:
            r3 = r30
            r6 = r33
            r14 = r41
            r18 = r45
            r21 = r48
            r27 = r54
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.darkstores.vendorslanding.data.model.SwimlaneProductResponse.<init>(java.lang.Integer, java.util.List, java.lang.String, com.talabat.feature.darkstores.vendorslanding.data.model.CharacteristicsResponse, java.lang.String, java.lang.Integer, java.lang.Integer, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.List, java.lang.Boolean, java.lang.String, java.lang.Float, java.lang.Float, java.lang.Float, java.lang.String, java.lang.Integer, java.util.List, com.talabat.feature.darkstores.vendorslanding.data.model.SwimlaneProductTrackingResponse, java.lang.String, java.lang.String, java.lang.Boolean, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
