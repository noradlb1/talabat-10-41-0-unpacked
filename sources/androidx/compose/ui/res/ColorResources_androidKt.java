package androidx.compose.ui.res;

import android.content.Context;
import androidx.annotation.ColorRes;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ReadOnlyComposable;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u001a\u001a\u0010\u0000\u001a\u00020\u00012\b\b\u0001\u0010\u0002\u001a\u00020\u0003H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0004\u0002\u0004\n\u0002\b\u0019¨\u0006\u0005"}, d2 = {"colorResource", "Landroidx/compose/ui/graphics/Color;", "id", "", "(ILandroidx/compose/runtime/Composer;I)J", "ui_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class ColorResources_androidKt {
    @ReadOnlyComposable
    @Composable
    public static final long colorResource(@ColorRes int i11, @Nullable Composer composer, int i12) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1777644873, i12, -1, "androidx.compose.ui.res.colorResource (ColorResources.android.kt:36)");
        }
        long r32 = ColorResourceHelper.INSTANCE.m4894getColorWaAFU9c((Context) composer.consume(AndroidCompositionLocals_androidKt.getLocalContext()), i11);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return r32;
    }
}
