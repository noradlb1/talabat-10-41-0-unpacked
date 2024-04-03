package com.designsystem.ds_input_field;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000N\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aå\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00132\b\b\u0002\u0010\u0014\u001a\u00020\f2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0010H\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001c\u0010\u001d\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u001e"}, d2 = {"TextFieldInputField", "", "modifier", "Landroidx/compose/ui/Modifier;", "text", "", "hint", "helperText", "onTextChange", "Lkotlin/Function1;", "onKeyboardReturnButtonTap", "isEnabled", "", "outerState", "Lcom/designsystem/ds_input_field/OuterState;", "leadingIcon", "", "trailingIcon", "onTrailingIconTap", "Lkotlin/Function0;", "trailingIconIsEnabled", "keyboardType", "Landroidx/compose/ui/text/input/KeyboardType;", "imeAction", "Landroidx/compose/ui/text/input/ImeAction;", "formatter", "Landroidx/compose/ui/text/input/VisualTransformation;", "maxNumberOfCharacters", "TextFieldInputField-qQH3efY", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;ZLcom/designsystem/ds_input_field/OuterState;Ljava/lang/Integer;Ljava/lang/Integer;Lkotlin/jvm/functions/Function0;ZLandroidx/compose/ui/text/input/KeyboardType;Landroidx/compose/ui/text/input/ImeAction;Landroidx/compose/ui/text/input/VisualTransformation;Ljava/lang/Integer;Landroidx/compose/runtime/Composer;III)V", "marshmallow_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class TextFieldComposablesKt {
    /* JADX WARNING: Removed duplicated region for block: B:106:0x0144  */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x0149  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x0163  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x0166  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x017f  */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x0185  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x018b  */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x0190  */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x01a8  */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x01ab  */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x01e0  */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x0201  */
    /* JADX WARNING: Removed duplicated region for block: B:206:0x0311  */
    /* JADX WARNING: Removed duplicated region for block: B:208:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00b9  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00d0  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00d5  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00ef  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0104  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x010b  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0124  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x012b  */
    @androidx.compose.runtime.Composable
    /* renamed from: TextFieldInputField-qQH3efY  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m8471TextFieldInputFieldqQH3efY(@org.jetbrains.annotations.NotNull androidx.compose.ui.Modifier r43, @org.jetbrains.annotations.Nullable java.lang.String r44, @org.jetbrains.annotations.Nullable java.lang.String r45, @org.jetbrains.annotations.Nullable java.lang.String r46, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r47, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r48, boolean r49, @org.jetbrains.annotations.NotNull com.designsystem.ds_input_field.OuterState r50, @org.jetbrains.annotations.Nullable @androidx.annotation.DrawableRes java.lang.Integer r51, @org.jetbrains.annotations.Nullable @androidx.annotation.DrawableRes java.lang.Integer r52, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function0<kotlin.Unit> r53, boolean r54, @org.jetbrains.annotations.Nullable androidx.compose.ui.text.input.KeyboardType r55, @org.jetbrains.annotations.Nullable androidx.compose.ui.text.input.ImeAction r56, @org.jetbrains.annotations.Nullable androidx.compose.ui.text.input.VisualTransformation r57, @org.jetbrains.annotations.Nullable java.lang.Integer r58, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r59, int r60, int r61, int r62) {
        /*
            r15 = r43
            r14 = r49
            r13 = r50
            r7 = r60
            r6 = r62
            java.lang.String r0 = "modifier"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "outerState"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            r0 = -1490649292(0xffffffffa7267f34, float:-2.3106085E-15)
            r1 = r59
            androidx.compose.runtime.Composer r5 = r1.startRestartGroup(r0)
            r0 = r6 & 1
            if (r0 == 0) goto L_0x0024
            r0 = r7 | 6
            goto L_0x0034
        L_0x0024:
            r0 = r7 & 14
            if (r0 != 0) goto L_0x0033
            boolean r0 = r5.changed((java.lang.Object) r15)
            if (r0 == 0) goto L_0x0030
            r0 = 4
            goto L_0x0031
        L_0x0030:
            r0 = 2
        L_0x0031:
            r0 = r0 | r7
            goto L_0x0034
        L_0x0033:
            r0 = r7
        L_0x0034:
            r3 = r6 & 2
            if (r3 == 0) goto L_0x003b
            r0 = r0 | 48
            goto L_0x004e
        L_0x003b:
            r9 = r7 & 112(0x70, float:1.57E-43)
            if (r9 != 0) goto L_0x004e
            r9 = r44
            boolean r10 = r5.changed((java.lang.Object) r9)
            if (r10 == 0) goto L_0x004a
            r10 = 32
            goto L_0x004c
        L_0x004a:
            r10 = 16
        L_0x004c:
            r0 = r0 | r10
            goto L_0x0050
        L_0x004e:
            r9 = r44
        L_0x0050:
            r10 = r6 & 4
            if (r10 == 0) goto L_0x0057
            r0 = r0 | 384(0x180, float:5.38E-43)
            goto L_0x006a
        L_0x0057:
            r11 = r7 & 896(0x380, float:1.256E-42)
            if (r11 != 0) goto L_0x006a
            r11 = r45
            boolean r12 = r5.changed((java.lang.Object) r11)
            if (r12 == 0) goto L_0x0066
            r12 = 256(0x100, float:3.59E-43)
            goto L_0x0068
        L_0x0066:
            r12 = 128(0x80, float:1.794E-43)
        L_0x0068:
            r0 = r0 | r12
            goto L_0x006c
        L_0x006a:
            r11 = r45
        L_0x006c:
            r12 = r6 & 8
            if (r12 == 0) goto L_0x0073
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            goto L_0x0087
        L_0x0073:
            r1 = r7 & 7168(0x1c00, float:1.0045E-41)
            if (r1 != 0) goto L_0x0087
            r1 = r46
            boolean r16 = r5.changed((java.lang.Object) r1)
            if (r16 == 0) goto L_0x0082
            r16 = 2048(0x800, float:2.87E-42)
            goto L_0x0084
        L_0x0082:
            r16 = 1024(0x400, float:1.435E-42)
        L_0x0084:
            r0 = r0 | r16
            goto L_0x0089
        L_0x0087:
            r1 = r46
        L_0x0089:
            r16 = r6 & 16
            r17 = 16384(0x4000, float:2.2959E-41)
            r18 = 8192(0x2000, float:1.14794E-41)
            r22 = 57344(0xe000, float:8.0356E-41)
            if (r16 == 0) goto L_0x0099
            r0 = r0 | 24576(0x6000, float:3.4438E-41)
            r2 = r47
            goto L_0x00ac
        L_0x0099:
            r19 = r7 & r22
            r2 = r47
            if (r19 != 0) goto L_0x00ac
            boolean r20 = r5.changed((java.lang.Object) r2)
            if (r20 == 0) goto L_0x00a8
            r20 = r17
            goto L_0x00aa
        L_0x00a8:
            r20 = r18
        L_0x00aa:
            r0 = r0 | r20
        L_0x00ac:
            r20 = r6 & 32
            r21 = 196608(0x30000, float:2.75506E-40)
            r23 = 458752(0x70000, float:6.42848E-40)
            if (r20 == 0) goto L_0x00b9
            r0 = r0 | r21
            r4 = r48
            goto L_0x00cc
        L_0x00b9:
            r24 = r7 & r23
            r4 = r48
            if (r24 != 0) goto L_0x00cc
            boolean r25 = r5.changed((java.lang.Object) r4)
            if (r25 == 0) goto L_0x00c8
            r25 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00ca
        L_0x00c8:
            r25 = 65536(0x10000, float:9.18355E-41)
        L_0x00ca:
            r0 = r0 | r25
        L_0x00cc:
            r25 = r6 & 64
            if (r25 == 0) goto L_0x00d5
            r25 = 1572864(0x180000, float:2.204052E-39)
        L_0x00d2:
            r0 = r0 | r25
            goto L_0x00e7
        L_0x00d5:
            r25 = 3670016(0x380000, float:5.142788E-39)
            r25 = r7 & r25
            if (r25 != 0) goto L_0x00e7
            boolean r25 = r5.changed((boolean) r14)
            if (r25 == 0) goto L_0x00e4
            r25 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d2
        L_0x00e4:
            r25 = 524288(0x80000, float:7.34684E-40)
            goto L_0x00d2
        L_0x00e7:
            r8 = r6 & 128(0x80, float:1.794E-43)
            if (r8 == 0) goto L_0x00ef
            r8 = 12582912(0xc00000, float:1.7632415E-38)
        L_0x00ed:
            r0 = r0 | r8
            goto L_0x0100
        L_0x00ef:
            r8 = 29360128(0x1c00000, float:7.052966E-38)
            r8 = r8 & r7
            if (r8 != 0) goto L_0x0100
            boolean r8 = r5.changed((java.lang.Object) r13)
            if (r8 == 0) goto L_0x00fd
            r8 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00ed
        L_0x00fd:
            r8 = 4194304(0x400000, float:5.877472E-39)
            goto L_0x00ed
        L_0x0100:
            r8 = r6 & 256(0x100, float:3.59E-43)
            if (r8 == 0) goto L_0x010b
            r26 = 100663296(0x6000000, float:2.4074124E-35)
            r0 = r0 | r26
            r1 = r51
            goto L_0x0120
        L_0x010b:
            r26 = 234881024(0xe000000, float:1.5777218E-30)
            r26 = r7 & r26
            r1 = r51
            if (r26 != 0) goto L_0x0120
            boolean r26 = r5.changed((java.lang.Object) r1)
            if (r26 == 0) goto L_0x011c
            r26 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x011e
        L_0x011c:
            r26 = 33554432(0x2000000, float:9.403955E-38)
        L_0x011e:
            r0 = r0 | r26
        L_0x0120:
            r1 = r6 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x012b
            r26 = 805306368(0x30000000, float:4.656613E-10)
            r0 = r0 | r26
            r2 = r52
            goto L_0x0140
        L_0x012b:
            r26 = 1879048192(0x70000000, float:1.58456325E29)
            r26 = r7 & r26
            r2 = r52
            if (r26 != 0) goto L_0x0140
            boolean r26 = r5.changed((java.lang.Object) r2)
            if (r26 == 0) goto L_0x013c
            r26 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x013e
        L_0x013c:
            r26 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x013e:
            r0 = r0 | r26
        L_0x0140:
            r2 = r6 & 1024(0x400, float:1.435E-42)
            if (r2 == 0) goto L_0x0149
            r19 = r61 | 6
            r4 = r53
            goto L_0x015f
        L_0x0149:
            r26 = r61 & 14
            r4 = r53
            if (r26 != 0) goto L_0x015d
            boolean r26 = r5.changed((java.lang.Object) r4)
            if (r26 == 0) goto L_0x0158
            r19 = 4
            goto L_0x015a
        L_0x0158:
            r19 = 2
        L_0x015a:
            r19 = r61 | r19
            goto L_0x015f
        L_0x015d:
            r19 = r61
        L_0x015f:
            r4 = r6 & 2048(0x800, float:2.87E-42)
            if (r4 == 0) goto L_0x0166
            r19 = r19 | 48
            goto L_0x0179
        L_0x0166:
            r26 = r61 & 112(0x70, float:1.57E-43)
            r7 = r54
            if (r26 != 0) goto L_0x0179
            boolean r26 = r5.changed((boolean) r7)
            if (r26 == 0) goto L_0x0175
            r24 = 32
            goto L_0x0177
        L_0x0175:
            r24 = 16
        L_0x0177:
            r19 = r19 | r24
        L_0x0179:
            r7 = r19
            r9 = r6 & 4096(0x1000, float:5.74E-42)
            if (r9 == 0) goto L_0x0181
            r7 = r7 | 128(0x80, float:1.794E-43)
        L_0x0181:
            r11 = r6 & 8192(0x2000, float:1.14794E-41)
            if (r11 == 0) goto L_0x0187
            r7 = r7 | 1024(0x400, float:1.435E-42)
        L_0x0187:
            r13 = r6 & 16384(0x4000, float:2.2959E-41)
            if (r13 == 0) goto L_0x0190
            r7 = r7 | 24576(0x6000, float:3.4438E-41)
            r15 = r57
            goto L_0x01a1
        L_0x0190:
            r19 = r61 & r22
            r15 = r57
            if (r19 != 0) goto L_0x01a1
            boolean r19 = r5.changed((java.lang.Object) r15)
            if (r19 == 0) goto L_0x019d
            goto L_0x019f
        L_0x019d:
            r17 = r18
        L_0x019f:
            r7 = r7 | r17
        L_0x01a1:
            r17 = 32768(0x8000, float:4.5918E-41)
            r17 = r6 & r17
            if (r17 == 0) goto L_0x01ab
            r7 = r7 | r21
            goto L_0x01be
        L_0x01ab:
            r18 = r61 & r23
            r15 = r58
            if (r18 != 0) goto L_0x01be
            boolean r18 = r5.changed((java.lang.Object) r15)
            if (r18 == 0) goto L_0x01ba
            r18 = 131072(0x20000, float:1.83671E-40)
            goto L_0x01bc
        L_0x01ba:
            r18 = 65536(0x10000, float:9.18355E-41)
        L_0x01bc:
            r7 = r7 | r18
        L_0x01be:
            int r15 = ~r6
            r15 = r15 & 12288(0x3000, float:1.7219E-41)
            if (r15 != 0) goto L_0x0201
            r15 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r15 = r15 & r0
            r18 = 306783378(0x12492492, float:6.3469493E-28)
            r15 = r15 ^ r18
            if (r15 != 0) goto L_0x0201
            r15 = 374491(0x5b6db, float:5.24774E-40)
            r15 = r15 & r7
            r18 = 74898(0x12492, float:1.04954E-40)
            r15 = r15 ^ r18
            if (r15 != 0) goto L_0x0201
            boolean r15 = r5.getSkipping()
            if (r15 != 0) goto L_0x01e0
            goto L_0x0201
        L_0x01e0:
            r5.skipToGroupEnd()
            r2 = r44
            r3 = r45
            r4 = r46
            r6 = r48
            r9 = r51
            r10 = r52
            r11 = r53
            r12 = r54
            r13 = r55
            r14 = r56
            r15 = r57
            r16 = r58
            r40 = r5
            r5 = r47
            goto L_0x030a
        L_0x0201:
            r15 = 0
            if (r3 == 0) goto L_0x0207
            r27 = r15
            goto L_0x0209
        L_0x0207:
            r27 = r44
        L_0x0209:
            if (r10 == 0) goto L_0x020e
            r28 = r15
            goto L_0x0210
        L_0x020e:
            r28 = r45
        L_0x0210:
            if (r12 == 0) goto L_0x0215
            r29 = r15
            goto L_0x0217
        L_0x0215:
            r29 = r46
        L_0x0217:
            if (r16 == 0) goto L_0x021c
            r30 = r15
            goto L_0x021e
        L_0x021c:
            r30 = r47
        L_0x021e:
            if (r20 == 0) goto L_0x0223
            r31 = r15
            goto L_0x0225
        L_0x0223:
            r31 = r48
        L_0x0225:
            if (r8 == 0) goto L_0x0229
            r3 = r15
            goto L_0x022b
        L_0x0229:
            r3 = r51
        L_0x022b:
            if (r1 == 0) goto L_0x0230
            r32 = r15
            goto L_0x0232
        L_0x0230:
            r32 = r52
        L_0x0232:
            if (r2 == 0) goto L_0x0237
            r33 = r15
            goto L_0x0239
        L_0x0237:
            r33 = r53
        L_0x0239:
            if (r4 == 0) goto L_0x023f
            r1 = 0
            r34 = r1
            goto L_0x0241
        L_0x023f:
            r34 = r54
        L_0x0241:
            if (r9 == 0) goto L_0x0246
            r35 = r15
            goto L_0x0248
        L_0x0246:
            r35 = r55
        L_0x0248:
            if (r11 == 0) goto L_0x024d
            r36 = r15
            goto L_0x024f
        L_0x024d:
            r36 = r56
        L_0x024f:
            if (r13 == 0) goto L_0x0254
            r37 = r15
            goto L_0x0256
        L_0x0254:
            r37 = r57
        L_0x0256:
            if (r17 == 0) goto L_0x025b
            r38 = r15
            goto L_0x025d
        L_0x025b:
            r38 = r58
        L_0x025d:
            com.designsystem.ds_input_field.InputFieldCommon r1 = com.designsystem.ds_input_field.InputFieldCommon.INSTANCE
            float r15 = r1.m8409getSingleLineContainerMinHeightD9Ej5fM()
            if (r37 != 0) goto L_0x026e
            androidx.compose.ui.text.input.VisualTransformation$Companion r1 = androidx.compose.ui.text.input.VisualTransformation.Companion
            androidx.compose.ui.text.input.VisualTransformation r1 = r1.getNone()
            r16 = r1
            goto L_0x0270
        L_0x026e:
            r16 = r37
        L_0x0270:
            com.designsystem.ds_input_field.TextFieldComposablesKt$TextFieldInputField$1 r1 = new com.designsystem.ds_input_field.TextFieldComposablesKt$TextFieldInputField$1
            r1.<init>(r3, r14, r0)
            r2 = -819895530(0xffffffffcf216316, float:-2.70762547E9)
            r4 = 1
            androidx.compose.runtime.internal.ComposableLambda r8 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r5, r2, r4, r1)
            r9 = 0
            com.designsystem.ds_input_field.TextFieldComposablesKt$TextFieldInputField$2 r1 = new com.designsystem.ds_input_field.TextFieldComposablesKt$TextFieldInputField$2
            r51 = r1
            r52 = r32
            r53 = r50
            r54 = r49
            r55 = r33
            r56 = r34
            r57 = r0
            r58 = r7
            r51.<init>(r52, r53, r54, r55, r56, r57, r58)
            r2 = -819895438(0xffffffffcf216372, float:-2.70764902E9)
            androidx.compose.runtime.internal.ComposableLambda r10 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r5, r2, r4, r1)
            r11 = 1
            r12 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r1 = 100663296(0x6000000, float:2.4074124E-35)
            r2 = r0 & 14
            r1 = r1 | r2
            r2 = r0 & 112(0x70, float:1.57E-43)
            r1 = r1 | r2
            r2 = r0 & 896(0x380, float:1.256E-42)
            r1 = r1 | r2
            r2 = r0 & 7168(0x1c00, float:1.0045E-41)
            r1 = r1 | r2
            r2 = r0 & r22
            r1 = r1 | r2
            r2 = r0 & r23
            r1 = r1 | r2
            r2 = 3670016(0x380000, float:5.142788E-39)
            r2 = r2 & r0
            r1 = r1 | r2
            r2 = 29360128(0x1c00000, float:7.052966E-38)
            r0 = r0 & r2
            r23 = r1 | r0
            int r0 = r7 >> 6
            r0 = r0 & 7168(0x1c00, float:1.0045E-41)
            r1 = 18874422(0x1200036, float:2.938751E-38)
            r24 = r0 | r1
            r25 = 0
            r26 = 3936768(0x3c1200, float:5.516587E-39)
            r0 = r43
            r1 = r27
            r2 = r28
            r39 = r3
            r3 = r29
            r4 = r30
            r40 = r5
            r5 = r31
            r6 = r49
            r7 = r50
            r13 = r38
            r14 = r16
            r16 = r35
            r17 = r36
            r22 = r40
            com.designsystem.ds_input_field.InputFieldCommonComposablesKt.m8413InputFieldmytMHeg(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26)
            r2 = r27
            r3 = r28
            r4 = r29
            r5 = r30
            r6 = r31
            r10 = r32
            r11 = r33
            r12 = r34
            r13 = r35
            r14 = r36
            r15 = r37
            r16 = r38
            r9 = r39
        L_0x030a:
            androidx.compose.runtime.ScopeUpdateScope r8 = r40.endRestartGroup()
            if (r8 != 0) goto L_0x0311
            goto L_0x032e
        L_0x0311:
            com.designsystem.ds_input_field.TextFieldComposablesKt$TextFieldInputField$3 r7 = new com.designsystem.ds_input_field.TextFieldComposablesKt$TextFieldInputField$3
            r0 = r7
            r1 = r43
            r41 = r7
            r7 = r49
            r42 = r8
            r8 = r50
            r17 = r60
            r18 = r61
            r19 = r62
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
            r1 = r41
            r0 = r42
            r0.updateScope(r1)
        L_0x032e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.designsystem.ds_input_field.TextFieldComposablesKt.m8471TextFieldInputFieldqQH3efY(androidx.compose.ui.Modifier, java.lang.String, java.lang.String, java.lang.String, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, boolean, com.designsystem.ds_input_field.OuterState, java.lang.Integer, java.lang.Integer, kotlin.jvm.functions.Function0, boolean, androidx.compose.ui.text.input.KeyboardType, androidx.compose.ui.text.input.ImeAction, androidx.compose.ui.text.input.VisualTransformation, java.lang.Integer, androidx.compose.runtime.Composer, int, int, int):void");
    }
}
