package com.talabat.talabatcommon.views.wallet.walletPaymentOption.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0004\u0007\b\t\n¨\u0006\u000b"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/WalletThreeDSURLRedirectionState;", "", "()V", "Default", "RedirectionFailure", "SuccessWithTopUpVerification", "SuccessWithoutTopUpVerification", "Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/WalletThreeDSURLRedirectionState$Default;", "Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/WalletThreeDSURLRedirectionState$SuccessWithoutTopUpVerification;", "Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/WalletThreeDSURLRedirectionState$SuccessWithTopUpVerification;", "Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/WalletThreeDSURLRedirectionState$RedirectionFailure;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class WalletThreeDSURLRedirectionState {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/WalletThreeDSURLRedirectionState$Default;", "Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/WalletThreeDSURLRedirectionState;", "()V", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Default extends WalletThreeDSURLRedirectionState {
        @NotNull
        public static final Default INSTANCE = new Default();

        private Default() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/WalletThreeDSURLRedirectionState$RedirectionFailure;", "Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/WalletThreeDSURLRedirectionState;", "()V", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class RedirectionFailure extends WalletThreeDSURLRedirectionState {
        @NotNull
        public static final RedirectionFailure INSTANCE = new RedirectionFailure();

        private RedirectionFailure() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/WalletThreeDSURLRedirectionState$SuccessWithTopUpVerification;", "Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/WalletThreeDSURLRedirectionState;", "()V", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class SuccessWithTopUpVerification extends WalletThreeDSURLRedirectionState {
        @NotNull
        public static final SuccessWithTopUpVerification INSTANCE = new SuccessWithTopUpVerification();

        private SuccessWithTopUpVerification() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/WalletThreeDSURLRedirectionState$SuccessWithoutTopUpVerification;", "Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/WalletThreeDSURLRedirectionState;", "()V", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class SuccessWithoutTopUpVerification extends WalletThreeDSURLRedirectionState {
        @NotNull
        public static final SuccessWithoutTopUpVerification INSTANCE = new SuccessWithoutTopUpVerification();

        private SuccessWithoutTopUpVerification() {
            super((DefaultConstructorMarker) null);
        }
    }

    private WalletThreeDSURLRedirectionState() {
    }

    public /* synthetic */ WalletThreeDSURLRedirectionState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
