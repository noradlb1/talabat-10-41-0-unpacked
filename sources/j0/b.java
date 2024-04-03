package j0;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final /* synthetic */ class b {
    public static void a(LayoutCoordinates layoutCoordinates, @NotNull LayoutCoordinates layoutCoordinates2, @NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(layoutCoordinates2, "sourceCoordinates");
        Intrinsics.checkNotNullParameter(fArr, "matrix");
        throw new UnsupportedOperationException("transformFrom is not implemented on this LayoutCoordinates");
    }

    public static /* synthetic */ Rect c(LayoutCoordinates layoutCoordinates, LayoutCoordinates layoutCoordinates2, boolean z11, int i11, Object obj) {
        if (obj == null) {
            if ((i11 & 2) != 0) {
                z11 = true;
            }
            return layoutCoordinates.localBoundingBoxOf(layoutCoordinates2, z11);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: localBoundingBoxOf");
    }
}
