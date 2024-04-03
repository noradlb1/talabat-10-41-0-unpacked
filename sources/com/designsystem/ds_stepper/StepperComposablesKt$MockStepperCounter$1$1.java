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
public final class StepperComposablesKt$MockStepperCounter$1$1 extends Lambda implements Function1<Context, StepperCounterLayout> {
    public static final StepperComposablesKt$MockStepperCounter$1$1 INSTANCE = new StepperComposablesKt$MockStepperCounter$1$1();

    public StepperComposablesKt$MockStepperCounter$1$1() {
        super(1);
    }

    @NotNull
    public final StepperCounterLayout invoke(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new StepperCounterLayout(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
    }
}
