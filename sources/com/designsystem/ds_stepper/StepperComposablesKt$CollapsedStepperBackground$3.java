package com.designsystem.ds_stepper;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class StepperComposablesKt$CollapsedStepperBackground$3 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ StepperValues f32832g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ DSStepperStyle f32833h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ long f32834i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ long f32835j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ MM2Properties f32836k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f32837l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f32838m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ int f32839n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StepperComposablesKt$CollapsedStepperBackground$3(StepperValues stepperValues, DSStepperStyle dSStepperStyle, long j11, long j12, MM2Properties mM2Properties, Function0<Unit> function0, Function0<Unit> function02, int i11) {
        super(2);
        this.f32832g = stepperValues;
        this.f32833h = dSStepperStyle;
        this.f32834i = j11;
        this.f32835j = j12;
        this.f32836k = mM2Properties;
        this.f32837l = function0;
        this.f32838m = function02;
        this.f32839n = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        StepperComposablesKt.m8593CollapsedStepperBackgroundY0xEhic(this.f32832g, this.f32833h, this.f32834i, this.f32835j, this.f32836k, this.f32837l, this.f32838m, composer, this.f32839n | 1);
    }
}
