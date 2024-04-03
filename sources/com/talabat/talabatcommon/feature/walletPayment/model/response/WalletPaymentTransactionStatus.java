package com.talabat.talabatcommon.feature.walletPayment.model.response;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0001\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/talabat/talabatcommon/feature/walletPayment/model/response/WalletPaymentTransactionStatus;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "THREE_DS", "SUCCESS", "FAIL", "NONE", "Companion", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public enum WalletPaymentTransactionStatus {
    THREE_DS(0),
    SUCCESS(1),
    FAIL(2),
    NONE(-1);
    
    @NotNull
    public static final Companion Companion = null;
    /* access modifiers changed from: private */
    @NotNull
    public static final WalletPaymentTransactionStatus[] values = null;
    private final int value;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\tR\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/talabat/talabatcommon/feature/walletPayment/model/response/WalletPaymentTransactionStatus$Companion;", "", "()V", "values", "", "Lcom/talabat/talabatcommon/feature/walletPayment/model/response/WalletPaymentTransactionStatus;", "[Lcom/talabat/talabatcommon/feature/walletPayment/model/response/WalletPaymentTransactionStatus;", "getByValue", "value", "", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final WalletPaymentTransactionStatus getByValue(int i11) {
            boolean z11;
            for (WalletPaymentTransactionStatus walletPaymentTransactionStatus : WalletPaymentTransactionStatus.values) {
                if (walletPaymentTransactionStatus.getValue() == i11) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (z11) {
                    return walletPaymentTransactionStatus;
                }
            }
            return null;
        }
    }

    /* access modifiers changed from: public */
    static {
        Companion = new Companion((DefaultConstructorMarker) null);
        values = values();
    }

    private WalletPaymentTransactionStatus(int i11) {
        this.value = i11;
    }

    public final int getValue() {
        return this.value;
    }
}
