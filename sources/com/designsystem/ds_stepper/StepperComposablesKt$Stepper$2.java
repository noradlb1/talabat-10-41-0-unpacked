package com.designsystem.ds_stepper;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class StepperComposablesKt$Stepper$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f32915g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f32916h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f32917i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f32918j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function1<Integer, Unit> f32919k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ boolean f32920l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Alignment.Horizontal f32921m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ boolean f32922n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ boolean f32923o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ boolean f32924p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ DSStepperStyle f32925q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ boolean f32926r;

    /* renamed from: s  reason: collision with root package name */
    public final /* synthetic */ int f32927s;

    /* renamed from: t  reason: collision with root package name */
    public final /* synthetic */ int f32928t;

    /* renamed from: u  reason: collision with root package name */
    public final /* synthetic */ int f32929u;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StepperComposablesKt$Stepper$2(Modifier modifier, int i11, int i12, int i13, Function1<? super Integer, Unit> function1, boolean z11, Alignment.Horizontal horizontal, boolean z12, boolean z13, boolean z14, DSStepperStyle dSStepperStyle, boolean z15, int i14, int i15, int i16) {
        super(2);
        this.f32915g = modifier;
        this.f32916h = i11;
        this.f32917i = i12;
        this.f32918j = i13;
        this.f32919k = function1;
        this.f32920l = z11;
        this.f32921m = horizontal;
        this.f32922n = z12;
        this.f32923o = z13;
        this.f32924p = z14;
        this.f32925q = dSStepperStyle;
        this.f32926r = z15;
        this.f32927s = i14;
        this.f32928t = i15;
        this.f32929u = i16;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        StepperComposablesKt.Stepper(this.f32915g, this.f32916h, this.f32917i, this.f32918j, this.f32919k, this.f32920l, this.f32921m, this.f32922n, this.f32923o, this.f32924p, this.f32925q, this.f32926r, composer, this.f32927s | 1, this.f32928t, this.f32929u);
    }
}
