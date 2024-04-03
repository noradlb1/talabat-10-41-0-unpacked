package com.talabat.talabatcommon.views.wallet.walletCardManagement.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0003\u0006\u0007\b¨\u0006\t"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/model/WalletSetDefaultCardDisplayModelState;", "", "()V", "ErrorSetDefaultCard", "Loading", "SuccessSetDefaultCard", "Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/model/WalletSetDefaultCardDisplayModelState$Loading;", "Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/model/WalletSetDefaultCardDisplayModelState$SuccessSetDefaultCard;", "Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/model/WalletSetDefaultCardDisplayModelState$ErrorSetDefaultCard;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class WalletSetDefaultCardDisplayModelState {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/model/WalletSetDefaultCardDisplayModelState$ErrorSetDefaultCard;", "Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/model/WalletSetDefaultCardDisplayModelState;", "()V", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ErrorSetDefaultCard extends WalletSetDefaultCardDisplayModelState {
        @NotNull
        public static final ErrorSetDefaultCard INSTANCE = new ErrorSetDefaultCard();

        private ErrorSetDefaultCard() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/model/WalletSetDefaultCardDisplayModelState$Loading;", "Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/model/WalletSetDefaultCardDisplayModelState;", "()V", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Loading extends WalletSetDefaultCardDisplayModelState {
        @NotNull
        public static final Loading INSTANCE = new Loading();

        private Loading() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/model/WalletSetDefaultCardDisplayModelState$SuccessSetDefaultCard;", "Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/model/WalletSetDefaultCardDisplayModelState;", "()V", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class SuccessSetDefaultCard extends WalletSetDefaultCardDisplayModelState {
        @NotNull
        public static final SuccessSetDefaultCard INSTANCE = new SuccessSetDefaultCard();

        private SuccessSetDefaultCard() {
            super((DefaultConstructorMarker) null);
        }
    }

    private WalletSetDefaultCardDisplayModelState() {
    }

    public /* synthetic */ WalletSetDefaultCardDisplayModelState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
