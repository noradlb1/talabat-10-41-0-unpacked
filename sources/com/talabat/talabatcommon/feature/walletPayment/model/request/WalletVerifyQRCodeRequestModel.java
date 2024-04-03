package com.talabat.talabatcommon.feature.walletPayment.model.request;

import com.integration.IntegrationGlobalDataModel;
import com.talabat.talabatcommon.extentions.StringUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/talabat/talabatcommon/feature/walletPayment/model/request/WalletVerifyQRCodeRequestModel;", "", "merchantTransactionId", "", "country", "", "(Ljava/lang/String;I)V", "getCountry", "()I", "setCountry", "(I)V", "getMerchantTransactionId", "()Ljava/lang/String;", "setMerchantTransactionId", "(Ljava/lang/String;)V", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletVerifyQRCodeRequestModel {
    private int country;
    @NotNull
    private String merchantTransactionId;

    public WalletVerifyQRCodeRequestModel() {
        this((String) null, 0, 3, (DefaultConstructorMarker) null);
    }

    public WalletVerifyQRCodeRequestModel(@NotNull String str, int i11) {
        Intrinsics.checkNotNullParameter(str, "merchantTransactionId");
        this.merchantTransactionId = str;
        this.country = i11;
    }

    public final int getCountry() {
        return this.country;
    }

    @NotNull
    public final String getMerchantTransactionId() {
        return this.merchantTransactionId;
    }

    public final void setCountry(int i11) {
        this.country = i11;
    }

    public final void setMerchantTransactionId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.merchantTransactionId = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ WalletVerifyQRCodeRequestModel(String str, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this((i12 & 1) != 0 ? StringUtils.empty(StringCompanionObject.INSTANCE) : str, (i12 & 2) != 0 ? IntegrationGlobalDataModel.Companion.selectedCountryCode() : i11);
    }
}
