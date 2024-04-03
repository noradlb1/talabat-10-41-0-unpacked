package JsonModels.Response;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0019\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001b¨\u0006\u001c"}, d2 = {"LJsonModels/Response/WalletTransactionTypes;", "", "value", "", "(Ljava/lang/String;ILjava/lang/Integer;)V", "getValue", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "PAID", "RECHARGE", "REFUNDORDER", "REFUNDCREDIT", "GIFTVOUCHERRECHARGE", "CREDITVOUCHER", "TALABATCREDIT", "CMSREFUND", "CMSCOMPENSATION", "CMSGIFT", "CASHBACK", "CREDITEXPIRED", "CASHBACKREVERSAL", "TALABATREWARDSCANCELLATION", "TALABATREWARDSLOYALITY", "TLIFE_SUBSCRIPTION", "TLIFE_CASH_PAYMENT", "RECEIVEDCREDIT", "RIDERTIP", "EMPLOYEE_GIFT_CREDIT", "com_talabat_core_legacy-models_legacy-models"}, k = 1, mv = {1, 6, 0}, xi = 48)
public enum WalletTransactionTypes {
    PAID(0),
    RECHARGE(1),
    REFUNDORDER(2),
    REFUNDCREDIT(3),
    GIFTVOUCHERRECHARGE(4),
    CREDITVOUCHER(5),
    TALABATCREDIT(6),
    CMSREFUND(7),
    CMSCOMPENSATION(8),
    CMSGIFT(9),
    CASHBACK(10),
    CREDITEXPIRED(11),
    CASHBACKREVERSAL(12),
    TALABATREWARDSCANCELLATION(13),
    TALABATREWARDSLOYALITY(14),
    TLIFE_SUBSCRIPTION(17),
    TLIFE_CASH_PAYMENT(18),
    RECEIVEDCREDIT(201),
    RIDERTIP(301),
    EMPLOYEE_GIFT_CREDIT(302);
    
    @Nullable
    private final Integer value;

    private WalletTransactionTypes(Integer num) {
        this.value = num;
    }

    @Nullable
    public final Integer getValue() {
        return this.value;
    }
}
