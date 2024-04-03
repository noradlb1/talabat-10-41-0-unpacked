package com.checkout.frames.component.addresssummary;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.DividerKt;
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
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.lifecycle.viewmodel.compose.ViewModelKt;
import com.checkout.frames.component.addresssummary.AddressSummaryViewModel;
import com.checkout.frames.di.base.Injector;
import com.checkout.frames.style.component.addresssummary.AddressSummaryComponentStyle;
import com.checkout.frames.style.view.DividerViewStyle;
import com.checkout.frames.style.view.TextLabelViewStyle;
import com.checkout.frames.style.view.addresssummary.AddressSummarySectionViewStyle;
import com.checkout.frames.view.InternalButtonKt;
import com.checkout.frames.view.InternalButtonState;
import com.checkout.frames.view.TextLabelKt;
import com.checkout.frames.view.TextLabelState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a+\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0001¢\u0006\u0002\u0010\b\u001a3\u0010\t\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0003¢\u0006\u0002\u0010\u0010¨\u0006\u0011"}, d2 = {"AddressSummaryComponent", "", "style", "Lcom/checkout/frames/style/component/addresssummary/AddressSummaryComponentStyle;", "injector", "Lcom/checkout/frames/di/base/Injector;", "goToBillingAddressForm", "Lkotlin/Function0;", "(Lcom/checkout/frames/style/component/addresssummary/AddressSummaryComponentStyle;Lcom/checkout/frames/di/base/Injector;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "AddressSummarySection", "Lcom/checkout/frames/style/view/addresssummary/AddressSummarySectionViewStyle;", "addressPreviewState", "Lcom/checkout/frames/view/TextLabelState;", "editAddressButtonState", "Lcom/checkout/frames/view/InternalButtonState;", "onEditButtonPress", "(Lcom/checkout/frames/style/view/addresssummary/AddressSummarySectionViewStyle;Lcom/checkout/frames/view/TextLabelState;Lcom/checkout/frames/view/InternalButtonState;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "frames_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class AddressSummaryComponentKt {
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void AddressSummaryComponent(@NotNull AddressSummaryComponentStyle addressSummaryComponentStyle, @NotNull Injector injector, @NotNull Function0<Unit> function0, @Nullable Composer composer, int i11) {
        CreationExtras creationExtras;
        Intrinsics.checkNotNullParameter(addressSummaryComponentStyle, "style");
        Intrinsics.checkNotNullParameter(injector, "injector");
        Intrinsics.checkNotNullParameter(function0, "goToBillingAddressForm");
        Composer startRestartGroup = composer.startRestartGroup(-1471573060);
        AddressSummaryViewModel.Factory factory = new AddressSummaryViewModel.Factory(injector, addressSummaryComponentStyle);
        startRestartGroup.startReplaceableGroup(1729797275);
        ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(startRestartGroup, 6);
        if (current != null) {
            if (current instanceof HasDefaultViewModelProviderFactory) {
                creationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                Intrinsics.checkNotNullExpressionValue(creationExtras, "{\n        viewModelStore…ModelCreationExtras\n    }");
            } else {
                creationExtras = CreationExtras.Empty.INSTANCE;
            }
            ViewModel viewModel = ViewModelKt.viewModel(AddressSummaryViewModel.class, current, (String) null, factory, creationExtras, startRestartGroup, 36936, 0);
            startRestartGroup.endReplaceableGroup();
            AddressSummaryViewModel addressSummaryViewModel = (AddressSummaryViewModel) viewModel;
            addressSummaryViewModel.prepare();
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(addressSummaryViewModel.getComponentStyle().getModifier(), 0.0f, 1, (Object) null);
            startRestartGroup.startReplaceableGroup(-483455358);
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), startRestartGroup, 0);
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
            Composer r82 = Updater.m2536constructorimpl(startRestartGroup);
            Updater.m2543setimpl(r82, columnMeasurePolicy, companion.getSetMeasurePolicy());
            Updater.m2543setimpl(r82, density, companion.getSetDensity());
            Updater.m2543setimpl(r82, layoutDirection, companion.getSetLayoutDirection());
            Updater.m2543setimpl(r82, viewConfiguration, companion.getSetViewConfiguration());
            startRestartGroup.enableReusing();
            materializerOf.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            startRestartGroup.startReplaceableGroup(-1163856341);
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            TextLabelViewStyle titleStyle = addressSummaryViewModel.getComponentStyle().getTitleStyle();
            startRestartGroup.startReplaceableGroup(2069902354);
            if (titleStyle != null) {
                TextLabelKt.TextLabel(titleStyle, addressSummaryViewModel.getComponentState().getTitleState(), startRestartGroup, 8);
            }
            startRestartGroup.endReplaceableGroup();
            TextLabelViewStyle subTitleStyle = addressSummaryViewModel.getComponentStyle().getSubTitleStyle();
            startRestartGroup.startReplaceableGroup(2069902517);
            if (subTitleStyle != null) {
                TextLabelKt.TextLabel(subTitleStyle, addressSummaryViewModel.getComponentState().getSubTitleState(), startRestartGroup, 8);
            }
            startRestartGroup.endReplaceableGroup();
            if (StringsKt__StringsJVMKt.isBlank(addressSummaryViewModel.getComponentState().getAddressPreviewState().getText().getValue())) {
                startRestartGroup.startReplaceableGroup(2069902743);
                InternalButtonKt.InternalButton(addressSummaryViewModel.getComponentStyle().getAddAddressButtonStyle(), addressSummaryViewModel.getComponentState().getAddAddressButtonState(), function0, startRestartGroup, 8 | (i11 & 896));
                startRestartGroup.endReplaceableGroup();
            } else {
                startRestartGroup.startReplaceableGroup(2069902995);
                AddressSummarySection(addressSummaryViewModel.getComponentStyle().getSummarySectionStyle(), addressSummaryViewModel.getComponentState().getAddressPreviewState(), addressSummaryViewModel.getComponentState().getEditAddressButtonState(), function0, startRestartGroup, ((i11 << 3) & 7168) | 8);
                startRestartGroup.endReplaceableGroup();
            }
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
                endRestartGroup.updateScope(new AddressSummaryComponentKt$AddressSummaryComponent$2(addressSummaryComponentStyle, injector, function0, i11));
                return;
            }
            return;
        }
        throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
    }

    /* access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void AddressSummarySection(AddressSummarySectionViewStyle addressSummarySectionViewStyle, TextLabelState textLabelState, InternalButtonState internalButtonState, Function0<Unit> function0, Composer composer, int i11) {
        Composer startRestartGroup = composer.startRestartGroup(-1841382179);
        Modifier modifier = addressSummarySectionViewStyle.getModifier();
        startRestartGroup.startReplaceableGroup(-483455358);
        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(-1323940314);
        Density density = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
        LayoutDirection layoutDirection = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
        ViewConfiguration viewConfiguration = (ViewConfiguration) startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
        ComposeUiNode.Companion companion = ComposeUiNode.Companion;
        Function0<ComposeUiNode> constructor = companion.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(modifier);
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
        Composer r72 = Updater.m2536constructorimpl(startRestartGroup);
        Updater.m2543setimpl(r72, columnMeasurePolicy, companion.getSetMeasurePolicy());
        Updater.m2543setimpl(r72, density, companion.getSetDensity());
        Updater.m2543setimpl(r72, layoutDirection, companion.getSetLayoutDirection());
        Updater.m2543setimpl(r72, viewConfiguration, companion.getSetViewConfiguration());
        startRestartGroup.enableReusing();
        materializerOf.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(startRestartGroup)), startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(2058660585);
        startRestartGroup.startReplaceableGroup(-1163856341);
        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
        TextLabelKt.TextLabel(addressSummarySectionViewStyle.getAddressTextStyle(), textLabelState, startRestartGroup, (i11 & 112) | 8);
        DividerViewStyle dividerStyle = addressSummarySectionViewStyle.getDividerStyle();
        startRestartGroup.startReplaceableGroup(1165870267);
        if (dividerStyle != null) {
            DividerKt.m1645Divider9IZ8Weo(dividerStyle.getModifier(), dividerStyle.m9267getThicknessD9Ej5fM(), dividerStyle.m9266getColor0d7_KjU(), startRestartGroup, 0, 0);
        }
        startRestartGroup.endReplaceableGroup();
        int i12 = i11 >> 3;
        InternalButtonKt.InternalButton(addressSummarySectionViewStyle.getEditAddressButtonStyle(), internalButtonState, function0, startRestartGroup, (i12 & 896) | (i12 & 112) | 8);
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endNode();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new AddressSummaryComponentKt$AddressSummarySection$2(addressSummarySectionViewStyle, textLabelState, internalButtonState, function0, i11));
        }
    }
}
