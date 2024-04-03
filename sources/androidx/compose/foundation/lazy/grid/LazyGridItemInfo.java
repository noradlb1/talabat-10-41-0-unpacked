package androidx.compose.foundation.lazy.grid;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0012\u0010\b\u001a\u00020\u0001X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u001b\u0010\u000b\u001a\u00020\fX¦\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0012\u0010\u000f\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0005R\u001b\u0010\u0011\u001a\u00020\u0012X¦\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u000e\u0001\u0001\u0015ø\u0001\u0003\u0002\u0015\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!\n\u0004\b!0\u0001¨\u0006\u0016À\u0006\u0001"}, d2 = {"Landroidx/compose/foundation/lazy/grid/LazyGridItemInfo;", "", "column", "", "getColumn", "()I", "index", "getIndex", "key", "getKey", "()Ljava/lang/Object;", "offset", "Landroidx/compose/ui/unit/IntOffset;", "getOffset-nOcc-ac", "()J", "row", "getRow", "size", "Landroidx/compose/ui/unit/IntSize;", "getSize-YbymL2g", "Companion", "Landroidx/compose/foundation/lazy/grid/LazyGridPositionedItem;", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface LazyGridItemInfo {
    @NotNull
    public static final Companion Companion = Companion.f2890a;
    public static final int UnknownColumn = -1;
    public static final int UnknownRow = -1;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Landroidx/compose/foundation/lazy/grid/LazyGridItemInfo$Companion;", "", "()V", "UnknownColumn", "", "UnknownRow", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public static final int UnknownColumn = -1;
        public static final int UnknownRow = -1;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ Companion f2890a = new Companion();

        private Companion() {
        }
    }

    int getColumn();

    int getIndex();

    @NotNull
    Object getKey();

    /* renamed from: getOffset-nOcc-ac  reason: not valid java name */
    long m685getOffsetnOccac();

    int getRow();

    /* renamed from: getSize-YbymL2g  reason: not valid java name */
    long m686getSizeYbymL2g();
}
