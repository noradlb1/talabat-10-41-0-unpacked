package com.talabat.feature.swimlanevoucherslist.data.datasource.mapper;

import com.talabat.feature.swimlanevoucherslist.data.model.QCSwimLaneVouchers;
import com.talabat.features.swimlanevoucherslist.domain.model.DiscountType;
import com.talabat.features.swimlanevoucherslist.domain.model.VoucherType;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028BX\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0018\u0010\u0005\u001a\u00020\u0006*\u00020\u00028BX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"discount", "Lcom/talabat/features/swimlanevoucherslist/domain/model/DiscountType;", "Lcom/talabat/feature/swimlanevoucherslist/data/model/QCSwimLaneVouchers;", "getDiscount", "(Lcom/talabat/feature/swimlanevoucherslist/data/model/QCSwimLaneVouchers;)Lcom/talabat/features/swimlanevoucherslist/domain/model/DiscountType;", "voucher", "Lcom/talabat/features/swimlanevoucherslist/domain/model/VoucherType;", "getVoucher", "(Lcom/talabat/feature/swimlanevoucherslist/data/model/QCSwimLaneVouchers;)Lcom/talabat/features/swimlanevoucherslist/domain/model/VoucherType;", "com_talabat_feature_customer-vouchers-swimlane_data_data"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class CustomerVoucherMapperKt {
    /* access modifiers changed from: private */
    public static final DiscountType getDiscount(QCSwimLaneVouchers qCSwimLaneVouchers) {
        DiscountType discountType;
        try {
            Result.Companion companion = Result.Companion;
            String discountType2 = qCSwimLaneVouchers.getDiscountType();
            if (discountType2 == null) {
                discountType2 = "";
            }
            discountType = Result.m6329constructorimpl(DiscountType.valueOf(discountType2));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            discountType = Result.m6329constructorimpl(ResultKt.createFailure(th2));
        }
        DiscountType discountType3 = DiscountType.UNDEFINED;
        if (Result.m6335isFailureimpl(discountType)) {
            discountType = discountType3;
        }
        return (DiscountType) discountType;
    }

    /* access modifiers changed from: private */
    public static final VoucherType getVoucher(QCSwimLaneVouchers qCSwimLaneVouchers) {
        VoucherType voucherType;
        try {
            Result.Companion companion = Result.Companion;
            String voucherType2 = qCSwimLaneVouchers.getVoucherType();
            if (voucherType2 == null) {
                voucherType2 = "";
            }
            voucherType = Result.m6329constructorimpl(VoucherType.valueOf(voucherType2));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            voucherType = Result.m6329constructorimpl(ResultKt.createFailure(th2));
        }
        VoucherType voucherType3 = VoucherType.UNDEFINED;
        if (Result.m6335isFailureimpl(voucherType)) {
            voucherType = voucherType3;
        }
        return (VoucherType) voucherType;
    }
}
