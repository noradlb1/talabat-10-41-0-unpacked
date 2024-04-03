package com.talabat.wallet.features.qrCodeScanner.model.response;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/talabat/wallet/features/qrCodeScanner/model/response/WalletTransactionStatus;", "", "value", "", "(Ljava/lang/String;ILjava/lang/Integer;)V", "getValue", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "DEFAULT", "PENDING", "SUCCESS", "FAIL", "EXPIRED", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public enum WalletTransactionStatus {
    DEFAULT(-1),
    PENDING(0),
    SUCCESS(1),
    FAIL(2),
    EXPIRED(3);
    
    @Nullable
    private final Integer value;

    private WalletTransactionStatus(Integer num) {
        this.value = num;
    }

    @Nullable
    public final Integer getValue() {
        return this.value;
    }
}
