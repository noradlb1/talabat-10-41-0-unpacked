package com.talabat.talabatcommon.views.wallet.walletCardManagement.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0004\u0007\b\t\n¨\u0006\u000b"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/model/WalletValidateCardNumberState;", "", "()V", "DefaultValidateCardNumber", "FailureValidateCardNumber", "ShowCardIcon", "SuccessValidateCardNumber", "Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/model/WalletValidateCardNumberState$ShowCardIcon;", "Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/model/WalletValidateCardNumberState$FailureValidateCardNumber;", "Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/model/WalletValidateCardNumberState$DefaultValidateCardNumber;", "Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/model/WalletValidateCardNumberState$SuccessValidateCardNumber;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class WalletValidateCardNumberState {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/model/WalletValidateCardNumberState$DefaultValidateCardNumber;", "Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/model/WalletValidateCardNumberState;", "()V", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultValidateCardNumber extends WalletValidateCardNumberState {
        @NotNull
        public static final DefaultValidateCardNumber INSTANCE = new DefaultValidateCardNumber();

        private DefaultValidateCardNumber() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/model/WalletValidateCardNumberState$FailureValidateCardNumber;", "Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/model/WalletValidateCardNumberState;", "errorState", "Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/model/WalletCardNumberValidationErrorState;", "(Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/model/WalletCardNumberValidationErrorState;)V", "getErrorState", "()Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/model/WalletCardNumberValidationErrorState;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class FailureValidateCardNumber extends WalletValidateCardNumberState {
        @NotNull
        private final WalletCardNumberValidationErrorState errorState;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public FailureValidateCardNumber(@NotNull WalletCardNumberValidationErrorState walletCardNumberValidationErrorState) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(walletCardNumberValidationErrorState, "errorState");
            this.errorState = walletCardNumberValidationErrorState;
        }

        @NotNull
        public final WalletCardNumberValidationErrorState getErrorState() {
            return this.errorState;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/model/WalletValidateCardNumberState$ShowCardIcon;", "Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/model/WalletValidateCardNumberState;", "cardType", "Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/model/WalletCardType;", "(Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/model/WalletCardType;)V", "getCardType", "()Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/model/WalletCardType;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ShowCardIcon extends WalletValidateCardNumberState {
        @NotNull
        private final WalletCardType cardType;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ShowCardIcon(@NotNull WalletCardType walletCardType) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(walletCardType, "cardType");
            this.cardType = walletCardType;
        }

        @NotNull
        public final WalletCardType getCardType() {
            return this.cardType;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/model/WalletValidateCardNumberState$SuccessValidateCardNumber;", "Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/model/WalletValidateCardNumberState;", "()V", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class SuccessValidateCardNumber extends WalletValidateCardNumberState {
        @NotNull
        public static final SuccessValidateCardNumber INSTANCE = new SuccessValidateCardNumber();

        private SuccessValidateCardNumber() {
            super((DefaultConstructorMarker) null);
        }
    }

    private WalletValidateCardNumberState() {
    }

    public /* synthetic */ WalletValidateCardNumberState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
