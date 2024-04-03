package com.designsystem.ds_input_field;

import androidx.annotation.DrawableRes;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import com.designsystem.ds_theme.DSTheme;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000f\u0010\u0010\u001a)\u0010\u0011\u001a\u00020\u00012\b\b\u0001\u0010\u0012\u001a\u00020\u00132\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0015H\u0003¢\u0006\u0002\u0010\u0016\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u0017"}, d2 = {"PasswordFieldInputField", "", "modifier", "Landroidx/compose/ui/Modifier;", "text", "", "hint", "helperText", "onTextChange", "Lkotlin/Function1;", "onKeyboardReturnButtonTap", "outerState", "Lcom/designsystem/ds_input_field/OuterState;", "imeAction", "Landroidx/compose/ui/text/input/ImeAction;", "PasswordFieldInputField-tulg0WA", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lcom/designsystem/ds_input_field/OuterState;Landroidx/compose/ui/text/input/ImeAction;Landroidx/compose/runtime/Composer;II)V", "PasswordFieldTrailingIconContainer", "trailingIcon", "", "onTrailingIconTap", "Lkotlin/Function0;", "(ILkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "marshmallow_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class PasswordFieldComposablesKt {
    /* JADX WARNING: Removed duplicated region for block: B:118:0x01f7  */
    /* JADX WARNING: Removed duplicated region for block: B:120:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00ac  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00cc  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00cf  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00e6  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0101  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0110  */
    @androidx.compose.runtime.Composable
    /* renamed from: PasswordFieldInputField-tulg0WA  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m8443PasswordFieldInputFieldtulg0WA(@org.jetbrains.annotations.NotNull androidx.compose.ui.Modifier r35, @org.jetbrains.annotations.Nullable java.lang.String r36, @org.jetbrains.annotations.Nullable java.lang.String r37, @org.jetbrains.annotations.Nullable java.lang.String r38, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r39, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r40, @org.jetbrains.annotations.NotNull com.designsystem.ds_input_field.OuterState r41, @org.jetbrains.annotations.Nullable androidx.compose.ui.text.input.ImeAction r42, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r43, int r44, int r45) {
        /*
            r14 = r35
            r7 = r41
            r5 = r44
            r4 = r45
            java.lang.String r0 = "modifier"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            java.lang.String r0 = "outerState"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            r0 = 793804567(0x2f507f17, float:1.8962641E-10)
            r1 = r43
            androidx.compose.runtime.Composer r3 = r1.startRestartGroup(r0)
            r0 = r4 & 1
            if (r0 == 0) goto L_0x0022
            r0 = r5 | 6
            goto L_0x0032
        L_0x0022:
            r0 = r5 & 14
            if (r0 != 0) goto L_0x0031
            boolean r0 = r3.changed((java.lang.Object) r14)
            if (r0 == 0) goto L_0x002e
            r0 = 4
            goto L_0x002f
        L_0x002e:
            r0 = 2
        L_0x002f:
            r0 = r0 | r5
            goto L_0x0032
        L_0x0031:
            r0 = r5
        L_0x0032:
            r2 = r4 & 2
            if (r2 == 0) goto L_0x0039
            r0 = r0 | 48
            goto L_0x004c
        L_0x0039:
            r6 = r5 & 112(0x70, float:1.57E-43)
            if (r6 != 0) goto L_0x004c
            r6 = r36
            boolean r8 = r3.changed((java.lang.Object) r6)
            if (r8 == 0) goto L_0x0048
            r8 = 32
            goto L_0x004a
        L_0x0048:
            r8 = 16
        L_0x004a:
            r0 = r0 | r8
            goto L_0x004e
        L_0x004c:
            r6 = r36
        L_0x004e:
            r8 = r4 & 4
            if (r8 == 0) goto L_0x0055
            r0 = r0 | 384(0x180, float:5.38E-43)
            goto L_0x0068
        L_0x0055:
            r10 = r5 & 896(0x380, float:1.256E-42)
            if (r10 != 0) goto L_0x0068
            r10 = r37
            boolean r11 = r3.changed((java.lang.Object) r10)
            if (r11 == 0) goto L_0x0064
            r11 = 256(0x100, float:3.59E-43)
            goto L_0x0066
        L_0x0064:
            r11 = 128(0x80, float:1.794E-43)
        L_0x0066:
            r0 = r0 | r11
            goto L_0x006a
        L_0x0068:
            r10 = r37
        L_0x006a:
            r11 = r4 & 8
            if (r11 == 0) goto L_0x0071
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            goto L_0x0084
        L_0x0071:
            r12 = r5 & 7168(0x1c00, float:1.0045E-41)
            if (r12 != 0) goto L_0x0084
            r12 = r38
            boolean r13 = r3.changed((java.lang.Object) r12)
            if (r13 == 0) goto L_0x0080
            r13 = 2048(0x800, float:2.87E-42)
            goto L_0x0082
        L_0x0080:
            r13 = 1024(0x400, float:1.435E-42)
        L_0x0082:
            r0 = r0 | r13
            goto L_0x0086
        L_0x0084:
            r12 = r38
        L_0x0086:
            r13 = r4 & 16
            r17 = 57344(0xe000, float:8.0356E-41)
            if (r13 == 0) goto L_0x0090
            r0 = r0 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00a4
        L_0x0090:
            r15 = r5 & r17
            if (r15 != 0) goto L_0x00a4
            r15 = r39
            boolean r16 = r3.changed((java.lang.Object) r15)
            if (r16 == 0) goto L_0x009f
            r16 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a1
        L_0x009f:
            r16 = 8192(0x2000, float:1.14794E-41)
        L_0x00a1:
            r0 = r0 | r16
            goto L_0x00a6
        L_0x00a4:
            r15 = r39
        L_0x00a6:
            r16 = r4 & 32
            r22 = 458752(0x70000, float:6.42848E-40)
            if (r16 == 0) goto L_0x00b3
            r18 = 196608(0x30000, float:2.75506E-40)
            r0 = r0 | r18
            r1 = r40
            goto L_0x00c6
        L_0x00b3:
            r18 = r5 & r22
            r1 = r40
            if (r18 != 0) goto L_0x00c6
            boolean r18 = r3.changed((java.lang.Object) r1)
            if (r18 == 0) goto L_0x00c2
            r18 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00c4
        L_0x00c2:
            r18 = 65536(0x10000, float:9.18355E-41)
        L_0x00c4:
            r0 = r0 | r18
        L_0x00c6:
            r18 = r4 & 64
            r23 = 1572864(0x180000, float:2.204052E-39)
            if (r18 == 0) goto L_0x00cf
            r0 = r0 | r23
            goto L_0x00e2
        L_0x00cf:
            r18 = 3670016(0x380000, float:5.142788E-39)
            r18 = r5 & r18
            if (r18 != 0) goto L_0x00e2
            boolean r18 = r3.changed((java.lang.Object) r7)
            if (r18 == 0) goto L_0x00de
            r18 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00e0
        L_0x00de:
            r18 = 524288(0x80000, float:7.34684E-40)
        L_0x00e0:
            r0 = r0 | r18
        L_0x00e2:
            r9 = r4 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x00ea
            r19 = 4194304(0x400000, float:5.877472E-39)
            r0 = r0 | r19
        L_0x00ea:
            int r1 = ~r4
            r4 = 128(0x80, float:1.794E-43)
            r1 = r1 & r4
            if (r1 != 0) goto L_0x0110
            r1 = 23967451(0x16db6db, float:4.3661218E-38)
            r1 = r1 & r0
            r4 = 4793490(0x492492, float:6.71711E-39)
            r1 = r1 ^ r4
            if (r1 != 0) goto L_0x0110
            boolean r1 = r3.getSkipping()
            if (r1 != 0) goto L_0x0101
            goto L_0x0110
        L_0x0101:
            r3.skipToGroupEnd()
            r8 = r42
            r34 = r3
            r2 = r6
            r3 = r10
            r4 = r12
            r5 = r15
            r6 = r40
            goto L_0x01f0
        L_0x0110:
            r1 = 0
            if (r2 == 0) goto L_0x0116
            r27 = r1
            goto L_0x0118
        L_0x0116:
            r27 = r6
        L_0x0118:
            if (r8 == 0) goto L_0x011d
            r28 = r1
            goto L_0x011f
        L_0x011d:
            r28 = r10
        L_0x011f:
            if (r11 == 0) goto L_0x0124
            r29 = r1
            goto L_0x0126
        L_0x0124:
            r29 = r12
        L_0x0126:
            if (r13 == 0) goto L_0x012b
            r30 = r1
            goto L_0x012d
        L_0x012b:
            r30 = r15
        L_0x012d:
            if (r16 == 0) goto L_0x0132
            r31 = r1
            goto L_0x0134
        L_0x0132:
            r31 = r40
        L_0x0134:
            if (r9 == 0) goto L_0x0139
            r32 = r1
            goto L_0x013b
        L_0x0139:
            r32 = r42
        L_0x013b:
            r2 = -3687241(0xffffffffffc7bcb7, float:NaN)
            r3.startReplaceableGroup(r2)
            java.lang.Object r2 = r3.rememberedValue()
            androidx.compose.runtime.Composer$Companion r4 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r4 = r4.getEmpty()
            if (r2 != r4) goto L_0x0157
            java.lang.Boolean r2 = java.lang.Boolean.FALSE
            r4 = 2
            androidx.compose.runtime.MutableState r2 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r2, r1, r4, r1)
            r3.updateRememberedValue(r2)
        L_0x0157:
            r3.endReplaceableGroup()
            androidx.compose.runtime.MutableState r2 = (androidx.compose.runtime.MutableState) r2
            boolean r4 = m8444PasswordFieldInputField_tulg0WA$lambda1(r2)
            r10 = 1
            if (r4 == 0) goto L_0x016c
            androidx.compose.ui.text.input.VisualTransformation$Companion r1 = androidx.compose.ui.text.input.VisualTransformation.Companion
            androidx.compose.ui.text.input.VisualTransformation r1 = r1.getNone()
            r33 = r1
            goto L_0x0174
        L_0x016c:
            androidx.compose.ui.text.input.PasswordVisualTransformation r4 = new androidx.compose.ui.text.input.PasswordVisualTransformation
            r6 = 0
            r4.<init>(r6, r10, r1)
            r33 = r4
        L_0x0174:
            boolean r1 = m8444PasswordFieldInputField_tulg0WA$lambda1(r2)
            if (r1 == 0) goto L_0x017d
            int r1 = com.designsystem.marshmallow.R.drawable.ds_hide_filled
            goto L_0x017f
        L_0x017d:
            int r1 = com.designsystem.marshmallow.R.drawable.ds_show_filled
        L_0x017f:
            r6 = 1
            r8 = 0
            r9 = 0
            com.designsystem.ds_input_field.PasswordFieldComposablesKt$PasswordFieldInputField$1 r4 = new com.designsystem.ds_input_field.PasswordFieldComposablesKt$PasswordFieldInputField$1
            r4.<init>(r1, r2)
            r1 = -819896281(0xffffffffcf216027, float:-2.70743322E9)
            androidx.compose.runtime.internal.ComposableLambda r10 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r3, r1, r10, r4)
            r11 = 1
            r12 = 0
            r13 = 0
            com.designsystem.ds_input_field.InputFieldCommon r1 = com.designsystem.ds_input_field.InputFieldCommon.INSTANCE
            float r15 = r1.m8409getSingleLineContainerMinHeightD9Ej5fM()
            androidx.compose.ui.text.input.KeyboardType$Companion r1 = androidx.compose.ui.text.input.KeyboardType.Companion
            int r1 = r1.m5225getPasswordPjHm6EE()
            androidx.compose.ui.text.input.KeyboardType r16 = androidx.compose.ui.text.input.KeyboardType.m5213boximpl(r1)
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r1 = r0 & 14
            r1 = r1 | r23
            r2 = r0 & 112(0x70, float:1.57E-43)
            r1 = r1 | r2
            r2 = r0 & 896(0x380, float:1.256E-42)
            r1 = r1 | r2
            r2 = r0 & 7168(0x1c00, float:1.0045E-41)
            r1 = r1 | r2
            r2 = r0 & r17
            r1 = r1 | r2
            r2 = r0 & r22
            r1 = r1 | r2
            int r0 = r0 << 3
            r2 = 29360128(0x1c00000, float:7.052966E-38)
            r0 = r0 & r2
            r23 = r1 | r0
            r24 = 18874422(0x1200036, float:2.938751E-38)
            r25 = 0
            r26 = 3945216(0x3c3300, float:5.528425E-39)
            r0 = r35
            r1 = r27
            r2 = r28
            r34 = r3
            r3 = r29
            r4 = r30
            r5 = r31
            r7 = r41
            r14 = r33
            r17 = r32
            r22 = r34
            com.designsystem.ds_input_field.InputFieldCommonComposablesKt.m8413InputFieldmytMHeg(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26)
            r2 = r27
            r3 = r28
            r4 = r29
            r5 = r30
            r6 = r31
            r8 = r32
        L_0x01f0:
            androidx.compose.runtime.ScopeUpdateScope r11 = r34.endRestartGroup()
            if (r11 != 0) goto L_0x01f7
            goto L_0x0208
        L_0x01f7:
            com.designsystem.ds_input_field.PasswordFieldComposablesKt$PasswordFieldInputField$2 r12 = new com.designsystem.ds_input_field.PasswordFieldComposablesKt$PasswordFieldInputField$2
            r0 = r12
            r1 = r35
            r7 = r41
            r9 = r44
            r10 = r45
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            r11.updateScope(r12)
        L_0x0208:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.designsystem.ds_input_field.PasswordFieldComposablesKt.m8443PasswordFieldInputFieldtulg0WA(androidx.compose.ui.Modifier, java.lang.String, java.lang.String, java.lang.String, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, com.designsystem.ds_input_field.OuterState, androidx.compose.ui.text.input.ImeAction, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: PasswordFieldInputField_tulg0WA$lambda-1  reason: not valid java name */
    public static final boolean m8444PasswordFieldInputField_tulg0WA$lambda1(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: PasswordFieldInputField_tulg0WA$lambda-2  reason: not valid java name */
    public static final void m8445PasswordFieldInputField_tulg0WA$lambda2(MutableState<Boolean> mutableState, boolean z11) {
        mutableState.setValue(Boolean.valueOf(z11));
    }

    /* access modifiers changed from: private */
    @Composable
    public static final void PasswordFieldTrailingIconContainer(@DrawableRes int i11, Function0<Unit> function0, Composer composer, int i12, int i13) {
        int i14;
        int i15;
        int i16;
        Composer startRestartGroup = composer.startRestartGroup(-1944575183);
        if ((i13 & 1) != 0) {
            i14 = i12 | 6;
        } else if ((i12 & 14) == 0) {
            if (startRestartGroup.changed(i11)) {
                i16 = 4;
            } else {
                i16 = 2;
            }
            i14 = i16 | i12;
        } else {
            i14 = i12;
        }
        int i17 = i13 & 2;
        if (i17 != 0) {
            i14 |= 48;
        } else if ((i12 & 112) == 0) {
            if (startRestartGroup.changed((Object) function0)) {
                i15 = 32;
            } else {
                i15 = 16;
            }
            i14 |= i15;
        }
        if (((i14 & 91) ^ 18) != 0 || !startRestartGroup.getSkipping()) {
            if (i17 != 0) {
                function0 = null;
            }
            InputFieldCommonComposablesKt.m8414InputFieldTrailingIcon8V94_ZQ(i11, DSTheme.INSTANCE.getColors(startRestartGroup, 0).m8771getDsNeutral700d7_KjU(), function0, true, true, startRestartGroup, (i14 & 14) | 27648 | ((i14 << 3) & 896), 0);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new PasswordFieldComposablesKt$PasswordFieldTrailingIconContainer$1(i11, function0, i12, i13));
        }
    }
}
