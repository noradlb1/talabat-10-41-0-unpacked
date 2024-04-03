package com.checkout.frames.screen.billingaddress.billingaddressdetails;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import com.checkout.frames.style.view.InternalButtonViewStyle;
import com.checkout.frames.style.view.TextLabelViewStyle;
import com.checkout.frames.view.InternalButtonKt;
import com.checkout.frames.view.InternalButtonState;
import com.checkout.frames.view.TextLabelKt;
import com.checkout.frames.view.TextLabelState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;

@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a3\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\tH\u0001¢\u0006\u0002\u0010\n\u001a;\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00010\tH\u0003¢\u0006\u0002\u0010\u0015¨\u0006\u0016"}, d2 = {"BillingAddressDetailsScreen", "", "style", "Lcom/checkout/frames/style/screen/BillingAddressDetailsStyle;", "injector", "Lcom/checkout/frames/di/base/Injector;", "navController", "Landroidx/navigation/NavHostController;", "onClose", "Lkotlin/Function0;", "(Lcom/checkout/frames/style/screen/BillingAddressDetailsStyle;Lcom/checkout/frames/di/base/Injector;Landroidx/navigation/NavHostController;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "HeaderComponent", "screenTitleStyle", "Lcom/checkout/frames/style/view/TextLabelViewStyle;", "screenTitleState", "Lcom/checkout/frames/view/TextLabelState;", "screenButtonStyle", "Lcom/checkout/frames/style/view/InternalButtonViewStyle;", "screenButtonState", "Lcom/checkout/frames/view/InternalButtonState;", "onTapDoneButton", "(Lcom/checkout/frames/style/view/TextLabelViewStyle;Lcom/checkout/frames/view/TextLabelState;Lcom/checkout/frames/style/view/InternalButtonViewStyle;Lcom/checkout/frames/view/InternalButtonState;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "frames_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class BillingAddressDetailsScreenKt {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: kotlin.jvm.functions.Function0} */
    /* JADX WARNING: Multi-variable type inference failed */
    @androidx.compose.runtime.ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void BillingAddressDetailsScreen(@org.jetbrains.annotations.NotNull com.checkout.frames.style.screen.BillingAddressDetailsStyle r23, @org.jetbrains.annotations.NotNull com.checkout.frames.di.base.Injector r24, @org.jetbrains.annotations.NotNull androidx.navigation.NavHostController r25, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function0<kotlin.Unit> r26, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r27, int r28) {
        /*
            r6 = r23
            r7 = r24
            java.lang.String r0 = "style"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "injector"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "navController"
            r8 = r25
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "onClose"
            r9 = r26
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            r0 = -885642004(0xffffffffcb362cec, float:-1.1939052E7)
            r1 = r27
            androidx.compose.runtime.Composer r5 = r1.startRestartGroup(r0)
            r0 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r5.startReplaceableGroup(r0)
            java.lang.Object r1 = r5.rememberedValue()
            androidx.compose.runtime.Composer$Companion r2 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r2.getEmpty()
            if (r1 != r3) goto L_0x003e
            androidx.compose.foundation.interaction.MutableInteractionSource r1 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r5.updateRememberedValue(r1)
        L_0x003e:
            r5.endReplaceableGroup()
            androidx.compose.foundation.interaction.MutableInteractionSource r1 = (androidx.compose.foundation.interaction.MutableInteractionSource) r1
            r5.startReplaceableGroup(r0)
            java.lang.Object r0 = r5.rememberedValue()
            java.lang.Object r3 = r2.getEmpty()
            r4 = 0
            if (r0 != r3) goto L_0x005b
            java.lang.Boolean r0 = java.lang.Boolean.FALSE
            r3 = 2
            androidx.compose.runtime.MutableState r0 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r0, r4, r3, r4)
            r5.updateRememberedValue(r0)
        L_0x005b:
            r5.endReplaceableGroup()
            r3 = r0
            androidx.compose.runtime.MutableState r3 = (androidx.compose.runtime.MutableState) r3
            com.checkout.frames.screen.billingaddress.billingaddressdetails.BillingAddressDetailsViewModel$Factory r13 = new com.checkout.frames.screen.billingaddress.billingaddressdetails.BillingAddressDetailsViewModel$Factory
            r13.<init>(r7, r6)
            r0 = 1729797275(0x671a9c9b, float:7.301333E23)
            r5.startReplaceableGroup(r0)
            androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner r0 = androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner.INSTANCE
            r10 = 6
            androidx.lifecycle.ViewModelStoreOwner r11 = r0.getCurrent(r5, r10)
            if (r11 == 0) goto L_0x0235
            r12 = 0
            boolean r0 = r11 instanceof androidx.lifecycle.HasDefaultViewModelProviderFactory
            if (r0 == 0) goto L_0x0088
            r0 = r11
            androidx.lifecycle.HasDefaultViewModelProviderFactory r0 = (androidx.lifecycle.HasDefaultViewModelProviderFactory) r0
            androidx.lifecycle.viewmodel.CreationExtras r0 = r0.getDefaultViewModelCreationExtras()
            java.lang.String r10 = "{\n        viewModelStore…ModelCreationExtras\n    }"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r10)
            goto L_0x008a
        L_0x0088:
            androidx.lifecycle.viewmodel.CreationExtras$Empty r0 = androidx.lifecycle.viewmodel.CreationExtras.Empty.INSTANCE
        L_0x008a:
            r14 = r0
            java.lang.Class<com.checkout.frames.screen.billingaddress.billingaddressdetails.BillingAddressDetailsViewModel> r10 = com.checkout.frames.screen.billingaddress.billingaddressdetails.BillingAddressDetailsViewModel.class
            r16 = 36936(0x9048, float:5.1758E-41)
            r17 = 0
            r15 = r5
            androidx.lifecycle.ViewModel r0 = androidx.lifecycle.viewmodel.compose.ViewModelKt.viewModel(r10, r11, r12, r13, r14, r15, r16, r17)
            r5.endReplaceableGroup()
            com.checkout.frames.screen.billingaddress.billingaddressdetails.BillingAddressDetailsViewModel r0 = (com.checkout.frames.screen.billingaddress.billingaddressdetails.BillingAddressDetailsViewModel) r0
            androidx.compose.runtime.MutableState r10 = r0.getGoBack()
            java.lang.Object r10 = r10.getValue()
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            if (r10 == 0) goto L_0x00af
            r26.invoke()
        L_0x00af:
            androidx.compose.ui.Modifier r10 = r0.getScreenModifier()
            r15 = 0
            r14 = 1
            androidx.compose.ui.Modifier r10 = androidx.compose.foundation.layout.SizeKt.fillMaxWidth$default(r10, r15, r14, r4)
            androidx.compose.ui.Modifier r10 = androidx.compose.foundation.layout.SizeKt.fillMaxHeight$default(r10, r15, r14, r4)
            r12 = 0
            r13 = 0
            r16 = 0
            r17 = 0
            r11 = 1157296644(0x44faf204, float:2007.563)
            r5.startReplaceableGroup(r11)
            boolean r11 = r5.changed((java.lang.Object) r3)
            java.lang.Object r14 = r5.rememberedValue()
            if (r11 != 0) goto L_0x00d9
            java.lang.Object r2 = r2.getEmpty()
            if (r14 != r2) goto L_0x00e1
        L_0x00d9:
            com.checkout.frames.screen.billingaddress.billingaddressdetails.BillingAddressDetailsScreenKt$BillingAddressDetailsScreen$1$1 r14 = new com.checkout.frames.screen.billingaddress.billingaddressdetails.BillingAddressDetailsScreenKt$BillingAddressDetailsScreen$1$1
            r14.<init>(r3)
            r5.updateRememberedValue(r14)
        L_0x00e1:
            r5.endReplaceableGroup()
            r2 = r14
            kotlin.jvm.functions.Function0 r2 = (kotlin.jvm.functions.Function0) r2
            r18 = 28
            r19 = 0
            r11 = r1
            r1 = 1
            r14 = r16
            r15 = r17
            r16 = r2
            r17 = r18
            r18 = r19
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.ClickableKt.m194clickableO2vRcR0$default(r10, r11, r12, r13, r14, r15, r16, r17, r18)
            r10 = -483455358(0xffffffffe32f0e82, float:-3.2292256E21)
            r5.startReplaceableGroup(r10)
            androidx.compose.foundation.layout.Arrangement r10 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$Vertical r10 = r10.getTop()
            androidx.compose.ui.Alignment$Companion r11 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Horizontal r11 = r11.getStart()
            r15 = 0
            androidx.compose.ui.layout.MeasurePolicy r10 = androidx.compose.foundation.layout.ColumnKt.columnMeasurePolicy(r10, r11, r5, r15)
            r11 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r5.startReplaceableGroup(r11)
            androidx.compose.runtime.ProvidableCompositionLocal r11 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            java.lang.Object r11 = r5.consume(r11)
            androidx.compose.ui.unit.Density r11 = (androidx.compose.ui.unit.Density) r11
            androidx.compose.runtime.ProvidableCompositionLocal r12 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            java.lang.Object r12 = r5.consume(r12)
            androidx.compose.ui.unit.LayoutDirection r12 = (androidx.compose.ui.unit.LayoutDirection) r12
            androidx.compose.runtime.ProvidableCompositionLocal r13 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            java.lang.Object r13 = r5.consume(r13)
            androidx.compose.ui.platform.ViewConfiguration r13 = (androidx.compose.ui.platform.ViewConfiguration) r13
            androidx.compose.ui.node.ComposeUiNode$Companion r14 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r1 = r14.getConstructor()
            kotlin.jvm.functions.Function3 r2 = androidx.compose.ui.layout.LayoutKt.materializerOf(r2)
            androidx.compose.runtime.Applier r4 = r5.getApplier()
            boolean r4 = r4 instanceof androidx.compose.runtime.Applier
            if (r4 != 0) goto L_0x014b
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x014b:
            r5.startReusableNode()
            boolean r4 = r5.getInserting()
            if (r4 == 0) goto L_0x0158
            r5.createNode(r1)
            goto L_0x015b
        L_0x0158:
            r5.useNode()
        L_0x015b:
            r5.disableReusing()
            androidx.compose.runtime.Composer r1 = androidx.compose.runtime.Updater.m2536constructorimpl(r5)
            kotlin.jvm.functions.Function2 r4 = r14.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r1, r10, r4)
            kotlin.jvm.functions.Function2 r4 = r14.getSetDensity()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r1, r11, r4)
            kotlin.jvm.functions.Function2 r4 = r14.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r1, r12, r4)
            kotlin.jvm.functions.Function2 r4 = r14.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r1, r13, r4)
            r5.enableReusing()
            androidx.compose.runtime.Composer r1 = androidx.compose.runtime.SkippableUpdater.m2527constructorimpl(r5)
            androidx.compose.runtime.SkippableUpdater r1 = androidx.compose.runtime.SkippableUpdater.m2526boximpl(r1)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r15)
            r2.invoke(r1, r5, r4)
            r1 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r5.startReplaceableGroup(r1)
            r1 = -1163856341(0xffffffffbaa0f62b, float:-0.0012280395)
            r5.startReplaceableGroup(r1)
            androidx.compose.foundation.layout.ColumnScopeInstance r1 = androidx.compose.foundation.layout.ColumnScopeInstance.INSTANCE
            com.checkout.frames.style.view.TextLabelViewStyle r10 = r0.getScreenTitleStyle()
            com.checkout.frames.view.TextLabelState r11 = r0.getScreenTitleState()
            com.checkout.frames.style.view.InternalButtonViewStyle r12 = r0.getScreenButtonStyle()
            com.checkout.frames.view.InternalButtonState r13 = r0.getScreenButtonState()
            com.checkout.frames.screen.billingaddress.billingaddressdetails.BillingAddressDetailsScreenKt$BillingAddressDetailsScreen$2$1 r14 = new com.checkout.frames.screen.billingaddress.billingaddressdetails.BillingAddressDetailsScreenKt$BillingAddressDetailsScreen$2$1
            r14.<init>(r0)
            r16 = 520(0x208, float:7.29E-43)
            r4 = r15
            r15 = r5
            HeaderComponent(r10, r11, r12, r13, r14, r15, r16)
            androidx.compose.ui.Modifier r1 = r0.getInputComponentsContainerModifier()
            r2 = 1
            r10 = 0
            r11 = 0
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.layout.SizeKt.fillMaxWidth$default(r1, r10, r2, r11)
            androidx.compose.ui.Modifier r10 = androidx.compose.foundation.layout.SizeKt.fillMaxHeight$default(r1, r10, r2, r11)
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            com.checkout.frames.screen.billingaddress.billingaddressdetails.BillingAddressDetailsScreenKt$BillingAddressDetailsScreen$2$2 r18 = new com.checkout.frames.screen.billingaddress.billingaddressdetails.BillingAddressDetailsScreenKt$BillingAddressDetailsScreen$2$2
            r1 = r0
            r0 = r18
            r2 = r23
            r27 = r3
            r3 = r24
            r4 = r28
            r22 = r5
            r5 = r25
            r0.<init>(r1, r2, r3, r4, r5)
            r20 = 0
            r21 = 254(0xfe, float:3.56E-43)
            r19 = r22
            androidx.compose.foundation.lazy.LazyDslKt.LazyColumn(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21)
            r22.endReplaceableGroup()
            r22.endReplaceableGroup()
            r22.endNode()
            r22.endReplaceableGroup()
            r22.endReplaceableGroup()
            java.lang.Object r0 = r27.getValue()
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x0218
            r0 = r22
            r1 = 0
            com.checkout.frames.utils.extensions.KeyboardExtensionsKt.ResetFocus(r0, r1)
            java.lang.Boolean r1 = java.lang.Boolean.FALSE
            r2 = r27
            r2.setValue(r1)
            goto L_0x021a
        L_0x0218:
            r0 = r22
        L_0x021a:
            androidx.compose.runtime.ScopeUpdateScope r10 = r0.endRestartGroup()
            if (r10 != 0) goto L_0x0221
            goto L_0x0234
        L_0x0221:
            com.checkout.frames.screen.billingaddress.billingaddressdetails.BillingAddressDetailsScreenKt$BillingAddressDetailsScreen$3 r11 = new com.checkout.frames.screen.billingaddress.billingaddressdetails.BillingAddressDetailsScreenKt$BillingAddressDetailsScreen$3
            r0 = r11
            r1 = r23
            r2 = r24
            r3 = r25
            r4 = r26
            r5 = r28
            r0.<init>(r1, r2, r3, r4, r5)
            r10.updateScope(r11)
        L_0x0234:
            return
        L_0x0235:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "No ViewModelStoreOwner was provided via LocalViewModelStoreOwner"
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.checkout.frames.screen.billingaddress.billingaddressdetails.BillingAddressDetailsScreenKt.BillingAddressDetailsScreen(com.checkout.frames.style.screen.BillingAddressDetailsStyle, com.checkout.frames.di.base.Injector, androidx.navigation.NavHostController, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int):void");
    }

    /* access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void HeaderComponent(TextLabelViewStyle textLabelViewStyle, TextLabelState textLabelState, InternalButtonViewStyle internalButtonViewStyle, InternalButtonState internalButtonState, Function0<Unit> function0, Composer composer, int i11) {
        Composer startRestartGroup = composer.startRestartGroup(-1336828180);
        Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
        Arrangement.HorizontalOrVertical spaceBetween = Arrangement.INSTANCE.getSpaceBetween();
        startRestartGroup.startReplaceableGroup(693286680);
        MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(spaceBetween, Alignment.Companion.getTop(), startRestartGroup, 6);
        startRestartGroup.startReplaceableGroup(-1323940314);
        Density density = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
        LayoutDirection layoutDirection = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
        ViewConfiguration viewConfiguration = (ViewConfiguration) startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
        ComposeUiNode.Companion companion = ComposeUiNode.Companion;
        Function0<ComposeUiNode> constructor = companion.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(fillMaxWidth$default);
        if (!(startRestartGroup.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
            startRestartGroup.createNode(constructor);
        } else {
            startRestartGroup.useNode();
        }
        startRestartGroup.disableReusing();
        Composer r62 = Updater.m2536constructorimpl(startRestartGroup);
        Updater.m2543setimpl(r62, rowMeasurePolicy, companion.getSetMeasurePolicy());
        Updater.m2543setimpl(r62, density, companion.getSetDensity());
        Updater.m2543setimpl(r62, layoutDirection, companion.getSetLayoutDirection());
        Updater.m2543setimpl(r62, viewConfiguration, companion.getSetViewConfiguration());
        startRestartGroup.enableReusing();
        materializerOf.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(startRestartGroup)), startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(2058660585);
        startRestartGroup.startReplaceableGroup(-678309503);
        RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
        TextLabelKt.TextLabel(textLabelViewStyle, textLabelState, startRestartGroup, (i11 & 112) | 8);
        startRestartGroup.startReplaceableGroup(1157296644);
        boolean changed = startRestartGroup.changed((Object) function0);
        Object rememberedValue = startRestartGroup.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new BillingAddressDetailsScreenKt$HeaderComponent$1$1$1(function0);
            startRestartGroup.updateRememberedValue(rememberedValue);
        }
        startRestartGroup.endReplaceableGroup();
        InternalButtonKt.InternalButton(internalButtonViewStyle, internalButtonState, (Function0) rememberedValue, startRestartGroup, ((i11 >> 6) & 112) | 8);
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endNode();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new BillingAddressDetailsScreenKt$HeaderComponent$2(textLabelViewStyle, textLabelState, internalButtonViewStyle, internalButtonState, function0, i11));
        }
    }
}
