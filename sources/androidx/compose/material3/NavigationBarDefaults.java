package androidx.compose.material3;

import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsetsSides;
import androidx.compose.material3.tokens.NavigationBarTokens;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\t8Gø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r8G¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0010"}, d2 = {"Landroidx/compose/material3/NavigationBarDefaults;", "", "()V", "Elevation", "Landroidx/compose/ui/unit/Dp;", "getElevation-D9Ej5fM", "()F", "F", "containerColor", "Landroidx/compose/ui/graphics/Color;", "getContainerColor", "(Landroidx/compose/runtime/Composer;I)J", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "getWindowInsets", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/layout/WindowInsets;", "material3_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class NavigationBarDefaults {
    public static final int $stable = 0;
    private static final float Elevation = NavigationBarTokens.INSTANCE.m2280getContainerElevationD9Ej5fM();
    @NotNull
    public static final NavigationBarDefaults INSTANCE = new NavigationBarDefaults();

    private NavigationBarDefaults() {
    }

    @Composable
    @JvmName(name = "getContainerColor")
    public final long getContainerColor(@Nullable Composer composer, int i11) {
        composer.startReplaceableGroup(1528098623);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1528098623, i11, -1, "androidx.compose.material3.NavigationBarDefaults.<get-containerColor> (NavigationBar.kt:265)");
        }
        long color = ColorSchemeKt.toColor(NavigationBarTokens.INSTANCE.getContainerColor(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return color;
    }

    /* renamed from: getElevation-D9Ej5fM  reason: not valid java name */
    public final float m1745getElevationD9Ej5fM() {
        return Elevation;
    }

    @NotNull
    @Composable
    @JvmName(name = "getWindowInsets")
    public final WindowInsets getWindowInsets(@Nullable Composer composer, int i11) {
        composer.startReplaceableGroup(-1938678202);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1938678202, i11, -1, "androidx.compose.material3.NavigationBarDefaults.<get-windowInsets> (NavigationBar.kt:272)");
        }
        WindowInsets systemBarsForVisualComponents = SystemBarsDefaultInsets_androidKt.getSystemBarsForVisualComponents(WindowInsets.Companion, composer, 8);
        WindowInsetsSides.Companion companion = WindowInsetsSides.Companion;
        WindowInsets r52 = WindowInsetsKt.m578onlybOOhFvg(systemBarsForVisualComponents, WindowInsetsSides.m592plusgK_yJZ4(companion.m603getHorizontalJoeWqyM(), companion.m601getBottomJoeWqyM()));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return r52;
    }
}
