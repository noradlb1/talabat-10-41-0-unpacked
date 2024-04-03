package com.talabat.rating.domain.model;

import com.talabat.NewRateActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b!\b\b\u0018\u00002\u00020\u0001Bi\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0006¢\u0006\u0002\u0010\u000fJ\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0006HÆ\u0003J\t\u0010!\u001a\u00020\u0006HÆ\u0003J\t\u0010\"\u001a\u00020\u0006HÆ\u0003J\t\u0010#\u001a\u00020\u0006HÆ\u0003J\t\u0010$\u001a\u00020\u000bHÆ\u0003J\t\u0010%\u001a\u00020\u000bHÆ\u0003J\t\u0010&\u001a\u00020\u0006HÆ\u0003Jm\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\u0006HÆ\u0001J\u0013\u0010(\u001a\u00020\u00032\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010*\u001a\u00020\u000bHÖ\u0001J\t\u0010+\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\r\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R\u0011\u0010\f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0011R\u0011\u0010\u000e\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015R\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0015¨\u0006,"}, d2 = {"Lcom/talabat/rating/domain/model/OrderRatingDetails;", "", "canRate", "", "showReasons", "vendorExperienceRatingTitle", "", "deliveryExperienceRatingTitle", "orderId", "vendorName", "branchId", "", "vendorId", "errorMessage", "vendorLogoUrl", "(ZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;)V", "getBranchId", "()I", "getCanRate", "()Z", "getDeliveryExperienceRatingTitle", "()Ljava/lang/String;", "getErrorMessage", "getOrderId", "getShowReasons", "getVendorExperienceRatingTitle", "getVendorId", "getVendorLogoUrl", "getVendorName", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OrderRatingDetails {
    private final int branchId;
    private final boolean canRate;
    @NotNull
    private final String deliveryExperienceRatingTitle;
    @NotNull
    private final String errorMessage;
    @NotNull
    private final String orderId;
    private final boolean showReasons;
    @NotNull
    private final String vendorExperienceRatingTitle;
    private final int vendorId;
    @NotNull
    private final String vendorLogoUrl;
    @NotNull
    private final String vendorName;

    public OrderRatingDetails() {
        this(false, false, (String) null, (String) null, (String) null, (String) null, 0, 0, (String) null, (String) null, 1023, (DefaultConstructorMarker) null);
    }

    public OrderRatingDetails(boolean z11, boolean z12, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, int i11, int i12, @NotNull String str5, @NotNull String str6) {
        Intrinsics.checkNotNullParameter(str, NewRateActivity.VENDOR_EXPERIENCE_RATING_TITLE);
        Intrinsics.checkNotNullParameter(str2, NewRateActivity.DELIVERY_EXPERIENCE_RATING_TITLE);
        Intrinsics.checkNotNullParameter(str3, "orderId");
        Intrinsics.checkNotNullParameter(str4, "vendorName");
        Intrinsics.checkNotNullParameter(str5, "errorMessage");
        Intrinsics.checkNotNullParameter(str6, "vendorLogoUrl");
        this.canRate = z11;
        this.showReasons = z12;
        this.vendorExperienceRatingTitle = str;
        this.deliveryExperienceRatingTitle = str2;
        this.orderId = str3;
        this.vendorName = str4;
        this.branchId = i11;
        this.vendorId = i12;
        this.errorMessage = str5;
        this.vendorLogoUrl = str6;
    }

    public static /* synthetic */ OrderRatingDetails copy$default(OrderRatingDetails orderRatingDetails, boolean z11, boolean z12, String str, String str2, String str3, String str4, int i11, int i12, String str5, String str6, int i13, Object obj) {
        OrderRatingDetails orderRatingDetails2 = orderRatingDetails;
        int i14 = i13;
        return orderRatingDetails.copy((i14 & 1) != 0 ? orderRatingDetails2.canRate : z11, (i14 & 2) != 0 ? orderRatingDetails2.showReasons : z12, (i14 & 4) != 0 ? orderRatingDetails2.vendorExperienceRatingTitle : str, (i14 & 8) != 0 ? orderRatingDetails2.deliveryExperienceRatingTitle : str2, (i14 & 16) != 0 ? orderRatingDetails2.orderId : str3, (i14 & 32) != 0 ? orderRatingDetails2.vendorName : str4, (i14 & 64) != 0 ? orderRatingDetails2.branchId : i11, (i14 & 128) != 0 ? orderRatingDetails2.vendorId : i12, (i14 & 256) != 0 ? orderRatingDetails2.errorMessage : str5, (i14 & 512) != 0 ? orderRatingDetails2.vendorLogoUrl : str6);
    }

    public final boolean component1() {
        return this.canRate;
    }

    @NotNull
    public final String component10() {
        return this.vendorLogoUrl;
    }

    public final boolean component2() {
        return this.showReasons;
    }

    @NotNull
    public final String component3() {
        return this.vendorExperienceRatingTitle;
    }

    @NotNull
    public final String component4() {
        return this.deliveryExperienceRatingTitle;
    }

    @NotNull
    public final String component5() {
        return this.orderId;
    }

    @NotNull
    public final String component6() {
        return this.vendorName;
    }

    public final int component7() {
        return this.branchId;
    }

    public final int component8() {
        return this.vendorId;
    }

    @NotNull
    public final String component9() {
        return this.errorMessage;
    }

    @NotNull
    public final OrderRatingDetails copy(boolean z11, boolean z12, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, int i11, int i12, @NotNull String str5, @NotNull String str6) {
        Intrinsics.checkNotNullParameter(str, NewRateActivity.VENDOR_EXPERIENCE_RATING_TITLE);
        String str7 = str2;
        Intrinsics.checkNotNullParameter(str7, NewRateActivity.DELIVERY_EXPERIENCE_RATING_TITLE);
        String str8 = str3;
        Intrinsics.checkNotNullParameter(str8, "orderId");
        String str9 = str4;
        Intrinsics.checkNotNullParameter(str9, "vendorName");
        String str10 = str5;
        Intrinsics.checkNotNullParameter(str10, "errorMessage");
        String str11 = str6;
        Intrinsics.checkNotNullParameter(str11, "vendorLogoUrl");
        return new OrderRatingDetails(z11, z12, str, str7, str8, str9, i11, i12, str10, str11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OrderRatingDetails)) {
            return false;
        }
        OrderRatingDetails orderRatingDetails = (OrderRatingDetails) obj;
        return this.canRate == orderRatingDetails.canRate && this.showReasons == orderRatingDetails.showReasons && Intrinsics.areEqual((Object) this.vendorExperienceRatingTitle, (Object) orderRatingDetails.vendorExperienceRatingTitle) && Intrinsics.areEqual((Object) this.deliveryExperienceRatingTitle, (Object) orderRatingDetails.deliveryExperienceRatingTitle) && Intrinsics.areEqual((Object) this.orderId, (Object) orderRatingDetails.orderId) && Intrinsics.areEqual((Object) this.vendorName, (Object) orderRatingDetails.vendorName) && this.branchId == orderRatingDetails.branchId && this.vendorId == orderRatingDetails.vendorId && Intrinsics.areEqual((Object) this.errorMessage, (Object) orderRatingDetails.errorMessage) && Intrinsics.areEqual((Object) this.vendorLogoUrl, (Object) orderRatingDetails.vendorLogoUrl);
    }

    public final int getBranchId() {
        return this.branchId;
    }

    public final boolean getCanRate() {
        return this.canRate;
    }

    @NotNull
    public final String getDeliveryExperienceRatingTitle() {
        return this.deliveryExperienceRatingTitle;
    }

    @NotNull
    public final String getErrorMessage() {
        return this.errorMessage;
    }

    @NotNull
    public final String getOrderId() {
        return this.orderId;
    }

    public final boolean getShowReasons() {
        return this.showReasons;
    }

    @NotNull
    public final String getVendorExperienceRatingTitle() {
        return this.vendorExperienceRatingTitle;
    }

    public final int getVendorId() {
        return this.vendorId;
    }

    @NotNull
    public final String getVendorLogoUrl() {
        return this.vendorLogoUrl;
    }

    @NotNull
    public final String getVendorName() {
        return this.vendorName;
    }

    public int hashCode() {
        boolean z11 = this.canRate;
        boolean z12 = true;
        if (z11) {
            z11 = true;
        }
        int i11 = (z11 ? 1 : 0) * true;
        boolean z13 = this.showReasons;
        if (!z13) {
            z12 = z13;
        }
        return ((((((((((((((((i11 + (z12 ? 1 : 0)) * 31) + this.vendorExperienceRatingTitle.hashCode()) * 31) + this.deliveryExperienceRatingTitle.hashCode()) * 31) + this.orderId.hashCode()) * 31) + this.vendorName.hashCode()) * 31) + this.branchId) * 31) + this.vendorId) * 31) + this.errorMessage.hashCode()) * 31) + this.vendorLogoUrl.hashCode();
    }

    @NotNull
    public String toString() {
        boolean z11 = this.canRate;
        boolean z12 = this.showReasons;
        String str = this.vendorExperienceRatingTitle;
        String str2 = this.deliveryExperienceRatingTitle;
        String str3 = this.orderId;
        String str4 = this.vendorName;
        int i11 = this.branchId;
        int i12 = this.vendorId;
        String str5 = this.errorMessage;
        String str6 = this.vendorLogoUrl;
        return "OrderRatingDetails(canRate=" + z11 + ", showReasons=" + z12 + ", vendorExperienceRatingTitle=" + str + ", deliveryExperienceRatingTitle=" + str2 + ", orderId=" + str3 + ", vendorName=" + str4 + ", branchId=" + i11 + ", vendorId=" + i12 + ", errorMessage=" + str5 + ", vendorLogoUrl=" + str6 + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ OrderRatingDetails(boolean r12, boolean r13, java.lang.String r14, java.lang.String r15, java.lang.String r16, java.lang.String r17, int r18, int r19, java.lang.String r20, java.lang.String r21, int r22, kotlin.jvm.internal.DefaultConstructorMarker r23) {
        /*
            r11 = this;
            r0 = r22
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = r2
            goto L_0x000a
        L_0x0009:
            r1 = r12
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            r3 = r2
            goto L_0x0011
        L_0x0010:
            r3 = r13
        L_0x0011:
            r4 = r0 & 4
            java.lang.String r5 = ""
            if (r4 == 0) goto L_0x0019
            r4 = r5
            goto L_0x001a
        L_0x0019:
            r4 = r14
        L_0x001a:
            r6 = r0 & 8
            if (r6 == 0) goto L_0x0020
            r6 = r5
            goto L_0x0021
        L_0x0020:
            r6 = r15
        L_0x0021:
            r7 = r0 & 16
            if (r7 == 0) goto L_0x0027
            r7 = r5
            goto L_0x0029
        L_0x0027:
            r7 = r16
        L_0x0029:
            r8 = r0 & 32
            if (r8 == 0) goto L_0x002f
            r8 = r5
            goto L_0x0031
        L_0x002f:
            r8 = r17
        L_0x0031:
            r9 = r0 & 64
            if (r9 == 0) goto L_0x0037
            r9 = r2
            goto L_0x0039
        L_0x0037:
            r9 = r18
        L_0x0039:
            r10 = r0 & 128(0x80, float:1.794E-43)
            if (r10 == 0) goto L_0x003e
            goto L_0x0040
        L_0x003e:
            r2 = r19
        L_0x0040:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x0046
            r10 = r5
            goto L_0x0048
        L_0x0046:
            r10 = r20
        L_0x0048:
            r0 = r0 & 512(0x200, float:7.175E-43)
            if (r0 == 0) goto L_0x004d
            goto L_0x004f
        L_0x004d:
            r5 = r21
        L_0x004f:
            r12 = r11
            r13 = r1
            r14 = r3
            r15 = r4
            r16 = r6
            r17 = r7
            r18 = r8
            r19 = r9
            r20 = r2
            r21 = r10
            r22 = r5
            r12.<init>(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.rating.domain.model.OrderRatingDetails.<init>(boolean, boolean, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, int, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
