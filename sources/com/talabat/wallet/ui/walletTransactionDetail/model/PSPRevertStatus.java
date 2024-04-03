package com.talabat.wallet.ui.walletTransactionDetail.model;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/talabat/wallet/ui/walletTransactionDetail/model/PSPRevertStatus;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "NotInitiated", "CustomerRevertRequested", "RevertInitiated", "RevertProcessed", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public enum PSPRevertStatus {
    NotInitiated(0),
    CustomerRevertRequested(100),
    RevertInitiated(200),
    RevertProcessed(300);
    
    private final int value;

    private PSPRevertStatus(int i11) {
        this.value = i11;
    }

    public final int getValue() {
        return this.value;
    }
}
