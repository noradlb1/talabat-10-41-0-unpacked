package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class TabKt$TabTransition$color$2 extends Lambda implements Function3<Transition.Segment<Boolean>, Composer, Integer, FiniteAnimationSpec<Color>> {
    public static final TabKt$TabTransition$color$2 INSTANCE = new TabKt$TabTransition$color$2();

    public TabKt$TabTransition$color$2() {
        super(3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((Transition.Segment<Boolean>) (Transition.Segment) obj, (Composer) obj2, ((Number) obj3).intValue());
    }

    @NotNull
    @Composable
    public final FiniteAnimationSpec<Color> invoke(@NotNull Transition.Segment<Boolean> segment, @Nullable Composer composer, int i11) {
        TweenSpec tweenSpec;
        Intrinsics.checkNotNullParameter(segment, "$this$animateColor");
        composer.startReplaceableGroup(-2120892502);
        if (segment.isTransitioningTo(Boolean.FALSE, Boolean.TRUE)) {
            tweenSpec = AnimationSpecKt.tween(150, 100, EasingKt.getLinearEasing());
        } else {
            tweenSpec = AnimationSpecKt.tween$default(100, 0, EasingKt.getLinearEasing(), 2, (Object) null);
        }
        composer.endReplaceableGroup();
        return tweenSpec;
    }
}
