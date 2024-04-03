package com.talabat.growth.ui.vouchers.list;

import com.talabat.growth.ui.vouchers.list.model.VoucherListDisplayModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class VouchersListFragment$observatory$1 extends FunctionReferenceImpl implements Function1<VoucherListDisplayModel, Unit> {
    public VouchersListFragment$observatory$1(Object obj) {
        super(1, obj, VouchersListFragment.class, "updateVoucherList", "updateVoucherList(Lcom/talabat/growth/ui/vouchers/list/model/VoucherListDisplayModel;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((VoucherListDisplayModel) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable VoucherListDisplayModel voucherListDisplayModel) {
        ((VouchersListFragment) this.receiver).updateVoucherList(voucherListDisplayModel);
    }
}
