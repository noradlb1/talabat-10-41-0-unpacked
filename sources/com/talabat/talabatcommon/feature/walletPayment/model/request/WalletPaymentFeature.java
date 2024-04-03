package com.talabat.talabatcommon.feature.walletPayment.model.request;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0001\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/talabat/talabatcommon/feature/walletPayment/model/request/WalletPaymentFeature;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "TOP_UP", "RIDER_TIP", "TLIFE_SUBSCRIPTION", "TLIFE_REDEMPTION", "BNPL_AD_HOC_PAYMEENT", "NONE", "Companion", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public enum WalletPaymentFeature {
    TOP_UP(100),
    RIDER_TIP(200),
    TLIFE_SUBSCRIPTION(300),
    TLIFE_REDEMPTION(301),
    BNPL_AD_HOC_PAYMEENT(501),
    NONE(-1);
    
    @NotNull
    public static final Companion Companion = null;
    private final int value;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/talabat/talabatcommon/feature/walletPayment/model/request/WalletPaymentFeature$Companion;", "", "()V", "fromInt", "Lcom/talabat/talabatcommon/feature/walletPayment/model/request/WalletPaymentFeature;", "value", "", "(Ljava/lang/Integer;)Lcom/talabat/talabatcommon/feature/walletPayment/model/request/WalletPaymentFeature;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final WalletPaymentFeature fromInt(@Nullable Integer num) {
            WalletPaymentFeature walletPaymentFeature;
            boolean z11;
            WalletPaymentFeature[] values = WalletPaymentFeature.values();
            int length = values.length;
            int i11 = 0;
            while (true) {
                if (i11 >= length) {
                    walletPaymentFeature = null;
                    break;
                }
                walletPaymentFeature = values[i11];
                int value = walletPaymentFeature.getValue();
                if (num != null && value == num.intValue()) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (z11) {
                    break;
                }
                i11++;
            }
            if (walletPaymentFeature == null) {
                return WalletPaymentFeature.NONE;
            }
            return walletPaymentFeature;
        }
    }

    /* access modifiers changed from: public */
    static {
        Companion = new Companion((DefaultConstructorMarker) null);
    }

    private WalletPaymentFeature(int i11) {
        this.value = i11;
    }

    public final int getValue() {
        return this.value;
    }
}
