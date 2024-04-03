package androidx.compose.ui.layout;

import androidx.compose.ui.geometry.Rect;
import j0.b;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0011\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\fH¦\u0002J\u001a\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0019\u001a\u00020\u0003H&J%\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001bH&ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001eJ\u001d\u0010\u001f\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020\u001bH&ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b!\u0010\"J\u001d\u0010#\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020\u001bH&ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b$\u0010\"J%\u0010%\u001a\u00020&2\u0006\u0010\u0018\u001a\u00020\u00002\u0006\u0010'\u001a\u00020(H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b)\u0010*J\u001d\u0010+\u001a\u00020\u001b2\u0006\u0010,\u001a\u00020\u001bH&ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b-\u0010\"R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u0000X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u0004\u0018\u00010\u0000X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007R\u0018\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u000f\u001a\u00020\u0010X¦\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012ø\u0001\u0003\u0002\u0015\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!\n\u0004\b!0\u0001¨\u0006.À\u0006\u0003"}, d2 = {"Landroidx/compose/ui/layout/LayoutCoordinates;", "", "isAttached", "", "()Z", "parentCoordinates", "getParentCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "parentLayoutCoordinates", "getParentLayoutCoordinates", "providedAlignmentLines", "", "Landroidx/compose/ui/layout/AlignmentLine;", "getProvidedAlignmentLines", "()Ljava/util/Set;", "size", "Landroidx/compose/ui/unit/IntSize;", "getSize-YbymL2g", "()J", "get", "", "alignmentLine", "localBoundingBoxOf", "Landroidx/compose/ui/geometry/Rect;", "sourceCoordinates", "clipBounds", "localPositionOf", "Landroidx/compose/ui/geometry/Offset;", "relativeToSource", "localPositionOf-R5De75A", "(Landroidx/compose/ui/layout/LayoutCoordinates;J)J", "localToRoot", "relativeToLocal", "localToRoot-MK-Hz9U", "(J)J", "localToWindow", "localToWindow-MK-Hz9U", "transformFrom", "", "matrix", "Landroidx/compose/ui/graphics/Matrix;", "transformFrom-EL8BTi8", "(Landroidx/compose/ui/layout/LayoutCoordinates;[F)V", "windowToLocal", "relativeToWindow", "windowToLocal-MK-Hz9U", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface LayoutCoordinates {

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        /* renamed from: transformFrom-EL8BTi8  reason: not valid java name */
        public static void m4479transformFromEL8BTi8(@NotNull LayoutCoordinates layoutCoordinates, @NotNull LayoutCoordinates layoutCoordinates2, @NotNull float[] fArr) {
            Intrinsics.checkNotNullParameter(layoutCoordinates2, "sourceCoordinates");
            Intrinsics.checkNotNullParameter(fArr, "matrix");
            b.a(layoutCoordinates, layoutCoordinates2, fArr);
        }
    }

    int get(@NotNull AlignmentLine alignmentLine);

    @Nullable
    LayoutCoordinates getParentCoordinates();

    @Nullable
    LayoutCoordinates getParentLayoutCoordinates();

    @NotNull
    Set<AlignmentLine> getProvidedAlignmentLines();

    /* renamed from: getSize-YbymL2g  reason: not valid java name */
    long m4473getSizeYbymL2g();

    boolean isAttached();

    @NotNull
    Rect localBoundingBoxOf(@NotNull LayoutCoordinates layoutCoordinates, boolean z11);

    /* renamed from: localPositionOf-R5De75A  reason: not valid java name */
    long m4474localPositionOfR5De75A(@NotNull LayoutCoordinates layoutCoordinates, long j11);

    /* renamed from: localToRoot-MK-Hz9U  reason: not valid java name */
    long m4475localToRootMKHz9U(long j11);

    /* renamed from: localToWindow-MK-Hz9U  reason: not valid java name */
    long m4476localToWindowMKHz9U(long j11);

    /* renamed from: transformFrom-EL8BTi8  reason: not valid java name */
    void m4477transformFromEL8BTi8(@NotNull LayoutCoordinates layoutCoordinates, @NotNull float[] fArr);

    /* renamed from: windowToLocal-MK-Hz9U  reason: not valid java name */
    long m4478windowToLocalMKHz9U(long j11);
}
