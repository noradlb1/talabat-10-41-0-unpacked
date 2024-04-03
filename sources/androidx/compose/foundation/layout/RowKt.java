package androidx.compose.foundation.layout;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
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
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aM\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\u001c\u0010\u000e\u001a\u0018\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00070\u000f¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u0012H\bø\u0001\u0000¢\u0006\u0002\u0010\u0013\u001a\u001d\u0010\u0014\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0001¢\u0006\u0002\u0010\u0015\"\u001c\u0010\u0000\u001a\u00020\u00018\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\u0002\u0007\n\u0005\b20\u0001¨\u0006\u0016"}, d2 = {"DefaultRowMeasurePolicy", "Landroidx/compose/ui/layout/MeasurePolicy;", "getDefaultRowMeasurePolicy$annotations", "()V", "getDefaultRowMeasurePolicy", "()Landroidx/compose/ui/layout/MeasurePolicy;", "Row", "", "modifier", "Landroidx/compose/ui/Modifier;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "verticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/ui/Alignment$Vertical;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "rowMeasurePolicy", "(Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/layout/MeasurePolicy;", "foundation-layout_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class RowKt {
    @NotNull
    private static final MeasurePolicy DefaultRowMeasurePolicy;

    static {
        LayoutOrientation layoutOrientation = LayoutOrientation.Horizontal;
        float r12 = Arrangement.INSTANCE.getStart().m409getSpacingD9Ej5fM();
        CrossAxisAlignment vertical$foundation_layout_release = CrossAxisAlignment.Companion.vertical$foundation_layout_release(Alignment.Companion.getTop());
        DefaultRowMeasurePolicy = RowColumnImplKt.m529rowColumnMeasurePolicyTDGSqEk(layoutOrientation, RowKt$DefaultRowMeasurePolicy$1.INSTANCE, r12, SizeMode.Wrap, vertical$foundation_layout_release);
    }

    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    @Composable
    public static final void Row(@Nullable Modifier modifier, @Nullable Arrangement.Horizontal horizontal, @Nullable Alignment.Vertical vertical, @NotNull Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, @Nullable Composer composer, int i11, int i12) {
        Intrinsics.checkNotNullParameter(function3, "content");
        composer.startReplaceableGroup(693286680);
        if ((i12 & 1) != 0) {
            modifier = Modifier.Companion;
        }
        if ((i12 & 2) != 0) {
            horizontal = Arrangement.INSTANCE.getStart();
        }
        if ((i12 & 4) != 0) {
            vertical = Alignment.Companion.getTop();
        }
        int i13 = i11 >> 3;
        MeasurePolicy rowMeasurePolicy = rowMeasurePolicy(horizontal, vertical, composer, (i13 & 112) | (i13 & 14));
        composer.startReplaceableGroup(-1323940314);
        Density density = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
        LayoutDirection layoutDirection = (LayoutDirection) composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
        ViewConfiguration viewConfiguration = (ViewConfiguration) composer.consume(CompositionLocalsKt.getLocalViewConfiguration());
        ComposeUiNode.Companion companion = ComposeUiNode.Companion;
        Function0<ComposeUiNode> constructor = companion.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(modifier);
        int i14 = ((((i11 << 3) & 112) << 9) & 7168) | 6;
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
        Updater.m2543setimpl(r32, rowMeasurePolicy, companion.getSetMeasurePolicy());
        Updater.m2543setimpl(r32, density, companion.getSetDensity());
        Updater.m2543setimpl(r32, layoutDirection, companion.getSetLayoutDirection());
        Updater.m2543setimpl(r32, viewConfiguration, companion.getSetViewConfiguration());
        composer.enableReusing();
        materializerOf.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(composer)), composer, Integer.valueOf((i14 >> 3) & 112));
        composer.startReplaceableGroup(2058660585);
        composer.startReplaceableGroup(-678309503);
        if (((i14 >> 9) & 14 & 11) != 2 || !composer.getSkipping()) {
            function3.invoke(RowScopeInstance.INSTANCE, composer, Integer.valueOf(((i11 >> 6) & 112) | 6));
        } else {
            composer.skipToGroupEnd();
        }
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        composer.endNode();
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
    }

    @NotNull
    public static final MeasurePolicy getDefaultRowMeasurePolicy() {
        return DefaultRowMeasurePolicy;
    }

    @PublishedApi
    public static /* synthetic */ void getDefaultRowMeasurePolicy$annotations() {
    }

    @NotNull
    @PublishedApi
    @Composable
    public static final MeasurePolicy rowMeasurePolicy(@NotNull Arrangement.Horizontal horizontal, @NotNull Alignment.Vertical vertical, @Nullable Composer composer, int i11) {
        MeasurePolicy measurePolicy;
        Intrinsics.checkNotNullParameter(horizontal, "horizontalArrangement");
        Intrinsics.checkNotNullParameter(vertical, "verticalAlignment");
        composer.startReplaceableGroup(-837807694);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-837807694, i11, -1, "androidx.compose.foundation.layout.rowMeasurePolicy (Row.kt:102)");
        }
        composer.startReplaceableGroup(511388516);
        boolean changed = composer.changed((Object) horizontal) | composer.changed((Object) vertical);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            if (!Intrinsics.areEqual((Object) horizontal, (Object) Arrangement.INSTANCE.getStart()) || !Intrinsics.areEqual((Object) vertical, (Object) Alignment.Companion.getTop())) {
                LayoutOrientation layoutOrientation = LayoutOrientation.Horizontal;
                float r02 = horizontal.m409getSpacingD9Ej5fM();
                CrossAxisAlignment vertical$foundation_layout_release = CrossAxisAlignment.Companion.vertical$foundation_layout_release(vertical);
                measurePolicy = RowColumnImplKt.m529rowColumnMeasurePolicyTDGSqEk(layoutOrientation, new RowKt$rowMeasurePolicy$1$1(horizontal), r02, SizeMode.Wrap, vertical$foundation_layout_release);
            } else {
                measurePolicy = DefaultRowMeasurePolicy;
            }
            rememberedValue = measurePolicy;
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        MeasurePolicy measurePolicy2 = (MeasurePolicy) rememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return measurePolicy2;
    }
}
