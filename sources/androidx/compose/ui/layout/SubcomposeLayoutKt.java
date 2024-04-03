package androidx.compose.ui.layout;

import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.UiComposable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u001a9\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u001d\u0010\u0004\u001a\u0019\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\u0002\b\tH\u0007ø\u0001\u0000¢\u0006\u0002\u0010\n\u001aA\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u001d\u0010\u0004\u001a\u0019\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\u0002\b\tH\u0007ø\u0001\u0000¢\u0006\u0002\u0010\r\u001a\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"SubcomposeLayout", "", "modifier", "Landroidx/compose/ui/Modifier;", "measurePolicy", "Lkotlin/Function2;", "Landroidx/compose/ui/layout/SubcomposeMeasureScope;", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/ui/layout/MeasureResult;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "state", "Landroidx/compose/ui/layout/SubcomposeLayoutState;", "(Landroidx/compose/ui/layout/SubcomposeLayoutState;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "SubcomposeSlotReusePolicy", "Landroidx/compose/ui/layout/SubcomposeSlotReusePolicy;", "maxSlotsToRetainForReuse", "", "ui_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class SubcomposeLayoutKt {
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void SubcomposeLayout(@Nullable Modifier modifier, @NotNull Function2<? super SubcomposeMeasureScope, ? super Constraints, ? extends MeasureResult> function2, @Nullable Composer composer, int i11, int i12) {
        int i13;
        Intrinsics.checkNotNullParameter(function2, "measurePolicy");
        Composer startRestartGroup = composer.startRestartGroup(-1298353104);
        int i14 = i12 & 1;
        if (i14 != 0) {
            i13 = i11 | 6;
        } else if ((i11 & 14) == 0) {
            i13 = (startRestartGroup.changed((Object) modifier) ? 4 : 2) | i11;
        } else {
            i13 = i11;
        }
        if ((i12 & 2) != 0) {
            i13 |= 48;
        } else if ((i11 & 112) == 0) {
            i13 |= startRestartGroup.changed((Object) function2) ? 32 : 16;
        }
        if ((i13 & 91) != 18 || !startRestartGroup.getSkipping()) {
            if (i14 != 0) {
                modifier = Modifier.Companion;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1298353104, i13, -1, "androidx.compose.ui.layout.SubcomposeLayout (SubcomposeLayout.kt:70)");
            }
            startRestartGroup.startReplaceableGroup(-492369756);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new SubcomposeLayoutState();
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            int i15 = i13 << 3;
            SubcomposeLayout((SubcomposeLayoutState) rememberedValue, modifier, function2, startRestartGroup, (i15 & 112) | 8 | (i15 & 896), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new SubcomposeLayoutKt$SubcomposeLayout$2(modifier, function2, i11, i12));
        }
    }

    @NotNull
    public static final SubcomposeSlotReusePolicy SubcomposeSlotReusePolicy(int i11) {
        return new FixedCountSubcomposeSlotReusePolicy(i11);
    }

    @Composable
    @UiComposable
    public static final void SubcomposeLayout(@NotNull SubcomposeLayoutState subcomposeLayoutState, @Nullable Modifier modifier, @NotNull Function2<? super SubcomposeMeasureScope, ? super Constraints, ? extends MeasureResult> function2, @Nullable Composer composer, int i11, int i12) {
        Intrinsics.checkNotNullParameter(subcomposeLayoutState, "state");
        Intrinsics.checkNotNullParameter(function2, "measurePolicy");
        Composer startRestartGroup = composer.startRestartGroup(-511989831);
        if ((i12 & 2) != 0) {
            modifier = Modifier.Companion;
        }
        Modifier modifier2 = modifier;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-511989831, i11, -1, "androidx.compose.ui.layout.SubcomposeLayout (SubcomposeLayout.kt:103)");
        }
        CompositionContext rememberCompositionContext = ComposablesKt.rememberCompositionContext(startRestartGroup, 0);
        Modifier materialize = ComposedModifierKt.materialize(startRestartGroup, modifier2);
        Density density = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
        LayoutDirection layoutDirection = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
        ViewConfiguration viewConfiguration = (ViewConfiguration) startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
        Function0<LayoutNode> constructor$ui_release = LayoutNode.Companion.getConstructor$ui_release();
        startRestartGroup.startReplaceableGroup(1886828752);
        if (!(startRestartGroup.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        startRestartGroup.startNode();
        if (startRestartGroup.getInserting()) {
            startRestartGroup.createNode(new SubcomposeLayoutKt$SubcomposeLayout$$inlined$ComposeNode$1(constructor$ui_release));
        } else {
            startRestartGroup.useNode();
        }
        Composer r62 = Updater.m2536constructorimpl(startRestartGroup);
        Updater.m2543setimpl(r62, subcomposeLayoutState, subcomposeLayoutState.getSetRoot$ui_release());
        Updater.m2543setimpl(r62, rememberCompositionContext, subcomposeLayoutState.getSetCompositionContext$ui_release());
        Updater.m2543setimpl(r62, function2, subcomposeLayoutState.getSetMeasurePolicy$ui_release());
        ComposeUiNode.Companion companion = ComposeUiNode.Companion;
        Updater.m2543setimpl(r62, density, companion.getSetDensity());
        Updater.m2543setimpl(r62, layoutDirection, companion.getSetLayoutDirection());
        Updater.m2543setimpl(r62, viewConfiguration, companion.getSetViewConfiguration());
        Updater.m2543setimpl(r62, materialize, companion.getSetModifier());
        startRestartGroup.endNode();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.startReplaceableGroup(-607848778);
        if (!startRestartGroup.getSkipping()) {
            EffectsKt.SideEffect(new SubcomposeLayoutKt$SubcomposeLayout$4(subcomposeLayoutState), startRestartGroup, 0);
        }
        startRestartGroup.endReplaceableGroup();
        State rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(subcomposeLayoutState, startRestartGroup, 8);
        Unit unit = Unit.INSTANCE;
        startRestartGroup.startReplaceableGroup(1157296644);
        boolean changed = startRestartGroup.changed((Object) rememberUpdatedState);
        Object rememberedValue = startRestartGroup.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new SubcomposeLayoutKt$SubcomposeLayout$5$1(rememberUpdatedState);
            startRestartGroup.updateRememberedValue(rememberedValue);
        }
        startRestartGroup.endReplaceableGroup();
        EffectsKt.DisposableEffect((Object) unit, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) (Function1) rememberedValue, startRestartGroup, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new SubcomposeLayoutKt$SubcomposeLayout$6(subcomposeLayoutState, modifier2, function2, i11, i12));
        }
    }
}
