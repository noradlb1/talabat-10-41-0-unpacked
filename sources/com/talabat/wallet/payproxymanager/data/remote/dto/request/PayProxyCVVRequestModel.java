package com.talabat.wallet.payproxymanager.data.remote.dto.request;

import com.talabat.card_tokenization.CardTokenizationPlugin;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/talabat/wallet/payproxymanager/data/remote/dto/request/PayProxyCVVRequestModel;", "", "encTransactionId", "", "cvv", "(Ljava/lang/String;Ljava/lang/String;)V", "getCvv", "()Ljava/lang/String;", "getEncTransactionId", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PayProxyCVVRequestModel {
    @NotNull
    private final String cvv;
    @NotNull
    private final String encTransactionId;

    public PayProxyCVVRequestModel(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "encTransactionId");
        Intrinsics.checkNotNullParameter(str2, CardTokenizationPlugin.ARG_CVV_KEY);
        this.encTransactionId = str;
        this.cvv = str2;
    }

    public static /* synthetic */ PayProxyCVVRequestModel copy$default(PayProxyCVVRequestModel payProxyCVVRequestModel, String str, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = payProxyCVVRequestModel.encTransactionId;
        }
        if ((i11 & 2) != 0) {
            str2 = payProxyCVVRequestModel.cvv;
        }
        return payProxyCVVRequestModel.copy(str, str2);
    }

    @NotNull
    public final String component1() {
        return this.encTransactionId;
    }

    @NotNull
    public final String component2() {
        return this.cvv;
    }

    @NotNull
    public final PayProxyCVVRequestModel copy(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "encTransactionId");
        Intrinsics.checkNotNullParameter(str2, CardTokenizationPlugin.ARG_CVV_KEY);
        return new PayProxyCVVRequestModel(str, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PayProxyCVVRequestModel)) {
            return false;
        }
        PayProxyCVVRequestModel payProxyCVVRequestModel = (PayProxyCVVRequestModel) obj;
        return Intrinsics.areEqual((Object) this.encTransactionId, (Object) payProxyCVVRequestModel.encTransactionId) && Intrinsics.areEqual((Object) this.cvv, (Object) payProxyCVVRequestModel.cvv);
    }

    @NotNull
    public final String getCvv() {
        return this.cvv;
    }

    @NotNull
    public final String getEncTransactionId() {
        return this.encTransactionId;
    }

    public int hashCode() {
        return (this.encTransactionId.hashCode() * 31) + this.cvv.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.encTransactionId;
        String str2 = this.cvv;
        return "PayProxyCVVRequestModel(encTransactionId=" + str + ", cvv=" + str2 + ")";
    }
}
