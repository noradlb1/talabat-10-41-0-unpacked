package com.designsystem.ds_stepper;

import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class StepperCounterComposablesKt$MM1StepperCounter$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ BoxScope f32999g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ boolean f33000h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f33001i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ long f33002j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f33003k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ int f33004l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StepperCounterComposablesKt$MM1StepperCounter$2(BoxScope boxScope, boolean z11, int i11, long j11, Function0<Unit> function0, int i12) {
        super(2);
        this.f32999g = boxScope;
        this.f33000h = z11;
        this.f33001i = i11;
        this.f33002j = j11;
        this.f33003k = function0;
        this.f33004l = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        StepperCounterComposablesKt.m8617MM1StepperCounterww6aTOc(this.f32999g, this.f33000h, this.f33001i, this.f33002j, this.f33003k, composer, this.f33004l | 1);
    }
}
