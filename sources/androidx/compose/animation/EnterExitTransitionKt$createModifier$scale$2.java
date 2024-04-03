package androidx.compose.animation;

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
public final class EnterExitTransitionKt$createModifier$scale$2 extends Lambda implements Function3<Transition.Segment<EnterExitState>, Composer, Integer, FiniteAnimationSpec<Float>> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ EnterTransition f1242g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ ExitTransition f1243h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EnterExitTransitionKt$createModifier$scale$2(EnterTransition enterTransition, ExitTransition exitTransition) {
        super(3);
        this.f1242g = enterTransition;
        this.f1243h = exitTransition;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((Transition.Segment<EnterExitState>) (Transition.Segment) obj, (Composer) obj2, ((Number) obj3).intValue());
    }

    @NotNull
    @Composable
    public final FiniteAnimationSpec<Float> invoke(@NotNull Transition.Segment<EnterExitState> segment, @Nullable Composer composer, int i11) {
        FiniteAnimationSpec<Float> finiteAnimationSpec;
        Intrinsics.checkNotNullParameter(segment, "$this$animateFloat");
        composer.startReplaceableGroup(-53984035);
        EnterExitState enterExitState = EnterExitState.PreEnter;
        EnterExitState enterExitState2 = EnterExitState.Visible;
        if (segment.isTransitioningTo(enterExitState, enterExitState2)) {
            Scale scale = this.f1242g.getData$animation_release().getScale();
            if (scale == null || (finiteAnimationSpec = scale.getAnimationSpec()) == null) {
                finiteAnimationSpec = EnterExitTransitionKt.DefaultAlphaAndScaleSpring;
            }
        } else if (segment.isTransitioningTo(enterExitState2, EnterExitState.PostExit)) {
            Scale scale2 = this.f1243h.getData$animation_release().getScale();
            if (scale2 == null || (finiteAnimationSpec = scale2.getAnimationSpec()) == null) {
                finiteAnimationSpec = EnterExitTransitionKt.DefaultAlphaAndScaleSpring;
            }
        } else {
            finiteAnimationSpec = EnterExitTransitionKt.DefaultAlphaAndScaleSpring;
        }
        composer.endReplaceableGroup();
        return finiteAnimationSpec;
    }
}
