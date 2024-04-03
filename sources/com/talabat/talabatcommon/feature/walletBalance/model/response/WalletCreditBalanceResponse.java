package com.talabat.talabatcommon.feature.walletBalance.model.response;

import com.google.gson.annotations.SerializedName;
import com.talabat.talabatcommon.model.wallet.WalletErrorMessageModel;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B/\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u001c\b\u0002\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001d\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007HÆ\u0003J3\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u001c\b\u0002\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R2\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u00078\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/talabat/talabatcommon/feature/walletBalance/model/response/WalletCreditBalanceResponse;", "", "result", "Lcom/talabat/talabatcommon/feature/walletBalance/model/response/WalletCreditBalanceResultModel;", "responseMessages", "Ljava/util/ArrayList;", "Lcom/talabat/talabatcommon/model/wallet/WalletErrorMessageModel;", "Lkotlin/collections/ArrayList;", "(Lcom/talabat/talabatcommon/feature/walletBalance/model/response/WalletCreditBalanceResultModel;Ljava/util/ArrayList;)V", "getResponseMessages", "()Ljava/util/ArrayList;", "setResponseMessages", "(Ljava/util/ArrayList;)V", "getResult", "()Lcom/talabat/talabatcommon/feature/walletBalance/model/response/WalletCreditBalanceResultModel;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletCreditBalanceResponse {
    @SerializedName("responseMessages")
    @Nullable
    private ArrayList<WalletErrorMessageModel> responseMessages;
    @SerializedName("result")
    @Nullable
    private final WalletCreditBalanceResultModel result;

    public WalletCreditBalanceResponse() {
        this((WalletCreditBalanceResultModel) null, (ArrayList) null, 3, (DefaultConstructorMarker) null);
    }

    public WalletCreditBalanceResponse(@Nullable WalletCreditBalanceResultModel walletCreditBalanceResultModel, @Nullable ArrayList<WalletErrorMessageModel> arrayList) {
        this.result = walletCreditBalanceResultModel;
        this.responseMessages = arrayList;
    }

    public static /* synthetic */ WalletCreditBalanceResponse copy$default(WalletCreditBalanceResponse walletCreditBalanceResponse, WalletCreditBalanceResultModel walletCreditBalanceResultModel, ArrayList<WalletErrorMessageModel> arrayList, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            walletCreditBalanceResultModel = walletCreditBalanceResponse.result;
        }
        if ((i11 & 2) != 0) {
            arrayList = walletCreditBalanceResponse.responseMessages;
        }
        return walletCreditBalanceResponse.copy(walletCreditBalanceResultModel, arrayList);
    }

    @Nullable
    public final WalletCreditBalanceResultModel component1() {
        return this.result;
    }

    @Nullable
    public final ArrayList<WalletErrorMessageModel> component2() {
        return this.responseMessages;
    }

    @NotNull
    public final WalletCreditBalanceResponse copy(@Nullable WalletCreditBalanceResultModel walletCreditBalanceResultModel, @Nullable ArrayList<WalletErrorMessageModel> arrayList) {
        return new WalletCreditBalanceResponse(walletCreditBalanceResultModel, arrayList);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WalletCreditBalanceResponse)) {
            return false;
        }
        WalletCreditBalanceResponse walletCreditBalanceResponse = (WalletCreditBalanceResponse) obj;
        return Intrinsics.areEqual((Object) this.result, (Object) walletCreditBalanceResponse.result) && Intrinsics.areEqual((Object) this.responseMessages, (Object) walletCreditBalanceResponse.responseMessages);
    }

    @Nullable
    public final ArrayList<WalletErrorMessageModel> getResponseMessages() {
        return this.responseMessages;
    }

    @Nullable
    public final WalletCreditBalanceResultModel getResult() {
        return this.result;
    }

    public int hashCode() {
        WalletCreditBalanceResultModel walletCreditBalanceResultModel = this.result;
        int i11 = 0;
        int hashCode = (walletCreditBalanceResultModel == null ? 0 : walletCreditBalanceResultModel.hashCode()) * 31;
        ArrayList<WalletErrorMessageModel> arrayList = this.responseMessages;
        if (arrayList != null) {
            i11 = arrayList.hashCode();
        }
        return hashCode + i11;
    }

    public final void setResponseMessages(@Nullable ArrayList<WalletErrorMessageModel> arrayList) {
        this.responseMessages = arrayList;
    }

    @NotNull
    public String toString() {
        WalletCreditBalanceResultModel walletCreditBalanceResultModel = this.result;
        ArrayList<WalletErrorMessageModel> arrayList = this.responseMessages;
        return "WalletCreditBalanceResponse(result=" + walletCreditBalanceResultModel + ", responseMessages=" + arrayList + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ WalletCreditBalanceResponse(WalletCreditBalanceResultModel walletCreditBalanceResultModel, ArrayList arrayList, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : walletCreditBalanceResultModel, (i11 & 2) != 0 ? null : arrayList);
    }
}
