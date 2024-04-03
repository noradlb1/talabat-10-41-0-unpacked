package com.skydoves.landscapist;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.Easing;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class CircularRevealedAnimationKt$circularReveal$radius$2 extends Lambda implements Function3<Transition.Segment<CircularRevealState>, Composer, Integer, FiniteAnimationSpec<Float>> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ int f52932g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CircularRevealedAnimationKt$circularReveal$radius$2(int i11) {
        super(3);
        this.f52932g = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((Transition.Segment<CircularRevealState>) (Transition.Segment) obj, (Composer) obj2, ((Number) obj3).intValue());
    }

    @NotNull
    @Composable
    public final FiniteAnimationSpec<Float> invoke(@NotNull Transition.Segment<CircularRevealState> segment, @Nullable Composer composer, int i11) {
        Intrinsics.checkNotNullParameter(segment, "$this$animateFloat");
        composer.startReplaceableGroup(-511059351);
        TweenSpec tween$default = AnimationSpecKt.tween$default(this.f52932g, 0, (Easing) null, 6, (Object) null);
        composer.endReplaceableGroup();
        return tween$default;
    }
}
