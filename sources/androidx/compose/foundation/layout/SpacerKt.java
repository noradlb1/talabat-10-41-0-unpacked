package androidx.compose.foundation.layout;

import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import com.google.android.exoplayer2.RendererCapabilities;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0015\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Spacer", "", "modifier", "Landroidx/compose/ui/Modifier;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)V", "foundation-layout_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class SpacerKt {
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void Spacer(@NotNull Modifier modifier, @Nullable Composer composer, int i11) {
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        composer.startReplaceableGroup(-72882467);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-72882467, i11, -1, "androidx.compose.foundation.layout.Spacer (Spacer.kt:38)");
        }
        SpacerMeasurePolicy spacerMeasurePolicy = SpacerMeasurePolicy.INSTANCE;
        int i12 = ((i11 << 3) & 112) | RendererCapabilities.MODE_SUPPORT_MASK;
        composer.startReplaceableGroup(-1323940314);
        Density density = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
        LayoutDirection layoutDirection = (LayoutDirection) composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
        ViewConfiguration viewConfiguration = (ViewConfiguration) composer.consume(CompositionLocalsKt.getLocalViewConfiguration());
        ComposeUiNode.Companion companion = ComposeUiNode.Companion;
        Function0<ComposeUiNode> constructor = companion.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(modifier);
        int i13 = ((i12 << 9) & 7168) | 6;
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
        Composer r52 = Updater.m2536constructorimpl(composer);
        Updater.m2543setimpl(r52, spacerMeasurePolicy, companion.getSetMeasurePolicy());
        Updater.m2543setimpl(r52, density, companion.getSetDensity());
        Updater.m2543setimpl(r52, layoutDirection, companion.getSetLayoutDirection());
        Updater.m2543setimpl(r52, viewConfiguration, companion.getSetViewConfiguration());
        composer.enableReusing();
        materializerOf.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(composer)), composer, Integer.valueOf((i13 >> 3) & 112));
        composer.startReplaceableGroup(2058660585);
        composer.startReplaceableGroup(1142320198);
        if (((i13 >> 9) & 14 & 11) == 2 && composer.getSkipping()) {
            composer.skipToGroupEnd();
        }
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        composer.endNode();
        composer.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
    }
}
