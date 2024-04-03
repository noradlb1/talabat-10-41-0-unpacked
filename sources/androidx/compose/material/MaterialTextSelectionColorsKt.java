package androidx.compose.material;

import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a-\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\t\u0010\n\u001a%\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000e\u0010\u000f\u001a5\u0010\u000b\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0011\u0010\u0012\u001a-\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u0015\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0001¢\u0006\u0002\u0010\u001a\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u001b"}, d2 = {"DefaultSelectionBackgroundAlpha", "", "DesiredContrastRatio", "MinimumSelectionBackgroundAlpha", "binarySearchForAccessibleSelectionColorAlpha", "selectionColor", "Landroidx/compose/ui/graphics/Color;", "textColor", "backgroundColor", "binarySearchForAccessibleSelectionColorAlpha-ysEtTa8", "(JJJ)F", "calculateContrastRatio", "foreground", "background", "calculateContrastRatio--OWjLjI", "(JJ)F", "selectionColorAlpha", "calculateContrastRatio-nb2GgbA", "(JFJJ)F", "calculateSelectionBackgroundColor", "calculateSelectionBackgroundColor-ysEtTa8", "(JJJ)J", "rememberTextSelectionColors", "Landroidx/compose/foundation/text/selection/TextSelectionColors;", "colors", "Landroidx/compose/material/Colors;", "(Landroidx/compose/material/Colors;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/text/selection/TextSelectionColors;", "material_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class MaterialTextSelectionColorsKt {
    private static final float DefaultSelectionBackgroundAlpha = 0.4f;
    private static final float DesiredContrastRatio = 4.5f;
    private static final float MinimumSelectionBackgroundAlpha = 0.2f;

    /* renamed from: binarySearchForAccessibleSelectionColorAlpha-ysEtTa8  reason: not valid java name */
    private static final float m1286binarySearchForAccessibleSelectionColorAlphaysEtTa8(long j11, long j12, long j13) {
        float f11 = 0.2f;
        float f12 = 0.4f;
        float f13 = 0.4f;
        for (int i11 = 0; i11 < 7; i11++) {
            float r22 = (m1288calculateContrastRationb2GgbA(j11, f12, j12, j13) / 4.5f) - 1.0f;
            if (0.0f <= r22 && r22 <= 0.01f) {
                break;
            }
            if (r22 < 0.0f) {
                f13 = f12;
            } else {
                f11 = f12;
            }
            f12 = (f13 + f11) / 2.0f;
        }
        return f12;
    }

    /* renamed from: calculateContrastRatio--OWjLjI  reason: not valid java name */
    public static final float m1287calculateContrastRatioOWjLjI(long j11, long j12) {
        float r02 = ColorKt.m2972luminance8_81llA(j11) + 0.05f;
        float r22 = ColorKt.m2972luminance8_81llA(j12) + 0.05f;
        return Math.max(r02, r22) / Math.min(r02, r22);
    }

    /* renamed from: calculateContrastRatio-nb2GgbA  reason: not valid java name */
    private static final float m1288calculateContrastRationb2GgbA(long j11, float f11, long j12, long j13) {
        long r82 = ColorKt.m2965compositeOverOWjLjI(Color.m2918copywmQWz5c$default(j11, f11, 0.0f, 0.0f, 0.0f, 14, (Object) null), j13);
        return m1287calculateContrastRatioOWjLjI(ColorKt.m2965compositeOverOWjLjI(j12, r82), r82);
    }

    /* renamed from: calculateSelectionBackgroundColor-ysEtTa8  reason: not valid java name */
    public static final long m1289calculateSelectionBackgroundColorysEtTa8(long j11, long j12, long j13) {
        float r102;
        float r02 = m1288calculateContrastRationb2GgbA(j11, 0.4f, j12, j13);
        float r12 = m1288calculateContrastRationb2GgbA(j11, 0.2f, j12, j13);
        if (r02 >= 4.5f) {
            r102 = 0.4f;
        } else if (r12 < 4.5f) {
            r102 = 0.2f;
        } else {
            r102 = m1286binarySearchForAccessibleSelectionColorAlphaysEtTa8(j11, j12, j13);
        }
        return Color.m2918copywmQWz5c$default(j11, r102, 0.0f, 0.0f, 0.0f, 14, (Object) null);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v8, resolved type: androidx.compose.foundation.text.selection.TextSelectionColors} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v2, resolved type: androidx.compose.foundation.text.selection.TextSelectionColors} */
    /* JADX WARNING: type inference failed for: r9v6 */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0081, code lost:
        if (r9 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L_0x0083;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    @org.jetbrains.annotations.NotNull
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final androidx.compose.foundation.text.selection.TextSelectionColors rememberTextSelectionColors(@org.jetbrains.annotations.NotNull androidx.compose.material.Colors r17, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r18, int r19) {
        /*
            r0 = r17
            r1 = r18
            java.lang.String r2 = "colors"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r2)
            r2 = -721696685(0xffffffffd4fbc853, float:-8.6511814E12)
            r1.startReplaceableGroup(r2)
            long r3 = r17.m1179getPrimary0d7_KjU()
            long r7 = r17.m1172getBackground0d7_KjU()
            r2 = 35572910(0x21eccae, float:1.1666747E-37)
            r1.startReplaceableGroup(r2)
            long r5 = androidx.compose.material.ColorsKt.m1196contentColorFor4WTKRHQ(r0, r7)
            androidx.compose.ui.graphics.Color$Companion r2 = androidx.compose.ui.graphics.Color.Companion
            long r9 = r2.m2955getUnspecified0d7_KjU()
            int r2 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
            if (r2 == 0) goto L_0x002d
            r2 = 1
            goto L_0x002e
        L_0x002d:
            r2 = 0
        L_0x002e:
            if (r2 == 0) goto L_0x0031
            goto L_0x003f
        L_0x0031:
            androidx.compose.runtime.ProvidableCompositionLocal r2 = androidx.compose.material.ContentColorKt.getLocalContentColor()
            java.lang.Object r2 = r1.consume(r2)
            androidx.compose.ui.graphics.Color r2 = (androidx.compose.ui.graphics.Color) r2
            long r5 = r2.m2929unboximpl()
        L_0x003f:
            r9 = r5
            r18.endReplaceableGroup()
            androidx.compose.material.ContentAlpha r2 = androidx.compose.material.ContentAlpha.INSTANCE
            r5 = 6
            float r11 = r2.getMedium(r1, r5)
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 14
            r16 = 0
            long r5 = androidx.compose.ui.graphics.Color.m2918copywmQWz5c$default(r9, r11, r12, r13, r14, r15, r16)
            androidx.compose.ui.graphics.Color r2 = androidx.compose.ui.graphics.Color.m2909boximpl(r3)
            androidx.compose.ui.graphics.Color r9 = androidx.compose.ui.graphics.Color.m2909boximpl(r7)
            androidx.compose.ui.graphics.Color r10 = androidx.compose.ui.graphics.Color.m2909boximpl(r5)
            r11 = 1618982084(0x607fb4c4, float:7.370227E19)
            r1.startReplaceableGroup(r11)
            boolean r2 = r1.changed((java.lang.Object) r2)
            boolean r9 = r1.changed((java.lang.Object) r9)
            r2 = r2 | r9
            boolean r9 = r1.changed((java.lang.Object) r10)
            r2 = r2 | r9
            java.lang.Object r9 = r18.rememberedValue()
            if (r2 != 0) goto L_0x0083
            androidx.compose.runtime.Composer$Companion r2 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r2 = r2.getEmpty()
            if (r9 != r2) goto L_0x0095
        L_0x0083:
            androidx.compose.foundation.text.selection.TextSelectionColors r9 = new androidx.compose.foundation.text.selection.TextSelectionColors
            long r11 = r17.m1179getPrimary0d7_KjU()
            long r13 = m1289calculateSelectionBackgroundColorysEtTa8(r3, r5, r7)
            r15 = 0
            r10 = r9
            r10.<init>(r11, r13, r15)
            r1.updateRememberedValue(r9)
        L_0x0095:
            r18.endReplaceableGroup()
            androidx.compose.foundation.text.selection.TextSelectionColors r9 = (androidx.compose.foundation.text.selection.TextSelectionColors) r9
            r18.endReplaceableGroup()
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.MaterialTextSelectionColorsKt.rememberTextSelectionColors(androidx.compose.material.Colors, androidx.compose.runtime.Composer, int):androidx.compose.foundation.text.selection.TextSelectionColors");
    }
}
