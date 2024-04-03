package androidx.compose.material.ripple;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.Indication;
import androidx.compose.foundation.interaction.DragInteraction;
import androidx.compose.foundation.interaction.FocusInteraction;
import androidx.compose.foundation.interaction.HoverInteraction;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002\u001a\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002\u001a3\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0010\u0010\u0011\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u0012"}, d2 = {"DefaultTweenSpec", "Landroidx/compose/animation/core/TweenSpec;", "", "incomingStateLayerAnimationSpecFor", "Landroidx/compose/animation/core/AnimationSpec;", "interaction", "Landroidx/compose/foundation/interaction/Interaction;", "outgoingStateLayerAnimationSpecFor", "rememberRipple", "Landroidx/compose/foundation/Indication;", "bounded", "", "radius", "Landroidx/compose/ui/unit/Dp;", "color", "Landroidx/compose/ui/graphics/Color;", "rememberRipple-9IZ8Weo", "(ZFJLandroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/Indication;", "material-ripple_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class RippleKt {
    @NotNull
    private static final TweenSpec<Float> DefaultTweenSpec = new TweenSpec(15, 0, EasingKt.getLinearEasing(), 2, (DefaultConstructorMarker) null);

    /* access modifiers changed from: private */
    public static final AnimationSpec<Float> incomingStateLayerAnimationSpecFor(Interaction interaction) {
        if (interaction instanceof HoverInteraction.Enter) {
            return DefaultTweenSpec;
        }
        if (interaction instanceof FocusInteraction.Focus) {
            return new TweenSpec(45, 0, EasingKt.getLinearEasing(), 2, (DefaultConstructorMarker) null);
        }
        if (interaction instanceof DragInteraction.Start) {
            return new TweenSpec(45, 0, EasingKt.getLinearEasing(), 2, (DefaultConstructorMarker) null);
        }
        return DefaultTweenSpec;
    }

    /* access modifiers changed from: private */
    public static final AnimationSpec<Float> outgoingStateLayerAnimationSpecFor(Interaction interaction) {
        if (interaction instanceof HoverInteraction.Enter) {
            return DefaultTweenSpec;
        }
        if (interaction instanceof FocusInteraction.Focus) {
            return DefaultTweenSpec;
        }
        if (interaction instanceof DragInteraction.Start) {
            return new TweenSpec(150, 0, EasingKt.getLinearEasing(), 2, (DefaultConstructorMarker) null);
        }
        return DefaultTweenSpec;
    }

    @NotNull
    @Composable
    /* renamed from: rememberRipple-9IZ8Weo  reason: not valid java name */
    public static final Indication m1485rememberRipple9IZ8Weo(boolean z11, float f11, long j11, @Nullable Composer composer, int i11, int i12) {
        composer.startReplaceableGroup(1635163520);
        if ((i12 & 1) != 0) {
            z11 = true;
        }
        if ((i12 & 2) != 0) {
            f11 = Dp.Companion.m5498getUnspecifiedD9Ej5fM();
        }
        if ((i12 & 4) != 0) {
            j11 = Color.Companion.m2955getUnspecified0d7_KjU();
        }
        State rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m2909boximpl(j11), composer, (i11 >> 6) & 14);
        Boolean valueOf = Boolean.valueOf(z11);
        Dp r62 = Dp.m5476boximpl(f11);
        composer.startReplaceableGroup(-3686552);
        boolean changed = composer.changed((Object) valueOf) | composer.changed((Object) r62);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new PlatformRipple(z11, f11, rememberUpdatedState, (DefaultConstructorMarker) null);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        PlatformRipple platformRipple = (PlatformRipple) rememberedValue;
        composer.endReplaceableGroup();
        return platformRipple;
    }
}
