package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.CubicBezierEasing;
import androidx.compose.animation.core.Easing;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aG\u0010\u0007\u001a\u00020\b*\f\u0012\u0004\u0012\u00020\u0002\u0012\u0002\b\u00030\t2\u0006\u0010\n\u001a\u00020\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\fH@ø\u0001\u0001ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\"\u0017\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000\"\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000\"\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u0010"}, d2 = {"DefaultIncomingSpec", "Landroidx/compose/animation/core/TweenSpec;", "Landroidx/compose/ui/unit/Dp;", "DefaultOutgoingSpec", "HoveredOutgoingSpec", "OutgoingSpecEasing", "Landroidx/compose/animation/core/Easing;", "animateElevation", "", "Landroidx/compose/animation/core/Animatable;", "target", "from", "Landroidx/compose/foundation/interaction/Interaction;", "to", "animateElevation-rAjV9yQ", "(Landroidx/compose/animation/core/Animatable;FLandroidx/compose/foundation/interaction/Interaction;Landroidx/compose/foundation/interaction/Interaction;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "material3_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class ElevationKt {
    /* access modifiers changed from: private */
    @NotNull
    public static final TweenSpec<Dp> DefaultIncomingSpec = new TweenSpec(120, 0, EasingKt.getFastOutSlowInEasing(), 2, (DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @NotNull
    public static final TweenSpec<Dp> DefaultOutgoingSpec;
    /* access modifiers changed from: private */
    @NotNull
    public static final TweenSpec<Dp> HoveredOutgoingSpec;
    @NotNull
    private static final Easing OutgoingSpecEasing;

    static {
        CubicBezierEasing cubicBezierEasing = new CubicBezierEasing(0.4f, 0.0f, 0.6f, 1.0f);
        OutgoingSpecEasing = cubicBezierEasing;
        CubicBezierEasing cubicBezierEasing2 = cubicBezierEasing;
        DefaultOutgoingSpec = new TweenSpec(150, 0, cubicBezierEasing2, 2, (DefaultConstructorMarker) null);
        HoveredOutgoingSpec = new TweenSpec(120, 0, cubicBezierEasing2, 2, (DefaultConstructorMarker) null);
    }

    @Nullable
    /* renamed from: animateElevation-rAjV9yQ  reason: not valid java name */
    public static final Object m1659animateElevationrAjV9yQ(@NotNull Animatable<Dp, ?> animatable, float f11, @Nullable Interaction interaction, @Nullable Interaction interaction2, @NotNull Continuation<? super Unit> continuation) {
        AnimationSpec<Dp> animationSpec;
        if (interaction2 != null) {
            animationSpec = ElevationDefaults.INSTANCE.incomingAnimationSpecForInteraction(interaction2);
        } else if (interaction != null) {
            animationSpec = ElevationDefaults.INSTANCE.outgoingAnimationSpecForInteraction(interaction);
        } else {
            animationSpec = null;
        }
        AnimationSpec<Dp> animationSpec2 = animationSpec;
        if (animationSpec2 != null) {
            Object animateTo$default = Animatable.animateTo$default(animatable, Dp.m5476boximpl(f11), animationSpec2, (Object) null, (Function1) null, continuation, 12, (Object) null);
            if (animateTo$default == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                return animateTo$default;
            }
            return Unit.INSTANCE;
        }
        Object snapTo = animatable.snapTo(Dp.m5476boximpl(f11), continuation);
        if (snapTo == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return snapTo;
        }
        return Unit.INSTANCE;
    }

    /* renamed from: animateElevation-rAjV9yQ$default  reason: not valid java name */
    public static /* synthetic */ Object m1660animateElevationrAjV9yQ$default(Animatable animatable, float f11, Interaction interaction, Interaction interaction2, Continuation continuation, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            interaction = null;
        }
        if ((i11 & 4) != 0) {
            interaction2 = null;
        }
        return m1659animateElevationrAjV9yQ(animatable, f11, interaction, interaction2, continuation);
    }
}
