package com.designsystem.ds_stepper;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class StepperCounterComposablesKt$StepperCounter$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ boolean f33016g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f33017h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ long f33018i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ long f33019j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ DSStepperStyle f33020k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ MM2Properties f33021l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f33022m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ int f33023n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StepperCounterComposablesKt$StepperCounter$2(boolean z11, int i11, long j11, long j12, DSStepperStyle dSStepperStyle, MM2Properties mM2Properties, Function0<Unit> function0, int i12) {
        super(2);
        this.f33016g = z11;
        this.f33017h = i11;
        this.f33018i = j11;
        this.f33019j = j12;
        this.f33020k = dSStepperStyle;
        this.f33021l = mM2Properties;
        this.f33022m = function0;
        this.f33023n = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        StepperCounterComposablesKt.m8619StepperCounterY0xEhic(this.f33016g, this.f33017h, this.f33018i, this.f33019j, this.f33020k, this.f33021l, this.f33022m, composer, this.f33023n | 1);
    }
}
