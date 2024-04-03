package datamodels;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b2\b\b\u0018\u00002\u00020\u0001Bã\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c¢\u0006\u0002\u0010\u001dJ\t\u00103\u001a\u00020\u0003HÆ\u0003J\t\u00104\u001a\u00020\u000fHÆ\u0003J\t\u00105\u001a\u00020\u000fHÆ\u0003J\t\u00106\u001a\u00020\u000fHÆ\u0003J\t\u00107\u001a\u00020\u000fHÆ\u0003J\t\u00108\u001a\u00020\u0006HÆ\u0003J\t\u00109\u001a\u00020\u0006HÆ\u0003J\t\u0010:\u001a\u00020\u0006HÆ\u0003J\t\u0010;\u001a\u00020\u000fHÆ\u0003J\t\u0010<\u001a\u00020\u000fHÆ\u0003J\t\u0010=\u001a\u00020\u000fHÆ\u0003J\t\u0010>\u001a\u00020\u0003HÆ\u0003J\t\u0010?\u001a\u00020\u000fHÆ\u0003J\t\u0010@\u001a\u00020\u000fHÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u001cHÆ\u0003J\t\u0010B\u001a\u00020\u0006HÆ\u0003J\t\u0010C\u001a\u00020\u0003HÆ\u0003J\t\u0010D\u001a\u00020\u0003HÆ\u0003J\t\u0010E\u001a\u00020\u0006HÆ\u0003J\t\u0010F\u001a\u00020\u000bHÆ\u0003J\t\u0010G\u001a\u00020\u000bHÆ\u0003J\t\u0010H\u001a\u00020\u000bHÆ\u0003Jç\u0001\u0010I\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u000f2\b\b\u0002\u0010\u0013\u001a\u00020\u00062\b\b\u0002\u0010\u0014\u001a\u00020\u00062\b\b\u0002\u0010\u0015\u001a\u00020\u00062\b\b\u0002\u0010\u0016\u001a\u00020\u000f2\b\b\u0002\u0010\u0017\u001a\u00020\u000f2\b\b\u0002\u0010\u0018\u001a\u00020\u000f2\b\b\u0002\u0010\u0019\u001a\u00020\u000f2\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÆ\u0001J\u0013\u0010J\u001a\u00020\u000f2\b\u0010K\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010L\u001a\u00020\u0003HÖ\u0001J\t\u0010M\u001a\u00020\u0006HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0016\u0010\u0013\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0016\u0010\u0010\u001a\u00020\u000f8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0016\u0010\u0012\u001a\u00020\u000f8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010#R\u0016\u0010\u0016\u001a\u00020\u000f8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010#R\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001fR\u0016\u0010\u0015\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010!R\u0016\u0010\u001a\u001a\u00020\u000f8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010#R\u0016\u0010\u000e\u001a\u00020\u000f8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010#R\u0016\u0010\u0017\u001a\u00020\u000f8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010#R\u0016\u0010\u0018\u001a\u00020\u000f8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010#R\u0016\u0010\u0011\u001a\u00020\u000f8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010#R\u0016\u0010\u0019\u001a\u00020\u000f8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010#R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001fR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010!R\u0016\u0010\t\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010!R\u0016\u0010\r\u001a\u00020\u000b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0016\u0010\f\u001a\u00020\u000b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010,R\u0016\u0010\n\u001a\u00020\u000b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010,R\u0016\u0010\u0014\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010!R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u001c8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\u001f¨\u0006N"}, d2 = {"Ldatamodels/FeaturedProductItem;", "", "chainid", "", "vendorid", "menuSectionName", "", "id", "menuSectionId", "name", "rating", "", "price", "oldPrice", "isDiscounted", "", "discount", "isPremium", "excludeFromGem", "description", "thumbnail", "image", "hasThumbnail", "isFavItem", "isItemDiscount", "isPromotional", "isChoiceCategory", "vendor", "Ldatamodels/Restaurant;", "(IILjava/lang/String;IILjava/lang/String;DDDZZZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZZZZLdatamodels/Restaurant;)V", "getChainid", "()I", "getDescription", "()Ljava/lang/String;", "getDiscount", "()Z", "getExcludeFromGem", "getHasThumbnail", "getId", "getImage", "getMenuSectionId", "getMenuSectionName", "getName", "getOldPrice", "()D", "getPrice", "getRating", "getThumbnail", "getVendor", "()Ldatamodels/Restaurant;", "getVendorid", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FeaturedProductItem {
    @SerializedName("chainid")
    private final int chainid;
    @SerializedName("dsc")
    @NotNull
    private final String description;
    @SerializedName("dc")
    private final boolean discount;
    @SerializedName("exG")
    private final boolean excludeFromGem;
    @SerializedName("ht")
    private final boolean hasThumbnail;
    @SerializedName("id")

    /* renamed from: id  reason: collision with root package name */
    private final int f13851id;
    @SerializedName("im")
    @NotNull
    private final String image;
    @SerializedName("icc")
    private final boolean isChoiceCategory;
    @SerializedName("idc")
    private final boolean isDiscounted;
    @SerializedName("isf")
    private final boolean isFavItem;
    @SerializedName("isi")
    private final boolean isItemDiscount;
    @SerializedName("ipm")
    private final boolean isPremium;
    @SerializedName("ipr")
    private final boolean isPromotional;
    @SerializedName("msi")
    private final int menuSectionId;
    @SerializedName("msname")
    @NotNull
    private final String menuSectionName;
    @SerializedName("nm")
    @NotNull

    /* renamed from: name  reason: collision with root package name */
    private final String f13852name;
    @SerializedName("opr")
    private final double oldPrice;
    @SerializedName("pr")
    private final double price;
    @SerializedName("rt")
    private final double rating;
    @SerializedName("img")
    @NotNull
    private final String thumbnail;
    @SerializedName("vendor")
    @Nullable
    private final Restaurant vendor;
    @SerializedName("vendorid")
    private final int vendorid;

    public FeaturedProductItem() {
        this(0, 0, (String) null, 0, 0, (String) null, 0.0d, 0.0d, 0.0d, false, false, false, false, (String) null, (String) null, (String) null, false, false, false, false, false, (Restaurant) null, 4194303, (DefaultConstructorMarker) null);
    }

    public FeaturedProductItem(int i11, int i12, @NotNull String str, int i13, int i14, @NotNull String str2, double d11, double d12, double d13, boolean z11, boolean z12, boolean z13, boolean z14, @NotNull String str3, @NotNull String str4, @NotNull String str5, boolean z15, boolean z16, boolean z17, boolean z18, boolean z19, @Nullable Restaurant restaurant) {
        String str6 = str3;
        String str7 = str4;
        String str8 = str5;
        Intrinsics.checkNotNullParameter(str, "menuSectionName");
        Intrinsics.checkNotNullParameter(str2, "name");
        Intrinsics.checkNotNullParameter(str6, "description");
        Intrinsics.checkNotNullParameter(str7, "thumbnail");
        Intrinsics.checkNotNullParameter(str8, "image");
        this.chainid = i11;
        this.vendorid = i12;
        this.menuSectionName = str;
        this.f13851id = i13;
        this.menuSectionId = i14;
        this.f13852name = str2;
        this.rating = d11;
        this.price = d12;
        this.oldPrice = d13;
        this.isDiscounted = z11;
        this.discount = z12;
        this.isPremium = z13;
        this.excludeFromGem = z14;
        this.description = str6;
        this.thumbnail = str7;
        this.image = str8;
        this.hasThumbnail = z15;
        this.isFavItem = z16;
        this.isItemDiscount = z17;
        this.isPromotional = z18;
        this.isChoiceCategory = z19;
        this.vendor = restaurant;
    }

    public static /* synthetic */ FeaturedProductItem copy$default(FeaturedProductItem featuredProductItem, int i11, int i12, String str, int i13, int i14, String str2, double d11, double d12, double d13, boolean z11, boolean z12, boolean z13, boolean z14, String str3, String str4, String str5, boolean z15, boolean z16, boolean z17, boolean z18, boolean z19, Restaurant restaurant, int i15, Object obj) {
        FeaturedProductItem featuredProductItem2 = featuredProductItem;
        int i16 = i15;
        return featuredProductItem.copy((i16 & 1) != 0 ? featuredProductItem2.chainid : i11, (i16 & 2) != 0 ? featuredProductItem2.vendorid : i12, (i16 & 4) != 0 ? featuredProductItem2.menuSectionName : str, (i16 & 8) != 0 ? featuredProductItem2.f13851id : i13, (i16 & 16) != 0 ? featuredProductItem2.menuSectionId : i14, (i16 & 32) != 0 ? featuredProductItem2.f13852name : str2, (i16 & 64) != 0 ? featuredProductItem2.rating : d11, (i16 & 128) != 0 ? featuredProductItem2.price : d12, (i16 & 256) != 0 ? featuredProductItem2.oldPrice : d13, (i16 & 512) != 0 ? featuredProductItem2.isDiscounted : z11, (i16 & 1024) != 0 ? featuredProductItem2.discount : z12, (i16 & 2048) != 0 ? featuredProductItem2.isPremium : z13, (i16 & 4096) != 0 ? featuredProductItem2.excludeFromGem : z14, (i16 & 8192) != 0 ? featuredProductItem2.description : str3, (i16 & 16384) != 0 ? featuredProductItem2.thumbnail : str4, (i16 & 32768) != 0 ? featuredProductItem2.image : str5, (i16 & 65536) != 0 ? featuredProductItem2.hasThumbnail : z15, (i16 & 131072) != 0 ? featuredProductItem2.isFavItem : z16, (i16 & 262144) != 0 ? featuredProductItem2.isItemDiscount : z17, (i16 & 524288) != 0 ? featuredProductItem2.isPromotional : z18, (i16 & 1048576) != 0 ? featuredProductItem2.isChoiceCategory : z19, (i16 & 2097152) != 0 ? featuredProductItem2.vendor : restaurant);
    }

    public final int component1() {
        return this.chainid;
    }

    public final boolean component10() {
        return this.isDiscounted;
    }

    public final boolean component11() {
        return this.discount;
    }

    public final boolean component12() {
        return this.isPremium;
    }

    public final boolean component13() {
        return this.excludeFromGem;
    }

    @NotNull
    public final String component14() {
        return this.description;
    }

    @NotNull
    public final String component15() {
        return this.thumbnail;
    }

    @NotNull
    public final String component16() {
        return this.image;
    }

    public final boolean component17() {
        return this.hasThumbnail;
    }

    public final boolean component18() {
        return this.isFavItem;
    }

    public final boolean component19() {
        return this.isItemDiscount;
    }

    public final int component2() {
        return this.vendorid;
    }

    public final boolean component20() {
        return this.isPromotional;
    }

    public final boolean component21() {
        return this.isChoiceCategory;
    }

    @Nullable
    public final Restaurant component22() {
        return this.vendor;
    }

    @NotNull
    public final String component3() {
        return this.menuSectionName;
    }

    public final int component4() {
        return this.f13851id;
    }

    public final int component5() {
        return this.menuSectionId;
    }

    @NotNull
    public final String component6() {
        return this.f13852name;
    }

    public final double component7() {
        return this.rating;
    }

    public final double component8() {
        return this.price;
    }

    public final double component9() {
        return this.oldPrice;
    }

    @NotNull
    public final FeaturedProductItem copy(int i11, int i12, @NotNull String str, int i13, int i14, @NotNull String str2, double d11, double d12, double d13, boolean z11, boolean z12, boolean z13, boolean z14, @NotNull String str3, @NotNull String str4, @NotNull String str5, boolean z15, boolean z16, boolean z17, boolean z18, boolean z19, @Nullable Restaurant restaurant) {
        int i15 = i11;
        Intrinsics.checkNotNullParameter(str, "menuSectionName");
        Intrinsics.checkNotNullParameter(str2, "name");
        Intrinsics.checkNotNullParameter(str3, "description");
        Intrinsics.checkNotNullParameter(str4, "thumbnail");
        Intrinsics.checkNotNullParameter(str5, "image");
        return new FeaturedProductItem(i11, i12, str, i13, i14, str2, d11, d12, d13, z11, z12, z13, z14, str3, str4, str5, z15, z16, z17, z18, z19, restaurant);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FeaturedProductItem)) {
            return false;
        }
        FeaturedProductItem featuredProductItem = (FeaturedProductItem) obj;
        return this.chainid == featuredProductItem.chainid && this.vendorid == featuredProductItem.vendorid && Intrinsics.areEqual((Object) this.menuSectionName, (Object) featuredProductItem.menuSectionName) && this.f13851id == featuredProductItem.f13851id && this.menuSectionId == featuredProductItem.menuSectionId && Intrinsics.areEqual((Object) this.f13852name, (Object) featuredProductItem.f13852name) && Intrinsics.areEqual((Object) Double.valueOf(this.rating), (Object) Double.valueOf(featuredProductItem.rating)) && Intrinsics.areEqual((Object) Double.valueOf(this.price), (Object) Double.valueOf(featuredProductItem.price)) && Intrinsics.areEqual((Object) Double.valueOf(this.oldPrice), (Object) Double.valueOf(featuredProductItem.oldPrice)) && this.isDiscounted == featuredProductItem.isDiscounted && this.discount == featuredProductItem.discount && this.isPremium == featuredProductItem.isPremium && this.excludeFromGem == featuredProductItem.excludeFromGem && Intrinsics.areEqual((Object) this.description, (Object) featuredProductItem.description) && Intrinsics.areEqual((Object) this.thumbnail, (Object) featuredProductItem.thumbnail) && Intrinsics.areEqual((Object) this.image, (Object) featuredProductItem.image) && this.hasThumbnail == featuredProductItem.hasThumbnail && this.isFavItem == featuredProductItem.isFavItem && this.isItemDiscount == featuredProductItem.isItemDiscount && this.isPromotional == featuredProductItem.isPromotional && this.isChoiceCategory == featuredProductItem.isChoiceCategory && Intrinsics.areEqual((Object) this.vendor, (Object) featuredProductItem.vendor);
    }

    public final int getChainid() {
        return this.chainid;
    }

    @NotNull
    public final String getDescription() {
        return this.description;
    }

    public final boolean getDiscount() {
        return this.discount;
    }

    public final boolean getExcludeFromGem() {
        return this.excludeFromGem;
    }

    public final boolean getHasThumbnail() {
        return this.hasThumbnail;
    }

    public final int getId() {
        return this.f13851id;
    }

    @NotNull
    public final String getImage() {
        return this.image;
    }

    public final int getMenuSectionId() {
        return this.menuSectionId;
    }

    @NotNull
    public final String getMenuSectionName() {
        return this.menuSectionName;
    }

    @NotNull
    public final String getName() {
        return this.f13852name;
    }

    public final double getOldPrice() {
        return this.oldPrice;
    }

    public final double getPrice() {
        return this.price;
    }

    public final double getRating() {
        return this.rating;
    }

    @NotNull
    public final String getThumbnail() {
        return this.thumbnail;
    }

    @Nullable
    public final Restaurant getVendor() {
        return this.vendor;
    }

    public final int getVendorid() {
        return this.vendorid;
    }

    public int hashCode() {
        int hashCode = ((((((((((((((((this.chainid * 31) + this.vendorid) * 31) + this.menuSectionName.hashCode()) * 31) + this.f13851id) * 31) + this.menuSectionId) * 31) + this.f13852name.hashCode()) * 31) + Double.doubleToLongBits(this.rating)) * 31) + Double.doubleToLongBits(this.price)) * 31) + Double.doubleToLongBits(this.oldPrice)) * 31;
        boolean z11 = this.isDiscounted;
        boolean z12 = true;
        if (z11) {
            z11 = true;
        }
        int i11 = (hashCode + (z11 ? 1 : 0)) * 31;
        boolean z13 = this.discount;
        if (z13) {
            z13 = true;
        }
        int i12 = (i11 + (z13 ? 1 : 0)) * 31;
        boolean z14 = this.isPremium;
        if (z14) {
            z14 = true;
        }
        int i13 = (i12 + (z14 ? 1 : 0)) * 31;
        boolean z15 = this.excludeFromGem;
        if (z15) {
            z15 = true;
        }
        int hashCode2 = (((((((i13 + (z15 ? 1 : 0)) * 31) + this.description.hashCode()) * 31) + this.thumbnail.hashCode()) * 31) + this.image.hashCode()) * 31;
        boolean z16 = this.hasThumbnail;
        if (z16) {
            z16 = true;
        }
        int i14 = (hashCode2 + (z16 ? 1 : 0)) * 31;
        boolean z17 = this.isFavItem;
        if (z17) {
            z17 = true;
        }
        int i15 = (i14 + (z17 ? 1 : 0)) * 31;
        boolean z18 = this.isItemDiscount;
        if (z18) {
            z18 = true;
        }
        int i16 = (i15 + (z18 ? 1 : 0)) * 31;
        boolean z19 = this.isPromotional;
        if (z19) {
            z19 = true;
        }
        int i17 = (i16 + (z19 ? 1 : 0)) * 31;
        boolean z21 = this.isChoiceCategory;
        if (!z21) {
            z12 = z21;
        }
        int i18 = (i17 + (z12 ? 1 : 0)) * 31;
        Restaurant restaurant = this.vendor;
        return i18 + (restaurant == null ? 0 : restaurant.hashCode());
    }

    public final boolean isChoiceCategory() {
        return this.isChoiceCategory;
    }

    public final boolean isDiscounted() {
        return this.isDiscounted;
    }

    public final boolean isFavItem() {
        return this.isFavItem;
    }

    public final boolean isItemDiscount() {
        return this.isItemDiscount;
    }

    public final boolean isPremium() {
        return this.isPremium;
    }

    public final boolean isPromotional() {
        return this.isPromotional;
    }

    @NotNull
    public String toString() {
        int i11 = this.chainid;
        int i12 = this.vendorid;
        String str = this.menuSectionName;
        int i13 = this.f13851id;
        int i14 = this.menuSectionId;
        String str2 = this.f13852name;
        double d11 = this.rating;
        double d12 = this.price;
        double d13 = this.oldPrice;
        boolean z11 = this.isDiscounted;
        boolean z12 = this.discount;
        boolean z13 = this.isPremium;
        boolean z14 = this.excludeFromGem;
        String str3 = this.description;
        String str4 = this.thumbnail;
        String str5 = this.image;
        boolean z15 = this.hasThumbnail;
        boolean z16 = this.isFavItem;
        boolean z17 = this.isItemDiscount;
        boolean z18 = this.isPromotional;
        boolean z19 = this.isChoiceCategory;
        Restaurant restaurant = this.vendor;
        return "FeaturedProductItem(chainid=" + i11 + ", vendorid=" + i12 + ", menuSectionName=" + str + ", id=" + i13 + ", menuSectionId=" + i14 + ", name=" + str2 + ", rating=" + d11 + ", price=" + d12 + ", oldPrice=" + d13 + ", isDiscounted=" + z11 + ", discount=" + z12 + ", isPremium=" + z13 + ", excludeFromGem=" + z14 + ", description=" + str3 + ", thumbnail=" + str4 + ", image=" + str5 + ", hasThumbnail=" + z15 + ", isFavItem=" + z16 + ", isItemDiscount=" + z17 + ", isPromotional=" + z18 + ", isChoiceCategory=" + z19 + ", vendor=" + restaurant + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ FeaturedProductItem(int r27, int r28, java.lang.String r29, int r30, int r31, java.lang.String r32, double r33, double r35, double r37, boolean r39, boolean r40, boolean r41, boolean r42, java.lang.String r43, java.lang.String r44, java.lang.String r45, boolean r46, boolean r47, boolean r48, boolean r49, boolean r50, datamodels.Restaurant r51, int r52, kotlin.jvm.internal.DefaultConstructorMarker r53) {
        /*
            r26 = this;
            r0 = r52
            r1 = r0 & 1
            if (r1 == 0) goto L_0x0008
            r1 = 0
            goto L_0x000a
        L_0x0008:
            r1 = r27
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            r3 = 0
            goto L_0x0012
        L_0x0010:
            r3 = r28
        L_0x0012:
            r4 = r0 & 4
            java.lang.String r5 = ""
            if (r4 == 0) goto L_0x001a
            r4 = r5
            goto L_0x001c
        L_0x001a:
            r4 = r29
        L_0x001c:
            r6 = r0 & 8
            if (r6 == 0) goto L_0x0022
            r6 = 0
            goto L_0x0024
        L_0x0022:
            r6 = r30
        L_0x0024:
            r7 = r0 & 16
            if (r7 == 0) goto L_0x002a
            r7 = 0
            goto L_0x002c
        L_0x002a:
            r7 = r31
        L_0x002c:
            r8 = r0 & 32
            if (r8 == 0) goto L_0x0032
            r8 = r5
            goto L_0x0034
        L_0x0032:
            r8 = r32
        L_0x0034:
            r9 = r0 & 64
            r10 = 0
            if (r9 == 0) goto L_0x003c
            r12 = r10
            goto L_0x003e
        L_0x003c:
            r12 = r33
        L_0x003e:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x0044
            r14 = r10
            goto L_0x0046
        L_0x0044:
            r14 = r35
        L_0x0046:
            r9 = r0 & 256(0x100, float:3.59E-43)
            if (r9 == 0) goto L_0x004b
            goto L_0x004d
        L_0x004b:
            r10 = r37
        L_0x004d:
            r9 = r0 & 512(0x200, float:7.175E-43)
            if (r9 == 0) goto L_0x0053
            r9 = 0
            goto L_0x0055
        L_0x0053:
            r9 = r39
        L_0x0055:
            r2 = r0 & 1024(0x400, float:1.435E-42)
            if (r2 == 0) goto L_0x005b
            r2 = 0
            goto L_0x005d
        L_0x005b:
            r2 = r40
        L_0x005d:
            r27 = r5
            r5 = r0 & 2048(0x800, float:2.87E-42)
            if (r5 == 0) goto L_0x0065
            r5 = 0
            goto L_0x0067
        L_0x0065:
            r5 = r41
        L_0x0067:
            r16 = r5
            r5 = r0 & 4096(0x1000, float:5.74E-42)
            if (r5 == 0) goto L_0x006f
            r5 = 0
            goto L_0x0071
        L_0x006f:
            r5 = r42
        L_0x0071:
            r17 = r5
            r5 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r5 == 0) goto L_0x007a
            r5 = r27
            goto L_0x007c
        L_0x007a:
            r5 = r43
        L_0x007c:
            r18 = r5
            r5 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r5 == 0) goto L_0x0085
            r5 = r27
            goto L_0x0087
        L_0x0085:
            r5 = r44
        L_0x0087:
            r19 = 32768(0x8000, float:4.5918E-41)
            r19 = r0 & r19
            if (r19 == 0) goto L_0x0091
            r19 = r27
            goto L_0x0093
        L_0x0091:
            r19 = r45
        L_0x0093:
            r20 = 65536(0x10000, float:9.18355E-41)
            r20 = r0 & r20
            if (r20 == 0) goto L_0x009c
            r20 = 0
            goto L_0x009e
        L_0x009c:
            r20 = r46
        L_0x009e:
            r21 = 131072(0x20000, float:1.83671E-40)
            r21 = r0 & r21
            if (r21 == 0) goto L_0x00a7
            r21 = 0
            goto L_0x00a9
        L_0x00a7:
            r21 = r47
        L_0x00a9:
            r22 = 262144(0x40000, float:3.67342E-40)
            r22 = r0 & r22
            if (r22 == 0) goto L_0x00b2
            r22 = 0
            goto L_0x00b4
        L_0x00b2:
            r22 = r48
        L_0x00b4:
            r23 = 524288(0x80000, float:7.34684E-40)
            r23 = r0 & r23
            if (r23 == 0) goto L_0x00bd
            r23 = 0
            goto L_0x00bf
        L_0x00bd:
            r23 = r49
        L_0x00bf:
            r24 = 1048576(0x100000, float:1.469368E-39)
            r24 = r0 & r24
            if (r24 == 0) goto L_0x00c8
            r24 = 0
            goto L_0x00ca
        L_0x00c8:
            r24 = r50
        L_0x00ca:
            r25 = 2097152(0x200000, float:2.938736E-39)
            r0 = r0 & r25
            if (r0 == 0) goto L_0x00d2
            r0 = 0
            goto L_0x00d4
        L_0x00d2:
            r0 = r51
        L_0x00d4:
            r27 = r26
            r28 = r1
            r29 = r3
            r30 = r4
            r31 = r6
            r32 = r7
            r33 = r8
            r34 = r12
            r36 = r14
            r38 = r10
            r40 = r9
            r41 = r2
            r42 = r16
            r43 = r17
            r44 = r18
            r45 = r5
            r46 = r19
            r47 = r20
            r48 = r21
            r49 = r22
            r50 = r23
            r51 = r24
            r52 = r0
            r27.<init>(r28, r29, r30, r31, r32, r33, r34, r36, r38, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: datamodels.FeaturedProductItem.<init>(int, int, java.lang.String, int, int, java.lang.String, double, double, double, boolean, boolean, boolean, boolean, java.lang.String, java.lang.String, java.lang.String, boolean, boolean, boolean, boolean, boolean, datamodels.Restaurant, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
