package com.designsystem.ds_branded_button;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aK\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\u000bH\u0007¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"DSAppleBrandedButton", "", "title", "", "modifier", "Landroidx/compose/ui/Modifier;", "isEnabled", "", "isLoading", "forceMM2", "onTap", "Lkotlin/Function0;", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;ZZZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "marshmallow_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class DSAppleBrandedButtonKt {
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00ad  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00cf  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00d6  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0127  */
    /* JADX WARNING: Removed duplicated region for block: B:88:? A[RETURN, SYNTHETIC] */
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void DSAppleBrandedButton(@org.jetbrains.annotations.NotNull java.lang.String r19, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r20, boolean r21, boolean r22, boolean r23, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function0<kotlin.Unit> r24, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r25, int r26, int r27) {
        /*
            r10 = r19
            r11 = r24
            r12 = r26
            java.lang.String r0 = "title"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "onTap"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            r0 = 963891791(0x3973d24f, float:2.3252632E-4)
            r1 = r25
            androidx.compose.runtime.Composer r13 = r1.startRestartGroup(r0)
            r0 = r27 & 1
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
            r1 = r27 & 2
            if (r1 == 0) goto L_0x0037
            r0 = r0 | 48
            goto L_0x004a
        L_0x0037:
            r2 = r12 & 112(0x70, float:1.57E-43)
            if (r2 != 0) goto L_0x004a
            r2 = r20
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
            r2 = r20
        L_0x004c:
            r3 = r27 & 4
            if (r3 == 0) goto L_0x0053
            r0 = r0 | 384(0x180, float:5.38E-43)
            goto L_0x0066
        L_0x0053:
            r4 = r12 & 896(0x380, float:1.256E-42)
            if (r4 != 0) goto L_0x0066
            r4 = r21
            boolean r5 = r13.changed((boolean) r4)
            if (r5 == 0) goto L_0x0062
            r5 = 256(0x100, float:3.59E-43)
            goto L_0x0064
        L_0x0062:
            r5 = 128(0x80, float:1.794E-43)
        L_0x0064:
            r0 = r0 | r5
            goto L_0x0068
        L_0x0066:
            r4 = r21
        L_0x0068:
            r5 = r27 & 8
            if (r5 == 0) goto L_0x006f
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            goto L_0x0082
        L_0x006f:
            r6 = r12 & 7168(0x1c00, float:1.0045E-41)
            if (r6 != 0) goto L_0x0082
            r6 = r22
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
            r6 = r22
        L_0x0084:
            r7 = r27 & 16
            r8 = 57344(0xe000, float:8.0356E-41)
            if (r7 == 0) goto L_0x008e
            r0 = r0 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00a1
        L_0x008e:
            r9 = r12 & r8
            if (r9 != 0) goto L_0x00a1
            r9 = r23
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
            r9 = r23
        L_0x00a3:
            r14 = r27 & 32
            r15 = 458752(0x70000, float:6.42848E-40)
            if (r14 == 0) goto L_0x00ad
            r14 = 196608(0x30000, float:2.75506E-40)
        L_0x00ab:
            r0 = r0 | r14
            goto L_0x00bd
        L_0x00ad:
            r14 = r12 & r15
            if (r14 != 0) goto L_0x00bd
            boolean r14 = r13.changed((java.lang.Object) r11)
            if (r14 == 0) goto L_0x00ba
            r14 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00ab
        L_0x00ba:
            r14 = 65536(0x10000, float:9.18355E-41)
            goto L_0x00ab
        L_0x00bd:
            r14 = 374491(0x5b6db, float:5.24774E-40)
            r14 = r14 & r0
            r16 = 74898(0x12492, float:1.04954E-40)
            r14 = r14 ^ r16
            if (r14 != 0) goto L_0x00d6
            boolean r14 = r13.getSkipping()
            if (r14 != 0) goto L_0x00cf
            goto L_0x00d6
        L_0x00cf:
            r13.skipToGroupEnd()
            r3 = r4
            r4 = r6
            r5 = r9
            goto L_0x0120
        L_0x00d6:
            if (r1 == 0) goto L_0x00dc
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            r14 = r1
            goto L_0x00dd
        L_0x00dc:
            r14 = r2
        L_0x00dd:
            if (r3 == 0) goto L_0x00e3
            r1 = 1
            r16 = r1
            goto L_0x00e5
        L_0x00e3:
            r16 = r4
        L_0x00e5:
            r1 = 0
            if (r5 == 0) goto L_0x00eb
            r17 = r1
            goto L_0x00ed
        L_0x00eb:
            r17 = r6
        L_0x00ed:
            if (r7 == 0) goto L_0x00f2
            r18 = r1
            goto L_0x00f4
        L_0x00f2:
            r18 = r9
        L_0x00f4:
            int r1 = com.designsystem.marshmallow.R.drawable.ds_apple
            java.lang.Integer r2 = java.lang.Integer.valueOf(r1)
            r1 = r0 & 14
            r3 = r0 & 112(0x70, float:1.57E-43)
            r1 = r1 | r3
            int r0 = r0 << 3
            r3 = r0 & 7168(0x1c00, float:1.0045E-41)
            r1 = r1 | r3
            r3 = r0 & r8
            r1 = r1 | r3
            r3 = r0 & r15
            r1 = r1 | r3
            r3 = 3670016(0x380000, float:5.142788E-39)
            r0 = r0 & r3
            r8 = r1 | r0
            r9 = 0
            r0 = r19
            r1 = r14
            r3 = r16
            r4 = r17
            r5 = r18
            r6 = r24
            r7 = r13
            com.designsystem.ds_branded_button.DSBrandedButtonKt.DSBrandedButton(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9)
            r2 = r14
        L_0x0120:
            androidx.compose.runtime.ScopeUpdateScope r9 = r13.endRestartGroup()
            if (r9 != 0) goto L_0x0127
            goto L_0x0138
        L_0x0127:
            com.designsystem.ds_branded_button.DSAppleBrandedButtonKt$DSAppleBrandedButton$1 r13 = new com.designsystem.ds_branded_button.DSAppleBrandedButtonKt$DSAppleBrandedButton$1
            r0 = r13
            r1 = r19
            r6 = r24
            r7 = r26
            r8 = r27
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            r9.updateScope(r13)
        L_0x0138:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.designsystem.ds_branded_button.DSAppleBrandedButtonKt.DSAppleBrandedButton(java.lang.String, androidx.compose.ui.Modifier, boolean, boolean, boolean, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }
}
