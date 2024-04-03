package com.checkout.frames.screen.countrypicker;

import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyListState;
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
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.LocalSoftwareKeyboardController;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.lifecycle.viewmodel.compose.ViewModelKt;
import com.checkout.frames.di.base.Injector;
import com.checkout.frames.screen.countrypicker.CountryPickerViewModel;
import com.checkout.frames.style.screen.CountryPickerStyle;
import com.checkout.frames.style.view.InputFieldViewStyle;
import com.checkout.frames.style.view.TextLabelViewStyle;
import com.checkout.frames.view.InputFieldKt;
import com.checkout.frames.view.InputFieldState;
import com.checkout.frames.view.TextLabelKt;
import com.checkout.frames.view.TextLabelState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000N\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a1\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0003¢\u0006\u0002\u0010\t\u001a+\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00010\u0010H\u0001¢\u0006\u0002\u0010\u0011\u001aU\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00010\u00072\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0003¢\u0006\u0002\u0010\u001d¨\u0006\u001e"}, d2 = {"CountryItemComponent", "", "labelStyle", "Lcom/checkout/frames/style/view/TextLabelViewStyle;", "data", "Lcom/checkout/frames/screen/countrypicker/CountryItem;", "onClick", "Lkotlin/Function1;", "", "(Lcom/checkout/frames/style/view/TextLabelViewStyle;Lcom/checkout/frames/screen/countrypicker/CountryItem;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "CountryPickerScreen", "style", "Lcom/checkout/frames/style/screen/CountryPickerStyle;", "injector", "Lcom/checkout/frames/di/base/Injector;", "onClose", "Lkotlin/Function0;", "(Lcom/checkout/frames/style/screen/CountryPickerStyle;Lcom/checkout/frames/di/base/Injector;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "HeaderComponent", "screenTitleStyle", "screenTitleState", "Lcom/checkout/frames/view/TextLabelState;", "searchFieldStyle", "Lcom/checkout/frames/style/view/InputFieldViewStyle;", "searchFieldState", "Lcom/checkout/frames/view/InputFieldState;", "onSearchFocusChange", "", "onSearchValueChange", "(Lcom/checkout/frames/style/view/TextLabelViewStyle;Lcom/checkout/frames/view/TextLabelState;Lcom/checkout/frames/style/view/InputFieldViewStyle;Lcom/checkout/frames/view/InputFieldState;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "frames_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class CountryPickerScreenKt {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v0, resolved type: kotlin.jvm.functions.Function0} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    @androidx.compose.runtime.ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void CountryItemComponent(com.checkout.frames.style.view.TextLabelViewStyle r20, com.checkout.frames.screen.countrypicker.CountryItem r21, kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r22, androidx.compose.runtime.Composer r23, int r24) {
        /*
            r0 = r20
            r1 = r21
            r2 = r22
            r3 = -534220496(0xffffffffe0287130, float:-4.855014E19)
            r4 = r23
            androidx.compose.runtime.Composer r3 = r4.startRestartGroup(r3)
            com.checkout.frames.view.TextLabelState r12 = new com.checkout.frames.view.TextLabelState
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 31
            r11 = 0
            r4 = r12
            r4.<init>(r5, r6, r7, r8, r9, r10, r11)
            androidx.compose.runtime.MutableState r4 = r12.isVisible()
            java.lang.Boolean r5 = java.lang.Boolean.TRUE
            r4.setValue(r5)
            androidx.compose.runtime.MutableState r4 = r12.getText()
            java.lang.String r5 = r21.getEmojiFlag()
            java.lang.String r6 = r21.getName()
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r5)
            java.lang.String r5 = "    "
            r7.append(r5)
            r7.append(r6)
            java.lang.String r5 = r7.toString()
            r4.setValue(r5)
            androidx.compose.ui.Modifier$Companion r4 = androidx.compose.ui.Modifier.Companion
            r5 = 1
            r6 = 0
            r7 = 0
            androidx.compose.ui.Modifier r13 = androidx.compose.foundation.layout.SizeKt.fillMaxWidth$default(r4, r7, r5, r6)
            r14 = 0
            r15 = 0
            r16 = 0
            r4 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r3.startReplaceableGroup(r4)
            boolean r4 = r3.changed((java.lang.Object) r2)
            boolean r5 = r3.changed((java.lang.Object) r1)
            r4 = r4 | r5
            java.lang.Object r5 = r3.rememberedValue()
            if (r4 != 0) goto L_0x0073
            androidx.compose.runtime.Composer$Companion r4 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r4 = r4.getEmpty()
            if (r5 != r4) goto L_0x007b
        L_0x0073:
            com.checkout.frames.screen.countrypicker.CountryPickerScreenKt$CountryItemComponent$1$1 r5 = new com.checkout.frames.screen.countrypicker.CountryPickerScreenKt$CountryItemComponent$1$1
            r5.<init>(r2, r1)
            r3.updateRememberedValue(r5)
        L_0x007b:
            r3.endReplaceableGroup()
            r17 = r5
            kotlin.jvm.functions.Function0 r17 = (kotlin.jvm.functions.Function0) r17
            r18 = 7
            r19 = 0
            androidx.compose.ui.Modifier r4 = androidx.compose.foundation.ClickableKt.m196clickableXHw0xAI$default(r13, r14, r15, r16, r17, r18, r19)
            r5 = 693286680(0x2952b718, float:4.6788176E-14)
            r3.startReplaceableGroup(r5)
            androidx.compose.foundation.layout.Arrangement r5 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$Horizontal r5 = r5.getStart()
            androidx.compose.ui.Alignment$Companion r6 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Vertical r6 = r6.getTop()
            r7 = 0
            androidx.compose.ui.layout.MeasurePolicy r5 = androidx.compose.foundation.layout.RowKt.rowMeasurePolicy(r5, r6, r3, r7)
            r6 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r3.startReplaceableGroup(r6)
            androidx.compose.runtime.ProvidableCompositionLocal r6 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            java.lang.Object r6 = r3.consume(r6)
            androidx.compose.ui.unit.Density r6 = (androidx.compose.ui.unit.Density) r6
            androidx.compose.runtime.ProvidableCompositionLocal r8 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            java.lang.Object r8 = r3.consume(r8)
            androidx.compose.ui.unit.LayoutDirection r8 = (androidx.compose.ui.unit.LayoutDirection) r8
            androidx.compose.runtime.ProvidableCompositionLocal r9 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            java.lang.Object r9 = r3.consume(r9)
            androidx.compose.ui.platform.ViewConfiguration r9 = (androidx.compose.ui.platform.ViewConfiguration) r9
            androidx.compose.ui.node.ComposeUiNode$Companion r10 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r11 = r10.getConstructor()
            kotlin.jvm.functions.Function3 r4 = androidx.compose.ui.layout.LayoutKt.materializerOf(r4)
            androidx.compose.runtime.Applier r13 = r3.getApplier()
            boolean r13 = r13 instanceof androidx.compose.runtime.Applier
            if (r13 != 0) goto L_0x00da
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x00da:
            r3.startReusableNode()
            boolean r13 = r3.getInserting()
            if (r13 == 0) goto L_0x00e7
            r3.createNode(r11)
            goto L_0x00ea
        L_0x00e7:
            r3.useNode()
        L_0x00ea:
            r3.disableReusing()
            androidx.compose.runtime.Composer r11 = androidx.compose.runtime.Updater.m2536constructorimpl(r3)
            kotlin.jvm.functions.Function2 r13 = r10.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r11, r5, r13)
            kotlin.jvm.functions.Function2 r5 = r10.getSetDensity()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r11, r6, r5)
            kotlin.jvm.functions.Function2 r5 = r10.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r11, r8, r5)
            kotlin.jvm.functions.Function2 r5 = r10.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r11, r9, r5)
            r3.enableReusing()
            androidx.compose.runtime.Composer r5 = androidx.compose.runtime.SkippableUpdater.m2527constructorimpl(r3)
            androidx.compose.runtime.SkippableUpdater r5 = androidx.compose.runtime.SkippableUpdater.m2526boximpl(r5)
            java.lang.Integer r6 = java.lang.Integer.valueOf(r7)
            r4.invoke(r5, r3, r6)
            r4 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r3.startReplaceableGroup(r4)
            r4 = -678309503(0xffffffffd791d181, float:-3.20657997E14)
            r3.startReplaceableGroup(r4)
            androidx.compose.foundation.layout.RowScopeInstance r4 = androidx.compose.foundation.layout.RowScopeInstance.INSTANCE
            r4 = 8
            com.checkout.frames.view.TextLabelKt.TextLabel(r0, r12, r3, r4)
            r3.endReplaceableGroup()
            r3.endReplaceableGroup()
            r3.endNode()
            r3.endReplaceableGroup()
            r3.endReplaceableGroup()
            androidx.compose.runtime.ScopeUpdateScope r3 = r3.endRestartGroup()
            if (r3 != 0) goto L_0x0148
            goto L_0x0152
        L_0x0148:
            com.checkout.frames.screen.countrypicker.CountryPickerScreenKt$CountryItemComponent$3 r4 = new com.checkout.frames.screen.countrypicker.CountryPickerScreenKt$CountryItemComponent$3
            r5 = r24
            r4.<init>(r0, r1, r2, r5)
            r3.updateScope(r4)
        L_0x0152:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.checkout.frames.screen.countrypicker.CountryPickerScreenKt.CountryItemComponent(com.checkout.frames.style.view.TextLabelViewStyle, com.checkout.frames.screen.countrypicker.CountryItem, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int):void");
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void CountryPickerScreen(@NotNull CountryPickerStyle countryPickerStyle, @NotNull Injector injector, @NotNull Function0<Unit> function0, @Nullable Composer composer, int i11) {
        CreationExtras creationExtras;
        CountryPickerStyle countryPickerStyle2 = countryPickerStyle;
        Injector injector2 = injector;
        Function0<Unit> function02 = function0;
        Intrinsics.checkNotNullParameter(countryPickerStyle2, "style");
        Intrinsics.checkNotNullParameter(injector2, "injector");
        Intrinsics.checkNotNullParameter(function02, "onClose");
        Composer startRestartGroup = composer.startRestartGroup(1972954548);
        CountryPickerViewModel.Factory factory = new CountryPickerViewModel.Factory(injector2, countryPickerStyle2);
        startRestartGroup.startReplaceableGroup(1729797275);
        ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(startRestartGroup, 6);
        if (current != null) {
            if (current instanceof HasDefaultViewModelProviderFactory) {
                creationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                Intrinsics.checkNotNullExpressionValue(creationExtras, "{\n        viewModelStore…ModelCreationExtras\n    }");
            } else {
                creationExtras = CreationExtras.Empty.INSTANCE;
            }
            ViewModel viewModel = ViewModelKt.viewModel(CountryPickerViewModel.class, current, (String) null, factory, creationExtras, startRestartGroup, 36936, 0);
            startRestartGroup.endReplaceableGroup();
            CountryPickerViewModel countryPickerViewModel = (CountryPickerViewModel) viewModel;
            if (countryPickerViewModel.getGoBack().getValue().booleanValue()) {
                function0.invoke();
            }
            startRestartGroup.startReplaceableGroup(1399974279);
            if (!countryPickerViewModel.isSearchActive().getValue().booleanValue()) {
                SoftwareKeyboardController current2 = LocalSoftwareKeyboardController.INSTANCE.getCurrent(startRestartGroup, 8);
                if (current2 != null) {
                    current2.hide();
                }
                ((FocusManager) startRestartGroup.consume(CompositionLocalsKt.getLocalFocusManager())).clearFocus(true);
            }
            startRestartGroup.endReplaceableGroup();
            Modifier fillMaxHeight$default = SizeKt.fillMaxHeight$default(SizeKt.fillMaxWidth$default(countryPickerViewModel.getScreenModifier(), 0.0f, 1, (Object) null), 0.0f, 1, (Object) null);
            startRestartGroup.startReplaceableGroup(-483455358);
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-1323940314);
            Density density = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration = (ViewConfiguration) startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion = ComposeUiNode.Companion;
            Function0<ComposeUiNode> constructor = companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(fillMaxHeight$default);
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
            Composer r11 = Updater.m2536constructorimpl(startRestartGroup);
            Updater.m2543setimpl(r11, columnMeasurePolicy, companion.getSetMeasurePolicy());
            Updater.m2543setimpl(r11, density, companion.getSetDensity());
            Updater.m2543setimpl(r11, layoutDirection, companion.getSetLayoutDirection());
            Updater.m2543setimpl(r11, viewConfiguration, companion.getSetViewConfiguration());
            startRestartGroup.enableReusing();
            materializerOf.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            startRestartGroup.startReplaceableGroup(-1163856341);
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            HeaderComponent(countryPickerViewModel.getScreenTitleStyle(), countryPickerViewModel.getScreenTitleState(), countryPickerViewModel.getSearchFieldStyle(), countryPickerViewModel.getSearchFieldState(), new CountryPickerScreenKt$CountryPickerScreen$1$1(countryPickerViewModel), new CountryPickerScreenKt$CountryPickerScreen$1$2(countryPickerViewModel), startRestartGroup, 520);
            LazyDslKt.LazyColumn((Modifier) null, (LazyListState) null, (PaddingValues) null, false, (Arrangement.Vertical) null, (Alignment.Horizontal) null, (FlingBehavior) null, false, new CountryPickerScreenKt$CountryPickerScreen$1$3(countryPickerViewModel), startRestartGroup, 0, 255);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
                endRestartGroup.updateScope(new CountryPickerScreenKt$CountryPickerScreen$2(countryPickerStyle2, injector2, function02, i11));
                return;
            }
            return;
        }
        throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
    }

    /* access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void HeaderComponent(TextLabelViewStyle textLabelViewStyle, TextLabelState textLabelState, InputFieldViewStyle inputFieldViewStyle, InputFieldState inputFieldState, Function1<? super Boolean, Unit> function1, Function1<? super String, Unit> function12, Composer composer, int i11) {
        Composer startRestartGroup = composer.startRestartGroup(-1699791835);
        startRestartGroup.startReplaceableGroup(-483455358);
        Modifier.Companion companion = Modifier.Companion;
        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(-1323940314);
        Density density = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
        LayoutDirection layoutDirection = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
        ViewConfiguration viewConfiguration = (ViewConfiguration) startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
        ComposeUiNode.Companion companion2 = ComposeUiNode.Companion;
        Function0<ComposeUiNode> constructor = companion2.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(companion);
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
        Composer r82 = Updater.m2536constructorimpl(startRestartGroup);
        Updater.m2543setimpl(r82, columnMeasurePolicy, companion2.getSetMeasurePolicy());
        Updater.m2543setimpl(r82, density, companion2.getSetDensity());
        Updater.m2543setimpl(r82, layoutDirection, companion2.getSetLayoutDirection());
        Updater.m2543setimpl(r82, viewConfiguration, companion2.getSetViewConfiguration());
        startRestartGroup.enableReusing();
        materializerOf.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(startRestartGroup)), startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(2058660585);
        startRestartGroup.startReplaceableGroup(-1163856341);
        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
        TextLabelViewStyle textLabelViewStyle2 = textLabelViewStyle;
        TextLabelState textLabelState2 = textLabelState;
        TextLabelKt.TextLabel(textLabelViewStyle, textLabelState, startRestartGroup, (i11 & 112) | 8);
        int i12 = i11 >> 6;
        InputFieldKt.InputField(inputFieldViewStyle, inputFieldState, function1, function12, startRestartGroup, (i12 & 112) | 8 | (i12 & 896) | (i12 & 7168), 0);
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endNode();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new CountryPickerScreenKt$HeaderComponent$2(textLabelViewStyle, textLabelState, inputFieldViewStyle, inputFieldState, function1, function12, i11));
        }
    }
}
