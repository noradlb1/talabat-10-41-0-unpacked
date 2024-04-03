package androidx.compose.material3;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.Easing;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.FocusInteractionKt;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aK\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\r\u0010\u000e\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u000f"}, d2 = {"animateBorderStrokeAsState", "Landroidx/compose/runtime/State;", "Landroidx/compose/foundation/BorderStroke;", "enabled", "", "isError", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "colors", "Landroidx/compose/material3/TextFieldColors;", "focusedBorderThickness", "Landroidx/compose/ui/unit/Dp;", "unfocusedBorderThickness", "animateBorderStrokeAsState-NuRrP5Q", "(ZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/material3/TextFieldColors;FFLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "material3_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class TextFieldDefaultsKt {
    /* access modifiers changed from: private */
    @Composable
    /* renamed from: animateBorderStrokeAsState-NuRrP5Q  reason: not valid java name */
    public static final State<BorderStroke> m1921animateBorderStrokeAsStateNuRrP5Q(boolean z11, boolean z12, InteractionSource interactionSource, TextFieldColors textFieldColors, float f11, float f12, Composer composer, int i11) {
        float f13;
        State<Dp> state;
        Composer composer2 = composer;
        int i12 = i11;
        composer.startReplaceableGroup(-1633063017);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1633063017, i12, -1, "androidx.compose.material3.animateBorderStrokeAsState (TextFieldDefaults.kt:943)");
        }
        State<Boolean> collectIsFocusedAsState = FocusInteractionKt.collectIsFocusedAsState(interactionSource, composer, (i12 >> 6) & 14);
        TextFieldColors textFieldColors2 = textFieldColors;
        boolean z13 = z11;
        boolean z14 = z12;
        State<Color> indicatorColor$material3_release = textFieldColors2.indicatorColor$material3_release(z13, z14, interactionSource, composer, (i12 & 14) | (i12 & 112) | (i12 & 896) | (i12 & 7168));
        if (m1922animateBorderStrokeAsState_NuRrP5Q$lambda0(collectIsFocusedAsState)) {
            f13 = f11;
        } else {
            f13 = f12;
        }
        if (z11) {
            composer.startReplaceableGroup(-1927801001);
            state = AnimateAsStateKt.m102animateDpAsStateKz89ssw(f13, AnimationSpecKt.tween$default(150, 0, (Easing) null, 6, (Object) null), (Function1<? super Dp, Unit>) null, composer, 48, 4);
            composer.endReplaceableGroup();
        } else {
            composer.startReplaceableGroup(-1927800903);
            state = SnapshotStateKt.rememberUpdatedState(Dp.m5476boximpl(f12), composer, (i12 >> 15) & 14);
            composer.endReplaceableGroup();
        }
        State<BorderStroke> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(new BorderStroke(state.getValue().m5492unboximpl(), new SolidColor(indicatorColor$material3_release.getValue().m2929unboximpl(), (DefaultConstructorMarker) null), (DefaultConstructorMarker) null), composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return rememberUpdatedState;
    }

    /* renamed from: animateBorderStrokeAsState_NuRrP5Q$lambda-0  reason: not valid java name */
    private static final boolean m1922animateBorderStrokeAsState_NuRrP5Q$lambda0(State<Boolean> state) {
        return state.getValue().booleanValue();
    }
}
