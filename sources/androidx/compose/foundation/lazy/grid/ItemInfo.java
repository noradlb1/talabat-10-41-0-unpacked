package androidx.compose.foundation.lazy.grid;

import androidx.compose.ui.unit.IntOffset;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006R\u001a\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\nR%\u0010\u000f\u001a\u00020\u0010X\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001b"}, d2 = {"Landroidx/compose/foundation/lazy/grid/ItemInfo;", "", "index", "", "crossAxisSize", "crossAxisOffset", "(III)V", "getCrossAxisOffset", "()I", "setCrossAxisOffset", "(I)V", "getCrossAxisSize", "setCrossAxisSize", "getIndex", "setIndex", "notAnimatableDelta", "Landroidx/compose/ui/unit/IntOffset;", "getNotAnimatableDelta-nOcc-ac", "()J", "setNotAnimatableDelta--gyyYBs", "(J)V", "J", "placeables", "", "Landroidx/compose/foundation/lazy/grid/PlaceableInfo;", "getPlaceables", "()Ljava/util/List;", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
final class ItemInfo {
    private int crossAxisOffset;
    private int crossAxisSize;
    private int index;
    private long notAnimatableDelta = IntOffset.Companion.m5606getZeronOccac();
    @NotNull
    private final List<PlaceableInfo> placeables = new ArrayList();

    public ItemInfo(int i11, int i12, int i13) {
        this.index = i11;
        this.crossAxisSize = i12;
        this.crossAxisOffset = i13;
    }

    public final int getCrossAxisOffset() {
        return this.crossAxisOffset;
    }

    public final int getCrossAxisSize() {
        return this.crossAxisSize;
    }

    public final int getIndex() {
        return this.index;
    }

    /* renamed from: getNotAnimatableDelta-nOcc-ac  reason: not valid java name */
    public final long m677getNotAnimatableDeltanOccac() {
        return this.notAnimatableDelta;
    }

    @NotNull
    public final List<PlaceableInfo> getPlaceables() {
        return this.placeables;
    }

    public final void setCrossAxisOffset(int i11) {
        this.crossAxisOffset = i11;
    }

    public final void setCrossAxisSize(int i11) {
        this.crossAxisSize = i11;
    }

    public final void setIndex(int i11) {
        this.index = i11;
    }

    /* renamed from: setNotAnimatableDelta--gyyYBs  reason: not valid java name */
    public final void m678setNotAnimatableDeltagyyYBs(long j11) {
        this.notAnimatableDelta = j11;
    }
}
