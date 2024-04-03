package e0;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.DegreesKt;
import androidx.compose.ui.graphics.Path;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final /* synthetic */ class e1 {
    static {
        Path.Companion companion = Path.Companion;
    }

    public static void a(Path path, @NotNull Rect rect, float f11, float f12, boolean z11) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        path.arcTo(rect, DegreesKt.degrees(f11), DegreesKt.degrees(f12), z11);
    }

    public static /* synthetic */ void c(Path path, Path path2, long j11, int i11, Object obj) {
        if (obj == null) {
            if ((i11 & 2) != 0) {
                j11 = Offset.Companion.m2692getZeroF1C5BW0();
            }
            path.m3150addPathUv8p0NA(path2, j11);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addPath-Uv8p0NA");
    }
}
