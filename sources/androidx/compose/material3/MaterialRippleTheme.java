package androidx.compose.material3;

import androidx.compose.material.ripple.RippleAlpha;
import androidx.compose.material.ripple.RippleTheme;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.Immutable;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Immutable
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u0004H\u0017ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0007\u001a\u00020\bH\u0017¢\u0006\u0002\u0010\t\u0002\u000f\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\n"}, d2 = {"Landroidx/compose/material3/MaterialRippleTheme;", "Landroidx/compose/material/ripple/RippleTheme;", "()V", "defaultColor", "Landroidx/compose/ui/graphics/Color;", "defaultColor-WaAFU9c", "(Landroidx/compose/runtime/Composer;I)J", "rippleAlpha", "Landroidx/compose/material/ripple/RippleAlpha;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material/ripple/RippleAlpha;", "material3_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
final class MaterialRippleTheme implements RippleTheme {
    @NotNull
    public static final MaterialRippleTheme INSTANCE = new MaterialRippleTheme();

    private MaterialRippleTheme() {
    }

    @Composable
    /* renamed from: defaultColor-WaAFU9c  reason: not valid java name */
    public long m1737defaultColorWaAFU9c(@Nullable Composer composer, int i11) {
        composer.startReplaceableGroup(-2059468846);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2059468846, i11, -1, "androidx.compose.material3.MaterialRippleTheme.defaultColor (MaterialTheme.kt:117)");
        }
        long r02 = ((Color) composer.consume(ContentColorKt.getLocalContentColor())).m2929unboximpl();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return r02;
    }

    @NotNull
    @Composable
    public RippleAlpha rippleAlpha(@Nullable Composer composer, int i11) {
        composer.startReplaceableGroup(1285764247);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1285764247, i11, -1, "androidx.compose.material3.MaterialRippleTheme.rippleAlpha (MaterialTheme.kt:120)");
        }
        RippleAlpha access$getDefaultRippleAlpha$p = MaterialThemeKt.DefaultRippleAlpha;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return access$getDefaultRippleAlpha$p;
    }
}
