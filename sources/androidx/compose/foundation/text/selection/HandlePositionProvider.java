package androidx.compose.foundation.text.selection;

import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.window.PopupPositionProvider;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0018\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000¢\u0006\u0002\u0010\u0006J5\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\fH\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0004\u001a\u00020\u0005X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0007\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0012"}, d2 = {"Landroidx/compose/foundation/text/selection/HandlePositionProvider;", "Landroidx/compose/ui/window/PopupPositionProvider;", "handleReferencePoint", "Landroidx/compose/foundation/text/selection/HandleReferencePoint;", "offset", "Landroidx/compose/ui/unit/IntOffset;", "(Landroidx/compose/foundation/text/selection/HandleReferencePoint;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "calculatePosition", "anchorBounds", "Landroidx/compose/ui/unit/IntRect;", "windowSize", "Landroidx/compose/ui/unit/IntSize;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "popupContentSize", "calculatePosition-llwVHH4", "(Landroidx/compose/ui/unit/IntRect;JLandroidx/compose/ui/unit/LayoutDirection;J)J", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class HandlePositionProvider implements PopupPositionProvider {
    @NotNull
    private final HandleReferencePoint handleReferencePoint;
    private final long offset;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[HandleReferencePoint.values().length];
            iArr[HandleReferencePoint.TopLeft.ordinal()] = 1;
            iArr[HandleReferencePoint.TopRight.ordinal()] = 2;
            iArr[HandleReferencePoint.TopMiddle.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private HandlePositionProvider(HandleReferencePoint handleReferencePoint2, long j11) {
        this.handleReferencePoint = handleReferencePoint2;
        this.offset = j11;
    }

    public /* synthetic */ HandlePositionProvider(HandleReferencePoint handleReferencePoint2, long j11, DefaultConstructorMarker defaultConstructorMarker) {
        this(handleReferencePoint2, j11);
    }

    /* renamed from: calculatePosition-llwVHH4  reason: not valid java name */
    public long m948calculatePositionllwVHH4(@NotNull IntRect intRect, long j11, @NotNull LayoutDirection layoutDirection, long j12) {
        Intrinsics.checkNotNullParameter(intRect, "anchorBounds");
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        int i11 = WhenMappings.$EnumSwitchMapping$0[this.handleReferencePoint.ordinal()];
        if (i11 == 1) {
            return IntOffsetKt.IntOffset(intRect.getLeft() + IntOffset.m5596getXimpl(this.offset), intRect.getTop() + IntOffset.m5597getYimpl(this.offset));
        }
        if (i11 == 2) {
            return IntOffsetKt.IntOffset((intRect.getLeft() + IntOffset.m5596getXimpl(this.offset)) - IntSize.m5638getWidthimpl(j12), intRect.getTop() + IntOffset.m5597getYimpl(this.offset));
        }
        if (i11 == 3) {
            return IntOffsetKt.IntOffset((intRect.getLeft() + IntOffset.m5596getXimpl(this.offset)) - (IntSize.m5638getWidthimpl(j12) / 2), intRect.getTop() + IntOffset.m5597getYimpl(this.offset));
        }
        throw new NoWhenBranchMatchedException();
    }
}
