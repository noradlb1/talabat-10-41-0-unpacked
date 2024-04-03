package androidx.compose.material3;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ReadOnlyComposable;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b8G¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f8G¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Landroidx/compose/material3/MaterialTheme;", "", "()V", "colorScheme", "Landroidx/compose/material3/ColorScheme;", "getColorScheme", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/ColorScheme;", "shapes", "Landroidx/compose/material3/Shapes;", "getShapes", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/Shapes;", "typography", "Landroidx/compose/material3/Typography;", "getTypography", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/Typography;", "material3_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class MaterialTheme {
    public static final int $stable = 0;
    @NotNull
    public static final MaterialTheme INSTANCE = new MaterialTheme();

    private MaterialTheme() {
    }

    @ReadOnlyComposable
    @NotNull
    @Composable
    @JvmName(name = "getColorScheme")
    public final ColorScheme getColorScheme(@Nullable Composer composer, int i11) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-561618718, i11, -1, "androidx.compose.material3.MaterialTheme.<get-colorScheme> (MaterialTheme.kt:95)");
        }
        ColorScheme colorScheme = (ColorScheme) composer.consume(ColorSchemeKt.getLocalColorScheme());
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return colorScheme;
    }

    @ReadOnlyComposable
    @NotNull
    @Composable
    @JvmName(name = "getShapes")
    public final Shapes getShapes(@Nullable Composer composer, int i11) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(419509830, i11, -1, "androidx.compose.material3.MaterialTheme.<get-shapes> (MaterialTheme.kt:111)");
        }
        Shapes shapes = (Shapes) composer.consume(ShapesKt.getLocalShapes());
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return shapes;
    }

    @ReadOnlyComposable
    @NotNull
    @Composable
    @JvmName(name = "getTypography")
    public final Typography getTypography(@Nullable Composer composer, int i11) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-942794935, i11, -1, "androidx.compose.material3.MaterialTheme.<get-typography> (MaterialTheme.kt:103)");
        }
        Typography typography = (Typography) composer.consume(TypographyKt.getLocalTypography());
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return typography;
    }
}
