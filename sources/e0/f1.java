package e0;

import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathMeasure;

public final /* synthetic */ class f1 {
    public static /* synthetic */ boolean a(PathMeasure pathMeasure, float f11, float f12, Path path, boolean z11, int i11, Object obj) {
        if (obj == null) {
            if ((i11 & 8) != 0) {
                z11 = true;
            }
            return pathMeasure.getSegment(f11, f12, path, z11);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getSegment");
    }
}
