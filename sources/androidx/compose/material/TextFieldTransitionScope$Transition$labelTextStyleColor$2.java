package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.Easing;
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
public final class TextFieldTransitionScope$Transition$labelTextStyleColor$2 extends Lambda implements Function3<Transition.Segment<InputPhase>, Composer, Integer, FiniteAnimationSpec<Color>> {
    public static final TextFieldTransitionScope$Transition$labelTextStyleColor$2 INSTANCE = new TextFieldTransitionScope$Transition$labelTextStyleColor$2();

    public TextFieldTransitionScope$Transition$labelTextStyleColor$2() {
        super(3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((Transition.Segment<InputPhase>) (Transition.Segment) obj, (Composer) obj2, ((Number) obj3).intValue());
    }

    @NotNull
    @Composable
    public final FiniteAnimationSpec<Color> invoke(@NotNull Transition.Segment<InputPhase> segment, @Nullable Composer composer, int i11) {
        Intrinsics.checkNotNullParameter(segment, "$this$animateColor");
        composer.startReplaceableGroup(-130058045);
        TweenSpec tween$default = AnimationSpecKt.tween$default(150, 0, (Easing) null, 6, (Object) null);
        composer.endReplaceableGroup();
        return tween$default;
    }
}
