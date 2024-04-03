package androidx.compose.ui.unit;

import androidx.compose.runtime.Stable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u001a\u001a\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u0007¨\u0006\u0005"}, d2 = {"Density", "Landroidx/compose/ui/unit/Density;", "density", "", "fontScale", "ui-unit_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class DensityKt {
    @NotNull
    @Stable
    public static final Density Density(float f11, float f12) {
        return new DensityImpl(f11, f12);
    }

    public static /* synthetic */ Density Density$default(float f11, float f12, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            f12 = 1.0f;
        }
        return Density(f11, f12);
    }
}
