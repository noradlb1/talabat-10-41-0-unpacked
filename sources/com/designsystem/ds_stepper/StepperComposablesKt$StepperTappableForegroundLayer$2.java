package com.designsystem.ds_stepper;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class StepperComposablesKt$StepperTappableForegroundLayer$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f32980g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ boolean f32981h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ StepperValues f32982i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ MM2Properties f32983j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f32984k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f32985l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ int f32986m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StepperComposablesKt$StepperTappableForegroundLayer$2(Modifier modifier, boolean z11, StepperValues stepperValues, MM2Properties mM2Properties, Function0<Unit> function0, Function0<Unit> function02, int i11) {
        super(2);
        this.f32980g = modifier;
        this.f32981h = z11;
        this.f32982i = stepperValues;
        this.f32983j = mM2Properties;
        this.f32984k = function0;
        this.f32985l = function02;
        this.f32986m = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        StepperComposablesKt.StepperTappableForegroundLayer(this.f32980g, this.f32981h, this.f32982i, this.f32983j, this.f32984k, this.f32985l, composer, this.f32986m | 1);
    }
}
