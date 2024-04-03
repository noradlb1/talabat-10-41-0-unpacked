package com.designsystem.ds_image;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a{\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\fH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0014\u0010\u0015\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u0016"}, d2 = {"RatioImageCornerRadius", "", "DSRatioImage", "", "imageUrl", "", "imageRatio", "Lcom/designsystem/ds_image/DSImageRatio;", "modifier", "Landroidx/compose/ui/Modifier;", "placeholderImageUrl", "width", "Landroidx/compose/ui/unit/Dp;", "height", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "cornerRadius", "borderColor", "Landroidx/compose/ui/graphics/Color;", "borderWidth", "DSRatioImage-DS-yytA", "(Ljava/lang/String;Lcom/designsystem/ds_image/DSImageRatio;Landroidx/compose/ui/Modifier;Ljava/lang/String;FFLandroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/Color;Landroidx/compose/ui/unit/Dp;Landroidx/compose/runtime/Composer;II)V", "marshmallow_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class DSRatioImageKt {
    private static final int RatioImageCornerRadius = 0;

    /* JADX WARNING: Removed duplicated region for block: B:100:0x011f  */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x0147  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x0155  */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x0242  */
    /* JADX WARNING: Removed duplicated region for block: B:161:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00b8  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00d4  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00da  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00de  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x00f8  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x00ff  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0118  */
    @androidx.compose.runtime.Composable
    /* renamed from: DSRatioImage-DS-yytA  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m8361DSRatioImageDSyytA(@org.jetbrains.annotations.NotNull java.lang.String r24, @org.jetbrains.annotations.NotNull com.designsystem.ds_image.DSImageRatio r25, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r26, @org.jetbrains.annotations.Nullable java.lang.String r27, float r28, float r29, @org.jetbrains.annotations.Nullable androidx.compose.ui.layout.ContentScale r30, float r31, @org.jetbrains.annotations.Nullable androidx.compose.ui.graphics.Color r32, @org.jetbrains.annotations.Nullable androidx.compose.ui.unit.Dp r33, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r34, int r35, int r36) {
        /*
            r12 = r24
            r13 = r25
            r14 = r35
            r15 = r36
            java.lang.String r0 = "imageUrl"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.lang.String r0 = "imageRatio"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            r0 = 1004535965(0x3be0009d, float:0.0068360106)
            r1 = r34
            androidx.compose.runtime.Composer r11 = r1.startRestartGroup(r0)
            r0 = r15 & 1
            if (r0 == 0) goto L_0x0022
            r0 = r14 | 6
            goto L_0x0032
        L_0x0022:
            r0 = r14 & 14
            if (r0 != 0) goto L_0x0031
            boolean r0 = r11.changed((java.lang.Object) r12)
            if (r0 == 0) goto L_0x002e
            r0 = 4
            goto L_0x002f
        L_0x002e:
            r0 = 2
        L_0x002f:
            r0 = r0 | r14
            goto L_0x0032
        L_0x0031:
            r0 = r14
        L_0x0032:
            r1 = r15 & 2
            if (r1 == 0) goto L_0x0039
            r0 = r0 | 48
            goto L_0x0049
        L_0x0039:
            r1 = r14 & 112(0x70, float:1.57E-43)
            if (r1 != 0) goto L_0x0049
            boolean r1 = r11.changed((java.lang.Object) r13)
            if (r1 == 0) goto L_0x0046
            r1 = 32
            goto L_0x0048
        L_0x0046:
            r1 = 16
        L_0x0048:
            r0 = r0 | r1
        L_0x0049:
            r1 = r15 & 4
            if (r1 == 0) goto L_0x0050
            r0 = r0 | 384(0x180, float:5.38E-43)
            goto L_0x0063
        L_0x0050:
            r2 = r14 & 896(0x380, float:1.256E-42)
            if (r2 != 0) goto L_0x0063
            r2 = r26
            boolean r3 = r11.changed((java.lang.Object) r2)
            if (r3 == 0) goto L_0x005f
            r3 = 256(0x100, float:3.59E-43)
            goto L_0x0061
        L_0x005f:
            r3 = 128(0x80, float:1.794E-43)
        L_0x0061:
            r0 = r0 | r3
            goto L_0x0065
        L_0x0063:
            r2 = r26
        L_0x0065:
            r3 = r15 & 8
            if (r3 == 0) goto L_0x006c
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            goto L_0x007f
        L_0x006c:
            r4 = r14 & 7168(0x1c00, float:1.0045E-41)
            if (r4 != 0) goto L_0x007f
            r4 = r27
            boolean r5 = r11.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x007b
            r5 = 2048(0x800, float:2.87E-42)
            goto L_0x007d
        L_0x007b:
            r5 = 1024(0x400, float:1.435E-42)
        L_0x007d:
            r0 = r0 | r5
            goto L_0x0081
        L_0x007f:
            r4 = r27
        L_0x0081:
            r5 = 57344(0xe000, float:8.0356E-41)
            r5 = r5 & r14
            if (r5 != 0) goto L_0x009c
            r5 = r15 & 16
            if (r5 != 0) goto L_0x0096
            r5 = r28
            boolean r6 = r11.changed((float) r5)
            if (r6 == 0) goto L_0x0098
            r6 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009a
        L_0x0096:
            r5 = r28
        L_0x0098:
            r6 = 8192(0x2000, float:1.14794E-41)
        L_0x009a:
            r0 = r0 | r6
            goto L_0x009e
        L_0x009c:
            r5 = r28
        L_0x009e:
            r6 = 458752(0x70000, float:6.42848E-40)
            r6 = r6 & r14
            if (r6 != 0) goto L_0x00b8
            r6 = r15 & 32
            if (r6 != 0) goto L_0x00b2
            r6 = r29
            boolean r7 = r11.changed((float) r6)
            if (r7 == 0) goto L_0x00b4
            r7 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b6
        L_0x00b2:
            r6 = r29
        L_0x00b4:
            r7 = 65536(0x10000, float:9.18355E-41)
        L_0x00b6:
            r0 = r0 | r7
            goto L_0x00ba
        L_0x00b8:
            r6 = r29
        L_0x00ba:
            r7 = 3670016(0x380000, float:5.142788E-39)
            r7 = r7 & r14
            if (r7 != 0) goto L_0x00d4
            r7 = r15 & 64
            if (r7 != 0) goto L_0x00ce
            r7 = r30
            boolean r8 = r11.changed((java.lang.Object) r7)
            if (r8 == 0) goto L_0x00d0
            r8 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d2
        L_0x00ce:
            r7 = r30
        L_0x00d0:
            r8 = 524288(0x80000, float:7.34684E-40)
        L_0x00d2:
            r0 = r0 | r8
            goto L_0x00d6
        L_0x00d4:
            r7 = r30
        L_0x00d6:
            r8 = r15 & 128(0x80, float:1.794E-43)
            if (r8 == 0) goto L_0x00de
            r9 = 12582912(0xc00000, float:1.7632415E-38)
            r0 = r0 | r9
            goto L_0x00f2
        L_0x00de:
            r9 = 29360128(0x1c00000, float:7.052966E-38)
            r9 = r9 & r14
            if (r9 != 0) goto L_0x00f2
            r9 = r31
            boolean r10 = r11.changed((float) r9)
            if (r10 == 0) goto L_0x00ee
            r10 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00f0
        L_0x00ee:
            r10 = 4194304(0x400000, float:5.877472E-39)
        L_0x00f0:
            r0 = r0 | r10
            goto L_0x00f4
        L_0x00f2:
            r9 = r31
        L_0x00f4:
            r10 = r15 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x00ff
            r16 = 100663296(0x6000000, float:2.4074124E-35)
            r0 = r0 | r16
            r2 = r32
            goto L_0x0114
        L_0x00ff:
            r16 = 234881024(0xe000000, float:1.5777218E-30)
            r16 = r14 & r16
            r2 = r32
            if (r16 != 0) goto L_0x0114
            boolean r16 = r11.changed((java.lang.Object) r2)
            if (r16 == 0) goto L_0x0110
            r16 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0112
        L_0x0110:
            r16 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0112:
            r0 = r0 | r16
        L_0x0114:
            r2 = r15 & 512(0x200, float:7.175E-43)
            if (r2 == 0) goto L_0x011f
            r16 = 805306368(0x30000000, float:4.656613E-10)
            r0 = r0 | r16
            r4 = r33
            goto L_0x0134
        L_0x011f:
            r16 = 1879048192(0x70000000, float:1.58456325E29)
            r16 = r14 & r16
            r4 = r33
            if (r16 != 0) goto L_0x0134
            boolean r16 = r11.changed((java.lang.Object) r4)
            if (r16 == 0) goto L_0x0130
            r16 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0132
        L_0x0130:
            r16 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0132:
            r0 = r0 | r16
        L_0x0134:
            r16 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r16 = r0 & r16
            r17 = 306783378(0x12492492, float:6.3469493E-28)
            r16 = r16 ^ r17
            if (r16 != 0) goto L_0x0155
            boolean r16 = r11.getSkipping()
            if (r16 != 0) goto L_0x0147
            goto L_0x0155
        L_0x0147:
            r11.skipToGroupEnd()
            r3 = r26
            r10 = r4
            r8 = r9
            r13 = r11
            r4 = r27
            r9 = r32
            goto L_0x023b
        L_0x0155:
            r16 = r14 & 1
            r17 = -3670017(0xffffffffffc7ffff, float:NaN)
            r18 = -458753(0xfffffffffff8ffff, float:NaN)
            r19 = -57345(0xffffffffffff1fff, float:NaN)
            if (r16 == 0) goto L_0x018f
            boolean r16 = r11.getDefaultsInvalid()
            if (r16 == 0) goto L_0x0169
            goto L_0x018f
        L_0x0169:
            r11.skipCurrentGroup()
            r1 = r15 & 16
            if (r1 == 0) goto L_0x0172
            r0 = r0 & r19
        L_0x0172:
            r1 = r15 & 32
            if (r1 == 0) goto L_0x0178
            r0 = r0 & r18
        L_0x0178:
            r1 = r15 & 64
            if (r1 == 0) goto L_0x017e
            r0 = r0 & r17
        L_0x017e:
            r16 = r26
            r17 = r27
            r20 = r32
            r8 = r0
            r21 = r4
            r10 = r5
            r18 = r7
            r19 = r9
        L_0x018c:
            r9 = r6
            goto L_0x01ed
        L_0x018f:
            r11.startDefaults()
            if (r1 == 0) goto L_0x0197
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            goto L_0x0199
        L_0x0197:
            r1 = r26
        L_0x0199:
            r16 = 0
            if (r3 == 0) goto L_0x01a0
            r3 = r16
            goto L_0x01a2
        L_0x01a0:
            r3 = r27
        L_0x01a2:
            r20 = r15 & 16
            if (r20 == 0) goto L_0x01ae
            androidx.compose.ui.unit.Dp$Companion r5 = androidx.compose.ui.unit.Dp.Companion
            float r5 = r5.m5498getUnspecifiedD9Ej5fM()
            r0 = r0 & r19
        L_0x01ae:
            r19 = r15 & 32
            if (r19 == 0) goto L_0x01ba
            androidx.compose.ui.unit.Dp$Companion r6 = androidx.compose.ui.unit.Dp.Companion
            float r6 = r6.m5498getUnspecifiedD9Ej5fM()
            r0 = r0 & r18
        L_0x01ba:
            r18 = r15 & 64
            if (r18 == 0) goto L_0x01c6
            androidx.compose.ui.layout.ContentScale$Companion r7 = androidx.compose.ui.layout.ContentScale.Companion
            androidx.compose.ui.layout.ContentScale r7 = r7.getCrop()
            r0 = r0 & r17
        L_0x01c6:
            if (r8 == 0) goto L_0x01cf
            r8 = 0
            float r8 = (float) r8
            float r8 = androidx.compose.ui.unit.Dp.m5478constructorimpl(r8)
            goto L_0x01d0
        L_0x01cf:
            r8 = r9
        L_0x01d0:
            if (r10 == 0) goto L_0x01d5
            r9 = r16
            goto L_0x01d7
        L_0x01d5:
            r9 = r32
        L_0x01d7:
            if (r2 == 0) goto L_0x01db
            r4 = r16
        L_0x01db:
            r11.endDefaults()
            r16 = r1
            r17 = r3
            r21 = r4
            r10 = r5
            r18 = r7
            r19 = r8
            r20 = r9
            r8 = r0
            goto L_0x018c
        L_0x01ed:
            androidx.compose.ui.unit.Dp$Companion r0 = androidx.compose.ui.unit.Dp.Companion
            float r1 = r0.m5498getUnspecifiedD9Ej5fM()
            boolean r1 = androidx.compose.ui.unit.Dp.m5483equalsimpl0(r10, r1)
            if (r1 != 0) goto L_0x0201
            float r0 = r0.m5498getUnspecifiedD9Ej5fM()
            boolean r0 = androidx.compose.ui.unit.Dp.m5483equalsimpl0(r9, r0)
        L_0x0201:
            com.designsystem.ds_image.DSRatioImageKt$DSRatioImage$3 r7 = new com.designsystem.ds_image.DSRatioImageKt$DSRatioImage$3
            r0 = r7
            r1 = r16
            r2 = r10
            r3 = r9
            r4 = r25
            r5 = r19
            r6 = r20
            r12 = r7
            r7 = r21
            r22 = r9
            r9 = r24
            r23 = r10
            r10 = r18
            r13 = r11
            r11 = r17
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            r0 = -819893659(0xffffffffcf216a65, float:-2.70810445E9)
            r1 = 1
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r13, r0, r1, r12)
            r1 = 6
            com.designsystem.ds_theme.DSThemeKt.DSTheme(r0, r13, r1)
            r3 = r16
            r4 = r17
            r7 = r18
            r8 = r19
            r9 = r20
            r10 = r21
            r6 = r22
            r5 = r23
        L_0x023b:
            androidx.compose.runtime.ScopeUpdateScope r13 = r13.endRestartGroup()
            if (r13 != 0) goto L_0x0242
            goto L_0x0254
        L_0x0242:
            com.designsystem.ds_image.DSRatioImageKt$DSRatioImage$4 r12 = new com.designsystem.ds_image.DSRatioImageKt$DSRatioImage$4
            r0 = r12
            r1 = r24
            r2 = r25
            r11 = r35
            r14 = r12
            r12 = r36
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            r13.updateScope(r14)
        L_0x0254:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.designsystem.ds_image.DSRatioImageKt.m8361DSRatioImageDSyytA(java.lang.String, com.designsystem.ds_image.DSImageRatio, androidx.compose.ui.Modifier, java.lang.String, float, float, androidx.compose.ui.layout.ContentScale, float, androidx.compose.ui.graphics.Color, androidx.compose.ui.unit.Dp, androidx.compose.runtime.Composer, int, int):void");
    }
}
