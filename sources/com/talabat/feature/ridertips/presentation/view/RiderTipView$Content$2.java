package com.talabat.feature.ridertips.presentation.view;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class RiderTipView$Content$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ RiderTipView f58805g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f58806h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RiderTipView$Content$2(RiderTipView riderTipView, int i11) {
        super(2);
        this.f58805g = riderTipView;
        this.f58806h = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        this.f58805g.Content(composer, this.f58806h | 1);
    }
}
