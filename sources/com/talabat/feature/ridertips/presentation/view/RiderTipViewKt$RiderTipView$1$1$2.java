package com.talabat.feature.ridertips.presentation.view;

import com.talabat.feature.ridertips.presentation.viewmodel.RiderTipViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class RiderTipViewKt$RiderTipView$1$1$2 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ RiderTipViewModel f58815g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RiderTipViewKt$RiderTipView$1$1$2(RiderTipViewModel riderTipViewModel) {
        super(0);
        this.f58815g = riderTipViewModel;
    }

    public final void invoke() {
        this.f58815g.onReuseTipTap();
    }
}
