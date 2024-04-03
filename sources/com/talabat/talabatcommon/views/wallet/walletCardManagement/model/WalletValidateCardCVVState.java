package com.talabat.talabatcommon.views.wallet.walletCardManagement.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0003\u0006\u0007\b¨\u0006\t"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/model/WalletValidateCardCVVState;", "", "()V", "DefaultValidateCVVState", "FailureValidateCVVState", "SuccessValidateCVVState", "Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/model/WalletValidateCardCVVState$DefaultValidateCVVState;", "Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/model/WalletValidateCardCVVState$FailureValidateCVVState;", "Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/model/WalletValidateCardCVVState$SuccessValidateCVVState;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class WalletValidateCardCVVState {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/model/WalletValidateCardCVVState$DefaultValidateCVVState;", "Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/model/WalletValidateCardCVVState;", "()V", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultValidateCVVState extends WalletValidateCardCVVState {
        @NotNull
        public static final DefaultValidateCVVState INSTANCE = new DefaultValidateCVVState();

        private DefaultValidateCVVState() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/model/WalletValidateCardCVVState$FailureValidateCVVState;", "Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/model/WalletValidateCardCVVState;", "()V", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class FailureValidateCVVState extends WalletValidateCardCVVState {
        @NotNull
        public static final FailureValidateCVVState INSTANCE = new FailureValidateCVVState();

        private FailureValidateCVVState() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/model/WalletValidateCardCVVState$SuccessValidateCVVState;", "Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/model/WalletValidateCardCVVState;", "()V", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class SuccessValidateCVVState extends WalletValidateCardCVVState {
        @NotNull
        public static final SuccessValidateCVVState INSTANCE = new SuccessValidateCVVState();

        private SuccessValidateCVVState() {
            super((DefaultConstructorMarker) null);
        }
    }

    private WalletValidateCardCVVState() {
    }

    public /* synthetic */ WalletValidateCardCVVState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
