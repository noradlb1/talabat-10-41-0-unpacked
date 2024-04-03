package com.talabat.talabatcommon.views.wallet.walletPaymentOption.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0001\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000eB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000f"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/PaymentMethod;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "WALLET", "MIXED", "CARD", "CASH", "KNET", "NAPS", "NONE", "Companion", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public enum PaymentMethod {
    WALLET(1),
    MIXED(2),
    CARD(3),
    CASH(4),
    KNET(5),
    NAPS(11),
    NONE(-1);
    
    @NotNull
    public static final Companion Companion = null;
    private final int value;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/PaymentMethod$Companion;", "", "()V", "fromInt", "Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/PaymentMethod;", "value", "", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final PaymentMethod fromInt(int i11) {
            PaymentMethod paymentMethod;
            boolean z11;
            PaymentMethod[] values = PaymentMethod.values();
            int length = values.length;
            int i12 = 0;
            while (true) {
                if (i12 >= length) {
                    paymentMethod = null;
                    break;
                }
                paymentMethod = values[i12];
                if (paymentMethod.getValue() == i11) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (z11) {
                    break;
                }
                i12++;
            }
            if (paymentMethod == null) {
                return PaymentMethod.NONE;
            }
            return paymentMethod;
        }
    }

    /* access modifiers changed from: public */
    static {
        Companion = new Companion((DefaultConstructorMarker) null);
    }

    private PaymentMethod(int i11) {
        this.value = i11;
    }

    public final int getValue() {
        return this.value;
    }
}
