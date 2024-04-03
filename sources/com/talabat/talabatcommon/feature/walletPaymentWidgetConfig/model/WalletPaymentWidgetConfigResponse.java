package com.talabat.talabatcommon.feature.walletPaymentWidgetConfig.model;

import com.google.gson.annotations.SerializedName;
import com.talabat.talabatcommon.model.wallet.WalletErrorMessageModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B#\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R&\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/talabat/talabatcommon/feature/walletPaymentWidgetConfig/model/WalletPaymentWidgetConfigResponse;", "", "result", "Lcom/talabat/talabatcommon/feature/walletPaymentWidgetConfig/model/WalletPaymentWidgetConfigResult;", "responseMessages", "", "Lcom/talabat/talabatcommon/model/wallet/WalletErrorMessageModel;", "(Lcom/talabat/talabatcommon/feature/walletPaymentWidgetConfig/model/WalletPaymentWidgetConfigResult;Ljava/util/List;)V", "getResponseMessages", "()Ljava/util/List;", "setResponseMessages", "(Ljava/util/List;)V", "getResult", "()Lcom/talabat/talabatcommon/feature/walletPaymentWidgetConfig/model/WalletPaymentWidgetConfigResult;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletPaymentWidgetConfigResponse {
    @SerializedName("responseMessages")
    @Nullable
    private List<WalletErrorMessageModel> responseMessages;
    @SerializedName("result")
    @Nullable
    private final WalletPaymentWidgetConfigResult result;

    public WalletPaymentWidgetConfigResponse() {
        this((WalletPaymentWidgetConfigResult) null, (List) null, 3, (DefaultConstructorMarker) null);
    }

    public WalletPaymentWidgetConfigResponse(@Nullable WalletPaymentWidgetConfigResult walletPaymentWidgetConfigResult, @Nullable List<WalletErrorMessageModel> list) {
        this.result = walletPaymentWidgetConfigResult;
        this.responseMessages = list;
    }

    public static /* synthetic */ WalletPaymentWidgetConfigResponse copy$default(WalletPaymentWidgetConfigResponse walletPaymentWidgetConfigResponse, WalletPaymentWidgetConfigResult walletPaymentWidgetConfigResult, List<WalletErrorMessageModel> list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            walletPaymentWidgetConfigResult = walletPaymentWidgetConfigResponse.result;
        }
        if ((i11 & 2) != 0) {
            list = walletPaymentWidgetConfigResponse.responseMessages;
        }
        return walletPaymentWidgetConfigResponse.copy(walletPaymentWidgetConfigResult, list);
    }

    @Nullable
    public final WalletPaymentWidgetConfigResult component1() {
        return this.result;
    }

    @Nullable
    public final List<WalletErrorMessageModel> component2() {
        return this.responseMessages;
    }

    @NotNull
    public final WalletPaymentWidgetConfigResponse copy(@Nullable WalletPaymentWidgetConfigResult walletPaymentWidgetConfigResult, @Nullable List<WalletErrorMessageModel> list) {
        return new WalletPaymentWidgetConfigResponse(walletPaymentWidgetConfigResult, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WalletPaymentWidgetConfigResponse)) {
            return false;
        }
        WalletPaymentWidgetConfigResponse walletPaymentWidgetConfigResponse = (WalletPaymentWidgetConfigResponse) obj;
        return Intrinsics.areEqual((Object) this.result, (Object) walletPaymentWidgetConfigResponse.result) && Intrinsics.areEqual((Object) this.responseMessages, (Object) walletPaymentWidgetConfigResponse.responseMessages);
    }

    @Nullable
    public final List<WalletErrorMessageModel> getResponseMessages() {
        return this.responseMessages;
    }

    @Nullable
    public final WalletPaymentWidgetConfigResult getResult() {
        return this.result;
    }

    public int hashCode() {
        WalletPaymentWidgetConfigResult walletPaymentWidgetConfigResult = this.result;
        int i11 = 0;
        int hashCode = (walletPaymentWidgetConfigResult == null ? 0 : walletPaymentWidgetConfigResult.hashCode()) * 31;
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
        WalletPaymentWidgetConfigResult walletPaymentWidgetConfigResult = this.result;
        List<WalletErrorMessageModel> list = this.responseMessages;
        return "WalletPaymentWidgetConfigResponse(result=" + walletPaymentWidgetConfigResult + ", responseMessages=" + list + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ WalletPaymentWidgetConfigResponse(WalletPaymentWidgetConfigResult walletPaymentWidgetConfigResult, List list, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : walletPaymentWidgetConfigResult, (i11 & 2) != 0 ? null : list);
    }
}
