package androidx.compose.foundation;

import android.content.Context;
import android.os.Build;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0001\u001a\r\u0010\u0007\u001a\u00020\bH\u0001¢\u0006\u0002\u0010\t\"\u0016\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\n\n\u0002\u0010\u0004\u0012\u0004\b\u0002\u0010\u0003\"\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"NoOpOverscrollEffect", "androidx/compose/foundation/AndroidOverscrollKt$NoOpOverscrollEffect$1", "getNoOpOverscrollEffect$annotations", "()V", "Landroidx/compose/foundation/AndroidOverscrollKt$NoOpOverscrollEffect$1;", "StretchOverscrollNonClippingLayer", "Landroidx/compose/ui/Modifier;", "rememberOverscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/OverscrollEffect;", "foundation_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class AndroidOverscrollKt {
    /* access modifiers changed from: private */
    @NotNull
    public static final AndroidOverscrollKt$NoOpOverscrollEffect$1 NoOpOverscrollEffect = new AndroidOverscrollKt$NoOpOverscrollEffect$1();
    /* access modifiers changed from: private */
    @NotNull
    public static final Modifier StretchOverscrollNonClippingLayer;

    static {
        Modifier modifier;
        if (Build.VERSION.SDK_INT >= 31) {
            modifier = LayoutModifierKt.layout(LayoutModifierKt.layout(Modifier.Companion, AndroidOverscrollKt$StretchOverscrollNonClippingLayer$1.INSTANCE), AndroidOverscrollKt$StretchOverscrollNonClippingLayer$2.INSTANCE);
        } else {
            modifier = Modifier.Companion;
        }
        StretchOverscrollNonClippingLayer = modifier;
    }

    private static /* synthetic */ void getNoOpOverscrollEffect$annotations() {
    }

    @NotNull
    @Composable
    public static final OverscrollEffect rememberOverscrollEffect(@Nullable Composer composer, int i11) {
        composer.startReplaceableGroup(-81138291);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-81138291, i11, -1, "androidx.compose.foundation.rememberOverscrollEffect (AndroidOverscroll.kt:62)");
        }
        Context context = (Context) composer.consume(AndroidCompositionLocals_androidKt.getLocalContext());
        OverscrollConfiguration overscrollConfiguration = (OverscrollConfiguration) composer.consume(OverscrollConfigurationKt.getLocalOverscrollConfiguration());
        composer.startReplaceableGroup(511388516);
        boolean changed = composer.changed((Object) context) | composer.changed((Object) overscrollConfiguration);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            if (overscrollConfiguration != null) {
                rememberedValue = new AndroidEdgeEffectOverscrollEffect(context, overscrollConfiguration);
            } else {
                rememberedValue = NoOpOverscrollEffect;
            }
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        OverscrollEffect overscrollEffect = (OverscrollEffect) rememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return overscrollEffect;
    }
}
