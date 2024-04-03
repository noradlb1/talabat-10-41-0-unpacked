package com.talabat.wallet.payproxymanager.domain.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0003\u0006\u0007\b¨\u0006\t"}, d2 = {"Lcom/talabat/wallet/payproxymanager/domain/entity/PayProxyCVVResult;", "", "()V", "CVVIsUnAvailable", "CVVServerError", "CVVSuccessful", "Lcom/talabat/wallet/payproxymanager/domain/entity/PayProxyCVVResult$CVVSuccessful;", "Lcom/talabat/wallet/payproxymanager/domain/entity/PayProxyCVVResult$CVVIsUnAvailable;", "Lcom/talabat/wallet/payproxymanager/domain/entity/PayProxyCVVResult$CVVServerError;", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class PayProxyCVVResult {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/wallet/payproxymanager/domain/entity/PayProxyCVVResult$CVVIsUnAvailable;", "Lcom/talabat/wallet/payproxymanager/domain/entity/PayProxyCVVResult;", "()V", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class CVVIsUnAvailable extends PayProxyCVVResult {
        @NotNull
        public static final CVVIsUnAvailable INSTANCE = new CVVIsUnAvailable();

        private CVVIsUnAvailable() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/wallet/payproxymanager/domain/entity/PayProxyCVVResult$CVVServerError;", "Lcom/talabat/wallet/payproxymanager/domain/entity/PayProxyCVVResult;", "()V", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class CVVServerError extends PayProxyCVVResult {
        @NotNull
        public static final CVVServerError INSTANCE = new CVVServerError();

        private CVVServerError() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/wallet/payproxymanager/domain/entity/PayProxyCVVResult$CVVSuccessful;", "Lcom/talabat/wallet/payproxymanager/domain/entity/PayProxyCVVResult;", "()V", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class CVVSuccessful extends PayProxyCVVResult {
        @NotNull
        public static final CVVSuccessful INSTANCE = new CVVSuccessful();

        private CVVSuccessful() {
            super((DefaultConstructorMarker) null);
        }
    }

    private PayProxyCVVResult() {
    }

    public /* synthetic */ PayProxyCVVResult(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
