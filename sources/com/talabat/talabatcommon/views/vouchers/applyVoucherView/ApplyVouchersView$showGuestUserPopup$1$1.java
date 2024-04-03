package com.talabat.talabatcommon.views.vouchers.applyVoucherView;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class ApplyVouchersView$showGuestUserPopup$1$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ApplyVouchersView f11760g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ApplyVouchersView$showGuestUserPopup$1$1(ApplyVouchersView applyVouchersView) {
        super(0);
        this.f11760g = applyVouchersView;
    }

    public final void invoke() {
        ApplyVouchersViewCallback access$getCallback$p = this.f11760g.callback;
        if (access$getCallback$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callback");
            access$getCallback$p = null;
        }
        access$getCallback$p.redirectToLogin();
    }
}
