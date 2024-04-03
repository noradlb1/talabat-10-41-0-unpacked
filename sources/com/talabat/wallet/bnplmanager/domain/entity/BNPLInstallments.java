package com.talabat.wallet.bnplmanager.domain.entity;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/talabat/wallet/bnplmanager/domain/entity/BNPLInstallments;", "", "()V", "installments", "", "Lcom/talabat/wallet/bnplmanager/domain/entity/InstallmentDetail;", "getInstallments", "()Ljava/util/List;", "setInstallments", "(Ljava/util/List;)V", "isServerError", "", "()Z", "setServerError", "(Z)V", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BNPLInstallments {
    @NotNull
    private List<InstallmentDetail> installments = CollectionsKt__CollectionsKt.emptyList();
    private boolean isServerError;

    @NotNull
    public final List<InstallmentDetail> getInstallments() {
        return this.installments;
    }

    public final boolean isServerError() {
        return this.isServerError;
    }

    public final void setInstallments(@NotNull List<InstallmentDetail> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.installments = list;
    }

    public final void setServerError(boolean z11) {
        this.isServerError = z11;
    }
}
