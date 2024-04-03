package com.talabat.talabatcommon.views.wallet.walletPaymentOption.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0001\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/WalletBottomSheetPaymentMode;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "CARDDETAIL", "PAYMENT", "THREEDS", "NONE", "Companion", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public enum WalletBottomSheetPaymentMode {
    CARDDETAIL(2),
    PAYMENT(1),
    THREEDS(3),
    NONE(-1);
    
    @NotNull
    public static final Companion Companion = null;
    private final int value;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/WalletBottomSheetPaymentMode$Companion;", "", "()V", "fromInt", "Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/WalletBottomSheetPaymentMode;", "value", "", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final WalletBottomSheetPaymentMode fromInt(int i11) {
            WalletBottomSheetPaymentMode walletBottomSheetPaymentMode;
            boolean z11;
            WalletBottomSheetPaymentMode[] values = WalletBottomSheetPaymentMode.values();
            int length = values.length;
            int i12 = 0;
            while (true) {
                if (i12 >= length) {
                    walletBottomSheetPaymentMode = null;
                    break;
                }
                walletBottomSheetPaymentMode = values[i12];
                if (walletBottomSheetPaymentMode.getValue() == i11) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (z11) {
                    break;
                }
                i12++;
            }
            if (walletBottomSheetPaymentMode == null) {
                return WalletBottomSheetPaymentMode.NONE;
            }
            return walletBottomSheetPaymentMode;
        }
    }

    /* access modifiers changed from: public */
    static {
        Companion = new Companion((DefaultConstructorMarker) null);
    }

    private WalletBottomSheetPaymentMode(int i11) {
        this.value = i11;
    }

    public final int getValue() {
        return this.value;
    }
}
