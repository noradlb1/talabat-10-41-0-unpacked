package com.talabat.talabatcommon.views.vouchers.applyVoucherView;

import com.talabat.talabatcommon.views.vouchers.applyVoucherView.viewModel.ApplyVouchersViewStates;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class ApplyVouchersView$observatory$1$2 extends FunctionReferenceImpl implements Function1<ApplyVouchersViewStates, Unit> {
    public ApplyVouchersView$observatory$1$2(Object obj) {
        super(1, obj, ApplyVouchersView.class, "render", "render(Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/viewModel/ApplyVouchersViewStates;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ApplyVouchersViewStates) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable ApplyVouchersViewStates applyVouchersViewStates) {
        ((ApplyVouchersView) this.receiver).render(applyVouchersViewStates);
    }
}
