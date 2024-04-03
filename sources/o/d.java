package o;

import androidx.compose.foundation.gestures.TransformScope;
import androidx.compose.ui.geometry.Offset;

public final /* synthetic */ class d {
    public static /* synthetic */ void a(TransformScope transformScope, float f11, long j11, float f12, int i11, Object obj) {
        if (obj == null) {
            if ((i11 & 1) != 0) {
                f11 = 1.0f;
            }
            if ((i11 & 2) != 0) {
                j11 = Offset.Companion.m2692getZeroF1C5BW0();
            }
            if ((i11 & 4) != 0) {
                f12 = 0.0f;
            }
            transformScope.m361transformByd4ec7I(f11, j11, f12);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: transformBy-d-4ec7I");
    }
}
