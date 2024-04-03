package androidx.compose.material.ripple;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Immutable;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Immutable
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u0004H\u0017ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0007\u001a\u00020\bH\u0017¢\u0006\u0002\u0010\t\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\n"}, d2 = {"Landroidx/compose/material/ripple/DebugRippleTheme;", "Landroidx/compose/material/ripple/RippleTheme;", "()V", "defaultColor", "Landroidx/compose/ui/graphics/Color;", "defaultColor-WaAFU9c", "(Landroidx/compose/runtime/Composer;I)J", "rippleAlpha", "Landroidx/compose/material/ripple/RippleAlpha;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material/ripple/RippleAlpha;", "material-ripple_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
final class DebugRippleTheme implements RippleTheme {
    @NotNull
    public static final DebugRippleTheme INSTANCE = new DebugRippleTheme();

    private DebugRippleTheme() {
    }

    @Composable
    /* renamed from: defaultColor-WaAFU9c  reason: not valid java name */
    public long m1475defaultColorWaAFU9c(@Nullable Composer composer, int i11) {
        composer.startReplaceableGroup(2042140174);
        long r02 = RippleTheme.Companion.m1488defaultRippleColor5vOe2sY(Color.Companion.m2945getBlack0d7_KjU(), true);
        composer.endReplaceableGroup();
        return r02;
    }

    @NotNull
    @Composable
    public RippleAlpha rippleAlpha(@Nullable Composer composer, int i11) {
        composer.startReplaceableGroup(-1629816343);
        RippleAlpha r52 = RippleTheme.Companion.m1487defaultRippleAlphaDxMtmZc(Color.Companion.m2945getBlack0d7_KjU(), true);
        composer.endReplaceableGroup();
        return r52;
    }
}
