package com.talabat.wallet.features.qrCodeScanner.model.response;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\"\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001Bi\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\f\u001a\u0004\u0018\u00010\t\u0012\b\u0010\r\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u000b\u0010 \u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010$\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u000b\u0010&\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010'\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010(\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0014J\u0001\u0010)\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010*J\u0013\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010.\u001a\u00020\tHÖ\u0001J\t\u0010/\u001a\u00020\u0006HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\f\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\r\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0016\u0010\u0014R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0017\u0010\u0011R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0019R\u001a\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u001c\u0010\u0011R\u001a\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u001d\u0010\u0014R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0019¨\u00060"}, d2 = {"Lcom/talabat/wallet/features/qrCodeScanner/model/response/QRCodeModel;", "", "amount", "", "discount", "qrCodeExpiryTime", "", "merchantTransactionId", "requestSource", "", "qrVersionNumber", "vendorId", "brandId", "countryId", "merchantName", "(Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)V", "getAmount", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getBrandId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCountryId", "getDiscount", "getMerchantName", "()Ljava/lang/String;", "getMerchantTransactionId", "getQrCodeExpiryTime", "getQrVersionNumber", "getRequestSource", "getVendorId", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)Lcom/talabat/wallet/features/qrCodeScanner/model/response/QRCodeModel;", "equals", "", "other", "hashCode", "toString", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class QRCodeModel {
    @SerializedName("amount")
    @Nullable
    private final Float amount;
    @SerializedName("brandId")
    @Nullable
    private final Integer brandId;
    @SerializedName("countryId")
    @Nullable
    private final Integer countryId;
    @SerializedName("discount")
    @Nullable
    private final Float discount;
    @SerializedName("merchantName")
    @Nullable
    private final String merchantName;
    @SerializedName(alternate = {"merchantTransId"}, value = "mrTrId")
    @Nullable
    private final String merchantTransactionId;
    @SerializedName("qrExp")
    @Nullable
    private final String qrCodeExpiryTime;
    @SerializedName("qrVr")
    @Nullable
    private final Float qrVersionNumber;
    @SerializedName("requestSource")
    @Nullable
    private final Integer requestSource;
    @SerializedName("vendorId")
    @Nullable
    private final String vendorId;

    public QRCodeModel(@Nullable Float f11, @Nullable Float f12, @Nullable String str, @Nullable String str2, @Nullable Integer num, @Nullable Float f13, @Nullable String str3, @Nullable Integer num2, @Nullable Integer num3, @Nullable String str4) {
        this.amount = f11;
        this.discount = f12;
        this.qrCodeExpiryTime = str;
        this.merchantTransactionId = str2;
        this.requestSource = num;
        this.qrVersionNumber = f13;
        this.vendorId = str3;
        this.brandId = num2;
        this.countryId = num3;
        this.merchantName = str4;
    }

    public static /* synthetic */ QRCodeModel copy$default(QRCodeModel qRCodeModel, Float f11, Float f12, String str, String str2, Integer num, Float f13, String str3, Integer num2, Integer num3, String str4, int i11, Object obj) {
        QRCodeModel qRCodeModel2 = qRCodeModel;
        int i12 = i11;
        return qRCodeModel.copy((i12 & 1) != 0 ? qRCodeModel2.amount : f11, (i12 & 2) != 0 ? qRCodeModel2.discount : f12, (i12 & 4) != 0 ? qRCodeModel2.qrCodeExpiryTime : str, (i12 & 8) != 0 ? qRCodeModel2.merchantTransactionId : str2, (i12 & 16) != 0 ? qRCodeModel2.requestSource : num, (i12 & 32) != 0 ? qRCodeModel2.qrVersionNumber : f13, (i12 & 64) != 0 ? qRCodeModel2.vendorId : str3, (i12 & 128) != 0 ? qRCodeModel2.brandId : num2, (i12 & 256) != 0 ? qRCodeModel2.countryId : num3, (i12 & 512) != 0 ? qRCodeModel2.merchantName : str4);
    }

    @Nullable
    public final Float component1() {
        return this.amount;
    }

    @Nullable
    public final String component10() {
        return this.merchantName;
    }

    @Nullable
    public final Float component2() {
        return this.discount;
    }

    @Nullable
    public final String component3() {
        return this.qrCodeExpiryTime;
    }

    @Nullable
    public final String component4() {
        return this.merchantTransactionId;
    }

    @Nullable
    public final Integer component5() {
        return this.requestSource;
    }

    @Nullable
    public final Float component6() {
        return this.qrVersionNumber;
    }

    @Nullable
    public final String component7() {
        return this.vendorId;
    }

    @Nullable
    public final Integer component8() {
        return this.brandId;
    }

    @Nullable
    public final Integer component9() {
        return this.countryId;
    }

    @NotNull
    public final QRCodeModel copy(@Nullable Float f11, @Nullable Float f12, @Nullable String str, @Nullable String str2, @Nullable Integer num, @Nullable Float f13, @Nullable String str3, @Nullable Integer num2, @Nullable Integer num3, @Nullable String str4) {
        return new QRCodeModel(f11, f12, str, str2, num, f13, str3, num2, num3, str4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof QRCodeModel)) {
            return false;
        }
        QRCodeModel qRCodeModel = (QRCodeModel) obj;
        return Intrinsics.areEqual((Object) this.amount, (Object) qRCodeModel.amount) && Intrinsics.areEqual((Object) this.discount, (Object) qRCodeModel.discount) && Intrinsics.areEqual((Object) this.qrCodeExpiryTime, (Object) qRCodeModel.qrCodeExpiryTime) && Intrinsics.areEqual((Object) this.merchantTransactionId, (Object) qRCodeModel.merchantTransactionId) && Intrinsics.areEqual((Object) this.requestSource, (Object) qRCodeModel.requestSource) && Intrinsics.areEqual((Object) this.qrVersionNumber, (Object) qRCodeModel.qrVersionNumber) && Intrinsics.areEqual((Object) this.vendorId, (Object) qRCodeModel.vendorId) && Intrinsics.areEqual((Object) this.brandId, (Object) qRCodeModel.brandId) && Intrinsics.areEqual((Object) this.countryId, (Object) qRCodeModel.countryId) && Intrinsics.areEqual((Object) this.merchantName, (Object) qRCodeModel.merchantName);
    }

    @Nullable
    public final Float getAmount() {
        return this.amount;
    }

    @Nullable
    public final Integer getBrandId() {
        return this.brandId;
    }

    @Nullable
    public final Integer getCountryId() {
        return this.countryId;
    }

    @Nullable
    public final Float getDiscount() {
        return this.discount;
    }

    @Nullable
    public final String getMerchantName() {
        return this.merchantName;
    }

    @Nullable
    public final String getMerchantTransactionId() {
        return this.merchantTransactionId;
    }

    @Nullable
    public final String getQrCodeExpiryTime() {
        return this.qrCodeExpiryTime;
    }

    @Nullable
    public final Float getQrVersionNumber() {
        return this.qrVersionNumber;
    }

    @Nullable
    public final Integer getRequestSource() {
        return this.requestSource;
    }

    @Nullable
    public final String getVendorId() {
        return this.vendorId;
    }

    public int hashCode() {
        Float f11 = this.amount;
        int i11 = 0;
        int hashCode = (f11 == null ? 0 : f11.hashCode()) * 31;
        Float f12 = this.discount;
        int hashCode2 = (hashCode + (f12 == null ? 0 : f12.hashCode())) * 31;
        String str = this.qrCodeExpiryTime;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.merchantTransactionId;
        int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num = this.requestSource;
        int hashCode5 = (hashCode4 + (num == null ? 0 : num.hashCode())) * 31;
        Float f13 = this.qrVersionNumber;
        int hashCode6 = (hashCode5 + (f13 == null ? 0 : f13.hashCode())) * 31;
        String str3 = this.vendorId;
        int hashCode7 = (hashCode6 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Integer num2 = this.brandId;
        int hashCode8 = (hashCode7 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.countryId;
        int hashCode9 = (hashCode8 + (num3 == null ? 0 : num3.hashCode())) * 31;
        String str4 = this.merchantName;
        if (str4 != null) {
            i11 = str4.hashCode();
        }
        return hashCode9 + i11;
    }

    @NotNull
    public String toString() {
        Float f11 = this.amount;
        Float f12 = this.discount;
        String str = this.qrCodeExpiryTime;
        String str2 = this.merchantTransactionId;
        Integer num = this.requestSource;
        Float f13 = this.qrVersionNumber;
        String str3 = this.vendorId;
        Integer num2 = this.brandId;
        Integer num3 = this.countryId;
        String str4 = this.merchantName;
        return "QRCodeModel(amount=" + f11 + ", discount=" + f12 + ", qrCodeExpiryTime=" + str + ", merchantTransactionId=" + str2 + ", requestSource=" + num + ", qrVersionNumber=" + f13 + ", vendorId=" + str3 + ", brandId=" + num2 + ", countryId=" + num3 + ", merchantName=" + str4 + ")";
    }
}
