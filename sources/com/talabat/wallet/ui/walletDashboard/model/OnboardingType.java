package com.talabat.wallet.ui.walletDashboard.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0003\u0006\u0007\b¨\u0006\t"}, d2 = {"Lcom/talabat/wallet/ui/walletDashboard/model/OnboardingType;", "", "()V", "None", "WithTopUp", "WithoutTopUp", "Lcom/talabat/wallet/ui/walletDashboard/model/OnboardingType$WithTopUp;", "Lcom/talabat/wallet/ui/walletDashboard/model/OnboardingType$WithoutTopUp;", "Lcom/talabat/wallet/ui/walletDashboard/model/OnboardingType$None;", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class OnboardingType {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/wallet/ui/walletDashboard/model/OnboardingType$None;", "Lcom/talabat/wallet/ui/walletDashboard/model/OnboardingType;", "()V", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class None extends OnboardingType {
        @NotNull
        public static final None INSTANCE = new None();

        private None() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/wallet/ui/walletDashboard/model/OnboardingType$WithTopUp;", "Lcom/talabat/wallet/ui/walletDashboard/model/OnboardingType;", "()V", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class WithTopUp extends OnboardingType {
        @NotNull
        public static final WithTopUp INSTANCE = new WithTopUp();

        private WithTopUp() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/wallet/ui/walletDashboard/model/OnboardingType$WithoutTopUp;", "Lcom/talabat/wallet/ui/walletDashboard/model/OnboardingType;", "()V", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class WithoutTopUp extends OnboardingType {
        @NotNull
        public static final WithoutTopUp INSTANCE = new WithoutTopUp();

        private WithoutTopUp() {
            super((DefaultConstructorMarker) null);
        }
    }

    private OnboardingType() {
    }

    public /* synthetic */ OnboardingType(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
