package com.designsystem.ds_stepper;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a}\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000b2\b\b\u0002\u0010\u000f\u001a\u00020\u000b2\b\b\u0002\u0010\u0010\u001a\u00020\u000bH\u0007¢\u0006\u0002\u0010\u0011¨\u0006\u0012"}, d2 = {"DSCollapsibleQuantityStepper", "", "modifier", "Landroidx/compose/ui/Modifier;", "min", "", "max", "initialValue", "onValueChanged", "Lkotlin/Function1;", "shouldShowBinIcon", "", "alignment", "Landroidx/compose/ui/Alignment$Horizontal;", "forceMM2", "isLoading", "isEnabled", "(Landroidx/compose/ui/Modifier;IIILkotlin/jvm/functions/Function1;ZLandroidx/compose/ui/Alignment$Horizontal;ZZZLandroidx/compose/runtime/Composer;II)V", "marshmallow_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class DSCollapsibleQuantityStepperKt {
    /* JADX WARNING: Removed duplicated region for block: B:100:0x0125  */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x014f  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x0161  */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x01c0  */
    /* JADX WARNING: Removed duplicated region for block: B:141:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00de  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x00e5  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x00fe  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0105  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x011e  */
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void DSCollapsibleQuantityStepper(@org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r25, int r26, int r27, int r28, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> r29, boolean r30, @org.jetbrains.annotations.Nullable androidx.compose.ui.Alignment.Horizontal r31, boolean r32, boolean r33, boolean r34, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r35, int r36, int r37) {
        /*
            r11 = r36
            r12 = r37
            r0 = -2102465900(0xffffffff82aeea94, float:-2.5701643E-37)
            r1 = r35
            androidx.compose.runtime.Composer r0 = r1.startRestartGroup(r0)
            r1 = r12 & 1
            if (r1 == 0) goto L_0x0017
            r2 = r11 | 6
            r3 = r2
            r2 = r25
            goto L_0x002b
        L_0x0017:
            r2 = r11 & 14
            if (r2 != 0) goto L_0x0028
            r2 = r25
            boolean r3 = r0.changed((java.lang.Object) r2)
            if (r3 == 0) goto L_0x0025
            r3 = 4
            goto L_0x0026
        L_0x0025:
            r3 = 2
        L_0x0026:
            r3 = r3 | r11
            goto L_0x002b
        L_0x0028:
            r2 = r25
            r3 = r11
        L_0x002b:
            r4 = r12 & 2
            if (r4 == 0) goto L_0x0032
            r3 = r3 | 48
            goto L_0x0045
        L_0x0032:
            r5 = r11 & 112(0x70, float:1.57E-43)
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
            r6 = r12 & 4
            if (r6 == 0) goto L_0x004e
            r3 = r3 | 384(0x180, float:5.38E-43)
            goto L_0x0061
        L_0x004e:
            r7 = r11 & 896(0x380, float:1.256E-42)
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
            r8 = r12 & 8
            if (r8 == 0) goto L_0x006a
            r3 = r3 | 3072(0xc00, float:4.305E-42)
            goto L_0x007d
        L_0x006a:
            r8 = r11 & 7168(0x1c00, float:1.0045E-41)
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
            r9 = r12 & 16
            if (r9 == 0) goto L_0x0086
            r3 = r3 | 24576(0x6000, float:3.4438E-41)
            goto L_0x009b
        L_0x0086:
            r10 = 57344(0xe000, float:8.0356E-41)
            r10 = r10 & r11
            if (r10 != 0) goto L_0x009b
            r10 = r29
            boolean r13 = r0.changed((java.lang.Object) r10)
            if (r13 == 0) goto L_0x0097
            r13 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0099
        L_0x0097:
            r13 = 8192(0x2000, float:1.14794E-41)
        L_0x0099:
            r3 = r3 | r13
            goto L_0x009d
        L_0x009b:
            r10 = r29
        L_0x009d:
            r13 = r12 & 32
            if (r13 == 0) goto L_0x00a5
            r14 = 196608(0x30000, float:2.75506E-40)
            r3 = r3 | r14
            goto L_0x00b9
        L_0x00a5:
            r14 = 458752(0x70000, float:6.42848E-40)
            r14 = r14 & r11
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
            r15 = r12 & 64
            if (r15 == 0) goto L_0x00c3
            r15 = 1572864(0x180000, float:2.204052E-39)
            r3 = r3 | r15
            goto L_0x00d8
        L_0x00c3:
            r15 = 3670016(0x380000, float:5.142788E-39)
            r15 = r15 & r11
            if (r15 != 0) goto L_0x00d8
            r15 = r31
            boolean r16 = r0.changed((java.lang.Object) r15)
            if (r16 == 0) goto L_0x00d3
            r16 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d5
        L_0x00d3:
            r16 = 524288(0x80000, float:7.34684E-40)
        L_0x00d5:
            r3 = r3 | r16
            goto L_0x00da
        L_0x00d8:
            r15 = r31
        L_0x00da:
            r2 = r12 & 128(0x80, float:1.794E-43)
            if (r2 == 0) goto L_0x00e5
            r16 = 12582912(0xc00000, float:1.7632415E-38)
            r3 = r3 | r16
            r5 = r32
            goto L_0x00fa
        L_0x00e5:
            r16 = 29360128(0x1c00000, float:7.052966E-38)
            r16 = r11 & r16
            r5 = r32
            if (r16 != 0) goto L_0x00fa
            boolean r16 = r0.changed((boolean) r5)
            if (r16 == 0) goto L_0x00f6
            r16 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00f8
        L_0x00f6:
            r16 = 4194304(0x400000, float:5.877472E-39)
        L_0x00f8:
            r3 = r3 | r16
        L_0x00fa:
            r5 = r12 & 256(0x100, float:3.59E-43)
            if (r5 == 0) goto L_0x0105
            r16 = 100663296(0x6000000, float:2.4074124E-35)
            r3 = r3 | r16
            r7 = r33
            goto L_0x011a
        L_0x0105:
            r16 = 234881024(0xe000000, float:1.5777218E-30)
            r16 = r11 & r16
            r7 = r33
            if (r16 != 0) goto L_0x011a
            boolean r16 = r0.changed((boolean) r7)
            if (r16 == 0) goto L_0x0116
            r16 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0118
        L_0x0116:
            r16 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0118:
            r3 = r3 | r16
        L_0x011a:
            r7 = r12 & 512(0x200, float:7.175E-43)
            if (r7 == 0) goto L_0x0125
            r16 = 805306368(0x30000000, float:4.656613E-10)
            r3 = r3 | r16
            r8 = r34
            goto L_0x013a
        L_0x0125:
            r16 = 1879048192(0x70000000, float:1.58456325E29)
            r16 = r11 & r16
            r8 = r34
            if (r16 != 0) goto L_0x013a
            boolean r16 = r0.changed((boolean) r8)
            if (r16 == 0) goto L_0x0136
            r16 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0138
        L_0x0136:
            r16 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0138:
            r3 = r3 | r16
        L_0x013a:
            r24 = r3
            r3 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r3 = r24 & r3
            r16 = 306783378(0x12492492, float:6.3469493E-28)
            r3 = r3 ^ r16
            if (r3 != 0) goto L_0x0161
            boolean r3 = r0.getSkipping()
            if (r3 != 0) goto L_0x014f
            goto L_0x0161
        L_0x014f:
            r0.skipToGroupEnd()
            r1 = r25
            r2 = r26
            r3 = r27
            r9 = r33
            r5 = r10
            r6 = r14
            r10 = r8
            r8 = r32
            goto L_0x01b9
        L_0x0161:
            if (r1 == 0) goto L_0x0166
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            goto L_0x0168
        L_0x0166:
            r1 = r25
        L_0x0168:
            r3 = 0
            if (r4 == 0) goto L_0x016d
            r4 = r3
            goto L_0x016f
        L_0x016d:
            r4 = r26
        L_0x016f:
            if (r6 == 0) goto L_0x0174
            r6 = 99
            goto L_0x0176
        L_0x0174:
            r6 = r27
        L_0x0176:
            if (r9 == 0) goto L_0x017a
            r9 = 0
            goto L_0x017b
        L_0x017a:
            r9 = r10
        L_0x017b:
            if (r13 == 0) goto L_0x017f
            r10 = r3
            goto L_0x0180
        L_0x017f:
            r10 = r14
        L_0x0180:
            if (r2 == 0) goto L_0x0184
            r2 = r3
            goto L_0x0186
        L_0x0184:
            r2 = r32
        L_0x0186:
            if (r5 == 0) goto L_0x0189
            goto L_0x018b
        L_0x0189:
            r3 = r33
        L_0x018b:
            r5 = 1
            if (r7 == 0) goto L_0x018f
            r8 = r5
        L_0x018f:
            com.designsystem.ds_stepper.DSCollapsibleQuantityStepperKt$DSCollapsibleQuantityStepper$1 r7 = new com.designsystem.ds_stepper.DSCollapsibleQuantityStepperKt$DSCollapsibleQuantityStepper$1
            r13 = r7
            r14 = r2
            r15 = r1
            r16 = r4
            r17 = r6
            r18 = r28
            r19 = r9
            r20 = r10
            r21 = r31
            r22 = r3
            r23 = r8
            r13.<init>(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24)
            r13 = -819892509(0xffffffffcf216ee3, float:-2.70839885E9)
            androidx.compose.runtime.internal.ComposableLambda r5 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r0, r13, r5, r7)
            r7 = 6
            com.designsystem.ds_theme.DSThemeKt.DSTheme(r5, r0, r7)
            r5 = r9
            r9 = r3
            r3 = r6
            r6 = r10
            r10 = r8
            r8 = r2
            r2 = r4
        L_0x01b9:
            androidx.compose.runtime.ScopeUpdateScope r13 = r0.endRestartGroup()
            if (r13 != 0) goto L_0x01c0
            goto L_0x01d1
        L_0x01c0:
            com.designsystem.ds_stepper.DSCollapsibleQuantityStepperKt$DSCollapsibleQuantityStepper$2 r14 = new com.designsystem.ds_stepper.DSCollapsibleQuantityStepperKt$DSCollapsibleQuantityStepper$2
            r0 = r14
            r4 = r28
            r7 = r31
            r11 = r36
            r12 = r37
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            r13.updateScope(r14)
        L_0x01d1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.designsystem.ds_stepper.DSCollapsibleQuantityStepperKt.DSCollapsibleQuantityStepper(androidx.compose.ui.Modifier, int, int, int, kotlin.jvm.functions.Function1, boolean, androidx.compose.ui.Alignment$Horizontal, boolean, boolean, boolean, androidx.compose.runtime.Composer, int, int):void");
    }
}
