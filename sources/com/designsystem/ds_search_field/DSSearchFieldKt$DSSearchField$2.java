package com.designsystem.ds_search_field;

import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.graphics.Color;
import com.designsystem.ds_theme.DSTheme;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class DSSearchFieldKt$DSSearchField$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f32582g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ MutableState<String> f32583h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ MutableState<String> f32584i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ FocusManager f32585j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f32586k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ String f32587l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f32588m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ int f32589n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSSearchFieldKt$DSSearchField$2(Modifier modifier, MutableState<String> mutableState, MutableState<String> mutableState2, FocusManager focusManager, Function0<Unit> function0, String str, Function0<Unit> function02, int i11) {
        super(2);
        this.f32582g = modifier;
        this.f32583h = mutableState;
        this.f32584i = mutableState2;
        this.f32585j = focusManager;
        this.f32586k = function0;
        this.f32587l = str;
        this.f32588m = function02;
        this.f32589n = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        Composer composer2 = composer;
        if (((i11 & 11) ^ 2) != 0 || !composer.getSkipping()) {
            DSTheme dSTheme = DSTheme.INSTANCE;
            ProvidedValue[] providedValueArr = {TextSelectionColorsKt.getLocalTextSelectionColors().provides(new TextSelectionColors(dSTheme.getColors(composer2, 0).m8793getDsPrimary1000d7_KjU(), Color.m2918copywmQWz5c$default(dSTheme.getColors(composer2, 0).m8793getDsPrimary1000d7_KjU(), 0.15f, 0.0f, 0.0f, 0.0f, 14, (Object) null), (DefaultConstructorMarker) null))};
            final Modifier modifier = this.f32582g;
            final MutableState<String> mutableState = this.f32583h;
            final MutableState<String> mutableState2 = this.f32584i;
            final FocusManager focusManager = this.f32585j;
            final Function0<Unit> function0 = this.f32586k;
            String str = this.f32587l;
            final String str2 = str;
            final Function0<Unit> function02 = this.f32588m;
            final int i12 = this.f32589n;
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda(composer2, -819890651, true, new Function2<Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v8, resolved type: kotlin.jvm.functions.Function1} */
                /* JADX WARNING: Multi-variable type inference failed */
                @androidx.compose.runtime.Composable
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final void invoke(@org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r44, int r45) {
                    /*
                        r43 = this;
                        r0 = r43
                        r14 = r44
                        r1 = r45 & 11
                        r1 = r1 ^ 2
                        if (r1 != 0) goto L_0x0016
                        boolean r1 = r44.getSkipping()
                        if (r1 != 0) goto L_0x0011
                        goto L_0x0016
                    L_0x0011:
                        r44.skipToGroupEnd()
                        goto L_0x0117
                    L_0x0016:
                        androidx.compose.runtime.MutableState<java.lang.String> r1 = r12
                        java.lang.String r1 = com.designsystem.ds_search_field.DSSearchFieldKt.m8553DSSearchField$lambda1(r1)
                        androidx.compose.foundation.text.KeyboardOptions r16 = new androidx.compose.foundation.text.KeyboardOptions
                        r3 = 0
                        r4 = 0
                        r5 = 0
                        androidx.compose.ui.text.input.ImeAction$Companion r2 = androidx.compose.ui.text.input.ImeAction.Companion
                        int r6 = r2.m5193getSearcheUduSuo()
                        r7 = 7
                        r8 = 0
                        r2 = r16
                        r2.<init>(r3, r4, r5, r6, r7, r8)
                        androidx.compose.foundation.text.KeyboardActions r8 = new androidx.compose.foundation.text.KeyboardActions
                        r18 = 0
                        r19 = 0
                        r20 = 0
                        r21 = 0
                        com.designsystem.ds_search_field.DSSearchFieldKt$DSSearchField$2$1$1 r2 = new com.designsystem.ds_search_field.DSSearchFieldKt$DSSearchField$2$1$1
                        androidx.compose.ui.focus.FocusManager r3 = r14
                        kotlin.jvm.functions.Function0<kotlin.Unit> r4 = r15
                        r2.<init>(r3, r4)
                        r23 = 0
                        r24 = 47
                        r25 = 0
                        r17 = r8
                        r22 = r2
                        r17.<init>(r18, r19, r20, r21, r22, r23, r24, r25)
                        com.designsystem.ds_theme.DSTheme r2 = com.designsystem.ds_theme.DSTheme.INSTANCE
                        r3 = 0
                        com.designsystem.ds_theme.DSTypography r4 = r2.getTypography(r14, r3)
                        androidx.compose.ui.text.TextStyle r17 = r4.getDsBody0()
                        com.designsystem.ds_theme.DSColors r4 = r2.getColors(r14, r3)
                        long r18 = r4.m8760getDsNeutral1000d7_KjU()
                        r20 = 0
                        r22 = 0
                        r24 = 0
                        r26 = 0
                        r27 = 0
                        r29 = 0
                        r30 = 0
                        r31 = 0
                        r32 = 0
                        r34 = 0
                        r35 = 0
                        r36 = 0
                        r37 = 0
                        r38 = 0
                        r40 = 0
                        r41 = 262142(0x3fffe, float:3.67339E-40)
                        r42 = 0
                        androidx.compose.ui.text.TextStyle r6 = androidx.compose.ui.text.TextStyle.m5046copyHL5avdY$default(r17, r18, r20, r22, r23, r24, r25, r26, r27, r29, r30, r31, r32, r34, r35, r36, r37, r38, r40, r41, r42)
                        androidx.compose.ui.graphics.SolidColor r7 = new androidx.compose.ui.graphics.SolidColor
                        com.designsystem.ds_theme.DSColors r2 = r2.getColors(r14, r3)
                        long r2 = r2.m8793getDsPrimary1000d7_KjU()
                        r4 = 0
                        r7.<init>(r2, r4)
                        androidx.compose.ui.Modifier r2 = r11
                        com.designsystem.ds_search_field.SearchField r3 = com.designsystem.ds_search_field.SearchField.INSTANCE
                        float r3 = r3.m8566getSearchFieldMinHeightD9Ej5fM()
                        r5 = 0
                        r15 = 1
                        androidx.compose.ui.Modifier r3 = androidx.compose.foundation.layout.SizeKt.m543defaultMinSizeVpY3zN4$default(r2, r5, r3, r15, r4)
                        androidx.compose.runtime.MutableState<java.lang.String> r2 = r12
                        androidx.compose.runtime.MutableState<java.lang.String> r4 = r13
                        r5 = -3686552(0xffffffffffc7bf68, float:NaN)
                        r14.startReplaceableGroup(r5)
                        boolean r5 = r14.changed((java.lang.Object) r2)
                        boolean r9 = r14.changed((java.lang.Object) r4)
                        r5 = r5 | r9
                        java.lang.Object r9 = r44.rememberedValue()
                        if (r5 != 0) goto L_0x00c5
                        androidx.compose.runtime.Composer$Companion r5 = androidx.compose.runtime.Composer.Companion
                        java.lang.Object r5 = r5.getEmpty()
                        if (r9 != r5) goto L_0x00cd
                    L_0x00c5:
                        com.designsystem.ds_search_field.DSSearchFieldKt$DSSearchField$2$1$2$1 r9 = new com.designsystem.ds_search_field.DSSearchFieldKt$DSSearchField$2$1$2$1
                        r9.<init>(r2, r4)
                        r14.updateRememberedValue(r9)
                    L_0x00cd:
                        r44.endReplaceableGroup()
                        r2 = r9
                        kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
                        r4 = 0
                        r5 = 0
                        r9 = 1
                        r10 = 0
                        r11 = 0
                        r12 = 0
                        r13 = 0
                        com.designsystem.ds_search_field.DSSearchFieldKt$DSSearchField$2$1$3 r4 = new com.designsystem.ds_search_field.DSSearchFieldKt$DSSearchField$2$1$3
                        java.lang.String r5 = r16
                        androidx.compose.runtime.MutableState<java.lang.String> r9 = r12
                        androidx.compose.runtime.MutableState<java.lang.String> r10 = r13
                        kotlin.jvm.functions.Function0<kotlin.Unit> r11 = r17
                        int r12 = r18
                        r17 = r4
                        r18 = r5
                        r19 = r9
                        r20 = r10
                        r21 = r11
                        r22 = r12
                        r17.<init>(r18, r19, r20, r21, r22)
                        r5 = -819890912(0xffffffffcf217520, float:-2.70880768E9)
                        androidx.compose.runtime.internal.ComposableLambda r15 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r14, r5, r15, r4)
                        int r4 = androidx.compose.foundation.text.KeyboardActions.$stable
                        int r4 = r4 << 21
                        r5 = 100663296(0x6000000, float:2.4074124E-35)
                        r17 = r4 | r5
                        r18 = 24576(0x6000, float:3.4438E-41)
                        r19 = 7704(0x1e18, float:1.0796E-41)
                        r4 = r7
                        r7 = r16
                        r14 = r4
                        r16 = r44
                        r4 = 0
                        r5 = 0
                        r9 = 1
                        r10 = 0
                        r11 = 0
                        r12 = 0
                        androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField((java.lang.String) r1, (kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit>) r2, (androidx.compose.ui.Modifier) r3, (boolean) r4, (boolean) r5, (androidx.compose.ui.text.TextStyle) r6, (androidx.compose.foundation.text.KeyboardOptions) r7, (androidx.compose.foundation.text.KeyboardActions) r8, (boolean) r9, (int) r10, (androidx.compose.ui.text.input.VisualTransformation) r11, (kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.TextLayoutResult, kotlin.Unit>) r12, (androidx.compose.foundation.interaction.MutableInteractionSource) r13, (androidx.compose.ui.graphics.Brush) r14, (kotlin.jvm.functions.Function3<? super kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r15, (androidx.compose.runtime.Composer) r16, (int) r17, (int) r18, (int) r19)
                    L_0x0117:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.designsystem.ds_search_field.DSSearchFieldKt$DSSearchField$2.AnonymousClass1.invoke(androidx.compose.runtime.Composer, int):void");
                }
            }), composer2, 56);
            return;
        }
        composer.skipToGroupEnd();
    }
}
