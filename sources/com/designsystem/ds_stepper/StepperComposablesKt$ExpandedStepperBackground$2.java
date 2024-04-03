package com.designsystem.ds_stepper;

import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class StepperComposablesKt$ExpandedStepperBackground$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ BoxWithConstraintsScope f32843g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ StepperValues f32844h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ DSStepperStyle f32845i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ long f32846j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ long f32847k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ MM2Properties f32848l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ boolean f32849m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ int f32850n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StepperComposablesKt$ExpandedStepperBackground$2(BoxWithConstraintsScope boxWithConstraintsScope, StepperValues stepperValues, DSStepperStyle dSStepperStyle, long j11, long j12, MM2Properties mM2Properties, boolean z11, int i11) {
        super(2);
        this.f32843g = boxWithConstraintsScope;
        this.f32844h = stepperValues;
        this.f32845i = dSStepperStyle;
        this.f32846j = j11;
        this.f32847k = j12;
        this.f32848l = mM2Properties;
        this.f32849m = z11;
        this.f32850n = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        StepperComposablesKt.m8595ExpandedStepperBackgroundjB83MbM(this.f32843g, this.f32844h, this.f32845i, this.f32846j, this.f32847k, this.f32848l, this.f32849m, composer, this.f32850n | 1);
    }
}
