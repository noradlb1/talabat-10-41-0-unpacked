package com.talabat.wallet.qPayManager.presentation.displaymodel;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0003\u0006\u0007\b¨\u0006\t"}, d2 = {"Lcom/talabat/wallet/qPayManager/presentation/displaymodel/QPayStatusDisplayModel;", "", "()V", "HideQPayPaymentOption", "Loading", "ShowQPayPaymentOption", "Lcom/talabat/wallet/qPayManager/presentation/displaymodel/QPayStatusDisplayModel$ShowQPayPaymentOption;", "Lcom/talabat/wallet/qPayManager/presentation/displaymodel/QPayStatusDisplayModel$HideQPayPaymentOption;", "Lcom/talabat/wallet/qPayManager/presentation/displaymodel/QPayStatusDisplayModel$Loading;", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class QPayStatusDisplayModel {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/wallet/qPayManager/presentation/displaymodel/QPayStatusDisplayModel$HideQPayPaymentOption;", "Lcom/talabat/wallet/qPayManager/presentation/displaymodel/QPayStatusDisplayModel;", "()V", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class HideQPayPaymentOption extends QPayStatusDisplayModel {
        @NotNull
        public static final HideQPayPaymentOption INSTANCE = new HideQPayPaymentOption();

        private HideQPayPaymentOption() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/wallet/qPayManager/presentation/displaymodel/QPayStatusDisplayModel$Loading;", "Lcom/talabat/wallet/qPayManager/presentation/displaymodel/QPayStatusDisplayModel;", "()V", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Loading extends QPayStatusDisplayModel {
        @NotNull
        public static final Loading INSTANCE = new Loading();

        private Loading() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/wallet/qPayManager/presentation/displaymodel/QPayStatusDisplayModel$ShowQPayPaymentOption;", "Lcom/talabat/wallet/qPayManager/presentation/displaymodel/QPayStatusDisplayModel;", "()V", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ShowQPayPaymentOption extends QPayStatusDisplayModel {
        @NotNull
        public static final ShowQPayPaymentOption INSTANCE = new ShowQPayPaymentOption();

        private ShowQPayPaymentOption() {
            super((DefaultConstructorMarker) null);
        }
    }

    private QPayStatusDisplayModel() {
    }

    public /* synthetic */ QPayStatusDisplayModel(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
