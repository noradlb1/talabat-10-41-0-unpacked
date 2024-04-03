package com.talabat.feature.ridertips.presentation.view.mainview.tipoptionsviewstate;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aq\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u000326\u0010\u0004\u001a2\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\r2\u0006\u0010\u000f\u001a\u00020\nH\u0001¢\u0006\u0002\u0010\u0010¨\u0006\u0011"}, d2 = {"TipOptionsView", "", "tipOptionsDetails", "Lcom/talabat/feature/ridertips/presentation/displaymodel/TipOptionsDetailsDisplayModel;", "onTipOptionTap", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "index", "", "selected", "onReuseTipTap", "Lkotlin/Function0;", "onClearTipTap", "isDefaultTipEnabled", "(Lcom/talabat/feature/ridertips/presentation/displaymodel/TipOptionsDetailsDisplayModel;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;ZLandroidx/compose/runtime/Composer;I)V", "com_talabat_feature_ridertips_presentation_presentation"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class TipOptionsViewKt {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v11, resolved type: kotlin.jvm.functions.Function0} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v13, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX WARNING: Multi-variable type inference failed */
    @androidx.compose.runtime.ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void TipOptionsView(@org.jetbrains.annotations.NotNull com.talabat.feature.ridertips.presentation.displaymodel.TipOptionsDetailsDisplayModel r52, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super java.lang.Integer, ? super java.lang.Boolean, kotlin.Unit> r53, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function0<kotlin.Unit> r54, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function0<kotlin.Unit> r55, boolean r56, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r57, int r58) {
        /*
            r1 = r52
            r2 = r53
            r3 = r54
            r4 = r55
            r5 = r56
            java.lang.String r0 = "tipOptionsDetails"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.String r0 = "onTipOptionTap"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "onReuseTipTap"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "onClearTipTap"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            r0 = -1191447990(0xffffffffb8fbf24a, float:-1.20137425E-4)
            r6 = r57
            androidx.compose.runtime.Composer r0 = r6.startRestartGroup(r0)
            androidx.compose.ui.Modifier$Companion r15 = androidx.compose.ui.Modifier.Companion
            r7 = 0
            r8 = 0
            r9 = 0
            com.designsystem.ds_theme.DSTheme r14 = com.designsystem.ds_theme.DSTheme.INSTANCE
            r13 = 8
            com.designsystem.ds_theme.DSDimens r6 = r14.getDimens(r0, r13)
            float r10 = r6.m8842getDsSD9Ej5fM()
            r11 = 7
            r12 = 0
            r6 = r15
            androidx.compose.ui.Modifier r6 = androidx.compose.foundation.layout.PaddingKt.m490paddingqDBjuR0$default(r6, r7, r8, r9, r10, r11, r12)
            r7 = -483455358(0xffffffffe32f0e82, float:-3.2292256E21)
            r0.startReplaceableGroup(r7)
            androidx.compose.foundation.layout.Arrangement r18 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$Vertical r7 = r18.getTop()
            androidx.compose.ui.Alignment$Companion r19 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Horizontal r8 = r19.getStart()
            r12 = 0
            java.lang.Integer r11 = java.lang.Integer.valueOf(r12)
            androidx.compose.ui.layout.MeasurePolicy r7 = androidx.compose.foundation.layout.ColumnKt.columnMeasurePolicy(r7, r8, r0, r12)
            r10 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r0.startReplaceableGroup(r10)
            androidx.compose.runtime.ProvidableCompositionLocal r8 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            java.lang.Object r8 = r0.consume(r8)
            androidx.compose.ui.unit.Density r8 = (androidx.compose.ui.unit.Density) r8
            androidx.compose.runtime.ProvidableCompositionLocal r9 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            java.lang.Object r9 = r0.consume(r9)
            androidx.compose.ui.unit.LayoutDirection r9 = (androidx.compose.ui.unit.LayoutDirection) r9
            androidx.compose.runtime.ProvidableCompositionLocal r10 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            java.lang.Object r10 = r0.consume(r10)
            androidx.compose.ui.platform.ViewConfiguration r10 = (androidx.compose.ui.platform.ViewConfiguration) r10
            androidx.compose.ui.node.ComposeUiNode$Companion r20 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r12 = r20.getConstructor()
            kotlin.jvm.functions.Function3 r6 = androidx.compose.ui.layout.LayoutKt.materializerOf(r6)
            androidx.compose.runtime.Applier r13 = r0.getApplier()
            boolean r13 = r13 instanceof androidx.compose.runtime.Applier
            if (r13 != 0) goto L_0x0094
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0094:
            r0.startReusableNode()
            boolean r13 = r0.getInserting()
            if (r13 == 0) goto L_0x00a1
            r0.createNode(r12)
            goto L_0x00a4
        L_0x00a1:
            r0.useNode()
        L_0x00a4:
            r0.disableReusing()
            androidx.compose.runtime.Composer r12 = androidx.compose.runtime.Updater.m2536constructorimpl(r0)
            kotlin.jvm.functions.Function2 r13 = r20.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r12, r7, r13)
            kotlin.jvm.functions.Function2 r7 = r20.getSetDensity()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r12, r8, r7)
            kotlin.jvm.functions.Function2 r7 = r20.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r12, r9, r7)
            kotlin.jvm.functions.Function2 r7 = r20.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r12, r10, r7)
            r0.enableReusing()
            androidx.compose.runtime.Composer r7 = androidx.compose.runtime.SkippableUpdater.m2527constructorimpl(r0)
            androidx.compose.runtime.SkippableUpdater r7 = androidx.compose.runtime.SkippableUpdater.m2526boximpl(r7)
            r6.invoke(r7, r0, r11)
            r13 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r0.startReplaceableGroup(r13)
            r6 = -1163856341(0xffffffffbaa0f62b, float:-0.0012280395)
            r0.startReplaceableGroup(r6)
            androidx.compose.foundation.layout.ColumnScopeInstance r12 = androidx.compose.foundation.layout.ColumnScopeInstance.INSTANCE
            r6 = 0
            r10 = 1
            r9 = 0
            androidx.compose.ui.Modifier r6 = androidx.compose.foundation.layout.SizeKt.fillMaxWidth$default(r15, r6, r10, r9)
            r7 = 0
            r8 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            com.talabat.feature.ridertips.presentation.view.mainview.tipoptionsviewstate.TipOptionsViewKt$TipOptionsView$1$1 r13 = new com.talabat.feature.ridertips.presentation.view.mainview.tipoptionsviewstate.TipOptionsViewKt$TipOptionsView$1$1
            r13.<init>(r1, r5, r2)
            r27 = 6
            r28 = 254(0xfe, float:3.56E-43)
            r9 = r21
            r10 = r22
            r33 = r11
            r11 = r23
            r34 = r12
            r12 = r24
            r16 = r13
            r13 = r25
            r38 = r14
            r14 = r16
            r39 = r15
            r15 = r0
            r16 = r27
            r17 = r28
            androidx.compose.foundation.lazy.LazyDslKt.LazyRow(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
            boolean r6 = r52.getReuseTipDisplayed()
            if (r6 == 0) goto L_0x0402
            if (r5 != 0) goto L_0x02e6
            r6 = 1588859523(0x5eb41283, float:6.4877888E18)
            r0.startReplaceableGroup(r6)
            r14 = r38
            r15 = 8
            com.designsystem.ds_theme.DSDimens r6 = r14.getDimens(r0, r15)
            float r6 = r6.m8842getDsSD9Ej5fM()
            r12 = r39
            androidx.compose.ui.Modifier r6 = androidx.compose.foundation.layout.SizeKt.m544height3ABfNKs(r12, r6)
            r11 = 0
            androidx.compose.foundation.layout.SpacerKt.Spacer(r6, r0, r11)
            int r6 = r52.getReuseTipTitleResId()
            java.lang.String r25 = androidx.compose.ui.res.StringResources_androidKt.stringResource(r6, r0, r11)
            androidx.compose.ui.Alignment$Vertical r6 = r19.getCenterVertically()
            r7 = 693286680(0x2952b718, float:4.6788176E-14)
            r0.startReplaceableGroup(r7)
            androidx.compose.foundation.layout.Arrangement$Horizontal r7 = r18.getStart()
            r8 = 48
            androidx.compose.ui.layout.MeasurePolicy r6 = androidx.compose.foundation.layout.RowKt.rowMeasurePolicy(r7, r6, r0, r8)
            r7 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r0.startReplaceableGroup(r7)
            androidx.compose.runtime.ProvidableCompositionLocal r7 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            java.lang.Object r7 = r0.consume(r7)
            androidx.compose.ui.unit.Density r7 = (androidx.compose.ui.unit.Density) r7
            androidx.compose.runtime.ProvidableCompositionLocal r8 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            java.lang.Object r8 = r0.consume(r8)
            androidx.compose.ui.unit.LayoutDirection r8 = (androidx.compose.ui.unit.LayoutDirection) r8
            androidx.compose.runtime.ProvidableCompositionLocal r9 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            java.lang.Object r9 = r0.consume(r9)
            androidx.compose.ui.platform.ViewConfiguration r9 = (androidx.compose.ui.platform.ViewConfiguration) r9
            kotlin.jvm.functions.Function0 r10 = r20.getConstructor()
            kotlin.jvm.functions.Function3 r13 = androidx.compose.ui.layout.LayoutKt.materializerOf(r12)
            androidx.compose.runtime.Applier r11 = r0.getApplier()
            boolean r11 = r11 instanceof androidx.compose.runtime.Applier
            if (r11 != 0) goto L_0x0194
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0194:
            r0.startReusableNode()
            boolean r11 = r0.getInserting()
            if (r11 == 0) goto L_0x01a1
            r0.createNode(r10)
            goto L_0x01a4
        L_0x01a1:
            r0.useNode()
        L_0x01a4:
            r0.disableReusing()
            androidx.compose.runtime.Composer r10 = androidx.compose.runtime.Updater.m2536constructorimpl(r0)
            kotlin.jvm.functions.Function2 r11 = r20.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r10, r6, r11)
            kotlin.jvm.functions.Function2 r6 = r20.getSetDensity()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r10, r7, r6)
            kotlin.jvm.functions.Function2 r6 = r20.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r10, r8, r6)
            kotlin.jvm.functions.Function2 r6 = r20.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r10, r9, r6)
            r0.enableReusing()
            androidx.compose.runtime.Composer r6 = androidx.compose.runtime.SkippableUpdater.m2527constructorimpl(r0)
            androidx.compose.runtime.SkippableUpdater r6 = androidx.compose.runtime.SkippableUpdater.m2526boximpl(r6)
            r8 = r33
            r13.invoke(r6, r0, r8)
            r6 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r0.startReplaceableGroup(r6)
            r6 = -678309503(0xffffffffd791d181, float:-3.20657997E14)
            r0.startReplaceableGroup(r6)
            androidx.compose.foundation.layout.RowScopeInstance r6 = androidx.compose.foundation.layout.RowScopeInstance.INSTANCE
            com.designsystem.ds_theme.DSDimens r6 = r14.getDimens(r0, r15)
            float r6 = r6.m8842getDsSD9Ej5fM()
            androidx.compose.ui.Modifier r6 = androidx.compose.foundation.layout.SizeKt.m563width3ABfNKs(r12, r6)
            r11 = 0
            androidx.compose.foundation.layout.SpacerKt.Spacer(r6, r0, r11)
            com.talabat.feature.ridertips.presentation.view.mainview.tipoptionsviewstate.TipOptionsViewKt$TipOptionsView$1$2$1 r6 = com.talabat.feature.ridertips.presentation.view.mainview.tipoptionsviewstate.TipOptionsViewKt$TipOptionsView$1$2$1.INSTANCE
            r7 = 0
            r8 = 1
            androidx.compose.ui.Modifier r6 = androidx.compose.ui.semantics.SemanticsModifierKt.semantics$default(r12, r11, r6, r8, r7)
            boolean r7 = r52.getReuseTipSelected()
            r8 = 0
            r9 = 1157296644(0x44faf204, float:2007.563)
            r0.startReplaceableGroup(r9)
            boolean r9 = r0.changed((java.lang.Object) r3)
            java.lang.Object r10 = r0.rememberedValue()
            if (r9 != 0) goto L_0x021a
            androidx.compose.runtime.Composer$Companion r9 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r9 = r9.getEmpty()
            if (r10 != r9) goto L_0x0222
        L_0x021a:
            com.talabat.feature.ridertips.presentation.view.mainview.tipoptionsviewstate.TipOptionsViewKt$TipOptionsView$1$2$2$1 r10 = new com.talabat.feature.ridertips.presentation.view.mainview.tipoptionsviewstate.TipOptionsViewKt$TipOptionsView$1$2$2$1
            r10.<init>(r3)
            r0.updateRememberedValue(r10)
        L_0x0222:
            r0.endReplaceableGroup()
            r9 = r10
            kotlin.jvm.functions.Function1 r9 = (kotlin.jvm.functions.Function1) r9
            r13 = 0
            r16 = 4
            r10 = r0
            r11 = r13
            r13 = r12
            r12 = r16
            com.designsystem.ds_checkbox_v2.DSCheckboxKt.DSCheckbox(r6, r7, r8, r9, r10, r11, r12)
            com.designsystem.ds_theme.DSDimens r6 = r14.getDimens(r0, r15)
            float r6 = r6.m8842getDsSD9Ej5fM()
            androidx.compose.ui.Modifier r6 = androidx.compose.foundation.layout.SizeKt.m563width3ABfNKs(r13, r6)
            r9 = 0
            androidx.compose.foundation.layout.SpacerKt.Spacer(r6, r0, r9)
            com.designsystem.ds_theme.DSTypography r6 = r14.getTypography(r0, r15)
            androidx.compose.ui.text.TextStyle r26 = r6.getDsBody1()
            com.designsystem.ds_theme.DSColors r6 = r14.getColors(r0, r15)
            long r27 = r6.m8760getDsNeutral1000d7_KjU()
            r29 = 0
            r31 = 0
            r32 = 0
            r33 = 0
            r34 = 0
            r35 = 0
            r36 = 0
            r38 = 0
            r39 = 0
            r40 = 0
            r41 = 0
            r43 = 0
            r44 = 0
            r45 = 0
            r46 = 0
            r47 = 0
            r49 = 0
            r50 = 262142(0x3fffe, float:3.67339E-40)
            r51 = 0
            androidx.compose.ui.text.TextStyle r26 = androidx.compose.ui.text.TextStyle.m5046copyHL5avdY$default(r26, r27, r29, r31, r32, r33, r34, r35, r36, r38, r39, r40, r41, r43, r44, r45, r46, r47, r49, r50, r51)
            r7 = 0
            r8 = 0
            r9 = 0
            r6 = 1157296644(0x44faf204, float:2007.563)
            r0.startReplaceableGroup(r6)
            boolean r6 = r0.changed((java.lang.Object) r3)
            java.lang.Object r10 = r0.rememberedValue()
            if (r6 != 0) goto L_0x0299
            androidx.compose.runtime.Composer$Companion r6 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r6 = r6.getEmpty()
            if (r10 != r6) goto L_0x02a1
        L_0x0299:
            com.talabat.feature.ridertips.presentation.view.mainview.tipoptionsviewstate.TipOptionsViewKt$TipOptionsView$1$2$3$1 r10 = new com.talabat.feature.ridertips.presentation.view.mainview.tipoptionsviewstate.TipOptionsViewKt$TipOptionsView$1$2$3$1
            r10.<init>(r3)
            r0.updateRememberedValue(r10)
        L_0x02a1:
            r0.endReplaceableGroup()
            kotlin.jvm.functions.Function0 r10 = (kotlin.jvm.functions.Function0) r10
            r11 = 7
            r12 = 0
            r6 = r13
            androidx.compose.ui.Modifier r7 = androidx.compose.foundation.ClickableKt.m196clickableXHw0xAI$default(r6, r7, r8, r9, r10, r11, r12)
            r8 = 0
            r10 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r27 = 0
            r28 = 0
            r29 = 32764(0x7ffc, float:4.5912E-41)
            r6 = r25
            r25 = r26
            r26 = r0
            androidx.compose.material.TextKt.m1461TextfLXpl1I(r6, r7, r8, r10, r12, r13, r14, r15, r17, r18, r19, r21, r22, r23, r24, r25, r26, r27, r28, r29)
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r0.endNode()
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            goto L_0x0402
        L_0x02e6:
            r8 = r33
            r14 = r38
            r13 = r39
            r6 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r7 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r9 = 0
            r15 = 8
            r10 = 1588860664(0x5eb416f8, float:6.488416E18)
            r0.startReplaceableGroup(r10)
            com.designsystem.ds_theme.DSDimens r10 = r14.getDimens(r0, r15)
            float r10 = r10.m8844getDsXsD9Ej5fM()
            androidx.compose.ui.Modifier r10 = androidx.compose.foundation.layout.SizeKt.m544height3ABfNKs(r13, r10)
            androidx.compose.foundation.layout.SpacerKt.Spacer(r10, r0, r9)
            androidx.compose.ui.Alignment$Horizontal r10 = r19.getEnd()
            r11 = r34
            androidx.compose.ui.Modifier r21 = r11.align(r13, r10)
            r22 = 0
            r23 = 0
            com.designsystem.ds_theme.DSDimens r10 = r14.getDimens(r0, r15)
            float r24 = r10.m8842getDsSD9Ej5fM()
            r25 = 0
            r26 = 11
            r27 = 0
            androidx.compose.ui.Modifier r10 = androidx.compose.foundation.layout.PaddingKt.m490paddingqDBjuR0$default(r21, r22, r23, r24, r25, r26, r27)
            r11 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r0.startReplaceableGroup(r11)
            androidx.compose.ui.Alignment r11 = r19.getTopStart()
            androidx.compose.ui.layout.MeasurePolicy r11 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r11, r9, r0, r9)
            r0.startReplaceableGroup(r7)
            androidx.compose.runtime.ProvidableCompositionLocal r7 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            java.lang.Object r7 = r0.consume(r7)
            androidx.compose.ui.unit.Density r7 = (androidx.compose.ui.unit.Density) r7
            androidx.compose.runtime.ProvidableCompositionLocal r12 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            java.lang.Object r12 = r0.consume(r12)
            androidx.compose.ui.unit.LayoutDirection r12 = (androidx.compose.ui.unit.LayoutDirection) r12
            androidx.compose.runtime.ProvidableCompositionLocal r13 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            java.lang.Object r13 = r0.consume(r13)
            androidx.compose.ui.platform.ViewConfiguration r13 = (androidx.compose.ui.platform.ViewConfiguration) r13
            kotlin.jvm.functions.Function0 r14 = r20.getConstructor()
            kotlin.jvm.functions.Function3 r10 = androidx.compose.ui.layout.LayoutKt.materializerOf(r10)
            androidx.compose.runtime.Applier r15 = r0.getApplier()
            boolean r15 = r15 instanceof androidx.compose.runtime.Applier
            if (r15 != 0) goto L_0x036c
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x036c:
            r0.startReusableNode()
            boolean r15 = r0.getInserting()
            if (r15 == 0) goto L_0x0379
            r0.createNode(r14)
            goto L_0x037c
        L_0x0379:
            r0.useNode()
        L_0x037c:
            r0.disableReusing()
            androidx.compose.runtime.Composer r14 = androidx.compose.runtime.Updater.m2536constructorimpl(r0)
            kotlin.jvm.functions.Function2 r15 = r20.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r14, r11, r15)
            kotlin.jvm.functions.Function2 r11 = r20.getSetDensity()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r14, r7, r11)
            kotlin.jvm.functions.Function2 r7 = r20.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r14, r12, r7)
            kotlin.jvm.functions.Function2 r7 = r20.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r14, r13, r7)
            r0.enableReusing()
            androidx.compose.runtime.Composer r7 = androidx.compose.runtime.SkippableUpdater.m2527constructorimpl(r0)
            androidx.compose.runtime.SkippableUpdater r7 = androidx.compose.runtime.SkippableUpdater.m2526boximpl(r7)
            r10.invoke(r7, r0, r8)
            r0.startReplaceableGroup(r6)
            r6 = -2137368960(0xffffffff809a5680, float:-1.4173697E-38)
            r0.startReplaceableGroup(r6)
            androidx.compose.foundation.layout.BoxScopeInstance r6 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            int r6 = com.talabat.localization.R.string.clear_tip
            java.lang.String r6 = androidx.compose.ui.res.StringResources_androidKt.stringResource(r6, r0, r9)
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 1157296644(0x44faf204, float:2007.563)
            r0.startReplaceableGroup(r12)
            boolean r12 = r0.changed((java.lang.Object) r4)
            java.lang.Object r13 = r0.rememberedValue()
            if (r12 != 0) goto L_0x03db
            androidx.compose.runtime.Composer$Companion r12 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r12 = r12.getEmpty()
            if (r13 != r12) goto L_0x03e3
        L_0x03db:
            com.talabat.feature.ridertips.presentation.view.mainview.tipoptionsviewstate.TipOptionsViewKt$TipOptionsView$1$3$1$1 r13 = new com.talabat.feature.ridertips.presentation.view.mainview.tipoptionsviewstate.TipOptionsViewKt$TipOptionsView$1$3$1$1
            r13.<init>(r4)
            r0.updateRememberedValue(r13)
        L_0x03e3:
            r0.endReplaceableGroup()
            r12 = r13
            kotlin.jvm.functions.Function0 r12 = (kotlin.jvm.functions.Function0) r12
            r14 = 0
            r15 = 62
            r13 = r0
            com.designsystem.ds_small_button.DSTertiarySmallButtonKt.DSTertiarySmallButton(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r0.endNode()
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
        L_0x0402:
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r0.endNode()
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            androidx.compose.runtime.ScopeUpdateScope r7 = r0.endRestartGroup()
            if (r7 != 0) goto L_0x0418
            goto L_0x042d
        L_0x0418:
            com.talabat.feature.ridertips.presentation.view.mainview.tipoptionsviewstate.TipOptionsViewKt$TipOptionsView$2 r8 = new com.talabat.feature.ridertips.presentation.view.mainview.tipoptionsviewstate.TipOptionsViewKt$TipOptionsView$2
            r0 = r8
            r1 = r52
            r2 = r53
            r3 = r54
            r4 = r55
            r5 = r56
            r6 = r58
            r0.<init>(r1, r2, r3, r4, r5, r6)
            r7.updateScope(r8)
        L_0x042d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.ridertips.presentation.view.mainview.tipoptionsviewstate.TipOptionsViewKt.TipOptionsView(com.talabat.feature.ridertips.presentation.displaymodel.TipOptionsDetailsDisplayModel, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, boolean, androidx.compose.runtime.Composer, int):void");
    }
}
