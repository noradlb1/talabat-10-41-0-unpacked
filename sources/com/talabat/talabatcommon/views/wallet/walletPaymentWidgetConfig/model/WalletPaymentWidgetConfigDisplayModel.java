package com.talabat.talabatcommon.views.wallet.walletPaymentWidgetConfig.model;

import com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.PaymentMethod;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\u0005\"\u0004\b\t\u0010\u0007R\u001a\u0010\n\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0005\"\u0004\b\u000b\u0010\u0007R \u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/walletPaymentWidgetConfig/model/WalletPaymentWidgetConfigDisplayModel;", "", "()V", "isCashEnabled", "", "()Z", "setCashEnabled", "(Z)V", "isElectronicPaymentEnabled", "setElectronicPaymentEnabled", "isWalletEnabled", "setWalletEnabled", "paymentMethods", "", "Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/PaymentMethod;", "getPaymentMethods", "()Ljava/util/List;", "setPaymentMethods", "(Ljava/util/List;)V", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletPaymentWidgetConfigDisplayModel {
    private boolean isCashEnabled;
    private boolean isElectronicPaymentEnabled;
    private boolean isWalletEnabled;
    @NotNull
    private List<? extends PaymentMethod> paymentMethods = CollectionsKt__CollectionsKt.emptyList();

    @NotNull
    public final List<PaymentMethod> getPaymentMethods() {
        return this.paymentMethods;
    }

    public final boolean isCashEnabled() {
        return this.isCashEnabled;
    }

    public final boolean isElectronicPaymentEnabled() {
        return this.isElectronicPaymentEnabled;
    }

    public final boolean isWalletEnabled() {
        return this.isWalletEnabled;
    }

    public final void setCashEnabled(boolean z11) {
        this.isCashEnabled = z11;
    }

    public final void setElectronicPaymentEnabled(boolean z11) {
        this.isElectronicPaymentEnabled = z11;
    }

    public final void setPaymentMethods(@NotNull List<? extends PaymentMethod> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.paymentMethods = list;
    }

    public final void setWalletEnabled(boolean z11) {
        this.isWalletEnabled = z11;
    }
}
