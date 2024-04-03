package androidx.compose.ui.text.font;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a9\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\n\u0010\u000b\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\f"}, d2 = {"synthesizeTypeface", "", "Landroidx/compose/ui/text/font/FontSynthesis;", "typeface", "font", "Landroidx/compose/ui/text/font/Font;", "requestedWeight", "Landroidx/compose/ui/text/font/FontWeight;", "requestedStyle", "Landroidx/compose/ui/text/font/FontStyle;", "synthesizeTypeface-FxwP2eA", "(ILjava/lang/Object;Landroidx/compose/ui/text/font/Font;Landroidx/compose/ui/text/font/FontWeight;I)Ljava/lang/Object;", "ui-text_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class FontSynthesis_androidKt {
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0061 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x007c  */
    @org.jetbrains.annotations.NotNull
    /* renamed from: synthesizeTypeface-FxwP2eA  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object m5143synthesizeTypefaceFxwP2eA(int r5, @org.jetbrains.annotations.NotNull java.lang.Object r6, @org.jetbrains.annotations.NotNull androidx.compose.ui.text.font.Font r7, @org.jetbrains.annotations.NotNull androidx.compose.ui.text.font.FontWeight r8, int r9) {
        /*
            java.lang.String r0 = "typeface"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "font"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "requestedWeight"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            boolean r0 = r6 instanceof android.graphics.Typeface
            if (r0 != 0) goto L_0x0014
            return r6
        L_0x0014:
            boolean r0 = androidx.compose.ui.text.font.FontSynthesis.m5136isWeightOnimpl$ui_text_release(r5)
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0042
            androidx.compose.ui.text.font.FontWeight r0 = r7.getWeight()
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r8)
            if (r0 != 0) goto L_0x0042
            androidx.compose.ui.text.font.FontWeight$Companion r0 = androidx.compose.ui.text.font.FontWeight.Companion
            androidx.compose.ui.text.font.FontWeight r3 = androidx.compose.ui.text.font.AndroidFontUtils_androidKt.getAndroidBold(r0)
            int r3 = r8.compareTo((androidx.compose.ui.text.font.FontWeight) r3)
            if (r3 < 0) goto L_0x0042
            androidx.compose.ui.text.font.FontWeight r3 = r7.getWeight()
            androidx.compose.ui.text.font.FontWeight r0 = androidx.compose.ui.text.font.AndroidFontUtils_androidKt.getAndroidBold(r0)
            int r0 = r3.compareTo((androidx.compose.ui.text.font.FontWeight) r0)
            if (r0 >= 0) goto L_0x0042
            r0 = r1
            goto L_0x0043
        L_0x0042:
            r0 = r2
        L_0x0043:
            boolean r5 = androidx.compose.ui.text.font.FontSynthesis.m5135isStyleOnimpl$ui_text_release(r5)
            if (r5 == 0) goto L_0x0055
            int r5 = r7.m5099getStyle_LCdwA()
            boolean r5 = androidx.compose.ui.text.font.FontStyle.m5124equalsimpl0(r9, r5)
            if (r5 != 0) goto L_0x0055
            r5 = r1
            goto L_0x0056
        L_0x0055:
            r5 = r2
        L_0x0056:
            if (r5 != 0) goto L_0x005b
            if (r0 != 0) goto L_0x005b
            return r6
        L_0x005b:
            int r3 = android.os.Build.VERSION.SDK_INT
            r4 = 28
            if (r3 >= r4) goto L_0x007c
            if (r5 == 0) goto L_0x0070
            androidx.compose.ui.text.font.FontStyle$Companion r5 = androidx.compose.ui.text.font.FontStyle.Companion
            int r5 = r5.m5128getItalic_LCdwA()
            boolean r5 = androidx.compose.ui.text.font.FontStyle.m5124equalsimpl0(r9, r5)
            if (r5 == 0) goto L_0x0070
            goto L_0x0071
        L_0x0070:
            r1 = r2
        L_0x0071:
            int r5 = androidx.compose.ui.text.font.AndroidFontUtils_androidKt.getAndroidTypefaceStyle(r0, r1)
            android.graphics.Typeface r6 = (android.graphics.Typeface) r6
            android.graphics.Typeface r5 = android.graphics.Typeface.create(r6, r5)
            goto L_0x00ae
        L_0x007c:
            if (r0 == 0) goto L_0x0083
            int r8 = r8.getWeight()
            goto L_0x008b
        L_0x0083:
            androidx.compose.ui.text.font.FontWeight r8 = r7.getWeight()
            int r8 = r8.getWeight()
        L_0x008b:
            if (r5 == 0) goto L_0x0098
            androidx.compose.ui.text.font.FontStyle$Companion r5 = androidx.compose.ui.text.font.FontStyle.Companion
            int r5 = r5.m5128getItalic_LCdwA()
            boolean r5 = androidx.compose.ui.text.font.FontStyle.m5124equalsimpl0(r9, r5)
            goto L_0x00a6
        L_0x0098:
            int r5 = r7.m5099getStyle_LCdwA()
            androidx.compose.ui.text.font.FontStyle$Companion r7 = androidx.compose.ui.text.font.FontStyle.Companion
            int r7 = r7.m5128getItalic_LCdwA()
            boolean r5 = androidx.compose.ui.text.font.FontStyle.m5124equalsimpl0(r5, r7)
        L_0x00a6:
            androidx.compose.ui.text.font.TypefaceHelperMethodsApi28 r7 = androidx.compose.ui.text.font.TypefaceHelperMethodsApi28.INSTANCE
            android.graphics.Typeface r6 = (android.graphics.Typeface) r6
            android.graphics.Typeface r5 = r7.create(r6, r8, r5)
        L_0x00ae:
            java.lang.String r6 = "if (Build.VERSION.SDK_IN…ht, finalFontStyle)\n    }"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.font.FontSynthesis_androidKt.m5143synthesizeTypefaceFxwP2eA(int, java.lang.Object, androidx.compose.ui.text.font.Font, androidx.compose.ui.text.font.FontWeight, int):java.lang.Object");
    }
}
