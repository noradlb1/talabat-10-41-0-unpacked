package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.Easing;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.state.ToggleableState;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class CheckboxKt$CheckboxImpl$checkDrawFraction$2 extends Lambda implements Function3<Transition.Segment<ToggleableState>, Composer, Integer, FiniteAnimationSpec<Float>> {
    public static final CheckboxKt$CheckboxImpl$checkDrawFraction$2 INSTANCE = new CheckboxKt$CheckboxImpl$checkDrawFraction$2();

    public CheckboxKt$CheckboxImpl$checkDrawFraction$2() {
        super(3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((Transition.Segment<ToggleableState>) (Transition.Segment) obj, (Composer) obj2, ((Number) obj3).intValue());
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @NotNull
    @Composable
    public final FiniteAnimationSpec<Float> invoke(@NotNull Transition.Segment<ToggleableState> segment, @Nullable Composer composer, int i11) {
        FiniteAnimationSpec<Float> finiteAnimationSpec;
        Intrinsics.checkNotNullParameter(segment, "$this$animateFloat");
        composer.startReplaceableGroup(-1707702900);
        ToggleableState initialState = segment.getInitialState();
        ToggleableState toggleableState = ToggleableState.Off;
        if (initialState == toggleableState) {
            finiteAnimationSpec = AnimationSpecKt.tween$default(100, 0, (Easing) null, 6, (Object) null);
        } else if (segment.getTargetState() == toggleableState) {
            finiteAnimationSpec = AnimationSpecKt.snap(100);
        } else {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 0.0f, (Object) null, 7, (Object) null);
        }
        composer.endReplaceableGroup();
        return finiteAnimationSpec;
    }
}
