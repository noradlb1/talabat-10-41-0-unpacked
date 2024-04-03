package com.talabat.talabatcommon.views.wallet.walletCardManagement.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0004\u0007\b\t\n¨\u0006\u000b"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/model/WalletAddCardDisplayModelState;", "", "()V", "ErrorWalletAddCard", "Loading", "SuccessWalletAddCardNonThreeDS", "SuccessWalletAddCardThreeDS", "Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/model/WalletAddCardDisplayModelState$Loading;", "Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/model/WalletAddCardDisplayModelState$ErrorWalletAddCard;", "Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/model/WalletAddCardDisplayModelState$SuccessWalletAddCardNonThreeDS;", "Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/model/WalletAddCardDisplayModelState$SuccessWalletAddCardThreeDS;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class WalletAddCardDisplayModelState {

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/model/WalletAddCardDisplayModelState$ErrorWalletAddCard;", "Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/model/WalletAddCardDisplayModelState;", "errorState", "Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/model/WalletAddCardErrorState;", "(Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/model/WalletAddCardErrorState;)V", "getErrorState", "()Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/model/WalletAddCardErrorState;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ErrorWalletAddCard extends WalletAddCardDisplayModelState {
        @NotNull
        private final WalletAddCardErrorState errorState;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ErrorWalletAddCard(@NotNull WalletAddCardErrorState walletAddCardErrorState) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(walletAddCardErrorState, "errorState");
            this.errorState = walletAddCardErrorState;
        }

        @NotNull
        public final WalletAddCardErrorState getErrorState() {
            return this.errorState;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/model/WalletAddCardDisplayModelState$Loading;", "Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/model/WalletAddCardDisplayModelState;", "()V", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Loading extends WalletAddCardDisplayModelState {
        @NotNull
        public static final Loading INSTANCE = new Loading();

        private Loading() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/model/WalletAddCardDisplayModelState$SuccessWalletAddCardNonThreeDS;", "Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/model/WalletAddCardDisplayModelState;", "()V", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class SuccessWalletAddCardNonThreeDS extends WalletAddCardDisplayModelState {
        @NotNull
        public static final SuccessWalletAddCardNonThreeDS INSTANCE = new SuccessWalletAddCardNonThreeDS();

        private SuccessWalletAddCardNonThreeDS() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/model/WalletAddCardDisplayModelState$SuccessWalletAddCardThreeDS;", "Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/model/WalletAddCardDisplayModelState;", "redirectUrl", "", "(Ljava/lang/String;)V", "getRedirectUrl", "()Ljava/lang/String;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class SuccessWalletAddCardThreeDS extends WalletAddCardDisplayModelState {
        @NotNull
        private final String redirectUrl;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SuccessWalletAddCardThreeDS(@NotNull String str) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "redirectUrl");
            this.redirectUrl = str;
        }

        @NotNull
        public final String getRedirectUrl() {
            return this.redirectUrl;
        }
    }

    private WalletAddCardDisplayModelState() {
    }

    public /* synthetic */ WalletAddCardDisplayModelState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
