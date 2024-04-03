package androidx.compose.animation;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.Easing;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class AnimatedContentKt$AnimatedContent$1 extends Lambda implements Function1<AnimatedContentScope<S>, ContentTransform> {
    public static final AnimatedContentKt$AnimatedContent$1 INSTANCE = new AnimatedContentKt$AnimatedContent$1();

    public AnimatedContentKt$AnimatedContent$1() {
        super(1);
    }

    @NotNull
    public final ContentTransform invoke(@NotNull AnimatedContentScope<S> animatedContentScope) {
        Intrinsics.checkNotNullParameter(animatedContentScope, "$this$null");
        return AnimatedContentKt.with(EnterExitTransitionKt.fadeIn$default(AnimationSpecKt.tween$default(220, 90, (Easing) null, 4, (Object) null), 0.0f, 2, (Object) null).plus(EnterExitTransitionKt.m57scaleInL8ZKhE$default(AnimationSpecKt.tween$default(220, 90, (Easing) null, 4, (Object) null), 0.92f, 0, 4, (Object) null)), EnterExitTransitionKt.fadeOut$default(AnimationSpecKt.tween$default(90, 0, (Easing) null, 6, (Object) null), 0.0f, 2, (Object) null));
    }
}
