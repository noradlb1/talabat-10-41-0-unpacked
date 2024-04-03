package com.talabat.wallet.ui.walletTransactionDetail.model;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u001b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001d¨\u0006\u001e"}, d2 = {"Lcom/talabat/wallet/ui/walletTransactionDetail/model/WalletTransactionType;", "", "value", "", "(Ljava/lang/String;ILjava/lang/Integer;)V", "getValue", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "DEFAULT", "PAID", "RECHARGE", "REFUND_ORDER", "REFUND_CREDIT", "GIFT_VOUCHER_RECHARGE", "CREDIT_VOUCHER", "TALABAT_CREDIT", "CMS_REFUND", "CMS_COMPENSATION", "CMS_GIFT", "CASH_BACK", "CREDIT_EXPIRED", "CASH_BACK_REVERSAL", "TALABAT_REWARDS_CANCELLATION", "TALABAT_REWARDS_LOYALTY", "T_LIFE_SUBSCRIPTION", "T_LIFE_CASH_PAYMENT", "RECEIVED_CREDIT", "RIDER_TIP", "EMPLOYEE_GIFT_CREDIT", "REFUND_SENT", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public enum WalletTransactionType {
    DEFAULT(-1),
    PAID(0),
    RECHARGE(1),
    REFUND_ORDER(2),
    REFUND_CREDIT(3),
    GIFT_VOUCHER_RECHARGE(4),
    CREDIT_VOUCHER(5),
    TALABAT_CREDIT(6),
    CMS_REFUND(7),
    CMS_COMPENSATION(8),
    CMS_GIFT(9),
    CASH_BACK(10),
    CREDIT_EXPIRED(11),
    CASH_BACK_REVERSAL(12),
    TALABAT_REWARDS_CANCELLATION(13),
    TALABAT_REWARDS_LOYALTY(14),
    T_LIFE_SUBSCRIPTION(17),
    T_LIFE_CASH_PAYMENT(18),
    RECEIVED_CREDIT(201),
    RIDER_TIP(301),
    EMPLOYEE_GIFT_CREDIT(302),
    REFUND_SENT(19);
    
    @Nullable
    private final Integer value;

    private WalletTransactionType(Integer num) {
        this.value = num;
    }

    @Nullable
    public final Integer getValue() {
        return this.value;
    }
}
