package androidx.compose.material3;

import androidx.compose.material3.tokens.SwitchTokens;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002Jµ\u0001\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000b2\b\b\u0002\u0010\u000f\u001a\u00020\u000b2\b\b\u0002\u0010\u0010\u001a\u00020\u000b2\b\b\u0002\u0010\u0011\u001a\u00020\u000b2\b\b\u0002\u0010\u0012\u001a\u00020\u000b2\b\b\u0002\u0010\u0013\u001a\u00020\u000b2\b\b\u0002\u0010\u0014\u001a\u00020\u000b2\b\b\u0002\u0010\u0015\u001a\u00020\u000b2\b\b\u0002\u0010\u0016\u001a\u00020\u000b2\b\b\u0002\u0010\u0017\u001a\u00020\u000b2\b\b\u0002\u0010\u0018\u001a\u00020\u000b2\b\b\u0002\u0010\u0019\u001a\u00020\u000b2\b\b\u0002\u0010\u001a\u001a\u00020\u000bH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001cR\u001c\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001d"}, d2 = {"Landroidx/compose/material3/SwitchDefaults;", "", "()V", "IconSize", "Landroidx/compose/ui/unit/Dp;", "getIconSize-D9Ej5fM", "()F", "F", "colors", "Landroidx/compose/material3/SwitchColors;", "checkedThumbColor", "Landroidx/compose/ui/graphics/Color;", "checkedTrackColor", "checkedBorderColor", "checkedIconColor", "uncheckedThumbColor", "uncheckedTrackColor", "uncheckedBorderColor", "uncheckedIconColor", "disabledCheckedThumbColor", "disabledCheckedTrackColor", "disabledCheckedBorderColor", "disabledCheckedIconColor", "disabledUncheckedThumbColor", "disabledUncheckedTrackColor", "disabledUncheckedBorderColor", "disabledUncheckedIconColor", "colors-V1nXRL4", "(JJJJJJJJJJJJJJJJLandroidx/compose/runtime/Composer;III)Landroidx/compose/material3/SwitchColors;", "material3_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SwitchDefaults {
    public static final int $stable = 0;
    @NotNull
    public static final SwitchDefaults INSTANCE = new SwitchDefaults();
    private static final float IconSize = Dp.m5478constructorimpl((float) 16);

    private SwitchDefaults() {
    }

    @NotNull
    @Composable
    /* renamed from: colors-V1nXRL4  reason: not valid java name */
    public final SwitchColors m1873colorsV1nXRL4(long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j21, long j22, long j23, long j24, long j25, long j26, long j27, @Nullable Composer composer, int i11, int i12, int i13) {
        Composer composer2 = composer;
        int i14 = i13;
        composer2.startReplaceableGroup(1937926421);
        long color = (i14 & 1) != 0 ? ColorSchemeKt.toColor(SwitchTokens.INSTANCE.getSelectedHandleColor(), composer2, 6) : j11;
        long color2 = (i14 & 2) != 0 ? ColorSchemeKt.toColor(SwitchTokens.INSTANCE.getSelectedTrackColor(), composer2, 6) : j12;
        long r12 = (i14 & 4) != 0 ? Color.Companion.m2954getTransparent0d7_KjU() : j13;
        long color3 = (i14 & 8) != 0 ? ColorSchemeKt.toColor(SwitchTokens.INSTANCE.getSelectedIconColor(), composer2, 6) : j14;
        long color4 = (i14 & 16) != 0 ? ColorSchemeKt.toColor(SwitchTokens.INSTANCE.getUnselectedHandleColor(), composer2, 6) : j15;
        long color5 = (i14 & 32) != 0 ? ColorSchemeKt.toColor(SwitchTokens.INSTANCE.getUnselectedTrackColor(), composer2, 6) : j16;
        long color6 = (i14 & 64) != 0 ? ColorSchemeKt.toColor(SwitchTokens.INSTANCE.getUnselectedFocusTrackOutlineColor(), composer2, 6) : j17;
        long color7 = (i14 & 128) != 0 ? ColorSchemeKt.toColor(SwitchTokens.INSTANCE.getUnselectedIconColor(), composer2, 6) : j18;
        long r24 = (i14 & 256) != 0 ? ColorKt.m2965compositeOverOWjLjI(Color.m2918copywmQWz5c$default(ColorSchemeKt.toColor(SwitchTokens.INSTANCE.getDisabledSelectedHandleColor(), composer2, 6), 1.0f, 0.0f, 0.0f, 0.0f, 14, (Object) null), MaterialTheme.INSTANCE.getColorScheme(composer2, 6).m1573getSurface0d7_KjU()) : j19;
        long r26 = (i14 & 512) != 0 ? ColorKt.m2965compositeOverOWjLjI(Color.m2918copywmQWz5c$default(ColorSchemeKt.toColor(SwitchTokens.INSTANCE.getDisabledSelectedTrackColor(), composer2, 6), 0.12f, 0.0f, 0.0f, 0.0f, 14, (Object) null), MaterialTheme.INSTANCE.getColorScheme(composer2, 6).m1573getSurface0d7_KjU()) : j21;
        long r28 = (i14 & 1024) != 0 ? Color.Companion.m2954getTransparent0d7_KjU() : j22;
        long r302 = (i14 & 2048) != 0 ? ColorKt.m2965compositeOverOWjLjI(Color.m2918copywmQWz5c$default(ColorSchemeKt.toColor(SwitchTokens.INSTANCE.getDisabledSelectedIconColor(), composer2, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null), MaterialTheme.INSTANCE.getColorScheme(composer2, 6).m1573getSurface0d7_KjU()) : j23;
        long r32 = (i14 & 4096) != 0 ? ColorKt.m2965compositeOverOWjLjI(Color.m2918copywmQWz5c$default(ColorSchemeKt.toColor(SwitchTokens.INSTANCE.getDisabledUnselectedHandleColor(), composer2, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null), MaterialTheme.INSTANCE.getColorScheme(composer2, 6).m1573getSurface0d7_KjU()) : j24;
        long r34 = (i14 & 8192) != 0 ? ColorKt.m2965compositeOverOWjLjI(Color.m2918copywmQWz5c$default(ColorSchemeKt.toColor(SwitchTokens.INSTANCE.getDisabledUnselectedTrackColor(), composer2, 6), 0.12f, 0.0f, 0.0f, 0.0f, 14, (Object) null), MaterialTheme.INSTANCE.getColorScheme(composer2, 6).m1573getSurface0d7_KjU()) : j25;
        long r36 = (i14 & 16384) != 0 ? ColorKt.m2965compositeOverOWjLjI(Color.m2918copywmQWz5c$default(ColorSchemeKt.toColor(SwitchTokens.INSTANCE.getDisabledUnselectedTrackOutlineColor(), composer2, 6), 0.12f, 0.0f, 0.0f, 0.0f, 14, (Object) null), MaterialTheme.INSTANCE.getColorScheme(composer2, 6).m1573getSurface0d7_KjU()) : j26;
        long r38 = (i14 & 32768) != 0 ? ColorKt.m2965compositeOverOWjLjI(Color.m2918copywmQWz5c$default(ColorSchemeKt.toColor(SwitchTokens.INSTANCE.getDisabledUnselectedIconColor(), composer2, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null), MaterialTheme.INSTANCE.getColorScheme(composer2, 6).m1573getSurface0d7_KjU()) : j27;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1937926421, i11, i12, "androidx.compose.material3.SwitchDefaults.colors (Switch.kt:279)");
        }
        SwitchColors switchColors = new SwitchColors(color, color2, r12, color3, color4, color5, color6, color7, r24, r26, r28, r302, r32, r34, r36, r38, (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return switchColors;
    }

    /* renamed from: getIconSize-D9Ej5fM  reason: not valid java name */
    public final float m1874getIconSizeD9Ej5fM() {
        return IconSize;
    }
}
