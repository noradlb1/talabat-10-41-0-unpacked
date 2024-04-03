package androidx.compose.animation;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "Landroidx/compose/ui/unit/IntSize;", "Landroidx/compose/animation/core/Transition$Segment;", "Landroidx/compose/animation/EnterExitState;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class ExpandShrinkModifier$sizeTransitionSpec$1 extends Lambda implements Function1<Transition.Segment<EnterExitState>, FiniteAnimationSpec<IntSize>> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ExpandShrinkModifier f1267g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ExpandShrinkModifier$sizeTransitionSpec$1(ExpandShrinkModifier expandShrinkModifier) {
        super(1);
        this.f1267g = expandShrinkModifier;
    }

    @NotNull
    public final FiniteAnimationSpec<IntSize> invoke(@NotNull Transition.Segment<EnterExitState> segment) {
        Intrinsics.checkNotNullParameter(segment, "$this$null");
        EnterExitState enterExitState = EnterExitState.PreEnter;
        EnterExitState enterExitState2 = EnterExitState.Visible;
        FiniteAnimationSpec<IntSize> finiteAnimationSpec = null;
        if (segment.isTransitioningTo(enterExitState, enterExitState2)) {
            ChangeSize value = this.f1267g.getExpand().getValue();
            if (value != null) {
                finiteAnimationSpec = value.getAnimationSpec();
            }
        } else if (segment.isTransitioningTo(enterExitState2, EnterExitState.PostExit)) {
            ChangeSize value2 = this.f1267g.getShrink().getValue();
            if (value2 != null) {
                finiteAnimationSpec = value2.getAnimationSpec();
            }
        } else {
            finiteAnimationSpec = EnterExitTransitionKt.DefaultSizeAnimationSpec;
        }
        return finiteAnimationSpec == null ? EnterExitTransitionKt.DefaultSizeAnimationSpec : finiteAnimationSpec;
    }
}
