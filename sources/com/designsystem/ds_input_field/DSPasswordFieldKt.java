package com.designsystem.ds_input_field;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0001\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000f\u0010\u0010\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u0011"}, d2 = {"DSPasswordField", "", "modifier", "Landroidx/compose/ui/Modifier;", "text", "", "hint", "helperText", "onTextChange", "Lkotlin/Function1;", "onKeyboardReturnButtonTap", "state", "Lcom/designsystem/ds_input_field/DSInputFieldState;", "imeAction", "Landroidx/compose/ui/text/input/ImeAction;", "DSPasswordField-t0ssOgc", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lcom/designsystem/ds_input_field/DSInputFieldState;ILandroidx/compose/runtime/Composer;II)V", "marshmallow_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class DSPasswordFieldKt {
    /* JADX WARNING: Removed duplicated region for block: B:120:0x0195  */
    /* JADX WARNING: Removed duplicated region for block: B:122:? A[RETURN, SYNTHETIC] */
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
    /* JADX WARNING: Removed duplicated region for block: B:84:0x00fc  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x010e  */
    @androidx.compose.runtime.Composable
    /* renamed from: DSPasswordField-t0ssOgc  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m8376DSPasswordFieldt0ssOgc(@org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r25, @org.jetbrains.annotations.Nullable java.lang.String r26, @org.jetbrains.annotations.Nullable java.lang.String r27, @org.jetbrains.annotations.Nullable java.lang.String r28, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r29, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r30, @org.jetbrains.annotations.Nullable com.designsystem.ds_input_field.DSInputFieldState r31, int r32, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r33, int r34, int r35) {
        /*
            r9 = r34
            r10 = r35
            r0 = 898288(0xdb4f0, float:1.25877E-39)
            r1 = r33
            androidx.compose.runtime.Composer r0 = r1.startRestartGroup(r0)
            r1 = r10 & 1
            if (r1 == 0) goto L_0x0017
            r2 = r9 | 6
            r3 = r2
            r2 = r25
            goto L_0x002b
        L_0x0017:
            r2 = r9 & 14
            if (r2 != 0) goto L_0x0028
            r2 = r25
            boolean r3 = r0.changed((java.lang.Object) r2)
            if (r3 == 0) goto L_0x0025
            r3 = 4
            goto L_0x0026
        L_0x0025:
            r3 = 2
        L_0x0026:
            r3 = r3 | r9
            goto L_0x002b
        L_0x0028:
            r2 = r25
            r3 = r9
        L_0x002b:
            r4 = r10 & 2
            if (r4 == 0) goto L_0x0032
            r3 = r3 | 48
            goto L_0x0045
        L_0x0032:
            r5 = r9 & 112(0x70, float:1.57E-43)
            if (r5 != 0) goto L_0x0045
            r5 = r26
            boolean r6 = r0.changed((java.lang.Object) r5)
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
            r6 = r10 & 4
            if (r6 == 0) goto L_0x004e
            r3 = r3 | 384(0x180, float:5.38E-43)
            goto L_0x0061
        L_0x004e:
            r8 = r9 & 896(0x380, float:1.256E-42)
            if (r8 != 0) goto L_0x0061
            r8 = r27
            boolean r11 = r0.changed((java.lang.Object) r8)
            if (r11 == 0) goto L_0x005d
            r11 = 256(0x100, float:3.59E-43)
            goto L_0x005f
        L_0x005d:
            r11 = 128(0x80, float:1.794E-43)
        L_0x005f:
            r3 = r3 | r11
            goto L_0x0063
        L_0x0061:
            r8 = r27
        L_0x0063:
            r11 = r10 & 8
            if (r11 == 0) goto L_0x006a
            r3 = r3 | 3072(0xc00, float:4.305E-42)
            goto L_0x007d
        L_0x006a:
            r12 = r9 & 7168(0x1c00, float:1.0045E-41)
            if (r12 != 0) goto L_0x007d
            r12 = r28
            boolean r13 = r0.changed((java.lang.Object) r12)
            if (r13 == 0) goto L_0x0079
            r13 = 2048(0x800, float:2.87E-42)
            goto L_0x007b
        L_0x0079:
            r13 = 1024(0x400, float:1.435E-42)
        L_0x007b:
            r3 = r3 | r13
            goto L_0x007f
        L_0x007d:
            r12 = r28
        L_0x007f:
            r13 = r10 & 16
            if (r13 == 0) goto L_0x0086
            r3 = r3 | 24576(0x6000, float:3.4438E-41)
            goto L_0x009b
        L_0x0086:
            r14 = 57344(0xe000, float:8.0356E-41)
            r14 = r14 & r9
            if (r14 != 0) goto L_0x009b
            r14 = r29
            boolean r15 = r0.changed((java.lang.Object) r14)
            if (r15 == 0) goto L_0x0097
            r15 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0099
        L_0x0097:
            r15 = 8192(0x2000, float:1.14794E-41)
        L_0x0099:
            r3 = r3 | r15
            goto L_0x009d
        L_0x009b:
            r14 = r29
        L_0x009d:
            r15 = r10 & 32
            if (r15 == 0) goto L_0x00a8
            r16 = 196608(0x30000, float:2.75506E-40)
            r3 = r3 | r16
            r7 = r30
            goto L_0x00bd
        L_0x00a8:
            r16 = 458752(0x70000, float:6.42848E-40)
            r16 = r9 & r16
            r7 = r30
            if (r16 != 0) goto L_0x00bd
            boolean r16 = r0.changed((java.lang.Object) r7)
            if (r16 == 0) goto L_0x00b9
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00bb
        L_0x00b9:
            r16 = 65536(0x10000, float:9.18355E-41)
        L_0x00bb:
            r3 = r3 | r16
        L_0x00bd:
            r16 = r10 & 64
            if (r16 == 0) goto L_0x00c8
            r17 = 1572864(0x180000, float:2.204052E-39)
            r3 = r3 | r17
            r2 = r31
            goto L_0x00dd
        L_0x00c8:
            r17 = 3670016(0x380000, float:5.142788E-39)
            r17 = r9 & r17
            r2 = r31
            if (r17 != 0) goto L_0x00dd
            boolean r17 = r0.changed((java.lang.Object) r2)
            if (r17 == 0) goto L_0x00d9
            r17 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00db
        L_0x00d9:
            r17 = 524288(0x80000, float:7.34684E-40)
        L_0x00db:
            r3 = r3 | r17
        L_0x00dd:
            r2 = r10 & 128(0x80, float:1.794E-43)
            if (r2 == 0) goto L_0x00e5
            r17 = 4194304(0x400000, float:5.877472E-39)
            r3 = r3 | r17
        L_0x00e5:
            int r5 = ~r10
            r7 = 128(0x80, float:1.794E-43)
            r5 = r5 & r7
            if (r5 != 0) goto L_0x010e
            r5 = 23967451(0x16db6db, float:4.3661218E-38)
            r5 = r5 & r3
            r7 = 4793490(0x492492, float:6.71711E-39)
            r5 = r5 ^ r7
            if (r5 != 0) goto L_0x010e
            boolean r5 = r0.getSkipping()
            if (r5 != 0) goto L_0x00fc
            goto L_0x010e
        L_0x00fc:
            r0.skipToGroupEnd()
            r1 = r25
            r2 = r26
            r6 = r30
            r7 = r31
            r3 = r8
            r4 = r12
            r5 = r14
            r8 = r32
            goto L_0x018e
        L_0x010e:
            r5 = r9 & 1
            r7 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            if (r5 == 0) goto L_0x012f
            boolean r5 = r0.getDefaultsInvalid()
            if (r5 == 0) goto L_0x011c
            goto L_0x012f
        L_0x011c:
            r0.skipCurrentGroup()
            if (r2 == 0) goto L_0x0122
            r3 = r3 & r7
        L_0x0122:
            r1 = r25
            r4 = r26
            r5 = r30
            r6 = r31
            r2 = r32
        L_0x012c:
            r24 = r3
            goto L_0x0165
        L_0x012f:
            r0.startDefaults()
            if (r1 == 0) goto L_0x0137
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            goto L_0x0139
        L_0x0137:
            r1 = r25
        L_0x0139:
            r5 = 0
            if (r4 == 0) goto L_0x013e
            r4 = r5
            goto L_0x0140
        L_0x013e:
            r4 = r26
        L_0x0140:
            if (r6 == 0) goto L_0x0143
            r8 = r5
        L_0x0143:
            if (r11 == 0) goto L_0x0146
            r12 = r5
        L_0x0146:
            if (r13 == 0) goto L_0x0149
            r14 = r5
        L_0x0149:
            if (r15 == 0) goto L_0x014c
            goto L_0x014e
        L_0x014c:
            r5 = r30
        L_0x014e:
            if (r16 == 0) goto L_0x0153
            com.designsystem.ds_input_field.DSInputFieldState r6 = com.designsystem.ds_input_field.DSInputFieldState.Normal
            goto L_0x0155
        L_0x0153:
            r6 = r31
        L_0x0155:
            if (r2 == 0) goto L_0x015f
            androidx.compose.ui.text.input.ImeAction$Companion r2 = androidx.compose.ui.text.input.ImeAction.Companion
            int r2 = r2.m5188getDoneeUduSuo()
            r3 = r3 & r7
            goto L_0x0161
        L_0x015f:
            r2 = r32
        L_0x0161:
            r0.endDefaults()
            goto L_0x012c
        L_0x0165:
            com.designsystem.ds_input_field.DSPasswordFieldKt$DSPasswordField$1 r3 = new com.designsystem.ds_input_field.DSPasswordFieldKt$DSPasswordField$1
            r15 = r3
            r16 = r1
            r17 = r4
            r18 = r8
            r19 = r12
            r20 = r14
            r21 = r5
            r22 = r6
            r23 = r2
            r15.<init>(r16, r17, r18, r19, r20, r21, r22, r23, r24)
            r7 = -819892563(0xffffffffcf216ead, float:-2.70838502E9)
            r11 = 1
            androidx.compose.runtime.internal.ComposableLambda r3 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r0, r7, r11, r3)
            r7 = 6
            com.designsystem.ds_theme.DSThemeKt.DSTheme(r3, r0, r7)
            r7 = r6
            r3 = r8
            r8 = r2
            r2 = r4
            r6 = r5
            r4 = r12
            r5 = r14
        L_0x018e:
            androidx.compose.runtime.ScopeUpdateScope r11 = r0.endRestartGroup()
            if (r11 != 0) goto L_0x0195
            goto L_0x01a2
        L_0x0195:
            com.designsystem.ds_input_field.DSPasswordFieldKt$DSPasswordField$2 r12 = new com.designsystem.ds_input_field.DSPasswordFieldKt$DSPasswordField$2
            r0 = r12
            r9 = r34
            r10 = r35
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            r11.updateScope(r12)
        L_0x01a2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.designsystem.ds_input_field.DSPasswordFieldKt.m8376DSPasswordFieldt0ssOgc(androidx.compose.ui.Modifier, java.lang.String, java.lang.String, java.lang.String, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, com.designsystem.ds_input_field.DSInputFieldState, int, androidx.compose.runtime.Composer, int, int):void");
    }
}
