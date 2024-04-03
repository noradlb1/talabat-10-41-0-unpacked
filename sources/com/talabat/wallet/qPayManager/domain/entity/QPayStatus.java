package com.talabat.wallet.qPayManager.domain.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/wallet/qPayManager/domain/entity/QPayStatus;", "", "()V", "QPayIsAvailable", "QPayIsUnAvailable", "Lcom/talabat/wallet/qPayManager/domain/entity/QPayStatus$QPayIsAvailable;", "Lcom/talabat/wallet/qPayManager/domain/entity/QPayStatus$QPayIsUnAvailable;", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class QPayStatus {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/wallet/qPayManager/domain/entity/QPayStatus$QPayIsAvailable;", "Lcom/talabat/wallet/qPayManager/domain/entity/QPayStatus;", "()V", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class QPayIsAvailable extends QPayStatus {
        @NotNull
        public static final QPayIsAvailable INSTANCE = new QPayIsAvailable();

        private QPayIsAvailable() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/wallet/qPayManager/domain/entity/QPayStatus$QPayIsUnAvailable;", "Lcom/talabat/wallet/qPayManager/domain/entity/QPayStatus;", "()V", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class QPayIsUnAvailable extends QPayStatus {
        @NotNull
        public static final QPayIsUnAvailable INSTANCE = new QPayIsUnAvailable();

        private QPayIsUnAvailable() {
            super((DefaultConstructorMarker) null);
        }
    }

    private QPayStatus() {
    }

    public /* synthetic */ QPayStatus(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
