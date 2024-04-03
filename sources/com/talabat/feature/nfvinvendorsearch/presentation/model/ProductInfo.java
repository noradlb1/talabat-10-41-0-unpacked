package com.talabat.feature.nfvinvendorsearch.presentation.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u001f"}, d2 = {"Lcom/talabat/feature/nfvinvendorsearch/presentation/model/ProductInfo;", "Landroid/os/Parcelable;", "productId", "", "eventOrigin", "swimlaneRequestId", "searchRequestId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getEventOrigin", "()Ljava/lang/String;", "getProductId", "getSearchRequestId", "getSwimlaneRequestId", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "com_talabat_feature_qcommerce-flutter_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Parcelize
public final class ProductInfo implements Parcelable {
    @NotNull
    public static final Parcelable.Creator<ProductInfo> CREATOR = new Creator();
    @NotNull
    private final String eventOrigin;
    @NotNull
    private final String productId;
    @NotNull
    private final String searchRequestId;
    @NotNull
    private final String swimlaneRequestId;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ProductInfo> {
        @NotNull
        public final ProductInfo createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ProductInfo(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        @NotNull
        public final ProductInfo[] newArray(int i11) {
            return new ProductInfo[i11];
        }
    }

    public ProductInfo(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkNotNullParameter(str, "productId");
        Intrinsics.checkNotNullParameter(str2, "eventOrigin");
        Intrinsics.checkNotNullParameter(str3, "swimlaneRequestId");
        Intrinsics.checkNotNullParameter(str4, "searchRequestId");
        this.productId = str;
        this.eventOrigin = str2;
        this.swimlaneRequestId = str3;
        this.searchRequestId = str4;
    }

    public static /* synthetic */ ProductInfo copy$default(ProductInfo productInfo, String str, String str2, String str3, String str4, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = productInfo.productId;
        }
        if ((i11 & 2) != 0) {
            str2 = productInfo.eventOrigin;
        }
        if ((i11 & 4) != 0) {
            str3 = productInfo.swimlaneRequestId;
        }
        if ((i11 & 8) != 0) {
            str4 = productInfo.searchRequestId;
        }
        return productInfo.copy(str, str2, str3, str4);
    }

    @NotNull
    public final String component1() {
        return this.productId;
    }

    @NotNull
    public final String component2() {
        return this.eventOrigin;
    }

    @NotNull
    public final String component3() {
        return this.swimlaneRequestId;
    }

    @NotNull
    public final String component4() {
        return this.searchRequestId;
    }

    @NotNull
    public final ProductInfo copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkNotNullParameter(str, "productId");
        Intrinsics.checkNotNullParameter(str2, "eventOrigin");
        Intrinsics.checkNotNullParameter(str3, "swimlaneRequestId");
        Intrinsics.checkNotNullParameter(str4, "searchRequestId");
        return new ProductInfo(str, str2, str3, str4);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProductInfo)) {
            return false;
        }
        ProductInfo productInfo = (ProductInfo) obj;
        return Intrinsics.areEqual((Object) this.productId, (Object) productInfo.productId) && Intrinsics.areEqual((Object) this.eventOrigin, (Object) productInfo.eventOrigin) && Intrinsics.areEqual((Object) this.swimlaneRequestId, (Object) productInfo.swimlaneRequestId) && Intrinsics.areEqual((Object) this.searchRequestId, (Object) productInfo.searchRequestId);
    }

    @NotNull
    public final String getEventOrigin() {
        return this.eventOrigin;
    }

    @NotNull
    public final String getProductId() {
        return this.productId;
    }

    @NotNull
    public final String getSearchRequestId() {
        return this.searchRequestId;
    }

    @NotNull
    public final String getSwimlaneRequestId() {
        return this.swimlaneRequestId;
    }

    public int hashCode() {
        return (((((this.productId.hashCode() * 31) + this.eventOrigin.hashCode()) * 31) + this.swimlaneRequestId.hashCode()) * 31) + this.searchRequestId.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.productId;
        String str2 = this.eventOrigin;
        String str3 = this.swimlaneRequestId;
        String str4 = this.searchRequestId;
        return "ProductInfo(productId=" + str + ", eventOrigin=" + str2 + ", swimlaneRequestId=" + str3 + ", searchRequestId=" + str4 + ")";
    }

    public void writeToParcel(@NotNull Parcel parcel, int i11) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.productId);
        parcel.writeString(this.eventOrigin);
        parcel.writeString(this.swimlaneRequestId);
        parcel.writeString(this.searchRequestId);
    }
}
