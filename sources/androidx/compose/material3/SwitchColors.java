package androidx.compose.material3;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Immutable
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0001\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0002\u0010\u0013J(\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018H\u0001ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u00182\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u001e\u001a\u00020\u001fH\u0016J(\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00030\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018H\u0001ø\u0001\u0000¢\u0006\u0004\b!\u0010\u001bJ(\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00030\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018H\u0001ø\u0001\u0000¢\u0006\u0004\b#\u0010\u001bJ(\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00030\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018H\u0001ø\u0001\u0000¢\u0006\u0004\b%\u0010\u001bR\u0019\u0010\u0005\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0014R\u0019\u0010\u0006\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0014R\u0019\u0010\u0002\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0014R\u0019\u0010\u0004\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0014R\u0019\u0010\r\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0014R\u0019\u0010\u000e\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0014R\u0019\u0010\u000b\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0014R\u0019\u0010\f\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0014R\u0019\u0010\u0011\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0014R\u0019\u0010\u0012\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0014R\u0019\u0010\u000f\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0014R\u0019\u0010\u0010\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0014R\u0019\u0010\t\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0014R\u0019\u0010\n\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0014R\u0019\u0010\u0007\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0014R\u0019\u0010\b\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0014\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006&"}, d2 = {"Landroidx/compose/material3/SwitchColors;", "", "checkedThumbColor", "Landroidx/compose/ui/graphics/Color;", "checkedTrackColor", "checkedBorderColor", "checkedIconColor", "uncheckedThumbColor", "uncheckedTrackColor", "uncheckedBorderColor", "uncheckedIconColor", "disabledCheckedThumbColor", "disabledCheckedTrackColor", "disabledCheckedBorderColor", "disabledCheckedIconColor", "disabledUncheckedThumbColor", "disabledUncheckedTrackColor", "disabledUncheckedBorderColor", "disabledUncheckedIconColor", "(JJJJJJJJJJJJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "borderColor", "Landroidx/compose/runtime/State;", "enabled", "", "checked", "borderColor$material3_release", "(ZZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "equals", "other", "hashCode", "", "iconColor", "iconColor$material3_release", "thumbColor", "thumbColor$material3_release", "trackColor", "trackColor$material3_release", "material3_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SwitchColors {
    private final long checkedBorderColor;
    private final long checkedIconColor;
    private final long checkedThumbColor;
    private final long checkedTrackColor;
    private final long disabledCheckedBorderColor;
    private final long disabledCheckedIconColor;
    private final long disabledCheckedThumbColor;
    private final long disabledCheckedTrackColor;
    private final long disabledUncheckedBorderColor;
    private final long disabledUncheckedIconColor;
    private final long disabledUncheckedThumbColor;
    private final long disabledUncheckedTrackColor;
    private final long uncheckedBorderColor;
    private final long uncheckedIconColor;
    private final long uncheckedThumbColor;
    private final long uncheckedTrackColor;

    private SwitchColors(long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j21, long j22, long j23, long j24, long j25, long j26, long j27) {
        this.checkedThumbColor = j11;
        this.checkedTrackColor = j12;
        this.checkedBorderColor = j13;
        this.checkedIconColor = j14;
        this.uncheckedThumbColor = j15;
        this.uncheckedTrackColor = j16;
        this.uncheckedBorderColor = j17;
        this.uncheckedIconColor = j18;
        this.disabledCheckedThumbColor = j19;
        this.disabledCheckedTrackColor = j21;
        this.disabledCheckedBorderColor = j22;
        this.disabledCheckedIconColor = j23;
        this.disabledUncheckedThumbColor = j24;
        this.disabledUncheckedTrackColor = j25;
        this.disabledUncheckedBorderColor = j26;
        this.disabledUncheckedIconColor = j27;
    }

    public /* synthetic */ SwitchColors(long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j21, long j22, long j23, long j24, long j25, long j26, long j27, DefaultConstructorMarker defaultConstructorMarker) {
        this(j11, j12, j13, j14, j15, j16, j17, j18, j19, j21, j22, j23, j24, j25, j26, j27);
    }

    @NotNull
    @Composable
    public final State<Color> borderColor$material3_release(boolean z11, boolean z12, @Nullable Composer composer, int i11) {
        long j11;
        composer.startReplaceableGroup(462653665);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(462653665, i11, -1, "androidx.compose.material3.SwitchColors.borderColor (Switch.kt:402)");
        }
        if (z11) {
            if (z12) {
                j11 = this.checkedBorderColor;
            } else {
                j11 = this.uncheckedBorderColor;
            }
        } else if (z12) {
            j11 = this.disabledCheckedBorderColor;
        } else {
            j11 = this.disabledUncheckedBorderColor;
        }
        State<Color> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m2909boximpl(j11), composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return rememberUpdatedState;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof SwitchColors)) {
            return false;
        }
        SwitchColors switchColors = (SwitchColors) obj;
        if (Color.m2920equalsimpl0(this.checkedThumbColor, switchColors.checkedThumbColor) && Color.m2920equalsimpl0(this.checkedTrackColor, switchColors.checkedTrackColor) && Color.m2920equalsimpl0(this.checkedBorderColor, switchColors.checkedBorderColor) && Color.m2920equalsimpl0(this.checkedIconColor, switchColors.checkedIconColor) && Color.m2920equalsimpl0(this.uncheckedThumbColor, switchColors.uncheckedThumbColor) && Color.m2920equalsimpl0(this.uncheckedTrackColor, switchColors.uncheckedTrackColor) && Color.m2920equalsimpl0(this.uncheckedBorderColor, switchColors.uncheckedBorderColor) && Color.m2920equalsimpl0(this.uncheckedIconColor, switchColors.uncheckedIconColor) && Color.m2920equalsimpl0(this.disabledCheckedThumbColor, switchColors.disabledCheckedThumbColor) && Color.m2920equalsimpl0(this.disabledCheckedTrackColor, switchColors.disabledCheckedTrackColor) && Color.m2920equalsimpl0(this.disabledCheckedBorderColor, switchColors.disabledCheckedBorderColor) && Color.m2920equalsimpl0(this.disabledCheckedIconColor, switchColors.disabledCheckedIconColor) && Color.m2920equalsimpl0(this.disabledUncheckedThumbColor, switchColors.disabledUncheckedThumbColor) && Color.m2920equalsimpl0(this.disabledUncheckedTrackColor, switchColors.disabledUncheckedTrackColor) && Color.m2920equalsimpl0(this.disabledUncheckedBorderColor, switchColors.disabledUncheckedBorderColor) && Color.m2920equalsimpl0(this.disabledUncheckedIconColor, switchColors.disabledUncheckedIconColor)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((Color.m2926hashCodeimpl(this.checkedThumbColor) * 31) + Color.m2926hashCodeimpl(this.checkedTrackColor)) * 31) + Color.m2926hashCodeimpl(this.checkedBorderColor)) * 31) + Color.m2926hashCodeimpl(this.checkedIconColor)) * 31) + Color.m2926hashCodeimpl(this.uncheckedThumbColor)) * 31) + Color.m2926hashCodeimpl(this.uncheckedTrackColor)) * 31) + Color.m2926hashCodeimpl(this.uncheckedBorderColor)) * 31) + Color.m2926hashCodeimpl(this.uncheckedIconColor)) * 31) + Color.m2926hashCodeimpl(this.disabledCheckedThumbColor)) * 31) + Color.m2926hashCodeimpl(this.disabledCheckedTrackColor)) * 31) + Color.m2926hashCodeimpl(this.disabledCheckedBorderColor)) * 31) + Color.m2926hashCodeimpl(this.disabledCheckedIconColor)) * 31) + Color.m2926hashCodeimpl(this.disabledUncheckedThumbColor)) * 31) + Color.m2926hashCodeimpl(this.disabledUncheckedTrackColor)) * 31) + Color.m2926hashCodeimpl(this.disabledUncheckedBorderColor)) * 31) + Color.m2926hashCodeimpl(this.disabledUncheckedIconColor);
    }

    @NotNull
    @Composable
    public final State<Color> iconColor$material3_release(boolean z11, boolean z12, @Nullable Composer composer, int i11) {
        long j11;
        composer.startReplaceableGroup(-153383122);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-153383122, i11, -1, "androidx.compose.material3.SwitchColors.iconColor (Switch.kt:419)");
        }
        if (z11) {
            if (z12) {
                j11 = this.checkedIconColor;
            } else {
                j11 = this.uncheckedIconColor;
            }
        } else if (z12) {
            j11 = this.disabledCheckedIconColor;
        } else {
            j11 = this.disabledUncheckedIconColor;
        }
        State<Color> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m2909boximpl(j11), composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return rememberUpdatedState;
    }

    @NotNull
    @Composable
    public final State<Color> thumbColor$material3_release(boolean z11, boolean z12, @Nullable Composer composer, int i11) {
        long j11;
        composer.startReplaceableGroup(-1539933265);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1539933265, i11, -1, "androidx.compose.material3.SwitchColors.thumbColor (Switch.kt:368)");
        }
        if (z11) {
            if (z12) {
                j11 = this.checkedThumbColor;
            } else {
                j11 = this.uncheckedThumbColor;
            }
        } else if (z12) {
            j11 = this.disabledCheckedThumbColor;
        } else {
            j11 = this.disabledUncheckedThumbColor;
        }
        State<Color> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m2909boximpl(j11), composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return rememberUpdatedState;
    }

    @NotNull
    @Composable
    public final State<Color> trackColor$material3_release(boolean z11, boolean z12, @Nullable Composer composer, int i11) {
        long j11;
        composer.startReplaceableGroup(961511844);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(961511844, i11, -1, "androidx.compose.material3.SwitchColors.trackColor (Switch.kt:385)");
        }
        if (z11) {
            if (z12) {
                j11 = this.checkedTrackColor;
            } else {
                j11 = this.uncheckedTrackColor;
            }
        } else if (z12) {
            j11 = this.disabledCheckedTrackColor;
        } else {
            j11 = this.disabledUncheckedTrackColor;
        }
        State<Color> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m2909boximpl(j11), composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return rememberUpdatedState;
    }
}
