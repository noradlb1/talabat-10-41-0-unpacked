package com.designsystem.ds_stepper;

import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Alignment;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class StepperComposablesKt$StepperStaticIconsBackgroundLayer$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ BoxWithConstraintsScope f32965g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Alignment.Horizontal f32966h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ MM2Properties f32967i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ DSStepperStyle f32968j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ long f32969k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ boolean f32970l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ StepperValues f32971m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ long f32972n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ boolean f32973o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f32974p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f32975q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ int f32976r;

    /* renamed from: s  reason: collision with root package name */
    public final /* synthetic */ int f32977s;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StepperComposablesKt$StepperStaticIconsBackgroundLayer$2(BoxWithConstraintsScope boxWithConstraintsScope, Alignment.Horizontal horizontal, MM2Properties mM2Properties, DSStepperStyle dSStepperStyle, long j11, boolean z11, StepperValues stepperValues, long j12, boolean z12, Function0<Unit> function0, Function0<Unit> function02, int i11, int i12) {
        super(2);
        this.f32965g = boxWithConstraintsScope;
        this.f32966h = horizontal;
        this.f32967i = mM2Properties;
        this.f32968j = dSStepperStyle;
        this.f32969k = j11;
        this.f32970l = z11;
        this.f32971m = stepperValues;
        this.f32972n = j12;
        this.f32973o = z12;
        this.f32974p = function0;
        this.f32975q = function02;
        this.f32976r = i11;
        this.f32977s = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        StepperComposablesKt.m8605StepperStaticIconsBackgroundLayerDTdxfFs(this.f32965g, this.f32966h, this.f32967i, this.f32968j, this.f32969k, this.f32970l, this.f32971m, this.f32972n, this.f32973o, this.f32974p, this.f32975q, composer, this.f32976r | 1, this.f32977s);
    }
}
