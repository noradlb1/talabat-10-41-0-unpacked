package com.designsystem.ds_input_field;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a£\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0015\u0010\u0016\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u0017"}, d2 = {"TextAreaInputField", "", "modifier", "Landroidx/compose/ui/Modifier;", "text", "", "hint", "helperText", "onTextChange", "Lkotlin/Function1;", "onKeyboardReturnButtonTap", "isEnabled", "", "outerState", "Lcom/designsystem/ds_input_field/OuterState;", "maxCharactersCount", "", "keyboardType", "Landroidx/compose/ui/text/input/KeyboardType;", "imeAction", "Landroidx/compose/ui/text/input/ImeAction;", "TextAreaInputField-JIo6yoo", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;ZLcom/designsystem/ds_input_field/OuterState;Ljava/lang/Integer;Landroidx/compose/ui/text/input/KeyboardType;Landroidx/compose/ui/text/input/ImeAction;Landroidx/compose/runtime/Composer;III)V", "marshmallow_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class TextAreaComposablesKt {
    /* JADX WARNING: Removed duplicated region for block: B:101:0x0129  */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x012c  */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x014d  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x015f  */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x0214  */
    /* JADX WARNING: Removed duplicated region for block: B:139:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00b5  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00e9  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00ed  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0103  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0106  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0121  */
    @androidx.compose.runtime.Composable
    /* renamed from: TextAreaInputField-JIo6yoo  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m8469TextAreaInputFieldJIo6yoo(@org.jetbrains.annotations.NotNull androidx.compose.ui.Modifier r36, @org.jetbrains.annotations.Nullable java.lang.String r37, @org.jetbrains.annotations.Nullable java.lang.String r38, @org.jetbrains.annotations.Nullable java.lang.String r39, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r40, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r41, boolean r42, @org.jetbrains.annotations.NotNull com.designsystem.ds_input_field.OuterState r43, @org.jetbrains.annotations.Nullable java.lang.Integer r44, @org.jetbrains.annotations.Nullable androidx.compose.ui.text.input.KeyboardType r45, @org.jetbrains.annotations.Nullable androidx.compose.ui.text.input.ImeAction r46, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r47, int r48, int r49, int r50) {
        /*
            r13 = r36
            r7 = r42
            r6 = r43
            r5 = r48
            r4 = r50
            java.lang.String r0 = "modifier"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.lang.String r0 = "outerState"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            r0 = 1522874278(0x5ac537a6, float:2.77558783E16)
            r1 = r47
            androidx.compose.runtime.Composer r3 = r1.startRestartGroup(r0)
            r0 = r4 & 1
            if (r0 == 0) goto L_0x0024
            r0 = r5 | 6
            goto L_0x0034
        L_0x0024:
            r0 = r5 & 14
            if (r0 != 0) goto L_0x0033
            boolean r0 = r3.changed((java.lang.Object) r13)
            if (r0 == 0) goto L_0x0030
            r0 = 4
            goto L_0x0031
        L_0x0030:
            r0 = 2
        L_0x0031:
            r0 = r0 | r5
            goto L_0x0034
        L_0x0033:
            r0 = r5
        L_0x0034:
            r2 = r4 & 2
            if (r2 == 0) goto L_0x003b
            r0 = r0 | 48
            goto L_0x004e
        L_0x003b:
            r8 = r5 & 112(0x70, float:1.57E-43)
            if (r8 != 0) goto L_0x004e
            r8 = r37
            boolean r9 = r3.changed((java.lang.Object) r8)
            if (r9 == 0) goto L_0x004a
            r9 = 32
            goto L_0x004c
        L_0x004a:
            r9 = 16
        L_0x004c:
            r0 = r0 | r9
            goto L_0x0050
        L_0x004e:
            r8 = r37
        L_0x0050:
            r9 = r4 & 4
            if (r9 == 0) goto L_0x0057
            r0 = r0 | 384(0x180, float:5.38E-43)
            goto L_0x006a
        L_0x0057:
            r10 = r5 & 896(0x380, float:1.256E-42)
            if (r10 != 0) goto L_0x006a
            r10 = r38
            boolean r11 = r3.changed((java.lang.Object) r10)
            if (r11 == 0) goto L_0x0066
            r11 = 256(0x100, float:3.59E-43)
            goto L_0x0068
        L_0x0066:
            r11 = 128(0x80, float:1.794E-43)
        L_0x0068:
            r0 = r0 | r11
            goto L_0x006c
        L_0x006a:
            r10 = r38
        L_0x006c:
            r11 = r4 & 8
            if (r11 == 0) goto L_0x0073
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            goto L_0x0086
        L_0x0073:
            r12 = r5 & 7168(0x1c00, float:1.0045E-41)
            if (r12 != 0) goto L_0x0086
            r12 = r39
            boolean r14 = r3.changed((java.lang.Object) r12)
            if (r14 == 0) goto L_0x0082
            r14 = 2048(0x800, float:2.87E-42)
            goto L_0x0084
        L_0x0082:
            r14 = 1024(0x400, float:1.435E-42)
        L_0x0084:
            r0 = r0 | r14
            goto L_0x0088
        L_0x0086:
            r12 = r39
        L_0x0088:
            r14 = r4 & 16
            r16 = 57344(0xe000, float:8.0356E-41)
            if (r14 == 0) goto L_0x0092
            r0 = r0 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00a6
        L_0x0092:
            r15 = r5 & r16
            if (r15 != 0) goto L_0x00a6
            r15 = r40
            boolean r17 = r3.changed((java.lang.Object) r15)
            if (r17 == 0) goto L_0x00a1
            r17 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a3
        L_0x00a1:
            r17 = 8192(0x2000, float:1.14794E-41)
        L_0x00a3:
            r0 = r0 | r17
            goto L_0x00a8
        L_0x00a6:
            r15 = r40
        L_0x00a8:
            r17 = r4 & 32
            r22 = 458752(0x70000, float:6.42848E-40)
            if (r17 == 0) goto L_0x00b5
            r18 = 196608(0x30000, float:2.75506E-40)
            r0 = r0 | r18
            r1 = r41
            goto L_0x00c8
        L_0x00b5:
            r18 = r5 & r22
            r1 = r41
            if (r18 != 0) goto L_0x00c8
            boolean r18 = r3.changed((java.lang.Object) r1)
            if (r18 == 0) goto L_0x00c4
            r18 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00c6
        L_0x00c4:
            r18 = 65536(0x10000, float:9.18355E-41)
        L_0x00c6:
            r0 = r0 | r18
        L_0x00c8:
            r18 = r4 & 64
            r23 = 3670016(0x380000, float:5.142788E-39)
            if (r18 == 0) goto L_0x00d3
            r18 = 1572864(0x180000, float:2.204052E-39)
        L_0x00d0:
            r0 = r0 | r18
            goto L_0x00e3
        L_0x00d3:
            r18 = r5 & r23
            if (r18 != 0) goto L_0x00e3
            boolean r18 = r3.changed((boolean) r7)
            if (r18 == 0) goto L_0x00e0
            r18 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d0
        L_0x00e0:
            r18 = 524288(0x80000, float:7.34684E-40)
            goto L_0x00d0
        L_0x00e3:
            r1 = r4 & 128(0x80, float:1.794E-43)
            r24 = 29360128(0x1c00000, float:7.052966E-38)
            if (r1 == 0) goto L_0x00ed
            r1 = 12582912(0xc00000, float:1.7632415E-38)
        L_0x00eb:
            r0 = r0 | r1
            goto L_0x00fd
        L_0x00ed:
            r1 = r5 & r24
            if (r1 != 0) goto L_0x00fd
            boolean r1 = r3.changed((java.lang.Object) r6)
            if (r1 == 0) goto L_0x00fa
            r1 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00eb
        L_0x00fa:
            r1 = 4194304(0x400000, float:5.877472E-39)
            goto L_0x00eb
        L_0x00fd:
            r1 = r4 & 256(0x100, float:3.59E-43)
            r25 = 100663296(0x6000000, float:2.4074124E-35)
            if (r1 == 0) goto L_0x0106
            r0 = r0 | r25
            goto L_0x011b
        L_0x0106:
            r1 = 234881024(0xe000000, float:1.5777218E-30)
            r1 = r1 & r5
            if (r1 != 0) goto L_0x011b
            r1 = r44
            boolean r18 = r3.changed((java.lang.Object) r1)
            if (r18 == 0) goto L_0x0116
            r18 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0118
        L_0x0116:
            r18 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0118:
            r0 = r0 | r18
            goto L_0x011d
        L_0x011b:
            r1 = r44
        L_0x011d:
            r1 = r4 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x0125
            r18 = 268435456(0x10000000, float:2.5243549E-29)
            r0 = r0 | r18
        L_0x0125:
            r5 = r4 & 1024(0x400, float:1.435E-42)
            if (r5 == 0) goto L_0x012c
            r18 = r49 | 2
            goto L_0x012e
        L_0x012c:
            r18 = r49
        L_0x012e:
            int r8 = ~r4
            r8 = r8 & 1536(0x600, float:2.152E-42)
            if (r8 != 0) goto L_0x015f
            r8 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r8 = r8 & r0
            r19 = 306783378(0x12492492, float:6.3469493E-28)
            r8 = r8 ^ r19
            if (r8 != 0) goto L_0x015f
            r8 = r18 & 11
            r18 = 2
            r8 = r8 ^ 2
            if (r8 != 0) goto L_0x015f
            boolean r8 = r3.getSkipping()
            if (r8 != 0) goto L_0x014d
            goto L_0x015f
        L_0x014d:
            r3.skipToGroupEnd()
            r2 = r37
            r6 = r41
            r11 = r46
            r34 = r3
            r3 = r10
            r4 = r12
            r5 = r15
            r10 = r45
            goto L_0x020d
        L_0x015f:
            r8 = 0
            if (r2 == 0) goto L_0x0165
            r27 = r8
            goto L_0x0167
        L_0x0165:
            r27 = r37
        L_0x0167:
            if (r9 == 0) goto L_0x016c
            r28 = r8
            goto L_0x016e
        L_0x016c:
            r28 = r10
        L_0x016e:
            if (r11 == 0) goto L_0x0173
            r29 = r8
            goto L_0x0175
        L_0x0173:
            r29 = r12
        L_0x0175:
            if (r14 == 0) goto L_0x017a
            r30 = r8
            goto L_0x017c
        L_0x017a:
            r30 = r15
        L_0x017c:
            if (r17 == 0) goto L_0x0181
            r31 = r8
            goto L_0x0183
        L_0x0181:
            r31 = r41
        L_0x0183:
            if (r1 == 0) goto L_0x0188
            r32 = r8
            goto L_0x018a
        L_0x0188:
            r32 = r45
        L_0x018a:
            if (r5 == 0) goto L_0x018f
            r33 = r8
            goto L_0x0191
        L_0x018f:
            r33 = r46
        L_0x0191:
            com.designsystem.ds_input_field.TextAreaInputField r1 = com.designsystem.ds_input_field.TextAreaInputField.INSTANCE
            float r1 = r1.m8470getTextInputHeightD9Ej5fM()
            com.designsystem.ds_input_field.InputFieldCommon r2 = com.designsystem.ds_input_field.InputFieldCommon.INSTANCE
            float r15 = r2.m8408getMultiLineContainerMinHeightD9Ej5fM()
            r8 = 0
            r9 = 0
            com.designsystem.ds_input_field.TextAreaComposablesKt$TextAreaInputField$1 r2 = new com.designsystem.ds_input_field.TextAreaComposablesKt$TextAreaInputField$1
            r2.<init>(r6, r7, r0)
            r5 = -819895458(0xffffffffcf21635e, float:-2.7076439E9)
            r10 = 1
            androidx.compose.runtime.internal.ComposableLambda r10 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r3, r5, r10, r2)
            r11 = 3
            androidx.compose.ui.unit.Dp r12 = androidx.compose.ui.unit.Dp.m5476boximpl(r1)
            r14 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r1 = r0 & 14
            r1 = r1 | r25
            r2 = r0 & 112(0x70, float:1.57E-43)
            r1 = r1 | r2
            r2 = r0 & 896(0x380, float:1.256E-42)
            r1 = r1 | r2
            r2 = r0 & 7168(0x1c00, float:1.0045E-41)
            r1 = r1 | r2
            r2 = r0 & r16
            r1 = r1 | r2
            r2 = r0 & r22
            r1 = r1 | r2
            r2 = r0 & r23
            r1 = r1 | r2
            r2 = r0 & r24
            r23 = r1 | r2
            int r0 = r0 >> 15
            r0 = r0 & 7168(0x1c00, float:1.0045E-41)
            r1 = 18874422(0x1200036, float:2.938751E-38)
            r24 = r0 | r1
            r25 = 0
            r26 = 3949056(0x3c4200, float:5.533806E-39)
            r0 = r36
            r1 = r27
            r2 = r28
            r34 = r3
            r3 = r29
            r4 = r30
            r5 = r31
            r6 = r42
            r7 = r43
            r13 = r44
            r16 = r32
            r17 = r33
            r22 = r34
            com.designsystem.ds_input_field.InputFieldCommonComposablesKt.m8413InputFieldmytMHeg(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26)
            r2 = r27
            r3 = r28
            r4 = r29
            r5 = r30
            r6 = r31
            r10 = r32
            r11 = r33
        L_0x020d:
            androidx.compose.runtime.ScopeUpdateScope r15 = r34.endRestartGroup()
            if (r15 != 0) goto L_0x0214
            goto L_0x022f
        L_0x0214:
            com.designsystem.ds_input_field.TextAreaComposablesKt$TextAreaInputField$2 r14 = new com.designsystem.ds_input_field.TextAreaComposablesKt$TextAreaInputField$2
            r0 = r14
            r1 = r36
            r7 = r42
            r8 = r43
            r9 = r44
            r12 = r48
            r13 = r49
            r35 = r14
            r14 = r50
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            r0 = r35
            r15.updateScope(r0)
        L_0x022f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.designsystem.ds_input_field.TextAreaComposablesKt.m8469TextAreaInputFieldJIo6yoo(androidx.compose.ui.Modifier, java.lang.String, java.lang.String, java.lang.String, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, boolean, com.designsystem.ds_input_field.OuterState, java.lang.Integer, androidx.compose.ui.text.input.KeyboardType, androidx.compose.ui.text.input.ImeAction, androidx.compose.runtime.Composer, int, int, int):void");
    }
}
