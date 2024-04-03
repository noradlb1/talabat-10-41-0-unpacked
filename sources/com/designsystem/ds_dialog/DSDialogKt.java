package com.designsystem.ds_dialog;

import kotlin.Metadata;

@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a[\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0007¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, d2 = {"DSDialog", "", "onDismissRequest", "Lkotlin/Function0;", "primaryAction", "Lcom/designsystem/ds_dialog/DSDialogPrimaryAction;", "modifier", "Landroidx/compose/ui/Modifier;", "title", "", "content", "secondaryAction", "Lcom/designsystem/ds_dialog/DSDialogSecondaryAction;", "properties", "Landroidx/compose/ui/window/DialogProperties;", "(Lkotlin/jvm/functions/Function0;Lcom/designsystem/ds_dialog/DSDialogPrimaryAction;Landroidx/compose/ui/Modifier;Ljava/lang/String;Ljava/lang/String;Lcom/designsystem/ds_dialog/DSDialogSecondaryAction;Landroidx/compose/ui/window/DialogProperties;Landroidx/compose/runtime/Composer;II)V", "marshmallow_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class DSDialogKt {
    /* JADX WARNING: Removed duplicated region for block: B:107:0x0176  */
    /* JADX WARNING: Removed duplicated region for block: B:109:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00d5  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x00e8  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x00f1  */
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void DSDialog(@org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function0<kotlin.Unit> r18, @org.jetbrains.annotations.NotNull com.designsystem.ds_dialog.DSDialogPrimaryAction r19, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r20, @org.jetbrains.annotations.Nullable java.lang.String r21, @org.jetbrains.annotations.Nullable java.lang.String r22, @org.jetbrains.annotations.Nullable com.designsystem.ds_dialog.DSDialogSecondaryAction r23, @org.jetbrains.annotations.Nullable androidx.compose.ui.window.DialogProperties r24, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r25, int r26, int r27) {
        /*
            r9 = r18
            r10 = r19
            r11 = r26
            java.lang.String r0 = "onDismissRequest"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "primaryAction"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            r0 = 1358562435(0x50fa0483, float:3.35567974E10)
            r1 = r25
            androidx.compose.runtime.Composer r12 = r1.startRestartGroup(r0)
            r0 = r27 & 1
            if (r0 == 0) goto L_0x0020
            r0 = r11 | 6
            goto L_0x0030
        L_0x0020:
            r0 = r11 & 14
            if (r0 != 0) goto L_0x002f
            boolean r0 = r12.changed((java.lang.Object) r9)
            if (r0 == 0) goto L_0x002c
            r0 = 4
            goto L_0x002d
        L_0x002c:
            r0 = 2
        L_0x002d:
            r0 = r0 | r11
            goto L_0x0030
        L_0x002f:
            r0 = r11
        L_0x0030:
            r1 = r27 & 2
            if (r1 == 0) goto L_0x0037
            r0 = r0 | 48
            goto L_0x0047
        L_0x0037:
            r1 = r11 & 112(0x70, float:1.57E-43)
            if (r1 != 0) goto L_0x0047
            boolean r1 = r12.changed((java.lang.Object) r10)
            if (r1 == 0) goto L_0x0044
            r1 = 32
            goto L_0x0046
        L_0x0044:
            r1 = 16
        L_0x0046:
            r0 = r0 | r1
        L_0x0047:
            r1 = r27 & 4
            if (r1 == 0) goto L_0x004e
            r0 = r0 | 384(0x180, float:5.38E-43)
            goto L_0x0061
        L_0x004e:
            r2 = r11 & 896(0x380, float:1.256E-42)
            if (r2 != 0) goto L_0x0061
            r2 = r20
            boolean r3 = r12.changed((java.lang.Object) r2)
            if (r3 == 0) goto L_0x005d
            r3 = 256(0x100, float:3.59E-43)
            goto L_0x005f
        L_0x005d:
            r3 = 128(0x80, float:1.794E-43)
        L_0x005f:
            r0 = r0 | r3
            goto L_0x0063
        L_0x0061:
            r2 = r20
        L_0x0063:
            r3 = r27 & 8
            if (r3 == 0) goto L_0x006a
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            goto L_0x007d
        L_0x006a:
            r4 = r11 & 7168(0x1c00, float:1.0045E-41)
            if (r4 != 0) goto L_0x007d
            r4 = r21
            boolean r5 = r12.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x0079
            r5 = 2048(0x800, float:2.87E-42)
            goto L_0x007b
        L_0x0079:
            r5 = 1024(0x400, float:1.435E-42)
        L_0x007b:
            r0 = r0 | r5
            goto L_0x007f
        L_0x007d:
            r4 = r21
        L_0x007f:
            r5 = r27 & 16
            if (r5 == 0) goto L_0x0086
            r0 = r0 | 24576(0x6000, float:3.4438E-41)
            goto L_0x009b
        L_0x0086:
            r6 = 57344(0xe000, float:8.0356E-41)
            r6 = r6 & r11
            if (r6 != 0) goto L_0x009b
            r6 = r22
            boolean r7 = r12.changed((java.lang.Object) r6)
            if (r7 == 0) goto L_0x0097
            r7 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0099
        L_0x0097:
            r7 = 8192(0x2000, float:1.14794E-41)
        L_0x0099:
            r0 = r0 | r7
            goto L_0x009d
        L_0x009b:
            r6 = r22
        L_0x009d:
            r7 = r27 & 32
            if (r7 == 0) goto L_0x00a5
            r8 = 196608(0x30000, float:2.75506E-40)
            r0 = r0 | r8
            goto L_0x00b9
        L_0x00a5:
            r8 = 458752(0x70000, float:6.42848E-40)
            r8 = r8 & r11
            if (r8 != 0) goto L_0x00b9
            r8 = r23
            boolean r13 = r12.changed((java.lang.Object) r8)
            if (r13 == 0) goto L_0x00b5
            r13 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b7
        L_0x00b5:
            r13 = 65536(0x10000, float:9.18355E-41)
        L_0x00b7:
            r0 = r0 | r13
            goto L_0x00bb
        L_0x00b9:
            r8 = r23
        L_0x00bb:
            r13 = 3670016(0x380000, float:5.142788E-39)
            r13 = r13 & r11
            if (r13 != 0) goto L_0x00d5
            r13 = r27 & 64
            if (r13 != 0) goto L_0x00cf
            r13 = r24
            boolean r14 = r12.changed((java.lang.Object) r13)
            if (r14 == 0) goto L_0x00d1
            r14 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d3
        L_0x00cf:
            r13 = r24
        L_0x00d1:
            r14 = 524288(0x80000, float:7.34684E-40)
        L_0x00d3:
            r0 = r0 | r14
            goto L_0x00d7
        L_0x00d5:
            r13 = r24
        L_0x00d7:
            r14 = 2995931(0x2db6db, float:4.198194E-39)
            r14 = r14 & r0
            r15 = 599186(0x92492, float:8.39638E-40)
            r14 = r14 ^ r15
            if (r14 != 0) goto L_0x00f1
            boolean r14 = r12.getSkipping()
            if (r14 != 0) goto L_0x00e8
            goto L_0x00f1
        L_0x00e8:
            r12.skipToGroupEnd()
            r3 = r2
            r5 = r6
            r6 = r8
            r7 = r13
            goto L_0x016f
        L_0x00f1:
            r14 = r11 & 1
            r15 = -3670017(0xffffffffffc7ffff, float:NaN)
            if (r14 == 0) goto L_0x0110
            boolean r14 = r12.getDefaultsInvalid()
            if (r14 == 0) goto L_0x00ff
            goto L_0x0110
        L_0x00ff:
            r12.skipCurrentGroup()
            r1 = r27 & 64
            if (r1 == 0) goto L_0x0107
            r0 = r0 & r15
        L_0x0107:
            r3 = r0
            r14 = r4
            r15 = r6
            r16 = r8
            r17 = r13
            r13 = r2
            goto L_0x014a
        L_0x0110:
            r12.startDefaults()
            if (r1 == 0) goto L_0x0118
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            goto L_0x0119
        L_0x0118:
            r1 = r2
        L_0x0119:
            r2 = 0
            if (r3 == 0) goto L_0x011d
            r4 = r2
        L_0x011d:
            if (r5 == 0) goto L_0x0120
            r6 = r2
        L_0x0120:
            if (r7 == 0) goto L_0x0123
            r8 = r2
        L_0x0123:
            r2 = r27 & 64
            if (r2 == 0) goto L_0x013f
            androidx.compose.ui.window.DialogProperties r2 = new androidx.compose.ui.window.DialogProperties
            r3 = 0
            r5 = 0
            r7 = 0
            r13 = 7
            r14 = 0
            r20 = r2
            r21 = r3
            r22 = r5
            r23 = r7
            r24 = r13
            r25 = r14
            r20.<init>((boolean) r21, (boolean) r22, (androidx.compose.ui.window.SecureFlagPolicy) r23, (int) r24, (kotlin.jvm.internal.DefaultConstructorMarker) r25)
            r0 = r0 & r15
            r13 = r2
        L_0x013f:
            r12.endDefaults()
            r3 = r0
            r14 = r4
            r15 = r6
            r16 = r8
            r17 = r13
            r13 = r1
        L_0x014a:
            com.designsystem.ds_dialog.DSDialogKt$DSDialog$1 r8 = new com.designsystem.ds_dialog.DSDialogKt$DSDialog$1
            r0 = r8
            r1 = r18
            r2 = r17
            r4 = r13
            r5 = r14
            r6 = r15
            r7 = r16
            r9 = r8
            r8 = r19
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            r0 = -819892549(0xffffffffcf216ebb, float:-2.70838861E9)
            r1 = 1
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r12, r0, r1, r9)
            r1 = 6
            com.designsystem.ds_theme.DSThemeKt.DSTheme(r0, r12, r1)
            r3 = r13
            r4 = r14
            r5 = r15
            r6 = r16
            r7 = r17
        L_0x016f:
            androidx.compose.runtime.ScopeUpdateScope r12 = r12.endRestartGroup()
            if (r12 != 0) goto L_0x0176
            goto L_0x0187
        L_0x0176:
            com.designsystem.ds_dialog.DSDialogKt$DSDialog$2 r13 = new com.designsystem.ds_dialog.DSDialogKt$DSDialog$2
            r0 = r13
            r1 = r18
            r2 = r19
            r8 = r26
            r9 = r27
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            r12.updateScope(r13)
        L_0x0187:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.designsystem.ds_dialog.DSDialogKt.DSDialog(kotlin.jvm.functions.Function0, com.designsystem.ds_dialog.DSDialogPrimaryAction, androidx.compose.ui.Modifier, java.lang.String, java.lang.String, com.designsystem.ds_dialog.DSDialogSecondaryAction, androidx.compose.ui.window.DialogProperties, androidx.compose.runtime.Composer, int, int):void");
    }
}
