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
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001BJ\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0002\u0010\u000bJ \u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00030\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0001ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0016J \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0001ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0011J \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0001ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0011J \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0001ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0011R\u0019\u0010\u0002\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\fR\u0019\u0010\u0007\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\fR\u0019\u0010\b\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\fR\u0019\u0010\t\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\fR\u0019\u0010\n\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\fR\u0019\u0010\u0004\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\fR\u0019\u0010\u0005\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\fR\u0019\u0010\u0006\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\f\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0019"}, d2 = {"Landroidx/compose/material3/ChipColors;", "", "containerColor", "Landroidx/compose/ui/graphics/Color;", "labelColor", "leadingIconContentColor", "trailingIconContentColor", "disabledContainerColor", "disabledLabelColor", "disabledLeadingIconContentColor", "disabledTrailingIconContentColor", "(JJJJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "Landroidx/compose/runtime/State;", "enabled", "", "containerColor$material3_release", "(ZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "equals", "other", "hashCode", "", "labelColor$material3_release", "leadingIconContentColor$material3_release", "trailingIconContentColor$material3_release", "material3_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@ExperimentalMaterial3Api
public final class ChipColors {
    private final long containerColor;
    private final long disabledContainerColor;
    private final long disabledLabelColor;
    private final long disabledLeadingIconContentColor;
    private final long disabledTrailingIconContentColor;
    private final long labelColor;
    private final long leadingIconContentColor;
    private final long trailingIconContentColor;

    private ChipColors(long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18) {
        this.containerColor = j11;
        this.labelColor = j12;
        this.leadingIconContentColor = j13;
        this.trailingIconContentColor = j14;
        this.disabledContainerColor = j15;
        this.disabledLabelColor = j16;
        this.disabledLeadingIconContentColor = j17;
        this.disabledTrailingIconContentColor = j18;
    }

    public /* synthetic */ ChipColors(long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, DefaultConstructorMarker defaultConstructorMarker) {
        this(j11, j12, j13, j14, j15, j16, j17, j18);
    }

    @NotNull
    @Composable
    public final State<Color> containerColor$material3_release(boolean z11, @Nullable Composer composer, int i11) {
        long j11;
        composer.startReplaceableGroup(-136683658);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-136683658, i11, -1, "androidx.compose.material3.ChipColors.containerColor (Chip.kt:1785)");
        }
        if (z11) {
            j11 = this.containerColor;
        } else {
            j11 = this.disabledContainerColor;
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
        if (obj == null || !(obj instanceof ChipColors)) {
            return false;
        }
        ChipColors chipColors = (ChipColors) obj;
        if (Color.m2920equalsimpl0(this.containerColor, chipColors.containerColor) && Color.m2920equalsimpl0(this.labelColor, chipColors.labelColor) && Color.m2920equalsimpl0(this.leadingIconContentColor, chipColors.leadingIconContentColor) && Color.m2920equalsimpl0(this.trailingIconContentColor, chipColors.trailingIconContentColor) && Color.m2920equalsimpl0(this.disabledContainerColor, chipColors.disabledContainerColor) && Color.m2920equalsimpl0(this.disabledLabelColor, chipColors.disabledLabelColor) && Color.m2920equalsimpl0(this.disabledLeadingIconContentColor, chipColors.disabledLeadingIconContentColor) && Color.m2920equalsimpl0(this.disabledTrailingIconContentColor, chipColors.disabledTrailingIconContentColor)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((Color.m2926hashCodeimpl(this.containerColor) * 31) + Color.m2926hashCodeimpl(this.labelColor)) * 31) + Color.m2926hashCodeimpl(this.leadingIconContentColor)) * 31) + Color.m2926hashCodeimpl(this.trailingIconContentColor)) * 31) + Color.m2926hashCodeimpl(this.disabledContainerColor)) * 31) + Color.m2926hashCodeimpl(this.disabledLabelColor)) * 31) + Color.m2926hashCodeimpl(this.disabledLeadingIconContentColor)) * 31) + Color.m2926hashCodeimpl(this.disabledTrailingIconContentColor);
    }

    @NotNull
    @Composable
    public final State<Color> labelColor$material3_release(boolean z11, @Nullable Composer composer, int i11) {
        long j11;
        composer.startReplaceableGroup(559848681);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(559848681, i11, -1, "androidx.compose.material3.ChipColors.labelColor (Chip.kt:1795)");
        }
        if (z11) {
            j11 = this.labelColor;
        } else {
            j11 = this.disabledLabelColor;
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
    public final State<Color> leadingIconContentColor$material3_release(boolean z11, @Nullable Composer composer, int i11) {
        long j11;
        composer.startReplaceableGroup(5136811);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(5136811, i11, -1, "androidx.compose.material3.ChipColors.leadingIconContentColor (Chip.kt:1805)");
        }
        if (z11) {
            j11 = this.leadingIconContentColor;
        } else {
            j11 = this.disabledLeadingIconContentColor;
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
    public final State<Color> trailingIconContentColor$material3_release(boolean z11, @Nullable Composer composer, int i11) {
        long j11;
        composer.startReplaceableGroup(96182905);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(96182905, i11, -1, "androidx.compose.material3.ChipColors.trailingIconContentColor (Chip.kt:1817)");
        }
        if (z11) {
            j11 = this.trailingIconContentColor;
        } else {
            j11 = this.disabledTrailingIconContentColor;
        }
        State<Color> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m2909boximpl(j11), composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return rememberUpdatedState;
    }
}
