package com.checkout.frames.component.base;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
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
import com.checkout.frames.style.view.InputComponentViewStyle;
import com.checkout.frames.view.InputFieldKt;
import com.checkout.frames.view.TextLabelKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p.e;

@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001aI\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00072\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\u0007H\u0001¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"InputComponent", "", "style", "Lcom/checkout/frames/style/view/InputComponentViewStyle;", "state", "Lcom/checkout/frames/component/base/InputComponentState;", "onFocusChanged", "Lkotlin/Function1;", "", "onValueChange", "", "(Lcom/checkout/frames/style/view/InputComponentViewStyle;Lcom/checkout/frames/component/base/InputComponentState;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "frames_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class InputComponentKt {
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void InputComponent(@NotNull InputComponentViewStyle inputComponentViewStyle, @NotNull InputComponentState inputComponentState, @Nullable Function1<? super Boolean, Unit> function1, @NotNull Function1<? super String, Unit> function12, @Nullable Composer composer, int i11, int i12) {
        Function1<? super Boolean, Unit> function13;
        int i13 = i11;
        Intrinsics.checkNotNullParameter(inputComponentViewStyle, "style");
        Intrinsics.checkNotNullParameter(inputComponentState, "state");
        Intrinsics.checkNotNullParameter(function12, "onValueChange");
        Composer startRestartGroup = composer.startRestartGroup(171350002);
        if ((i12 & 4) != 0) {
            function13 = null;
        } else {
            function13 = function1;
        }
        Modifier wrapContentHeight$default = SizeKt.wrapContentHeight$default(inputComponentViewStyle.getContainerModifier(), (Alignment.Vertical) null, false, 3, (Object) null);
        startRestartGroup.startReplaceableGroup(-483455358);
        Arrangement arrangement = Arrangement.INSTANCE;
        Arrangement.Vertical top = arrangement.getTop();
        Alignment.Companion companion = Alignment.Companion;
        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(top, companion.getStart(), startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(-1323940314);
        Density density = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
        LayoutDirection layoutDirection = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
        ViewConfiguration viewConfiguration = (ViewConfiguration) startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
        ComposeUiNode.Companion companion2 = ComposeUiNode.Companion;
        Function0<ComposeUiNode> constructor = companion2.getConstructor();
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
        Updater.m2543setimpl(r92, columnMeasurePolicy, companion2.getSetMeasurePolicy());
        Updater.m2543setimpl(r92, density, companion2.getSetDensity());
        Updater.m2543setimpl(r92, layoutDirection, companion2.getSetLayoutDirection());
        Updater.m2543setimpl(r92, viewConfiguration, companion2.getSetViewConfiguration());
        startRestartGroup.enableReusing();
        materializerOf.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(startRestartGroup)), startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(2058660585);
        startRestartGroup.startReplaceableGroup(-1163856341);
        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
        startRestartGroup.startReplaceableGroup(693286680);
        Modifier.Companion companion3 = Modifier.Companion;
        MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getStart(), companion.getTop(), startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(-1323940314);
        Density density2 = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
        LayoutDirection layoutDirection2 = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
        ViewConfiguration viewConfiguration2 = (ViewConfiguration) startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
        Function0<ComposeUiNode> constructor2 = companion2.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf2 = LayoutKt.materializerOf(companion3);
        if (!(startRestartGroup.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
            startRestartGroup.createNode(constructor2);
        } else {
            startRestartGroup.useNode();
        }
        startRestartGroup.disableReusing();
        Composer r72 = Updater.m2536constructorimpl(startRestartGroup);
        Updater.m2543setimpl(r72, rowMeasurePolicy, companion2.getSetMeasurePolicy());
        Updater.m2543setimpl(r72, density2, companion2.getSetDensity());
        Updater.m2543setimpl(r72, layoutDirection2, companion2.getSetLayoutDirection());
        Updater.m2543setimpl(r72, viewConfiguration2, companion2.getSetViewConfiguration());
        startRestartGroup.enableReusing();
        materializerOf2.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(startRestartGroup)), startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(2058660585);
        startRestartGroup.startReplaceableGroup(-678309503);
        RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
        Modifier wrapContentHeight$default2 = SizeKt.wrapContentHeight$default(e.a(rowScopeInstance, companion3, 1.0f, false, 2, (Object) null), (Alignment.Vertical) null, false, 3, (Object) null);
        startRestartGroup.startReplaceableGroup(-483455358);
        MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(arrangement.getTop(), companion.getStart(), startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(-1323940314);
        Density density3 = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
        LayoutDirection layoutDirection3 = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
        ViewConfiguration viewConfiguration3 = (ViewConfiguration) startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
        Function0<ComposeUiNode> constructor3 = companion2.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf3 = LayoutKt.materializerOf(wrapContentHeight$default2);
        if (!(startRestartGroup.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
            startRestartGroup.createNode(constructor3);
        } else {
            startRestartGroup.useNode();
        }
        startRestartGroup.disableReusing();
        Composer r12 = Updater.m2536constructorimpl(startRestartGroup);
        Updater.m2543setimpl(r12, columnMeasurePolicy2, companion2.getSetMeasurePolicy());
        Updater.m2543setimpl(r12, density3, companion2.getSetDensity());
        Updater.m2543setimpl(r12, layoutDirection3, companion2.getSetLayoutDirection());
        Updater.m2543setimpl(r12, viewConfiguration3, companion2.getSetViewConfiguration());
        startRestartGroup.enableReusing();
        materializerOf3.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(startRestartGroup)), startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(2058660585);
        startRestartGroup.startReplaceableGroup(-1163856341);
        startRestartGroup.startReplaceableGroup(-716616696);
        if (inputComponentState.getTitleState().isVisible().getValue().booleanValue()) {
            TextLabelKt.TextLabel(inputComponentViewStyle.getTitleStyle(), inputComponentState.getTitleState(), startRestartGroup, 8);
        }
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.startReplaceableGroup(409816033);
        if (inputComponentState.getSubtitleState().isVisible().getValue().booleanValue()) {
            TextLabelKt.TextLabel(inputComponentViewStyle.getSubtitleStyle(), inputComponentState.getSubtitleState(), startRestartGroup, 8);
        }
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endNode();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        Modifier wrapContentHeight$default3 = SizeKt.wrapContentHeight$default(rowScopeInstance.align(companion3, companion.getBottom()), (Alignment.Vertical) null, false, 3, (Object) null);
        startRestartGroup.startReplaceableGroup(-483455358);
        MeasurePolicy columnMeasurePolicy3 = ColumnKt.columnMeasurePolicy(arrangement.getTop(), companion.getStart(), startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(-1323940314);
        Density density4 = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
        LayoutDirection layoutDirection4 = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
        ViewConfiguration viewConfiguration4 = (ViewConfiguration) startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
        Function0<ComposeUiNode> constructor4 = companion2.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf4 = LayoutKt.materializerOf(wrapContentHeight$default3);
        if (!(startRestartGroup.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
            startRestartGroup.createNode(constructor4);
        } else {
            startRestartGroup.useNode();
        }
        startRestartGroup.disableReusing();
        Composer r102 = Updater.m2536constructorimpl(startRestartGroup);
        Updater.m2543setimpl(r102, columnMeasurePolicy3, companion2.getSetMeasurePolicy());
        Updater.m2543setimpl(r102, density4, companion2.getSetDensity());
        Updater.m2543setimpl(r102, layoutDirection4, companion2.getSetLayoutDirection());
        Updater.m2543setimpl(r102, viewConfiguration4, companion2.getSetViewConfiguration());
        startRestartGroup.enableReusing();
        materializerOf4.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(startRestartGroup)), startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(2058660585);
        startRestartGroup.startReplaceableGroup(-1163856341);
        startRestartGroup.startReplaceableGroup(-1224334624);
        if (inputComponentState.getInfoState().isVisible().getValue().booleanValue()) {
            TextLabelKt.TextLabel(inputComponentViewStyle.getInfoStyle(), inputComponentState.getInfoState(), startRestartGroup, 8);
        }
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endNode();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endNode();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        InputFieldKt.InputField(inputComponentViewStyle.getInputFieldStyle(), inputComponentState.getInputFieldState(), function13, function12, startRestartGroup, (i13 & 896) | 8 | (i13 & 7168), 0);
        if (inputComponentState.getErrorState().isVisible().getValue().booleanValue()) {
            TextLabelKt.TextLabel(inputComponentViewStyle.getErrorMessageStyle(), inputComponentState.getErrorState(), startRestartGroup, 8);
        }
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endNode();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        Unit unit = Unit.INSTANCE;
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new InputComponentKt$InputComponent$2(inputComponentViewStyle, inputComponentState, function13, function12, i11, i12));
        }
    }
}
