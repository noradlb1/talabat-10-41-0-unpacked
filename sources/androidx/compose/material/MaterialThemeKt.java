package androidx.compose.material;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a>\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0011\u0010\b\u001a\r\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\nH\u0007¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"MaterialTheme", "", "colors", "Landroidx/compose/material/Colors;", "typography", "Landroidx/compose/material/Typography;", "shapes", "Landroidx/compose/material/Shapes;", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/material/Colors;Landroidx/compose/material/Typography;Landroidx/compose/material/Shapes;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "material_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class MaterialThemeKt {
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00ae, code lost:
        if ((r49 & 4) != 0) goto L_0x00d3;
     */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x00ed  */
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[0[0]]")
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void MaterialTheme(@org.jetbrains.annotations.Nullable androidx.compose.material.Colors r43, @org.jetbrains.annotations.Nullable androidx.compose.material.Typography r44, @org.jetbrains.annotations.Nullable androidx.compose.material.Shapes r45, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r46, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r47, int r48, int r49) {
        /*
            r4 = r46
            r5 = r48
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            r0 = -891417079(0xffffffffcade0e09, float:-7276292.5)
            r1 = r47
            androidx.compose.runtime.Composer r0 = r1.startRestartGroup(r0)
            r1 = r5 & 14
            r3 = 2
            if (r1 != 0) goto L_0x002a
            r1 = r49 & 1
            if (r1 != 0) goto L_0x0025
            r1 = r43
            boolean r6 = r0.changed((java.lang.Object) r1)
            if (r6 == 0) goto L_0x0027
            r6 = 4
            goto L_0x0028
        L_0x0025:
            r1 = r43
        L_0x0027:
            r6 = r3
        L_0x0028:
            r6 = r6 | r5
            goto L_0x002d
        L_0x002a:
            r1 = r43
            r6 = r5
        L_0x002d:
            r7 = r5 & 112(0x70, float:1.57E-43)
            if (r7 != 0) goto L_0x0046
            r7 = r49 & 2
            if (r7 != 0) goto L_0x0040
            r7 = r44
            boolean r8 = r0.changed((java.lang.Object) r7)
            if (r8 == 0) goto L_0x0042
            r8 = 32
            goto L_0x0044
        L_0x0040:
            r7 = r44
        L_0x0042:
            r8 = 16
        L_0x0044:
            r6 = r6 | r8
            goto L_0x0048
        L_0x0046:
            r7 = r44
        L_0x0048:
            r8 = r5 & 896(0x380, float:1.256E-42)
            if (r8 != 0) goto L_0x0061
            r8 = r49 & 4
            if (r8 != 0) goto L_0x005b
            r8 = r45
            boolean r9 = r0.changed((java.lang.Object) r8)
            if (r9 == 0) goto L_0x005d
            r9 = 256(0x100, float:3.59E-43)
            goto L_0x005f
        L_0x005b:
            r8 = r45
        L_0x005d:
            r9 = 128(0x80, float:1.794E-43)
        L_0x005f:
            r6 = r6 | r9
            goto L_0x0063
        L_0x0061:
            r8 = r45
        L_0x0063:
            r9 = r49 & 8
            if (r9 == 0) goto L_0x006a
            r6 = r6 | 3072(0xc00, float:4.305E-42)
            goto L_0x007a
        L_0x006a:
            r9 = r5 & 7168(0x1c00, float:1.0045E-41)
            if (r9 != 0) goto L_0x007a
            boolean r9 = r0.changed((java.lang.Object) r4)
            if (r9 == 0) goto L_0x0077
            r9 = 2048(0x800, float:2.87E-42)
            goto L_0x0079
        L_0x0077:
            r9 = 1024(0x400, float:1.435E-42)
        L_0x0079:
            r6 = r6 | r9
        L_0x007a:
            r9 = r6 & 5851(0x16db, float:8.199E-42)
            r10 = 1170(0x492, float:1.64E-42)
            if (r9 != r10) goto L_0x008e
            boolean r9 = r0.getSkipping()
            if (r9 != 0) goto L_0x0087
            goto L_0x008e
        L_0x0087:
            r0.skipToGroupEnd()
            r2 = r7
            r3 = r8
            goto L_0x01a2
        L_0x008e:
            r0.startDefaults()
            r9 = r5 & 1
            r13 = 6
            if (r9 == 0) goto L_0x00b1
            boolean r9 = r0.getDefaultsInvalid()
            if (r9 == 0) goto L_0x009d
            goto L_0x00b1
        L_0x009d:
            r0.skipToGroupEnd()
            r9 = r49 & 1
            if (r9 == 0) goto L_0x00a6
            r6 = r6 & -15
        L_0x00a6:
            r9 = r49 & 2
            if (r9 == 0) goto L_0x00ac
            r6 = r6 & -113(0xffffffffffffff8f, float:NaN)
        L_0x00ac:
            r9 = r49 & 4
            if (r9 == 0) goto L_0x00d5
            goto L_0x00d3
        L_0x00b1:
            r9 = r49 & 1
            if (r9 == 0) goto L_0x00bd
            androidx.compose.material.MaterialTheme r1 = androidx.compose.material.MaterialTheme.INSTANCE
            androidx.compose.material.Colors r1 = r1.getColors(r0, r13)
            r6 = r6 & -15
        L_0x00bd:
            r9 = r49 & 2
            if (r9 == 0) goto L_0x00c9
            androidx.compose.material.MaterialTheme r7 = androidx.compose.material.MaterialTheme.INSTANCE
            androidx.compose.material.Typography r7 = r7.getTypography(r0, r13)
            r6 = r6 & -113(0xffffffffffffff8f, float:NaN)
        L_0x00c9:
            r9 = r49 & 4
            if (r9 == 0) goto L_0x00d5
            androidx.compose.material.MaterialTheme r8 = androidx.compose.material.MaterialTheme.INSTANCE
            androidx.compose.material.Shapes r8 = r8.getShapes(r0, r13)
        L_0x00d3:
            r6 = r6 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x00d5:
            r10 = r6
            r12 = r7
            r11 = r8
            r0.endDefaults()
            r6 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r0.startReplaceableGroup(r6)
            java.lang.Object r6 = r0.rememberedValue()
            androidx.compose.runtime.Composer$Companion r7 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r7 = r7.getEmpty()
            if (r6 != r7) goto L_0x0113
            r15 = 0
            r17 = 0
            r19 = 0
            r21 = 0
            r23 = 0
            r25 = 0
            r27 = 0
            r29 = 0
            r31 = 0
            r33 = 0
            r35 = 0
            r37 = 0
            r39 = 0
            r40 = 8191(0x1fff, float:1.1478E-41)
            r41 = 0
            r14 = r1
            androidx.compose.material.Colors r6 = androidx.compose.material.Colors.m1170copypvPzIIM$default(r14, r15, r17, r19, r21, r23, r25, r27, r29, r31, r33, r35, r37, r39, r40, r41)
            r0.updateRememberedValue(r6)
        L_0x0113:
            r0.endReplaceableGroup()
            r14 = r6
            androidx.compose.material.Colors r14 = (androidx.compose.material.Colors) r14
            androidx.compose.material.ColorsKt.updateColorsFrom(r14, r1)
            r6 = 0
            r7 = 0
            r8 = 0
            r15 = 0
            r16 = 7
            r42 = r10
            r10 = r0
            r2 = r11
            r11 = r15
            r15 = r12
            r12 = r16
            androidx.compose.foundation.Indication r6 = androidx.compose.material.ripple.RippleKt.m1485rememberRipple9IZ8Weo(r6, r7, r8, r10, r11, r12)
            r7 = 0
            androidx.compose.foundation.text.selection.TextSelectionColors r8 = androidx.compose.material.MaterialTextSelectionColorsKt.rememberTextSelectionColors(r14, r0, r7)
            r9 = 7
            androidx.compose.runtime.ProvidedValue[] r9 = new androidx.compose.runtime.ProvidedValue[r9]
            androidx.compose.runtime.ProvidableCompositionLocal r10 = androidx.compose.material.ColorsKt.getLocalColors()
            androidx.compose.runtime.ProvidedValue r10 = r10.provides(r14)
            r9[r7] = r10
            androidx.compose.runtime.ProvidableCompositionLocal r7 = androidx.compose.material.ContentAlphaKt.getLocalContentAlpha()
            androidx.compose.material.ContentAlpha r10 = androidx.compose.material.ContentAlpha.INSTANCE
            float r10 = r10.getHigh(r0, r13)
            java.lang.Float r10 = java.lang.Float.valueOf(r10)
            androidx.compose.runtime.ProvidedValue r7 = r7.provides(r10)
            r10 = 1
            r9[r10] = r7
            androidx.compose.runtime.ProvidableCompositionLocal r7 = androidx.compose.foundation.IndicationKt.getLocalIndication()
            androidx.compose.runtime.ProvidedValue r6 = r7.provides(r6)
            r9[r3] = r6
            androidx.compose.runtime.ProvidableCompositionLocal r3 = androidx.compose.material.ripple.RippleThemeKt.getLocalRippleTheme()
            androidx.compose.material.MaterialRippleTheme r6 = androidx.compose.material.MaterialRippleTheme.INSTANCE
            androidx.compose.runtime.ProvidedValue r3 = r3.provides(r6)
            r6 = 3
            r9[r6] = r3
            androidx.compose.runtime.ProvidableCompositionLocal r3 = androidx.compose.material.ShapesKt.getLocalShapes()
            androidx.compose.runtime.ProvidedValue r3 = r3.provides(r2)
            r6 = 4
            r9[r6] = r3
            androidx.compose.runtime.ProvidableCompositionLocal r3 = androidx.compose.foundation.text.selection.TextSelectionColorsKt.getLocalTextSelectionColors()
            androidx.compose.runtime.ProvidedValue r3 = r3.provides(r8)
            r6 = 5
            r9[r6] = r3
            androidx.compose.runtime.ProvidableCompositionLocal r3 = androidx.compose.material.TypographyKt.getLocalTypography()
            androidx.compose.runtime.ProvidedValue r3 = r3.provides(r15)
            r9[r13] = r3
            androidx.compose.material.MaterialThemeKt$MaterialTheme$1 r3 = new androidx.compose.material.MaterialThemeKt$MaterialTheme$1
            r6 = r42
            r3.<init>(r15, r4, r6)
            r6 = -1740102967(0xffffffff984822c9, float:-2.5866956E-24)
            androidx.compose.runtime.internal.ComposableLambda r3 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r0, r6, r10, r3)
            r6 = 56
            androidx.compose.runtime.CompositionLocalKt.CompositionLocalProvider((androidx.compose.runtime.ProvidedValue<?>[]) r9, (kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r3, (androidx.compose.runtime.Composer) r0, (int) r6)
            r3 = r2
            r2 = r15
        L_0x01a2:
            androidx.compose.runtime.ScopeUpdateScope r7 = r0.endRestartGroup()
            if (r7 != 0) goto L_0x01a9
            goto L_0x01b8
        L_0x01a9:
            androidx.compose.material.MaterialThemeKt$MaterialTheme$2 r8 = new androidx.compose.material.MaterialThemeKt$MaterialTheme$2
            r0 = r8
            r4 = r46
            r5 = r48
            r6 = r49
            r0.<init>(r1, r2, r3, r4, r5, r6)
            r7.updateScope(r8)
        L_0x01b8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.MaterialThemeKt.MaterialTheme(androidx.compose.material.Colors, androidx.compose.material.Typography, androidx.compose.material.Shapes, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }
}
