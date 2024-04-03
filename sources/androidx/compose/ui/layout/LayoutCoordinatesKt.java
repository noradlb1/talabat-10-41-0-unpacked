package androidx.compose.ui.layout;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.unit.IntSize;
import j0.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0004\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0005\u001a\u00020\u0002*\u00020\u0002\u001a\u0012\u0010\u0006\u001a\u00020\u0007*\u00020\u0002ø\u0001\u0000¢\u0006\u0002\u0010\b\u001a\u0012\u0010\t\u001a\u00020\u0007*\u00020\u0002ø\u0001\u0000¢\u0006\u0002\u0010\b\u001a\u0012\u0010\n\u001a\u00020\u0007*\u00020\u0002ø\u0001\u0000¢\u0006\u0002\u0010\b\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b"}, d2 = {"boundsInParent", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "boundsInRoot", "boundsInWindow", "findRootCoordinates", "positionInParent", "Landroidx/compose/ui/geometry/Offset;", "(Landroidx/compose/ui/layout/LayoutCoordinates;)J", "positionInRoot", "positionInWindow", "ui_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class LayoutCoordinatesKt {
    @NotNull
    public static final Rect boundsInParent(@NotNull LayoutCoordinates layoutCoordinates) {
        Rect c11;
        Intrinsics.checkNotNullParameter(layoutCoordinates, "<this>");
        LayoutCoordinates parentLayoutCoordinates = layoutCoordinates.getParentLayoutCoordinates();
        if (parentLayoutCoordinates == null || (c11 = b.c(parentLayoutCoordinates, layoutCoordinates, false, 2, (Object) null)) == null) {
            return new Rect(0.0f, 0.0f, (float) IntSize.m5638getWidthimpl(layoutCoordinates.m4473getSizeYbymL2g()), (float) IntSize.m5637getHeightimpl(layoutCoordinates.m4473getSizeYbymL2g()));
        }
        return c11;
    }

    @NotNull
    public static final Rect boundsInRoot(@NotNull LayoutCoordinates layoutCoordinates) {
        Intrinsics.checkNotNullParameter(layoutCoordinates, "<this>");
        return b.c(findRootCoordinates(layoutCoordinates), layoutCoordinates, false, 2, (Object) null);
    }

    @NotNull
    public static final Rect boundsInWindow(@NotNull LayoutCoordinates layoutCoordinates) {
        boolean z11;
        boolean z12;
        Intrinsics.checkNotNullParameter(layoutCoordinates, "<this>");
        LayoutCoordinates findRootCoordinates = findRootCoordinates(layoutCoordinates);
        Rect boundsInRoot = boundsInRoot(layoutCoordinates);
        float r22 = (float) IntSize.m5638getWidthimpl(findRootCoordinates.m4473getSizeYbymL2g());
        float r32 = (float) IntSize.m5637getHeightimpl(findRootCoordinates.m4473getSizeYbymL2g());
        float coerceIn = RangesKt___RangesKt.coerceIn(boundsInRoot.getLeft(), 0.0f, r22);
        float coerceIn2 = RangesKt___RangesKt.coerceIn(boundsInRoot.getTop(), 0.0f, r32);
        float coerceIn3 = RangesKt___RangesKt.coerceIn(boundsInRoot.getRight(), 0.0f, r22);
        float coerceIn4 = RangesKt___RangesKt.coerceIn(boundsInRoot.getBottom(), 0.0f, r32);
        if (coerceIn == coerceIn3) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            if (coerceIn2 == coerceIn4) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (!z12) {
                long r82 = findRootCoordinates.m4476localToWindowMKHz9U(OffsetKt.Offset(coerceIn, coerceIn2));
                long r102 = findRootCoordinates.m4476localToWindowMKHz9U(OffsetKt.Offset(coerceIn3, coerceIn2));
                long r23 = findRootCoordinates.m4476localToWindowMKHz9U(OffsetKt.Offset(coerceIn3, coerceIn4));
                long r02 = findRootCoordinates.m4476localToWindowMKHz9U(OffsetKt.Offset(coerceIn, coerceIn4));
                return new Rect(ComparisonsKt___ComparisonsJvmKt.minOf(Offset.m2676getXimpl(r82), Offset.m2676getXimpl(r102), Offset.m2676getXimpl(r02), Offset.m2676getXimpl(r23)), ComparisonsKt___ComparisonsJvmKt.minOf(Offset.m2677getYimpl(r82), Offset.m2677getYimpl(r102), Offset.m2677getYimpl(r02), Offset.m2677getYimpl(r23)), ComparisonsKt___ComparisonsJvmKt.maxOf(Offset.m2676getXimpl(r82), Offset.m2676getXimpl(r102), Offset.m2676getXimpl(r02), Offset.m2676getXimpl(r23)), ComparisonsKt___ComparisonsJvmKt.maxOf(Offset.m2677getYimpl(r82), Offset.m2677getYimpl(r102), Offset.m2677getYimpl(r02), Offset.m2677getYimpl(r23)));
            }
        }
        return Rect.Companion.getZero();
    }

    @NotNull
    public static final LayoutCoordinates findRootCoordinates(@NotNull LayoutCoordinates layoutCoordinates) {
        LayoutCoordinates layoutCoordinates2;
        NodeCoordinator nodeCoordinator;
        Intrinsics.checkNotNullParameter(layoutCoordinates, "<this>");
        LayoutCoordinates parentLayoutCoordinates = layoutCoordinates.getParentLayoutCoordinates();
        while (true) {
            LayoutCoordinates layoutCoordinates3 = parentLayoutCoordinates;
            layoutCoordinates2 = layoutCoordinates;
            layoutCoordinates = layoutCoordinates3;
            if (layoutCoordinates == null) {
                break;
            }
            parentLayoutCoordinates = layoutCoordinates.getParentLayoutCoordinates();
        }
        if (layoutCoordinates2 instanceof NodeCoordinator) {
            nodeCoordinator = (NodeCoordinator) layoutCoordinates2;
        } else {
            nodeCoordinator = null;
        }
        if (nodeCoordinator == null) {
            return layoutCoordinates2;
        }
        NodeCoordinator wrappedBy$ui_release = nodeCoordinator.getWrappedBy$ui_release();
        while (true) {
            NodeCoordinator nodeCoordinator2 = wrappedBy$ui_release;
            NodeCoordinator nodeCoordinator3 = nodeCoordinator;
            nodeCoordinator = nodeCoordinator2;
            if (nodeCoordinator == null) {
                return nodeCoordinator3;
            }
            wrappedBy$ui_release = nodeCoordinator.getWrappedBy$ui_release();
        }
    }

    public static final long positionInParent(@NotNull LayoutCoordinates layoutCoordinates) {
        Intrinsics.checkNotNullParameter(layoutCoordinates, "<this>");
        LayoutCoordinates parentLayoutCoordinates = layoutCoordinates.getParentLayoutCoordinates();
        if (parentLayoutCoordinates != null) {
            return parentLayoutCoordinates.m4474localPositionOfR5De75A(layoutCoordinates, Offset.Companion.m2692getZeroF1C5BW0());
        }
        return Offset.Companion.m2692getZeroF1C5BW0();
    }

    public static final long positionInRoot(@NotNull LayoutCoordinates layoutCoordinates) {
        Intrinsics.checkNotNullParameter(layoutCoordinates, "<this>");
        return layoutCoordinates.m4475localToRootMKHz9U(Offset.Companion.m2692getZeroF1C5BW0());
    }

    public static final long positionInWindow(@NotNull LayoutCoordinates layoutCoordinates) {
        Intrinsics.checkNotNullParameter(layoutCoordinates, "<this>");
        return layoutCoordinates.m4476localToWindowMKHz9U(Offset.Companion.m2692getZeroF1C5BW0());
    }
}
