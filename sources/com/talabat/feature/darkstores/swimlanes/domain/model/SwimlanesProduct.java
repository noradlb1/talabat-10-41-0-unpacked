package com.talabat.feature.darkstores.swimlanes.domain.model;

import com.talabat.fluttercore.channels.AnalyticsMethodChannel;
import com.talabat.observability.squads.nfv.ObservableAttributesNames;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b7\b\b\u0018\u00002\u00020\u0001B¿\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000e\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0003\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\t\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u0012\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\t\u0012\u0006\u0010\u001c\u001a\u00020\u001d\u0012\u0006\u0010\u001e\u001a\u00020\u0015¢\u0006\u0002\u0010\u001fJ\t\u0010:\u001a\u00020\u0003HÆ\u0003J\t\u0010;\u001a\u00020\fHÆ\u0003J\t\u0010<\u001a\u00020\u0003HÆ\u0003J\t\u0010=\u001a\u00020\u0003HÆ\u0003J\t\u0010>\u001a\u00020\u0003HÆ\u0003J\t\u0010?\u001a\u00020\u0003HÆ\u0003J\t\u0010@\u001a\u00020\u0015HÆ\u0003J\t\u0010A\u001a\u00020\u0003HÆ\u0003J\u000f\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00030\tHÆ\u0003J\t\u0010C\u001a\u00020\u0019HÆ\u0003J\u000f\u0010D\u001a\b\u0012\u0004\u0012\u00020\u001b0\tHÆ\u0003J\t\u0010E\u001a\u00020\u0003HÆ\u0003J\t\u0010F\u001a\u00020\u001dHÆ\u0003J\t\u0010G\u001a\u00020\u0015HÆ\u0003J\t\u0010H\u001a\u00020\u0003HÆ\u0003J\t\u0010I\u001a\u00020\u0003HÆ\u0003J\t\u0010J\u001a\u00020\u0003HÆ\u0003J\u000f\u0010K\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J\t\u0010L\u001a\u00020\fHÆ\u0003J\t\u0010M\u001a\u00020\fHÆ\u0003J\t\u0010N\u001a\u00020\fHÆ\u0003Jí\u0001\u0010O\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\f2\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00032\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\t2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\u000e\b\u0002\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\t2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u0015HÆ\u0001J\u0013\u0010P\u001a\u00020\u00192\b\u0010Q\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010R\u001a\u00020\u0015HÖ\u0001J\t\u0010S\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u001e\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\t¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\u0013\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010\u001c\u001a\u00020\u001d¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010%R\u0011\u0010\u000e\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0011\u0010\u000f\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b+\u0010*R\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b,\u0010%R\u0011\u0010\u0011\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b-\u0010%R\u0011\u0010\u0012\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b.\u0010%R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b/\u0010%R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b0\u0010%R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b1\u0010#R\u0011\u0010\u0018\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u00102R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b3\u0010%R\u0011\u0010\r\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b4\u0010*R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b5\u0010*R\u0011\u0010\u0016\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b6\u0010%R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b7\u0010!R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\t¢\u0006\b\n\u0000\u001a\u0004\b8\u0010#R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b9\u0010%¨\u0006T"}, d2 = {"Lcom/talabat/feature/darkstores/swimlanes/domain/model/SwimlanesProduct;", "", "id", "", "vendorId", "name", "description", "imageUrl", "imageUrls", "", "Lcom/talabat/feature/darkstores/swimlanes/domain/model/SwimlanesProductUrl;", "price", "", "originalPrice", "discount", "discountPercentage", "discountText", "globalCatalogId", "globalCatalogVendorId", "categoryId", "stockAmount", "", "sku", "tags", "isAvailable", "", "attributes", "Lcom/talabat/feature/darkstores/swimlanes/domain/model/ProductAttributes;", "characteristics", "Lcom/talabat/feature/darkstores/swimlanes/domain/model/ProductCharacteristics;", "ageLimit", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;FFFFLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/util/List;ZLjava/util/List;Lcom/talabat/feature/darkstores/swimlanes/domain/model/ProductCharacteristics;I)V", "getAgeLimit", "()I", "getAttributes", "()Ljava/util/List;", "getCategoryId", "()Ljava/lang/String;", "getCharacteristics", "()Lcom/talabat/feature/darkstores/swimlanes/domain/model/ProductCharacteristics;", "getDescription", "getDiscount", "()F", "getDiscountPercentage", "getDiscountText", "getGlobalCatalogId", "getGlobalCatalogVendorId", "getId", "getImageUrl", "getImageUrls", "()Z", "getName", "getOriginalPrice", "getPrice", "getSku", "getStockAmount", "getTags", "getVendorId", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "com_talabat_feature_darkstores-swimlanes_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SwimlanesProduct {
    private final int ageLimit;
    @NotNull
    private final List<ProductAttributes> attributes;
    @NotNull
    private final String categoryId;
    @NotNull
    private final ProductCharacteristics characteristics;
    @NotNull
    private final String description;
    private final float discount;
    private final float discountPercentage;
    @NotNull
    private final String discountText;
    @NotNull
    private final String globalCatalogId;
    @NotNull
    private final String globalCatalogVendorId;
    @NotNull

    /* renamed from: id  reason: collision with root package name */
    private final String f58414id;
    @NotNull
    private final String imageUrl;
    @NotNull
    private final List<SwimlanesProductUrl> imageUrls;
    private final boolean isAvailable;
    @NotNull

    /* renamed from: name  reason: collision with root package name */
    private final String f58415name;
    private final float originalPrice;
    private final float price;
    @NotNull
    private final String sku;
    private final int stockAmount;
    @NotNull
    private final List<String> tags;
    @NotNull
    private final String vendorId;

    public SwimlanesProduct(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull List<SwimlanesProductUrl> list, float f11, float f12, float f13, float f14, @NotNull String str6, @NotNull String str7, @NotNull String str8, @NotNull String str9, int i11, @NotNull String str10, @NotNull List<String> list2, boolean z11, @NotNull List<ProductAttributes> list3, @NotNull ProductCharacteristics productCharacteristics, int i12) {
        String str11 = str;
        String str12 = str2;
        String str13 = str3;
        String str14 = str4;
        String str15 = str5;
        List<SwimlanesProductUrl> list4 = list;
        String str16 = str6;
        String str17 = str7;
        String str18 = str8;
        String str19 = str9;
        String str20 = str10;
        List<String> list5 = list2;
        List<ProductAttributes> list6 = list3;
        ProductCharacteristics productCharacteristics2 = productCharacteristics;
        Intrinsics.checkNotNullParameter(str11, "id");
        Intrinsics.checkNotNullParameter(str12, "vendorId");
        Intrinsics.checkNotNullParameter(str13, "name");
        Intrinsics.checkNotNullParameter(str14, "description");
        Intrinsics.checkNotNullParameter(str15, ObservableAttributesNames.IMAGE_URL_V2);
        Intrinsics.checkNotNullParameter(list4, "imageUrls");
        Intrinsics.checkNotNullParameter(str16, "discountText");
        Intrinsics.checkNotNullParameter(str17, "globalCatalogId");
        Intrinsics.checkNotNullParameter(str18, "globalCatalogVendorId");
        Intrinsics.checkNotNullParameter(str19, "categoryId");
        Intrinsics.checkNotNullParameter(str20, "sku");
        Intrinsics.checkNotNullParameter(list5, "tags");
        Intrinsics.checkNotNullParameter(list6, AnalyticsMethodChannel.EVENT_ATTRIBUTES_KEY);
        Intrinsics.checkNotNullParameter(productCharacteristics2, "characteristics");
        this.f58414id = str11;
        this.vendorId = str12;
        this.f58415name = str13;
        this.description = str14;
        this.imageUrl = str15;
        this.imageUrls = list4;
        this.price = f11;
        this.originalPrice = f12;
        this.discount = f13;
        this.discountPercentage = f14;
        this.discountText = str16;
        this.globalCatalogId = str17;
        this.globalCatalogVendorId = str18;
        this.categoryId = str19;
        this.stockAmount = i11;
        this.sku = str20;
        this.tags = list5;
        this.isAvailable = z11;
        this.attributes = list6;
        this.characteristics = productCharacteristics2;
        this.ageLimit = i12;
    }

    public static /* synthetic */ SwimlanesProduct copy$default(SwimlanesProduct swimlanesProduct, String str, String str2, String str3, String str4, String str5, List list, float f11, float f12, float f13, float f14, String str6, String str7, String str8, String str9, int i11, String str10, List list2, boolean z11, List list3, ProductCharacteristics productCharacteristics, int i12, int i13, Object obj) {
        SwimlanesProduct swimlanesProduct2 = swimlanesProduct;
        int i14 = i13;
        return swimlanesProduct.copy((i14 & 1) != 0 ? swimlanesProduct2.f58414id : str, (i14 & 2) != 0 ? swimlanesProduct2.vendorId : str2, (i14 & 4) != 0 ? swimlanesProduct2.f58415name : str3, (i14 & 8) != 0 ? swimlanesProduct2.description : str4, (i14 & 16) != 0 ? swimlanesProduct2.imageUrl : str5, (i14 & 32) != 0 ? swimlanesProduct2.imageUrls : list, (i14 & 64) != 0 ? swimlanesProduct2.price : f11, (i14 & 128) != 0 ? swimlanesProduct2.originalPrice : f12, (i14 & 256) != 0 ? swimlanesProduct2.discount : f13, (i14 & 512) != 0 ? swimlanesProduct2.discountPercentage : f14, (i14 & 1024) != 0 ? swimlanesProduct2.discountText : str6, (i14 & 2048) != 0 ? swimlanesProduct2.globalCatalogId : str7, (i14 & 4096) != 0 ? swimlanesProduct2.globalCatalogVendorId : str8, (i14 & 8192) != 0 ? swimlanesProduct2.categoryId : str9, (i14 & 16384) != 0 ? swimlanesProduct2.stockAmount : i11, (i14 & 32768) != 0 ? swimlanesProduct2.sku : str10, (i14 & 65536) != 0 ? swimlanesProduct2.tags : list2, (i14 & 131072) != 0 ? swimlanesProduct2.isAvailable : z11, (i14 & 262144) != 0 ? swimlanesProduct2.attributes : list3, (i14 & 524288) != 0 ? swimlanesProduct2.characteristics : productCharacteristics, (i14 & 1048576) != 0 ? swimlanesProduct2.ageLimit : i12);
    }

    @NotNull
    public final String component1() {
        return this.f58414id;
    }

    public final float component10() {
        return this.discountPercentage;
    }

    @NotNull
    public final String component11() {
        return this.discountText;
    }

    @NotNull
    public final String component12() {
        return this.globalCatalogId;
    }

    @NotNull
    public final String component13() {
        return this.globalCatalogVendorId;
    }

    @NotNull
    public final String component14() {
        return this.categoryId;
    }

    public final int component15() {
        return this.stockAmount;
    }

    @NotNull
    public final String component16() {
        return this.sku;
    }

    @NotNull
    public final List<String> component17() {
        return this.tags;
    }

    public final boolean component18() {
        return this.isAvailable;
    }

    @NotNull
    public final List<ProductAttributes> component19() {
        return this.attributes;
    }

    @NotNull
    public final String component2() {
        return this.vendorId;
    }

    @NotNull
    public final ProductCharacteristics component20() {
        return this.characteristics;
    }

    public final int component21() {
        return this.ageLimit;
    }

    @NotNull
    public final String component3() {
        return this.f58415name;
    }

    @NotNull
    public final String component4() {
        return this.description;
    }

    @NotNull
    public final String component5() {
        return this.imageUrl;
    }

    @NotNull
    public final List<SwimlanesProductUrl> component6() {
        return this.imageUrls;
    }

    public final float component7() {
        return this.price;
    }

    public final float component8() {
        return this.originalPrice;
    }

    public final float component9() {
        return this.discount;
    }

    @NotNull
    public final SwimlanesProduct copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull List<SwimlanesProductUrl> list, float f11, float f12, float f13, float f14, @NotNull String str6, @NotNull String str7, @NotNull String str8, @NotNull String str9, int i11, @NotNull String str10, @NotNull List<String> list2, boolean z11, @NotNull List<ProductAttributes> list3, @NotNull ProductCharacteristics productCharacteristics, int i12) {
        String str11 = str;
        Intrinsics.checkNotNullParameter(str11, "id");
        Intrinsics.checkNotNullParameter(str2, "vendorId");
        Intrinsics.checkNotNullParameter(str3, "name");
        Intrinsics.checkNotNullParameter(str4, "description");
        Intrinsics.checkNotNullParameter(str5, ObservableAttributesNames.IMAGE_URL_V2);
        Intrinsics.checkNotNullParameter(list, "imageUrls");
        Intrinsics.checkNotNullParameter(str6, "discountText");
        Intrinsics.checkNotNullParameter(str7, "globalCatalogId");
        Intrinsics.checkNotNullParameter(str8, "globalCatalogVendorId");
        Intrinsics.checkNotNullParameter(str9, "categoryId");
        Intrinsics.checkNotNullParameter(str10, "sku");
        Intrinsics.checkNotNullParameter(list2, "tags");
        Intrinsics.checkNotNullParameter(list3, AnalyticsMethodChannel.EVENT_ATTRIBUTES_KEY);
        Intrinsics.checkNotNullParameter(productCharacteristics, "characteristics");
        return new SwimlanesProduct(str11, str2, str3, str4, str5, list, f11, f12, f13, f14, str6, str7, str8, str9, i11, str10, list2, z11, list3, productCharacteristics, i12);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SwimlanesProduct)) {
            return false;
        }
        SwimlanesProduct swimlanesProduct = (SwimlanesProduct) obj;
        return Intrinsics.areEqual((Object) this.f58414id, (Object) swimlanesProduct.f58414id) && Intrinsics.areEqual((Object) this.vendorId, (Object) swimlanesProduct.vendorId) && Intrinsics.areEqual((Object) this.f58415name, (Object) swimlanesProduct.f58415name) && Intrinsics.areEqual((Object) this.description, (Object) swimlanesProduct.description) && Intrinsics.areEqual((Object) this.imageUrl, (Object) swimlanesProduct.imageUrl) && Intrinsics.areEqual((Object) this.imageUrls, (Object) swimlanesProduct.imageUrls) && Intrinsics.areEqual((Object) Float.valueOf(this.price), (Object) Float.valueOf(swimlanesProduct.price)) && Intrinsics.areEqual((Object) Float.valueOf(this.originalPrice), (Object) Float.valueOf(swimlanesProduct.originalPrice)) && Intrinsics.areEqual((Object) Float.valueOf(this.discount), (Object) Float.valueOf(swimlanesProduct.discount)) && Intrinsics.areEqual((Object) Float.valueOf(this.discountPercentage), (Object) Float.valueOf(swimlanesProduct.discountPercentage)) && Intrinsics.areEqual((Object) this.discountText, (Object) swimlanesProduct.discountText) && Intrinsics.areEqual((Object) this.globalCatalogId, (Object) swimlanesProduct.globalCatalogId) && Intrinsics.areEqual((Object) this.globalCatalogVendorId, (Object) swimlanesProduct.globalCatalogVendorId) && Intrinsics.areEqual((Object) this.categoryId, (Object) swimlanesProduct.categoryId) && this.stockAmount == swimlanesProduct.stockAmount && Intrinsics.areEqual((Object) this.sku, (Object) swimlanesProduct.sku) && Intrinsics.areEqual((Object) this.tags, (Object) swimlanesProduct.tags) && this.isAvailable == swimlanesProduct.isAvailable && Intrinsics.areEqual((Object) this.attributes, (Object) swimlanesProduct.attributes) && Intrinsics.areEqual((Object) this.characteristics, (Object) swimlanesProduct.characteristics) && this.ageLimit == swimlanesProduct.ageLimit;
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
    public final ProductCharacteristics getCharacteristics() {
        return this.characteristics;
    }

    @NotNull
    public final String getDescription() {
        return this.description;
    }

    public final float getDiscount() {
        return this.discount;
    }

    public final float getDiscountPercentage() {
        return this.discountPercentage;
    }

    @NotNull
    public final String getDiscountText() {
        return this.discountText;
    }

    @NotNull
    public final String getGlobalCatalogId() {
        return this.globalCatalogId;
    }

    @NotNull
    public final String getGlobalCatalogVendorId() {
        return this.globalCatalogVendorId;
    }

    @NotNull
    public final String getId() {
        return this.f58414id;
    }

    @NotNull
    public final String getImageUrl() {
        return this.imageUrl;
    }

    @NotNull
    public final List<SwimlanesProductUrl> getImageUrls() {
        return this.imageUrls;
    }

    @NotNull
    public final String getName() {
        return this.f58415name;
    }

    public final float getOriginalPrice() {
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

    @NotNull
    public final String getVendorId() {
        return this.vendorId;
    }

    public int hashCode() {
        int hashCode = ((((((((((((((((((((((((((((((((this.f58414id.hashCode() * 31) + this.vendorId.hashCode()) * 31) + this.f58415name.hashCode()) * 31) + this.description.hashCode()) * 31) + this.imageUrl.hashCode()) * 31) + this.imageUrls.hashCode()) * 31) + Float.floatToIntBits(this.price)) * 31) + Float.floatToIntBits(this.originalPrice)) * 31) + Float.floatToIntBits(this.discount)) * 31) + Float.floatToIntBits(this.discountPercentage)) * 31) + this.discountText.hashCode()) * 31) + this.globalCatalogId.hashCode()) * 31) + this.globalCatalogVendorId.hashCode()) * 31) + this.categoryId.hashCode()) * 31) + this.stockAmount) * 31) + this.sku.hashCode()) * 31) + this.tags.hashCode()) * 31;
        boolean z11 = this.isAvailable;
        if (z11) {
            z11 = true;
        }
        return ((((((hashCode + (z11 ? 1 : 0)) * 31) + this.attributes.hashCode()) * 31) + this.characteristics.hashCode()) * 31) + this.ageLimit;
    }

    public final boolean isAvailable() {
        return this.isAvailable;
    }

    @NotNull
    public String toString() {
        String str = this.f58414id;
        String str2 = this.vendorId;
        String str3 = this.f58415name;
        String str4 = this.description;
        String str5 = this.imageUrl;
        List<SwimlanesProductUrl> list = this.imageUrls;
        float f11 = this.price;
        float f12 = this.originalPrice;
        float f13 = this.discount;
        float f14 = this.discountPercentage;
        String str6 = this.discountText;
        String str7 = this.globalCatalogId;
        String str8 = this.globalCatalogVendorId;
        String str9 = this.categoryId;
        int i11 = this.stockAmount;
        String str10 = this.sku;
        List<String> list2 = this.tags;
        boolean z11 = this.isAvailable;
        List<ProductAttributes> list3 = this.attributes;
        ProductCharacteristics productCharacteristics = this.characteristics;
        int i12 = this.ageLimit;
        return "SwimlanesProduct(id=" + str + ", vendorId=" + str2 + ", name=" + str3 + ", description=" + str4 + ", imageUrl=" + str5 + ", imageUrls=" + list + ", price=" + f11 + ", originalPrice=" + f12 + ", discount=" + f13 + ", discountPercentage=" + f14 + ", discountText=" + str6 + ", globalCatalogId=" + str7 + ", globalCatalogVendorId=" + str8 + ", categoryId=" + str9 + ", stockAmount=" + i11 + ", sku=" + str10 + ", tags=" + list2 + ", isAvailable=" + z11 + ", attributes=" + list3 + ", characteristics=" + productCharacteristics + ", ageLimit=" + i12 + ")";
    }
}
