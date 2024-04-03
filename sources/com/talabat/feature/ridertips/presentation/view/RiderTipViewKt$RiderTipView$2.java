package com.talabat.feature.ridertips.presentation.view;

import androidx.compose.runtime.Composer;
import com.talabat.feature.ridertips.presentation.viewmodel.RiderTipViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class RiderTipViewKt$RiderTipView$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ RiderTipViewModel f58819g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f58820h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function1<Double, Unit> f58821i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f58822j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RiderTipViewKt$RiderTipView$2(RiderTipViewModel riderTipViewModel, Function0<Unit> function0, Function1<? super Double, Unit> function1, int i11) {
        super(2);
        this.f58819g = riderTipViewModel;
        this.f58820h = function0;
        this.f58821i = function1;
        this.f58822j = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        RiderTipViewKt.RiderTipView(this.f58819g, this.f58820h, this.f58821i, composer, this.f58822j | 1);
    }
}
