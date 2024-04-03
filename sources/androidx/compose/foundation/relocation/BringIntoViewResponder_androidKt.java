package androidx.compose.foundation.relocation;

import android.graphics.Rect;
import android.view.View;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010\u0002\u001a\f\u0010\u0003\u001a\u00020\u0004*\u00020\u0005H\u0002¨\u0006\u0006"}, d2 = {"rememberDefaultBringIntoViewParent", "Landroidx/compose/foundation/relocation/BringIntoViewParent;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/relocation/BringIntoViewParent;", "toRect", "Landroid/graphics/Rect;", "Landroidx/compose/ui/geometry/Rect;", "foundation_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class BringIntoViewResponder_androidKt {
    @NotNull
    @Composable
    public static final BringIntoViewParent rememberDefaultBringIntoViewParent(@Nullable Composer composer, int i11) {
        composer.startReplaceableGroup(-1031410916);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1031410916, i11, -1, "androidx.compose.foundation.relocation.rememberDefaultBringIntoViewParent (BringIntoViewResponder.android.kt:28)");
        }
        View view = (View) composer.consume(AndroidCompositionLocals_androidKt.getLocalView());
        composer.startReplaceableGroup(1157296644);
        boolean changed = composer.changed((Object) view);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new AndroidBringIntoViewParent(view);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        AndroidBringIntoViewParent androidBringIntoViewParent = (AndroidBringIntoViewParent) rememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return androidBringIntoViewParent;
    }

    /* access modifiers changed from: private */
    public static final Rect toRect(androidx.compose.ui.geometry.Rect rect) {
        return new Rect((int) rect.getLeft(), (int) rect.getTop(), (int) rect.getRight(), (int) rect.getBottom());
    }
}
