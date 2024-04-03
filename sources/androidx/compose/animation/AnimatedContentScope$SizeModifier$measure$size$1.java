package androidx.compose.animation;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.runtime.State;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "Landroidx/compose/ui/unit/IntSize;", "S", "Landroidx/compose/animation/core/Transition$Segment;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class AnimatedContentScope$SizeModifier$measure$size$1 extends Lambda implements Function1<Transition.Segment<S>, FiniteAnimationSpec<IntSize>> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ AnimatedContentScope<S> f1097g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ AnimatedContentScope<S>.SizeModifier f1098h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AnimatedContentScope$SizeModifier$measure$size$1(AnimatedContentScope<S> animatedContentScope, AnimatedContentScope<S>.SizeModifier sizeModifier) {
        super(1);
        this.f1097g = animatedContentScope;
        this.f1098h = sizeModifier;
    }

    @NotNull
    public final FiniteAnimationSpec<IntSize> invoke(@NotNull Transition.Segment<S> segment) {
        FiniteAnimationSpec<IntSize> r52;
        Intrinsics.checkNotNullParameter(segment, "$this$animate");
        State state = this.f1097g.getTargetSizeMap$animation_release().get(segment.getInitialState());
        long r02 = state != null ? ((IntSize) state.getValue()).m5642unboximpl() : IntSize.Companion.m5643getZeroYbymL2g();
        State state2 = this.f1097g.getTargetSizeMap$animation_release().get(segment.getTargetState());
        long r22 = state2 != null ? ((IntSize) state2.getValue()).m5642unboximpl() : IntSize.Companion.m5643getZeroYbymL2g();
        SizeTransform value = this.f1098h.getSizeTransform().getValue();
        return (value == null || (r52 = value.m94createAnimationSpecTemP2vQ(r02, r22)) == null) ? AnimationSpecKt.spring$default(0.0f, 0.0f, (Object) null, 7, (Object) null) : r52;
    }
}
