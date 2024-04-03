package com.designsystem.ds_input_field;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a³\u0001\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0003\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0010H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0016\u0010\u0017\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u0018"}, d2 = {"DSCreditCardField", "", "modifier", "Landroidx/compose/ui/Modifier;", "text", "", "hint", "helperText", "onTextChange", "Lkotlin/Function1;", "onKeyboardReturnButtonTap", "isEnabled", "", "state", "Lcom/designsystem/ds_input_field/DSInputFieldState;", "leadingIcon", "", "imeAction", "Landroidx/compose/ui/text/input/ImeAction;", "formatter", "Landroidx/compose/ui/text/input/VisualTransformation;", "maxNumberOfCharacters", "DSCreditCardField-k7ZECbw", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;ZLcom/designsystem/ds_input_field/DSInputFieldState;IILandroidx/compose/ui/text/input/VisualTransformation;Ljava/lang/Integer;Landroidx/compose/runtime/Composer;III)V", "marshmallow_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class DSCreditCardFieldKt {
    /* JADX WARNING: Removed duplicated region for block: B:100:0x0129  */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x012e  */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x0148  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x014b  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x017d  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x0197  */
    /* JADX WARNING: Removed duplicated region for block: B:179:0x0281  */
    /* JADX WARNING: Removed duplicated region for block: B:181:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00ca  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00e3  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00ea  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0105  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x011b  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0121  */
    @androidx.compose.runtime.Composable
    /* renamed from: DSCreditCardField-k7ZECbw  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m8371DSCreditCardFieldk7ZECbw(@org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r37, @org.jetbrains.annotations.Nullable java.lang.String r38, @org.jetbrains.annotations.Nullable java.lang.String r39, @org.jetbrains.annotations.Nullable java.lang.String r40, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r41, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r42, boolean r43, @org.jetbrains.annotations.Nullable com.designsystem.ds_input_field.DSInputFieldState r44, @androidx.annotation.DrawableRes int r45, int r46, @org.jetbrains.annotations.Nullable androidx.compose.ui.text.input.VisualTransformation r47, @org.jetbrains.annotations.Nullable java.lang.Integer r48, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r49, int r50, int r51, int r52) {
        /*
            r13 = r50
            r15 = r52
            r0 = -430709861(0xffffffffe653e39b, float:-2.5015448E23)
            r1 = r49
            androidx.compose.runtime.Composer r0 = r1.startRestartGroup(r0)
            r1 = r15 & 1
            if (r1 == 0) goto L_0x0017
            r4 = r13 | 6
            r5 = r4
            r4 = r37
            goto L_0x002b
        L_0x0017:
            r4 = r13 & 14
            if (r4 != 0) goto L_0x0028
            r4 = r37
            boolean r5 = r0.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x0025
            r5 = 4
            goto L_0x0026
        L_0x0025:
            r5 = 2
        L_0x0026:
            r5 = r5 | r13
            goto L_0x002b
        L_0x0028:
            r4 = r37
            r5 = r13
        L_0x002b:
            r6 = r15 & 2
            if (r6 == 0) goto L_0x0032
            r5 = r5 | 48
            goto L_0x0045
        L_0x0032:
            r9 = r13 & 112(0x70, float:1.57E-43)
            if (r9 != 0) goto L_0x0045
            r9 = r38
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
            r9 = r38
        L_0x0047:
            r10 = r15 & 4
            if (r10 == 0) goto L_0x004e
            r5 = r5 | 384(0x180, float:5.38E-43)
            goto L_0x0061
        L_0x004e:
            r11 = r13 & 896(0x380, float:1.256E-42)
            if (r11 != 0) goto L_0x0061
            r11 = r39
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
            r11 = r39
        L_0x0063:
            r12 = r15 & 8
            if (r12 == 0) goto L_0x006a
            r5 = r5 | 3072(0xc00, float:4.305E-42)
            goto L_0x007e
        L_0x006a:
            r14 = r13 & 7168(0x1c00, float:1.0045E-41)
            if (r14 != 0) goto L_0x007e
            r14 = r40
            boolean r16 = r0.changed((java.lang.Object) r14)
            if (r16 == 0) goto L_0x0079
            r16 = 2048(0x800, float:2.87E-42)
            goto L_0x007b
        L_0x0079:
            r16 = 1024(0x400, float:1.435E-42)
        L_0x007b:
            r5 = r5 | r16
            goto L_0x0080
        L_0x007e:
            r14 = r40
        L_0x0080:
            r16 = r15 & 16
            if (r16 == 0) goto L_0x0089
            r5 = r5 | 24576(0x6000, float:3.4438E-41)
            r2 = r41
            goto L_0x009f
        L_0x0089:
            r17 = 57344(0xe000, float:8.0356E-41)
            r17 = r13 & r17
            r2 = r41
            if (r17 != 0) goto L_0x009f
            boolean r17 = r0.changed((java.lang.Object) r2)
            if (r17 == 0) goto L_0x009b
            r17 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009d
        L_0x009b:
            r17 = 8192(0x2000, float:1.14794E-41)
        L_0x009d:
            r5 = r5 | r17
        L_0x009f:
            r17 = r15 & 32
            if (r17 == 0) goto L_0x00aa
            r18 = 196608(0x30000, float:2.75506E-40)
            r5 = r5 | r18
            r3 = r42
            goto L_0x00bf
        L_0x00aa:
            r18 = 458752(0x70000, float:6.42848E-40)
            r18 = r13 & r18
            r3 = r42
            if (r18 != 0) goto L_0x00bf
            boolean r19 = r0.changed((java.lang.Object) r3)
            if (r19 == 0) goto L_0x00bb
            r19 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00bd
        L_0x00bb:
            r19 = 65536(0x10000, float:9.18355E-41)
        L_0x00bd:
            r5 = r5 | r19
        L_0x00bf:
            r19 = r15 & 64
            if (r19 == 0) goto L_0x00ca
            r20 = 1572864(0x180000, float:2.204052E-39)
            r5 = r5 | r20
            r7 = r43
            goto L_0x00df
        L_0x00ca:
            r20 = 3670016(0x380000, float:5.142788E-39)
            r20 = r13 & r20
            r7 = r43
            if (r20 != 0) goto L_0x00df
            boolean r21 = r0.changed((boolean) r7)
            if (r21 == 0) goto L_0x00db
            r21 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00dd
        L_0x00db:
            r21 = 524288(0x80000, float:7.34684E-40)
        L_0x00dd:
            r5 = r5 | r21
        L_0x00df:
            r8 = r15 & 128(0x80, float:1.794E-43)
            if (r8 == 0) goto L_0x00ea
            r22 = 12582912(0xc00000, float:1.7632415E-38)
            r5 = r5 | r22
            r2 = r44
            goto L_0x00ff
        L_0x00ea:
            r22 = 29360128(0x1c00000, float:7.052966E-38)
            r22 = r13 & r22
            r2 = r44
            if (r22 != 0) goto L_0x00ff
            boolean r22 = r0.changed((java.lang.Object) r2)
            if (r22 == 0) goto L_0x00fb
            r22 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00fd
        L_0x00fb:
            r22 = 4194304(0x400000, float:5.877472E-39)
        L_0x00fd:
            r5 = r5 | r22
        L_0x00ff:
            r22 = 234881024(0xe000000, float:1.5777218E-30)
            r22 = r13 & r22
            if (r22 != 0) goto L_0x011b
            r2 = r15 & 256(0x100, float:3.59E-43)
            if (r2 != 0) goto L_0x0114
            r2 = r45
            boolean r22 = r0.changed((int) r2)
            if (r22 == 0) goto L_0x0116
            r22 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0118
        L_0x0114:
            r2 = r45
        L_0x0116:
            r22 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0118:
            r5 = r5 | r22
            goto L_0x011d
        L_0x011b:
            r2 = r45
        L_0x011d:
            r2 = r15 & 512(0x200, float:7.175E-43)
            if (r2 == 0) goto L_0x0125
            r22 = 268435456(0x10000000, float:2.5243549E-29)
            r5 = r5 | r22
        L_0x0125:
            r3 = r15 & 1024(0x400, float:1.435E-42)
            if (r3 == 0) goto L_0x012e
            r18 = r51 | 6
            r4 = r47
            goto L_0x0144
        L_0x012e:
            r22 = r51 & 14
            r4 = r47
            if (r22 != 0) goto L_0x0142
            boolean r22 = r0.changed((java.lang.Object) r4)
            if (r22 == 0) goto L_0x013d
            r18 = 4
            goto L_0x013f
        L_0x013d:
            r18 = 2
        L_0x013f:
            r18 = r51 | r18
            goto L_0x0144
        L_0x0142:
            r18 = r51
        L_0x0144:
            r4 = r15 & 2048(0x800, float:2.87E-42)
            if (r4 == 0) goto L_0x014b
            r18 = r18 | 48
            goto L_0x015e
        L_0x014b:
            r22 = r51 & 112(0x70, float:1.57E-43)
            r7 = r48
            if (r22 != 0) goto L_0x015e
            boolean r22 = r0.changed((java.lang.Object) r7)
            if (r22 == 0) goto L_0x015a
            r20 = 32
            goto L_0x015c
        L_0x015a:
            r20 = 16
        L_0x015c:
            r18 = r18 | r20
        L_0x015e:
            r33 = r18
            int r7 = ~r15
            r7 = r7 & 512(0x200, float:7.175E-43)
            if (r7 != 0) goto L_0x0197
            r7 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r7 = r7 & r5
            r18 = 306783378(0x12492492, float:6.3469493E-28)
            r7 = r7 ^ r18
            if (r7 != 0) goto L_0x0197
            r7 = r33 & 91
            r7 = r7 ^ 18
            if (r7 != 0) goto L_0x0197
            boolean r7 = r0.getSkipping()
            if (r7 != 0) goto L_0x017d
            goto L_0x0197
        L_0x017d:
            r0.skipToGroupEnd()
            r1 = r37
            r5 = r41
            r6 = r42
            r7 = r43
            r8 = r44
            r10 = r46
            r12 = r48
            r2 = r9
            r3 = r11
            r4 = r14
            r9 = r45
            r11 = r47
            goto L_0x027a
        L_0x0197:
            r7 = r13 & 1
            r18 = -1879048193(0xffffffff8fffffff, float:-2.5243547E-29)
            r20 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r9 = 1
            if (r7 == 0) goto L_0x01e6
            boolean r7 = r0.getDefaultsInvalid()
            if (r7 == 0) goto L_0x01a9
            goto L_0x01e6
        L_0x01a9:
            r0.skipCurrentGroup()
            r1 = r15 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x01b2
            r5 = r5 & r20
        L_0x01b2:
            if (r2 == 0) goto L_0x01ce
            r1 = r5 & r18
            r6 = r38
            r10 = r41
            r12 = r42
            r16 = r43
            r8 = r44
            r7 = r45
            r2 = r46
            r3 = r47
            r4 = r48
            r32 = r1
            r1 = r37
            goto L_0x023e
        L_0x01ce:
            r1 = r37
            r6 = r38
            r10 = r41
            r12 = r42
            r16 = r43
            r8 = r44
            r7 = r45
            r2 = r46
            r3 = r47
            r4 = r48
        L_0x01e2:
            r32 = r5
            goto L_0x023e
        L_0x01e6:
            r0.startDefaults()
            if (r1 == 0) goto L_0x01ee
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            goto L_0x01f0
        L_0x01ee:
            r1 = r37
        L_0x01f0:
            if (r6 == 0) goto L_0x01f4
            r6 = 0
            goto L_0x01f6
        L_0x01f4:
            r6 = r38
        L_0x01f6:
            if (r10 == 0) goto L_0x01f9
            r11 = 0
        L_0x01f9:
            if (r12 == 0) goto L_0x01fc
            r14 = 0
        L_0x01fc:
            if (r16 == 0) goto L_0x0200
            r10 = 0
            goto L_0x0202
        L_0x0200:
            r10 = r41
        L_0x0202:
            if (r17 == 0) goto L_0x0206
            r12 = 0
            goto L_0x0208
        L_0x0206:
            r12 = r42
        L_0x0208:
            if (r19 == 0) goto L_0x020d
            r16 = r9
            goto L_0x020f
        L_0x020d:
            r16 = r43
        L_0x020f:
            if (r8 == 0) goto L_0x0214
            com.designsystem.ds_input_field.DSInputFieldState r8 = com.designsystem.ds_input_field.DSInputFieldState.Normal
            goto L_0x0216
        L_0x0214:
            r8 = r44
        L_0x0216:
            r7 = r15 & 256(0x100, float:3.59E-43)
            if (r7 == 0) goto L_0x021f
            int r7 = com.designsystem.marshmallow.R.drawable.ds_credit_card
            r5 = r5 & r20
            goto L_0x0221
        L_0x021f:
            r7 = r45
        L_0x0221:
            if (r2 == 0) goto L_0x022c
            androidx.compose.ui.text.input.ImeAction$Companion r2 = androidx.compose.ui.text.input.ImeAction.Companion
            int r2 = r2.m5188getDoneeUduSuo()
            r5 = r5 & r18
            goto L_0x022e
        L_0x022c:
            r2 = r46
        L_0x022e:
            if (r3 == 0) goto L_0x0232
            r3 = 0
            goto L_0x0234
        L_0x0232:
            r3 = r47
        L_0x0234:
            if (r4 == 0) goto L_0x0238
            r4 = 0
            goto L_0x023a
        L_0x0238:
            r4 = r48
        L_0x023a:
            r0.endDefaults()
            goto L_0x01e2
        L_0x023e:
            com.designsystem.ds_input_field.DSCreditCardFieldKt$DSCreditCardField$1 r5 = new com.designsystem.ds_input_field.DSCreditCardFieldKt$DSCreditCardField$1
            r20 = r5
            r21 = r3
            r22 = r1
            r23 = r6
            r24 = r11
            r25 = r14
            r26 = r10
            r27 = r12
            r28 = r16
            r29 = r8
            r30 = r4
            r31 = r2
            r34 = r7
            r20.<init>(r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34)
            r37 = r1
            r1 = -819892872(0xffffffffcf216d78, float:-2.70830592E9)
            androidx.compose.runtime.internal.ComposableLambda r1 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r0, r1, r9, r5)
            r5 = 6
            com.designsystem.ds_theme.DSThemeKt.DSTheme(r1, r0, r5)
            r1 = r37
            r9 = r7
            r5 = r10
            r7 = r16
            r10 = r2
            r2 = r6
            r6 = r12
            r12 = r4
            r4 = r14
            r36 = r11
            r11 = r3
            r3 = r36
        L_0x027a:
            androidx.compose.runtime.ScopeUpdateScope r14 = r0.endRestartGroup()
            if (r14 != 0) goto L_0x0281
            goto L_0x0297
        L_0x0281:
            com.designsystem.ds_input_field.DSCreditCardFieldKt$DSCreditCardField$2 r0 = new com.designsystem.ds_input_field.DSCreditCardFieldKt$DSCreditCardField$2
            r37 = r0
            r13 = r50
            r35 = r14
            r14 = r51
            r15 = r52
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            r1 = r37
            r0 = r35
            r0.updateScope(r1)
        L_0x0297:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.designsystem.ds_input_field.DSCreditCardFieldKt.m8371DSCreditCardFieldk7ZECbw(androidx.compose.ui.Modifier, java.lang.String, java.lang.String, java.lang.String, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, boolean, com.designsystem.ds_input_field.DSInputFieldState, int, int, androidx.compose.ui.text.input.VisualTransformation, java.lang.Integer, androidx.compose.runtime.Composer, int, int, int):void");
    }
}
