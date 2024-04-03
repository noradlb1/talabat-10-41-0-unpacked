package androidx.palette.graphics;

import androidx.palette.graphics.Palette;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0017\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¨\u0006\u0005"}, d2 = {"get", "Landroidx/palette/graphics/Palette$Swatch;", "Landroidx/palette/graphics/Palette;", "target", "Landroidx/palette/graphics/Target;", "palette-ktx_release"}, k = 2, mv = {1, 1, 10})
public final class PaletteKt {
    @Nullable
    public static final Palette.Swatch get(@NotNull Palette palette, @NotNull Target target) {
        Intrinsics.checkParameterIsNotNull(palette, "$receiver");
        Intrinsics.checkParameterIsNotNull(target, "target");
        return palette.getSwatchForTarget(target);
    }
}
