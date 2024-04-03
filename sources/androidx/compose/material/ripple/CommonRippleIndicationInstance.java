package androidx.compose.material.ripple;

import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.runtime.RememberObserver;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.snapshots.SnapshotStateMap;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B4\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\bø\u0001\u0000¢\u0006\u0002\u0010\fJ\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0013H\u0016J\b\u0010\u0018\u001a\u00020\u0013H\u0016J\b\u0010\u0019\u001a\u00020\u0013H\u0016J\u0010\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0010H\u0016J\f\u0010\u001b\u001a\u00020\u0013*\u00020\u001cH\u0016J!\u0010\u001d\u001a\u00020\u0013*\u00020\u001e2\u0006\u0010\u0007\u001a\u00020\tH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001f\u0010 R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000R\u0019\u0010\u0005\u001a\u00020\u0006X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\rR\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\bX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000fX\u0004¢\u0006\u0002\n\u0000\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006!"}, d2 = {"Landroidx/compose/material/ripple/CommonRippleIndicationInstance;", "Landroidx/compose/material/ripple/RippleIndicationInstance;", "Landroidx/compose/runtime/RememberObserver;", "bounded", "", "radius", "Landroidx/compose/ui/unit/Dp;", "color", "Landroidx/compose/runtime/State;", "Landroidx/compose/ui/graphics/Color;", "rippleAlpha", "Landroidx/compose/material/ripple/RippleAlpha;", "(ZFLandroidx/compose/runtime/State;Landroidx/compose/runtime/State;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "F", "ripples", "Landroidx/compose/runtime/snapshots/SnapshotStateMap;", "Landroidx/compose/foundation/interaction/PressInteraction$Press;", "Landroidx/compose/material/ripple/RippleAnimation;", "addRipple", "", "interaction", "scope", "Lkotlinx/coroutines/CoroutineScope;", "onAbandoned", "onForgotten", "onRemembered", "removeRipple", "drawIndication", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "drawRipples", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "drawRipples-4WTKRHQ", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;J)V", "material-ripple_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CommonRippleIndicationInstance extends RippleIndicationInstance implements RememberObserver {
    private final boolean bounded;
    @NotNull
    private final State<Color> color;
    private final float radius;
    @NotNull
    private final State<RippleAlpha> rippleAlpha;
    /* access modifiers changed from: private */
    @NotNull
    public final SnapshotStateMap<PressInteraction.Press, RippleAnimation> ripples;

    private CommonRippleIndicationInstance(boolean z11, float f11, State<Color> state, State<RippleAlpha> state2) {
        super(z11, state2);
        this.bounded = z11;
        this.radius = f11;
        this.color = state;
        this.rippleAlpha = state2;
        this.ripples = SnapshotStateKt.mutableStateMapOf();
    }

    public /* synthetic */ CommonRippleIndicationInstance(boolean z11, float f11, State state, State state2, DefaultConstructorMarker defaultConstructorMarker) {
        this(z11, f11, state, state2);
    }

    /* renamed from: drawRipples-4WTKRHQ  reason: not valid java name */
    private final void m1474drawRipples4WTKRHQ(DrawScope drawScope, long j11) {
        boolean z11;
        for (Map.Entry<PressInteraction.Press, RippleAnimation> value : this.ripples.entrySet()) {
            RippleAnimation rippleAnimation = (RippleAnimation) value.getValue();
            float pressedAlpha = this.rippleAlpha.getValue().getPressedAlpha();
            if (pressedAlpha == 0.0f) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (!z11) {
                rippleAnimation.m1478draw4WTKRHQ(drawScope, Color.m2918copywmQWz5c$default(j11, pressedAlpha, 0.0f, 0.0f, 0.0f, 14, (Object) null));
            }
        }
    }

    public void addRipple(@NotNull PressInteraction.Press press, @NotNull CoroutineScope coroutineScope) {
        Offset offset;
        Intrinsics.checkNotNullParameter(press, "interaction");
        Intrinsics.checkNotNullParameter(coroutineScope, "scope");
        for (Map.Entry<PressInteraction.Press, RippleAnimation> value : this.ripples.entrySet()) {
            ((RippleAnimation) value.getValue()).finish();
        }
        if (this.bounded) {
            offset = Offset.m2665boximpl(press.m367getPressPositionF1C5BW0());
        } else {
            offset = null;
        }
        RippleAnimation rippleAnimation = new RippleAnimation(offset, this.radius, this.bounded, (DefaultConstructorMarker) null);
        this.ripples.put(press, rippleAnimation);
        Job unused = BuildersKt__Builders_commonKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new CommonRippleIndicationInstance$addRipple$2(rippleAnimation, this, press, (Continuation<? super CommonRippleIndicationInstance$addRipple$2>) null), 3, (Object) null);
    }

    public void drawIndication(@NotNull ContentDrawScope contentDrawScope) {
        Intrinsics.checkNotNullParameter(contentDrawScope, "<this>");
        long r02 = this.color.getValue().m2929unboximpl();
        contentDrawScope.drawContent();
        m1484drawStateLayerH2RKhps(contentDrawScope, this.radius, r02);
        m1474drawRipples4WTKRHQ(contentDrawScope, r02);
    }

    public void onAbandoned() {
        this.ripples.clear();
    }

    public void onForgotten() {
        this.ripples.clear();
    }

    public void onRemembered() {
    }

    public void removeRipple(@NotNull PressInteraction.Press press) {
        Intrinsics.checkNotNullParameter(press, "interaction");
        RippleAnimation rippleAnimation = this.ripples.get(press);
        if (rippleAnimation != null) {
            rippleAnimation.finish();
        }
    }
}
