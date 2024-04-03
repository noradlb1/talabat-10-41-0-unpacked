package com.talabat.wallet.features.qrCodeScanner.model.request;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b/\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001Bs\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u0010J\u0010\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0012J\u000b\u0010*\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010,\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001bJ\u000b\u0010-\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u00100\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0010\u00101\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0010\u00102\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0010\u00103\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0001\u00104\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u00105J\u0013\u00106\u001a\u0002072\b\u00108\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00109\u001a\u00020\u0005HÖ\u0001J\t\u0010:\u001a\u00020\u0007HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R \u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00078\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R\"\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00078\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0015R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b \u0010\u001bR\"\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b!\u0010\u001b\"\u0004\b\"\u0010\u001dR \u0010\u000f\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0015\"\u0004\b$\u0010\u0017R\"\u0010\r\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b%\u0010\u001b\"\u0004\b&\u0010\u001dR\"\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b'\u0010\u001b\"\u0004\b(\u0010\u001d¨\u0006;"}, d2 = {"Lcom/talabat/wallet/features/qrCodeScanner/model/request/WalletPaymentRequestModel;", "", "amount", "", "countryId", "", "cardTokenId", "", "card4Digits", "cardType", "vendorId", "orderId", "paymentMethod", "requestSource", "merchantTransactionId", "qrVerificationString", "(Ljava/lang/Float;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "getAmount", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getCard4Digits", "()Ljava/lang/String;", "setCard4Digits", "(Ljava/lang/String;)V", "getCardTokenId", "getCardType", "getCountryId", "()Ljava/lang/Integer;", "setCountryId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getMerchantTransactionId", "getOrderId", "getPaymentMethod", "setPaymentMethod", "getQrVerificationString", "setQrVerificationString", "getRequestSource", "setRequestSource", "getVendorId", "setVendorId", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Float;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Lcom/talabat/wallet/features/qrCodeScanner/model/request/WalletPaymentRequestModel;", "equals", "", "other", "hashCode", "toString", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletPaymentRequestModel {
    @SerializedName("amount")
    @Nullable
    private final Float amount;
    @SerializedName("card4Digits")
    @Nullable
    private String card4Digits;
    @SerializedName("cardTokenId")
    @Nullable
    private final String cardTokenId;
    @SerializedName("cardType")
    @Nullable
    private final String cardType;
    @SerializedName("countryId")
    @Nullable
    private Integer countryId;
    @SerializedName("mrTrId")
    @Nullable
    private final String merchantTransactionId;
    @SerializedName("orderId")
    @Nullable
    private final Integer orderId;
    @SerializedName("paymentMethod")
    @Nullable
    private Integer paymentMethod;
    @SerializedName("qrVr")
    @Nullable
    private String qrVerificationString;
    @SerializedName("requestSource")
    @Nullable
    private Integer requestSource;
    @SerializedName("vendorId")
    @Nullable
    private Integer vendorId;

    public WalletPaymentRequestModel(@Nullable Float f11, @Nullable Integer num, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable Integer num2, @Nullable Integer num3, @Nullable Integer num4, @Nullable Integer num5, @Nullable String str4, @Nullable String str5) {
        this.amount = f11;
        this.countryId = num;
        this.cardTokenId = str;
        this.card4Digits = str2;
        this.cardType = str3;
        this.vendorId = num2;
        this.orderId = num3;
        this.paymentMethod = num4;
        this.requestSource = num5;
        this.merchantTransactionId = str4;
        this.qrVerificationString = str5;
    }

    public static /* synthetic */ WalletPaymentRequestModel copy$default(WalletPaymentRequestModel walletPaymentRequestModel, Float f11, Integer num, String str, String str2, String str3, Integer num2, Integer num3, Integer num4, Integer num5, String str4, String str5, int i11, Object obj) {
        WalletPaymentRequestModel walletPaymentRequestModel2 = walletPaymentRequestModel;
        int i12 = i11;
        return walletPaymentRequestModel.copy((i12 & 1) != 0 ? walletPaymentRequestModel2.amount : f11, (i12 & 2) != 0 ? walletPaymentRequestModel2.countryId : num, (i12 & 4) != 0 ? walletPaymentRequestModel2.cardTokenId : str, (i12 & 8) != 0 ? walletPaymentRequestModel2.card4Digits : str2, (i12 & 16) != 0 ? walletPaymentRequestModel2.cardType : str3, (i12 & 32) != 0 ? walletPaymentRequestModel2.vendorId : num2, (i12 & 64) != 0 ? walletPaymentRequestModel2.orderId : num3, (i12 & 128) != 0 ? walletPaymentRequestModel2.paymentMethod : num4, (i12 & 256) != 0 ? walletPaymentRequestModel2.requestSource : num5, (i12 & 512) != 0 ? walletPaymentRequestModel2.merchantTransactionId : str4, (i12 & 1024) != 0 ? walletPaymentRequestModel2.qrVerificationString : str5);
    }

    @Nullable
    public final Float component1() {
        return this.amount;
    }

    @Nullable
    public final String component10() {
        return this.merchantTransactionId;
    }

    @Nullable
    public final String component11() {
        return this.qrVerificationString;
    }

    @Nullable
    public final Integer component2() {
        return this.countryId;
    }

    @Nullable
    public final String component3() {
        return this.cardTokenId;
    }

    @Nullable
    public final String component4() {
        return this.card4Digits;
    }

    @Nullable
    public final String component5() {
        return this.cardType;
    }

    @Nullable
    public final Integer component6() {
        return this.vendorId;
    }

    @Nullable
    public final Integer component7() {
        return this.orderId;
    }

    @Nullable
    public final Integer component8() {
        return this.paymentMethod;
    }

    @Nullable
    public final Integer component9() {
        return this.requestSource;
    }

    @NotNull
    public final WalletPaymentRequestModel copy(@Nullable Float f11, @Nullable Integer num, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable Integer num2, @Nullable Integer num3, @Nullable Integer num4, @Nullable Integer num5, @Nullable String str4, @Nullable String str5) {
        return new WalletPaymentRequestModel(f11, num, str, str2, str3, num2, num3, num4, num5, str4, str5);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WalletPaymentRequestModel)) {
            return false;
        }
        WalletPaymentRequestModel walletPaymentRequestModel = (WalletPaymentRequestModel) obj;
        return Intrinsics.areEqual((Object) this.amount, (Object) walletPaymentRequestModel.amount) && Intrinsics.areEqual((Object) this.countryId, (Object) walletPaymentRequestModel.countryId) && Intrinsics.areEqual((Object) this.cardTokenId, (Object) walletPaymentRequestModel.cardTokenId) && Intrinsics.areEqual((Object) this.card4Digits, (Object) walletPaymentRequestModel.card4Digits) && Intrinsics.areEqual((Object) this.cardType, (Object) walletPaymentRequestModel.cardType) && Intrinsics.areEqual((Object) this.vendorId, (Object) walletPaymentRequestModel.vendorId) && Intrinsics.areEqual((Object) this.orderId, (Object) walletPaymentRequestModel.orderId) && Intrinsics.areEqual((Object) this.paymentMethod, (Object) walletPaymentRequestModel.paymentMethod) && Intrinsics.areEqual((Object) this.requestSource, (Object) walletPaymentRequestModel.requestSource) && Intrinsics.areEqual((Object) this.merchantTransactionId, (Object) walletPaymentRequestModel.merchantTransactionId) && Intrinsics.areEqual((Object) this.qrVerificationString, (Object) walletPaymentRequestModel.qrVerificationString);
    }

    @Nullable
    public final Float getAmount() {
        return this.amount;
    }

    @Nullable
    public final String getCard4Digits() {
        return this.card4Digits;
    }

    @Nullable
    public final String getCardTokenId() {
        return this.cardTokenId;
    }

    @Nullable
    public final String getCardType() {
        return this.cardType;
    }

    @Nullable
    public final Integer getCountryId() {
        return this.countryId;
    }

    @Nullable
    public final String getMerchantTransactionId() {
        return this.merchantTransactionId;
    }

    @Nullable
    public final Integer getOrderId() {
        return this.orderId;
    }

    @Nullable
    public final Integer getPaymentMethod() {
        return this.paymentMethod;
    }

    @Nullable
    public final String getQrVerificationString() {
        return this.qrVerificationString;
    }

    @Nullable
    public final Integer getRequestSource() {
        return this.requestSource;
    }

    @Nullable
    public final Integer getVendorId() {
        return this.vendorId;
    }

    public int hashCode() {
        Float f11 = this.amount;
        int i11 = 0;
        int hashCode = (f11 == null ? 0 : f11.hashCode()) * 31;
        Integer num = this.countryId;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        String str = this.cardTokenId;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.card4Digits;
        int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.cardType;
        int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Integer num2 = this.vendorId;
        int hashCode6 = (hashCode5 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.orderId;
        int hashCode7 = (hashCode6 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.paymentMethod;
        int hashCode8 = (hashCode7 + (num4 == null ? 0 : num4.hashCode())) * 31;
        Integer num5 = this.requestSource;
        int hashCode9 = (hashCode8 + (num5 == null ? 0 : num5.hashCode())) * 31;
        String str4 = this.merchantTransactionId;
        int hashCode10 = (hashCode9 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.qrVerificationString;
        if (str5 != null) {
            i11 = str5.hashCode();
        }
        return hashCode10 + i11;
    }

    public final void setCard4Digits(@Nullable String str) {
        this.card4Digits = str;
    }

    public final void setCountryId(@Nullable Integer num) {
        this.countryId = num;
    }

    public final void setPaymentMethod(@Nullable Integer num) {
        this.paymentMethod = num;
    }

    public final void setQrVerificationString(@Nullable String str) {
        this.qrVerificationString = str;
    }

    public final void setRequestSource(@Nullable Integer num) {
        this.requestSource = num;
    }

    public final void setVendorId(@Nullable Integer num) {
        this.vendorId = num;
    }

    @NotNull
    public String toString() {
        Float f11 = this.amount;
        Integer num = this.countryId;
        String str = this.cardTokenId;
        String str2 = this.card4Digits;
        String str3 = this.cardType;
        Integer num2 = this.vendorId;
        Integer num3 = this.orderId;
        Integer num4 = this.paymentMethod;
        Integer num5 = this.requestSource;
        String str4 = this.merchantTransactionId;
        String str5 = this.qrVerificationString;
        return "WalletPaymentRequestModel(amount=" + f11 + ", countryId=" + num + ", cardTokenId=" + str + ", card4Digits=" + str2 + ", cardType=" + str3 + ", vendorId=" + num2 + ", orderId=" + num3 + ", paymentMethod=" + num4 + ", requestSource=" + num5 + ", merchantTransactionId=" + str4 + ", qrVerificationString=" + str5 + ")";
    }
}
