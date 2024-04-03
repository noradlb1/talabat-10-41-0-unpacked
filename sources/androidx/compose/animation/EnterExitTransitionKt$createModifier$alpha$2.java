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
public final class EnterExitTransitionKt$createModifier$alpha$2 extends Lambda implements Function3<Transition.Segment<EnterExitState>, Composer, Integer, FiniteAnimationSpec<Float>> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ EnterTransition f1240g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ ExitTransition f1241h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EnterExitTransitionKt$createModifier$alpha$2(EnterTransition enterTransition, ExitTransition exitTransition) {
        super(3);
        this.f1240g = enterTransition;
        this.f1241h = exitTransition;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((Transition.Segment<EnterExitState>) (Transition.Segment) obj, (Composer) obj2, ((Number) obj3).intValue());
    }

    @NotNull
    @Composable
    public final FiniteAnimationSpec<Float> invoke(@NotNull Transition.Segment<EnterExitState> segment, @Nullable Composer composer, int i11) {
        FiniteAnimationSpec<Float> finiteAnimationSpec;
        Intrinsics.checkNotNullParameter(segment, "$this$animateFloat");
        composer.startReplaceableGroup(-57153604);
        EnterExitState enterExitState = EnterExitState.PreEnter;
        EnterExitState enterExitState2 = EnterExitState.Visible;
        if (segment.isTransitioningTo(enterExitState, enterExitState2)) {
            Fade fade = this.f1240g.getData$animation_release().getFade();
            if (fade == null || (finiteAnimationSpec = fade.getAnimationSpec()) == null) {
                finiteAnimationSpec = EnterExitTransitionKt.DefaultAlphaAndScaleSpring;
            }
        } else if (segment.isTransitioningTo(enterExitState2, EnterExitState.PostExit)) {
            Fade fade2 = this.f1241h.getData$animation_release().getFade();
            if (fade2 == null || (finiteAnimationSpec = fade2.getAnimationSpec()) == null) {
                finiteAnimationSpec = EnterExitTransitionKt.DefaultAlphaAndScaleSpring;
            }
        } else {
            finiteAnimationSpec = EnterExitTransitionKt.DefaultAlphaAndScaleSpring;
        }
        composer.endReplaceableGroup();
        return finiteAnimationSpec;
    }
}
