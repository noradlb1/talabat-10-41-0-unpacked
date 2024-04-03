package com.talabat.talabatcommon.views.ridersTip.bottomSheet;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.talabat.talabatcommon.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class RiderTipFragment$showPaymentSuccessfulView$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ RiderTipFragment f11740g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RiderTipFragment$showPaymentSuccessfulView$1(RiderTipFragment riderTipFragment) {
        super(0);
        this.f11740g = riderTipFragment;
    }

    public final void invoke() {
        this.f11740g._$_findCachedViewById(R.id.riderBottomSheetSuccessView).setVisibility(0);
        ((ConstraintLayout) this.f11740g._$_findCachedViewById(R.id.container_all)).setVisibility(4);
        this.f11740g.hideProgress();
    }
}
