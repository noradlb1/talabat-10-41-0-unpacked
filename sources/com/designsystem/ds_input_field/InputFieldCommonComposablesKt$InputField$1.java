package com.designsystem.ds_input_field;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class InputFieldCommonComposablesKt$InputField$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    public final /* synthetic */ Function2<Composer, Integer, Unit> A;
    public final /* synthetic */ Function2<Composer, Integer, Unit> B;
    public final /* synthetic */ OuterState C;
    public final /* synthetic */ Dp D;
    public final /* synthetic */ float E;
    public final /* synthetic */ boolean F;
    public final /* synthetic */ boolean G;
    public final /* synthetic */ int H;
    public final /* synthetic */ State<Offset> I;
    public final /* synthetic */ MutableState<ContainerState> J;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f31595g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ boolean f31596h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f31597i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f31598j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f31599k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Function1<String, Unit> f31600l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ MutableState<TextFieldValue> f31601m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ ImeAction f31602n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ KeyboardType f31603o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ Function1<TextFieldValue, TextFieldValue> f31604p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ Integer f31605q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ Function1<String, Unit> f31606r;

    /* renamed from: s  reason: collision with root package name */
    public final /* synthetic */ MutableState<Integer> f31607s;

    /* renamed from: t  reason: collision with root package name */
    public final /* synthetic */ VisualTransformation f31608t;

    /* renamed from: u  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f31609u;

    /* renamed from: v  reason: collision with root package name */
    public final /* synthetic */ int f31610v;

    /* renamed from: w  reason: collision with root package name */
    public final /* synthetic */ String f31611w;

    /* renamed from: x  reason: collision with root package name */
    public final /* synthetic */ TextStyle f31612x;

    /* renamed from: y  reason: collision with root package name */
    public final /* synthetic */ String f31613y;

    /* renamed from: z  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f31614z;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InputFieldCommonComposablesKt$InputField$1(Modifier modifier, boolean z11, Function0<Unit> function0, int i11, int i12, Function1<? super String, Unit> function1, MutableState<TextFieldValue> mutableState, ImeAction imeAction, KeyboardType keyboardType, Function1<? super TextFieldValue, TextFieldValue> function12, Integer num, Function1<? super String, Unit> function13, MutableState<Integer> mutableState2, VisualTransformation visualTransformation, MutableInteractionSource mutableInteractionSource, int i13, String str, TextStyle textStyle, String str2, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, OuterState outerState, Dp dp2, float f11, boolean z12, boolean z13, int i14, State<Offset> state, MutableState<ContainerState> mutableState3) {
        super(2);
        this.f31595g = modifier;
        this.f31596h = z11;
        this.f31597i = function0;
        this.f31598j = i11;
        this.f31599k = i12;
        this.f31600l = function1;
        this.f31601m = mutableState;
        this.f31602n = imeAction;
        this.f31603o = keyboardType;
        this.f31604p = function12;
        this.f31605q = num;
        this.f31606r = function13;
        this.f31607s = mutableState2;
        this.f31608t = visualTransformation;
        this.f31609u = mutableInteractionSource;
        this.f31610v = i13;
        this.f31611w = str;
        this.f31612x = textStyle;
        this.f31613y = str2;
        this.f31614z = function2;
        this.A = function22;
        this.B = function23;
        this.C = outerState;
        this.D = dp2;
        this.E = f11;
        this.F = z12;
        this.G = z13;
        this.H = i14;
        this.I = state;
        this.J = mutableState3;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v12, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v23, resolved type: com.designsystem.ds_input_field.InputFieldCommonComposablesKt$InputField$1$2$1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v10, resolved type: com.designsystem.ds_input_field.InputFieldCommonComposablesKt$InputField$1$2$1} */
    /* JADX WARNING: type inference failed for: r10v13 */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00f6, code lost:
        if (r10 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L_0x00f8;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(@org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r47, int r48) {
        /*
            r46 = this;
            r0 = r46
            r14 = r47
            r1 = r48 & 11
            r2 = 2
            r1 = r1 ^ r2
            if (r1 != 0) goto L_0x0016
            boolean r1 = r47.getSkipping()
            if (r1 != 0) goto L_0x0011
            goto L_0x0016
        L_0x0011:
            r47.skipToGroupEnd()
            goto L_0x01a3
        L_0x0016:
            androidx.compose.ui.Modifier r1 = r0.f31595g
            java.lang.String r3 = "InputFieldInnerTextFieldTestTag"
            androidx.compose.ui.Modifier r3 = androidx.compose.ui.platform.TestTagKt.testTag(r1, r3)
            boolean r1 = r0.f31596h
            r4 = 1
            r5 = 0
            if (r1 == 0) goto L_0x002a
            kotlin.jvm.functions.Function0<kotlin.Unit> r6 = r0.f31597i
            if (r6 != 0) goto L_0x002a
            r6 = r4
            goto L_0x002b
        L_0x002a:
            r6 = r5
        L_0x002b:
            int r7 = r0.f31598j
            int r7 = r7 >> 18
            r7 = r7 & 14
            androidx.compose.ui.text.TextStyle r7 = com.designsystem.ds_input_field.InputFieldTextStyleComposablesKt.inputTextStyle(r1, r14, r7)
            androidx.compose.runtime.MutableState<androidx.compose.ui.text.input.TextFieldValue> r1 = r0.f31601m
            androidx.compose.ui.text.input.TextFieldValue r1 = com.designsystem.ds_input_field.InputFieldCommonComposablesKt.m8419InputField_mytMHeg$lambda2(r1)
            int r8 = r0.f31599k
            if (r8 != r4) goto L_0x0041
            r9 = r4
            goto L_0x0042
        L_0x0041:
            r9 = r5
        L_0x0042:
            kotlin.jvm.functions.Function1<java.lang.String, kotlin.Unit> r8 = r0.f31600l
            androidx.compose.runtime.MutableState<androidx.compose.ui.text.input.TextFieldValue> r10 = r0.f31601m
            r11 = -3686552(0xffffffffffc7bf68, float:NaN)
            r14.startReplaceableGroup(r11)
            boolean r11 = r14.changed((java.lang.Object) r8)
            boolean r12 = r14.changed((java.lang.Object) r10)
            r11 = r11 | r12
            java.lang.Object r12 = r47.rememberedValue()
            if (r11 != 0) goto L_0x0063
            androidx.compose.runtime.Composer$Companion r11 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r11 = r11.getEmpty()
            if (r12 != r11) goto L_0x006b
        L_0x0063:
            com.designsystem.ds_input_field.InputFieldCommonComposablesKt$InputField$1$1$1 r12 = new com.designsystem.ds_input_field.InputFieldCommonComposablesKt$InputField$1$1$1
            r12.<init>(r8, r10)
            r14.updateRememberedValue(r12)
        L_0x006b:
            r47.endReplaceableGroup()
            kotlin.jvm.functions.Function1 r12 = (kotlin.jvm.functions.Function1) r12
            androidx.compose.foundation.text.KeyboardActions r8 = androidx.compose.foundation.text.KeyboardActionsKt.KeyboardActions(r12)
            androidx.compose.ui.graphics.SolidColor r15 = new androidx.compose.ui.graphics.SolidColor
            com.designsystem.ds_theme.DSTheme r10 = com.designsystem.ds_theme.DSTheme.INSTANCE
            com.designsystem.ds_theme.DSColors r10 = r10.getColors(r14, r5)
            long r10 = r10.m8793getDsPrimary1000d7_KjU()
            r12 = 0
            r15.<init>(r10, r12)
            androidx.compose.ui.text.input.ImeAction r10 = r0.f31602n
            if (r10 != 0) goto L_0x008f
            androidx.compose.ui.text.input.ImeAction$Companion r10 = androidx.compose.ui.text.input.ImeAction.Companion
            int r10 = r10.m5187getDefaulteUduSuo()
            goto L_0x0093
        L_0x008f:
            int r10 = r10.m5186unboximpl()
        L_0x0093:
            r20 = r10
            androidx.compose.ui.text.input.KeyboardType r10 = r0.f31603o
            if (r10 != 0) goto L_0x00a0
            androidx.compose.ui.text.input.KeyboardType$Companion r10 = androidx.compose.ui.text.input.KeyboardType.Companion
            int r10 = r10.m5227getTextPjHm6EE()
            goto L_0x00a4
        L_0x00a0:
            int r10 = r10.m5219unboximpl()
        L_0x00a4:
            r19 = r10
            androidx.compose.foundation.text.KeyboardOptions r23 = new androidx.compose.foundation.text.KeyboardOptions
            r17 = 0
            r18 = 0
            r21 = 3
            r22 = 0
            r16 = r23
            r16.<init>(r17, r18, r19, r20, r21, r22)
            r10 = 5
            java.lang.Object[] r11 = new java.lang.Object[r10]
            kotlin.jvm.functions.Function1<androidx.compose.ui.text.input.TextFieldValue, androidx.compose.ui.text.input.TextFieldValue> r12 = r0.f31604p
            r11[r5] = r12
            java.lang.Integer r13 = r0.f31605q
            r11[r4] = r13
            androidx.compose.runtime.MutableState<androidx.compose.ui.text.input.TextFieldValue> r5 = r0.f31601m
            r11[r2] = r5
            kotlin.jvm.functions.Function1<java.lang.String, kotlin.Unit> r2 = r0.f31606r
            r16 = 3
            r11[r16] = r2
            androidx.compose.runtime.MutableState<java.lang.Integer> r4 = r0.f31607s
            r16 = 4
            r11[r16] = r4
            r10 = -3685570(0xffffffffffc7c33e, float:NaN)
            r14.startReplaceableGroup(r10)
            r48 = r15
            r10 = 0
            r15 = 5
            r16 = 0
        L_0x00dc:
            if (r10 >= r15) goto L_0x00ea
            r15 = r11[r10]
            int r10 = r10 + 1
            boolean r15 = r14.changed((java.lang.Object) r15)
            r16 = r16 | r15
            r15 = 5
            goto L_0x00dc
        L_0x00ea:
            java.lang.Object r10 = r47.rememberedValue()
            if (r16 != 0) goto L_0x00f8
            androidx.compose.runtime.Composer$Companion r11 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r11 = r11.getEmpty()
            if (r10 != r11) goto L_0x010c
        L_0x00f8:
            com.designsystem.ds_input_field.InputFieldCommonComposablesKt$InputField$1$2$1 r10 = new com.designsystem.ds_input_field.InputFieldCommonComposablesKt$InputField$1$2$1
            r16 = r10
            r17 = r12
            r18 = r13
            r19 = r2
            r20 = r5
            r21 = r4
            r16.<init>(r17, r18, r19, r20, r21)
            r14.updateRememberedValue(r10)
        L_0x010c:
            r47.endReplaceableGroup()
            r2 = r10
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            r5 = 0
            int r10 = r0.f31599k
            androidx.compose.ui.text.input.VisualTransformation r11 = r0.f31608t
            r12 = 0
            androidx.compose.foundation.interaction.MutableInteractionSource r13 = r0.f31609u
            com.designsystem.ds_input_field.InputFieldCommonComposablesKt$InputField$1$3 r4 = new com.designsystem.ds_input_field.InputFieldCommonComposablesKt$InputField$1$3
            r24 = r4
            java.lang.String r15 = r0.f31611w
            r25 = r15
            androidx.compose.ui.text.TextStyle r15 = r0.f31612x
            r26 = r15
            java.lang.String r15 = r0.f31613y
            r27 = r15
            kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r15 = r0.f31614z
            r28 = r15
            kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r15 = r0.A
            r29 = r15
            kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r15 = r0.B
            r30 = r15
            com.designsystem.ds_input_field.OuterState r15 = r0.C
            r31 = r15
            boolean r15 = r0.f31596h
            r32 = r15
            androidx.compose.ui.unit.Dp r15 = r0.D
            r33 = r15
            java.lang.Integer r15 = r0.f31605q
            r34 = r15
            float r15 = r0.E
            r35 = r15
            kotlin.jvm.functions.Function0<kotlin.Unit> r15 = r0.f31597i
            r36 = r15
            boolean r15 = r0.F
            r37 = r15
            boolean r15 = r0.G
            r38 = r15
            int r15 = r0.f31598j
            r39 = r15
            int r15 = r0.f31610v
            r40 = r15
            int r15 = r0.H
            r41 = r15
            androidx.compose.runtime.MutableState<androidx.compose.ui.text.input.TextFieldValue> r15 = r0.f31601m
            r42 = r15
            androidx.compose.runtime.State<androidx.compose.ui.geometry.Offset> r15 = r0.I
            r43 = r15
            androidx.compose.runtime.MutableState<com.designsystem.ds_input_field.ContainerState> r15 = r0.J
            r44 = r15
            androidx.compose.runtime.MutableState<java.lang.Integer> r15 = r0.f31607s
            r45 = r15
            r24.<init>(r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45)
            r15 = -819902661(0xffffffffcf21473b, float:-2.70579994E9)
            r5 = 1
            androidx.compose.runtime.internal.ComposableLambda r15 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r14, r15, r5, r4)
            r5 = r48
            int r4 = androidx.compose.foundation.text.KeyboardActions.$stable
            int r4 = r4 << 21
            int r12 = r0.f31610v
            int r16 = r12 << 24
            r17 = 1879048192(0x70000000, float:1.58456325E29)
            r16 = r16 & r17
            r17 = r4 | r16
            int r4 = r12 >> 12
            r4 = r4 & 14
            r4 = r4 | 24960(0x6180, float:3.4976E-41)
            r18 = r4
            r19 = 2064(0x810, float:2.892E-42)
            r4 = r6
            r6 = r7
            r7 = r23
            r14 = r5
            r16 = r47
            r5 = 0
            r12 = 0
            androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField((androidx.compose.ui.text.input.TextFieldValue) r1, (kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.input.TextFieldValue, kotlin.Unit>) r2, (androidx.compose.ui.Modifier) r3, (boolean) r4, (boolean) r5, (androidx.compose.ui.text.TextStyle) r6, (androidx.compose.foundation.text.KeyboardOptions) r7, (androidx.compose.foundation.text.KeyboardActions) r8, (boolean) r9, (int) r10, (androidx.compose.ui.text.input.VisualTransformation) r11, (kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.TextLayoutResult, kotlin.Unit>) r12, (androidx.compose.foundation.interaction.MutableInteractionSource) r13, (androidx.compose.ui.graphics.Brush) r14, (kotlin.jvm.functions.Function3<? super kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r15, (androidx.compose.runtime.Composer) r16, (int) r17, (int) r18, (int) r19)
        L_0x01a3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.designsystem.ds_input_field.InputFieldCommonComposablesKt$InputField$1.invoke(androidx.compose.runtime.Composer, int):void");
    }
}
