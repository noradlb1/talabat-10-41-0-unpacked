package com.designsystem.ds_counter;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class CounterComposablesKt$CounterText$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ BoxWithConstraintsScope f31046g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Animatable<Dp, AnimationVector1D> f31047h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ String f31048i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ long f31049j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ TextStyle f31050k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ int f31051l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CounterComposablesKt$CounterText$2(BoxWithConstraintsScope boxWithConstraintsScope, Animatable<Dp, AnimationVector1D> animatable, String str, long j11, TextStyle textStyle, int i11) {
        super(2);
        this.f31046g = boxWithConstraintsScope;
        this.f31047h = animatable;
        this.f31048i = str;
        this.f31049j = j11;
        this.f31050k = textStyle;
        this.f31051l = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        CounterComposablesKt.m8327CounterTextww6aTOc(this.f31046g, this.f31047h, this.f31048i, this.f31049j, this.f31050k, composer, this.f31051l | 1);
    }
}
