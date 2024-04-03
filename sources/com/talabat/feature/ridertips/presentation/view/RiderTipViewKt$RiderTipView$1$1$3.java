package com.talabat.feature.ridertips.presentation.view;

import com.talabat.feature.ridertips.presentation.viewmodel.RiderTipViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class RiderTipViewKt$RiderTipView$1$1$3 extends Lambda implements Function1<String, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ RiderTipViewModel f58816g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RiderTipViewKt$RiderTipView$1$1$3(RiderTipViewModel riderTipViewModel) {
        super(1);
        this.f58816g = riderTipViewModel;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((String) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "it");
        this.f58816g.onTipCustomInputTextChange(str);
    }
}
