package com.talabat.talabatcommon.views.wallet.walletCardManagement.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0003\u0006\u0007\b¨\u0006\t"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/model/WalletValidateExpiryDateState;", "", "()V", "DefaultValidateExpiryDate", "FailureValidateExpiryDate", "SuccessValidateExpiryDate", "Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/model/WalletValidateExpiryDateState$DefaultValidateExpiryDate;", "Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/model/WalletValidateExpiryDateState$FailureValidateExpiryDate;", "Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/model/WalletValidateExpiryDateState$SuccessValidateExpiryDate;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class WalletValidateExpiryDateState {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/model/WalletValidateExpiryDateState$DefaultValidateExpiryDate;", "Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/model/WalletValidateExpiryDateState;", "()V", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultValidateExpiryDate extends WalletValidateExpiryDateState {
        @NotNull
        public static final DefaultValidateExpiryDate INSTANCE = new DefaultValidateExpiryDate();

        private DefaultValidateExpiryDate() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/model/WalletValidateExpiryDateState$FailureValidateExpiryDate;", "Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/model/WalletValidateExpiryDateState;", "errorState", "Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/model/WalletCardExpiryDateValidationErrorState;", "(Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/model/WalletCardExpiryDateValidationErrorState;)V", "getErrorState", "()Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/model/WalletCardExpiryDateValidationErrorState;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class FailureValidateExpiryDate extends WalletValidateExpiryDateState {
        @NotNull
        private final WalletCardExpiryDateValidationErrorState errorState;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public FailureValidateExpiryDate(@NotNull WalletCardExpiryDateValidationErrorState walletCardExpiryDateValidationErrorState) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(walletCardExpiryDateValidationErrorState, "errorState");
            this.errorState = walletCardExpiryDateValidationErrorState;
        }

        @NotNull
        public final WalletCardExpiryDateValidationErrorState getErrorState() {
            return this.errorState;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/model/WalletValidateExpiryDateState$SuccessValidateExpiryDate;", "Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/model/WalletValidateExpiryDateState;", "()V", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class SuccessValidateExpiryDate extends WalletValidateExpiryDateState {
        @NotNull
        public static final SuccessValidateExpiryDate INSTANCE = new SuccessValidateExpiryDate();

        private SuccessValidateExpiryDate() {
            super((DefaultConstructorMarker) null);
        }
    }

    private WalletValidateExpiryDateState() {
    }

    public /* synthetic */ WalletValidateExpiryDateState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
