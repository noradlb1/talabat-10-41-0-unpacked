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
public final class DSCollapsibleQuantityStepperKt$DSCollapsibleQuantityStepper$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f32793g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f32794h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f32795i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f32796j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function1<Integer, Unit> f32797k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ boolean f32798l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Alignment.Horizontal f32799m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ boolean f32800n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ boolean f32801o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ boolean f32802p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ int f32803q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ int f32804r;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSCollapsibleQuantityStepperKt$DSCollapsibleQuantityStepper$2(Modifier modifier, int i11, int i12, int i13, Function1<? super Integer, Unit> function1, boolean z11, Alignment.Horizontal horizontal, boolean z12, boolean z13, boolean z14, int i14, int i15) {
        super(2);
        this.f32793g = modifier;
        this.f32794h = i11;
        this.f32795i = i12;
        this.f32796j = i13;
        this.f32797k = function1;
        this.f32798l = z11;
        this.f32799m = horizontal;
        this.f32800n = z12;
        this.f32801o = z13;
        this.f32802p = z14;
        this.f32803q = i14;
        this.f32804r = i15;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        DSCollapsibleQuantityStepperKt.DSCollapsibleQuantityStepper(this.f32793g, this.f32794h, this.f32795i, this.f32796j, this.f32797k, this.f32798l, this.f32799m, this.f32800n, this.f32801o, this.f32802p, composer, this.f32803q | 1, this.f32804r);
    }
}
