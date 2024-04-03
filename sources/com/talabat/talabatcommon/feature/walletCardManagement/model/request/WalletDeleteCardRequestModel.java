package com.talabat.talabatcommon.feature.walletCardManagement.model.request;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0015"}, d2 = {"Lcom/talabat/talabatcommon/feature/walletCardManagement/model/request/WalletDeleteCardRequestModel;", "", "eTokenId", "", "paymentProvider", "", "(Ljava/lang/String;I)V", "getETokenId", "()Ljava/lang/String;", "getPaymentProvider", "()I", "setPaymentProvider", "(I)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletDeleteCardRequestModel {
    @SerializedName("eTokenId")
    @NotNull
    private final String eTokenId;
    @SerializedName("paymentProvider")
    private int paymentProvider;

    public WalletDeleteCardRequestModel(@NotNull String str, int i11) {
        Intrinsics.checkNotNullParameter(str, "eTokenId");
        this.eTokenId = str;
        this.paymentProvider = i11;
    }

    public static /* synthetic */ WalletDeleteCardRequestModel copy$default(WalletDeleteCardRequestModel walletDeleteCardRequestModel, String str, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            str = walletDeleteCardRequestModel.eTokenId;
        }
        if ((i12 & 2) != 0) {
            i11 = walletDeleteCardRequestModel.paymentProvider;
        }
        return walletDeleteCardRequestModel.copy(str, i11);
    }

    @NotNull
    public final String component1() {
        return this.eTokenId;
    }

    public final int component2() {
        return this.paymentProvider;
    }

    @NotNull
    public final WalletDeleteCardRequestModel copy(@NotNull String str, int i11) {
        Intrinsics.checkNotNullParameter(str, "eTokenId");
        return new WalletDeleteCardRequestModel(str, i11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WalletDeleteCardRequestModel)) {
            return false;
        }
        WalletDeleteCardRequestModel walletDeleteCardRequestModel = (WalletDeleteCardRequestModel) obj;
        return Intrinsics.areEqual((Object) this.eTokenId, (Object) walletDeleteCardRequestModel.eTokenId) && this.paymentProvider == walletDeleteCardRequestModel.paymentProvider;
    }

    @NotNull
    public final String getETokenId() {
        return this.eTokenId;
    }

    public final int getPaymentProvider() {
        return this.paymentProvider;
    }

    public int hashCode() {
        return (this.eTokenId.hashCode() * 31) + this.paymentProvider;
    }

    public final void setPaymentProvider(int i11) {
        this.paymentProvider = i11;
    }

    @NotNull
    public String toString() {
        String str = this.eTokenId;
        int i11 = this.paymentProvider;
        return "WalletDeleteCardRequestModel(eTokenId=" + str + ", paymentProvider=" + i11 + ")";
    }
}
