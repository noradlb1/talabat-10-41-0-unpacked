package com.talabat.wallet.walletbalance.domain.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/wallet/walletbalance/domain/entity/WalletBalanceResult;", "", "()V", "WalletBalanceFailure", "WalletBalanceSuccess", "Lcom/talabat/wallet/walletbalance/domain/entity/WalletBalanceResult$WalletBalanceSuccess;", "Lcom/talabat/wallet/walletbalance/domain/entity/WalletBalanceResult$WalletBalanceFailure;", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class WalletBalanceResult {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/wallet/walletbalance/domain/entity/WalletBalanceResult$WalletBalanceFailure;", "Lcom/talabat/wallet/walletbalance/domain/entity/WalletBalanceResult;", "()V", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class WalletBalanceFailure extends WalletBalanceResult {
        @NotNull
        public static final WalletBalanceFailure INSTANCE = new WalletBalanceFailure();

        private WalletBalanceFailure() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/wallet/walletbalance/domain/entity/WalletBalanceResult$WalletBalanceSuccess;", "Lcom/talabat/wallet/walletbalance/domain/entity/WalletBalanceResult;", "balanceAmount", "", "(F)V", "getBalanceAmount", "()F", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class WalletBalanceSuccess extends WalletBalanceResult {
        private final float balanceAmount;

        public WalletBalanceSuccess(float f11) {
            super((DefaultConstructorMarker) null);
            this.balanceAmount = f11;
        }

        public final float getBalanceAmount() {
            return this.balanceAmount;
        }
    }

    private WalletBalanceResult() {
    }

    public /* synthetic */ WalletBalanceResult(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
