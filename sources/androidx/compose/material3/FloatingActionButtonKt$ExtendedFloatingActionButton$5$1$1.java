package androidx.compose.material3;

import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
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
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class FloatingActionButtonKt$ExtendedFloatingActionButton$5$1$1 extends Lambda implements Function3<AnimatedVisibilityScope, Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f7078g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f7079h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FloatingActionButtonKt$ExtendedFloatingActionButton$5$1$1(Function2<? super Composer, ? super Integer, Unit> function2, int i11) {
        super(3);
        this.f7078g = function2;
        this.f7079h = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((AnimatedVisibilityScope) obj, (Composer) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public final void invoke(@NotNull AnimatedVisibilityScope animatedVisibilityScope, @Nullable Composer composer, int i11) {
        Intrinsics.checkNotNullParameter(animatedVisibilityScope, "$this$AnimatedVisibility");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(176242764, i11, -1, "androidx.compose.material3.ExtendedFloatingActionButton.<anonymous>.<anonymous>.<anonymous> (FloatingActionButton.kt:374)");
        }
        Modifier.Companion companion = Modifier.Companion;
        Modifier clearAndSetSemantics = SemanticsModifierKt.clearAndSetSemantics(companion, AnonymousClass1.INSTANCE);
        Function2<Composer, Integer, Unit> function2 = this.f7078g;
        int i12 = this.f7079h;
        composer.startReplaceableGroup(693286680);
        MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.Companion.getTop(), composer, 0);
        composer.startReplaceableGroup(-1323940314);
        Density density = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
        LayoutDirection layoutDirection = (LayoutDirection) composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
        ViewConfiguration viewConfiguration = (ViewConfiguration) composer.consume(CompositionLocalsKt.getLocalViewConfiguration());
        ComposeUiNode.Companion companion2 = ComposeUiNode.Companion;
        Function0<ComposeUiNode> constructor = companion2.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(clearAndSetSemantics);
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
        Composer r82 = Updater.m2536constructorimpl(composer);
        Updater.m2543setimpl(r82, rowMeasurePolicy, companion2.getSetMeasurePolicy());
        Updater.m2543setimpl(r82, density, companion2.getSetDensity());
        Updater.m2543setimpl(r82, layoutDirection, companion2.getSetLayoutDirection());
        Updater.m2543setimpl(r82, viewConfiguration, companion2.getSetViewConfiguration());
        composer.enableReusing();
        materializerOf.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(composer)), composer, 0);
        composer.startReplaceableGroup(2058660585);
        composer.startReplaceableGroup(-678309503);
        RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
        composer.startReplaceableGroup(-141102928);
        SpacerKt.Spacer(SizeKt.m563width3ABfNKs(companion, FloatingActionButtonKt.ExtendedFabEndIconPadding), composer, 6);
        function2.invoke(composer, Integer.valueOf(i12 & 14));
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        composer.endNode();
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
