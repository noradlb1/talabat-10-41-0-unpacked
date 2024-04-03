package com.designsystem.ds_switch;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aC\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\bH\u0007¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"DSSwitch", "", "modifier", "Landroidx/compose/ui/Modifier;", "isChecked", "", "isEnabled", "onCheckedChange", "Lkotlin/Function1;", "(Landroidx/compose/ui/Modifier;ZZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "marshmallow_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class DSSwitchKt {
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:66:? A[RETURN, SYNTHETIC] */
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void DSSwitch(@org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r16, boolean r17, boolean r18, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> r19, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r20, int r21, int r22) {
        /*
            r5 = r21
            r0 = 1609746849(0x5ff2c9a1, float:3.4989382E19)
            r1 = r20
            androidx.compose.runtime.Composer r0 = r1.startRestartGroup(r0)
            r1 = r22 & 1
            if (r1 == 0) goto L_0x0015
            r2 = r5 | 6
            r3 = r2
            r2 = r16
            goto L_0x0029
        L_0x0015:
            r2 = r5 & 14
            if (r2 != 0) goto L_0x0026
            r2 = r16
            boolean r3 = r0.changed((java.lang.Object) r2)
            if (r3 == 0) goto L_0x0023
            r3 = 4
            goto L_0x0024
        L_0x0023:
            r3 = 2
        L_0x0024:
            r3 = r3 | r5
            goto L_0x0029
        L_0x0026:
            r2 = r16
            r3 = r5
        L_0x0029:
            r4 = r22 & 2
            if (r4 == 0) goto L_0x0030
            r3 = r3 | 48
            goto L_0x0043
        L_0x0030:
            r6 = r5 & 112(0x70, float:1.57E-43)
            if (r6 != 0) goto L_0x0043
            r6 = r17
            boolean r7 = r0.changed((boolean) r6)
            if (r7 == 0) goto L_0x003f
            r7 = 32
            goto L_0x0041
        L_0x003f:
            r7 = 16
        L_0x0041:
            r3 = r3 | r7
            goto L_0x0045
        L_0x0043:
            r6 = r17
        L_0x0045:
            r7 = r22 & 4
            if (r7 == 0) goto L_0x004c
            r3 = r3 | 384(0x180, float:5.38E-43)
            goto L_0x005f
        L_0x004c:
            r8 = r5 & 896(0x380, float:1.256E-42)
            if (r8 != 0) goto L_0x005f
            r8 = r18
            boolean r9 = r0.changed((boolean) r8)
            if (r9 == 0) goto L_0x005b
            r9 = 256(0x100, float:3.59E-43)
            goto L_0x005d
        L_0x005b:
            r9 = 128(0x80, float:1.794E-43)
        L_0x005d:
            r3 = r3 | r9
            goto L_0x0061
        L_0x005f:
            r8 = r18
        L_0x0061:
            r9 = r22 & 8
            if (r9 == 0) goto L_0x0068
            r3 = r3 | 3072(0xc00, float:4.305E-42)
            goto L_0x007b
        L_0x0068:
            r10 = r5 & 7168(0x1c00, float:1.0045E-41)
            if (r10 != 0) goto L_0x007b
            r10 = r19
            boolean r11 = r0.changed((java.lang.Object) r10)
            if (r11 == 0) goto L_0x0077
            r11 = 2048(0x800, float:2.87E-42)
            goto L_0x0079
        L_0x0077:
            r11 = 1024(0x400, float:1.435E-42)
        L_0x0079:
            r3 = r3 | r11
            goto L_0x007d
        L_0x007b:
            r10 = r19
        L_0x007d:
            r15 = r3
            r3 = r15 & 5851(0x16db, float:8.199E-42)
            r3 = r3 ^ 1170(0x492, float:1.64E-42)
            if (r3 != 0) goto L_0x0093
            boolean r3 = r0.getSkipping()
            if (r3 != 0) goto L_0x008b
            goto L_0x0093
        L_0x008b:
            r0.skipToGroupEnd()
            r1 = r2
            r2 = r6
            r3 = r8
            r4 = r10
            goto L_0x00bd
        L_0x0093:
            if (r1 == 0) goto L_0x0098
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            goto L_0x0099
        L_0x0098:
            r1 = r2
        L_0x0099:
            if (r4 == 0) goto L_0x009d
            r2 = 0
            goto L_0x009e
        L_0x009d:
            r2 = r6
        L_0x009e:
            r3 = 1
            if (r7 == 0) goto L_0x00a2
            r8 = r3
        L_0x00a2:
            if (r9 == 0) goto L_0x00a6
            r4 = 0
            goto L_0x00a7
        L_0x00a6:
            r4 = r10
        L_0x00a7:
            com.designsystem.ds_switch.DSSwitchKt$DSSwitch$1 r6 = new com.designsystem.ds_switch.DSSwitchKt$DSSwitch$1
            r10 = r6
            r11 = r2
            r12 = r4
            r13 = r1
            r14 = r8
            r10.<init>(r11, r12, r13, r14, r15)
            r7 = -819896099(0xffffffffcf2160dd, float:-2.70747981E9)
            androidx.compose.runtime.internal.ComposableLambda r3 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r0, r7, r3, r6)
            r6 = 6
            com.designsystem.ds_theme.DSThemeKt.DSTheme(r3, r0, r6)
            r3 = r8
        L_0x00bd:
            androidx.compose.runtime.ScopeUpdateScope r7 = r0.endRestartGroup()
            if (r7 != 0) goto L_0x00c4
            goto L_0x00d1
        L_0x00c4:
            com.designsystem.ds_switch.DSSwitchKt$DSSwitch$2 r8 = new com.designsystem.ds_switch.DSSwitchKt$DSSwitch$2
            r0 = r8
            r5 = r21
            r6 = r22
            r0.<init>(r1, r2, r3, r4, r5, r6)
            r7.updateScope(r8)
        L_0x00d1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.designsystem.ds_switch.DSSwitchKt.DSSwitch(androidx.compose.ui.Modifier, boolean, boolean, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }
}
