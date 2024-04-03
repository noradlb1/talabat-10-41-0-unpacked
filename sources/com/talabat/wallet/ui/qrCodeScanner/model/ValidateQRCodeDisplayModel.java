package com.talabat.wallet.ui.qrCodeScanner.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.talabat.talabatnavigation.tLife.TLifeNavigationActions;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b&\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001Bs\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\f\u001a\u00020\n\u0012\b\b\u0002\u0010\r\u001a\u00020\n\u0012\b\b\u0002\u0010\u000e\u001a\u00020\n\u0012\b\b\u0002\u0010\u000f\u001a\u00020\n\u0012\b\b\u0002\u0010\u0010\u001a\u00020\n¢\u0006\u0002\u0010\u0011J\t\u0010/\u001a\u00020\bHÖ\u0001J\u0019\u00100\u001a\u0002012\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\bHÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u0006\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\r\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010\u000b\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010 \"\u0004\b$\u0010\"R\u001a\u0010\f\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010 \"\u0004\b&\u0010\"R\u001a\u0010\u000f\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010 \"\u0004\b(\u0010\"R\u001a\u0010\u000e\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010 \"\u0004\b*\u0010\"R\u001a\u0010\u0010\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010 \"\u0004\b,\u0010\"R\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010 \"\u0004\b.\u0010\"¨\u00065"}, d2 = {"Lcom/talabat/wallet/ui/qrCodeScanner/model/ValidateQRCodeDisplayModel;", "Landroid/os/Parcelable;", "isQRCodeValid", "", "amount", "", "discount", "brandId", "", "vendorId", "", "merchantName", "merchantTransactionId", "merchantImageUrl", "requestSource", "qrErrorMessage", "serverErrorMessage", "(ZFFILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAmount", "()F", "setAmount", "(F)V", "getBrandId", "()I", "setBrandId", "(I)V", "getDiscount", "setDiscount", "()Z", "setQRCodeValid", "(Z)V", "getMerchantImageUrl", "()Ljava/lang/String;", "setMerchantImageUrl", "(Ljava/lang/String;)V", "getMerchantName", "setMerchantName", "getMerchantTransactionId", "setMerchantTransactionId", "getQrErrorMessage", "setQrErrorMessage", "getRequestSource", "setRequestSource", "getServerErrorMessage", "setServerErrorMessage", "getVendorId", "setVendorId", "describeContents", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Parcelize
public final class ValidateQRCodeDisplayModel implements Parcelable {
    @NotNull
    public static final Parcelable.Creator<ValidateQRCodeDisplayModel> CREATOR = new Creator();
    private float amount;
    private int brandId;
    private float discount;
    private boolean isQRCodeValid;
    @NotNull
    private String merchantImageUrl;
    @NotNull
    private String merchantName;
    @NotNull
    private String merchantTransactionId;
    @NotNull
    private String qrErrorMessage;
    @NotNull
    private String requestSource;
    @NotNull
    private String serverErrorMessage;
    @NotNull
    private String vendorId;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ValidateQRCodeDisplayModel> {
        @NotNull
        public final ValidateQRCodeDisplayModel createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ValidateQRCodeDisplayModel(parcel.readInt() != 0, parcel.readFloat(), parcel.readFloat(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        @NotNull
        public final ValidateQRCodeDisplayModel[] newArray(int i11) {
            return new ValidateQRCodeDisplayModel[i11];
        }
    }

    public ValidateQRCodeDisplayModel() {
        this(false, 0.0f, 0.0f, 0, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 2047, (DefaultConstructorMarker) null);
    }

    public ValidateQRCodeDisplayModel(boolean z11, float f11, float f12, int i11, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull String str7) {
        Intrinsics.checkNotNullParameter(str, "vendorId");
        Intrinsics.checkNotNullParameter(str2, TLifeNavigationActions.EXTRA_REDEEM_AND_PAY_MERCHANT_NAME);
        Intrinsics.checkNotNullParameter(str3, "merchantTransactionId");
        Intrinsics.checkNotNullParameter(str4, "merchantImageUrl");
        Intrinsics.checkNotNullParameter(str5, "requestSource");
        Intrinsics.checkNotNullParameter(str6, "qrErrorMessage");
        Intrinsics.checkNotNullParameter(str7, "serverErrorMessage");
        this.isQRCodeValid = z11;
        this.amount = f11;
        this.discount = f12;
        this.brandId = i11;
        this.vendorId = str;
        this.merchantName = str2;
        this.merchantTransactionId = str3;
        this.merchantImageUrl = str4;
        this.requestSource = str5;
        this.qrErrorMessage = str6;
        this.serverErrorMessage = str7;
    }

    public int describeContents() {
        return 0;
    }

    public final float getAmount() {
        return this.amount;
    }

    public final int getBrandId() {
        return this.brandId;
    }

    public final float getDiscount() {
        return this.discount;
    }

    @NotNull
    public final String getMerchantImageUrl() {
        return this.merchantImageUrl;
    }

    @NotNull
    public final String getMerchantName() {
        return this.merchantName;
    }

    @NotNull
    public final String getMerchantTransactionId() {
        return this.merchantTransactionId;
    }

    @NotNull
    public final String getQrErrorMessage() {
        return this.qrErrorMessage;
    }

    @NotNull
    public final String getRequestSource() {
        return this.requestSource;
    }

    @NotNull
    public final String getServerErrorMessage() {
        return this.serverErrorMessage;
    }

    @NotNull
    public final String getVendorId() {
        return this.vendorId;
    }

    public final boolean isQRCodeValid() {
        return this.isQRCodeValid;
    }

    public final void setAmount(float f11) {
        this.amount = f11;
    }

    public final void setBrandId(int i11) {
        this.brandId = i11;
    }

    public final void setDiscount(float f11) {
        this.discount = f11;
    }

    public final void setMerchantImageUrl(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.merchantImageUrl = str;
    }

    public final void setMerchantName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.merchantName = str;
    }

    public final void setMerchantTransactionId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.merchantTransactionId = str;
    }

    public final void setQRCodeValid(boolean z11) {
        this.isQRCodeValid = z11;
    }

    public final void setQrErrorMessage(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.qrErrorMessage = str;
    }

    public final void setRequestSource(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.requestSource = str;
    }

    public final void setServerErrorMessage(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.serverErrorMessage = str;
    }

    public final void setVendorId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.vendorId = str;
    }

    public void writeToParcel(@NotNull Parcel parcel, int i11) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(this.isQRCodeValid ? 1 : 0);
        parcel.writeFloat(this.amount);
        parcel.writeFloat(this.discount);
        parcel.writeInt(this.brandId);
        parcel.writeString(this.vendorId);
        parcel.writeString(this.merchantName);
        parcel.writeString(this.merchantTransactionId);
        parcel.writeString(this.merchantImageUrl);
        parcel.writeString(this.requestSource);
        parcel.writeString(this.qrErrorMessage);
        parcel.writeString(this.serverErrorMessage);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ValidateQRCodeDisplayModel(boolean r13, float r14, float r15, int r16, java.lang.String r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, java.lang.String r21, java.lang.String r22, java.lang.String r23, int r24, kotlin.jvm.internal.DefaultConstructorMarker r25) {
        /*
            r12 = this;
            r0 = r24
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = r2
            goto L_0x000a
        L_0x0009:
            r1 = r13
        L_0x000a:
            r3 = r0 & 2
            r4 = 0
            if (r3 == 0) goto L_0x0011
            r3 = r4
            goto L_0x0012
        L_0x0011:
            r3 = r14
        L_0x0012:
            r5 = r0 & 4
            if (r5 == 0) goto L_0x0017
            goto L_0x0018
        L_0x0017:
            r4 = r15
        L_0x0018:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x001d
            goto L_0x001f
        L_0x001d:
            r2 = r16
        L_0x001f:
            r5 = r0 & 16
            if (r5 == 0) goto L_0x002a
            kotlin.jvm.internal.StringCompanionObject r5 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.String r5 = com.talabat.talabatcommon.extentions.StringUtils.empty(r5)
            goto L_0x002c
        L_0x002a:
            r5 = r17
        L_0x002c:
            r6 = r0 & 32
            java.lang.String r7 = ""
            if (r6 == 0) goto L_0x0034
            r6 = r7
            goto L_0x0036
        L_0x0034:
            r6 = r18
        L_0x0036:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x003c
            r8 = r7
            goto L_0x003e
        L_0x003c:
            r8 = r19
        L_0x003e:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x0044
            r9 = r7
            goto L_0x0046
        L_0x0044:
            r9 = r20
        L_0x0046:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x004c
            r10 = r7
            goto L_0x004e
        L_0x004c:
            r10 = r21
        L_0x004e:
            r11 = r0 & 512(0x200, float:7.175E-43)
            if (r11 == 0) goto L_0x0054
            r11 = r7
            goto L_0x0056
        L_0x0054:
            r11 = r22
        L_0x0056:
            r0 = r0 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x005b
            goto L_0x005d
        L_0x005b:
            r7 = r23
        L_0x005d:
            r13 = r12
            r14 = r1
            r15 = r3
            r16 = r4
            r17 = r2
            r18 = r5
            r19 = r6
            r20 = r8
            r21 = r9
            r22 = r10
            r23 = r11
            r24 = r7
            r13.<init>(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.wallet.ui.qrCodeScanner.model.ValidateQRCodeDisplayModel.<init>(boolean, float, float, int, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
