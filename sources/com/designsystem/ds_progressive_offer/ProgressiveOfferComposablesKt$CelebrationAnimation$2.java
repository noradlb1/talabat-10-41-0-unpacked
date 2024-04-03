package com.designsystem.ds_progressive_offer;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class ProgressiveOfferComposablesKt$CelebrationAnimation$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ boolean f32487g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Animatable<Float, AnimationVector1D> f32488h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Animatable<Float, AnimationVector1D> f32489i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f32490j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ProgressiveOfferComposablesKt$CelebrationAnimation$2(boolean z11, Animatable<Float, AnimationVector1D> animatable, Animatable<Float, AnimationVector1D> animatable2, int i11) {
        super(2);
        this.f32487g = z11;
        this.f32488h = animatable;
        this.f32489i = animatable2;
        this.f32490j = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        ProgressiveOfferComposablesKt.CelebrationAnimation(this.f32487g, this.f32488h, this.f32489i, composer, this.f32490j | 1);
    }
}
