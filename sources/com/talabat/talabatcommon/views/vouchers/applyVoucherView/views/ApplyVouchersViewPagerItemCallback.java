package com.talabat.talabatcommon.views.vouchers.applyVoucherView.views;

import com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.VoucherDisplayModel;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\b"}, d2 = {"Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/views/ApplyVouchersViewPagerItemCallback;", "", "onApplyVoucherItemClicked", "", "model", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/VoucherDisplayModel;", "onRedeemVoucherItemClicked", "onRemoveVoucherItemClicked", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ApplyVouchersViewPagerItemCallback {
    void onApplyVoucherItemClicked(@NotNull VoucherDisplayModel voucherDisplayModel);

    void onRedeemVoucherItemClicked(@NotNull VoucherDisplayModel voucherDisplayModel);

    void onRemoveVoucherItemClicked(@NotNull VoucherDisplayModel voucherDisplayModel);
}
