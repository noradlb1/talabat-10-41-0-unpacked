package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class TextFieldTransitionScope$Transition$placeholderOpacity$2 extends Lambda implements Function3<Transition.Segment<InputPhase>, Composer, Integer, FiniteAnimationSpec<Float>> {
    public static final TextFieldTransitionScope$Transition$placeholderOpacity$2 INSTANCE = new TextFieldTransitionScope$Transition$placeholderOpacity$2();

    public TextFieldTransitionScope$Transition$placeholderOpacity$2() {
        super(3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((Transition.Segment<InputPhase>) (Transition.Segment) obj, (Composer) obj2, ((Number) obj3).intValue());
    }

    @NotNull
    @Composable
    public final FiniteAnimationSpec<Float> invoke(@NotNull Transition.Segment<InputPhase> segment, @Nullable Composer composer, int i11) {
        FiniteAnimationSpec<Float> finiteAnimationSpec;
        Intrinsics.checkNotNullParameter(segment, "$this$animateFloat");
        composer.startReplaceableGroup(-1079955085);
        InputPhase inputPhase = InputPhase.Focused;
        InputPhase inputPhase2 = InputPhase.UnfocusedEmpty;
        if (segment.isTransitioningTo(inputPhase, inputPhase2)) {
            finiteAnimationSpec = AnimationSpecKt.tween$default(67, 0, EasingKt.getLinearEasing(), 2, (Object) null);
        } else if (segment.isTransitioningTo(inputPhase2, inputPhase) || segment.isTransitioningTo(InputPhase.UnfocusedNotEmpty, inputPhase2)) {
            finiteAnimationSpec = AnimationSpecKt.tween(83, 67, EasingKt.getLinearEasing());
        } else {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 0.0f, (Object) null, 7, (Object) null);
        }
        composer.endReplaceableGroup();
        return finiteAnimationSpec;
    }
}
