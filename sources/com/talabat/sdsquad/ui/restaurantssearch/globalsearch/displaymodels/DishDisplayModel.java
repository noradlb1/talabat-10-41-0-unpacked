package com.talabat.sdsquad.ui.restaurantssearch.globalsearch.displaymodels;

import com.talabat.sdsquad.core.DisplayModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000b\n\u0002\b*\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001Be\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0010\u001a\u00020\u000e\u0012\u0006\u0010\u0011\u001a\u00020\u0003¢\u0006\u0002\u0010\u0012J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u000eHÆ\u0003J\t\u0010,\u001a\u00020\u000eHÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\t\u0010/\u001a\u00020\u0006HÆ\u0003J\t\u00100\u001a\u00020\u0006HÆ\u0003J\t\u00101\u001a\u00020\u0006HÆ\u0003J\t\u00102\u001a\u00020\u0003HÆ\u0003J\t\u00103\u001a\u00020\u0006HÆ\u0003J\t\u00104\u001a\u00020\fHÆ\u0003J\t\u00105\u001a\u00020\u000eHÆ\u0003J\u0001\u00106\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u0003HÆ\u0001J\u0013\u00107\u001a\u00020\u000e2\b\u00108\u001a\u0004\u0018\u000109HÖ\u0003J\t\u0010:\u001a\u00020\u0003HÖ\u0001J\t\u0010;\u001a\u00020\u0006HÖ\u0001R\u001a\u0010\n\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0011\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0018\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\t\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001bR\u001a\u0010\b\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0014\"\u0004\b\u001f\u0010\u0016R\u001a\u0010\u0007\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0014\"\u0004\b!\u0010\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0018R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010#R\u0011\u0010\u000f\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010#R\u0011\u0010\u0010\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010#R\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0014\"\u0004\b)\u0010\u0016¨\u0006<"}, d2 = {"Lcom/talabat/sdsquad/ui/restaurantssearch/globalsearch/displaymodels/DishDisplayModel;", "Lcom/talabat/sdsquad/core/DisplayModel;", "id", "", "branchId", "vendorName", "", "dishName", "dishImage", "dishCount", "baseUrl", "price", "", "isBusy", "", "isClosed", "isOpen", "decimalCount", "(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;DZZZI)V", "getBaseUrl", "()Ljava/lang/String;", "setBaseUrl", "(Ljava/lang/String;)V", "getBranchId", "()I", "getDecimalCount", "setDecimalCount", "(I)V", "getDishCount", "setDishCount", "getDishImage", "setDishImage", "getDishName", "setDishName", "getId", "()Z", "getPrice", "()D", "setPrice", "(D)V", "getVendorName", "setVendorName", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "", "hashCode", "toString", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DishDisplayModel implements DisplayModel {
    @NotNull
    private String baseUrl;
    private final int branchId;
    private int decimalCount;
    private int dishCount;
    @NotNull
    private String dishImage;
    @NotNull
    private String dishName;

    /* renamed from: id  reason: collision with root package name */
    private final int f61344id;
    private final boolean isBusy;
    private final boolean isClosed;
    private final boolean isOpen;
    private double price;
    @NotNull
    private String vendorName;

    public DishDisplayModel(int i11, int i12, @NotNull String str, @NotNull String str2, @NotNull String str3, int i13, @NotNull String str4, double d11, boolean z11, boolean z12, boolean z13, int i14) {
        Intrinsics.checkNotNullParameter(str, "vendorName");
        Intrinsics.checkNotNullParameter(str2, "dishName");
        Intrinsics.checkNotNullParameter(str3, "dishImage");
        Intrinsics.checkNotNullParameter(str4, "baseUrl");
        this.f61344id = i11;
        this.branchId = i12;
        this.vendorName = str;
        this.dishName = str2;
        this.dishImage = str3;
        this.dishCount = i13;
        this.baseUrl = str4;
        this.price = d11;
        this.isBusy = z11;
        this.isClosed = z12;
        this.isOpen = z13;
        this.decimalCount = i14;
    }

    public static /* synthetic */ DishDisplayModel copy$default(DishDisplayModel dishDisplayModel, int i11, int i12, String str, String str2, String str3, int i13, String str4, double d11, boolean z11, boolean z12, boolean z13, int i14, int i15, Object obj) {
        DishDisplayModel dishDisplayModel2 = dishDisplayModel;
        int i16 = i15;
        return dishDisplayModel.copy((i16 & 1) != 0 ? dishDisplayModel2.f61344id : i11, (i16 & 2) != 0 ? dishDisplayModel2.branchId : i12, (i16 & 4) != 0 ? dishDisplayModel2.vendorName : str, (i16 & 8) != 0 ? dishDisplayModel2.dishName : str2, (i16 & 16) != 0 ? dishDisplayModel2.dishImage : str3, (i16 & 32) != 0 ? dishDisplayModel2.dishCount : i13, (i16 & 64) != 0 ? dishDisplayModel2.baseUrl : str4, (i16 & 128) != 0 ? dishDisplayModel2.price : d11, (i16 & 256) != 0 ? dishDisplayModel2.isBusy : z11, (i16 & 512) != 0 ? dishDisplayModel2.isClosed : z12, (i16 & 1024) != 0 ? dishDisplayModel2.isOpen : z13, (i16 & 2048) != 0 ? dishDisplayModel2.decimalCount : i14);
    }

    public final int component1() {
        return this.f61344id;
    }

    public final boolean component10() {
        return this.isClosed;
    }

    public final boolean component11() {
        return this.isOpen;
    }

    public final int component12() {
        return this.decimalCount;
    }

    public final int component2() {
        return this.branchId;
    }

    @NotNull
    public final String component3() {
        return this.vendorName;
    }

    @NotNull
    public final String component4() {
        return this.dishName;
    }

    @NotNull
    public final String component5() {
        return this.dishImage;
    }

    public final int component6() {
        return this.dishCount;
    }

    @NotNull
    public final String component7() {
        return this.baseUrl;
    }

    public final double component8() {
        return this.price;
    }

    public final boolean component9() {
        return this.isBusy;
    }

    @NotNull
    public final DishDisplayModel copy(int i11, int i12, @NotNull String str, @NotNull String str2, @NotNull String str3, int i13, @NotNull String str4, double d11, boolean z11, boolean z12, boolean z13, int i14) {
        String str5 = str;
        Intrinsics.checkNotNullParameter(str5, "vendorName");
        String str6 = str2;
        Intrinsics.checkNotNullParameter(str6, "dishName");
        String str7 = str3;
        Intrinsics.checkNotNullParameter(str7, "dishImage");
        String str8 = str4;
        Intrinsics.checkNotNullParameter(str8, "baseUrl");
        return new DishDisplayModel(i11, i12, str5, str6, str7, i13, str8, d11, z11, z12, z13, i14);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DishDisplayModel)) {
            return false;
        }
        DishDisplayModel dishDisplayModel = (DishDisplayModel) obj;
        return this.f61344id == dishDisplayModel.f61344id && this.branchId == dishDisplayModel.branchId && Intrinsics.areEqual((Object) this.vendorName, (Object) dishDisplayModel.vendorName) && Intrinsics.areEqual((Object) this.dishName, (Object) dishDisplayModel.dishName) && Intrinsics.areEqual((Object) this.dishImage, (Object) dishDisplayModel.dishImage) && this.dishCount == dishDisplayModel.dishCount && Intrinsics.areEqual((Object) this.baseUrl, (Object) dishDisplayModel.baseUrl) && Intrinsics.areEqual((Object) Double.valueOf(this.price), (Object) Double.valueOf(dishDisplayModel.price)) && this.isBusy == dishDisplayModel.isBusy && this.isClosed == dishDisplayModel.isClosed && this.isOpen == dishDisplayModel.isOpen && this.decimalCount == dishDisplayModel.decimalCount;
    }

    @NotNull
    public final String getBaseUrl() {
        return this.baseUrl;
    }

    public final int getBranchId() {
        return this.branchId;
    }

    public final int getDecimalCount() {
        return this.decimalCount;
    }

    public final int getDishCount() {
        return this.dishCount;
    }

    @NotNull
    public final String getDishImage() {
        return this.dishImage;
    }

    @NotNull
    public final String getDishName() {
        return this.dishName;
    }

    public final int getId() {
        return this.f61344id;
    }

    public final double getPrice() {
        return this.price;
    }

    @NotNull
    public final String getVendorName() {
        return this.vendorName;
    }

    public int hashCode() {
        int hashCode = ((((((((((((((this.f61344id * 31) + this.branchId) * 31) + this.vendorName.hashCode()) * 31) + this.dishName.hashCode()) * 31) + this.dishImage.hashCode()) * 31) + this.dishCount) * 31) + this.baseUrl.hashCode()) * 31) + Double.doubleToLongBits(this.price)) * 31;
        boolean z11 = this.isBusy;
        boolean z12 = true;
        if (z11) {
            z11 = true;
        }
        int i11 = (hashCode + (z11 ? 1 : 0)) * 31;
        boolean z13 = this.isClosed;
        if (z13) {
            z13 = true;
        }
        int i12 = (i11 + (z13 ? 1 : 0)) * 31;
        boolean z14 = this.isOpen;
        if (!z14) {
            z12 = z14;
        }
        return ((i12 + (z12 ? 1 : 0)) * 31) + this.decimalCount;
    }

    public final boolean isBusy() {
        return this.isBusy;
    }

    public final boolean isClosed() {
        return this.isClosed;
    }

    public final boolean isOpen() {
        return this.isOpen;
    }

    public final void setBaseUrl(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.baseUrl = str;
    }

    public final void setDecimalCount(int i11) {
        this.decimalCount = i11;
    }

    public final void setDishCount(int i11) {
        this.dishCount = i11;
    }

    public final void setDishImage(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.dishImage = str;
    }

    public final void setDishName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.dishName = str;
    }

    public final void setPrice(double d11) {
        this.price = d11;
    }

    public final void setVendorName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.vendorName = str;
    }

    @NotNull
    public String toString() {
        int i11 = this.f61344id;
        int i12 = this.branchId;
        String str = this.vendorName;
        String str2 = this.dishName;
        String str3 = this.dishImage;
        int i13 = this.dishCount;
        String str4 = this.baseUrl;
        double d11 = this.price;
        boolean z11 = this.isBusy;
        boolean z12 = this.isClosed;
        boolean z13 = this.isOpen;
        int i14 = this.decimalCount;
        return "DishDisplayModel(id=" + i11 + ", branchId=" + i12 + ", vendorName=" + str + ", dishName=" + str2 + ", dishImage=" + str3 + ", dishCount=" + i13 + ", baseUrl=" + str4 + ", price=" + d11 + ", isBusy=" + z11 + ", isClosed=" + z12 + ", isOpen=" + z13 + ", decimalCount=" + i14 + ")";
    }
}
