package com.talabat.talabatcommon.views.wallet.walletPaymentOption.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0003\u0006\u0007\b¨\u0006\t"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/WalletTopUpCtaState;", "", "()V", "Clear", "Disabled", "Enabled", "Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/WalletTopUpCtaState$Clear;", "Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/WalletTopUpCtaState$Disabled;", "Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/WalletTopUpCtaState$Enabled;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class WalletTopUpCtaState {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/WalletTopUpCtaState$Clear;", "Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/WalletTopUpCtaState;", "()V", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Clear extends WalletTopUpCtaState {
        @NotNull
        public static final Clear INSTANCE = new Clear();

        private Clear() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/WalletTopUpCtaState$Disabled;", "Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/WalletTopUpCtaState;", "()V", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Disabled extends WalletTopUpCtaState {
        @NotNull
        public static final Disabled INSTANCE = new Disabled();

        private Disabled() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/WalletTopUpCtaState$Enabled;", "Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/WalletTopUpCtaState;", "()V", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Enabled extends WalletTopUpCtaState {
        @NotNull
        public static final Enabled INSTANCE = new Enabled();

        private Enabled() {
            super((DefaultConstructorMarker) null);
        }
    }

    private WalletTopUpCtaState() {
    }

    public /* synthetic */ WalletTopUpCtaState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
