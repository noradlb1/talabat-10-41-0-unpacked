package com.designsystem.ds_input_field;

import android.content.Context;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.fragment.app.FragmentManager;
import com.designsystem.ds_input_field.country.DSCountryModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class PhoneFieldComposablesKt$PhoneNumberInputField$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f31791g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ String f31792h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ String f31793i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function2<DSCountryModel, String, Unit> f31794j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ MutableState<DSCountryModel> f31795k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ int f31796l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Function2<DSCountryModel, String, Unit> f31797m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ boolean f31798n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ OuterState f31799o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ ImeAction f31800p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ MutableState<VisualTransformation> f31801q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ FragmentManager f31802r;

    /* renamed from: s  reason: collision with root package name */
    public final /* synthetic */ Context f31803s;

    /* renamed from: t  reason: collision with root package name */
    public final /* synthetic */ String f31804t;

    /* renamed from: u  reason: collision with root package name */
    public final /* synthetic */ String f31805u;

    /* renamed from: v  reason: collision with root package name */
    public final /* synthetic */ String f31806v;

    /* renamed from: w  reason: collision with root package name */
    public final /* synthetic */ MutableState<Boolean> f31807w;

    /* renamed from: x  reason: collision with root package name */
    public final /* synthetic */ MutableState<List<DSCountryModel>> f31808x;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PhoneFieldComposablesKt$PhoneNumberInputField$2(Modifier modifier, String str, String str2, Function2<? super DSCountryModel, ? super String, Unit> function2, MutableState<DSCountryModel> mutableState, int i11, Function2<? super DSCountryModel, ? super String, Unit> function22, boolean z11, OuterState outerState, ImeAction imeAction, MutableState<VisualTransformation> mutableState2, FragmentManager fragmentManager, Context context, String str3, String str4, String str5, MutableState<Boolean> mutableState3, MutableState<List<DSCountryModel>> mutableState4) {
        super(2);
        this.f31791g = modifier;
        this.f31792h = str;
        this.f31793i = str2;
        this.f31794j = function2;
        this.f31795k = mutableState;
        this.f31796l = i11;
        this.f31797m = function22;
        this.f31798n = z11;
        this.f31799o = outerState;
        this.f31800p = imeAction;
        this.f31801q = mutableState2;
        this.f31802r = fragmentManager;
        this.f31803s = context;
        this.f31804t = str3;
        this.f31805u = str4;
        this.f31806v = str5;
        this.f31807w = mutableState3;
        this.f31808x = mutableState4;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r29v0, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v2, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX WARNING: Multi-variable type inference failed */
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(@org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r49, int r50) {
        /*
            r48 = this;
            r0 = r48
            r15 = r49
            r1 = r50 & 11
            r1 = r1 ^ 2
            if (r1 != 0) goto L_0x0016
            boolean r1 = r49.getSkipping()
            if (r1 != 0) goto L_0x0011
            goto L_0x0016
        L_0x0011:
            r49.skipToGroupEnd()
            goto L_0x015f
        L_0x0016:
            androidx.compose.runtime.MutableState<com.designsystem.ds_input_field.country.DSCountryModel> r1 = r0.f31795k
            com.designsystem.ds_input_field.country.DSCountryModel r1 = com.designsystem.ds_input_field.PhoneFieldComposablesKt.m8455PhoneNumberInputField_4_mkn5s$lambda7(r1)
            r2 = 0
            if (r1 != 0) goto L_0x0021
            r1 = r2
            goto L_0x0025
        L_0x0021:
            java.lang.String r1 = r1.getPrefix()
        L_0x0025:
            r3 = 1
            if (r1 == 0) goto L_0x0038
            com.designsystem.ds_input_field.PhoneFieldComposablesKt$PhoneNumberInputField$2$1 r1 = new com.designsystem.ds_input_field.PhoneFieldComposablesKt$PhoneNumberInputField$2$1
            androidx.compose.runtime.MutableState<com.designsystem.ds_input_field.country.DSCountryModel> r2 = r0.f31795k
            r1.<init>(r2)
            r2 = -819890486(0xffffffffcf2176ca, float:-2.70891674E9)
            androidx.compose.runtime.internal.ComposableLambda r1 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r15, r2, r3, r1)
            r10 = r1
            goto L_0x0039
        L_0x0038:
            r10 = r2
        L_0x0039:
            com.designsystem.ds_input_field.InputFieldCommon r1 = com.designsystem.ds_input_field.InputFieldCommon.INSTANCE
            float r16 = r1.m8409getSingleLineContainerMinHeightD9Ej5fM()
            androidx.compose.ui.text.input.KeyboardType$Companion r1 = androidx.compose.ui.text.input.KeyboardType.Companion
            int r1 = r1.m5226getPhonePjHm6EE()
            androidx.compose.runtime.MutableState<androidx.compose.ui.text.input.VisualTransformation> r2 = r0.f31801q
            androidx.compose.ui.text.input.VisualTransformation r2 = com.designsystem.ds_input_field.PhoneFieldComposablesKt.m8450PhoneNumberInputField_4_mkn5s$lambda10(r2)
            if (r2 != 0) goto L_0x0053
            androidx.compose.ui.text.input.VisualTransformation$Companion r2 = androidx.compose.ui.text.input.VisualTransformation.Companion
            androidx.compose.ui.text.input.VisualTransformation r2 = r2.getNone()
        L_0x0053:
            r23 = r2
            androidx.compose.ui.Modifier r2 = r0.f31791g
            java.lang.String r4 = r0.f31792h
            java.lang.String r5 = r0.f31793i
            r28 = 0
            kotlin.jvm.functions.Function2<com.designsystem.ds_input_field.country.DSCountryModel, java.lang.String, kotlin.Unit> r6 = r0.f31794j
            androidx.compose.runtime.MutableState<com.designsystem.ds_input_field.country.DSCountryModel> r7 = r0.f31795k
            r8 = -3686552(0xffffffffffc7bf68, float:NaN)
            r15.startReplaceableGroup(r8)
            boolean r9 = r15.changed((java.lang.Object) r6)
            boolean r11 = r15.changed((java.lang.Object) r7)
            r9 = r9 | r11
            java.lang.Object r11 = r49.rememberedValue()
            if (r9 != 0) goto L_0x007e
            androidx.compose.runtime.Composer$Companion r9 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r9 = r9.getEmpty()
            if (r11 != r9) goto L_0x0086
        L_0x007e:
            com.designsystem.ds_input_field.PhoneFieldComposablesKt$PhoneNumberInputField$2$2$1 r11 = new com.designsystem.ds_input_field.PhoneFieldComposablesKt$PhoneNumberInputField$2$2$1
            r11.<init>(r6, r7)
            r15.updateRememberedValue(r11)
        L_0x0086:
            r49.endReplaceableGroup()
            r29 = r11
            kotlin.jvm.functions.Function1 r29 = (kotlin.jvm.functions.Function1) r29
            kotlin.jvm.functions.Function2<com.designsystem.ds_input_field.country.DSCountryModel, java.lang.String, kotlin.Unit> r6 = r0.f31797m
            androidx.compose.runtime.MutableState<com.designsystem.ds_input_field.country.DSCountryModel> r7 = r0.f31795k
            r15.startReplaceableGroup(r8)
            boolean r8 = r15.changed((java.lang.Object) r6)
            boolean r9 = r15.changed((java.lang.Object) r7)
            r8 = r8 | r9
            java.lang.Object r9 = r49.rememberedValue()
            if (r8 != 0) goto L_0x00ab
            androidx.compose.runtime.Composer$Companion r8 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r8 = r8.getEmpty()
            if (r9 != r8) goto L_0x00b3
        L_0x00ab:
            com.designsystem.ds_input_field.PhoneFieldComposablesKt$PhoneNumberInputField$2$3$1 r9 = new com.designsystem.ds_input_field.PhoneFieldComposablesKt$PhoneNumberInputField$2$3$1
            r9.<init>(r6, r7)
            r15.updateRememberedValue(r9)
        L_0x00b3:
            r49.endReplaceableGroup()
            r6 = r9
            kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
            boolean r9 = r0.f31798n
            r7 = r9
            com.designsystem.ds_input_field.OuterState r8 = r0.f31799o
            com.designsystem.ds_input_field.PhoneFieldComposablesKt$PhoneNumberInputField$2$4 r11 = new com.designsystem.ds_input_field.PhoneFieldComposablesKt$PhoneNumberInputField$2$4
            int r12 = r0.f31796l
            androidx.compose.runtime.MutableState<com.designsystem.ds_input_field.country.DSCountryModel> r13 = r0.f31795k
            androidx.fragment.app.FragmentManager r14 = r0.f31802r
            android.content.Context r3 = r0.f31803s
            r42 = r6
            java.lang.String r6 = r0.f31804t
            r43 = r7
            java.lang.String r7 = r0.f31805u
            r44 = r8
            java.lang.String r8 = r0.f31806v
            r45 = r10
            androidx.compose.runtime.MutableState<java.lang.Boolean> r10 = r0.f31807w
            r46 = r5
            androidx.compose.runtime.MutableState<androidx.compose.ui.text.input.VisualTransformation> r5 = r0.f31801q
            r47 = r4
            androidx.compose.runtime.MutableState<java.util.List<com.designsystem.ds_input_field.country.DSCountryModel>> r4 = r0.f31808x
            r30 = r11
            r31 = r9
            r32 = r12
            r33 = r13
            r34 = r14
            r35 = r3
            r36 = r6
            r37 = r7
            r38 = r8
            r39 = r10
            r40 = r5
            r41 = r4
            r30.<init>(r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41)
            r3 = -819892739(0xffffffffcf216dfd, float:-2.70833997E9)
            r4 = 1
            androidx.compose.runtime.internal.ComposableLambda r9 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r15, r3, r4, r11)
            com.designsystem.ds_input_field.PhoneFieldComposablesKt$PhoneNumberInputField$2$5 r3 = new com.designsystem.ds_input_field.PhoneFieldComposablesKt$PhoneNumberInputField$2$5
            com.designsystem.ds_input_field.OuterState r5 = r0.f31799o
            boolean r6 = r0.f31798n
            int r7 = r0.f31796l
            r3.<init>(r5, r6, r7)
            r5 = -819890985(0xffffffffcf2174d7, float:-2.70878899E9)
            androidx.compose.runtime.internal.ComposableLambda r11 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r15, r5, r4, r3)
            r12 = 1
            r13 = 0
            r14 = 0
            androidx.compose.ui.text.input.KeyboardType r17 = androidx.compose.ui.text.input.KeyboardType.m5213boximpl(r1)
            androidx.compose.ui.text.input.ImeAction r1 = r0.f31800p
            r18 = r1
            r19 = 0
            com.designsystem.ds_input_field.PhoneFieldComposablesKt$PhoneNumberInputField$2$6 r20 = com.designsystem.ds_input_field.PhoneFieldComposablesKt$PhoneNumberInputField$2.AnonymousClass6.INSTANCE
            r21 = 0
            r22 = 1
            int r1 = r0.f31796l
            r3 = r1 & 14
            r4 = 100666368(0x6000c00, float:2.408294E-35)
            r3 = r3 | r4
            r4 = r1 & 112(0x70, float:1.57E-43)
            r3 = r3 | r4
            r4 = r1 & 896(0x380, float:1.256E-42)
            r3 = r3 | r4
            r4 = 3670016(0x380000, float:5.142788E-39)
            r4 = r4 & r1
            r3 = r3 | r4
            r4 = 29360128(0x1c00000, float:7.052966E-38)
            r1 = r1 & r4
            r24 = r3 | r1
            r25 = 18874422(0x1200036, float:2.938751E-38)
            r26 = 48
            r27 = 1323008(0x143000, float:1.853929E-39)
            r1 = r2
            r2 = r47
            r3 = r46
            r4 = r28
            r5 = r29
            r10 = r45
            r15 = r23
            r23 = r49
            r6 = r42
            r7 = r43
            r8 = r44
            com.designsystem.ds_input_field.InputFieldCommonComposablesKt.m8413InputFieldmytMHeg(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27)
        L_0x015f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.designsystem.ds_input_field.PhoneFieldComposablesKt$PhoneNumberInputField$2.invoke(androidx.compose.runtime.Composer, int):void");
    }
}
