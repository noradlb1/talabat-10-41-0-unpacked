package com.designsystem.ds_counter;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class CounterComposablesKt$CounterAnimation$4 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ CounterChange f30990g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Animatable<Dp, AnimationVector1D> f30991h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Animatable<Dp, AnimationVector1D> f30992i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ String f30993j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ float f30994k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ boolean f30995l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ int f30996m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CounterComposablesKt$CounterAnimation$4(CounterChange counterChange, Animatable<Dp, AnimationVector1D> animatable, Animatable<Dp, AnimationVector1D> animatable2, String str, float f11, boolean z11, int i11) {
        super(2);
        this.f30990g = counterChange;
        this.f30991h = animatable;
        this.f30992i = animatable2;
        this.f30993j = str;
        this.f30994k = f11;
        this.f30995l = z11;
        this.f30996m = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        CounterComposablesKt.m8318CounterAnimationFJfuzF0(this.f30990g, this.f30991h, this.f30992i, this.f30993j, this.f30994k, this.f30995l, composer, this.f30996m | 1);
    }
}
