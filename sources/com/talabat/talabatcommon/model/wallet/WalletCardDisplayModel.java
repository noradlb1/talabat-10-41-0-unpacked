package com.talabat.talabatcommon.model.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.talabat.authentication.token.data.local.impl.LegacyTokenLocalDataSourceImpl;
import com.talabat.card_tokenization.CardTokenizationPlugin;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.PaymentMethod;
import com.talabat.talabatnavigation.walletSquad.WalletNavigatorActions;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.apache.commons.compress.archivers.zip.UnixStat;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B}\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\t¢\u0006\u0002\u0010\u0011J\t\u0010.\u001a\u00020/HÖ\u0001J\u0019\u00100\u001a\u0002012\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u00020/HÖ\u0001R\u001a\u0010\u0007\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\r\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0013\"\u0004\b\u0017\u0010\u0015R\u001a\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0013\"\u0004\b\u0019\u0010\u0015R\u001a\u0010\u0006\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015R\u001a\u0010\f\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0013\"\u0004\b\u001d\u0010\u0015R\u001a\u0010\n\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0013\"\u0004\b\u001f\u0010\u0015R\u001a\u0010\u000b\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0013\"\u0004\b!\u0010\u0015R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\"\"\u0004\b#\u0010$R\u001a\u0010\u0010\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\"\"\u0004\b%\u0010$R\u001a\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0013\"\u0004\b+\u0010\u0015R\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0013\"\u0004\b-\u0010\u0015¨\u00065"}, d2 = {"Lcom/talabat/talabatcommon/model/wallet/WalletCardDisplayModel;", "Landroid/os/Parcelable;", "token", "", "tokenId", "cardNumber", "cardType", "binNumber", "isDefaultCard", "", "expiryMonth", "expiryYear", "expiryDate", "card4Digits", "paymentMethod", "Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/PaymentMethod;", "isSupported", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/PaymentMethod;Z)V", "getBinNumber", "()Ljava/lang/String;", "setBinNumber", "(Ljava/lang/String;)V", "getCard4Digits", "setCard4Digits", "getCardNumber", "setCardNumber", "getCardType", "setCardType", "getExpiryDate", "setExpiryDate", "getExpiryMonth", "setExpiryMonth", "getExpiryYear", "setExpiryYear", "()Z", "setDefaultCard", "(Z)V", "setSupported", "getPaymentMethod", "()Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/PaymentMethod;", "setPaymentMethod", "(Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/PaymentMethod;)V", "getToken", "setToken", "getTokenId", "setTokenId", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Parcelize
public final class WalletCardDisplayModel implements Parcelable {
    @NotNull
    public static final Parcelable.Creator<WalletCardDisplayModel> CREATOR = new Creator();
    @NotNull
    private String binNumber;
    @NotNull
    private String card4Digits;
    @NotNull
    private String cardNumber;
    @NotNull
    private String cardType;
    @NotNull
    private String expiryDate;
    @NotNull
    private String expiryMonth;
    @NotNull
    private String expiryYear;
    private boolean isDefaultCard;
    private boolean isSupported;
    @NotNull
    private PaymentMethod paymentMethod;
    @NotNull
    private String token;
    @NotNull
    private String tokenId;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<WalletCardDisplayModel> {
        @NotNull
        public final WalletCardDisplayModel createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new WalletCardDisplayModel(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), PaymentMethod.valueOf(parcel.readString()), parcel.readInt() != 0);
        }

        @NotNull
        public final WalletCardDisplayModel[] newArray(int i11) {
            return new WalletCardDisplayModel[i11];
        }
    }

    public WalletCardDisplayModel() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, false, (String) null, (String) null, (String) null, (String) null, (PaymentMethod) null, false, UnixStat.PERM_MASK, (DefaultConstructorMarker) null);
    }

    public WalletCardDisplayModel(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, boolean z11, @NotNull String str6, @NotNull String str7, @NotNull String str8, @NotNull String str9, @NotNull PaymentMethod paymentMethod2, boolean z12) {
        Intrinsics.checkNotNullParameter(str, LegacyTokenLocalDataSourceImpl.KEY);
        Intrinsics.checkNotNullParameter(str2, WalletNavigatorActions.EXTRA_TOKEN_ID);
        Intrinsics.checkNotNullParameter(str3, "cardNumber");
        Intrinsics.checkNotNullParameter(str4, "cardType");
        Intrinsics.checkNotNullParameter(str5, "binNumber");
        Intrinsics.checkNotNullParameter(str6, CardTokenizationPlugin.ARG_EXPIRY_MONTH_KEY);
        Intrinsics.checkNotNullParameter(str7, CardTokenizationPlugin.ARG_EXPIRY_YEAR_KEY);
        Intrinsics.checkNotNullParameter(str8, "expiryDate");
        Intrinsics.checkNotNullParameter(str9, WalletNavigatorActions.EXTRA_CARD_4_DIGITS);
        Intrinsics.checkNotNullParameter(paymentMethod2, "paymentMethod");
        this.token = str;
        this.tokenId = str2;
        this.cardNumber = str3;
        this.cardType = str4;
        this.binNumber = str5;
        this.isDefaultCard = z11;
        this.expiryMonth = str6;
        this.expiryYear = str7;
        this.expiryDate = str8;
        this.card4Digits = str9;
        this.paymentMethod = paymentMethod2;
        this.isSupported = z12;
    }

    public int describeContents() {
        return 0;
    }

    @NotNull
    public final String getBinNumber() {
        return this.binNumber;
    }

    @NotNull
    public final String getCard4Digits() {
        return this.card4Digits;
    }

    @NotNull
    public final String getCardNumber() {
        return this.cardNumber;
    }

    @NotNull
    public final String getCardType() {
        return this.cardType;
    }

    @NotNull
    public final String getExpiryDate() {
        return this.expiryDate;
    }

    @NotNull
    public final String getExpiryMonth() {
        return this.expiryMonth;
    }

    @NotNull
    public final String getExpiryYear() {
        return this.expiryYear;
    }

    @NotNull
    public final PaymentMethod getPaymentMethod() {
        return this.paymentMethod;
    }

    @NotNull
    public final String getToken() {
        return this.token;
    }

    @NotNull
    public final String getTokenId() {
        return this.tokenId;
    }

    public final boolean isDefaultCard() {
        return this.isDefaultCard;
    }

    public final boolean isSupported() {
        return this.isSupported;
    }

    public final void setBinNumber(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.binNumber = str;
    }

    public final void setCard4Digits(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.card4Digits = str;
    }

    public final void setCardNumber(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.cardNumber = str;
    }

    public final void setCardType(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.cardType = str;
    }

    public final void setDefaultCard(boolean z11) {
        this.isDefaultCard = z11;
    }

    public final void setExpiryDate(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.expiryDate = str;
    }

    public final void setExpiryMonth(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.expiryMonth = str;
    }

    public final void setExpiryYear(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.expiryYear = str;
    }

    public final void setPaymentMethod(@NotNull PaymentMethod paymentMethod2) {
        Intrinsics.checkNotNullParameter(paymentMethod2, "<set-?>");
        this.paymentMethod = paymentMethod2;
    }

    public final void setSupported(boolean z11) {
        this.isSupported = z11;
    }

    public final void setToken(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.token = str;
    }

    public final void setTokenId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.tokenId = str;
    }

    public void writeToParcel(@NotNull Parcel parcel, int i11) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.token);
        parcel.writeString(this.tokenId);
        parcel.writeString(this.cardNumber);
        parcel.writeString(this.cardType);
        parcel.writeString(this.binNumber);
        parcel.writeInt(this.isDefaultCard ? 1 : 0);
        parcel.writeString(this.expiryMonth);
        parcel.writeString(this.expiryYear);
        parcel.writeString(this.expiryDate);
        parcel.writeString(this.card4Digits);
        parcel.writeString(this.paymentMethod.name());
        parcel.writeInt(this.isSupported ? 1 : 0);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ WalletCardDisplayModel(java.lang.String r13, java.lang.String r14, java.lang.String r15, java.lang.String r16, java.lang.String r17, boolean r18, java.lang.String r19, java.lang.String r20, java.lang.String r21, java.lang.String r22, com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.PaymentMethod r23, boolean r24, int r25, kotlin.jvm.internal.DefaultConstructorMarker r26) {
        /*
            r12 = this;
            r0 = r25
            r1 = r0 & 1
            if (r1 == 0) goto L_0x000d
            kotlin.jvm.internal.StringCompanionObject r1 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.String r1 = com.talabat.talabatcommon.extentions.StringUtils.empty(r1)
            goto L_0x000e
        L_0x000d:
            r1 = r13
        L_0x000e:
            r2 = r0 & 2
            if (r2 == 0) goto L_0x0019
            kotlin.jvm.internal.StringCompanionObject r2 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.String r2 = com.talabat.talabatcommon.extentions.StringUtils.empty(r2)
            goto L_0x001a
        L_0x0019:
            r2 = r14
        L_0x001a:
            r3 = r0 & 4
            if (r3 == 0) goto L_0x0025
            kotlin.jvm.internal.StringCompanionObject r3 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.String r3 = com.talabat.talabatcommon.extentions.StringUtils.empty(r3)
            goto L_0x0026
        L_0x0025:
            r3 = r15
        L_0x0026:
            r4 = r0 & 8
            if (r4 == 0) goto L_0x0031
            kotlin.jvm.internal.StringCompanionObject r4 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.String r4 = com.talabat.talabatcommon.extentions.StringUtils.empty(r4)
            goto L_0x0033
        L_0x0031:
            r4 = r16
        L_0x0033:
            r5 = r0 & 16
            if (r5 == 0) goto L_0x003e
            kotlin.jvm.internal.StringCompanionObject r5 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.String r5 = com.talabat.talabatcommon.extentions.StringUtils.empty(r5)
            goto L_0x0040
        L_0x003e:
            r5 = r17
        L_0x0040:
            r6 = r0 & 32
            if (r6 == 0) goto L_0x0046
            r6 = 0
            goto L_0x0048
        L_0x0046:
            r6 = r18
        L_0x0048:
            r7 = r0 & 64
            if (r7 == 0) goto L_0x0053
            kotlin.jvm.internal.StringCompanionObject r7 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.String r7 = com.talabat.talabatcommon.extentions.StringUtils.empty(r7)
            goto L_0x0055
        L_0x0053:
            r7 = r19
        L_0x0055:
            r8 = r0 & 128(0x80, float:1.794E-43)
            if (r8 == 0) goto L_0x0060
            kotlin.jvm.internal.StringCompanionObject r8 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.String r8 = com.talabat.talabatcommon.extentions.StringUtils.empty(r8)
            goto L_0x0062
        L_0x0060:
            r8 = r20
        L_0x0062:
            r9 = r0 & 256(0x100, float:3.59E-43)
            if (r9 == 0) goto L_0x006d
            kotlin.jvm.internal.StringCompanionObject r9 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.String r9 = com.talabat.talabatcommon.extentions.StringUtils.empty(r9)
            goto L_0x006f
        L_0x006d:
            r9 = r21
        L_0x006f:
            r10 = r0 & 512(0x200, float:7.175E-43)
            if (r10 == 0) goto L_0x007a
            kotlin.jvm.internal.StringCompanionObject r10 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.String r10 = com.talabat.talabatcommon.extentions.StringUtils.empty(r10)
            goto L_0x007c
        L_0x007a:
            r10 = r22
        L_0x007c:
            r11 = r0 & 1024(0x400, float:1.435E-42)
            if (r11 == 0) goto L_0x0083
            com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.PaymentMethod r11 = com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.PaymentMethod.NONE
            goto L_0x0085
        L_0x0083:
            r11 = r23
        L_0x0085:
            r0 = r0 & 2048(0x800, float:2.87E-42)
            if (r0 == 0) goto L_0x008b
            r0 = 1
            goto L_0x008d
        L_0x008b:
            r0 = r24
        L_0x008d:
            r13 = r12
            r14 = r1
            r15 = r2
            r16 = r3
            r17 = r4
            r18 = r5
            r19 = r6
            r20 = r7
            r21 = r8
            r22 = r9
            r23 = r10
            r24 = r11
            r25 = r0
            r13.<init>(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.talabatcommon.model.wallet.WalletCardDisplayModel.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean, java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.PaymentMethod, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
