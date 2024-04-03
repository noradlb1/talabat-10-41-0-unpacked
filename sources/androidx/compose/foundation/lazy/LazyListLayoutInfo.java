package androidx.compose.foundation.lazy;

import androidx.compose.foundation.gestures.Orientation;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import q.b;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0014\u0010\b\u001a\u00020\t8VX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\r8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0012\u0010\u0010\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0005R\u0012\u0010\u0012\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0005R\u001d\u0010\u0014\u001a\u00020\u00158VX\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0012\u0010\u0018\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0005R\u0018\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eø\u0001\u0003\u0002\u0015\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!\n\u0004\b!0\u0001¨\u0006\u001fÀ\u0006\u0003"}, d2 = {"Landroidx/compose/foundation/lazy/LazyListLayoutInfo;", "", "afterContentPadding", "", "getAfterContentPadding", "()I", "beforeContentPadding", "getBeforeContentPadding", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "getOrientation", "()Landroidx/compose/foundation/gestures/Orientation;", "reverseLayout", "", "getReverseLayout", "()Z", "totalItemsCount", "getTotalItemsCount", "viewportEndOffset", "getViewportEndOffset", "viewportSize", "Landroidx/compose/ui/unit/IntSize;", "getViewportSize-YbymL2g", "()J", "viewportStartOffset", "getViewportStartOffset", "visibleItemsInfo", "", "Landroidx/compose/foundation/lazy/LazyListItemInfo;", "getVisibleItemsInfo", "()Ljava/util/List;", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface LazyListLayoutInfo {

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static int getAfterContentPadding(@NotNull LazyListLayoutInfo lazyListLayoutInfo) {
            return b.a(lazyListLayoutInfo);
        }

        @Deprecated
        public static int getBeforeContentPadding(@NotNull LazyListLayoutInfo lazyListLayoutInfo) {
            return b.b(lazyListLayoutInfo);
        }

        @NotNull
        @Deprecated
        public static Orientation getOrientation(@NotNull LazyListLayoutInfo lazyListLayoutInfo) {
            return b.c(lazyListLayoutInfo);
        }

        @Deprecated
        public static boolean getReverseLayout(@NotNull LazyListLayoutInfo lazyListLayoutInfo) {
            return b.d(lazyListLayoutInfo);
        }

        @Deprecated
        /* renamed from: getViewportSize-YbymL2g  reason: not valid java name */
        public static long m637getViewportSizeYbymL2g(@NotNull LazyListLayoutInfo lazyListLayoutInfo) {
            return b.e(lazyListLayoutInfo);
        }
    }

    int getAfterContentPadding();

    int getBeforeContentPadding();

    @NotNull
    Orientation getOrientation();

    boolean getReverseLayout();

    int getTotalItemsCount();

    int getViewportEndOffset();

    /* renamed from: getViewportSize-YbymL2g  reason: not valid java name */
    long m636getViewportSizeYbymL2g();

    int getViewportStartOffset();

    @NotNull
    List<LazyListItemInfo> getVisibleItemsInfo();
}
