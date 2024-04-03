package com.designsystem.ds_button_v2;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001ac\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\n2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\u000eH\u0007¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, d2 = {"DSSecondaryButton", "", "title", "", "modifier", "Landroidx/compose/ui/Modifier;", "caption", "leadingIcon", "", "isEnabled", "", "isLoading", "forceMM2", "onTap", "Lkotlin/Function0;", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;Ljava/lang/String;Ljava/lang/Integer;ZZZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "marshmallow_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class DSSecondaryButtonKt {
    /* JADX WARNING: Removed duplicated region for block: B:119:0x01a8  */
    /* JADX WARNING: Removed duplicated region for block: B:121:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00b2  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00cb  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00e9  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00ed  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0110  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x011f  */
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void DSSecondaryButton(@org.jetbrains.annotations.NotNull java.lang.String r25, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r26, @org.jetbrains.annotations.Nullable java.lang.String r27, @org.jetbrains.annotations.Nullable @androidx.annotation.DrawableRes java.lang.Integer r28, boolean r29, boolean r30, boolean r31, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function0<kotlin.Unit> r32, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r33, int r34, int r35) {
        /*
            r13 = r25
            r14 = r32
            r15 = r34
            r12 = r35
            java.lang.String r0 = "title"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.lang.String r0 = "onTap"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            r0 = 1529979150(0x5b31a10e, float:4.9998152E16)
            r1 = r33
            androidx.compose.runtime.Composer r11 = r1.startRestartGroup(r0)
            r0 = r12 & 1
            if (r0 == 0) goto L_0x0022
            r0 = r15 | 6
            goto L_0x0032
        L_0x0022:
            r0 = r15 & 14
            if (r0 != 0) goto L_0x0031
            boolean r0 = r11.changed((java.lang.Object) r13)
            if (r0 == 0) goto L_0x002e
            r0 = 4
            goto L_0x002f
        L_0x002e:
            r0 = 2
        L_0x002f:
            r0 = r0 | r15
            goto L_0x0032
        L_0x0031:
            r0 = r15
        L_0x0032:
            r1 = r12 & 2
            if (r1 == 0) goto L_0x0039
            r0 = r0 | 48
            goto L_0x004c
        L_0x0039:
            r2 = r15 & 112(0x70, float:1.57E-43)
            if (r2 != 0) goto L_0x004c
            r2 = r26
            boolean r3 = r11.changed((java.lang.Object) r2)
            if (r3 == 0) goto L_0x0048
            r3 = 32
            goto L_0x004a
        L_0x0048:
            r3 = 16
        L_0x004a:
            r0 = r0 | r3
            goto L_0x004e
        L_0x004c:
            r2 = r26
        L_0x004e:
            r3 = r12 & 4
            if (r3 == 0) goto L_0x0055
            r0 = r0 | 384(0x180, float:5.38E-43)
            goto L_0x0068
        L_0x0055:
            r4 = r15 & 896(0x380, float:1.256E-42)
            if (r4 != 0) goto L_0x0068
            r4 = r27
            boolean r5 = r11.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x0064
            r5 = 256(0x100, float:3.59E-43)
            goto L_0x0066
        L_0x0064:
            r5 = 128(0x80, float:1.794E-43)
        L_0x0066:
            r0 = r0 | r5
            goto L_0x006a
        L_0x0068:
            r4 = r27
        L_0x006a:
            r5 = r12 & 8
            if (r5 == 0) goto L_0x0071
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            goto L_0x0084
        L_0x0071:
            r6 = r15 & 7168(0x1c00, float:1.0045E-41)
            if (r6 != 0) goto L_0x0084
            r6 = r28
            boolean r7 = r11.changed((java.lang.Object) r6)
            if (r7 == 0) goto L_0x0080
            r7 = 2048(0x800, float:2.87E-42)
            goto L_0x0082
        L_0x0080:
            r7 = 1024(0x400, float:1.435E-42)
        L_0x0082:
            r0 = r0 | r7
            goto L_0x0086
        L_0x0084:
            r6 = r28
        L_0x0086:
            r7 = r12 & 16
            r8 = 57344(0xe000, float:8.0356E-41)
            if (r7 == 0) goto L_0x0090
            r0 = r0 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00a3
        L_0x0090:
            r9 = r15 & r8
            if (r9 != 0) goto L_0x00a3
            r9 = r29
            boolean r10 = r11.changed((boolean) r9)
            if (r10 == 0) goto L_0x009f
            r10 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a1
        L_0x009f:
            r10 = 8192(0x2000, float:1.14794E-41)
        L_0x00a1:
            r0 = r0 | r10
            goto L_0x00a5
        L_0x00a3:
            r9 = r29
        L_0x00a5:
            r10 = r12 & 32
            r16 = 458752(0x70000, float:6.42848E-40)
            if (r10 == 0) goto L_0x00b2
            r17 = 196608(0x30000, float:2.75506E-40)
            r0 = r0 | r17
            r8 = r30
            goto L_0x00c5
        L_0x00b2:
            r17 = r15 & r16
            r8 = r30
            if (r17 != 0) goto L_0x00c5
            boolean r17 = r11.changed((boolean) r8)
            if (r17 == 0) goto L_0x00c1
            r17 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00c3
        L_0x00c1:
            r17 = 65536(0x10000, float:9.18355E-41)
        L_0x00c3:
            r0 = r0 | r17
        L_0x00c5:
            r17 = r12 & 64
            r18 = 3670016(0x380000, float:5.142788E-39)
            if (r17 == 0) goto L_0x00d2
            r19 = 1572864(0x180000, float:2.204052E-39)
            r0 = r0 | r19
            r2 = r31
            goto L_0x00e5
        L_0x00d2:
            r19 = r15 & r18
            r2 = r31
            if (r19 != 0) goto L_0x00e5
            boolean r19 = r11.changed((boolean) r2)
            if (r19 == 0) goto L_0x00e1
            r19 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00e3
        L_0x00e1:
            r19 = 524288(0x80000, float:7.34684E-40)
        L_0x00e3:
            r0 = r0 | r19
        L_0x00e5:
            r2 = r12 & 128(0x80, float:1.794E-43)
            if (r2 == 0) goto L_0x00ed
            r2 = 12582912(0xc00000, float:1.7632415E-38)
        L_0x00eb:
            r0 = r0 | r2
            goto L_0x00fe
        L_0x00ed:
            r2 = 29360128(0x1c00000, float:7.052966E-38)
            r2 = r2 & r15
            if (r2 != 0) goto L_0x00fe
            boolean r2 = r11.changed((java.lang.Object) r14)
            if (r2 == 0) goto L_0x00fb
            r2 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00eb
        L_0x00fb:
            r2 = 4194304(0x400000, float:5.877472E-39)
            goto L_0x00eb
        L_0x00fe:
            r2 = 23967451(0x16db6db, float:4.3661218E-38)
            r2 = r2 & r0
            r19 = 4793490(0x492492, float:6.71711E-39)
            r2 = r2 ^ r19
            if (r2 != 0) goto L_0x011f
            boolean r2 = r11.getSkipping()
            if (r2 != 0) goto L_0x0110
            goto L_0x011f
        L_0x0110:
            r11.skipToGroupEnd()
            r2 = r26
            r7 = r31
            r3 = r4
            r4 = r6
            r6 = r8
            r5 = r9
            r24 = r11
            goto L_0x01a1
        L_0x011f:
            if (r1 == 0) goto L_0x0126
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            r19 = r1
            goto L_0x0128
        L_0x0126:
            r19 = r26
        L_0x0128:
            r1 = 0
            if (r3 == 0) goto L_0x012e
            r20 = r1
            goto L_0x0130
        L_0x012e:
            r20 = r4
        L_0x0130:
            if (r5 == 0) goto L_0x0135
            r21 = r1
            goto L_0x0137
        L_0x0135:
            r21 = r6
        L_0x0137:
            r1 = 1
            if (r7 == 0) goto L_0x013d
            r22 = r1
            goto L_0x013f
        L_0x013d:
            r22 = r9
        L_0x013f:
            r2 = 0
            if (r10 == 0) goto L_0x0145
            r23 = r2
            goto L_0x0147
        L_0x0145:
            r23 = r8
        L_0x0147:
            if (r17 == 0) goto L_0x014c
            r17 = r2
            goto L_0x014e
        L_0x014c:
            r17 = r31
        L_0x014e:
            if (r17 != 0) goto L_0x015f
            com.designsystem.DSConfiguration$Companion r3 = com.designsystem.DSConfiguration.Companion
            com.designsystem.DSConfiguration r3 = r3.getInstance()
            boolean r3 = r3.getButtonM2Enabled()
            if (r3 == 0) goto L_0x015d
            goto L_0x015f
        L_0x015d:
            r7 = r2
            goto L_0x0160
        L_0x015f:
            r7 = r1
        L_0x0160:
            com.designsystem.ds_button_v2.DSButtonDefaults r1 = com.designsystem.ds_button_v2.DSButtonDefaults.INSTANCE
            com.designsystem.ds_button_v2.DSDefaultButtonTheme r1 = r1.secondaryButtonTheme(r7, r11, r2, r2)
            r8 = r7 ^ 1
            int r2 = r0 << 3
            r3 = r2 & 112(0x70, float:1.57E-43)
            r4 = r2 & 896(0x380, float:1.256E-42)
            r3 = r3 | r4
            r4 = r2 & 7168(0x1c00, float:1.0045E-41)
            r3 = r3 | r4
            r4 = 57344(0xe000, float:8.0356E-41)
            r4 = r4 & r2
            r3 = r3 | r4
            r4 = r2 & r16
            r3 = r3 | r4
            r2 = r2 & r18
            r2 = r2 | r3
            r3 = 1879048192(0x70000000, float:1.58456325E29)
            int r0 = r0 << 6
            r0 = r0 & r3
            r16 = r2 | r0
            r18 = 0
            r0 = r1
            r1 = r25
            r2 = r19
            r3 = r20
            r4 = r21
            r5 = r22
            r6 = r23
            r9 = r32
            r10 = r11
            r24 = r11
            r11 = r16
            r12 = r18
            com.designsystem.ds_button_v2.DSBaseButtonKt.DSBaseButton(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            r7 = r17
        L_0x01a1:
            androidx.compose.runtime.ScopeUpdateScope r11 = r24.endRestartGroup()
            if (r11 != 0) goto L_0x01a8
            goto L_0x01b9
        L_0x01a8:
            com.designsystem.ds_button_v2.DSSecondaryButtonKt$DSSecondaryButton$1 r12 = new com.designsystem.ds_button_v2.DSSecondaryButtonKt$DSSecondaryButton$1
            r0 = r12
            r1 = r25
            r8 = r32
            r9 = r34
            r10 = r35
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            r11.updateScope(r12)
        L_0x01b9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.designsystem.ds_button_v2.DSSecondaryButtonKt.DSSecondaryButton(java.lang.String, androidx.compose.ui.Modifier, java.lang.String, java.lang.Integer, boolean, boolean, boolean, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }
}
