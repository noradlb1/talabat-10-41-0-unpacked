package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Immutable
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B:\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\bø\u0001\u0000¢\u0006\u0002\u0010\nJ'\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u0019\u0010\u0002\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u000bR\u0019\u0010\u0007\u001a\u00020\bX\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\fR\u0019\u0010\u0005\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u000bR\u0019\u0010\u0006\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u000bR\u0019\u0010\u0004\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u000bR\u0019\u0010\t\u001a\u00020\bX\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\f\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0019"}, d2 = {"Landroidx/compose/material3/SelectableChipBorder;", "", "borderColor", "Landroidx/compose/ui/graphics/Color;", "selectedBorderColor", "disabledBorderColor", "disabledSelectedBorderColor", "borderWidth", "Landroidx/compose/ui/unit/Dp;", "selectedBorderWidth", "(JJJJFFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "F", "borderStroke", "Landroidx/compose/runtime/State;", "Landroidx/compose/foundation/BorderStroke;", "enabled", "", "selected", "borderStroke$material3_release", "(ZZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "equals", "other", "hashCode", "", "material3_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@ExperimentalMaterial3Api
public final class SelectableChipBorder {
    private final long borderColor;
    private final float borderWidth;
    private final long disabledBorderColor;
    private final long disabledSelectedBorderColor;
    private final long selectedBorderColor;
    private final float selectedBorderWidth;

    private SelectableChipBorder(long j11, long j12, long j13, long j14, float f11, float f12) {
        this.borderColor = j11;
        this.selectedBorderColor = j12;
        this.disabledBorderColor = j13;
        this.disabledSelectedBorderColor = j14;
        this.borderWidth = f11;
        this.selectedBorderWidth = f12;
    }

    public /* synthetic */ SelectableChipBorder(long j11, long j12, long j13, long j14, float f11, float f12, DefaultConstructorMarker defaultConstructorMarker) {
        this(j11, j12, j13, j14, f11, f12);
    }

    @NotNull
    @Composable
    public final State<BorderStroke> borderStroke$material3_release(boolean z11, boolean z12, @Nullable Composer composer, int i11) {
        long j11;
        float f11;
        composer.startReplaceableGroup(670222826);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(670222826, i11, -1, "androidx.compose.material3.SelectableChipBorder.borderStroke (Chip.kt:2002)");
        }
        if (z11) {
            if (z12) {
                j11 = this.selectedBorderColor;
            } else {
                j11 = this.borderColor;
            }
        } else if (z12) {
            j11 = this.disabledSelectedBorderColor;
        } else {
            j11 = this.disabledBorderColor;
        }
        if (z12) {
            f11 = this.selectedBorderWidth;
        } else {
            f11 = this.borderWidth;
        }
        State<BorderStroke> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(BorderStrokeKt.m191BorderStrokecXLIe8U(f11, j11), composer, 0);
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
        if (obj == null || !(obj instanceof SelectableChipBorder)) {
            return false;
        }
        SelectableChipBorder selectableChipBorder = (SelectableChipBorder) obj;
        if (Color.m2920equalsimpl0(this.borderColor, selectableChipBorder.borderColor) && Color.m2920equalsimpl0(this.selectedBorderColor, selectableChipBorder.selectedBorderColor) && Color.m2920equalsimpl0(this.disabledBorderColor, selectableChipBorder.disabledBorderColor) && Color.m2920equalsimpl0(this.disabledSelectedBorderColor, selectableChipBorder.disabledSelectedBorderColor) && Dp.m5483equalsimpl0(this.borderWidth, selectableChipBorder.borderWidth) && Dp.m5483equalsimpl0(this.selectedBorderWidth, selectableChipBorder.selectedBorderWidth)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((Color.m2926hashCodeimpl(this.borderColor) * 31) + Color.m2926hashCodeimpl(this.selectedBorderColor)) * 31) + Color.m2926hashCodeimpl(this.disabledBorderColor)) * 31) + Color.m2926hashCodeimpl(this.disabledSelectedBorderColor)) * 31) + Dp.m5484hashCodeimpl(this.borderWidth)) * 31) + Dp.m5484hashCodeimpl(this.selectedBorderWidth);
    }
}
