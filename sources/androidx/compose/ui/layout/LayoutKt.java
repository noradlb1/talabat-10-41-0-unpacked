package androidx.compose.ui.layout;

import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.ExperimentalComposeUiApi;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.UiComposable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import com.google.android.exoplayer2.RendererCapabilities;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a;\u0010\u0000\u001a\u00020\u00012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0004¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\bø\u0001\u0000¢\u0006\u0002\u0010\n\u001a \u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\b¢\u0006\u0002\u0010\u000b\u001a>\u0010\u0000\u001a\u00020\u00012\u001c\u0010\f\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0004¢\u0006\u0002\b\u00050\r2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u000eH\b¢\u0006\u0002\u0010\u000f\u001a7\u0010\u0010\u001a\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0004¢\u0006\u0002\b\u00052\u0006\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\u0010\u0011\u001a;\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0004¢\u0006\u0002\b\u00052\u001c\u0010\f\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0004¢\u0006\u0002\b\u00050\rH\u0001¢\u0006\u0002\u0010\u0013\u001a4\u0010\u0014\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u0016\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u0004¢\u0006\u0002\b\u00182\u0006\u0010\u0006\u001a\u00020\u0007H\u0001ø\u0001\u0001¢\u0006\u0002\u0010\u0019\u0002\u000b\n\u0005\b20\u0001\n\u0002\b\u0019¨\u0006\u001a"}, d2 = {"Layout", "", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "Landroidx/compose/ui/UiComposable;", "modifier", "Landroidx/compose/ui/Modifier;", "measurePolicy", "Landroidx/compose/ui/layout/MeasurePolicy;", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/layout/MeasurePolicy;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/layout/MeasurePolicy;Landroidx/compose/runtime/Composer;II)V", "contents", "", "Landroidx/compose/ui/layout/MultiContentMeasurePolicy;", "(Ljava/util/List;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/layout/MultiContentMeasurePolicy;Landroidx/compose/runtime/Composer;II)V", "MultiMeasureLayout", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/layout/MeasurePolicy;Landroidx/compose/runtime/Composer;II)V", "combineAsVirtualLayouts", "(Ljava/util/List;)Lkotlin/jvm/functions/Function2;", "materializerOf", "Lkotlin/Function1;", "Landroidx/compose/runtime/SkippableUpdater;", "Landroidx/compose/ui/node/ComposeUiNode;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/Modifier;)Lkotlin/jvm/functions/Function3;", "ui_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class LayoutKt {
    @Composable
    @UiComposable
    public static final void Layout(@NotNull Function2<? super Composer, ? super Integer, Unit> function2, @Nullable Modifier modifier, @NotNull MeasurePolicy measurePolicy, @Nullable Composer composer, int i11, int i12) {
        Intrinsics.checkNotNullParameter(function2, "content");
        Intrinsics.checkNotNullParameter(measurePolicy, "measurePolicy");
        composer.startReplaceableGroup(-1323940314);
        if ((i12 & 2) != 0) {
            modifier = Modifier.Companion;
        }
        Density density = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
        LayoutDirection layoutDirection = (LayoutDirection) composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
        ViewConfiguration viewConfiguration = (ViewConfiguration) composer.consume(CompositionLocalsKt.getLocalViewConfiguration());
        ComposeUiNode.Companion companion = ComposeUiNode.Companion;
        Function0<ComposeUiNode> constructor = companion.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = materializerOf(modifier);
        int i13 = ((i11 << 9) & 7168) | 6;
        if (!(composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        composer.startReusableNode();
        if (composer.getInserting()) {
            composer.createNode(constructor);
        } else {
            composer.useNode();
        }
        composer.disableReusing();
        Composer r32 = Updater.m2536constructorimpl(composer);
        Updater.m2543setimpl(r32, measurePolicy, companion.getSetMeasurePolicy());
        Updater.m2543setimpl(r32, density, companion.getSetDensity());
        Updater.m2543setimpl(r32, layoutDirection, companion.getSetLayoutDirection());
        Updater.m2543setimpl(r32, viewConfiguration, companion.getSetViewConfiguration());
        composer.enableReusing();
        materializerOf.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(composer)), composer, Integer.valueOf((i13 >> 3) & 112));
        composer.startReplaceableGroup(2058660585);
        function2.invoke(composer, Integer.valueOf((i13 >> 9) & 14));
        composer.endReplaceableGroup();
        composer.endNode();
        composer.endReplaceableGroup();
    }

    @UiComposable
    @Deprecated(message = "This API is unsafe for UI performance at scale - using it incorrectly will lead to exponential performance issues. This API should be avoided whenever possible.")
    @Composable
    public static final void MultiMeasureLayout(@Nullable Modifier modifier, @NotNull Function2<? super Composer, ? super Integer, Unit> function2, @NotNull MeasurePolicy measurePolicy, @Nullable Composer composer, int i11, int i12) {
        int i13;
        int i14;
        int i15;
        int i16;
        Intrinsics.checkNotNullParameter(function2, "content");
        Intrinsics.checkNotNullParameter(measurePolicy, "measurePolicy");
        Composer startRestartGroup = composer.startRestartGroup(1949933075);
        int i17 = i12 & 1;
        if (i17 != 0) {
            i13 = i11 | 6;
        } else if ((i11 & 14) == 0) {
            if (startRestartGroup.changed((Object) modifier)) {
                i16 = 4;
            } else {
                i16 = 2;
            }
            i13 = i16 | i11;
        } else {
            i13 = i11;
        }
        if ((i12 & 2) != 0) {
            i13 |= 48;
        } else if ((i11 & 112) == 0) {
            if (startRestartGroup.changed((Object) function2)) {
                i15 = 32;
            } else {
                i15 = 16;
            }
            i13 |= i15;
        }
        if ((i12 & 4) != 0) {
            i13 |= RendererCapabilities.MODE_SUPPORT_MASK;
        } else if ((i11 & 896) == 0) {
            if (startRestartGroup.changed((Object) measurePolicy)) {
                i14 = 256;
            } else {
                i14 = 128;
            }
            i13 |= i14;
        }
        if ((i13 & 731) != 146 || !startRestartGroup.getSkipping()) {
            if (i17 != 0) {
                modifier = Modifier.Companion;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1949933075, i13, -1, "androidx.compose.ui.layout.MultiMeasureLayout (Layout.kt:205)");
            }
            Modifier materialize = ComposedModifierKt.materialize(startRestartGroup, modifier);
            Density density = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration = (ViewConfiguration) startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            Function0<LayoutNode> constructor$ui_release = LayoutNode.Companion.getConstructor$ui_release();
            int i18 = ((i13 << 3) & 896) | 6;
            startRestartGroup.startReplaceableGroup(-692256719);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor$ui_release);
            } else {
                startRestartGroup.useNode();
            }
            startRestartGroup.disableReusing();
            Composer r52 = Updater.m2536constructorimpl(startRestartGroup);
            ComposeUiNode.Companion companion = ComposeUiNode.Companion;
            Updater.m2543setimpl(r52, materialize, companion.getSetModifier());
            Updater.m2543setimpl(r52, measurePolicy, companion.getSetMeasurePolicy());
            Updater.m2543setimpl(r52, density, companion.getSetDensity());
            Updater.m2543setimpl(r52, layoutDirection, companion.getSetLayoutDirection());
            Updater.m2543setimpl(r52, viewConfiguration, companion.getSetViewConfiguration());
            Updater.m2540initimpl(r52, LayoutKt$MultiMeasureLayout$1$1.INSTANCE);
            startRestartGroup.enableReusing();
            function2.invoke(startRestartGroup, Integer.valueOf((i18 >> 6) & 14));
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        Modifier modifier2 = modifier;
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new LayoutKt$MultiMeasureLayout$2(modifier2, function2, measurePolicy, i11, i12));
        }
    }

    @NotNull
    @PublishedApi
    public static final Function2<Composer, Integer, Unit> combineAsVirtualLayouts(@NotNull List<? extends Function2<? super Composer, ? super Integer, Unit>> list) {
        Intrinsics.checkNotNullParameter(list, "contents");
        return ComposableLambdaKt.composableLambdaInstance(-1953651383, true, new LayoutKt$combineAsVirtualLayouts$1(list));
    }

    @NotNull
    @PublishedApi
    public static final Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf(@NotNull Modifier modifier) {
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        return ComposableLambdaKt.composableLambdaInstance(-1586257396, true, new LayoutKt$materializerOf$1(modifier));
    }

    @Composable
    @UiComposable
    public static final void Layout(@Nullable Modifier modifier, @NotNull MeasurePolicy measurePolicy, @Nullable Composer composer, int i11, int i12) {
        Intrinsics.checkNotNullParameter(measurePolicy, "measurePolicy");
        composer.startReplaceableGroup(544976794);
        if ((i12 & 1) != 0) {
            modifier = Modifier.Companion;
        }
        Density density = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
        LayoutDirection layoutDirection = (LayoutDirection) composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
        ViewConfiguration viewConfiguration = (ViewConfiguration) composer.consume(CompositionLocalsKt.getLocalViewConfiguration());
        Modifier materialize = ComposedModifierKt.materialize(composer, modifier);
        ComposeUiNode.Companion companion = ComposeUiNode.Companion;
        Function0<ComposeUiNode> constructor = companion.getConstructor();
        composer.startReplaceableGroup(1405779621);
        if (!(composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        composer.startReusableNode();
        if (composer.getInserting()) {
            composer.createNode(new LayoutKt$Layout$$inlined$ReusableComposeNode$1(constructor));
        } else {
            composer.useNode();
        }
        composer.disableReusing();
        Composer r22 = Updater.m2536constructorimpl(composer);
        Updater.m2543setimpl(r22, measurePolicy, companion.getSetMeasurePolicy());
        Updater.m2543setimpl(r22, density, companion.getSetDensity());
        Updater.m2543setimpl(r22, layoutDirection, companion.getSetLayoutDirection());
        Updater.m2543setimpl(r22, viewConfiguration, companion.getSetViewConfiguration());
        Updater.m2543setimpl(r22, materialize, companion.getSetModifier());
        composer.enableReusing();
        composer.endNode();
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
    }

    @ExperimentalComposeUiApi
    @UiComposable
    @Composable
    public static final void Layout(@NotNull List<? extends Function2<? super Composer, ? super Integer, Unit>> list, @Nullable Modifier modifier, @NotNull MultiContentMeasurePolicy multiContentMeasurePolicy, @Nullable Composer composer, int i11, int i12) {
        Intrinsics.checkNotNullParameter(list, "contents");
        Intrinsics.checkNotNullParameter(multiContentMeasurePolicy, "measurePolicy");
        composer.startReplaceableGroup(1399185516);
        if ((i12 & 2) != 0) {
            modifier = Modifier.Companion;
        }
        Function2<Composer, Integer, Unit> combineAsVirtualLayouts = combineAsVirtualLayouts(list);
        composer.startReplaceableGroup(1157296644);
        boolean changed = composer.changed((Object) multiContentMeasurePolicy);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = MultiContentMeasurePolicyKt.createMeasurePolicy(multiContentMeasurePolicy);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        MeasurePolicy measurePolicy = (MeasurePolicy) rememberedValue;
        int i13 = i11 & 112;
        composer.startReplaceableGroup(-1323940314);
        Density density = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
        LayoutDirection layoutDirection = (LayoutDirection) composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
        ViewConfiguration viewConfiguration = (ViewConfiguration) composer.consume(CompositionLocalsKt.getLocalViewConfiguration());
        ComposeUiNode.Companion companion = ComposeUiNode.Companion;
        Function0<ComposeUiNode> constructor = companion.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = materializerOf(modifier);
        int i14 = ((i13 << 9) & 7168) | 6;
        if (!(composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        composer.startReusableNode();
        if (composer.getInserting()) {
            composer.createNode(constructor);
        } else {
            composer.useNode();
        }
        composer.disableReusing();
        Composer r32 = Updater.m2536constructorimpl(composer);
        Updater.m2543setimpl(r32, measurePolicy, companion.getSetMeasurePolicy());
        Updater.m2543setimpl(r32, density, companion.getSetDensity());
        Updater.m2543setimpl(r32, layoutDirection, companion.getSetLayoutDirection());
        Updater.m2543setimpl(r32, viewConfiguration, companion.getSetViewConfiguration());
        composer.enableReusing();
        materializerOf.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(composer)), composer, Integer.valueOf((i14 >> 3) & 112));
        composer.startReplaceableGroup(2058660585);
        combineAsVirtualLayouts.invoke(composer, Integer.valueOf((i14 >> 9) & 14));
        composer.endReplaceableGroup();
        composer.endNode();
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
    }
}
