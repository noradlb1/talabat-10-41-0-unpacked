package androidx.compose.material3;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
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
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class FloatingActionButtonKt$ExtendedFloatingActionButton$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function3<RowScope, Composer, Integer, Unit> f7062g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f7063h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FloatingActionButtonKt$ExtendedFloatingActionButton$2(Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, int i11) {
        super(2);
        this.f7062g = function3;
        this.f7063h = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        if ((i11 & 11) != 2 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(398457247, i11, -1, "androidx.compose.material3.ExtendedFloatingActionButton.<anonymous> (FloatingActionButton.kt:286)");
            }
            Modifier r13 = PaddingKt.m488paddingVpY3zN4$default(SizeKt.m562sizeInqDBjuR0$default(Modifier.Companion, FloatingActionButtonKt.ExtendedFabMinimumWidth, 0.0f, 0.0f, 0.0f, 14, (Object) null), FloatingActionButtonKt.ExtendedFabTextPadding, 0.0f, 2, (Object) null);
            Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
            Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
            Function3<RowScope, Composer, Integer, Unit> function3 = this.f7062g;
            int i12 = ((this.f7063h >> 12) & 7168) | 438;
            composer.startReplaceableGroup(693286680);
            int i13 = i12 >> 3;
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(center, centerVertically, composer, (i13 & 112) | (i13 & 14));
            composer.startReplaceableGroup(-1323940314);
            Density density = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection = (LayoutDirection) composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration = (ViewConfiguration) composer.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion = ComposeUiNode.Companion;
            Function0<ComposeUiNode> constructor = companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(r13);
            int i14 = ((((i12 << 3) & 112) << 9) & 7168) | 6;
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
            Composer r92 = Updater.m2536constructorimpl(composer);
            Updater.m2543setimpl(r92, rowMeasurePolicy, companion.getSetMeasurePolicy());
            Updater.m2543setimpl(r92, density, companion.getSetDensity());
            Updater.m2543setimpl(r92, layoutDirection, companion.getSetLayoutDirection());
            Updater.m2543setimpl(r92, viewConfiguration, companion.getSetViewConfiguration());
            composer.enableReusing();
            materializerOf.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(composer)), composer, Integer.valueOf((i14 >> 3) & 112));
            composer.startReplaceableGroup(2058660585);
            composer.startReplaceableGroup(-678309503);
            if (((i14 >> 9) & 14 & 11) != 2 || !composer.getSkipping()) {
                function3.invoke(RowScopeInstance.INSTANCE, composer, Integer.valueOf(((i12 >> 6) & 112) | 6));
            } else {
                composer.skipToGroupEnd();
            }
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
