package com.talabat.wallet.features.qrCodeScanner.model.response;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0007HÆ\u0003J2\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0007HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u0002\u0010\tR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/talabat/wallet/features/qrCodeScanner/model/response/ValidateQRCodeResponseResult;", "", "isValid", "", "qrCode", "Lcom/talabat/wallet/features/qrCodeScanner/model/response/QRCodeModel;", "message", "", "(Ljava/lang/Boolean;Lcom/talabat/wallet/features/qrCodeScanner/model/response/QRCodeModel;Ljava/lang/String;)V", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getMessage", "()Ljava/lang/String;", "getQrCode", "()Lcom/talabat/wallet/features/qrCodeScanner/model/response/QRCodeModel;", "component1", "component2", "component3", "copy", "(Ljava/lang/Boolean;Lcom/talabat/wallet/features/qrCodeScanner/model/response/QRCodeModel;Ljava/lang/String;)Lcom/talabat/wallet/features/qrCodeScanner/model/response/ValidateQRCodeResponseResult;", "equals", "other", "hashCode", "", "toString", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ValidateQRCodeResponseResult {
    @SerializedName("isValid")
    @Nullable
    private final Boolean isValid;
    @SerializedName("message")
    @Nullable
    private final String message;
    @SerializedName("qrCode")
    @Nullable
    private final QRCodeModel qrCode;

    public ValidateQRCodeResponseResult(@Nullable Boolean bool, @Nullable QRCodeModel qRCodeModel, @Nullable String str) {
        this.isValid = bool;
        this.qrCode = qRCodeModel;
        this.message = str;
    }

    public static /* synthetic */ ValidateQRCodeResponseResult copy$default(ValidateQRCodeResponseResult validateQRCodeResponseResult, Boolean bool, QRCodeModel qRCodeModel, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            bool = validateQRCodeResponseResult.isValid;
        }
        if ((i11 & 2) != 0) {
            qRCodeModel = validateQRCodeResponseResult.qrCode;
        }
        if ((i11 & 4) != 0) {
            str = validateQRCodeResponseResult.message;
        }
        return validateQRCodeResponseResult.copy(bool, qRCodeModel, str);
    }

    @Nullable
    public final Boolean component1() {
        return this.isValid;
    }

    @Nullable
    public final QRCodeModel component2() {
        return this.qrCode;
    }

    @Nullable
    public final String component3() {
        return this.message;
    }

    @NotNull
    public final ValidateQRCodeResponseResult copy(@Nullable Boolean bool, @Nullable QRCodeModel qRCodeModel, @Nullable String str) {
        return new ValidateQRCodeResponseResult(bool, qRCodeModel, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ValidateQRCodeResponseResult)) {
            return false;
        }
        ValidateQRCodeResponseResult validateQRCodeResponseResult = (ValidateQRCodeResponseResult) obj;
        return Intrinsics.areEqual((Object) this.isValid, (Object) validateQRCodeResponseResult.isValid) && Intrinsics.areEqual((Object) this.qrCode, (Object) validateQRCodeResponseResult.qrCode) && Intrinsics.areEqual((Object) this.message, (Object) validateQRCodeResponseResult.message);
    }

    @Nullable
    public final String getMessage() {
        return this.message;
    }

    @Nullable
    public final QRCodeModel getQrCode() {
        return this.qrCode;
    }

    public int hashCode() {
        Boolean bool = this.isValid;
        int i11 = 0;
        int hashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        QRCodeModel qRCodeModel = this.qrCode;
        int hashCode2 = (hashCode + (qRCodeModel == null ? 0 : qRCodeModel.hashCode())) * 31;
        String str = this.message;
        if (str != null) {
            i11 = str.hashCode();
        }
        return hashCode2 + i11;
    }

    @Nullable
    public final Boolean isValid() {
        return this.isValid;
    }

    @NotNull
    public String toString() {
        Boolean bool = this.isValid;
        QRCodeModel qRCodeModel = this.qrCode;
        String str = this.message;
        return "ValidateQRCodeResponseResult(isValid=" + bool + ", qrCode=" + qRCodeModel + ", message=" + str + ")";
    }
}
