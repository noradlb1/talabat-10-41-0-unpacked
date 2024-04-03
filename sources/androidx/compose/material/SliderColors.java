package androidx.compose.material;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Stable;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H'ø\u0001\u0000¢\u0006\u0002\u0010\u0007J&\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H'ø\u0001\u0000¢\u0006\u0002\u0010\nJ&\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H'ø\u0001\u0000¢\u0006\u0002\u0010\n\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"Landroidx/compose/material/SliderColors;", "", "thumbColor", "Landroidx/compose/runtime/State;", "Landroidx/compose/ui/graphics/Color;", "enabled", "", "(ZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "tickColor", "active", "(ZZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "trackColor", "material_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Stable
public interface SliderColors {
    @NotNull
    @Composable
    State<Color> thumbColor(boolean z11, @Nullable Composer composer, int i11);

    @NotNull
    @Composable
    State<Color> tickColor(boolean z11, boolean z12, @Nullable Composer composer, int i11);

    @NotNull
    @Composable
    State<Color> trackColor(boolean z11, boolean z12, @Nullable Composer composer, int i11);
}
