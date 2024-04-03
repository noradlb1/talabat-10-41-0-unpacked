package com.talabat.talabatcommon.views.wallet.walletPaymentOption.model;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/WalletPaymentOptionMode;", "", "value", "", "(Ljava/lang/String;ILjava/lang/Integer;)V", "getValue", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "SINGLE", "MIXED", "ONLYCARD", "NONE", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public enum WalletPaymentOptionMode {
    SINGLE(0),
    MIXED(1),
    ONLYCARD(2),
    NONE(-1);
    
    @Nullable
    private final Integer value;

    private WalletPaymentOptionMode(Integer num) {
        this.value = num;
    }

    @Nullable
    public final Integer getValue() {
        return this.value;
    }
}
