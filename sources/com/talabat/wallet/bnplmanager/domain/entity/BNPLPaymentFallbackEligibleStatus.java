package com.talabat.wallet.bnplmanager.domain.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/wallet/bnplmanager/domain/entity/BNPLPaymentFallbackEligibleStatus;", "", "()V", "IsEligibleForBnplPaymentFallback", "NotEligibleForBnplPaymentFallback", "Lcom/talabat/wallet/bnplmanager/domain/entity/BNPLPaymentFallbackEligibleStatus$IsEligibleForBnplPaymentFallback;", "Lcom/talabat/wallet/bnplmanager/domain/entity/BNPLPaymentFallbackEligibleStatus$NotEligibleForBnplPaymentFallback;", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class BNPLPaymentFallbackEligibleStatus {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/wallet/bnplmanager/domain/entity/BNPLPaymentFallbackEligibleStatus$IsEligibleForBnplPaymentFallback;", "Lcom/talabat/wallet/bnplmanager/domain/entity/BNPLPaymentFallbackEligibleStatus;", "()V", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class IsEligibleForBnplPaymentFallback extends BNPLPaymentFallbackEligibleStatus {
        @NotNull
        public static final IsEligibleForBnplPaymentFallback INSTANCE = new IsEligibleForBnplPaymentFallback();

        private IsEligibleForBnplPaymentFallback() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/wallet/bnplmanager/domain/entity/BNPLPaymentFallbackEligibleStatus$NotEligibleForBnplPaymentFallback;", "Lcom/talabat/wallet/bnplmanager/domain/entity/BNPLPaymentFallbackEligibleStatus;", "()V", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class NotEligibleForBnplPaymentFallback extends BNPLPaymentFallbackEligibleStatus {
        @NotNull
        public static final NotEligibleForBnplPaymentFallback INSTANCE = new NotEligibleForBnplPaymentFallback();

        private NotEligibleForBnplPaymentFallback() {
            super((DefaultConstructorMarker) null);
        }
    }

    private BNPLPaymentFallbackEligibleStatus() {
    }

    public /* synthetic */ BNPLPaymentFallbackEligibleStatus(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
