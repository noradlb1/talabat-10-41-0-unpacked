package com.designsystem.ds_alert;

import kotlin.Metadata;

@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001aW\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0007¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, d2 = {"DSAlert", "", "modifier", "Landroidx/compose/ui/Modifier;", "descriptor", "", "alertType", "Lcom/designsystem/ds_alert/DSAlertType;", "title", "actionButton", "Lcom/designsystem/ds_alert/DSAlertActionButtonModel;", "iconButton", "Lcom/designsystem/ds_icon_button/DSIconButtonModel;", "withLeadingIcon", "", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;Lcom/designsystem/ds_alert/DSAlertType;Ljava/lang/String;Lcom/designsystem/ds_alert/DSAlertActionButtonModel;Lcom/designsystem/ds_icon_button/DSIconButtonModel;Ljava/lang/Boolean;Landroidx/compose/runtime/Composer;II)V", "marshmallow_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class DSAlertKt {
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00cc  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00f2  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00f9  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0151  */
    /* JADX WARNING: Removed duplicated region for block: B:99:? A[RETURN, SYNTHETIC] */
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void DSAlert(@org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r20, @org.jetbrains.annotations.NotNull java.lang.String r21, @org.jetbrains.annotations.NotNull com.designsystem.ds_alert.DSAlertType r22, @org.jetbrains.annotations.Nullable java.lang.String r23, @org.jetbrains.annotations.Nullable com.designsystem.ds_alert.DSAlertActionButtonModel r24, @org.jetbrains.annotations.Nullable com.designsystem.ds_icon_button.DSIconButtonModel r25, @org.jetbrains.annotations.Nullable java.lang.Boolean r26, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r27, int r28, int r29) {
        /*
            r10 = r21
            r11 = r22
            r12 = r28
            java.lang.String r0 = "descriptor"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "alertType"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            r0 = -1320833070(0xffffffffb145afd2, float:-2.8767215E-9)
            r1 = r27
            androidx.compose.runtime.Composer r13 = r1.startRestartGroup(r0)
            r0 = r29 & 1
            if (r0 == 0) goto L_0x0023
            r1 = r12 | 6
            r2 = r1
            r1 = r20
            goto L_0x0037
        L_0x0023:
            r1 = r12 & 14
            if (r1 != 0) goto L_0x0034
            r1 = r20
            boolean r2 = r13.changed((java.lang.Object) r1)
            if (r2 == 0) goto L_0x0031
            r2 = 4
            goto L_0x0032
        L_0x0031:
            r2 = 2
        L_0x0032:
            r2 = r2 | r12
            goto L_0x0037
        L_0x0034:
            r1 = r20
            r2 = r12
        L_0x0037:
            r3 = r29 & 2
            if (r3 == 0) goto L_0x003e
            r2 = r2 | 48
            goto L_0x004e
        L_0x003e:
            r3 = r12 & 112(0x70, float:1.57E-43)
            if (r3 != 0) goto L_0x004e
            boolean r3 = r13.changed((java.lang.Object) r10)
            if (r3 == 0) goto L_0x004b
            r3 = 32
            goto L_0x004d
        L_0x004b:
            r3 = 16
        L_0x004d:
            r2 = r2 | r3
        L_0x004e:
            r3 = r29 & 4
            if (r3 == 0) goto L_0x0055
            r2 = r2 | 384(0x180, float:5.38E-43)
            goto L_0x0065
        L_0x0055:
            r3 = r12 & 896(0x380, float:1.256E-42)
            if (r3 != 0) goto L_0x0065
            boolean r3 = r13.changed((java.lang.Object) r11)
            if (r3 == 0) goto L_0x0062
            r3 = 256(0x100, float:3.59E-43)
            goto L_0x0064
        L_0x0062:
            r3 = 128(0x80, float:1.794E-43)
        L_0x0064:
            r2 = r2 | r3
        L_0x0065:
            r3 = r29 & 8
            if (r3 == 0) goto L_0x006c
            r2 = r2 | 3072(0xc00, float:4.305E-42)
            goto L_0x007f
        L_0x006c:
            r4 = r12 & 7168(0x1c00, float:1.0045E-41)
            if (r4 != 0) goto L_0x007f
            r4 = r23
            boolean r5 = r13.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x007b
            r5 = 2048(0x800, float:2.87E-42)
            goto L_0x007d
        L_0x007b:
            r5 = 1024(0x400, float:1.435E-42)
        L_0x007d:
            r2 = r2 | r5
            goto L_0x0081
        L_0x007f:
            r4 = r23
        L_0x0081:
            r5 = r29 & 16
            r6 = 57344(0xe000, float:8.0356E-41)
            if (r5 == 0) goto L_0x008b
            r2 = r2 | 24576(0x6000, float:3.4438E-41)
            goto L_0x009e
        L_0x008b:
            r7 = r12 & r6
            if (r7 != 0) goto L_0x009e
            r7 = r24
            boolean r8 = r13.changed((java.lang.Object) r7)
            if (r8 == 0) goto L_0x009a
            r8 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009c
        L_0x009a:
            r8 = 8192(0x2000, float:1.14794E-41)
        L_0x009c:
            r2 = r2 | r8
            goto L_0x00a0
        L_0x009e:
            r7 = r24
        L_0x00a0:
            r8 = r29 & 32
            r9 = 458752(0x70000, float:6.42848E-40)
            if (r8 == 0) goto L_0x00aa
            r14 = 196608(0x30000, float:2.75506E-40)
            r2 = r2 | r14
            goto L_0x00bd
        L_0x00aa:
            r14 = r12 & r9
            if (r14 != 0) goto L_0x00bd
            r14 = r25
            boolean r15 = r13.changed((java.lang.Object) r14)
            if (r15 == 0) goto L_0x00b9
            r15 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00bb
        L_0x00b9:
            r15 = 65536(0x10000, float:9.18355E-41)
        L_0x00bb:
            r2 = r2 | r15
            goto L_0x00bf
        L_0x00bd:
            r14 = r25
        L_0x00bf:
            r15 = r29 & 64
            r16 = 3670016(0x380000, float:5.142788E-39)
            if (r15 == 0) goto L_0x00cc
            r17 = 1572864(0x180000, float:2.204052E-39)
            r2 = r2 | r17
            r9 = r26
            goto L_0x00df
        L_0x00cc:
            r17 = r12 & r16
            r9 = r26
            if (r17 != 0) goto L_0x00df
            boolean r17 = r13.changed((java.lang.Object) r9)
            if (r17 == 0) goto L_0x00db
            r17 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00dd
        L_0x00db:
            r17 = 524288(0x80000, float:7.34684E-40)
        L_0x00dd:
            r2 = r2 | r17
        L_0x00df:
            r17 = 2995931(0x2db6db, float:4.198194E-39)
            r17 = r2 & r17
            r18 = 599186(0x92492, float:8.39638E-40)
            r17 = r17 ^ r18
            if (r17 != 0) goto L_0x00f9
            boolean r17 = r13.getSkipping()
            if (r17 != 0) goto L_0x00f2
            goto L_0x00f9
        L_0x00f2:
            r13.skipToGroupEnd()
            r5 = r7
            r7 = r9
            r6 = r14
            goto L_0x014a
        L_0x00f9:
            if (r0 == 0) goto L_0x0100
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            r17 = r0
            goto L_0x0102
        L_0x0100:
            r17 = r1
        L_0x0102:
            r0 = 0
            if (r3 == 0) goto L_0x0108
            r18 = r0
            goto L_0x010a
        L_0x0108:
            r18 = r4
        L_0x010a:
            if (r5 == 0) goto L_0x010f
            r19 = r0
            goto L_0x0111
        L_0x010f:
            r19 = r7
        L_0x0111:
            if (r8 == 0) goto L_0x0114
            r14 = r0
        L_0x0114:
            if (r15 == 0) goto L_0x011a
            java.lang.Boolean r0 = java.lang.Boolean.TRUE
            r15 = r0
            goto L_0x011b
        L_0x011a:
            r15 = r9
        L_0x011b:
            r0 = r2 & 14
            r1 = r2 & 112(0x70, float:1.57E-43)
            r0 = r0 | r1
            r1 = r2 & 896(0x380, float:1.256E-42)
            r0 = r0 | r1
            r1 = r2 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r1
            r1 = r2 & r6
            r0 = r0 | r1
            r1 = 458752(0x70000, float:6.42848E-40)
            r1 = r1 & r2
            r0 = r0 | r1
            r1 = r2 & r16
            r8 = r0 | r1
            r9 = 0
            r0 = r17
            r1 = r21
            r2 = r22
            r3 = r18
            r4 = r19
            r5 = r14
            r6 = r15
            r7 = r13
            com.designsystem.ds_alert.DSAlertComposablesKt.AlertSurface(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9)
            r6 = r14
            r7 = r15
            r1 = r17
            r4 = r18
            r5 = r19
        L_0x014a:
            androidx.compose.runtime.ScopeUpdateScope r13 = r13.endRestartGroup()
            if (r13 != 0) goto L_0x0151
            goto L_0x0162
        L_0x0151:
            com.designsystem.ds_alert.DSAlertKt$DSAlert$1 r14 = new com.designsystem.ds_alert.DSAlertKt$DSAlert$1
            r0 = r14
            r2 = r21
            r3 = r22
            r8 = r28
            r9 = r29
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            r13.updateScope(r14)
        L_0x0162:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.designsystem.ds_alert.DSAlertKt.DSAlert(androidx.compose.ui.Modifier, java.lang.String, com.designsystem.ds_alert.DSAlertType, java.lang.String, com.designsystem.ds_alert.DSAlertActionButtonModel, com.designsystem.ds_icon_button.DSIconButtonModel, java.lang.Boolean, androidx.compose.runtime.Composer, int, int):void");
    }
}
