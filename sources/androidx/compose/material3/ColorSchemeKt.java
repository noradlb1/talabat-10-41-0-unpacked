package androidx.compose.material3;

import androidx.compose.material3.tokens.ColorDarkTokens;
import androidx.compose.material3.tokens.ColorLightTokens;
import androidx.compose.material3.tokens.ColorSchemeKeyTokens;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ReadOnlyComposable;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.unit.Dp;
import com.google.android.exoplayer2.C;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b'\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u001d\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\n\u0010\u000b\u001aµ\u0002\u0010\f\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\b2\b\b\u0002\u0010\u000f\u001a\u00020\b2\b\b\u0002\u0010\u0010\u001a\u00020\b2\b\b\u0002\u0010\u0011\u001a\u00020\b2\b\b\u0002\u0010\u0012\u001a\u00020\b2\b\b\u0002\u0010\u0013\u001a\u00020\b2\b\b\u0002\u0010\u0014\u001a\u00020\b2\b\b\u0002\u0010\u0015\u001a\u00020\b2\b\b\u0002\u0010\u0016\u001a\u00020\b2\b\b\u0002\u0010\u0017\u001a\u00020\b2\b\b\u0002\u0010\u0018\u001a\u00020\b2\b\b\u0002\u0010\u0019\u001a\u00020\b2\b\b\u0002\u0010\u001a\u001a\u00020\b2\b\b\u0002\u0010\u001b\u001a\u00020\b2\b\b\u0002\u0010\u001c\u001a\u00020\b2\b\b\u0002\u0010\u001d\u001a\u00020\b2\b\b\u0002\u0010\u001e\u001a\u00020\b2\b\b\u0002\u0010\u001f\u001a\u00020\b2\b\b\u0002\u0010 \u001a\u00020\b2\b\b\u0002\u0010!\u001a\u00020\b2\b\b\u0002\u0010\"\u001a\u00020\b2\b\b\u0002\u0010#\u001a\u00020\b2\b\b\u0002\u0010$\u001a\u00020\b2\b\b\u0002\u0010%\u001a\u00020\b2\b\b\u0002\u0010&\u001a\u00020\b2\b\b\u0002\u0010'\u001a\u00020\b2\b\b\u0002\u0010(\u001a\u00020\b2\b\b\u0002\u0010)\u001a\u00020\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b*\u0010+\u001aµ\u0002\u0010,\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\b2\b\b\u0002\u0010\u000f\u001a\u00020\b2\b\b\u0002\u0010\u0010\u001a\u00020\b2\b\b\u0002\u0010\u0011\u001a\u00020\b2\b\b\u0002\u0010\u0012\u001a\u00020\b2\b\b\u0002\u0010\u0013\u001a\u00020\b2\b\b\u0002\u0010\u0014\u001a\u00020\b2\b\b\u0002\u0010\u0015\u001a\u00020\b2\b\b\u0002\u0010\u0016\u001a\u00020\b2\b\b\u0002\u0010\u0017\u001a\u00020\b2\b\b\u0002\u0010\u0018\u001a\u00020\b2\b\b\u0002\u0010\u0019\u001a\u00020\b2\b\b\u0002\u0010\u001a\u001a\u00020\b2\b\b\u0002\u0010\u001b\u001a\u00020\b2\b\b\u0002\u0010\u001c\u001a\u00020\b2\b\b\u0002\u0010\u001d\u001a\u00020\b2\b\b\u0002\u0010\u001e\u001a\u00020\b2\b\b\u0002\u0010\u001f\u001a\u00020\b2\b\b\u0002\u0010 \u001a\u00020\b2\b\b\u0002\u0010!\u001a\u00020\b2\b\b\u0002\u0010\"\u001a\u00020\b2\b\b\u0002\u0010#\u001a\u00020\b2\b\b\u0002\u0010$\u001a\u00020\b2\b\b\u0002\u0010%\u001a\u00020\b2\b\b\u0002\u0010&\u001a\u00020\b2\b\b\u0002\u0010'\u001a\u00020\b2\b\b\u0002\u0010(\u001a\u00020\b2\b\b\u0002\u0010)\u001a\u00020\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b-\u0010+\u001a)\u0010.\u001a\u00020\b*\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010/\u001a\u000200H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b1\u00102\u001a\u001f\u0010\u0007\u001a\u00020\b*\u00020\u00042\u0006\u0010\t\u001a\u00020\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b3\u00104\u001a\u001c\u00105\u001a\u00020\b*\u00020\u00042\u0006\u00106\u001a\u000207H\u0000ø\u0001\u0001¢\u0006\u0002\u00108\u001a\u001f\u00109\u001a\u00020\b*\u00020\u00042\u0006\u0010/\u001a\u000200ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b:\u0010;\u001a\u0014\u0010<\u001a\u00020\b*\u000207H\u0001ø\u0001\u0001¢\u0006\u0002\u0010=\u001a\u0014\u0010>\u001a\u00020?*\u00020\u00042\u0006\u0010@\u001a\u00020\u0004H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u001a\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006A"}, d2 = {"DisabledAlpha", "", "LocalColorScheme", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/material3/ColorScheme;", "getLocalColorScheme", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "contentColorFor", "Landroidx/compose/ui/graphics/Color;", "backgroundColor", "contentColorFor-ek8zF_U", "(JLandroidx/compose/runtime/Composer;I)J", "darkColorScheme", "primary", "onPrimary", "primaryContainer", "onPrimaryContainer", "inversePrimary", "secondary", "onSecondary", "secondaryContainer", "onSecondaryContainer", "tertiary", "onTertiary", "tertiaryContainer", "onTertiaryContainer", "background", "onBackground", "surface", "onSurface", "surfaceVariant", "onSurfaceVariant", "surfaceTint", "inverseSurface", "inverseOnSurface", "error", "onError", "errorContainer", "onErrorContainer", "outline", "outlineVariant", "scrim", "darkColorScheme-G1PFc-w", "(JJJJJJJJJJJJJJJJJJJJJJJJJJJJJ)Landroidx/compose/material3/ColorScheme;", "lightColorScheme", "lightColorScheme-G1PFc-w", "applyTonalElevation", "elevation", "Landroidx/compose/ui/unit/Dp;", "applyTonalElevation-Hht5A8o", "(Landroidx/compose/material3/ColorScheme;JF)J", "contentColorFor-4WTKRHQ", "(Landroidx/compose/material3/ColorScheme;J)J", "fromToken", "value", "Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "(Landroidx/compose/material3/ColorScheme;Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;)J", "surfaceColorAtElevation", "surfaceColorAtElevation-3ABfNKs", "(Landroidx/compose/material3/ColorScheme;F)J", "toColor", "(Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;Landroidx/compose/runtime/Composer;I)J", "updateColorSchemeFrom", "", "other", "material3_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class ColorSchemeKt {
    public static final float DisabledAlpha = 0.38f;
    @NotNull
    private static final ProvidableCompositionLocal<ColorScheme> LocalColorScheme = CompositionLocalKt.staticCompositionLocalOf(ColorSchemeKt$LocalColorScheme$1.INSTANCE);

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ColorSchemeKeyTokens.values().length];
            iArr[ColorSchemeKeyTokens.Background.ordinal()] = 1;
            iArr[ColorSchemeKeyTokens.Error.ordinal()] = 2;
            iArr[ColorSchemeKeyTokens.ErrorContainer.ordinal()] = 3;
            iArr[ColorSchemeKeyTokens.InverseOnSurface.ordinal()] = 4;
            iArr[ColorSchemeKeyTokens.InversePrimary.ordinal()] = 5;
            iArr[ColorSchemeKeyTokens.InverseSurface.ordinal()] = 6;
            iArr[ColorSchemeKeyTokens.OnBackground.ordinal()] = 7;
            iArr[ColorSchemeKeyTokens.OnError.ordinal()] = 8;
            iArr[ColorSchemeKeyTokens.OnErrorContainer.ordinal()] = 9;
            iArr[ColorSchemeKeyTokens.OnPrimary.ordinal()] = 10;
            iArr[ColorSchemeKeyTokens.OnPrimaryContainer.ordinal()] = 11;
            iArr[ColorSchemeKeyTokens.OnSecondary.ordinal()] = 12;
            iArr[ColorSchemeKeyTokens.OnSecondaryContainer.ordinal()] = 13;
            iArr[ColorSchemeKeyTokens.OnSurface.ordinal()] = 14;
            iArr[ColorSchemeKeyTokens.OnSurfaceVariant.ordinal()] = 15;
            iArr[ColorSchemeKeyTokens.SurfaceTint.ordinal()] = 16;
            iArr[ColorSchemeKeyTokens.OnTertiary.ordinal()] = 17;
            iArr[ColorSchemeKeyTokens.OnTertiaryContainer.ordinal()] = 18;
            iArr[ColorSchemeKeyTokens.Outline.ordinal()] = 19;
            iArr[ColorSchemeKeyTokens.OutlineVariant.ordinal()] = 20;
            iArr[ColorSchemeKeyTokens.Primary.ordinal()] = 21;
            iArr[ColorSchemeKeyTokens.PrimaryContainer.ordinal()] = 22;
            iArr[ColorSchemeKeyTokens.Scrim.ordinal()] = 23;
            iArr[ColorSchemeKeyTokens.Secondary.ordinal()] = 24;
            iArr[ColorSchemeKeyTokens.SecondaryContainer.ordinal()] = 25;
            iArr[ColorSchemeKeyTokens.Surface.ordinal()] = 26;
            iArr[ColorSchemeKeyTokens.SurfaceVariant.ordinal()] = 27;
            iArr[ColorSchemeKeyTokens.Tertiary.ordinal()] = 28;
            iArr[ColorSchemeKeyTokens.TertiaryContainer.ordinal()] = 29;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* renamed from: applyTonalElevation-Hht5A8o  reason: not valid java name */
    public static final long m1607applyTonalElevationHht5A8o(@NotNull ColorScheme colorScheme, long j11, float f11) {
        Intrinsics.checkNotNullParameter(colorScheme, "$this$applyTonalElevation");
        if (Color.m2920equalsimpl0(j11, colorScheme.m1573getSurface0d7_KjU())) {
            return m1614surfaceColorAtElevation3ABfNKs(colorScheme, f11);
        }
        return j11;
    }

    /* renamed from: contentColorFor-4WTKRHQ  reason: not valid java name */
    public static final long m1608contentColorFor4WTKRHQ(@NotNull ColorScheme colorScheme, long j11) {
        Intrinsics.checkNotNullParameter(colorScheme, "$this$contentColorFor");
        if (Color.m2920equalsimpl0(j11, colorScheme.m1568getPrimary0d7_KjU())) {
            return colorScheme.m1558getOnPrimary0d7_KjU();
        }
        if (Color.m2920equalsimpl0(j11, colorScheme.m1571getSecondary0d7_KjU())) {
            return colorScheme.m1560getOnSecondary0d7_KjU();
        }
        if (Color.m2920equalsimpl0(j11, colorScheme.m1576getTertiary0d7_KjU())) {
            return colorScheme.m1564getOnTertiary0d7_KjU();
        }
        if (Color.m2920equalsimpl0(j11, colorScheme.m1549getBackground0d7_KjU())) {
            return colorScheme.m1555getOnBackground0d7_KjU();
        }
        if (Color.m2920equalsimpl0(j11, colorScheme.m1550getError0d7_KjU())) {
            return colorScheme.m1556getOnError0d7_KjU();
        }
        if (Color.m2920equalsimpl0(j11, colorScheme.m1573getSurface0d7_KjU())) {
            return colorScheme.m1562getOnSurface0d7_KjU();
        }
        if (Color.m2920equalsimpl0(j11, colorScheme.m1575getSurfaceVariant0d7_KjU())) {
            return colorScheme.m1563getOnSurfaceVariant0d7_KjU();
        }
        if (Color.m2920equalsimpl0(j11, colorScheme.m1569getPrimaryContainer0d7_KjU())) {
            return colorScheme.m1559getOnPrimaryContainer0d7_KjU();
        }
        if (Color.m2920equalsimpl0(j11, colorScheme.m1572getSecondaryContainer0d7_KjU())) {
            return colorScheme.m1561getOnSecondaryContainer0d7_KjU();
        }
        if (Color.m2920equalsimpl0(j11, colorScheme.m1577getTertiaryContainer0d7_KjU())) {
            return colorScheme.m1565getOnTertiaryContainer0d7_KjU();
        }
        if (Color.m2920equalsimpl0(j11, colorScheme.m1551getErrorContainer0d7_KjU())) {
            return colorScheme.m1557getOnErrorContainer0d7_KjU();
        }
        if (Color.m2920equalsimpl0(j11, colorScheme.m1554getInverseSurface0d7_KjU())) {
            return colorScheme.m1552getInverseOnSurface0d7_KjU();
        }
        return Color.Companion.m2955getUnspecified0d7_KjU();
    }

    @ReadOnlyComposable
    @Composable
    /* renamed from: contentColorFor-ek8zF_U  reason: not valid java name */
    public static final long m1609contentColorForek8zF_U(long j11, @Nullable Composer composer, int i11) {
        boolean z11;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(509589638, i11, -1, "androidx.compose.material3.contentColorFor (ColorScheme.kt:473)");
        }
        long r32 = m1608contentColorFor4WTKRHQ(MaterialTheme.INSTANCE.getColorScheme(composer, 6), j11);
        if (r32 != Color.Companion.m2955getUnspecified0d7_KjU()) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            r32 = ((Color) composer.consume(ContentColorKt.getLocalContentColor())).m2929unboximpl();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return r32;
    }

    @NotNull
    /* renamed from: darkColorScheme-G1PFc-w  reason: not valid java name */
    public static final ColorScheme m1610darkColorSchemeG1PFcw(long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j31, long j32, long j33, long j34, long j35, long j36, long j37, long j38, long j39, long j41, long j42) {
        return new ColorScheme(j11, j12, j13, j14, j15, j16, j17, j18, j19, j21, j22, j23, j24, j25, j26, j27, j28, j29, j31, j32, j33, j34, j35, j36, j37, j38, j39, j41, j42, (DefaultConstructorMarker) null);
    }

    /* renamed from: darkColorScheme-G1PFc-w$default  reason: not valid java name */
    public static /* synthetic */ ColorScheme m1611darkColorSchemeG1PFcw$default(long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j31, long j32, long j33, long j34, long j35, long j36, long j37, long j38, long j39, long j41, long j42, int i11, Object obj) {
        int i12 = i11;
        long r12 = (i12 & 1) != 0 ? ColorDarkTokens.INSTANCE.m2076getPrimary0d7_KjU() : j11;
        return m1610darkColorSchemeG1PFcw(r12, (i12 & 2) != 0 ? ColorDarkTokens.INSTANCE.m2066getOnPrimary0d7_KjU() : j12, (i12 & 4) != 0 ? ColorDarkTokens.INSTANCE.m2077getPrimaryContainer0d7_KjU() : j13, (i12 & 8) != 0 ? ColorDarkTokens.INSTANCE.m2067getOnPrimaryContainer0d7_KjU() : j14, (i12 & 16) != 0 ? ColorDarkTokens.INSTANCE.m2061getInversePrimary0d7_KjU() : j15, (i12 & 32) != 0 ? ColorDarkTokens.INSTANCE.m2079getSecondary0d7_KjU() : j16, (i12 & 64) != 0 ? ColorDarkTokens.INSTANCE.m2068getOnSecondary0d7_KjU() : j17, (i12 & 128) != 0 ? ColorDarkTokens.INSTANCE.m2080getSecondaryContainer0d7_KjU() : j18, (i12 & 256) != 0 ? ColorDarkTokens.INSTANCE.m2069getOnSecondaryContainer0d7_KjU() : j19, (i12 & 512) != 0 ? ColorDarkTokens.INSTANCE.m2084getTertiary0d7_KjU() : j21, (i12 & 1024) != 0 ? ColorDarkTokens.INSTANCE.m2072getOnTertiary0d7_KjU() : j22, (i12 & 2048) != 0 ? ColorDarkTokens.INSTANCE.m2085getTertiaryContainer0d7_KjU() : j23, (i12 & 4096) != 0 ? ColorDarkTokens.INSTANCE.m2073getOnTertiaryContainer0d7_KjU() : j24, (i12 & 8192) != 0 ? ColorDarkTokens.INSTANCE.m2057getBackground0d7_KjU() : j25, (i12 & 16384) != 0 ? ColorDarkTokens.INSTANCE.m2063getOnBackground0d7_KjU() : j26, (i12 & 32768) != 0 ? ColorDarkTokens.INSTANCE.m2081getSurface0d7_KjU() : j27, (i12 & 65536) != 0 ? ColorDarkTokens.INSTANCE.m2070getOnSurface0d7_KjU() : j28, (i12 & 131072) != 0 ? ColorDarkTokens.INSTANCE.m2083getSurfaceVariant0d7_KjU() : j29, (i12 & 262144) != 0 ? ColorDarkTokens.INSTANCE.m2071getOnSurfaceVariant0d7_KjU() : j31, (i12 & 524288) != 0 ? r12 : j32, (i12 & 1048576) != 0 ? ColorDarkTokens.INSTANCE.m2062getInverseSurface0d7_KjU() : j33, (i12 & 2097152) != 0 ? ColorDarkTokens.INSTANCE.m2060getInverseOnSurface0d7_KjU() : j34, (i12 & 4194304) != 0 ? ColorDarkTokens.INSTANCE.m2058getError0d7_KjU() : j35, (i12 & 8388608) != 0 ? ColorDarkTokens.INSTANCE.m2064getOnError0d7_KjU() : j36, (i12 & 16777216) != 0 ? ColorDarkTokens.INSTANCE.m2059getErrorContainer0d7_KjU() : j37, (i12 & 33554432) != 0 ? ColorDarkTokens.INSTANCE.m2065getOnErrorContainer0d7_KjU() : j38, (i12 & 67108864) != 0 ? ColorDarkTokens.INSTANCE.m2074getOutline0d7_KjU() : j39, (i12 & C.BUFFER_FLAG_FIRST_SAMPLE) != 0 ? ColorDarkTokens.INSTANCE.m2075getOutlineVariant0d7_KjU() : j41, (i12 & 268435456) != 0 ? ColorDarkTokens.INSTANCE.m2078getScrim0d7_KjU() : j42);
    }

    public static final long fromToken(@NotNull ColorScheme colorScheme, @NotNull ColorSchemeKeyTokens colorSchemeKeyTokens) {
        Intrinsics.checkNotNullParameter(colorScheme, "<this>");
        Intrinsics.checkNotNullParameter(colorSchemeKeyTokens, "value");
        switch (WhenMappings.$EnumSwitchMapping$0[colorSchemeKeyTokens.ordinal()]) {
            case 1:
                return colorScheme.m1549getBackground0d7_KjU();
            case 2:
                return colorScheme.m1550getError0d7_KjU();
            case 3:
                return colorScheme.m1551getErrorContainer0d7_KjU();
            case 4:
                return colorScheme.m1552getInverseOnSurface0d7_KjU();
            case 5:
                return colorScheme.m1553getInversePrimary0d7_KjU();
            case 6:
                return colorScheme.m1554getInverseSurface0d7_KjU();
            case 7:
                return colorScheme.m1555getOnBackground0d7_KjU();
            case 8:
                return colorScheme.m1556getOnError0d7_KjU();
            case 9:
                return colorScheme.m1557getOnErrorContainer0d7_KjU();
            case 10:
                return colorScheme.m1558getOnPrimary0d7_KjU();
            case 11:
                return colorScheme.m1559getOnPrimaryContainer0d7_KjU();
            case 12:
                return colorScheme.m1560getOnSecondary0d7_KjU();
            case 13:
                return colorScheme.m1561getOnSecondaryContainer0d7_KjU();
            case 14:
                return colorScheme.m1562getOnSurface0d7_KjU();
            case 15:
                return colorScheme.m1563getOnSurfaceVariant0d7_KjU();
            case 16:
                return colorScheme.m1574getSurfaceTint0d7_KjU();
            case 17:
                return colorScheme.m1564getOnTertiary0d7_KjU();
            case 18:
                return colorScheme.m1565getOnTertiaryContainer0d7_KjU();
            case 19:
                return colorScheme.m1566getOutline0d7_KjU();
            case 20:
                return colorScheme.m1567getOutlineVariant0d7_KjU();
            case 21:
                return colorScheme.m1568getPrimary0d7_KjU();
            case 22:
                return colorScheme.m1569getPrimaryContainer0d7_KjU();
            case 23:
                return colorScheme.m1570getScrim0d7_KjU();
            case 24:
                return colorScheme.m1571getSecondary0d7_KjU();
            case 25:
                return colorScheme.m1572getSecondaryContainer0d7_KjU();
            case 26:
                return colorScheme.m1573getSurface0d7_KjU();
            case 27:
                return colorScheme.m1575getSurfaceVariant0d7_KjU();
            case 28:
                return colorScheme.m1576getTertiary0d7_KjU();
            case 29:
                return colorScheme.m1577getTertiaryContainer0d7_KjU();
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    @NotNull
    public static final ProvidableCompositionLocal<ColorScheme> getLocalColorScheme() {
        return LocalColorScheme;
    }

    @NotNull
    /* renamed from: lightColorScheme-G1PFc-w  reason: not valid java name */
    public static final ColorScheme m1612lightColorSchemeG1PFcw(long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j31, long j32, long j33, long j34, long j35, long j36, long j37, long j38, long j39, long j41, long j42) {
        return new ColorScheme(j11, j12, j13, j14, j15, j16, j17, j18, j19, j21, j22, j23, j24, j25, j26, j27, j28, j29, j31, j32, j33, j34, j35, j36, j37, j38, j39, j41, j42, (DefaultConstructorMarker) null);
    }

    /* renamed from: lightColorScheme-G1PFc-w$default  reason: not valid java name */
    public static /* synthetic */ ColorScheme m1613lightColorSchemeG1PFcw$default(long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j31, long j32, long j33, long j34, long j35, long j36, long j37, long j38, long j39, long j41, long j42, int i11, Object obj) {
        int i12 = i11;
        long r12 = (i12 & 1) != 0 ? ColorLightTokens.INSTANCE.m2105getPrimary0d7_KjU() : j11;
        return m1612lightColorSchemeG1PFcw(r12, (i12 & 2) != 0 ? ColorLightTokens.INSTANCE.m2095getOnPrimary0d7_KjU() : j12, (i12 & 4) != 0 ? ColorLightTokens.INSTANCE.m2106getPrimaryContainer0d7_KjU() : j13, (i12 & 8) != 0 ? ColorLightTokens.INSTANCE.m2096getOnPrimaryContainer0d7_KjU() : j14, (i12 & 16) != 0 ? ColorLightTokens.INSTANCE.m2090getInversePrimary0d7_KjU() : j15, (i12 & 32) != 0 ? ColorLightTokens.INSTANCE.m2108getSecondary0d7_KjU() : j16, (i12 & 64) != 0 ? ColorLightTokens.INSTANCE.m2097getOnSecondary0d7_KjU() : j17, (i12 & 128) != 0 ? ColorLightTokens.INSTANCE.m2109getSecondaryContainer0d7_KjU() : j18, (i12 & 256) != 0 ? ColorLightTokens.INSTANCE.m2098getOnSecondaryContainer0d7_KjU() : j19, (i12 & 512) != 0 ? ColorLightTokens.INSTANCE.m2113getTertiary0d7_KjU() : j21, (i12 & 1024) != 0 ? ColorLightTokens.INSTANCE.m2101getOnTertiary0d7_KjU() : j22, (i12 & 2048) != 0 ? ColorLightTokens.INSTANCE.m2114getTertiaryContainer0d7_KjU() : j23, (i12 & 4096) != 0 ? ColorLightTokens.INSTANCE.m2102getOnTertiaryContainer0d7_KjU() : j24, (i12 & 8192) != 0 ? ColorLightTokens.INSTANCE.m2086getBackground0d7_KjU() : j25, (i12 & 16384) != 0 ? ColorLightTokens.INSTANCE.m2092getOnBackground0d7_KjU() : j26, (i12 & 32768) != 0 ? ColorLightTokens.INSTANCE.m2110getSurface0d7_KjU() : j27, (i12 & 65536) != 0 ? ColorLightTokens.INSTANCE.m2099getOnSurface0d7_KjU() : j28, (i12 & 131072) != 0 ? ColorLightTokens.INSTANCE.m2112getSurfaceVariant0d7_KjU() : j29, (i12 & 262144) != 0 ? ColorLightTokens.INSTANCE.m2100getOnSurfaceVariant0d7_KjU() : j31, (i12 & 524288) != 0 ? r12 : j32, (i12 & 1048576) != 0 ? ColorLightTokens.INSTANCE.m2091getInverseSurface0d7_KjU() : j33, (i12 & 2097152) != 0 ? ColorLightTokens.INSTANCE.m2089getInverseOnSurface0d7_KjU() : j34, (i12 & 4194304) != 0 ? ColorLightTokens.INSTANCE.m2087getError0d7_KjU() : j35, (i12 & 8388608) != 0 ? ColorLightTokens.INSTANCE.m2093getOnError0d7_KjU() : j36, (i12 & 16777216) != 0 ? ColorLightTokens.INSTANCE.m2088getErrorContainer0d7_KjU() : j37, (i12 & 33554432) != 0 ? ColorLightTokens.INSTANCE.m2094getOnErrorContainer0d7_KjU() : j38, (i12 & 67108864) != 0 ? ColorLightTokens.INSTANCE.m2103getOutline0d7_KjU() : j39, (i12 & C.BUFFER_FLAG_FIRST_SAMPLE) != 0 ? ColorLightTokens.INSTANCE.m2104getOutlineVariant0d7_KjU() : j41, (i12 & 268435456) != 0 ? ColorLightTokens.INSTANCE.m2107getScrim0d7_KjU() : j42);
    }

    /* renamed from: surfaceColorAtElevation-3ABfNKs  reason: not valid java name */
    public static final long m1614surfaceColorAtElevation3ABfNKs(@NotNull ColorScheme colorScheme, float f11) {
        Intrinsics.checkNotNullParameter(colorScheme, "$this$surfaceColorAtElevation");
        if (Dp.m5483equalsimpl0(f11, Dp.m5478constructorimpl((float) 0))) {
            return colorScheme.m1573getSurface0d7_KjU();
        }
        return ColorKt.m2965compositeOverOWjLjI(Color.m2918copywmQWz5c$default(colorScheme.m1574getSurfaceTint0d7_KjU(), ((((float) Math.log((double) (f11 + ((float) 1)))) * 4.5f) + 2.0f) / 100.0f, 0.0f, 0.0f, 0.0f, 14, (Object) null), colorScheme.m1573getSurface0d7_KjU());
    }

    @ReadOnlyComposable
    @Composable
    public static final long toColor(@NotNull ColorSchemeKeyTokens colorSchemeKeyTokens, @Nullable Composer composer, int i11) {
        Intrinsics.checkNotNullParameter(colorSchemeKeyTokens, "<this>");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1330949347, i11, -1, "androidx.compose.material3.toColor (ColorScheme.kt:611)");
        }
        long fromToken = fromToken(MaterialTheme.INSTANCE.getColorScheme(composer, 6), colorSchemeKeyTokens);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return fromToken;
    }

    public static final void updateColorSchemeFrom(@NotNull ColorScheme colorScheme, @NotNull ColorScheme colorScheme2) {
        Intrinsics.checkNotNullParameter(colorScheme, "<this>");
        Intrinsics.checkNotNullParameter(colorScheme2, "other");
        colorScheme.m1597setPrimary8_81llA$material3_release(colorScheme2.m1568getPrimary0d7_KjU());
        colorScheme.m1587setOnPrimary8_81llA$material3_release(colorScheme2.m1558getOnPrimary0d7_KjU());
        colorScheme.m1598setPrimaryContainer8_81llA$material3_release(colorScheme2.m1569getPrimaryContainer0d7_KjU());
        colorScheme.m1588setOnPrimaryContainer8_81llA$material3_release(colorScheme2.m1559getOnPrimaryContainer0d7_KjU());
        colorScheme.m1582setInversePrimary8_81llA$material3_release(colorScheme2.m1553getInversePrimary0d7_KjU());
        colorScheme.m1600setSecondary8_81llA$material3_release(colorScheme2.m1571getSecondary0d7_KjU());
        colorScheme.m1589setOnSecondary8_81llA$material3_release(colorScheme2.m1560getOnSecondary0d7_KjU());
        colorScheme.m1601setSecondaryContainer8_81llA$material3_release(colorScheme2.m1572getSecondaryContainer0d7_KjU());
        colorScheme.m1590setOnSecondaryContainer8_81llA$material3_release(colorScheme2.m1561getOnSecondaryContainer0d7_KjU());
        colorScheme.m1605setTertiary8_81llA$material3_release(colorScheme2.m1576getTertiary0d7_KjU());
        colorScheme.m1593setOnTertiary8_81llA$material3_release(colorScheme2.m1564getOnTertiary0d7_KjU());
        colorScheme.m1606setTertiaryContainer8_81llA$material3_release(colorScheme2.m1577getTertiaryContainer0d7_KjU());
        colorScheme.m1594setOnTertiaryContainer8_81llA$material3_release(colorScheme2.m1565getOnTertiaryContainer0d7_KjU());
        colorScheme.m1578setBackground8_81llA$material3_release(colorScheme2.m1549getBackground0d7_KjU());
        colorScheme.m1584setOnBackground8_81llA$material3_release(colorScheme2.m1555getOnBackground0d7_KjU());
        colorScheme.m1602setSurface8_81llA$material3_release(colorScheme2.m1573getSurface0d7_KjU());
        colorScheme.m1591setOnSurface8_81llA$material3_release(colorScheme2.m1562getOnSurface0d7_KjU());
        colorScheme.m1604setSurfaceVariant8_81llA$material3_release(colorScheme2.m1575getSurfaceVariant0d7_KjU());
        colorScheme.m1592setOnSurfaceVariant8_81llA$material3_release(colorScheme2.m1563getOnSurfaceVariant0d7_KjU());
        colorScheme.m1603setSurfaceTint8_81llA$material3_release(colorScheme2.m1574getSurfaceTint0d7_KjU());
        colorScheme.m1583setInverseSurface8_81llA$material3_release(colorScheme2.m1554getInverseSurface0d7_KjU());
        colorScheme.m1581setInverseOnSurface8_81llA$material3_release(colorScheme2.m1552getInverseOnSurface0d7_KjU());
        colorScheme.m1579setError8_81llA$material3_release(colorScheme2.m1550getError0d7_KjU());
        colorScheme.m1585setOnError8_81llA$material3_release(colorScheme2.m1556getOnError0d7_KjU());
        colorScheme.m1580setErrorContainer8_81llA$material3_release(colorScheme2.m1551getErrorContainer0d7_KjU());
        colorScheme.m1586setOnErrorContainer8_81llA$material3_release(colorScheme2.m1557getOnErrorContainer0d7_KjU());
        colorScheme.m1595setOutline8_81llA$material3_release(colorScheme2.m1566getOutline0d7_KjU());
        colorScheme.m1596setOutlineVariant8_81llA$material3_release(colorScheme2.m1567getOutlineVariant0d7_KjU());
        colorScheme.m1599setScrim8_81llA$material3_release(colorScheme2.m1570getScrim0d7_KjU());
    }
}
