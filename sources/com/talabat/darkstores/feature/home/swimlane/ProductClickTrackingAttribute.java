package com.talabat.darkstores.feature.home.swimlane;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J3\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\t\u0010\u0014\u001a\u00020\u0007HÖ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006 "}, d2 = {"Lcom/talabat/darkstores/feature/home/swimlane/ProductClickTrackingAttribute;", "Landroid/os/Parcelable;", "shopSponsoringPlacement", "", "swimlaneStrategy", "swimlaneTitle", "swimlaneLength", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getShopSponsoringPlacement", "()Ljava/lang/String;", "getSwimlaneLength", "()I", "getSwimlaneStrategy", "getSwimlaneTitle", "component1", "component2", "component3", "component4", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Parcelize
public final class ProductClickTrackingAttribute implements Parcelable {
    @NotNull
    public static final Parcelable.Creator<ProductClickTrackingAttribute> CREATOR = new Creator();
    @NotNull
    private final String shopSponsoringPlacement;
    private final int swimlaneLength;
    @Nullable
    private final String swimlaneStrategy;
    @NotNull
    private final String swimlaneTitle;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ProductClickTrackingAttribute> {
        @NotNull
        public final ProductClickTrackingAttribute createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ProductClickTrackingAttribute(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt());
        }

        @NotNull
        public final ProductClickTrackingAttribute[] newArray(int i11) {
            return new ProductClickTrackingAttribute[i11];
        }
    }

    public ProductClickTrackingAttribute(@NotNull String str, @Nullable String str2, @NotNull String str3, int i11) {
        Intrinsics.checkNotNullParameter(str, "shopSponsoringPlacement");
        Intrinsics.checkNotNullParameter(str3, "swimlaneTitle");
        this.shopSponsoringPlacement = str;
        this.swimlaneStrategy = str2;
        this.swimlaneTitle = str3;
        this.swimlaneLength = i11;
    }

    public static /* synthetic */ ProductClickTrackingAttribute copy$default(ProductClickTrackingAttribute productClickTrackingAttribute, String str, String str2, String str3, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            str = productClickTrackingAttribute.shopSponsoringPlacement;
        }
        if ((i12 & 2) != 0) {
            str2 = productClickTrackingAttribute.swimlaneStrategy;
        }
        if ((i12 & 4) != 0) {
            str3 = productClickTrackingAttribute.swimlaneTitle;
        }
        if ((i12 & 8) != 0) {
            i11 = productClickTrackingAttribute.swimlaneLength;
        }
        return productClickTrackingAttribute.copy(str, str2, str3, i11);
    }

    @NotNull
    public final String component1() {
        return this.shopSponsoringPlacement;
    }

    @Nullable
    public final String component2() {
        return this.swimlaneStrategy;
    }

    @NotNull
    public final String component3() {
        return this.swimlaneTitle;
    }

    public final int component4() {
        return this.swimlaneLength;
    }

    @NotNull
    public final ProductClickTrackingAttribute copy(@NotNull String str, @Nullable String str2, @NotNull String str3, int i11) {
        Intrinsics.checkNotNullParameter(str, "shopSponsoringPlacement");
        Intrinsics.checkNotNullParameter(str3, "swimlaneTitle");
        return new ProductClickTrackingAttribute(str, str2, str3, i11);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProductClickTrackingAttribute)) {
            return false;
        }
        ProductClickTrackingAttribute productClickTrackingAttribute = (ProductClickTrackingAttribute) obj;
        return Intrinsics.areEqual((Object) this.shopSponsoringPlacement, (Object) productClickTrackingAttribute.shopSponsoringPlacement) && Intrinsics.areEqual((Object) this.swimlaneStrategy, (Object) productClickTrackingAttribute.swimlaneStrategy) && Intrinsics.areEqual((Object) this.swimlaneTitle, (Object) productClickTrackingAttribute.swimlaneTitle) && this.swimlaneLength == productClickTrackingAttribute.swimlaneLength;
    }

    @NotNull
    public final String getShopSponsoringPlacement() {
        return this.shopSponsoringPlacement;
    }

    public final int getSwimlaneLength() {
        return this.swimlaneLength;
    }

    @Nullable
    public final String getSwimlaneStrategy() {
        return this.swimlaneStrategy;
    }

    @NotNull
    public final String getSwimlaneTitle() {
        return this.swimlaneTitle;
    }

    public int hashCode() {
        int hashCode = this.shopSponsoringPlacement.hashCode() * 31;
        String str = this.swimlaneStrategy;
        return ((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.swimlaneTitle.hashCode()) * 31) + this.swimlaneLength;
    }

    @NotNull
    public String toString() {
        String str = this.shopSponsoringPlacement;
        String str2 = this.swimlaneStrategy;
        String str3 = this.swimlaneTitle;
        int i11 = this.swimlaneLength;
        return "ProductClickTrackingAttribute(shopSponsoringPlacement=" + str + ", swimlaneStrategy=" + str2 + ", swimlaneTitle=" + str3 + ", swimlaneLength=" + i11 + ")";
    }

    public void writeToParcel(@NotNull Parcel parcel, int i11) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.shopSponsoringPlacement);
        parcel.writeString(this.swimlaneStrategy);
        parcel.writeString(this.swimlaneTitle);
        parcel.writeInt(this.swimlaneLength);
    }
}
