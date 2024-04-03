package com.designsystem.ds_input_field;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a¥\u0001\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u0014H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0015\u0010\u0016\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u0017"}, d2 = {"DSTextAreaField", "", "modifier", "Landroidx/compose/ui/Modifier;", "text", "", "hint", "helperText", "onTextChange", "Lkotlin/Function1;", "onKeyboardReturnButtonTap", "isEnabled", "", "state", "Lcom/designsystem/ds_input_field/DSInputFieldState;", "maxNumberOfCharacters", "", "keyboardType", "Landroidx/compose/ui/text/input/KeyboardType;", "imeAction", "Landroidx/compose/ui/text/input/ImeAction;", "DSTextAreaField-A1rYqW4", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;ZLcom/designsystem/ds_input_field/DSInputFieldState;IIILandroidx/compose/runtime/Composer;III)V", "marshmallow_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class DSTextAreaFieldKt {
    /* JADX WARNING: Removed duplicated region for block: B:100:0x0129  */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x012c  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x014d  */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x0167  */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x0225  */
    /* JADX WARNING: Removed duplicated region for block: B:159:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00e8  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0101  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0108  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0121  */
    @androidx.compose.runtime.Composable
    /* renamed from: DSTextAreaField-A1rYqW4  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m8384DSTextAreaFieldA1rYqW4(@org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r30, @org.jetbrains.annotations.Nullable java.lang.String r31, @org.jetbrains.annotations.Nullable java.lang.String r32, @org.jetbrains.annotations.Nullable java.lang.String r33, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r34, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r35, boolean r36, @org.jetbrains.annotations.Nullable com.designsystem.ds_input_field.DSInputFieldState r37, int r38, int r39, int r40, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r41, int r42, int r43, int r44) {
        /*
            r12 = r42
            r14 = r44
            r0 = 1293638688(0x4d1b5c20, float:1.62906624E8)
            r1 = r41
            androidx.compose.runtime.Composer r0 = r1.startRestartGroup(r0)
            r1 = r14 & 1
            if (r1 == 0) goto L_0x0017
            r3 = r12 | 6
            r4 = r3
            r3 = r30
            goto L_0x002b
        L_0x0017:
            r3 = r12 & 14
            if (r3 != 0) goto L_0x0028
            r3 = r30
            boolean r4 = r0.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x0025
            r4 = 4
            goto L_0x0026
        L_0x0025:
            r4 = 2
        L_0x0026:
            r4 = r4 | r12
            goto L_0x002b
        L_0x0028:
            r3 = r30
            r4 = r12
        L_0x002b:
            r5 = r14 & 2
            if (r5 == 0) goto L_0x0032
            r4 = r4 | 48
            goto L_0x0045
        L_0x0032:
            r6 = r12 & 112(0x70, float:1.57E-43)
            if (r6 != 0) goto L_0x0045
            r6 = r31
            boolean r7 = r0.changed((java.lang.Object) r6)
            if (r7 == 0) goto L_0x0041
            r7 = 32
            goto L_0x0043
        L_0x0041:
            r7 = 16
        L_0x0043:
            r4 = r4 | r7
            goto L_0x0047
        L_0x0045:
            r6 = r31
        L_0x0047:
            r7 = r14 & 4
            if (r7 == 0) goto L_0x004e
            r4 = r4 | 384(0x180, float:5.38E-43)
            goto L_0x0061
        L_0x004e:
            r8 = r12 & 896(0x380, float:1.256E-42)
            if (r8 != 0) goto L_0x0061
            r8 = r32
            boolean r9 = r0.changed((java.lang.Object) r8)
            if (r9 == 0) goto L_0x005d
            r9 = 256(0x100, float:3.59E-43)
            goto L_0x005f
        L_0x005d:
            r9 = 128(0x80, float:1.794E-43)
        L_0x005f:
            r4 = r4 | r9
            goto L_0x0063
        L_0x0061:
            r8 = r32
        L_0x0063:
            r9 = r14 & 8
            if (r9 == 0) goto L_0x006a
            r4 = r4 | 3072(0xc00, float:4.305E-42)
            goto L_0x007d
        L_0x006a:
            r10 = r12 & 7168(0x1c00, float:1.0045E-41)
            if (r10 != 0) goto L_0x007d
            r10 = r33
            boolean r11 = r0.changed((java.lang.Object) r10)
            if (r11 == 0) goto L_0x0079
            r11 = 2048(0x800, float:2.87E-42)
            goto L_0x007b
        L_0x0079:
            r11 = 1024(0x400, float:1.435E-42)
        L_0x007b:
            r4 = r4 | r11
            goto L_0x007f
        L_0x007d:
            r10 = r33
        L_0x007f:
            r11 = r14 & 16
            if (r11 == 0) goto L_0x0086
            r4 = r4 | 24576(0x6000, float:3.4438E-41)
            goto L_0x009b
        L_0x0086:
            r13 = 57344(0xe000, float:8.0356E-41)
            r13 = r13 & r12
            if (r13 != 0) goto L_0x009b
            r13 = r34
            boolean r15 = r0.changed((java.lang.Object) r13)
            if (r15 == 0) goto L_0x0097
            r15 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0099
        L_0x0097:
            r15 = 8192(0x2000, float:1.14794E-41)
        L_0x0099:
            r4 = r4 | r15
            goto L_0x009d
        L_0x009b:
            r13 = r34
        L_0x009d:
            r15 = r14 & 32
            if (r15 == 0) goto L_0x00a8
            r16 = 196608(0x30000, float:2.75506E-40)
            r4 = r4 | r16
            r2 = r35
            goto L_0x00bd
        L_0x00a8:
            r16 = 458752(0x70000, float:6.42848E-40)
            r16 = r12 & r16
            r2 = r35
            if (r16 != 0) goto L_0x00bd
            boolean r16 = r0.changed((java.lang.Object) r2)
            if (r16 == 0) goto L_0x00b9
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00bb
        L_0x00b9:
            r16 = 65536(0x10000, float:9.18355E-41)
        L_0x00bb:
            r4 = r4 | r16
        L_0x00bd:
            r16 = r14 & 64
            if (r16 == 0) goto L_0x00c8
            r17 = 1572864(0x180000, float:2.204052E-39)
            r4 = r4 | r17
            r2 = r36
            goto L_0x00dd
        L_0x00c8:
            r17 = 3670016(0x380000, float:5.142788E-39)
            r17 = r12 & r17
            r2 = r36
            if (r17 != 0) goto L_0x00dd
            boolean r17 = r0.changed((boolean) r2)
            if (r17 == 0) goto L_0x00d9
            r17 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00db
        L_0x00d9:
            r17 = 524288(0x80000, float:7.34684E-40)
        L_0x00db:
            r4 = r4 | r17
        L_0x00dd:
            r2 = r14 & 128(0x80, float:1.794E-43)
            if (r2 == 0) goto L_0x00e8
            r17 = 12582912(0xc00000, float:1.7632415E-38)
            r4 = r4 | r17
            r3 = r37
            goto L_0x00fd
        L_0x00e8:
            r17 = 29360128(0x1c00000, float:7.052966E-38)
            r17 = r12 & r17
            r3 = r37
            if (r17 != 0) goto L_0x00fd
            boolean r17 = r0.changed((java.lang.Object) r3)
            if (r17 == 0) goto L_0x00f9
            r17 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00fb
        L_0x00f9:
            r17 = 4194304(0x400000, float:5.877472E-39)
        L_0x00fb:
            r4 = r4 | r17
        L_0x00fd:
            r3 = r14 & 256(0x100, float:3.59E-43)
            if (r3 == 0) goto L_0x0108
            r17 = 100663296(0x6000000, float:2.4074124E-35)
            r4 = r4 | r17
            r6 = r38
            goto L_0x011d
        L_0x0108:
            r17 = 234881024(0xe000000, float:1.5777218E-30)
            r17 = r12 & r17
            r6 = r38
            if (r17 != 0) goto L_0x011d
            boolean r17 = r0.changed((int) r6)
            if (r17 == 0) goto L_0x0119
            r17 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x011b
        L_0x0119:
            r17 = 33554432(0x2000000, float:9.403955E-38)
        L_0x011b:
            r4 = r4 | r17
        L_0x011d:
            r6 = r14 & 512(0x200, float:7.175E-43)
            if (r6 == 0) goto L_0x0125
            r17 = 268435456(0x10000000, float:2.5243549E-29)
            r4 = r4 | r17
        L_0x0125:
            r8 = r14 & 1024(0x400, float:1.435E-42)
            if (r8 == 0) goto L_0x012c
            r17 = r43 | 2
            goto L_0x012e
        L_0x012c:
            r17 = r43
        L_0x012e:
            int r10 = ~r14
            r10 = r10 & 1536(0x600, float:2.152E-42)
            if (r10 != 0) goto L_0x0167
            r10 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r10 = r10 & r4
            r18 = 306783378(0x12492492, float:6.3469493E-28)
            r10 = r10 ^ r18
            if (r10 != 0) goto L_0x0167
            r10 = r17 & 11
            r17 = 2
            r10 = r10 ^ 2
            if (r10 != 0) goto L_0x0167
            boolean r10 = r0.getSkipping()
            if (r10 != 0) goto L_0x014d
            goto L_0x0167
        L_0x014d:
            r0.skipToGroupEnd()
            r1 = r30
            r2 = r31
            r3 = r32
            r4 = r33
            r6 = r35
            r7 = r36
            r8 = r37
            r9 = r38
            r10 = r39
            r11 = r40
            r5 = r13
            goto L_0x021e
        L_0x0167:
            r10 = r12 & 1
            r17 = -1879048193(0xffffffff8fffffff, float:-2.5243547E-29)
            r12 = 1
            if (r10 == 0) goto L_0x0195
            boolean r10 = r0.getDefaultsInvalid()
            if (r10 == 0) goto L_0x0176
            goto L_0x0195
        L_0x0176:
            r0.skipCurrentGroup()
            if (r6 == 0) goto L_0x017d
            r4 = r4 & r17
        L_0x017d:
            r1 = r30
            r5 = r31
            r7 = r32
            r9 = r33
            r10 = r35
            r11 = r36
            r2 = r37
            r3 = r38
            r6 = r39
            r8 = r40
        L_0x0191:
            r27 = r4
            goto L_0x01ea
        L_0x0195:
            r0.startDefaults()
            if (r1 == 0) goto L_0x019d
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            goto L_0x019f
        L_0x019d:
            r1 = r30
        L_0x019f:
            r10 = 0
            if (r5 == 0) goto L_0x01a4
            r5 = r10
            goto L_0x01a6
        L_0x01a4:
            r5 = r31
        L_0x01a6:
            if (r7 == 0) goto L_0x01aa
            r7 = r10
            goto L_0x01ac
        L_0x01aa:
            r7 = r32
        L_0x01ac:
            if (r9 == 0) goto L_0x01b0
            r9 = r10
            goto L_0x01b2
        L_0x01b0:
            r9 = r33
        L_0x01b2:
            if (r11 == 0) goto L_0x01b5
            r13 = r10
        L_0x01b5:
            if (r15 == 0) goto L_0x01b8
            goto L_0x01ba
        L_0x01b8:
            r10 = r35
        L_0x01ba:
            if (r16 == 0) goto L_0x01be
            r11 = r12
            goto L_0x01c0
        L_0x01be:
            r11 = r36
        L_0x01c0:
            if (r2 == 0) goto L_0x01c5
            com.designsystem.ds_input_field.DSInputFieldState r2 = com.designsystem.ds_input_field.DSInputFieldState.Normal
            goto L_0x01c7
        L_0x01c5:
            r2 = r37
        L_0x01c7:
            if (r3 == 0) goto L_0x01cc
            r3 = 100
            goto L_0x01ce
        L_0x01cc:
            r3 = r38
        L_0x01ce:
            if (r6 == 0) goto L_0x01d9
            androidx.compose.ui.text.input.KeyboardType$Companion r6 = androidx.compose.ui.text.input.KeyboardType.Companion
            int r6 = r6.m5227getTextPjHm6EE()
            r4 = r4 & r17
            goto L_0x01db
        L_0x01d9:
            r6 = r39
        L_0x01db:
            if (r8 == 0) goto L_0x01e4
            androidx.compose.ui.text.input.ImeAction$Companion r8 = androidx.compose.ui.text.input.ImeAction.Companion
            int r8 = r8.m5188getDoneeUduSuo()
            goto L_0x01e6
        L_0x01e4:
            r8 = r40
        L_0x01e6:
            r0.endDefaults()
            goto L_0x0191
        L_0x01ea:
            com.designsystem.ds_input_field.DSTextAreaFieldKt$DSTextAreaField$1 r4 = new com.designsystem.ds_input_field.DSTextAreaFieldKt$DSTextAreaField$1
            r15 = r4
            r16 = r1
            r17 = r5
            r18 = r7
            r19 = r9
            r20 = r13
            r21 = r10
            r22 = r11
            r23 = r2
            r24 = r3
            r25 = r6
            r26 = r8
            r15.<init>(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27)
            r15 = -819892999(0xffffffffcf216cf9, float:-2.70827341E9)
            androidx.compose.runtime.internal.ComposableLambda r4 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r0, r15, r12, r4)
            r12 = 6
            com.designsystem.ds_theme.DSThemeKt.DSTheme(r4, r0, r12)
            r4 = r9
            r9 = r3
            r3 = r7
            r7 = r11
            r11 = r8
            r8 = r2
            r2 = r5
            r5 = r13
            r29 = r10
            r10 = r6
            r6 = r29
        L_0x021e:
            androidx.compose.runtime.ScopeUpdateScope r15 = r0.endRestartGroup()
            if (r15 != 0) goto L_0x0225
            goto L_0x0238
        L_0x0225:
            com.designsystem.ds_input_field.DSTextAreaFieldKt$DSTextAreaField$2 r13 = new com.designsystem.ds_input_field.DSTextAreaFieldKt$DSTextAreaField$2
            r0 = r13
            r12 = r42
            r28 = r13
            r13 = r43
            r14 = r44
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            r0 = r28
            r15.updateScope(r0)
        L_0x0238:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.designsystem.ds_input_field.DSTextAreaFieldKt.m8384DSTextAreaFieldA1rYqW4(androidx.compose.ui.Modifier, java.lang.String, java.lang.String, java.lang.String, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, boolean, com.designsystem.ds_input_field.DSInputFieldState, int, int, int, androidx.compose.runtime.Composer, int, int, int):void");
    }
}
