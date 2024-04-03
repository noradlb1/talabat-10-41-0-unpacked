package com.designsystem.ds_chip;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aQ\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00010\fH\u0007¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"DSSingleSelectionChip", "", "text", "", "modifier", "Landroidx/compose/ui/Modifier;", "leadingIcon", "", "trailingIcon", "isSelected", "", "onTap", "Lkotlin/Function0;", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;Ljava/lang/Integer;Ljava/lang/Integer;ZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "marshmallow_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class DSSingleSelectionChipKt {
    /* JADX WARNING: Removed duplicated region for block: B:100:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00b5  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x00d1  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0139  */
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void DSSingleSelectionChip(@org.jetbrains.annotations.NotNull java.lang.String r16, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r17, @org.jetbrains.annotations.Nullable @androidx.annotation.DrawableRes java.lang.Integer r18, @org.jetbrains.annotations.Nullable @androidx.annotation.DrawableRes java.lang.Integer r19, boolean r20, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function0<kotlin.Unit> r21, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r22, int r23, int r24) {
        /*
            r8 = r16
            r9 = r23
            java.lang.String r0 = "text"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            r0 = -794647746(0xffffffffd0a2a33e, float:-2.18288579E10)
            r1 = r22
            androidx.compose.runtime.Composer r10 = r1.startRestartGroup(r0)
            r0 = r24 & 1
            if (r0 == 0) goto L_0x0019
            r0 = r9 | 6
            goto L_0x0029
        L_0x0019:
            r0 = r9 & 14
            if (r0 != 0) goto L_0x0028
            boolean r0 = r10.changed((java.lang.Object) r8)
            if (r0 == 0) goto L_0x0025
            r0 = 4
            goto L_0x0026
        L_0x0025:
            r0 = 2
        L_0x0026:
            r0 = r0 | r9
            goto L_0x0029
        L_0x0028:
            r0 = r9
        L_0x0029:
            r1 = r24 & 2
            if (r1 == 0) goto L_0x0030
            r0 = r0 | 48
            goto L_0x0043
        L_0x0030:
            r2 = r9 & 112(0x70, float:1.57E-43)
            if (r2 != 0) goto L_0x0043
            r2 = r17
            boolean r3 = r10.changed((java.lang.Object) r2)
            if (r3 == 0) goto L_0x003f
            r3 = 32
            goto L_0x0041
        L_0x003f:
            r3 = 16
        L_0x0041:
            r0 = r0 | r3
            goto L_0x0045
        L_0x0043:
            r2 = r17
        L_0x0045:
            r3 = r24 & 4
            if (r3 == 0) goto L_0x004c
            r0 = r0 | 384(0x180, float:5.38E-43)
            goto L_0x005f
        L_0x004c:
            r4 = r9 & 896(0x380, float:1.256E-42)
            if (r4 != 0) goto L_0x005f
            r4 = r18
            boolean r5 = r10.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x005b
            r5 = 256(0x100, float:3.59E-43)
            goto L_0x005d
        L_0x005b:
            r5 = 128(0x80, float:1.794E-43)
        L_0x005d:
            r0 = r0 | r5
            goto L_0x0061
        L_0x005f:
            r4 = r18
        L_0x0061:
            r5 = r24 & 8
            if (r5 == 0) goto L_0x0068
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            goto L_0x007b
        L_0x0068:
            r6 = r9 & 7168(0x1c00, float:1.0045E-41)
            if (r6 != 0) goto L_0x007b
            r6 = r19
            boolean r7 = r10.changed((java.lang.Object) r6)
            if (r7 == 0) goto L_0x0077
            r7 = 2048(0x800, float:2.87E-42)
            goto L_0x0079
        L_0x0077:
            r7 = 1024(0x400, float:1.435E-42)
        L_0x0079:
            r0 = r0 | r7
            goto L_0x007d
        L_0x007b:
            r6 = r19
        L_0x007d:
            r7 = r24 & 16
            if (r7 == 0) goto L_0x0084
            r0 = r0 | 24576(0x6000, float:3.4438E-41)
            goto L_0x0099
        L_0x0084:
            r11 = 57344(0xe000, float:8.0356E-41)
            r11 = r11 & r9
            if (r11 != 0) goto L_0x0099
            r11 = r20
            boolean r12 = r10.changed((boolean) r11)
            if (r12 == 0) goto L_0x0095
            r12 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0097
        L_0x0095:
            r12 = 8192(0x2000, float:1.14794E-41)
        L_0x0097:
            r0 = r0 | r12
            goto L_0x009b
        L_0x0099:
            r11 = r20
        L_0x009b:
            r12 = 458752(0x70000, float:6.42848E-40)
            r12 = r12 & r9
            if (r12 != 0) goto L_0x00b5
            r12 = r24 & 32
            if (r12 != 0) goto L_0x00af
            r12 = r21
            boolean r13 = r10.changed((java.lang.Object) r12)
            if (r13 == 0) goto L_0x00b1
            r13 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b3
        L_0x00af:
            r12 = r21
        L_0x00b1:
            r13 = 65536(0x10000, float:9.18355E-41)
        L_0x00b3:
            r0 = r0 | r13
            goto L_0x00b7
        L_0x00b5:
            r12 = r21
        L_0x00b7:
            r13 = 374491(0x5b6db, float:5.24774E-40)
            r13 = r13 & r0
            r14 = 74898(0x12492, float:1.04954E-40)
            r13 = r13 ^ r14
            if (r13 != 0) goto L_0x00d1
            boolean r13 = r10.getSkipping()
            if (r13 != 0) goto L_0x00c8
            goto L_0x00d1
        L_0x00c8:
            r10.skipToGroupEnd()
            r3 = r4
            r4 = r6
            r5 = r11
            r6 = r12
            goto L_0x0132
        L_0x00d1:
            r13 = r9 & 1
            r14 = -458753(0xfffffffffff8ffff, float:NaN)
            if (r13 == 0) goto L_0x00ee
            boolean r13 = r10.getDefaultsInvalid()
            if (r13 == 0) goto L_0x00df
            goto L_0x00ee
        L_0x00df:
            r10.skipCurrentGroup()
            r1 = r24 & 32
            if (r1 == 0) goto L_0x00e7
            r0 = r0 & r14
        L_0x00e7:
            r13 = r6
            r14 = r11
            r15 = r12
            r11 = r2
        L_0x00eb:
            r12 = r4
            r4 = r0
            goto L_0x0113
        L_0x00ee:
            r10.startDefaults()
            if (r1 == 0) goto L_0x00f6
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            goto L_0x00f7
        L_0x00f6:
            r1 = r2
        L_0x00f7:
            r2 = 0
            if (r3 == 0) goto L_0x00fb
            r4 = r2
        L_0x00fb:
            if (r5 == 0) goto L_0x00fe
            goto L_0x00ff
        L_0x00fe:
            r2 = r6
        L_0x00ff:
            if (r7 == 0) goto L_0x0103
            r3 = 0
            r11 = r3
        L_0x0103:
            r3 = r24 & 32
            if (r3 == 0) goto L_0x010b
            com.designsystem.ds_chip.DSSingleSelectionChipKt$DSSingleSelectionChip$1 r3 = com.designsystem.ds_chip.DSSingleSelectionChipKt$DSSingleSelectionChip$1.INSTANCE
            r0 = r0 & r14
            r12 = r3
        L_0x010b:
            r10.endDefaults()
            r13 = r2
            r14 = r11
            r15 = r12
            r11 = r1
            goto L_0x00eb
        L_0x0113:
            com.designsystem.ds_chip.DSSingleSelectionChipKt$DSSingleSelectionChip$2 r7 = new com.designsystem.ds_chip.DSSingleSelectionChipKt$DSSingleSelectionChip$2
            r0 = r7
            r1 = r11
            r2 = r14
            r3 = r15
            r5 = r12
            r6 = r16
            r8 = r7
            r7 = r13
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            r0 = -819896030(0xffffffffcf216122, float:-2.70749747E9)
            r1 = 1
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r10, r0, r1, r8)
            r1 = 6
            com.designsystem.ds_theme.DSThemeKt.DSTheme(r0, r10, r1)
            r2 = r11
            r3 = r12
            r4 = r13
            r5 = r14
            r6 = r15
        L_0x0132:
            androidx.compose.runtime.ScopeUpdateScope r10 = r10.endRestartGroup()
            if (r10 != 0) goto L_0x0139
            goto L_0x0148
        L_0x0139:
            com.designsystem.ds_chip.DSSingleSelectionChipKt$DSSingleSelectionChip$3 r11 = new com.designsystem.ds_chip.DSSingleSelectionChipKt$DSSingleSelectionChip$3
            r0 = r11
            r1 = r16
            r7 = r23
            r8 = r24
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            r10.updateScope(r11)
        L_0x0148:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.designsystem.ds_chip.DSSingleSelectionChipKt.DSSingleSelectionChip(java.lang.String, androidx.compose.ui.Modifier, java.lang.Integer, java.lang.Integer, boolean, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }
}
