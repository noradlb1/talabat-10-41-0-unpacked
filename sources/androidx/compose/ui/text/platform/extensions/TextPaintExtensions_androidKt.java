package androidx.compose.ui.text.platform.extensions;

import androidx.compose.ui.text.SpanStyle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0000\u001aG\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00042&\u0010\u0007\u001a\"\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0000ø\u0001\u0000\u001a\f\u0010\u0010\u001a\u00020\u0011*\u00020\u0004H\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"correctBlurRadius", "", "blurRadius", "applySpanStyle", "Landroidx/compose/ui/text/SpanStyle;", "Landroidx/compose/ui/text/platform/AndroidTextPaint;", "style", "resolveTypeface", "Lkotlin/Function4;", "Landroidx/compose/ui/text/font/FontFamily;", "Landroidx/compose/ui/text/font/FontWeight;", "Landroidx/compose/ui/text/font/FontStyle;", "Landroidx/compose/ui/text/font/FontSynthesis;", "Landroid/graphics/Typeface;", "density", "Landroidx/compose/ui/unit/Density;", "hasFontAttributes", "", "ui-text_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class TextPaintExtensions_androidKt {
    /* JADX WARNING: Removed duplicated region for block: B:57:0x01bb  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x01c0  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x01d3  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x01de  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x01e1  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x01fc  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x01ff  */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final androidx.compose.ui.text.SpanStyle applySpanStyle(@org.jetbrains.annotations.NotNull androidx.compose.ui.text.platform.AndroidTextPaint r28, @org.jetbrains.annotations.NotNull androidx.compose.ui.text.SpanStyle r29, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function4<? super androidx.compose.ui.text.font.FontFamily, ? super androidx.compose.ui.text.font.FontWeight, ? super androidx.compose.ui.text.font.FontStyle, ? super androidx.compose.ui.text.font.FontSynthesis, ? extends android.graphics.Typeface> r30, @org.jetbrains.annotations.NotNull androidx.compose.ui.unit.Density r31) {
        /*
            r0 = r28
            r1 = r30
            r2 = r31
            java.lang.String r3 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r3)
            java.lang.String r3 = "style"
            r4 = r29
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r3)
            java.lang.String r3 = "resolveTypeface"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r3)
            java.lang.String r3 = "density"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r3)
            long r5 = r29.m5002getFontSizeXSAIIZE()
            long r5 = androidx.compose.ui.unit.TextUnit.m5658getTypeUIouoOA(r5)
            androidx.compose.ui.unit.TextUnitType$Companion r3 = androidx.compose.ui.unit.TextUnitType.Companion
            long r7 = r3.m5692getSpUIouoOA()
            boolean r7 = androidx.compose.ui.unit.TextUnitType.m5687equalsimpl0(r5, r7)
            if (r7 == 0) goto L_0x003c
            long r5 = r29.m5002getFontSizeXSAIIZE()
            float r2 = r2.m5446toPxR2X_6o(r5)
            r0.setTextSize(r2)
            goto L_0x0056
        L_0x003c:
            long r7 = r3.m5691getEmUIouoOA()
            boolean r2 = androidx.compose.ui.unit.TextUnitType.m5687equalsimpl0(r5, r7)
            if (r2 == 0) goto L_0x0056
            float r2 = r28.getTextSize()
            long r5 = r29.m5002getFontSizeXSAIIZE()
            float r5 = androidx.compose.ui.unit.TextUnit.m5659getValueimpl(r5)
            float r2 = r2 * r5
            r0.setTextSize(r2)
        L_0x0056:
            boolean r2 = hasFontAttributes(r29)
            if (r2 == 0) goto L_0x009f
            androidx.compose.ui.text.font.FontFamily r2 = r29.getFontFamily()
            androidx.compose.ui.text.font.FontWeight r5 = r29.getFontWeight()
            if (r5 != 0) goto L_0x006c
            androidx.compose.ui.text.font.FontWeight$Companion r5 = androidx.compose.ui.text.font.FontWeight.Companion
            androidx.compose.ui.text.font.FontWeight r5 = r5.getNormal()
        L_0x006c:
            androidx.compose.ui.text.font.FontStyle r6 = r29.m5003getFontStyle4Lr2A7w()
            if (r6 == 0) goto L_0x0077
            int r6 = r6.m5127unboximpl()
            goto L_0x007d
        L_0x0077:
            androidx.compose.ui.text.font.FontStyle$Companion r6 = androidx.compose.ui.text.font.FontStyle.Companion
            int r6 = r6.m5129getNormal_LCdwA()
        L_0x007d:
            androidx.compose.ui.text.font.FontStyle r6 = androidx.compose.ui.text.font.FontStyle.m5121boximpl(r6)
            androidx.compose.ui.text.font.FontSynthesis r7 = r29.m5004getFontSynthesisZQGJjVo()
            if (r7 == 0) goto L_0x008c
            int r7 = r7.m5138unboximpl()
            goto L_0x0092
        L_0x008c:
            androidx.compose.ui.text.font.FontSynthesis$Companion r7 = androidx.compose.ui.text.font.FontSynthesis.Companion
            int r7 = r7.m5139getAllGVVA2EU()
        L_0x0092:
            androidx.compose.ui.text.font.FontSynthesis r7 = androidx.compose.ui.text.font.FontSynthesis.m5130boximpl(r7)
            java.lang.Object r1 = r1.invoke(r2, r5, r6, r7)
            android.graphics.Typeface r1 = (android.graphics.Typeface) r1
            r0.setTypeface(r1)
        L_0x009f:
            androidx.compose.ui.text.intl.LocaleList r1 = r29.getLocaleList()
            r2 = 0
            if (r1 == 0) goto L_0x00e6
            androidx.compose.ui.text.intl.LocaleList r1 = r29.getLocaleList()
            androidx.compose.ui.text.intl.LocaleList$Companion r5 = androidx.compose.ui.text.intl.LocaleList.Companion
            androidx.compose.ui.text.intl.LocaleList r5 = r5.getCurrent()
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r5)
            if (r1 != 0) goto L_0x00e6
            int r1 = android.os.Build.VERSION.SDK_INT
            r5 = 24
            if (r1 < r5) goto L_0x00c6
            androidx.compose.ui.text.platform.extensions.LocaleListHelperMethods r1 = androidx.compose.ui.text.platform.extensions.LocaleListHelperMethods.INSTANCE
            androidx.compose.ui.text.intl.LocaleList r5 = r29.getLocaleList()
            r1.setTextLocales(r0, r5)
            goto L_0x00e6
        L_0x00c6:
            androidx.compose.ui.text.intl.LocaleList r1 = r29.getLocaleList()
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L_0x00d7
            androidx.compose.ui.text.intl.Locale$Companion r1 = androidx.compose.ui.text.intl.Locale.Companion
            androidx.compose.ui.text.intl.Locale r1 = r1.getCurrent()
            goto L_0x00df
        L_0x00d7:
            androidx.compose.ui.text.intl.LocaleList r1 = r29.getLocaleList()
            androidx.compose.ui.text.intl.Locale r1 = r1.get(r2)
        L_0x00df:
            java.util.Locale r1 = androidx.compose.ui.text.platform.extensions.LocaleExtensions_androidKt.toJavaLocale(r1)
            r0.setTextLocale(r1)
        L_0x00e6:
            long r5 = r29.m5005getLetterSpacingXSAIIZE()
            long r5 = androidx.compose.ui.unit.TextUnit.m5658getTypeUIouoOA(r5)
            long r7 = r3.m5691getEmUIouoOA()
            boolean r1 = androidx.compose.ui.unit.TextUnitType.m5687equalsimpl0(r5, r7)
            if (r1 == 0) goto L_0x0104
            long r5 = r29.m5005getLetterSpacingXSAIIZE()
            float r1 = androidx.compose.ui.unit.TextUnit.m5659getValueimpl(r5)
            r0.setLetterSpacing(r1)
            goto L_0x010b
        L_0x0104:
            long r7 = r3.m5692getSpUIouoOA()
            androidx.compose.ui.unit.TextUnitType.m5687equalsimpl0(r5, r7)
        L_0x010b:
            java.lang.String r1 = r29.getFontFeatureSettings()
            if (r1 == 0) goto L_0x0124
            java.lang.String r1 = r29.getFontFeatureSettings()
            java.lang.String r5 = ""
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r5)
            if (r1 != 0) goto L_0x0124
            java.lang.String r1 = r29.getFontFeatureSettings()
            r0.setFontFeatureSettings(r1)
        L_0x0124:
            androidx.compose.ui.text.style.TextGeometricTransform r1 = r29.getTextGeometricTransform()
            if (r1 == 0) goto L_0x015a
            androidx.compose.ui.text.style.TextGeometricTransform r1 = r29.getTextGeometricTransform()
            androidx.compose.ui.text.style.TextGeometricTransform$Companion r5 = androidx.compose.ui.text.style.TextGeometricTransform.Companion
            androidx.compose.ui.text.style.TextGeometricTransform r5 = r5.getNone$ui_text_release()
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r5)
            if (r1 != 0) goto L_0x015a
            float r1 = r28.getTextScaleX()
            androidx.compose.ui.text.style.TextGeometricTransform r5 = r29.getTextGeometricTransform()
            float r5 = r5.getScaleX()
            float r1 = r1 * r5
            r0.setTextScaleX(r1)
            float r1 = r28.getTextSkewX()
            androidx.compose.ui.text.style.TextGeometricTransform r5 = r29.getTextGeometricTransform()
            float r5 = r5.getSkewX()
            float r1 = r1 + r5
            r0.setTextSkewX(r1)
        L_0x015a:
            long r5 = r29.m5001getColor0d7_KjU()
            r0.m5252setColor8_81llA(r5)
            androidx.compose.ui.graphics.Brush r1 = r29.getBrush()
            androidx.compose.ui.geometry.Size$Companion r5 = androidx.compose.ui.geometry.Size.Companion
            long r5 = r5.m2753getUnspecifiedNHjbRc()
            float r7 = r29.getAlpha()
            r0.m5250setBrush12SF9DM(r1, r5, r7)
            androidx.compose.ui.graphics.Shadow r1 = r29.getShadow()
            r0.setShadow(r1)
            long r0 = r29.m5005getLetterSpacingXSAIIZE()
            long r0 = androidx.compose.ui.unit.TextUnit.m5658getTypeUIouoOA(r0)
            long r5 = r3.m5692getSpUIouoOA()
            boolean r0 = androidx.compose.ui.unit.TextUnitType.m5687equalsimpl0(r0, r5)
            r1 = 1
            if (r0 == 0) goto L_0x01a3
            long r5 = r29.m5005getLetterSpacingXSAIIZE()
            float r0 = androidx.compose.ui.unit.TextUnit.m5659getValueimpl(r5)
            r3 = 0
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 != 0) goto L_0x019b
            r0 = r1
            goto L_0x019c
        L_0x019b:
            r0 = r2
        L_0x019c:
            if (r0 != 0) goto L_0x01a3
            long r5 = r29.m5005getLetterSpacingXSAIIZE()
            goto L_0x01a9
        L_0x01a3:
            androidx.compose.ui.unit.TextUnit$Companion r0 = androidx.compose.ui.unit.TextUnit.Companion
            long r5 = r0.m5670getUnspecifiedXSAIIZE()
        L_0x01a9:
            r17 = r5
            long r5 = r29.m4999getBackground0d7_KjU()
            androidx.compose.ui.graphics.Color$Companion r0 = androidx.compose.ui.graphics.Color.Companion
            long r7 = r0.m2954getTransparent0d7_KjU()
            boolean r3 = androidx.compose.ui.graphics.Color.m2920equalsimpl0(r5, r7)
            if (r3 == 0) goto L_0x01c0
            long r5 = r0.m2955getUnspecified0d7_KjU()
            goto L_0x01c4
        L_0x01c0:
            long r5 = r29.m4999getBackground0d7_KjU()
        L_0x01c4:
            r22 = r5
            androidx.compose.ui.text.style.BaselineShift r0 = r29.m5000getBaselineShift5SSeXJ0()
            androidx.compose.ui.text.style.BaselineShift$Companion r3 = androidx.compose.ui.text.style.BaselineShift.Companion
            float r3 = r3.m5284getNoney9eOQZs()
            if (r0 != 0) goto L_0x01d3
            goto L_0x01db
        L_0x01d3:
            float r0 = r0.m5280unboximpl()
            boolean r2 = androidx.compose.ui.text.style.BaselineShift.m5277equalsimpl0(r0, r3)
        L_0x01db:
            r0 = 0
            if (r2 == 0) goto L_0x01e1
            r19 = r0
            goto L_0x01e7
        L_0x01e1:
            androidx.compose.ui.text.style.BaselineShift r2 = r29.m5000getBaselineShift5SSeXJ0()
            r19 = r2
        L_0x01e7:
            androidx.compose.ui.text.style.TextDecoration r2 = r29.getTextDecoration()
            androidx.compose.ui.text.style.TextDecoration r3 = r29.getTextDecoration()
            androidx.compose.ui.text.style.TextDecoration$Companion r4 = androidx.compose.ui.text.style.TextDecoration.Companion
            androidx.compose.ui.text.style.TextDecoration r4 = r4.getNone()
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r4)
            r1 = r1 ^ r3
            if (r1 == 0) goto L_0x01ff
            r24 = r2
            goto L_0x0201
        L_0x01ff:
            r24 = r0
        L_0x0201:
            androidx.compose.ui.text.SpanStyle r0 = new androidx.compose.ui.text.SpanStyle
            r7 = r0
            r8 = 0
            r10 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r20 = 0
            r21 = 0
            r25 = 0
            r26 = 9855(0x267f, float:1.381E-41)
            r27 = 0
            r7.<init>((long) r8, (long) r10, (androidx.compose.ui.text.font.FontWeight) r12, (androidx.compose.ui.text.font.FontStyle) r13, (androidx.compose.ui.text.font.FontSynthesis) r14, (androidx.compose.ui.text.font.FontFamily) r15, (java.lang.String) r16, (long) r17, (androidx.compose.ui.text.style.BaselineShift) r19, (androidx.compose.ui.text.style.TextGeometricTransform) r20, (androidx.compose.ui.text.intl.LocaleList) r21, (long) r22, (androidx.compose.ui.text.style.TextDecoration) r24, (androidx.compose.ui.graphics.Shadow) r25, (int) r26, (kotlin.jvm.internal.DefaultConstructorMarker) r27)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.platform.extensions.TextPaintExtensions_androidKt.applySpanStyle(androidx.compose.ui.text.platform.AndroidTextPaint, androidx.compose.ui.text.SpanStyle, kotlin.jvm.functions.Function4, androidx.compose.ui.unit.Density):androidx.compose.ui.text.SpanStyle");
    }

    public static final float correctBlurRadius(float f11) {
        if (f11 == 0.0f) {
            return Float.MIN_VALUE;
        }
        return f11;
    }

    public static final boolean hasFontAttributes(@NotNull SpanStyle spanStyle) {
        Intrinsics.checkNotNullParameter(spanStyle, "<this>");
        if (spanStyle.getFontFamily() == null && spanStyle.m5003getFontStyle4Lr2A7w() == null && spanStyle.getFontWeight() == null) {
            return false;
        }
        return true;
    }
}
