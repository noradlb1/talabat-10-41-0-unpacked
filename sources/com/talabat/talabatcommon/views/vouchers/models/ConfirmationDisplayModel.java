package com.talabat.talabatcommon.views.vouchers.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.talabat.talabatcommon.feature.vouchers.loyalty.VoucherUrlConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BY\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\bHÆ\u0003J\u0010\u0010\"\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010$\u001a\u00020\rHÆ\u0003Jb\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\f\u001a\u00020\rHÆ\u0001¢\u0006\u0002\u0010&J\t\u0010'\u001a\u00020\nHÖ\u0001J\u0013\u0010(\u001a\u00020\b2\b\u0010)\u001a\u0004\u0018\u00010*HÖ\u0003J\t\u0010+\u001a\u00020\nHÖ\u0001J\t\u0010,\u001a\u00020\u0003HÖ\u0001J\u0019\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\nHÖ\u0001R\u0015\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0016R\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0013¨\u00062"}, d2 = {"Lcom/talabat/talabatcommon/views/vouchers/models/ConfirmationDisplayModel;", "Landroid/os/Parcelable;", "customerVoucherId", "", "couponCode", "partnerLink", "partnerButtonLink", "isSuccess", "", "brandId", "", "description", "orderNowDirection", "Lcom/talabat/talabatcommon/views/vouchers/models/OrderNowDirection;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/Integer;Ljava/lang/String;Lcom/talabat/talabatcommon/views/vouchers/models/OrderNowDirection;)V", "getBrandId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCouponCode", "()Ljava/lang/String;", "getCustomerVoucherId", "getDescription", "()Z", "getOrderNowDirection", "()Lcom/talabat/talabatcommon/views/vouchers/models/OrderNowDirection;", "setOrderNowDirection", "(Lcom/talabat/talabatcommon/views/vouchers/models/OrderNowDirection;)V", "getPartnerButtonLink", "getPartnerLink", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/Integer;Ljava/lang/String;Lcom/talabat/talabatcommon/views/vouchers/models/OrderNowDirection;)Lcom/talabat/talabatcommon/views/vouchers/models/ConfirmationDisplayModel;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Parcelize
public final class ConfirmationDisplayModel implements Parcelable {
    @NotNull
    public static final Parcelable.Creator<ConfirmationDisplayModel> CREATOR = new Creator();
    @Nullable
    private final Integer brandId;
    @NotNull
    private final String couponCode;
    @NotNull
    private final String customerVoucherId;
    @Nullable
    private final String description;
    private final boolean isSuccess;
    @NotNull
    private OrderNowDirection orderNowDirection;
    @NotNull
    private final String partnerButtonLink;
    @NotNull
    private final String partnerLink;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ConfirmationDisplayModel> {
        @NotNull
        public final ConfirmationDisplayModel createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ConfirmationDisplayModel(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readString(), (OrderNowDirection) parcel.readParcelable(ConfirmationDisplayModel.class.getClassLoader()));
        }

        @NotNull
        public final ConfirmationDisplayModel[] newArray(int i11) {
            return new ConfirmationDisplayModel[i11];
        }
    }

    public ConfirmationDisplayModel() {
        this((String) null, (String) null, (String) null, (String) null, false, (Integer) null, (String) null, (OrderNowDirection) null, 255, (DefaultConstructorMarker) null);
    }

    public ConfirmationDisplayModel(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, boolean z11, @Nullable Integer num, @Nullable String str5, @NotNull OrderNowDirection orderNowDirection2) {
        Intrinsics.checkNotNullParameter(str, VoucherUrlConstantsKt.QUERY_CUSTOMER_VOUCHER_ID);
        Intrinsics.checkNotNullParameter(str2, "couponCode");
        Intrinsics.checkNotNullParameter(str3, "partnerLink");
        Intrinsics.checkNotNullParameter(str4, "partnerButtonLink");
        Intrinsics.checkNotNullParameter(orderNowDirection2, "orderNowDirection");
        this.customerVoucherId = str;
        this.couponCode = str2;
        this.partnerLink = str3;
        this.partnerButtonLink = str4;
        this.isSuccess = z11;
        this.brandId = num;
        this.description = str5;
        this.orderNowDirection = orderNowDirection2;
    }

    public static /* synthetic */ ConfirmationDisplayModel copy$default(ConfirmationDisplayModel confirmationDisplayModel, String str, String str2, String str3, String str4, boolean z11, Integer num, String str5, OrderNowDirection orderNowDirection2, int i11, Object obj) {
        ConfirmationDisplayModel confirmationDisplayModel2 = confirmationDisplayModel;
        int i12 = i11;
        return confirmationDisplayModel.copy((i12 & 1) != 0 ? confirmationDisplayModel2.customerVoucherId : str, (i12 & 2) != 0 ? confirmationDisplayModel2.couponCode : str2, (i12 & 4) != 0 ? confirmationDisplayModel2.partnerLink : str3, (i12 & 8) != 0 ? confirmationDisplayModel2.partnerButtonLink : str4, (i12 & 16) != 0 ? confirmationDisplayModel2.isSuccess : z11, (i12 & 32) != 0 ? confirmationDisplayModel2.brandId : num, (i12 & 64) != 0 ? confirmationDisplayModel2.description : str5, (i12 & 128) != 0 ? confirmationDisplayModel2.orderNowDirection : orderNowDirection2);
    }

    @NotNull
    public final String component1() {
        return this.customerVoucherId;
    }

    @NotNull
    public final String component2() {
        return this.couponCode;
    }

    @NotNull
    public final String component3() {
        return this.partnerLink;
    }

    @NotNull
    public final String component4() {
        return this.partnerButtonLink;
    }

    public final boolean component5() {
        return this.isSuccess;
    }

    @Nullable
    public final Integer component6() {
        return this.brandId;
    }

    @Nullable
    public final String component7() {
        return this.description;
    }

    @NotNull
    public final OrderNowDirection component8() {
        return this.orderNowDirection;
    }

    @NotNull
    public final ConfirmationDisplayModel copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, boolean z11, @Nullable Integer num, @Nullable String str5, @NotNull OrderNowDirection orderNowDirection2) {
        Intrinsics.checkNotNullParameter(str, VoucherUrlConstantsKt.QUERY_CUSTOMER_VOUCHER_ID);
        Intrinsics.checkNotNullParameter(str2, "couponCode");
        Intrinsics.checkNotNullParameter(str3, "partnerLink");
        Intrinsics.checkNotNullParameter(str4, "partnerButtonLink");
        OrderNowDirection orderNowDirection3 = orderNowDirection2;
        Intrinsics.checkNotNullParameter(orderNowDirection3, "orderNowDirection");
        return new ConfirmationDisplayModel(str, str2, str3, str4, z11, num, str5, orderNowDirection3);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ConfirmationDisplayModel)) {
            return false;
        }
        ConfirmationDisplayModel confirmationDisplayModel = (ConfirmationDisplayModel) obj;
        return Intrinsics.areEqual((Object) this.customerVoucherId, (Object) confirmationDisplayModel.customerVoucherId) && Intrinsics.areEqual((Object) this.couponCode, (Object) confirmationDisplayModel.couponCode) && Intrinsics.areEqual((Object) this.partnerLink, (Object) confirmationDisplayModel.partnerLink) && Intrinsics.areEqual((Object) this.partnerButtonLink, (Object) confirmationDisplayModel.partnerButtonLink) && this.isSuccess == confirmationDisplayModel.isSuccess && Intrinsics.areEqual((Object) this.brandId, (Object) confirmationDisplayModel.brandId) && Intrinsics.areEqual((Object) this.description, (Object) confirmationDisplayModel.description) && Intrinsics.areEqual((Object) this.orderNowDirection, (Object) confirmationDisplayModel.orderNowDirection);
    }

    @Nullable
    public final Integer getBrandId() {
        return this.brandId;
    }

    @NotNull
    public final String getCouponCode() {
        return this.couponCode;
    }

    @NotNull
    public final String getCustomerVoucherId() {
        return this.customerVoucherId;
    }

    @Nullable
    public final String getDescription() {
        return this.description;
    }

    @NotNull
    public final OrderNowDirection getOrderNowDirection() {
        return this.orderNowDirection;
    }

    @NotNull
    public final String getPartnerButtonLink() {
        return this.partnerButtonLink;
    }

    @NotNull
    public final String getPartnerLink() {
        return this.partnerLink;
    }

    public int hashCode() {
        int hashCode = ((((((this.customerVoucherId.hashCode() * 31) + this.couponCode.hashCode()) * 31) + this.partnerLink.hashCode()) * 31) + this.partnerButtonLink.hashCode()) * 31;
        boolean z11 = this.isSuccess;
        if (z11) {
            z11 = true;
        }
        int i11 = (hashCode + (z11 ? 1 : 0)) * 31;
        Integer num = this.brandId;
        int i12 = 0;
        int hashCode2 = (i11 + (num == null ? 0 : num.hashCode())) * 31;
        String str = this.description;
        if (str != null) {
            i12 = str.hashCode();
        }
        return ((hashCode2 + i12) * 31) + this.orderNowDirection.hashCode();
    }

    public final boolean isSuccess() {
        return this.isSuccess;
    }

    public final void setOrderNowDirection(@NotNull OrderNowDirection orderNowDirection2) {
        Intrinsics.checkNotNullParameter(orderNowDirection2, "<set-?>");
        this.orderNowDirection = orderNowDirection2;
    }

    @NotNull
    public String toString() {
        String str = this.customerVoucherId;
        String str2 = this.couponCode;
        String str3 = this.partnerLink;
        String str4 = this.partnerButtonLink;
        boolean z11 = this.isSuccess;
        Integer num = this.brandId;
        String str5 = this.description;
        OrderNowDirection orderNowDirection2 = this.orderNowDirection;
        return "ConfirmationDisplayModel(customerVoucherId=" + str + ", couponCode=" + str2 + ", partnerLink=" + str3 + ", partnerButtonLink=" + str4 + ", isSuccess=" + z11 + ", brandId=" + num + ", description=" + str5 + ", orderNowDirection=" + orderNowDirection2 + ")";
    }

    public void writeToParcel(@NotNull Parcel parcel, int i11) {
        int i12;
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.customerVoucherId);
        parcel.writeString(this.couponCode);
        parcel.writeString(this.partnerLink);
        parcel.writeString(this.partnerButtonLink);
        parcel.writeInt(this.isSuccess ? 1 : 0);
        Integer num = this.brandId;
        if (num == null) {
            i12 = 0;
        } else {
            parcel.writeInt(1);
            i12 = num.intValue();
        }
        parcel.writeInt(i12);
        parcel.writeString(this.description);
        parcel.writeParcelable(this.orderNowDirection, i11);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ConfirmationDisplayModel(java.lang.String r10, java.lang.String r11, java.lang.String r12, java.lang.String r13, boolean r14, java.lang.Integer r15, java.lang.String r16, com.talabat.talabatcommon.views.vouchers.models.OrderNowDirection r17, int r18, kotlin.jvm.internal.DefaultConstructorMarker r19) {
        /*
            r9 = this;
            r0 = r18
            r1 = r0 & 1
            if (r1 == 0) goto L_0x000d
            kotlin.jvm.internal.StringCompanionObject r1 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.String r1 = com.talabat.talabatcommon.extentions.StringUtils.empty(r1)
            goto L_0x000e
        L_0x000d:
            r1 = r10
        L_0x000e:
            r2 = r0 & 2
            if (r2 == 0) goto L_0x0019
            kotlin.jvm.internal.StringCompanionObject r2 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.String r2 = com.talabat.talabatcommon.extentions.StringUtils.empty(r2)
            goto L_0x001a
        L_0x0019:
            r2 = r11
        L_0x001a:
            r3 = r0 & 4
            if (r3 == 0) goto L_0x0025
            kotlin.jvm.internal.StringCompanionObject r3 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.String r3 = com.talabat.talabatcommon.extentions.StringUtils.empty(r3)
            goto L_0x0026
        L_0x0025:
            r3 = r12
        L_0x0026:
            r4 = r0 & 8
            if (r4 == 0) goto L_0x0031
            kotlin.jvm.internal.StringCompanionObject r4 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.String r4 = com.talabat.talabatcommon.extentions.StringUtils.empty(r4)
            goto L_0x0032
        L_0x0031:
            r4 = r13
        L_0x0032:
            r5 = r0 & 16
            if (r5 == 0) goto L_0x0038
            r5 = 0
            goto L_0x0039
        L_0x0038:
            r5 = r14
        L_0x0039:
            r6 = r0 & 32
            r7 = 0
            if (r6 == 0) goto L_0x0040
            r6 = r7
            goto L_0x0041
        L_0x0040:
            r6 = r15
        L_0x0041:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0046
            goto L_0x0048
        L_0x0046:
            r7 = r16
        L_0x0048:
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x004f
            com.talabat.talabatcommon.views.vouchers.models.OrderNowDirection$Undefined r0 = com.talabat.talabatcommon.views.vouchers.models.OrderNowDirection.Undefined.INSTANCE
            goto L_0x0051
        L_0x004f:
            r0 = r17
        L_0x0051:
            r10 = r9
            r11 = r1
            r12 = r2
            r13 = r3
            r14 = r4
            r15 = r5
            r16 = r6
            r17 = r7
            r18 = r0
            r10.<init>(r11, r12, r13, r14, r15, r16, r17, r18)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.talabatcommon.views.vouchers.models.ConfirmationDisplayModel.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean, java.lang.Integer, java.lang.String, com.talabat.talabatcommon.views.vouchers.models.OrderNowDirection, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
