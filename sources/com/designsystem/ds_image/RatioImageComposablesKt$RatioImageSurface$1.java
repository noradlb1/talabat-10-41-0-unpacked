package com.designsystem.ds_image;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class RatioImageComposablesKt$RatioImageSurface$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f31340g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ float f31341h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Color f31342i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Dp f31343j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f31344k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ int f31345l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RatioImageComposablesKt$RatioImageSurface$1(Modifier modifier, float f11, Color color, Dp dp2, Function2<? super Composer, ? super Integer, Unit> function2, int i11) {
        super(2);
        this.f31340g = modifier;
        this.f31341h = f11;
        this.f31342i = color;
        this.f31343j = dp2;
        this.f31344k = function2;
        this.f31345l = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        RatioImageComposablesKt.m8364RatioImageSurfaceyVuOV74(this.f31340g, this.f31341h, this.f31342i, this.f31343j, this.f31344k, composer, this.f31345l | 1);
    }
}
