package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.ui.unit.IntSize;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u000eXD¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0006R\u0014\u0010\u0013\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0006R\u001f\u0010\u0015\u001a\u00020\u0016X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001a\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0006R\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 \u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006!"}, d2 = {"Landroidx/compose/foundation/lazy/grid/EmptyLazyGridLayoutInfo;", "Landroidx/compose/foundation/lazy/grid/LazyGridLayoutInfo;", "()V", "afterContentPadding", "", "getAfterContentPadding", "()I", "beforeContentPadding", "getBeforeContentPadding", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "getOrientation", "()Landroidx/compose/foundation/gestures/Orientation;", "reverseLayout", "", "getReverseLayout", "()Z", "totalItemsCount", "getTotalItemsCount", "viewportEndOffset", "getViewportEndOffset", "viewportSize", "Landroidx/compose/ui/unit/IntSize;", "getViewportSize-YbymL2g", "()J", "J", "viewportStartOffset", "getViewportStartOffset", "visibleItemsInfo", "", "Landroidx/compose/foundation/lazy/grid/LazyGridItemInfo;", "getVisibleItemsInfo", "()Ljava/util/List;", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
final class EmptyLazyGridLayoutInfo implements LazyGridLayoutInfo {
    @NotNull
    public static final EmptyLazyGridLayoutInfo INSTANCE = new EmptyLazyGridLayoutInfo();
    private static final int afterContentPadding = 0;
    private static final int beforeContentPadding = 0;
    @NotNull
    private static final Orientation orientation = Orientation.Vertical;
    private static final boolean reverseLayout = false;
    private static final int totalItemsCount = 0;
    private static final int viewportEndOffset = 0;
    private static final long viewportSize = IntSize.Companion.m5643getZeroYbymL2g();
    private static final int viewportStartOffset = 0;
    @NotNull
    private static final List<LazyGridItemInfo> visibleItemsInfo = CollectionsKt__CollectionsKt.emptyList();

    private EmptyLazyGridLayoutInfo() {
    }

    public int getAfterContentPadding() {
        return afterContentPadding;
    }

    public int getBeforeContentPadding() {
        return beforeContentPadding;
    }

    @NotNull
    public Orientation getOrientation() {
        return orientation;
    }

    public boolean getReverseLayout() {
        return reverseLayout;
    }

    public int getTotalItemsCount() {
        return totalItemsCount;
    }

    public int getViewportEndOffset() {
        return viewportEndOffset;
    }

    /* renamed from: getViewportSize-YbymL2g  reason: not valid java name */
    public long m655getViewportSizeYbymL2g() {
        return viewportSize;
    }

    public int getViewportStartOffset() {
        return viewportStartOffset;
    }

    @NotNull
    public List<LazyGridItemInfo> getVisibleItemsInfo() {
        return visibleItemsInfo;
    }
}
