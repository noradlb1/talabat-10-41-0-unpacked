package androidx.compose.ui.input.pointer;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.unit.IntSize;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0007\u001a\n\u0010\u0003\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0004\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0005\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0006\u001a\u00020\u0001*\u00020\u0002\u001a\f\u0010\u0007\u001a\u00020\b*\u00020\u0002H\u0007\u001a\f\u0010\t\u001a\u00020\b*\u00020\u0002H\u0007\u001a\f\u0010\n\u001a\u00020\b*\u00020\u0002H\u0007\u001a!\u0010\u000b\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\f\u001a\u00020\rH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000e\u0010\u000f\u001a'\u0010\u000b\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u0012\u0010\u0014\u001a\u00020\u0015*\u00020\u0002ø\u0001\u0001¢\u0006\u0002\u0010\u0016\u001a\f\u0010\u0017\u001a\u00020\u0001*\u00020\u0002H\u0007\u001a\u0012\u0010\u0018\u001a\u00020\u0015*\u00020\u0002ø\u0001\u0001¢\u0006\u0002\u0010\u0016\u001a\u001e\u0010\u0019\u001a\u00020\u0015*\u00020\u00022\b\b\u0002\u0010\u001a\u001a\u00020\u0001H\u0002ø\u0001\u0001¢\u0006\u0002\u0010\u001b\u001a\n\u0010\u001c\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u001d\u001a\u00020\u0001*\u00020\u0002\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u001e"}, d2 = {"anyChangeConsumed", "", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "changedToDown", "changedToDownIgnoreConsumed", "changedToUp", "changedToUpIgnoreConsumed", "consumeAllChanges", "", "consumeDownChange", "consumePositionChange", "isOutOfBounds", "size", "Landroidx/compose/ui/unit/IntSize;", "isOutOfBounds-O0kMr_c", "(Landroidx/compose/ui/input/pointer/PointerInputChange;J)Z", "extendedTouchPadding", "Landroidx/compose/ui/geometry/Size;", "isOutOfBounds-jwHxaWs", "(Landroidx/compose/ui/input/pointer/PointerInputChange;JJ)Z", "positionChange", "Landroidx/compose/ui/geometry/Offset;", "(Landroidx/compose/ui/input/pointer/PointerInputChange;)J", "positionChangeConsumed", "positionChangeIgnoreConsumed", "positionChangeInternal", "ignoreConsumed", "(Landroidx/compose/ui/input/pointer/PointerInputChange;Z)J", "positionChanged", "positionChangedIgnoreConsumed", "ui_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class PointerEventKt {
    @Deprecated(message = "Partial consumption has been deprecated. Use isConsumed instead", replaceWith = @ReplaceWith(expression = "isConsumed", imports = {}))
    public static final boolean anyChangeConsumed(@NotNull PointerInputChange pointerInputChange) {
        Intrinsics.checkNotNullParameter(pointerInputChange, "<this>");
        return pointerInputChange.isConsumed();
    }

    public static final boolean changedToDown(@NotNull PointerInputChange pointerInputChange) {
        Intrinsics.checkNotNullParameter(pointerInputChange, "<this>");
        if (pointerInputChange.isConsumed() || pointerInputChange.getPreviousPressed() || !pointerInputChange.getPressed()) {
            return false;
        }
        return true;
    }

    public static final boolean changedToDownIgnoreConsumed(@NotNull PointerInputChange pointerInputChange) {
        Intrinsics.checkNotNullParameter(pointerInputChange, "<this>");
        if (pointerInputChange.getPreviousPressed() || !pointerInputChange.getPressed()) {
            return false;
        }
        return true;
    }

    public static final boolean changedToUp(@NotNull PointerInputChange pointerInputChange) {
        Intrinsics.checkNotNullParameter(pointerInputChange, "<this>");
        if (pointerInputChange.isConsumed() || !pointerInputChange.getPreviousPressed() || pointerInputChange.getPressed()) {
            return false;
        }
        return true;
    }

    public static final boolean changedToUpIgnoreConsumed(@NotNull PointerInputChange pointerInputChange) {
        Intrinsics.checkNotNullParameter(pointerInputChange, "<this>");
        if (!pointerInputChange.getPreviousPressed() || pointerInputChange.getPressed()) {
            return false;
        }
        return true;
    }

    @Deprecated(message = "Use consume() instead", replaceWith = @ReplaceWith(expression = "consume()", imports = {}))
    public static final void consumeAllChanges(@NotNull PointerInputChange pointerInputChange) {
        Intrinsics.checkNotNullParameter(pointerInputChange, "<this>");
        pointerInputChange.consume();
    }

    @Deprecated(message = "Partial consumption has been deprecated. Use consume() instead.", replaceWith = @ReplaceWith(expression = "if (pressed != previousPressed) consume()", imports = {}))
    public static final void consumeDownChange(@NotNull PointerInputChange pointerInputChange) {
        Intrinsics.checkNotNullParameter(pointerInputChange, "<this>");
        if (pointerInputChange.getPressed() != pointerInputChange.getPreviousPressed()) {
            pointerInputChange.consume();
        }
    }

    @Deprecated(message = "Partial consumption has been deprecated. Use consume() instead.", replaceWith = @ReplaceWith(expression = "if (positionChange() != Offset.Zero) consume()", imports = {}))
    public static final void consumePositionChange(@NotNull PointerInputChange pointerInputChange) {
        Intrinsics.checkNotNullParameter(pointerInputChange, "<this>");
        if (!Offset.m2673equalsimpl0(positionChange(pointerInputChange), Offset.Companion.m2692getZeroF1C5BW0())) {
            pointerInputChange.consume();
        }
    }

    @Deprecated(message = "Use isOutOfBounds() that supports minimum touch target", replaceWith = @ReplaceWith(expression = "this.isOutOfBounds(size, extendedTouchPadding)", imports = {}))
    /* renamed from: isOutOfBounds-O0kMr_c  reason: not valid java name */
    public static final boolean m4253isOutOfBoundsO0kMr_c(@NotNull PointerInputChange pointerInputChange, long j11) {
        Intrinsics.checkNotNullParameter(pointerInputChange, "$this$isOutOfBounds");
        long r02 = pointerInputChange.m4306getPositionF1C5BW0();
        float r32 = Offset.m2676getXimpl(r02);
        float r03 = Offset.m2677getYimpl(r02);
        int r12 = IntSize.m5638getWidthimpl(j11);
        int r42 = IntSize.m5637getHeightimpl(j11);
        if (r32 < 0.0f || r32 > ((float) r12) || r03 < 0.0f || r03 > ((float) r42)) {
            return true;
        }
        return false;
    }

    /* renamed from: isOutOfBounds-jwHxaWs  reason: not valid java name */
    public static final boolean m4254isOutOfBoundsjwHxaWs(@NotNull PointerInputChange pointerInputChange, long j11, long j12) {
        Intrinsics.checkNotNullParameter(pointerInputChange, "$this$isOutOfBounds");
        if (!PointerType.m4365equalsimpl0(pointerInputChange.m4309getTypeT8wyACA(), PointerType.Companion.m4372getTouchT8wyACA())) {
            return m4253isOutOfBoundsO0kMr_c(pointerInputChange, j11);
        }
        long r02 = pointerInputChange.m4306getPositionF1C5BW0();
        float r42 = Offset.m2676getXimpl(r02);
        float r03 = Offset.m2677getYimpl(r02);
        float r22 = ((float) IntSize.m5638getWidthimpl(j11)) + Size.m2745getWidthimpl(j12);
        float f11 = -Size.m2742getHeightimpl(j12);
        float r52 = ((float) IntSize.m5637getHeightimpl(j11)) + Size.m2742getHeightimpl(j12);
        if (r42 < (-Size.m2745getWidthimpl(j12)) || r42 > r22 || r03 < f11 || r03 > r52) {
            return true;
        }
        return false;
    }

    public static final long positionChange(@NotNull PointerInputChange pointerInputChange) {
        Intrinsics.checkNotNullParameter(pointerInputChange, "<this>");
        return positionChangeInternal(pointerInputChange, false);
    }

    @Deprecated(message = "Partial consumption has been deprecated. Use isConsumed instead", replaceWith = @ReplaceWith(expression = "isConsumed", imports = {}))
    public static final boolean positionChangeConsumed(@NotNull PointerInputChange pointerInputChange) {
        Intrinsics.checkNotNullParameter(pointerInputChange, "<this>");
        return pointerInputChange.isConsumed();
    }

    public static final long positionChangeIgnoreConsumed(@NotNull PointerInputChange pointerInputChange) {
        Intrinsics.checkNotNullParameter(pointerInputChange, "<this>");
        return positionChangeInternal(pointerInputChange, true);
    }

    private static final long positionChangeInternal(PointerInputChange pointerInputChange, boolean z11) {
        long r02 = Offset.m2680minusMKHz9U(pointerInputChange.m4306getPositionF1C5BW0(), pointerInputChange.m4307getPreviousPositionF1C5BW0());
        if (z11 || !pointerInputChange.isConsumed()) {
            return r02;
        }
        return Offset.Companion.m2692getZeroF1C5BW0();
    }

    public static final boolean positionChanged(@NotNull PointerInputChange pointerInputChange) {
        Intrinsics.checkNotNullParameter(pointerInputChange, "<this>");
        return !Offset.m2673equalsimpl0(positionChangeInternal(pointerInputChange, false), Offset.Companion.m2692getZeroF1C5BW0());
    }

    public static final boolean positionChangedIgnoreConsumed(@NotNull PointerInputChange pointerInputChange) {
        Intrinsics.checkNotNullParameter(pointerInputChange, "<this>");
        return !Offset.m2673equalsimpl0(positionChangeInternal(pointerInputChange, true), Offset.Companion.m2692getZeroF1C5BW0());
    }
}
