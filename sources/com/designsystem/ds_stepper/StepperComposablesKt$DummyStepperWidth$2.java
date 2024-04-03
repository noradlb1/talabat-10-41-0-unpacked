package com.designsystem.ds_stepper;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class StepperComposablesKt$DummyStepperWidth$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ float f32840g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ float f32841h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f32842i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StepperComposablesKt$DummyStepperWidth$2(float f11, float f12, int i11) {
        super(2);
        this.f32840g = f11;
        this.f32841h = f12;
        this.f32842i = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        StepperComposablesKt.m8594DummyStepperWidthi1RSzL4(this.f32840g, this.f32841h, composer, this.f32842i | 1);
    }
}
