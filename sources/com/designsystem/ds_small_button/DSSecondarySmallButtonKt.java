package com.designsystem.ds_small_button;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aW\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\rH\u0007¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, d2 = {"DSSecondarySmallButton", "", "title", "", "modifier", "Landroidx/compose/ui/Modifier;", "leadingIcon", "", "isEnabled", "", "isLoading", "forceMM2", "onTap", "Lkotlin/Function0;", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;Ljava/lang/Integer;ZZZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "marshmallow_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class DSSecondarySmallButtonKt {
    /* JADX WARNING: Removed duplicated region for block: B:105:0x0178  */
    /* JADX WARNING: Removed duplicated region for block: B:107:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00b0  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00cc  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00f1  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x00fc  */
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void DSSecondarySmallButton(@org.jetbrains.annotations.NotNull java.lang.String r23, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r24, @org.jetbrains.annotations.Nullable @androidx.annotation.DrawableRes java.lang.Integer r25, boolean r26, boolean r27, boolean r28, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function0<kotlin.Unit> r29, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r30, int r31, int r32) {
        /*
            r13 = r23
            r14 = r29
            r15 = r31
            java.lang.String r0 = "title"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.lang.String r0 = "onTap"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            r0 = -355787828(0xffffffffeacb1bcc, float:-1.227716E26)
            r1 = r30
            androidx.compose.runtime.Composer r12 = r1.startRestartGroup(r0)
            r0 = r32 & 1
            if (r0 == 0) goto L_0x0020
            r0 = r15 | 6
            goto L_0x0030
        L_0x0020:
            r0 = r15 & 14
            if (r0 != 0) goto L_0x002f
            boolean r0 = r12.changed((java.lang.Object) r13)
            if (r0 == 0) goto L_0x002c
            r0 = 4
            goto L_0x002d
        L_0x002c:
            r0 = 2
        L_0x002d:
            r0 = r0 | r15
            goto L_0x0030
        L_0x002f:
            r0 = r15
        L_0x0030:
            r1 = r32 & 2
            if (r1 == 0) goto L_0x0037
            r0 = r0 | 48
            goto L_0x004a
        L_0x0037:
            r2 = r15 & 112(0x70, float:1.57E-43)
            if (r2 != 0) goto L_0x004a
            r2 = r24
            boolean r3 = r12.changed((java.lang.Object) r2)
            if (r3 == 0) goto L_0x0046
            r3 = 32
            goto L_0x0048
        L_0x0046:
            r3 = 16
        L_0x0048:
            r0 = r0 | r3
            goto L_0x004c
        L_0x004a:
            r2 = r24
        L_0x004c:
            r3 = r32 & 4
            if (r3 == 0) goto L_0x0053
            r0 = r0 | 384(0x180, float:5.38E-43)
            goto L_0x0066
        L_0x0053:
            r4 = r15 & 896(0x380, float:1.256E-42)
            if (r4 != 0) goto L_0x0066
            r4 = r25
            boolean r5 = r12.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x0062
            r5 = 256(0x100, float:3.59E-43)
            goto L_0x0064
        L_0x0062:
            r5 = 128(0x80, float:1.794E-43)
        L_0x0064:
            r0 = r0 | r5
            goto L_0x0068
        L_0x0066:
            r4 = r25
        L_0x0068:
            r5 = r32 & 8
            if (r5 == 0) goto L_0x006f
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            goto L_0x0082
        L_0x006f:
            r6 = r15 & 7168(0x1c00, float:1.0045E-41)
            if (r6 != 0) goto L_0x0082
            r6 = r26
            boolean r7 = r12.changed((boolean) r6)
            if (r7 == 0) goto L_0x007e
            r7 = 2048(0x800, float:2.87E-42)
            goto L_0x0080
        L_0x007e:
            r7 = 1024(0x400, float:1.435E-42)
        L_0x0080:
            r0 = r0 | r7
            goto L_0x0084
        L_0x0082:
            r6 = r26
        L_0x0084:
            r7 = r32 & 16
            r8 = 57344(0xe000, float:8.0356E-41)
            if (r7 == 0) goto L_0x008e
            r0 = r0 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00a1
        L_0x008e:
            r9 = r15 & r8
            if (r9 != 0) goto L_0x00a1
            r9 = r27
            boolean r10 = r12.changed((boolean) r9)
            if (r10 == 0) goto L_0x009d
            r10 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009f
        L_0x009d:
            r10 = 8192(0x2000, float:1.14794E-41)
        L_0x009f:
            r0 = r0 | r10
            goto L_0x00a3
        L_0x00a1:
            r9 = r27
        L_0x00a3:
            r10 = r32 & 32
            r11 = 458752(0x70000, float:6.42848E-40)
            if (r10 == 0) goto L_0x00b0
            r16 = 196608(0x30000, float:2.75506E-40)
            r0 = r0 | r16
            r11 = r28
            goto L_0x00c3
        L_0x00b0:
            r16 = r15 & r11
            r11 = r28
            if (r16 != 0) goto L_0x00c3
            boolean r16 = r12.changed((boolean) r11)
            if (r16 == 0) goto L_0x00bf
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00c1
        L_0x00bf:
            r16 = 65536(0x10000, float:9.18355E-41)
        L_0x00c1:
            r0 = r0 | r16
        L_0x00c3:
            r16 = r32 & 64
            if (r16 == 0) goto L_0x00cc
            r16 = 1572864(0x180000, float:2.204052E-39)
        L_0x00c9:
            r0 = r0 | r16
            goto L_0x00de
        L_0x00cc:
            r16 = 3670016(0x380000, float:5.142788E-39)
            r16 = r15 & r16
            if (r16 != 0) goto L_0x00de
            boolean r16 = r12.changed((java.lang.Object) r14)
            if (r16 == 0) goto L_0x00db
            r16 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00c9
        L_0x00db:
            r16 = 524288(0x80000, float:7.34684E-40)
            goto L_0x00c9
        L_0x00de:
            r16 = 2995931(0x2db6db, float:4.198194E-39)
            r16 = r0 & r16
            r17 = 599186(0x92492, float:8.39638E-40)
            r16 = r16 ^ r17
            if (r16 != 0) goto L_0x00fc
            boolean r16 = r12.getSkipping()
            if (r16 != 0) goto L_0x00f1
            goto L_0x00fc
        L_0x00f1:
            r12.skipToGroupEnd()
            r3 = r4
            r4 = r6
            r5 = r9
            r6 = r11
            r22 = r12
            goto L_0x0171
        L_0x00fc:
            if (r1 == 0) goto L_0x0103
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            r16 = r1
            goto L_0x0105
        L_0x0103:
            r16 = r2
        L_0x0105:
            if (r3 == 0) goto L_0x010b
            r1 = 0
            r17 = r1
            goto L_0x010d
        L_0x010b:
            r17 = r4
        L_0x010d:
            r1 = 1
            if (r5 == 0) goto L_0x0113
            r18 = r1
            goto L_0x0115
        L_0x0113:
            r18 = r6
        L_0x0115:
            r2 = 0
            if (r7 == 0) goto L_0x011b
            r19 = r2
            goto L_0x011d
        L_0x011b:
            r19 = r9
        L_0x011d:
            if (r10 == 0) goto L_0x0122
            r20 = r2
            goto L_0x0124
        L_0x0122:
            r20 = r11
        L_0x0124:
            if (r20 != 0) goto L_0x0135
            com.designsystem.DSConfiguration$Companion r3 = com.designsystem.DSConfiguration.Companion
            com.designsystem.DSConfiguration r3 = r3.getInstance()
            boolean r3 = r3.getSmallButtonM2Enabled()
            if (r3 == 0) goto L_0x0133
            goto L_0x0135
        L_0x0133:
            r6 = r2
            goto L_0x0136
        L_0x0135:
            r6 = r1
        L_0x0136:
            com.designsystem.ds_button_v2.DSButtonDefaults r1 = com.designsystem.ds_button_v2.DSButtonDefaults.INSTANCE
            com.designsystem.ds_button_v2.DSDefaultButtonTheme r1 = r1.secondaryButtonTheme(r6, r12, r2, r2)
            r7 = r6 ^ 1
            r9 = 0
            int r2 = r0 << 3
            r3 = r2 & 112(0x70, float:1.57E-43)
            r4 = r2 & 896(0x380, float:1.256E-42)
            r3 = r3 | r4
            r4 = r2 & 7168(0x1c00, float:1.0045E-41)
            r3 = r3 | r4
            r4 = r2 & r8
            r3 = r3 | r4
            r4 = 458752(0x70000, float:6.42848E-40)
            r2 = r2 & r4
            r2 = r2 | r3
            int r0 = r0 << 9
            r3 = 1879048192(0x70000000, float:1.58456325E29)
            r0 = r0 & r3
            r11 = r2 | r0
            r21 = 256(0x100, float:3.59E-43)
            r0 = r1
            r1 = r23
            r2 = r16
            r3 = r17
            r4 = r18
            r5 = r19
            r8 = r9
            r9 = r29
            r10 = r12
            r22 = r12
            r12 = r21
            com.designsystem.ds_small_button.DSBaseSmallButtonKt.DSBaseSmallButton(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            r6 = r20
        L_0x0171:
            androidx.compose.runtime.ScopeUpdateScope r10 = r22.endRestartGroup()
            if (r10 != 0) goto L_0x0178
            goto L_0x0189
        L_0x0178:
            com.designsystem.ds_small_button.DSSecondarySmallButtonKt$DSSecondarySmallButton$1 r11 = new com.designsystem.ds_small_button.DSSecondarySmallButtonKt$DSSecondarySmallButton$1
            r0 = r11
            r1 = r23
            r7 = r29
            r8 = r31
            r9 = r32
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            r10.updateScope(r11)
        L_0x0189:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.designsystem.ds_small_button.DSSecondarySmallButtonKt.DSSecondarySmallButton(java.lang.String, androidx.compose.ui.Modifier, java.lang.Integer, boolean, boolean, boolean, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }
}
