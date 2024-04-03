package com.designsystem.ds_stepper;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u001as\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000bH\u0007¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, d2 = {"DSQuantityStepper", "", "modifier", "Landroidx/compose/ui/Modifier;", "min", "", "max", "initialValue", "onValueChanged", "Lkotlin/Function1;", "shouldShowBinIcon", "", "forceMM2", "isLoading", "isEnabled", "(Landroidx/compose/ui/Modifier;IIILkotlin/jvm/functions/Function1;ZZZZLandroidx/compose/runtime/Composer;II)V", "marshmallow_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class DSQuantityStepperKt {
    /* JADX WARNING: Removed duplicated region for block: B:100:0x0130  */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x0142  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x01a4  */
    /* JADX WARNING: Removed duplicated region for block: B:130:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00df  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00e6  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x00ff  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0106  */
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void DSQuantityStepper(@org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r25, int r26, int r27, int r28, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> r29, boolean r30, boolean r31, boolean r32, boolean r33, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r34, int r35, int r36) {
        /*
            r10 = r35
            r11 = r36
            r0 = 1081225960(0x407232e8, float:3.784357)
            r1 = r34
            androidx.compose.runtime.Composer r0 = r1.startRestartGroup(r0)
            r1 = r11 & 1
            if (r1 == 0) goto L_0x0017
            r2 = r10 | 6
            r3 = r2
            r2 = r25
            goto L_0x002b
        L_0x0017:
            r2 = r10 & 14
            if (r2 != 0) goto L_0x0028
            r2 = r25
            boolean r3 = r0.changed((java.lang.Object) r2)
            if (r3 == 0) goto L_0x0025
            r3 = 4
            goto L_0x0026
        L_0x0025:
            r3 = 2
        L_0x0026:
            r3 = r3 | r10
            goto L_0x002b
        L_0x0028:
            r2 = r25
            r3 = r10
        L_0x002b:
            r4 = r11 & 2
            if (r4 == 0) goto L_0x0032
            r3 = r3 | 48
            goto L_0x0045
        L_0x0032:
            r5 = r10 & 112(0x70, float:1.57E-43)
            if (r5 != 0) goto L_0x0045
            r5 = r26
            boolean r6 = r0.changed((int) r5)
            if (r6 == 0) goto L_0x0041
            r6 = 32
            goto L_0x0043
        L_0x0041:
            r6 = 16
        L_0x0043:
            r3 = r3 | r6
            goto L_0x0047
        L_0x0045:
            r5 = r26
        L_0x0047:
            r6 = r11 & 4
            if (r6 == 0) goto L_0x004e
            r3 = r3 | 384(0x180, float:5.38E-43)
            goto L_0x0061
        L_0x004e:
            r7 = r10 & 896(0x380, float:1.256E-42)
            if (r7 != 0) goto L_0x0061
            r7 = r27
            boolean r8 = r0.changed((int) r7)
            if (r8 == 0) goto L_0x005d
            r8 = 256(0x100, float:3.59E-43)
            goto L_0x005f
        L_0x005d:
            r8 = 128(0x80, float:1.794E-43)
        L_0x005f:
            r3 = r3 | r8
            goto L_0x0063
        L_0x0061:
            r7 = r27
        L_0x0063:
            r8 = r11 & 8
            if (r8 == 0) goto L_0x006a
            r3 = r3 | 3072(0xc00, float:4.305E-42)
            goto L_0x007d
        L_0x006a:
            r8 = r10 & 7168(0x1c00, float:1.0045E-41)
            if (r8 != 0) goto L_0x007d
            r8 = r28
            boolean r9 = r0.changed((int) r8)
            if (r9 == 0) goto L_0x0079
            r9 = 2048(0x800, float:2.87E-42)
            goto L_0x007b
        L_0x0079:
            r9 = 1024(0x400, float:1.435E-42)
        L_0x007b:
            r3 = r3 | r9
            goto L_0x007f
        L_0x007d:
            r8 = r28
        L_0x007f:
            r9 = r11 & 16
            if (r9 == 0) goto L_0x0086
            r3 = r3 | 24576(0x6000, float:3.4438E-41)
            goto L_0x009b
        L_0x0086:
            r12 = 57344(0xe000, float:8.0356E-41)
            r12 = r12 & r10
            if (r12 != 0) goto L_0x009b
            r12 = r29
            boolean r13 = r0.changed((java.lang.Object) r12)
            if (r13 == 0) goto L_0x0097
            r13 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0099
        L_0x0097:
            r13 = 8192(0x2000, float:1.14794E-41)
        L_0x0099:
            r3 = r3 | r13
            goto L_0x009d
        L_0x009b:
            r12 = r29
        L_0x009d:
            r13 = r11 & 32
            if (r13 == 0) goto L_0x00a5
            r14 = 196608(0x30000, float:2.75506E-40)
            r3 = r3 | r14
            goto L_0x00b9
        L_0x00a5:
            r14 = 458752(0x70000, float:6.42848E-40)
            r14 = r14 & r10
            if (r14 != 0) goto L_0x00b9
            r14 = r30
            boolean r15 = r0.changed((boolean) r14)
            if (r15 == 0) goto L_0x00b5
            r15 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b7
        L_0x00b5:
            r15 = 65536(0x10000, float:9.18355E-41)
        L_0x00b7:
            r3 = r3 | r15
            goto L_0x00bb
        L_0x00b9:
            r14 = r30
        L_0x00bb:
            r15 = r11 & 64
            if (r15 == 0) goto L_0x00c6
            r16 = 1572864(0x180000, float:2.204052E-39)
            r3 = r3 | r16
            r2 = r31
            goto L_0x00db
        L_0x00c6:
            r16 = 3670016(0x380000, float:5.142788E-39)
            r16 = r10 & r16
            r2 = r31
            if (r16 != 0) goto L_0x00db
            boolean r16 = r0.changed((boolean) r2)
            if (r16 == 0) goto L_0x00d7
            r16 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d9
        L_0x00d7:
            r16 = 524288(0x80000, float:7.34684E-40)
        L_0x00d9:
            r3 = r3 | r16
        L_0x00db:
            r2 = r11 & 128(0x80, float:1.794E-43)
            if (r2 == 0) goto L_0x00e6
            r16 = 12582912(0xc00000, float:1.7632415E-38)
            r3 = r3 | r16
            r5 = r32
            goto L_0x00fb
        L_0x00e6:
            r16 = 29360128(0x1c00000, float:7.052966E-38)
            r16 = r10 & r16
            r5 = r32
            if (r16 != 0) goto L_0x00fb
            boolean r16 = r0.changed((boolean) r5)
            if (r16 == 0) goto L_0x00f7
            r16 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00f9
        L_0x00f7:
            r16 = 4194304(0x400000, float:5.877472E-39)
        L_0x00f9:
            r3 = r3 | r16
        L_0x00fb:
            r5 = r11 & 256(0x100, float:3.59E-43)
            if (r5 == 0) goto L_0x0106
            r16 = 100663296(0x6000000, float:2.4074124E-35)
            r3 = r3 | r16
            r7 = r33
            goto L_0x011b
        L_0x0106:
            r16 = 234881024(0xe000000, float:1.5777218E-30)
            r16 = r10 & r16
            r7 = r33
            if (r16 != 0) goto L_0x011b
            boolean r16 = r0.changed((boolean) r7)
            if (r16 == 0) goto L_0x0117
            r16 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0119
        L_0x0117:
            r16 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0119:
            r3 = r3 | r16
        L_0x011b:
            r22 = r3
            r3 = 191739611(0xb6db6db, float:4.5782105E-32)
            r3 = r22 & r3
            r16 = 38347922(0x2492492, float:1.4777643E-37)
            r3 = r3 ^ r16
            if (r3 != 0) goto L_0x0142
            boolean r3 = r0.getSkipping()
            if (r3 != 0) goto L_0x0130
            goto L_0x0142
        L_0x0130:
            r0.skipToGroupEnd()
            r1 = r25
            r2 = r26
            r3 = r27
            r9 = r32
            r5 = r12
            r6 = r14
            r12 = r7
            r7 = r31
            goto L_0x019d
        L_0x0142:
            if (r1 == 0) goto L_0x0147
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            goto L_0x0149
        L_0x0147:
            r1 = r25
        L_0x0149:
            r3 = 0
            if (r4 == 0) goto L_0x014e
            r4 = r3
            goto L_0x0150
        L_0x014e:
            r4 = r26
        L_0x0150:
            if (r6 == 0) goto L_0x0155
            r6 = 99
            goto L_0x0157
        L_0x0155:
            r6 = r27
        L_0x0157:
            if (r9 == 0) goto L_0x015b
            r9 = 0
            goto L_0x015c
        L_0x015b:
            r9 = r12
        L_0x015c:
            if (r13 == 0) goto L_0x0161
            r23 = r3
            goto L_0x0163
        L_0x0161:
            r23 = r14
        L_0x0163:
            if (r15 == 0) goto L_0x0168
            r24 = r3
            goto L_0x016a
        L_0x0168:
            r24 = r31
        L_0x016a:
            if (r2 == 0) goto L_0x016d
            goto L_0x016f
        L_0x016d:
            r3 = r32
        L_0x016f:
            r2 = 1
            if (r5 == 0) goto L_0x0173
            r7 = r2
        L_0x0173:
            com.designsystem.ds_stepper.DSQuantityStepperKt$DSQuantityStepper$1 r5 = new com.designsystem.ds_stepper.DSQuantityStepperKt$DSQuantityStepper$1
            r12 = r5
            r13 = r24
            r14 = r1
            r15 = r4
            r16 = r6
            r17 = r28
            r18 = r9
            r19 = r23
            r20 = r3
            r21 = r7
            r12.<init>(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
            r12 = -819896220(0xffffffffcf216064, float:-2.70744883E9)
            androidx.compose.runtime.internal.ComposableLambda r2 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r0, r12, r2, r5)
            r5 = 6
            com.designsystem.ds_theme.DSThemeKt.DSTheme(r2, r0, r5)
            r2 = r4
            r12 = r7
            r5 = r9
            r7 = r24
            r9 = r3
            r3 = r6
            r6 = r23
        L_0x019d:
            androidx.compose.runtime.ScopeUpdateScope r13 = r0.endRestartGroup()
            if (r13 != 0) goto L_0x01a4
            goto L_0x01b5
        L_0x01a4:
            com.designsystem.ds_stepper.DSQuantityStepperKt$DSQuantityStepper$2 r14 = new com.designsystem.ds_stepper.DSQuantityStepperKt$DSQuantityStepper$2
            r0 = r14
            r4 = r28
            r8 = r9
            r9 = r12
            r10 = r35
            r11 = r36
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            r13.updateScope(r14)
        L_0x01b5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.designsystem.ds_stepper.DSQuantityStepperKt.DSQuantityStepper(androidx.compose.ui.Modifier, int, int, int, kotlin.jvm.functions.Function1, boolean, boolean, boolean, boolean, androidx.compose.runtime.Composer, int, int):void");
    }
}
