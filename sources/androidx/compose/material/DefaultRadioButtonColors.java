package androidx.compose.material;

import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.Easing;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Immutable
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B \u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0002\u0010\u0006J\u0013\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0002J\b\u0010\f\u001a\u00020\rH\u0016J&\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\tH\u0017ø\u0001\u0000¢\u0006\u0002\u0010\u0012R\u0019\u0010\u0005\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0007R\u0019\u0010\u0002\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0007R\u0019\u0010\u0004\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0007\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0013"}, d2 = {"Landroidx/compose/material/DefaultRadioButtonColors;", "Landroidx/compose/material/RadioButtonColors;", "selectedColor", "Landroidx/compose/ui/graphics/Color;", "unselectedColor", "disabledColor", "(JJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "equals", "", "other", "", "hashCode", "", "radioColor", "Landroidx/compose/runtime/State;", "enabled", "selected", "(ZZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "material_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
final class DefaultRadioButtonColors implements RadioButtonColors {
    private final long disabledColor;
    private final long selectedColor;
    private final long unselectedColor;

    private DefaultRadioButtonColors(long j11, long j12, long j13) {
        this.selectedColor = j11;
        this.unselectedColor = j12;
        this.disabledColor = j13;
    }

    public /* synthetic */ DefaultRadioButtonColors(long j11, long j12, long j13, DefaultConstructorMarker defaultConstructorMarker) {
        this(j11, j12, j13);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !Intrinsics.areEqual((Object) Reflection.getOrCreateKotlinClass(DefaultRadioButtonColors.class), (Object) Reflection.getOrCreateKotlinClass(obj.getClass()))) {
            return false;
        }
        DefaultRadioButtonColors defaultRadioButtonColors = (DefaultRadioButtonColors) obj;
        if (Color.m2920equalsimpl0(this.selectedColor, defaultRadioButtonColors.selectedColor) && Color.m2920equalsimpl0(this.unselectedColor, defaultRadioButtonColors.unselectedColor) && Color.m2920equalsimpl0(this.disabledColor, defaultRadioButtonColors.disabledColor)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((Color.m2926hashCodeimpl(this.selectedColor) * 31) + Color.m2926hashCodeimpl(this.unselectedColor)) * 31) + Color.m2926hashCodeimpl(this.disabledColor);
    }

    @NotNull
    @Composable
    public State<Color> radioColor(boolean z11, boolean z12, @Nullable Composer composer, int i11) {
        long j11;
        State<Color> state;
        composer.startReplaceableGroup(1243421834);
        if (!z11) {
            j11 = this.disabledColor;
        } else if (!z12) {
            j11 = this.unselectedColor;
        } else {
            j11 = this.selectedColor;
        }
        long j12 = j11;
        if (z11) {
            composer.startReplaceableGroup(-1052799218);
            state = SingleValueAnimationKt.m86animateColorAsStateKTwxG1Y(j12, AnimationSpecKt.tween$default(100, 0, (Easing) null, 6, (Object) null), (Function1<? super Color, Unit>) null, composer, 48, 4);
            composer.endReplaceableGroup();
        } else {
            composer.startReplaceableGroup(-1052799113);
            state = SnapshotStateKt.rememberUpdatedState(Color.m2909boximpl(j12), composer, 0);
            composer.endReplaceableGroup();
        }
        composer.endReplaceableGroup();
        return state;
    }
}
