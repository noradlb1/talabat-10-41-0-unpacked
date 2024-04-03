package com.checkout.frames.component.cardscheme;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
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
import com.checkout.frames.component.cardscheme.CardSchemeViewModel;
import com.checkout.frames.di.base.Injector;
import com.checkout.frames.style.component.CardSchemeComponentStyle;
import com.checkout.frames.style.view.CardSchemeComponentViewStyle;
import com.checkout.frames.view.TextLabelKt;
import com.checkout.frames.view.TextLabelState;
import com.google.accompanist.flowlayout.FlowCrossAxisAlignment;
import com.google.accompanist.flowlayout.FlowKt;
import com.google.accompanist.flowlayout.MainAxisAlignment;
import com.google.accompanist.flowlayout.SizeMode;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a8\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0019\u0010\u0006\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\b¢\u0006\u0002\b\t0\u0007H\u0003¢\u0006\u0002\u0010\n\u001a\u001d\u0010\u000b\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0001¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, d2 = {"BasicCardSchemeComponent", "", "style", "Lcom/checkout/frames/style/view/CardSchemeComponentViewStyle;", "state", "Lcom/checkout/frames/component/cardscheme/CardSchemeComponentState;", "supportedCardSchemeIconList", "", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Lcom/checkout/frames/style/view/CardSchemeComponentViewStyle;Lcom/checkout/frames/component/cardscheme/CardSchemeComponentState;Ljava/util/List;Landroidx/compose/runtime/Composer;I)V", "CardSchemeComponent", "Lcom/checkout/frames/style/component/CardSchemeComponentStyle;", "injector", "Lcom/checkout/frames/di/base/Injector;", "(Lcom/checkout/frames/style/component/CardSchemeComponentStyle;Lcom/checkout/frames/di/base/Injector;Landroidx/compose/runtime/Composer;I)V", "frames_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class CardSchemeComponentKt {
    /* access modifiers changed from: private */
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    @Composable
    public static final void BasicCardSchemeComponent(CardSchemeComponentViewStyle cardSchemeComponentViewStyle, CardSchemeComponentState cardSchemeComponentState, List<? extends Function2<? super Composer, ? super Integer, Unit>> list, Composer composer, int i11) {
        List<? extends Function2<? super Composer, ? super Integer, Unit>> list2 = list;
        Composer startRestartGroup = composer.startRestartGroup(784020352);
        Modifier wrapContentHeight$default = SizeKt.wrapContentHeight$default(cardSchemeComponentViewStyle.getContainerModifier(), (Alignment.Vertical) null, false, 3, (Object) null);
        startRestartGroup.startReplaceableGroup(-483455358);
        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(-1323940314);
        Density density = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
        LayoutDirection layoutDirection = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
        ViewConfiguration viewConfiguration = (ViewConfiguration) startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
        ComposeUiNode.Companion companion = ComposeUiNode.Companion;
        Function0<ComposeUiNode> constructor = companion.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(wrapContentHeight$default);
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
        Composer r92 = Updater.m2536constructorimpl(startRestartGroup);
        Updater.m2543setimpl(r92, columnMeasurePolicy, companion.getSetMeasurePolicy());
        Updater.m2543setimpl(r92, density, companion.getSetDensity());
        Updater.m2543setimpl(r92, layoutDirection, companion.getSetLayoutDirection());
        Updater.m2543setimpl(r92, viewConfiguration, companion.getSetViewConfiguration());
        startRestartGroup.enableReusing();
        materializerOf.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(startRestartGroup)), startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(2058660585);
        startRestartGroup.startReplaceableGroup(-1163856341);
        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
        TextLabelState textLabelState = cardSchemeComponentState.getTextLabelState();
        startRestartGroup.startReplaceableGroup(-633275088);
        if (textLabelState != null && textLabelState.isVisible().getValue().booleanValue()) {
            TextLabelKt.TextLabel(cardSchemeComponentViewStyle.getTitleStyle(), textLabelState, startRestartGroup, 8);
        }
        startRestartGroup.endReplaceableGroup();
        FlowKt.m9016FlowRow07r0xoM(cardSchemeComponentViewStyle.getFlowRowViewStyle().getImagesContainerModifier(), (SizeMode) null, (MainAxisAlignment) null, cardSchemeComponentViewStyle.getFlowRowViewStyle().m9273getMainAxisSpacingD9Ej5fM(), (FlowCrossAxisAlignment) null, cardSchemeComponentViewStyle.getFlowRowViewStyle().m9272getCrossAxisSpacingD9Ej5fM(), (MainAxisAlignment) null, ComposableLambdaKt.composableLambda(startRestartGroup, -1836202282, true, new CardSchemeComponentKt$BasicCardSchemeComponent$1$1$2(list)), startRestartGroup, 12582912, 86);
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endNode();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            CardSchemeComponentViewStyle cardSchemeComponentViewStyle2 = cardSchemeComponentViewStyle;
            CardSchemeComponentState cardSchemeComponentState2 = cardSchemeComponentState;
            endRestartGroup.updateScope(new CardSchemeComponentKt$BasicCardSchemeComponent$2(cardSchemeComponentViewStyle, cardSchemeComponentState, list, i11));
        }
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void CardSchemeComponent(@NotNull CardSchemeComponentStyle cardSchemeComponentStyle, @NotNull Injector injector, @Nullable Composer composer, int i11) {
        CreationExtras creationExtras;
        Intrinsics.checkNotNullParameter(cardSchemeComponentStyle, "style");
        Intrinsics.checkNotNullParameter(injector, "injector");
        Composer startRestartGroup = composer.startRestartGroup(-1158186896);
        CardSchemeViewModel.Factory factory = new CardSchemeViewModel.Factory(injector, cardSchemeComponentStyle);
        startRestartGroup.startReplaceableGroup(1729797275);
        ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(startRestartGroup, 6);
        if (current != null) {
            if (current instanceof HasDefaultViewModelProviderFactory) {
                creationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                Intrinsics.checkNotNullExpressionValue(creationExtras, "{\n        viewModelStore…ModelCreationExtras\n    }");
            } else {
                creationExtras = CreationExtras.Empty.INSTANCE;
            }
            ViewModel viewModel = ViewModelKt.viewModel(CardSchemeViewModel.class, current, (String) null, factory, creationExtras, startRestartGroup, 36936, 0);
            startRestartGroup.endReplaceableGroup();
            CardSchemeViewModel cardSchemeViewModel = (CardSchemeViewModel) viewModel;
            BasicCardSchemeComponent(cardSchemeViewModel.getComponentStyle(), cardSchemeViewModel.getComponentState(), cardSchemeViewModel.getComponentSupportedCardSchemeIcons(), startRestartGroup, 520);
            ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
                endRestartGroup.updateScope(new CardSchemeComponentKt$CardSchemeComponent$1(cardSchemeComponentStyle, injector, i11));
                return;
            }
            return;
        }
        throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
    }
}
