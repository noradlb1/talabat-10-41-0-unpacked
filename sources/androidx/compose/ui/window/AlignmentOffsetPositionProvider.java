package androidx.compose.ui.window;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0018\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000¢\u0006\u0002\u0010\u0006J5\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0010H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0016"}, d2 = {"Landroidx/compose/ui/window/AlignmentOffsetPositionProvider;", "Landroidx/compose/ui/window/PopupPositionProvider;", "alignment", "Landroidx/compose/ui/Alignment;", "offset", "Landroidx/compose/ui/unit/IntOffset;", "(Landroidx/compose/ui/Alignment;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAlignment", "()Landroidx/compose/ui/Alignment;", "getOffset-nOcc-ac", "()J", "J", "calculatePosition", "anchorBounds", "Landroidx/compose/ui/unit/IntRect;", "windowSize", "Landroidx/compose/ui/unit/IntSize;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "popupContentSize", "calculatePosition-llwVHH4", "(Landroidx/compose/ui/unit/IntRect;JLandroidx/compose/ui/unit/LayoutDirection;J)J", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AlignmentOffsetPositionProvider implements PopupPositionProvider {
    @NotNull
    private final Alignment alignment;
    private final long offset;

    private AlignmentOffsetPositionProvider(Alignment alignment2, long j11) {
        this.alignment = alignment2;
        this.offset = j11;
    }

    public /* synthetic */ AlignmentOffsetPositionProvider(Alignment alignment2, long j11, DefaultConstructorMarker defaultConstructorMarker) {
        this(alignment2, j11);
    }

    /* renamed from: calculatePosition-llwVHH4  reason: not valid java name */
    public long m5722calculatePositionllwVHH4(@NotNull IntRect intRect, long j11, @NotNull LayoutDirection layoutDirection, long j12) {
        int i11;
        LayoutDirection layoutDirection2 = layoutDirection;
        IntRect intRect2 = intRect;
        Intrinsics.checkNotNullParameter(intRect, "anchorBounds");
        Intrinsics.checkNotNullParameter(layoutDirection2, "layoutDirection");
        long IntOffset = IntOffsetKt.IntOffset(0, 0);
        Alignment alignment2 = this.alignment;
        IntSize.Companion companion = IntSize.Companion;
        LayoutDirection layoutDirection3 = layoutDirection;
        long r12 = alignment2.m2554alignKFBX0sM(companion.m5643getZeroYbymL2g(), IntSizeKt.IntSize(intRect.getWidth(), intRect.getHeight()), layoutDirection3);
        long r13 = this.alignment.m2554alignKFBX0sM(companion.m5643getZeroYbymL2g(), IntSizeKt.IntSize(IntSize.m5638getWidthimpl(j12), IntSize.m5637getHeightimpl(j12)), layoutDirection3);
        long IntOffset2 = IntOffsetKt.IntOffset(intRect.getLeft(), intRect.getTop());
        long IntOffset3 = IntOffsetKt.IntOffset(IntOffset.m5596getXimpl(IntOffset) + IntOffset.m5596getXimpl(IntOffset2), IntOffset.m5597getYimpl(IntOffset) + IntOffset.m5597getYimpl(IntOffset2));
        long IntOffset4 = IntOffsetKt.IntOffset(IntOffset.m5596getXimpl(IntOffset3) + IntOffset.m5596getXimpl(r12), IntOffset.m5597getYimpl(IntOffset3) + IntOffset.m5597getYimpl(r12));
        long IntOffset5 = IntOffsetKt.IntOffset(IntOffset.m5596getXimpl(r13), IntOffset.m5597getYimpl(r13));
        long IntOffset6 = IntOffsetKt.IntOffset(IntOffset.m5596getXimpl(IntOffset4) - IntOffset.m5596getXimpl(IntOffset5), IntOffset.m5597getYimpl(IntOffset4) - IntOffset.m5597getYimpl(IntOffset5));
        int r32 = IntOffset.m5596getXimpl(this.offset);
        if (layoutDirection2 == LayoutDirection.Ltr) {
            i11 = 1;
        } else {
            i11 = -1;
        }
        long IntOffset7 = IntOffsetKt.IntOffset(r32 * i11, IntOffset.m5597getYimpl(this.offset));
        return IntOffsetKt.IntOffset(IntOffset.m5596getXimpl(IntOffset6) + IntOffset.m5596getXimpl(IntOffset7), IntOffset.m5597getYimpl(IntOffset6) + IntOffset.m5597getYimpl(IntOffset7));
    }

    @NotNull
    public final Alignment getAlignment() {
        return this.alignment;
    }

    /* renamed from: getOffset-nOcc-ac  reason: not valid java name */
    public final long m5723getOffsetnOccac() {
        return this.offset;
    }
}
