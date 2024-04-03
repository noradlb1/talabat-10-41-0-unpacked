package com.designsystem.ds_stepper;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class StepperComposablesKt$StepperIconArea$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ int f32932g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ boolean f32933h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ float f32934i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ float f32935j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ boolean f32936k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ boolean f32937l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ DSStepperStyle f32938m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ int f32939n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StepperComposablesKt$StepperIconArea$1(int i11, boolean z11, float f11, float f12, boolean z12, boolean z13, DSStepperStyle dSStepperStyle, int i12) {
        super(2);
        this.f32932g = i11;
        this.f32933h = z11;
        this.f32934i = f11;
        this.f32935j = f12;
        this.f32936k = z12;
        this.f32937l = z13;
        this.f32938m = dSStepperStyle;
        this.f32939n = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        StepperComposablesKt.m8604StepperIconArea1yyLQnY(this.f32932g, this.f32933h, this.f32934i, this.f32935j, this.f32936k, this.f32937l, this.f32938m, composer, this.f32939n | 1);
    }
}
