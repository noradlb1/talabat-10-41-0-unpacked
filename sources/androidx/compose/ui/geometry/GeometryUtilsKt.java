package androidx.compose.ui.geometry;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000¨\u0006\u0005"}, d2 = {"toStringAsFixed", "", "", "digits", "", "ui-geometry_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class GeometryUtilsKt {
    @NotNull
    public static final String toStringAsFixed(float f11, int i11) {
        int max = Math.max(i11, 0);
        float pow = (float) Math.pow((double) 10.0f, (double) max);
        float f12 = f11 * pow;
        int i12 = (int) f12;
        if (f12 - ((float) i12) >= 0.5f) {
            i12++;
        }
        float f13 = ((float) i12) / pow;
        if (max > 0) {
            return String.valueOf(f13);
        }
        return String.valueOf((int) f13);
    }
}
