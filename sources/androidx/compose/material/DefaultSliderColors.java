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
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001BX\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0002\u0010\rJ\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00030\u00152\u0006\u0010\u0016\u001a\u00020\u0010H\u0017ø\u0001\u0000¢\u0006\u0002\u0010\u0017J&\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\u00152\u0006\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u0010H\u0017ø\u0001\u0000¢\u0006\u0002\u0010\u001aJ&\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00152\u0006\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u0010H\u0017ø\u0001\u0000¢\u0006\u0002\u0010\u001aR\u0019\u0010\t\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u000eR\u0019\u0010\u0005\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u000eR\u0019\u0010\u000b\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u000eR\u0019\u0010\u0007\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u000eR\u0019\u0010\f\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u000eR\u0019\u0010\b\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u000eR\u0019\u0010\u0004\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u000eR\u0019\u0010\n\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u000eR\u0019\u0010\u0006\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u000eR\u0019\u0010\u0002\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u000e\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001c"}, d2 = {"Landroidx/compose/material/DefaultSliderColors;", "Landroidx/compose/material/SliderColors;", "thumbColor", "Landroidx/compose/ui/graphics/Color;", "disabledThumbColor", "activeTrackColor", "inactiveTrackColor", "disabledActiveTrackColor", "disabledInactiveTrackColor", "activeTickColor", "inactiveTickColor", "disabledActiveTickColor", "disabledInactiveTickColor", "(JJJJJJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "equals", "", "other", "", "hashCode", "", "Landroidx/compose/runtime/State;", "enabled", "(ZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "tickColor", "active", "(ZZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "trackColor", "material_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
final class DefaultSliderColors implements SliderColors {
    private final long activeTickColor;
    private final long activeTrackColor;
    private final long disabledActiveTickColor;
    private final long disabledActiveTrackColor;
    private final long disabledInactiveTickColor;
    private final long disabledInactiveTrackColor;
    private final long disabledThumbColor;
    private final long inactiveTickColor;
    private final long inactiveTrackColor;
    private final long thumbColor;

    private DefaultSliderColors(long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j21) {
        this.thumbColor = j11;
        this.disabledThumbColor = j12;
        this.activeTrackColor = j13;
        this.inactiveTrackColor = j14;
        this.disabledActiveTrackColor = j15;
        this.disabledInactiveTrackColor = j16;
        this.activeTickColor = j17;
        this.inactiveTickColor = j18;
        this.disabledActiveTickColor = j19;
        this.disabledInactiveTickColor = j21;
    }

    public /* synthetic */ DefaultSliderColors(long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j21, DefaultConstructorMarker defaultConstructorMarker) {
        this(j11, j12, j13, j14, j15, j16, j17, j18, j19, j21);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !Intrinsics.areEqual((Object) Reflection.getOrCreateKotlinClass(DefaultSliderColors.class), (Object) Reflection.getOrCreateKotlinClass(obj.getClass()))) {
            return false;
        }
        DefaultSliderColors defaultSliderColors = (DefaultSliderColors) obj;
        if (Color.m2920equalsimpl0(this.thumbColor, defaultSliderColors.thumbColor) && Color.m2920equalsimpl0(this.disabledThumbColor, defaultSliderColors.disabledThumbColor) && Color.m2920equalsimpl0(this.activeTrackColor, defaultSliderColors.activeTrackColor) && Color.m2920equalsimpl0(this.inactiveTrackColor, defaultSliderColors.inactiveTrackColor) && Color.m2920equalsimpl0(this.disabledActiveTrackColor, defaultSliderColors.disabledActiveTrackColor) && Color.m2920equalsimpl0(this.disabledInactiveTrackColor, defaultSliderColors.disabledInactiveTrackColor) && Color.m2920equalsimpl0(this.activeTickColor, defaultSliderColors.activeTickColor) && Color.m2920equalsimpl0(this.inactiveTickColor, defaultSliderColors.inactiveTickColor) && Color.m2920equalsimpl0(this.disabledActiveTickColor, defaultSliderColors.disabledActiveTickColor) && Color.m2920equalsimpl0(this.disabledInactiveTickColor, defaultSliderColors.disabledInactiveTickColor)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((((Color.m2926hashCodeimpl(this.thumbColor) * 31) + Color.m2926hashCodeimpl(this.disabledThumbColor)) * 31) + Color.m2926hashCodeimpl(this.activeTrackColor)) * 31) + Color.m2926hashCodeimpl(this.inactiveTrackColor)) * 31) + Color.m2926hashCodeimpl(this.disabledActiveTrackColor)) * 31) + Color.m2926hashCodeimpl(this.disabledInactiveTrackColor)) * 31) + Color.m2926hashCodeimpl(this.activeTickColor)) * 31) + Color.m2926hashCodeimpl(this.inactiveTickColor)) * 31) + Color.m2926hashCodeimpl(this.disabledActiveTickColor)) * 31) + Color.m2926hashCodeimpl(this.disabledInactiveTickColor);
    }

    @NotNull
    @Composable
    public State<Color> thumbColor(boolean z11, @Nullable Composer composer, int i11) {
        long j11;
        composer.startReplaceableGroup(-1733795637);
        if (z11) {
            j11 = this.thumbColor;
        } else {
            j11 = this.disabledThumbColor;
        }
        State<Color> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m2909boximpl(j11), composer, 0);
        composer.endReplaceableGroup();
        return rememberUpdatedState;
    }

    @NotNull
    @Composable
    public State<Color> tickColor(boolean z11, boolean z12, @Nullable Composer composer, int i11) {
        long j11;
        composer.startReplaceableGroup(-1491563694);
        if (z11) {
            if (z12) {
                j11 = this.activeTickColor;
            } else {
                j11 = this.inactiveTickColor;
            }
        } else if (z12) {
            j11 = this.disabledActiveTickColor;
        } else {
            j11 = this.disabledInactiveTickColor;
        }
        State<Color> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m2909boximpl(j11), composer, 0);
        composer.endReplaceableGroup();
        return rememberUpdatedState;
    }

    @NotNull
    @Composable
    public State<Color> trackColor(boolean z11, boolean z12, @Nullable Composer composer, int i11) {
        long j11;
        composer.startReplaceableGroup(1575395620);
        if (z11) {
            if (z12) {
                j11 = this.activeTrackColor;
            } else {
                j11 = this.inactiveTrackColor;
            }
        } else if (z12) {
            j11 = this.disabledActiveTrackColor;
        } else {
            j11 = this.disabledInactiveTrackColor;
        }
        State<Color> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m2909boximpl(j11), composer, 0);
        composer.endReplaceableGroup();
        return rememberUpdatedState;
    }
}
