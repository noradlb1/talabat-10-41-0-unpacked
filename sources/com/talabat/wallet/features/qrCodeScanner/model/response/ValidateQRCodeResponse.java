package com.talabat.wallet.features.qrCodeScanner.model.response;

import com.google.gson.annotations.SerializedName;
import com.talabat.talabatcommon.model.wallet.WalletErrorMessageModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007R&\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/talabat/wallet/features/qrCodeScanner/model/response/ValidateQRCodeResponse;", "", "result", "Lcom/talabat/wallet/features/qrCodeScanner/model/response/ValidateQRCodeResponseResult;", "responseMessages", "", "Lcom/talabat/talabatcommon/model/wallet/WalletErrorMessageModel;", "(Lcom/talabat/wallet/features/qrCodeScanner/model/response/ValidateQRCodeResponseResult;Ljava/util/List;)V", "getResponseMessages", "()Ljava/util/List;", "setResponseMessages", "(Ljava/util/List;)V", "getResult", "()Lcom/talabat/wallet/features/qrCodeScanner/model/response/ValidateQRCodeResponseResult;", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ValidateQRCodeResponse {
    @SerializedName("responseMessages")
    @Nullable
    private List<WalletErrorMessageModel> responseMessages;
    @SerializedName("result")
    @Nullable
    private final ValidateQRCodeResponseResult result;

    public ValidateQRCodeResponse() {
        this((ValidateQRCodeResponseResult) null, (List) null, 3, (DefaultConstructorMarker) null);
    }

    public ValidateQRCodeResponse(@Nullable ValidateQRCodeResponseResult validateQRCodeResponseResult, @Nullable List<WalletErrorMessageModel> list) {
        this.result = validateQRCodeResponseResult;
        this.responseMessages = list;
    }

    @Nullable
    public final List<WalletErrorMessageModel> getResponseMessages() {
        return this.responseMessages;
    }

    @Nullable
    public final ValidateQRCodeResponseResult getResult() {
        return this.result;
    }

    public final void setResponseMessages(@Nullable List<WalletErrorMessageModel> list) {
        this.responseMessages = list;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ValidateQRCodeResponse(ValidateQRCodeResponseResult validateQRCodeResponseResult, List list, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : validateQRCodeResponseResult, (i11 & 2) != 0 ? null : list);
    }
}
