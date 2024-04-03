package androidx.compose.material3;

import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.Easing;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Immutable
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B*\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0002\u0010\u0007J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\f\u001a\u00020\rH\u0016J(\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\nH\u0001ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0005\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\bR\u0019\u0010\u0006\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\bR\u0019\u0010\u0002\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\bR\u0019\u0010\u0004\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\b\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0014"}, d2 = {"Landroidx/compose/material3/RadioButtonColors;", "", "selectedColor", "Landroidx/compose/ui/graphics/Color;", "unselectedColor", "disabledSelectedColor", "disabledUnselectedColor", "(JJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "equals", "", "other", "hashCode", "", "radioColor", "Landroidx/compose/runtime/State;", "enabled", "selected", "radioColor$material3_release", "(ZZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "material3_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class RadioButtonColors {
    private final long disabledSelectedColor;
    private final long disabledUnselectedColor;
    private final long selectedColor;
    private final long unselectedColor;

    private RadioButtonColors(long j11, long j12, long j13, long j14) {
        this.selectedColor = j11;
        this.unselectedColor = j12;
        this.disabledSelectedColor = j13;
        this.disabledUnselectedColor = j14;
    }

    public /* synthetic */ RadioButtonColors(long j11, long j12, long j13, long j14, DefaultConstructorMarker defaultConstructorMarker) {
        this(j11, j12, j13, j14);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof RadioButtonColors)) {
            return false;
        }
        RadioButtonColors radioButtonColors = (RadioButtonColors) obj;
        if (Color.m2920equalsimpl0(this.selectedColor, radioButtonColors.selectedColor) && Color.m2920equalsimpl0(this.unselectedColor, radioButtonColors.unselectedColor) && Color.m2920equalsimpl0(this.disabledSelectedColor, radioButtonColors.disabledSelectedColor) && Color.m2920equalsimpl0(this.disabledUnselectedColor, radioButtonColors.disabledUnselectedColor)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((Color.m2926hashCodeimpl(this.selectedColor) * 31) + Color.m2926hashCodeimpl(this.unselectedColor)) * 31) + Color.m2926hashCodeimpl(this.disabledSelectedColor)) * 31) + Color.m2926hashCodeimpl(this.disabledUnselectedColor);
    }

    @NotNull
    @Composable
    public final State<Color> radioColor$material3_release(boolean z11, boolean z12, @Nullable Composer composer, int i11) {
        long j11;
        State<Color> state;
        composer.startReplaceableGroup(-1840145292);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1840145292, i11, -1, "androidx.compose.material3.RadioButtonColors.radioColor (RadioButton.kt:182)");
        }
        if (z11 && z12) {
            j11 = this.selectedColor;
        } else if (z11 && !z12) {
            j11 = this.unselectedColor;
        } else if (z11 || !z12) {
            j11 = this.disabledUnselectedColor;
        } else {
            j11 = this.disabledSelectedColor;
        }
        long j12 = j11;
        if (z11) {
            composer.startReplaceableGroup(-1943770140);
            state = SingleValueAnimationKt.m86animateColorAsStateKTwxG1Y(j12, AnimationSpecKt.tween$default(100, 0, (Easing) null, 6, (Object) null), (Function1<? super Color, Unit>) null, composer, 48, 4);
            composer.endReplaceableGroup();
        } else {
            composer.startReplaceableGroup(-1943770035);
            state = SnapshotStateKt.rememberUpdatedState(Color.m2909boximpl(j12), composer, 0);
            composer.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return state;
    }
}
