package com.designsystem.ds_stepper;

import android.content.Context;
import android.util.AttributeSet;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class StepperCounterComposablesKt$MM1StepperCounter$1$2$1 extends Lambda implements Function1<Context, StepperCounterLayout> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ int f32996g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StepperCounterComposablesKt$MM1StepperCounter$1$2$1(int i11) {
        super(1);
        this.f32996g = i11;
    }

    @NotNull
    public final StepperCounterLayout invoke(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        StepperCounterLayout stepperCounterLayout = new StepperCounterLayout(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        stepperCounterLayout.setInitialValue(this.f32996g);
        return stepperCounterLayout;
    }
}
