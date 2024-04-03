package androidx.compose.material3;

import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/compose/material3/ScaffoldDefaults;", "", "()V", "contentWindowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "getContentWindowInsets", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/layout/WindowInsets;", "material3_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@ExperimentalMaterial3Api
public final class ScaffoldDefaults {
    public static final int $stable = 0;
    @NotNull
    public static final ScaffoldDefaults INSTANCE = new ScaffoldDefaults();

    private ScaffoldDefaults() {
    }

    @NotNull
    @Composable
    @JvmName(name = "getContentWindowInsets")
    public final WindowInsets getContentWindowInsets(@Nullable Composer composer, int i11) {
        composer.startReplaceableGroup(757124140);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(757124140, i11, -1, "androidx.compose.material3.ScaffoldDefaults.<get-contentWindowInsets> (Scaffold.kt:282)");
        }
        WindowInsets systemBarsForVisualComponents = SystemBarsDefaultInsets_androidKt.getSystemBarsForVisualComponents(WindowInsets.Companion, composer, 8);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return systemBarsForVisualComponents;
    }
}
