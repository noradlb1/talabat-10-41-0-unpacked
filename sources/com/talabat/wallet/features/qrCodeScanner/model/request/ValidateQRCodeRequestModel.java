package com.talabat.wallet.features.qrCodeScanner.model.request;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\bJ&\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\"\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/talabat/wallet/features/qrCodeScanner/model/request/ValidateQRCodeRequestModel;", "", "qrCode", "", "countryId", "", "(Ljava/lang/String;Ljava/lang/Integer;)V", "getCountryId", "()Ljava/lang/Integer;", "setCountryId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getQrCode", "()Ljava/lang/String;", "component1", "component2", "copy", "(Ljava/lang/String;Ljava/lang/Integer;)Lcom/talabat/wallet/features/qrCodeScanner/model/request/ValidateQRCodeRequestModel;", "equals", "", "other", "hashCode", "toString", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ValidateQRCodeRequestModel {
    @SerializedName("countryId")
    @Nullable
    private Integer countryId;
    @SerializedName("qrCode")
    @Nullable
    private final String qrCode;

    public ValidateQRCodeRequestModel(@Nullable String str, @Nullable Integer num) {
        this.qrCode = str;
        this.countryId = num;
    }

    public static /* synthetic */ ValidateQRCodeRequestModel copy$default(ValidateQRCodeRequestModel validateQRCodeRequestModel, String str, Integer num, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = validateQRCodeRequestModel.qrCode;
        }
        if ((i11 & 2) != 0) {
            num = validateQRCodeRequestModel.countryId;
        }
        return validateQRCodeRequestModel.copy(str, num);
    }

    @Nullable
    public final String component1() {
        return this.qrCode;
    }

    @Nullable
    public final Integer component2() {
        return this.countryId;
    }

    @NotNull
    public final ValidateQRCodeRequestModel copy(@Nullable String str, @Nullable Integer num) {
        return new ValidateQRCodeRequestModel(str, num);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ValidateQRCodeRequestModel)) {
            return false;
        }
        ValidateQRCodeRequestModel validateQRCodeRequestModel = (ValidateQRCodeRequestModel) obj;
        return Intrinsics.areEqual((Object) this.qrCode, (Object) validateQRCodeRequestModel.qrCode) && Intrinsics.areEqual((Object) this.countryId, (Object) validateQRCodeRequestModel.countryId);
    }

    @Nullable
    public final Integer getCountryId() {
        return this.countryId;
    }

    @Nullable
    public final String getQrCode() {
        return this.qrCode;
    }

    public int hashCode() {
        String str = this.qrCode;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Integer num = this.countryId;
        if (num != null) {
            i11 = num.hashCode();
        }
        return hashCode + i11;
    }

    public final void setCountryId(@Nullable Integer num) {
        this.countryId = num;
    }

    @NotNull
    public String toString() {
        String str = this.qrCode;
        Integer num = this.countryId;
        return "ValidateQRCodeRequestModel(qrCode=" + str + ", countryId=" + num + ")";
    }
}
