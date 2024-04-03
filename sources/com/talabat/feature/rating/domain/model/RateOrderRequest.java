package com.talabat.feature.rating.domain.model;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001Ba\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\u0018\b\u0002\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00030\bj\b\u0012\u0004\u0012\u00020\u0003`\t\u0012\u0018\b\u0002\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u00030\bj\b\u0012\u0004\u0012\u00020\u0003`\t¢\u0006\u0002\u0010\u000bJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\u0019\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u00030\bj\b\u0012\u0004\u0012\u00020\u0003`\tHÆ\u0003J\u0019\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020\u00030\bj\b\u0012\u0004\u0012\u00020\u0003`\tHÆ\u0003Je\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\u0018\b\u0002\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00030\bj\b\u0012\u0004\u0012\u00020\u0003`\t2\u0018\b\u0002\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u00030\bj\b\u0012\u0004\u0012\u00020\u0003`\tHÆ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020$HÖ\u0001J\t\u0010%\u001a\u00020\u0003HÖ\u0001R\u001e\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR&\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00030\bj\b\u0012\u0004\u0012\u00020\u0003`\t8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000fR\u001e\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\r\"\u0004\b\u0017\u0010\u000fR&\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u00030\bj\b\u0012\u0004\u0012\u00020\u0003`\t8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011¨\u0006&"}, d2 = {"Lcom/talabat/feature/rating/domain/model/RateOrderRequest;", "", "orderId", "", "vendorRating", "deliveryRating", "review", "deliveryReasons", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "vendorReasons", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;Ljava/util/ArrayList;)V", "getDeliveryRating", "()Ljava/lang/String;", "setDeliveryRating", "(Ljava/lang/String;)V", "getDeliveryReasons", "()Ljava/util/ArrayList;", "getOrderId", "setOrderId", "getReview", "setReview", "getVendorRating", "setVendorRating", "getVendorReasons", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_feature_rating_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RateOrderRequest {
    @SerializedName("delivery_rating")
    @NotNull
    private String deliveryRating;
    @SerializedName("delivery_reasons")
    @NotNull
    private final ArrayList<String> deliveryReasons;
    @SerializedName("order_id")
    @NotNull
    private String orderId;
    @SerializedName("review")
    @NotNull
    private String review;
    @SerializedName("vendor_rating")
    @NotNull
    private String vendorRating;
    @SerializedName("vendor_reasons")
    @NotNull
    private final ArrayList<String> vendorReasons;

    public RateOrderRequest() {
        this((String) null, (String) null, (String) null, (String) null, (ArrayList) null, (ArrayList) null, 63, (DefaultConstructorMarker) null);
    }

    public RateOrderRequest(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull ArrayList<String> arrayList, @NotNull ArrayList<String> arrayList2) {
        Intrinsics.checkNotNullParameter(str, "orderId");
        Intrinsics.checkNotNullParameter(str2, "vendorRating");
        Intrinsics.checkNotNullParameter(str3, "deliveryRating");
        Intrinsics.checkNotNullParameter(str4, "review");
        Intrinsics.checkNotNullParameter(arrayList, "deliveryReasons");
        Intrinsics.checkNotNullParameter(arrayList2, "vendorReasons");
        this.orderId = str;
        this.vendorRating = str2;
        this.deliveryRating = str3;
        this.review = str4;
        this.deliveryReasons = arrayList;
        this.vendorReasons = arrayList2;
    }

    public static /* synthetic */ RateOrderRequest copy$default(RateOrderRequest rateOrderRequest, String str, String str2, String str3, String str4, ArrayList<String> arrayList, ArrayList<String> arrayList2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = rateOrderRequest.orderId;
        }
        if ((i11 & 2) != 0) {
            str2 = rateOrderRequest.vendorRating;
        }
        String str5 = str2;
        if ((i11 & 4) != 0) {
            str3 = rateOrderRequest.deliveryRating;
        }
        String str6 = str3;
        if ((i11 & 8) != 0) {
            str4 = rateOrderRequest.review;
        }
        String str7 = str4;
        if ((i11 & 16) != 0) {
            arrayList = rateOrderRequest.deliveryReasons;
        }
        ArrayList<String> arrayList3 = arrayList;
        if ((i11 & 32) != 0) {
            arrayList2 = rateOrderRequest.vendorReasons;
        }
        return rateOrderRequest.copy(str, str5, str6, str7, arrayList3, arrayList2);
    }

    @NotNull
    public final String component1() {
        return this.orderId;
    }

    @NotNull
    public final String component2() {
        return this.vendorRating;
    }

    @NotNull
    public final String component3() {
        return this.deliveryRating;
    }

    @NotNull
    public final String component4() {
        return this.review;
    }

    @NotNull
    public final ArrayList<String> component5() {
        return this.deliveryReasons;
    }

    @NotNull
    public final ArrayList<String> component6() {
        return this.vendorReasons;
    }

    @NotNull
    public final RateOrderRequest copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull ArrayList<String> arrayList, @NotNull ArrayList<String> arrayList2) {
        Intrinsics.checkNotNullParameter(str, "orderId");
        Intrinsics.checkNotNullParameter(str2, "vendorRating");
        Intrinsics.checkNotNullParameter(str3, "deliveryRating");
        Intrinsics.checkNotNullParameter(str4, "review");
        Intrinsics.checkNotNullParameter(arrayList, "deliveryReasons");
        Intrinsics.checkNotNullParameter(arrayList2, "vendorReasons");
        return new RateOrderRequest(str, str2, str3, str4, arrayList, arrayList2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RateOrderRequest)) {
            return false;
        }
        RateOrderRequest rateOrderRequest = (RateOrderRequest) obj;
        return Intrinsics.areEqual((Object) this.orderId, (Object) rateOrderRequest.orderId) && Intrinsics.areEqual((Object) this.vendorRating, (Object) rateOrderRequest.vendorRating) && Intrinsics.areEqual((Object) this.deliveryRating, (Object) rateOrderRequest.deliveryRating) && Intrinsics.areEqual((Object) this.review, (Object) rateOrderRequest.review) && Intrinsics.areEqual((Object) this.deliveryReasons, (Object) rateOrderRequest.deliveryReasons) && Intrinsics.areEqual((Object) this.vendorReasons, (Object) rateOrderRequest.vendorReasons);
    }

    @NotNull
    public final String getDeliveryRating() {
        return this.deliveryRating;
    }

    @NotNull
    public final ArrayList<String> getDeliveryReasons() {
        return this.deliveryReasons;
    }

    @NotNull
    public final String getOrderId() {
        return this.orderId;
    }

    @NotNull
    public final String getReview() {
        return this.review;
    }

    @NotNull
    public final String getVendorRating() {
        return this.vendorRating;
    }

    @NotNull
    public final ArrayList<String> getVendorReasons() {
        return this.vendorReasons;
    }

    public int hashCode() {
        return (((((((((this.orderId.hashCode() * 31) + this.vendorRating.hashCode()) * 31) + this.deliveryRating.hashCode()) * 31) + this.review.hashCode()) * 31) + this.deliveryReasons.hashCode()) * 31) + this.vendorReasons.hashCode();
    }

    public final void setDeliveryRating(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.deliveryRating = str;
    }

    public final void setOrderId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.orderId = str;
    }

    public final void setReview(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.review = str;
    }

    public final void setVendorRating(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.vendorRating = str;
    }

    @NotNull
    public String toString() {
        String str = this.orderId;
        String str2 = this.vendorRating;
        String str3 = this.deliveryRating;
        String str4 = this.review;
        ArrayList<String> arrayList = this.deliveryReasons;
        ArrayList<String> arrayList2 = this.vendorReasons;
        return "RateOrderRequest(orderId=" + str + ", vendorRating=" + str2 + ", deliveryRating=" + str3 + ", review=" + str4 + ", deliveryReasons=" + arrayList + ", vendorReasons=" + arrayList2 + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ RateOrderRequest(java.lang.String r5, java.lang.String r6, java.lang.String r7, java.lang.String r8, java.util.ArrayList r9, java.util.ArrayList r10, int r11, kotlin.jvm.internal.DefaultConstructorMarker r12) {
        /*
            r4 = this;
            r12 = r11 & 1
            java.lang.String r0 = ""
            if (r12 == 0) goto L_0x0008
            r12 = r0
            goto L_0x0009
        L_0x0008:
            r12 = r5
        L_0x0009:
            r5 = r11 & 2
            if (r5 == 0) goto L_0x000f
            r1 = r0
            goto L_0x0010
        L_0x000f:
            r1 = r6
        L_0x0010:
            r5 = r11 & 4
            if (r5 == 0) goto L_0x0016
            r2 = r0
            goto L_0x0017
        L_0x0016:
            r2 = r7
        L_0x0017:
            r5 = r11 & 8
            if (r5 == 0) goto L_0x001c
            goto L_0x001d
        L_0x001c:
            r0 = r8
        L_0x001d:
            r5 = r11 & 16
            if (r5 == 0) goto L_0x0026
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
        L_0x0026:
            r3 = r9
            r5 = r11 & 32
            if (r5 == 0) goto L_0x0030
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
        L_0x0030:
            r11 = r10
            r5 = r4
            r6 = r12
            r7 = r1
            r8 = r2
            r9 = r0
            r10 = r3
            r5.<init>(r6, r7, r8, r9, r10, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.rating.domain.model.RateOrderRequest.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.ArrayList, java.util.ArrayList, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
