package com.designsystem.ds_stepper;

import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class StepperCounterComposablesKt$MM1StepperCounter$1$3$1 extends Lambda implements Function1<StepperCounterLayout, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ int f32997g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ long f32998h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StepperCounterComposablesKt$MM1StepperCounter$1$3$1(int i11, long j11) {
        super(1);
        this.f32997g = i11;
        this.f32998h = j11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((StepperCounterLayout) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull StepperCounterLayout stepperCounterLayout) {
        Intrinsics.checkNotNullParameter(stepperCounterLayout, "it");
        stepperCounterLayout.updateCounter(this.f32997g);
        stepperCounterLayout.m8623setColorY2TPw74(Color.m2909boximpl(this.f32998h));
    }
}
