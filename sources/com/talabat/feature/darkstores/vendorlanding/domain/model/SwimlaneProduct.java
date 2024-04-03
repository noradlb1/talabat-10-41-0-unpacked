package com.talabat.feature.darkstores.vendorlanding.domain.model;

import com.talabat.fluttercore.channels.AnalyticsMethodChannel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\bA\b\b\u0018\u00002\u00020\u0001B×\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u000e\u001a\u00020\b\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\b\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u0005\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\b\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\u0006\u0010\u0018\u001a\u00020\b\u0012\u0006\u0010\u0019\u001a\u00020\u0003\u0012\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\b0\u0005\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\u001e\u001a\u00020\b\u0012\u0006\u0010\u001f\u001a\u00020\u0013\u0012\b\u0010 \u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010!J\t\u0010A\u001a\u00020\u0003HÆ\u0003J\u000f\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00110\u0005HÆ\u0003J\t\u0010C\u001a\u00020\u0013HÆ\u0003J\t\u0010D\u001a\u00020\bHÆ\u0003J\u0010\u0010E\u001a\u0004\u0018\u00010\u0016HÆ\u0003¢\u0006\u0002\u00106J\t\u0010F\u001a\u00020\u0016HÆ\u0003J\t\u0010G\u001a\u00020\bHÆ\u0003J\t\u0010H\u001a\u00020\u0003HÆ\u0003J\u000f\u0010I\u001a\b\u0012\u0004\u0012\u00020\b0\u0005HÆ\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\u001cHÆ\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000f\u0010L\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010M\u001a\u00020\bHÆ\u0003J\t\u0010N\u001a\u00020\u0013HÆ\u0003J\u000b\u0010O\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u0010P\u001a\u00020\bHÆ\u0003J\t\u0010Q\u001a\u00020\nHÆ\u0003J\u000b\u0010R\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0010\u0010S\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010,J\u0010\u0010T\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010,J\t\u0010U\u001a\u00020\bHÆ\u0003J\u000b\u0010V\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0002\u0010W\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000e\u001a\u00020\b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b2\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\b2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00162\b\b\u0002\u0010\u0018\u001a\u00020\b2\b\b\u0002\u0010\u0019\u001a\u00020\u00032\u000e\b\u0002\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\b0\u00052\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u001e\u001a\u00020\b2\b\b\u0002\u0010\u001f\u001a\u00020\u00132\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010XJ\u0013\u0010Y\u001a\u00020\u00132\b\u0010Z\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010[\u001a\u00020\u0003HÖ\u0001J\t\u0010\\\u001a\u00020\bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b*\u0010'R\u0015\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010-\u001a\u0004\b+\u0010,R\u0015\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010-\u001a\u0004\b.\u0010,R\u0011\u0010\u000e\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b/\u0010'R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b0\u0010'R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u0005¢\u0006\b\n\u0000\u001a\u0004\b1\u0010%R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u00102R\u0011\u0010\u001f\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u00102R\u0011\u0010\u0014\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b3\u0010'R\u0013\u0010 \u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b4\u0010'R\u0015\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\n\n\u0002\u00107\u001a\u0004\b5\u00106R\u0011\u0010\u0017\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b8\u00109R\u0011\u0010\u0018\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b:\u0010'R\u0011\u0010\u0019\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b;\u0010#R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\b\n\u0000\u001a\u0004\b<\u0010%R\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u001c¢\u0006\b\n\u0000\u001a\u0004\b=\u0010>R\u0013\u0010\u001d\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b?\u0010'R\u0011\u0010\u001e\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b@\u0010'¨\u0006]"}, d2 = {"Lcom/talabat/feature/darkstores/vendorlanding/domain/model/SwimlaneProduct;", "", "ageLimit", "", "attributes", "", "Lcom/talabat/feature/darkstores/vendorlanding/domain/model/ProductAttributes;", "categoryId", "", "characteristics", "Lcom/talabat/feature/darkstores/vendorlanding/domain/model/Characteristics;", "description", "discount", "discountPercentage", "id", "imageUrl", "imageUrls", "Lcom/talabat/feature/darkstores/vendorlanding/domain/model/ImageUrl;", "isAvailable", "", "name", "originalPrice", "", "price", "sku", "stockAmount", "tags", "tracking", "Lcom/talabat/feature/darkstores/vendorlanding/domain/model/SwimlaneProductTracking;", "trackingCode", "vendorId", "isSponsored", "offerText", "(ILjava/util/List;Ljava/lang/String;Lcom/talabat/feature/darkstores/vendorlanding/domain/model/Characteristics;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;ZLjava/lang/String;Ljava/lang/Float;FLjava/lang/String;ILjava/util/List;Lcom/talabat/feature/darkstores/vendorlanding/domain/model/SwimlaneProductTracking;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "getAgeLimit", "()I", "getAttributes", "()Ljava/util/List;", "getCategoryId", "()Ljava/lang/String;", "getCharacteristics", "()Lcom/talabat/feature/darkstores/vendorlanding/domain/model/Characteristics;", "getDescription", "getDiscount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getDiscountPercentage", "getId", "getImageUrl", "getImageUrls", "()Z", "getName", "getOfferText", "getOriginalPrice", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getPrice", "()F", "getSku", "getStockAmount", "getTags", "getTracking", "()Lcom/talabat/feature/darkstores/vendorlanding/domain/model/SwimlaneProductTracking;", "getTrackingCode", "getVendorId", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(ILjava/util/List;Ljava/lang/String;Lcom/talabat/feature/darkstores/vendorlanding/domain/model/Characteristics;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;ZLjava/lang/String;Ljava/lang/Float;FLjava/lang/String;ILjava/util/List;Lcom/talabat/feature/darkstores/vendorlanding/domain/model/SwimlaneProductTracking;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)Lcom/talabat/feature/darkstores/vendorlanding/domain/model/SwimlaneProduct;", "equals", "other", "hashCode", "toString", "com_talabat_feature_darkstores-vendor-landing_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SwimlaneProduct {
    private final int ageLimit;
    @NotNull
    private final List<ProductAttributes> attributes;
    @NotNull
    private final String categoryId;
    @NotNull
    private final Characteristics characteristics;
    @Nullable
    private final String description;
    @Nullable
    private final Integer discount;
    @Nullable
    private final Integer discountPercentage;
    @NotNull

    /* renamed from: id  reason: collision with root package name */
    private final String f58429id;
    @Nullable
    private final String imageUrl;
    @NotNull
    private final List<ImageUrl> imageUrls;
    private final boolean isAvailable;
    private final boolean isSponsored;
    @NotNull

    /* renamed from: name  reason: collision with root package name */
    private final String f58430name;
    @Nullable
    private final String offerText;
    @Nullable
    private final Float originalPrice;
    private final float price;
    @NotNull
    private final String sku;
    private final int stockAmount;
    @NotNull
    private final List<String> tags;
    @Nullable

    /* renamed from: tracking  reason: collision with root package name */
    private final SwimlaneProductTracking f58431tracking;
    @Nullable
    private final String trackingCode;
    @NotNull
    private final String vendorId;

    public SwimlaneProduct(int i11, @NotNull List<ProductAttributes> list, @NotNull String str, @NotNull Characteristics characteristics2, @Nullable String str2, @Nullable Integer num, @Nullable Integer num2, @NotNull String str3, @Nullable String str4, @NotNull List<ImageUrl> list2, boolean z11, @NotNull String str5, @Nullable Float f11, float f12, @NotNull String str6, int i12, @NotNull List<String> list3, @Nullable SwimlaneProductTracking swimlaneProductTracking, @Nullable String str7, @NotNull String str8, boolean z12, @Nullable String str9) {
        String str10 = str3;
        List<ImageUrl> list4 = list2;
        String str11 = str5;
        String str12 = str6;
        List<String> list5 = list3;
        String str13 = str8;
        Intrinsics.checkNotNullParameter(list, AnalyticsMethodChannel.EVENT_ATTRIBUTES_KEY);
        Intrinsics.checkNotNullParameter(str, "categoryId");
        Intrinsics.checkNotNullParameter(characteristics2, "characteristics");
        Intrinsics.checkNotNullParameter(str10, "id");
        Intrinsics.checkNotNullParameter(list4, "imageUrls");
        Intrinsics.checkNotNullParameter(str11, "name");
        Intrinsics.checkNotNullParameter(str12, "sku");
        Intrinsics.checkNotNullParameter(list5, "tags");
        Intrinsics.checkNotNullParameter(str13, "vendorId");
        this.ageLimit = i11;
        this.attributes = list;
        this.categoryId = str;
        this.characteristics = characteristics2;
        this.description = str2;
        this.discount = num;
        this.discountPercentage = num2;
        this.f58429id = str10;
        this.imageUrl = str4;
        this.imageUrls = list4;
        this.isAvailable = z11;
        this.f58430name = str11;
        this.originalPrice = f11;
        this.price = f12;
        this.sku = str12;
        this.stockAmount = i12;
        this.tags = list5;
        this.f58431tracking = swimlaneProductTracking;
        this.trackingCode = str7;
        this.vendorId = str13;
        this.isSponsored = z12;
        this.offerText = str9;
    }

    public static /* synthetic */ SwimlaneProduct copy$default(SwimlaneProduct swimlaneProduct, int i11, List list, String str, Characteristics characteristics2, String str2, Integer num, Integer num2, String str3, String str4, List list2, boolean z11, String str5, Float f11, float f12, String str6, int i12, List list3, SwimlaneProductTracking swimlaneProductTracking, String str7, String str8, boolean z12, String str9, int i13, Object obj) {
        SwimlaneProduct swimlaneProduct2 = swimlaneProduct;
        int i14 = i13;
        return swimlaneProduct.copy((i14 & 1) != 0 ? swimlaneProduct2.ageLimit : i11, (i14 & 2) != 0 ? swimlaneProduct2.attributes : list, (i14 & 4) != 0 ? swimlaneProduct2.categoryId : str, (i14 & 8) != 0 ? swimlaneProduct2.characteristics : characteristics2, (i14 & 16) != 0 ? swimlaneProduct2.description : str2, (i14 & 32) != 0 ? swimlaneProduct2.discount : num, (i14 & 64) != 0 ? swimlaneProduct2.discountPercentage : num2, (i14 & 128) != 0 ? swimlaneProduct2.f58429id : str3, (i14 & 256) != 0 ? swimlaneProduct2.imageUrl : str4, (i14 & 512) != 0 ? swimlaneProduct2.imageUrls : list2, (i14 & 1024) != 0 ? swimlaneProduct2.isAvailable : z11, (i14 & 2048) != 0 ? swimlaneProduct2.f58430name : str5, (i14 & 4096) != 0 ? swimlaneProduct2.originalPrice : f11, (i14 & 8192) != 0 ? swimlaneProduct2.price : f12, (i14 & 16384) != 0 ? swimlaneProduct2.sku : str6, (i14 & 32768) != 0 ? swimlaneProduct2.stockAmount : i12, (i14 & 65536) != 0 ? swimlaneProduct2.tags : list3, (i14 & 131072) != 0 ? swimlaneProduct2.f58431tracking : swimlaneProductTracking, (i14 & 262144) != 0 ? swimlaneProduct2.trackingCode : str7, (i14 & 524288) != 0 ? swimlaneProduct2.vendorId : str8, (i14 & 1048576) != 0 ? swimlaneProduct2.isSponsored : z12, (i14 & 2097152) != 0 ? swimlaneProduct2.offerText : str9);
    }

    public final int component1() {
        return this.ageLimit;
    }

    @NotNull
    public final List<ImageUrl> component10() {
        return this.imageUrls;
    }

    public final boolean component11() {
        return this.isAvailable;
    }

    @NotNull
    public final String component12() {
        return this.f58430name;
    }

    @Nullable
    public final Float component13() {
        return this.originalPrice;
    }

    public final float component14() {
        return this.price;
    }

    @NotNull
    public final String component15() {
        return this.sku;
    }

    public final int component16() {
        return this.stockAmount;
    }

    @NotNull
    public final List<String> component17() {
        return this.tags;
    }

    @Nullable
    public final SwimlaneProductTracking component18() {
        return this.f58431tracking;
    }

    @Nullable
    public final String component19() {
        return this.trackingCode;
    }

    @NotNull
    public final List<ProductAttributes> component2() {
        return this.attributes;
    }

    @NotNull
    public final String component20() {
        return this.vendorId;
    }

    public final boolean component21() {
        return this.isSponsored;
    }

    @Nullable
    public final String component22() {
        return this.offerText;
    }

    @NotNull
    public final String component3() {
        return this.categoryId;
    }

    @NotNull
    public final Characteristics component4() {
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

    @NotNull
    public final String component8() {
        return this.f58429id;
    }

    @Nullable
    public final String component9() {
        return this.imageUrl;
    }

    @NotNull
    public final SwimlaneProduct copy(int i11, @NotNull List<ProductAttributes> list, @NotNull String str, @NotNull Characteristics characteristics2, @Nullable String str2, @Nullable Integer num, @Nullable Integer num2, @NotNull String str3, @Nullable String str4, @NotNull List<ImageUrl> list2, boolean z11, @NotNull String str5, @Nullable Float f11, float f12, @NotNull String str6, int i12, @NotNull List<String> list3, @Nullable SwimlaneProductTracking swimlaneProductTracking, @Nullable String str7, @NotNull String str8, boolean z12, @Nullable String str9) {
        int i13 = i11;
        Intrinsics.checkNotNullParameter(list, AnalyticsMethodChannel.EVENT_ATTRIBUTES_KEY);
        Intrinsics.checkNotNullParameter(str, "categoryId");
        Intrinsics.checkNotNullParameter(characteristics2, "characteristics");
        Intrinsics.checkNotNullParameter(str3, "id");
        Intrinsics.checkNotNullParameter(list2, "imageUrls");
        Intrinsics.checkNotNullParameter(str5, "name");
        Intrinsics.checkNotNullParameter(str6, "sku");
        Intrinsics.checkNotNullParameter(list3, "tags");
        Intrinsics.checkNotNullParameter(str8, "vendorId");
        return new SwimlaneProduct(i11, list, str, characteristics2, str2, num, num2, str3, str4, list2, z11, str5, f11, f12, str6, i12, list3, swimlaneProductTracking, str7, str8, z12, str9);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SwimlaneProduct)) {
            return false;
        }
        SwimlaneProduct swimlaneProduct = (SwimlaneProduct) obj;
        return this.ageLimit == swimlaneProduct.ageLimit && Intrinsics.areEqual((Object) this.attributes, (Object) swimlaneProduct.attributes) && Intrinsics.areEqual((Object) this.categoryId, (Object) swimlaneProduct.categoryId) && Intrinsics.areEqual((Object) this.characteristics, (Object) swimlaneProduct.characteristics) && Intrinsics.areEqual((Object) this.description, (Object) swimlaneProduct.description) && Intrinsics.areEqual((Object) this.discount, (Object) swimlaneProduct.discount) && Intrinsics.areEqual((Object) this.discountPercentage, (Object) swimlaneProduct.discountPercentage) && Intrinsics.areEqual((Object) this.f58429id, (Object) swimlaneProduct.f58429id) && Intrinsics.areEqual((Object) this.imageUrl, (Object) swimlaneProduct.imageUrl) && Intrinsics.areEqual((Object) this.imageUrls, (Object) swimlaneProduct.imageUrls) && this.isAvailable == swimlaneProduct.isAvailable && Intrinsics.areEqual((Object) this.f58430name, (Object) swimlaneProduct.f58430name) && Intrinsics.areEqual((Object) this.originalPrice, (Object) swimlaneProduct.originalPrice) && Intrinsics.areEqual((Object) Float.valueOf(this.price), (Object) Float.valueOf(swimlaneProduct.price)) && Intrinsics.areEqual((Object) this.sku, (Object) swimlaneProduct.sku) && this.stockAmount == swimlaneProduct.stockAmount && Intrinsics.areEqual((Object) this.tags, (Object) swimlaneProduct.tags) && Intrinsics.areEqual((Object) this.f58431tracking, (Object) swimlaneProduct.f58431tracking) && Intrinsics.areEqual((Object) this.trackingCode, (Object) swimlaneProduct.trackingCode) && Intrinsics.areEqual((Object) this.vendorId, (Object) swimlaneProduct.vendorId) && this.isSponsored == swimlaneProduct.isSponsored && Intrinsics.areEqual((Object) this.offerText, (Object) swimlaneProduct.offerText);
    }

    public final int getAgeLimit() {
        return this.ageLimit;
    }

    @NotNull
    public final List<ProductAttributes> getAttributes() {
        return this.attributes;
    }

    @NotNull
    public final String getCategoryId() {
        return this.categoryId;
    }

    @NotNull
    public final Characteristics getCharacteristics() {
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

    @NotNull
    public final String getId() {
        return this.f58429id;
    }

    @Nullable
    public final String getImageUrl() {
        return this.imageUrl;
    }

    @NotNull
    public final List<ImageUrl> getImageUrls() {
        return this.imageUrls;
    }

    @NotNull
    public final String getName() {
        return this.f58430name;
    }

    @Nullable
    public final String getOfferText() {
        return this.offerText;
    }

    @Nullable
    public final Float getOriginalPrice() {
        return this.originalPrice;
    }

    public final float getPrice() {
        return this.price;
    }

    @NotNull
    public final String getSku() {
        return this.sku;
    }

    public final int getStockAmount() {
        return this.stockAmount;
    }

    @NotNull
    public final List<String> getTags() {
        return this.tags;
    }

    @Nullable
    public final SwimlaneProductTracking getTracking() {
        return this.f58431tracking;
    }

    @Nullable
    public final String getTrackingCode() {
        return this.trackingCode;
    }

    @NotNull
    public final String getVendorId() {
        return this.vendorId;
    }

    public int hashCode() {
        int hashCode = ((((((this.ageLimit * 31) + this.attributes.hashCode()) * 31) + this.categoryId.hashCode()) * 31) + this.characteristics.hashCode()) * 31;
        String str = this.description;
        int i11 = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        Integer num = this.discount;
        int hashCode3 = (hashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.discountPercentage;
        int hashCode4 = (((hashCode3 + (num2 == null ? 0 : num2.hashCode())) * 31) + this.f58429id.hashCode()) * 31;
        String str2 = this.imageUrl;
        int hashCode5 = (((hashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.imageUrls.hashCode()) * 31;
        boolean z11 = this.isAvailable;
        boolean z12 = true;
        if (z11) {
            z11 = true;
        }
        int hashCode6 = (((hashCode5 + (z11 ? 1 : 0)) * 31) + this.f58430name.hashCode()) * 31;
        Float f11 = this.originalPrice;
        int hashCode7 = (((((((((hashCode6 + (f11 == null ? 0 : f11.hashCode())) * 31) + Float.floatToIntBits(this.price)) * 31) + this.sku.hashCode()) * 31) + this.stockAmount) * 31) + this.tags.hashCode()) * 31;
        SwimlaneProductTracking swimlaneProductTracking = this.f58431tracking;
        int hashCode8 = (hashCode7 + (swimlaneProductTracking == null ? 0 : swimlaneProductTracking.hashCode())) * 31;
        String str3 = this.trackingCode;
        int hashCode9 = (((hashCode8 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.vendorId.hashCode()) * 31;
        boolean z13 = this.isSponsored;
        if (!z13) {
            z12 = z13;
        }
        int i12 = (hashCode9 + (z12 ? 1 : 0)) * 31;
        String str4 = this.offerText;
        if (str4 != null) {
            i11 = str4.hashCode();
        }
        return i12 + i11;
    }

    public final boolean isAvailable() {
        return this.isAvailable;
    }

    public final boolean isSponsored() {
        return this.isSponsored;
    }

    @NotNull
    public String toString() {
        int i11 = this.ageLimit;
        List<ProductAttributes> list = this.attributes;
        String str = this.categoryId;
        Characteristics characteristics2 = this.characteristics;
        String str2 = this.description;
        Integer num = this.discount;
        Integer num2 = this.discountPercentage;
        String str3 = this.f58429id;
        String str4 = this.imageUrl;
        List<ImageUrl> list2 = this.imageUrls;
        boolean z11 = this.isAvailable;
        String str5 = this.f58430name;
        Float f11 = this.originalPrice;
        float f12 = this.price;
        String str6 = this.sku;
        int i12 = this.stockAmount;
        List<String> list3 = this.tags;
        SwimlaneProductTracking swimlaneProductTracking = this.f58431tracking;
        String str7 = this.trackingCode;
        String str8 = this.vendorId;
        boolean z12 = this.isSponsored;
        String str9 = this.offerText;
        return "SwimlaneProduct(ageLimit=" + i11 + ", attributes=" + list + ", categoryId=" + str + ", characteristics=" + characteristics2 + ", description=" + str2 + ", discount=" + num + ", discountPercentage=" + num2 + ", id=" + str3 + ", imageUrl=" + str4 + ", imageUrls=" + list2 + ", isAvailable=" + z11 + ", name=" + str5 + ", originalPrice=" + f11 + ", price=" + f12 + ", sku=" + str6 + ", stockAmount=" + i12 + ", tags=" + list3 + ", tracking=" + swimlaneProductTracking + ", trackingCode=" + str7 + ", vendorId=" + str8 + ", isSponsored=" + z12 + ", offerText=" + str9 + ")";
    }
}
