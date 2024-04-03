package com.talabat.wallet.features.qrCodeScanner.model.response;

import com.google.gson.annotations.SerializedName;
import com.talabat.talabatcommon.model.wallet.WalletErrorMessageModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B#\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R&\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/talabat/wallet/features/qrCodeScanner/model/response/WalletPaymentResponse;", "", "result", "Lcom/talabat/wallet/features/qrCodeScanner/model/response/WalletPaymentResponseResult;", "responseMessages", "", "Lcom/talabat/talabatcommon/model/wallet/WalletErrorMessageModel;", "(Lcom/talabat/wallet/features/qrCodeScanner/model/response/WalletPaymentResponseResult;Ljava/util/List;)V", "getResponseMessages", "()Ljava/util/List;", "setResponseMessages", "(Ljava/util/List;)V", "getResult", "()Lcom/talabat/wallet/features/qrCodeScanner/model/response/WalletPaymentResponseResult;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletPaymentResponse {
    @SerializedName("responseMessages")
    @Nullable
    private List<WalletErrorMessageModel> responseMessages;
    @SerializedName("result")
    @Nullable
    private final WalletPaymentResponseResult result;

    public WalletPaymentResponse() {
        this((WalletPaymentResponseResult) null, (List) null, 3, (DefaultConstructorMarker) null);
    }

    public WalletPaymentResponse(@Nullable WalletPaymentResponseResult walletPaymentResponseResult, @Nullable List<WalletErrorMessageModel> list) {
        this.result = walletPaymentResponseResult;
        this.responseMessages = list;
    }

    public static /* synthetic */ WalletPaymentResponse copy$default(WalletPaymentResponse walletPaymentResponse, WalletPaymentResponseResult walletPaymentResponseResult, List<WalletErrorMessageModel> list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            walletPaymentResponseResult = walletPaymentResponse.result;
        }
        if ((i11 & 2) != 0) {
            list = walletPaymentResponse.responseMessages;
        }
        return walletPaymentResponse.copy(walletPaymentResponseResult, list);
    }

    @Nullable
    public final WalletPaymentResponseResult component1() {
        return this.result;
    }

    @Nullable
    public final List<WalletErrorMessageModel> component2() {
        return this.responseMessages;
    }

    @NotNull
    public final WalletPaymentResponse copy(@Nullable WalletPaymentResponseResult walletPaymentResponseResult, @Nullable List<WalletErrorMessageModel> list) {
        return new WalletPaymentResponse(walletPaymentResponseResult, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WalletPaymentResponse)) {
            return false;
        }
        WalletPaymentResponse walletPaymentResponse = (WalletPaymentResponse) obj;
        return Intrinsics.areEqual((Object) this.result, (Object) walletPaymentResponse.result) && Intrinsics.areEqual((Object) this.responseMessages, (Object) walletPaymentResponse.responseMessages);
    }

    @Nullable
    public final List<WalletErrorMessageModel> getResponseMessages() {
        return this.responseMessages;
    }

    @Nullable
    public final WalletPaymentResponseResult getResult() {
        return this.result;
    }

    public int hashCode() {
        WalletPaymentResponseResult walletPaymentResponseResult = this.result;
        int i11 = 0;
        int hashCode = (walletPaymentResponseResult == null ? 0 : walletPaymentResponseResult.hashCode()) * 31;
        List<WalletErrorMessageModel> list = this.responseMessages;
        if (list != null) {
            i11 = list.hashCode();
        }
        return hashCode + i11;
    }

    public final void setResponseMessages(@Nullable List<WalletErrorMessageModel> list) {
        this.responseMessages = list;
    }

    @NotNull
    public String toString() {
        WalletPaymentResponseResult walletPaymentResponseResult = this.result;
        List<WalletErrorMessageModel> list = this.responseMessages;
        return "WalletPaymentResponse(result=" + walletPaymentResponseResult + ", responseMessages=" + list + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ WalletPaymentResponse(WalletPaymentResponseResult walletPaymentResponseResult, List list, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : walletPaymentResponseResult, (i11 & 2) != 0 ? null : list);
    }
}
