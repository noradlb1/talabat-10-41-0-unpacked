package com.talabat.feature.ridertips.presentation.view.mainview.customtipinputviewstate;

import androidx.compose.runtime.MutableState;
import androidx.compose.ui.focus.FocusRequester;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aO\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\u000bH\u0001¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"CustomTipInputView", "", "ctaTitle", "", "text", "hint", "enabled", "", "onTextChange", "Lkotlin/Function1;", "onCtaTap", "Lkotlin/Function0;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "com_talabat_feature_ridertips_presentation_presentation"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class CustomTipInputViewKt {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v3, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX WARNING: Multi-variable type inference failed */
    @androidx.compose.runtime.ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void CustomTipInputView(@org.jetbrains.annotations.NotNull java.lang.String r33, @org.jetbrains.annotations.NotNull java.lang.String r34, @org.jetbrains.annotations.NotNull java.lang.String r35, boolean r36, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r37, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function0<kotlin.Unit> r38, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r39, int r40) {
        /*
            r11 = r33
            r10 = r34
            r9 = r35
            r8 = r37
            r7 = r38
            r6 = r40
            java.lang.String r0 = "ctaTitle"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.String r0 = "text"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "hint"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "onTextChange"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "onCtaTap"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            r0 = -1570081627(0xffffffffa26a74a5, float:-3.1774665E-18)
            r1 = r39
            androidx.compose.runtime.Composer r5 = r1.startRestartGroup(r0)
            r0 = r6 & 14
            if (r0 != 0) goto L_0x003d
            boolean r0 = r5.changed((java.lang.Object) r11)
            if (r0 == 0) goto L_0x003a
            r0 = 4
            goto L_0x003b
        L_0x003a:
            r0 = 2
        L_0x003b:
            r0 = r0 | r6
            goto L_0x003e
        L_0x003d:
            r0 = r6
        L_0x003e:
            r2 = r6 & 112(0x70, float:1.57E-43)
            if (r2 != 0) goto L_0x004e
            boolean r2 = r5.changed((java.lang.Object) r10)
            if (r2 == 0) goto L_0x004b
            r2 = 32
            goto L_0x004d
        L_0x004b:
            r2 = 16
        L_0x004d:
            r0 = r0 | r2
        L_0x004e:
            r2 = r6 & 896(0x380, float:1.256E-42)
            if (r2 != 0) goto L_0x005e
            boolean r2 = r5.changed((java.lang.Object) r9)
            if (r2 == 0) goto L_0x005b
            r2 = 256(0x100, float:3.59E-43)
            goto L_0x005d
        L_0x005b:
            r2 = 128(0x80, float:1.794E-43)
        L_0x005d:
            r0 = r0 | r2
        L_0x005e:
            r2 = r6 & 7168(0x1c00, float:1.0045E-41)
            r4 = r36
            if (r2 != 0) goto L_0x0070
            boolean r2 = r5.changed((boolean) r4)
            if (r2 == 0) goto L_0x006d
            r2 = 2048(0x800, float:2.87E-42)
            goto L_0x006f
        L_0x006d:
            r2 = 1024(0x400, float:1.435E-42)
        L_0x006f:
            r0 = r0 | r2
        L_0x0070:
            r2 = 57344(0xe000, float:8.0356E-41)
            r3 = r6 & r2
            if (r3 != 0) goto L_0x0083
            boolean r3 = r5.changed((java.lang.Object) r8)
            if (r3 == 0) goto L_0x0080
            r3 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0082
        L_0x0080:
            r3 = 8192(0x2000, float:1.14794E-41)
        L_0x0082:
            r0 = r0 | r3
        L_0x0083:
            r3 = 458752(0x70000, float:6.42848E-40)
            r3 = r3 & r6
            if (r3 != 0) goto L_0x0094
            boolean r3 = r5.changed((java.lang.Object) r7)
            if (r3 == 0) goto L_0x0091
            r3 = 131072(0x20000, float:1.83671E-40)
            goto L_0x0093
        L_0x0091:
            r3 = 65536(0x10000, float:9.18355E-41)
        L_0x0093:
            r0 = r0 | r3
        L_0x0094:
            r3 = 374491(0x5b6db, float:5.24774E-40)
            r3 = r3 & r0
            r12 = 74898(0x12492, float:1.04954E-40)
            if (r3 != r12) goto L_0x00ab
            boolean r3 = r5.getSkipping()
            if (r3 != 0) goto L_0x00a4
            goto L_0x00ab
        L_0x00a4:
            r5.skipToGroupEnd()
            r16 = r5
            goto L_0x0285
        L_0x00ab:
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            com.designsystem.ds_theme.DSTheme r15 = com.designsystem.ds_theme.DSTheme.INSTANCE
            r14 = 8
            com.designsystem.ds_theme.DSDimens r12 = r15.getDimens(r5, r14)
            float r13 = r12.m8842getDsSD9Ej5fM()
            r16 = 0
            com.designsystem.ds_theme.DSDimens r12 = r15.getDimens(r5, r14)
            float r17 = r12.m8842getDsSD9Ej5fM()
            com.designsystem.ds_theme.DSDimens r12 = r15.getDimens(r5, r14)
            float r18 = r12.m8842getDsSD9Ej5fM()
            r19 = 2
            r20 = 0
            r12 = r3
            r14 = r16
            r32 = r15
            r15 = r17
            r16 = r18
            r17 = r19
            r18 = r20
            androidx.compose.ui.Modifier r12 = androidx.compose.foundation.layout.PaddingKt.m490paddingqDBjuR0$default(r12, r13, r14, r15, r16, r17, r18)
            r13 = -483455358(0xffffffffe32f0e82, float:-3.2292256E21)
            r5.startReplaceableGroup(r13)
            androidx.compose.foundation.layout.Arrangement r13 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$Vertical r13 = r13.getTop()
            androidx.compose.ui.Alignment$Companion r14 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Horizontal r14 = r14.getStart()
            r15 = 0
            androidx.compose.ui.layout.MeasurePolicy r13 = androidx.compose.foundation.layout.ColumnKt.columnMeasurePolicy(r13, r14, r5, r15)
            r14 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r5.startReplaceableGroup(r14)
            androidx.compose.runtime.ProvidableCompositionLocal r14 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            java.lang.Object r14 = r5.consume(r14)
            androidx.compose.ui.unit.Density r14 = (androidx.compose.ui.unit.Density) r14
            androidx.compose.runtime.ProvidableCompositionLocal r2 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            java.lang.Object r2 = r5.consume(r2)
            androidx.compose.ui.unit.LayoutDirection r2 = (androidx.compose.ui.unit.LayoutDirection) r2
            androidx.compose.runtime.ProvidableCompositionLocal r1 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            java.lang.Object r1 = r5.consume(r1)
            androidx.compose.ui.platform.ViewConfiguration r1 = (androidx.compose.ui.platform.ViewConfiguration) r1
            androidx.compose.ui.node.ComposeUiNode$Companion r17 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r15 = r17.getConstructor()
            kotlin.jvm.functions.Function3 r12 = androidx.compose.ui.layout.LayoutKt.materializerOf(r12)
            androidx.compose.runtime.Applier r4 = r5.getApplier()
            boolean r4 = r4 instanceof androidx.compose.runtime.Applier
            if (r4 != 0) goto L_0x0130
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0130:
            r5.startReusableNode()
            boolean r4 = r5.getInserting()
            if (r4 == 0) goto L_0x013d
            r5.createNode(r15)
            goto L_0x0140
        L_0x013d:
            r5.useNode()
        L_0x0140:
            r5.disableReusing()
            androidx.compose.runtime.Composer r4 = androidx.compose.runtime.Updater.m2536constructorimpl(r5)
            kotlin.jvm.functions.Function2 r15 = r17.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r4, r13, r15)
            kotlin.jvm.functions.Function2 r13 = r17.getSetDensity()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r4, r14, r13)
            kotlin.jvm.functions.Function2 r13 = r17.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r4, r2, r13)
            kotlin.jvm.functions.Function2 r2 = r17.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r4, r1, r2)
            r5.enableReusing()
            androidx.compose.runtime.Composer r1 = androidx.compose.runtime.SkippableUpdater.m2527constructorimpl(r5)
            androidx.compose.runtime.SkippableUpdater r1 = androidx.compose.runtime.SkippableUpdater.m2526boximpl(r1)
            r2 = 0
            java.lang.Integer r4 = java.lang.Integer.valueOf(r2)
            r12.invoke(r1, r5, r4)
            r1 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r5.startReplaceableGroup(r1)
            r1 = -1163856341(0xffffffffbaa0f62b, float:-0.0012280395)
            r5.startReplaceableGroup(r1)
            androidx.compose.foundation.layout.ColumnScopeInstance r1 = androidx.compose.foundation.layout.ColumnScopeInstance.INSTANCE
            r1 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r5.startReplaceableGroup(r1)
            java.lang.Object r1 = r5.rememberedValue()
            androidx.compose.runtime.Composer$Companion r4 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r12 = r4.getEmpty()
            if (r1 != r12) goto L_0x01a4
            androidx.compose.ui.focus.FocusRequester r1 = new androidx.compose.ui.focus.FocusRequester
            r1.<init>()
            r12 = 0
            r13 = 2
            androidx.compose.runtime.MutableState r1 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r1, r12, r13, r12)
            r5.updateRememberedValue(r1)
        L_0x01a4:
            r5.endReplaceableGroup()
            androidx.compose.runtime.MutableState r1 = (androidx.compose.runtime.MutableState) r1
            androidx.compose.ui.focus.FocusRequester r12 = m10290CustomTipInputView$lambda4$lambda1(r1)
            androidx.compose.ui.Modifier r12 = androidx.compose.ui.focus.FocusRequesterModifierKt.focusRequester(r3, r12)
            androidx.compose.ui.text.input.KeyboardType$Companion r13 = androidx.compose.ui.text.input.KeyboardType.Companion
            int r24 = r13.m5223getNumberPjHm6EE()
            androidx.compose.ui.text.input.ImeAction$Companion r13 = androidx.compose.ui.text.input.ImeAction.Companion
            int r25 = r13.m5188getDoneeUduSuo()
            r14 = 0
            r15 = 1157296644(0x44faf204, float:2007.563)
            r5.startReplaceableGroup(r15)
            boolean r13 = r5.changed((java.lang.Object) r7)
            java.lang.Object r2 = r5.rememberedValue()
            if (r13 != 0) goto L_0x01d4
            java.lang.Object r13 = r4.getEmpty()
            if (r2 != r13) goto L_0x01dc
        L_0x01d4:
            com.talabat.feature.ridertips.presentation.view.mainview.customtipinputviewstate.CustomTipInputViewKt$CustomTipInputView$1$1$1 r2 = new com.talabat.feature.ridertips.presentation.view.mainview.customtipinputviewstate.CustomTipInputViewKt$CustomTipInputView$1$1$1
            r2.<init>(r7)
            r5.updateRememberedValue(r2)
        L_0x01dc:
            r5.endReplaceableGroup()
            r17 = r2
            kotlin.jvm.functions.Function1 r17 = (kotlin.jvm.functions.Function1) r17
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r26 = 0
            r27 = 0
            r2 = r0 & 112(0x70, float:1.57E-43)
            int r13 = r0 << 3
            r15 = r13 & 7168(0x1c00, float:1.0045E-41)
            r2 = r2 | r15
            r15 = 57344(0xe000, float:8.0356E-41)
            r29 = r0 & r15
            r29 = r2 | r29
            r30 = 0
            r31 = 53188(0xcfc4, float:7.4532E-41)
            r2 = r13
            r13 = r34
            r15 = r35
            r16 = r37
            r28 = r5
            com.designsystem.ds_input_field.DSTextFieldKt.m8389DSTextFieldjAliMPc(r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31)
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            r13 = 1157296644(0x44faf204, float:2007.563)
            r5.startReplaceableGroup(r13)
            boolean r13 = r5.changed((java.lang.Object) r1)
            java.lang.Object r14 = r5.rememberedValue()
            if (r13 != 0) goto L_0x022a
            java.lang.Object r4 = r4.getEmpty()
            if (r14 != r4) goto L_0x0232
        L_0x022a:
            com.talabat.feature.ridertips.presentation.view.mainview.customtipinputviewstate.CustomTipInputViewKt$CustomTipInputView$1$2$1 r14 = new com.talabat.feature.ridertips.presentation.view.mainview.customtipinputviewstate.CustomTipInputViewKt$CustomTipInputView$1$2$1
            r14.<init>(r1)
            r5.updateRememberedValue(r14)
        L_0x0232:
            r5.endReplaceableGroup()
            kotlin.jvm.functions.Function1 r14 = (kotlin.jvm.functions.Function1) r14
            r1 = 0
            androidx.compose.runtime.EffectsKt.DisposableEffect((java.lang.Object) r12, (kotlin.jvm.functions.Function1<? super androidx.compose.runtime.DisposableEffectScope, ? extends androidx.compose.runtime.DisposableEffectResult>) r14, (androidx.compose.runtime.Composer) r5, (int) r1)
            r4 = r32
            r12 = 8
            com.designsystem.ds_theme.DSDimens r4 = r4.getDimens(r5, r12)
            float r4 = r4.m8842getDsSD9Ej5fM()
            androidx.compose.ui.Modifier r3 = androidx.compose.foundation.layout.SizeKt.m544height3ABfNKs(r3, r4)
            androidx.compose.foundation.layout.SpacerKt.Spacer(r3, r5, r1)
            r1 = 0
            r3 = 0
            r4 = 0
            r12 = 0
            r13 = 0
            r14 = r0 & 14
            r15 = 57344(0xe000, float:8.0356E-41)
            r2 = r2 & r15
            r2 = r2 | r14
            int r0 = r0 << 6
            r14 = 29360128(0x1c00000, float:7.052966E-38)
            r0 = r0 & r14
            r14 = r2 | r0
            r15 = 110(0x6e, float:1.54E-43)
            r0 = r33
            r2 = r3
            r3 = r4
            r4 = r36
            r16 = r5
            r5 = r12
            r6 = r13
            r7 = r38
            r8 = r16
            r9 = r14
            r10 = r15
            com.designsystem.ds_button_v2.DSSecondaryButtonKt.DSSecondaryButton(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            r16.endReplaceableGroup()
            r16.endReplaceableGroup()
            r16.endNode()
            r16.endReplaceableGroup()
            r16.endReplaceableGroup()
        L_0x0285:
            androidx.compose.runtime.ScopeUpdateScope r8 = r16.endRestartGroup()
            if (r8 != 0) goto L_0x028c
            goto L_0x02a3
        L_0x028c:
            com.talabat.feature.ridertips.presentation.view.mainview.customtipinputviewstate.CustomTipInputViewKt$CustomTipInputView$2 r9 = new com.talabat.feature.ridertips.presentation.view.mainview.customtipinputviewstate.CustomTipInputViewKt$CustomTipInputView$2
            r0 = r9
            r1 = r33
            r2 = r34
            r3 = r35
            r4 = r36
            r5 = r37
            r6 = r38
            r7 = r40
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            r8.updateScope(r9)
        L_0x02a3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.ridertips.presentation.view.mainview.customtipinputviewstate.CustomTipInputViewKt.CustomTipInputView(java.lang.String, java.lang.String, java.lang.String, boolean, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: CustomTipInputView$lambda-4$lambda-1  reason: not valid java name */
    public static final FocusRequester m10290CustomTipInputView$lambda4$lambda1(MutableState<FocusRequester> mutableState) {
        return mutableState.getValue();
    }
}
