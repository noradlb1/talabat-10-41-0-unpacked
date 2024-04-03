package androidx.compose.material;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ReadOnlyComposable;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u001d\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\f\u001a\u0001\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u00062\b\b\u0002\u0010\u0010\u001a\u00020\u00062\b\b\u0002\u0010\u0011\u001a\u00020\u00062\b\b\u0002\u0010\u0012\u001a\u00020\u00062\b\b\u0002\u0010\u0013\u001a\u00020\u00062\b\b\u0002\u0010\u0014\u001a\u00020\u00062\b\b\u0002\u0010\u0015\u001a\u00020\u00062\b\b\u0002\u0010\u0016\u001a\u00020\u00062\b\b\u0002\u0010\u0017\u001a\u00020\u00062\b\b\u0002\u0010\u0018\u001a\u00020\u00062\b\b\u0002\u0010\u0019\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u0001\u0010\u001c\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u00062\b\b\u0002\u0010\u0010\u001a\u00020\u00062\b\b\u0002\u0010\u0011\u001a\u00020\u00062\b\b\u0002\u0010\u0012\u001a\u00020\u00062\b\b\u0002\u0010\u0013\u001a\u00020\u00062\b\b\u0002\u0010\u0014\u001a\u00020\u00062\b\b\u0002\u0010\u0015\u001a\u00020\u00062\b\b\u0002\u0010\u0016\u001a\u00020\u00062\b\b\u0002\u0010\u0017\u001a\u00020\u00062\b\b\u0002\u0010\u0018\u001a\u00020\u00062\b\b\u0002\u0010\u0019\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001d\u0010\u001b\u001a\u001f\u0010\t\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\n\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001e\u0010\u001f\u001a\u0014\u0010 \u001a\u00020!*\u00020\u00022\u0006\u0010\"\u001a\u00020\u0002H\u0000\"\u001a\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004\"\u0018\u0010\u0005\u001a\u00020\u0006*\u00020\u00028Fø\u0001\u0000¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006#"}, d2 = {"LocalColors", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/material/Colors;", "getLocalColors", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "primarySurface", "Landroidx/compose/ui/graphics/Color;", "getPrimarySurface", "(Landroidx/compose/material/Colors;)J", "contentColorFor", "backgroundColor", "contentColorFor-ek8zF_U", "(JLandroidx/compose/runtime/Composer;I)J", "darkColors", "primary", "primaryVariant", "secondary", "secondaryVariant", "background", "surface", "error", "onPrimary", "onSecondary", "onBackground", "onSurface", "onError", "darkColors-2qZNXz8", "(JJJJJJJJJJJJ)Landroidx/compose/material/Colors;", "lightColors", "lightColors-2qZNXz8", "contentColorFor-4WTKRHQ", "(Landroidx/compose/material/Colors;J)J", "updateColorsFrom", "", "other", "material_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class ColorsKt {
    @NotNull
    private static final ProvidableCompositionLocal<Colors> LocalColors = CompositionLocalKt.staticCompositionLocalOf(ColorsKt$LocalColors$1.INSTANCE);

    /* renamed from: contentColorFor-4WTKRHQ  reason: not valid java name */
    public static final long m1196contentColorFor4WTKRHQ(@NotNull Colors colors, long j11) {
        Intrinsics.checkNotNullParameter(colors, "$this$contentColorFor");
        if (Color.m2920equalsimpl0(j11, colors.m1179getPrimary0d7_KjU())) {
            return colors.m1176getOnPrimary0d7_KjU();
        }
        if (Color.m2920equalsimpl0(j11, colors.m1180getPrimaryVariant0d7_KjU())) {
            return colors.m1176getOnPrimary0d7_KjU();
        }
        if (Color.m2920equalsimpl0(j11, colors.m1181getSecondary0d7_KjU())) {
            return colors.m1177getOnSecondary0d7_KjU();
        }
        if (Color.m2920equalsimpl0(j11, colors.m1182getSecondaryVariant0d7_KjU())) {
            return colors.m1177getOnSecondary0d7_KjU();
        }
        if (Color.m2920equalsimpl0(j11, colors.m1172getBackground0d7_KjU())) {
            return colors.m1174getOnBackground0d7_KjU();
        }
        if (Color.m2920equalsimpl0(j11, colors.m1183getSurface0d7_KjU())) {
            return colors.m1178getOnSurface0d7_KjU();
        }
        if (Color.m2920equalsimpl0(j11, colors.m1173getError0d7_KjU())) {
            return colors.m1175getOnError0d7_KjU();
        }
        return Color.Companion.m2955getUnspecified0d7_KjU();
    }

    @ReadOnlyComposable
    @Composable
    /* renamed from: contentColorFor-ek8zF_U  reason: not valid java name */
    public static final long m1197contentColorForek8zF_U(long j11, @Nullable Composer composer, int i11) {
        boolean z11;
        long r22 = m1196contentColorFor4WTKRHQ(MaterialTheme.INSTANCE.getColors(composer, 6), j11);
        if (r22 != Color.Companion.m2955getUnspecified0d7_KjU()) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            return r22;
        }
        return ((Color) composer.consume(ContentColorKt.getLocalContentColor())).m2929unboximpl();
    }

    @NotNull
    /* renamed from: darkColors-2qZNXz8  reason: not valid java name */
    public static final Colors m1198darkColors2qZNXz8(long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j21, long j22, long j23) {
        return new Colors(j11, j12, j13, j14, j15, j16, j17, j18, j19, j21, j22, j23, false, (DefaultConstructorMarker) null);
    }

    /* renamed from: darkColors-2qZNXz8$default  reason: not valid java name */
    public static /* synthetic */ Colors m1199darkColors2qZNXz8$default(long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j21, long j22, long j23, int i11, Object obj) {
        long j24;
        long j25;
        long j26;
        long j27;
        long j28;
        long j29;
        long j31;
        long j32;
        long j33;
        long j34;
        long j35;
        long j36;
        int i12 = i11;
        if ((i12 & 1) != 0) {
            j24 = ColorKt.Color(4290479868L);
        } else {
            j24 = j11;
        }
        if ((i12 & 2) != 0) {
            j25 = ColorKt.Color(4281794739L);
        } else {
            j25 = j12;
        }
        if ((i12 & 4) != 0) {
            j26 = ColorKt.Color(4278442694L);
        } else {
            j26 = j13;
        }
        if ((i12 & 8) != 0) {
            j27 = j26;
        } else {
            j27 = j14;
        }
        if ((i12 & 16) != 0) {
            j28 = ColorKt.Color(4279374354L);
        } else {
            j28 = j15;
        }
        if ((i12 & 32) != 0) {
            j29 = ColorKt.Color(4279374354L);
        } else {
            j29 = j16;
        }
        if ((i12 & 64) != 0) {
            j31 = ColorKt.Color(4291782265L);
        } else {
            j31 = j17;
        }
        if ((i12 & 128) != 0) {
            j32 = Color.Companion.m2945getBlack0d7_KjU();
        } else {
            j32 = j18;
        }
        if ((i12 & 256) != 0) {
            j33 = Color.Companion.m2945getBlack0d7_KjU();
        } else {
            j33 = j19;
        }
        if ((i12 & 512) != 0) {
            j34 = Color.Companion.m2956getWhite0d7_KjU();
        } else {
            j34 = j21;
        }
        if ((i12 & 1024) != 0) {
            j35 = Color.Companion.m2956getWhite0d7_KjU();
        } else {
            j35 = j22;
        }
        if ((i12 & 2048) != 0) {
            j36 = Color.Companion.m2945getBlack0d7_KjU();
        } else {
            j36 = j23;
        }
        return m1198darkColors2qZNXz8(j24, j25, j26, j27, j28, j29, j31, j32, j33, j34, j35, j36);
    }

    @NotNull
    public static final ProvidableCompositionLocal<Colors> getLocalColors() {
        return LocalColors;
    }

    public static final long getPrimarySurface(@NotNull Colors colors) {
        Intrinsics.checkNotNullParameter(colors, "<this>");
        if (colors.isLight()) {
            return colors.m1179getPrimary0d7_KjU();
        }
        return colors.m1183getSurface0d7_KjU();
    }

    @NotNull
    /* renamed from: lightColors-2qZNXz8  reason: not valid java name */
    public static final Colors m1200lightColors2qZNXz8(long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j21, long j22, long j23) {
        return new Colors(j11, j12, j13, j14, j15, j16, j17, j18, j19, j21, j22, j23, true, (DefaultConstructorMarker) null);
    }

    /* renamed from: lightColors-2qZNXz8$default  reason: not valid java name */
    public static /* synthetic */ Colors m1201lightColors2qZNXz8$default(long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j21, long j22, long j23, int i11, Object obj) {
        long j24;
        long j25;
        long j26;
        long j27;
        long j28;
        long j29;
        long j31;
        long j32;
        long j33;
        long j34;
        long j35;
        long j36;
        int i12 = i11;
        if ((i12 & 1) != 0) {
            j24 = ColorKt.Color(4284612846L);
        } else {
            j24 = j11;
        }
        if ((i12 & 2) != 0) {
            j25 = ColorKt.Color(4281794739L);
        } else {
            j25 = j12;
        }
        if ((i12 & 4) != 0) {
            j26 = ColorKt.Color(4278442694L);
        } else {
            j26 = j13;
        }
        if ((i12 & 8) != 0) {
            j27 = ColorKt.Color(4278290310L);
        } else {
            j27 = j14;
        }
        if ((i12 & 16) != 0) {
            j28 = Color.Companion.m2956getWhite0d7_KjU();
        } else {
            j28 = j15;
        }
        if ((i12 & 32) != 0) {
            j29 = Color.Companion.m2956getWhite0d7_KjU();
        } else {
            j29 = j16;
        }
        if ((i12 & 64) != 0) {
            j31 = ColorKt.Color(4289724448L);
        } else {
            j31 = j17;
        }
        if ((i12 & 128) != 0) {
            j32 = Color.Companion.m2956getWhite0d7_KjU();
        } else {
            j32 = j18;
        }
        long j37 = j32;
        if ((i12 & 256) != 0) {
            j33 = Color.Companion.m2945getBlack0d7_KjU();
        } else {
            j33 = j19;
        }
        long j38 = j33;
        if ((i12 & 512) != 0) {
            j34 = Color.Companion.m2945getBlack0d7_KjU();
        } else {
            j34 = j21;
        }
        long j39 = j34;
        if ((i12 & 1024) != 0) {
            j35 = Color.Companion.m2945getBlack0d7_KjU();
        } else {
            j35 = j22;
        }
        if ((i12 & 2048) != 0) {
            j36 = Color.Companion.m2956getWhite0d7_KjU();
        } else {
            j36 = j23;
        }
        return m1200lightColors2qZNXz8(j24, j25, j26, j27, j28, j29, j31, j37, j38, j39, j35, j36);
    }

    public static final void updateColorsFrom(@NotNull Colors colors, @NotNull Colors colors2) {
        Intrinsics.checkNotNullParameter(colors, "<this>");
        Intrinsics.checkNotNullParameter(colors2, "other");
        colors.m1191setPrimary8_81llA$material_release(colors2.m1179getPrimary0d7_KjU());
        colors.m1192setPrimaryVariant8_81llA$material_release(colors2.m1180getPrimaryVariant0d7_KjU());
        colors.m1193setSecondary8_81llA$material_release(colors2.m1181getSecondary0d7_KjU());
        colors.m1194setSecondaryVariant8_81llA$material_release(colors2.m1182getSecondaryVariant0d7_KjU());
        colors.m1184setBackground8_81llA$material_release(colors2.m1172getBackground0d7_KjU());
        colors.m1195setSurface8_81llA$material_release(colors2.m1183getSurface0d7_KjU());
        colors.m1185setError8_81llA$material_release(colors2.m1173getError0d7_KjU());
        colors.m1188setOnPrimary8_81llA$material_release(colors2.m1176getOnPrimary0d7_KjU());
        colors.m1189setOnSecondary8_81llA$material_release(colors2.m1177getOnSecondary0d7_KjU());
        colors.m1186setOnBackground8_81llA$material_release(colors2.m1174getOnBackground0d7_KjU());
        colors.m1190setOnSurface8_81llA$material_release(colors2.m1178getOnSurface0d7_KjU());
        colors.m1187setOnError8_81llA$material_release(colors2.m1175getOnError0d7_KjU());
        colors.setLight$material_release(colors2.isLight());
    }
}
