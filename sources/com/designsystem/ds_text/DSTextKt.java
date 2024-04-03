package com.designsystem.ds_text;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Typeface;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.Font;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontListFontFamily;
import androidx.compose.ui.text.font.ResourceFont;
import androidx.compose.ui.unit.Density;
import androidx.core.content.res.ResourcesCompat;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001aÓ\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u000b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u000b2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\u0014\b\u0002\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00010\u001f2\b\b\u0002\u0010!\u001a\u00020\"H\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b#\u0010$\u001a\u0018\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\"H\u0002\u001a\u001c\u0010*\u001a\u00020+*\u00020,2\u0006\u0010-\u001a\u00020.2\u0006\u0010)\u001a\u00020\"H\u0002\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006/"}, d2 = {"DSText", "", "text", "", "modifier", "Landroidx/compose/ui/Modifier;", "offset", "", "color", "Landroidx/compose/ui/graphics/Color;", "fontSize", "Landroidx/compose/ui/unit/TextUnit;", "fontStyle", "Landroidx/compose/ui/text/font/FontStyle;", "fontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "fontFamily", "Landroidx/compose/ui/text/font/FontFamily;", "letterSpacing", "textDecoration", "Landroidx/compose/ui/text/style/TextDecoration;", "textAlign", "Landroidx/compose/ui/text/style/TextAlign;", "lineHeight", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "softWrap", "", "maxLines", "", "onTextLayout", "Lkotlin/Function1;", "Landroidx/compose/ui/text/TextLayoutResult;", "style", "Landroidx/compose/ui/text/TextStyle;", "DSText-qBUjsXY", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;FJJLandroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontFamily;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/text/style/TextAlign;JIZILkotlin/jvm/functions/Function1;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/runtime/Composer;III)V", "setCustomResourceFont", "Landroidx/compose/ui/text/font/ResourceFont;", "fonts", "Landroidx/compose/ui/text/font/FontListFontFamily;", "textStyle", "fontMetrics", "Landroid/graphics/Paint$FontMetrics;", "Landroidx/compose/ui/unit/Density;", "context", "Landroid/content/Context;", "marshmallow_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class DSTextKt {
    /* JADX WARNING: Removed duplicated region for block: B:100:0x0126  */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x0129  */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x012f  */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x0143  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x014b  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x0151  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x0154  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x016e  */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x0173  */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x0190  */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x01a4  */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x01aa  */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x01be  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x01e2  */
    /* JADX WARNING: Removed duplicated region for block: B:164:0x0209  */
    /* JADX WARNING: Removed duplicated region for block: B:248:0x03c8  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:250:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00ad  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00cb  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0101  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0107  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x010b  */
    @androidx.compose.runtime.Composable
    /* renamed from: DSText-qBUjsXY  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m8635DSTextqBUjsXY(@org.jetbrains.annotations.NotNull java.lang.String r46, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r47, float r48, long r49, long r51, @org.jetbrains.annotations.Nullable androidx.compose.ui.text.font.FontStyle r53, @org.jetbrains.annotations.Nullable androidx.compose.ui.text.font.FontWeight r54, @org.jetbrains.annotations.Nullable androidx.compose.ui.text.font.FontFamily r55, long r56, @org.jetbrains.annotations.Nullable androidx.compose.ui.text.style.TextDecoration r58, @org.jetbrains.annotations.Nullable androidx.compose.ui.text.style.TextAlign r59, long r60, int r62, boolean r63, int r64, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.TextLayoutResult, kotlin.Unit> r65, @org.jetbrains.annotations.Nullable androidx.compose.ui.text.TextStyle r66, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r67, int r68, int r69, int r70) {
        /*
            r15 = r46
            r13 = r68
            r14 = r69
            r12 = r70
            java.lang.String r0 = "text"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            r0 = -888717192(0xffffffffcb074078, float:-8863864.0)
            r1 = r67
            androidx.compose.runtime.Composer r11 = r1.startRestartGroup(r0)
            r0 = r12 & 1
            if (r0 == 0) goto L_0x001d
            r0 = r13 | 6
            goto L_0x002d
        L_0x001d:
            r0 = r13 & 14
            if (r0 != 0) goto L_0x002c
            boolean r0 = r11.changed((java.lang.Object) r15)
            if (r0 == 0) goto L_0x0029
            r0 = 4
            goto L_0x002a
        L_0x0029:
            r0 = 2
        L_0x002a:
            r0 = r0 | r13
            goto L_0x002d
        L_0x002c:
            r0 = r13
        L_0x002d:
            r1 = r12 & 2
            if (r1 == 0) goto L_0x0034
            r0 = r0 | 48
            goto L_0x0047
        L_0x0034:
            r4 = r13 & 112(0x70, float:1.57E-43)
            if (r4 != 0) goto L_0x0047
            r4 = r47
            boolean r5 = r11.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x0043
            r5 = 32
            goto L_0x0045
        L_0x0043:
            r5 = 16
        L_0x0045:
            r0 = r0 | r5
            goto L_0x0049
        L_0x0047:
            r4 = r47
        L_0x0049:
            r5 = r12 & 4
            if (r5 == 0) goto L_0x0050
            r0 = r0 | 384(0x180, float:5.38E-43)
            goto L_0x0063
        L_0x0050:
            r6 = r13 & 896(0x380, float:1.256E-42)
            if (r6 != 0) goto L_0x0063
            r6 = r48
            boolean r7 = r11.changed((float) r6)
            if (r7 == 0) goto L_0x005f
            r7 = 256(0x100, float:3.59E-43)
            goto L_0x0061
        L_0x005f:
            r7 = 128(0x80, float:1.794E-43)
        L_0x0061:
            r0 = r0 | r7
            goto L_0x0065
        L_0x0063:
            r6 = r48
        L_0x0065:
            r7 = r13 & 7168(0x1c00, float:1.0045E-41)
            if (r7 != 0) goto L_0x007c
            r7 = r12 & 8
            r2 = r49
            if (r7 != 0) goto L_0x0078
            boolean r10 = r11.changed((long) r2)
            if (r10 == 0) goto L_0x0078
            r10 = 2048(0x800, float:2.87E-42)
            goto L_0x007a
        L_0x0078:
            r10 = 1024(0x400, float:1.435E-42)
        L_0x007a:
            r0 = r0 | r10
            goto L_0x007e
        L_0x007c:
            r2 = r49
        L_0x007e:
            r10 = 57344(0xe000, float:8.0356E-41)
            r16 = r13 & r10
            r17 = 16384(0x4000, float:2.2959E-41)
            r18 = 8192(0x2000, float:1.14794E-41)
            if (r16 != 0) goto L_0x009d
            r16 = r12 & 16
            r7 = r51
            if (r16 != 0) goto L_0x0098
            boolean r20 = r11.changed((long) r7)
            if (r20 == 0) goto L_0x0098
            r20 = r17
            goto L_0x009a
        L_0x0098:
            r20 = r18
        L_0x009a:
            r0 = r0 | r20
            goto L_0x009f
        L_0x009d:
            r7 = r51
        L_0x009f:
            r20 = r12 & 32
            r21 = 65536(0x10000, float:9.18355E-41)
            if (r20 == 0) goto L_0x00a7
            r0 = r0 | r21
        L_0x00a7:
            r22 = r12 & 64
            r23 = 3670016(0x380000, float:5.142788E-39)
            if (r22 == 0) goto L_0x00b4
            r24 = 1572864(0x180000, float:2.204052E-39)
            r0 = r0 | r24
            r9 = r54
            goto L_0x00c7
        L_0x00b4:
            r24 = r13 & r23
            r9 = r54
            if (r24 != 0) goto L_0x00c7
            boolean r25 = r11.changed((java.lang.Object) r9)
            if (r25 == 0) goto L_0x00c3
            r25 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00c5
        L_0x00c3:
            r25 = 524288(0x80000, float:7.34684E-40)
        L_0x00c5:
            r0 = r0 | r25
        L_0x00c7:
            r10 = r12 & 128(0x80, float:1.794E-43)
            if (r10 == 0) goto L_0x00d2
            r26 = 12582912(0xc00000, float:1.7632415E-38)
            r0 = r0 | r26
            r2 = r55
            goto L_0x00e6
        L_0x00d2:
            r26 = 29360128(0x1c00000, float:7.052966E-38)
            r26 = r13 & r26
            r2 = r55
            if (r26 != 0) goto L_0x00e6
            boolean r3 = r11.changed((java.lang.Object) r2)
            if (r3 == 0) goto L_0x00e3
            r3 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00e5
        L_0x00e3:
            r3 = 4194304(0x400000, float:5.877472E-39)
        L_0x00e5:
            r0 = r0 | r3
        L_0x00e6:
            r3 = 234881024(0xe000000, float:1.5777218E-30)
            r3 = r3 & r13
            if (r3 != 0) goto L_0x0101
            r3 = r12 & 256(0x100, float:3.59E-43)
            if (r3 != 0) goto L_0x00fa
            r2 = r56
            boolean r26 = r11.changed((long) r2)
            if (r26 == 0) goto L_0x00fc
            r26 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x00fe
        L_0x00fa:
            r2 = r56
        L_0x00fc:
            r26 = 33554432(0x2000000, float:9.403955E-38)
        L_0x00fe:
            r0 = r0 | r26
            goto L_0x0103
        L_0x0101:
            r2 = r56
        L_0x0103:
            r2 = r12 & 512(0x200, float:7.175E-43)
            if (r2 == 0) goto L_0x010b
            r3 = 805306368(0x30000000, float:4.656613E-10)
            r0 = r0 | r3
            goto L_0x0120
        L_0x010b:
            r3 = 1879048192(0x70000000, float:1.58456325E29)
            r3 = r3 & r13
            if (r3 != 0) goto L_0x0120
            r3 = r58
            boolean r26 = r11.changed((java.lang.Object) r3)
            if (r26 == 0) goto L_0x011b
            r26 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x011d
        L_0x011b:
            r26 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x011d:
            r0 = r0 | r26
            goto L_0x0122
        L_0x0120:
            r3 = r58
        L_0x0122:
            r3 = r12 & 1024(0x400, float:1.435E-42)
            if (r3 == 0) goto L_0x0129
            r26 = r14 | 2
            goto L_0x012b
        L_0x0129:
            r26 = r14
        L_0x012b:
            r27 = r14 & 112(0x70, float:1.57E-43)
            if (r27 != 0) goto L_0x0143
            r4 = r12 & 2048(0x800, float:2.87E-42)
            r6 = r60
            if (r4 != 0) goto L_0x013e
            boolean r4 = r11.changed((long) r6)
            if (r4 == 0) goto L_0x013e
            r19 = 32
            goto L_0x0140
        L_0x013e:
            r19 = 16
        L_0x0140:
            r26 = r26 | r19
            goto L_0x0145
        L_0x0143:
            r6 = r60
        L_0x0145:
            r4 = r26
            r8 = r12 & 4096(0x1000, float:5.74E-42)
            if (r8 == 0) goto L_0x014d
            r4 = r4 | 128(0x80, float:1.794E-43)
        L_0x014d:
            r6 = r12 & 8192(0x2000, float:1.14794E-41)
            if (r6 == 0) goto L_0x0154
            r4 = r4 | 3072(0xc00, float:4.305E-42)
            goto L_0x0168
        L_0x0154:
            r7 = r14 & 7168(0x1c00, float:1.0045E-41)
            if (r7 != 0) goto L_0x0168
            r7 = r63
            boolean r19 = r11.changed((boolean) r7)
            if (r19 == 0) goto L_0x0163
            r24 = 2048(0x800, float:2.87E-42)
            goto L_0x0165
        L_0x0163:
            r24 = 1024(0x400, float:1.435E-42)
        L_0x0165:
            r4 = r4 | r24
            goto L_0x016a
        L_0x0168:
            r7 = r63
        L_0x016a:
            r7 = r12 & 16384(0x4000, float:2.2959E-41)
            if (r7 == 0) goto L_0x0173
            r4 = r4 | 24576(0x6000, float:3.4438E-41)
            r9 = r64
            goto L_0x0187
        L_0x0173:
            r16 = 57344(0xe000, float:8.0356E-41)
            r19 = r14 & r16
            r9 = r64
            if (r19 != 0) goto L_0x0187
            boolean r16 = r11.changed((int) r9)
            if (r16 == 0) goto L_0x0183
            goto L_0x0185
        L_0x0183:
            r17 = r18
        L_0x0185:
            r4 = r4 | r17
        L_0x0187:
            r16 = 458752(0x70000, float:6.42848E-40)
            r17 = r14 & r16
            r18 = 32768(0x8000, float:4.5918E-41)
            if (r17 != 0) goto L_0x01a4
            r17 = r12 & r18
            r9 = r65
            if (r17 != 0) goto L_0x019f
            boolean r17 = r11.changed((java.lang.Object) r9)
            if (r17 == 0) goto L_0x019f
            r17 = 131072(0x20000, float:1.83671E-40)
            goto L_0x01a1
        L_0x019f:
            r17 = r21
        L_0x01a1:
            r4 = r4 | r17
            goto L_0x01a6
        L_0x01a4:
            r9 = r65
        L_0x01a6:
            r17 = r14 & r23
            if (r17 != 0) goto L_0x01be
            r17 = r12 & r21
            r9 = r66
            if (r17 != 0) goto L_0x01b9
            boolean r17 = r11.changed((java.lang.Object) r9)
            if (r17 == 0) goto L_0x01b9
            r17 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x01bb
        L_0x01b9:
            r17 = 524288(0x80000, float:7.34684E-40)
        L_0x01bb:
            r4 = r4 | r17
            goto L_0x01c0
        L_0x01be:
            r9 = r66
        L_0x01c0:
            int r9 = ~r12
            r9 = r9 & 5152(0x1420, float:7.22E-42)
            if (r9 != 0) goto L_0x0209
            r9 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r9 = r9 & r0
            r17 = 306783378(0x12492492, float:6.3469493E-28)
            r9 = r9 ^ r17
            if (r9 != 0) goto L_0x0209
            r9 = 2995931(0x2db6db, float:4.198194E-39)
            r9 = r9 & r4
            r17 = 599186(0x92492, float:8.39638E-40)
            r9 = r9 ^ r17
            if (r9 != 0) goto L_0x0209
            boolean r9 = r11.getSkipping()
            if (r9 != 0) goto L_0x01e2
            goto L_0x0209
        L_0x01e2:
            r11.skipToGroupEnd()
            r2 = r47
            r3 = r48
            r4 = r49
            r6 = r51
            r8 = r53
            r9 = r54
            r10 = r55
            r13 = r58
            r14 = r59
            r15 = r60
            r17 = r62
            r18 = r63
            r19 = r64
            r20 = r65
            r21 = r66
            r43 = r11
            r11 = r56
            goto L_0x03c1
        L_0x0209:
            r9 = r13 & 1
            if (r9 == 0) goto L_0x0269
            boolean r9 = r11.getDefaultsInvalid()
            if (r9 == 0) goto L_0x0214
            goto L_0x0269
        L_0x0214:
            r11.skipCurrentGroup()
            r1 = r12 & 8
            if (r1 == 0) goto L_0x021d
            r0 = r0 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x021d:
            r1 = r12 & 16
            if (r1 == 0) goto L_0x0225
            r1 = -57345(0xffffffffffff1fff, float:NaN)
            r0 = r0 & r1
        L_0x0225:
            r1 = r12 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x022d
            r1 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r0 = r0 & r1
        L_0x022d:
            r1 = r12 & 2048(0x800, float:2.87E-42)
            if (r1 == 0) goto L_0x0233
            r4 = r4 & -113(0xffffffffffffff8f, float:NaN)
        L_0x0233:
            if (r8 == 0) goto L_0x0237
            r4 = r4 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x0237:
            r1 = r12 & r18
            if (r1 == 0) goto L_0x023f
            r1 = -458753(0xfffffffffff8ffff, float:NaN)
            r4 = r4 & r1
        L_0x023f:
            r1 = r12 & r21
            if (r1 == 0) goto L_0x0247
            r1 = -3670017(0xffffffffffc7ffff, float:NaN)
            r4 = r4 & r1
        L_0x0247:
            r13 = r47
            r9 = r48
            r26 = r49
            r28 = r51
            r24 = r53
            r30 = r54
            r31 = r55
            r32 = r56
            r34 = r58
            r35 = r59
            r36 = r60
            r38 = r62
            r39 = r63
            r40 = r64
            r41 = r65
            r10 = r66
            goto L_0x0337
        L_0x0269:
            r11.startDefaults()
            if (r1 == 0) goto L_0x0271
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            goto L_0x0273
        L_0x0271:
            r1 = r47
        L_0x0273:
            if (r5 == 0) goto L_0x0277
            r5 = 0
            goto L_0x0279
        L_0x0277:
            r5 = r48
        L_0x0279:
            r9 = r12 & 8
            if (r9 == 0) goto L_0x0286
            androidx.compose.ui.graphics.Color$Companion r9 = androidx.compose.ui.graphics.Color.Companion
            long r26 = r9.m2955getUnspecified0d7_KjU()
            r0 = r0 & -7169(0xffffffffffffe3ff, float:NaN)
            goto L_0x0288
        L_0x0286:
            r26 = r49
        L_0x0288:
            r9 = r12 & 16
            if (r9 == 0) goto L_0x0297
            androidx.compose.ui.unit.TextUnit$Companion r9 = androidx.compose.ui.unit.TextUnit.Companion
            long r28 = r9.m5670getUnspecifiedXSAIIZE()
            r9 = -57345(0xffffffffffff1fff, float:NaN)
            r0 = r0 & r9
            goto L_0x0299
        L_0x0297:
            r28 = r51
        L_0x0299:
            if (r20 == 0) goto L_0x029d
            r9 = 0
            goto L_0x029f
        L_0x029d:
            r9 = r53
        L_0x029f:
            if (r22 == 0) goto L_0x02a4
            r17 = 0
            goto L_0x02a6
        L_0x02a4:
            r17 = r54
        L_0x02a6:
            if (r10 == 0) goto L_0x02aa
            r10 = 0
            goto L_0x02ac
        L_0x02aa:
            r10 = r55
        L_0x02ac:
            r13 = r12 & 256(0x100, float:3.59E-43)
            if (r13 == 0) goto L_0x02bb
            androidx.compose.ui.unit.TextUnit$Companion r13 = androidx.compose.ui.unit.TextUnit.Companion
            long r30 = r13.m5670getUnspecifiedXSAIIZE()
            r13 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r0 = r0 & r13
            goto L_0x02bd
        L_0x02bb:
            r30 = r56
        L_0x02bd:
            if (r2 == 0) goto L_0x02c1
            r2 = 0
            goto L_0x02c3
        L_0x02c1:
            r2 = r58
        L_0x02c3:
            if (r3 == 0) goto L_0x02c7
            r3 = 0
            goto L_0x02c9
        L_0x02c7:
            r3 = r59
        L_0x02c9:
            r13 = r12 & 2048(0x800, float:2.87E-42)
            if (r13 == 0) goto L_0x02d6
            androidx.compose.ui.unit.TextUnit$Companion r13 = androidx.compose.ui.unit.TextUnit.Companion
            long r32 = r13.m5670getUnspecifiedXSAIIZE()
            r4 = r4 & -113(0xffffffffffffff8f, float:NaN)
            goto L_0x02d8
        L_0x02d6:
            r32 = r60
        L_0x02d8:
            if (r8 == 0) goto L_0x02e3
            androidx.compose.ui.text.style.TextOverflow$Companion r8 = androidx.compose.ui.text.style.TextOverflow.Companion
            int r8 = r8.m5402getClipgIe3tQ8()
            r4 = r4 & -897(0xfffffffffffffc7f, float:NaN)
            goto L_0x02e5
        L_0x02e3:
            r8 = r62
        L_0x02e5:
            if (r6 == 0) goto L_0x02e9
            r6 = 1
            goto L_0x02eb
        L_0x02e9:
            r6 = r63
        L_0x02eb:
            if (r7 == 0) goto L_0x02f1
            r7 = 2147483647(0x7fffffff, float:NaN)
            goto L_0x02f3
        L_0x02f1:
            r7 = r64
        L_0x02f3:
            r13 = r12 & r18
            if (r13 == 0) goto L_0x02ff
            com.designsystem.ds_text.DSTextKt$DSText$1 r13 = com.designsystem.ds_text.DSTextKt$DSText$1.INSTANCE
            r18 = -458753(0xfffffffffff8ffff, float:NaN)
            r4 = r4 & r18
            goto L_0x0301
        L_0x02ff:
            r13 = r65
        L_0x0301:
            r18 = r12 & r21
            r47 = r0
            if (r18 == 0) goto L_0x0317
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.material.TextKt.getLocalTextStyle()
            java.lang.Object r0 = r11.consume(r0)
            androidx.compose.ui.text.TextStyle r0 = (androidx.compose.ui.text.TextStyle) r0
            r18 = -3670017(0xffffffffffc7ffff, float:NaN)
            r4 = r4 & r18
            goto L_0x0319
        L_0x0317:
            r0 = r66
        L_0x0319:
            r11.endDefaults()
            r34 = r2
            r35 = r3
            r39 = r6
            r40 = r7
            r38 = r8
            r24 = r9
            r41 = r13
            r36 = r32
            r13 = r1
            r9 = r5
            r32 = r30
            r31 = r10
            r30 = r17
            r10 = r0
            r0 = r47
        L_0x0337:
            com.designsystem.ds_text.DSTextKt$DSText$2 r1 = new com.designsystem.ds_text.DSTextKt$DSText$2
            r1.<init>(r10, r9)
            r2 = 0
            r3 = 1
            androidx.compose.ui.Modifier r1 = androidx.compose.ui.ComposedModifierKt.composed$default(r13, r2, r1, r3, r2)
            r2 = r0 & 14
            r3 = 1073774592(0x40008000, float:2.0078125)
            r2 = r2 | r3
            int r0 = r0 >> 3
            r3 = r0 & 896(0x380, float:1.256E-42)
            r2 = r2 | r3
            r3 = r0 & 7168(0x1c00, float:1.0045E-41)
            r2 = r2 | r3
            r3 = r0 & r16
            r2 = r2 | r3
            r3 = r0 & r23
            r2 = r2 | r3
            r3 = 29360128(0x1c00000, float:7.052966E-38)
            r3 = r3 & r0
            r2 = r2 | r3
            r3 = 234881024(0xe000000, float:1.5777218E-30)
            r0 = r0 & r3
            r21 = r2 | r0
            int r0 = r4 >> 3
            r2 = r0 & 14
            r2 = r2 | 64
            r3 = r0 & 896(0x380, float:1.256E-42)
            r2 = r2 | r3
            r3 = r0 & 7168(0x1c00, float:1.0045E-41)
            r2 = r2 | r3
            r3 = 57344(0xe000, float:8.0356E-41)
            r3 = r3 & r0
            r2 = r2 | r3
            r0 = r0 & r16
            r22 = r2 | r0
            r23 = 0
            r0 = r46
            r2 = r26
            r4 = r28
            r6 = r24
            r7 = r30
            r8 = r31
            r42 = r9
            r25 = r10
            r9 = r32
            r43 = r11
            r11 = r34
            r12 = r35
            r44 = r13
            r13 = r36
            r15 = r38
            r16 = r39
            r17 = r40
            r18 = r41
            r19 = r25
            r20 = r43
            androidx.compose.material.TextKt.m1461TextfLXpl1I(r0, r1, r2, r4, r6, r7, r8, r9, r11, r12, r13, r15, r16, r17, r18, r19, r20, r21, r22, r23)
            r8 = r24
            r21 = r25
            r4 = r26
            r6 = r28
            r9 = r30
            r10 = r31
            r11 = r32
            r13 = r34
            r14 = r35
            r15 = r36
            r17 = r38
            r18 = r39
            r19 = r40
            r20 = r41
            r3 = r42
            r2 = r44
        L_0x03c1:
            androidx.compose.runtime.ScopeUpdateScope r1 = r43.endRestartGroup()
            if (r1 != 0) goto L_0x03c8
            goto L_0x03e0
        L_0x03c8:
            com.designsystem.ds_text.DSTextKt$DSText$3 r0 = new com.designsystem.ds_text.DSTextKt$DSText$3
            r47 = r0
            r45 = r1
            r1 = r46
            r22 = r68
            r23 = r69
            r24 = r70
            r0.<init>(r1, r2, r3, r4, r6, r8, r9, r10, r11, r13, r14, r15, r17, r18, r19, r20, r21, r22, r23, r24)
            r1 = r47
            r0 = r45
            r0.updateScope(r1)
        L_0x03e0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.designsystem.ds_text.DSTextKt.m8635DSTextqBUjsXY(java.lang.String, androidx.compose.ui.Modifier, float, long, long, androidx.compose.ui.text.font.FontStyle, androidx.compose.ui.text.font.FontWeight, androidx.compose.ui.text.font.FontFamily, long, androidx.compose.ui.text.style.TextDecoration, androidx.compose.ui.text.style.TextAlign, long, int, boolean, int, kotlin.jvm.functions.Function1, androidx.compose.ui.text.TextStyle, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* access modifiers changed from: private */
    public static final Paint.FontMetrics fontMetrics(Density density, Context context, TextStyle textStyle) {
        ResourceFont resourceFont;
        Object obj;
        FontFamily fontFamily = textStyle.getFontFamily();
        if (fontFamily != null) {
            FontListFontFamily fontListFontFamily = (FontListFontFamily) fontFamily;
            Iterator it = fontListFontFamily.getFonts().iterator();
            while (true) {
                resourceFont = null;
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (Intrinsics.areEqual((Object) ((Font) obj).getWeight(), (Object) textStyle.getFontWeight())) {
                    break;
                }
            }
            if (obj instanceof ResourceFont) {
                resourceFont = (ResourceFont) obj;
            }
            if (resourceFont == null) {
                resourceFont = setCustomResourceFont(fontListFontFamily, textStyle);
            }
            Typeface font = ResourcesCompat.getFont(context, resourceFont.getResId());
            Paint paint = new Paint();
            paint.setTypeface(font);
            paint.setTextSize(density.m5446toPxR2X_6o(textStyle.m5057getFontSizeXSAIIZE()));
            Paint.FontMetrics fontMetrics = paint.getFontMetrics();
            Intrinsics.checkNotNullExpressionValue(fontMetrics, "paint.fontMetrics");
            return fontMetrics;
        }
        throw new NullPointerException("null cannot be cast to non-null type androidx.compose.ui.text.font.FontListFontFamily");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: androidx.compose.ui.text.font.ResourceFont} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: androidx.compose.ui.text.font.ResourceFont} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: androidx.compose.ui.text.font.Font} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: androidx.compose.ui.text.font.ResourceFont} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final androidx.compose.ui.text.font.ResourceFont setCustomResourceFont(androidx.compose.ui.text.font.FontListFontFamily r8, androidx.compose.ui.text.TextStyle r9) {
        /*
            androidx.compose.ui.text.font.FontWeight r0 = r9.getFontWeight()
            r1 = 0
            if (r0 != 0) goto L_0x0009
            r0 = r1
            goto L_0x0011
        L_0x0009:
            int r0 = r0.getWeight()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
        L_0x0011:
            if (r0 != 0) goto L_0x0026
            java.util.List r0 = r8.getFonts()
            java.lang.Object r0 = kotlin.collections.CollectionsKt___CollectionsKt.first(r0)
            androidx.compose.ui.text.font.Font r0 = (androidx.compose.ui.text.font.Font) r0
            androidx.compose.ui.text.font.FontWeight r0 = r0.getWeight()
            int r0 = r0.getWeight()
            goto L_0x002a
        L_0x0026:
            int r0 = r0.intValue()
        L_0x002a:
            java.util.List r2 = r8.getFonts()
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.Iterator r2 = r2.iterator()
            r3 = r1
        L_0x0035:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L_0x0068
            java.lang.Object r4 = r2.next()
            androidx.compose.ui.text.font.Font r4 = (androidx.compose.ui.text.font.Font) r4
            androidx.compose.ui.text.font.FontWeight r5 = r4.getWeight()
            int r5 = r5.getWeight()
            if (r5 > r0) goto L_0x0035
            if (r3 == 0) goto L_0x005b
            androidx.compose.ui.text.font.FontWeight r5 = r4.getWeight()
            int r5 = r5.getWeight()
            int r6 = r3.intValue()
            if (r5 <= r6) goto L_0x0035
        L_0x005b:
            androidx.compose.ui.text.font.FontWeight r3 = r4.getWeight()
            int r3 = r3.getWeight()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            goto L_0x0035
        L_0x0068:
            java.util.List r8 = r8.getFonts()
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.Iterator r8 = r8.iterator()
        L_0x0072:
            boolean r0 = r8.hasNext()
            if (r0 == 0) goto L_0x0096
            java.lang.Object r0 = r8.next()
            r2 = r0
            androidx.compose.ui.text.font.Font r2 = (androidx.compose.ui.text.font.Font) r2
            androidx.compose.ui.text.font.FontWeight r2 = r2.getWeight()
            int r2 = r2.getWeight()
            if (r3 != 0) goto L_0x008a
            goto L_0x0092
        L_0x008a:
            int r4 = r3.intValue()
            if (r2 != r4) goto L_0x0092
            r2 = 1
            goto L_0x0093
        L_0x0092:
            r2 = 0
        L_0x0093:
            if (r2 == 0) goto L_0x0072
            r1 = r0
        L_0x0096:
            if (r1 == 0) goto L_0x00ab
            r2 = r1
            androidx.compose.ui.text.font.ResourceFont r2 = (androidx.compose.ui.text.font.ResourceFont) r2
            r3 = 0
            androidx.compose.ui.text.font.FontWeight r4 = r9.getFontWeight()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            r5 = 0
            r6 = 5
            r7 = 0
            androidx.compose.ui.text.font.ResourceFont r8 = androidx.compose.ui.text.font.ResourceFont.m5165copyRetOiIg$default(r2, r3, r4, r5, r6, r7)
            return r8
        L_0x00ab:
            java.lang.NullPointerException r8 = new java.lang.NullPointerException
            java.lang.String r9 = "null cannot be cast to non-null type androidx.compose.ui.text.font.ResourceFont"
            r8.<init>(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.designsystem.ds_text.DSTextKt.setCustomResourceFont(androidx.compose.ui.text.font.FontListFontFamily, androidx.compose.ui.text.TextStyle):androidx.compose.ui.text.font.ResourceFont");
    }
}
