package com.talabat.wallet.ui.walletTransactionDetail.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.PaymentMethod;
import com.talabat.talabatnavigation.walletSquad.WalletNavigatorActions;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0019\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001BA\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005¢\u0006\u0002\u0010\fJ\t\u0010!\u001a\u00020\tHÖ\u0001J\u0019\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\tHÖ\u0001R\u001a\u0010\u000b\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\n\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001c\"\u0004\b \u0010\u001e¨\u0006'"}, d2 = {"Lcom/talabat/wallet/ui/walletTransactionDetail/model/WalletRefundBottomSheetDisplayModel;", "Landroid/os/Parcelable;", "paymentMethod", "Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/PaymentMethod;", "cardType", "", "revertAmount", "", "revertMinDays", "", "revertMaxDays", "card4Digits", "(Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/PaymentMethod;Ljava/lang/String;FIILjava/lang/String;)V", "getCard4Digits", "()Ljava/lang/String;", "setCard4Digits", "(Ljava/lang/String;)V", "getCardType", "setCardType", "getPaymentMethod", "()Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/PaymentMethod;", "setPaymentMethod", "(Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/PaymentMethod;)V", "getRevertAmount", "()F", "setRevertAmount", "(F)V", "getRevertMaxDays", "()I", "setRevertMaxDays", "(I)V", "getRevertMinDays", "setRevertMinDays", "describeContents", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Parcelize
public final class WalletRefundBottomSheetDisplayModel implements Parcelable {
    @NotNull
    public static final Parcelable.Creator<WalletRefundBottomSheetDisplayModel> CREATOR = new Creator();
    @NotNull
    private String card4Digits;
    @NotNull
    private String cardType;
    @NotNull
    private PaymentMethod paymentMethod;
    private float revertAmount;
    private int revertMaxDays;
    private int revertMinDays;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<WalletRefundBottomSheetDisplayModel> {
        @NotNull
        public final WalletRefundBottomSheetDisplayModel createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new WalletRefundBottomSheetDisplayModel(PaymentMethod.valueOf(parcel.readString()), parcel.readString(), parcel.readFloat(), parcel.readInt(), parcel.readInt(), parcel.readString());
        }

        @NotNull
        public final WalletRefundBottomSheetDisplayModel[] newArray(int i11) {
            return new WalletRefundBottomSheetDisplayModel[i11];
        }
    }

    public WalletRefundBottomSheetDisplayModel() {
        this((PaymentMethod) null, (String) null, 0.0f, 0, 0, (String) null, 63, (DefaultConstructorMarker) null);
    }

    public WalletRefundBottomSheetDisplayModel(@NotNull PaymentMethod paymentMethod2, @NotNull String str, float f11, int i11, int i12, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(paymentMethod2, "paymentMethod");
        Intrinsics.checkNotNullParameter(str, "cardType");
        Intrinsics.checkNotNullParameter(str2, WalletNavigatorActions.EXTRA_CARD_4_DIGITS);
        this.paymentMethod = paymentMethod2;
        this.cardType = str;
        this.revertAmount = f11;
        this.revertMinDays = i11;
        this.revertMaxDays = i12;
        this.card4Digits = str2;
    }

    public int describeContents() {
        return 0;
    }

    @NotNull
    public final String getCard4Digits() {
        return this.card4Digits;
    }

    @NotNull
    public final String getCardType() {
        return this.cardType;
    }

    @NotNull
    public final PaymentMethod getPaymentMethod() {
        return this.paymentMethod;
    }

    public final float getRevertAmount() {
        return this.revertAmount;
    }

    public final int getRevertMaxDays() {
        return this.revertMaxDays;
    }

    public final int getRevertMinDays() {
        return this.revertMinDays;
    }

    public final void setCard4Digits(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.card4Digits = str;
    }

    public final void setCardType(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.cardType = str;
    }

    public final void setPaymentMethod(@NotNull PaymentMethod paymentMethod2) {
        Intrinsics.checkNotNullParameter(paymentMethod2, "<set-?>");
        this.paymentMethod = paymentMethod2;
    }

    public final void setRevertAmount(float f11) {
        this.revertAmount = f11;
    }

    public final void setRevertMaxDays(int i11) {
        this.revertMaxDays = i11;
    }

    public final void setRevertMinDays(int i11) {
        this.revertMinDays = i11;
    }

    public void writeToParcel(@NotNull Parcel parcel, int i11) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.paymentMethod.name());
        parcel.writeString(this.cardType);
        parcel.writeFloat(this.revertAmount);
        parcel.writeInt(this.revertMinDays);
        parcel.writeInt(this.revertMaxDays);
        parcel.writeString(this.card4Digits);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ WalletRefundBottomSheetDisplayModel(com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.PaymentMethod r5, java.lang.String r6, float r7, int r8, int r9, java.lang.String r10, int r11, kotlin.jvm.internal.DefaultConstructorMarker r12) {
        /*
            r4 = this;
            r12 = r11 & 1
            if (r12 == 0) goto L_0x0006
            com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.PaymentMethod r5 = com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.PaymentMethod.NONE
        L_0x0006:
            r12 = r11 & 2
            if (r12 == 0) goto L_0x0010
            kotlin.jvm.internal.StringCompanionObject r6 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.String r6 = com.talabat.talabatcommon.extentions.StringUtils.empty(r6)
        L_0x0010:
            r12 = r6
            r6 = r11 & 4
            if (r6 == 0) goto L_0x0016
            r7 = 0
        L_0x0016:
            r0 = r7
            r6 = r11 & 8
            r7 = 0
            if (r6 == 0) goto L_0x001e
            r1 = r7
            goto L_0x001f
        L_0x001e:
            r1 = r8
        L_0x001f:
            r6 = r11 & 16
            if (r6 == 0) goto L_0x0025
            r2 = r7
            goto L_0x0026
        L_0x0025:
            r2 = r9
        L_0x0026:
            r6 = r11 & 32
            if (r6 == 0) goto L_0x0030
            kotlin.jvm.internal.StringCompanionObject r6 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.String r10 = com.talabat.talabatcommon.extentions.StringUtils.empty(r6)
        L_0x0030:
            r3 = r10
            r6 = r4
            r7 = r5
            r8 = r12
            r9 = r0
            r10 = r1
            r11 = r2
            r12 = r3
            r6.<init>(r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.wallet.ui.walletTransactionDetail.model.WalletRefundBottomSheetDisplayModel.<init>(com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.PaymentMethod, java.lang.String, float, int, int, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
