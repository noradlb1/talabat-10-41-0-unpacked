package com.talabat.wallet.checkoutpaymentmanager.presentation.displaymodel;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\u0003\u0004\u0005\u0006\u0007B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0005\b\t\n\u000b\f¨\u0006\r"}, d2 = {"Lcom/talabat/wallet/checkoutpaymentmanager/presentation/displaymodel/WalletBalanceDisplayModel;", "", "()V", "HideWalletBalance", "LoadingWalletBalance", "ShowDefaultState", "ShowPaymentMethods", "ShowWalletBalance", "Lcom/talabat/wallet/checkoutpaymentmanager/presentation/displaymodel/WalletBalanceDisplayModel$ShowWalletBalance;", "Lcom/talabat/wallet/checkoutpaymentmanager/presentation/displaymodel/WalletBalanceDisplayModel$LoadingWalletBalance;", "Lcom/talabat/wallet/checkoutpaymentmanager/presentation/displaymodel/WalletBalanceDisplayModel$ShowDefaultState;", "Lcom/talabat/wallet/checkoutpaymentmanager/presentation/displaymodel/WalletBalanceDisplayModel$HideWalletBalance;", "Lcom/talabat/wallet/checkoutpaymentmanager/presentation/displaymodel/WalletBalanceDisplayModel$ShowPaymentMethods;", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class WalletBalanceDisplayModel {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/wallet/checkoutpaymentmanager/presentation/displaymodel/WalletBalanceDisplayModel$HideWalletBalance;", "Lcom/talabat/wallet/checkoutpaymentmanager/presentation/displaymodel/WalletBalanceDisplayModel;", "()V", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class HideWalletBalance extends WalletBalanceDisplayModel {
        @NotNull
        public static final HideWalletBalance INSTANCE = new HideWalletBalance();

        private HideWalletBalance() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/wallet/checkoutpaymentmanager/presentation/displaymodel/WalletBalanceDisplayModel$LoadingWalletBalance;", "Lcom/talabat/wallet/checkoutpaymentmanager/presentation/displaymodel/WalletBalanceDisplayModel;", "()V", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class LoadingWalletBalance extends WalletBalanceDisplayModel {
        @NotNull
        public static final LoadingWalletBalance INSTANCE = new LoadingWalletBalance();

        private LoadingWalletBalance() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/wallet/checkoutpaymentmanager/presentation/displaymodel/WalletBalanceDisplayModel$ShowDefaultState;", "Lcom/talabat/wallet/checkoutpaymentmanager/presentation/displaymodel/WalletBalanceDisplayModel;", "()V", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ShowDefaultState extends WalletBalanceDisplayModel {
        @NotNull
        public static final ShowDefaultState INSTANCE = new ShowDefaultState();

        private ShowDefaultState() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/wallet/checkoutpaymentmanager/presentation/displaymodel/WalletBalanceDisplayModel$ShowPaymentMethods;", "Lcom/talabat/wallet/checkoutpaymentmanager/presentation/displaymodel/WalletBalanceDisplayModel;", "()V", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ShowPaymentMethods extends WalletBalanceDisplayModel {
        @NotNull
        public static final ShowPaymentMethods INSTANCE = new ShowPaymentMethods();

        private ShowPaymentMethods() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/wallet/checkoutpaymentmanager/presentation/displaymodel/WalletBalanceDisplayModel$ShowWalletBalance;", "Lcom/talabat/wallet/checkoutpaymentmanager/presentation/displaymodel/WalletBalanceDisplayModel;", "balance", "", "(F)V", "getBalance", "()F", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ShowWalletBalance extends WalletBalanceDisplayModel {
        private final float balance;

        public ShowWalletBalance(float f11) {
            super((DefaultConstructorMarker) null);
            this.balance = f11;
        }

        public final float getBalance() {
            return this.balance;
        }
    }

    private WalletBalanceDisplayModel() {
    }

    public /* synthetic */ WalletBalanceDisplayModel(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
