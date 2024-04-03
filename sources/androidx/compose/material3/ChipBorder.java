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
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\"\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006ø\u0001\u0000¢\u0006\u0002\u0010\u0007J\u001f\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u0019\u0010\u0002\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\bR\u0019\u0010\u0005\u001a\u00020\u0006X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\tR\u0019\u0010\u0004\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\b\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0015"}, d2 = {"Landroidx/compose/material3/ChipBorder;", "", "borderColor", "Landroidx/compose/ui/graphics/Color;", "disabledBorderColor", "borderWidth", "Landroidx/compose/ui/unit/Dp;", "(JJFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "F", "borderStroke", "Landroidx/compose/runtime/State;", "Landroidx/compose/foundation/BorderStroke;", "enabled", "", "borderStroke$material3_release", "(ZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "equals", "other", "hashCode", "", "material3_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@ExperimentalMaterial3Api
public final class ChipBorder {
    private final long borderColor;
    private final float borderWidth;
    private final long disabledBorderColor;

    private ChipBorder(long j11, long j12, float f11) {
        this.borderColor = j11;
        this.disabledBorderColor = j12;
        this.borderWidth = f11;
    }

    public /* synthetic */ ChipBorder(long j11, long j12, float f11, DefaultConstructorMarker defaultConstructorMarker) {
        this(j11, j12, f11);
    }

    @NotNull
    @Composable
    public final State<BorderStroke> borderStroke$material3_release(boolean z11, @Nullable Composer composer, int i11) {
        long j11;
        composer.startReplaceableGroup(1899621712);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1899621712, i11, -1, "androidx.compose.material3.ChipBorder.borderStroke (Chip.kt:2055)");
        }
        float f11 = this.borderWidth;
        if (z11) {
            j11 = this.borderColor;
        } else {
            j11 = this.disabledBorderColor;
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
        if (obj == null || !(obj instanceof ChipBorder)) {
            return false;
        }
        ChipBorder chipBorder = (ChipBorder) obj;
        if (Color.m2920equalsimpl0(this.borderColor, chipBorder.borderColor) && Color.m2920equalsimpl0(this.disabledBorderColor, chipBorder.disabledBorderColor) && Dp.m5483equalsimpl0(this.borderWidth, chipBorder.borderWidth)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((Color.m2926hashCodeimpl(this.borderColor) * 31) + Color.m2926hashCodeimpl(this.disabledBorderColor)) * 31) + Dp.m5484hashCodeimpl(this.borderWidth);
    }
}
