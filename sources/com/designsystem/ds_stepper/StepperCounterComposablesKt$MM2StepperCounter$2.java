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
public final class StepperCounterComposablesKt$MM2StepperCounter$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ BoxScope f33007g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ boolean f33008h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f33009i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ long f33010j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ long f33011k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ DSStepperStyle f33012l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ boolean f33013m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f33014n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ int f33015o;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StepperCounterComposablesKt$MM2StepperCounter$2(BoxScope boxScope, boolean z11, int i11, long j11, long j12, DSStepperStyle dSStepperStyle, boolean z12, Function0<Unit> function0, int i12) {
        super(2);
        this.f33007g = boxScope;
        this.f33008h = z11;
        this.f33009i = i11;
        this.f33010j = j11;
        this.f33011k = j12;
        this.f33012l = dSStepperStyle;
        this.f33013m = z12;
        this.f33014n = function0;
        this.f33015o = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        StepperCounterComposablesKt.m8618MM2StepperCountervRFhKjU(this.f33007g, this.f33008h, this.f33009i, this.f33010j, this.f33011k, this.f33012l, this.f33013m, this.f33014n, composer, this.f33015o | 1);
    }
}
