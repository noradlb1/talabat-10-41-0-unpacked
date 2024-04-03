package androidx.compose.ui.layout;

import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
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
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aB\u0010\u0000\u001a\u00020\u00012!\u0010\u0002\u001a\u001d\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0005¢\u0006\u0002\b\u0006¢\u0006\u0002\b\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"LookaheadLayout", "", "content", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/LookaheadLayoutScope;", "Landroidx/compose/runtime/Composable;", "Landroidx/compose/ui/UiComposable;", "Lkotlin/ExtensionFunctionType;", "modifier", "Landroidx/compose/ui/Modifier;", "measurePolicy", "Landroidx/compose/ui/layout/MeasurePolicy;", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/layout/MeasurePolicy;Landroidx/compose/runtime/Composer;II)V", "ui_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class LookaheadLayoutKt {
    @ExperimentalComposeUiApi
    @UiComposable
    @Composable
    public static final void LookaheadLayout(@NotNull Function3<? super LookaheadLayoutScope, ? super Composer, ? super Integer, Unit> function3, @Nullable Modifier modifier, @NotNull MeasurePolicy measurePolicy, @Nullable Composer composer, int i11, int i12) {
        int i13;
        int i14;
        int i15;
        int i16;
        Intrinsics.checkNotNullParameter(function3, "content");
        Intrinsics.checkNotNullParameter(measurePolicy, "measurePolicy");
        Composer startRestartGroup = composer.startRestartGroup(1697006219);
        if ((i12 & 1) != 0) {
            i13 = i11 | 6;
        } else if ((i11 & 14) == 0) {
            if (startRestartGroup.changed((Object) function3)) {
                i16 = 4;
            } else {
                i16 = 2;
            }
            i13 = i16 | i11;
        } else {
            i13 = i11;
        }
        int i17 = i12 & 2;
        if (i17 != 0) {
            i13 |= 48;
        } else if ((i11 & 112) == 0) {
            if (startRestartGroup.changed((Object) modifier)) {
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
                ComposerKt.traceEventStart(1697006219, i13, -1, "androidx.compose.ui.layout.LookaheadLayout (LookaheadLayout.kt:67)");
            }
            Modifier materialize = ComposedModifierKt.materialize(startRestartGroup, modifier);
            Density density = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration = (ViewConfiguration) startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            startRestartGroup.startReplaceableGroup(-492369756);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new LookaheadLayoutScopeImpl();
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            LookaheadLayoutScopeImpl lookaheadLayoutScopeImpl = (LookaheadLayoutScopeImpl) rememberedValue;
            Function0<LayoutNode> constructor$ui_release = LayoutNode.Companion.getConstructor$ui_release();
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
            Composer r62 = Updater.m2536constructorimpl(startRestartGroup);
            ComposeUiNode.Companion companion = ComposeUiNode.Companion;
            Updater.m2543setimpl(r62, materialize, companion.getSetModifier());
            Updater.m2543setimpl(r62, measurePolicy, companion.getSetMeasurePolicy());
            Updater.m2543setimpl(r62, density, companion.getSetDensity());
            Updater.m2543setimpl(r62, layoutDirection, companion.getSetLayoutDirection());
            Updater.m2543setimpl(r62, viewConfiguration, companion.getSetViewConfiguration());
            Updater.m2543setimpl(r62, lookaheadLayoutScopeImpl, LookaheadLayoutKt$LookaheadLayout$1$1.INSTANCE);
            Updater.m2540initimpl(r62, LookaheadLayoutKt$LookaheadLayout$1$2.INSTANCE);
            startRestartGroup.enableReusing();
            startRestartGroup.startReplaceableGroup(1130448943);
            function3.invoke(lookaheadLayoutScopeImpl, startRestartGroup, Integer.valueOf(((i13 << 3) & 112) | 8));
            startRestartGroup.endReplaceableGroup();
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
            endRestartGroup.updateScope(new LookaheadLayoutKt$LookaheadLayout$3(function3, modifier2, measurePolicy, i11, i12));
        }
    }
}
