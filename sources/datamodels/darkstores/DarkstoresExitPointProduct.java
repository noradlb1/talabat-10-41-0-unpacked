package datamodels.darkstores;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\"\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001Be\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\f\u001a\u00020\n\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000f¢\u0006\u0002\u0010\u0010J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\u0011\u0010&\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000fHÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010*\u001a\u00020\bHÆ\u0003J\t\u0010+\u001a\u00020\nHÆ\u0003J\u0010\u0010,\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u001bJ\t\u0010-\u001a\u00020\nHÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0001\u0010/\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\f\u001a\u00020\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000fHÆ\u0001¢\u0006\u0002\u00100J\u0013\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00104\u001a\u00020\bHÖ\u0001J\t\u00105\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\f\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0012R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0016R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0016R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0016¨\u00066"}, d2 = {"Ldatamodels/darkstores/DarkstoresExitPointProduct;", "", "id", "", "name", "productDescription", "thumbnail", "quantity", "", "price", "", "originalPrice", "absoluteDiscount", "sku", "categoryIds", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IFLjava/lang/Float;FLjava/lang/String;Ljava/util/List;)V", "getAbsoluteDiscount", "()F", "getCategoryIds", "()Ljava/util/List;", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "getName", "getOriginalPrice", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getPrice", "getProductDescription", "getQuantity", "()I", "setQuantity", "(I)V", "getSku", "getThumbnail", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IFLjava/lang/Float;FLjava/lang/String;Ljava/util/List;)Ldatamodels/darkstores/DarkstoresExitPointProduct;", "equals", "", "other", "hashCode", "toString", "com_talabat_core_legacy-models_legacy-models"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DarkstoresExitPointProduct {
    private final float absoluteDiscount;
    @Nullable
    private final List<String> categoryIds;
    @NotNull

    /* renamed from: id  reason: collision with root package name */
    private String f13879id;
    @NotNull

    /* renamed from: name  reason: collision with root package name */
    private final String f13880name;
    @Nullable
    private final Float originalPrice;
    private final float price;
    @Nullable
    private final String productDescription;
    private int quantity;
    @Nullable
    private final String sku;
    @Nullable
    private final String thumbnail;

    public DarkstoresExitPointProduct(@NotNull String str, @NotNull String str2, @Nullable String str3, @Nullable String str4, int i11, float f11, @Nullable Float f12, float f13, @Nullable String str5, @Nullable List<String> list) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "name");
        this.f13879id = str;
        this.f13880name = str2;
        this.productDescription = str3;
        this.thumbnail = str4;
        this.quantity = i11;
        this.price = f11;
        this.originalPrice = f12;
        this.absoluteDiscount = f13;
        this.sku = str5;
        this.categoryIds = list;
    }

    public static /* synthetic */ DarkstoresExitPointProduct copy$default(DarkstoresExitPointProduct darkstoresExitPointProduct, String str, String str2, String str3, String str4, int i11, float f11, Float f12, float f13, String str5, List list, int i12, Object obj) {
        DarkstoresExitPointProduct darkstoresExitPointProduct2 = darkstoresExitPointProduct;
        int i13 = i12;
        return darkstoresExitPointProduct.copy((i13 & 1) != 0 ? darkstoresExitPointProduct2.f13879id : str, (i13 & 2) != 0 ? darkstoresExitPointProduct2.f13880name : str2, (i13 & 4) != 0 ? darkstoresExitPointProduct2.productDescription : str3, (i13 & 8) != 0 ? darkstoresExitPointProduct2.thumbnail : str4, (i13 & 16) != 0 ? darkstoresExitPointProduct2.quantity : i11, (i13 & 32) != 0 ? darkstoresExitPointProduct2.price : f11, (i13 & 64) != 0 ? darkstoresExitPointProduct2.originalPrice : f12, (i13 & 128) != 0 ? darkstoresExitPointProduct2.absoluteDiscount : f13, (i13 & 256) != 0 ? darkstoresExitPointProduct2.sku : str5, (i13 & 512) != 0 ? darkstoresExitPointProduct2.categoryIds : list);
    }

    @NotNull
    public final String component1() {
        return this.f13879id;
    }

    @Nullable
    public final List<String> component10() {
        return this.categoryIds;
    }

    @NotNull
    public final String component2() {
        return this.f13880name;
    }

    @Nullable
    public final String component3() {
        return this.productDescription;
    }

    @Nullable
    public final String component4() {
        return this.thumbnail;
    }

    public final int component5() {
        return this.quantity;
    }

    public final float component6() {
        return this.price;
    }

    @Nullable
    public final Float component7() {
        return this.originalPrice;
    }

    public final float component8() {
        return this.absoluteDiscount;
    }

    @Nullable
    public final String component9() {
        return this.sku;
    }

    @NotNull
    public final DarkstoresExitPointProduct copy(@NotNull String str, @NotNull String str2, @Nullable String str3, @Nullable String str4, int i11, float f11, @Nullable Float f12, float f13, @Nullable String str5, @Nullable List<String> list) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "name");
        return new DarkstoresExitPointProduct(str, str2, str3, str4, i11, f11, f12, f13, str5, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DarkstoresExitPointProduct)) {
            return false;
        }
        DarkstoresExitPointProduct darkstoresExitPointProduct = (DarkstoresExitPointProduct) obj;
        return Intrinsics.areEqual((Object) this.f13879id, (Object) darkstoresExitPointProduct.f13879id) && Intrinsics.areEqual((Object) this.f13880name, (Object) darkstoresExitPointProduct.f13880name) && Intrinsics.areEqual((Object) this.productDescription, (Object) darkstoresExitPointProduct.productDescription) && Intrinsics.areEqual((Object) this.thumbnail, (Object) darkstoresExitPointProduct.thumbnail) && this.quantity == darkstoresExitPointProduct.quantity && Intrinsics.areEqual((Object) Float.valueOf(this.price), (Object) Float.valueOf(darkstoresExitPointProduct.price)) && Intrinsics.areEqual((Object) this.originalPrice, (Object) darkstoresExitPointProduct.originalPrice) && Intrinsics.areEqual((Object) Float.valueOf(this.absoluteDiscount), (Object) Float.valueOf(darkstoresExitPointProduct.absoluteDiscount)) && Intrinsics.areEqual((Object) this.sku, (Object) darkstoresExitPointProduct.sku) && Intrinsics.areEqual((Object) this.categoryIds, (Object) darkstoresExitPointProduct.categoryIds);
    }

    public final float getAbsoluteDiscount() {
        return this.absoluteDiscount;
    }

    @Nullable
    public final List<String> getCategoryIds() {
        return this.categoryIds;
    }

    @NotNull
    public final String getId() {
        return this.f13879id;
    }

    @NotNull
    public final String getName() {
        return this.f13880name;
    }

    @Nullable
    public final Float getOriginalPrice() {
        return this.originalPrice;
    }

    public final float getPrice() {
        return this.price;
    }

    @Nullable
    public final String getProductDescription() {
        return this.productDescription;
    }

    public final int getQuantity() {
        return this.quantity;
    }

    @Nullable
    public final String getSku() {
        return this.sku;
    }

    @Nullable
    public final String getThumbnail() {
        return this.thumbnail;
    }

    public int hashCode() {
        int hashCode = ((this.f13879id.hashCode() * 31) + this.f13880name.hashCode()) * 31;
        String str = this.productDescription;
        int i11 = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.thumbnail;
        int hashCode3 = (((((hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.quantity) * 31) + Float.floatToIntBits(this.price)) * 31;
        Float f11 = this.originalPrice;
        int hashCode4 = (((hashCode3 + (f11 == null ? 0 : f11.hashCode())) * 31) + Float.floatToIntBits(this.absoluteDiscount)) * 31;
        String str3 = this.sku;
        int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        List<String> list = this.categoryIds;
        if (list != null) {
            i11 = list.hashCode();
        }
        return hashCode5 + i11;
    }

    public final void setId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f13879id = str;
    }

    public final void setQuantity(int i11) {
        this.quantity = i11;
    }

    @NotNull
    public String toString() {
        String str = this.f13879id;
        String str2 = this.f13880name;
        String str3 = this.productDescription;
        String str4 = this.thumbnail;
        int i11 = this.quantity;
        float f11 = this.price;
        Float f12 = this.originalPrice;
        float f13 = this.absoluteDiscount;
        String str5 = this.sku;
        List<String> list = this.categoryIds;
        return "DarkstoresExitPointProduct(id=" + str + ", name=" + str2 + ", productDescription=" + str3 + ", thumbnail=" + str4 + ", quantity=" + i11 + ", price=" + f11 + ", originalPrice=" + f12 + ", absoluteDiscount=" + f13 + ", sku=" + str5 + ", categoryIds=" + list + ")";
    }
}
