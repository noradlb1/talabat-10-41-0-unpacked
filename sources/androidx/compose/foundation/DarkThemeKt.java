package androidx.compose.foundation;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ReadOnlyComposable;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"isSystemInDarkTheme", "", "(Landroidx/compose/runtime/Composer;I)Z", "foundation_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class DarkThemeKt {
    @ReadOnlyComposable
    @Composable
    public static final boolean isSystemInDarkTheme(@Nullable Composer composer, int i11) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1100791446, i11, -1, "androidx.compose.foundation.isSystemInDarkTheme (DarkTheme.kt:40)");
        }
        boolean _isSystemInDarkTheme = DarkTheme_androidKt._isSystemInDarkTheme(composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return _isSystemInDarkTheme;
    }
}
