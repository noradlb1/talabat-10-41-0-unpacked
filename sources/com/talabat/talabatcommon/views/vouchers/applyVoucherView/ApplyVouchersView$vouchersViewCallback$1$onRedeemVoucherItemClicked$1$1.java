package com.talabat.talabatcommon.views.vouchers.applyVoucherView;

import com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.VoucherDisplayModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class ApplyVouchersView$vouchersViewCallback$1$onRedeemVoucherItemClicked$1$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ApplyVouchersView f11764g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ VoucherDisplayModel f11765h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ApplyVouchersView$vouchersViewCallback$1$onRedeemVoucherItemClicked$1$1(ApplyVouchersView applyVouchersView, VoucherDisplayModel voucherDisplayModel) {
        super(0);
        this.f11764g = applyVouchersView;
        this.f11765h = voucherDisplayModel;
    }

    public final void invoke() {
        this.f11764g.redeemOption(this.f11765h);
    }
}
