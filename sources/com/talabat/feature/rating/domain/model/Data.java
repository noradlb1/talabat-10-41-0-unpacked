package com.talabat.feature.rating.domain.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003¢\u0006\u0002\u0010\rJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\tHÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003JY\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020\u0003HÖ\u0001J\t\u0010&\u001a\u00020\tHÖ\u0001R\u0016\u0010\u0007\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u000b\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u0016\u0010\f\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000f¨\u0006'"}, d2 = {"Lcom/talabat/feature/rating/domain/model/Data;", "", "transactionId", "", "vendorRating", "", "deliveryRating", "averageRating", "review", "", "orderId", "chainId", "vendorId", "(IFFFLjava/lang/String;III)V", "getAverageRating", "()F", "getChainId", "()I", "getDeliveryRating", "getOrderId", "getReview", "()Ljava/lang/String;", "getTransactionId", "getVendorId", "getVendorRating", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "toString", "com_talabat_feature_rating_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Data {
    @SerializedName("average_rating")
    private final float averageRating;
    @SerializedName("chain_id")
    private final int chainId;
    @SerializedName("delivery_rating")
    private final float deliveryRating;
    @SerializedName("order_id")
    private final int orderId;
    @SerializedName("review")
    @NotNull
    private final String review;
    @SerializedName("transaction_id")
    private final int transactionId;
    @SerializedName("vendor_id")
    private final int vendorId;
    @SerializedName("vendor_rating")
    private final float vendorRating;

    public Data(int i11, float f11, float f12, float f13, @NotNull String str, int i12, int i13, int i14) {
        Intrinsics.checkNotNullParameter(str, "review");
        this.transactionId = i11;
        this.vendorRating = f11;
        this.deliveryRating = f12;
        this.averageRating = f13;
        this.review = str;
        this.orderId = i12;
        this.chainId = i13;
        this.vendorId = i14;
    }

    public static /* synthetic */ Data copy$default(Data data, int i11, float f11, float f12, float f13, String str, int i12, int i13, int i14, int i15, Object obj) {
        Data data2 = data;
        int i16 = i15;
        return data.copy((i16 & 1) != 0 ? data2.transactionId : i11, (i16 & 2) != 0 ? data2.vendorRating : f11, (i16 & 4) != 0 ? data2.deliveryRating : f12, (i16 & 8) != 0 ? data2.averageRating : f13, (i16 & 16) != 0 ? data2.review : str, (i16 & 32) != 0 ? data2.orderId : i12, (i16 & 64) != 0 ? data2.chainId : i13, (i16 & 128) != 0 ? data2.vendorId : i14);
    }

    public final int component1() {
        return this.transactionId;
    }

    public final float component2() {
        return this.vendorRating;
    }

    public final float component3() {
        return this.deliveryRating;
    }

    public final float component4() {
        return this.averageRating;
    }

    @NotNull
    public final String component5() {
        return this.review;
    }

    public final int component6() {
        return this.orderId;
    }

    public final int component7() {
        return this.chainId;
    }

    public final int component8() {
        return this.vendorId;
    }

    @NotNull
    public final Data copy(int i11, float f11, float f12, float f13, @NotNull String str, int i12, int i13, int i14) {
        Intrinsics.checkNotNullParameter(str, "review");
        return new Data(i11, f11, f12, f13, str, i12, i13, i14);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Data)) {
            return false;
        }
        Data data = (Data) obj;
        return this.transactionId == data.transactionId && Intrinsics.areEqual((Object) Float.valueOf(this.vendorRating), (Object) Float.valueOf(data.vendorRating)) && Intrinsics.areEqual((Object) Float.valueOf(this.deliveryRating), (Object) Float.valueOf(data.deliveryRating)) && Intrinsics.areEqual((Object) Float.valueOf(this.averageRating), (Object) Float.valueOf(data.averageRating)) && Intrinsics.areEqual((Object) this.review, (Object) data.review) && this.orderId == data.orderId && this.chainId == data.chainId && this.vendorId == data.vendorId;
    }

    public final float getAverageRating() {
        return this.averageRating;
    }

    public final int getChainId() {
        return this.chainId;
    }

    public final float getDeliveryRating() {
        return this.deliveryRating;
    }

    public final int getOrderId() {
        return this.orderId;
    }

    @NotNull
    public final String getReview() {
        return this.review;
    }

    public final int getTransactionId() {
        return this.transactionId;
    }

    public final int getVendorId() {
        return this.vendorId;
    }

    public final float getVendorRating() {
        return this.vendorRating;
    }

    public int hashCode() {
        return (((((((((((((this.transactionId * 31) + Float.floatToIntBits(this.vendorRating)) * 31) + Float.floatToIntBits(this.deliveryRating)) * 31) + Float.floatToIntBits(this.averageRating)) * 31) + this.review.hashCode()) * 31) + this.orderId) * 31) + this.chainId) * 31) + this.vendorId;
    }

    @NotNull
    public String toString() {
        int i11 = this.transactionId;
        float f11 = this.vendorRating;
        float f12 = this.deliveryRating;
        float f13 = this.averageRating;
        String str = this.review;
        int i12 = this.orderId;
        int i13 = this.chainId;
        int i14 = this.vendorId;
        return "Data(transactionId=" + i11 + ", vendorRating=" + f11 + ", deliveryRating=" + f12 + ", averageRating=" + f13 + ", review=" + str + ", orderId=" + i12 + ", chainId=" + i13 + ", vendorId=" + i14 + ")";
    }
}
