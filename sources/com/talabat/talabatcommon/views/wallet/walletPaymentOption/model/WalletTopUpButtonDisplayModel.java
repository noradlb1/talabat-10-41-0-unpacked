package com.talabat.talabatcommon.views.wallet.walletPaymentOption.model;

import com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.WalletTopUpCtaState;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/WalletTopUpButtonDisplayModel;", "", "walletTopUpCtaState", "Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/WalletTopUpCtaState;", "walletTopUpAmount", "", "(Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/WalletTopUpCtaState;Ljava/lang/String;)V", "getWalletTopUpAmount", "()Ljava/lang/String;", "setWalletTopUpAmount", "(Ljava/lang/String;)V", "getWalletTopUpCtaState", "()Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/WalletTopUpCtaState;", "setWalletTopUpCtaState", "(Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/WalletTopUpCtaState;)V", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletTopUpButtonDisplayModel {
    @NotNull
    private String walletTopUpAmount;
    @NotNull
    private WalletTopUpCtaState walletTopUpCtaState;

    public WalletTopUpButtonDisplayModel() {
        this((WalletTopUpCtaState) null, (String) null, 3, (DefaultConstructorMarker) null);
    }

    public WalletTopUpButtonDisplayModel(@NotNull WalletTopUpCtaState walletTopUpCtaState2, @NotNull String str) {
        Intrinsics.checkNotNullParameter(walletTopUpCtaState2, "walletTopUpCtaState");
        Intrinsics.checkNotNullParameter(str, "walletTopUpAmount");
        this.walletTopUpCtaState = walletTopUpCtaState2;
        this.walletTopUpAmount = str;
    }

    @NotNull
    public final String getWalletTopUpAmount() {
        return this.walletTopUpAmount;
    }

    @NotNull
    public final WalletTopUpCtaState getWalletTopUpCtaState() {
        return this.walletTopUpCtaState;
    }

    public final void setWalletTopUpAmount(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.walletTopUpAmount = str;
    }

    public final void setWalletTopUpCtaState(@NotNull WalletTopUpCtaState walletTopUpCtaState2) {
        Intrinsics.checkNotNullParameter(walletTopUpCtaState2, "<set-?>");
        this.walletTopUpCtaState = walletTopUpCtaState2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ WalletTopUpButtonDisplayModel(WalletTopUpCtaState walletTopUpCtaState2, String str, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? WalletTopUpCtaState.Disabled.INSTANCE : walletTopUpCtaState2, (i11 & 2) != 0 ? "" : str);
    }
}
