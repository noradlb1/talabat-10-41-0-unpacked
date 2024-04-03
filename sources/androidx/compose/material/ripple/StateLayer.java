package androidx.compose.material.ripple;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.foundation.interaction.DragInteraction;
import androidx.compose.foundation.interaction.FocusInteraction;
import androidx.compose.foundation.interaction.HoverInteraction;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import f0.b;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0014J'\u0010\u0015\u001a\u00020\u0011*\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001b\u0010\u001cR\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u000fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u001d"}, d2 = {"Landroidx/compose/material/ripple/StateLayer;", "", "bounded", "", "rippleAlpha", "Landroidx/compose/runtime/State;", "Landroidx/compose/material/ripple/RippleAlpha;", "(ZLandroidx/compose/runtime/State;)V", "animatedAlpha", "Landroidx/compose/animation/core/Animatable;", "", "Landroidx/compose/animation/core/AnimationVector1D;", "currentInteraction", "Landroidx/compose/foundation/interaction/Interaction;", "interactions", "", "handleInteraction", "", "interaction", "scope", "Lkotlinx/coroutines/CoroutineScope;", "drawStateLayer", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "radius", "Landroidx/compose/ui/unit/Dp;", "color", "Landroidx/compose/ui/graphics/Color;", "drawStateLayer-H2RKhps", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FJ)V", "material-ripple_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
final class StateLayer {
    /* access modifiers changed from: private */
    @NotNull
    public final Animatable<Float, AnimationVector1D> animatedAlpha = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, (Object) null);
    private final boolean bounded;
    @Nullable
    private Interaction currentInteraction;
    @NotNull
    private final List<Interaction> interactions = new ArrayList();
    @NotNull
    private final State<RippleAlpha> rippleAlpha;

    public StateLayer(boolean z11, @NotNull State<RippleAlpha> state) {
        Intrinsics.checkNotNullParameter(state, "rippleAlpha");
        this.bounded = z11;
        this.rippleAlpha = state;
    }

    /* renamed from: drawStateLayer-H2RKhps  reason: not valid java name */
    public final void m1489drawStateLayerH2RKhps(@NotNull DrawScope drawScope, float f11, long j11) {
        float f12;
        DrawScope drawScope2 = drawScope;
        Intrinsics.checkNotNullParameter(drawScope2, "$this$drawStateLayer");
        if (Float.isNaN(f11)) {
            f12 = RippleAnimationKt.m1479getRippleEndRadiuscSwnlzA(drawScope2, this.bounded, drawScope.m3425getSizeNHjbRc());
        } else {
            f12 = drawScope.m5447toPx0680j_4(f11);
        }
        float f13 = f12;
        float floatValue = this.animatedAlpha.getValue().floatValue();
        if (floatValue > 0.0f) {
            long r22 = Color.m2918copywmQWz5c$default(j11, floatValue, 0.0f, 0.0f, 0.0f, 14, (Object) null);
            if (this.bounded) {
                float r92 = Size.m2745getWidthimpl(drawScope.m3425getSizeNHjbRc());
                float r102 = Size.m2742getHeightimpl(drawScope.m3425getSizeNHjbRc());
                int r11 = ClipOp.Companion.m2908getIntersectrtfAjoo();
                DrawContext drawContext = drawScope.getDrawContext();
                long r14 = drawContext.m3403getSizeNHjbRc();
                drawContext.getCanvas().save();
                drawContext.getTransform().m3475clipRectN_I0leg(0.0f, 0.0f, r92, r102, r11);
                b.x(drawScope, r22, f13, 0, 0.0f, (DrawStyle) null, (ColorFilter) null, 0, 124, (Object) null);
                drawContext.getCanvas().restore();
                drawContext.m3404setSizeuvyYCjk(r14);
                return;
            }
            b.x(drawScope, r22, f13, 0, 0.0f, (DrawStyle) null, (ColorFilter) null, 0, 124, (Object) null);
        }
    }

    public final void handleInteraction(@NotNull Interaction interaction, @NotNull CoroutineScope coroutineScope) {
        float f11;
        Intrinsics.checkNotNullParameter(interaction, "interaction");
        Intrinsics.checkNotNullParameter(coroutineScope, "scope");
        boolean z11 = interaction instanceof HoverInteraction.Enter;
        if (z11) {
            this.interactions.add(interaction);
        } else if (interaction instanceof HoverInteraction.Exit) {
            this.interactions.remove(((HoverInteraction.Exit) interaction).getEnter());
        } else if (interaction instanceof FocusInteraction.Focus) {
            this.interactions.add(interaction);
        } else if (interaction instanceof FocusInteraction.Unfocus) {
            this.interactions.remove(((FocusInteraction.Unfocus) interaction).getFocus());
        } else if (interaction instanceof DragInteraction.Start) {
            this.interactions.add(interaction);
        } else if (interaction instanceof DragInteraction.Stop) {
            this.interactions.remove(((DragInteraction.Stop) interaction).getStart());
        } else if (interaction instanceof DragInteraction.Cancel) {
            this.interactions.remove(((DragInteraction.Cancel) interaction).getStart());
        } else {
            return;
        }
        Interaction interaction2 = (Interaction) CollectionsKt___CollectionsKt.lastOrNull(this.interactions);
        if (!Intrinsics.areEqual((Object) this.currentInteraction, (Object) interaction2)) {
            if (interaction2 != null) {
                if (z11) {
                    f11 = this.rippleAlpha.getValue().getHoveredAlpha();
                } else if (interaction instanceof FocusInteraction.Focus) {
                    f11 = this.rippleAlpha.getValue().getFocusedAlpha();
                } else if (interaction instanceof DragInteraction.Start) {
                    f11 = this.rippleAlpha.getValue().getDraggedAlpha();
                } else {
                    f11 = 0.0f;
                }
                Job unused = BuildersKt__Builders_commonKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new StateLayer$handleInteraction$1(this, f11, RippleKt.incomingStateLayerAnimationSpecFor(interaction2), (Continuation<? super StateLayer$handleInteraction$1>) null), 3, (Object) null);
            } else {
                Job unused2 = BuildersKt__Builders_commonKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new StateLayer$handleInteraction$2(this, RippleKt.outgoingStateLayerAnimationSpecFor(this.currentInteraction), (Continuation<? super StateLayer$handleInteraction$2>) null), 3, (Object) null);
            }
            this.currentInteraction = interaction2;
        }
    }
}
