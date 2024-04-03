package com.designsystem.ds_input_field;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000N\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aç\u0001\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00132\b\b\u0002\u0010\u0014\u001a\u00020\f2\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0010H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001c\u0010\u001d\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u001e"}, d2 = {"DSTextField", "", "modifier", "Landroidx/compose/ui/Modifier;", "text", "", "hint", "helperText", "onTextChange", "Lkotlin/Function1;", "onKeyboardReturnButtonTap", "isEnabled", "", "state", "Lcom/designsystem/ds_input_field/DSInputFieldState;", "leadingIcon", "", "trailingIcon", "onTrailingIconTap", "Lkotlin/Function0;", "trailingIconIsEnabled", "keyboardType", "Landroidx/compose/ui/text/input/KeyboardType;", "imeAction", "Landroidx/compose/ui/text/input/ImeAction;", "formatter", "Landroidx/compose/ui/text/input/VisualTransformation;", "maxNumberOfCharacters", "DSTextField-jAliMPc", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;ZLcom/designsystem/ds_input_field/DSInputFieldState;Ljava/lang/Integer;Ljava/lang/Integer;Lkotlin/jvm/functions/Function0;ZIILandroidx/compose/ui/text/input/VisualTransformation;Ljava/lang/Integer;Landroidx/compose/runtime/Composer;III)V", "marshmallow_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class DSTextFieldKt {
    /* JADX WARNING: Removed duplicated region for block: B:106:0x014d  */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x0152  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x016c  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x016f  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x0188  */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x018e  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x0194  */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x0197  */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x01b6  */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x01b9  */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x01ed  */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x0212  */
    /* JADX WARNING: Removed duplicated region for block: B:223:0x0340  */
    /* JADX WARNING: Removed duplicated region for block: B:225:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00cb  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00f2  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x010b  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0112  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x012b  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0132  */
    @androidx.compose.runtime.Composable
    /* renamed from: DSTextField-jAliMPc  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m8389DSTextFieldjAliMPc(@org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r52, @org.jetbrains.annotations.Nullable java.lang.String r53, @org.jetbrains.annotations.Nullable java.lang.String r54, @org.jetbrains.annotations.Nullable java.lang.String r55, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r56, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r57, boolean r58, @org.jetbrains.annotations.Nullable com.designsystem.ds_input_field.DSInputFieldState r59, @org.jetbrains.annotations.Nullable @androidx.annotation.DrawableRes java.lang.Integer r60, @org.jetbrains.annotations.Nullable @androidx.annotation.DrawableRes java.lang.Integer r61, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function0<kotlin.Unit> r62, boolean r63, int r64, int r65, @org.jetbrains.annotations.Nullable androidx.compose.ui.text.input.VisualTransformation r66, @org.jetbrains.annotations.Nullable java.lang.Integer r67, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r68, int r69, int r70, int r71) {
        /*
            r15 = r69
            r14 = r71
            r0 = -330340319(0xffffffffec4f6821, float:-1.0029575E27)
            r1 = r68
            androidx.compose.runtime.Composer r0 = r1.startRestartGroup(r0)
            r1 = r14 & 1
            if (r1 == 0) goto L_0x0017
            r4 = r15 | 6
            r5 = r4
            r4 = r52
            goto L_0x002b
        L_0x0017:
            r4 = r15 & 14
            if (r4 != 0) goto L_0x0028
            r4 = r52
            boolean r5 = r0.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x0025
            r5 = 4
            goto L_0x0026
        L_0x0025:
            r5 = 2
        L_0x0026:
            r5 = r5 | r15
            goto L_0x002b
        L_0x0028:
            r4 = r52
            r5 = r15
        L_0x002b:
            r6 = r14 & 2
            if (r6 == 0) goto L_0x0032
            r5 = r5 | 48
            goto L_0x0045
        L_0x0032:
            r9 = r15 & 112(0x70, float:1.57E-43)
            if (r9 != 0) goto L_0x0045
            r9 = r53
            boolean r10 = r0.changed((java.lang.Object) r9)
            if (r10 == 0) goto L_0x0041
            r10 = 32
            goto L_0x0043
        L_0x0041:
            r10 = 16
        L_0x0043:
            r5 = r5 | r10
            goto L_0x0047
        L_0x0045:
            r9 = r53
        L_0x0047:
            r10 = r14 & 4
            if (r10 == 0) goto L_0x004e
            r5 = r5 | 384(0x180, float:5.38E-43)
            goto L_0x0061
        L_0x004e:
            r11 = r15 & 896(0x380, float:1.256E-42)
            if (r11 != 0) goto L_0x0061
            r11 = r54
            boolean r12 = r0.changed((java.lang.Object) r11)
            if (r12 == 0) goto L_0x005d
            r12 = 256(0x100, float:3.59E-43)
            goto L_0x005f
        L_0x005d:
            r12 = 128(0x80, float:1.794E-43)
        L_0x005f:
            r5 = r5 | r12
            goto L_0x0063
        L_0x0061:
            r11 = r54
        L_0x0063:
            r12 = r14 & 8
            if (r12 == 0) goto L_0x006a
            r5 = r5 | 3072(0xc00, float:4.305E-42)
            goto L_0x007e
        L_0x006a:
            r13 = r15 & 7168(0x1c00, float:1.0045E-41)
            if (r13 != 0) goto L_0x007e
            r13 = r55
            boolean r16 = r0.changed((java.lang.Object) r13)
            if (r16 == 0) goto L_0x0079
            r16 = 2048(0x800, float:2.87E-42)
            goto L_0x007b
        L_0x0079:
            r16 = 1024(0x400, float:1.435E-42)
        L_0x007b:
            r5 = r5 | r16
            goto L_0x0080
        L_0x007e:
            r13 = r55
        L_0x0080:
            r16 = r14 & 16
            r17 = 57344(0xe000, float:8.0356E-41)
            r18 = 16384(0x4000, float:2.2959E-41)
            r19 = 8192(0x2000, float:1.14794E-41)
            if (r16 == 0) goto L_0x0090
            r5 = r5 | 24576(0x6000, float:3.4438E-41)
            r2 = r56
            goto L_0x00a3
        L_0x0090:
            r20 = r15 & r17
            r2 = r56
            if (r20 != 0) goto L_0x00a3
            boolean r20 = r0.changed((java.lang.Object) r2)
            if (r20 == 0) goto L_0x009f
            r20 = r18
            goto L_0x00a1
        L_0x009f:
            r20 = r19
        L_0x00a1:
            r5 = r5 | r20
        L_0x00a3:
            r20 = r14 & 32
            r21 = 131072(0x20000, float:1.83671E-40)
            r22 = 65536(0x10000, float:9.18355E-41)
            r23 = 196608(0x30000, float:2.75506E-40)
            r24 = 458752(0x70000, float:6.42848E-40)
            if (r20 == 0) goto L_0x00b4
            r5 = r5 | r23
            r3 = r57
            goto L_0x00c7
        L_0x00b4:
            r25 = r15 & r24
            r3 = r57
            if (r25 != 0) goto L_0x00c7
            boolean r26 = r0.changed((java.lang.Object) r3)
            if (r26 == 0) goto L_0x00c3
            r26 = r21
            goto L_0x00c5
        L_0x00c3:
            r26 = r22
        L_0x00c5:
            r5 = r5 | r26
        L_0x00c7:
            r26 = r14 & 64
            if (r26 == 0) goto L_0x00d2
            r27 = 1572864(0x180000, float:2.204052E-39)
            r5 = r5 | r27
            r7 = r58
            goto L_0x00e7
        L_0x00d2:
            r27 = 3670016(0x380000, float:5.142788E-39)
            r27 = r15 & r27
            r7 = r58
            if (r27 != 0) goto L_0x00e7
            boolean r28 = r0.changed((boolean) r7)
            if (r28 == 0) goto L_0x00e3
            r28 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00e5
        L_0x00e3:
            r28 = 524288(0x80000, float:7.34684E-40)
        L_0x00e5:
            r5 = r5 | r28
        L_0x00e7:
            r8 = r14 & 128(0x80, float:1.794E-43)
            if (r8 == 0) goto L_0x00f2
            r29 = 12582912(0xc00000, float:1.7632415E-38)
            r5 = r5 | r29
            r2 = r59
            goto L_0x0107
        L_0x00f2:
            r29 = 29360128(0x1c00000, float:7.052966E-38)
            r29 = r15 & r29
            r2 = r59
            if (r29 != 0) goto L_0x0107
            boolean r29 = r0.changed((java.lang.Object) r2)
            if (r29 == 0) goto L_0x0103
            r29 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0105
        L_0x0103:
            r29 = 4194304(0x400000, float:5.877472E-39)
        L_0x0105:
            r5 = r5 | r29
        L_0x0107:
            r2 = r14 & 256(0x100, float:3.59E-43)
            if (r2 == 0) goto L_0x0112
            r29 = 100663296(0x6000000, float:2.4074124E-35)
            r5 = r5 | r29
            r3 = r60
            goto L_0x0127
        L_0x0112:
            r29 = 234881024(0xe000000, float:1.5777218E-30)
            r29 = r15 & r29
            r3 = r60
            if (r29 != 0) goto L_0x0127
            boolean r29 = r0.changed((java.lang.Object) r3)
            if (r29 == 0) goto L_0x0123
            r29 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0125
        L_0x0123:
            r29 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0125:
            r5 = r5 | r29
        L_0x0127:
            r3 = r14 & 512(0x200, float:7.175E-43)
            if (r3 == 0) goto L_0x0132
            r29 = 805306368(0x30000000, float:4.656613E-10)
            r5 = r5 | r29
            r4 = r61
            goto L_0x0147
        L_0x0132:
            r29 = 1879048192(0x70000000, float:1.58456325E29)
            r29 = r15 & r29
            r4 = r61
            if (r29 != 0) goto L_0x0147
            boolean r29 = r0.changed((java.lang.Object) r4)
            if (r29 == 0) goto L_0x0143
            r29 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0145
        L_0x0143:
            r29 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0145:
            r5 = r5 | r29
        L_0x0147:
            r46 = r5
            r5 = r14 & 1024(0x400, float:1.435E-42)
            if (r5 == 0) goto L_0x0152
            r25 = r70 | 6
            r4 = r62
            goto L_0x0168
        L_0x0152:
            r29 = r70 & 14
            r4 = r62
            if (r29 != 0) goto L_0x0166
            boolean r29 = r0.changed((java.lang.Object) r4)
            if (r29 == 0) goto L_0x0161
            r25 = 4
            goto L_0x0163
        L_0x0161:
            r25 = 2
        L_0x0163:
            r25 = r70 | r25
            goto L_0x0168
        L_0x0166:
            r25 = r70
        L_0x0168:
            r4 = r14 & 2048(0x800, float:2.87E-42)
            if (r4 == 0) goto L_0x016f
            r25 = r25 | 48
            goto L_0x0182
        L_0x016f:
            r29 = r70 & 112(0x70, float:1.57E-43)
            r7 = r63
            if (r29 != 0) goto L_0x0182
            boolean r29 = r0.changed((boolean) r7)
            if (r29 == 0) goto L_0x017e
            r28 = 32
            goto L_0x0180
        L_0x017e:
            r28 = 16
        L_0x0180:
            r25 = r25 | r28
        L_0x0182:
            r7 = r25
            r9 = r14 & 4096(0x1000, float:5.74E-42)
            if (r9 == 0) goto L_0x018a
            r7 = r7 | 128(0x80, float:1.794E-43)
        L_0x018a:
            r11 = r14 & 8192(0x2000, float:1.14794E-41)
            if (r11 == 0) goto L_0x0190
            r7 = r7 | 1024(0x400, float:1.435E-42)
        L_0x0190:
            r13 = r14 & 16384(0x4000, float:2.2959E-41)
            if (r13 == 0) goto L_0x0197
            r7 = r7 | 24576(0x6000, float:3.4438E-41)
            goto L_0x01ab
        L_0x0197:
            r17 = r70 & r17
            if (r17 != 0) goto L_0x01ab
            r17 = r13
            r13 = r66
            boolean r25 = r0.changed((java.lang.Object) r13)
            if (r25 == 0) goto L_0x01a6
            goto L_0x01a8
        L_0x01a6:
            r18 = r19
        L_0x01a8:
            r7 = r7 | r18
            goto L_0x01af
        L_0x01ab:
            r17 = r13
            r13 = r66
        L_0x01af:
            r18 = 32768(0x8000, float:4.5918E-41)
            r18 = r14 & r18
            if (r18 == 0) goto L_0x01b9
            r7 = r7 | r23
            goto L_0x01ca
        L_0x01b9:
            r19 = r70 & r24
            r13 = r67
            if (r19 != 0) goto L_0x01ca
            boolean r19 = r0.changed((java.lang.Object) r13)
            if (r19 == 0) goto L_0x01c6
            goto L_0x01c8
        L_0x01c6:
            r21 = r22
        L_0x01c8:
            r7 = r7 | r21
        L_0x01ca:
            int r13 = ~r14
            r13 = r13 & 12288(0x3000, float:1.7219E-41)
            if (r13 != 0) goto L_0x0212
            r13 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r13 = r46 & r13
            r19 = 306783378(0x12492492, float:6.3469493E-28)
            r13 = r13 ^ r19
            if (r13 != 0) goto L_0x0212
            r13 = 374491(0x5b6db, float:5.24774E-40)
            r13 = r13 & r7
            r19 = 74898(0x12492, float:1.04954E-40)
            r13 = r13 ^ r19
            if (r13 != 0) goto L_0x0212
            boolean r13 = r0.getSkipping()
            if (r13 != 0) goto L_0x01ed
            goto L_0x0212
        L_0x01ed:
            r0.skipToGroupEnd()
            r1 = r52
            r2 = r53
            r3 = r54
            r4 = r55
            r5 = r56
            r6 = r57
            r7 = r58
            r8 = r59
            r9 = r60
            r10 = r61
            r11 = r62
            r12 = r63
            r13 = r64
            r14 = r65
            r17 = r66
            r16 = r67
            goto L_0x0339
        L_0x0212:
            r13 = r15 & 1
            r14 = 1
            if (r13 == 0) goto L_0x0271
            boolean r13 = r0.getDefaultsInvalid()
            if (r13 == 0) goto L_0x021e
            goto L_0x0271
        L_0x021e:
            r0.skipCurrentGroup()
            if (r9 == 0) goto L_0x0225
            r7 = r7 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x0225:
            if (r11 == 0) goto L_0x024d
            r1 = r7 & -7169(0xffffffffffffe3ff, float:NaN)
            r6 = r53
            r10 = r54
            r12 = r55
            r16 = r56
            r19 = r57
            r20 = r58
            r8 = r59
            r2 = r60
            r3 = r61
            r5 = r62
            r4 = r63
            r9 = r64
            r11 = r65
            r17 = r66
            r13 = r67
            r47 = r1
            r1 = r52
            goto L_0x02ec
        L_0x024d:
            r1 = r52
            r6 = r53
            r10 = r54
            r12 = r55
            r16 = r56
            r19 = r57
            r20 = r58
            r8 = r59
            r2 = r60
            r3 = r61
            r5 = r62
            r4 = r63
            r9 = r64
            r11 = r65
            r17 = r66
            r13 = r67
        L_0x026d:
            r47 = r7
            goto L_0x02ec
        L_0x0271:
            r0.startDefaults()
            if (r1 == 0) goto L_0x0279
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            goto L_0x027b
        L_0x0279:
            r1 = r52
        L_0x027b:
            r13 = 0
            if (r6 == 0) goto L_0x0280
            r6 = r13
            goto L_0x0282
        L_0x0280:
            r6 = r53
        L_0x0282:
            if (r10 == 0) goto L_0x0286
            r10 = r13
            goto L_0x0288
        L_0x0286:
            r10 = r54
        L_0x0288:
            if (r12 == 0) goto L_0x028c
            r12 = r13
            goto L_0x028e
        L_0x028c:
            r12 = r55
        L_0x028e:
            if (r16 == 0) goto L_0x0293
            r16 = r13
            goto L_0x0295
        L_0x0293:
            r16 = r56
        L_0x0295:
            if (r20 == 0) goto L_0x029a
            r19 = r13
            goto L_0x029c
        L_0x029a:
            r19 = r57
        L_0x029c:
            if (r26 == 0) goto L_0x02a1
            r20 = r14
            goto L_0x02a3
        L_0x02a1:
            r20 = r58
        L_0x02a3:
            if (r8 == 0) goto L_0x02a8
            com.designsystem.ds_input_field.DSInputFieldState r8 = com.designsystem.ds_input_field.DSInputFieldState.Normal
            goto L_0x02aa
        L_0x02a8:
            r8 = r59
        L_0x02aa:
            if (r2 == 0) goto L_0x02ae
            r2 = r13
            goto L_0x02b0
        L_0x02ae:
            r2 = r60
        L_0x02b0:
            if (r3 == 0) goto L_0x02b4
            r3 = r13
            goto L_0x02b6
        L_0x02b4:
            r3 = r61
        L_0x02b6:
            if (r5 == 0) goto L_0x02ba
            r5 = r13
            goto L_0x02bc
        L_0x02ba:
            r5 = r62
        L_0x02bc:
            if (r4 == 0) goto L_0x02c0
            r4 = 0
            goto L_0x02c2
        L_0x02c0:
            r4 = r63
        L_0x02c2:
            if (r9 == 0) goto L_0x02cd
            androidx.compose.ui.text.input.KeyboardType$Companion r9 = androidx.compose.ui.text.input.KeyboardType.Companion
            int r9 = r9.m5227getTextPjHm6EE()
            r7 = r7 & -897(0xfffffffffffffc7f, float:NaN)
            goto L_0x02cf
        L_0x02cd:
            r9 = r64
        L_0x02cf:
            if (r11 == 0) goto L_0x02da
            androidx.compose.ui.text.input.ImeAction$Companion r11 = androidx.compose.ui.text.input.ImeAction.Companion
            int r11 = r11.m5188getDoneeUduSuo()
            r7 = r7 & -7169(0xffffffffffffe3ff, float:NaN)
            goto L_0x02dc
        L_0x02da:
            r11 = r65
        L_0x02dc:
            if (r17 == 0) goto L_0x02e1
            r17 = r13
            goto L_0x02e3
        L_0x02e1:
            r17 = r66
        L_0x02e3:
            if (r18 == 0) goto L_0x02e6
            goto L_0x02e8
        L_0x02e6:
            r13 = r67
        L_0x02e8:
            r0.endDefaults()
            goto L_0x026d
        L_0x02ec:
            com.designsystem.ds_input_field.DSTextFieldKt$DSTextField$1 r7 = new com.designsystem.ds_input_field.DSTextFieldKt$DSTextField$1
            r29 = r7
            r30 = r1
            r31 = r6
            r32 = r10
            r33 = r12
            r34 = r16
            r35 = r19
            r36 = r20
            r37 = r8
            r38 = r2
            r39 = r3
            r40 = r5
            r41 = r4
            r42 = r9
            r43 = r11
            r44 = r17
            r45 = r13
            r29.<init>(r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47)
            r52 = r1
            r1 = -819893480(0xffffffffcf216b18, float:-2.70815027E9)
            androidx.compose.runtime.internal.ComposableLambda r1 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r0, r1, r14, r7)
            r7 = 6
            com.designsystem.ds_theme.DSThemeKt.DSTheme(r1, r0, r7)
            r1 = r52
            r14 = r11
            r7 = r20
            r11 = r5
            r5 = r16
            r16 = r13
            r13 = r9
            r9 = r2
            r2 = r6
            r6 = r19
            r50 = r10
            r10 = r3
            r3 = r50
            r51 = r12
            r12 = r4
            r4 = r51
        L_0x0339:
            androidx.compose.runtime.ScopeUpdateScope r0 = r0.endRestartGroup()
            if (r0 != 0) goto L_0x0340
            goto L_0x0359
        L_0x0340:
            com.designsystem.ds_input_field.DSTextFieldKt$DSTextField$2 r15 = new com.designsystem.ds_input_field.DSTextFieldKt$DSTextField$2
            r48 = r0
            r0 = r15
            r49 = r15
            r15 = r17
            r17 = r69
            r18 = r70
            r19 = r71
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
            r0 = r48
            r1 = r49
            r0.updateScope(r1)
        L_0x0359:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.designsystem.ds_input_field.DSTextFieldKt.m8389DSTextFieldjAliMPc(androidx.compose.ui.Modifier, java.lang.String, java.lang.String, java.lang.String, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, boolean, com.designsystem.ds_input_field.DSInputFieldState, java.lang.Integer, java.lang.Integer, kotlin.jvm.functions.Function0, boolean, int, int, androidx.compose.ui.text.input.VisualTransformation, java.lang.Integer, androidx.compose.runtime.Composer, int, int, int):void");
    }
}
