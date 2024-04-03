package com.talabat.wallet.bnplmanager.domain.entity;

import com.talabat.mapper.ModelMapping;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/talabat/wallet/bnplmanager/domain/entity/InstallmentDetail;", "", "()V", "amount", "", "getAmount", "()F", "setAmount", "(F)V", "paymentDate", "", "getPaymentDate", "()Ljava/lang/String;", "setPaymentDate", "(Ljava/lang/String;)V", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class InstallmentDetail {
    @ModelMapping({"installmentAmount"})
    private float amount;
    @NotNull
    @ModelMapping({"installmentDate"})
    private String paymentDate = "";

    public final float getAmount() {
        return this.amount;
    }

    @NotNull
    public final String getPaymentDate() {
        return this.paymentDate;
    }

    public final void setAmount(float f11) {
        this.amount = f11;
    }

    public final void setPaymentDate(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.paymentDate = str;
    }
}
