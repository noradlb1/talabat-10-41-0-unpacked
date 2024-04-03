package com.talabat.wallet.knetStatusManager.presentation.displaymodel;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0004\u0007\b\t\n¨\u0006\u000b"}, d2 = {"Lcom/talabat/wallet/knetStatusManager/presentation/displaymodel/KNetStatusDisplayModel;", "", "()V", "Loading", "ShowDefaultPaymentScreen", "ShowKNetPaymentOption", "ShowKNetUnAvailableView", "Lcom/talabat/wallet/knetStatusManager/presentation/displaymodel/KNetStatusDisplayModel$Loading;", "Lcom/talabat/wallet/knetStatusManager/presentation/displaymodel/KNetStatusDisplayModel$ShowKNetPaymentOption;", "Lcom/talabat/wallet/knetStatusManager/presentation/displaymodel/KNetStatusDisplayModel$ShowKNetUnAvailableView;", "Lcom/talabat/wallet/knetStatusManager/presentation/displaymodel/KNetStatusDisplayModel$ShowDefaultPaymentScreen;", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class KNetStatusDisplayModel {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/wallet/knetStatusManager/presentation/displaymodel/KNetStatusDisplayModel$Loading;", "Lcom/talabat/wallet/knetStatusManager/presentation/displaymodel/KNetStatusDisplayModel;", "()V", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Loading extends KNetStatusDisplayModel {
        @NotNull
        public static final Loading INSTANCE = new Loading();

        private Loading() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/wallet/knetStatusManager/presentation/displaymodel/KNetStatusDisplayModel$ShowDefaultPaymentScreen;", "Lcom/talabat/wallet/knetStatusManager/presentation/displaymodel/KNetStatusDisplayModel;", "()V", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ShowDefaultPaymentScreen extends KNetStatusDisplayModel {
        @NotNull
        public static final ShowDefaultPaymentScreen INSTANCE = new ShowDefaultPaymentScreen();

        private ShowDefaultPaymentScreen() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/wallet/knetStatusManager/presentation/displaymodel/KNetStatusDisplayModel$ShowKNetPaymentOption;", "Lcom/talabat/wallet/knetStatusManager/presentation/displaymodel/KNetStatusDisplayModel;", "()V", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ShowKNetPaymentOption extends KNetStatusDisplayModel {
        @NotNull
        public static final ShowKNetPaymentOption INSTANCE = new ShowKNetPaymentOption();

        private ShowKNetPaymentOption() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/wallet/knetStatusManager/presentation/displaymodel/KNetStatusDisplayModel$ShowKNetUnAvailableView;", "Lcom/talabat/wallet/knetStatusManager/presentation/displaymodel/KNetStatusDisplayModel;", "()V", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ShowKNetUnAvailableView extends KNetStatusDisplayModel {
        @NotNull
        public static final ShowKNetUnAvailableView INSTANCE = new ShowKNetUnAvailableView();

        private ShowKNetUnAvailableView() {
            super((DefaultConstructorMarker) null);
        }
    }

    private KNetStatusDisplayModel() {
    }

    public /* synthetic */ KNetStatusDisplayModel(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
