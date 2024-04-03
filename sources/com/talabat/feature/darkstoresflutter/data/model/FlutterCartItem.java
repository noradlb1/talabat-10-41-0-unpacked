package com.talabat.feature.darkstoresflutter.data.model;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b@\b\b\u0018\u00002\u00020\u0001B\u0002\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0001\u0010\u0007\u001a\u00020\b\u0012\b\b\u0001\u0010\t\u001a\u00020\b\u0012\u000e\b\u0001\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\b\b\u0001\u0010\r\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u000e\u001a\u00020\b\u0012\b\b\u0001\u0010\u000f\u001a\u00020\u0003\u0012\u000e\b\u0001\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b\u0012\n\b\u0001\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0001\u0010\u0013\u001a\u00020\u0003\u0012\u000e\b\u0001\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b\u0012\b\b\u0001\u0010\u0015\u001a\u00020\b\u0012\b\b\u0001\u0010\u0016\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0017\u001a\u00020\u0018\u0012\b\b\u0001\u0010\u0019\u001a\u00020\u0018\u0012\n\b\u0001\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\n\b\u0001\u0010\u001c\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u001d\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u001e\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u001f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010 J\t\u0010>\u001a\u00020\u0003HÆ\u0003J\u000f\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00030\u000bHÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010B\u001a\u00020\u0003HÆ\u0003J\u000f\u0010C\u001a\b\u0012\u0004\u0012\u00020\u00030\u000bHÆ\u0003J\t\u0010D\u001a\u00020\bHÆ\u0003J\t\u0010E\u001a\u00020\u0003HÆ\u0003J\t\u0010F\u001a\u00020\u0018HÆ\u0003J\t\u0010G\u001a\u00020\u0018HÆ\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\u001bHÆ\u0003J\t\u0010I\u001a\u00020\u0005HÆ\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010K\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u00101J\u0010\u0010L\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u00101J\u000b\u0010M\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010N\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u00101J\t\u0010O\u001a\u00020\bHÆ\u0003J\t\u0010P\u001a\u00020\bHÆ\u0003J\u000f\u0010Q\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003J\t\u0010R\u001a\u00020\u0005HÆ\u0003J\t\u0010S\u001a\u00020\bHÆ\u0003J\t\u0010T\u001a\u00020\u0003HÆ\u0003J\u0002\u0010U\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0003\u0010\u0007\u001a\u00020\b2\b\b\u0003\u0010\t\u001a\u00020\b2\u000e\b\u0003\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\b\b\u0003\u0010\r\u001a\u00020\u00052\b\b\u0003\u0010\u000e\u001a\u00020\b2\b\b\u0003\u0010\u000f\u001a\u00020\u00032\u000e\b\u0003\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\n\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u00032\b\b\u0003\u0010\u0013\u001a\u00020\u00032\u000e\b\u0003\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\b\b\u0003\u0010\u0015\u001a\u00020\b2\b\b\u0003\u0010\u0016\u001a\u00020\u00032\b\b\u0003\u0010\u0017\u001a\u00020\u00182\b\b\u0003\u0010\u0019\u001a\u00020\u00182\n\b\u0003\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\n\b\u0003\u0010\u001c\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u001d\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u001e\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010VJ\u0013\u0010W\u001a\u00020\u00182\b\u0010X\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010Y\u001a\u00020\bHÖ\u0001J\t\u0010Z\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\r\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\u000e\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b)\u0010$R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b¢\u0006\b\n\u0000\u001a\u0004\b*\u0010&R\u0011\u0010\u0017\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010+R\u0011\u0010\u0019\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010+R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b,\u0010(R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b-\u0010(R\u0011\u0010\u0013\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b.\u0010(R\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b/\u0010(R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u00102\u001a\u0004\b0\u00101R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\"R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b4\u0010(R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b5\u0010$R\u0011\u0010\u0016\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b6\u0010(R\u0011\u0010\u0015\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b7\u0010$R\u0015\u0010\u001d\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u00102\u001a\u0004\b8\u00101R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b¢\u0006\b\n\u0000\u001a\u0004\b9\u0010&R\u0013\u0010\u001f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b:\u0010(R\u0015\u0010\u001e\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u00102\u001a\u0004\b;\u00101R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u001b¢\u0006\b\n\u0000\u001a\u0004\b<\u0010=¨\u0006["}, d2 = {"Lcom/talabat/feature/darkstoresflutter/data/model/FlutterCartItem;", "", "productId", "", "price", "", "oldPrice", "quantity", "", "freeQuantity", "campaigns", "", "Lcom/talabat/feature/darkstoresflutter/data/model/FlutterCampaign;", "absoluteDiscount", "ageLimit", "mainImageUrl", "imageURLs", "categoryId", "itemDescription", "name", "tags", "stockAmount", "sku", "isFavourited", "", "isSponsored", "tracking", "Lcom/talabat/feature/darkstoresflutter/data/model/FlutterTracking;", "offerText", "subtotal", "total", "tooltipAlertText", "(Ljava/lang/String;FLjava/lang/Float;IILjava/util/List;FILjava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;ILjava/lang/String;ZZLcom/talabat/feature/darkstoresflutter/data/model/FlutterTracking;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/String;)V", "getAbsoluteDiscount", "()F", "getAgeLimit", "()I", "getCampaigns", "()Ljava/util/List;", "getCategoryId", "()Ljava/lang/String;", "getFreeQuantity", "getImageURLs", "()Z", "getItemDescription", "getMainImageUrl", "getName", "getOfferText", "getOldPrice", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getPrice", "getProductId", "getQuantity", "getSku", "getStockAmount", "getSubtotal", "getTags", "getTooltipAlertText", "getTotal", "getTracking", "()Lcom/talabat/feature/darkstoresflutter/data/model/FlutterTracking;", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;FLjava/lang/Float;IILjava/util/List;FILjava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;ILjava/lang/String;ZZLcom/talabat/feature/darkstoresflutter/data/model/FlutterTracking;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/String;)Lcom/talabat/feature/darkstoresflutter/data/model/FlutterCartItem;", "equals", "other", "hashCode", "toString", "com_talabat_feature_darkstores-flutter_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FlutterCartItem {
    private final float absoluteDiscount;
    private final int ageLimit;
    @NotNull
    private final List<FlutterCampaign> campaigns;
    @Nullable
    private final String categoryId;
    private final int freeQuantity;
    @NotNull
    private final List<String> imageURLs;
    private final boolean isFavourited;
    private final boolean isSponsored;
    @Nullable
    private final String itemDescription;
    @NotNull
    private final String mainImageUrl;
    @NotNull

    /* renamed from: name  reason: collision with root package name */
    private final String f58499name;
    @Nullable
    private final String offerText;
    @Nullable
    private final Float oldPrice;
    private final float price;
    @NotNull
    private final String productId;
    private final int quantity;
    @NotNull
    private final String sku;
    private final int stockAmount;
    @Nullable
    private final Float subtotal;
    @NotNull
    private final List<String> tags;
    @Nullable
    private final String tooltipAlertText;
    @Nullable
    private final Float total;
    @Nullable

    /* renamed from: tracking  reason: collision with root package name */
    private final FlutterTracking f58500tracking;

    public FlutterCartItem(@NotNull @Json(name = "productId") String str, @Json(name = "price") float f11, @Nullable @Json(name = "oldPrice") Float f12, @Json(name = "quantity") int i11, @Json(name = "freeQuantity") int i12, @NotNull @Json(name = "campaigns") List<FlutterCampaign> list, @Json(name = "absoluteDiscount") float f13, @Json(name = "ageLimit") int i13, @NotNull @Json(name = "mainImageUrl") String str2, @NotNull @Json(name = "imageURLs") List<String> list2, @Nullable @Json(name = "categoryId") String str3, @Nullable @Json(name = "itemDescription") String str4, @NotNull @Json(name = "name") String str5, @NotNull @Json(name = "tags") List<String> list3, @Json(name = "stockAmount") int i14, @NotNull @Json(name = "sku") String str6, @Json(name = "isFavourited") boolean z11, @Json(name = "isSponsored") boolean z12, @Nullable @Json(name = "tracking") FlutterTracking flutterTracking, @Nullable @Json(name = "offerText") String str7, @Nullable @Json(name = "subtotal") Float f14, @Nullable @Json(name = "total") Float f15, @Nullable @Json(name = "tooltipAlertText") String str8) {
        String str9 = str2;
        List<String> list4 = list2;
        String str10 = str5;
        List<String> list5 = list3;
        String str11 = str6;
        Intrinsics.checkNotNullParameter(str, "productId");
        Intrinsics.checkNotNullParameter(list, "campaigns");
        Intrinsics.checkNotNullParameter(str9, "mainImageUrl");
        Intrinsics.checkNotNullParameter(list4, "imageURLs");
        Intrinsics.checkNotNullParameter(str10, "name");
        Intrinsics.checkNotNullParameter(list5, "tags");
        Intrinsics.checkNotNullParameter(str11, "sku");
        this.productId = str;
        this.price = f11;
        this.oldPrice = f12;
        this.quantity = i11;
        this.freeQuantity = i12;
        this.campaigns = list;
        this.absoluteDiscount = f13;
        this.ageLimit = i13;
        this.mainImageUrl = str9;
        this.imageURLs = list4;
        this.categoryId = str3;
        this.itemDescription = str4;
        this.f58499name = str10;
        this.tags = list5;
        this.stockAmount = i14;
        this.sku = str11;
        this.isFavourited = z11;
        this.isSponsored = z12;
        this.f58500tracking = flutterTracking;
        this.offerText = str7;
        this.subtotal = f14;
        this.total = f15;
        this.tooltipAlertText = str8;
    }

    public static /* synthetic */ FlutterCartItem copy$default(FlutterCartItem flutterCartItem, String str, float f11, Float f12, int i11, int i12, List list, float f13, int i13, String str2, List list2, String str3, String str4, String str5, List list3, int i14, String str6, boolean z11, boolean z12, FlutterTracking flutterTracking, String str7, Float f14, Float f15, String str8, int i15, Object obj) {
        FlutterCartItem flutterCartItem2 = flutterCartItem;
        int i16 = i15;
        return flutterCartItem.copy((i16 & 1) != 0 ? flutterCartItem2.productId : str, (i16 & 2) != 0 ? flutterCartItem2.price : f11, (i16 & 4) != 0 ? flutterCartItem2.oldPrice : f12, (i16 & 8) != 0 ? flutterCartItem2.quantity : i11, (i16 & 16) != 0 ? flutterCartItem2.freeQuantity : i12, (i16 & 32) != 0 ? flutterCartItem2.campaigns : list, (i16 & 64) != 0 ? flutterCartItem2.absoluteDiscount : f13, (i16 & 128) != 0 ? flutterCartItem2.ageLimit : i13, (i16 & 256) != 0 ? flutterCartItem2.mainImageUrl : str2, (i16 & 512) != 0 ? flutterCartItem2.imageURLs : list2, (i16 & 1024) != 0 ? flutterCartItem2.categoryId : str3, (i16 & 2048) != 0 ? flutterCartItem2.itemDescription : str4, (i16 & 4096) != 0 ? flutterCartItem2.f58499name : str5, (i16 & 8192) != 0 ? flutterCartItem2.tags : list3, (i16 & 16384) != 0 ? flutterCartItem2.stockAmount : i14, (i16 & 32768) != 0 ? flutterCartItem2.sku : str6, (i16 & 65536) != 0 ? flutterCartItem2.isFavourited : z11, (i16 & 131072) != 0 ? flutterCartItem2.isSponsored : z12, (i16 & 262144) != 0 ? flutterCartItem2.f58500tracking : flutterTracking, (i16 & 524288) != 0 ? flutterCartItem2.offerText : str7, (i16 & 1048576) != 0 ? flutterCartItem2.subtotal : f14, (i16 & 2097152) != 0 ? flutterCartItem2.total : f15, (i16 & 4194304) != 0 ? flutterCartItem2.tooltipAlertText : str8);
    }

    @NotNull
    public final String component1() {
        return this.productId;
    }

    @NotNull
    public final List<String> component10() {
        return this.imageURLs;
    }

    @Nullable
    public final String component11() {
        return this.categoryId;
    }

    @Nullable
    public final String component12() {
        return this.itemDescription;
    }

    @NotNull
    public final String component13() {
        return this.f58499name;
    }

    @NotNull
    public final List<String> component14() {
        return this.tags;
    }

    public final int component15() {
        return this.stockAmount;
    }

    @NotNull
    public final String component16() {
        return this.sku;
    }

    public final boolean component17() {
        return this.isFavourited;
    }

    public final boolean component18() {
        return this.isSponsored;
    }

    @Nullable
    public final FlutterTracking component19() {
        return this.f58500tracking;
    }

    public final float component2() {
        return this.price;
    }

    @Nullable
    public final String component20() {
        return this.offerText;
    }

    @Nullable
    public final Float component21() {
        return this.subtotal;
    }

    @Nullable
    public final Float component22() {
        return this.total;
    }

    @Nullable
    public final String component23() {
        return this.tooltipAlertText;
    }

    @Nullable
    public final Float component3() {
        return this.oldPrice;
    }

    public final int component4() {
        return this.quantity;
    }

    public final int component5() {
        return this.freeQuantity;
    }

    @NotNull
    public final List<FlutterCampaign> component6() {
        return this.campaigns;
    }

    public final float component7() {
        return this.absoluteDiscount;
    }

    public final int component8() {
        return this.ageLimit;
    }

    @NotNull
    public final String component9() {
        return this.mainImageUrl;
    }

    @NotNull
    public final FlutterCartItem copy(@NotNull @Json(name = "productId") String str, @Json(name = "price") float f11, @Nullable @Json(name = "oldPrice") Float f12, @Json(name = "quantity") int i11, @Json(name = "freeQuantity") int i12, @NotNull @Json(name = "campaigns") List<FlutterCampaign> list, @Json(name = "absoluteDiscount") float f13, @Json(name = "ageLimit") int i13, @NotNull @Json(name = "mainImageUrl") String str2, @NotNull @Json(name = "imageURLs") List<String> list2, @Nullable @Json(name = "categoryId") String str3, @Nullable @Json(name = "itemDescription") String str4, @NotNull @Json(name = "name") String str5, @NotNull @Json(name = "tags") List<String> list3, @Json(name = "stockAmount") int i14, @NotNull @Json(name = "sku") String str6, @Json(name = "isFavourited") boolean z11, @Json(name = "isSponsored") boolean z12, @Nullable @Json(name = "tracking") FlutterTracking flutterTracking, @Nullable @Json(name = "offerText") String str7, @Nullable @Json(name = "subtotal") Float f14, @Nullable @Json(name = "total") Float f15, @Nullable @Json(name = "tooltipAlertText") String str8) {
        String str9 = str;
        Intrinsics.checkNotNullParameter(str9, "productId");
        Intrinsics.checkNotNullParameter(list, "campaigns");
        Intrinsics.checkNotNullParameter(str2, "mainImageUrl");
        Intrinsics.checkNotNullParameter(list2, "imageURLs");
        Intrinsics.checkNotNullParameter(str5, "name");
        Intrinsics.checkNotNullParameter(list3, "tags");
        Intrinsics.checkNotNullParameter(str6, "sku");
        return new FlutterCartItem(str9, f11, f12, i11, i12, list, f13, i13, str2, list2, str3, str4, str5, list3, i14, str6, z11, z12, flutterTracking, str7, f14, f15, str8);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FlutterCartItem)) {
            return false;
        }
        FlutterCartItem flutterCartItem = (FlutterCartItem) obj;
        return Intrinsics.areEqual((Object) this.productId, (Object) flutterCartItem.productId) && Intrinsics.areEqual((Object) Float.valueOf(this.price), (Object) Float.valueOf(flutterCartItem.price)) && Intrinsics.areEqual((Object) this.oldPrice, (Object) flutterCartItem.oldPrice) && this.quantity == flutterCartItem.quantity && this.freeQuantity == flutterCartItem.freeQuantity && Intrinsics.areEqual((Object) this.campaigns, (Object) flutterCartItem.campaigns) && Intrinsics.areEqual((Object) Float.valueOf(this.absoluteDiscount), (Object) Float.valueOf(flutterCartItem.absoluteDiscount)) && this.ageLimit == flutterCartItem.ageLimit && Intrinsics.areEqual((Object) this.mainImageUrl, (Object) flutterCartItem.mainImageUrl) && Intrinsics.areEqual((Object) this.imageURLs, (Object) flutterCartItem.imageURLs) && Intrinsics.areEqual((Object) this.categoryId, (Object) flutterCartItem.categoryId) && Intrinsics.areEqual((Object) this.itemDescription, (Object) flutterCartItem.itemDescription) && Intrinsics.areEqual((Object) this.f58499name, (Object) flutterCartItem.f58499name) && Intrinsics.areEqual((Object) this.tags, (Object) flutterCartItem.tags) && this.stockAmount == flutterCartItem.stockAmount && Intrinsics.areEqual((Object) this.sku, (Object) flutterCartItem.sku) && this.isFavourited == flutterCartItem.isFavourited && this.isSponsored == flutterCartItem.isSponsored && Intrinsics.areEqual((Object) this.f58500tracking, (Object) flutterCartItem.f58500tracking) && Intrinsics.areEqual((Object) this.offerText, (Object) flutterCartItem.offerText) && Intrinsics.areEqual((Object) this.subtotal, (Object) flutterCartItem.subtotal) && Intrinsics.areEqual((Object) this.total, (Object) flutterCartItem.total) && Intrinsics.areEqual((Object) this.tooltipAlertText, (Object) flutterCartItem.tooltipAlertText);
    }

    public final float getAbsoluteDiscount() {
        return this.absoluteDiscount;
    }

    public final int getAgeLimit() {
        return this.ageLimit;
    }

    @NotNull
    public final List<FlutterCampaign> getCampaigns() {
        return this.campaigns;
    }

    @Nullable
    public final String getCategoryId() {
        return this.categoryId;
    }

    public final int getFreeQuantity() {
        return this.freeQuantity;
    }

    @NotNull
    public final List<String> getImageURLs() {
        return this.imageURLs;
    }

    @Nullable
    public final String getItemDescription() {
        return this.itemDescription;
    }

    @NotNull
    public final String getMainImageUrl() {
        return this.mainImageUrl;
    }

    @NotNull
    public final String getName() {
        return this.f58499name;
    }

    @Nullable
    public final String getOfferText() {
        return this.offerText;
    }

    @Nullable
    public final Float getOldPrice() {
        return this.oldPrice;
    }

    public final float getPrice() {
        return this.price;
    }

    @NotNull
    public final String getProductId() {
        return this.productId;
    }

    public final int getQuantity() {
        return this.quantity;
    }

    @NotNull
    public final String getSku() {
        return this.sku;
    }

    public final int getStockAmount() {
        return this.stockAmount;
    }

    @Nullable
    public final Float getSubtotal() {
        return this.subtotal;
    }

    @NotNull
    public final List<String> getTags() {
        return this.tags;
    }

    @Nullable
    public final String getTooltipAlertText() {
        return this.tooltipAlertText;
    }

    @Nullable
    public final Float getTotal() {
        return this.total;
    }

    @Nullable
    public final FlutterTracking getTracking() {
        return this.f58500tracking;
    }

    public int hashCode() {
        int hashCode = ((this.productId.hashCode() * 31) + Float.floatToIntBits(this.price)) * 31;
        Float f11 = this.oldPrice;
        int i11 = 0;
        int hashCode2 = (((((((((((((((hashCode + (f11 == null ? 0 : f11.hashCode())) * 31) + this.quantity) * 31) + this.freeQuantity) * 31) + this.campaigns.hashCode()) * 31) + Float.floatToIntBits(this.absoluteDiscount)) * 31) + this.ageLimit) * 31) + this.mainImageUrl.hashCode()) * 31) + this.imageURLs.hashCode()) * 31;
        String str = this.categoryId;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.itemDescription;
        int hashCode4 = (((((((((hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.f58499name.hashCode()) * 31) + this.tags.hashCode()) * 31) + this.stockAmount) * 31) + this.sku.hashCode()) * 31;
        boolean z11 = this.isFavourited;
        boolean z12 = true;
        if (z11) {
            z11 = true;
        }
        int i12 = (hashCode4 + (z11 ? 1 : 0)) * 31;
        boolean z13 = this.isSponsored;
        if (!z13) {
            z12 = z13;
        }
        int i13 = (i12 + (z12 ? 1 : 0)) * 31;
        FlutterTracking flutterTracking = this.f58500tracking;
        int hashCode5 = (i13 + (flutterTracking == null ? 0 : flutterTracking.hashCode())) * 31;
        String str3 = this.offerText;
        int hashCode6 = (hashCode5 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Float f12 = this.subtotal;
        int hashCode7 = (hashCode6 + (f12 == null ? 0 : f12.hashCode())) * 31;
        Float f13 = this.total;
        int hashCode8 = (hashCode7 + (f13 == null ? 0 : f13.hashCode())) * 31;
        String str4 = this.tooltipAlertText;
        if (str4 != null) {
            i11 = str4.hashCode();
        }
        return hashCode8 + i11;
    }

    public final boolean isFavourited() {
        return this.isFavourited;
    }

    public final boolean isSponsored() {
        return this.isSponsored;
    }

    @NotNull
    public String toString() {
        String str = this.productId;
        float f11 = this.price;
        Float f12 = this.oldPrice;
        int i11 = this.quantity;
        int i12 = this.freeQuantity;
        List<FlutterCampaign> list = this.campaigns;
        float f13 = this.absoluteDiscount;
        int i13 = this.ageLimit;
        String str2 = this.mainImageUrl;
        List<String> list2 = this.imageURLs;
        String str3 = this.categoryId;
        String str4 = this.itemDescription;
        String str5 = this.f58499name;
        List<String> list3 = this.tags;
        int i14 = this.stockAmount;
        String str6 = this.sku;
        boolean z11 = this.isFavourited;
        boolean z12 = this.isSponsored;
        FlutterTracking flutterTracking = this.f58500tracking;
        String str7 = this.offerText;
        Float f14 = this.subtotal;
        Float f15 = this.total;
        String str8 = this.tooltipAlertText;
        return "FlutterCartItem(productId=" + str + ", price=" + f11 + ", oldPrice=" + f12 + ", quantity=" + i11 + ", freeQuantity=" + i12 + ", campaigns=" + list + ", absoluteDiscount=" + f13 + ", ageLimit=" + i13 + ", mainImageUrl=" + str2 + ", imageURLs=" + list2 + ", categoryId=" + str3 + ", itemDescription=" + str4 + ", name=" + str5 + ", tags=" + list3 + ", stockAmount=" + i14 + ", sku=" + str6 + ", isFavourited=" + z11 + ", isSponsored=" + z12 + ", tracking=" + flutterTracking + ", offerText=" + str7 + ", subtotal=" + f14 + ", total=" + f15 + ", tooltipAlertText=" + str8 + ")";
    }
}
