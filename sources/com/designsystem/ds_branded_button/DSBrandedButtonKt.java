package com.designsystem.ds_branded_button;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aW\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\rH\u0007¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, d2 = {"DSBrandedButton", "", "title", "", "modifier", "Landroidx/compose/ui/Modifier;", "leadingIcon", "", "isEnabled", "", "isLoading", "forceMM2", "onTap", "Lkotlin/Function0;", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;Ljava/lang/Integer;ZZZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "marshmallow_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class DSBrandedButtonKt {
    /* JADX WARNING: Removed duplicated region for block: B:110:0x0167  */
    /* JADX WARNING: Removed duplicated region for block: B:112:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00cb  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x00f9  */
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void DSBrandedButton(@org.jetbrains.annotations.NotNull java.lang.String r20, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r21, @org.jetbrains.annotations.Nullable @androidx.annotation.DrawableRes java.lang.Integer r22, boolean r23, boolean r24, boolean r25, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function0<kotlin.Unit> r26, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r27, int r28, int r29) {
        /*
            r10 = r20
            r11 = r26
            r12 = r28
            java.lang.String r0 = "title"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "onTap"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            r0 = 512198040(0x1e878598, float:1.4348934E-20)
            r1 = r27
            androidx.compose.runtime.Composer r13 = r1.startRestartGroup(r0)
            r0 = r29 & 1
            if (r0 == 0) goto L_0x0020
            r0 = r12 | 6
            goto L_0x0030
        L_0x0020:
            r0 = r12 & 14
            if (r0 != 0) goto L_0x002f
            boolean r0 = r13.changed((java.lang.Object) r10)
            if (r0 == 0) goto L_0x002c
            r0 = 4
            goto L_0x002d
        L_0x002c:
            r0 = 2
        L_0x002d:
            r0 = r0 | r12
            goto L_0x0030
        L_0x002f:
            r0 = r12
        L_0x0030:
            r1 = r29 & 2
            if (r1 == 0) goto L_0x0037
            r0 = r0 | 48
            goto L_0x004a
        L_0x0037:
            r2 = r12 & 112(0x70, float:1.57E-43)
            if (r2 != 0) goto L_0x004a
            r2 = r21
            boolean r3 = r13.changed((java.lang.Object) r2)
            if (r3 == 0) goto L_0x0046
            r3 = 32
            goto L_0x0048
        L_0x0046:
            r3 = 16
        L_0x0048:
            r0 = r0 | r3
            goto L_0x004c
        L_0x004a:
            r2 = r21
        L_0x004c:
            r3 = r29 & 4
            if (r3 == 0) goto L_0x0053
            r0 = r0 | 384(0x180, float:5.38E-43)
            goto L_0x0066
        L_0x0053:
            r4 = r12 & 896(0x380, float:1.256E-42)
            if (r4 != 0) goto L_0x0066
            r4 = r22
            boolean r5 = r13.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x0062
            r5 = 256(0x100, float:3.59E-43)
            goto L_0x0064
        L_0x0062:
            r5 = 128(0x80, float:1.794E-43)
        L_0x0064:
            r0 = r0 | r5
            goto L_0x0068
        L_0x0066:
            r4 = r22
        L_0x0068:
            r5 = r29 & 8
            if (r5 == 0) goto L_0x006f
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            goto L_0x0082
        L_0x006f:
            r6 = r12 & 7168(0x1c00, float:1.0045E-41)
            if (r6 != 0) goto L_0x0082
            r6 = r23
            boolean r7 = r13.changed((boolean) r6)
            if (r7 == 0) goto L_0x007e
            r7 = 2048(0x800, float:2.87E-42)
            goto L_0x0080
        L_0x007e:
            r7 = 1024(0x400, float:1.435E-42)
        L_0x0080:
            r0 = r0 | r7
            goto L_0x0084
        L_0x0082:
            r6 = r23
        L_0x0084:
            r7 = r29 & 16
            r8 = 57344(0xe000, float:8.0356E-41)
            if (r7 == 0) goto L_0x008e
            r0 = r0 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00a1
        L_0x008e:
            r9 = r12 & r8
            if (r9 != 0) goto L_0x00a1
            r9 = r24
            boolean r14 = r13.changed((boolean) r9)
            if (r14 == 0) goto L_0x009d
            r14 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009f
        L_0x009d:
            r14 = 8192(0x2000, float:1.14794E-41)
        L_0x009f:
            r0 = r0 | r14
            goto L_0x00a3
        L_0x00a1:
            r9 = r24
        L_0x00a3:
            r14 = r29 & 32
            if (r14 == 0) goto L_0x00ab
            r15 = 196608(0x30000, float:2.75506E-40)
            r0 = r0 | r15
            goto L_0x00c0
        L_0x00ab:
            r15 = 458752(0x70000, float:6.42848E-40)
            r15 = r15 & r12
            if (r15 != 0) goto L_0x00c0
            r15 = r25
            boolean r16 = r13.changed((boolean) r15)
            if (r16 == 0) goto L_0x00bb
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00bd
        L_0x00bb:
            r16 = 65536(0x10000, float:9.18355E-41)
        L_0x00bd:
            r0 = r0 | r16
            goto L_0x00c2
        L_0x00c0:
            r15 = r25
        L_0x00c2:
            r16 = r29 & 64
            if (r16 == 0) goto L_0x00cb
            r16 = 1572864(0x180000, float:2.204052E-39)
        L_0x00c8:
            r0 = r0 | r16
            goto L_0x00dd
        L_0x00cb:
            r16 = 3670016(0x380000, float:5.142788E-39)
            r16 = r12 & r16
            if (r16 != 0) goto L_0x00dd
            boolean r16 = r13.changed((java.lang.Object) r11)
            if (r16 == 0) goto L_0x00da
            r16 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00c8
        L_0x00da:
            r16 = 524288(0x80000, float:7.34684E-40)
            goto L_0x00c8
        L_0x00dd:
            r16 = 2995931(0x2db6db, float:4.198194E-39)
            r16 = r0 & r16
            r17 = 599186(0x92492, float:8.39638E-40)
            r16 = r16 ^ r17
            if (r16 != 0) goto L_0x00f9
            boolean r16 = r13.getSkipping()
            if (r16 != 0) goto L_0x00f0
            goto L_0x00f9
        L_0x00f0:
            r13.skipToGroupEnd()
            r3 = r4
            r4 = r6
            r5 = r9
            r6 = r15
            goto L_0x0160
        L_0x00f9:
            if (r1 == 0) goto L_0x0100
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            r16 = r1
            goto L_0x0102
        L_0x0100:
            r16 = r2
        L_0x0102:
            if (r3 == 0) goto L_0x0108
            r1 = 0
            r17 = r1
            goto L_0x010a
        L_0x0108:
            r17 = r4
        L_0x010a:
            r1 = 1
            if (r5 == 0) goto L_0x0110
            r18 = r1
            goto L_0x0112
        L_0x0110:
            r18 = r6
        L_0x0112:
            r2 = 0
            if (r7 == 0) goto L_0x0118
            r19 = r2
            goto L_0x011a
        L_0x0118:
            r19 = r9
        L_0x011a:
            if (r14 == 0) goto L_0x011d
            r15 = r2
        L_0x011d:
            if (r15 != 0) goto L_0x012e
            com.designsystem.DSConfiguration$Companion r3 = com.designsystem.DSConfiguration.Companion
            com.designsystem.DSConfiguration r3 = r3.getInstance()
            boolean r3 = r3.getBrandedButtonM2Enabled()
            if (r3 == 0) goto L_0x012c
            goto L_0x012e
        L_0x012c:
            r6 = r2
            goto L_0x012f
        L_0x012e:
            r6 = r1
        L_0x012f:
            com.designsystem.ds_button_v2.DSButtonDefaults r3 = com.designsystem.ds_button_v2.DSButtonDefaults.INSTANCE
            com.designsystem.ds_button_v2.DSDefaultButtonTheme r3 = r3.brandedButtonTheme(r6, r13, r2, r2)
            if (r6 == 0) goto L_0x013b
            if (r19 == 0) goto L_0x013b
            r5 = r1
            goto L_0x013c
        L_0x013b:
            r5 = r2
        L_0x013c:
            int r0 = r0 << 3
            r1 = r0 & 112(0x70, float:1.57E-43)
            r2 = r0 & 896(0x380, float:1.256E-42)
            r1 = r1 | r2
            r2 = r0 & 7168(0x1c00, float:1.0045E-41)
            r1 = r1 | r2
            r2 = r0 & r8
            r1 = r1 | r2
            r2 = 29360128(0x1c00000, float:7.052966E-38)
            r0 = r0 & r2
            r9 = r1 | r0
            r0 = r3
            r1 = r20
            r2 = r16
            r3 = r17
            r4 = r18
            r7 = r26
            r8 = r13
            com.designsystem.ds_branded_button.DSBaseBrandedButtonKt.DSBaseBrandedButton(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9)
            r6 = r15
            r5 = r19
        L_0x0160:
            androidx.compose.runtime.ScopeUpdateScope r13 = r13.endRestartGroup()
            if (r13 != 0) goto L_0x0167
            goto L_0x0178
        L_0x0167:
            com.designsystem.ds_branded_button.DSBrandedButtonKt$DSBrandedButton$1 r14 = new com.designsystem.ds_branded_button.DSBrandedButtonKt$DSBrandedButton$1
            r0 = r14
            r1 = r20
            r7 = r26
            r8 = r28
            r9 = r29
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            r13.updateScope(r14)
        L_0x0178:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.designsystem.ds_branded_button.DSBrandedButtonKt.DSBrandedButton(java.lang.String, androidx.compose.ui.Modifier, java.lang.Integer, boolean, boolean, boolean, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }
}
