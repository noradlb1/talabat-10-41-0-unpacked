package com.talabat.feature.ridertips.presentation.view;

import com.talabat.feature.ridertips.presentation.viewmodel.RiderTipViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class RiderTipViewKt$RiderTipView$1$1$1 extends Lambda implements Function2<Integer, Boolean, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ RiderTipViewModel f58814g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RiderTipViewKt$RiderTipView$1$1$1(RiderTipViewModel riderTipViewModel) {
        super(2);
        this.f58814g = riderTipViewModel;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke(((Number) obj).intValue(), ((Boolean) obj2).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i11, boolean z11) {
        this.f58814g.onTipOptionTap(i11, z11);
    }
}
