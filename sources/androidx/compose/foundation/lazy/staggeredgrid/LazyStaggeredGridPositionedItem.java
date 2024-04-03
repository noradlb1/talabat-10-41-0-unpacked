package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001BN\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0010ø\u0001\u0000¢\u0006\u0002\u0010\u0011J\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eR\u0019\u0010\u000e\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0012R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0006\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u001f\u0010\u0002\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\t\u001a\u00020\nX\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u001a\u0010\u0019\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001f"}, d2 = {"Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridPositionedItem;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemInfo;", "offset", "Landroidx/compose/ui/unit/IntOffset;", "index", "", "lane", "key", "", "size", "Landroidx/compose/ui/unit/IntSize;", "placeables", "", "Landroidx/compose/ui/layout/Placeable;", "contentOffset", "isVertical", "", "(JIILjava/lang/Object;JLjava/util/List;JZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "getIndex", "()I", "getKey", "()Ljava/lang/Object;", "getLane", "getOffset-nOcc-ac", "()J", "getSize-YbymL2g", "place", "", "scope", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
final class LazyStaggeredGridPositionedItem implements LazyStaggeredGridItemInfo {
    private final long contentOffset;
    private final int index;
    private final boolean isVertical;
    @NotNull
    private final Object key;
    private final int lane;
    private final long offset;
    @NotNull
    private final List<Placeable> placeables;
    private final long size;

    private LazyStaggeredGridPositionedItem(long j11, int i11, int i12, Object obj, long j12, List<? extends Placeable> list, long j13, boolean z11) {
        this.offset = j11;
        this.index = i11;
        this.lane = i12;
        this.key = obj;
        this.size = j12;
        this.placeables = list;
        this.contentOffset = j13;
        this.isVertical = z11;
    }

    public /* synthetic */ LazyStaggeredGridPositionedItem(long j11, int i11, int i12, Object obj, long j12, List list, long j13, boolean z11, DefaultConstructorMarker defaultConstructorMarker) {
        this(j11, i11, i12, obj, j12, list, j13, z11);
    }

    public int getIndex() {
        return this.index;
    }

    @NotNull
    public Object getKey() {
        return this.key;
    }

    public int getLane() {
        return this.lane;
    }

    /* renamed from: getOffset-nOcc-ac  reason: not valid java name */
    public long m780getOffsetnOccac() {
        return this.offset;
    }

    /* renamed from: getSize-YbymL2g  reason: not valid java name */
    public long m781getSizeYbymL2g() {
        return this.size;
    }

    public final void place(@NotNull Placeable.PlacementScope placementScope) {
        Intrinsics.checkNotNullParameter(placementScope, "scope");
        List<Placeable> list = this.placeables;
        int size2 = list.size();
        for (int i11 = 0; i11 < size2; i11++) {
            Placeable placeable = list.get(i11);
            if (this.isVertical) {
                long r32 = m780getOffsetnOccac();
                long j11 = this.contentOffset;
                Placeable.PlacementScope.m4532placeWithLayeraW9wM$default(placementScope, placeable, IntOffsetKt.IntOffset(IntOffset.m5596getXimpl(r32) + IntOffset.m5596getXimpl(j11), IntOffset.m5597getYimpl(r32) + IntOffset.m5597getYimpl(j11)), 0.0f, (Function1) null, 6, (Object) null);
            } else {
                long r33 = m780getOffsetnOccac();
                long j12 = this.contentOffset;
                Placeable.PlacementScope.m4531placeRelativeWithLayeraW9wM$default(placementScope, placeable, IntOffsetKt.IntOffset(IntOffset.m5596getXimpl(r33) + IntOffset.m5596getXimpl(j12), IntOffset.m5597getYimpl(r33) + IntOffset.m5597getYimpl(j12)), 0.0f, (Function1) null, 6, (Object) null);
            }
        }
    }
}
