package androidx.compose.material;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Immutable
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001BH\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0002\u0010\u000bJ\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J&\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u00142\u0006\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u000eH\u0017ø\u0001\u0000¢\u0006\u0002\u0010\u0017J&\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\u00142\u0006\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u000eH\u0017ø\u0001\u0000¢\u0006\u0002\u0010\u0017R\u0019\u0010\u0002\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\fR\u0019\u0010\u0004\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\fR\u0019\u0010\u0007\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\fR\u0019\u0010\b\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\fR\u0019\u0010\t\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\fR\u0019\u0010\n\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\fR\u0019\u0010\u0005\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\fR\u0019\u0010\u0006\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\f\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0019"}, d2 = {"Landroidx/compose/material/DefaultSwitchColors;", "Landroidx/compose/material/SwitchColors;", "checkedThumbColor", "Landroidx/compose/ui/graphics/Color;", "checkedTrackColor", "uncheckedThumbColor", "uncheckedTrackColor", "disabledCheckedThumbColor", "disabledCheckedTrackColor", "disabledUncheckedThumbColor", "disabledUncheckedTrackColor", "(JJJJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "equals", "", "other", "", "hashCode", "", "thumbColor", "Landroidx/compose/runtime/State;", "enabled", "checked", "(ZZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "trackColor", "material_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
final class DefaultSwitchColors implements SwitchColors {
    private final long checkedThumbColor;
    private final long checkedTrackColor;
    private final long disabledCheckedThumbColor;
    private final long disabledCheckedTrackColor;
    private final long disabledUncheckedThumbColor;
    private final long disabledUncheckedTrackColor;
    private final long uncheckedThumbColor;
    private final long uncheckedTrackColor;

    private DefaultSwitchColors(long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18) {
        this.checkedThumbColor = j11;
        this.checkedTrackColor = j12;
        this.uncheckedThumbColor = j13;
        this.uncheckedTrackColor = j14;
        this.disabledCheckedThumbColor = j15;
        this.disabledCheckedTrackColor = j16;
        this.disabledUncheckedThumbColor = j17;
        this.disabledUncheckedTrackColor = j18;
    }

    public /* synthetic */ DefaultSwitchColors(long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, DefaultConstructorMarker defaultConstructorMarker) {
        this(j11, j12, j13, j14, j15, j16, j17, j18);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !Intrinsics.areEqual((Object) Reflection.getOrCreateKotlinClass(DefaultSwitchColors.class), (Object) Reflection.getOrCreateKotlinClass(obj.getClass()))) {
            return false;
        }
        DefaultSwitchColors defaultSwitchColors = (DefaultSwitchColors) obj;
        if (Color.m2920equalsimpl0(this.checkedThumbColor, defaultSwitchColors.checkedThumbColor) && Color.m2920equalsimpl0(this.checkedTrackColor, defaultSwitchColors.checkedTrackColor) && Color.m2920equalsimpl0(this.uncheckedThumbColor, defaultSwitchColors.uncheckedThumbColor) && Color.m2920equalsimpl0(this.uncheckedTrackColor, defaultSwitchColors.uncheckedTrackColor) && Color.m2920equalsimpl0(this.disabledCheckedThumbColor, defaultSwitchColors.disabledCheckedThumbColor) && Color.m2920equalsimpl0(this.disabledCheckedTrackColor, defaultSwitchColors.disabledCheckedTrackColor) && Color.m2920equalsimpl0(this.disabledUncheckedThumbColor, defaultSwitchColors.disabledUncheckedThumbColor) && Color.m2920equalsimpl0(this.disabledUncheckedTrackColor, defaultSwitchColors.disabledUncheckedTrackColor)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((Color.m2926hashCodeimpl(this.checkedThumbColor) * 31) + Color.m2926hashCodeimpl(this.checkedTrackColor)) * 31) + Color.m2926hashCodeimpl(this.uncheckedThumbColor)) * 31) + Color.m2926hashCodeimpl(this.uncheckedTrackColor)) * 31) + Color.m2926hashCodeimpl(this.disabledCheckedThumbColor)) * 31) + Color.m2926hashCodeimpl(this.disabledCheckedTrackColor)) * 31) + Color.m2926hashCodeimpl(this.disabledUncheckedThumbColor)) * 31) + Color.m2926hashCodeimpl(this.disabledUncheckedTrackColor);
    }

    @NotNull
    @Composable
    public State<Color> thumbColor(boolean z11, boolean z12, @Nullable Composer composer, int i11) {
        long j11;
        composer.startReplaceableGroup(-66424183);
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
        composer.endReplaceableGroup();
        return rememberUpdatedState;
    }

    @NotNull
    @Composable
    public State<Color> trackColor(boolean z11, boolean z12, @Nullable Composer composer, int i11) {
        long j11;
        composer.startReplaceableGroup(-1176343362);
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
        composer.endReplaceableGroup();
        return rememberUpdatedState;
    }
}
