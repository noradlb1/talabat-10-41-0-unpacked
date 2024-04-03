package com.designsystem.ds_stepper;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class DSQuantityStepperKt$DSQuantityStepper$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f32817g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f32818h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f32819i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f32820j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function1<Integer, Unit> f32821k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ boolean f32822l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ boolean f32823m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ boolean f32824n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ boolean f32825o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ int f32826p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ int f32827q;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSQuantityStepperKt$DSQuantityStepper$2(Modifier modifier, int i11, int i12, int i13, Function1<? super Integer, Unit> function1, boolean z11, boolean z12, boolean z13, boolean z14, int i14, int i15) {
        super(2);
        this.f32817g = modifier;
        this.f32818h = i11;
        this.f32819i = i12;
        this.f32820j = i13;
        this.f32821k = function1;
        this.f32822l = z11;
        this.f32823m = z12;
        this.f32824n = z13;
        this.f32825o = z14;
        this.f32826p = i14;
        this.f32827q = i15;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        DSQuantityStepperKt.DSQuantityStepper(this.f32817g, this.f32818h, this.f32819i, this.f32820j, this.f32821k, this.f32822l, this.f32823m, this.f32824n, this.f32825o, composer, this.f32826p | 1, this.f32827q);
    }
}
