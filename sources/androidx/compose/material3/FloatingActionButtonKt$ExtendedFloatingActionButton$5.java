package androidx.compose.material3;

import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.tokens.FabPrimaryTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
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
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class FloatingActionButtonKt$ExtendedFloatingActionButton$5 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ boolean f7074g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f7075h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f7076i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f7077j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FloatingActionButtonKt$ExtendedFloatingActionButton$5(boolean z11, Function2<? super Composer, ? super Integer, Unit> function2, int i11, Function2<? super Composer, ? super Integer, Unit> function22) {
        super(2);
        this.f7074g = z11;
        this.f7075h = function2;
        this.f7076i = i11;
        this.f7077j = function22;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        float f11;
        float f12;
        float f13;
        Composer composer2 = composer;
        int i12 = i11;
        if ((i12 & 11) != 2 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1172118032, i12, -1, "androidx.compose.material3.ExtendedFloatingActionButton.<anonymous> (FloatingActionButton.kt:355)");
            }
            if (this.f7074g) {
                f11 = FloatingActionButtonKt.ExtendedFabStartIconPadding;
            } else {
                f11 = Dp.m5478constructorimpl((float) 0);
            }
            float f14 = f11;
            if (this.f7074g) {
                f12 = FloatingActionButtonKt.ExtendedFabTextPadding;
            } else {
                f12 = Dp.m5478constructorimpl((float) 0);
            }
            float f15 = f12;
            Modifier.Companion companion = Modifier.Companion;
            if (this.f7074g) {
                f13 = FloatingActionButtonKt.ExtendedFabMinimumWidth;
            } else {
                f13 = FabPrimaryTokens.INSTANCE.m2172getContainerWidthD9Ej5fM();
            }
            Modifier r12 = PaddingKt.m490paddingqDBjuR0$default(SizeKt.m562sizeInqDBjuR0$default(companion, f13, 0.0f, 0.0f, 0.0f, 14, (Object) null), f14, 0.0f, f15, 0.0f, 10, (Object) null);
            Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
            Arrangement.Horizontal start = this.f7074g ? Arrangement.INSTANCE.getStart() : Arrangement.INSTANCE.getCenter();
            Function2<Composer, Integer, Unit> function2 = this.f7075h;
            int i13 = this.f7076i;
            boolean z11 = this.f7074g;
            Function2<Composer, Integer, Unit> function22 = this.f7077j;
            composer2.startReplaceableGroup(693286680);
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(start, centerVertically, composer2, 48);
            composer2.startReplaceableGroup(-1323940314);
            Density density = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion2 = ComposeUiNode.Companion;
            Function0<ComposeUiNode> constructor = companion2.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(r12);
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer2.createNode(constructor);
            } else {
                composer.useNode();
            }
            composer.disableReusing();
            Composer r13 = Updater.m2536constructorimpl(composer);
            Updater.m2543setimpl(r13, rowMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m2543setimpl(r13, density, companion2.getSetDensity());
            Updater.m2543setimpl(r13, layoutDirection, companion2.getSetLayoutDirection());
            Updater.m2543setimpl(r13, viewConfiguration, companion2.getSetViewConfiguration());
            composer.enableReusing();
            materializerOf.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(composer)), composer2, 0);
            composer2.startReplaceableGroup(2058660585);
            composer2.startReplaceableGroup(-678309503);
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            composer2.startReplaceableGroup(1368928116);
            function2.invoke(composer2, Integer.valueOf((i13 >> 3) & 14));
            AnimatedVisibilityKt.AnimatedVisibility((RowScope) rowScopeInstance, z11, (Modifier) null, FloatingActionButtonKt.ExtendedFabExpandAnimation, FloatingActionButtonKt.ExtendedFabCollapseAnimation, (String) null, (Function3<? super AnimatedVisibilityScope, ? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda(composer2, 176242764, true, new FloatingActionButtonKt$ExtendedFloatingActionButton$5$1$1(function22, i13)), composer, 1600518 | ((i13 >> 9) & 112), 18);
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
            composer.endNode();
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
