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
import androidx.compose.ui.state.ToggleableState;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Immutable
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001Bb\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0002\u0010\u000eJ(\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0001ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017J(\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0001ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u0017J \u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00030\u00112\u0006\u0010\u0014\u001a\u00020\u0015H\u0001ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u00132\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u001f\u001a\u00020 H\u0016R\u0019\u0010\n\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u000fR\u0019\u0010\u0005\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u000fR\u0019\u0010\u0002\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u000fR\u0019\u0010\f\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u000fR\u0019\u0010\u0007\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u000fR\u0019\u0010\r\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u000fR\u0019\u0010\t\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u000fR\u0019\u0010\b\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u000fR\u0019\u0010\u000b\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u000fR\u0019\u0010\u0006\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u000fR\u0019\u0010\u0004\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u000f\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006!"}, d2 = {"Landroidx/compose/material3/CheckboxColors;", "", "checkedCheckmarkColor", "Landroidx/compose/ui/graphics/Color;", "uncheckedCheckmarkColor", "checkedBoxColor", "uncheckedBoxColor", "disabledCheckedBoxColor", "disabledUncheckedBoxColor", "disabledIndeterminateBoxColor", "checkedBorderColor", "uncheckedBorderColor", "disabledBorderColor", "disabledIndeterminateBorderColor", "(JJJJJJJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "borderColor", "Landroidx/compose/runtime/State;", "enabled", "", "state", "Landroidx/compose/ui/state/ToggleableState;", "borderColor$material3_release", "(ZLandroidx/compose/ui/state/ToggleableState;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "boxColor", "boxColor$material3_release", "checkmarkColor", "checkmarkColor$material3_release", "(Landroidx/compose/ui/state/ToggleableState;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "equals", "other", "hashCode", "", "material3_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class CheckboxColors {
    private final long checkedBorderColor;
    private final long checkedBoxColor;
    private final long checkedCheckmarkColor;
    private final long disabledBorderColor;
    private final long disabledCheckedBoxColor;
    private final long disabledIndeterminateBorderColor;
    private final long disabledIndeterminateBoxColor;
    private final long disabledUncheckedBoxColor;
    private final long uncheckedBorderColor;
    private final long uncheckedBoxColor;
    private final long uncheckedCheckmarkColor;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ToggleableState.values().length];
            iArr[ToggleableState.On.ordinal()] = 1;
            iArr[ToggleableState.Indeterminate.ordinal()] = 2;
            iArr[ToggleableState.Off.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private CheckboxColors(long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j21, long j22) {
        this.checkedCheckmarkColor = j11;
        this.uncheckedCheckmarkColor = j12;
        this.checkedBoxColor = j13;
        this.uncheckedBoxColor = j14;
        this.disabledCheckedBoxColor = j15;
        this.disabledUncheckedBoxColor = j16;
        this.disabledIndeterminateBoxColor = j17;
        this.checkedBorderColor = j18;
        this.uncheckedBorderColor = j19;
        this.disabledBorderColor = j21;
        this.disabledIndeterminateBorderColor = j22;
    }

    public /* synthetic */ CheckboxColors(long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j21, long j22, DefaultConstructorMarker defaultConstructorMarker) {
        this(j11, j12, j13, j14, j15, j16, j17, j18, j19, j21, j22);
    }

    @NotNull
    @Composable
    public final State<Color> borderColor$material3_release(boolean z11, @NotNull ToggleableState toggleableState, @Nullable Composer composer, int i11) {
        long j11;
        State<Color> state;
        int i12;
        Intrinsics.checkNotNullParameter(toggleableState, "state");
        composer.startReplaceableGroup(1009643462);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1009643462, i11, -1, "androidx.compose.material3.CheckboxColors.borderColor (Checkbox.kt:446)");
        }
        if (z11) {
            int i13 = WhenMappings.$EnumSwitchMapping$0[toggleableState.ordinal()];
            if (i13 == 1 || i13 == 2) {
                j11 = this.checkedBorderColor;
            } else if (i13 == 3) {
                j11 = this.uncheckedBorderColor;
            } else {
                throw new NoWhenBranchMatchedException();
            }
        } else {
            int i14 = WhenMappings.$EnumSwitchMapping$0[toggleableState.ordinal()];
            if (i14 != 1) {
                if (i14 == 2) {
                    j11 = this.disabledIndeterminateBorderColor;
                } else if (i14 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
            }
            j11 = this.disabledBorderColor;
        }
        long j12 = j11;
        if (z11) {
            composer.startReplaceableGroup(1209369334);
            if (toggleableState == ToggleableState.Off) {
                i12 = 100;
            } else {
                i12 = 50;
            }
            state = SingleValueAnimationKt.m86animateColorAsStateKTwxG1Y(j12, AnimationSpecKt.tween$default(i12, 0, (Easing) null, 6, (Object) null), (Function1<? super Color, Unit>) null, composer, 0, 4);
            composer.endReplaceableGroup();
        } else {
            composer.startReplaceableGroup(1209369520);
            state = SnapshotStateKt.rememberUpdatedState(Color.m2909boximpl(j12), composer, 0);
            composer.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return state;
    }

    @NotNull
    @Composable
    public final State<Color> boxColor$material3_release(boolean z11, @NotNull ToggleableState toggleableState, @Nullable Composer composer, int i11) {
        long j11;
        State<Color> state;
        int i12;
        Intrinsics.checkNotNullParameter(toggleableState, "state");
        composer.startReplaceableGroup(360729865);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(360729865, i11, -1, "androidx.compose.material3.CheckboxColors.boxColor (Checkbox.kt:415)");
        }
        if (z11) {
            int i13 = WhenMappings.$EnumSwitchMapping$0[toggleableState.ordinal()];
            if (i13 == 1 || i13 == 2) {
                j11 = this.checkedBoxColor;
            } else if (i13 == 3) {
                j11 = this.uncheckedBoxColor;
            } else {
                throw new NoWhenBranchMatchedException();
            }
        } else {
            int i14 = WhenMappings.$EnumSwitchMapping$0[toggleableState.ordinal()];
            if (i14 == 1) {
                j11 = this.disabledCheckedBoxColor;
            } else if (i14 == 2) {
                j11 = this.disabledIndeterminateBoxColor;
            } else if (i14 == 3) {
                j11 = this.disabledUncheckedBoxColor;
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
        long j12 = j11;
        if (z11) {
            composer.startReplaceableGroup(1143718194);
            if (toggleableState == ToggleableState.Off) {
                i12 = 100;
            } else {
                i12 = 50;
            }
            state = SingleValueAnimationKt.m86animateColorAsStateKTwxG1Y(j12, AnimationSpecKt.tween$default(i12, 0, (Easing) null, 6, (Object) null), (Function1<? super Color, Unit>) null, composer, 0, 4);
            composer.endReplaceableGroup();
        } else {
            composer.startReplaceableGroup(1143718380);
            state = SnapshotStateKt.rememberUpdatedState(Color.m2909boximpl(j12), composer, 0);
            composer.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return state;
    }

    @NotNull
    @Composable
    public final State<Color> checkmarkColor$material3_release(@NotNull ToggleableState toggleableState, @Nullable Composer composer, int i11) {
        long j11;
        int i12;
        Intrinsics.checkNotNullParameter(toggleableState, "state");
        composer.startReplaceableGroup(-507585681);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-507585681, i11, -1, "androidx.compose.material3.CheckboxColors.checkmarkColor (Checkbox.kt:396)");
        }
        ToggleableState toggleableState2 = ToggleableState.Off;
        if (toggleableState == toggleableState2) {
            j11 = this.uncheckedCheckmarkColor;
        } else {
            j11 = this.checkedCheckmarkColor;
        }
        long j12 = j11;
        if (toggleableState == toggleableState2) {
            i12 = 100;
        } else {
            i12 = 50;
        }
        State<Color> r102 = SingleValueAnimationKt.m86animateColorAsStateKTwxG1Y(j12, AnimationSpecKt.tween$default(i12, 0, (Easing) null, 6, (Object) null), (Function1<? super Color, Unit>) null, composer, 0, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return r102;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof CheckboxColors)) {
            return false;
        }
        CheckboxColors checkboxColors = (CheckboxColors) obj;
        if (Color.m2920equalsimpl0(this.checkedCheckmarkColor, checkboxColors.checkedCheckmarkColor) && Color.m2920equalsimpl0(this.uncheckedCheckmarkColor, checkboxColors.uncheckedCheckmarkColor) && Color.m2920equalsimpl0(this.checkedBoxColor, checkboxColors.checkedBoxColor) && Color.m2920equalsimpl0(this.uncheckedBoxColor, checkboxColors.uncheckedBoxColor) && Color.m2920equalsimpl0(this.disabledCheckedBoxColor, checkboxColors.disabledCheckedBoxColor) && Color.m2920equalsimpl0(this.disabledUncheckedBoxColor, checkboxColors.disabledUncheckedBoxColor) && Color.m2920equalsimpl0(this.disabledIndeterminateBoxColor, checkboxColors.disabledIndeterminateBoxColor) && Color.m2920equalsimpl0(this.checkedBorderColor, checkboxColors.checkedBorderColor) && Color.m2920equalsimpl0(this.uncheckedBorderColor, checkboxColors.uncheckedBorderColor) && Color.m2920equalsimpl0(this.disabledBorderColor, checkboxColors.disabledBorderColor) && Color.m2920equalsimpl0(this.disabledIndeterminateBorderColor, checkboxColors.disabledIndeterminateBorderColor)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((((((Color.m2926hashCodeimpl(this.checkedCheckmarkColor) * 31) + Color.m2926hashCodeimpl(this.uncheckedCheckmarkColor)) * 31) + Color.m2926hashCodeimpl(this.checkedBoxColor)) * 31) + Color.m2926hashCodeimpl(this.uncheckedBoxColor)) * 31) + Color.m2926hashCodeimpl(this.disabledCheckedBoxColor)) * 31) + Color.m2926hashCodeimpl(this.disabledUncheckedBoxColor)) * 31) + Color.m2926hashCodeimpl(this.disabledIndeterminateBoxColor)) * 31) + Color.m2926hashCodeimpl(this.checkedBorderColor)) * 31) + Color.m2926hashCodeimpl(this.uncheckedBorderColor)) * 31) + Color.m2926hashCodeimpl(this.disabledBorderColor)) * 31) + Color.m2926hashCodeimpl(this.disabledIndeterminateBorderColor);
    }
}
