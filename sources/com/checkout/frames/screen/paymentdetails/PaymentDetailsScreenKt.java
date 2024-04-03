package com.checkout.frames.screen.paymentdetails;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a%\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0001¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"PaymentDetailsScreen", "", "style", "Lcom/checkout/frames/style/screen/PaymentDetailsStyle;", "injector", "Lcom/checkout/frames/di/base/Injector;", "navController", "Landroidx/navigation/NavController;", "(Lcom/checkout/frames/style/screen/PaymentDetailsStyle;Lcom/checkout/frames/di/base/Injector;Landroidx/navigation/NavController;Landroidx/compose/runtime/Composer;I)V", "frames_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class PaymentDetailsScreenKt {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v0, resolved type: kotlin.jvm.functions.Function0} */
    /* JADX WARNING: Multi-variable type inference failed */
    @androidx.compose.runtime.ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void PaymentDetailsScreen(@org.jetbrains.annotations.NotNull com.checkout.frames.style.screen.PaymentDetailsStyle r25, @org.jetbrains.annotations.NotNull com.checkout.frames.di.base.Injector r26, @org.jetbrains.annotations.NotNull androidx.navigation.NavController r27, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r28, int r29) {
        /*
            r0 = r25
            r1 = r26
            r2 = r27
            java.lang.String r3 = "style"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r3)
            java.lang.String r3 = "injector"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r3)
            java.lang.String r3 = "navController"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r3)
            r3 = -1695587665(0xffffffff9aef62af, float:-9.9007515E-23)
            r4 = r28
            androidx.compose.runtime.Composer r3 = r4.startRestartGroup(r3)
            r4 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r3.startReplaceableGroup(r4)
            java.lang.Object r5 = r3.rememberedValue()
            androidx.compose.runtime.Composer$Companion r12 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r6 = r12.getEmpty()
            if (r5 != r6) goto L_0x0037
            androidx.compose.foundation.interaction.MutableInteractionSource r5 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r3.updateRememberedValue(r5)
        L_0x0037:
            r3.endReplaceableGroup()
            r14 = r5
            androidx.compose.foundation.interaction.MutableInteractionSource r14 = (androidx.compose.foundation.interaction.MutableInteractionSource) r14
            r3.startReplaceableGroup(r4)
            java.lang.Object r4 = r3.rememberedValue()
            java.lang.Object r5 = r12.getEmpty()
            r15 = 0
            if (r4 != r5) goto L_0x0055
            java.lang.Boolean r4 = java.lang.Boolean.FALSE
            r5 = 2
            androidx.compose.runtime.MutableState r4 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r4, r15, r5, r15)
            r3.updateRememberedValue(r4)
        L_0x0055:
            r3.endReplaceableGroup()
            r13 = r4
            androidx.compose.runtime.MutableState r13 = (androidx.compose.runtime.MutableState) r13
            com.checkout.frames.screen.paymentdetails.PaymentDetailsViewModel$Factory r7 = new com.checkout.frames.screen.paymentdetails.PaymentDetailsViewModel$Factory
            r7.<init>(r1, r0)
            r4 = 1729797275(0x671a9c9b, float:7.301333E23)
            r3.startReplaceableGroup(r4)
            androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner r4 = androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner.INSTANCE
            r5 = 6
            androidx.lifecycle.ViewModelStoreOwner r5 = r4.getCurrent(r3, r5)
            if (r5 == 0) goto L_0x02fb
            r6 = 0
            boolean r4 = r5 instanceof androidx.lifecycle.HasDefaultViewModelProviderFactory
            if (r4 == 0) goto L_0x0082
            r4 = r5
            androidx.lifecycle.HasDefaultViewModelProviderFactory r4 = (androidx.lifecycle.HasDefaultViewModelProviderFactory) r4
            androidx.lifecycle.viewmodel.CreationExtras r4 = r4.getDefaultViewModelCreationExtras()
            java.lang.String r8 = "{\n        viewModelStore…ModelCreationExtras\n    }"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r8)
            goto L_0x0084
        L_0x0082:
            androidx.lifecycle.viewmodel.CreationExtras$Empty r4 = androidx.lifecycle.viewmodel.CreationExtras.Empty.INSTANCE
        L_0x0084:
            r8 = r4
            java.lang.Class<com.checkout.frames.screen.paymentdetails.PaymentDetailsViewModel> r4 = com.checkout.frames.screen.paymentdetails.PaymentDetailsViewModel.class
            r10 = 36936(0x9048, float:5.1758E-41)
            r11 = 0
            r9 = r3
            androidx.lifecycle.ViewModel r4 = androidx.lifecycle.viewmodel.compose.ViewModelKt.viewModel(r4, r5, r6, r7, r8, r9, r10, r11)
            r3.endReplaceableGroup()
            com.checkout.frames.screen.paymentdetails.PaymentDetailsViewModel r4 = (com.checkout.frames.screen.paymentdetails.PaymentDetailsViewModel) r4
            androidx.compose.ui.Modifier$Companion r5 = androidx.compose.ui.Modifier.Companion
            r6 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r7 = 1157296644(0x44faf204, float:2007.563)
            r3.startReplaceableGroup(r7)
            boolean r7 = r3.changed((java.lang.Object) r13)
            java.lang.Object r8 = r3.rememberedValue()
            if (r7 != 0) goto L_0x00b4
            java.lang.Object r7 = r12.getEmpty()
            if (r8 != r7) goto L_0x00bc
        L_0x00b4:
            com.checkout.frames.screen.paymentdetails.PaymentDetailsScreenKt$PaymentDetailsScreen$1$1 r8 = new com.checkout.frames.screen.paymentdetails.PaymentDetailsScreenKt$PaymentDetailsScreen$1$1
            r8.<init>(r13)
            r3.updateRememberedValue(r8)
        L_0x00bc:
            r3.endReplaceableGroup()
            r19 = r8
            kotlin.jvm.functions.Function0 r19 = (kotlin.jvm.functions.Function0) r19
            r20 = 28
            r21 = 0
            r7 = r13
            r13 = r5
            r5 = r15
            r15 = r6
            androidx.compose.ui.Modifier r6 = androidx.compose.foundation.ClickableKt.m194clickableO2vRcR0$default(r13, r14, r15, r16, r17, r18, r19, r20, r21)
            r8 = -483455358(0xffffffffe32f0e82, float:-3.2292256E21)
            r3.startReplaceableGroup(r8)
            androidx.compose.foundation.layout.Arrangement r9 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$Vertical r10 = r9.getTop()
            androidx.compose.ui.Alignment$Companion r11 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Horizontal r12 = r11.getStart()
            r13 = 0
            androidx.compose.ui.layout.MeasurePolicy r10 = androidx.compose.foundation.layout.ColumnKt.columnMeasurePolicy(r10, r12, r3, r13)
            r12 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r3.startReplaceableGroup(r12)
            androidx.compose.runtime.ProvidableCompositionLocal r14 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            java.lang.Object r14 = r3.consume(r14)
            androidx.compose.ui.unit.Density r14 = (androidx.compose.ui.unit.Density) r14
            androidx.compose.runtime.ProvidableCompositionLocal r15 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            java.lang.Object r15 = r3.consume(r15)
            androidx.compose.ui.unit.LayoutDirection r15 = (androidx.compose.ui.unit.LayoutDirection) r15
            androidx.compose.runtime.ProvidableCompositionLocal r12 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            java.lang.Object r12 = r3.consume(r12)
            androidx.compose.ui.platform.ViewConfiguration r12 = (androidx.compose.ui.platform.ViewConfiguration) r12
            androidx.compose.ui.node.ComposeUiNode$Companion r16 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r8 = r16.getConstructor()
            kotlin.jvm.functions.Function3 r6 = androidx.compose.ui.layout.LayoutKt.materializerOf(r6)
            androidx.compose.runtime.Applier r5 = r3.getApplier()
            boolean r5 = r5 instanceof androidx.compose.runtime.Applier
            if (r5 != 0) goto L_0x011f
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x011f:
            r3.startReusableNode()
            boolean r5 = r3.getInserting()
            if (r5 == 0) goto L_0x012c
            r3.createNode(r8)
            goto L_0x012f
        L_0x012c:
            r3.useNode()
        L_0x012f:
            r3.disableReusing()
            androidx.compose.runtime.Composer r5 = androidx.compose.runtime.Updater.m2536constructorimpl(r3)
            kotlin.jvm.functions.Function2 r8 = r16.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r5, r10, r8)
            kotlin.jvm.functions.Function2 r8 = r16.getSetDensity()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r5, r14, r8)
            kotlin.jvm.functions.Function2 r8 = r16.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r5, r15, r8)
            kotlin.jvm.functions.Function2 r8 = r16.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r5, r12, r8)
            r3.enableReusing()
            androidx.compose.runtime.Composer r5 = androidx.compose.runtime.SkippableUpdater.m2527constructorimpl(r3)
            androidx.compose.runtime.SkippableUpdater r5 = androidx.compose.runtime.SkippableUpdater.m2526boximpl(r5)
            java.lang.Integer r8 = java.lang.Integer.valueOf(r13)
            r6.invoke(r5, r3, r8)
            r5 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r3.startReplaceableGroup(r5)
            r6 = -1163856341(0xffffffffbaa0f62b, float:-0.0012280395)
            r3.startReplaceableGroup(r6)
            androidx.compose.foundation.layout.ColumnScopeInstance r8 = androidx.compose.foundation.layout.ColumnScopeInstance.INSTANCE
            com.checkout.frames.style.view.TextLabelViewStyle r8 = r4.getHeaderStyle()
            com.checkout.frames.view.TextLabelState r10 = r4.getHeaderState()
            r12 = 8
            com.checkout.frames.view.TextLabelKt.TextLabel(r8, r10, r3, r12)
            androidx.compose.ui.Modifier r8 = r4.getFieldsContainerModifier()
            r10 = 0
            r14 = 1
            r15 = 0
            androidx.compose.ui.Modifier r8 = androidx.compose.foundation.layout.SizeKt.fillMaxWidth$default(r8, r10, r14, r15)
            androidx.compose.ui.Modifier r18 = androidx.compose.foundation.layout.SizeKt.fillMaxHeight$default(r8, r10, r14, r15)
            androidx.compose.foundation.ScrollState r19 = androidx.compose.foundation.ScrollKt.rememberScrollState(r13, r3, r13, r14)
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 14
            r24 = 0
            androidx.compose.ui.Modifier r8 = androidx.compose.foundation.ScrollKt.verticalScroll$default(r18, r19, r20, r21, r22, r23, r24)
            r10 = -483455358(0xffffffffe32f0e82, float:-3.2292256E21)
            r3.startReplaceableGroup(r10)
            androidx.compose.foundation.layout.Arrangement$Vertical r9 = r9.getTop()
            androidx.compose.ui.Alignment$Horizontal r10 = r11.getStart()
            androidx.compose.ui.layout.MeasurePolicy r9 = androidx.compose.foundation.layout.ColumnKt.columnMeasurePolicy(r9, r10, r3, r13)
            r10 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r3.startReplaceableGroup(r10)
            androidx.compose.runtime.ProvidableCompositionLocal r10 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            java.lang.Object r10 = r3.consume(r10)
            androidx.compose.ui.unit.Density r10 = (androidx.compose.ui.unit.Density) r10
            androidx.compose.runtime.ProvidableCompositionLocal r11 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            java.lang.Object r11 = r3.consume(r11)
            androidx.compose.ui.unit.LayoutDirection r11 = (androidx.compose.ui.unit.LayoutDirection) r11
            androidx.compose.runtime.ProvidableCompositionLocal r15 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            java.lang.Object r15 = r3.consume(r15)
            androidx.compose.ui.platform.ViewConfiguration r15 = (androidx.compose.ui.platform.ViewConfiguration) r15
            kotlin.jvm.functions.Function0 r14 = r16.getConstructor()
            kotlin.jvm.functions.Function3 r8 = androidx.compose.ui.layout.LayoutKt.materializerOf(r8)
            androidx.compose.runtime.Applier r12 = r3.getApplier()
            boolean r12 = r12 instanceof androidx.compose.runtime.Applier
            if (r12 != 0) goto L_0x01e9
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x01e9:
            r3.startReusableNode()
            boolean r12 = r3.getInserting()
            if (r12 == 0) goto L_0x01f6
            r3.createNode(r14)
            goto L_0x01f9
        L_0x01f6:
            r3.useNode()
        L_0x01f9:
            r3.disableReusing()
            androidx.compose.runtime.Composer r12 = androidx.compose.runtime.Updater.m2536constructorimpl(r3)
            kotlin.jvm.functions.Function2 r14 = r16.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r12, r9, r14)
            kotlin.jvm.functions.Function2 r9 = r16.getSetDensity()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r12, r10, r9)
            kotlin.jvm.functions.Function2 r9 = r16.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r12, r11, r9)
            kotlin.jvm.functions.Function2 r9 = r16.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r12, r15, r9)
            r3.enableReusing()
            androidx.compose.runtime.Composer r9 = androidx.compose.runtime.SkippableUpdater.m2527constructorimpl(r3)
            androidx.compose.runtime.SkippableUpdater r9 = androidx.compose.runtime.SkippableUpdater.m2526boximpl(r9)
            java.lang.Integer r10 = java.lang.Integer.valueOf(r13)
            r8.invoke(r9, r3, r10)
            r3.startReplaceableGroup(r5)
            r3.startReplaceableGroup(r6)
            com.checkout.frames.component.provider.ComponentProvider r5 = r4.getComponentProvider()
            com.checkout.frames.style.component.CardSchemeComponentStyle r6 = r25.getCardSchemeStyle()
            r8 = 8
            r5.CardScheme(r6, r3, r8)
            com.checkout.frames.component.provider.ComponentProvider r5 = r4.getComponentProvider()
            com.checkout.frames.style.component.CardNumberComponentStyle r6 = r25.getCardNumberStyle()
            r5.CardNumber(r6, r3, r8)
            com.checkout.frames.component.provider.ComponentProvider r5 = r4.getComponentProvider()
            com.checkout.frames.style.component.ExpiryDateComponentStyle r6 = r25.getExpiryDateStyle()
            r5.ExpiryDate(r6, r3, r8)
            com.checkout.frames.style.component.CvvComponentStyle r5 = r25.getCvvStyle()
            r6 = 2144647611(0x7fd4b9bb, float:NaN)
            r3.startReplaceableGroup(r6)
            if (r5 != 0) goto L_0x0264
            goto L_0x026d
        L_0x0264:
            com.checkout.frames.component.provider.ComponentProvider r6 = r4.getComponentProvider()
            r6.Cvv(r5, r3, r8)
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
        L_0x026d:
            r3.endReplaceableGroup()
            com.checkout.frames.style.component.addresssummary.AddressSummaryComponentStyle r5 = r25.getAddressSummaryStyle()
            r6 = 2144647742(0x7fd4ba3e, float:NaN)
            r3.startReplaceableGroup(r6)
            if (r5 != 0) goto L_0x027f
            r9 = 8
            goto L_0x028f
        L_0x027f:
            com.checkout.frames.component.provider.ComponentProvider r6 = r4.getComponentProvider()
            com.checkout.frames.screen.paymentdetails.PaymentDetailsScreenKt$PaymentDetailsScreen$2$1$2$1 r8 = new com.checkout.frames.screen.paymentdetails.PaymentDetailsScreenKt$PaymentDetailsScreen$2$1$2$1
            r8.<init>(r2)
            r9 = 8
            r6.AddressSummary(r5, r8, r3, r9)
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
        L_0x028f:
            r3.endReplaceableGroup()
            com.checkout.frames.component.provider.ComponentProvider r4 = r4.getComponentProvider()
            com.checkout.frames.style.component.PayButtonComponentStyle r5 = r25.getPayButtonStyle()
            r4.PayButton(r5, r3, r9)
            r3.endReplaceableGroup()
            r3.endReplaceableGroup()
            r3.endNode()
            r3.endReplaceableGroup()
            r3.endReplaceableGroup()
            r3.endReplaceableGroup()
            r3.endReplaceableGroup()
            r3.endNode()
            r3.endReplaceableGroup()
            r3.endReplaceableGroup()
            java.lang.Object r4 = r7.getValue()
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r4 = r4.booleanValue()
            if (r4 == 0) goto L_0x02e9
            androidx.compose.ui.platform.LocalSoftwareKeyboardController r4 = androidx.compose.ui.platform.LocalSoftwareKeyboardController.INSTANCE
            r5 = 8
            androidx.compose.ui.platform.SoftwareKeyboardController r4 = r4.getCurrent(r3, r5)
            if (r4 == 0) goto L_0x02d6
            r4.hide()
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
        L_0x02d6:
            androidx.compose.runtime.ProvidableCompositionLocal r4 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalFocusManager()
            java.lang.Object r4 = r3.consume(r4)
            androidx.compose.ui.focus.FocusManager r4 = (androidx.compose.ui.focus.FocusManager) r4
            r5 = 1
            r4.clearFocus(r5)
            java.lang.Boolean r4 = java.lang.Boolean.FALSE
            r7.setValue(r4)
        L_0x02e9:
            androidx.compose.runtime.ScopeUpdateScope r3 = r3.endRestartGroup()
            if (r3 != 0) goto L_0x02f0
            goto L_0x02fa
        L_0x02f0:
            com.checkout.frames.screen.paymentdetails.PaymentDetailsScreenKt$PaymentDetailsScreen$3 r4 = new com.checkout.frames.screen.paymentdetails.PaymentDetailsScreenKt$PaymentDetailsScreen$3
            r5 = r29
            r4.<init>(r0, r1, r2, r5)
            r3.updateScope(r4)
        L_0x02fa:
            return
        L_0x02fb:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "No ViewModelStoreOwner was provided via LocalViewModelStoreOwner"
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.checkout.frames.screen.paymentdetails.PaymentDetailsScreenKt.PaymentDetailsScreen(com.checkout.frames.style.screen.PaymentDetailsStyle, com.checkout.frames.di.base.Injector, androidx.navigation.NavController, androidx.compose.runtime.Composer, int):void");
    }
}
